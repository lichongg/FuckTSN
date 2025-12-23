package com.bytedance.adsdk.j.j.j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class jy extends tl<com.bytedance.adsdk.j.j.xt.j, com.bytedance.adsdk.j.j.xt.xt> {

    /* renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f23158j = true;

    @Override // com.bytedance.adsdk.j.j.j.tl
    public Bitmap j(Canvas canvas, Paint paint, int i6, Bitmap bitmap, com.bytedance.adsdk.j.j.xt.xt xtVar) {
        Bitmap decodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i6;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.bytedance.adsdk.j.j.xt.j) this.ae).d_();
            try {
                decodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.j.j.xt.j) this.ae).up(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i6;
                options2.inMutable = true;
                decodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.j.j.xt.j) this.ae).up(), null, options2);
            }
        } catch (IOException e6) {
            e = e6;
        }
        try {
            if (!f23158j && decodeStream == null) {
                throw new AssertionError();
            }
            paint.setXfermode(null);
            canvas.drawBitmap(decodeStream, 0.0f, 0.0f, paint);
            return decodeStream;
        } catch (IOException e7) {
            e = e7;
            bitmap2 = decodeStream;
            com.bytedance.sdk.component.utils.vl.j(e);
            return bitmap2;
        }
    }

    public jy(com.bytedance.adsdk.j.j.xt.j jVar) {
        super(jVar);
    }
}
