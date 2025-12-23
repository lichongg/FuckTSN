package com.bytedance.sdk.openadsdk.core.component.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.av;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.k;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.zz;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TsView extends FrameLayout {
    private NativeExpressView ae;
    private FrameLayout az;
    private ImageView cw;

    /* renamed from: g, reason: collision with root package name */
    private TextView f28590g;

    /* renamed from: j, reason: collision with root package name */
    private final Context f28591j;
    private j jy;

    /* renamed from: m, reason: collision with root package name */
    private SplashClickBar f28592m;
    private FrameLayout oq;
    private n qv;

    /* renamed from: r, reason: collision with root package name */
    private FrameLayout f28593r;
    private String tl;
    private TextView up;
    private boolean vl;
    private boolean ws;
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.r xt;

    public interface j {
        void g();

        void j(boolean z5);

        void tl();
    }

    private void cw() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        try {
            View j6 = j(this.f28591j);
            if (j6 == null) {
                return;
            }
            addView(j6);
            SplashClickBar splashClickBar = new SplashClickBar(getContext(), this.qv);
            this.f28592m = splashClickBar;
            addView(splashClickBar);
            FrameLayout xt = xt(this.qv);
            this.oq = xt;
            if (xt != null) {
                addView(xt);
            }
        } catch (Throwable unused) {
        }
    }

    public void r(n nVar, Context context, String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.xt(nVar, context, str);
    }

    private View getCountDownLayout() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.r rVar = this.xt;
        if (rVar == null) {
            return null;
        }
        return rVar.getView();
    }

    private View j(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(2114387588);
        this.f28593r = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f28593r.setId(2114387587);
        this.f28593r.setLayoutParams(layoutParams);
        frameLayout.addView(this.f28593r);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.az = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.cw = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 8388659;
        layoutParams2.topMargin = ed.cw(this.f28591j, 16.0f);
        layoutParams2.leftMargin = ed.cw(this.f28591j, 16.0f);
        this.cw.setId(2114387586);
        this.cw.setLayoutParams(layoutParams2);
        kt.j(this.f28591j, "tt_splash_mute", this.cw);
        ed.j((View) this.cw, 8);
        frameLayout.addView(this.cw);
        this.xt = j(frameLayout, context);
        this.up = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.up.setId(2114387584);
        this.up.setGravity(17);
        layoutParams3.gravity = 8388691;
        layoutParams3.bottomMargin = ed.cw(this.f28591j, 40.0f);
        layoutParams3.leftMargin = ed.cw(this.f28591j, 20.0f);
        kt.j(this.f28591j, "tt_ad_logo_new", this.up);
        this.up.setLayoutParams(layoutParams3);
        frameLayout.addView(this.up);
        return frameLayout;
    }

    private void setComplianceBarLayout(n nVar) {
        k vi;
        if (this.f28590g == null || !cw(nVar) || (vi = nVar.vi()) == null) {
            return;
        }
        int j6 = vi.j();
        int xt = vi.xt();
        int cw = vi.cw();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ed.cw(v.getContext(), 25.0f);
        layoutParams.rightMargin = ed.cw(v.getContext(), 25.0f);
        this.f28590g.setPadding(20, 20, 20, 20);
        this.f28590g.setHighlightColor(0);
        if (j6 == 2) {
            layoutParams.gravity = 80;
            if (r()) {
                layoutParams.bottomMargin = ed.cw(v.getContext(), cw);
            } else {
                layoutParams.bottomMargin = ed.cw(v.getContext(), xt);
            }
        } else {
            layoutParams.gravity = 48;
            if (r()) {
                layoutParams.topMargin = ed.cw(v.getContext(), cw);
            } else {
                layoutParams.topMargin = ed.cw(v.getContext(), xt);
            }
        }
        this.oq.setLayoutParams(layoutParams);
    }

    private boolean up() {
        n nVar = this.qv;
        return nVar != null && nVar.zw() == 2;
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.r getCountDownView() {
        return this.xt;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.az;
    }

    public void setAdlogoViewVisibility(int i6) {
        ed.j((View) this.up, i6);
    }

    public void setAttachedToWindowListener(j jVar) {
        this.jy = jVar;
    }

    public void setComplianceBarVisibility(int i6) {
        if (i6 == 8) {
            ed.j((View) this.f28592m, i6);
        }
        ed.j((View) this.oq, i6);
    }

    public void setCountDownTime(int i6) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.r rVar = this.xt;
        if (rVar != null) {
            rVar.setCountDownTime(i6);
        }
    }

    public void setCountDownViewPosition(n nVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.r rVar = this.xt;
        if (rVar == null || rVar.getView() == null || nVar == null) {
            return;
        }
        View view = this.xt.getView();
        zz pq = nVar.pq();
        if (pq == null) {
            return;
        }
        int j6 = pq.j();
        int cw = ed.cw(this.f28591j, pq.xt());
        int cw2 = ed.cw(this.f28591j, pq.cw());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (j6 == 1) {
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = cw;
            layoutParams.topMargin = cw2;
        } else if (j6 == 3) {
            layoutParams.gravity = 8388691;
            layoutParams.leftMargin = cw;
            layoutParams.bottomMargin = cw2;
        } else if (j6 != 4) {
            layoutParams.gravity = 8388661;
            layoutParams.rightMargin = cw;
            layoutParams.topMargin = cw2;
        } else {
            layoutParams.gravity = 8388693;
            layoutParams.rightMargin = cw;
            layoutParams.bottomMargin = cw2;
        }
        view.setLayoutParams(layoutParams);
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.ae = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.ae.getParent()).removeView(this.ae);
        }
        this.f28593r.addView(this.ae);
        setExpressViewVisibility(0);
    }

    void setExpressViewVisibility(int i6) {
        ed.j((View) this.f28593r, i6);
    }

    public void setIsShowSuccess(boolean z5) {
        this.ws = z5;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        av.j("不允许在Splash广告中注册OnClickListener");
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        av.j("不允许在Splash广告中注册OnTouchListener");
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.r rVar = this.xt;
        if (rVar == null || rVar.getView() == null) {
            return;
        }
        this.xt.getView().setOnClickListener(onClickListener);
    }

    public void setVideoViewVisibility(int i6) {
        ed.j((View) this.cw, i6);
    }

    void setVideoVoiceVisibility(int i6) {
        ed.j((View) this.cw, i6);
    }

    public final void setVoiceViewImageDrawable(Drawable drawable) {
        ImageView imageView = this.cw;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.cw;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public FrameLayout xt(final n nVar) {
        com.bytedance.sdk.openadsdk.core.tj.m et;
        k vi;
        if (nVar == null || nVar.jl() != 4 || (et = nVar.et()) == null || (vi = nVar.vi()) == null || vi.j() == 0) {
            return null;
        }
        String ws = et.ws();
        if (TextUtils.isEmpty(ws)) {
            ws = "暂无";
        }
        String up = et.up();
        if (TextUtils.isEmpty(up)) {
            up = "补充中，可于应用官网查看";
        }
        String ae = et.ae();
        String str = TextUtils.isEmpty(ae) ? "补充中，可于应用官网查看" : ae;
        StringBuilder sb = new StringBuilder();
        sb.append("应用名：");
        sb.append(ws);
        sb.append("；版本号：");
        sb.append(up);
        sb.append("；开发者：");
        sb.append(str);
        String qv = et.qv();
        if (TextUtils.isEmpty(qv)) {
            sb.append("；功能 | 权限 | 隐私  ");
        } else {
            sb.append("；功能 | 权限 | 隐私 | 备案  ");
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        int indexOf = sb.indexOf("功能");
        int i6 = indexOf + 2;
        int indexOf2 = sb.indexOf("隐私");
        int i7 = indexOf2 + 2;
        int indexOf3 = sb.indexOf("权限");
        int i8 = indexOf3 + 2;
        if (!TextUtils.isEmpty(qv)) {
            int indexOf4 = sb.indexOf("备案");
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.1
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    TsView tsView = TsView.this;
                    tsView.j(nVar, tsView.f28591j, TsView.this.tl);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    if (textPaint != null) {
                        textPaint.setColor(-1);
                    }
                }
            }, indexOf4, indexOf4 + 2, 34);
        }
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.xt(nVar, tsView.f28591j, TsView.this.tl);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, indexOf, i6, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.r(nVar, tsView.f28591j, TsView.this.tl);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, indexOf2, i7, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.cw(nVar, tsView.f28591j, TsView.this.tl);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, indexOf3, i8, 34);
        this.f28590g = new TextView(this.f28591j);
        this.oq = new FrameLayout(this.f28591j);
        this.f28590g.setMovementMethod(LinkMovementMethod.getInstance());
        this.f28590g.setTextColor(-1);
        this.f28590g.setTextSize(11.0f);
        this.f28590g.setText(spannableString);
        this.oq.addView(this.f28590g);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#66000000"));
        gradientDrawable.setCornerRadius(ed.cw(this.f28591j, 6.0f));
        this.oq.setBackground(gradientDrawable);
        return this.oq;
    }

    public TsView(Context context, String str, n nVar) {
        super(context);
        this.vl = false;
        this.ws = false;
        this.f28591j = context;
        this.tl = str;
        this.qv = nVar;
        cw();
    }

    private boolean r() {
        return getHeight() < ed.xt(v.getContext())[1];
    }

    public View getDislikeView() {
        return getCountDownLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!up() && !this.ws) {
            ed.j(this, getCountDownLayout());
            ed.j(this, this.cw);
        }
        j jVar = this.jy;
        if (jVar != null) {
            jVar.tl();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.jy;
        if (jVar != null) {
            jVar.g();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (!this.vl) {
            SplashClickBar splashClickBar = this.f28592m;
            if (splashClickBar != null) {
                splashClickBar.setBtnLayout(!r());
            }
            setComplianceBarLayout(this.qv);
            this.vl = true;
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        j jVar = this.jy;
        if (jVar != null) {
            jVar.j(z5);
        }
    }

    final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public void setSkipIconVisibility(int i6) {
        ed.j(getCountDownLayout(), i6);
    }

    public void setSlideUpTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListenerInternal(onTouchListener);
    }

    private boolean cw(n nVar) {
        k vi;
        return (nVar == null || nVar.jl() != 4 || nVar.et() == null || (vi = nVar.vi()) == null || vi.j() == 0) ? false : true;
    }

    public void cw(n nVar, Context context, String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.cw(nVar, context, str);
    }

    public void j(n nVar) {
        SplashClickBar splashClickBar = this.f28592m;
        if (splashClickBar == null) {
            return;
        }
        try {
            splashClickBar.j(nVar);
            ed.j(this.up, nVar);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public void j(int i6, com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        SplashClickBar splashClickBar = this.f28592m;
        if (splashClickBar != null) {
            splashClickBar.j(jVar);
        }
        if (i6 == 1) {
            jVar.j(this);
            setOnClickListenerInternal(jVar);
            setOnTouchListenerInternal(jVar);
        }
    }

    public void xt(n nVar, Context context, String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.j(context, nVar, str);
    }

    public void j(n nVar, Context context, String str) {
        if (nVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.j(nVar, context, str);
    }

    public void xt() {
        TextView textView = this.up;
        if (textView != null) {
            textView.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.r rVar = this.xt;
        if (rVar == null || rVar.getView() == null) {
            return;
        }
        this.xt.j(true);
        this.xt.getView().setVisibility(8);
    }

    public void j() {
        TextView textView = this.up;
        if (textView != null) {
            kt.j(this.f28591j, "tt_ad_logo_backup", textView);
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.r j(FrameLayout frameLayout, Context context) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.r tTCountdownViewForBtn;
        FrameLayout.LayoutParams layoutParams;
        Resources resources = context.getResources();
        n nVar = this.qv;
        zz pq = nVar == null ? null : nVar.pq();
        if ((pq == null ? 1 : pq.r()) == 1) {
            tTCountdownViewForBtn = new TTCountdownViewForCircle(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()));
        } else {
            tTCountdownViewForBtn = new TTCountdownViewForBtn(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 76.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 26.0f, resources.getDisplayMetrics()));
        }
        if (tTCountdownViewForBtn.getView() != null) {
            tTCountdownViewForBtn.getView().setId(2114387585);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = ed.cw(this.f28591j, 16.0f);
            layoutParams.rightMargin = ed.cw(this.f28591j, 16.0f);
            tTCountdownViewForBtn.getView().setLayoutParams(layoutParams);
            frameLayout.addView(tTCountdownViewForBtn.getView());
        }
        return tTCountdownViewForBtn;
    }
}
