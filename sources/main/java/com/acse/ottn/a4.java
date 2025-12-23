package com.acse.ottn;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.acse.ottn.widget.CustomWebView;
import java.io.ObjectStreamException;
import java.lang.reflect.Method;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a4 {

    /* renamed from: p, reason: collision with root package name */
    public static a4 f4063p;

    /* renamed from: a, reason: collision with root package name */
    public ImageView f4064a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f4065b;

    /* renamed from: c, reason: collision with root package name */
    public CustomWebView f4066c;

    /* renamed from: e, reason: collision with root package name */
    public String f4068e;

    /* renamed from: f, reason: collision with root package name */
    public String f4069f;

    /* renamed from: g, reason: collision with root package name */
    public String f4070g;

    /* renamed from: h, reason: collision with root package name */
    public String f4071h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f4072i;

    /* renamed from: j, reason: collision with root package name */
    public g f4073j;

    /* renamed from: k, reason: collision with root package name */
    public h f4074k;

    /* renamed from: l, reason: collision with root package name */
    public Activity f4075l;

    /* renamed from: m, reason: collision with root package name */
    public String f4076m;

    /* renamed from: n, reason: collision with root package name */
    public ValueAnimator f4077n;

    /* renamed from: d, reason: collision with root package name */
    public String[] f4067d = {".", "..", "..."};

    /* renamed from: o, reason: collision with root package name */
    public Handler f4078o = new e();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4081a;

        public c(String str) {
            this.f4081a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a4.this.f4076m = "";
            try {
                JSONObject jSONObject = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f4081a).build()).execute().body().string());
                a4.this.f4076m = jSONObject.getString("content");
                try {
                    String string = jSONObject.getString("origin_url");
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    a4.this.f4070g = string;
                } catch (Throwable unused) {
                }
            } catch (Exception e6) {
                a4.this.f4076m = "";
                a4.this.e();
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a4.this.f4072i.setText(a4.this.f4067d[((Integer) valueAnimator.getAnimatedValue()).intValue() % a4.this.f4067d.length]);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i6 = message.what;
            if (i6 == 10010) {
                ValueAnimator valueAnimator = a4.this.f4077n;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    a4.this.f4077n = null;
                }
                if (n.c().f4869w.equals(a4.this.f4068e)) {
                    a4.this.f4064a.setImageResource(R.mipmap.jd_one);
                } else {
                    a4.this.f4064a.setImageResource(R.mipmap.loading_one);
                }
                a4.this.f4072i.setText("");
                if (!"1".equals(a4.this.f4071h) && !"2".equals(a4.this.f4071h) && !"3".equals(a4.this.f4071h)) {
                    a4.this.f4065b.setText("生成专属优惠券...ok");
                } else {
                    a4.this.f4065b.setText("生成专属礼金...ok");
                }
                a4.this.a(10011, 2000);
                return;
            }
            if (i6 == 10011) {
                a4.this.b();
                if (n.c().f4869w.equals(a4.this.f4068e)) {
                    a4.this.f4064a.setImageResource(R.mipmap.jd_two);
                } else {
                    a4.this.f4064a.setImageResource(R.mipmap.loading_two);
                }
                if (!"1".equals(a4.this.f4071h) && !"2".equals(a4.this.f4071h) && !"3".equals(a4.this.f4071h)) {
                    a4.this.f4065b.setText("复制优惠券口令");
                } else {
                    a4.this.f4065b.setText("复制礼金口令");
                }
                a4.this.f4072i.setText("...");
                a4.this.a(10012, 2000);
                return;
            }
            if (i6 == 10012) {
                ValueAnimator valueAnimator2 = a4.this.f4077n;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                    a4.this.f4077n = null;
                }
                a4.this.e();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g extends WebChromeClient {
        public g() {
        }

        public /* synthetic */ g(a4 a4Var, a aVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            super.onProgressChanged(webView, i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface h {
        void a(String str, String str2);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f extends FrameLayout {
        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        public f(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(android.R.color.black));
        }
    }

    public void c() {
        try {
            l2.b().a("loading_comeback");
            this.f4078o.removeMessages(10010);
            this.f4078o.removeMessages(10011);
            this.f4078o.removeMessages(10012);
        } catch (Throwable th) {
            c2.a("SeedingLoadingActivity", "onBackPressed error e = " + th.getMessage());
        }
    }

    public final Object d() throws ObjectStreamException {
        return f4063p;
    }

    public final void e() {
        c2.a("SeedingLoadingActivity", "write code = " + this.f4076m);
        h hVar = this.f4074k;
        if (hVar != null) {
            hVar.a(this.f4076m, this.f4070g);
        }
    }

    public final void b(String str) {
        new Thread(new c(str)).start();
    }

    public static a4 a() {
        if (f4063p == null) {
            synchronized (a4.class) {
                try {
                    if (f4063p == null) {
                        f4063p = new a4();
                    }
                } finally {
                }
            }
        }
        return f4063p;
    }

    public final void b() {
        if (this.f4077n == null) {
            ValueAnimator duration = ValueAnimator.ofInt(0, 3).setDuration(1000L);
            this.f4077n = duration;
            duration.setRepeatCount(-1);
            this.f4077n.addUpdateListener(new d());
        }
        this.f4077n.start();
    }

    public void a(Activity activity, h hVar) {
        this.f4075l = activity;
        this.f4074k = hVar;
        this.f4076m = "";
        this.f4064a = (ImageView) activity.findViewById(R.id.loading_icon);
        if (n.c().f4869w.equals(this.f4068e)) {
            this.f4064a.setImageResource(R.mipmap.jd_one);
        } else {
            this.f4064a.setImageResource(R.mipmap.loading_one);
        }
        this.f4065b = (TextView) activity.findViewById(R.id.tv_loading_text);
        this.f4072i = (TextView) activity.findViewById(R.id.tv_loading_animation);
        activity.findViewById(R.id.re_loading).setOnClickListener(new a());
        String stringExtra = activity.getIntent().getStringExtra("link");
        this.f4068e = activity.getIntent().getStringExtra("packagename");
        this.f4069f = activity.getIntent().getStringExtra("tkl_turn_url");
        this.f4070g = activity.getIntent().getStringExtra("origin_url");
        this.f4071h = activity.getIntent().getStringExtra("pic_type");
        if (!TextUtils.isEmpty(this.f4069f)) {
            try {
                b(this.f4069f);
            } catch (Exception unused) {
            }
        }
        if (!"1".equals(this.f4071h) && !"2".equals(this.f4071h) && !"3".equals(this.f4071h)) {
            this.f4065b.setText("生成专属优惠券");
        } else {
            this.f4065b.setText("生成专属礼金");
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            a(stringExtra);
        } else {
            activity.finish();
        }
        a(10010, 2000);
        b();
    }

    public final void a(String str) {
        c2.b("LoadingActivity ", "loadH5Url = " + str);
        try {
            CustomWebView customWebView = (CustomWebView) this.f4075l.findViewById(R.id.dwebView);
            this.f4066c = customWebView;
            WebSettings settings = customWebView.getSettings();
            settings.setTextZoom(100);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setAllowFileAccess(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(true);
            settings.setMixedContentMode(0);
            g gVar = new g(this, null);
            this.f4073j = gVar;
            this.f4066c.setWebChromeClient(gVar);
            Method method = this.f4066c.getSettings().getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(this.f4066c.getSettings(), Boolean.TRUE);
            }
            this.f4066c.setWebViewClient(new b());
            this.f4066c.loadUrl(str);
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    public final void a(int i6, int i7) {
        Message message = new Message();
        message.what = i6;
        this.f4078o.sendMessageDelayed(message, i7);
    }
}
