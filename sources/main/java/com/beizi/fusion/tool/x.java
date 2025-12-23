package com.beizi.fusion.tool;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.bn;
import com.beizi.fusion.model.RequestInfo;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static x f13776a;

    /* renamed from: b, reason: collision with root package name */
    private String f13777b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.fusion.tool.x$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final j f13778a;

        /* renamed from: b, reason: collision with root package name */
        private int f13779b;

        /* synthetic */ a(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        private a(final Context context) {
            this.f13779b = 100100;
            this.f13778a = new j(context) { // from class: com.beizi.fusion.tool.x.a.1
                @Override // com.beizi.fusion.tool.j
                public void a(Message message) {
                    Context a6;
                    if (message == null) {
                        return;
                    }
                    try {
                        if (message.what == a.this.f13779b && (a6 = a()) != null) {
                            if (System.currentTimeMillis() - an.b(context, "updateUserAgentTime") < bn.f10749e) {
                                return;
                            }
                            WebView webView = new WebView(a6);
                            WebView.setWebContentsDebuggingEnabled(false);
                            webView.getSettings().setSavePassword(false);
                            String userAgentString = webView.getSettings().getUserAgentString();
                            RequestInfo.getInstance(a6).updateUserAgent(userAgentString);
                            com.beizi.ad.f.b(userAgentString);
                            an.a(a6, "userAgent", userAgentString);
                            an.a(a6, "updateUserAgentTime", Long.valueOf(System.currentTimeMillis()));
                        }
                    } catch (Exception unused) {
                    }
                }
            };
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13778a == null) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = this.f13779b;
            this.f13778a.sendMessage(obtain);
        }
    }

    public static synchronized x a() {
        x xVar;
        synchronized (x.class) {
            try {
                if (f13776a == null) {
                    synchronized (x.class) {
                        f13776a = new x();
                    }
                }
                xVar = f13776a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    public void b(Context context) {
        if (TextUtils.isEmpty(this.f13777b)) {
            Executors.newSingleThreadScheduledExecutor().schedule(new a(context, null), 15000L, TimeUnit.MILLISECONDS);
        }
    }

    public String a(Context context) {
        if (TextUtils.isEmpty(this.f13777b)) {
            this.f13777b = an.a(context, "userAgent");
        }
        return this.f13777b;
    }

    public void a(String str) {
        this.f13777b = str;
    }
}
