package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k4 {

    /* renamed from: a, reason: collision with root package name */
    private volatile b f6681a = new b(0);

    /* renamed from: b, reason: collision with root package name */
    private g6 f6682b = new g6("HttpsDecisionUtil");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static k4 f6683a = new k4();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f6684a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f6685b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f6686c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6687d;

        private b() {
            this.f6684a = 0;
            this.f6685b = true;
            this.f6686c = true;
            this.f6687d = false;
        }

        public final void a(Context context) {
            if (context != null && this.f6684a <= 0) {
                this.f6684a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z5) {
            this.f6685b = z5;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean c() {
            /*
                r5 = this;
                boolean r0 = r5.f6687d
                r1 = 1
                if (r0 != 0) goto L2f
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 28
                r3 = 0
                if (r0 < r2) goto Le
                r0 = 1
                goto Lf
            Le:
                r0 = 0
            Lf:
                boolean r4 = r5.f6685b
                if (r4 == 0) goto L23
                int r4 = r5.f6684a
                if (r4 > 0) goto L19
                r4 = 28
            L19:
                if (r4 < r2) goto L1d
                r2 = 1
                goto L1e
            L1d:
                r2 = 0
            L1e:
                if (r2 == 0) goto L21
                goto L23
            L21:
                r2 = 0
                goto L24
            L23:
                r2 = 1
            L24:
                if (r0 == 0) goto L2a
                if (r2 == 0) goto L2a
                r0 = 1
                goto L2b
            L2a:
                r0 = 0
            L2b:
                if (r0 == 0) goto L2e
                goto L2f
            L2e:
                return r3
            L2f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.k4.b.c():boolean");
        }

        /* synthetic */ b(byte b6) {
            this();
        }
    }

    public static void f(Context context) {
        g(context, true);
    }

    private static boolean i() {
        return false;
    }

    public static k4 a() {
        return a.f6683a;
    }

    private static void g(Context context, boolean z5) {
        SharedPreferences.Editor c6 = g6.c(context, "open_common");
        g6.k(c6, "a3", z5);
        g6.f(c6);
    }

    public final void c(Context context) {
        if (this.f6681a == null) {
            this.f6681a = new b((byte) 0);
        }
        this.f6681a.b(g6.l(context, "open_common", "a3", true));
        this.f6681a.a(context);
        g5.a(context).b();
    }

    final void d(Context context, boolean z5) {
        if (this.f6681a == null) {
            this.f6681a = new b((byte) 0);
        }
        g(context, z5);
        this.f6681a.b(z5);
    }

    public final boolean h() {
        if (this.f6681a == null) {
            this.f6681a = new b((byte) 0);
        }
        return this.f6681a.c();
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith(master.flame.danmaku.danmaku.parser.b.f50155b)) {
            try {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.scheme(master.flame.danmaku.danmaku.parser.b.f50155b);
                return buildUpon.build().toString();
            } catch (Throwable unused) {
                return str;
            }
        }
        return str;
    }

    public final boolean e(boolean z5) {
        if (i()) {
            return false;
        }
        if (!z5 && !h()) {
            return false;
        }
        return true;
    }
}
