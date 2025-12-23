package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.cw;
import com.bytedance.adsdk.ugeno.cw.up;
import com.bytedance.adsdk.ugeno.j.ae;
import com.bytedance.adsdk.ugeno.j.tl;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class RoundImageView extends ImageView implements up, ae {

    /* renamed from: j, reason: collision with root package name */
    public static final Shader.TileMode f23812j = Shader.TileMode.CLAMP;

    /* renamed from: r, reason: collision with root package name */
    private static final ImageView.ScaleType[] f23813r = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    static final /* synthetic */ boolean xt = true;
    private ColorStateList ae;
    private int av;
    private int az;
    private float cw;

    /* renamed from: g, reason: collision with root package name */
    private ColorFilter f23814g;

    /* renamed from: i, reason: collision with root package name */
    private ImageView.ScaleType f23815i;
    private boolean jy;
    private cw kt;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f23816m;
    private Shader.TileMode mi;
    private boolean oq;
    private Drawable qv;
    private tl tj;
    private float tl;
    private final float[] up;
    private boolean vl;

    /* renamed from: w, reason: collision with root package name */
    private Shader.TileMode f23817w;
    private boolean ws;

    private Drawable j() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i6 = this.az;
        if (i6 != 0) {
            try {
                drawable = resources.getDrawable(i6);
            } catch (Exception e6) {
                vl.xt("RoundedImageView", "Unable to find resource: " + this.az, e6);
                this.az = 0;
            }
        }
        return j.j(drawable);
    }

    public void setBorderColor(int i6) {
        setBorderColor(ColorStateList.valueOf(i6));
    }

    public void setBorderWidth(int i6) {
        setBorderWidth(getResources().getDimension(i6));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.az = 0;
        this.qv = j.j(bitmap);
        cw();
        super.setImageDrawable(this.qv);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.az = 0;
        this.qv = j.j(drawable);
        cw();
        super.setImageDrawable(drawable);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.widget.image.RoundImageView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23818j;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f23818j = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23818j[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23818j[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23818j[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23818j[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23818j[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23818j[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void cw() {
        j(this.qv, this.f23815i);
    }

    private void r() {
        Drawable drawable = this.qv;
        if (drawable == null || !this.oq) {
            return;
        }
        Drawable mutate = drawable.mutate();
        this.qv = mutate;
        if (this.vl) {
            mutate.setColorFilter(this.f23814g);
        }
    }

    public int getBorderColor() {
        return this.ae.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.ae;
    }

    public float getBorderRadius() {
        return this.tj.j();
    }

    public float getBorderWidth() {
        return this.tl;
    }

    public float getMaxCornerRadius() {
        float f6 = 0.0f;
        for (float f7 : this.up) {
            f6 = Math.max(f7, f6);
        }
        return f6;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.up, com.bytedance.adsdk.ugeno.j.ae
    public float getRipple() {
        return this.cw;
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getRubIn() {
        return this.tj.getRubIn();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f23815i;
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getShine() {
        return this.tj.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getStretch() {
        return this.tj.getStretch();
    }

    public Shader.TileMode getTileModeX() {
        return this.f23817w;
    }

    public Shader.TileMode getTileModeY() {
        return this.mi;
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        cw cwVar = this.kt;
        if (cwVar != null) {
            cwVar.j(i6, i7, i8, i9);
        }
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i6, int i7) {
        cw cwVar = this.kt;
        if (cwVar == null) {
            super.onMeasure(i6, i7);
        } else {
            int[] j6 = cwVar.j(i6, i7);
            super.onMeasure(j6[0], j6[1]);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        ColorDrawable colorDrawable = new ColorDrawable(i6);
        this.f23816m = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f23816m = drawable;
        j(true);
        super.setBackgroundDrawable(this.f23816m);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        if (this.av != i6) {
            this.av = i6;
            Drawable xt2 = xt();
            this.f23816m = xt2;
            setBackgroundDrawable(xt2);
        }
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.ae.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.ae = colorStateList;
        cw();
        j(false);
        if (this.tl > 0.0f) {
            invalidate();
        }
    }

    public void setBorderRadius(float f6) {
        tl tlVar = this.tj;
        if (tlVar != null) {
            tlVar.j(f6);
        }
    }

    public void setBorderWidth(float f6) {
        if (this.tl == f6) {
            return;
        }
        this.tl = f6;
        cw();
        j(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f23814g != colorFilter) {
            this.f23814g = colorFilter;
            this.vl = true;
            this.oq = true;
            r();
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i6) {
        if (this.az != i6) {
            this.az = i6;
            this.qv = j();
            cw();
            super.setImageDrawable(this.qv);
        }
    }

    public void setOval(boolean z5) {
        this.jy = z5;
        cw();
        j(false);
        invalidate();
    }

    public void setRipple(float f6) {
        this.cw = f6;
        tl tlVar = this.tj;
        if (tlVar != null) {
            tlVar.xt(f6);
        }
        postInvalidate();
    }

    public void setRubIn(float f6) {
        tl tlVar = this.tj;
        if (tlVar != null) {
            tlVar.up(f6);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!xt && scaleType == null) {
            throw new AssertionError();
        }
        if (this.f23815i != scaleType) {
            this.f23815i = scaleType;
            int i6 = AnonymousClass1.f23818j[scaleType.ordinal()];
            if (i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            cw();
            j(false);
            invalidate();
        }
    }

    public void setShine(float f6) {
        tl tlVar = this.tj;
        if (tlVar != null) {
            tlVar.cw(f6);
        }
    }

    public void setStretch(float f6) {
        tl tlVar = this.tj;
        if (tlVar != null) {
            tlVar.r(f6);
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.f23817w == tileMode) {
            return;
        }
        this.f23817w = tileMode;
        cw();
        j(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.mi == tileMode) {
            return;
        }
        this.mi = tileMode;
        cw();
        j(false);
        invalidate();
    }

    public RoundImageView(Context context) {
        super(context);
        this.up = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.ae = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.tl = 0.0f;
        this.f23814g = null;
        this.oq = false;
        this.vl = false;
        this.jy = false;
        this.ws = false;
        Shader.TileMode tileMode = f23812j;
        this.f23817w = tileMode;
        this.mi = tileMode;
        this.tj = new tl(this);
    }

    private Drawable xt() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i6 = this.av;
        if (i6 != 0) {
            try {
                drawable = resources.getDrawable(i6);
            } catch (Exception e6) {
                vl.xt("RoundedImageView", "Unable to find resource: " + this.av, e6);
                this.av = 0;
            }
        }
        return j.j(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.kt;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.kt;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cw cwVar = this.kt;
        if (cwVar != null) {
            cwVar.j(canvas, this);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        cw cwVar = this.kt;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i8);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.kt;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setCornerRadius(float f6) {
        j(f6, f6, f6, f6);
    }

    public void setCornerRadiusDimen(int i6) {
        float dimension = getResources().getDimension(i6);
        j(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private void j(boolean z5) {
        if (this.ws) {
            if (z5) {
                this.f23816m = j.j(this.f23816m);
            }
            j(this.f23816m, ImageView.ScaleType.FIT_XY);
        }
    }

    private void j(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof j) {
            j jVar = (j) drawable;
            jVar.j(scaleType).j(this.tl).j(this.ae).j(this.jy).j(this.f23817w).xt(this.mi);
            float[] fArr = this.up;
            if (fArr != null) {
                jVar.j(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            r();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i6 = 0; i6 < numberOfLayers; i6++) {
                j(layerDrawable.getDrawable(i6), scaleType);
            }
        }
    }

    public void j(float f6, float f7, float f8, float f9) {
        float[] fArr = this.up;
        if (fArr[0] == f6 && fArr[1] == f7 && fArr[2] == f9 && fArr[3] == f8) {
            return;
        }
        fArr[0] = f6;
        fArr[1] = f7;
        fArr[3] = f8;
        fArr[2] = f9;
        cw();
        j(false);
        invalidate();
    }

    public void j(cw cwVar) {
        this.kt = cwVar;
    }
}
