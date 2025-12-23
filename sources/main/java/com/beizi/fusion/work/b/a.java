package com.beizi.fusion.work.b;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.beizi.ad.h;
import com.beizi.ad.i;
import com.beizi.ad.internal.e.e;
import com.beizi.ad.internal.e.f;
import com.beizi.ad.internal.h.i;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ab;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.ak;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.ar;
import com.beizi.fusion.widget.ScrollClickView;
import com.beizi.fusion.widget.dialog.dislike.a;
import com.beizi.fusion.work.splash.SplashContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.fusion.work.a implements com.beizi.fusion.c.c {
    protected ab A;
    protected AdSpacesBean.BuyerBean.DislikeConfigBean D;
    protected AdSpacesBean.BuyerBean.DislikeConfigBean E;
    protected i K;
    protected com.beizi.ad.v2.d.c L;
    protected View M;
    protected AdSpacesBean.ComplainBean N;
    protected Boolean R;
    protected int S;
    protected int T;
    protected boolean U;
    private boolean V;
    private long W;
    private long X;
    private boolean Y;
    private boolean Z;
    private long aa;
    private int ab;
    private int ac;
    private FrameLayout ad;
    private boolean ae;
    private long ag;
    private String ah;
    private boolean ai;
    private boolean ak;
    private boolean al;
    private ViewGroup am;
    private FrameLayout an;
    private long ao;

    /* renamed from: n, reason: collision with root package name */
    protected Context f14092n;

    /* renamed from: o, reason: collision with root package name */
    protected String f14093o;

    /* renamed from: p, reason: collision with root package name */
    protected long f14094p;

    /* renamed from: q, reason: collision with root package name */
    protected long f14095q;

    /* renamed from: r, reason: collision with root package name */
    protected float f14096r;

    /* renamed from: s, reason: collision with root package name */
    protected float f14097s;

    /* renamed from: t, reason: collision with root package name */
    protected ViewGroup f14098t;

    /* renamed from: u, reason: collision with root package name */
    protected View f14099u;

    /* renamed from: v, reason: collision with root package name */
    protected List<AdSpacesBean.RenderViewBean> f14100v;

    /* renamed from: w, reason: collision with root package name */
    protected AdSpacesBean.RenderViewBean f14101w;

    /* renamed from: x, reason: collision with root package name */
    protected List<Pair<String, Integer>> f14102x;

    /* renamed from: y, reason: collision with root package name */
    protected AdSpacesBean.BuyerBean.ShakeViewBean f14103y;

    /* renamed from: z, reason: collision with root package name */
    protected AdSpacesBean.BuyerBean.CoolShakeViewBean f14104z;
    protected String B = null;
    protected boolean C = false;
    protected float F = 0.0f;
    protected float G = 0.0f;
    protected float H = 0.0f;
    protected float I = 0.0f;
    protected String J = null;
    protected String O = null;
    protected boolean P = false;
    protected boolean Q = false;
    private String[] af = new String[4];
    private String aj = "#00000000";
    private ViewTreeObserver.OnScrollChangedListener ap = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.b.a.3
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (a.this.ae && !a.this.Y && !a.this.ai && System.currentTimeMillis() - a.this.ag >= a.this.aa && System.currentTimeMillis() - a.this.X >= 50) {
                    a.this.X = System.currentTimeMillis();
                    if (ar.a(a.this.f14099u, 0.8d)) {
                        int[] iArr = new int[2];
                        View view = a.this.f14099u;
                        if (view != null) {
                            view.getLocationOnScreen(iArr);
                        }
                        if (iArr[1] > 0 && a.this.ac == 0) {
                            a.this.ac = iArr[1];
                        }
                        if (Math.abs(a.this.ac - iArr[1]) < a.this.ab) {
                            return;
                        }
                        a aVar = a.this;
                        aVar.a(aVar.af, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private ViewTreeObserver.OnScrollChangedListener aq = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.b.a.5
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (a.this.f14098t != null && System.currentTimeMillis() - a.this.ao >= 50) {
                    a.this.ao = System.currentTimeMillis();
                    int[] iArr = new int[2];
                    a.this.f14098t.getLocationOnScreen(iArr);
                    if (iArr[1] < 0) {
                        a.this.f14098t.getViewTreeObserver().removeOnScrollChangedListener(this);
                        if (a.this.an == null || a.this.am == null) {
                            return;
                        }
                        a.this.am.removeView(a.this.an);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        AdSpacesBean.BuyerBean buyerBean;
        this.Y = true;
        this.ai = false;
        this.U = false;
        aK();
        if (this.P && (buyerBean = this.f14056e) != null) {
            this.f14053b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
            ao();
        }
        E();
        if (!this.P || this.Q) {
            com.beizi.fusion.c.d dVar = this.f14055d;
            if (dVar != null && dVar.o() != 2) {
                this.f14055d.d(f());
            }
            D();
            ad();
            com.beizi.ad.v2.d.c cVar = this.L;
            if (cVar != null) {
                cVar.o();
            }
        }
    }

    private boolean aF() {
        try {
            return System.currentTimeMillis() - ap.o(this.f14092n).longValue() < this.f14104z.getUserProtectTime();
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private boolean aH() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.E;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.D;
            return dislikeConfigBean2 != null && dislikeConfigBean2.getIsShowDialog() == 1;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return false;
    }

    public void a(i iVar) {
    }

    public void b() {
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
    }

    private void aG() {
        AdSpacesBean.BuyerBean.DislikeConfigBean b6;
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.f14056e.getDislikeConfig();
        this.D = dislikeConfig;
        if (dislikeConfig == null || (b6 = b(dislikeConfig.getOrderData(), this.L.b())) == null) {
            return;
        }
        this.E = b6;
    }

    private boolean aI() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f14103y;
        if (shakeViewBean == null) {
            return false;
        }
        return af.a(shakeViewBean.getRenderRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        try {
            if (this.Z && this.f14098t != null && this.f14092n != null) {
                this.ad = new FrameLayout(this.f14092n);
                int width = this.f14098t.getWidth();
                int height = this.f14098t.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.ad.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.ad.setBackgroundColor(Color.parseColor(this.aj));
                this.f14098t.addView(this.ad);
                this.ad.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.a.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            a.this.ae = true;
                            a.this.af[0] = motionEvent.getX() + "";
                            a.this.af[1] = motionEvent.getY() + "";
                            a.this.af[2] = motionEvent.getRawX() + "";
                            a.this.af[3] = motionEvent.getRawY() + "";
                        }
                        return false;
                    }
                });
                this.ad.getViewTreeObserver().addOnScrollChangedListener(this.ap);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void aK() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        try {
            FrameLayout frameLayout3 = this.ad;
            if (frameLayout3 != null && this.ap != null) {
                frameLayout3.getViewTreeObserver().removeOnScrollChangedListener(this.ap);
            }
            ViewGroup viewGroup = this.f14098t;
            if (viewGroup != null && (frameLayout2 = this.ad) != null) {
                viewGroup.removeView(frameLayout2);
                this.ad = null;
            }
            ViewGroup viewGroup2 = this.f14098t;
            if (viewGroup2 != null && this.aq != null) {
                viewGroup2.getViewTreeObserver().removeOnScrollChangedListener(this.aq);
            }
            ViewGroup viewGroup3 = this.am;
            if (viewGroup3 == null || (frameLayout = this.an) == null) {
                return;
            }
            viewGroup3.removeView(frameLayout);
            this.an = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (this.f14098t != null && this.f14092n != null && (buyerBean = this.f14056e) != null) {
                if ((this.ak || this.al) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && af.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = this.f14098t.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
                    this.am = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int m6 = ap.m(this.f14092n);
                    int n6 = ap.n(this.f14092n);
                    int width2 = this.f14098t.getWidth();
                    int height2 = this.f14098t.getHeight();
                    int[] iArr = new int[2];
                    this.f14098t.getLocationOnScreen(iArr);
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
                    this.an = new FrameLayout(this.f14092n);
                    this.an.setLayoutParams(new FrameLayout.LayoutParams(m6, i8));
                    int a6 = a(horizontalSpace, m6, width2, i6);
                    int b6 = b(verticalSpace, i8, height2, i7);
                    int a7 = ap.a(this.f14092n, 25.0f);
                    if (b6 > a7) {
                        b6 -= a7;
                    }
                    this.an.setX(a6);
                    this.an.setY(b6);
                    this.an.setBackgroundColor(Color.parseColor(this.aj));
                    this.am.addView(this.an);
                    final float[] fArr = new float[4];
                    this.an.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.a.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            try {
                                if (motionEvent.getAction() == 0) {
                                    fArr[0] = motionEvent.getX();
                                    fArr[1] = motionEvent.getY();
                                    fArr[2] = motionEvent.getRawX();
                                    fArr[3] = motionEvent.getRawY();
                                    if (a.this.ak) {
                                        a aVar = a.this;
                                        FrameLayout frameLayout = aVar.an;
                                        ViewGroup viewGroup2 = a.this.f14098t;
                                        float[] fArr2 = fArr;
                                        a.this.a(aVar.a(frameLayout, viewGroup2, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                                    }
                                }
                                if (motionEvent.getAction() == 1 && a.this.al) {
                                    a aVar2 = a.this;
                                    FrameLayout frameLayout2 = aVar2.an;
                                    ViewGroup viewGroup3 = a.this.f14098t;
                                    float[] fArr3 = fArr;
                                    a.this.a(aVar2.a(frameLayout2, viewGroup3, fArr3[0], fArr3[1], fArr3[2], fArr3[3]), 0);
                                }
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                            if (!a.this.ak) {
                                if (!a.this.al) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    });
                    this.f14098t.getViewTreeObserver().addOnScrollChangedListener(this.aq);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void aM() {
        ViewGroup viewGroup = this.f14098t;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.a.6

            /* renamed from: a, reason: collision with root package name */
            String[] f14123a = new String[4];

            /* JADX WARN: Removed duplicated region for block: B:12:0x0093 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:3:0x0003, B:5:0x000a, B:7:0x0012, B:10:0x002d, B:12:0x0093, B:13:0x001e, B:15:0x0024, B:17:0x002a, B:18:0x009a, B:20:0x00a0, B:22:0x00a8, B:23:0x00af, B:25:0x00b7), top: B:2:0x0003 }] */
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
                    if (r1 != 0) goto L9a
                    com.beizi.fusion.work.b.a r1 = com.beizi.fusion.work.b.a.this     // Catch: java.lang.Exception -> L1b
                    boolean r1 = com.beizi.fusion.work.b.a.F(r1)     // Catch: java.lang.Exception -> L1b
                    if (r1 != 0) goto L1e
                    com.beizi.fusion.work.b.a r1 = com.beizi.fusion.work.b.a.this     // Catch: java.lang.Exception -> L1b
                    boolean r1 = com.beizi.fusion.work.b.a.H(r1)     // Catch: java.lang.Exception -> L1b
                    if (r1 == 0) goto L2d
                    goto L1e
                L1b:
                    r6 = move-exception
                    goto Lc0
                L1e:
                    com.beizi.fusion.work.b.a r1 = com.beizi.fusion.work.b.a.this     // Catch: java.lang.Exception -> L1b
                    android.view.ViewGroup r1 = r1.f14098t     // Catch: java.lang.Exception -> L1b
                    if (r1 == 0) goto L2d
                    android.view.ViewParent r1 = r1.getParent()     // Catch: java.lang.Exception -> L1b
                    if (r1 == 0) goto L2d
                    r1.requestDisallowInterceptTouchEvent(r2)     // Catch: java.lang.Exception -> L1b
                L2d:
                    java.lang.String[] r1 = r5.f14123a     // Catch: java.lang.Exception -> L1b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                    r3.<init>()     // Catch: java.lang.Exception -> L1b
                    float r4 = r7.getX()     // Catch: java.lang.Exception -> L1b
                    r3.append(r4)     // Catch: java.lang.Exception -> L1b
                    r3.append(r6)     // Catch: java.lang.Exception -> L1b
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1b
                    r1[r0] = r3     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r1 = r5.f14123a     // Catch: java.lang.Exception -> L1b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                    r3.<init>()     // Catch: java.lang.Exception -> L1b
                    float r4 = r7.getY()     // Catch: java.lang.Exception -> L1b
                    r3.append(r4)     // Catch: java.lang.Exception -> L1b
                    r3.append(r6)     // Catch: java.lang.Exception -> L1b
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1b
                    r1[r2] = r3     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r1 = r5.f14123a     // Catch: java.lang.Exception -> L1b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                    r3.<init>()     // Catch: java.lang.Exception -> L1b
                    float r4 = r7.getRawX()     // Catch: java.lang.Exception -> L1b
                    r3.append(r4)     // Catch: java.lang.Exception -> L1b
                    r3.append(r6)     // Catch: java.lang.Exception -> L1b
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1b
                    r4 = 2
                    r1[r4] = r3     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r1 = r5.f14123a     // Catch: java.lang.Exception -> L1b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                    r3.<init>()     // Catch: java.lang.Exception -> L1b
                    float r4 = r7.getRawY()     // Catch: java.lang.Exception -> L1b
                    r3.append(r4)     // Catch: java.lang.Exception -> L1b
                    r3.append(r6)     // Catch: java.lang.Exception -> L1b
                    java.lang.String r6 = r3.toString()     // Catch: java.lang.Exception -> L1b
                    r3 = 3
                    r1[r3] = r6     // Catch: java.lang.Exception -> L1b
                    com.beizi.fusion.work.b.a r6 = com.beizi.fusion.work.b.a.this     // Catch: java.lang.Exception -> L1b
                    boolean r6 = com.beizi.fusion.work.b.a.F(r6)     // Catch: java.lang.Exception -> L1b
                    if (r6 == 0) goto L9a
                    com.beizi.fusion.work.b.a r6 = com.beizi.fusion.work.b.a.this     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r1 = r5.f14123a     // Catch: java.lang.Exception -> L1b
                    com.beizi.fusion.work.b.a.a(r6, r1)     // Catch: java.lang.Exception -> L1b
                L9a:
                    int r6 = r7.getAction()     // Catch: java.lang.Exception -> L1b
                    if (r6 != r2) goto Laf
                    com.beizi.fusion.work.b.a r6 = com.beizi.fusion.work.b.a.this     // Catch: java.lang.Exception -> L1b
                    boolean r6 = com.beizi.fusion.work.b.a.H(r6)     // Catch: java.lang.Exception -> L1b
                    if (r6 == 0) goto Laf
                    com.beizi.fusion.work.b.a r6 = com.beizi.fusion.work.b.a.this     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r7 = r5.f14123a     // Catch: java.lang.Exception -> L1b
                    com.beizi.fusion.work.b.a.a(r6, r7)     // Catch: java.lang.Exception -> L1b
                Laf:
                    com.beizi.fusion.work.b.a r6 = com.beizi.fusion.work.b.a.this     // Catch: java.lang.Exception -> L1b
                    boolean r6 = com.beizi.fusion.work.b.a.F(r6)     // Catch: java.lang.Exception -> L1b
                    if (r6 != 0) goto Lbf
                    com.beizi.fusion.work.b.a r6 = com.beizi.fusion.work.b.a.this     // Catch: java.lang.Exception -> L1b
                    boolean r6 = com.beizi.fusion.work.b.a.H(r6)     // Catch: java.lang.Exception -> L1b
                    if (r6 == 0) goto Lc3
                Lbf:
                    return r2
                Lc0:
                    r6.printStackTrace()
                Lc3:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.b.a.AnonymousClass6.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    public void aA() {
        View view;
        try {
            com.beizi.ad.v2.d.c cVar = this.L;
            if (cVar != null && (view = this.M) != null) {
                cVar.a(view, new e() { // from class: com.beizi.fusion.work.b.a.11
                    @Override // com.beizi.ad.internal.e.e
                    public void a() {
                        a.this.ag = System.currentTimeMillis();
                        ((com.beizi.fusion.work.a) a.this).f14061j = com.beizi.fusion.e.a.ADSHOW;
                        if (a.this.V) {
                            ((com.beizi.fusion.work.a) a.this).f14053b.setIsCacheAd("1");
                            if (a.this.W > 0) {
                                ((com.beizi.fusion.work.a) a.this).f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.W));
                            }
                            a.this.ao();
                        }
                        if (((com.beizi.fusion.work.a) a.this).f14055d != null && ((com.beizi.fusion.work.a) a.this).f14055d.o() != 2) {
                            ((com.beizi.fusion.work.a) a.this).f14055d.b(a.this.f());
                        }
                        a.this.B();
                        a.this.C();
                        a.this.ac();
                        a.this.aJ();
                        a.this.aL();
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public boolean aB() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.E;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.D;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    public boolean aC() {
        return this.U;
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        com.beizi.ad.v2.d.c cVar = this.L;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        com.beizi.ad.v2.d.c cVar = this.L;
        if (cVar == null) {
            return null;
        }
        return cVar.m();
    }

    public void az() {
        View view;
        try {
            i iVar = this.K;
            if (iVar != null && (view = this.M) != null) {
                if (!this.ak && !this.al) {
                    f.a(iVar, view, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.b.a.10

                        /* renamed from: a, reason: collision with root package name */
                        boolean f14106a = false;

                        @Override // com.beizi.ad.internal.e.b
                        public void a() {
                            a.this.aE();
                        }

                        @Override // com.beizi.ad.internal.e.b
                        public void b() {
                        }
                    });
                    return;
                }
                aM();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.f14061j;
    }

    @Override // com.beizi.fusion.work.a
    public String i() {
        com.beizi.ad.v2.d.c cVar = this.L;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
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
        this.f14103y = shakeView;
        if (shakeView != null) {
            this.f14104z = shakeView.getCoolShakeView();
        }
        this.B = "cool_" + this.f14060i;
        this.J = "dl_cool_" + this.f14060i;
        if (this.f14096r <= 0.0f) {
            this.f14096r = ap.i(this.f14092n);
        }
        if (this.f14097s <= 0.0f) {
            this.f14097s = 0.0f;
        }
        com.beizi.ad.v2.d.c cVar = new com.beizi.ad.v2.d.c(this.f14092n, this.f14060i, new h() { // from class: com.beizi.fusion.work.b.a.1
            @Override // com.beizi.ad.h
            public void a(i iVar) {
                ((com.beizi.fusion.work.a) a.this).f14061j = com.beizi.fusion.e.a.ADLOAD;
                a aVar = a.this;
                aVar.R = Boolean.valueOf(aVar.L.l());
                a aVar2 = a.this;
                aVar2.V = aVar2.L.i();
                if (a.this.V) {
                    a aVar3 = a.this;
                    aVar3.W = aVar3.L.j();
                    ((com.beizi.fusion.work.a) a.this).f14053b.setIsCacheAd("1");
                    if (a.this.W > 0) {
                        ((com.beizi.fusion.work.a) a.this).f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.W));
                    }
                    a.this.ao();
                }
                if (a.this.L.a() != null) {
                    try {
                        a aVar4 = a.this;
                        aVar4.a(Double.parseDouble(aVar4.L.a()));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                a.this.x();
                if (iVar == null) {
                    a.this.c(-991);
                    return;
                }
                a aVar5 = a.this;
                aVar5.K = iVar;
                aVar5.b();
            }

            @Override // com.beizi.ad.h
            public void a(int i6) {
                a.this.a(String.valueOf(i6), i6);
            }
        });
        this.L = cVar;
        cVar.a(true);
        try {
            this.L.a(this.f14053b.m86clone());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.L.a((int) this.f14094p);
        this.L.a(this.f14056e);
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equals(g())) {
            this.L.c(g());
            com.beizi.fusion.c.d dVar = this.f14055d;
            if (dVar != null) {
                String w5 = dVar.w();
                if (!TextUtils.isEmpty(w5)) {
                    this.L.b(w5);
                }
            }
        }
        com.beizi.fusion.c.d dVar2 = this.f14055d;
        if (dVar2 != null) {
            this.L.c(dVar2.x());
        }
        this.L.c();
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        i iVar = this.K;
        if (iVar != null) {
            iVar.h();
        }
        com.beizi.ad.v2.d.c cVar = this.L;
        if (cVar != null) {
            cVar.f();
        }
        ab abVar = this.A;
        if (abVar != null) {
            abVar.c();
        }
        aK();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        ab abVar;
        try {
            if (!com.beizi.fusion.c.b.a().m() || (abVar = this.A) == null) {
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
            if (!com.beizi.fusion.c.b.a().m() || (abVar = this.A) == null) {
                return;
            }
            abVar.a(false);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f14099u;
    }

    @Override // com.beizi.fusion.work.a
    protected void z() {
        if (!y() || this.L == null) {
            return;
        }
        ag();
    }

    public a(Context context, String str, long j6, long j7, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.c.d dVar, float f6, float f7) {
        this.f14092n = context;
        this.f14093o = str;
        this.f14094p = j6;
        this.f14095q = j7;
        this.f14056e = buyerBean;
        this.f14055d = dVar;
        this.f14057f = forwardBean;
        this.f14096r = f6;
        this.f14097s = f7;
        this.f14098t = new SplashContainer(context);
        r();
    }

    public void aD() {
        try {
            if (!aH()) {
                com.beizi.fusion.c.d dVar = this.f14055d;
                if (dVar != null && dVar.o() != 2) {
                    this.f14055d.b(f(), this.f14099u);
                }
                F();
                return;
            }
            a.C0139a c0139a = new a.C0139a(this.f14092n);
            c0139a.a(new a.c() { // from class: com.beizi.fusion.work.b.a.14
                @Override // com.beizi.fusion.widget.dialog.dislike.a.c
                public void a() {
                    try {
                        if (((com.beizi.fusion.work.a) a.this).f14055d != null && ((com.beizi.fusion.work.a) a.this).f14055d.o() != 2) {
                            ((com.beizi.fusion.work.a) a.this).f14055d.b(a.this.f(), a.this.f14099u);
                        }
                        a.this.F();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
            c0139a.a().show();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void ay() {
        try {
            if (Y()) {
                com.beizi.fusion.c.d dVar = this.f14055d;
                if (dVar != null) {
                    Map<String, com.beizi.fusion.work.a> n6 = dVar.n();
                    f();
                    n6.toString();
                    Z();
                    com.beizi.fusion.c.e eVar = this.f14058g;
                    if (eVar == com.beizi.fusion.c.e.SUCCESS) {
                        if (this.f14099u != null) {
                            this.f14055d.a(f(), this.f14099u);
                            return;
                        } else {
                            this.f14055d.a(10140);
                            return;
                        }
                    }
                    if (eVar == com.beizi.fusion.c.e.FAIL) {
                        f();
                        return;
                    }
                    return;
                }
                return;
            }
            P();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00af, code lost:
    
        r7.Q = com.beizi.fusion.tool.af.a(java.lang.Integer.parseInt(r4.getRate()));
     */
    @Override // com.beizi.fusion.work.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.b.a.d():void");
    }

    private boolean b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long longValue = ((Long) an.b(this.f14092n, this.B, 0L)).longValue();
        if (longValue != 0) {
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis < this.f14104z.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.b.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.A.a(shakeViewBean);
                    }
                }, this.f14104z.getCoolTime() - currentTimeMillis);
                return true;
            }
            ak.a().a(this.B);
        }
        return false;
    }

    public void a(final TextView textView, final ImageView imageView) {
        ArrayList<String> j6;
        try {
            i iVar = this.K;
            if (iVar == null) {
                return;
            }
            String e6 = iVar.e();
            if (TextUtils.isEmpty(e6) && (j6 = this.K.j()) != null && j6.size() >= 3) {
                e6 = j6.get(2);
            }
            if (TextUtils.isEmpty(e6)) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            if (e6.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                com.beizi.ad.internal.h.i.a((Context) null).a(e6, new i.a() { // from class: com.beizi.fusion.work.b.a.8
                    @Override // com.beizi.ad.internal.h.i.a
                    public void a() {
                    }

                    @Override // com.beizi.ad.internal.h.i.a
                    public void a(Bitmap bitmap) {
                        try {
                            TextView textView2 = textView;
                            if (textView2 != null) {
                                textView2.setVisibility(8);
                            }
                            ImageView imageView2 = imageView;
                            if (imageView2 != null) {
                                imageView2.setVisibility(0);
                                imageView.setImageBitmap(bitmap);
                            }
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                });
                return;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(e6);
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.DislikeConfigBean b(List<AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean> list, String str) {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislike;
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean orderDataDislikeConfigBean : list) {
                List<String> orderList = orderDataDislikeConfigBean.getOrderList();
                if (orderList != null && orderList.contains(str) && (dislike = orderDataDislikeConfigBean.getDislike()) != null) {
                    return dislike;
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
            com.beizi.ad.v2.d.c cVar = this.L;
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

    public void a(final View view) {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean;
        try {
            int a6 = ap.a(this.f14092n, this.f14096r);
            float f6 = this.f14097s;
            int a7 = f6 > 0.0f ? ap.a(this.f14092n, f6) : -2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a6, a7);
            ViewGroup viewGroup = this.f14098t;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                StringBuilder sb = new StringBuilder();
                sb.append("mNativeAd != null ? ");
                boolean z5 = true;
                sb.append(this.L != null);
                sb.append(",renderViewBean != null ? ");
                if (this.f14101w == null) {
                    z5 = false;
                }
                sb.append(z5);
                aa.a("BeiZis", sb.toString());
                this.f14098t.addView(this.M, layoutParams);
                this.M.measure(0, 0);
                a(this.K, a6, a7, this.M.getMeasuredHeight());
                aG();
                EventBean eventBean = this.f14053b;
                if (eventBean != null && (dislikeConfigBean = this.D) != null) {
                    eventBean.setDislikeUuid(dislikeConfigBean.getDislikeUuid());
                    ao();
                }
                if (aB()) {
                    a(this.K);
                }
                ViewGroup viewGroup2 = this.f14098t;
                this.f14099u = viewGroup2;
                ab abVar = this.A;
                if (abVar != null) {
                    abVar.a(viewGroup2);
                }
            }
            com.beizi.ad.v2.d.c cVar = this.L;
            if (cVar == null || this.f14101w == null) {
                return;
            }
            cVar.a(this.f14102x);
            this.L.b(this.f14101w.getOptimizePercent());
            aa.a("BeiZis", "percent = " + this.f14101w.getOptimizePercent());
            this.f14098t.post(new Runnable() { // from class: com.beizi.fusion.work.b.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    com.beizi.ad.v2.d.c cVar2 = aVar.L;
                    int optimizeSize = aVar.f14101w.getOptimizeSize();
                    View view2 = view;
                    a aVar2 = a.this;
                    cVar2.a(optimizeSize, view2, aVar2.f14098t, aVar2.f14101w.getDirection());
                }
            });
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

    private void a(final com.beizi.ad.i iVar, final int i6, final int i7, int i8) {
        try {
            if (!com.beizi.fusion.c.b.a().n() && aI()) {
                if (this.A == null) {
                    this.A = new ab(this.f14092n);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f14103y;
                if (shakeViewBean == null || this.A == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setShakeViewUuid(this.f14103y.getShakeViewUuid());
                    ao();
                }
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean a6 = a(this.f14103y.getOrderData(), this.L.b());
                AdSpacesBean.BuyerBean.ShakeViewBean shakeView = (a6 == null || a6.getShakeView() == null) ? null : a6.getShakeView();
                if (i7 <= 0) {
                    i7 = i8;
                }
                this.A.a(this.R);
                View a7 = this.A.a(ap.b(this.f14092n, i6), ap.b(this.f14092n, i7), this.f14103y.getPosition());
                if (a7 != null) {
                    ViewGroup.LayoutParams layoutParams = a7.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f14103y;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            this.f14098t.addView(a7, layoutParams2);
                        }
                    }
                }
                a(shakeView);
                this.A.a(new ab.a() { // from class: com.beizi.fusion.work.b.a.12
                    @Override // com.beizi.fusion.tool.ab.a
                    public void a() {
                        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
                        View view;
                        try {
                            if (ar.a(a.this.f14099u) && !a.this.ai) {
                                a.this.Y = true;
                                a.this.ai = true;
                                int[] iArr = new int[2];
                                a.this.f14099u.getLocationOnScreen(iArr);
                                int[] a8 = af.a(i6 / 2, i7 / 2);
                                com.beizi.ad.i iVar2 = iVar;
                                if (iVar2 != null && (view = a.this.f14099u) != null) {
                                    iVar2.a(view, String.valueOf(a8[0]), String.valueOf(a8[1]), String.valueOf(a8[0] + iArr[0]), String.valueOf(a8[1] + iArr[1]), 2, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.b.a.12.1
                                        @Override // com.beizi.ad.internal.e.b
                                        public void a() {
                                            a.this.aE();
                                        }

                                        @Override // com.beizi.ad.internal.e.b
                                        public void b() {
                                        }
                                    });
                                }
                                a aVar = a.this;
                                if (!aVar.C || (coolShakeViewBean = aVar.f14104z) == null) {
                                    return;
                                }
                                aVar.C = false;
                                aVar.A.a(coolShakeViewBean);
                                a aVar2 = a.this;
                                an.a(aVar2.f14092n, aVar2.B, (Object) Long.valueOf(System.currentTimeMillis()));
                                ak.a().a(a.this.B, System.currentTimeMillis());
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f14104z;
                if (coolShakeViewBean != null) {
                    this.A.a(coolShakeViewBean, this.B);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.f14103y;
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        ab abVar = this.A;
        if (abVar != null) {
            abVar.c(regulatoryAngle);
        }
        if (this.f14104z == null) {
            this.C = true;
            this.A.a(shakeViewBean);
        } else if (b(shakeViewBean)) {
            this.A.a(this.f14104z);
        } else if (aF()) {
            this.A.a(this.f14104z);
        } else {
            this.C = true;
            this.A.a(shakeViewBean);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            com.beizi.ad.v2.d.c cVar = this.L;
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

    protected void a(String[] strArr, int i6) {
        View view;
        try {
            aK();
            if (this.K != null && this.f14099u != null && !this.ai && !this.Y) {
                this.Y = true;
                this.ai = true;
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.ah);
                    ao();
                }
                com.beizi.ad.i iVar = this.K;
                if (iVar == null || (view = this.f14099u) == null) {
                    return;
                }
                iVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.b.a.15
                    @Override // com.beizi.ad.internal.e.b
                    public void a() {
                        a.this.aE();
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
        View view;
        try {
            aK();
            if (this.K != null && this.f14099u != null && !this.ai) {
                this.Y = true;
                this.ai = true;
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.ah);
                    ao();
                }
                com.beizi.ad.i iVar = this.K;
                if (iVar == null || (view = this.f14099u) == null) {
                    return;
                }
                iVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.b.a.7
                    @Override // com.beizi.ad.internal.e.b
                    public void a() {
                        a.this.aE();
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
