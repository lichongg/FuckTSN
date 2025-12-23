package com.beizi.ad.internal.splash;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.i;
import com.beizi.ad.internal.h.j;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.internal.k;
import com.beizi.ad.lance.a.q;
import com.beizi.ad.model.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.ad.internal.f.a implements com.beizi.ad.internal.a {
    private boolean A;
    private boolean B;

    /* renamed from: a, reason: collision with root package name */
    public com.beizi.ad.internal.f.c f12304a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f12305b;

    /* renamed from: d, reason: collision with root package name */
    private View f12306d;

    /* renamed from: e, reason: collision with root package name */
    private com.beizi.ad.a f12307e;

    /* renamed from: f, reason: collision with root package name */
    private C0113a f12308f;

    /* renamed from: g, reason: collision with root package name */
    private e f12309g;

    /* renamed from: h, reason: collision with root package name */
    private String f12310h;

    /* renamed from: i, reason: collision with root package name */
    private String f12311i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12312j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12313k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f12314l;

    /* renamed from: m, reason: collision with root package name */
    private CountDownTimer f12315m;

    /* renamed from: n, reason: collision with root package name */
    private int f12316n;

    /* renamed from: o, reason: collision with root package name */
    private String f12317o;

    /* renamed from: p, reason: collision with root package name */
    private f.EnumC0127f f12318p;

    /* renamed from: q, reason: collision with root package name */
    private int f12319q;

    /* renamed from: r, reason: collision with root package name */
    private int f12320r;

    /* renamed from: s, reason: collision with root package name */
    private WebView f12321s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f12322t;

    /* renamed from: u, reason: collision with root package name */
    private String f12323u;

    /* renamed from: v, reason: collision with root package name */
    private k f12324v;

    /* renamed from: w, reason: collision with root package name */
    private CountDownTimer f12325w;

    /* renamed from: x, reason: collision with root package name */
    private int f12326x;

    /* renamed from: y, reason: collision with root package name */
    private com.beizi.ad.internal.a.b f12327y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f12328z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.splash.a$a, reason: collision with other inner class name */
    private class C0113a implements com.beizi.ad.internal.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f12339a;

        @Override // com.beizi.ad.internal.c
        public void a() {
        }

        @Override // com.beizi.ad.internal.c
        public void a(long j6) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, int i6) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, String str2) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(com.beizi.ad.internal.f.b bVar) {
            try {
                this.f12339a.m();
                if (this.f12339a.A) {
                    this.f12339a.a(bVar.j(), bVar.k());
                } else {
                    if (bVar.j() == null) {
                        if (this.f12339a.l()) {
                            return;
                        }
                        a(0);
                        return;
                    }
                    this.f12339a.a(true, bVar.k(), bVar.j());
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a(int i6) {
            this.f12339a.f12313k = false;
            if (this.f12339a.A) {
                return;
            }
            this.f12339a.m();
            if (this.f12339a.l()) {
                return;
            }
            this.f12339a.a(i6);
        }

        @Override // com.beizi.ad.internal.c
        public void b() {
        }

        @Override // com.beizi.ad.internal.c
        public void c() {
        }

        @Override // com.beizi.ad.internal.c
        public void d() {
        }

        @Override // com.beizi.ad.internal.c
        public void e() {
        }

        @Override // com.beizi.ad.internal.c
        public void f() {
        }
    }

    private void e() {
        try {
            f.EnumC0127f enumC0127f = this.f12318p;
            if (enumC0127f == f.EnumC0127f.RENDER_PIC) {
                if (TextUtils.isEmpty(this.f12317o)) {
                    a(3);
                    return;
                } else if (this.f12317o.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    f();
                    return;
                } else {
                    a(7);
                    return;
                }
            }
            if (enumC0127f != f.EnumC0127f.RENDER_H5) {
                a(3);
            } else {
                if (TextUtils.isEmpty(this.f12317o)) {
                    a(3);
                    return;
                }
                if (this.f12317o.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    this.f12317o = "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n  <title>Document</title>\n  <style>\n    html, body { width: 100%; height: 100%; margin: 0; padding: 0 }\n    .material-wrap { overflow: hidden; position: relative; height: 100%; background-repeat: no-repeat; background-position: center center; background-size: cover }\n    .filter-shadow { content: \"\"; position: absolute; z-index: 2; top: -3%; left: -3%; right: -3%; bottom: -3%; background: inherit; filter: blur(10px) }\n    .material-wrap .black-shadow { position: absolute; z-index: 3; top: 0; left: 0; right: 0; bottom: 0; background: rgba(0, 0, 0, .05) }\n    .material-wrap .material { position: absolute; z-index: 3; top: 0; left: 0; width: 100%; height: 100%; background-repeat: no-repeat; background-position: center center; background-size: contain }\n  </style>\n</head>\n<body>\n  <div class=\"material-wrap\" style=\"background-image: url('__IMAGE_SRC_PATH__')\">\n    <div class=\"filter-shadow\"></div>\n    <div class=\"black-shadow\"></div>\n    <div class=\"material\" style=\"background-image: url('__IMAGE_SRC_PATH__')\"></div>\n  </div>\n</body>\n</html>\n".replaceAll("__IMAGE_SRC_PATH__", this.f12317o);
                }
                g();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            a(3);
        }
    }

    private void f() {
        i.a((Context) null).a(this.f12317o, new i.a() { // from class: com.beizi.ad.internal.splash.a.1
            @Override // com.beizi.ad.internal.h.i.a
            public void a(Bitmap bitmap) {
                try {
                    if (a.this.f12305b == null) {
                        a.this.a(10);
                        return;
                    }
                    if (bitmap == null) {
                        a.this.a(8);
                        return;
                    }
                    Context context = a.this.f12305b.getContext();
                    float width = (float) ((bitmap.getWidth() * 1.0d) / bitmap.getHeight());
                    int i6 = a.this.f12319q;
                    int i7 = a.this.f12320r > 0 ? a.this.f12320r : (int) (i6 / width);
                    ImageView imageView = new ImageView(context);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = i6;
                        layoutParams.height = i7;
                        imageView.setLayoutParams(layoutParams);
                    }
                    imageView.setBackground(new BitmapDrawable(j.a(context, bitmap, 20.0f)));
                    imageView.setImageBitmap(bitmap);
                    a.this.f12305b.addView(imageView, new FrameLayout.LayoutParams(i6, i7));
                    a.this.i();
                    a.this.j();
                    a.this.h();
                    a.this.k();
                } catch (Exception e6) {
                    e6.printStackTrace();
                    a.this.a(8);
                }
            }

            @Override // com.beizi.ad.internal.h.i.a
            public void a() {
                a.this.a(8);
            }
        });
    }

    private void g() {
        ViewGroup viewGroup = this.f12305b;
        if (viewGroup == null) {
            a(10);
            return;
        }
        WebView webView = new WebView(viewGroup.getContext());
        this.f12321s = webView;
        x.a(webView);
        this.f12321s.setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.splash.a.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                try {
                    if (a.this.f12305b == null) {
                        a.this.a(10);
                        return;
                    }
                    if (a.this.f12321s == null) {
                        a.this.a(9);
                        return;
                    }
                    a.this.f12305b.addView(a.this.f12321s);
                    a.this.i();
                    a.this.j();
                    a.this.h();
                    a.this.k();
                } catch (Exception e6) {
                    e6.printStackTrace();
                    a.this.a(2);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                a.this.a(2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                a.this.a(2);
            }
        });
        this.f12321s.loadDataWithBaseURL(null, this.f12317o, "text/html", "UTF-8", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        View view = this.f12306d;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        this.f12306d.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.splash.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        View b6;
        FrameLayout a6;
        try {
            ViewGroup viewGroup = this.f12305b;
            if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
                Context context = viewGroup.getContext();
                LinearLayout linearLayout = new LinearLayout(this.f12305b.getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                c.a A = this.f12304a.A();
                if (!TextUtils.isEmpty(A.a()) && (a6 = u.a(new MutableContextWrapper(context), A)) != null) {
                    linearLayout.addView(a6, new FrameLayout.LayoutParams(-2, -2, 17));
                    a6.setVisibility(0);
                    a6.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.splash.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                        }
                    });
                }
                c.a z5 = this.f12304a.z();
                if (!TextUtils.isEmpty(z5.a()) && (b6 = u.b(new MutableContextWrapper(this.f12305b.getContext()), z5)) != null) {
                    linearLayout.addView(b6, new FrameLayout.LayoutParams(-2, -2, 17));
                    b6.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b6.getLayoutParams();
                    layoutParams.setMargins(5, 0, 0, 0);
                    layoutParams.gravity = 17;
                    b6.setLayoutParams(layoutParams);
                }
                ((FrameLayout) this.f12305b).addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                int a7 = u.a(context, 12.0f);
                layoutParams2.setMargins(0, 0, a7, a7);
                linearLayout.setLayoutParams(layoutParams2);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int I;
        try {
            com.beizi.ad.internal.f.c cVar = this.f12304a;
            if (cVar == null || this.f12305b == null || !((I = cVar.I()) == 2 || I == 5)) {
                return;
            }
            final String B = this.f12304a.B();
            String D = this.f12304a.D();
            String C = this.f12304a.C();
            String F = this.f12304a.F();
            final String E = !TextUtils.isEmpty(F) ? F : this.f12304a.E();
            final String G = this.f12304a.G();
            final String H = this.f12304a.H();
            final Context context = this.f12305b.getContext();
            TextView textView = new TextView(context);
            textView.setText(Html.fromHtml("应用名称：" + B + " | 开发者：" + D + " | 应用版本：" + C + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
            textView.setTextSize(2, 6.0f);
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
            textView.setPadding(10, 10, 10, 10);
            try {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.splash.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(context, (Class<?>) DownloadAppInfoActivity.class);
                            intent.putExtra("title_content_key", B);
                            intent.putExtra("privacy_content_key", G);
                            intent.putExtra("permission_content_key", E);
                            intent.putExtra("intro_content_key", H);
                            intent.setFlags(268435456);
                            context.startActivity(intent);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
                int d6 = (q.d(context) * 2) / 3;
                ViewGroup viewGroup = this.f12305b;
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).addView(textView, new FrameLayout.LayoutParams(d6, -2, 83));
                }
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f12322t) {
            return;
        }
        this.f12314l = true;
        com.beizi.ad.a aVar = this.f12307e;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        com.beizi.ad.internal.f.c a6;
        if (this.f12326x <= 0 || this.f12328z) {
            return false;
        }
        com.beizi.ad.internal.a.b b6 = com.beizi.ad.internal.a.a.a().b(a());
        this.f12327y = b6;
        if (b6 == null || (a6 = com.beizi.ad.internal.a.a.a().a(this.f12327y, this.f12324v)) == null) {
            return false;
        }
        if (this.f12328z) {
            com.beizi.ad.internal.a.a.a().a(this.f12327y, 1, this.f12326x);
            return false;
        }
        a(false, null, a6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        CountDownTimer countDownTimer = this.f12325w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f12325w = null;
        }
    }

    public void b(String str) {
        this.f12311i = str;
    }

    public void c() {
        try {
            com.beizi.ad.a aVar = this.f12307e;
            if (aVar != null) {
                aVar.c();
            }
            CountDownTimer countDownTimer = this.f12315m;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public com.beizi.ad.internal.c d() {
        return this.f12308f;
    }

    @Override // com.beizi.ad.internal.a
    public k getMediaType() {
        return this.f12309g.i();
    }

    @Override // com.beizi.ad.internal.a
    public boolean isReadyToStart() {
        return this.f12307e != null && this.f12309g.j();
    }

    e b() {
        return this.f12309g;
    }

    public String a() {
        return this.f12309g.c();
    }

    public void a(String str) {
        this.f12310h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6) {
        com.beizi.ad.a aVar = this.f12307e;
        if (aVar == null || this.f12322t || this.f12314l) {
            return;
        }
        this.f12322t = true;
        aVar.a(i6);
    }

    private void c(com.beizi.ad.internal.f.c cVar) {
        this.f12316n = cVar.s();
        this.f12317o = cVar.S();
        this.f12318p = cVar.T();
        a(cVar.e());
        b(cVar.f());
        a(cVar.P());
        e();
    }

    public void a(boolean z5) {
        this.f12312j = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z5, String str, com.beizi.ad.internal.f.c cVar) {
        try {
            if (this.B) {
                if (z5) {
                    a(cVar, str);
                } else if (this.f12328z) {
                    com.beizi.ad.internal.a.a.a().a(this.f12327y, 1, this.f12326x);
                }
                return;
            }
            this.B = true;
            this.f12304a = cVar;
            if (z5) {
                this.f12328z = true;
            } else {
                this.A = true;
                this.f12309g.a(this.f12327y.d());
                this.f12304a.c(true);
            }
            c(cVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(com.beizi.ad.internal.f.c cVar, String str) {
        if (cVar == null || !cVar.h() || TextUtils.isEmpty(str)) {
            return;
        }
        com.beizi.ad.internal.a.a.a().a(cVar, str, this.f12323u, a(), this.f12324v);
    }
}
