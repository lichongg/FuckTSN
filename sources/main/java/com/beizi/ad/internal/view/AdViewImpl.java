package com.beizi.ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Color;
import android.graphics.Point;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.f.a;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.h.t;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.internal.i;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.n;
import com.beizi.ad.internal.video.AdVideoView;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.ad.internal.view.f;
import com.beizi.ad.l;
import com.beizi.ad.lance.a.j;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.q;
import com.beizi.ad.model.f;
import com.beizi.fusion.R;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class AdViewImpl extends FrameLayout implements com.beizi.ad.internal.a {
    private static FrameLayout U;
    private static f V;
    private static AdWebView.b W;
    private AppCompatTextView A;
    private ImageView B;
    private CountDownTimer C;
    private AppCompatImageView D;
    private long E;
    private GestureDetector F;
    private float G;
    private float H;
    private float I;
    private float J;
    private FrameLayout K;
    private FrameLayout L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private boolean R;
    private AdWebView S;
    private boolean T;

    /* renamed from: a, reason: collision with root package name */
    protected ViewGroup f12430a;

    /* renamed from: b, reason: collision with root package name */
    protected a f12431b;
    public int bottomPadding;

    /* renamed from: c, reason: collision with root package name */
    protected com.beizi.ad.internal.view.c f12432c;
    public int clickCount;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f12433d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f12434e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f12435f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f12436g;

    /* renamed from: h, reason: collision with root package name */
    protected com.beizi.ad.internal.e f12437h;

    /* renamed from: i, reason: collision with root package name */
    protected a.C0107a f12438i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f12439j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f12440k;

    /* renamed from: l, reason: collision with root package name */
    int f12441l;
    public int leftPadding;
    public int loadCount;

    /* renamed from: m, reason: collision with root package name */
    private View f12442m;
    public com.beizi.ad.internal.d mAdFetcher;

    /* renamed from: n, reason: collision with root package name */
    private int f12443n;

    /* renamed from: o, reason: collision with root package name */
    private int f12444o;

    /* renamed from: p, reason: collision with root package name */
    private String f12445p;

    /* renamed from: q, reason: collision with root package name */
    private com.beizi.ad.a f12446q;

    /* renamed from: r, reason: collision with root package name */
    private l f12447r;
    public int rightPadding;

    /* renamed from: s, reason: collision with root package name */
    private com.beizi.ad.d f12448s;
    public com.beizi.ad.internal.f.c serverResponse;

    /* renamed from: t, reason: collision with root package name */
    private c f12449t;
    public int topPadding;

    /* renamed from: u, reason: collision with root package name */
    private final Handler f12450u;

    /* renamed from: v, reason: collision with root package name */
    private b f12451v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f12452w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f12453x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f12454y;

    /* renamed from: z, reason: collision with root package name */
    private AppCompatTextView f12455z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public EnumC0115a f12500a = EnumC0115a.UNCHANGE;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12501b = false;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.beizi.ad.internal.view.AdViewImpl$a$a, reason: collision with other inner class name */
        enum EnumC0115a {
            UNCHANGE,
            STATE_PREPARE_CHANGE,
            STATE_BACKGROUND,
            FINISHCLOSE
        }

        public boolean a() {
            return this.f12501b;
        }

        public void a(boolean z5) {
            this.f12501b = z5;
        }

        public void b() {
            this.f12500a = EnumC0115a.UNCHANGE;
        }

        public EnumC0115a c() {
            return this.f12500a;
        }

        a() {
        }

        public synchronized void a(EnumC0115a enumC0115a) {
            try {
                EnumC0115a enumC0115a2 = EnumC0115a.STATE_PREPARE_CHANGE;
                if (enumC0115a == enumC0115a2 && this.f12500a == EnumC0115a.UNCHANGE) {
                    this.f12500a = enumC0115a2;
                }
                EnumC0115a enumC0115a3 = EnumC0115a.STATE_BACKGROUND;
                if (enumC0115a == enumC0115a3 && this.f12500a == enumC0115a2) {
                    this.f12500a = enumC0115a3;
                }
                EnumC0115a enumC0115a4 = EnumC0115a.FINISHCLOSE;
                if (enumC0115a == enumC0115a4 && this.f12500a == enumC0115a3 && this.f12501b) {
                    this.f12500a = enumC0115a4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements com.beizi.ad.internal.c {

        /* renamed from: b, reason: collision with root package name */
        private Handler f12508b;

        /* renamed from: c, reason: collision with root package name */
        private com.beizi.ad.internal.f.b f12509c;

        public b(Handler handler) {
            this.f12508b = handler;
        }

        @Override // com.beizi.ad.internal.c
        public void a(final com.beizi.ad.internal.f.b bVar) {
            this.f12509c = bVar;
            if (bVar.a().equals(k.BANNER) || bVar.a().equals(k.INTERSTITIAL) || bVar.a().equals(k.SPLASH)) {
                this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdViewImpl.this.setCreativeWidth(bVar.c().getCreativeWidth());
                        AdViewImpl.this.setCreativeHeight(bVar.c().getCreativeHeight());
                        AdViewImpl.this.setAdExtInfo(bVar.e());
                        AdViewImpl.this.setPrice(bVar.f());
                        AdViewImpl.this.setAdId(bVar.g());
                        AdViewImpl.this.setDownloadApp(bVar.i());
                        if (bVar.b()) {
                            try {
                                AdViewImpl.this.a((com.beizi.ad.internal.d.e) bVar.c());
                            } catch (ClassCastException unused) {
                            }
                        } else {
                            AdViewImpl.this.a(bVar.c());
                        }
                        AdViewImpl adViewImpl = AdViewImpl.this;
                        if (adViewImpl.f12439j) {
                            if (adViewImpl.f12447r != null) {
                                AdViewImpl.this.f12447r.c();
                            }
                        } else {
                            if (adViewImpl.f12446q == null || bVar.a().equals(k.SPLASH)) {
                                return;
                            }
                            if (bVar.a().equals(k.INTERSTITIAL)) {
                                AdViewImpl.this.h();
                            } else {
                                AdViewImpl.this.f12446q.a();
                            }
                            if (bVar.d() != null) {
                                AdViewImpl.this.setLandingPageUrl(bVar.d().m());
                            }
                        }
                    }
                });
            } else {
                a(0);
            }
        }

        @Override // com.beizi.ad.internal.c
        public void b() {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdViewImpl adViewImpl = AdViewImpl.this;
                        if (adViewImpl.f12439j) {
                            if (adViewImpl.f12447r != null) {
                                AdViewImpl.this.f12447r.a();
                            }
                        } else if (adViewImpl.f12446q != null) {
                            AdViewImpl.this.f12446q.c();
                            AdViewImpl.this.f12431b.b();
                            if (AdViewImpl.this.S != null) {
                                AdViewImpl.this.S.closeWebResourceRequestConnection();
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void c() {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.8
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (adViewImpl.f12439j) {
                        if (adViewImpl.f12447r != null) {
                            AdViewImpl.this.f12447r.d();
                        }
                    } else if (adViewImpl.f12446q != null) {
                        AdViewImpl.this.f12446q.d();
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void d() {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.10
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (adViewImpl.f12439j || adViewImpl.f12446q == null) {
                        return;
                    }
                    AdViewImpl.this.f12431b.a(a.EnumC0115a.STATE_PREPARE_CHANGE);
                    AdViewImpl.this.f12446q.e();
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void e() {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.11
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f12446q != null) {
                        AdViewImpl.this.f12446q.f();
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void f() {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.2
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f12439j || adViewImpl.f12447r == null) {
                        return;
                    }
                    AdViewImpl.this.f12447r.e();
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a() {
            AdViewImpl.this.E = System.currentTimeMillis();
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.6
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (adViewImpl.f12439j) {
                        if (adViewImpl.f12447r != null) {
                            AdViewImpl.this.f12447r.b();
                        }
                    } else if (adViewImpl.f12446q != null) {
                        AdViewImpl.this.f12446q.b();
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final int i6) {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.7
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (adViewImpl.f12439j) {
                        if (adViewImpl.f12447r != null) {
                            AdViewImpl.this.f12447r.a(i6);
                        }
                    } else if (adViewImpl.f12446q != null) {
                        AdViewImpl.this.f12446q.a(i6);
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final String str, final String str2) {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.12
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f12448s != null) {
                        AdViewImpl.this.f12448s.a(str, str2);
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final String str, final int i6) {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.3
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f12439j || adViewImpl.f12447r == null) {
                        return;
                    }
                    AdViewImpl.this.f12447r.a(new n(str, i6));
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final long j6) {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f12446q == null || b.this.f12509c == null || !b.this.f12509c.a().equals(k.SPLASH)) {
                        return;
                    }
                    AdViewImpl.this.f12446q.a(j6);
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final String str) {
            this.f12508b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f12446q == null || b.this.f12509c == null) {
                        return;
                    }
                    AdViewImpl.this.f12446q.a(str);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final ArrayList<Pair<String, c>> f12530a = new ArrayList<>();
    }

    AdViewImpl(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    protected abstract void a(com.beizi.ad.internal.d.e eVar);

    protected abstract void a(com.beizi.ad.internal.view.c cVar);

    public abstract void activityOnDestroy();

    public abstract void activityOnPause();

    public abstract void activityOnResume();

    protected abstract void b(Context context, AttributeSet attributeSet);

    public void clearAdRequest() {
        this.f12438i = null;
    }

    abstract boolean d();

    abstract boolean e();

    abstract void f();

    public String getMediationAdapterClassName() {
        return null;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.view.AdViewImpl$14, reason: invalid class name */
    static /* synthetic */ class AnonymousClass14 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12465a;

        static {
            int[] iArr = new int[f.a.values().length];
            f12465a = iArr;
            try {
                iArr[f.a.bottom_center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12465a[f.a.bottom_left.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12465a[f.a.bottom_right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12465a[f.a.center.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12465a[f.a.top_center.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12465a[f.a.top_left.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12465a[f.a.top_right.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    AdViewImpl(Context context, ViewGroup viewGroup, View view) {
        super(context, null, 0);
        this.f12430a = null;
        this.f12442m = null;
        this.f12445p = "";
        this.f12431b = new a();
        this.f12450u = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.view.AdViewImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.f12433d = false;
        this.f12434e = false;
        this.f12435f = false;
        this.f12436g = true;
        this.f12452w = false;
        this.f12453x = true;
        this.f12437h = null;
        this.f12438i = null;
        this.f12454y = false;
        this.f12439j = false;
        this.f12440k = false;
        this.T = false;
        this.f12441l = 0;
        this.f12430a = viewGroup;
        this.f12442m = view;
        a(context, (AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        WebView webView = new WebView(new MutableContextWrapper(getContext()));
        x.a(webView);
        String b6 = com.beizi.ad.lance.a.b.b("aHR0cDovL3Nka2RvYy5iZWl6aS5iaXovIy96aC1jbi9ndWlkZS9Vc2VQcml2YWN5");
        if (!TextUtils.isEmpty(b6)) {
            webView.loadUrl(b6, j.a());
        }
        a(webView, context);
    }

    public static FrameLayout getMRAIDFullscreenContainer() {
        return U;
    }

    public static f getMRAIDFullscreenImplementation() {
        return V;
    }

    public static AdWebView.b getMRAIDFullscreenListener() {
        return W;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String str;
        boolean z5;
        String str2;
        try {
            com.beizi.ad.internal.f.c cVar = this.serverResponse;
            if (cVar != null) {
                z5 = cVar.N();
                str = this.serverResponse.L();
                str2 = this.serverResponse.M();
            } else {
                str = null;
                z5 = false;
                str2 = null;
            }
            if (z5) {
                if (!TextUtils.isEmpty(str2)) {
                    t.a().a(getContext(), str2, new t.a() { // from class: com.beizi.ad.internal.view.AdViewImpl.13
                        @Override // com.beizi.ad.internal.h.t.a
                        public void a(String str3) {
                            m.a("BeiZisAd", "onVideoLoaded: 加载成功");
                            if (AdViewImpl.this.f12446q != null) {
                                AdViewImpl.this.T = true;
                                AdViewImpl.this.f12446q.a();
                            }
                        }

                        @Override // com.beizi.ad.internal.h.t.a
                        public void a() {
                            if (AdViewImpl.this.f12446q != null) {
                                AdViewImpl.this.f12446q.a(6);
                            }
                        }
                    });
                    return;
                }
                com.beizi.ad.a aVar = this.f12446q;
                if (aVar != null) {
                    aVar.a(3);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                com.beizi.ad.a aVar2 = this.f12446q;
                if (aVar2 != null) {
                    aVar2.a(3);
                    return;
                }
                return;
            }
            com.beizi.ad.a aVar3 = this.f12446q;
            if (aVar3 != null) {
                this.T = true;
                aVar3.a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void setMRAIDFullscreenContainer(FrameLayout frameLayout) {
        U = frameLayout;
    }

    public static void setMRAIDFullscreenImplementation(f fVar) {
        V = fVar;
    }

    public static void setMRAIDFullscreenListener(AdWebView.b bVar) {
        W = bVar;
    }

    public void addBannerCloseBtn() {
        u.a(this.B);
        ImageView a6 = u.a(getContext());
        this.B = a6;
        a6.setVisibility(0);
        this.B.setEnabled(true);
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdViewImpl.this.getAdDispatcher().b();
            }
        });
    }

    public void addCloseButton(int i6, int i7, int i8, final View view, final boolean z5) {
        final int i9;
        final int i10;
        u.a(this.A);
        u.a(this.f12455z);
        CountDownTimer countDownTimer = this.C;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.A = u.a(getContext(), this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
        if (i8 != -1) {
            this.f12455z = u.a(getContext(), i8, this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
            if (i7 > 0) {
                this.A.setEnabled(false);
                i10 = i8 - i7;
            } else {
                if (i7 == -1) {
                    this.A.setVisibility(8);
                }
                i10 = 0;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(i8 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.4
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Activity activity;
                    AdViewImpl.this.f12455z.setText("0");
                    if (!AdViewImpl.this.e()) {
                        AdViewImpl.this.f12431b.a(true);
                        if (AdViewImpl.this.f12431b.a() && (AdViewImpl.this.f12431b.c() == a.EnumC0115a.UNCHANGE || AdViewImpl.this.f12431b.c() == a.EnumC0115a.STATE_PREPARE_CHANGE)) {
                            AdViewImpl.this.getAdDispatcher().b();
                        }
                        ViewGroup viewGroup = AdViewImpl.this.f12430a;
                        return;
                    }
                    if (!z5) {
                        AdViewImpl.this.getAdDispatcher().b();
                        if (!(AdViewImpl.this.a(view) instanceof Activity) || (activity = (Activity) AdViewImpl.this.a(view)) == null || activity.isFinishing()) {
                            return;
                        }
                        activity.finish();
                        return;
                    }
                    View view2 = view;
                    if (view2 instanceof AdWebView) {
                        if (((AdWebView) view2).loadAdBy(1)) {
                            ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                        }
                    } else if ((view2 instanceof AdVideoView) && ((AdVideoView) view2).getAdWebView().loadAdBy(1)) {
                        ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j6) {
                    int i11 = (int) ((j6 / 1000) + 1);
                    int i12 = i10;
                    if (i12 > 0 && i11 <= i12) {
                        AdViewImpl.this.A.setEnabled(true);
                    }
                    AdViewImpl.this.f12455z.setText(Integer.toString(i11));
                }
            };
            this.C = countDownTimer2;
            countDownTimer2.start();
        } else {
            if (i7 == -1 || i6 == -1) {
                if (i6 != -1) {
                    this.f12455z = u.a(getContext(), i6, this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
                    CountDownTimer countDownTimer3 = new CountDownTimer(i6 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.6
                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            AdViewImpl.this.f12455z.setText("0");
                            AdViewImpl.this.f12455z.setVisibility(8);
                        }

                        @Override // android.os.CountDownTimer
                        public void onTick(long j6) {
                            AdViewImpl.this.f12455z.setText(Integer.toString((int) ((j6 / 1000) + 1)));
                        }
                    };
                    this.C = countDownTimer3;
                    countDownTimer3.start();
                    ViewParent parent = e() ? view.getParent() : getParent();
                    if (parent instanceof FrameLayout) {
                        ((FrameLayout) parent).addView(this.f12455z);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f12455z = u.a(getContext(), i6, this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
            if (i7 > 0) {
                this.A.setEnabled(false);
                i9 = i6 - i7;
            } else {
                i9 = 0;
            }
            CountDownTimer countDownTimer4 = new CountDownTimer(i6 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.5
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f12455z.setText("0");
                    AdViewImpl.this.f12455z.setVisibility(8);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j6) {
                    int i11 = (int) ((j6 / 1000) + 1);
                    AdViewImpl.this.f12455z.setText(Integer.toString(i11));
                    int i12 = i9;
                    if (i12 <= 0 || i11 > i12) {
                        return;
                    }
                    AdViewImpl.this.A.setEnabled(true);
                }
            };
            this.C = countDownTimer4;
            countDownTimer4.start();
        }
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Activity activity;
                if (!AdViewImpl.this.e()) {
                    AdViewImpl.this.getAdDispatcher().b();
                    AdViewImpl.this.C.cancel();
                    ViewGroup viewGroup = AdViewImpl.this.f12430a;
                    return;
                }
                if (!z5) {
                    AdViewImpl.this.getAdDispatcher().b();
                    if (!(AdViewImpl.this.a(view) instanceof Activity) || (activity = (Activity) AdViewImpl.this.a(view)) == null || activity.isFinishing()) {
                        return;
                    }
                    activity.onBackPressed();
                    activity.finish();
                    return;
                }
                View view3 = view;
                if (view3 instanceof AdWebView) {
                    if (((AdWebView) view3).loadAdBy(1)) {
                        ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                    }
                } else if ((view3 instanceof AdVideoView) && ((AdVideoView) view3).getAdWebView().loadAdBy(1)) {
                    ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                }
            }
        });
        ViewParent parent2 = e() ? view.getParent() : getParent();
        if (parent2 instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) parent2;
            frameLayout.addView(this.A);
            frameLayout.addView(this.f12455z);
        }
    }

    public void addDownloadTextView(View view) {
        try {
            com.beizi.ad.internal.f.c cVar = this.serverResponse;
            if (cVar != null && view != null) {
                int I = cVar.I();
                if (I == 2 || I == 5) {
                    final String B = this.serverResponse.B();
                    String D = this.serverResponse.D();
                    String C = this.serverResponse.C();
                    String F = this.serverResponse.F();
                    final String E = !TextUtils.isEmpty(F) ? F : this.serverResponse.E();
                    final String G = this.serverResponse.G();
                    final String H = this.serverResponse.H();
                    ViewParent parent = view.getParent();
                    TextView textView = new TextView(getContext());
                    textView.setText(Html.fromHtml("应用名称：" + B + " | 开发者：" + D + " | 应用版本：" + C + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                    textView.setTextSize(2, 6.0f);
                    textView.setTextColor(Color.parseColor("#999999"));
                    textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                    textView.setPadding(10, 10, 10, 10);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.17
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            try {
                                Intent intent = new Intent(AdViewImpl.this.getContext(), (Class<?>) DownloadAppInfoActivity.class);
                                intent.putExtra("title_content_key", B);
                                intent.putExtra("privacy_content_key", G);
                                intent.putExtra("permission_content_key", E);
                                intent.putExtra("intro_content_key", H);
                                intent.setFlags(268435456);
                                AdViewImpl.this.getContext().startActivity(intent);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    });
                    int d6 = (q.d(getContext()) * 2) / 3;
                    if (parent instanceof FrameLayout) {
                        ((FrameLayout) parent).addView(textView, new FrameLayout.LayoutParams(d6, -2, 83));
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void addInterstitialCloseButton(int i6, int i7, final View view, final boolean z5) {
        u.a(this.f12455z);
        if (i7 != -1) {
            this.f12455z = u.a(getContext(), i7);
            final int i8 = i6 > 0 ? i7 - i6 : 0;
            CountDownTimer countDownTimer = new CountDownTimer(i7 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.19
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Activity activity;
                    AdViewImpl.this.f12455z.setText("0");
                    if (!AdViewImpl.this.e()) {
                        AdViewImpl.this.getAdDispatcher().b();
                        ViewGroup viewGroup = AdViewImpl.this.f12430a;
                        return;
                    }
                    if (!z5) {
                        AdViewImpl.this.getAdDispatcher().b();
                        if (!(AdViewImpl.this.a(view) instanceof Activity) || (activity = (Activity) AdViewImpl.this.a(view)) == null || activity.isFinishing()) {
                            return;
                        }
                        activity.finish();
                        return;
                    }
                    View view2 = view;
                    if (view2 instanceof AdWebView) {
                        if (((AdWebView) view2).loadAdBy(1)) {
                            ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                        }
                    } else if ((view2 instanceof AdVideoView) && ((AdVideoView) view2).getAdWebView().loadAdBy(1)) {
                        ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j6) {
                    AdViewImpl.this.f12455z.setText(Integer.toString((int) ((j6 / 1000) + 1)));
                }
            };
            this.C = countDownTimer;
            countDownTimer.start();
        } else {
            if (i6 == -1) {
                return;
            }
            this.f12455z = u.a(getContext(), i6);
            CountDownTimer countDownTimer2 = new CountDownTimer(i6 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.20
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f12455z.setText("");
                    AdViewImpl.this.f12455z.setBackgroundResource(R.mipmap.ad_close);
                    AdViewImpl.this.f12455z.setVisibility(0);
                    AdViewImpl.this.f12455z.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.20.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (AdViewImpl.this.e()) {
                                AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                                if (z5) {
                                    View view3 = view;
                                    if (view3 instanceof AdWebView) {
                                        if (((AdWebView) view3).loadAdBy(1)) {
                                            ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                                            return;
                                        }
                                        return;
                                    } else {
                                        if ((view3 instanceof AdVideoView) && ((AdVideoView) view3).getAdWebView().loadAdBy(1)) {
                                            ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                AdViewImpl.this.getAdDispatcher().b();
                                AnonymousClass20 anonymousClass202 = AnonymousClass20.this;
                                if (AdViewImpl.this.a(view) instanceof Activity) {
                                    AnonymousClass20 anonymousClass203 = AnonymousClass20.this;
                                    Activity activity = (Activity) AdViewImpl.this.a(view);
                                    if (activity == null || activity.isFinishing()) {
                                        return;
                                    }
                                    activity.finish();
                                }
                            }
                        }
                    });
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j6) {
                    AdViewImpl.this.f12455z.setText(Integer.toString((int) ((j6 / 1000) + 1)));
                }
            };
            this.C = countDownTimer2;
            countDownTimer2.start();
        }
        ViewParent parent = e() ? view.getParent() : getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).addView(this.f12455z);
        }
    }

    public void addMuteButton(final AdVideoView adVideoView, boolean z5) {
        u.a(this.D);
        AppCompatImageView a6 = u.a(getContext(), z5);
        this.D = a6;
        a6.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdViewImpl.this.D.setImageResource(adVideoView.toggleMute() ? R.drawable.voice_off : R.drawable.voice_on);
            }
        });
        ViewParent parent = e() ? adVideoView.getParent() : getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).addView(this.D);
        }
    }

    public void addSkipView(int i6, View view) {
        u.a(this.A);
        u.a(this.f12455z);
        CountDownTimer countDownTimer = this.C;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (i6 <= 0) {
            i6 = 5;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(i6 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                AdViewImpl.this.f12431b.a(true);
                if (AdViewImpl.this.f12431b.a() && (AdViewImpl.this.f12431b.c() == a.EnumC0115a.UNCHANGE || AdViewImpl.this.f12431b.c() == a.EnumC0115a.STATE_PREPARE_CHANGE)) {
                    AdViewImpl.this.getAdDispatcher().b();
                }
                ViewGroup viewGroup = AdViewImpl.this.f12430a;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j6) {
                AdViewImpl.this.getAdDispatcher().a(j6);
            }
        };
        this.C = countDownTimer2;
        countDownTimer2.start();
        view.setVisibility(0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdViewImpl.this.getAdDispatcher().b();
                AdViewImpl.this.C.cancel();
                ViewGroup viewGroup = AdViewImpl.this.f12430a;
            }
        });
    }

    public void createAdLogo(c.a aVar, c.a aVar2) {
        u.a(this.K);
        u.a(this.L);
        if (!TextUtils.isEmpty(aVar.a())) {
            this.K = u.b(new MutableContextWrapper(getContext()), aVar);
        }
        if (TextUtils.isEmpty(aVar2.a())) {
            return;
        }
        this.L = u.a(new MutableContextWrapper(getContext()), aVar2);
    }

    public void destroy() {
        com.beizi.ad.internal.view.c cVar = this.f12432c;
        if (cVar != null) {
            cVar.destroy();
            this.f12432c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.F.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.beizi.ad.internal.c getAdDispatcher() {
        return this.f12451v;
    }

    public String getAdId() {
        return this.O;
    }

    public com.beizi.ad.a getAdListener() {
        return this.f12446q;
    }

    public com.beizi.ad.internal.e getAdParameters() {
        return this.f12437h;
    }

    public a.C0107a getAdRequest() {
        return this.f12438i;
    }

    public com.beizi.ad.c getAdSize() {
        return new com.beizi.ad.c(this.f12443n, this.f12444o);
    }

    public String getAdUnitId() {
        return this.f12437h.c();
    }

    public com.beizi.ad.d getAppEventListener() {
        return this.f12448s;
    }

    public String getAuctionStrategyData() {
        com.beizi.ad.internal.f.c cVar = this.serverResponse;
        if (cVar == null) {
            return null;
        }
        return cVar.R();
    }

    c getBrowserStyle() {
        return this.f12449t;
    }

    int getContainerHeight() {
        return this.f12437h.g();
    }

    int getContainerWidth() {
        return this.f12437h.f();
    }

    public int getCreativeHeight() {
        return this.f12444o;
    }

    public int getCreativeWidth() {
        return this.f12443n;
    }

    public String getLandingPageUrl() {
        return this.N;
    }

    public boolean getLoadsInBackground() {
        return this.f12436g;
    }

    public Handler getMyHandler() {
        return this.f12450u;
    }

    public boolean getOpensNativeBrowser() {
        return this.f12437h.h();
    }

    public String getPrice() {
        return this.M;
    }

    public l getRewaredVideoAdListener() {
        return this.f12447r;
    }

    public Map getSensorData() {
        com.beizi.ad.internal.f.c cVar = this.serverResponse;
        if (cVar == null) {
            return null;
        }
        return cVar.Q();
    }

    public boolean getShowLoadingIndicator() {
        return this.f12453x;
    }

    public ViewGroup getSplashParent() {
        return this.f12430a;
    }

    public boolean isCloseMarketDialog() {
        com.beizi.ad.internal.e eVar = this.f12437h;
        if (eVar != null) {
            return eVar.l();
        }
        return true;
    }

    public boolean isDownloadApp() {
        return this.R;
    }

    public void isLoadToShow(AdWebView adWebView) {
        this.S = adWebView;
        this.T = true;
        com.beizi.ad.a aVar = this.f12446q;
        if (aVar != null) {
            aVar.a();
        }
    }

    public boolean isLoaded() {
        return this.T;
    }

    public boolean isLoading() {
        return this.f12454y;
    }

    public boolean isRewardedVideo() {
        return this.f12439j;
    }

    public boolean loadAd(a.C0107a c0107a) {
        com.beizi.ad.internal.d dVar;
        com.beizi.ad.internal.d dVar2;
        this.f12438i = c0107a;
        if (!isReadyToStart()) {
            com.beizi.ad.a aVar = this.f12446q;
            if (aVar != null) {
                aVar.a(4);
            }
            return false;
        }
        if (getWindowVisibility() == 0 && (dVar2 = this.mAdFetcher) != null) {
            dVar2.a();
            this.mAdFetcher.c();
            this.mAdFetcher.b();
            this.f12454y = true;
            this.loadCount = 1;
            this.clickCount = 0;
            return true;
        }
        if (this.f12430a != null && (dVar = this.mAdFetcher) != null) {
            dVar.a();
            this.mAdFetcher.c();
            this.mAdFetcher.b();
            this.f12454y = true;
            this.loadCount = 1;
            this.clickCount = 0;
        }
        return false;
    }

    public void onDestoryLifeCycle() {
        com.beizi.ad.internal.d dVar = this.mAdFetcher;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void onResumeLifeCycle() {
        a aVar = this.f12431b;
        a.EnumC0115a enumC0115a = a.EnumC0115a.FINISHCLOSE;
        aVar.a(enumC0115a);
        if (this.f12431b.c() == enumC0115a) {
            getAdDispatcher().b();
        }
    }

    public void onStopLifeCycle() {
        this.f12431b.a(a.EnumC0115a.STATE_BACKGROUND);
    }

    public void sendLossNotificationWithInfo(Map map) {
        com.beizi.ad.internal.f.c cVar = this.serverResponse;
        if (cVar == null || map == null) {
            return;
        }
        cVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        com.beizi.ad.internal.f.c cVar = this.serverResponse;
        if (cVar == null || map == null) {
            return;
        }
        cVar.a(map);
    }

    void setAdExtInfo(String str) {
        this.f12445p = str;
    }

    public void setAdId(String str) {
        this.O = str;
    }

    public void setAdListener(com.beizi.ad.a aVar) {
        if (this.f12439j) {
            return;
        }
        this.f12446q = aVar;
    }

    public void setAdUnitId(String str) {
        this.f12437h.b(str);
    }

    public void setAppEventListener(com.beizi.ad.d dVar) {
        this.f12448s = dVar;
    }

    protected void setBrowserStyle(c cVar) {
        this.f12449t = cVar;
    }

    public void setCloseButtonPadding(int i6, int i7, int i8, int i9) {
        this.leftPadding = i6;
        this.topPadding = i7;
        this.rightPadding = i8;
        this.bottomPadding = i9;
    }

    public void setCloseMarketDialog(boolean z5) {
        com.beizi.ad.internal.e eVar = this.f12437h;
        if (eVar != null) {
            eVar.c(z5);
        }
    }

    void setCreativeHeight(int i6) {
        this.f12444o = i6;
    }

    void setCreativeWidth(int i6) {
        this.f12443n = i6;
    }

    public void setDownloadApp(boolean z5) {
        this.R = z5;
    }

    public void setLandingPageUrl(String str) {
        this.N = str;
    }

    public void setLoadsInBackground(boolean z5) {
        this.f12436g = z5;
    }

    public void setOpensNativeBrowser(boolean z5) {
        this.f12437h.b(z5);
    }

    public void setPrice(String str) {
        this.M = str;
    }

    public void setRewardedVideoAdListener(l lVar) {
        if (this.f12439j) {
            this.f12447r = lVar;
        }
    }

    protected void setShouldResizeParent(boolean z5) {
        this.f12452w = z5;
    }

    public void setShowLoadingIndicator(boolean z5) {
        this.f12453x = z5;
    }

    public void showAd() {
        AdViewImpl adViewImpl;
        try {
            ViewGroup viewGroup = this.f12430a;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.f12430a.addView(this);
            }
            AdWebView adWebView = this.S;
            com.beizi.ad.internal.f.c cVar = adWebView.ad;
            if (cVar == null || cVar.f11907a != k.SPLASH || this.f12442m == null) {
                int showCloseBtnTime = adWebView.getShowCloseBtnTime();
                int autoCloseTime = this.S.getAutoCloseTime();
                AdWebView adWebView2 = this.S;
                adViewImpl = this;
                try {
                    adViewImpl.addCloseButton(-1, showCloseBtnTime, autoCloseTime, adWebView2, adWebView2.ad.x() == f.a.ADP_IVIDEO);
                } catch (Exception e6) {
                    e = e6;
                    e.printStackTrace();
                    return;
                }
            } else {
                addSkipView(adWebView.getAutoCloseTime(), this.f12442m);
                adViewImpl = this;
            }
            adViewImpl.S.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.15
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl.this.S.ad.a(AdViewImpl.this.S, AdViewImpl.this.f12437h.a());
                    if (AdViewImpl.this.f12446q != null) {
                        AdViewImpl.this.f12446q.b();
                    }
                }
            });
        } catch (Exception e7) {
            e = e7;
        }
    }

    public void showAdLogo(View view) {
        try {
            u.a(this.K);
            u.a(this.L);
            ViewParent parent = e() ? view.getParent() : this;
            if (parent instanceof FrameLayout) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                FrameLayout frameLayout = this.L;
                if (frameLayout != null) {
                    linearLayout.addView(frameLayout, new FrameLayout.LayoutParams(-2, -2, 17));
                    this.L.setVisibility(0);
                    this.L.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            AdViewImpl.this.g();
                        }
                    });
                }
                FrameLayout frameLayout2 = this.K;
                if (frameLayout2 != null) {
                    linearLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-2, -2, 17));
                    this.K.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.K.getLayoutParams();
                layoutParams.setMargins(5, 0, 0, 0);
                layoutParams.gravity = 17;
                this.K.setLayoutParams(layoutParams);
                ((FrameLayout) parent).addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                int a6 = u.a(getContext(), 12.0f);
                layoutParams2.setMargins(0, 0, a6, a6);
                linearLayout.setLayoutParams(layoutParams2);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void showBannerCloseBtn(View view) {
        ImageView imageView;
        if (!(view instanceof FrameLayout) || (imageView = this.B) == null) {
            return;
        }
        ((FrameLayout) view).addView(imageView);
    }

    void b() {
        getVisibility();
    }

    void c() {
        getVisibility();
    }

    public void closeAd() {
        try {
            getAdDispatcher().b();
            this.C.cancel();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable unused) {
        }
        com.beizi.ad.internal.d dVar = this.mAdFetcher;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.beizi.ad.internal.a
    public boolean isReadyToStart() {
        com.beizi.ad.internal.e eVar;
        if (a() || (eVar = this.f12437h) == null || !eVar.j() || this.f12438i == null) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
    }

    public void openAdInNativeBrowser(boolean z5) {
        setOpensNativeBrowser(z5);
    }

    public void pingClick(String str) {
        if (!o.a(str)) {
            new i(str).execute(new Void[0]);
        }
    }

    public void pingConvert(String str) {
        if (!o.a(str)) {
            new i(str).execute(new Void[0]);
        }
    }

    void a(Context context, AttributeSet attributeSet) {
        setBackgroundColor(0);
        this.f12451v = new b(this.f12450u);
        this.f12437h = new com.beizi.ad.internal.e(context, o.a());
        this.F = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.12
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                AdViewImpl.this.G = motionEvent.getX();
                AdViewImpl.this.H = motionEvent.getY();
                AdViewImpl.this.I = motionEvent.getRawX();
                AdViewImpl.this.J = motionEvent.getRawY();
                AdViewImpl adViewImpl = AdViewImpl.this;
                int i6 = adViewImpl.clickCount;
                int i7 = adViewImpl.loadCount;
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }
        });
        setPadding(0, 0, 0, 0);
        this.mAdFetcher = new com.beizi.ad.internal.d(this);
        if (attributeSet != null) {
            b(context, attributeSet);
        }
        try {
            this.P = (String) com.beizi.ad.internal.h.m.b(this.f12437h.b(), "urlTemplate", com.beizi.ad.lance.a.b.b("aHR0cHM6Ly9hcGkuaHRwLmFkLXNjb3BlLmNvbS5jbi9tYi9zZGsvZXZlbnQvdjE/ZXh0SW5mbz13QkxRZVA4Ym1xNkF1SjVEYVp5YzV4UVFVXzkyT1drU1VkeV82VjRuMlJBM01iZ2VodzZKNjdaZndjRFFDbWozdVR5aENrclQ4bk1Bc1EmcmVxdWVzdFV1aWQ9X19SRVFVRVNUVVVJRF9fJmV2ZW50VHlwZT1fX0VWRU5UVFlQRV9fJmFwcElEPV9fQVBQSURfXyZzcGFjZUlEPV9fU1BBQ0VJRF9fJmNoYW5uZWxJRD1fX0NIQU5ORUxJRF9fJmNoYW5uZWxBcHBJRD1fX0NIQU5ORUxBUFBJRF9fJmNoYW5uZWxTcGFjZUlEPV9fQ0hBTk5FTFNQQUNFSURfXyZ0cz1fX1RTX18maXA9X19JUF9fJm5ldFR5cGU9X19ORVRUWVBFX18mY2Fycmllcj1fX0NBUlJJRVJfXyZlcnJJbmZvPV9fRVJSSU5GT19fJnNka0V4dEluZm89X19TREtFWFRJTkZPX18maW1laT1fX0lNRUlfXyZhbmRyb2lkSUQ9X19BTkRST0lESURfXyZpZGZhPV9fSURGQV9fJmlkZnY9X19JREZWX18mbWFjPV9fTUFDX18mdWlkPV9fVUlEX18mc2RrVmVyc2lvbj1fX1NES1ZFUlNJT05fXyZhcHBWZXJpc29uPV9fQVBQVkVSU0lPTl9f"));
            this.Q = (String) com.beizi.ad.internal.h.m.b(this.f12437h.b(), "eventsList", "[1, 2, 3, 4, 5, 6]");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    boolean a() {
        return this.f12434e;
    }

    protected Context a(View view) {
        if (view.getContext() instanceof MutableContextWrapper) {
            return ((MutableContextWrapper) view.getContext()).getBaseContext();
        }
        return getContext();
    }

    private void a(WebView webView, Context context) {
        Intent intent = new Intent(context, (Class<?>) AdActivity.a());
        intent.setFlags(268435456);
        intent.putExtra("ACTIVITY_TYPE", "BROWSER");
        com.beizi.ad.internal.activity.a.f11616a.add(webView);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            com.beizi.ad.internal.activity.a.f11616a.remove();
        }
    }

    public void onCreateLifeCycle() {
    }

    public void onPauseLifeCycle() {
    }

    public void onRestartLifeCycle() {
    }

    public void onStartLifeCycle() {
    }

    AdViewImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AdViewImpl(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f12430a = null;
        this.f12442m = null;
        this.f12445p = "";
        this.f12431b = new a();
        this.f12450u = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.view.AdViewImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.f12433d = false;
        this.f12434e = false;
        this.f12435f = false;
        this.f12436g = true;
        this.f12452w = false;
        this.f12453x = true;
        this.f12437h = null;
        this.f12438i = null;
        this.f12454y = false;
        this.f12439j = false;
        this.f12440k = false;
        this.T = false;
        this.f12441l = 0;
        a(context, attributeSet);
    }

    protected void a(int i6, int i7, f fVar) {
        u.a(this.A);
        this.A = null;
        AdWebView adWebView = fVar.f12668b;
        if (adWebView.f12531a) {
            u.a(adWebView);
            if (fVar.d() != null) {
                fVar.d().addView(fVar.f12668b, 0);
            }
            if (fVar.c() != null) {
                fVar.c().finish();
            }
            if (getMediaType().equals(k.BANNER) && (fVar.f12668b.getContext() instanceof MutableContextWrapper)) {
                ((MutableContextWrapper) fVar.f12668b.getContext()).setBaseContext(getContext());
            }
        }
        U = null;
        V = null;
        W = null;
        a(i6, i7);
        this.f12435f = true;
        this.f12434e = false;
    }

    private void a(int i6, int i7) {
        this.f12433d = true;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width > 0) {
                getLayoutParams().width = i6;
            }
            if (getLayoutParams().height > 0) {
                getLayoutParams().height = i7;
            }
        }
        if (this.f12452w && (getParent() instanceof View)) {
            View view = (View) getParent();
            if (view.getLayoutParams() != null) {
                if (view.getLayoutParams().width > 0) {
                    view.getLayoutParams().width = i6;
                }
                if (view.getLayoutParams().height > 0) {
                    view.getLayoutParams().height = i7;
                }
            }
        }
    }

    protected void a(final f fVar, boolean z5, AdWebView.b bVar) {
        fVar.a((ViewGroup) fVar.f12668b.getParent());
        FrameLayout frameLayout = new FrameLayout(getContext());
        u.a(fVar.f12668b);
        frameLayout.addView(fVar.f12668b);
        if (this.A == null) {
            AppCompatTextView b6 = u.b(getContext());
            this.A = b6;
            b6.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    fVar.a();
                }
            });
        }
        frameLayout.addView(this.A);
        U = frameLayout;
        V = fVar;
        W = bVar;
        try {
            Intent intent = new Intent(getContext(), (Class<?>) AdActivity.a());
            intent.putExtra("ACTIVITY_TYPE", "MRAID");
            intent.setFlags(268435456);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            U = null;
            V = null;
            W = null;
        }
    }

    void a(int i6, int i7, boolean z5, final f fVar, AdWebView.b bVar) {
        a(i6, i7);
        AppCompatTextView b6 = u.b(getContext());
        this.A = b6;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b6.getLayoutParams();
        if (!fVar.f12668b.f12531a && getChildAt(0) != null) {
            layoutParams.rightMargin = (getMeasuredWidth() - getChildAt(0).getMeasuredWidth()) / 2;
        }
        this.A.setLayoutParams(layoutParams);
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fVar.a();
            }
        });
        if (fVar.f12668b.f12531a) {
            a(fVar, z5, bVar);
        } else {
            addView(this.A);
        }
        this.f12434e = true;
    }

    void a(int i6, int i7, int i8, int i9, f.a aVar, boolean z5, final f fVar) {
        a(i6, i7);
        u.a(this.A);
        if (this.f12441l <= 0) {
            this.f12441l = (int) (fVar.f12668b.getContext().getResources().getDisplayMetrics().density * 50.0f);
        }
        this.A = new AppCompatTextView(getContext()) { // from class: com.beizi.ad.internal.view.AdViewImpl.10
            @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
            @SuppressLint({"NewApi", "DrawAllocation"})
            public void onLayout(boolean z6, int i10, int i11, int i12, int i13) {
                boolean z7;
                Point point;
                int i14;
                int i15;
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                Point point2 = new Point(0, 0);
                try {
                    r12 = fVar.f12668b.getContext() instanceof Activity ? (Activity) fVar.f12668b.getContext() : null;
                    z7 = true;
                } catch (Throwable unused) {
                    z7 = false;
                }
                if (r12 != null && z7) {
                    r12.getWindowManager().getDefaultDisplay().getSize(point2);
                }
                int[] iArr2 = new int[2];
                if (AdViewImpl.this.getMediaType().equals(k.INTERSTITIAL)) {
                    InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.measure(0, 0);
                    InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getLocationOnScreen(iArr2);
                    point = new Point(InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getMeasuredWidth(), InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getMeasuredHeight());
                } else {
                    AdViewImpl.this.measure(0, 0);
                    AdViewImpl.this.getLocationOnScreen(iArr2);
                    point = new Point(AdViewImpl.this.getMeasuredWidth(), AdViewImpl.this.getMeasuredHeight());
                }
                int i16 = point.x;
                int i17 = AdViewImpl.this.f12441l;
                int i18 = i16 - i17;
                int i19 = point.y - i17;
                if (z7) {
                    i18 = (iArr2[0] + Math.min(point2.x, i16)) - AdViewImpl.this.f12441l;
                    i19 = (iArr2[1] + Math.min(point2.y, point.y)) - AdViewImpl.this.f12441l;
                    i14 = iArr2[0];
                    i15 = iArr2[1];
                } else {
                    i14 = 0;
                    i15 = 0;
                }
                int i20 = iArr[0];
                if (i20 + 1 >= i14 && i20 - 1 <= i18) {
                    int i21 = iArr[1];
                    if (i21 + 1 >= i15 && i21 - 1 <= i19) {
                        return;
                    }
                }
                final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
                layoutParams.setMargins(40, 40, 40, 40);
                post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        setLayoutParams(layoutParams);
                    }
                });
                AdViewImpl.this.A.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_close_background));
                AdViewImpl.this.A.setTextColor(ContextCompat.getColorStateList(getContext(), R.color.button_text_selector));
                AdViewImpl.this.A.setTextSize(2, 16.0f);
                AdViewImpl.this.A.setText(R.string.beizi_skip_ad);
            }
        };
        int i10 = this.f12441l;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i10, i10, 17);
        int i11 = this.f12441l;
        int i12 = (i7 / 2) - (i11 / 2);
        int i13 = (i6 / 2) - (i11 / 2);
        int i14 = AnonymousClass14.f12465a[aVar.ordinal()];
        if (i14 == 1) {
            layoutParams.topMargin = i12;
        } else if (i14 == 2) {
            layoutParams.rightMargin = i13;
            layoutParams.topMargin = i12;
        } else if (i14 == 3) {
            layoutParams.leftMargin = i13;
            layoutParams.topMargin = i12;
        } else if (i14 == 5) {
            layoutParams.bottomMargin = i12;
        } else if (i14 == 6) {
            layoutParams.rightMargin = i13;
            layoutParams.bottomMargin = i12;
        } else if (i14 == 7) {
            layoutParams.leftMargin = i13;
            layoutParams.bottomMargin = i12;
        }
        this.A.setLayoutParams(layoutParams);
        this.A.setBackgroundColor(0);
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fVar.a();
            }
        });
        if (fVar.f12668b.getParent() != null) {
            ((ViewGroup) fVar.f12668b.getParent()).addView(this.A);
        }
    }
}
