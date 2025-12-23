package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class CycleCountDownView extends View {

    /* renamed from: a, reason: collision with root package name */
    private boolean f30554a;
    protected boolean ae;
    private float av;
    private Paint az;

    /* renamed from: c, reason: collision with root package name */
    private String f30555c;
    private Bitmap ch;
    protected int cw;
    private String ed;

    /* renamed from: f, reason: collision with root package name */
    private boolean f30556f;

    /* renamed from: g, reason: collision with root package name */
    protected float f30557g;
    private final Rect gq;
    private String gx;

    /* renamed from: h, reason: collision with root package name */
    private final Rect f30558h;

    /* renamed from: i, reason: collision with root package name */
    private AnimatorSet f30559i;

    /* renamed from: j, reason: collision with root package name */
    protected int f30560j;
    private Paint jy;
    private ValueAnimator kt;

    /* renamed from: l, reason: collision with root package name */
    private final RectF f30561l;
    private final Rect la;

    /* renamed from: m, reason: collision with root package name */
    protected int f30562m;
    private ValueAnimator mi;
    protected int oq;

    /* renamed from: p, reason: collision with root package name */
    private final Rect f30563p;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    protected float f30564r;
    private final Rect rn;

    /* renamed from: s, reason: collision with root package name */
    private boolean f30565s;
    private boolean tj;
    protected float tl;
    private String uf;
    protected float up;

    /* renamed from: v, reason: collision with root package name */
    private Bitmap f30566v;
    private Paint vl;

    /* renamed from: w, reason: collision with root package name */
    private ValueAnimator f30567w;
    private float wq;
    private Paint ws;

    /* renamed from: x, reason: collision with root package name */
    private Bitmap f30568x;
    protected int xt;

    private void cw() {
        this.f30566v = kt.r(getContext(), "tt_reward_chest_gift2");
        this.f30568x = kt.r(getContext(), "tt_reward_chest_gift_open2");
        this.ch = j(getContext(), "tt_reward_chest_btn_bg");
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.mi;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mi = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.av, this.wq);
        this.mi = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.mi.setDuration(1000L);
        this.mi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleCountDownView.this.av = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleCountDownView.this.postInvalidate();
            }
        });
        return this.mi;
    }

    private int r() {
        return (int) ((((this.f30564r / 2.0f) + this.up) * 2.0f) + j(4.0f));
    }

    private void xt() {
        Paint paint = new Paint(1);
        this.vl = paint;
        paint.setColor(this.f30560j);
        this.vl.setStrokeWidth(this.f30564r);
        this.vl.setAntiAlias(true);
        this.vl.setStrokeCap(Paint.Cap.ROUND);
        this.vl.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.jy = paint2;
        paint2.setColor(this.xt);
        this.jy.setAntiAlias(true);
        this.jy.setStrokeWidth(this.f30564r);
        this.jy.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.ws = paint3;
        paint3.setColor(this.cw);
        this.ws.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint(1);
        this.az = paint4;
        paint4.setFilterBitmap(true);
        this.az.setDither(true);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.f30559i;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.f30559i = null;
            }
            ValueAnimator valueAnimator = this.kt;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.kt = null;
            }
            ValueAnimator valueAnimator2 = this.f30567w;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.f30567w = null;
            }
            ValueAnimator valueAnimator3 = this.mi;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.mi = null;
            }
            this.av = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    public void setBoxFinish(Bitmap bitmap) {
        this.f30568x = bitmap;
        this.f30554a = true;
        Rect rect = this.f30558h;
        rect.left = 0;
        rect.top = 0;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.f30558h;
        Bitmap bitmap2 = this.f30568x;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
    }

    public void setBoxImage(Bitmap bitmap) {
        this.f30566v = bitmap;
        this.f30565s = true;
        Rect rect = this.f30563p;
        rect.left = 0;
        rect.top = 0;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.f30563p;
        Bitmap bitmap2 = this.f30566v;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
    }

    public void setCanSkip(boolean z5) {
        this.qv = z5;
    }

    public CycleCountDownView(Context context) {
        super(context);
        this.f30560j = Color.parseColor("#FFDA7B");
        this.xt = Color.parseColor("#4D000000");
        this.cw = Color.parseColor("#ffffff");
        this.f30562m = 270;
        this.ae = false;
        this.tl = 5.0f;
        this.f30557g = 0.0f;
        this.oq = 0;
        this.qv = false;
        this.av = 0.0f;
        this.tj = false;
        this.f30556f = false;
        this.f30565s = false;
        this.f30554a = false;
        this.f30561l = new RectF();
        this.f30563p = new Rect();
        this.f30558h = new Rect();
        this.la = new Rect();
        this.gq = new Rect();
        this.rn = new Rect();
        this.wq = 1.0f;
        this.f30564r = j(4.0f);
        this.up = j(34.0f);
        this.f30562m %= 360;
        xt();
        cw();
        setBackgroundColor(-16711681);
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        j(canvas);
        cw(canvas);
        xt(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        super.onMeasure(i6, i7);
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i7);
        if (mode != 1073741824) {
            size = r();
        }
        if (mode2 != 1073741824) {
            size2 = r();
        }
        j(size, size2);
        setMeasuredDimension(size, size2);
        RectF rectF = this.f30561l;
        float f6 = this.up;
        rectF.left = -f6;
        rectF.right = f6;
        rectF.top = -f6;
        rectF.bottom = f6;
        Rect rect = this.f30563p;
        rect.left = 0;
        rect.top = 0;
        Bitmap bitmap = this.f30566v;
        if (bitmap != null) {
            i8 = bitmap.getWidth();
        } else {
            i8 = 0;
        }
        rect.right = i8;
        Rect rect2 = this.f30563p;
        Bitmap bitmap2 = this.f30566v;
        if (bitmap2 != null) {
            i9 = bitmap2.getHeight();
        } else {
            i9 = 0;
        }
        rect2.bottom = i9;
        Rect rect3 = this.f30558h;
        rect3.left = 0;
        rect3.top = 0;
        Bitmap bitmap3 = this.f30568x;
        if (bitmap3 != null) {
            i10 = bitmap3.getWidth();
        } else {
            i10 = 0;
        }
        rect3.right = i10;
        Rect rect4 = this.f30558h;
        Bitmap bitmap4 = this.f30568x;
        if (bitmap4 != null) {
            i11 = bitmap4.getHeight();
        } else {
            i11 = 0;
        }
        rect4.bottom = i11;
        int minLine = getMinLine();
        Rect rect5 = this.la;
        int i12 = -minLine;
        int i13 = i12 / 2;
        rect5.left = i13;
        rect5.top = i13;
        int i14 = minLine / 2;
        rect5.right = i14;
        rect5.bottom = i14;
        Rect rect6 = this.gq;
        rect6.left = 0;
        rect6.top = 0;
        rect6.right = this.ch.getWidth();
        this.gq.bottom = this.ch.getHeight();
        Rect rect7 = this.rn;
        rect7.left = i12 / 3;
        rect7.top = minLine / 8;
        int i15 = minLine / 3;
        rect7.right = i15;
        rect7.bottom = i15;
        this.ws.setTextSize(((i15 - r0) / 2) - xt(2.0f));
    }

    private void cw(Canvas canvas) {
        float f6;
        canvas.save();
        float f7 = this.av * 360.0f;
        if (this.ae) {
            f6 = this.f30562m - f7;
        } else {
            f6 = this.f30562m;
        }
        float f8 = f6;
        canvas.drawCircle(0.0f, 0.0f, this.up, this.jy);
        canvas.drawArc(this.f30561l, f8, f7, false, this.vl);
        canvas.restore();
    }

    private void j(int i6, int i7) {
        this.up = (Math.min(i6, i7) / 2.0f) - this.f30564r;
    }

    private void j(Canvas canvas) {
        Bitmap bitmap;
        canvas.save();
        boolean z5 = false;
        if (this.oq <= 0 && (bitmap = this.f30568x) != null) {
            boolean z6 = this.f30565s;
            if (!(z6 && this.f30554a) && (z6 || this.f30554a)) {
                bitmap = this.f30566v;
            } else {
                z5 = true;
            }
        } else {
            bitmap = this.f30566v;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, z5 ? this.f30558h : this.f30563p, this.la, this.az);
        }
        canvas.restore();
    }

    private float j(float f6) {
        return TypedValue.applyDimension(1, f6, getResources().getDisplayMetrics());
    }

    public void j() {
        AnimatorSet animatorSet = this.f30559i;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f30559i.cancel();
            this.f30559i = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f30559i = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.f30559i.setInterpolator(new LinearInterpolator());
        this.f30559i.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleCountDownView.this.tj = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleCountDownView.this.tj) {
                    CycleCountDownView.this.tj = false;
                } else {
                    CycleCountDownView.this.f30556f = true;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.f30559i.start();
    }

    private void xt(Canvas canvas) {
        String str;
        canvas.save();
        canvas.drawBitmap(this.ch, this.gq, this.rn, this.az);
        Paint.FontMetrics fontMetrics = this.ws.getFontMetrics();
        float f6 = (fontMetrics.bottom - fontMetrics.top) / 2.0f;
        if (TextUtils.isEmpty(this.gx)) {
            str = this.uf + this.oq + this.ed;
        } else if (this.oq <= 0) {
            str = this.gx;
        } else {
            str = this.uf + this.oq + this.ed;
        }
        if (this.qv) {
            str = str + "｜" + this.f30555c;
        }
        canvas.drawText(str, 0.0f, ((getMinLine() / 3.0f) - (getMinLine() / 9.0f)) + (f6 / 2.0f), this.ws);
        canvas.restore();
    }

    public void j(int i6, int i7, int i8) {
        float f6 = i6;
        this.tl = f6;
        float f7 = i7;
        this.f30557g = f7;
        this.oq = i8;
        this.wq = f7 / f6;
        j();
    }

    private Bitmap j(Context context, String str) {
        Drawable cw = kt.cw(context, str);
        Bitmap createBitmap = Bitmap.createBitmap(cw.getIntrinsicWidth(), cw.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        cw.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        cw.draw(canvas);
        return createBitmap;
    }

    private float xt(float f6) {
        return TypedValue.applyDimension(2, f6, getResources().getDisplayMetrics());
    }

    public void j(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.uf = str;
        this.ed = TextUtils.isEmpty(str2) ? "" : str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "跳过";
        }
        this.f30555c = str3;
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        }
        this.gx = str4;
    }
}
