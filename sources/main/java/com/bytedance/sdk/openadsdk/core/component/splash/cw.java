package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.splash.ae;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.xq;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
class cw extends xt implements View.OnClickListener {
    private ImageView ae;
    private View av;
    private TextView az;

    /* renamed from: f, reason: collision with root package name */
    private f f28629f;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f28630g;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f28631i;
    private TextView jy;
    private RelativeLayout kt;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f28632m;
    private TextView mi;
    private RelativeLayout oq;
    private ImageView qv;
    private TextView tj;
    private View tl;
    protected com.bytedance.sdk.openadsdk.i.cw.xt.ae up;

    /* renamed from: v, reason: collision with root package name */
    private View.OnClickListener f28633v;
    private TextView vl;

    /* renamed from: w, reason: collision with root package name */
    private TextView f28634w;
    private TextView ws;

    private View j(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.f28632m = relativeLayout2;
        relativeLayout2.setId(2114387568);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), -2);
        layoutParams2.addRule(13);
        this.f28632m.setClipChildren(false);
        this.f28632m.setVisibility(4);
        this.f28632m.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f28632m);
        ImageView imageView = new ImageView(context);
        this.tl = imageView;
        imageView.setId(2114387567);
        this.tl.setLayoutParams(new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 370.0f, resources.getDisplayMetrics())));
        this.f28632m.addView(this.tl);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(2114387566);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 130.0f, resources.getDisplayMetrics())));
        this.f28632m.addView(relativeLayout3);
        TextView textView = new TextView(context);
        this.ws = textView;
        textView.setId(2114387565);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = ed.cw(context, 8.0f);
        layoutParams3.bottomMargin = ed.cw(context, 10.0f);
        layoutParams3.rightMargin = ed.cw(context, 4.0f);
        this.ws.setLayoutParams(layoutParams3);
        kt.j(this.f28793j, "tt_splash_card_feedback_bg", this.ws);
        this.ws.setGravity(17);
        this.ws.setText(kt.j(this.f28793j, "tt_feedback"));
        this.ws.setTextColor(Color.parseColor("#99FFFFFF"));
        this.ws.setTextSize(2, 12.0f);
        relativeLayout3.addView(this.ws);
        RelativeLayout relativeLayout4 = new RelativeLayout(context);
        this.oq = relativeLayout4;
        relativeLayout4.setId(2114387564);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 240.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(3, 2114387566);
        this.oq.setLayoutParams(layoutParams4);
        this.oq.setBackgroundColor(Color.parseColor("#D9FFFFFF"));
        this.f28632m.addView(this.oq);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f28630g = frameLayout;
        frameLayout.setId(2114387563);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        layoutParams5.topMargin = ed.cw(context, -42.0f);
        this.f28630g.setElevation(ed.cw(context, 3.0f));
        this.f28630g.setLayoutParams(layoutParams5);
        this.oq.addView(this.f28630g);
        ImageView imageView2 = new ImageView(context);
        this.qv = imageView2;
        imageView2.setId(2114387562);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(ed.cw(context, 2.0f), ed.cw(context, 2.0f), ed.cw(context, 2.0f), ed.cw(context, 2.0f));
        this.qv.setLayoutParams(layoutParams6);
        this.f28630g.addView(this.qv);
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int cw = ed.cw(context, 6.0f);
        gradientDrawable.setCornerRadius(cw);
        gradientDrawable.setStroke(cw / 3, -1);
        view.setBackground(gradientDrawable);
        this.f28630g.addView(view);
        TextView textView2 = new TextView(context);
        this.vl = textView2;
        textView2.setId(2114387561);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, 2114387563);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = ed.cw(context, 16.0f);
        this.vl.setLayoutParams(layoutParams7);
        TextView textView3 = this.vl;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView3.setEllipsize(truncateAt);
        this.vl.setMaxLines(1);
        this.vl.setTextColor(Color.parseColor("#161823"));
        this.vl.setTextSize(2, 20.0f);
        this.oq.addView(this.vl);
        TextView textView4 = new TextView(context);
        this.jy = textView4;
        textView4.setId(2114387560);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(3, 2114387561);
        layoutParams8.addRule(14);
        layoutParams8.setMarginStart(ed.cw(context, 42.0f));
        layoutParams8.setMarginEnd(ed.cw(context, 42.0f));
        layoutParams8.topMargin = ed.cw(context, 8.0f);
        this.jy.setLayoutParams(layoutParams8);
        this.jy.setEllipsize(truncateAt);
        this.jy.setGravity(1);
        this.jy.setMaxLines(2);
        this.jy.setTextColor(Color.parseColor("#90161823"));
        this.jy.setTextSize(2, 14.0f);
        this.oq.addView(this.jy);
        RelativeLayout relativeLayout5 = new RelativeLayout(context);
        this.f28631i = relativeLayout5;
        relativeLayout5.setId(2114387559);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams9.addRule(3, 2114387560);
        layoutParams9.addRule(14);
        layoutParams9.topMargin = ed.cw(context, 36.0f);
        this.f28631i.setLayoutParams(layoutParams9);
        kt.j(this.f28793j, "tt_splash_card_btn_bg", this.f28631i);
        this.f28631i.setGravity(17);
        this.oq.addView(this.f28631i);
        TextView textView5 = new TextView(context);
        this.f28634w = textView5;
        textView5.setId(2114387558);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        this.f28634w.setLayoutParams(layoutParams10);
        this.f28634w.setEllipsize(truncateAt);
        this.f28634w.setMaxLines(1);
        this.f28634w.setTextColor(Color.parseColor("#FFFFFF"));
        this.f28634w.setTextSize(2, 14.0f);
        this.f28634w.setTypeface(Typeface.defaultFromStyle(1));
        this.f28631i.addView(this.f28634w);
        TextView textView6 = new TextView(context);
        this.mi = textView6;
        textView6.setId(2114387557);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, 2114387558);
        layoutParams11.addRule(14);
        this.mi.setLayoutParams(layoutParams11);
        this.mi.setEllipsize(truncateAt);
        this.mi.setMaxLines(1);
        this.mi.setTextColor(Color.parseColor("#AAFFFFFF"));
        this.mi.setTextSize(2, 11.0f);
        this.f28631i.addView(this.mi);
        RelativeLayout relativeLayout6 = new RelativeLayout(context);
        this.kt = relativeLayout6;
        relativeLayout6.setId(2114387556);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams12.addRule(3, 2114387560);
        layoutParams12.addRule(14);
        layoutParams12.topMargin = ed.cw(context, 36.0f);
        this.kt.setLayoutParams(layoutParams12);
        kt.j(this.f28793j, "tt_splash_card_btn_bg", this.kt);
        this.kt.setVisibility(8);
        this.oq.addView(this.kt);
        RelativeLayout relativeLayout7 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(13);
        relativeLayout7.setLayoutParams(layoutParams13);
        this.kt.addView(relativeLayout7);
        View imageView3 = new ImageView(context);
        imageView3.setId(2114387555);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 23.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams14.addRule(9);
        layoutParams14.addRule(15);
        imageView3.setLayoutParams(layoutParams14);
        kt.j(this.f28793j, "tt_splash_card_shake", imageView3);
        relativeLayout7.addView(imageView3);
        TextView textView7 = new TextView(context);
        this.tj = textView7;
        textView7.setId(2114387554);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = ed.cw(context, 8.0f);
        layoutParams15.addRule(1, 2114387555);
        layoutParams15.addRule(15);
        this.tj.setLayoutParams(layoutParams15);
        this.tj.setEllipsize(truncateAt);
        this.tj.setTypeface(Typeface.defaultFromStyle(1));
        this.tj.setMaxLines(1);
        this.tj.setTextColor(Color.parseColor("#FFFFFF"));
        this.tj.setTextSize(2, 13.0f);
        relativeLayout7.addView(this.tj);
        TextView textView8 = new TextView(context);
        this.az = textView8;
        textView8.setId(2114387552);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(20);
        layoutParams16.addRule(12);
        layoutParams16.setMarginStart(ed.cw(context, 8.0f));
        layoutParams16.bottomMargin = ed.cw(context, 8.0f);
        this.az.setLayoutParams(layoutParams16);
        kt.j(this.f28793j, "tt_ad_logo_new", this.az);
        this.oq.addView(this.az);
        ImageView imageView4 = new ImageView(context);
        this.av = imageView4;
        imageView4.setId(2114387553);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        layoutParams17.addRule(3, 2114387568);
        layoutParams17.addRule(14);
        layoutParams17.topMargin = ed.cw(context, 48.0f);
        this.av.setLayoutParams(layoutParams17);
        kt.j(this.f28793j, "tt_splash_card_close", this.av);
        relativeLayout.addView(this.av);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.ae = tTRoundRectImageView;
        tTRoundRectImageView.setId(2114387551);
        this.ae.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ae.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(this.ae);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable m() {
        return new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.8
            @Override // java.lang.Runnable
            public void run() {
                if (cw.this.ae.getWidth() == 0 || cw.this.ae.getHeight() == 0) {
                    return;
                }
                cw.this.ae.animate().scaleX(cw.this.f28632m.getWidth() / cw.this.ae.getWidth()).scaleY(cw.this.f28632m.getHeight() / cw.this.ae.getHeight()).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.8.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        cw.this.ae.setVisibility(8);
                        cw.this.f28632m.setVisibility(0);
                        cw.this.f28630g.setScaleX(0.0f);
                        cw.this.f28630g.setScaleY(0.0f);
                        cw.this.f28630g.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        cw.this.vl.setScaleX(0.0f);
                        cw.this.vl.setScaleY(0.0f);
                        cw.this.vl.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        cw.this.jy.setScaleX(0.0f);
                        cw.this.jy.setScaleY(0.0f);
                        cw.this.jy.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        cw.this.f28631i.setScaleX(0.0f);
                        cw.this.f28631i.setScaleY(0.0f);
                        cw.this.f28631i.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        ae.j jVar = cw.this.f28794r;
                        if (jVar != null) {
                            jVar.j(xq.m(r5.cw));
                        }
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
        };
    }

    protected String cw() {
        n nVar = this.cw;
        return nVar == null ? "" : !TextUtils.isEmpty(nVar.rs()) ? this.cw.rs() : (this.cw.by() == null || TextUtils.isEmpty(this.cw.by().cw())) ? "" : this.cw.by().cw();
    }

    protected String r() {
        n nVar = this.cw;
        return (nVar == null || TextUtils.isEmpty(nVar.hw())) ? "" : this.cw.hw();
    }

    public void up() {
        ae.j jVar = this.f28794r;
        if (jVar == null) {
            return;
        }
        if (this.up == null) {
            this.up = new com.bytedance.sdk.openadsdk.core.dislike.ui.j(jVar.getActivity(), this.cw.gs(), "splash_ad", true);
            com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.f28794r.getActivity(), this.cw, (com.bytedance.sdk.openadsdk.core.dislike.ui.j) this.up);
        }
        this.up.j("splash_card");
        this.up.j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xt
    public void xt() {
        if (xq.tl(this.cw)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 2);
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.cw, "splash_ad", "splash_card_close", jSONObject);
                ae.j jVar = this.f28794r;
                if (jVar != null) {
                    jVar.xt();
                }
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }

    cw() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i6;
        if (view.getId() == 2114387559) {
            i6 = 0;
        } else if (view.getId() == 2114387567) {
            i6 = 1;
        } else if (view.getId() == 2114387562) {
            i6 = 2;
        } else if (view.getId() == 2114387561) {
            i6 = 3;
        } else if (view.getId() == 2114387560) {
            i6 = 4;
        } else {
            i6 = 5;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_card_click_type", i6);
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.cw, "splash_ad", "splash_card_click", jSONObject);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        View.OnClickListener onClickListener = this.f28633v;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xt
    public void j(Context context, ViewGroup viewGroup, n nVar) {
        super.j(context, viewGroup, nVar);
        View j6 = j(this.f28793j);
        if (j6 == null) {
            return;
        }
        this.xt.addView(j6);
        this.f28632m.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ed.cw(v.getContext(), 18.0f));
            }
        });
        this.f28632m.setClipToOutline(true);
        this.ae.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ed.cw(v.getContext(), 28.0f));
            }
        });
        this.ae.setClipToOutline(true);
        ed.j(this.az, this.cw);
        List<h> fp = this.cw.fp();
        if (fp != null && fp.size() > 0) {
            com.bytedance.sdk.openadsdk.g.xt.j(fp.get(0)).cw(2).j(Bitmap.Config.ARGB_8888).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.3
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv<Bitmap> qvVar) {
                    Bitmap cw = qvVar.cw();
                    if (cw == null) {
                        return;
                    }
                    try {
                        if (cw.getConfig() == Bitmap.Config.RGB_565) {
                            cw = cw.copy(Bitmap.Config.ARGB_8888, true);
                        }
                    } catch (Throwable unused) {
                    }
                    Bitmap j7 = com.bytedance.sdk.component.adexpress.r.xt.j(cw.this.f28793j, cw, 10);
                    if (j7 == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(cw.this.f28793j.getResources(), j7);
                    com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (cw.this.tl != null) {
                                cw.this.tl.setBackground(bitmapDrawable);
                            }
                            if (cw.this.ae != null) {
                                cw.this.ae.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
        com.bytedance.sdk.openadsdk.g.xt.j(this.cw.ig()).j(this.qv);
        this.vl.setText(cw());
        this.jy.setText(r());
        this.ws.setVisibility(this.cw.xa() ? 0 : 8);
        this.ws.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                cw.this.up();
            }
        });
        this.f28634w.setText(xq.r(this.cw));
        this.mi.setText(xq.cw(this.cw));
        j(this.cw);
    }

    private void j(n nVar) {
        if (nVar == null || this.f28632m == null || xq.up(nVar) != 1) {
            return;
        }
        ed.j((View) this.kt, 0);
        ed.j((View) this.f28631i, 8);
        TextView textView = this.tj;
        if (textView != null) {
            textView.setText(xq.r(nVar));
        }
        if (this.f28629f == null) {
            this.f28629f = new f(v.getContext(), 1, oq.i().up());
        }
        this.f28629f.xt(this.cw.km());
        this.f28629f.j(this.cw.mt());
        this.f28629f.xt(this.cw.lr());
        this.f28629f.m(this.cw.qo());
        this.f28629f.j(nVar.si());
        this.f28629f.cw(nVar.xn());
        this.f28629f.up(nVar.wo());
        this.f28629f.j(new f.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.5
            @Override // com.bytedance.sdk.component.utils.f.j
            public void j(int i6) {
                if (cw.this.f28633v == null || !cw.this.f28632m.isShown() || i6 != 1 || cw.this.f28633v == null) {
                    return;
                }
                if (cw.this.f28633v instanceof com.bytedance.sdk.openadsdk.core.xt.j) {
                    ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) ((com.bytedance.sdk.openadsdk.core.xt.j) cw.this.f28633v).j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j();
                }
                cw.this.f28633v.onClick(cw.this.f28632m);
            }
        });
        f fVar = this.f28629f;
        n nVar2 = this.cw;
        fVar.j(nVar2 != null ? nVar2.ae() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xt
    public void j(com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        if (jVar == null) {
            return;
        }
        this.f28633v = jVar;
        if (xq.ae(this.cw)) {
            this.f28632m.setOnClickListener(this);
            this.tl.setOnClickListener(this);
            this.qv.setOnClickListener(this);
            this.vl.setOnClickListener(this);
            this.jy.setOnClickListener(this);
            this.oq.setOnClickListener(this);
        }
        this.f28631i.setOnClickListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xt
    public void j(com.bytedance.sdk.openadsdk.core.video.nativevideo.r rVar, ae.j jVar) {
        super.j(rVar, jVar);
        this.xt.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.6
            @Override // java.lang.Runnable
            public void run() {
                if (cw.this.f28632m.isAttachedToWindow()) {
                    cw.this.m().run();
                } else {
                    cw cwVar = cw.this;
                    cwVar.xt.postDelayed(cwVar.m(), 20L);
                }
            }
        });
        if (this.f28794r != null) {
            this.av.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 1);
                        com.bytedance.sdk.openadsdk.core.jy.cw.xt(cw.this.cw, "splash_ad", "splash_card_close", jSONObject);
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                    cw.this.f28794r.xt();
                }
            });
        }
        xq.j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xt
    public String j() {
        return "splash_card_show";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xt
    public void j(boolean z5) {
        super.j(z5);
        ae.j jVar = this.f28794r;
        if (jVar == null) {
            return;
        }
        if (z5) {
            jVar.j(-1L);
        } else {
            jVar.j();
        }
        f fVar = this.f28629f;
        if (fVar != null) {
            if (z5) {
                n nVar = this.cw;
                fVar.j(nVar != null ? nVar.ae() : 0);
            } else {
                n nVar2 = this.cw;
                fVar.xt(nVar2 != null ? nVar2.ae() : 0);
            }
        }
    }
}
