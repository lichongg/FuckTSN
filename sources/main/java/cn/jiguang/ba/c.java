package cn.jiguang.ba;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f1887a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1888b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f1889c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f1890d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f1891e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f1892f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f1893g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f1894h;

    /* renamed from: i, reason: collision with root package name */
    private static AtomicInteger f1895i = new AtomicInteger(0);

    /* renamed from: cn.jiguang.ba.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f1896a = new c(null);
    }

    private c() {
        f1887a = h();
        f1888b = i();
        f1889c = j();
        f1890d = k();
        f1891e = l();
        f1892f = m();
        f1893g = n();
        f1894h = o();
    }

    public static c a() {
        return a.f1896a;
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static boolean b() {
        return (!f1891e || f1887a || f1888b || f1889c || f1890d || f1892f || f1893g || f1894h) ? false : true;
    }

    public static boolean c() {
        return (!f1887a || f1891e || f1888b || f1889c || f1890d || f1892f || f1893g || f1894h) ? false : true;
    }

    public static boolean d() {
        return f1887a;
    }

    public static boolean e() {
        return (!f1894h || f1891e || f1888b || f1889c || f1890d || f1892f || f1893g || f1887a) ? false : true;
    }

    private static boolean h() {
        int i6;
        boolean z5 = false;
        try {
        } catch (ClassNotFoundException e6) {
            e = e6;
            i6 = 0;
        }
        if ((f1895i.intValue() & 1) != 0) {
            cn.jiguang.bb.f.c("JClientsHelper", "p jpush init");
            return f1887a;
        }
        int i7 = f1895i.addAndGet(1);
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            z5 = true;
        } catch (ClassNotFoundException e7) {
            i6 = i7;
            e = e7;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJpushSDK:" + e.getMessage());
            i7 = i6;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJpushSDK:" + z5 + ", mPluginInitState: " + i7);
            return z5;
        }
        cn.jiguang.bb.f.a("JClientsHelper", "isPluginJpushSDK:" + z5 + ", mPluginInitState: " + i7);
        return z5;
    }

    private static boolean i() {
        int i6;
        boolean z5 = false;
        try {
        } catch (ClassNotFoundException e6) {
            e = e6;
            i6 = 0;
        }
        if ((f1895i.intValue() & 2) != 0) {
            cn.jiguang.bb.f.c("JClientsHelper", "p jmessage init");
            return f1888b;
        }
        int i7 = f1895i.addAndGet(2);
        try {
            Class.forName("cn.jpush.im.android.api.JMessageClient");
            z5 = true;
        } catch (ClassNotFoundException e7) {
            i6 = i7;
            e = e7;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJMessageSDK:" + e.getMessage());
            i7 = i6;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJMessageSDK:" + z5 + ", pluginState: " + i7);
            return z5;
        }
        cn.jiguang.bb.f.a("JClientsHelper", "isPluginJMessageSDK:" + z5 + ", pluginState: " + i7);
        return z5;
    }

    private static boolean j() {
        int i6;
        boolean z5 = false;
        try {
        } catch (ClassNotFoundException e6) {
            e = e6;
            i6 = 0;
        }
        if ((f1895i.intValue() & 4) != 0) {
            cn.jiguang.bb.f.c("JClientsHelper", "p janalytics init");
            return f1889c;
        }
        int i7 = f1895i.addAndGet(4);
        try {
            Class.forName("cn.jiguang.analytics.android.api.JAnalyticsInterface");
            z5 = true;
        } catch (ClassNotFoundException e7) {
            i6 = i7;
            e = e7;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJanalyticsSDK:" + e.getMessage());
            i7 = i6;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJanalyticsSDK:" + z5 + ", pluginState: " + i7);
            return z5;
        }
        cn.jiguang.bb.f.a("JClientsHelper", "isPluginJanalyticsSDK:" + z5 + ", pluginState: " + i7);
        return z5;
    }

    private static boolean k() {
        int i6;
        boolean z5 = false;
        try {
        } catch (ClassNotFoundException e6) {
            e = e6;
            i6 = 0;
        }
        if ((f1895i.intValue() & 8) != 0) {
            cn.jiguang.bb.f.c("JClientsHelper", "p jshare init");
            return f1890d;
        }
        int i7 = f1895i.addAndGet(8);
        try {
            Class.forName("cn.jiguang.share.android.api.JShareInterface");
            z5 = true;
        } catch (ClassNotFoundException e7) {
            i6 = i7;
            e = e7;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJshareSDK:" + e.getMessage());
            i7 = i6;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJshareSDK:" + z5 + ", pluginState: " + i7);
            return z5;
        }
        cn.jiguang.bb.f.a("JClientsHelper", "isPluginJshareSDK:" + z5 + ", pluginState: " + i7);
        return z5;
    }

    private static boolean l() {
        int i6;
        boolean z5 = false;
        try {
        } catch (ClassNotFoundException e6) {
            e = e6;
            i6 = 0;
        }
        if ((f1895i.intValue() & 64) != 0) {
            cn.jiguang.bb.f.c("JClientsHelper", "p jverification init");
            return f1891e;
        }
        int i7 = f1895i.addAndGet(64);
        try {
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            z5 = true;
        } catch (ClassNotFoundException e7) {
            i6 = i7;
            e = e7;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJVerificationSDK:" + e.getMessage());
            i7 = i6;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJVerificationSDK:" + z5 + ", pluginState: " + i7);
            return z5;
        }
        cn.jiguang.bb.f.a("JClientsHelper", "isPluginJVerificationSDK:" + z5 + ", pluginState: " + i7);
        return z5;
    }

    private static boolean m() {
        int i6;
        boolean z5 = false;
        try {
        } catch (ClassNotFoundException e6) {
            e = e6;
            i6 = 0;
        }
        if ((f1895i.intValue() & 128) != 0) {
            cn.jiguang.bb.f.c("JClientsHelper", "p jmlink init");
            return f1892f;
        }
        int i7 = f1895i.addAndGet(128);
        try {
            Class.forName("cn.jiguang.jmlinksdk.core.JMlinkInterfaceImpl");
            z5 = true;
        } catch (ClassNotFoundException e7) {
            i6 = i7;
            e = e7;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJMLinkSDK:" + e.getMessage());
            i7 = i6;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJMLinkSDK:" + z5 + ", pluginState: " + i7);
            return z5;
        }
        cn.jiguang.bb.f.a("JClientsHelper", "isPluginJMLinkSDK:" + z5 + ", pluginState: " + i7);
        return z5;
    }

    private static boolean n() {
        int i6;
        boolean z5 = false;
        try {
        } catch (ClassNotFoundException e6) {
            e = e6;
            i6 = 0;
        }
        if ((f1895i.intValue() & 256) != 0) {
            cn.jiguang.bb.f.c("JClientsHelper", "p junion init");
            return f1893g;
        }
        int i7 = f1895i.addAndGet(256);
        try {
            Class.forName("cn.jiguang.junion.JUnionInterface");
            z5 = true;
        } catch (ClassNotFoundException e7) {
            i6 = i7;
            e = e7;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJUnionSDK:" + e.getMessage());
            i7 = i6;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJUnionSDK:" + z5 + ", pluginState: " + i7);
            return z5;
        }
        cn.jiguang.bb.f.a("JClientsHelper", "isPluginJUnionSDK:" + z5 + ", pluginState: " + i7);
        return z5;
    }

    private static boolean o() {
        int i6;
        boolean z5 = false;
        try {
        } catch (ClassNotFoundException e6) {
            e = e6;
            i6 = 0;
        }
        if ((f1895i.intValue() & 2048) != 0) {
            cn.jiguang.bb.f.c("JClientsHelper", "p joperate init");
            return f1894h;
        }
        int i7 = f1895i.addAndGet(2048);
        try {
            Class.forName("cn.jiguang.joperate.api.JOperateInterface");
            z5 = true;
        } catch (ClassNotFoundException e7) {
            i6 = i7;
            e = e7;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJOperateSDK:" + e.getMessage());
            i7 = i6;
            cn.jiguang.bb.f.a("JClientsHelper", "isPluginJOperateSDK:" + z5 + ", pluginState: " + i7);
            return z5;
        }
        cn.jiguang.bb.f.a("JClientsHelper", "isPluginJOperateSDK:" + z5 + ", pluginState: " + i7);
        return z5;
    }

    public boolean a(Context context) {
        boolean z5 = f1888b || f1887a;
        cn.jiguang.bb.f.c("JClientsHelper", "isNeedKeepTcpConnect:" + z5);
        return z5;
    }

    public boolean f() {
        return f1888b;
    }

    public boolean g() {
        return f1887a;
    }
}
