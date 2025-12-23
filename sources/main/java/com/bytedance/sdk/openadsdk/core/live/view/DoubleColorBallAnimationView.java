package com.bytedance.sdk.openadsdk.core.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.core.rn.ed;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DoubleColorBallAnimationView extends View {
    private int ae;
    private long av;
    private boolean az;
    private final float cw;

    /* renamed from: g, reason: collision with root package name */
    private Paint f29489g;

    /* renamed from: i, reason: collision with root package name */
    private int f29490i;

    /* renamed from: j, reason: collision with root package name */
    private final float f29491j;
    private boolean jy;
    private float kt;

    /* renamed from: m, reason: collision with root package name */
    private final long f29492m;
    private float mi;
    private final PorterDuffXfermode oq;
    private float qv;

    /* renamed from: r, reason: collision with root package name */
    private final float f29493r;
    private float tj;
    private int tl;
    private final float up;
    private boolean vl;

    /* renamed from: w, reason: collision with root package name */
    private float f29494w;
    private int ws;
    private final float xt;

    public DoubleColorBallAnimationView(Context context) {
        this(context, null);
    }

    private float j(float f6) {
        return ((double) f6) < 0.5d ? 2.0f * f6 * f6 : ((f6 * 2.0f) * (2.0f - f6)) - 1.0f;
    }

    public void cw() {
        this.az = false;
        this.jy = false;
        this.qv = 0.0f;
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Paint r() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private void up() {
        this.av = -1L;
        if (this.f29490i <= 0) {
            setProgressBarInfo(ed.cw(getContext(), 60.0f));
        }
        int min = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.f29490i > min && min > 0) {
            setProgressBarInfo(min);
        }
        if (this.f29489g == null) {
            this.f29489g = r();
        }
        this.jy = true;
    }

    public boolean j() {
        return this.az;
    }

    public void setCycleBias(int i6) {
        this.ws = i6;
    }

    public void setProgress(float f6) {
        if (!this.jy) {
            up();
        }
        this.qv = f6;
        this.az = false;
        this.vl = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int i6) {
        if (i6 > 0) {
            this.f29490i = i6;
            this.f29494w = i6 / 2.0f;
            float f6 = (i6 >> 1) * 0.32f;
            this.mi = f6;
            float f7 = (i6 * 0.16f) + f6;
            this.kt = f7;
            this.tj = i6 - (f7 * 2.0f);
        }
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f29491j = 0.25f;
        this.xt = 0.375f;
        this.cw = 0.16f;
        this.f29493r = 0.32f;
        this.up = 400.0f;
        this.f29492m = 17L;
        this.ae = -119723;
        this.tl = -14289682;
        this.oq = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.vl = false;
        this.jy = false;
        this.ws = 0;
        this.az = false;
        this.av = -1L;
        this.f29490i = -1;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f6;
        int i6;
        int i7;
        super.onDraw(canvas);
        if ((!j() && this.vl) || !this.jy) {
            return;
        }
        boolean z5 = false;
        if (this.vl) {
            long nanoTime = System.nanoTime() / C.MICROS_PER_SECOND;
            if (this.av < 0) {
                this.av = nanoTime;
            }
            float f7 = (nanoTime - this.av) / 400.0f;
            this.qv = f7;
            int i8 = (int) f7;
            if (((this.ws + i8) & 1) == 1) {
                z5 = true;
            }
            this.qv = f7 - i8;
        }
        try {
            float j6 = j(this.qv);
            int i9 = this.f29490i;
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, i9, i9, this.f29489g, 31);
            float f8 = (this.tj * j6) + this.kt;
            if (j6 < 0.5d) {
                f6 = j6 * 2.0f;
            } else {
                f6 = 2.0f - (j6 * 2.0f);
            }
            float f9 = this.mi;
            float f10 = (0.25f * f6 * f9) + f9;
            Paint paint = this.f29489g;
            if (z5) {
                i6 = this.tl;
            } else {
                i6 = this.ae;
            }
            paint.setColor(i6);
            canvas.drawCircle(f8, this.f29494w, f10, this.f29489g);
            float f11 = this.f29490i - f8;
            float f12 = this.mi;
            float f13 = f12 - ((f6 * 0.375f) * f12);
            Paint paint2 = this.f29489g;
            if (z5) {
                i7 = this.ae;
            } else {
                i7 = this.tl;
            }
            paint2.setColor(i7);
            this.f29489g.setXfermode(this.oq);
            canvas.drawCircle(f11, this.f29494w, f13, this.f29489g);
            this.f29489g.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        } catch (Throwable unused) {
        }
        postInvalidateDelayed(17L);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int min = Math.min(View.MeasureSpec.getSize(i6), View.MeasureSpec.getSize(i7));
        if (this.f29490i > min && min > 0) {
            setProgressBarInfo(min);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        if (i6 == 0) {
            xt();
        } else {
            cw();
        }
    }

    public void xt() {
        up();
        this.az = true;
        this.vl = true;
        postInvalidate();
    }
}
