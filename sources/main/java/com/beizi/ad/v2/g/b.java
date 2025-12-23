package com.beizi.ad.v2.g;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.CountDownTimer;
import android.os.Handler;
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
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.i;
import com.beizi.ad.internal.h.j;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.internal.k;
import com.beizi.ad.lance.a.q;
import com.beizi.ad.model.d;
import com.beizi.ad.model.f;
import com.beizi.fusion.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends com.beizi.ad.v2.a.b {
    private ViewGroup G;
    private View H;
    private com.beizi.ad.a I;
    private CountDownTimer J;
    private String K;
    private f.EnumC0127f L;
    private int M;
    private int N;
    private WebView O;
    private com.beizi.ad.v2.b.a P;

    public b(Context context, ViewGroup viewGroup, View view, String str) {
        super(context, str, k.NEW_SPLASH);
        this.G = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        View b6;
        FrameLayout a6;
        try {
            ViewGroup viewGroup = this.G;
            if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
                Context context = viewGroup.getContext();
                LinearLayout linearLayout = new LinearLayout(this.G.getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                c.a A = this.f13086c.A();
                if (!TextUtils.isEmpty(A.a()) && (a6 = u.a(new MutableContextWrapper(context), A)) != null) {
                    linearLayout.addView(a6, new FrameLayout.LayoutParams(-2, -2, 17));
                    a6.setVisibility(0);
                    a6.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.g.b.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                        }
                    });
                }
                c.a z5 = this.f13086c.z();
                if (!TextUtils.isEmpty(z5.a()) && (b6 = u.b(new MutableContextWrapper(this.G.getContext()), z5)) != null) {
                    linearLayout.addView(b6, new FrameLayout.LayoutParams(-2, -2, 17));
                    b6.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b6.getLayoutParams();
                    layoutParams.setMargins(5, 0, 0, 0);
                    layoutParams.gravity = 17;
                    b6.setLayoutParams(layoutParams);
                }
                ((FrameLayout) this.G).addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
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
    public void B() {
        int I;
        try {
            c cVar = this.f13086c;
            if (cVar == null || this.G == null || !((I = cVar.I()) == 2 || I == 5)) {
                return;
            }
            final String B = this.f13086c.B();
            String D = this.f13086c.D();
            String C = this.f13086c.C();
            String F = this.f13086c.F();
            final String E = !TextUtils.isEmpty(F) ? F : this.f13086c.E();
            final String G = this.f13086c.G();
            final String H = this.f13086c.H();
            final Context context = this.G.getContext();
            TextView textView = new TextView(context);
            textView.setText(Html.fromHtml("应用名称：" + B + " | 开发者：" + D + " | 应用版本：" + C + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
            textView.setTextSize(2, 6.0f);
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
            textView.setPadding(10, 10, 10, 10);
            try {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.g.b.9
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
                ViewGroup viewGroup = this.G;
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
    public void C() {
        if (this.f13093j) {
            return;
        }
        this.f13090g = true;
        com.beizi.ad.a aVar = this.I;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void D() {
        if (this.L == f.EnumC0127f.RENDER_PIC && !TextUtils.isEmpty(this.K)) {
            i.a((Context) null).a(this.K, false, new i.a() { // from class: com.beizi.ad.v2.g.b.3
                @Override // com.beizi.ad.internal.h.i.a
                public void a(Bitmap bitmap) {
                }

                @Override // com.beizi.ad.internal.h.i.a
                public void a() {
                    b.this.b(8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            f.EnumC0127f enumC0127f = this.L;
            if (enumC0127f == f.EnumC0127f.RENDER_PIC) {
                if (TextUtils.isEmpty(this.K)) {
                    b(3);
                    return;
                } else if (this.K.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    x();
                    return;
                } else {
                    b(7);
                    return;
                }
            }
            if (enumC0127f != f.EnumC0127f.RENDER_H5) {
                b(3);
            } else {
                if (TextUtils.isEmpty(this.K)) {
                    b(3);
                    return;
                }
                if (this.K.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    this.K = "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n  <title>Document</title>\n  <style>\n    html, body { width: 100%; height: 100%; margin: 0; padding: 0 }\n    .material-wrap { overflow: hidden; position: relative; height: 100%; background-repeat: no-repeat; background-position: center center; background-size: cover }\n    .filter-shadow { content: \"\"; position: absolute; z-index: 2; top: -3%; left: -3%; right: -3%; bottom: -3%; background: inherit; filter: blur(10px) }\n    .material-wrap .black-shadow { position: absolute; z-index: 3; top: 0; left: 0; right: 0; bottom: 0; background: rgba(0, 0, 0, .05) }\n    .material-wrap .material { position: absolute; z-index: 3; top: 0; left: 0; width: 100%; height: 100%; background-repeat: no-repeat; background-position: center center; background-size: contain }\n  </style>\n</head>\n<body>\n  <div class=\"material-wrap\" style=\"background-image: url('__IMAGE_SRC_PATH__')\">\n    <div class=\"filter-shadow\"></div>\n    <div class=\"black-shadow\"></div>\n    <div class=\"material\" style=\"background-image: url('__IMAGE_SRC_PATH__')\"></div>\n  </div>\n</body>\n</html>\n".replaceAll("__IMAGE_SRC_PATH__", this.K);
                }
                y();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            b(3);
        }
    }

    private void x() {
        final ImageView imageView;
        if (this.B) {
            try {
                imageView = new ImageView(this.G.getContext());
            } catch (Exception e6) {
                e = e6;
                imageView = null;
            }
            try {
                this.G.addView(imageView);
                if (this.E) {
                    imageView.setAlpha(0.0f);
                }
                if (!this.C) {
                    A();
                    B();
                }
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                i.a((Context) null).a(this.K, new i.a() { // from class: com.beizi.ad.v2.g.b.4
                    @Override // com.beizi.ad.internal.h.i.a
                    public void a(final Bitmap bitmap) {
                        ViewGroup.LayoutParams layoutParams;
                        try {
                            if (b.this.G == null) {
                                b.this.b(10);
                                return;
                            }
                            if (bitmap == null) {
                                b.this.b(8);
                                return;
                            }
                            final Context context = b.this.G.getContext();
                            float width = (float) ((bitmap.getWidth() * 1.0d) / bitmap.getHeight());
                            int i6 = b.this.M;
                            int i7 = b.this.N > 0 ? b.this.N : (int) (i6 / width);
                            final ImageView imageView2 = ((com.beizi.ad.v2.a.b) b.this).B ? imageView : new ImageView(context);
                            if (imageView2 != null && (layoutParams = imageView2.getLayoutParams()) != null) {
                                layoutParams.width = i6;
                                layoutParams.height = i7;
                                imageView2.setLayoutParams(layoutParams);
                            }
                            float abs = Math.abs(((float) ((i6 * 1.0d) / i7)) - width);
                            if (abs > 0.1f) {
                                com.beizi.ad.lance.a.c.b().e().execute(new Runnable() { // from class: com.beizi.ad.v2.g.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Bitmap bitmap2;
                                        try {
                                            Context context2 = context;
                                            if (context2 == null || (bitmap2 = bitmap) == null) {
                                                return;
                                            }
                                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(j.a(context2, bitmap2, 20.0f));
                                            if (((com.beizi.ad.v2.a.b) b.this).F != null) {
                                                ((com.beizi.ad.v2.a.b) b.this).F.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.4.1.1
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        ImageView imageView3;
                                                        try {
                                                            BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                                                            if (bitmapDrawable2 == null || (imageView3 = imageView2) == null) {
                                                                return;
                                                            }
                                                            imageView3.setBackground(bitmapDrawable2);
                                                        } catch (Throwable th) {
                                                            th.printStackTrace();
                                                        }
                                                    }
                                                });
                                            }
                                        } catch (Exception e8) {
                                            e8.printStackTrace();
                                        }
                                    }
                                });
                            } else if (abs > 0.07d) {
                                imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            } else {
                                imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                            imageView2.setImageBitmap(bitmap);
                            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i6, i7);
                            if (!((com.beizi.ad.v2.a.b) b.this).B) {
                                b.this.G.addView(imageView2, layoutParams2);
                                b.this.A();
                                b.this.B();
                                b.this.C();
                                return;
                            }
                            imageView2.setLayoutParams(layoutParams2);
                            if (((com.beizi.ad.v2.a.b) b.this).E) {
                                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView2, "alpha", 0.0f, 1.0f);
                                ofFloat.setDuration(200L);
                                ofFloat.start();
                            }
                            if (((com.beizi.ad.v2.a.b) b.this).C) {
                                b.this.A();
                                b.this.B();
                            }
                            if (b.this.P != null) {
                                b.this.P.a();
                            }
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            b.this.b(8);
                        }
                    }

                    @Override // com.beizi.ad.internal.h.i.a
                    public void a() {
                        if (((com.beizi.ad.v2.a.b) b.this).B) {
                            try {
                                ImageView imageView2 = imageView;
                                if (imageView2 != null) {
                                    imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                                    imageView.setImageResource(R.drawable.beizi_bg_place_holder);
                                    if (((com.beizi.ad.v2.a.b) b.this).E) {
                                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 1.0f);
                                        ofFloat.setDuration(200L);
                                        ofFloat.start();
                                    }
                                }
                                if (((com.beizi.ad.v2.a.b) b.this).C) {
                                    b.this.A();
                                    b.this.B();
                                }
                                if (b.this.P != null) {
                                    b.this.P.a();
                                    return;
                                }
                                return;
                            } catch (Exception e8) {
                                e8.printStackTrace();
                                return;
                            }
                        }
                        b.this.b(8);
                    }
                });
            }
        } else {
            imageView = null;
        }
        i.a((Context) null).a(this.K, new i.a() { // from class: com.beizi.ad.v2.g.b.4
            @Override // com.beizi.ad.internal.h.i.a
            public void a(final Bitmap bitmap) {
                ViewGroup.LayoutParams layoutParams;
                try {
                    if (b.this.G == null) {
                        b.this.b(10);
                        return;
                    }
                    if (bitmap == null) {
                        b.this.b(8);
                        return;
                    }
                    final Context context = b.this.G.getContext();
                    float width = (float) ((bitmap.getWidth() * 1.0d) / bitmap.getHeight());
                    int i6 = b.this.M;
                    int i7 = b.this.N > 0 ? b.this.N : (int) (i6 / width);
                    final ImageView imageView2 = ((com.beizi.ad.v2.a.b) b.this).B ? imageView : new ImageView(context);
                    if (imageView2 != null && (layoutParams = imageView2.getLayoutParams()) != null) {
                        layoutParams.width = i6;
                        layoutParams.height = i7;
                        imageView2.setLayoutParams(layoutParams);
                    }
                    float abs = Math.abs(((float) ((i6 * 1.0d) / i7)) - width);
                    if (abs > 0.1f) {
                        com.beizi.ad.lance.a.c.b().e().execute(new Runnable() { // from class: com.beizi.ad.v2.g.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                try {
                                    Context context2 = context;
                                    if (context2 == null || (bitmap2 = bitmap) == null) {
                                        return;
                                    }
                                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(j.a(context2, bitmap2, 20.0f));
                                    if (((com.beizi.ad.v2.a.b) b.this).F != null) {
                                        ((com.beizi.ad.v2.a.b) b.this).F.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.4.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                ImageView imageView3;
                                                try {
                                                    BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                                                    if (bitmapDrawable2 == null || (imageView3 = imageView2) == null) {
                                                        return;
                                                    }
                                                    imageView3.setBackground(bitmapDrawable2);
                                                } catch (Throwable th) {
                                                    th.printStackTrace();
                                                }
                                            }
                                        });
                                    }
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                            }
                        });
                    } else if (abs > 0.07d) {
                        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else {
                        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                    imageView2.setImageBitmap(bitmap);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i6, i7);
                    if (!((com.beizi.ad.v2.a.b) b.this).B) {
                        b.this.G.addView(imageView2, layoutParams2);
                        b.this.A();
                        b.this.B();
                        b.this.C();
                        return;
                    }
                    imageView2.setLayoutParams(layoutParams2);
                    if (((com.beizi.ad.v2.a.b) b.this).E) {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView2, "alpha", 0.0f, 1.0f);
                        ofFloat.setDuration(200L);
                        ofFloat.start();
                    }
                    if (((com.beizi.ad.v2.a.b) b.this).C) {
                        b.this.A();
                        b.this.B();
                    }
                    if (b.this.P != null) {
                        b.this.P.a();
                    }
                } catch (Exception e8) {
                    e8.printStackTrace();
                    b.this.b(8);
                }
            }

            @Override // com.beizi.ad.internal.h.i.a
            public void a() {
                if (((com.beizi.ad.v2.a.b) b.this).B) {
                    try {
                        ImageView imageView2 = imageView;
                        if (imageView2 != null) {
                            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView.setImageResource(R.drawable.beizi_bg_place_holder);
                            if (((com.beizi.ad.v2.a.b) b.this).E) {
                                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 1.0f);
                                ofFloat.setDuration(200L);
                                ofFloat.start();
                            }
                        }
                        if (((com.beizi.ad.v2.a.b) b.this).C) {
                            b.this.A();
                            b.this.B();
                        }
                        if (b.this.P != null) {
                            b.this.P.a();
                            return;
                        }
                        return;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        return;
                    }
                }
                b.this.b(8);
            }
        });
    }

    private void y() {
        ViewGroup viewGroup = this.G;
        if (viewGroup == null) {
            b(10);
            return;
        }
        WebView webView = new WebView(viewGroup.getContext());
        this.O = webView;
        x.a(webView);
        if (this.B) {
            this.G.addView(this.O);
            if (!this.C) {
                A();
                B();
            }
        }
        this.O.setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.v2.g.b.5
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                try {
                    if (b.this.G == null) {
                        b.this.b(10);
                        return;
                    }
                    if (b.this.O == null) {
                        b.this.b(9);
                        return;
                    }
                    if (((com.beizi.ad.v2.a.b) b.this).B) {
                        if (((com.beizi.ad.v2.a.b) b.this).C) {
                            b.this.A();
                            b.this.B();
                        }
                        if (b.this.P != null) {
                            b.this.P.a();
                            return;
                        }
                        return;
                    }
                    b.this.G.addView(b.this.O);
                    b.this.A();
                    b.this.B();
                    b.this.C();
                } catch (Exception e6) {
                    e6.printStackTrace();
                    b.this.b(2);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                b.this.b(2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                b.this.b(2);
            }
        });
        this.O.loadDataWithBaseURL(null, this.K, "text/html", "UTF-8", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        View view = this.H;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.g.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.c();
            }
        });
    }

    public void b(View.OnTouchListener onTouchListener) {
        WebView webView = this.O;
        if (webView != null) {
            webView.setOnTouchListener(onTouchListener);
            return;
        }
        ViewGroup viewGroup = this.G;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(onTouchListener);
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void c() {
        try {
            c cVar = this.f13086c;
            if (cVar != null) {
                cVar.d(false);
            }
            com.beizi.ad.a aVar = this.I;
            if (aVar != null) {
                aVar.c();
            }
            CountDownTimer countDownTimer = this.J;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void u() {
        CountDownTimer countDownTimer = this.J;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (this.f13097n <= 0) {
            this.f13097n = 5;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(this.f13097n * 1000, 200L) { // from class: com.beizi.ad.v2.g.b.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (((com.beizi.ad.v2.a.b) b.this).f13086c != null) {
                    ((com.beizi.ad.v2.a.b) b.this).f13086c.d(false);
                }
                if (b.this.I != null) {
                    b.this.I.c();
                }
                if (b.this.J != null) {
                    b.this.J.cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j6) {
                if (b.this.I != null) {
                    b.this.I.a(j6);
                }
            }
        };
        this.J = countDownTimer2;
        countDownTimer2.start();
    }

    public void v() {
        try {
            this.f13086c.a(true);
            this.f13086c.b(f());
            this.f13086c.a(this.G, "100", "200", "105", "206", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.f13092i, this.f13095l);
            this.f13092i = true;
            com.beizi.ad.a aVar = this.I;
            if (aVar == null) {
                return;
            }
            aVar.e();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(com.beizi.ad.a aVar) {
        this.I = aVar;
    }

    public void a(int i6, int i7) {
        this.M = i6;
        this.N = i7;
    }

    public void a(View view) {
        ViewGroup viewGroup = this.G;
        if (viewGroup == null) {
            b(11);
        } else {
            this.H = view;
            viewGroup.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.z();
                        b.this.u();
                        if (((com.beizi.ad.v2.a.b) b.this).f13086c != null) {
                            ((com.beizi.ad.v2.a.b) b.this).f13086c.a(b.this.G, ((com.beizi.ad.v2.a.b) b.this).f13095l);
                        }
                        if (((com.beizi.ad.v2.a.b) b.this).f13103t) {
                            ((com.beizi.ad.v2.a.b) b.this).f13104u = true;
                            com.beizi.ad.internal.a.a.a().a(((com.beizi.ad.v2.a.b) b.this).f13101r);
                        }
                        if (b.this.I != null) {
                            b.this.I.b();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        b.this.b(11);
                    }
                }
            });
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void b(final int i6) {
        if (this.I == null || this.f13093j || this.f13090g) {
            return;
        }
        this.f13093j = true;
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.10
                @Override // java.lang.Runnable
                public void run() {
                    b.this.I.a(i6);
                }
            });
        }
    }

    public void a(com.beizi.ad.v2.b.a aVar) {
        this.P = aVar;
        w();
    }

    public void a(View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            return;
        }
        WebView webView = this.O;
        if (webView != null) {
            webView.setOnTouchListener(onTouchListener);
            return;
        }
        ViewGroup viewGroup = this.G;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(onTouchListener);
        }
    }

    public void a(d dVar, int i6) {
        try {
            c cVar = this.f13086c;
            if (cVar != null && this.G != null) {
                cVar.a(true);
                this.f13086c.b(f());
                this.f13086c.a(this.G, dVar, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.f13092i, this.f13095l, i6);
                this.f13092i = true;
                com.beizi.ad.a aVar = this.I;
                if (aVar == null) {
                    return;
                }
                aVar.e();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void a(c cVar) {
        this.f13097n = cVar.s();
        this.K = cVar.S();
        this.L = cVar.T();
        b(cVar.e());
        c(cVar.f());
        a(cVar.P());
        if (this.B) {
            this.F.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.11
                @Override // java.lang.Runnable
                public void run() {
                    b.this.C();
                }
            });
            D();
        } else {
            Handler handler = this.F;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.w();
                    }
                });
            }
        }
    }
}
