package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl extends Drawable {
    private int ae;
    private int[] cw;

    /* renamed from: g, reason: collision with root package name */
    private int f31260g;

    /* renamed from: j, reason: collision with root package name */
    private int f31261j;

    /* renamed from: m, reason: collision with root package name */
    private int f31262m;
    private RectF oq;
    private Paint qv;

    /* renamed from: r, reason: collision with root package name */
    private float[] f31263r;
    private int tl;
    private LinearGradient up;
    private int xt;

    public static class j {
        private int[] cw;

        /* renamed from: g, reason: collision with root package name */
        private int f31264g;

        /* renamed from: r, reason: collision with root package name */
        private float[] f31267r;
        private int tl;
        private LinearGradient up;

        /* renamed from: j, reason: collision with root package name */
        private int f31265j = kt.oq(v.getContext(), "tt_ssxinmian8");
        private int xt = kt.oq(v.getContext(), "tt_ssxinxian3");

        /* renamed from: m, reason: collision with root package name */
        private int f31266m = 10;
        private int ae = 16;

        public j j(int i6) {
            this.f31265j = i6;
            return this;
        }

        public j cw(int i6) {
            this.f31266m = i6;
            return this;
        }

        public j j(int[] iArr) {
            this.cw = iArr;
            return this;
        }

        public j r(int i6) {
            this.tl = i6;
            return this;
        }

        public j up(int i6) {
            this.f31264g = i6;
            return this;
        }

        public j xt(int i6) {
            this.xt = i6;
            return this;
        }

        public j() {
            this.tl = 0;
            this.f31264g = 0;
            this.tl = 0;
            this.f31264g = 0;
        }

        public vl j() {
            return new vl(this.f31265j, this.cw, this.f31267r, this.xt, this.up, this.f31266m, this.ae, this.tl, this.f31264g);
        }
    }

    private void j() {
        int[] iArr;
        Paint paint = new Paint();
        this.qv = paint;
        paint.setAntiAlias(true);
        this.qv.setShadowLayer(this.ae, this.tl, this.f31260g, this.xt);
        if (this.oq == null || (iArr = this.cw) == null || iArr.length <= 1) {
            this.qv.setColor(this.f31261j);
            return;
        }
        float[] fArr = this.f31263r;
        boolean z5 = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
        Paint paint2 = this.qv;
        LinearGradient linearGradient = this.up;
        if (linearGradient == null) {
            RectF rectF = this.oq;
            linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.cw, z5 ? this.f31263r : null, Shader.TileMode.CLAMP);
        }
        paint2.setShader(linearGradient);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.oq == null) {
            Rect bounds = getBounds();
            int i6 = bounds.left;
            int i7 = this.ae;
            int i8 = this.tl;
            int i9 = bounds.top + i7;
            int i10 = this.f31260g;
            this.oq = new RectF((i6 + i7) - i8, i9 - i10, (bounds.right - i7) - i8, (bounds.bottom - i7) - i10);
        }
        if (this.qv == null) {
            j();
        }
        RectF rectF = this.oq;
        int i11 = this.f31262m;
        canvas.drawRoundRect(rectF, i11, i11, this.qv);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        Paint paint = this.qv;
        if (paint != null) {
            paint.setAlpha(i6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.qv;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public vl(int i6, int[] iArr, float[] fArr, int i7, LinearGradient linearGradient, int i8, int i9, int i10, int i11) {
        this.f31261j = i6;
        this.cw = iArr;
        this.f31263r = fArr;
        this.xt = i7;
        this.up = linearGradient;
        this.f31262m = i8;
        this.ae = i9;
        this.tl = i10;
        this.f31260g = i11;
    }

    public static void j(View view, j jVar) {
        if (view == null || jVar == null) {
            return;
        }
        view.setLayerType(1, null);
        view.setBackground(jVar.j());
    }
}
