package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10545a = "LoadRemoteDex";

    /* renamed from: i, reason: collision with root package name */
    private static aa f10546i;

    /* renamed from: b, reason: collision with root package name */
    private IXAdContainerFactory f10547b;

    /* renamed from: c, reason: collision with root package name */
    private bp f10548c;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f10551f;

    /* renamed from: g, reason: collision with root package name */
    private Context f10552g;

    /* renamed from: k, reason: collision with root package name */
    private boolean f10555k;

    /* renamed from: d, reason: collision with root package name */
    private int f10549d = 5000;

    /* renamed from: e, reason: collision with root package name */
    private Handler f10550e = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    private bu f10553h = bu.a();

    /* renamed from: j, reason: collision with root package name */
    private AtomicBoolean f10554j = new AtomicBoolean(false);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f10556a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f10557b = 2;

        void onFailure();

        void onSuccess();
    }

    private void f() {
        this.f10554j.set(true);
        if (ao.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (aa.class) {
            try {
                bp bpVar = new bp(Class.forName(z.aO, true, getClass().getClassLoader()), this.f10552g);
                this.f10548c = bpVar;
                this.f10547b = bpVar.a();
                k();
            } catch (Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f10551f = new ab(this);
        j();
        if (h.f11035a == null) {
            synchronized (ca.class) {
                try {
                    if (h.f11035a == null) {
                        h.f11035a = new ca(this.f10552g);
                    }
                } finally {
                }
            }
        }
        if (this.f10547b != null) {
            k();
            return;
        }
        if (h.f11035a == null) {
            this.f10553h.a(f10545a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
            return;
        }
        this.f10553h.a(f10545a, "start load apk");
        try {
            h.f11035a.a(new ac(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void i() {
        Runnable runnable = this.f10551f;
        if (runnable != null) {
            this.f10550e.removeCallbacks(runnable);
        }
        this.f10551f = null;
    }

    private void j() {
        Runnable runnable = this.f10551f;
        if (runnable != null) {
            this.f10550e.postDelayed(runnable, this.f10549d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f10554j.set(false);
        bn.a(this.f10552g);
        i();
        s.a().a(1);
        co.a(this.f10552g).b();
        co.a(this.f10552g).a();
    }

    public Context b() {
        return this.f10552g;
    }

    public IXAdContainerFactory c() {
        if (this.f10552g == null) {
            return null;
        }
        if (this.f10547b == null && !this.f10554j.get()) {
            f();
        }
        return this.f10547b;
    }

    public String d() {
        if (this.f10547b == null) {
            return "";
        }
        return "_" + this.f10547b.getRemoteVersion();
    }

    public boolean e() {
        return this.f10555k;
    }

    private aa() {
    }

    public static aa a() {
        if (f10546i == null) {
            synchronized (aa.class) {
                try {
                    if (f10546i == null) {
                        f10546i = new aa();
                    }
                } finally {
                }
            }
        }
        return f10546i;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.f10553h.c(f10545a, "init Context is null,error");
            return;
        }
        this.f10552g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        s.a().a(aVar);
        if (this.f10547b != null) {
            k();
        } else {
            if (this.f10554j.get()) {
                return;
            }
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.f10553h.a(f10545a, "加载dex失败原因=" + str);
        this.f10554j.set(false);
        i();
        s.a().a(2);
    }
}
