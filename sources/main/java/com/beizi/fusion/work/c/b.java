package com.beizi.fusion.work.c;

import android.R;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.beizi.ad.h;
import com.beizi.ad.i;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.e.f;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.v2.d.c;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.l;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import com.beizi.fusion.tool.ab;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.ak;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.ar;
import com.beizi.fusion.widget.ScrollClickView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends a {
    private String A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private View H;
    private String I;
    private boolean J;
    private boolean K;
    private Boolean L;
    private boolean M;
    private long N;
    private long O;
    private long P;
    private boolean Q;
    private boolean R;
    private long S;
    private int T;
    private int U;
    private FrameLayout V;
    private boolean W;
    private String[] X;
    private long Y;
    private String Z;
    private boolean aa;
    private boolean ab;
    private String ac;
    private boolean ad;
    private boolean ae;
    private ViewGroup af;
    private FrameLayout ag;
    private long ah;
    private boolean ai;
    private ViewTreeObserver.OnScrollChangedListener aj;
    private ViewTreeObserver.OnScrollChangedListener ak;

    /* renamed from: v, reason: collision with root package name */
    private c f14189v;

    /* renamed from: w, reason: collision with root package name */
    private i f14190w;

    /* renamed from: x, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ShakeViewBean f14191x;

    /* renamed from: y, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f14192y;

    /* renamed from: z, reason: collision with root package name */
    private ab f14193z;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b8, code lost:
    
        r9.D = com.beizi.fusion.tool.af.a(java.lang.Integer.parseInt(r11.getRate()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(android.content.Context r10, long r11, long r13, com.beizi.fusion.model.AdSpacesBean.BuyerBean r15, com.beizi.fusion.model.AdSpacesBean.ForwardBean r16, com.beizi.fusion.c.d r17, int r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.c.b.<init>(android.content.Context, long, long, com.beizi.fusion.model.AdSpacesBean$BuyerBean, com.beizi.fusion.model.AdSpacesBean$ForwardBean, com.beizi.fusion.c.d, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        ab abVar;
        AdSpacesBean.BuyerBean buyerBean;
        try {
            this.Q = true;
            this.aa = false;
            this.ab = false;
            aT();
            if (this.C && (buyerBean = this.f14056e) != null) {
                this.f14053b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
                ao();
            }
            E();
            if (!this.C || this.D) {
                d dVar = this.f14055d;
                if (dVar != null && dVar.o() != 2) {
                    this.f14055d.d(f());
                }
                D();
                ad();
                if (this.G != 0 && (abVar = this.f14193z) != null && this.H != null) {
                    abVar.c();
                    this.H.setVisibility(8);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private boolean aP() {
        try {
            return System.currentTimeMillis() - ap.o(((a) this).f14180n).longValue() < this.f14192y.getUserProtectTime();
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    @Override // com.beizi.fusion.work.c.a
    public int aE() {
        return 1;
    }

    @Override // com.beizi.fusion.work.c.a
    public boolean aG() {
        return false;
    }

    @Override // com.beizi.fusion.work.c.a
    public UnifiedAdDownloadAppInfo aL() {
        try {
            ApkBean n6 = this.f14190w.n();
            if (n6 == null) {
                return null;
            }
            UnifiedAdDownloadAppInfo unifiedAdDownloadAppInfo = new UnifiedAdDownloadAppInfo();
            unifiedAdDownloadAppInfo.setAppName(n6.getApkName());
            unifiedAdDownloadAppInfo.setAppVersion(n6.getAppVersion());
            unifiedAdDownloadAppInfo.setAppDeveloper(n6.getAppDeveloper());
            String appPermissionsUrl = n6.getAppPermissionsUrl();
            if (TextUtils.isEmpty(appPermissionsUrl)) {
                String appPermissionsDesc = n6.getAppPermissionsDesc();
                if (!TextUtils.isEmpty(appPermissionsDesc)) {
                    unifiedAdDownloadAppInfo.setAppPermission(appPermissionsDesc);
                }
            } else {
                unifiedAdDownloadAppInfo.setAppPermission(appPermissionsUrl);
            }
            if (!TextUtils.isEmpty(n6.getAppPrivacyUrl())) {
                unifiedAdDownloadAppInfo.setAppPrivacy(n6.getAppPrivacyUrl());
            }
            unifiedAdDownloadAppInfo.setAppIntro(n6.getAppintro());
            return unifiedAdDownloadAppInfo;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private boolean aQ() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f14191x;
        if (shakeViewBean == null) {
            return false;
        }
        return af.a(shakeViewBean.getRenderRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR() {
        View a6;
        try {
            i iVar = this.f14190w;
            if (iVar == null || this.K || iVar.n() == null || (a6 = f.a(((a) this).f14180n, this.f14190w)) == null) {
                return;
            }
            a6.setLayoutParams(new FrameLayout.LayoutParams((((a) this).f14185s.getLayoutParams().width * 2) / 3, -2));
            ((a) this).f14185s.addView(a6, new FrameLayout.LayoutParams(-2, -2, 51));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void aS() {
        try {
            if (this.R && ((a) this).f14185s != null && ((a) this).f14180n != null) {
                this.V = new FrameLayout(((a) this).f14180n);
                int width = ((a) this).f14185s.getWidth();
                int height = ((a) this).f14185s.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.V.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.V.setBackgroundColor(Color.parseColor(this.ac));
                ((a) this).f14185s.addView(this.V);
                this.V.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.c.b.10
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            b.this.W = true;
                            b.this.X[0] = motionEvent.getX() + "";
                            b.this.X[1] = motionEvent.getY() + "";
                            b.this.X[2] = motionEvent.getRawX() + "";
                            b.this.X[3] = motionEvent.getRawY() + "";
                        }
                        return false;
                    }
                });
                this.V.getViewTreeObserver().addOnScrollChangedListener(this.aj);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void aT() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        try {
            FrameLayout frameLayout3 = this.V;
            if (frameLayout3 != null && this.aj != null) {
                frameLayout3.getViewTreeObserver().removeOnScrollChangedListener(this.aj);
            }
            FrameLayout frameLayout4 = ((a) this).f14185s;
            if (frameLayout4 != null && (frameLayout2 = this.V) != null) {
                frameLayout4.removeView(frameLayout2);
                this.V = null;
            }
            FrameLayout frameLayout5 = ((a) this).f14185s;
            if (frameLayout5 != null && this.ak != null) {
                frameLayout5.getViewTreeObserver().removeOnScrollChangedListener(this.ak);
            }
            ViewGroup viewGroup = this.af;
            if (viewGroup == null || (frameLayout = this.ag) == null) {
                return;
            }
            viewGroup.removeView(frameLayout);
            this.ag = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void aU() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (((a) this).f14185s != null && ((a) this).f14180n != null && (buyerBean = this.f14056e) != null) {
                if ((this.ad || this.ae) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && af.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = ((a) this).f14185s.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
                    this.af = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int m6 = ap.m(((a) this).f14180n);
                    int n6 = ap.n(((a) this).f14180n);
                    int width2 = ((a) this).f14185s.getWidth();
                    int height2 = ((a) this).f14185s.getHeight();
                    int[] iArr = new int[2];
                    ((a) this).f14185s.getLocationOnScreen(iArr);
                    int i6 = iArr[0];
                    int i7 = iArr[1];
                    int i8 = -1;
                    if (reference == 0) {
                        m6 = width2;
                        n6 = height2;
                    } else if (reference != 1) {
                        m6 = -1;
                        n6 = -1;
                    }
                    try {
                        if (!TextUtils.isEmpty(width)) {
                            m6 = width.endsWith("%") ? (Integer.parseInt(width.substring(0, width.indexOf("%"))) * m6) / 100 : Integer.parseInt(width);
                        }
                        if (!TextUtils.isEmpty(height)) {
                            n6 = height.endsWith("%") ? (Integer.parseInt(height.substring(0, height.indexOf("%"))) * n6) / 100 : Integer.parseInt(height);
                        }
                    } catch (NumberFormatException e6) {
                        e6.printStackTrace();
                    }
                    if (m6 < 0) {
                        m6 = -1;
                    }
                    if (n6 >= 0) {
                        i8 = n6;
                    }
                    this.ag = new FrameLayout(((a) this).f14180n);
                    this.ag.setLayoutParams(new FrameLayout.LayoutParams(m6, i8));
                    int a6 = a(horizontalSpace, m6, width2, i6);
                    int b6 = b(verticalSpace, i8, height2, i7);
                    int a7 = ap.a(((a) this).f14180n, 25.0f);
                    if (b6 > a7) {
                        b6 -= a7;
                    }
                    this.ag.setX(a6);
                    this.ag.setY(b6);
                    this.ag.setBackgroundColor(Color.parseColor(this.ac));
                    this.af.addView(this.ag);
                    final float[] fArr = new float[4];
                    this.ag.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.c.b.12
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            try {
                                if (motionEvent.getAction() == 0) {
                                    fArr[0] = motionEvent.getX();
                                    fArr[1] = motionEvent.getY();
                                    fArr[2] = motionEvent.getRawX();
                                    fArr[3] = motionEvent.getRawY();
                                    if (b.this.ad) {
                                        b bVar = b.this;
                                        FrameLayout frameLayout = bVar.ag;
                                        FrameLayout frameLayout2 = ((a) b.this).f14185s;
                                        float[] fArr2 = fArr;
                                        b.this.a(bVar.a(frameLayout, frameLayout2, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                                    }
                                }
                                if (motionEvent.getAction() == 1 && b.this.ae) {
                                    b bVar2 = b.this;
                                    FrameLayout frameLayout3 = bVar2.ag;
                                    FrameLayout frameLayout4 = ((a) b.this).f14185s;
                                    float[] fArr3 = fArr;
                                    b.this.a(bVar2.a(frameLayout3, frameLayout4, fArr3[0], fArr3[1], fArr3[2], fArr3[3]), 0);
                                }
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                            if (!b.this.ad) {
                                if (!b.this.ae) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    });
                    ((a) this).f14185s.getViewTreeObserver().addOnScrollChangedListener(this.ak);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.c.a
    public String aA() {
        ArrayList<String> j6;
        i iVar = this.f14190w;
        if (iVar == null || TextUtils.isEmpty(iVar.c())) {
            return null;
        }
        String c6 = this.f14190w.c();
        return (!TextUtils.isEmpty(c6) || (j6 = this.f14190w.j()) == null || j6.size() < 2) ? c6 : j6.get(1);
    }

    @Override // com.beizi.fusion.work.c.a
    public String aB() {
        i iVar = this.f14190w;
        if (iVar == null || TextUtils.isEmpty(iVar.d())) {
            return null;
        }
        return this.f14190w.d();
    }

    @Override // com.beizi.fusion.work.c.a
    public String aC() {
        i iVar = this.f14190w;
        if (iVar == null || TextUtils.isEmpty(iVar.b())) {
            return null;
        }
        return this.f14190w.b();
    }

    @Override // com.beizi.fusion.work.c.a
    public List<String> aD() {
        i iVar = this.f14190w;
        if (iVar == null) {
            return null;
        }
        if ((iVar.i() != null) && (this.f14190w.i().size() > 0)) {
            return this.f14190w.i();
        }
        return null;
    }

    @Override // com.beizi.fusion.work.c.a
    public String aF() {
        String str;
        ArrayList<String> j6;
        i iVar = this.f14190w;
        if (iVar != null) {
            str = iVar.e();
            if (TextUtils.isEmpty(str) && (j6 = this.f14190w.j()) != null && j6.size() >= 3) {
                str = j6.get(2);
            }
        } else {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "查看详情" : str;
    }

    @Override // com.beizi.fusion.work.c.a
    public ViewGroup aH() {
        return ((a) this).f14185s;
    }

    @Override // com.beizi.fusion.work.c.a
    public void aJ() {
        try {
            if (this.f14190w == null || this.J) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(((a) this).f14180n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout a6 = u.a(((a) this).f14180n, this.f14190w.l());
            a6.setVisibility(0);
            linearLayout.addView(a6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View b6 = u.b(((a) this).f14180n, this.f14190w.k());
            b6.setVisibility(0);
            linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b6.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            b6.setLayoutParams(layoutParams);
            ((a) this).f14185s.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int a7 = ap.a(((a) this).f14180n, 6.0f);
            layoutParams2.setMargins(0, 0, a7, a7);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.c.a
    public String aK() {
        if (this.f14189v == null) {
            return null;
        }
        try {
            c.a l6 = this.f14190w.l();
            if (l6 == null) {
                return null;
            }
            return l6.a();
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        com.beizi.ad.v2.d.c cVar = this.f14189v;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        com.beizi.ad.v2.d.c cVar = this.f14189v;
        if (cVar == null) {
            return null;
        }
        return cVar.m();
    }

    @Override // com.beizi.fusion.work.c.a
    public void ay() {
        ((a) this).f14185s = new FrameLayout(((a) this).f14180n);
        com.beizi.ad.v2.d.c cVar = new com.beizi.ad.v2.d.c(((a) this).f14180n, this.f14060i, new h() { // from class: com.beizi.fusion.work.c.b.1
            @Override // com.beizi.ad.h
            public void a(i iVar) {
                ((com.beizi.fusion.work.a) b.this).f14061j = com.beizi.fusion.e.a.ADLOAD;
                b bVar = b.this;
                bVar.L = Boolean.valueOf(bVar.f14189v.l());
                b bVar2 = b.this;
                bVar2.M = bVar2.f14189v.i();
                if (b.this.M) {
                    b bVar3 = b.this;
                    bVar3.N = bVar3.f14189v.j();
                    ((com.beizi.fusion.work.a) b.this).f14053b.setIsCacheAd("1");
                    if (b.this.N > 0) {
                        ((com.beizi.fusion.work.a) b.this).f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - b.this.N));
                    }
                    b.this.ao();
                }
                if (b.this.f14189v.a() != null) {
                    try {
                        b bVar4 = b.this;
                        bVar4.a(Double.parseDouble(bVar4.f14189v.a()));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                b.this.x();
                if (iVar == null) {
                    b.this.c(-991);
                } else {
                    b.this.f14190w = iVar;
                    b.this.aM();
                }
            }

            @Override // com.beizi.ad.h
            public void a(int i6) {
                b.this.a(String.valueOf(i6), i6);
            }
        });
        this.f14189v = cVar;
        cVar.a(true);
        try {
            this.f14189v.a(this.f14053b.m86clone());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f14189v.a((int) this.O);
        this.f14189v.a(this.f14056e);
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equals(g())) {
            this.f14189v.c(g());
            d dVar = this.f14055d;
            if (dVar != null) {
                String w5 = dVar.w();
                if (!TextUtils.isEmpty(w5)) {
                    this.f14189v.b(w5);
                }
            }
        }
        d dVar2 = this.f14055d;
        if (dVar2 != null) {
            this.f14189v.c(dVar2.x());
        }
        this.f14189v.c();
    }

    @Override // com.beizi.fusion.work.c.a
    public String az() {
        ArrayList<String> j6;
        i iVar = this.f14190w;
        if (iVar == null) {
            return null;
        }
        String a6 = iVar.a();
        return (!TextUtils.isEmpty(a6) || (j6 = this.f14190w.j()) == null || j6.size() < 1) ? a6 : j6.get(0);
    }

    @Override // com.beizi.fusion.work.c.a, com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.a
    public String i() {
        com.beizi.ad.v2.d.c cVar = this.f14189v;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        i iVar = this.f14190w;
        if (iVar != null) {
            iVar.h();
        }
        com.beizi.ad.v2.d.c cVar = this.f14189v;
        if (cVar != null) {
            cVar.f();
        }
        ab abVar = this.f14193z;
        if (abVar != null) {
            abVar.c();
        }
        aT();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        ab abVar;
        try {
            if (!com.beizi.fusion.c.b.a().m() || (abVar = this.f14193z) == null) {
                return;
            }
            abVar.d();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void n() {
        ab abVar;
        try {
            if (!com.beizi.fusion.c.b.a().m() || (abVar = this.f14193z) == null) {
                return;
            }
            abVar.a(false);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    protected void z() {
        if (!y() || this.f14189v == null) {
            return;
        }
        ag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        this.Y = System.currentTimeMillis();
        float k6 = ap.k(((a) this).f14180n);
        int a6 = ap.a(((a) this).f14180n, 40.0f);
        if (this.E >= k6 / 4.0f && this.F >= a6) {
            this.f14061j = com.beizi.fusion.e.a.ADSHOW;
            if (this.M) {
                this.f14053b.setIsCacheAd("1");
                if (this.N > 0) {
                    this.f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - this.N));
                }
                ao();
            }
            d dVar = this.f14055d;
            if (dVar != null && dVar.o() != 2) {
                this.f14055d.b(f());
            }
            if (!((a) this).f14186t) {
                ((a) this).f14186t = true;
                B();
                C();
                ac();
            }
            aS();
            aU();
        }
    }

    @Override // com.beizi.fusion.work.c.a
    public void b() {
        t();
        l.a(((a) this).f14180n, this.f14059h);
        u();
        f();
        long j6 = ((a) this).f14181o;
        if (j6 > 0) {
            this.f14064m.sendEmptyMessageDelayed(1, j6);
            return;
        }
        d dVar = this.f14055d;
        if (dVar == null || dVar.p() >= 1 || this.f14055d.o() == 2) {
            return;
        }
        k();
    }

    private boolean b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long longValue = ((Long) an.b(((a) this).f14180n, this.A, 0L)).longValue();
        if (longValue != 0) {
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis < this.f14192y.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.c.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f14193z.a(shakeViewBean);
                    }
                }, this.f14192y.getCoolTime() - currentTimeMillis);
                return true;
            }
            ak.a().a(this.A);
        }
        return false;
    }

    @Override // com.beizi.fusion.work.c.a
    public void a(final List<View> list) {
        try {
            if (((a) this).f14185s != null) {
                aJ();
                ((a) this).f14185s.post(new Runnable() { // from class: com.beizi.fusion.work.c.b.5
                    /* JADX WARN: Removed duplicated region for block: B:17:0x0089 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:2:0x0000, B:4:0x0006, B:5:0x0037, B:7:0x003f, B:10:0x0048, B:12:0x004c, B:14:0x0052, B:15:0x0081, B:17:0x0089, B:22:0x0067, B:23:0x007a), top: B:1:0x0000 }] */
                    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void run() {
                        /*
                            r4 = this;
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            android.widget.FrameLayout r1 = r0.f14185s     // Catch: java.lang.Throwable -> L35
                            if (r1 == 0) goto L37
                            com.beizi.fusion.work.c.b.h(r0)     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            android.widget.FrameLayout r1 = r0.f14185s     // Catch: java.lang.Throwable -> L35
                            int r1 = r1.getWidth()     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b.b(r0, r1)     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            android.widget.FrameLayout r1 = r0.f14185s     // Catch: java.lang.Throwable -> L35
                            int r1 = r1.getHeight()     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b.c(r0, r1)     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            int r1 = com.beizi.fusion.work.c.b.i(r0)     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b r2 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            int r2 = com.beizi.fusion.work.c.b.j(r2)     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b r3 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            int r3 = com.beizi.fusion.work.c.b.j(r3)     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b.a(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L35
                            goto L37
                        L35:
                            r0 = move-exception
                            goto L9c
                        L37:
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            boolean r0 = com.beizi.fusion.work.c.b.k(r0)     // Catch: java.lang.Throwable -> L35
                            if (r0 != 0) goto L7a
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            boolean r0 = com.beizi.fusion.work.c.b.l(r0)     // Catch: java.lang.Throwable -> L35
                            if (r0 == 0) goto L48
                            goto L7a
                        L48:
                            java.util.List r0 = r2     // Catch: java.lang.Throwable -> L35
                            if (r0 == 0) goto L67
                            int r0 = r0.size()     // Catch: java.lang.Throwable -> L35
                            if (r0 <= 0) goto L67
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            com.beizi.ad.i r0 = com.beizi.fusion.work.c.b.m(r0)     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b r1 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            android.widget.FrameLayout r1 = r1.f14185s     // Catch: java.lang.Throwable -> L35
                            java.util.List r2 = r2     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b$5$1 r3 = new com.beizi.fusion.work.c.b$5$1     // Catch: java.lang.Throwable -> L35
                            r3.<init>()     // Catch: java.lang.Throwable -> L35
                            com.beizi.ad.internal.e.f.a(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L35
                            goto L81
                        L67:
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            com.beizi.ad.i r0 = com.beizi.fusion.work.c.b.m(r0)     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b r1 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            android.widget.FrameLayout r1 = r1.f14185s     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b$5$2 r2 = new com.beizi.fusion.work.c.b$5$2     // Catch: java.lang.Throwable -> L35
                            r2.<init>()     // Catch: java.lang.Throwable -> L35
                            com.beizi.ad.internal.e.f.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L35
                            goto L81
                        L7a:
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            java.util.List r1 = r2     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b.a(r0, r1)     // Catch: java.lang.Throwable -> L35
                        L81:
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            com.beizi.ad.v2.d.c r0 = com.beizi.fusion.work.c.b.a(r0)     // Catch: java.lang.Throwable -> L35
                            if (r0 == 0) goto L9b
                            com.beizi.fusion.work.c.b r0 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            com.beizi.ad.v2.d.c r0 = com.beizi.fusion.work.c.b.a(r0)     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b r1 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Throwable -> L35
                            android.widget.FrameLayout r1 = r1.f14185s     // Catch: java.lang.Throwable -> L35
                            com.beizi.fusion.work.c.b$5$3 r2 = new com.beizi.fusion.work.c.b$5$3     // Catch: java.lang.Throwable -> L35
                            r2.<init>()     // Catch: java.lang.Throwable -> L35
                            r0.a(r1, r2)     // Catch: java.lang.Throwable -> L35
                        L9b:
                            return
                        L9c:
                            r0.printStackTrace()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.c.b.AnonymousClass5.run():void");
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
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

    @Override // com.beizi.fusion.work.a
    public void b(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            com.beizi.ad.v2.d.c cVar = this.f14189v;
            if (cVar == null) {
                return;
            }
            cVar.b(map);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i6, final int i7, int i8) {
        try {
            if (!com.beizi.fusion.c.b.a().n() && aQ()) {
                if (this.f14193z == null) {
                    this.f14193z = new ab(((a) this).f14180n);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f14191x;
                if (shakeViewBean == null || this.f14193z == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setShakeViewUuid(this.f14191x.getShakeViewUuid());
                    ao();
                }
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean a6 = a(this.f14191x.getOrderData(), this.f14189v.b());
                AdSpacesBean.BuyerBean.ShakeViewBean shakeView = (a6 == null || a6.getShakeView() == null) ? null : a6.getShakeView();
                if (i7 <= 0) {
                    i7 = i8;
                }
                this.f14193z.a(this.L);
                View a7 = this.f14193z.a(ap.b(((a) this).f14180n, i6), ap.b(((a) this).f14180n, i7), this.f14191x.getPosition(), this.I);
                this.H = a7;
                if (a7 != null) {
                    ViewGroup.LayoutParams layoutParams = a7.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f14191x;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            ((a) this).f14185s.addView(this.H, layoutParams2);
                        }
                    }
                }
                a(shakeView);
                this.f14193z.a(new ab.a() { // from class: com.beizi.fusion.work.c.b.6
                    @Override // com.beizi.fusion.tool.ab.a
                    public void a() {
                        try {
                            if (ar.a(((a) b.this).f14185s) && !b.this.aa) {
                                b.this.Q = true;
                                b.this.aa = true;
                                int[] iArr = new int[2];
                                ((a) b.this).f14185s.getLocationOnScreen(iArr);
                                int[] a8 = af.a(i6 / 2, i7 / 2);
                                if (b.this.f14190w != null) {
                                    b bVar = b.this;
                                    if (((a) bVar).f14185s != null) {
                                        bVar.f14190w.a(((a) b.this).f14185s, String.valueOf(a8[0]), String.valueOf(a8[1]), String.valueOf(a8[0] + iArr[0]), String.valueOf(a8[1] + iArr[1]), 2, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.c.b.6.1
                                            @Override // com.beizi.ad.internal.e.b
                                            public void a() {
                                                b.this.aO();
                                            }

                                            @Override // com.beizi.ad.internal.e.b
                                            public void b() {
                                            }
                                        });
                                    }
                                }
                                if (!b.this.B || b.this.f14192y == null) {
                                    return;
                                }
                                b.this.B = false;
                                b.this.f14193z.a(b.this.f14192y);
                                b bVar2 = b.this;
                                an.a(((a) bVar2).f14180n, bVar2.A, (Object) Long.valueOf(System.currentTimeMillis()));
                                ak.a().a(b.this.A, System.currentTimeMillis());
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f14192y;
                if (coolShakeViewBean != null) {
                    this.f14193z.a(coolShakeViewBean, this.A);
                }
                this.f14193z.a(((a) this).f14185s);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private int b(String str, int i6, int i7, int i8) {
        int i9;
        int i10;
        try {
            if (TextUtils.isEmpty(str)) {
                return i8;
            }
            if (!"top".equals(str)) {
                if (AutoScrollViewPager.f4187g.equals(str)) {
                    if (i6 > i7) {
                        i10 = (i6 - i7) / 2;
                        i8 -= i10;
                    } else {
                        i9 = (i7 - i6) / 2;
                        i8 += i9;
                    }
                } else if (!"bottom".equals(str)) {
                    i8 = 0;
                } else if (i6 > i7) {
                    i10 = i6 - i7;
                    i8 -= i10;
                } else {
                    i9 = i7 - i6;
                    i8 += i9;
                }
            }
            if (i8 < 0) {
                return 0;
            }
            return i8;
        } catch (Exception e6) {
            e6.printStackTrace();
            return i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<View> list) {
        FrameLayout frameLayout;
        if (list == null || list.size() == 0) {
            list = new ArrayList<>();
        }
        if (this.ai && (frameLayout = ((a) this).f14185s) != null) {
            list.add(frameLayout);
        }
        if (list.size() == 0) {
            return;
        }
        for (final View view : list) {
            if (view != null) {
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.c.b.3

                    /* renamed from: a, reason: collision with root package name */
                    String[] f14200a = new String[4];

                    /* JADX WARN: Removed duplicated region for block: B:12:0x0091 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:3:0x0003, B:5:0x000a, B:7:0x0012, B:10:0x002b, B:12:0x0091, B:13:0x001e, B:15:0x0022, B:17:0x0028, B:18:0x0098, B:20:0x009e, B:22:0x00a6, B:23:0x00ad, B:25:0x00b5), top: B:2:0x0003 }] */
                    @Override // android.view.View.OnTouchListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
                        /*
                            r5 = this;
                            java.lang.String r6 = ""
                            r0 = 0
                            int r1 = r7.getAction()     // Catch: java.lang.Exception -> L1b
                            r2 = 1
                            if (r1 != 0) goto L98
                            com.beizi.fusion.work.c.b r1 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Exception -> L1b
                            boolean r1 = com.beizi.fusion.work.c.b.k(r1)     // Catch: java.lang.Exception -> L1b
                            if (r1 != 0) goto L1e
                            com.beizi.fusion.work.c.b r1 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Exception -> L1b
                            boolean r1 = com.beizi.fusion.work.c.b.l(r1)     // Catch: java.lang.Exception -> L1b
                            if (r1 == 0) goto L2b
                            goto L1e
                        L1b:
                            r6 = move-exception
                            goto Lbe
                        L1e:
                            android.view.View r1 = r2     // Catch: java.lang.Exception -> L1b
                            if (r1 == 0) goto L2b
                            android.view.ViewParent r1 = r1.getParent()     // Catch: java.lang.Exception -> L1b
                            if (r1 == 0) goto L2b
                            r1.requestDisallowInterceptTouchEvent(r2)     // Catch: java.lang.Exception -> L1b
                        L2b:
                            java.lang.String[] r1 = r5.f14200a     // Catch: java.lang.Exception -> L1b
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                            r3.<init>()     // Catch: java.lang.Exception -> L1b
                            float r4 = r7.getX()     // Catch: java.lang.Exception -> L1b
                            r3.append(r4)     // Catch: java.lang.Exception -> L1b
                            r3.append(r6)     // Catch: java.lang.Exception -> L1b
                            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1b
                            r1[r0] = r3     // Catch: java.lang.Exception -> L1b
                            java.lang.String[] r1 = r5.f14200a     // Catch: java.lang.Exception -> L1b
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                            r3.<init>()     // Catch: java.lang.Exception -> L1b
                            float r4 = r7.getY()     // Catch: java.lang.Exception -> L1b
                            r3.append(r4)     // Catch: java.lang.Exception -> L1b
                            r3.append(r6)     // Catch: java.lang.Exception -> L1b
                            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1b
                            r1[r2] = r3     // Catch: java.lang.Exception -> L1b
                            java.lang.String[] r1 = r5.f14200a     // Catch: java.lang.Exception -> L1b
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                            r3.<init>()     // Catch: java.lang.Exception -> L1b
                            float r4 = r7.getRawX()     // Catch: java.lang.Exception -> L1b
                            r3.append(r4)     // Catch: java.lang.Exception -> L1b
                            r3.append(r6)     // Catch: java.lang.Exception -> L1b
                            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1b
                            r4 = 2
                            r1[r4] = r3     // Catch: java.lang.Exception -> L1b
                            java.lang.String[] r1 = r5.f14200a     // Catch: java.lang.Exception -> L1b
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                            r3.<init>()     // Catch: java.lang.Exception -> L1b
                            float r4 = r7.getRawY()     // Catch: java.lang.Exception -> L1b
                            r3.append(r4)     // Catch: java.lang.Exception -> L1b
                            r3.append(r6)     // Catch: java.lang.Exception -> L1b
                            java.lang.String r6 = r3.toString()     // Catch: java.lang.Exception -> L1b
                            r3 = 3
                            r1[r3] = r6     // Catch: java.lang.Exception -> L1b
                            com.beizi.fusion.work.c.b r6 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Exception -> L1b
                            boolean r6 = com.beizi.fusion.work.c.b.k(r6)     // Catch: java.lang.Exception -> L1b
                            if (r6 == 0) goto L98
                            com.beizi.fusion.work.c.b r6 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Exception -> L1b
                            java.lang.String[] r1 = r5.f14200a     // Catch: java.lang.Exception -> L1b
                            com.beizi.fusion.work.c.b.a(r6, r1)     // Catch: java.lang.Exception -> L1b
                        L98:
                            int r6 = r7.getAction()     // Catch: java.lang.Exception -> L1b
                            if (r6 != r2) goto Lad
                            com.beizi.fusion.work.c.b r6 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Exception -> L1b
                            boolean r6 = com.beizi.fusion.work.c.b.l(r6)     // Catch: java.lang.Exception -> L1b
                            if (r6 == 0) goto Lad
                            com.beizi.fusion.work.c.b r6 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Exception -> L1b
                            java.lang.String[] r7 = r5.f14200a     // Catch: java.lang.Exception -> L1b
                            com.beizi.fusion.work.c.b.a(r6, r7)     // Catch: java.lang.Exception -> L1b
                        Lad:
                            com.beizi.fusion.work.c.b r6 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Exception -> L1b
                            boolean r6 = com.beizi.fusion.work.c.b.k(r6)     // Catch: java.lang.Exception -> L1b
                            if (r6 != 0) goto Lbd
                            com.beizi.fusion.work.c.b r6 = com.beizi.fusion.work.c.b.this     // Catch: java.lang.Exception -> L1b
                            boolean r6 = com.beizi.fusion.work.c.b.l(r6)     // Catch: java.lang.Exception -> L1b
                            if (r6 == 0) goto Lc1
                        Lbd:
                            return r2
                        Lbe:
                            r6.printStackTrace()
                        Lc1:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.c.b.AnonymousClass3.onTouch(android.view.View, android.view.MotionEvent):boolean");
                    }
                });
            }
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            try {
                shakeViewBean = this.f14191x;
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        ab abVar = this.f14193z;
        if (abVar != null) {
            abVar.c(regulatoryAngle);
        }
        if (this.f14192y == null) {
            this.B = true;
            this.f14193z.a(shakeViewBean);
        } else if (b(shakeViewBean)) {
            this.f14193z.a(this.f14192y);
        } else if (aP()) {
            this.f14193z.a(this.f14192y);
        } else {
            this.B = true;
            this.f14193z.a(shakeViewBean);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            com.beizi.ad.v2.d.c cVar = this.f14189v;
            if (cVar == null) {
                return;
            }
            cVar.a(map);
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

    @Override // com.beizi.fusion.work.c.a
    public void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.c.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ApkBean n6;
                try {
                    b bVar = b.this;
                    if (((a) bVar).f14180n == null || (n6 = bVar.f14190w.n()) == null) {
                        return;
                    }
                    String apkName = n6.getApkName();
                    String appPermissionsUrl = n6.getAppPermissionsUrl();
                    String appPermissionsDesc = n6.getAppPermissionsDesc();
                    if (TextUtils.isEmpty(appPermissionsUrl)) {
                        appPermissionsUrl = appPermissionsDesc;
                    }
                    String appPrivacyUrl = n6.getAppPrivacyUrl();
                    String appintro = n6.getAppintro();
                    Intent intent = new Intent(((a) b.this).f14180n, (Class<?>) DownloadAppInfoActivity.class);
                    intent.putExtra("title_content_key", apkName);
                    intent.putExtra("privacy_content_key", appPrivacyUrl);
                    intent.putExtra("permission_content_key", appPermissionsUrl);
                    intent.putExtra("intro_content_key", appintro);
                    intent.setFlags(268435456);
                    ((a) b.this).f14180n.startActivity(intent);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, int i6) {
        FrameLayout frameLayout;
        try {
            aT();
            if (this.f14190w != null && ((a) this).f14185s != null && !this.aa && !this.Q) {
                this.Q = true;
                this.aa = true;
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.Z);
                    ao();
                }
                i iVar = this.f14190w;
                if (iVar == null || (frameLayout = ((a) this).f14185s) == null) {
                    return;
                }
                iVar.a(frameLayout, strArr[0], strArr[1], strArr[2], strArr[3], i6, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.c.b.9
                    @Override // com.beizi.ad.internal.e.b
                    public void a() {
                        b.this.aO();
                    }

                    @Override // com.beizi.ad.internal.e.b
                    public void b() {
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private int a(String str, int i6, int i7, int i8) {
        int i9;
        int i10;
        try {
            if (TextUtils.isEmpty(str)) {
                return i8;
            }
            if (!ScrollClickView.DIR_LEFT.equals(str)) {
                if (AutoScrollViewPager.f4187g.equals(str)) {
                    if (i6 > i7) {
                        i10 = (i6 - i7) / 2;
                        i8 -= i10;
                    } else {
                        i9 = (i7 - i6) / 2;
                        i8 += i9;
                    }
                } else if (!"right".equals(str)) {
                    i8 = 0;
                } else if (i6 > i7) {
                    i10 = i6 - i7;
                    i8 -= i10;
                } else {
                    i9 = i7 - i6;
                    i8 += i9;
                }
            }
            if (i8 < 0) {
                return 0;
            }
            return i8;
        } catch (Exception e6) {
            e6.printStackTrace();
            return i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] a(View view, View view2, float f6, float f7, float f8, float f9) {
        String[] strArr = new String[0];
        try {
            String[] strArr2 = {f6 + "", f7 + "", f8 + "", f9 + ""};
            if (view == null || view2 == null) {
                return strArr2;
            }
            try {
                view.getLocationOnScreen(new int[2]);
                int width = view2.getWidth();
                int height = view2.getHeight();
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                int width2 = (width * ((int) ((f6 * 100.0d) / view.getWidth()))) / 100;
                int height2 = (height * ((int) ((f7 * 100.0d) / view.getHeight()))) / 100;
                int i6 = iArr[0] + width2;
                int i7 = iArr[1] + height2;
                strArr2[0] = width2 + "";
                strArr2[1] = height2 + "";
                strArr2[2] = i6 + "";
                strArr2[3] = i7 + "";
                return strArr2;
            } catch (Exception e6) {
                try {
                    e6.printStackTrace();
                    return strArr2;
                } catch (Exception e7) {
                    e = e7;
                    strArr = strArr2;
                    e.printStackTrace();
                    return strArr;
                }
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        FrameLayout frameLayout;
        try {
            aT();
            if (this.f14190w != null && ((a) this).f14185s != null && !this.aa) {
                this.Q = true;
                this.aa = true;
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.Z);
                    ao();
                }
                i iVar = this.f14190w;
                if (iVar == null || (frameLayout = ((a) this).f14185s) == null) {
                    return;
                }
                iVar.a(frameLayout, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.c.b.4
                    @Override // com.beizi.ad.internal.e.b
                    public void a() {
                        b.this.aO();
                    }

                    @Override // com.beizi.ad.internal.e.b
                    public void b() {
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
