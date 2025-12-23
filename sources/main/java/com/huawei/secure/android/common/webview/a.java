package com.huawei.secure.android.common.webview;

import android.webkit.WebView;
import com.huawei.secure.android.common.util.k0;
import com.huawei.secure.android.common.util.l0;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f35308c = "SafeGetUrl";

    /* renamed from: d, reason: collision with root package name */
    private static final long f35309d = 200;

    /* renamed from: a, reason: collision with root package name */
    private String f35310a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f35311b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.secure.android.common.webview.a$a, reason: collision with other inner class name */
    class RunnableC0548a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f35312a;

        RunnableC0548a(CountDownLatch countDownLatch) {
            this.f35312a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.d(aVar.f35311b.getUrl());
            this.f35312a.countDown();
        }
    }

    public a() {
    }

    public a(WebView webView) {
        this.f35311b = webView;
    }

    public String b() {
        if (this.f35311b == null) {
            return "";
        }
        if (k0.a()) {
            return this.f35311b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        l0.a(new RunnableC0548a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e6) {
            e6.getMessage();
        }
        return this.f35310a;
    }

    public WebView c() {
        return this.f35311b;
    }

    public void d(String str) {
        this.f35310a = str;
    }

    public void e(WebView webView) {
        this.f35311b = webView;
    }
}
