package com.beizi.fusion.work.splash;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.c.b;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.c.l;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.ag;
import com.beizi.fusion.tool.ah;
import com.beizi.fusion.tool.aj;
import com.beizi.fusion.tool.al;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.r;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.ScrollClickView;
import com.beizi.fusion.widget.SkipView;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.fusion.work.a implements ag.a, aj.a, al.a {
    private long I;
    private long J;
    private boolean K;
    private CircleProgressView L;
    private AdSpacesBean.PositionBean M;
    private AdSpacesBean.PositionBean N;
    private float O;
    private float P;
    private AdSpacesBean.RenderViewBean Q;
    private int R;
    private int S;
    private String T;
    private String U;
    private String V;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean W;
    private al ab;
    private ag ac;
    private aj ad;
    private AdSpacesBean.BuyerBean.RollViewBean ae;
    private AdSpacesBean.BuyerBean.CoolRollViewBean af;
    private ah ag;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean ah;
    private r ai;
    private List<AdSpacesBean.ScreenConfigVoBean> aj;
    private View ak;
    private Boolean al;
    private int ao;
    private int ap;
    private boolean aq;
    private int ar;
    private boolean as;
    private long at;

    /* renamed from: n, reason: collision with root package name */
    AdSpacesBean.BuyerBean.ShakeViewBean f14265n;

    /* renamed from: o, reason: collision with root package name */
    AdSpacesBean.BuyerBean.RegionalClickViewBean f14266o;

    /* renamed from: p, reason: collision with root package name */
    AdSpacesBean.BuyerBean.ScrollClickBean f14267p;

    /* renamed from: q, reason: collision with root package name */
    AdSpacesBean.BuyerBean.FullScreenClickBean f14268q;

    /* renamed from: r, reason: collision with root package name */
    View.OnClickListener f14269r;

    /* renamed from: s, reason: collision with root package name */
    private Context f14270s;

    /* renamed from: t, reason: collision with root package name */
    private String f14271t;

    /* renamed from: u, reason: collision with root package name */
    private long f14272u;

    /* renamed from: v, reason: collision with root package name */
    private com.beizi.ad.v2.g.a f14273v;

    /* renamed from: w, reason: collision with root package name */
    private ViewGroup f14274w;

    /* renamed from: x, reason: collision with root package name */
    private ViewGroup f14275x;

    /* renamed from: y, reason: collision with root package name */
    private View f14276y;

    /* renamed from: z, reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f14277z;
    private List<AdSpacesBean.RenderViewBean> A = new ArrayList();
    private List<AdSpacesBean.RenderViewBean> B = new ArrayList();
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private long H = 5000;
    private String X = null;
    private boolean Y = false;
    private int Z = -1;
    private String aa = "full";
    private boolean am = false;
    private boolean an = false;
    private int au = 5;

    private void aA() {
        ViewGroup viewGroup;
        final boolean z5;
        com.beizi.ad.v2.g.a aVar = this.f14273v;
        if (aVar == null || !aVar.d() || (viewGroup = this.f14274w) == null) {
            ap();
            return;
        }
        viewGroup.removeAllViews();
        this.f14274w.addView(this.f14275x);
        AdSpacesBean.BuyerBean buyerBean = this.f14056e;
        if (buyerBean != null) {
            boolean z6 = buyerBean.getIsImageSpeed() == 1;
            r1 = z6;
            z5 = this.f14056e.getIsHideInteraction() == 1;
        } else {
            z5 = false;
        }
        if (!r1) {
            aB();
            aC();
        } else {
            this.f14273v.a(new com.beizi.ad.v2.b.a() { // from class: com.beizi.fusion.work.splash.a.5
                @Override // com.beizi.ad.v2.b.a
                public void a() {
                    if (z5) {
                        a.this.aB();
                    }
                }
            });
            if (!z5) {
                aB();
            }
            aC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB() {
        StringBuilder sb = new StringBuilder();
        sb.append("shakeViewBean != null ? ");
        sb.append(this.f14265n != null);
        sb.append(",regionalClickViewBean != null ? ");
        sb.append(this.f14266o != null);
        sb.append(",fullScreenClickBean != null ? ");
        sb.append(this.f14268q != null);
        aa.a("BeiZis", sb.toString());
        this.f14275x.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.splash.a.6

            /* renamed from: a, reason: collision with root package name */
            boolean f14296a;

            /* renamed from: b, reason: collision with root package name */
            boolean f14297b;

            protected void a(boolean z5) {
                if (z5 || a.this.f14273v == null) {
                    return;
                }
                a.this.f14273v.a(new View.OnTouchListener() { // from class: com.beizi.fusion.work.splash.a.6.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (a.this.f14275x == null) {
                        return;
                    }
                    a.this.f14275x.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    if (((com.beizi.fusion.work.a) a.this).f14056e == null) {
                        return;
                    }
                    a aVar = a.this;
                    if (aVar.f14268q != null) {
                        if (((com.beizi.fusion.work.a) aVar).f14053b != null) {
                            ((com.beizi.fusion.work.a) a.this).f14053b.setFullScreenClickUuid(a.this.f14268q.getFullScreenClickUuid());
                            a.this.ao();
                        }
                        a aVar2 = a.this;
                        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean d6 = aVar2.d(aVar2.f14268q.getOrderData(), a.this.f14273v.b());
                        if (d6 == null) {
                            this.f14296a = af.a(a.this.f14268q.getRandomClickNum());
                            aa.a("BeiZis", "beizi clickable Two = " + this.f14296a);
                            a(this.f14296a);
                        } else if (d6.getFullScreenClick() != null) {
                            this.f14297b = af.a(d6.getFullScreenClick().getRandomClickNum());
                            aa.a("BeiZis", "beizi clickable = " + this.f14297b);
                            a(this.f14297b);
                        }
                    }
                    a.this.aQ();
                    if (((com.beizi.fusion.work.a) a.this).f14056e.getInteractionRules() == null || ((com.beizi.fusion.work.a) a.this).f14056e.getInteractionRules().size() <= 0) {
                        if (b.a().n()) {
                            a.this.aM();
                            a.this.aN();
                            return;
                        }
                        a.this.aD();
                        a.this.aM();
                        a.this.aN();
                        a.this.aO();
                        a.this.aP();
                        return;
                    }
                    String a6 = com.beizi.fusion.e.b.a(((com.beizi.fusion.work.a) a.this).f14056e.getInteractionRules(), af.b(100));
                    switch (a6.hashCode()) {
                        case -1671124246:
                            if (a6.equals("eulerAngle")) {
                                if (!b.a().n()) {
                                    a.this.aP();
                                    break;
                                } else {
                                    a.this.aM();
                                    break;
                                }
                            }
                            break;
                        case -907680051:
                            if (a6.equals("scroll")) {
                                a.this.aN();
                                break;
                            }
                            break;
                        case -690338273:
                            if (a6.equals("regional")) {
                                a.this.aM();
                                break;
                            }
                            break;
                        case 3506301:
                            if (a6.equals("roll")) {
                                if (!b.a().n()) {
                                    a.this.aO();
                                    break;
                                } else {
                                    a.this.aM();
                                    break;
                                }
                            }
                            break;
                        case 109399814:
                            if (a6.equals("shake")) {
                                if (!b.a().n()) {
                                    a.this.aD();
                                    break;
                                } else {
                                    a.this.aM();
                                    break;
                                }
                            }
                            break;
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD() {
        try {
            if (this.ab == null) {
                this.ab = new al(this.f14270s);
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f14265n;
            if (shakeViewBean == null || this.ab == null || shakeViewBean.getPosition() == null) {
                return;
            }
            this.am = true;
            EventBean eventBean = this.f14053b;
            if (eventBean != null) {
                eventBean.setShakeViewUuid(this.f14265n.getShakeViewUuid());
                ao();
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean a6 = a(this.f14265n.getOrderData(), this.f14273v.b());
            AdSpacesBean.BuyerBean.ShakeViewBean shakeView = (a6 == null || a6.getShakeView() == null) ? null : a6.getShakeView();
            this.ab.a(this.al);
            View a7 = this.ab.a(ap.b(this.f14270s, this.f14275x.getWidth()), ap.b(this.f14270s, this.f14275x.getHeight()), this.f14265n.getPosition());
            if (a7 != null) {
                ViewGroup.LayoutParams layoutParams = a7.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    this.f14274w.addView(a7, layoutParams2);
                }
            }
            aE();
            a(shakeView);
            this.ab.a(this);
            a(shakeView, a7);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void aE() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f14265n;
        if (shakeViewBean == null) {
            return;
        }
        int sensorParam = shakeViewBean.getSensorParam();
        int compliantAngle = this.f14265n.getCompliantAngle();
        boolean isReturnAngle = this.f14265n.isReturnAngle();
        com.beizi.ad.v2.g.a aVar = this.f14273v;
        Map g6 = aVar != null ? aVar.g() : null;
        al alVar = this.ab;
        if (alVar == null) {
            return;
        }
        alVar.a(sensorParam, compliantAngle, isReturnAngle, g6);
    }

    private void aF() {
        int passPercent;
        for (int i6 = 0; i6 < this.f14277z.size(); i6++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f14277z.get(i6);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.B.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.A.add(renderViewBean);
            }
        }
        if (this.B.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = this.B.get(0);
            this.Q = renderViewBean2;
            if (renderViewBean2 != null) {
                this.N = renderViewBean2.getTapPosition();
                this.M = this.Q.getLayerPosition();
                long skipViewTotalTime = this.Q.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.H = skipViewTotalTime;
                }
                long skipUnavailableTime = this.Q.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.J = skipUnavailableTime;
                }
                this.R = this.Q.getShowCountDown();
                this.S = this.Q.getShowBorder();
                String skipText = this.Q.getSkipText();
                this.T = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.T = "跳过";
                }
                String textColor = this.Q.getTextColor();
                this.U = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.U = "#FFFFFF";
                }
                String countDownColor = this.Q.getCountDownColor();
                this.V = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.V = "#FFFFFF";
                }
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.Q.getPassPolicy();
                if (passPolicy != null && passPolicy.size() > 0) {
                    for (AdSpacesBean.PassPolicyBean passPolicyBean : passPolicy) {
                        String passType = passPolicyBean.getPassType();
                        passPercent = passPolicyBean.getPassPercent();
                        passType.getClass();
                        switch (passType) {
                            case "RANDOMPASS":
                                this.D = af.a(passPercent);
                                break;
                            case "WAITPASS":
                                this.C = af.a(passPercent);
                                break;
                            case "LAYERPASS":
                                AdSpacesBean.PositionBean positionBean = this.M;
                                if (positionBean != null && this.N != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.M.getCenterY();
                                    double width = this.M.getWidth();
                                    double height = this.M.getHeight();
                                    double centerX2 = this.N.getCenterX();
                                    double centerY2 = this.N.getCenterY();
                                    double width2 = this.N.getWidth();
                                    double height2 = this.N.getHeight();
                                    if ((centerX > 0.0d && centerX2 > 0.0d && centerX != centerX2) || ((centerY > 0.0d && centerY2 > 0.0d && centerY != centerY2) || ((width > 0.0d && width2 > 0.0d && width != width2) || (height > 0.0d && height2 > 0.0d && height != height2)))) {
                                        this.E = af.a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.F = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
        if (this.A.size() > 0) {
            Collections.sort(this.A, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.a.10
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean3, AdSpacesBean.RenderViewBean renderViewBean4) {
                    return renderViewBean4.getLevel() - renderViewBean3.getLevel();
                }
            });
        }
    }

    private void aG() {
        if (this.C) {
            R();
        }
        if (this.D) {
            S();
        }
        if (this.E) {
            T();
        }
        if (this.F) {
            U();
        }
        this.I = this.H - this.J;
    }

    private View aH() {
        View view;
        String str;
        this.f14269r = new View.OnClickListener() { // from class: com.beizi.fusion.work.splash.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    if (a.this.f14273v != null) {
                        a.this.f14273v.e();
                    }
                    a.this.G();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        };
        if (this.K) {
            View view2 = this.f14276y;
            if (view2 != null) {
                view2.setVisibility(8);
                view2.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.f14270s);
            this.f14276y = skipView;
            skipView.setOnClickListener(this.f14269r);
            CircleProgressView circleProgressView = new CircleProgressView(this.f14270s);
            this.L = circleProgressView;
            circleProgressView.setAlpha(0.0f);
            view = this.L;
            str = "beizi";
        } else {
            view = this.f14276y;
            if (view != null) {
                CircleProgressView circleProgressView2 = new CircleProgressView(this.f14270s);
                this.L = circleProgressView2;
                circleProgressView2.setAlpha(0.0f);
                view = this.L;
                str = Constants.JumpUrlConstants.SRC_TYPE_APP;
            } else {
                str = "buyer";
            }
        }
        EventBean eventBean = this.f14053b;
        if (eventBean != null) {
            eventBean.setSkipType(str);
            ao();
        }
        return view;
    }

    private void aI() {
        if (!this.K) {
            View view = this.f14276y;
            if (view != null) {
                view.setVisibility(0);
                this.f14276y.setAlpha(1.0f);
                return;
            }
            return;
        }
        if (this.M == null || this.Q == null) {
            aJ();
            return;
        }
        float f6 = this.O;
        float height = this.f14274w.getHeight();
        if (height == 0.0f) {
            height = this.P - ap.a(this.f14270s, 100.0f);
        }
        int width = (int) (f6 * this.M.getWidth() * 0.01d);
        if (this.M.getHeight() < 12.0d) {
            aJ();
            return;
        }
        int height2 = (int) (width * this.M.getHeight() * 0.01d);
        int paddingHeight = (int) (height2 * this.Q.getPaddingHeight() * 0.01d);
        if (paddingHeight < 0) {
            paddingHeight = 0;
        }
        ((SkipView) this.f14276y).setData(this.S, paddingHeight);
        d(this.au);
        this.f14274w.addView(this.f14276y, new FrameLayout.LayoutParams(width, height2));
        float centerX = (f6 * ((float) (this.M.getCenterX() * 0.01d))) - (width / 2);
        float centerY = (height * ((float) (this.M.getCenterY() * 0.01d))) - (height2 / 2);
        this.f14276y.setX(centerX);
        this.f14276y.setY(centerY);
        View view2 = this.f14276y;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private void aJ() {
        int i6 = (int) (this.O * 0.15d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, (int) (i6 * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = ap.a(this.f14270s, 20.0f);
        layoutParams.rightMargin = ap.a(this.f14270s, 20.0f);
        ViewGroup viewGroup = this.f14274w;
        if (viewGroup != null) {
            viewGroup.addView(this.f14276y, layoutParams);
        }
        View view = this.f14276y;
        if (view != null) {
            this.R = 1;
            this.S = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.f14276y).setText(String.format("跳过 %d", Integer.valueOf(this.au)));
            this.f14276y.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK() {
        float pivotX;
        float pivotY;
        float height;
        try {
            View view = this.f14276y;
            if (view == null) {
                return;
            }
            view.getLocationOnScreen(new int[2]);
            if (this.N != null) {
                float f6 = this.O;
                float height2 = this.f14274w.getHeight();
                if (height2 == 0.0f) {
                    height2 = this.P - ap.a(this.f14270s, 100.0f);
                }
                int width = (int) (f6 * this.N.getWidth() * 0.01d);
                int height3 = (int) (width * this.N.getHeight() * 0.01d);
                ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = height3;
                this.L.setLayoutParams(layoutParams);
                pivotX = (f6 * ((float) (this.N.getCenterX() * 0.01d))) - (width / 2);
                pivotY = height2 * ((float) (this.N.getCenterY() * 0.01d));
                height = height3 / 2;
            } else {
                pivotX = (r2[0] + this.f14276y.getPivotX()) - (this.L.getWidth() / 2);
                pivotY = r2[1] + this.f14276y.getPivotY();
                height = this.L.getHeight() / 2;
            }
            float f7 = pivotY - height;
            this.L.setX(pivotX);
            this.L.setY(f7);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void aL() {
        com.beizi.ad.v2.g.a aVar = this.f14273v;
        if (aVar != null) {
            aVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM() {
        try {
            if (this.f14266o == null && b.a().n()) {
                AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean = new AdSpacesBean.BuyerBean.RegionalClickViewBean();
                this.f14266o = regionalClickViewBean;
                regionalClickViewBean.setTitleColor("#FFFFFF");
                this.f14266o.setTitle("点击跳转至网页或第三方应用");
                this.f14266o.setRegionalClickUuid("-4");
                this.f14266o.setIsDisableClick(0);
                AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean = new AdSpacesBean.BuyerBean.PercentPositionBean();
                percentPositionBean.setCenterX("50%");
                percentPositionBean.setCenterY("80%");
                this.f14266o.setPosition(percentPositionBean);
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean2 = this.f14266o;
            if (regionalClickViewBean2 == null || this.ac == null || regionalClickViewBean2.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f14053b;
            if (eventBean != null) {
                eventBean.setRegionalClickUuid(this.f14266o.getRegionalClickUuid());
                ao();
            }
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean b6 = b(this.f14266o.getOrderData(), this.f14273v.b());
            if (b6 != null) {
                this.ac.a(b6.getRegionalClickView());
            } else {
                this.ac.a(this.f14266o);
            }
            this.ac.a(this.al);
            View a6 = this.ac.a(ap.b(this.f14270s, this.f14275x.getWidth()), ap.b(this.f14270s, this.f14275x.getHeight()), this.f14266o.getPosition(), true);
            this.ak = a6;
            if (a6 != null) {
                ViewGroup.LayoutParams layoutParams = a6.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    try {
                        this.f14274w.addView(this.ak, layoutParams2);
                        this.ac.a(this);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.f14267p;
            if (scrollClickBean == null || this.ad == null || scrollClickBean.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f14053b;
            if (eventBean != null) {
                eventBean.setScrollClickUuid(this.f14267p.getScrollClickUuid());
                ao();
            }
            AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean c6 = c(this.f14267p.getOrderData(), this.f14273v.b());
            if (c6 != null) {
                this.ad.a(c6.getScrollClick());
            } else {
                this.ad.a(this.f14267p);
            }
            this.ad.a(this.al);
            View a6 = this.ad.a(ap.b(this.f14270s, this.f14275x.getWidth()), ap.b(this.f14270s, this.f14275x.getHeight()), this.f14267p.getPosition());
            if (a6 != null) {
                ViewGroup.LayoutParams layoutParams = a6.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    try {
                        this.f14274w.addView(a6, layoutParams2);
                        this.ad.a(this);
                        a(this.f14267p.getScrollDirection(), this.f14267p.getScrollDistance(), this);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        try {
            AdSpacesBean.BuyerBean.RollViewBean rollView = this.f14056e.getRollView();
            this.ae = rollView;
            if (rollView == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataRollViewBean e6 = e(rollView.getOrderData(), this.f14273v.b());
            AdSpacesBean.BuyerBean.RollViewBean rollView2 = (e6 == null || e6.getRollView() == null) ? null : e6.getRollView();
            if (rollView2 == null) {
                rollView2 = this.ae;
            }
            if (rollView2.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.f14053b;
            if (eventBean != null) {
                eventBean.setRollViewUuid(rollView2.getRollViewUuid());
                ao();
            }
            if (this.ag == null) {
                this.ag = new ah(this.f14270s);
            }
            this.ag.a(this.al);
            this.ag.a(this.f14274w, ap.b(this.f14270s, this.f14275x.getWidth()), ap.b(this.f14270s, this.f14275x.getHeight()), rollView2);
            AdSpacesBean.BuyerBean.RollViewBean rollViewBean = this.ae;
            if (rollViewBean != null) {
                this.af = rollViewBean.getCoolRollView();
            }
            a(rollView2);
            this.ag.a();
            final int isClick = rollView2.getIsClick();
            this.ag.a(new ah.a() { // from class: com.beizi.fusion.work.splash.a.12
                @Override // com.beizi.fusion.tool.ah.a
                public void a() {
                    if (a.this.Y && a.this.af != null) {
                        an.a(a.this.f14270s, a.this.X, (Object) Long.valueOf(System.currentTimeMillis()));
                    }
                    a.this.aa = "roll";
                    ((com.beizi.fusion.work.a) a.this).f14053b.setClickType("roll");
                    a.this.ao();
                    aa.a("BeiZis", "enter onRollHappened  ");
                    a.this.a("", "", "", "", "", "", "", "", 5);
                }

                @Override // com.beizi.fusion.tool.ah.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    if (isClick == 1) {
                        a.this.aa = "regionalClick";
                        ((com.beizi.fusion.work.a) a.this).f14053b.setClickType("regionalClick");
                        a.this.ao();
                        aa.a("BeiZis", "enter onClickHappened  ");
                        a.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                        a.this.ag.c();
                    }
                }
            });
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.f14056e.getEulerAngleRule();
            this.ah = eulerAngleRule;
            if (eulerAngleRule == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean f6 = f(eulerAngleRule.getOrderData(), this.f14273v.b());
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule2 = (f6 == null || f6.getEulerAngleRule() == null) ? null : f6.getEulerAngleRule();
            if (eulerAngleRule2 != null) {
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setEulerAngleUuid(eulerAngleRule2.getEulerAngleUuid());
                    ao();
                }
            } else {
                EventBean eventBean2 = this.f14053b;
                if (eventBean2 != null) {
                    eventBean2.setEulerAngleUuid(this.ah.getEulerAngleUuid());
                    ao();
                }
            }
            if (this.ai == null) {
                this.ai = new r(this.f14270s, this.f14060i, this.ah, eulerAngleRule2);
            }
            this.ai.a(this.al);
            this.ai.a(this.f14274w, ap.b(this.f14270s, this.f14275x.getWidth()), ap.b(this.f14270s, this.f14275x.getHeight()));
            this.ai.a(new r.a() { // from class: com.beizi.fusion.work.splash.a.2
                @Override // com.beizi.fusion.tool.r.a
                public void a() {
                    try {
                        a.this.aa = "eulerAngle";
                        ((com.beizi.fusion.work.a) a.this).f14053b.setClickType("eulerAngle");
                        a.this.ao();
                        a.this.a("", "", "", "", "", "", "", "", 2);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
            this.ai.a();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000d, B:7:0x0013, B:9:0x0019, B:11:0x0032, B:14:0x003d, B:15:0x003f, B:18:0x005a, B:21:0x0061, B:23:0x0067, B:24:0x0086, B:26:0x008c, B:29:0x0093, B:31:0x0099, B:32:0x00b8, B:34:0x00be, B:37:0x00c5, B:39:0x00cb, B:40:0x00ea, B:42:0x00f0, B:45:0x00f7, B:47:0x00fd, B:48:0x011c, B:53:0x012d, B:55:0x014d, B:57:0x0155, B:58:0x0162, B:68:0x010f, B:69:0x011b, B:70:0x00dd, B:71:0x00e9, B:72:0x00ab, B:73:0x00b7, B:74:0x0079, B:75:0x0085), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000d, B:7:0x0013, B:9:0x0019, B:11:0x0032, B:14:0x003d, B:15:0x003f, B:18:0x005a, B:21:0x0061, B:23:0x0067, B:24:0x0086, B:26:0x008c, B:29:0x0093, B:31:0x0099, B:32:0x00b8, B:34:0x00be, B:37:0x00c5, B:39:0x00cb, B:40:0x00ea, B:42:0x00f0, B:45:0x00f7, B:47:0x00fd, B:48:0x011c, B:53:0x012d, B:55:0x014d, B:57:0x0155, B:58:0x0162, B:68:0x010f, B:69:0x011b, B:70:0x00dd, B:71:0x00e9, B:72:0x00ab, B:73:0x00b7, B:74:0x0079, B:75:0x0085), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000d, B:7:0x0013, B:9:0x0019, B:11:0x0032, B:14:0x003d, B:15:0x003f, B:18:0x005a, B:21:0x0061, B:23:0x0067, B:24:0x0086, B:26:0x008c, B:29:0x0093, B:31:0x0099, B:32:0x00b8, B:34:0x00be, B:37:0x00c5, B:39:0x00cb, B:40:0x00ea, B:42:0x00f0, B:45:0x00f7, B:47:0x00fd, B:48:0x011c, B:53:0x012d, B:55:0x014d, B:57:0x0155, B:58:0x0162, B:68:0x010f, B:69:0x011b, B:70:0x00dd, B:71:0x00e9, B:72:0x00ab, B:73:0x00b7, B:74:0x0079, B:75:0x0085), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000d, B:7:0x0013, B:9:0x0019, B:11:0x0032, B:14:0x003d, B:15:0x003f, B:18:0x005a, B:21:0x0061, B:23:0x0067, B:24:0x0086, B:26:0x008c, B:29:0x0093, B:31:0x0099, B:32:0x00b8, B:34:0x00be, B:37:0x00c5, B:39:0x00cb, B:40:0x00ea, B:42:0x00f0, B:45:0x00f7, B:47:0x00fd, B:48:0x011c, B:53:0x012d, B:55:0x014d, B:57:0x0155, B:58:0x0162, B:68:0x010f, B:69:0x011b, B:70:0x00dd, B:71:0x00e9, B:72:0x00ab, B:73:0x00b7, B:74:0x0079, B:75:0x0085), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000d, B:7:0x0013, B:9:0x0019, B:11:0x0032, B:14:0x003d, B:15:0x003f, B:18:0x005a, B:21:0x0061, B:23:0x0067, B:24:0x0086, B:26:0x008c, B:29:0x0093, B:31:0x0099, B:32:0x00b8, B:34:0x00be, B:37:0x00c5, B:39:0x00cb, B:40:0x00ea, B:42:0x00f0, B:45:0x00f7, B:47:0x00fd, B:48:0x011c, B:53:0x012d, B:55:0x014d, B:57:0x0155, B:58:0x0162, B:68:0x010f, B:69:0x011b, B:70:0x00dd, B:71:0x00e9, B:72:0x00ab, B:73:0x00b7, B:74:0x0079, B:75:0x0085), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014d A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000d, B:7:0x0013, B:9:0x0019, B:11:0x0032, B:14:0x003d, B:15:0x003f, B:18:0x005a, B:21:0x0061, B:23:0x0067, B:24:0x0086, B:26:0x008c, B:29:0x0093, B:31:0x0099, B:32:0x00b8, B:34:0x00be, B:37:0x00c5, B:39:0x00cb, B:40:0x00ea, B:42:0x00f0, B:45:0x00f7, B:47:0x00fd, B:48:0x011c, B:53:0x012d, B:55:0x014d, B:57:0x0155, B:58:0x0162, B:68:0x010f, B:69:0x011b, B:70:0x00dd, B:71:0x00e9, B:72:0x00ab, B:73:0x00b7, B:74:0x0079, B:75:0x0085), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000d, B:7:0x0013, B:9:0x0019, B:11:0x0032, B:14:0x003d, B:15:0x003f, B:18:0x005a, B:21:0x0061, B:23:0x0067, B:24:0x0086, B:26:0x008c, B:29:0x0093, B:31:0x0099, B:32:0x00b8, B:34:0x00be, B:37:0x00c5, B:39:0x00cb, B:40:0x00ea, B:42:0x00f0, B:45:0x00f7, B:47:0x00fd, B:48:0x011c, B:53:0x012d, B:55:0x014d, B:57:0x0155, B:58:0x0162, B:68:0x010f, B:69:0x011b, B:70:0x00dd, B:71:0x00e9, B:72:0x00ab, B:73:0x00b7, B:74:0x0079, B:75:0x0085), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00dd A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000d, B:7:0x0013, B:9:0x0019, B:11:0x0032, B:14:0x003d, B:15:0x003f, B:18:0x005a, B:21:0x0061, B:23:0x0067, B:24:0x0086, B:26:0x008c, B:29:0x0093, B:31:0x0099, B:32:0x00b8, B:34:0x00be, B:37:0x00c5, B:39:0x00cb, B:40:0x00ea, B:42:0x00f0, B:45:0x00f7, B:47:0x00fd, B:48:0x011c, B:53:0x012d, B:55:0x014d, B:57:0x0155, B:58:0x0162, B:68:0x010f, B:69:0x011b, B:70:0x00dd, B:71:0x00e9, B:72:0x00ab, B:73:0x00b7, B:74:0x0079, B:75:0x0085), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ab A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000d, B:7:0x0013, B:9:0x0019, B:11:0x0032, B:14:0x003d, B:15:0x003f, B:18:0x005a, B:21:0x0061, B:23:0x0067, B:24:0x0086, B:26:0x008c, B:29:0x0093, B:31:0x0099, B:32:0x00b8, B:34:0x00be, B:37:0x00c5, B:39:0x00cb, B:40:0x00ea, B:42:0x00f0, B:45:0x00f7, B:47:0x00fd, B:48:0x011c, B:53:0x012d, B:55:0x014d, B:57:0x0155, B:58:0x0162, B:68:0x010f, B:69:0x011b, B:70:0x00dd, B:71:0x00e9, B:72:0x00ab, B:73:0x00b7, B:74:0x0079, B:75:0x0085), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void aQ() {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.splash.a.aQ():void");
    }

    private void ay() {
        View view;
        View.OnClickListener onClickListener;
        if (this.K || (view = this.f14276y) == null || (onClickListener = this.f14269r) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        d dVar = this.f14055d;
        if (dVar == null) {
            return;
        }
        dVar.n().toString();
        Z();
        e eVar = this.f14058g;
        if (eVar == e.SUCCESS) {
            ay();
            this.f14055d.a(f(), (View) null);
        } else if (eVar == e.FAIL) {
            f();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean f(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean : list) {
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.tool.aj.a
    public void a_() {
        this.aa = "scroll";
        this.f14053b.setClickType("scroll");
        ao();
        aa.a("BeiZis", "enter onScrollDistanceMeet ");
        aL();
    }

    @Override // com.beizi.fusion.work.a
    public Map av() {
        try {
            if (!this.an) {
                return null;
            }
            if (this.am) {
                al alVar = this.ab;
                if (alVar == null) {
                    return null;
                }
                return alVar.e();
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f14265n;
            if (shakeViewBean == null || shakeViewBean.getSensorParam() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("actionType", 0);
            return hashMap;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        com.beizi.ad.v2.g.a aVar = this.f14273v;
        if (aVar == null) {
            return null;
        }
        return aVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        com.beizi.ad.v2.g.a aVar = this.f14273v;
        if (aVar == null) {
            return null;
        }
        return aVar.m();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.f14061j;
    }

    @Override // com.beizi.fusion.work.a
    public String i() {
        com.beizi.ad.v2.g.a aVar = this.f14273v;
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean j() {
        return this.f14056e;
    }

    @Override // com.beizi.fusion.work.a
    protected void k() {
        v();
        ab();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f14056e.getShakeView();
        this.f14265n = shakeView;
        if (shakeView != null) {
            this.W = shakeView.getCoolShakeView();
        }
        this.f14266o = this.f14056e.getRegionalClickView();
        this.f14268q = this.f14056e.getFullScreenClick();
        this.f14267p = this.f14056e.getScrollClick();
        this.aj = this.f14056e.getScreenConfigVo();
        com.beizi.ad.a aVar = new com.beizi.ad.a() { // from class: com.beizi.fusion.work.splash.a.1

            /* renamed from: a, reason: collision with root package name */
            boolean f14278a = false;

            @Override // com.beizi.ad.a
            public void a() {
                if (b.a().i() && a.this.f14272u - (System.currentTimeMillis() - ((com.beizi.fusion.work.a) a.this).f14055d.u()) < a.this.ar) {
                    a.this.aq = true;
                    a.this.a(String.valueOf(3), 3);
                    return;
                }
                System.currentTimeMillis();
                a aVar2 = a.this;
                aVar2.au = aVar2.f14273v.k();
                ((com.beizi.fusion.work.a) a.this).f14061j = com.beizi.fusion.e.a.ADLOAD;
                if (a.this.f14273v.a() != null) {
                    try {
                        a aVar3 = a.this;
                        aVar3.a(Double.parseDouble(aVar3.f14273v.a()));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                a aVar4 = a.this;
                aVar4.al = Boolean.valueOf(aVar4.f14273v.l());
                a aVar5 = a.this;
                aVar5.as = aVar5.f14273v.i();
                if (a.this.as) {
                    a aVar6 = a.this;
                    aVar6.at = aVar6.f14273v.j();
                    ((com.beizi.fusion.work.a) a.this).f14053b.setIsCacheAd("1");
                    if (a.this.at > 0) {
                        ((com.beizi.fusion.work.a) a.this).f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.at));
                    }
                    a.this.ao();
                }
                a.this.x();
                if (a.this.Y()) {
                    a.this.az();
                } else {
                    a.this.P();
                }
            }

            @Override // com.beizi.ad.a
            public void b() {
                ((com.beizi.fusion.work.a) a.this).f14061j = com.beizi.fusion.e.a.ADSHOW;
                if (a.this.as) {
                    ((com.beizi.fusion.work.a) a.this).f14053b.setIsCacheAd("1");
                    if (a.this.at > 0) {
                        ((com.beizi.fusion.work.a) a.this).f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.at));
                    }
                    a.this.ao();
                }
                if (((com.beizi.fusion.work.a) a.this).f14055d != null) {
                    if (((com.beizi.fusion.work.a) a.this).f14055d.o() != 2) {
                        ((com.beizi.fusion.work.a) a.this).f14055d.b(a.this.f());
                    }
                    a.this.ac();
                }
                a.this.B();
                a.this.V();
                a.this.C();
            }

            @Override // com.beizi.ad.a
            public void c() {
                try {
                    if (((com.beizi.fusion.work.a) a.this).f14055d != null) {
                        ((com.beizi.fusion.work.a) a.this).f14055d.c(a.this.f());
                    }
                    a.this.F();
                    if (a.this.ab != null) {
                        a.this.ab.c();
                    }
                    if (a.this.ac != null) {
                        a.this.ac.a();
                    }
                    if (a.this.ad != null) {
                        a.this.ad.b();
                    }
                    if (a.this.ag != null) {
                        a.this.ag.b();
                    }
                    if (a.this.ai != null) {
                        a.this.ai.b();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
            @Override // com.beizi.ad.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void e() {
                /*
                    r7 = this;
                    com.beizi.fusion.work.splash.a r0 = com.beizi.fusion.work.splash.a.this
                    android.content.Context r0 = com.beizi.fusion.work.splash.a.F(r0)
                    long r1 = java.lang.System.currentTimeMillis()
                    java.lang.Long r1 = java.lang.Long.valueOf(r1)
                    java.lang.String r2 = "uniteTime"
                    com.beizi.fusion.tool.an.a(r0, r2, r1)
                    r0 = 1
                    r1 = 0
                    com.beizi.fusion.work.splash.a r2 = com.beizi.fusion.work.splash.a.this     // Catch: java.lang.Exception -> L58
                    com.beizi.fusion.model.AdSpacesBean$BuyerBean r2 = com.beizi.fusion.work.splash.a.G(r2)     // Catch: java.lang.Exception -> L58
                    java.util.List r2 = r2.getCallBackStrategy()     // Catch: java.lang.Exception -> L58
                    if (r2 == 0) goto L5f
                    int r3 = r2.size()     // Catch: java.lang.Exception -> L58
                    if (r3 <= 0) goto L5f
                    r3 = 0
                L28:
                    int r4 = r2.size()     // Catch: java.lang.Exception -> L4f
                    if (r3 >= r4) goto L56
                    java.lang.Object r4 = r2.get(r3)     // Catch: java.lang.Exception -> L4f
                    com.beizi.fusion.model.AdSpacesBean$CallBackStrategyBean r4 = (com.beizi.fusion.model.AdSpacesBean.CallBackStrategyBean) r4     // Catch: java.lang.Exception -> L4f
                    java.lang.String r5 = "290.300"
                    java.lang.String r6 = r4.getEventCode()     // Catch: java.lang.Exception -> L4f
                    boolean r5 = r5.equalsIgnoreCase(r6)     // Catch: java.lang.Exception -> L4f
                    if (r5 == 0) goto L53
                    java.lang.String r2 = r4.getRate()     // Catch: java.lang.Exception -> L4f
                    int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L4f
                    boolean r1 = com.beizi.fusion.tool.af.a(r2)     // Catch: java.lang.Exception -> L4f
                    r2 = r1
                    r1 = 1
                    goto L60
                L4f:
                    r2 = move-exception
                    r3 = r2
                    r2 = 1
                    goto L5b
                L53:
                    int r3 = r3 + 1
                    goto L28
                L56:
                    r1 = 1
                    goto L5f
                L58:
                    r2 = move-exception
                    r3 = r2
                    r2 = 0
                L5b:
                    r3.printStackTrace()
                    r1 = r2
                L5f:
                    r2 = 0
                L60:
                    if (r1 == 0) goto L82
                    com.beizi.fusion.work.splash.a r3 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.model.AdSpacesBean$BuyerBean r3 = com.beizi.fusion.work.splash.a.H(r3)
                    if (r3 == 0) goto L82
                    com.beizi.fusion.work.splash.a r3 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.events.EventBean r3 = com.beizi.fusion.work.splash.a.J(r3)
                    com.beizi.fusion.work.splash.a r4 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.model.AdSpacesBean$BuyerBean r4 = com.beizi.fusion.work.splash.a.I(r4)
                    java.lang.String r4 = r4.getCallBackStrategyUuid()
                    r3.setCallBackStrategyUuid(r4)
                    com.beizi.fusion.work.splash.a r3 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.work.splash.a.K(r3)
                L82:
                    com.beizi.fusion.work.splash.a r3 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.work.splash.a.L(r3)
                    if (r1 == 0) goto L8c
                    if (r2 != 0) goto L8c
                    return
                L8c:
                    com.beizi.fusion.work.splash.a r1 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.work.splash.a.c(r1, r0)
                    com.beizi.fusion.work.splash.a r0 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.c.d r0 = com.beizi.fusion.work.splash.a.M(r0)
                    if (r0 == 0) goto Lad
                    com.beizi.fusion.work.splash.a r0 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.c.d r0 = com.beizi.fusion.work.splash.a.N(r0)
                    com.beizi.fusion.work.splash.a r1 = com.beizi.fusion.work.splash.a.this
                    java.lang.String r1 = r1.f()
                    r0.d(r1)
                    com.beizi.fusion.work.splash.a r0 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.work.splash.a.O(r0)
                Lad:
                    com.beizi.fusion.work.splash.a r0 = com.beizi.fusion.work.splash.a.this
                    com.beizi.fusion.work.splash.a.P(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.splash.a.AnonymousClass1.e():void");
            }

            @Override // com.beizi.ad.a
            public void a(int i6) {
                a.this.a(String.valueOf(i6), i6);
            }

            @Override // com.beizi.ad.a
            public void a(long j6) {
                try {
                    if (!this.f14278a) {
                        a.this.aK();
                        this.f14278a = true;
                    }
                    if (a.this.K) {
                        if (a.this.J > 0 && a.this.J <= a.this.H) {
                            if (a.this.C) {
                                if (a.this.I <= 0 || j6 <= a.this.I) {
                                    a.this.G = false;
                                    a.this.f14276y.setAlpha(1.0f);
                                } else {
                                    a.this.G = true;
                                    a.this.f14276y.setAlpha(0.2f);
                                }
                            }
                            if (a.this.J == a.this.H) {
                                a.this.f14276y.setEnabled(false);
                            } else {
                                a.this.f14276y.setEnabled(true);
                            }
                        }
                        a.this.d(Math.round(j6 / 1000.0f));
                    }
                    if (((com.beizi.fusion.work.a) a.this).f14055d == null || ((com.beizi.fusion.work.a) a.this).f14055d.o() == 2) {
                        return;
                    }
                    ((com.beizi.fusion.work.a) a.this).f14055d.a(j6);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        };
        com.beizi.ad.v2.g.a aVar2 = new com.beizi.ad.v2.g.a(this.f14270s, this.f14275x, null, this.f14060i);
        this.f14273v = aVar2;
        aVar2.a((int) this.f14272u);
        this.f14273v.a(this.f14056e);
        try {
            this.f14273v.a(this.f14053b.m86clone());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f14273v.a(10, 20, 10, 10);
        this.f14273v.a(true);
        this.f14273v.a(aVar);
        this.f14273v.a(ap.a(this.f14270s, this.ao), ap.a(this.f14270s, this.ap));
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equals(g())) {
            this.f14273v.c(g());
            d dVar = this.f14055d;
            if (dVar != null) {
                String w5 = dVar.w();
                if (!TextUtils.isEmpty(w5)) {
                    this.f14273v.b(w5);
                }
            }
        }
        d dVar2 = this.f14055d;
        if (dVar2 != null) {
            this.f14273v.c(dVar2.x());
        }
        this.f14273v.c();
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        super.l();
        com.beizi.ad.v2.g.a aVar = this.f14273v;
        if (aVar != null) {
            aVar.f();
            this.f14273v = null;
        }
    }

    @Override // com.beizi.fusion.work.a
    protected void z() {
        if (!y() || this.f14273v == null) {
            return;
        }
        ag();
    }

    public a(Context context, String str, long j6, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, int i6, int i7, d dVar) {
        this.f14270s = context;
        this.f14271t = str;
        this.f14272u = j6;
        this.f14274w = viewGroup;
        this.f14056e = buyerBean;
        this.f14057f = forwardBean;
        this.f14055d = dVar;
        this.f14275x = new SplashContainer(context);
        this.f14276y = view;
        this.f14277z = list;
        this.ao = i6;
        this.ap = i7;
        r();
    }

    private void aC() {
        View aH = aH();
        if (this.L != null) {
            this.f14274w.addView(this.L, new FrameLayout.LayoutParams(-2, -2));
        }
        this.f14273v.a(aH);
        aI();
        if (this.K) {
            aG();
        }
    }

    private boolean c(long j6) {
        try {
            return System.currentTimeMillis() - ap.o(this.f14270s).longValue() < j6;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f14055d == null) {
            return;
        }
        this.f14059h = this.f14056e.getAppId();
        this.f14060i = this.f14056e.getSpaceId();
        this.f14054c = this.f14056e.getBuyerSpaceUuId();
        this.X = "splash_cool_" + this.f14060i;
        this.ar = this.f14056e.getMinShowTime();
        aa.b("BeiZis", "AdWorker chanel = " + this.f14054c);
        com.beizi.fusion.events.b bVar = this.f14052a;
        if (bVar != null) {
            EventBean a6 = bVar.a().a(this.f14054c);
            this.f14053b = a6;
            if (a6 != null) {
                s();
                t();
                l.a(this.f14270s, this.f14059h);
                u();
            }
        }
        long sleepTime = this.f14057f.getSleepTime();
        if (this.f14055d.q()) {
            sleepTime = Math.max(sleepTime, this.f14057f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f14277z;
        boolean z5 = list != null && list.size() > 0;
        this.K = z5;
        if (z5) {
            aF();
        }
        f();
        if (sleepTime > 0) {
            this.f14064m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            d dVar = this.f14055d;
            if (dVar != null && dVar.p() < 1 && this.f14055d.o() != 2) {
                k();
            }
        }
        this.O = ap.k(this.f14270s);
        this.P = ap.l(this.f14270s);
        this.ac = new ag(this.f14270s);
        this.ad = new aj(this.f14270s);
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        f();
        try {
            aA();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    private boolean b(long j6) {
        long longValue = ((Long) an.b(this.f14270s, this.X, 0L)).longValue();
        return longValue != 0 && System.currentTimeMillis() - longValue < j6;
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean c(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }

    private AdSpacesBean.BuyerBean.OrderDataRollViewBean e(List<AdSpacesBean.BuyerBean.OrderDataRollViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRollViewBean orderDataRollViewBean : list) {
                List<String> orderList = orderDataRollViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRollViewBean;
                }
            }
        }
        return null;
    }

    private boolean b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean != null) {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean.getAliaseShakeView();
            if (aliaseShakeView == null || aliaseShakeView.getPassivationTime() <= 0) {
                return false;
            }
            return aliaseShakeView.getShakeCount() > 0 || aliaseShakeView.getRotatCount() > 0;
        }
        AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = this.f14265n.getAliaseShakeView();
        if (this.f14265n.getAliaseShakeView() == null || aliaseShakeView2.getPassivationTime() <= 0) {
            return false;
        }
        return aliaseShakeView2.getShakeCount() > 0 || aliaseShakeView2.getRotatCount() > 0;
    }

    @Override // com.beizi.fusion.work.a
    protected void a(Message message) {
        EventBean eventBean = this.f14053b;
        if (eventBean != null) {
            int i6 = message.what;
            if (this.aq) {
                i6 = 10180;
            }
            eventBean.setError(String.valueOf(i6));
            this.f14053b.setErrorCode(String.valueOf(i6));
            ao();
            A();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean b(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean : list) {
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = shakeViewBean != null ? shakeViewBean : this.f14265n;
        int regulatoryAngle = shakeViewBean2.getRegulatoryAngle();
        al alVar = this.ab;
        if (alVar != null) {
            alVar.h(regulatoryAngle);
        }
        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.W;
        if (coolShakeViewBean == null) {
            if (b(shakeViewBean)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean2.getAliaseShakeView();
                if (aliaseShakeView != null) {
                    this.ab.a(aliaseShakeView);
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.Y = true;
                            a.this.ab.a(shakeViewBean2);
                        }
                    }, af.b(aliaseShakeView.getPassivationTime()));
                    return;
                }
                return;
            }
            this.Y = true;
            this.ab.a(shakeViewBean2);
            return;
        }
        if (b(coolShakeViewBean.getCoolTime())) {
            this.Z = this.W.getFeedback();
            this.ab.a(this.W);
            return;
        }
        if (c(this.W.getUserProtectTime())) {
            this.Z = this.W.getFeedback();
            this.ab.a(this.W);
        } else {
            if (b(shakeViewBean)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = shakeViewBean2.getAliaseShakeView();
                if (aliaseShakeView2 != null) {
                    this.ab.a(aliaseShakeView2);
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.Y = true;
                            a.this.ab.a(shakeViewBean2);
                        }
                    }, af.b(aliaseShakeView2.getPassivationTime()));
                    return;
                }
                return;
            }
            this.Y = true;
            this.ab.a(shakeViewBean2);
        }
    }

    @Override // com.beizi.fusion.tool.al.a
    public void b() {
        if (this.Y && this.W != null) {
            an.a(this.f14270s, this.X, (Object) Long.valueOf(System.currentTimeMillis()));
        }
        this.aa = "shake";
        this.f14053b.setClickType("shake");
        ao();
        aa.a("BeiZis", "enter onShakeHappened  ");
        a("", "", "", "", "", "", "", "", 2);
    }

    @Override // com.beizi.fusion.tool.aj.a
    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.aa = "scroll";
        this.f14053b.setClickType("scroll");
        ao();
        aa.a("BeiZis", "enter onScrollDistanceMeetByPosition ");
        a(str, str2, str3, str4, str5, str6, str7, str8, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean d(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean : list) {
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i6) {
        if (this.R == 1) {
            String valueOf = String.valueOf(i6);
            String str = this.T + " ";
            String str2 = str + valueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.U)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.V)), str2.indexOf(valueOf), str2.length(), 33);
            ((SkipView) this.f14276y).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.T);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.U)), 0, this.T.length(), 33);
        ((SkipView) this.f14276y).setText(spannableString2);
    }

    @Override // com.beizi.fusion.work.a
    public void b(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            com.beizi.ad.v2.g.a aVar = this.f14273v;
            if (aVar == null) {
                return;
            }
            aVar.b(map);
            if (map.containsKey("winPrice") && (obj3 = map.get("winPrice")) != null && (obj3 instanceof String)) {
                String str = (String) obj3;
                if (!TextUtils.isEmpty(str)) {
                    this.f14053b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj2 = map.get("adnId")) != null && (obj2 instanceof String)) {
                String str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    this.f14053b.setAdnId(str2);
                }
            }
            if (map.containsKey("lossReason") && (obj = map.get("lossReason")) != null && (obj instanceof String)) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    this.f14053b.setLossReason(str3);
                }
            }
            ao();
            N();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, View view) {
        if (this.Z == -1) {
            this.Z = this.f14265n.getFeedback();
            if (shakeViewBean != null) {
                this.Z = shakeViewBean.getFeedback();
            }
        }
        if (this.Z == 0 || view == null || this.ab == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ShakeArcView shakeArcView = new ShakeArcView(this.f14270s);
            shakeArcView.setLineRadius(5);
            int i6 = (int) (r9.width * 0.5d);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i6, i6);
            layoutParams2.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (((r9.width - i6) - 12) / 2);
            layoutParams2.topMargin = (int) (r9.topMargin + (r9.height * 0.08d));
            this.f14274w.addView(shakeArcView, layoutParams2);
            this.ab.a(shakeArcView, this.Z);
        }
    }

    private void a(final String str, int i6, final aj.a aVar) {
        final int a6 = ap.a(this.f14270s, i6);
        this.f14273v.b(new View.OnTouchListener() { // from class: com.beizi.fusion.work.splash.a.9

            /* renamed from: a, reason: collision with root package name */
            float f14304a;

            /* renamed from: b, reason: collision with root package name */
            float f14305b;

            /* renamed from: c, reason: collision with root package name */
            float f14306c;

            /* renamed from: d, reason: collision with root package name */
            float f14307d;

            /* renamed from: e, reason: collision with root package name */
            float f14308e;

            /* renamed from: f, reason: collision with root package name */
            float f14309f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                aj.a aVar2;
                aj.a aVar3;
                aj.a aVar4;
                aj.a aVar5;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f14304a = motionEvent.getX();
                    this.f14305b = motionEvent.getY();
                    this.f14306c = motionEvent.getX();
                    this.f14307d = motionEvent.getY();
                    this.f14308e = motionEvent.getRawX();
                    this.f14309f = motionEvent.getRawY();
                } else if (action == 1) {
                    aa.b("ScrollClickUtil", "mCurPosX = " + this.f14306c + ",mCurPosY = " + this.f14307d + ",mPosX = " + this.f14304a + ",mPosY = " + this.f14305b);
                    float f6 = this.f14307d;
                    float f7 = this.f14305b;
                    if (f6 - f7 <= 0.0f || Math.abs(f6 - f7) <= a6) {
                        float f8 = this.f14307d;
                        float f9 = this.f14305b;
                        if (f8 - f9 >= 0.0f || Math.abs(f8 - f9) <= a6) {
                            float f10 = this.f14306c;
                            float f11 = this.f14304a;
                            if (f10 - f11 >= 0.0f || Math.abs(f10 - f11) <= a6) {
                                float f12 = this.f14306c;
                                float f13 = this.f14304a;
                                if (f12 - f13 > 0.0f && Math.abs(f12 - f13) > a6 && "right".equalsIgnoreCase(str) && (aVar2 = aVar) != null) {
                                    aVar2.b(this.f14304a + "", this.f14305b + "", this.f14308e + "", this.f14309f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else if (ScrollClickView.DIR_LEFT.equalsIgnoreCase(str) && (aVar3 = aVar) != null) {
                                aVar3.b(this.f14304a + "", this.f14305b + "", this.f14308e + "", this.f14309f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else if ("up".equalsIgnoreCase(str) && (aVar4 = aVar) != null) {
                            aVar4.b(this.f14304a + "", this.f14305b + "", this.f14308e + "", this.f14309f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(str) && (aVar5 = aVar) != null) {
                        aVar5.b(this.f14304a + "", this.f14305b + "", this.f14308e + "", this.f14309f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                    }
                } else if (action == 2) {
                    this.f14306c = motionEvent.getX();
                    this.f14307d = motionEvent.getY();
                }
                return true;
            }
        });
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.tool.ag.a
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.aa = "regionalClick";
        this.f14053b.setClickType("regionalClick");
        ao();
        aa.a("BeiZis", "enter onRegionClickByPosition ");
        a(str, str2, str3, str4, str5, str6, str7, str8, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i6) {
        com.beizi.ad.v2.g.a aVar = this.f14273v;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4, str5, str6, str7, str8, i6);
        }
    }

    private void a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean = this.af;
        if (coolRollViewBean == null) {
            this.Y = true;
            this.ag.a(rollViewBean);
        } else if (b(coolRollViewBean.getCoolTime())) {
            this.ag.a(this.af);
        } else if (c(this.af.getUserProtectTime())) {
            this.ag.a(this.af);
        } else {
            this.Y = true;
            this.ag.a(rollViewBean);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            com.beizi.ad.v2.g.a aVar = this.f14273v;
            if (aVar == null) {
                return;
            }
            aVar.a(map);
            if (map.containsKey("winPrice") && (obj4 = map.get("winPrice")) != null && (obj4 instanceof String)) {
                String str = (String) obj4;
                if (!TextUtils.isEmpty(str)) {
                    this.f14053b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj3 = map.get("adnId")) != null && (obj3 instanceof String)) {
                String str2 = (String) obj3;
                if (!TextUtils.isEmpty(str2)) {
                    this.f14053b.setAdnId(str2);
                }
            }
            if (map.containsKey("highestLossPrice") && (obj2 = map.get("highestLossPrice")) != null && (obj2 instanceof String)) {
                String str3 = (String) obj2;
                if (!TextUtils.isEmpty(str3)) {
                    this.f14053b.setHighestLossPrice(str3);
                }
            }
            if (map.containsKey("auctionExt") && (obj = map.get("auctionExt")) != null && (obj instanceof String)) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    this.f14053b.setSecondPrice(str4);
                }
            }
            ao();
            M();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
