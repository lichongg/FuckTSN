package com.bytedance.adsdk.ugeno.widget.image;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.lottie.model.layer.a;
import com.bytedance.sdk.component.utils.vl;
import java.util.HashSet;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends Drawable {
    private final int ae;
    private final boolean[] av;
    private float az;
    private final RectF cw;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f23819g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f23820i;
    private Shader.TileMode jy;
    private ImageView.ScaleType kt;

    /* renamed from: m, reason: collision with root package name */
    private final int f23822m;
    private ColorStateList mi;
    private final Matrix oq;
    private final RectF qv;

    /* renamed from: r, reason: collision with root package name */
    private final Bitmap f23823r;
    private final RectF tl;
    private final Paint up;
    private Shader.TileMode vl;

    /* renamed from: w, reason: collision with root package name */
    private float f23824w;
    private boolean ws;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f23821j = new RectF();
    private final RectF xt = new RectF();

    public static j j(Bitmap bitmap) {
        if (bitmap != null) {
            return new j(bitmap);
        }
        return null;
    }

    public static Bitmap xt(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            vl.j(th);
            vl.xt("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* renamed from: com.bytedance.adsdk.ugeno.widget.image.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23825j;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f23825j = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23825j[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23825j[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23825j[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23825j[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23825j[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23825j[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static Drawable j(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof j) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && a.a(drawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i6 = 0; i6 < numberOfLayers; i6++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i6), j(layerDrawable.getDrawable(i6)));
                }
                return layerDrawable;
            }
        }
        Bitmap xt = xt(drawable);
        return xt != null ? new j(xt) : drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.ws) {
            BitmapShader bitmapShader = new BitmapShader(this.f23823r, this.vl, this.jy);
            Shader.TileMode tileMode = this.vl;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.jy == tileMode2) {
                bitmapShader.setLocalMatrix(this.oq);
            }
            this.up.setShader(bitmapShader);
            this.ws = false;
        }
        if (this.f23820i) {
            if (this.f23824w <= 0.0f) {
                canvas.drawOval(this.xt, this.up);
                return;
            } else {
                canvas.drawOval(this.xt, this.up);
                canvas.drawOval(this.tl, this.f23819g);
                return;
            }
        }
        if (!j(this.av)) {
            canvas.drawRect(this.xt, this.up);
            if (this.f23824w > 0.0f) {
                canvas.drawRect(this.tl, this.f23819g);
                return;
            }
            return;
        }
        float f6 = this.az;
        if (this.f23824w <= 0.0f) {
            canvas.drawRoundRect(this.xt, f6, f6, this.up);
            j(canvas);
        } else {
            canvas.drawRoundRect(this.xt, f6, f6, this.up);
            canvas.drawRoundRect(this.tl, f6, f6, this.f23819g);
            j(canvas);
            xt(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.up.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.up.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.ae;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f23822m;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mi.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.mi.getColorForState(iArr, 0);
        if (this.f23819g.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f23819g.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.up.setAlpha(i6);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.up.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z5) {
        this.up.setDither(z5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z5) {
        this.up.setFilterBitmap(z5);
        invalidateSelf();
    }

    public j(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.cw = rectF;
        this.tl = new RectF();
        this.oq = new Matrix();
        this.qv = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.vl = tileMode;
        this.jy = tileMode;
        this.ws = true;
        this.az = 0.0f;
        this.av = new boolean[]{true, true, true, true};
        this.f23820i = false;
        this.f23824w = 0.0f;
        this.mi = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.kt = ImageView.ScaleType.FIT_CENTER;
        this.f23823r = bitmap;
        int width = bitmap.getWidth();
        this.f23822m = width;
        int height = bitmap.getHeight();
        this.ae = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.up = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f23819g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.mi.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        paint2.setStrokeWidth(this.f23824w);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f23821j.set(rect);
        j();
    }

    private void xt(Canvas canvas) {
        float f6;
        float f7;
        if (xt(this.av) || this.az == 0.0f) {
            return;
        }
        RectF rectF = this.xt;
        float f8 = rectF.left;
        float f9 = rectF.top;
        float width = rectF.width() + f8;
        float height = f9 + this.xt.height();
        float f10 = this.az;
        float f11 = this.f23824w / 2.0f;
        if (this.av[0]) {
            f6 = f9;
        } else {
            f6 = f9;
            canvas.drawLine(f8 - f11, f9, f8 + f10, f6, this.f23819g);
            canvas.drawLine(f8, f6 - f11, f8, f6 + f10, this.f23819g);
        }
        if (!this.av[1]) {
            float f12 = f6;
            canvas.drawLine((width - f10) - f11, f12, width, f6, this.f23819g);
            canvas.drawLine(width, f12 - f11, width, f12 + f10, this.f23819g);
            width = width;
        }
        if (this.av[2]) {
            f7 = height;
        } else {
            canvas.drawLine((width - f10) - f11, height, width + f11, height, this.f23819g);
            float f13 = width;
            canvas.drawLine(f13, height - f10, width, height, this.f23819g);
            f7 = height;
        }
        if (this.av[3]) {
            return;
        }
        canvas.drawLine(f8 - f11, f7, f8 + f10, f7, this.f23819g);
        canvas.drawLine(f8, f7 - f10, f8, f7, this.f23819g);
    }

    private void j() {
        float width;
        float height;
        int i6 = AnonymousClass1.f23825j[this.kt.ordinal()];
        if (i6 == 1) {
            this.tl.set(this.f23821j);
            RectF rectF = this.tl;
            float f6 = this.f23824w;
            rectF.inset(f6 / 2.0f, f6 / 2.0f);
            this.oq.reset();
            this.oq.setTranslate((int) (((this.tl.width() - this.f23822m) * 0.5f) + 0.5f), (int) (((this.tl.height() - this.ae) * 0.5f) + 0.5f));
        } else if (i6 == 2) {
            this.tl.set(this.f23821j);
            RectF rectF2 = this.tl;
            float f7 = this.f23824w;
            rectF2.inset(f7 / 2.0f, f7 / 2.0f);
            this.oq.reset();
            float f8 = 0.0f;
            if (this.f23822m * this.tl.height() > this.tl.width() * this.ae) {
                width = this.tl.height() / this.ae;
                f8 = (this.tl.width() - (this.f23822m * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = this.tl.width() / this.f23822m;
                height = (this.tl.height() - (this.ae * width)) * 0.5f;
            }
            this.oq.setScale(width, width);
            Matrix matrix = this.oq;
            float f9 = this.f23824w;
            matrix.postTranslate(((int) (f8 + 0.5f)) + (f9 / 2.0f), ((int) (height + 0.5f)) + (f9 / 2.0f));
        } else if (i6 == 3) {
            this.oq.reset();
            float min = (((float) this.f23822m) > this.f23821j.width() || ((float) this.ae) > this.f23821j.height()) ? Math.min(this.f23821j.width() / this.f23822m, this.f23821j.height() / this.ae) : 1.0f;
            float width2 = (int) (((this.f23821j.width() - (this.f23822m * min)) * 0.5f) + 0.5f);
            float height2 = (int) (((this.f23821j.height() - (this.ae * min)) * 0.5f) + 0.5f);
            this.oq.setScale(min, min);
            this.oq.postTranslate(width2, height2);
            this.tl.set(this.cw);
            this.oq.mapRect(this.tl);
            RectF rectF3 = this.tl;
            float f10 = this.f23824w;
            rectF3.inset(f10 / 2.0f, f10 / 2.0f);
            this.oq.setRectToRect(this.cw, this.tl, Matrix.ScaleToFit.FILL);
        } else if (i6 == 5) {
            this.tl.set(this.cw);
            this.oq.setRectToRect(this.cw, this.f23821j, Matrix.ScaleToFit.END);
            this.oq.mapRect(this.tl);
            RectF rectF4 = this.tl;
            float f11 = this.f23824w;
            rectF4.inset(f11 / 2.0f, f11 / 2.0f);
            this.oq.setRectToRect(this.cw, this.tl, Matrix.ScaleToFit.FILL);
        } else if (i6 == 6) {
            this.tl.set(this.cw);
            this.oq.setRectToRect(this.cw, this.f23821j, Matrix.ScaleToFit.START);
            this.oq.mapRect(this.tl);
            RectF rectF5 = this.tl;
            float f12 = this.f23824w;
            rectF5.inset(f12 / 2.0f, f12 / 2.0f);
            this.oq.setRectToRect(this.cw, this.tl, Matrix.ScaleToFit.FILL);
        } else if (i6 != 7) {
            this.tl.set(this.cw);
            this.oq.setRectToRect(this.cw, this.f23821j, Matrix.ScaleToFit.CENTER);
            this.oq.mapRect(this.tl);
            RectF rectF6 = this.tl;
            float f13 = this.f23824w;
            rectF6.inset(f13 / 2.0f, f13 / 2.0f);
            this.oq.setRectToRect(this.cw, this.tl, Matrix.ScaleToFit.FILL);
        } else {
            this.tl.set(this.f23821j);
            RectF rectF7 = this.tl;
            float f14 = this.f23824w;
            rectF7.inset(f14 / 2.0f, f14 / 2.0f);
            this.oq.reset();
            this.oq.setRectToRect(this.cw, this.tl, Matrix.ScaleToFit.FILL);
        }
        this.xt.set(this.tl);
        this.ws = true;
    }

    public j xt(Shader.TileMode tileMode) {
        if (this.jy != tileMode) {
            this.jy = tileMode;
            this.ws = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean xt(boolean[] zArr) {
        for (boolean z5 : zArr) {
            if (z5) {
                return false;
            }
        }
        return true;
    }

    private void j(Canvas canvas) {
        if (xt(this.av) || this.az == 0.0f) {
            return;
        }
        RectF rectF = this.xt;
        float f6 = rectF.left;
        float f7 = rectF.top;
        float width = rectF.width() + f6;
        float height = this.xt.height() + f7;
        float f8 = this.az;
        if (!this.av[0]) {
            this.qv.set(f6, f7, f6 + f8, f7 + f8);
            canvas.drawRect(this.qv, this.up);
        }
        if (!this.av[1]) {
            this.qv.set(width - f8, f7, width, f8);
            canvas.drawRect(this.qv, this.up);
        }
        if (!this.av[2]) {
            this.qv.set(width - f8, height - f8, width, height);
            canvas.drawRect(this.qv, this.up);
        }
        if (this.av[3]) {
            return;
        }
        this.qv.set(f6, height - f8, f8 + f6, height);
        canvas.drawRect(this.qv, this.up);
    }

    public j j(float f6, float f7, float f8, float f9) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f6));
        hashSet.add(Float.valueOf(f7));
        hashSet.add(Float.valueOf(f8));
        hashSet.add(Float.valueOf(f9));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue) && floatValue >= 0.0f) {
                    this.az = floatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(floatValue)));
                }
            } else {
                this.az = 0.0f;
            }
            boolean[] zArr = this.av;
            zArr[0] = f6 > 0.0f;
            zArr[1] = f7 > 0.0f;
            zArr[2] = f8 > 0.0f;
            zArr[3] = f9 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public j j(float f6) {
        this.f23824w = f6;
        this.f23819g.setStrokeWidth(f6);
        return this;
    }

    public j j(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mi = colorStateList;
        this.f23819g.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public j j(boolean z5) {
        this.f23820i = z5;
        return this;
    }

    public j j(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.kt != scaleType) {
            this.kt = scaleType;
            j();
        }
        return this;
    }

    public j j(Shader.TileMode tileMode) {
        if (this.vl != tileMode) {
            this.vl = tileMode;
            this.ws = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean j(boolean[] zArr) {
        for (boolean z5 : zArr) {
            if (z5) {
                return true;
            }
        }
        return false;
    }
}
