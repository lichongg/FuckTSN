package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.ff;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SplashClickBarBtn extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f28563a;
    private RelativeLayout ae;
    private final AnimatorSet av;
    private Paint az;
    private float ch;
    private TextView cw;

    /* renamed from: f, reason: collision with root package name */
    private f f28564f;

    /* renamed from: g, reason: collision with root package name */
    private SplashClickBarArrow f28565g;
    private n gq;

    /* renamed from: h, reason: collision with root package name */
    private int f28566h;

    /* renamed from: i, reason: collision with root package name */
    private final ValueAnimator f28567i;

    /* renamed from: j, reason: collision with root package name */
    private GradientDrawable f28568j;
    private Path jy;
    private int[] kt;

    /* renamed from: l, reason: collision with root package name */
    private JSONObject f28569l;
    private int la;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f28570m;
    private LinearGradient mi;
    private SlideUpView oq;

    /* renamed from: p, reason: collision with root package name */
    private JSONObject f28571p;
    private RockView qv;

    /* renamed from: r, reason: collision with root package name */
    private TextView f28572r;

    /* renamed from: s, reason: collision with root package name */
    private float f28573s;
    private boolean tj;
    private LinearLayout tl;
    private LottieAnimationView up;

    /* renamed from: v, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.xt.j f28574v;
    private AnimatorSet vl;

    /* renamed from: w, reason: collision with root package name */
    private final ValueAnimator f28575w;
    private Rect ws;

    /* renamed from: x, reason: collision with root package name */
    private float f28576x;
    private ff xt;

    private void ae() {
        int parseColor = Color.parseColor("#57000000");
        int parseColor2 = Color.parseColor(this.xt.oq());
        this.f28568j.setColor(parseColor);
        this.f28575w.setIntValues(parseColor, parseColor2);
        this.f28575w.setEvaluator(new ArgbEvaluator());
        this.f28575w.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.f28568j.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                SplashClickBarBtn splashClickBarBtn = SplashClickBarBtn.this;
                splashClickBarBtn.setBackgroundDrawable(splashClickBarBtn.f28568j);
            }
        });
        this.f28575w.setDuration(300L);
        this.f28575w.setStartDelay(800L);
        this.f28575w.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.av.playTogether(this.f28575w);
    }

    private void g() {
        if (this.xt != null && isShown()) {
            if (this.xt.g() == 4 || this.xt.g() == 7) {
                if (this.f28564f == null) {
                    if (this.xt.g() == 4) {
                        this.f28564f = new f(v.getContext(), 1, oq.i().up());
                    } else if (this.xt.g() == 7) {
                        this.f28564f = new f(v.getContext(), 2, oq.i().up());
                    }
                }
                this.f28564f.j(this.f28576x);
                this.f28564f.cw(this.ch);
                this.f28564f.xt(this.f28573s);
                this.f28564f.j(this.f28563a);
                this.f28564f.cw(this.f28569l);
                this.f28564f.xt(this.f28571p);
                this.f28564f.up(this.f28566h);
                this.f28564f.m(this.la);
                this.f28564f.j(new f.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.3
                    @Override // com.bytedance.sdk.component.utils.f.j
                    public void j(int i6) {
                        if (SplashClickBarBtn.this.f28574v == null || !SplashClickBarBtn.this.isShown()) {
                            return;
                        }
                        if (SplashClickBarBtn.this.f28564f.j() && SplashClickBarBtn.this.gq != null) {
                            com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.f29897r = true;
                        }
                        if (i6 == 1) {
                            if (SplashClickBarBtn.this.xt.g() == 4) {
                                ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) SplashClickBarBtn.this.f28574v.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j();
                                SplashClickBarBtn.this.f28574v.onClick(SplashClickBarBtn.this);
                                return;
                            }
                            return;
                        }
                        if (i6 == 2 && SplashClickBarBtn.this.xt.g() == 7) {
                            ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) SplashClickBarBtn.this.f28574v.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).xt();
                            SplashClickBarBtn.this.f28574v.onClick(SplashClickBarBtn.this);
                        }
                    }
                });
                f fVar = this.f28564f;
                n nVar = this.gq;
                fVar.j(nVar != null ? nVar.ae() : 0);
            }
        }
    }

    private void m() {
        if (this.tj) {
            return;
        }
        this.tj = true;
        int g6 = this.xt.g();
        if (g6 == 1 || g6 == 2) {
            tl();
            ae();
        }
    }

    private void oq() {
        ff ffVar = this.xt;
        if (ffVar == null || ffVar.g() != 5) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.oq == null) {
                    return;
                }
                SplashClickBarBtn.this.oq.j();
                final AnimatorSet slideUpAnimatorSet = SplashClickBarBtn.this.oq.getSlideUpAnimatorSet();
                if (slideUpAnimatorSet == null) {
                    return;
                }
                slideUpAnimatorSet.start();
                slideUpAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SplashClickBarBtn.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                slideUpAnimatorSet.start();
                            }
                        }, 200L);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }, 500L);
    }

    private void tl() {
        Point point = new Point(0, 0);
        Point point2 = new Point(getMeasuredWidth(), 0);
        Point point3 = new Point(getMeasuredWidth(), getMeasuredHeight());
        Point point4 = new Point(0, getMeasuredHeight());
        this.jy.moveTo(point.x, point.y);
        this.jy.lineTo(point2.x, point2.y);
        this.jy.lineTo(point3.x, point3.y);
        this.jy.lineTo(point4.x, point4.y);
        this.jy.close();
        this.ws = getBackground().getBounds();
        final int cw = ed.cw(getContext(), 36.0f);
        final int cw2 = ed.cw(getContext(), 45.0f);
        this.f28567i.setIntValues(point.x - cw, point2.x + cw);
        this.f28567i.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.f28567i.setDuration(1600L);
        this.f28567i.setStartDelay(1300L);
        this.f28567i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.mi = new LinearGradient(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0.0f, r10 + cw, cw2, SplashClickBarBtn.this.kt, (float[]) null, Shader.TileMode.CLAMP);
                SplashClickBarBtn.this.postInvalidate();
            }
        });
        this.av.playTogether(this.f28567i);
    }

    private void up() {
        View j6 = j(getContext());
        if (j6 == null) {
            return;
        }
        addView(j6);
        SplashClickBarArrow splashClickBarArrow = new SplashClickBarArrow(getContext());
        this.f28565g = splashClickBarArrow;
        this.f28570m.addView(splashClickBarArrow);
        this.f28565g.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f28565g.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.ae.getId());
        this.f28568j = j(Color.parseColor("#57000000"));
        this.jy = new Path();
        Paint paint = new Paint();
        this.az = paint;
        paint.isAntiAlias();
    }

    public void cw() {
        RockView rockView;
        if (this.xt.g() == 4 && (rockView = this.qv) != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rockView, "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.start();
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashClickBarBtn.this.qv != null) {
                        SplashClickBarBtn.this.qv.j();
                    }
                }
            }, 500L);
        }
    }

    public Animator getAnimator() {
        return this.av;
    }

    public f getShakeUtils() {
        return this.f28564f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        f fVar = this.f28564f;
        if (fVar != null) {
            if (z5) {
                n nVar = this.gq;
                fVar.j(nVar != null ? nVar.ae() : 0);
            } else {
                n nVar2 = this.gq;
                fVar.xt(nVar2 != null ? nVar2.ae() : 0);
            }
        }
    }

    public void r() {
        if (this.xt.g() != 7) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SplashClickBarBtn.this.up != null) {
                        SplashClickBarBtn.this.up.j();
                    }
                } catch (Exception unused) {
                }
            }
        }, 500L);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        this.f28568j.setColor(i6);
        setBackgroundDrawable(this.f28568j);
    }

    public void setCalculationMethod(int i6) {
        this.f28566h = i6;
    }

    public void setCalculationTwistMethod(int i6) {
        this.la = i6;
    }

    public void setDeepShakeValue(float f6) {
        this.ch = f6;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.f28569l = jSONObject;
    }

    public void setShakeValue(float f6) {
        this.f28576x = f6;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.f28563a = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.f28571p = jSONObject;
    }

    public void setWriggleValue(float f6) {
        this.f28573s = f6;
    }

    public void xt() {
        if (this.xt.g() != 3) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        scaleAnimation.setInterpolator(new PathInterpolator(0.41f, 0.23f, 0.25f, 1.0f));
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        startAnimation(scaleAnimation);
    }

    public SplashClickBarBtn(Context context, n nVar) {
        super(context);
        this.xt = new ff();
        this.av = new AnimatorSet();
        this.f28567i = new ValueAnimator();
        this.f28575w = new ValueAnimator();
        this.kt = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#47FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.tj = false;
        this.f28576x = 13.0f;
        this.f28573s = 50.0f;
        this.gq = nVar;
        up();
    }

    private View j(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setClipChildren(false);
        layoutParams.addRule(14);
        relativeLayout.setId(2114387583);
        relativeLayout.setLayoutParams(layoutParams);
        this.f28570m = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.f28570m.setId(2114387582);
        this.f28570m.setClipChildren(false);
        layoutParams2.addRule(13);
        this.f28570m.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f28570m);
        this.qv = new RockView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.qv.setId(2114387581);
        layoutParams3.addRule(14);
        this.qv.setLayoutParams(layoutParams3);
        ed.j((View) this.qv, 8);
        this.f28570m.addView(this.qv);
        this.ae = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        this.ae.setId(2114387580);
        this.ae.setClipChildren(false);
        layoutParams4.addRule(13);
        this.ae.setGravity(17);
        this.ae.setLayoutParams(layoutParams4);
        this.f28570m.addView(this.ae);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(2, 2114387579);
        layoutParams5.addRule(14);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams5);
        this.ae.addView(linearLayout);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.up = lottieAnimationView;
        lottieAnimationView.setId(2114387578);
        this.up.setAnimation("lottie_json/twist_multi_angle.json");
        this.up.setImageAssetsFolder("images/");
        this.up.j(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()));
        layoutParams6.bottomMargin = ed.cw(context, 4.0f);
        layoutParams6.gravity = 17;
        this.up.setLayoutParams(layoutParams6);
        linearLayout.addView(this.up);
        ed.j((View) this.up, 8);
        SlideUpView slideUpView = new SlideUpView(context);
        this.oq = slideUpView;
        slideUpView.setId(2114387575);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, resources.getDisplayMetrics()));
        layoutParams7.topMargin = ed.cw(context, -140.0f);
        this.oq.setLayoutParams(layoutParams7);
        linearLayout.addView(this.oq);
        ed.j((View) this.oq, 8);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.tl = linearLayout2;
        linearLayout2.setId(2114387579);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(12);
        this.tl.setGravity(17);
        this.tl.setOrientation(1);
        this.tl.setLayoutParams(layoutParams8);
        this.ae.addView(this.tl);
        TextView textView = new TextView(context);
        this.f28572r = textView;
        textView.setId(2114387574);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.f28572r.setSingleLine();
        this.f28572r.setText(kt.j(context, "tt_splash_click_bar_text"));
        this.f28572r.setTextColor(-1);
        this.f28572r.setTextSize(20.0f);
        this.f28572r.setTypeface(Typeface.defaultFromStyle(1));
        this.f28572r.setLayoutParams(layoutParams9);
        this.tl.addView(this.f28572r);
        ed.j((View) this.f28572r, 8);
        TextView textView2 = new TextView(context);
        this.cw = textView2;
        textView2.setId(2114387573);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        this.cw.setShadowLayer(2.0f, 0.0f, 0.5f, kt.oq(context, "tt_splash_click_bar_text_shadow"));
        this.cw.setSingleLine();
        this.cw.setText(kt.j(context, "tt_splash_click_bar_text"));
        this.cw.setTextColor(-1);
        this.cw.setTextSize(15.0f);
        this.cw.setTypeface(Typeface.defaultFromStyle(1));
        this.cw.setLayoutParams(layoutParams10);
        this.tl.addView(this.cw);
        ed.j((View) this.cw, 8);
        return relativeLayout;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.4
            @Override // java.lang.Runnable
            public void run() {
                SplashClickBarBtn.this.j();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        int i6;
        super.onDetachedFromWindow();
        f fVar = this.f28564f;
        if (fVar != null) {
            n nVar = this.gq;
            if (nVar != null) {
                i6 = nVar.ae();
            } else {
                i6 = 0;
            }
            fVar.xt(i6);
        }
        AnimatorSet animatorSet = this.vl;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.av;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        SlideUpView slideUpView = this.oq;
        if (slideUpView != null) {
            slideUpView.xt();
        }
        LottieAnimationView lottieAnimationView = this.up;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        m();
        super.onDraw(canvas);
        if (this.f28567i.isRunning()) {
            this.az.setShader(this.mi);
            canvas.drawRoundRect(new RectF(this.ws), ed.cw(getContext(), 50.0f), ed.cw(getContext(), 50.0f), this.az);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
    }

    private GradientDrawable j(int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i6);
        gradientDrawable.setSize(32, 12);
        gradientDrawable.setStroke(1, -2130706433);
        gradientDrawable.setCornerRadius(ed.cw(v.getContext(), 50.0f));
        return gradientDrawable;
    }

    public void j(ff ffVar) {
        if (ffVar == null) {
            return;
        }
        this.xt = ffVar;
        if (ffVar.g() == 4) {
            this.qv.j(this.xt);
            return;
        }
        TextView textView = this.cw;
        if (textView != null) {
            textView.setVisibility(0);
            this.cw.setText(TextUtils.isEmpty(this.xt.xt()) ? "点击跳转至详情页或第三方应用" : this.xt.xt());
            if (this.xt.vl() != null) {
                this.cw.setTextSize(2, this.xt.vl().xt());
            }
        }
        if (this.f28572r != null && this.xt.jy() != null) {
            this.f28572r.setTextSize(2, this.xt.jy().xt());
        }
        this.f28568j.setColor(Color.parseColor("#57000000"));
        this.f28565g.j(this.xt.g());
        int g6 = this.xt.g();
        if (g6 == 1 || g6 == 2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.vl = animatorSet;
            animatorSet.playTogether(getAnimator(), this.f28565g.getAnimator());
        } else if (g6 == 3) {
            TextView textView2 = this.f28572r;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.f28572r.setText(this.xt.qv());
            }
            TextView textView3 = this.cw;
            if (textView3 != null) {
                textView3.setTypeface(Typeface.defaultFromStyle(0));
            }
            this.f28568j = j(Color.parseColor(this.xt.oq()));
        } else {
            if (g6 == 4) {
                return;
            }
            if (g6 == 5) {
                SlideUpView slideUpView = this.oq;
                if (slideUpView != null) {
                    slideUpView.setVisibility(0);
                }
                LinearLayout linearLayout = this.tl;
                if (linearLayout != null) {
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.width = -1;
                    this.tl.setLayoutParams(layoutParams);
                }
                TextView textView4 = this.f28572r;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.f28572r.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    if (TextUtils.isEmpty(this.xt.qv())) {
                        this.f28572r.setText("向上滑动");
                    } else {
                        this.f28572r.setText(this.xt.qv());
                    }
                }
                TextView textView5 = this.cw;
                if (textView5 != null) {
                    textView5.setText(TextUtils.isEmpty(this.xt.xt()) ? "滑动查看详情" : this.xt.xt());
                    this.cw.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    return;
                }
                return;
            }
            if (g6 != 7) {
                this.f28568j.setStroke(0, ViewCompat.MEASURED_STATE_MASK);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.vl = animatorSet2;
                animatorSet2.playTogether(getAnimator(), this.f28565g.getAnimator());
                try {
                    setBackgroundColor(Color.parseColor(this.xt.oq()));
                } catch (Throwable unused) {
                    setBackgroundColor(Color.parseColor("#008DEA"));
                }
            } else {
                TextView textView6 = this.f28572r;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    this.f28572r.setText(this.xt.qv());
                    this.f28572r.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                TextView textView7 = this.cw;
                if (textView7 != null) {
                    textView7.setTypeface(Typeface.defaultFromStyle(0));
                    this.cw.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                LottieAnimationView lottieAnimationView = this.up;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    return;
                }
                return;
            }
        }
        setBackgroundDrawable(this.f28568j);
    }

    public void j() {
        AnimatorSet animatorSet = this.vl;
        if (animatorSet != null) {
            animatorSet.start();
        }
        xt();
        cw();
        r();
        oq();
    }

    public void j(com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        this.f28574v = jVar;
        if (this.xt.g() == 4 || this.xt.g() == 7 || this.xt.g() == 5 || jVar == null) {
            return;
        }
        jVar.j(this);
        setOnClickListener(jVar);
        setOnTouchListener(jVar);
        setId(2114387639);
    }
}
