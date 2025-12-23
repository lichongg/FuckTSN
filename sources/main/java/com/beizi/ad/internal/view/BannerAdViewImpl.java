package com.beizi.ad.internal.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.beizi.ad.internal.animation.Animator;
import com.beizi.ad.internal.f.a;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.video.AdVideoView;
import com.beizi.ad.lance.a.m;
import com.beizi.fusion.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BannerAdViewImpl extends AdViewImpl {
    private c A;
    private a B;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f12572m;

    /* renamed from: n, reason: collision with root package name */
    protected int f12573n;

    /* renamed from: o, reason: collision with root package name */
    protected int f12574o;

    /* renamed from: p, reason: collision with root package name */
    private int f12575p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12576q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f12577r;

    /* renamed from: s, reason: collision with root package name */
    private BroadcastReceiver f12578s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f12579t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f12580u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f12581v;

    /* renamed from: w, reason: collision with root package name */
    private Animator f12582w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f12583x;

    /* renamed from: y, reason: collision with root package name */
    private AdWebView f12584y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f12585z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        TOP_LEFT,
        TOP_CENTER,
        TOP_RIGHT,
        CENTER_LEFT,
        CENTER,
        CENTER_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_CENTER,
        BOTTOM_RIGHT;

        int a() {
            switch (AnonymousClass2.f12587a[ordinal()]) {
                case 1:
                    return 51;
                case 2:
                    return 49;
                case 3:
                    return 53;
                case 4:
                    return 19;
                case 5:
                default:
                    return 17;
                case 6:
                    return 21;
                case 7:
                    return 83;
                case 8:
                    return 81;
                case 9:
                    return 85;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Animation.AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        private final c f12599b;

        /* renamed from: c, reason: collision with root package name */
        private final Animator f12600c;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            animation.setAnimationListener(null);
            final c cVar = this.f12599b;
            final Animator animator = this.f12600c;
            if (cVar == null || animator == null) {
                return;
            }
            cVar.getView().getHandler().post(new Runnable() { // from class: com.beizi.ad.internal.view.BannerAdViewImpl.b.1
                @Override // java.lang.Runnable
                public void run() {
                    animator.clearAnimation();
                    cVar.destroy();
                    animator.setAnimation();
                }
            });
        }

        b(c cVar, Animator animator) {
            this.f12599b = cVar;
            this.f12600c = animator;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public BannerAdViewImpl(Context context) {
        super(context);
        this.f12585z = true;
    }

    private void j() {
        this.f12576q = false;
        this.f12575p = -1;
        this.f12577r = false;
        this.f12583x = true;
    }

    public void clickArea() {
        AdWebView adWebView = this.f12584y;
        if (adWebView != null) {
            adWebView.handleClickView(null, System.currentTimeMillis(), System.currentTimeMillis() + 10);
        }
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    boolean d() {
        return true;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    boolean e() {
        return false;
    }

    protected void i() {
        this.f12572m = false;
        if (getLayoutParams() != null) {
            getLayoutParams().height = this.f12573n;
            getLayoutParams().width = this.f12574o;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.view.BannerAdViewImpl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12587a;

        static {
            int[] iArr = new int[a.values().length];
            f12587a = iArr;
            try {
                iArr[a.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12587a[a.TOP_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12587a[a.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12587a[a.CENTER_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12587a[a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12587a[a.CENTER_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12587a[a.BOTTOM_LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12587a[a.BOTTOM_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12587a[a.BOTTOM_RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private void k() {
        if (this.f12578s != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.f12578s = new BroadcastReceiver() { // from class: com.beizi.ad.internal.view.BannerAdViewImpl.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                        BannerAdViewImpl.this.h();
                        return;
                    }
                    if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                        if (BannerAdViewImpl.this.f12575p > 0) {
                            BannerAdViewImpl.this.g();
                        } else if (BannerAdViewImpl.this.f12577r) {
                            BannerAdViewImpl.this.h();
                            BannerAdViewImpl.this.g();
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        };
        try {
            m.c("BeiZisAd", "before registerReceiver");
            getContext().registerReceiver(this.f12578s, intentFilter);
        } catch (Throwable unused) {
            m.c("BeiZisAd", "ignore error");
        }
    }

    private void l() {
        if (this.f12575p > 0) {
            k();
        }
    }

    private void m() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter dismantleBroadcast mReceiver == null ? ");
        sb.append(this.f12578s == null);
        m.c("BeiZisAd", sb.toString());
        if (this.f12578s == null) {
            return;
        }
        try {
            getContext().unregisterReceiver(this.f12578s);
            m.c("BeiZisAd", "after unregisterReceiver");
        } catch (IllegalArgumentException unused) {
            m.c("BeiZisAd", "got IllegalArgumentException");
        }
        this.f12578s = null;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    protected void a(Context context, AttributeSet attributeSet) {
        this.f12575p = -1;
        this.f12572m = false;
        this.f12579t = false;
        this.f12580u = false;
        this.f12581v = false;
        this.f12582w = new Animator(getContext(), com.beizi.ad.internal.animation.h.NONE, com.beizi.ad.internal.animation.g.UP, 500L);
        View view = (View) getParent();
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            int measuredHeight2 = view.getMeasuredHeight();
            com.beizi.ad.internal.h a6 = com.beizi.ad.internal.h.a();
            int h6 = (int) ((measuredHeight / a6.h()) + 0.5f);
            this.f12437h.c((int) ((measuredHeight2 / a6.g()) + 0.5f));
            this.f12437h.d(h6);
        }
        super.a(context, attributeSet);
        l();
        this.f12437h.a(this.f12430a != null ? k.SPLASH : k.BANNER);
        this.mAdFetcher.a(this.f12575p);
        if (this.f12583x) {
            this.mAdFetcher.b();
            this.f12576q = true;
        }
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void activityOnDestroy() {
        c cVar = this.A;
        if (cVar != null) {
            cVar.onDestroy();
            this.A = null;
        }
        m.c("BeiZisAd", "enter activityOnDestroy before dismantleBroadcast");
        m();
        if (this.mAdFetcher != null) {
            h();
        }
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void activityOnPause() {
        c cVar = this.A;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public void activityOnResume() {
        c cVar = this.A;
        if (cVar != null) {
            cVar.onResume();
        }
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    protected void b(Context context, AttributeSet attributeSet) {
        j();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = obtainStyledAttributes.getIndex(i6);
            if (index == R.styleable.AdView_beizi_adUnitId) {
                setAdUnitId(obtainStyledAttributes.getString(index));
            } else if (index == R.styleable.AdView_auto_refresh_interval) {
                int i7 = obtainStyledAttributes.getInt(index, -1);
                setAutoRefreshInterval(i7);
                if (i7 <= 0) {
                    this.f12583x = true;
                }
            } else if (index == R.styleable.AdView_test) {
                com.beizi.ad.internal.h.a().f11999d = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.AdView_beizi_adSize) {
                String string = obtainStyledAttributes.getString(index);
                com.beizi.ad.c cVar = null;
                if (string != null && !string.isEmpty()) {
                    try {
                        cVar = (com.beizi.ad.c) com.beizi.ad.c.class.getDeclaredField(string).get(null);
                    } catch (Exception unused) {
                    }
                }
                if (cVar == null) {
                    cVar = com.beizi.ad.c.f11414g;
                }
                setAdSize(cVar.b(), cVar.a());
            } else if (index == R.styleable.AdView_should_reload_on_resume) {
                setShouldReloadOnResume(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.AdView_opens_native_browser) {
                setOpensNativeBrowser(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.AdView_expands_to_fit_screen_width) {
                setExpandsToFitScreenWidth(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.AdView_resize_ad_to_fit_container) {
                setResizeAdToFitContainer(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.AdView_show_loading_indicator) {
                setShowLoadingIndicator(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == R.styleable.AdView_transition_type) {
                setTransitionType(com.beizi.ad.internal.animation.h.a(obtainStyledAttributes.getInt(index, 0)));
            } else if (index == R.styleable.AdView_transition_direction) {
                setTransitionDirection(com.beizi.ad.internal.animation.g.a(obtainStyledAttributes.getInt(index, 0)));
            } else if (index == R.styleable.AdView_transition_duration) {
                setTransitionDuration(obtainStyledAttributes.getInt(index, 1000));
            } else if (index == R.styleable.AdView_load_landing_page_in_background) {
                setLoadsInBackground(obtainStyledAttributes.getBoolean(index, true));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void cancel() {
        com.beizi.ad.internal.d dVar = this.mAdFetcher;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void disableFullClick(View.OnTouchListener onTouchListener) {
        AdWebView adWebView = this.f12584y;
        if (adWebView != null) {
            adWebView.setOnTouchListener(onTouchListener);
        }
    }

    void g() {
        if (this.f12576q) {
            return;
        }
        this.mAdFetcher.b();
        this.f12576q = true;
    }

    public a getAdAlignment() {
        if (this.B == null) {
            this.B = a.CENTER;
        }
        return this.B;
    }

    public int getAdHeight() {
        return this.f12437h.e();
    }

    public int getAdWidth() {
        return this.f12437h.d();
    }

    public int getAutoRefreshInterval() {
        return this.f12575p;
    }

    public boolean getExpandsToFitScreenWidth() {
        return this.f12579t;
    }

    @Override // com.beizi.ad.internal.a
    public k getMediaType() {
        return this.f12430a != null ? k.SPLASH : k.BANNER;
    }

    public boolean getResizeAdToFitContainer() {
        return this.f12580u;
    }

    public boolean getShouldReloadOnResume() {
        return this.f12577r;
    }

    public com.beizi.ad.internal.animation.g getTransitionDirection() {
        return this.f12582w.getTransitionDirection();
    }

    public long getTransitionDuration() {
        return this.f12582w.getTransitionDuration();
    }

    public com.beizi.ad.internal.animation.h getTransitionType() {
        return this.f12582w.getTransitionType();
    }

    void h() {
        this.mAdFetcher.a();
        this.f12576q = false;
    }

    public boolean isAutoRefresh() {
        return this.f12585z;
    }

    public void resetContainerIfNeeded() {
        if (this.f12572m) {
            i();
        }
    }

    public void setAdAlignment(a aVar) {
        this.B = aVar;
    }

    public void setAdSize(int i6, int i7) {
        this.f12437h.a(i6);
        this.f12437h.b(i7);
    }

    public void setAutoRefresh(boolean z5) {
        this.f12585z = z5;
    }

    public void setAutoRefreshInterval(int i6) {
        if (i6 > 0) {
            this.f12575p = Math.max(10000, i6);
        } else {
            this.f12575p = i6;
        }
        com.beizi.ad.internal.d dVar = this.mAdFetcher;
        if (dVar != null) {
            dVar.a(this.f12575p);
        }
    }

    public void setExpandsToFitScreenWidth(boolean z5) {
        this.f12579t = z5;
    }

    public void setResizeAdToFitContainer(boolean z5) {
        this.f12580u = z5;
    }

    public void setScrollClick(View.OnTouchListener onTouchListener) {
        AdWebView adWebView = this.f12584y;
        if (adWebView != null) {
            adWebView.setOnTouchListener(onTouchListener);
        }
    }

    public void setShouldReloadOnResume(boolean z5) {
        this.f12577r = z5;
    }

    public void setTransitionDirection(com.beizi.ad.internal.animation.g gVar) {
        this.f12582w.setTransitionDirection(gVar);
    }

    public void setTransitionDuration(long j6) {
        this.f12582w.setTransitionDuration(j6);
    }

    public void setTransitionType(com.beizi.ad.internal.animation.h hVar) {
        this.f12582w.setTransitionType(hVar);
    }

    public BannerAdViewImpl(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
        this.f12585z = true;
    }

    public void clickArea(com.beizi.ad.model.d dVar, int i6) {
        AdWebView adWebView = this.f12584y;
        if (adWebView != null) {
            adWebView.handleClickView(dVar, System.currentTimeMillis(), System.currentTimeMillis() + 10, i6);
        }
    }

    @SuppressLint({"NewApi"})
    public void expandToFitScreenWidth(int i6, int i7, c cVar) {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i8 = point.x;
        int floor = (int) Math.floor(i7 * (i8 / i6));
        this.f12573n = getLayoutParams().height;
        this.f12574o = getLayoutParams().width;
        if (getLayoutParams().width > 0 || getLayoutParams().width == -2) {
            getLayoutParams().width = i8;
        }
        getLayoutParams().height = floor;
        View view = cVar.getView();
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        } else {
            view.getLayoutParams().width = -1;
            view.getLayoutParams().height = -1;
        }
        view.invalidate();
        this.f12572m = true;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    public boolean loadAd(a.C0107a c0107a) {
        if (super.loadAd(c0107a)) {
            this.f12576q = true;
            return true;
        }
        return false;
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (this.f12433d) {
            this.f12433d = false;
            return;
        }
        if (!this.f12581v || z5) {
            com.beizi.ad.internal.h a6 = com.beizi.ad.internal.h.a();
            int g6 = (int) (((i8 - i6) / a6.g()) + 0.5f);
            int h6 = (int) (((i9 - i7) / a6.h()) + 0.5f);
            if (g6 >= this.f12437h.d() && (h6 >= this.f12437h.e() || g6 <= 0 || h6 <= 0)) {
                this.f12437h.c(g6);
                this.f12437h.d(h6);
                if (!this.f12581v) {
                    c();
                }
                this.f12581v = true;
            } else {
                c();
                com.beizi.ad.internal.d dVar = this.mAdFetcher;
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
        }
        if (this.f12576q) {
            k();
            if (this.f12577r) {
                g();
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        if (i6 == 0) {
            k();
            if ((this.f12576q || this.f12577r || this.f12575p > 0) && !this.f12435f && !this.f12433d && !a() && this.mAdFetcher != null) {
                g();
            }
            this.f12435f = false;
            if (getChildAt(0) instanceof WebView) {
                x.b((WebView) getChildAt(0));
                return;
            }
            return;
        }
        m.c("BeiZisAd", "enter onWindowVisibilityChanged before dismantleBroadcast");
        m();
        if (this.mAdFetcher != null && this.f12576q) {
            h();
        }
        if (getChildAt(0) instanceof WebView) {
            x.c((WebView) getChildAt(0));
        }
    }

    @SuppressLint({"NewApi"})
    public void resizeWebViewToFitContainer(int i6, int i7, c cVar) {
        int width;
        int height;
        if (getWidth() <= 0) {
            width = getMeasuredWidth();
        } else {
            width = getWidth();
        }
        if (getHeight() <= 0) {
            height = getMeasuredHeight();
        } else {
            height = getHeight();
        }
        if (height > 0 && width > 0) {
            float f6 = i6 / width;
            float f7 = i7 / height;
            View view = cVar.getView();
            if (f6 < f7) {
                width = (i6 * height) / i7;
                if (view instanceof WebView) {
                    ((WebView) view).setInitialScale((int) Math.ceil((height * 100) / i7));
                }
            } else {
                height = (i7 * width) / i6;
                if (view instanceof WebView) {
                    ((WebView) view).setInitialScale((int) Math.ceil((width * 100) / i6));
                }
            }
            if (view.getLayoutParams() == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                view.setLayoutParams(layoutParams);
            } else {
                view.getLayoutParams().width = width;
                view.getLayoutParams().height = height;
                ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = 17;
            }
            view.invalidate();
        }
    }

    public BannerAdViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12585z = true;
    }

    public BannerAdViewImpl(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f12585z = true;
    }

    public BannerAdViewImpl(Context context, int i6) {
        super(context);
        this.f12585z = true;
        setAutoRefreshInterval(i6);
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    void f() {
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    protected void a(c cVar) {
        int refreshInterval;
        if (cVar != null && !cVar.failed() && cVar.getView() != null) {
            if (this.f12432c == cVar) {
                return;
            }
            this.A = cVar;
            if (getTransitionType() == com.beizi.ad.internal.animation.h.NONE) {
                removeAllViews();
                c cVar2 = this.f12432c;
                if (cVar2 != null) {
                    cVar2.destroy();
                }
                View view = cVar.getView();
                addView(view);
                if (view instanceof AdWebView) {
                    m.a("BeiZisAd", "set mAdWebView");
                    this.f12584y = (AdWebView) view;
                }
                if (view.getLayoutParams() != null) {
                    ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = getAdAlignment().a();
                }
                if (getMediaType() != k.SPLASH || (cVar.getView() instanceof AdVideoView)) {
                    cVar.visible();
                }
            } else {
                if (cVar.getView().getLayoutParams() != null) {
                    ((FrameLayout.LayoutParams) cVar.getView().getLayoutParams()).gravity = getAdAlignment().a();
                    this.f12582w.setLayoutParams(cVar.getView().getLayoutParams());
                }
                if (getChildCount() != 0 && indexOfChild(this.f12582w) != -1) {
                    if (getMediaType() != k.SPLASH || (cVar.getView() instanceof AdVideoView)) {
                        cVar.visible();
                    }
                    this.f12582w.addView(cVar.getView());
                    this.f12582w.showNext();
                } else {
                    removeAllViews();
                    if (getMediaType() != k.SPLASH || (cVar.getView() instanceof AdVideoView)) {
                        cVar.visible();
                    }
                    addView(this.f12582w, 0);
                    this.f12582w.addView(cVar.getView());
                }
                c cVar3 = this.f12432c;
                if (cVar3 != null) {
                    if (cVar3.getView().getAnimation() != null) {
                        cVar3.getView().getAnimation().setAnimationListener(new b(cVar3, this.f12582w));
                    } else {
                        cVar3.destroy();
                    }
                }
            }
            b();
            if (this.f12430a == null && (refreshInterval = cVar.getRefreshInterval()) > 0 && this.f12585z) {
                setAutoRefreshInterval(refreshInterval * 1000);
            }
            this.f12432c = cVar;
            return;
        }
        getAdListener().a(5);
    }

    @Override // com.beizi.ad.internal.view.AdViewImpl
    protected void a(com.beizi.ad.internal.d.e eVar) {
        a((c) eVar);
    }
}
