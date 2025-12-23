package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.util.g;
import com.yalantis.ucrop.view.TransformImageView;
import f3.c;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CropImageView extends TransformImageView {
    public static final int F = 0;
    public static final int G = 500;
    public static final float H = 10.0f;
    public static final float I = 0.0f;
    public static final float J = 0.0f;
    private float A;
    private float B;
    private int C;
    private int D;
    private long E;

    /* renamed from: t, reason: collision with root package name */
    private final RectF f42818t;

    /* renamed from: u, reason: collision with root package name */
    private final Matrix f42819u;

    /* renamed from: v, reason: collision with root package name */
    private float f42820v;

    /* renamed from: w, reason: collision with root package name */
    private float f42821w;

    /* renamed from: x, reason: collision with root package name */
    private c f42822x;

    /* renamed from: y, reason: collision with root package name */
    private Runnable f42823y;

    /* renamed from: z, reason: collision with root package name */
    private Runnable f42824z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<CropImageView> f42825a;

        /* renamed from: b, reason: collision with root package name */
        private final long f42826b;

        /* renamed from: c, reason: collision with root package name */
        private final long f42827c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        private final float f42828d;

        /* renamed from: e, reason: collision with root package name */
        private final float f42829e;

        /* renamed from: f, reason: collision with root package name */
        private final float f42830f;

        /* renamed from: g, reason: collision with root package name */
        private final float f42831g;

        /* renamed from: h, reason: collision with root package name */
        private final float f42832h;

        /* renamed from: i, reason: collision with root package name */
        private final float f42833i;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f42834j;

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f42825a.get();
            if (cropImageView == null) {
                return;
            }
            float min = Math.min(this.f42826b, System.currentTimeMillis() - this.f42827c);
            float c6 = com.yalantis.ucrop.util.b.c(min, 0.0f, this.f42830f, this.f42826b);
            float c7 = com.yalantis.ucrop.util.b.c(min, 0.0f, this.f42831g, this.f42826b);
            float b6 = com.yalantis.ucrop.util.b.b(min, 0.0f, this.f42833i, this.f42826b);
            if (min < this.f42826b) {
                float[] fArr = cropImageView.f42876b;
                cropImageView.k(c6 - (fArr[0] - this.f42828d), c7 - (fArr[1] - this.f42829e));
                if (!this.f42834j) {
                    cropImageView.C(this.f42832h + b6, cropImageView.f42818t.centerX(), cropImageView.f42818t.centerY());
                }
                if (cropImageView.u()) {
                    return;
                }
                cropImageView.post(this);
            }
        }

        public a(CropImageView cropImageView, long j6, float f6, float f7, float f8, float f9, float f10, float f11, boolean z5) {
            this.f42825a = new WeakReference<>(cropImageView);
            this.f42826b = j6;
            this.f42828d = f6;
            this.f42829e = f7;
            this.f42830f = f8;
            this.f42831g = f9;
            this.f42832h = f10;
            this.f42833i = f11;
            this.f42834j = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<CropImageView> f42835a;

        /* renamed from: b, reason: collision with root package name */
        private final long f42836b;

        /* renamed from: c, reason: collision with root package name */
        private final long f42837c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        private final float f42838d;

        /* renamed from: e, reason: collision with root package name */
        private final float f42839e;

        /* renamed from: f, reason: collision with root package name */
        private final float f42840f;

        /* renamed from: g, reason: collision with root package name */
        private final float f42841g;

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f42835a.get();
            if (cropImageView == null) {
                return;
            }
            float min = Math.min(this.f42836b, System.currentTimeMillis() - this.f42837c);
            float b6 = com.yalantis.ucrop.util.b.b(min, 0.0f, this.f42839e, this.f42836b);
            if (min >= this.f42836b) {
                cropImageView.y();
            } else {
                cropImageView.C(this.f42838d + b6, this.f42840f, this.f42841g);
                cropImageView.post(this);
            }
        }

        public b(CropImageView cropImageView, long j6, float f6, float f7, float f8, float f9) {
            this.f42835a = new WeakReference<>(cropImageView);
            this.f42836b = j6;
            this.f42838d = f6;
            this.f42839e = f7;
            this.f42840f = f8;
            this.f42841g = f9;
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public void y() {
        setImageToWrapCropBounds(true);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private float[] p() {
        this.f42819u.reset();
        this.f42819u.setRotate(-getCurrentAngle());
        float[] fArr = this.f42875a;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] b6 = g.b(this.f42818t);
        this.f42819u.mapPoints(copyOf);
        this.f42819u.mapPoints(b6);
        RectF d6 = g.d(copyOf);
        RectF d7 = g.d(b6);
        float f6 = d6.left - d7.left;
        float f7 = d6.top - d7.top;
        float f8 = d6.right - d7.right;
        float f9 = d6.bottom - d7.bottom;
        if (f6 <= 0.0f) {
            f6 = 0.0f;
        }
        if (f7 <= 0.0f) {
            f7 = 0.0f;
        }
        if (f8 >= 0.0f) {
            f8 = 0.0f;
        }
        if (f9 >= 0.0f) {
            f9 = 0.0f;
        }
        float[] fArr2 = {f6, f7, f8, f9};
        this.f42819u.reset();
        this.f42819u.setRotate(getCurrentAngle());
        this.f42819u.mapPoints(fArr2);
        return fArr2;
    }

    private void r(float f6, float f7) {
        float min = Math.min(Math.min(this.f42818t.width() / f6, this.f42818t.width() / f7), Math.min(this.f42818t.height() / f7, this.f42818t.height() / f6));
        this.B = min;
        this.A = min * this.f42821w;
    }

    private void z(float f6, float f7) {
        float width = this.f42818t.width();
        float height = this.f42818t.height();
        float max = Math.max(this.f42818t.width() / f6, this.f42818t.height() / f7);
        RectF rectF = this.f42818t;
        float f8 = ((width - (f6 * max)) / 2.0f) + rectF.left;
        float f9 = ((height - (f7 * max)) / 2.0f) + rectF.top;
        this.f42878d.reset();
        this.f42878d.postScale(max, max);
        this.f42878d.postTranslate(f8, f9);
        setImageMatrix(this.f42878d);
    }

    public void B(float f6) {
        C(f6, this.f42818t.centerX(), this.f42818t.centerY());
    }

    public void D(float f6) {
        E(f6, this.f42818t.centerX(), this.f42818t.centerY());
    }

    @Nullable
    public c getCropBoundsChangeListener() {
        return this.f42822x;
    }

    public float getMaxScale() {
        return this.A;
    }

    public float getMinScale() {
        return this.B;
    }

    public float getTargetAspectRatio() {
        return this.f42820v;
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void j(float f6, float f7, float f8) {
        if (f6 > 1.0f && getCurrentScale() * f6 <= getMaxScale()) {
            super.j(f6, f7, f8);
        } else {
            if (f6 >= 1.0f || getCurrentScale() * f6 < getMinScale()) {
                return;
            }
            super.j(f6, f7, f8);
        }
    }

    public void s() {
        removeCallbacks(this.f42823y);
        removeCallbacks(this.f42824z);
    }

    public void setCropBoundsChangeListener(@Nullable c cVar) {
        this.f42822x = cVar;
    }

    public void setImageToWrapCropBounds(boolean z5) {
        float f6;
        float max;
        if (!this.f42885k || u()) {
            return;
        }
        float[] fArr = this.f42876b;
        float f7 = fArr[0];
        float f8 = fArr[1];
        float currentScale = getCurrentScale();
        float centerX = this.f42818t.centerX() - f7;
        float centerY = this.f42818t.centerY() - f8;
        this.f42819u.reset();
        this.f42819u.setTranslate(centerX, centerY);
        float[] fArr2 = this.f42875a;
        float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.f42819u.mapPoints(copyOf);
        boolean v5 = v(copyOf);
        if (v5) {
            float[] p5 = p();
            float f9 = -(p5[0] + p5[2]);
            centerY = -(p5[1] + p5[3]);
            f6 = f9;
            max = 0.0f;
        } else {
            RectF rectF = new RectF(this.f42818t);
            this.f42819u.reset();
            this.f42819u.setRotate(getCurrentAngle());
            this.f42819u.mapRect(rectF);
            float[] c6 = g.c(this.f42875a);
            f6 = centerX;
            max = (Math.max(rectF.width() / c6[0], rectF.height() / c6[1]) * currentScale) - currentScale;
        }
        float f10 = centerY;
        if (z5) {
            a aVar = new a(this, this.E, f7, f8, f6, f10, currentScale, max, v5);
            this.f42823y = aVar;
            post(aVar);
        } else {
            k(f6, f10);
            if (v5) {
                return;
            }
            C(currentScale + max, this.f42818t.centerX(), this.f42818t.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j6) {
        if (j6 <= 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative value.");
        }
        this.E = j6;
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i6) {
        this.C = i6;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i6) {
        this.D = i6;
    }

    public void setMaxScaleMultiplier(float f6) {
        this.f42821w = f6;
    }

    protected boolean u() {
        return v(this.f42875a);
    }

    protected boolean v(float[] fArr) {
        this.f42819u.reset();
        this.f42819u.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.f42819u.mapPoints(copyOf);
        float[] b6 = g.b(this.f42818t);
        this.f42819u.mapPoints(b6);
        return g.d(copyOf).contains(g.d(b6));
    }

    public void w(float f6) {
        i(f6, this.f42818t.centerX(), this.f42818t.centerY());
    }

    protected void x(@NonNull TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (abs == 0.0f || abs2 == 0.0f) {
            this.f42820v = 0.0f;
        } else {
            this.f42820v = abs / abs2;
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f42818t = new RectF();
        this.f42819u = new Matrix();
        this.f42821w = 10.0f;
        this.f42824z = null;
        this.C = 0;
        this.D = 0;
        this.E = 500L;
    }

    private void q() {
        if (getDrawable() == null) {
            return;
        }
        r(r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
    }

    protected void A(float f6, float f7, float f8, long j6) {
        if (f6 > getMaxScale()) {
            f6 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        b bVar = new b(this, j6, currentScale, f6 - currentScale, f7, f8);
        this.f42824z = bVar;
        post(bVar);
    }

    public void C(float f6, float f7, float f8) {
        if (f6 <= getMaxScale()) {
            j(f6 / getCurrentScale(), f7, f8);
        }
    }

    public void E(float f6, float f7, float f8) {
        if (f6 >= getMinScale()) {
            j(f6 / getCurrentScale(), f7, f8);
        }
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    protected void h() {
        super.h();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            if (this.f42820v == 0.0f) {
                this.f42820v = intrinsicWidth / intrinsicHeight;
            }
            int i6 = this.f42879e;
            float f6 = this.f42820v;
            int i7 = (int) (i6 / f6);
            int i8 = this.f42880f;
            if (i7 > i8) {
                this.f42818t.set((i6 - ((int) (i8 * f6))) / 2, 0.0f, r4 + r2, i8);
            } else {
                this.f42818t.set(0.0f, (i8 - i7) / 2, i6, i7 + r6);
            }
            r(intrinsicWidth, intrinsicHeight);
            z(intrinsicWidth, intrinsicHeight);
            c cVar = this.f42822x;
            if (cVar != null) {
                cVar.a(this.f42820v);
            }
            TransformImageView.b bVar = this.f42881g;
            if (bVar != null) {
                bVar.c(getCurrentScale());
                this.f42881g.d(getCurrentAngle());
            }
        }
    }

    public void setCropRect(RectF rectF) {
        this.f42820v = rectF.width() / rectF.height();
        this.f42818t.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        q();
        y();
    }

    public void setTargetAspectRatio(float f6) {
        if (getDrawable() == null) {
            this.f42820v = f6;
            return;
        }
        if (f6 == 0.0f) {
            this.f42820v = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.f42820v = f6;
        }
        c cVar = this.f42822x;
        if (cVar != null) {
            cVar.a(this.f42820v);
        }
    }

    public void t(@NonNull Bitmap.CompressFormat compressFormat, int i6, @Nullable f3.a aVar) {
        s();
        setImageToWrapCropBounds(false);
        new com.yalantis.ucrop.task.a(getContext(), getViewBitmap(), new com.yalantis.ucrop.model.c(this.f42818t, g.d(this.f42875a), getCurrentScale(), getCurrentAngle()), new com.yalantis.ucrop.model.a(this.C, this.D, compressFormat, i6, getImageInputPath(), getImageOutputPath(), getExifInfo()), aVar).execute(new Void[0]);
    }
}
