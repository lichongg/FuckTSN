package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smartrefresh.layout.constant.DimensionStatus;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SmartRefreshLayout extends ViewGroup implements m2.h, NestedScrollingParent, NestedScrollingChild {

    /* renamed from: i1, reason: collision with root package name */
    protected static boolean f37244i1;

    /* renamed from: j1, reason: collision with root package name */
    protected static m2.a f37245j1 = new f();

    /* renamed from: k1, reason: collision with root package name */
    protected static m2.b f37246k1 = new g();
    protected boolean A;
    protected boolean B;
    protected boolean C;
    protected boolean D;
    protected boolean E;
    protected boolean F;
    protected DimensionStatus F0;
    protected boolean G;
    protected int G0;
    protected boolean H;
    protected DimensionStatus H0;
    protected boolean I;
    protected int I0;
    protected boolean J;
    protected int J0;
    protected boolean K;
    protected float K0;
    protected boolean L;
    protected float L0;
    protected boolean M;
    protected float M0;
    protected boolean N;
    protected float N0;
    protected boolean O;
    protected m2.e O0;
    protected boolean P;
    protected m2.d P0;
    protected boolean Q;
    protected m2.c Q0;
    protected n2.d R;
    protected Paint R0;
    protected n2.b S;
    protected Handler S0;
    protected n2.c T;
    protected m2.g T0;
    protected m2.i U;
    protected List<com.scwang.smartrefresh.layout.util.b> U0;
    protected int[] V;
    protected RefreshState V0;
    protected int[] W;
    protected RefreshState W0;
    protected boolean X0;
    protected long Y0;
    protected long Z0;

    /* renamed from: a, reason: collision with root package name */
    protected int f37247a;

    /* renamed from: a0, reason: collision with root package name */
    protected int f37248a0;

    /* renamed from: a1, reason: collision with root package name */
    protected int f37249a1;

    /* renamed from: b, reason: collision with root package name */
    protected int f37250b;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f37251b0;

    /* renamed from: b1, reason: collision with root package name */
    protected int f37252b1;

    /* renamed from: c, reason: collision with root package name */
    protected int f37253c;

    /* renamed from: c0, reason: collision with root package name */
    protected NestedScrollingChildHelper f37254c0;

    /* renamed from: c1, reason: collision with root package name */
    protected boolean f37255c1;

    /* renamed from: d, reason: collision with root package name */
    protected int f37256d;

    /* renamed from: d1, reason: collision with root package name */
    protected boolean f37257d1;

    /* renamed from: e, reason: collision with root package name */
    protected int f37258e;

    /* renamed from: e1, reason: collision with root package name */
    MotionEvent f37259e1;

    /* renamed from: f, reason: collision with root package name */
    protected int f37260f;

    /* renamed from: f1, reason: collision with root package name */
    protected ValueAnimator f37261f1;

    /* renamed from: g, reason: collision with root package name */
    protected int f37262g;

    /* renamed from: g1, reason: collision with root package name */
    protected Animator.AnimatorListener f37263g1;

    /* renamed from: h, reason: collision with root package name */
    protected float f37264h;

    /* renamed from: h1, reason: collision with root package name */
    protected ValueAnimator.AnimatorUpdateListener f37265h1;

    /* renamed from: i, reason: collision with root package name */
    protected float f37266i;

    /* renamed from: j, reason: collision with root package name */
    protected float f37267j;

    /* renamed from: k, reason: collision with root package name */
    protected float f37268k;

    /* renamed from: k0, reason: collision with root package name */
    protected NestedScrollingParentHelper f37269k0;

    /* renamed from: l, reason: collision with root package name */
    protected float f37270l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f37271m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f37272n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f37273o;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f37274p;

    /* renamed from: p0, reason: collision with root package name */
    protected int f37275p0;

    /* renamed from: q, reason: collision with root package name */
    protected Interpolator f37276q;

    /* renamed from: r, reason: collision with root package name */
    protected int f37277r;

    /* renamed from: s, reason: collision with root package name */
    protected int f37278s;

    /* renamed from: t, reason: collision with root package name */
    protected int f37279t;

    /* renamed from: u, reason: collision with root package name */
    protected int f37280u;

    /* renamed from: v, reason: collision with root package name */
    protected Scroller f37281v;

    /* renamed from: w, reason: collision with root package name */
    protected VelocityTracker f37282w;

    /* renamed from: x, reason: collision with root package name */
    protected int[] f37283x;

    /* renamed from: y, reason: collision with root package name */
    protected boolean f37284y;

    /* renamed from: z, reason: collision with root package name */
    protected boolean f37285z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f37286a;

        a(boolean z5) {
            this.f37286a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.V0 == RefreshState.Refreshing) {
                m2.e eVar = smartRefreshLayout.O0;
                if (eVar == null || smartRefreshLayout.Q0 == null) {
                    smartRefreshLayout.K0();
                    return;
                }
                int d6 = eVar.d(smartRefreshLayout, this.f37286a);
                if (d6 < Integer.MAX_VALUE) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.f37271m) {
                        smartRefreshLayout2.f37256d = 0;
                        smartRefreshLayout2.f37266i = smartRefreshLayout2.f37268k;
                        smartRefreshLayout2.f37271m = false;
                        long currentTimeMillis = System.currentTimeMillis();
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        smartRefreshLayout3.E1(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout3.f37267j, smartRefreshLayout3.f37266i + smartRefreshLayout3.f37250b, 0));
                    }
                    SmartRefreshLayout.this.H0(RefreshState.RefreshFinish);
                }
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                n2.c cVar = smartRefreshLayout4.T;
                if (cVar != null) {
                    cVar.p(smartRefreshLayout4.O0, this.f37286a);
                }
                if (d6 < Integer.MAX_VALUE) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.f37250b <= 0) {
                        smartRefreshLayout5.F0(0, true);
                        SmartRefreshLayout.this.K0();
                        return;
                    }
                    ValueAnimator n02 = smartRefreshLayout5.n0(0, d6);
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    ValueAnimator.AnimatorUpdateListener e6 = smartRefreshLayout6.J ? smartRefreshLayout6.Q0.e(smartRefreshLayout6.f37250b) : null;
                    if (n02 == null || e6 == null) {
                        return;
                    }
                    n02.addUpdateListener(e6);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f37288a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f37289b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f37291a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$b$a$a, reason: collision with other inner class name */
            class C0725a extends AnimatorListenerAdapter {
                C0725a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SmartRefreshLayout.this.b(true);
                }
            }

            a(int i6) {
                this.f37291a = i6;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i6;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener e6 = (!smartRefreshLayout.I || (i6 = smartRefreshLayout.f37250b) >= 0) ? null : smartRefreshLayout.Q0.e(i6);
                if (e6 != null) {
                    e6.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                }
                if (e6 == null) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.f37250b < 0) {
                        ValueAnimator n02 = smartRefreshLayout2.n0(0, this.f37291a);
                        if (n02 == null || !b.this.f37289b) {
                            return;
                        }
                        n02.addListener(new C0725a());
                        return;
                    }
                }
                SmartRefreshLayout.this.F0(0, true);
                SmartRefreshLayout.this.K0();
                b bVar = b.this;
                if (bVar.f37289b) {
                    SmartRefreshLayout.this.b(true);
                }
            }
        }

        b(boolean z5, boolean z6) {
            this.f37288a = z5;
            this.f37289b = z6;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.V0 != RefreshState.Loading) {
                if (this.f37289b) {
                    smartRefreshLayout.b(true);
                    return;
                }
                return;
            }
            m2.d dVar = smartRefreshLayout.P0;
            if (dVar == null || smartRefreshLayout.Q0 == null) {
                smartRefreshLayout.K0();
                return;
            }
            int d6 = dVar.d(smartRefreshLayout, this.f37288a);
            if (d6 < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (smartRefreshLayout2.f37271m) {
                    smartRefreshLayout2.f37256d = 0;
                    smartRefreshLayout2.f37266i = smartRefreshLayout2.f37268k;
                    smartRefreshLayout2.f37271m = false;
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    smartRefreshLayout3.E1(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout3.f37267j, smartRefreshLayout3.f37266i + smartRefreshLayout3.f37250b, 0));
                }
                SmartRefreshLayout.this.H0(RefreshState.LoadFinish);
            }
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            n2.c cVar = smartRefreshLayout4.T;
            if (cVar != null) {
                cVar.n(smartRefreshLayout4.P0, this.f37288a);
            }
            if (d6 < Integer.MAX_VALUE) {
                SmartRefreshLayout.this.postDelayed(new a(d6), SmartRefreshLayout.this.f37250b < 0 ? d6 : 0L);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f37294a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37295b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.F0(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f37261f1 = null;
                if (smartRefreshLayout.V0 != RefreshState.ReleaseToRefresh) {
                    smartRefreshLayout.D1();
                }
                SmartRefreshLayout.this.I0();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout.this.f37267j = r2.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.y1();
            }
        }

        c(float f6, int i6) {
            this.f37294a = f6;
            this.f37295b = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f37261f1 = ValueAnimator.ofInt(smartRefreshLayout.f37250b, (int) (smartRefreshLayout.f37275p0 * this.f37294a));
            SmartRefreshLayout.this.f37261f1.setDuration(this.f37295b);
            SmartRefreshLayout.this.f37261f1.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.f37261f1.addUpdateListener(new a());
            SmartRefreshLayout.this.f37261f1.addListener(new b());
            SmartRefreshLayout.this.f37261f1.start();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f37299a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37300b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.F0(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f37261f1 = null;
                if (smartRefreshLayout.V0 != RefreshState.ReleaseToLoad) {
                    smartRefreshLayout.C1();
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.G) {
                    smartRefreshLayout2.I0();
                    return;
                }
                smartRefreshLayout2.G = false;
                smartRefreshLayout2.I0();
                SmartRefreshLayout.this.G = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout.this.f37267j = r2.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.A1();
            }
        }

        d(float f6, int i6) {
            this.f37299a = f6;
            this.f37300b = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f37261f1 = ValueAnimator.ofInt(smartRefreshLayout.f37250b, -((int) (smartRefreshLayout.G0 * this.f37299a)));
            SmartRefreshLayout.this.f37261f1.setDuration(this.f37300b);
            SmartRefreshLayout.this.f37261f1.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.f37261f1.addUpdateListener(new a());
            SmartRefreshLayout.this.f37261f1.addListener(new b());
            SmartRefreshLayout.this.f37261f1.start();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f implements m2.a {
        @Override // m2.a
        @NonNull
        public m2.d a(Context context, m2.h hVar) {
            return new BallPulseFooter(context);
        }

        f() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g implements m2.b {
        @Override // m2.b
        @NonNull
        public m2.e a(Context context, m2.h hVar) {
            return new BezierRadarHeader(context);
        }

        g() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements n2.d {
        h() {
        }

        @Override // n2.d
        public void a(m2.h hVar) {
            hVar.B(3000);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements n2.b {
        i() {
        }

        @Override // n2.b
        public void f(m2.h hVar) {
            hVar.S(2000);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.v1();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class k extends AnimatorListenerAdapter {
        k() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.Z0 = System.currentTimeMillis();
            SmartRefreshLayout.this.H0(RefreshState.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            n2.d dVar = smartRefreshLayout.R;
            if (dVar != null) {
                dVar.a(smartRefreshLayout);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            m2.e eVar = smartRefreshLayout2.O0;
            if (eVar != null) {
                eVar.h(smartRefreshLayout2, smartRefreshLayout2.f37275p0, smartRefreshLayout2.I0);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            n2.c cVar = smartRefreshLayout3.T;
            if (cVar != null) {
                cVar.a(smartRefreshLayout3);
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.T.r(smartRefreshLayout4.O0, smartRefreshLayout4.f37275p0, smartRefreshLayout4.I0);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class l extends AnimatorListenerAdapter {
        l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f37261f1 = null;
            if (smartRefreshLayout.f37250b != 0) {
                RefreshState refreshState = smartRefreshLayout.V0;
                if (refreshState != smartRefreshLayout.W0) {
                    smartRefreshLayout.setViceState(refreshState);
                    return;
                }
                return;
            }
            RefreshState refreshState2 = smartRefreshLayout.V0;
            RefreshState refreshState3 = RefreshState.None;
            if (refreshState2 == refreshState3 || refreshState2.opening) {
                return;
            }
            smartRefreshLayout.H0(refreshState3);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class m implements ValueAnimator.AnimatorUpdateListener {
        m() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.F0(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class n extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f37312a;

        n(int i6) {
            this.f37312a = i6;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f37261f1 = ValueAnimator.ofInt(smartRefreshLayout.f37250b, 0);
            SmartRefreshLayout.this.f37261f1.setDuration(this.f37312a);
            SmartRefreshLayout.this.f37261f1.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.f37261f1.addUpdateListener(smartRefreshLayout2.f37265h1);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.f37261f1.addListener(smartRefreshLayout3.f37263g1);
            SmartRefreshLayout.this.f37261f1.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class p implements m2.g {

        /* renamed from: a, reason: collision with root package name */
        SmartRefreshLayout f37316a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                p.this.f37316a.H0(RefreshState.TwoLevel);
            }
        }

        @Override // m2.g
        public m2.g a() {
            SmartRefreshLayout smartRefreshLayout = this.f37316a;
            DimensionStatus dimensionStatus = smartRefreshLayout.F0;
            if (dimensionStatus.notifyed) {
                smartRefreshLayout.F0 = dimensionStatus.unNotify();
            }
            return this;
        }

        @Override // m2.g
        public m2.g b(int i6) {
            this.f37316a.m0(i6);
            return this;
        }

        @Override // m2.g
        @NonNull
        public m2.h c() {
            return this.f37316a;
        }

        @Override // m2.g
        public m2.g d(boolean z5) {
            this.f37316a.f37257d1 = z5;
            return this;
        }

        @Override // m2.g
        public m2.g e(@NonNull RefreshState refreshState) {
            switch (e.f37305b[refreshState.ordinal()]) {
                case 1:
                    this.f37316a.K0();
                    break;
                case 2:
                    this.f37316a.y1();
                    break;
                case 3:
                    this.f37316a.A1();
                    break;
                case 4:
                    this.f37316a.x1();
                    break;
                case 5:
                    this.f37316a.z1();
                    break;
                case 6:
                    this.f37316a.D1();
                    break;
                case 7:
                    this.f37316a.C1();
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout = this.f37316a;
                    if (!smartRefreshLayout.V0.opening && smartRefreshLayout.g0()) {
                        this.f37316a.H0(RefreshState.ReleaseToTwoLevel);
                        break;
                    } else {
                        this.f37316a.setViceState(RefreshState.ReleaseToTwoLevel);
                        break;
                    }
                    break;
                case 9:
                    SmartRefreshLayout smartRefreshLayout2 = this.f37316a;
                    if (!smartRefreshLayout2.V0.opening && smartRefreshLayout2.g0()) {
                        this.f37316a.H0(RefreshState.RefreshReleased);
                        break;
                    } else {
                        this.f37316a.setViceState(RefreshState.RefreshReleased);
                        break;
                    }
                    break;
                case 10:
                    SmartRefreshLayout smartRefreshLayout3 = this.f37316a;
                    if (!smartRefreshLayout3.V0.opening && smartRefreshLayout3.z()) {
                        this.f37316a.H0(RefreshState.LoadReleased);
                        break;
                    } else {
                        this.f37316a.setViceState(RefreshState.LoadReleased);
                        break;
                    }
                case 11:
                    this.f37316a.B1();
                    break;
                case 12:
                    this.f37316a.w1();
                    break;
                case 13:
                    SmartRefreshLayout smartRefreshLayout4 = this.f37316a;
                    if (smartRefreshLayout4.V0 == RefreshState.Refreshing) {
                        smartRefreshLayout4.H0(RefreshState.RefreshFinish);
                        break;
                    }
                    break;
                case 14:
                    SmartRefreshLayout smartRefreshLayout5 = this.f37316a;
                    if (smartRefreshLayout5.V0 == RefreshState.Loading) {
                        smartRefreshLayout5.H0(RefreshState.LoadFinish);
                        break;
                    }
                    break;
            }
            return null;
        }

        @Override // m2.g
        public m2.g f(int i6) {
            SmartRefreshLayout smartRefreshLayout = this.f37316a;
            if (smartRefreshLayout.R0 == null && i6 != 0) {
                smartRefreshLayout.R0 = new Paint();
            }
            this.f37316a.f37249a1 = i6;
            return this;
        }

        @Override // m2.g
        public void g() {
            SmartRefreshLayout smartRefreshLayout = this.f37316a;
            if (smartRefreshLayout.V0 == RefreshState.TwoLevel) {
                smartRefreshLayout.H0(RefreshState.TwoLevelFinish);
                SmartRefreshLayout smartRefreshLayout2 = this.f37316a;
                if (smartRefreshLayout2.f37250b != 0) {
                    smartRefreshLayout2.m0(0).setDuration(this.f37316a.f37258e);
                } else {
                    k(0, true);
                    this.f37316a.H0(RefreshState.None);
                }
            }
        }

        @Override // m2.g
        public m2.g h(int i6) {
            this.f37316a.f37258e = i6;
            return this;
        }

        @Override // m2.g
        public m2.g i(boolean z5) {
            this.f37316a.f37255c1 = z5;
            return this;
        }

        @Override // m2.g
        public void j(boolean z5) {
            if (!z5) {
                if (b(0) == null) {
                    this.f37316a.H0(RefreshState.None);
                    return;
                }
                return;
            }
            a aVar = new a();
            SmartRefreshLayout smartRefreshLayout = this.f37316a;
            ValueAnimator m02 = smartRefreshLayout.m0(smartRefreshLayout.getMeasuredHeight());
            if (m02 != null) {
                if (m02 == this.f37316a.f37261f1) {
                    m02.setDuration(r1.f37258e);
                    m02.addListener(aVar);
                    return;
                }
            }
            aVar.onAnimationEnd(null);
        }

        @Override // m2.g
        public m2.g k(int i6, boolean z5) {
            this.f37316a.F0(i6, z5);
            return this;
        }

        @Override // m2.g
        public m2.g l(boolean z5) {
            SmartRefreshLayout smartRefreshLayout = this.f37316a;
            if (!smartRefreshLayout.Q) {
                smartRefreshLayout.Q = true;
                smartRefreshLayout.A = z5;
            }
            return this;
        }

        @Override // m2.g
        @NonNull
        public m2.c m() {
            return this.f37316a.Q0;
        }

        @Override // m2.g
        public m2.g n(int i6) {
            SmartRefreshLayout smartRefreshLayout = this.f37316a;
            if (smartRefreshLayout.R0 == null && i6 != 0) {
                smartRefreshLayout.R0 = new Paint();
            }
            this.f37316a.f37252b1 = i6;
            return this;
        }

        @Override // m2.g
        public m2.g o() {
            SmartRefreshLayout smartRefreshLayout = this.f37316a;
            DimensionStatus dimensionStatus = smartRefreshLayout.H0;
            if (dimensionStatus.notifyed) {
                smartRefreshLayout.H0 = dimensionStatus.unNotify();
            }
            return this;
        }

        public p(SmartRefreshLayout smartRefreshLayout) {
            this.f37316a = smartRefreshLayout;
        }
    }

    public SmartRefreshLayout(Context context) {
        super(context);
        this.f37258e = 250;
        this.f37260f = 250;
        this.f37270l = 0.5f;
        this.f37284y = true;
        this.f37285z = false;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.V = new int[2];
        this.W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.F0 = dimensionStatus;
        this.H0 = dimensionStatus;
        this.K0 = 2.5f;
        this.L0 = 2.5f;
        this.M0 = 1.0f;
        this.N0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.V0 = refreshState;
        this.W0 = refreshState;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0L;
        this.f37249a1 = 0;
        this.f37252b1 = 0;
        this.f37259e1 = null;
        this.f37263g1 = new l();
        this.f37265h1 = new m();
        D0(context, null);
    }

    private void D0(Context context, AttributeSet attributeSet) {
        setClipToPadding(false);
        com.scwang.smartrefresh.layout.util.c cVar = new com.scwang.smartrefresh.layout.util.c();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f37281v = new Scroller(context);
        this.T0 = new p(this);
        this.f37282w = VelocityTracker.obtain();
        this.f37262g = context.getResources().getDisplayMetrics().heightPixels;
        this.f37276q = new com.scwang.smartrefresh.layout.util.e();
        this.f37247a = viewConfiguration.getScaledTouchSlop();
        this.f37279t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f37280u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f37269k0 = new NestedScrollingParentHelper(this);
        this.f37254c0 = new NestedScrollingChildHelper(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        int i6 = R.styleable.SmartRefreshLayout_srlEnableNestedScrolling;
        ViewCompat.setNestedScrollingEnabled(this, obtainStyledAttributes.getBoolean(i6, false));
        this.f37270l = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.f37270l);
        this.K0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.K0);
        this.L0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.L0);
        this.M0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.M0);
        this.N0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.N0);
        this.f37284y = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.f37284y);
        this.f37260f = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f37260f);
        int i7 = R.styleable.SmartRefreshLayout_srlEnableLoadmore;
        this.f37285z = obtainStyledAttributes.getBoolean(i7, this.f37285z);
        int i8 = R.styleable.SmartRefreshLayout_srlHeaderHeight;
        this.f37275p0 = obtainStyledAttributes.getDimensionPixelOffset(i8, cVar.a(100.0f));
        int i9 = R.styleable.SmartRefreshLayout_srlFooterHeight;
        this.G0 = obtainStyledAttributes.getDimensionPixelOffset(i9, cVar.a(60.0f));
        this.L = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.L);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.M);
        int i10 = R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.A = obtainStyledAttributes.getBoolean(i10, this.A);
        this.B = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.B);
        this.D = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.D);
        this.G = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadmore, this.G);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.E);
        this.H = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.H);
        this.I = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.I);
        this.J = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.J);
        this.K = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadmoreWhenContentNotFull, this.K);
        this.C = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.C);
        this.F = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.F);
        this.f37277r = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, -1);
        this.f37278s = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, -1);
        this.O = obtainStyledAttributes.hasValue(i7);
        this.P = obtainStyledAttributes.hasValue(i6);
        this.Q = obtainStyledAttributes.hasValue(i10);
        this.F0 = obtainStyledAttributes.hasValue(i8) ? DimensionStatus.XmlLayoutUnNotify : this.F0;
        this.H0 = obtainStyledAttributes.hasValue(i9) ? DimensionStatus.XmlLayoutUnNotify : this.H0;
        this.I0 = (int) Math.max(this.f37275p0 * (this.K0 - 1.0f), 0.0f);
        this.J0 = (int) Math.max(this.G0 * (this.L0 - 1.0f), 0.0f);
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f37283x = new int[]{color2, color};
            } else {
                this.f37283x = new int[]{color2};
            }
        } else if (color != 0) {
            this.f37283x = new int[]{0, color};
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x009d, code lost:
    
        if (r2 > 0) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void F0(int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.F0(int, boolean):void");
    }

    @Override // m2.h
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout k() {
        b(false);
        return this;
    }

    @Override // m2.h
    public m2.h O(View view) {
        return C(view, -1, -1);
    }

    @Override // m2.h
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout v(boolean z5) {
        this.O = true;
        this.f37285z = z5;
        return this;
    }

    @Override // m2.h
    public boolean T() {
        return j0(0);
    }

    @Override // m2.h
    public SmartRefreshLayout getLayout() {
        return this;
    }

    protected ValueAnimator m0(int i6) {
        return n0(i6, 0);
    }

    @Override // m2.h
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout q(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr2[i6] = ContextCompat.getColor(getContext(), iArr[i6]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // m2.h
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout S(int i6) {
        return N(i6, true);
    }

    @Override // m2.h
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout i0(m2.d dVar) {
        return J(dVar, -1, -2);
    }

    @Override // m2.h
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout N(int i6, boolean z5) {
        return A(i6, z5, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z5) {
        this.P = true;
        this.f37254c0.setNestedScrollingEnabled(z5);
    }

    @Override // m2.h
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout l(m2.e eVar) {
        return m(eVar, -1, -2);
    }

    @Override // m2.h
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout B(int i6) {
        return M(i6, true);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37304a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f37305b;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f37305b = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37305b[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37305b[RefreshState.PullToUpLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37305b[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37305b[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37305b[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37305b[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f37305b[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f37305b[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f37305b[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f37305b[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f37305b[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f37305b[RefreshState.RefreshFinish.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f37305b[RefreshState.LoadFinish.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr2 = new int[SpinnerStyle.values().length];
            f37304a = iArr2;
            try {
                iArr2[SpinnerStyle.Translate.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f37304a[SpinnerStyle.Scale.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public static void setDefaultRefreshFooterCreater(@NonNull m2.a aVar) {
        f37245j1 = aVar;
        f37244i1 = true;
    }

    public static void setDefaultRefreshHeaderCreater(@NonNull m2.b bVar) {
        f37246k1 = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public o generateDefaultLayoutParams() {
        return new o(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public o generateLayoutParams(AttributeSet attributeSet) {
        return new o(getContext(), attributeSet);
    }

    protected void B1() {
        k kVar = new k();
        H0(RefreshState.RefreshReleased);
        ValueAnimator m02 = m0(this.f37275p0);
        if (m02 != null) {
            m02.addListener(kVar);
        }
        m2.e eVar = this.O0;
        if (eVar != null) {
            eVar.w(this, this.f37275p0, this.I0);
        }
        n2.c cVar = this.T;
        if (cVar != null) {
            cVar.s(this.O0, this.f37275p0, this.I0);
        }
        if (m02 == null) {
            kVar.onAnimationEnd(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    @Override // m2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public m2.h C(android.view.View r2, int r3, int r4) {
        /*
            r1 = this;
            if (r2 == 0) goto L8e
            m2.c r0 = r1.Q0
            if (r0 == 0) goto Ld
            android.view.View r0 = r0.getView()
            r1.removeView(r0)
        Ld:
            com.scwang.smartrefresh.layout.SmartRefreshLayout$o r0 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$o
            r0.<init>(r3, r4)
            r3 = 0
            r1.addView(r2, r3, r0)
            m2.e r3 = r1.O0
            if (r3 == 0) goto L39
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.FixedBehind
            if (r3 != r4) goto L39
            r1.bringChildToFront(r2)
            m2.d r3 = r1.P0
            if (r3 == 0) goto L5b
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
            if (r3 == r4) goto L5b
            m2.d r3 = r1.P0
            android.view.View r3 = r3.getView()
            r1.bringChildToFront(r3)
            goto L5b
        L39:
            m2.d r3 = r1.P0
            if (r3 == 0) goto L5b
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.FixedBehind
            if (r3 != r4) goto L5b
            r1.bringChildToFront(r2)
            m2.e r3 = r1.O0
            if (r3 == 0) goto L5b
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
            if (r3 != r4) goto L5b
            m2.e r3 = r1.O0
            android.view.View r3 = r3.getView()
            r1.bringChildToFront(r3)
        L5b:
            com.scwang.smartrefresh.layout.impl.a r3 = new com.scwang.smartrefresh.layout.impl.a
            r3.<init>(r2)
            r1.Q0 = r3
            android.os.Handler r2 = r1.S0
            if (r2 == 0) goto L8e
            int r2 = r1.f37277r
            r3 = 0
            if (r2 <= 0) goto L70
            android.view.View r2 = r1.findViewById(r2)
            goto L71
        L70:
            r2 = r3
        L71:
            int r4 = r1.f37278s
            if (r4 <= 0) goto L79
            android.view.View r3 = r1.findViewById(r4)
        L79:
            m2.c r4 = r1.Q0
            m2.i r0 = r1.U
            r4.a(r0)
            m2.c r4 = r1.Q0
            boolean r0 = r1.K
            r4.c(r0)
            m2.c r4 = r1.Q0
            m2.g r0 = r1.T0
            r4.o(r0, r2, r3)
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.C(android.view.View, int, int):m2.h");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public o generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new o(layoutParams);
    }

    protected void D1() {
        if (this.V0.opening || !g0()) {
            setViceState(RefreshState.ReleaseToRefresh);
        } else {
            H0(RefreshState.ReleaseToRefresh);
        }
    }

    protected boolean E0(int i6) {
        RefreshState refreshState;
        if (this.f37261f1 == null || i6 != 0 || (refreshState = this.V0) == RefreshState.LoadFinish || refreshState == RefreshState.RefreshFinish) {
            return false;
        }
        if (refreshState == RefreshState.PullDownCanceled) {
            y1();
        } else if (refreshState == RefreshState.PullUpCanceled) {
            A1();
        }
        this.f37261f1.cancel();
        this.f37261f1 = null;
        return true;
    }

    @Override // m2.h
    public boolean F() {
        return u(this.S0 == null ? 400 : 0);
    }

    protected void G0(float f6) {
        RefreshState refreshState;
        RefreshState refreshState2 = this.V0;
        if (refreshState2 == RefreshState.TwoLevel && f6 > 0.0f) {
            F0(Math.min((int) f6, getMeasuredHeight()), false);
        } else if (refreshState2 != RefreshState.Refreshing || f6 < 0.0f) {
            if (f6 >= 0.0f || !(refreshState2 == RefreshState.Loading || ((this.C && this.N) || (this.G && z() && !this.N)))) {
                if (f6 >= 0.0f) {
                    double d6 = this.I0 + this.f37275p0;
                    double max = Math.max(this.f37262g / 2, getHeight());
                    double max2 = Math.max(0.0f, this.f37270l * f6);
                    F0((int) Math.min(d6 * (1.0d - Math.pow(100.0d, (-max2) / max)), max2), false);
                } else {
                    double d7 = this.J0 + this.G0;
                    double max3 = Math.max(this.f37262g / 2, getHeight());
                    double d8 = -Math.min(0.0f, this.f37270l * f6);
                    F0((int) (-Math.min(d7 * (1.0d - Math.pow(100.0d, (-d8) / max3)), d8)), false);
                }
            } else if (f6 > (-this.G0)) {
                F0((int) f6, false);
            } else {
                double d9 = this.J0;
                int max4 = Math.max((this.f37262g * 4) / 3, getHeight());
                int i6 = this.G0;
                double d10 = max4 - i6;
                double d11 = -Math.min(0.0f, (i6 + f6) * this.f37270l);
                F0(((int) (-Math.min(d9 * (1.0d - Math.pow(100.0d, (-d11) / d10)), d11))) - this.G0, false);
            }
        } else if (f6 < this.f37275p0) {
            F0((int) f6, false);
        } else {
            double d12 = this.I0;
            int max5 = Math.max((this.f37262g * 4) / 3, getHeight());
            int i7 = this.f37275p0;
            double d13 = max5 - i7;
            double max6 = Math.max(0.0f, (f6 - i7) * this.f37270l);
            F0(((int) Math.min(d12 * (1.0d - Math.pow(100.0d, (-max6) / d13)), max6)) + this.f37275p0, false);
        }
        if (!this.G || !z() || f6 >= 0.0f || (refreshState = this.V0) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish || this.N) {
            return;
        }
        v1();
    }

    protected void H0(RefreshState refreshState) {
        RefreshState refreshState2 = this.V0;
        if (refreshState2 != refreshState) {
            this.V0 = refreshState;
            this.W0 = refreshState;
            m2.d dVar = this.P0;
            if (dVar != null) {
                dVar.x(this, refreshState2, refreshState);
            }
            m2.e eVar = this.O0;
            if (eVar != null) {
                eVar.x(this, refreshState2, refreshState);
            }
            n2.c cVar = this.T;
            if (cVar != null) {
                cVar.x(this, refreshState2, refreshState);
            }
        }
    }

    protected boolean I0() {
        RefreshState refreshState = this.V0;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.f37282w.getYVelocity() > -1000.0f && this.f37250b > getMeasuredHeight() / 2) {
                ValueAnimator m02 = m0(getMeasuredHeight());
                if (m02 != null) {
                    m02.setDuration(this.f37258e);
                }
            } else if (this.f37271m) {
                this.T0.g();
            }
            return this.f37271m;
        }
        if (refreshState == RefreshState.Loading || ((this.G && z() && !this.N && this.f37250b < 0 && this.V0 != RefreshState.Refreshing) || (this.C && this.N && this.f37250b < 0))) {
            int i6 = this.f37250b;
            int i7 = this.G0;
            if (i6 < (-i7)) {
                this.f37248a0 = -i7;
                m0(-i7);
                return true;
            }
            if (i6 <= 0) {
                return false;
            }
            this.f37248a0 = 0;
            m0(0);
            return true;
        }
        RefreshState refreshState2 = this.V0;
        if (refreshState2 == RefreshState.Refreshing) {
            int i8 = this.f37250b;
            int i9 = this.f37275p0;
            if (i8 > i9) {
                this.f37248a0 = i9;
                m0(i9);
                return true;
            }
            if (i8 >= 0) {
                return false;
            }
            this.f37248a0 = 0;
            m0(0);
            return true;
        }
        if (refreshState2 == RefreshState.PullDownToRefresh) {
            x1();
            return true;
        }
        if (refreshState2 == RefreshState.PullToUpLoad) {
            z1();
            return true;
        }
        if (refreshState2 == RefreshState.ReleaseToRefresh) {
            B1();
            return true;
        }
        if (refreshState2 == RefreshState.ReleaseToLoad) {
            w1();
            return true;
        }
        if (refreshState2 == RefreshState.ReleaseToTwoLevel) {
            H0(RefreshState.TwoLevelReleased);
            return true;
        }
        if (this.f37250b == 0) {
            return false;
        }
        m0(0);
        return true;
    }

    protected void K0() {
        RefreshState refreshState = this.V0;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2 && this.f37250b == 0) {
            H0(refreshState2);
        }
        if (this.f37250b != 0) {
            m0(0);
        }
    }

    @Override // m2.h
    public boolean L() {
        return this.N;
    }

    @Override // m2.h
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout K(boolean z5) {
        this.M = z5;
        return this;
    }

    @Override // m2.h
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout d(boolean z5) {
        this.L = z5;
        return this;
    }

    @Override // m2.h
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout l0(float f6) {
        this.f37270l = f6;
        return this;
    }

    @Override // m2.h
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout V(boolean z5) {
        this.G = z5;
        return this;
    }

    @Override // m2.h
    public boolean P() {
        return this.H;
    }

    @Override // m2.h
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout d0(boolean z5) {
        this.C = z5;
        return this;
    }

    @Override // m2.h
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout g(boolean z5) {
        this.B = z5;
        return this;
    }

    @Override // m2.h
    public boolean R(int i6, int i7, float f6) {
        if (this.V0 != RefreshState.None || !g0()) {
            return false;
        }
        ValueAnimator valueAnimator = this.f37261f1;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        c cVar = new c(f6, i7);
        if (i6 <= 0) {
            cVar.run();
            return true;
        }
        this.f37261f1 = new ValueAnimator();
        postDelayed(cVar, i6);
        return true;
    }

    @Override // m2.h
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout a0(boolean z5) {
        this.A = z5;
        this.Q = true;
        return this;
    }

    @Override // m2.h
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout c(boolean z5) {
        this.K = z5;
        m2.c cVar = this.Q0;
        if (cVar != null) {
            cVar.c(z5);
        }
        return this;
    }

    @Override // m2.h
    public boolean U() {
        return this.G;
    }

    @Override // m2.h
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout e0(boolean z5) {
        this.E = z5;
        return this;
    }

    @Override // m2.h
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout i(boolean z5) {
        this.F = z5;
        return this;
    }

    @Override // m2.h
    public boolean W(int i6, int i7, float f6) {
        if (this.V0 != RefreshState.None || !z() || this.N) {
            return false;
        }
        ValueAnimator valueAnimator = this.f37261f1;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        d dVar = new d(f6, i7);
        if (i6 <= 0) {
            dVar.run();
            return true;
        }
        this.f37261f1 = new ValueAnimator();
        postDelayed(dVar, i6);
        return true;
    }

    @Override // m2.h
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout o(boolean z5) {
        this.H = z5;
        return this;
    }

    @Override // m2.h
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout h0(boolean z5) {
        this.f37284y = z5;
        return this;
    }

    @Override // m2.h
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout r(boolean z5) {
        this.I = z5;
        return this;
    }

    @Override // m2.h
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout s(boolean z5) {
        this.J = z5;
        return this;
    }

    @Override // m2.h
    public m2.h a(m2.i iVar) {
        this.U = iVar;
        m2.c cVar = this.Q0;
        if (cVar != null) {
            cVar.a(iVar);
        }
        return this;
    }

    @Override // m2.h
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout j(int i6) {
        if (this.H0.canReplaceWith(DimensionStatus.CodeExact)) {
            this.G0 = i6;
            this.J0 = (int) Math.max(i6 * (this.L0 - 1.0f), 0.0f);
            this.H0 = DimensionStatus.CodeExactUnNotify;
            m2.d dVar = this.P0;
            if (dVar != null) {
                dVar.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // m2.h
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout f0(float f6) {
        this.L0 = f6;
        int max = (int) Math.max(this.G0 * (f6 - 1.0f), 0.0f);
        this.J0 = max;
        m2.d dVar = this.P0;
        if (dVar == null || this.S0 == null) {
            this.H0 = this.H0.unNotify();
            return this;
        }
        dVar.q(this.T0, this.G0, max);
        return this;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof o;
    }

    @Override // android.view.View
    public void computeScroll() {
        int currY = this.f37281v.getCurrY();
        if (this.f37281v.computeScrollOffset()) {
            int finalY = this.f37281v.getFinalY();
            if ((finalY <= 0 || !this.Q0.q()) && (finalY >= 0 || !this.Q0.n())) {
                this.X0 = true;
                invalidate();
                return;
            }
            if (this.X0) {
                int currVelocity = (int) this.f37281v.getCurrVelocity();
                AnimationUtils.currentAnimationTimeMillis();
                int abs = (Math.abs(this.f37281v.getCurrY() - currY) * 1000) / currVelocity;
                if (finalY > 0) {
                    if (z() || this.F) {
                        if (this.G && z() && !this.N) {
                            p0(-((int) (this.G0 * Math.pow((currVelocity * 1.0d) / this.f37280u, 0.5d))));
                            RefreshState refreshState = this.V0;
                            if (!refreshState.opening && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
                                v1();
                            }
                        } else if (this.E) {
                            p0(-((int) (this.G0 * Math.pow((currVelocity * 1.0d) / this.f37280u, 0.5d))));
                        }
                    }
                } else if ((g0() || this.F) && this.E) {
                    p0((int) (this.f37275p0 * Math.pow((currVelocity * 1.0d) / this.f37280u, 0.5d)));
                }
                this.X0 = false;
            }
            this.f37281v.forceFinished(true);
        }
    }

    @Override // m2.h
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout f(float f6) {
        this.N0 = f6;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        int i6;
        boolean z5 = this.D && isInEditMode();
        if (!g0() || (i6 = this.f37249a1) == 0 || (this.f37250b <= 0 && !z5)) {
            canvas2 = canvas;
            if (z() && this.f37252b1 != 0 && (this.f37250b < 0 || z5)) {
                int height = getHeight();
                this.R0.setColor(this.f37252b1);
                canvas2.drawRect(0.0f, height - (z5 ? this.G0 : -this.f37250b), getWidth(), height, this.R0);
            }
        } else {
            this.R0.setColor(i6);
            canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, getWidth(), z5 ? this.f37275p0 : this.f37250b, this.R0);
        }
        super.dispatchDraw(canvas2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        return this.f37254c0.dispatchNestedFling(f6, f7, z5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f6, float f7) {
        return this.f37254c0.dispatchNestedPreFling(f6, f7);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i6, int i7, int[] iArr, int[] iArr2) {
        return this.f37254c0.dispatchNestedPreScroll(i6, i7, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, int[] iArr) {
        return this.f37254c0.dispatchNestedScroll(i6, i7, i8, i9, iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if (r6 != 3) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x012b, code lost:
    
        if (r6 != 3) goto L226;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 848
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // m2.h
    public boolean e() {
        return this.E;
    }

    @Override // m2.h
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout Z(int i6) {
        if (this.F0.canReplaceWith(DimensionStatus.CodeExact)) {
            this.f37275p0 = i6;
            this.I0 = (int) Math.max(i6 * (this.K0 - 1.0f), 0.0f);
            this.F0 = DimensionStatus.CodeExactUnNotify;
            m2.e eVar = this.O0;
            if (eVar != null) {
                eVar.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // m2.h
    public boolean g0() {
        return this.f37284y && !this.H;
    }

    @Override // m2.h
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout E(float f6) {
        this.K0 = f6;
        int max = (int) Math.max(this.f37275p0 * (f6 - 1.0f), 0.0f);
        this.I0 = max;
        m2.e eVar = this.O0;
        if (eVar == null || this.S0 == null) {
            this.F0 = this.F0.unNotify();
            return this;
        }
        eVar.q(this.T0, this.f37275p0, max);
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f37269k0.getNestedScrollAxes();
    }

    @Override // m2.h
    @Nullable
    public m2.d getRefreshFooter() {
        return this.P0;
    }

    @Override // m2.h
    @Nullable
    public m2.e getRefreshHeader() {
        return this.O0;
    }

    @Override // m2.h
    public RefreshState getState() {
        return this.V0;
    }

    protected RefreshState getViceState() {
        return this.W0;
    }

    @Override // m2.h
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout n(float f6) {
        this.M0 = f6;
        return this;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f37254c0.hasNestedScrollingParent();
    }

    @Override // m2.h
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout b(boolean z5) {
        this.N = z5;
        m2.d dVar = this.P0;
        if (dVar != null) {
            dVar.b(z5);
        }
        return this;
    }

    @Override // m2.h
    public boolean isLoading() {
        return this.V0 == RefreshState.Loading;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f37254c0.isNestedScrollingEnabled();
    }

    @Override // m2.h
    public boolean j0(int i6) {
        return W(i6, this.f37260f, (((this.J0 / 2) + r1) * 1.0f) / this.G0);
    }

    @Override // m2.h
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout b0(n2.b bVar) {
        this.S = bVar;
        this.f37285z = this.f37285z || !(this.O || bVar == null);
        return this;
    }

    @Override // m2.h
    public boolean k0() {
        return this.I;
    }

    @Override // m2.h
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout I(n2.c cVar) {
        this.T = cVar;
        return this;
    }

    @Override // m2.h
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout p(n2.d dVar) {
        this.R = dVar;
        return this;
    }

    @Override // m2.h
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout D(n2.e eVar) {
        this.R = eVar;
        this.S = eVar;
        this.f37285z = this.f37285z || !(this.O || eVar == null);
        return this;
    }

    protected ValueAnimator n0(int i6, int i7) {
        return o0(i6, i7, this.f37276q);
    }

    @Override // m2.h
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout setPrimaryColors(int... iArr) {
        m2.e eVar = this.O0;
        if (eVar != null) {
            eVar.setPrimaryColors(iArr);
        }
        m2.d dVar = this.P0;
        if (dVar != null) {
            dVar.setPrimaryColors(iArr);
        }
        this.f37283x = iArr;
        return this;
    }

    protected ValueAnimator o0(int i6, int i7, Interpolator interpolator) {
        if (this.f37250b == i6) {
            return null;
        }
        ValueAnimator valueAnimator = this.f37261f1;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f37250b, i6);
        this.f37261f1 = ofInt;
        ofInt.setDuration(this.f37260f);
        this.f37261f1.setInterpolator(interpolator);
        this.f37261f1.addUpdateListener(this.f37265h1);
        this.f37261f1.addListener(this.f37263g1);
        this.f37261f1.setStartDelay(i7);
        this.f37261f1.start();
        return this.f37261f1;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        float f6;
        int i8;
        int i9;
        int i10 = 0;
        boolean z5 = isInEditMode() && this.D;
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            m2.e eVar = this.O0;
            if (eVar == null || eVar.getView() != childAt) {
                f6 = 1.0f;
            } else {
                View view = this.O0.getView();
                f6 = 1.0f;
                o oVar = (o) view.getLayoutParams();
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, ((ViewGroup.MarginLayoutParams) oVar).width);
                if (this.F0.gteReplaceWith(DimensionStatus.XmlLayoutUnNotify)) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(this.f37275p0 - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, i10), 1073741824));
                } else if (this.O0.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                    if (this.F0.notifyed) {
                        i9 = 0;
                    } else {
                        measureChild(view, childMeasureSpec, i7);
                        i9 = view.getMeasuredHeight();
                    }
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i7), 1073741824));
                    if (i9 > 0 && i9 != view.getMeasuredHeight()) {
                        this.f37275p0 = i9 + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
                    }
                } else {
                    int i13 = ((ViewGroup.MarginLayoutParams) oVar).height;
                    if (i13 > 0) {
                        DimensionStatus dimensionStatus = this.F0;
                        DimensionStatus dimensionStatus2 = DimensionStatus.XmlExactUnNotify;
                        if (dimensionStatus.canReplaceWith(dimensionStatus2)) {
                            this.f37275p0 = ((ViewGroup.MarginLayoutParams) oVar).height + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
                            this.F0 = dimensionStatus2;
                        }
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) oVar).height, 1073741824));
                    } else if (i13 == -2) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(View.MeasureSpec.getSize(i7) - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight = view.getMeasuredHeight();
                        if (measuredHeight > 0) {
                            DimensionStatus dimensionStatus3 = this.F0;
                            DimensionStatus dimensionStatus4 = DimensionStatus.XmlWrapUnNotify;
                            if (dimensionStatus3.canReplaceWith(dimensionStatus4)) {
                                this.F0 = dimensionStatus4;
                                this.f37275p0 = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
                            }
                        }
                        if (measuredHeight <= 0) {
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(this.f37275p0 - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, 0), 1073741824));
                        }
                    } else if (i13 == -1) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(this.f37275p0 - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, 0), 1073741824));
                    } else {
                        view.measure(childMeasureSpec, i7);
                    }
                }
                if (this.O0.getSpinnerStyle() == SpinnerStyle.Scale && !z5) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(Math.max(0, g0() ? this.f37250b : 0) - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, 0), 1073741824));
                }
                DimensionStatus dimensionStatus5 = this.F0;
                if (!dimensionStatus5.notifyed) {
                    this.F0 = dimensionStatus5.notifyed();
                    int max = (int) Math.max(this.f37275p0 * (this.K0 - 1.0f), 0.0f);
                    this.I0 = max;
                    this.O0.q(this.T0, this.f37275p0, max);
                }
                if (z5 && g0()) {
                    i12 += view.getMeasuredHeight();
                }
            }
            m2.d dVar = this.P0;
            if (dVar != null && dVar.getView() == childAt) {
                View view2 = this.P0.getView();
                o oVar2 = (o) view2.getLayoutParams();
                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, ((ViewGroup.MarginLayoutParams) oVar2).leftMargin + ((ViewGroup.MarginLayoutParams) oVar2).rightMargin, ((ViewGroup.MarginLayoutParams) oVar2).width);
                if (this.H0.gteReplaceWith(DimensionStatus.XmlLayoutUnNotify)) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(this.G0 - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, 0), 1073741824));
                } else if (this.P0.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                    if (this.H0.notifyed) {
                        i8 = 0;
                    } else {
                        measureChild(view2, childMeasureSpec2, i7);
                        i8 = view2.getMeasuredHeight();
                    }
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i7), 1073741824));
                    if (i8 > 0 && i8 != view2.getMeasuredHeight()) {
                        this.f37275p0 = i8 + ((ViewGroup.MarginLayoutParams) oVar2).bottomMargin;
                    }
                } else {
                    int i14 = ((ViewGroup.MarginLayoutParams) oVar2).height;
                    if (i14 > 0) {
                        DimensionStatus dimensionStatus6 = this.H0;
                        DimensionStatus dimensionStatus7 = DimensionStatus.XmlExactUnNotify;
                        if (dimensionStatus6.canReplaceWith(dimensionStatus7)) {
                            this.G0 = ((ViewGroup.MarginLayoutParams) oVar2).height + ((ViewGroup.MarginLayoutParams) oVar2).topMargin;
                            this.H0 = dimensionStatus7;
                        }
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) oVar2).height, 1073741824));
                    } else if (i14 == -2) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(View.MeasureSpec.getSize(i7) - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight2 = view2.getMeasuredHeight();
                        if (measuredHeight2 > 0) {
                            DimensionStatus dimensionStatus8 = this.H0;
                            DimensionStatus dimensionStatus9 = DimensionStatus.XmlWrapUnNotify;
                            if (dimensionStatus8.canReplaceWith(dimensionStatus9)) {
                                this.H0 = dimensionStatus9;
                                this.G0 = view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) oVar2).topMargin;
                            }
                        }
                        if (measuredHeight2 <= 0) {
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(this.G0 - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, 0), 1073741824));
                        }
                    } else if (i14 == -1) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(this.G0 - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, 0), 1073741824));
                    } else {
                        view2.measure(childMeasureSpec2, i7);
                    }
                }
                if (this.P0.getSpinnerStyle() == SpinnerStyle.Scale && !z5) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(Math.max(0, this.f37285z ? -this.f37250b : 0) - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, 0), 1073741824));
                }
                DimensionStatus dimensionStatus10 = this.H0;
                if (!dimensionStatus10.notifyed) {
                    this.H0 = dimensionStatus10.notifyed();
                    int max2 = (int) Math.max(this.G0 * (this.L0 - f6), 0.0f);
                    this.J0 = max2;
                    this.P0.q(this.T0, this.G0, max2);
                }
                if (z5 && this.f37285z) {
                    i12 += view2.getMeasuredHeight();
                }
            }
            m2.c cVar = this.Q0;
            if (cVar != null && cVar.getView() == childAt) {
                o oVar3 = (o) this.Q0.getLayoutParams();
                this.Q0.g(ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) oVar3).leftMargin + ((ViewGroup.MarginLayoutParams) oVar3).rightMargin, ((ViewGroup.MarginLayoutParams) oVar3).width), ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) oVar3).topMargin + ((ViewGroup.MarginLayoutParams) oVar3).bottomMargin + ((z5 && g0() && (this.A || this.O0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) ? this.f37275p0 : 0) + ((z5 && z() && (this.B || this.P0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) ? this.G0 : 0), ((ViewGroup.MarginLayoutParams) oVar3).height));
                this.Q0.j(this.f37275p0, this.G0);
                i12 += this.Q0.h();
            }
            i11++;
            i10 = 0;
        }
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(i12, i7));
        this.f37267j = getMeasuredWidth() / 2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f6, float f7) {
        RefreshState refreshState;
        if (this.f37250b != 0 && this.V0.opening) {
            m0(0);
        }
        if (this.f37261f1 != null || (refreshState = this.V0) == RefreshState.ReleaseToRefresh || refreshState == RefreshState.ReleaseToLoad) {
            return true;
        }
        if (refreshState != RefreshState.PullDownToRefresh || this.f37250b <= 0) {
            return (refreshState == RefreshState.PullToUpLoad && this.f37250b > 0) || dispatchNestedPreFling(f6, f7);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i6, int i7, @NonNull int[] iArr) {
        int i8;
        int i9;
        int i10;
        int i11;
        if (!this.V0.opening) {
            if (g0() && i7 > 0 && (i9 = this.f37248a0) > 0) {
                if (i7 > i9) {
                    iArr[1] = i7 - i9;
                    this.f37248a0 = 0;
                } else {
                    this.f37248a0 = i9 - i7;
                    iArr[1] = i7;
                }
                G0(this.f37248a0);
            } else if (z() && i7 < 0 && (i8 = this.f37248a0) < 0) {
                if (i7 < i8) {
                    iArr[1] = i7 - i8;
                    this.f37248a0 = 0;
                } else {
                    this.f37248a0 = i8 - i7;
                    iArr[1] = i7;
                }
                G0(this.f37248a0);
            }
            int[] iArr2 = this.V;
            if (dispatchNestedPreScroll(i6 - iArr[0], i7 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
                return;
            }
            return;
        }
        int[] iArr3 = this.V;
        if (dispatchNestedPreScroll(i6, i7, iArr3, null)) {
            i7 -= iArr3[1];
        }
        RefreshState refreshState = this.V0;
        if ((refreshState == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel) && (this.f37248a0 * i7 > 0 || this.f37256d > 0)) {
            iArr[1] = 0;
            if (Math.abs(i7) > Math.abs(this.f37248a0)) {
                iArr[1] = iArr[1] + this.f37248a0;
                this.f37248a0 = 0;
                if (this.f37256d <= 0) {
                    G0(0.0f);
                }
            } else {
                this.f37248a0 = this.f37248a0 - i7;
                iArr[1] = iArr[1] + i7;
                G0(r5 + this.f37256d);
                i7 = 0;
            }
            if (i7 <= 0 || (i10 = this.f37256d) <= 0) {
                return;
            }
            if (i7 > i10) {
                iArr[1] = iArr[1] + i10;
                this.f37256d = 0;
            } else {
                this.f37256d = i10 - i7;
                iArr[1] = iArr[1] + i7;
            }
            G0(this.f37256d);
            return;
        }
        if (refreshState == RefreshState.Loading) {
            if (this.f37248a0 * i7 > 0 || this.f37256d < 0) {
                iArr[1] = 0;
                if (Math.abs(i7) > Math.abs(this.f37248a0)) {
                    iArr[1] = iArr[1] + this.f37248a0;
                    this.f37248a0 = 0;
                    if (this.f37256d >= 0) {
                        G0(0.0f);
                    }
                } else {
                    this.f37248a0 = this.f37248a0 - i7;
                    iArr[1] = iArr[1] + i7;
                    G0(r5 + this.f37256d);
                    i7 = 0;
                }
                if (i7 >= 0 || (i11 = this.f37256d) >= 0) {
                    return;
                }
                if (i7 < i11) {
                    iArr[1] = iArr[1] + i11;
                    this.f37256d = 0;
                } else {
                    this.f37256d = i11 - i7;
                    iArr[1] = iArr[1] + i7;
                }
                G0(this.f37256d);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i6, int i7, int i8, int i9) {
        m2.c cVar;
        m2.c cVar2;
        dispatchNestedScroll(i6, i7, i8, i9, this.W);
        int i10 = i9 + this.W[1];
        if (this.V0.opening) {
            if (g0() && i10 < 0 && ((cVar2 = this.Q0) == null || cVar2.n())) {
                this.f37248a0 = this.f37248a0 + Math.abs(i10);
                G0(r7 + this.f37256d);
                return;
            } else {
                if (!z() || i10 <= 0) {
                    return;
                }
                m2.c cVar3 = this.Q0;
                if (cVar3 == null || cVar3.q()) {
                    this.f37248a0 = this.f37248a0 - Math.abs(i10);
                    G0(r7 + this.f37256d);
                    return;
                }
                return;
            }
        }
        if (g0() && i10 < 0 && ((cVar = this.Q0) == null || cVar.n())) {
            if (this.V0 == RefreshState.None) {
                y1();
            }
            int abs = this.f37248a0 + Math.abs(i10);
            this.f37248a0 = abs;
            G0(abs);
            return;
        }
        if (!z() || i10 <= 0) {
            return;
        }
        m2.c cVar4 = this.Q0;
        if (cVar4 == null || cVar4.q()) {
            if (this.V0 == RefreshState.None && !this.N) {
                A1();
            }
            int abs2 = this.f37248a0 - Math.abs(i10);
            this.f37248a0 = abs2;
            G0(abs2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i6) {
        this.f37269k0.onNestedScrollAccepted(view, view2, i6);
        startNestedScroll(i6 & 2);
        this.f37248a0 = 0;
        this.f37256d = this.f37250b;
        this.f37251b0 = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.f37269k0.onStopNestedScroll(view);
        this.f37251b0 = false;
        this.f37248a0 = 0;
        I0();
        stopNestedScroll();
    }

    protected ValueAnimator p0(int i6) {
        int max;
        if (this.f37261f1 == null) {
            int i7 = (this.f37260f * 2) / 3;
            this.f37267j = getMeasuredWidth() / 2;
            RefreshState refreshState = this.V0;
            RefreshState refreshState2 = RefreshState.Refreshing;
            if ((refreshState == refreshState2 || refreshState == RefreshState.TwoLevel) && i6 > 0) {
                ValueAnimator ofInt = ValueAnimator.ofInt(this.f37250b, Math.min(i6 * 2, this.f37275p0));
                this.f37261f1 = ofInt;
                ofInt.addListener(this.f37263g1);
            } else if (i6 < 0 && (refreshState == RefreshState.Loading || ((this.C && this.N) || (this.G && z() && !this.N && this.V0 != refreshState2)))) {
                ValueAnimator ofInt2 = ValueAnimator.ofInt(this.f37250b, Math.max((i6 * 7) / 2, -this.G0));
                this.f37261f1 = ofInt2;
                ofInt2.addListener(this.f37263g1);
            } else if (this.f37250b == 0 && this.E) {
                if (i6 > 0) {
                    if (this.V0 != RefreshState.Loading) {
                        y1();
                    }
                    max = Math.max(150, (i6 * 250) / this.f37275p0);
                    this.f37261f1 = ValueAnimator.ofInt(0, Math.min(i6, this.f37275p0));
                } else {
                    if (this.V0 != refreshState2) {
                        A1();
                    }
                    max = Math.max(150, ((-i6) * 250) / this.G0);
                    this.f37261f1 = ValueAnimator.ofInt(0, Math.max(i6, -this.G0));
                }
                i7 = max;
                this.f37261f1.addListener(new n(i7));
            }
            ValueAnimator valueAnimator = this.f37261f1;
            if (valueAnimator != null) {
                valueAnimator.setDuration(i7);
                this.f37261f1.setInterpolator(new DecelerateInterpolator());
                this.f37261f1.addUpdateListener(this.f37265h1);
                this.f37261f1.start();
            }
        }
        return this.f37261f1;
    }

    @Override // m2.h
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout y(int i6) {
        this.f37260f = i6;
        return this;
    }

    @Override // android.view.View
    public boolean post(Runnable runnable) {
        Handler handler = this.S0;
        if (handler != null) {
            return handler.post(new com.scwang.smartrefresh.layout.util.b(runnable));
        }
        List<com.scwang.smartrefresh.layout.util.b> list = this.U0;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.U0 = list;
        list.add(new com.scwang.smartrefresh.layout.util.b(runnable));
        return false;
    }

    @Override // android.view.View
    public boolean postDelayed(Runnable runnable, long j6) {
        if (j6 == 0) {
            new com.scwang.smartrefresh.layout.util.b(runnable).run();
            return true;
        }
        Handler handler = this.S0;
        if (handler != null) {
            return handler.postDelayed(new com.scwang.smartrefresh.layout.util.b(runnable), j6);
        }
        List<com.scwang.smartrefresh.layout.util.b> list = this.U0;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.U0 = list;
        list.add(new com.scwang.smartrefresh.layout.util.b(runnable, j6));
        return false;
    }

    @Override // m2.h
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout H(Interpolator interpolator) {
        this.f37276q = interpolator;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        View l6 = this.Q0.l();
        if (l6 == null || ViewCompat.isNestedScrollingEnabled(l6)) {
            super.requestDisallowInterceptTouchEvent(z5);
        }
    }

    @Override // m2.h
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout J(m2.d dVar, int i6, int i7) {
        if (dVar != null) {
            m2.d dVar2 = this.P0;
            if (dVar2 != null) {
                removeView(dVar2.getView());
            }
            this.P0 = dVar;
            this.H0 = this.H0.unNotify();
            this.f37285z = !this.O || this.f37285z;
            if (this.P0.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                addView(this.P0.getView(), 0, new o(i6, i7));
                return this;
            }
            addView(this.P0.getView(), i6, i7);
        }
        return this;
    }

    protected void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.V0;
        if (refreshState2.draging && refreshState2.isHeader() != refreshState.isHeader()) {
            H0(RefreshState.None);
        }
        if (this.W0 != refreshState) {
            this.W0 = refreshState;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i6) {
        return this.f37254c0.startNestedScroll(i6);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f37254c0.stopNestedScroll();
    }

    @Override // m2.h
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout A(int i6, boolean z5, boolean z6) {
        postDelayed(new b(z5, z6), i6 <= 0 ? 1L : i6);
        return this;
    }

    @Override // m2.h
    public boolean u(int i6) {
        return R(i6, this.f37260f, (((this.I0 / 2) + r1) * 1.0f) / this.f37275p0);
    }

    @Override // m2.h
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout m(m2.e eVar, int i6, int i7) {
        if (eVar != null) {
            m2.e eVar2 = this.O0;
            if (eVar2 != null) {
                removeView(eVar2.getView());
            }
            this.O0 = eVar;
            this.F0 = this.F0.unNotify();
            if (eVar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                addView(this.O0.getView(), 0, new o(i6, i7));
                return this;
            }
            addView(this.O0.getView(), i6, i7);
        }
        return this;
    }

    protected void v1() {
        RefreshState refreshState = this.V0;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.Y0 = System.currentTimeMillis();
            RefreshState refreshState3 = this.V0;
            RefreshState refreshState4 = RefreshState.LoadReleased;
            if (refreshState3 != refreshState4) {
                if (refreshState3 != RefreshState.ReleaseToLoad) {
                    if (refreshState3 != RefreshState.PullToUpLoad) {
                        A1();
                    }
                    C1();
                }
                H0(refreshState4);
                m2.d dVar = this.P0;
                if (dVar != null) {
                    dVar.k(this, this.G0, this.J0);
                }
            }
            H0(refreshState2);
            m2.d dVar2 = this.P0;
            if (dVar2 != null) {
                dVar2.h(this, this.G0, this.J0);
            }
            n2.b bVar = this.S;
            if (bVar != null) {
                bVar.f(this);
            }
            n2.c cVar = this.T;
            if (cVar != null) {
                cVar.f(this);
                this.T.u(this.P0, this.G0, this.J0);
            }
        }
    }

    protected void w1() {
        j jVar = new j();
        H0(RefreshState.LoadReleased);
        ValueAnimator m02 = m0(-this.G0);
        if (m02 != null) {
            m02.addListener(jVar);
        }
        m2.d dVar = this.P0;
        if (dVar != null) {
            dVar.k(this, this.G0, this.J0);
        }
        n2.c cVar = this.T;
        if (cVar != null) {
            cVar.e(this.P0, this.G0, this.J0);
        }
        if (m02 == null) {
            jVar.onAnimationEnd(null);
        }
    }

    @Override // m2.h
    public boolean x() {
        return this.V0 == RefreshState.Refreshing;
    }

    protected void x1() {
        if (this.V0.opening || !g0()) {
            setViceState(RefreshState.PullDownCanceled);
        } else {
            H0(RefreshState.PullDownCanceled);
            K0();
        }
    }

    @Override // m2.h
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout M(int i6, boolean z5) {
        postDelayed(new a(z5), i6 <= 0 ? 1L : i6);
        return this;
    }

    protected void y1() {
        if (this.V0.opening || !g0()) {
            setViceState(RefreshState.PullDownToRefresh);
        } else {
            H0(RefreshState.PullDownToRefresh);
        }
    }

    @Override // m2.h
    public boolean z() {
        return this.f37285z && !this.H;
    }

    protected void A1() {
        if (z() && !this.N && !this.V0.opening) {
            H0(RefreshState.PullToUpLoad);
        } else {
            setViceState(RefreshState.PullToUpLoad);
        }
    }

    protected void C1() {
        if (z() && !this.N && !this.V0.opening) {
            H0(RefreshState.ReleaseToLoad);
        } else {
            setViceState(RefreshState.ReleaseToLoad);
        }
    }

    protected boolean E1(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            float f6 = -this.f37282w.getYVelocity();
            if (Math.abs(f6) > this.f37279t && this.f37250b == 0 && this.f37256d == 0) {
                this.X0 = false;
                this.f37281v.fling(0, getScrollY(), 0, (int) f6, 0, 0, -2147483647, Integer.MAX_VALUE);
                this.f37281v.computeScrollOffset();
                invalidate();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // m2.h
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout h(float f6) {
        return j(com.scwang.smartrefresh.layout.util.c.b(f6));
    }

    @Override // m2.h
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout c0(float f6) {
        return Z(com.scwang.smartrefresh.layout.util.c.b(f6));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        m2.c cVar;
        View view;
        m2.d dVar;
        boolean z5;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.S0 == null) {
                this.S0 = new Handler();
            }
            List<com.scwang.smartrefresh.layout.util.b> list = this.U0;
            View view2 = null;
            if (list != null) {
                for (com.scwang.smartrefresh.layout.util.b bVar : list) {
                    this.S0.postDelayed(bVar, bVar.f37475a);
                }
                this.U0.clear();
                this.U0 = null;
            }
            if (this.O0 == null) {
                m2.e a6 = f37246k1.a(getContext(), this);
                this.O0 = a6;
                if (!(a6.getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    if (this.O0.getSpinnerStyle() == SpinnerStyle.Scale) {
                        addView(this.O0.getView(), -1, -1);
                    } else {
                        addView(this.O0.getView(), -1, -2);
                    }
                }
            }
            if (this.P0 == null) {
                m2.d a7 = f37245j1.a(getContext(), this);
                this.P0 = a7;
                if (!this.f37285z && (this.O || !f37244i1)) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                this.f37285z = z5;
                if (!(a7.getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    if (this.P0.getSpinnerStyle() == SpinnerStyle.Scale) {
                        addView(this.P0.getView(), -1, -1);
                    } else {
                        addView(this.P0.getView(), -1, -2);
                    }
                }
            }
            int childCount = getChildCount();
            int i6 = 0;
            while (true) {
                cVar = this.Q0;
                if (cVar != null || i6 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i6);
                m2.e eVar = this.O0;
                if ((eVar == null || childAt != eVar.getView()) && ((dVar = this.P0) == null || childAt != dVar.getView())) {
                    this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt);
                }
                i6++;
            }
            if (cVar == null) {
                this.Q0 = new com.scwang.smartrefresh.layout.impl.a(getContext());
            }
            int i7 = this.f37277r;
            if (i7 > 0) {
                view = findViewById(i7);
            } else {
                view = null;
            }
            int i8 = this.f37278s;
            if (i8 > 0) {
                view2 = findViewById(i8);
            }
            this.Q0.a(this.U);
            this.Q0.c(this.K);
            this.Q0.o(this.T0, view, view2);
            if (this.f37250b != 0) {
                H0(RefreshState.None);
                m2.c cVar2 = this.Q0;
                this.f37250b = 0;
                cVar2.i(0);
            }
            bringChildToFront(this.Q0.getView());
            SpinnerStyle spinnerStyle = this.O0.getSpinnerStyle();
            SpinnerStyle spinnerStyle2 = SpinnerStyle.FixedBehind;
            if (spinnerStyle != spinnerStyle2) {
                bringChildToFront(this.O0.getView());
            }
            if (this.P0.getSpinnerStyle() != spinnerStyle2) {
                bringChildToFront(this.P0.getView());
            }
            if (this.R == null) {
                this.R = new h();
            }
            if (this.S == null) {
                this.S = new i();
            }
            int[] iArr = this.f37283x;
            if (iArr != null) {
                this.O0.setPrimaryColors(iArr);
                this.P0.setPrimaryColors(this.f37283x);
            }
            if (!this.P && !isNestedScrollingEnabled()) {
                for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                    if (parent instanceof NestedScrollingParent) {
                        setNestedScrollingEnabled(true);
                        this.P = false;
                        return;
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        F0(0, false);
        H0(RefreshState.None);
        this.S0.removeCallbacksAndMessages(null);
        this.S0 = null;
        this.O = true;
        this.P = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onFinishInflate() {
        boolean z5;
        boolean z6;
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount <= 3) {
            boolean[] zArr = new boolean[childCount];
            int i6 = 0;
            while (true) {
                boolean z7 = true;
                if (i6 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i6);
                if ((childAt instanceof m2.e) && this.O0 == null) {
                    this.O0 = (m2.e) childAt;
                } else if ((childAt instanceof m2.d) && this.P0 == null) {
                    if (!this.f37285z && this.O) {
                        z7 = false;
                    }
                    this.f37285z = z7;
                    this.P0 = (m2.d) childAt;
                } else if (this.Q0 == null && ((childAt instanceof AbsListView) || (childAt instanceof WebView) || (childAt instanceof ScrollView) || (childAt instanceof ScrollingView) || (childAt instanceof NestedScrollingChild) || (childAt instanceof NestedScrollingParent) || (childAt instanceof ViewPager))) {
                    this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt);
                } else {
                    zArr[i6] = true;
                }
                i6++;
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                if (zArr[i7]) {
                    View childAt2 = getChildAt(i7);
                    if (childCount == 1 && this.Q0 == null) {
                        this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt2);
                    } else if (i7 == 0 && this.O0 == null) {
                        this.O0 = new com.scwang.smartrefresh.layout.impl.c(childAt2);
                    } else if (childCount == 2 && this.Q0 == null) {
                        this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt2);
                    } else if (i7 == 2 && this.P0 == null) {
                        if (!this.f37285z && this.O) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        this.f37285z = z6;
                        this.P0 = new com.scwang.smartrefresh.layout.impl.b(childAt2);
                    } else if (this.Q0 == null) {
                        this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt2);
                    } else if (i7 == 1 && childCount == 2 && this.P0 == null) {
                        if (!this.f37285z && this.O) {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        this.f37285z = z5;
                        this.P0 = new com.scwang.smartrefresh.layout.impl.b(childAt2);
                    }
                }
            }
            if (isInEditMode()) {
                int[] iArr = this.f37283x;
                if (iArr != null) {
                    m2.e eVar = this.O0;
                    if (eVar != null) {
                        eVar.setPrimaryColors(iArr);
                    }
                    m2.d dVar = this.P0;
                    if (dVar != null) {
                        dVar.setPrimaryColors(this.f37283x);
                    }
                }
                m2.c cVar = this.Q0;
                if (cVar != null) {
                    bringChildToFront(cVar.getView());
                }
                m2.e eVar2 = this.O0;
                if (eVar2 != null && eVar2.getSpinnerStyle() != SpinnerStyle.FixedBehind) {
                    bringChildToFront(this.O0.getView());
                }
                m2.d dVar2 = this.P0;
                if (dVar2 != null && dVar2.getSpinnerStyle() != SpinnerStyle.FixedBehind) {
                    bringChildToFront(this.P0.getView());
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        boolean z6;
        int i12;
        int max;
        boolean z7;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            m2.c cVar = this.Q0;
            boolean z8 = true;
            if (cVar != null && cVar.getView() == childAt) {
                if (isInEditMode() && this.D) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                o oVar = (o) this.Q0.getLayoutParams();
                int i14 = ((ViewGroup.MarginLayoutParams) oVar).leftMargin + paddingLeft;
                int i15 = ((ViewGroup.MarginLayoutParams) oVar).topMargin + paddingTop;
                int f6 = this.Q0.f() + i14;
                int h6 = this.Q0.h() + i15;
                if (z7 && g0() && (this.A || this.O0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) {
                    int i16 = this.f37275p0;
                    i15 += i16;
                    h6 += i16;
                }
                this.Q0.k(i14, i15, f6, h6);
            }
            m2.e eVar = this.O0;
            if (eVar != null && eVar.getView() == childAt) {
                if (isInEditMode() && this.D && g0()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                View view = this.O0.getView();
                o oVar2 = (o) view.getLayoutParams();
                int i17 = ((ViewGroup.MarginLayoutParams) oVar2).leftMargin;
                int i18 = ((ViewGroup.MarginLayoutParams) oVar2).topMargin;
                int measuredWidth = view.getMeasuredWidth() + i17;
                int measuredHeight = view.getMeasuredHeight() + i18;
                if (!z6) {
                    if (this.O0.getSpinnerStyle() == SpinnerStyle.Translate) {
                        i18 -= this.f37275p0;
                        max = view.getMeasuredHeight();
                    } else if (this.O0.getSpinnerStyle() == SpinnerStyle.Scale) {
                        if (g0()) {
                            i12 = this.f37250b;
                        } else {
                            i12 = 0;
                        }
                        max = Math.max(Math.max(0, i12) - ((ViewGroup.MarginLayoutParams) oVar2).bottomMargin, 0);
                    }
                    measuredHeight = i18 + max;
                }
                view.layout(i17, i18, measuredWidth, measuredHeight);
            }
            m2.d dVar = this.P0;
            if (dVar != null && dVar.getView() == childAt) {
                if (!isInEditMode() || !this.D || !z()) {
                    z8 = false;
                }
                View view2 = this.P0.getView();
                o oVar3 = (o) view2.getLayoutParams();
                SpinnerStyle spinnerStyle = this.P0.getSpinnerStyle();
                int i19 = ((ViewGroup.MarginLayoutParams) oVar3).leftMargin;
                int measuredHeight2 = (((ViewGroup.MarginLayoutParams) oVar3).topMargin + getMeasuredHeight()) - ((ViewGroup.MarginLayoutParams) oVar3).bottomMargin;
                if (!z8 && spinnerStyle != SpinnerStyle.FixedFront && spinnerStyle != SpinnerStyle.FixedBehind) {
                    if (spinnerStyle == SpinnerStyle.Scale) {
                        if (z()) {
                            i11 = -this.f37250b;
                        } else {
                            i11 = 0;
                        }
                        i10 = Math.max(Math.max(i11, 0) - ((ViewGroup.MarginLayoutParams) oVar3).topMargin, 0);
                    }
                    view2.layout(i19, measuredHeight2, view2.getMeasuredWidth() + i19, view2.getMeasuredHeight() + measuredHeight2);
                } else {
                    i10 = this.G0;
                }
                measuredHeight2 -= i10;
                view2.layout(i19, measuredHeight2, view2.getMeasuredWidth() + i19, view2.getMeasuredHeight() + measuredHeight2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f6, float f7, boolean z5) {
        return dispatchNestedFling(f6, f7, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i6) {
        if (isEnabled() && isNestedScrollingEnabled() && (i6 & 2) != 0) {
            if (g0() || z()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // m2.h
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout Q() {
        return S(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.Y0))));
    }

    @Override // m2.h
    public m2.h t(boolean z5) {
        setNestedScrollingEnabled(z5);
        return this;
    }

    @Override // m2.h
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout G(boolean z5) {
        long currentTimeMillis = System.currentTimeMillis() - this.Y0;
        int i6 = 0;
        if (z5) {
            i6 = Math.max(0, 1000 - ((int) currentTimeMillis));
        }
        return N(i6, z5);
    }

    @Override // m2.h
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout X() {
        return A(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.Y0))), true, true);
    }

    @Override // m2.h
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout Y() {
        return B(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.Z0))));
    }

    @Override // m2.h
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout w(boolean z5) {
        long currentTimeMillis = System.currentTimeMillis() - this.Z0;
        int i6 = 0;
        if (z5) {
            i6 = Math.max(0, 1000 - ((int) currentTimeMillis));
        }
        return M(i6, z5);
    }

    protected void z1() {
        if (z() && !this.N && !this.V0.opening) {
            H0(RefreshState.PullUpCanceled);
            K0();
        } else {
            setViceState(RefreshState.PullUpCanceled);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class o extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f37314a;

        /* renamed from: b, reason: collision with root package name */
        public SpinnerStyle f37315b;

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f37314a = 0;
            this.f37315b = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f37314a = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f37314a);
            int i6 = R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i6)) {
                this.f37315b = SpinnerStyle.values()[obtainStyledAttributes.getInt(i6, SpinnerStyle.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
        }

        public o(int i6, int i7) {
            super(i6, i7);
            this.f37314a = 0;
            this.f37315b = null;
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f37314a = 0;
            this.f37315b = null;
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f37314a = 0;
            this.f37315b = null;
        }
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37258e = 250;
        this.f37260f = 250;
        this.f37270l = 0.5f;
        this.f37284y = true;
        this.f37285z = false;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.V = new int[2];
        this.W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.F0 = dimensionStatus;
        this.H0 = dimensionStatus;
        this.K0 = 2.5f;
        this.L0 = 2.5f;
        this.M0 = 1.0f;
        this.N0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.V0 = refreshState;
        this.W0 = refreshState;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0L;
        this.f37249a1 = 0;
        this.f37252b1 = 0;
        this.f37259e1 = null;
        this.f37263g1 = new l();
        this.f37265h1 = new m();
        D0(context, attributeSet);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37258e = 250;
        this.f37260f = 250;
        this.f37270l = 0.5f;
        this.f37284y = true;
        this.f37285z = false;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.V = new int[2];
        this.W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.F0 = dimensionStatus;
        this.H0 = dimensionStatus;
        this.K0 = 2.5f;
        this.L0 = 2.5f;
        this.M0 = 1.0f;
        this.N0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.V0 = refreshState;
        this.W0 = refreshState;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0L;
        this.f37249a1 = 0;
        this.f37252b1 = 0;
        this.f37259e1 = null;
        this.f37263g1 = new l();
        this.f37265h1 = new m();
        D0(context, attributeSet);
    }

    @RequiresApi(21)
    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f37258e = 250;
        this.f37260f = 250;
        this.f37270l = 0.5f;
        this.f37284y = true;
        this.f37285z = false;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.V = new int[2];
        this.W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.F0 = dimensionStatus;
        this.H0 = dimensionStatus;
        this.K0 = 2.5f;
        this.L0 = 2.5f;
        this.M0 = 1.0f;
        this.N0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.V0 = refreshState;
        this.W0 = refreshState;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0L;
        this.f37249a1 = 0;
        this.f37252b1 = 0;
        this.f37259e1 = null;
        this.f37263g1 = new l();
        this.f37265h1 = new m();
        D0(context, attributeSet);
    }
}
