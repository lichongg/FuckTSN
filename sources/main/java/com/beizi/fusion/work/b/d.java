package com.beizi.fusion.work.b;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.beizi.ad.h;
import com.beizi.ad.i;
import com.beizi.ad.internal.e.e;
import com.beizi.ad.internal.e.f;
import com.beizi.ad.internal.h.i;
import com.beizi.ad.internal.h.u;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ab;
import com.beizi.fusion.tool.af;
import com.beizi.fusion.tool.ak;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.ar;
import com.beizi.fusion.tool.l;
import com.beizi.fusion.tool.w;
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
public class d extends com.beizi.fusion.work.a implements com.beizi.fusion.c.c {
    private AdSpacesBean.BuyerBean.CoolShakeViewBean A;
    private ab B;
    private AdSpacesBean.BuyerBean.DislikeConfigBean E;
    private AdSpacesBean.BuyerBean.DislikeConfigBean F;
    private i L;
    private Boolean P;
    private long Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private long V;
    private int W;
    private int X;
    private FrameLayout Y;
    private boolean Z;
    private long ab;
    private String ac;
    private boolean ad;
    private boolean ae;
    private boolean ag;
    private boolean ah;
    private ViewGroup ai;
    private FrameLayout aj;
    private long ak;
    private AdSpacesBean.ComplainBean al;
    private boolean am;
    private long an;

    /* renamed from: n, reason: collision with root package name */
    private Context f14139n;

    /* renamed from: o, reason: collision with root package name */
    private String f14140o;

    /* renamed from: p, reason: collision with root package name */
    private long f14141p;

    /* renamed from: q, reason: collision with root package name */
    private long f14142q;

    /* renamed from: r, reason: collision with root package name */
    private float f14143r;

    /* renamed from: s, reason: collision with root package name */
    private float f14144s;

    /* renamed from: t, reason: collision with root package name */
    private com.beizi.ad.v2.d.a f14145t;

    /* renamed from: u, reason: collision with root package name */
    private ViewGroup f14146u;

    /* renamed from: v, reason: collision with root package name */
    private View f14147v;

    /* renamed from: w, reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f14148w;

    /* renamed from: x, reason: collision with root package name */
    private AdSpacesBean.RenderViewBean f14149x;

    /* renamed from: y, reason: collision with root package name */
    private List<Pair<String, Integer>> f14150y;

    /* renamed from: z, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ShakeViewBean f14151z;
    private String C = null;
    private boolean D = false;
    private float G = 0.0f;
    private float H = 0.0f;
    private float I = 0.0f;
    private float J = 0.0f;
    private String K = null;
    private String M = null;
    private boolean N = false;
    private boolean O = false;
    private String[] aa = new String[4];
    private String af = "#00000000";
    private ViewTreeObserver.OnScrollChangedListener ao = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.b.d.5
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (d.this.Z && !d.this.T && !d.this.ad && System.currentTimeMillis() - d.this.ab >= d.this.V && System.currentTimeMillis() - d.this.Q >= 50) {
                    d.this.Q = System.currentTimeMillis();
                    if (ar.a(d.this.f14147v, 0.8d)) {
                        int[] iArr = new int[2];
                        if (d.this.f14147v != null) {
                            d.this.f14147v.getLocationOnScreen(iArr);
                        }
                        if (iArr[1] > 0 && d.this.X == 0) {
                            d.this.X = iArr[1];
                        }
                        if (Math.abs(d.this.X - iArr[1]) < d.this.W) {
                            return;
                        }
                        d dVar = d.this;
                        dVar.a(dVar.aa, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private ViewTreeObserver.OnScrollChangedListener ap = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.beizi.fusion.work.b.d.7
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (d.this.f14146u != null && System.currentTimeMillis() - d.this.ak >= 100) {
                    d.this.ak = System.currentTimeMillis();
                    int[] iArr = new int[2];
                    d.this.f14146u.getLocationOnScreen(iArr);
                    if (iArr[1] < 0) {
                        d.this.f14146u.getViewTreeObserver().removeOnScrollChangedListener(this);
                        if (d.this.aj == null || d.this.ai == null) {
                            return;
                        }
                        d.this.ai.removeView(d.this.aj);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    };

    private boolean aA() {
        try {
            return System.currentTimeMillis() - ap.o(this.f14139n).longValue() < this.A.getUserProtectTime();
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private boolean aD() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.F;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.E;
            return dislikeConfigBean2 != null && dislikeConfigBean2.getIsShowDialog() == 1;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return false;
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB() {
        AdSpacesBean.BuyerBean.DislikeConfigBean b6;
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.f14056e.getDislikeConfig();
        this.E = dislikeConfig;
        if (dislikeConfig == null || (b6 = b(dislikeConfig.getOrderData(), this.f14145t.b())) == null) {
            return;
        }
        this.F = b6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aC() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.F;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.E;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aE() {
        return this.ae;
    }

    private boolean aG() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f14151z;
        if (shakeViewBean == null) {
            return false;
        }
        return af.a(shakeViewBean.getRenderRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH() {
        try {
            if (this.U && this.f14146u != null && this.f14139n != null) {
                this.Y = new FrameLayout(this.f14139n);
                int width = this.f14146u.getWidth();
                int height = this.f14146u.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.Y.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.Y.setBackgroundColor(Color.parseColor(this.af));
                this.f14146u.addView(this.Y);
                this.Y.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.d.4
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            d.this.Z = true;
                            d.this.aa[0] = motionEvent.getX() + "";
                            d.this.aa[1] = motionEvent.getY() + "";
                            d.this.aa[2] = motionEvent.getRawX() + "";
                            d.this.aa[3] = motionEvent.getRawY() + "";
                        }
                        return false;
                    }
                });
                this.Y.getViewTreeObserver().addOnScrollChangedListener(this.ao);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void aI() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        try {
            FrameLayout frameLayout3 = this.Y;
            if (frameLayout3 != null && this.ao != null) {
                frameLayout3.getViewTreeObserver().removeOnScrollChangedListener(this.ao);
            }
            ViewGroup viewGroup = this.f14146u;
            if (viewGroup != null && (frameLayout2 = this.Y) != null) {
                viewGroup.removeView(frameLayout2);
                this.Y = null;
            }
            ViewGroup viewGroup2 = this.f14146u;
            if (viewGroup2 != null && this.ap != null) {
                viewGroup2.getViewTreeObserver().removeOnScrollChangedListener(this.ap);
            }
            ViewGroup viewGroup3 = this.ai;
            if (viewGroup3 == null || (frameLayout = this.aj) == null) {
                return;
            }
            viewGroup3.removeView(frameLayout);
            this.aj = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (this.f14146u != null && this.f14139n != null && (buyerBean = this.f14056e) != null) {
                if ((this.ag || this.ah) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && af.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = this.f14146u.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
                    this.ai = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int m6 = ap.m(this.f14139n);
                    int n6 = ap.n(this.f14139n);
                    int width2 = this.f14146u.getWidth();
                    int height2 = this.f14146u.getHeight();
                    int[] iArr = new int[2];
                    this.f14146u.getLocationOnScreen(iArr);
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
                    this.aj = new FrameLayout(this.f14139n);
                    this.aj.setLayoutParams(new FrameLayout.LayoutParams(m6, i8));
                    int a6 = a(horizontalSpace, m6, width2, i6);
                    int b6 = b(verticalSpace, i8, height2, i7);
                    int a7 = ap.a(this.f14139n, 25.0f);
                    if (b6 > a7) {
                        b6 -= a7;
                    }
                    this.aj.setX(a6);
                    this.aj.setY(b6);
                    this.aj.setBackgroundColor(Color.parseColor(this.af));
                    this.ai.addView(this.aj);
                    final float[] fArr = new float[4];
                    this.aj.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.d.6
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            try {
                                if (motionEvent.getAction() == 0) {
                                    fArr[0] = motionEvent.getX();
                                    fArr[1] = motionEvent.getY();
                                    fArr[2] = motionEvent.getRawX();
                                    fArr[3] = motionEvent.getRawY();
                                    if (d.this.ag) {
                                        d dVar = d.this;
                                        FrameLayout frameLayout = dVar.aj;
                                        ViewGroup viewGroup2 = d.this.f14146u;
                                        float[] fArr2 = fArr;
                                        d.this.a(dVar.a(frameLayout, viewGroup2, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                                    }
                                }
                                if (motionEvent.getAction() == 1 && d.this.ah) {
                                    d dVar2 = d.this;
                                    FrameLayout frameLayout2 = dVar2.aj;
                                    ViewGroup viewGroup3 = d.this.f14146u;
                                    float[] fArr3 = fArr;
                                    d.this.a(dVar2.a(frameLayout2, viewGroup3, fArr3[0], fArr3[1], fArr3[2], fArr3[3]), 0);
                                }
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                            if (!d.this.ag) {
                                if (!d.this.ah) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    });
                    this.f14146u.getViewTreeObserver().addOnScrollChangedListener(this.ap);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void aK() {
        ViewGroup viewGroup = this.f14146u;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.d.8

            /* renamed from: a, reason: collision with root package name */
            String[] f14177a = new String[4];

            /* JADX WARN: Removed duplicated region for block: B:12:0x009b A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:3:0x0003, B:5:0x000a, B:7:0x0012, B:10:0x0035, B:12:0x009b, B:13:0x001e, B:15:0x0026, B:17:0x0032, B:18:0x00a2, B:20:0x00a8, B:22:0x00b0, B:23:0x00b7, B:25:0x00bf), top: B:2:0x0003 }] */
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
                    if (r1 != 0) goto La2
                    com.beizi.fusion.work.b.d r1 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    boolean r1 = com.beizi.fusion.work.b.d.ao(r1)     // Catch: java.lang.Exception -> L1b
                    if (r1 != 0) goto L1e
                    com.beizi.fusion.work.b.d r1 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    boolean r1 = com.beizi.fusion.work.b.d.aq(r1)     // Catch: java.lang.Exception -> L1b
                    if (r1 == 0) goto L35
                    goto L1e
                L1b:
                    r6 = move-exception
                    goto Lc8
                L1e:
                    com.beizi.fusion.work.b.d r1 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    android.view.ViewGroup r1 = com.beizi.fusion.work.b.d.l(r1)     // Catch: java.lang.Exception -> L1b
                    if (r1 == 0) goto L35
                    com.beizi.fusion.work.b.d r1 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    android.view.ViewGroup r1 = com.beizi.fusion.work.b.d.l(r1)     // Catch: java.lang.Exception -> L1b
                    android.view.ViewParent r1 = r1.getParent()     // Catch: java.lang.Exception -> L1b
                    if (r1 == 0) goto L35
                    r1.requestDisallowInterceptTouchEvent(r2)     // Catch: java.lang.Exception -> L1b
                L35:
                    java.lang.String[] r1 = r5.f14177a     // Catch: java.lang.Exception -> L1b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                    r3.<init>()     // Catch: java.lang.Exception -> L1b
                    float r4 = r7.getX()     // Catch: java.lang.Exception -> L1b
                    r3.append(r4)     // Catch: java.lang.Exception -> L1b
                    r3.append(r6)     // Catch: java.lang.Exception -> L1b
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1b
                    r1[r0] = r3     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r1 = r5.f14177a     // Catch: java.lang.Exception -> L1b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                    r3.<init>()     // Catch: java.lang.Exception -> L1b
                    float r4 = r7.getY()     // Catch: java.lang.Exception -> L1b
                    r3.append(r4)     // Catch: java.lang.Exception -> L1b
                    r3.append(r6)     // Catch: java.lang.Exception -> L1b
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1b
                    r1[r2] = r3     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r1 = r5.f14177a     // Catch: java.lang.Exception -> L1b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                    r3.<init>()     // Catch: java.lang.Exception -> L1b
                    float r4 = r7.getRawX()     // Catch: java.lang.Exception -> L1b
                    r3.append(r4)     // Catch: java.lang.Exception -> L1b
                    r3.append(r6)     // Catch: java.lang.Exception -> L1b
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1b
                    r4 = 2
                    r1[r4] = r3     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r1 = r5.f14177a     // Catch: java.lang.Exception -> L1b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1b
                    r3.<init>()     // Catch: java.lang.Exception -> L1b
                    float r4 = r7.getRawY()     // Catch: java.lang.Exception -> L1b
                    r3.append(r4)     // Catch: java.lang.Exception -> L1b
                    r3.append(r6)     // Catch: java.lang.Exception -> L1b
                    java.lang.String r6 = r3.toString()     // Catch: java.lang.Exception -> L1b
                    r3 = 3
                    r1[r3] = r6     // Catch: java.lang.Exception -> L1b
                    com.beizi.fusion.work.b.d r6 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    boolean r6 = com.beizi.fusion.work.b.d.ao(r6)     // Catch: java.lang.Exception -> L1b
                    if (r6 == 0) goto La2
                    com.beizi.fusion.work.b.d r6 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r1 = r5.f14177a     // Catch: java.lang.Exception -> L1b
                    com.beizi.fusion.work.b.d.a(r6, r1)     // Catch: java.lang.Exception -> L1b
                La2:
                    int r6 = r7.getAction()     // Catch: java.lang.Exception -> L1b
                    if (r6 != r2) goto Lb7
                    com.beizi.fusion.work.b.d r6 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    boolean r6 = com.beizi.fusion.work.b.d.aq(r6)     // Catch: java.lang.Exception -> L1b
                    if (r6 == 0) goto Lb7
                    com.beizi.fusion.work.b.d r6 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    java.lang.String[] r7 = r5.f14177a     // Catch: java.lang.Exception -> L1b
                    com.beizi.fusion.work.b.d.a(r6, r7)     // Catch: java.lang.Exception -> L1b
                Lb7:
                    com.beizi.fusion.work.b.d r6 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    boolean r6 = com.beizi.fusion.work.b.d.ao(r6)     // Catch: java.lang.Exception -> L1b
                    if (r6 != 0) goto Lc7
                    com.beizi.fusion.work.b.d r6 = com.beizi.fusion.work.b.d.this     // Catch: java.lang.Exception -> L1b
                    boolean r6 = com.beizi.fusion.work.b.d.aq(r6)     // Catch: java.lang.Exception -> L1b
                    if (r6 == 0) goto Lcb
                Lc7:
                    return r2
                Lc8:
                    r6.printStackTrace()
                Lcb:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.b.d.AnonymousClass8.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.al;
            if (complainBean != null && complainBean.getOpen() == 1) {
                l lVar = new l();
                lVar.a(this.f14139n, this.f14146u, "1");
                lVar.a(new l.a() { // from class: com.beizi.fusion.work.b.d.13
                    @Override // com.beizi.fusion.tool.l.a
                    public void a(String str) {
                        try {
                            an.a(d.this.f14139n, d.this.M, (Object) Long.valueOf(System.currentTimeMillis()));
                            ((com.beizi.fusion.work.a) d.this).f14053b.setComplain(str);
                            d.this.ao();
                            d.this.H();
                            d.this.az();
                            if (((com.beizi.fusion.work.a) d.this).f14055d != null && ((com.beizi.fusion.work.a) d.this).f14055d.o() != 2) {
                                ((com.beizi.fusion.work.a) d.this).f14055d.b(d.this.f(), d.this.f14147v);
                            }
                            d.this.F();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.f14139n);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(this.f14139n);
            imageView.setImageResource(com.beizi.fusion.R.drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(this.f14139n);
            textView.setText("投诉成功，我们将重视您的反馈。");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 30, 0, 0);
            linearLayout.addView(textView, layoutParams);
            this.f14147v.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f14147v.getMeasuredWidth(), this.f14147v.getMeasuredHeight());
            layoutParams2.gravity = 17;
            this.f14146u.addView(linearLayout, layoutParams2);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        com.beizi.ad.v2.d.a aVar = this.f14145t;
        if (aVar == null) {
            return null;
        }
        return aVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        com.beizi.ad.v2.d.a aVar = this.f14145t;
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
        com.beizi.ad.v2.d.a aVar = this.f14145t;
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
        this.f14151z = shakeView;
        if (shakeView != null) {
            this.A = shakeView.getCoolShakeView();
        }
        this.C = "cool_" + this.f14060i;
        this.K = "dl_cool_" + this.f14060i;
        if (this.f14143r <= 0.0f) {
            this.f14143r = ap.i(this.f14139n);
        }
        if (this.f14144s <= 0.0f) {
            this.f14144s = 0.0f;
        }
        com.beizi.ad.v2.d.a aVar = new com.beizi.ad.v2.d.a(this.f14139n, this.f14060i, 3, new h() { // from class: com.beizi.fusion.work.b.d.1
            @Override // com.beizi.ad.h
            public void a(i iVar) {
                ((com.beizi.fusion.work.a) d.this).f14061j = com.beizi.fusion.e.a.ADLOAD;
                d.this.L = iVar;
                d dVar = d.this;
                dVar.P = Boolean.valueOf(dVar.f14145t.l());
                d dVar2 = d.this;
                dVar2.am = dVar2.f14145t.i();
                if (d.this.am) {
                    d dVar3 = d.this;
                    dVar3.an = dVar3.f14145t.j();
                    ((com.beizi.fusion.work.a) d.this).f14053b.setIsCacheAd("1");
                    if (d.this.an > 0) {
                        ((com.beizi.fusion.work.a) d.this).f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - d.this.an));
                    }
                    d.this.ao();
                }
                if (d.this.f14145t.a() != null) {
                    try {
                        d dVar4 = d.this;
                        dVar4.a(Double.parseDouble(dVar4.f14145t.a()));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                d.this.x();
                if (iVar == null) {
                    d.this.c(-991);
                } else {
                    d.this.c(iVar);
                }
            }

            @Override // com.beizi.ad.h
            public void a(int i6) {
                d.this.a(String.valueOf(i6), i6);
            }
        });
        this.f14145t = aVar;
        aVar.a(true);
        try {
            this.f14145t.a(this.f14053b.m86clone());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f14145t.a((int) this.f14141p);
        this.f14145t.a(this.f14056e);
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equals(g())) {
            this.f14145t.c(g());
            com.beizi.fusion.c.d dVar = this.f14055d;
            if (dVar != null) {
                String w5 = dVar.w();
                if (!TextUtils.isEmpty(w5)) {
                    this.f14145t.b(w5);
                }
            }
        }
        com.beizi.fusion.c.d dVar2 = this.f14055d;
        if (dVar2 != null) {
            this.f14145t.c(dVar2.x());
        }
        this.f14145t.c();
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        i iVar = this.L;
        if (iVar != null) {
            iVar.h();
        }
        com.beizi.ad.v2.d.a aVar = this.f14145t;
        if (aVar != null) {
            aVar.f();
        }
        ab abVar = this.B;
        if (abVar != null) {
            abVar.c();
        }
        aI();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        ab abVar;
        try {
            if (!com.beizi.fusion.c.b.a().m() || (abVar = this.B) == null) {
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
            if (!com.beizi.fusion.c.b.a().m() || (abVar = this.B) == null) {
                return;
            }
            abVar.a(false);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f14147v;
    }

    @Override // com.beizi.fusion.work.a
    protected void z() {
        if (!y() || this.f14145t == null) {
            return;
        }
        ag();
    }

    public d(Context context, String str, long j6, long j7, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.c.d dVar, float f6, float f7) {
        this.f14139n = context;
        this.f14140o = str;
        this.f14141p = j6;
        this.f14142q = j7;
        this.f14056e = buyerBean;
        this.f14055d = dVar;
        this.f14057f = forwardBean;
        this.f14143r = f6;
        this.f14144s = f7;
        this.f14146u = new SplashContainer(context);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        try {
            if (!aD()) {
                com.beizi.fusion.c.d dVar = this.f14055d;
                if (dVar != null && dVar.o() != 2) {
                    this.f14055d.b(f(), this.f14147v);
                }
                F();
                return;
            }
            a.C0139a c0139a = new a.C0139a(this.f14139n);
            c0139a.a(new a.c() { // from class: com.beizi.fusion.work.b.d.2
                @Override // com.beizi.fusion.widget.dialog.dislike.a.c
                public void a() {
                    try {
                        if (((com.beizi.fusion.work.a) d.this).f14055d != null && ((com.beizi.fusion.work.a) d.this).f14055d.o() != 2) {
                            ((com.beizi.fusion.work.a) d.this).f14055d.b(d.this.f(), d.this.f14147v);
                        }
                        d.this.F();
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

    @Override // com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(i iVar) {
        View a6;
        if (iVar == null) {
            return;
        }
        try {
            if (iVar.n() == null || (a6 = f.a(this.f14139n, iVar)) == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.f14146u.getLayoutParams().width * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.f14146u.addView(a6, layoutParams);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(i iVar) {
        ImageView imageView = new ImageView(this.f14139n);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(85, 85);
        imageView.setPadding(25, 15, 15, 25);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(0);
        imageView.setImageResource(com.beizi.fusion.R.drawable.beizi_close);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(85, 85);
        layoutParams2.gravity = 5;
        this.f14146u.addView(imageView, layoutParams2);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.d.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    d.this.G = motionEvent.getX();
                    d.this.H = motionEvent.getY();
                    d.this.I = motionEvent.getRawX();
                    d.this.J = motionEvent.getRawY();
                    return false;
                }
                return false;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.b.d.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.aE()) {
                    d.this.aF();
                    return;
                }
                d.this.ae = false;
                d.this.a(new String[]{String.valueOf(d.this.G), String.valueOf(d.this.H), String.valueOf(d.this.I), String.valueOf(d.this.J)}, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final i iVar) {
        if (iVar == null) {
            c(-991);
            return;
        }
        ArrayList<String> i6 = iVar.i();
        if (i6 != null && i6.size() != 0) {
            final ImageView imageView = new ImageView(this.f14139n);
            imageView.setVisibility(0);
            com.beizi.ad.internal.h.i.a((Context) null).a(i6.get(0), new i.a() { // from class: com.beizi.fusion.work.b.d.10
                @Override // com.beizi.ad.internal.h.i.a
                public void a(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    try {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        float f6 = (float) ((width * 1.0d) / height);
                        int a6 = ap.a(d.this.f14139n, d.this.f14143r);
                        int a7 = d.this.f14144s > 0.0f ? ap.a(d.this.f14139n, d.this.f14144s) : (int) (a6 / f6);
                        ImageView imageView2 = imageView;
                        if (imageView2 != null && (layoutParams = imageView2.getLayoutParams()) != null) {
                            layoutParams.width = a6;
                            layoutParams.height = a7;
                            imageView.setLayoutParams(layoutParams);
                        }
                        if (imageView != null) {
                            imageView.setBackground(new BitmapDrawable(w.a(d.this.f14139n, bitmap, 20.0f)));
                            imageView.setImageBitmap(bitmap);
                        }
                        d.this.R = a6;
                        d.this.S = a7;
                        if (d.this.S < 0) {
                            d.this.S = height;
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a6, a7);
                        if (d.this.f14146u != null) {
                            d.this.f14146u.removeAllViews();
                            d.this.f14146u.setLayoutParams(layoutParams2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("mNativeAd != null ? ");
                            sb.append(d.this.f14145t != null);
                            sb.append(",renderViewBean != null ? ");
                            sb.append(d.this.f14149x != null);
                            aa.a("BeiZis", sb.toString());
                            d.this.f14146u.addView(imageView, layoutParams2);
                            d.this.d(iVar);
                            d.this.ay();
                            d.this.e(iVar);
                            d.this.a(iVar, a6, a7, bitmap.getHeight());
                            d.this.aB();
                            if (((com.beizi.fusion.work.a) d.this).f14053b != null && d.this.E != null) {
                                ((com.beizi.fusion.work.a) d.this).f14053b.setDislikeUuid(d.this.E.getDislikeUuid());
                                d.this.ao();
                            }
                            if (d.this.aC()) {
                                d.this.f(iVar);
                            }
                            d dVar = d.this;
                            dVar.f14147v = dVar.f14146u;
                            if (d.this.B != null) {
                                d.this.B.a(d.this.f14147v);
                            }
                        }
                        if (d.this.f14145t != null && d.this.f14149x != null) {
                            d.this.f14145t.a(d.this.f14150y);
                            d.this.f14145t.b(d.this.f14149x.getOptimizePercent());
                            aa.a("BeiZis", "percent = " + d.this.f14149x.getOptimizePercent());
                            d.this.f14146u.post(new Runnable() { // from class: com.beizi.fusion.work.b.d.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.beizi.ad.v2.d.a aVar = d.this.f14145t;
                                    int optimizeSize = d.this.f14149x.getOptimizeSize();
                                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                    aVar.a(optimizeSize, imageView, d.this.f14146u, d.this.f14149x.getDirection());
                                }
                            });
                        }
                        d.this.b(iVar);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }

                @Override // com.beizi.ad.internal.h.i.a
                public void a() {
                    d.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }
            });
            if (!this.ag && !this.ah) {
                f.a(iVar, imageView, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.b.d.11

                    /* renamed from: a, reason: collision with root package name */
                    boolean f14157a = false;

                    @Override // com.beizi.ad.internal.e.b
                    public void a() {
                        d.this.b();
                    }

                    @Override // com.beizi.ad.internal.e.b
                    public void b() {
                    }
                });
            } else {
                aK();
            }
            com.beizi.ad.v2.d.a aVar = this.f14145t;
            if (aVar != null) {
                aVar.a(imageView, new e() { // from class: com.beizi.fusion.work.b.d.12
                    @Override // com.beizi.ad.internal.e.e
                    public void a() {
                        d.this.ab = System.currentTimeMillis();
                        ((com.beizi.fusion.work.a) d.this).f14061j = com.beizi.fusion.e.a.ADSHOW;
                        if (d.this.am) {
                            ((com.beizi.fusion.work.a) d.this).f14053b.setIsCacheAd("1");
                            if (d.this.an > 0) {
                                ((com.beizi.fusion.work.a) d.this).f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - d.this.an));
                            }
                            d.this.ao();
                        }
                        if (((com.beizi.fusion.work.a) d.this).f14055d != null && ((com.beizi.fusion.work.a) d.this).f14055d.o() != 2) {
                            ((com.beizi.fusion.work.a) d.this).f14055d.b(d.this.f());
                        }
                        d.this.B();
                        d.this.C();
                        d.this.ac();
                        d.this.aH();
                        d.this.aJ();
                    }
                });
                return;
            }
            return;
        }
        c(-991);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00af, code lost:
    
        r7.O = com.beizi.fusion.tool.af.a(java.lang.Integer.parseInt(r4.getRate()));
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
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.b.d.d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.beizi.ad.i iVar) {
        if (Y()) {
            a(iVar);
        } else {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        AdSpacesBean.BuyerBean buyerBean;
        this.T = true;
        this.ad = false;
        this.ae = false;
        aI();
        if (this.N && (buyerBean = this.f14056e) != null) {
            this.f14053b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
            ao();
        }
        E();
        if (!this.N || this.O) {
            com.beizi.fusion.c.d dVar = this.f14055d;
            if (dVar != null && dVar.o() != 2) {
                this.f14055d.d(f());
            }
            D();
            ad();
            com.beizi.ad.v2.d.a aVar = this.f14145t;
            if (aVar != null) {
                aVar.o();
            }
        }
    }

    private void a(com.beizi.ad.i iVar) {
        com.beizi.fusion.c.d dVar = this.f14055d;
        if (dVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> n6 = dVar.n();
        f();
        n6.toString();
        Z();
        com.beizi.fusion.c.e eVar = this.f14058g;
        if (eVar == com.beizi.fusion.c.e.SUCCESS) {
            if (this.f14147v != null) {
                this.f14055d.a(f(), this.f14147v);
                return;
            } else {
                this.f14055d.a(10140);
                return;
            }
        }
        if (eVar == com.beizi.fusion.c.e.FAIL) {
            f();
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

    private boolean b(final AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long longValue = ((Long) an.b(this.f14139n, this.C, 0L)).longValue();
        if (longValue != 0) {
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            if (currentTimeMillis < this.A.getCoolTime()) {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.b.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.B.a(shakeViewBean);
                    }
                }, this.A.getCoolTime() - currentTimeMillis);
                return true;
            }
            ak.a().a(this.C);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.beizi.ad.i iVar, final int i6, final int i7, int i8) {
        try {
            if (!com.beizi.fusion.c.b.a().n() && aG()) {
                if (this.B == null) {
                    this.B = new ab(this.f14139n);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f14151z;
                if (shakeViewBean == null || this.B == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setShakeViewUuid(this.f14151z.getShakeViewUuid());
                    ao();
                }
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean a6 = a(this.f14151z.getOrderData(), this.f14145t.b());
                AdSpacesBean.BuyerBean.ShakeViewBean shakeView = (a6 == null || a6.getShakeView() == null) ? null : a6.getShakeView();
                if (i7 <= 0) {
                    i7 = i8;
                }
                this.B.a(this.P);
                View a7 = this.B.a(ap.b(this.f14139n, i6), ap.b(this.f14139n, i7), this.f14151z.getPosition());
                if (a7 != null) {
                    ViewGroup.LayoutParams layoutParams = a7.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f14151z;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            this.f14146u.addView(a7, layoutParams2);
                        }
                    }
                }
                a(shakeView);
                this.B.a(new ab.a() { // from class: com.beizi.fusion.work.b.d.14
                    @Override // com.beizi.fusion.tool.ab.a
                    public void a() {
                        try {
                            if (ar.a(d.this.f14147v) && !d.this.ad) {
                                d.this.T = true;
                                d.this.ad = true;
                                int[] iArr = new int[2];
                                d.this.f14147v.getLocationOnScreen(iArr);
                                int[] a8 = af.a(i6 / 2, i7 / 2);
                                if (iVar != null && d.this.f14147v != null) {
                                    iVar.a(d.this.f14147v, String.valueOf(a8[0]), String.valueOf(a8[1]), String.valueOf(a8[0] + iArr[0]), String.valueOf(a8[1] + iArr[1]), 2, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.b.d.14.1
                                        @Override // com.beizi.ad.internal.e.b
                                        public void a() {
                                            d.this.b();
                                        }

                                        @Override // com.beizi.ad.internal.e.b
                                        public void b() {
                                        }
                                    });
                                }
                                if (!d.this.D || d.this.A == null) {
                                    return;
                                }
                                d.this.D = false;
                                d.this.B.a(d.this.A);
                                an.a(d.this.f14139n, d.this.C, (Object) Long.valueOf(System.currentTimeMillis()));
                                ak.a().a(d.this.C, System.currentTimeMillis());
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.A;
                if (coolShakeViewBean != null) {
                    this.B.a(coolShakeViewBean, this.C);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
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
            com.beizi.ad.v2.d.a aVar = this.f14145t;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.beizi.ad.i iVar) {
        try {
            LinearLayout linearLayout = new LinearLayout(this.f14139n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout a6 = u.a(this.f14139n, iVar.l());
            a6.setVisibility(0);
            linearLayout.addView(a6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View b6 = u.b(this.f14139n, iVar.k());
            b6.setVisibility(0);
            linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b6.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            b6.setLayoutParams(layoutParams);
            this.f14146u.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int a7 = ap.a(this.f14139n, 12.0f);
            layoutParams2.setMargins(0, 0, a7, a7);
            linearLayout.setLayoutParams(layoutParams2);
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

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.f14151z;
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        ab abVar = this.B;
        if (abVar != null) {
            abVar.c(regulatoryAngle);
        }
        if (this.A == null) {
            this.D = true;
            this.B.a(shakeViewBean);
        } else if (b(shakeViewBean)) {
            this.B.a(this.A);
        } else if (aA()) {
            this.B.a(this.A);
        } else {
            this.D = true;
            this.B.a(shakeViewBean);
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            com.beizi.ad.v2.d.a aVar = this.f14145t;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, int i6) {
        View view;
        try {
            aI();
            if (this.L != null && this.f14147v != null && !this.ad && !this.T) {
                this.T = true;
                this.ad = true;
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.ac);
                    ao();
                }
                com.beizi.ad.i iVar = this.L;
                if (iVar == null || (view = this.f14147v) == null) {
                    return;
                }
                iVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.b.d.3
                    @Override // com.beizi.ad.internal.e.b
                    public void a() {
                        d.this.b();
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
            aI();
            if (this.L != null && this.f14147v != null && !this.ad) {
                this.T = true;
                this.ad = true;
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.ac);
                    ao();
                }
                com.beizi.ad.i iVar = this.L;
                if (iVar == null || (view = this.f14147v) == null) {
                    return;
                }
                iVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new com.beizi.ad.internal.e.b() { // from class: com.beizi.fusion.work.b.d.9
                    @Override // com.beizi.ad.internal.e.b
                    public void a() {
                        d.this.b();
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
