package com.huawei.hms.ml.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import com.stub.StubApp;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class NV21ToBitmapConverter1 {
    private Context applicationContext;
    private Allocation in;
    private Allocation out;
    private RenderScript renderScript;
    private Type.Builder rgbaType;
    private ScriptIntrinsicYuvToRGB yuvToRgbIntrinsic;
    private Type.Builder yuvType;
    private int width = -1;
    private int height = -1;
    private int length = -1;

    public Bitmap convert(byte[] bArr, int i6, int i7, int i8, int i9, int i10, boolean z5, boolean z6, boolean z7) {
        recreateIfNeed(bArr, i6, i7, i10);
        Bitmap createBitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(convertYUVtoRGB(bArr, i6, i7), getTransformationMatrix(i6, i7, i8, i9, i10, z5, z6, z7), null);
        return createBitmap;
    }

    private void recreateIfNeed(byte[] bArr, int i6, int i7, int i8) {
        if (this.width == i6 && this.height == i7 && this.length == bArr.length) {
            return;
        }
        this.width = i6;
        this.height = i7;
        this.length = bArr.length;
        this.yuvType = null;
        this.rgbaType = null;
    }

    public Bitmap convertYUVtoRGB(byte[] bArr, int i6, int i7) {
        if (this.yuvType == null) {
            RenderScript renderScript = this.renderScript;
            Type.Builder x5 = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
            this.yuvType = x5;
            this.in = Allocation.createTyped(this.renderScript, x5.create(), 1);
            RenderScript renderScript2 = this.renderScript;
            Type.Builder y5 = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i6).setY(i7);
            this.rgbaType = y5;
            this.out = Allocation.createTyped(this.renderScript, y5.create(), 1);
        }
        this.in.copyFrom(bArr);
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.yuvToRgbIntrinsic;
        if (scriptIntrinsicYuvToRGB != null) {
            scriptIntrinsicYuvToRGB.setInput(this.in);
            this.yuvToRgbIntrinsic.forEach(this.out);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        this.out.copyTo(createBitmap);
        return createBitmap;
    }

    public Context getApplicationContext() {
        Context context = this.applicationContext;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("initial must be called first");
    }

    public Matrix getTransformationMatrix(int i6, int i7, int i8, int i9, int i10, boolean z5, boolean z6, boolean z7) {
        Matrix matrix = new Matrix();
        if (i10 != 0) {
            if (i10 % 90 != 0) {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Rotation of %d", Integer.valueOf(i10)));
            }
            matrix.postTranslate((-i6) / 2.0f, (-i7) / 2.0f);
            matrix.postRotate(i10);
        }
        boolean z8 = (Math.abs(i10) + 90) % 180 == 0;
        int i11 = z8 ? i7 : i6;
        if (!z8) {
            i6 = i7;
        }
        int i12 = z5 ? -1 : 1;
        int i13 = z6 ? -1 : 1;
        if (i11 != i8 || i6 != i9) {
            float f6 = (i12 * i8) / i11;
            float f7 = (i13 * i9) / i6;
            if (z7) {
                float max = Math.max(Math.abs(f6), Math.abs(f7));
                matrix.postScale(max, max);
            } else {
                matrix.postScale(f6, f7);
            }
        }
        if (i10 != 0) {
            float f8 = i8 / 2.0f;
            float f9 = i9 / 2.0f;
            matrix.postTranslate(f8, f9);
            matrix.postScale(i12, i13, f8, f9);
        }
        return matrix;
    }

    public NV21ToBitmapConverter1(Context context) {
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext == null) {
                this.applicationContext = context;
            } else {
                this.applicationContext = origApplicationContext;
            }
            RenderScript create = RenderScript.create(this.applicationContext);
            this.renderScript = create;
            if (create != null) {
                this.yuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    public Bitmap convert(byte[] bArr, int i6, int i7, int i8, int i9, int i10) {
        return convert(bArr, i6, i7, i8, i9, i10, false, false, false);
    }
}
