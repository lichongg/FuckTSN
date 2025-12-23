package com.beizi.fusion.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.am;
import com.beizi.fusion.tool.f;
import com.beizi.fusion.update.ShakeArcView;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class EulerAngleView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f13861a;

    /* renamed from: b, reason: collision with root package name */
    private Context f13862b;

    /* renamed from: c, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f13863c;

    /* renamed from: d, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean f13864d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f13865e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f13866f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f13867g;

    /* renamed from: h, reason: collision with root package name */
    private ShakeArcView f13868h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f13869i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f13870j;

    /* renamed from: k, reason: collision with root package name */
    private float f13871k;

    /* renamed from: l, reason: collision with root package name */
    private float f13872l;

    /* renamed from: m, reason: collision with root package name */
    private float f13873m;

    /* renamed from: n, reason: collision with root package name */
    private int f13874n;

    /* renamed from: o, reason: collision with root package name */
    private int f13875o;

    /* renamed from: p, reason: collision with root package name */
    private int f13876p;

    /* renamed from: q, reason: collision with root package name */
    private double f13877q;

    /* renamed from: r, reason: collision with root package name */
    private double f13878r;

    /* renamed from: s, reason: collision with root package name */
    private double f13879s;

    /* renamed from: t, reason: collision with root package name */
    private String f13880t;

    /* renamed from: u, reason: collision with root package name */
    private String f13881u;

    /* renamed from: v, reason: collision with root package name */
    private String f13882v;

    /* renamed from: w, reason: collision with root package name */
    private AnimatorSet f13883w;

    /* renamed from: x, reason: collision with root package name */
    private Boolean f13884x;

    public EulerAngleView(Context context) {
        super(context);
        this.f13861a = false;
        this.f13871k = 60.0f;
        this.f13872l = 60.0f;
        this.f13873m = 30.0f;
        this.f13874n = l.f50696w;
        this.f13877q = 0.0d;
        this.f13878r = 0.0d;
        this.f13879s = 0.0d;
        init(context);
    }

    public void onDestroy() {
        try {
            this.f13862b = null;
            AnimatorSet animatorSet = this.f13883w;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.f13883w = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(List<Animator> list, String str, float f6, float f7) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13867g, str, f6, f7);
            ofFloat.setDuration(this.f13874n);
            list.add(ofFloat);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void buildEulerAngleView() {
        String str;
        TextView textView;
        TextView textView2;
        List<String> imgs;
        try {
            if (this.f13863c == null) {
                return;
            }
            View.inflate(getContext(), R.layout.beizi_interaction_euler_angle_view, this);
            this.f13865e = (LinearLayout) findViewById(R.id.bz_eav_container_ll);
            this.f13866f = (RelativeLayout) findViewById(R.id.bz_eav_img_container_rl);
            this.f13867g = (ImageView) findViewById(R.id.bz_eav_img_iv);
            this.f13868h = (ShakeArcView) findViewById(R.id.bz_eav_sav_iv);
            this.f13869i = (TextView) findViewById(R.id.bz_eav_title_tv);
            this.f13870j = (TextView) findViewById(R.id.bz_eav_subtitle_tv);
            RelativeLayout relativeLayout = this.f13866f;
            if (relativeLayout != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.width = this.f13875o;
                layoutParams.height = this.f13876p;
                this.f13866f.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.f13867g;
            if (imageView != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.width = (int) (this.f13875o * 0.35d);
                int i6 = this.f13876p;
                layoutParams2.height = (int) (i6 * 0.5d);
                layoutParams2.setMargins(0, 0, 0, (int) (i6 * 0.2d));
                this.f13867g.setLayoutParams(layoutParams2);
            }
            ShakeArcView shakeArcView = this.f13868h;
            if (shakeArcView != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) shakeArcView.getLayoutParams();
                layoutParams3.width = (int) (Math.min(this.f13875o, this.f13876p) * 0.7d);
                layoutParams3.height = (int) (Math.min(this.f13875o, this.f13876p) * 0.7d);
                this.f13868h.setLayoutParams(layoutParams3);
                if (!TextUtils.isEmpty(this.f13880t)) {
                    this.f13868h.setArrowDirection(0);
                } else if (("1".equals(this.f13881u) && "1".equals(this.f13882v)) || ((TextUtils.isEmpty(this.f13881u) && "1".equals(this.f13882v)) || (TextUtils.isEmpty(this.f13882v) && "1".equals(this.f13881u)))) {
                    this.f13868h.setArrowDirection(1);
                } else if (("2".equals(this.f13881u) && "2".equals(this.f13882v)) || ((TextUtils.isEmpty(this.f13881u) && "2".equals(this.f13882v)) || (TextUtils.isEmpty(this.f13882v) && "2".equals(this.f13881u)))) {
                    this.f13868h.setArrowDirection(2);
                }
                try {
                    this.f13868h.setLineWidth(Math.min(this.f13875o, this.f13876p) / 30);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean = this.f13864d;
            String color = eulerAngleRenderBean != null ? eulerAngleRenderBean.getColor() : "#66333333";
            String str2 = null;
            if (!TextUtils.isEmpty(color) && color.startsWith("#")) {
                am.a(this.f13866f, color, 0, null, this.f13875o / 2);
            }
            AdSpacesBean.BuyerBean.EulerAngleStyleBean style = this.f13863c.getStyle();
            String str3 = (style == null || (imgs = style.getImgs()) == null || imgs.size() <= 0) ? null : imgs.get(0);
            if (!TextUtils.isEmpty(str3)) {
                f.a(this.f13862b).b(str3, new f.a() { // from class: com.beizi.fusion.widget.EulerAngleView.1
                    @Override // com.beizi.fusion.tool.f.a
                    public void a() {
                    }

                    @Override // com.beizi.fusion.tool.f.a
                    public void a(Bitmap bitmap) {
                        try {
                            if (EulerAngleView.this.f13867g == null || bitmap == null) {
                                return;
                            }
                            EulerAngleView.this.f13867g.setImageBitmap(bitmap);
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                });
            }
            ShakeArcView shakeArcView2 = this.f13868h;
            if (shakeArcView2 != null) {
                shakeArcView2.setMaxProgress(100.0d);
            }
            if (style != null) {
                str2 = style.getTitle();
                if (this.f13884x.booleanValue()) {
                    str = style.getDownloadSubTitle();
                    if (TextUtils.isEmpty(str)) {
                        str = "下载应用";
                    }
                } else {
                    str = style.getSubTitle();
                }
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str2) && (textView2 = this.f13869i) != null) {
                textView2.setText(str2);
                this.f13869i.setTextColor(Color.parseColor("#FFFFFFFF"));
                this.f13869i.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            if (TextUtils.isEmpty(str) || (textView = this.f13870j) == null) {
                return;
            }
            textView.setText(str);
            this.f13870j.setTextColor(Color.parseColor("#FFFFFFFF"));
            this.f13870j.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    public void init(Context context) {
        if (this.f13861a) {
            return;
        }
        this.f13862b = context;
        this.f13861a = true;
    }

    public void setAngle(double d6, double d7, double d8) {
        this.f13877q = d6;
        this.f13878r = d7;
        this.f13879s = d8;
    }

    public void setAnimationViewWidthAndHeight(int i6, int i7) {
        this.f13875o = i6;
        this.f13876p = i7;
    }

    public void setCurrentProgress(double d6, double d7, double d8) {
        double d9;
        try {
            if (this.f13868h != null) {
                double d10 = 0.0d;
                if (this.f13877q <= 0.0d || ((!"2".equals(this.f13880t) || d6 <= 0.0d) && ((!"1".equals(this.f13880t) || d6 >= 0.0d) && !"0".equals(this.f13880t) && !"3".equals(this.f13880t)))) {
                    d9 = 0.0d;
                    double abs = (this.f13878r > 0.0d || ((!"2".equals(this.f13881u) || d7 >= 0.0d) && !(("1".equals(this.f13881u) && d7 > 0.0d) || "0".equals(this.f13881u) || "3".equals(this.f13881u)))) ? 0.0d : (Math.abs(d7) * 100.0d) / this.f13878r;
                    if (this.f13879s > 0.0d && (("2".equals(this.f13882v) && d8 > 0.0d) || (("1".equals(this.f13882v) && d8 < 0.0d) || "0".equals(this.f13882v) || "3".equals(this.f13882v)))) {
                        d10 = (Math.abs(d8) * 100.0d) / this.f13879s;
                    }
                    this.f13868h.setCurrentProgress(Math.max(Math.max(d9, abs), d10));
                }
                d9 = (Math.abs(d6) * 100.0d) / this.f13877q;
                if (this.f13878r > 0.0d) {
                }
                if (this.f13879s > 0.0d) {
                    d10 = (Math.abs(d8) * 100.0d) / this.f13879s;
                }
                this.f13868h.setCurrentProgress(Math.max(Math.max(d9, abs), d10));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setDownloadApp(Boolean bool) {
        this.f13884x = bool;
    }

    public void setEulerAngleRenderBean(AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean) {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            this.f13864d = eulerAngleRenderBean;
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13863c;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        String direction = eulerAngleRuleBean.getDirection();
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.f13880t = direction;
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.f13881u = direction;
                        } else if (bi.aG.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            this.f13882v = direction;
                        }
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setEulerAngleViewRuleBean(AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean) {
        this.f13863c = eulerAngleViewRuleBean;
    }

    public void startContinuousRotations() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13863c;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null && eulerAngleRuleBean.getAngle() != 0.0d) {
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationX", 0.0f, -this.f13871k);
                                a(arrayList, "rotationX", -this.f13871k, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationX", 0.0f, this.f13871k);
                                a(arrayList, "rotationX", this.f13871k, 0.0f);
                            } else {
                                a(arrayList, "rotationX", 0.0f, this.f13871k);
                                a(arrayList, "rotationX", this.f13871k, 0.0f);
                                a(arrayList, "rotationX", 0.0f, -this.f13871k);
                                a(arrayList, "rotationX", -this.f13871k, 0.0f);
                            }
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationY", 0.0f, -this.f13872l);
                                a(arrayList, "rotationY", -this.f13872l, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotationY", 0.0f, this.f13872l);
                                a(arrayList, "rotationY", this.f13872l, 0.0f);
                            } else {
                                a(arrayList, "rotationY", 0.0f, this.f13872l);
                                a(arrayList, "rotationY", this.f13872l, 0.0f);
                                a(arrayList, "rotationY", 0.0f, -this.f13872l);
                                a(arrayList, "rotationY", -this.f13872l, 0.0f);
                            }
                        } else if (bi.aG.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if ("2".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotation", 0.0f, -this.f13873m);
                                a(arrayList, "rotation", -this.f13873m, 0.0f);
                            } else if ("1".equals(eulerAngleRuleBean.getDirection())) {
                                a(arrayList, "rotation", 0.0f, this.f13873m);
                                a(arrayList, "rotation", this.f13873m, 0.0f);
                            } else {
                                a(arrayList, "rotation", 0.0f, this.f13873m);
                                a(arrayList, "rotation", this.f13873m, 0.0f);
                                a(arrayList, "rotation", 0.0f, -this.f13873m);
                                a(arrayList, "rotation", -this.f13873m, 0.0f);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.f13883w = animatorSet;
                    animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.fusion.widget.EulerAngleView.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            try {
                                if (EulerAngleView.this.f13883w != null) {
                                    EulerAngleView.this.f13883w.start();
                                }
                            } catch (Exception e6) {
                                e6.printStackTrace();
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
                    this.f13883w.playSequentially(arrayList);
                    this.f13883w.start();
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public EulerAngleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13861a = false;
        this.f13871k = 60.0f;
        this.f13872l = 60.0f;
        this.f13873m = 30.0f;
        this.f13874n = l.f50696w;
        this.f13877q = 0.0d;
        this.f13878r = 0.0d;
        this.f13879s = 0.0d;
        init(context);
    }

    public EulerAngleView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13861a = false;
        this.f13871k = 60.0f;
        this.f13872l = 60.0f;
        this.f13873m = 30.0f;
        this.f13874n = l.f50696w;
        this.f13877q = 0.0d;
        this.f13878r = 0.0d;
        this.f13879s = 0.0d;
        init(context);
    }
}
