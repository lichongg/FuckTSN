package cn.jiguang.bv;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.j;
import cn.jiguang.internal.JNAction;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f2581a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final Context f2582b;

    /* renamed from: c, reason: collision with root package name */
    private final cn.jiguang.bv.b f2583c;

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f2592a = new c();
    }

    private c() {
        Context a6 = cn.jiguang.bz.d.a();
        this.f2582b = a6;
        this.f2583c = new cn.jiguang.bv.b(a6);
    }

    public static void b() {
        cn.jiguang.bb.f.c("JSM", "force d...");
        c a6 = a();
        Context a7 = cn.jiguang.bz.d.a();
        String str = cn.jiguang.bv.a.f2579g;
        a6.a(str, cn.jiguang.bv.a.a(a7, str), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("report_type", 2);
            jSONObject.put("local_v", e.c());
            cn.jiguang.be.b.a(cn.jiguang.bz.d.a(), jSONObject, "xstats");
        } catch (Exception unused) {
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2589a;

        /* renamed from: b, reason: collision with root package name */
        public String f2590b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f2591c;

        public a(boolean z5, String str, byte[] bArr) {
            this.f2589a = z5;
            this.f2590b = str;
            this.f2591c = bArr;
        }
    }

    public static c a() {
        return b.f2592a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("report_type", 1);
            jSONObject.put("local_v", e.c());
            if (str != null && !str.trim().isEmpty()) {
                jSONObject.put("download_v", new JSONObject(str).optString("v"));
            }
            cn.jiguang.be.b.a(cn.jiguang.bz.d.a(), jSONObject, "xstats");
        } catch (Exception unused) {
        }
    }

    private void a(final String str, final String str2, final boolean z5) {
        final cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        cn.jiguang.by.d.a("NORMAL_TASK", new Runnable() { // from class: cn.jiguang.bv.c.1
            @Override // java.lang.Runnable
            public void run() {
                String sb;
                cn.jiguang.bw.a aVar;
                int i6;
                a6.h(3069);
                try {
                    String h6 = d.h();
                    if (TextUtils.isEmpty(h6)) {
                        aVar = a6;
                        i6 = 3073;
                    } else {
                        String a7 = c.this.f2583c.a(h6);
                        if (!TextUtils.isEmpty(a7)) {
                            a a8 = c.this.f2583c.a(h6, str, a7);
                            if (a8.f2589a) {
                                a6.h(3071);
                                d.f();
                                c.e(a8.f2590b);
                                cn.jiguang.bb.f.c("JSM", "d ok, load=" + z5);
                                if (!z5) {
                                    return;
                                }
                                if (c.a().b(str2)) {
                                    cn.jiguang.bb.f.c("JSM", "load ok");
                                    a6.h(3053);
                                    if (d.e()) {
                                        c.this.c();
                                        d.g();
                                        return;
                                    }
                                    return;
                                }
                                a6.h(3054);
                                sb = "load f after d";
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("d f");
                                sb2.append(z5 ? ", no load" : "");
                                sb = sb2.toString();
                            }
                            cn.jiguang.bb.f.l("JSM", sb);
                            return;
                        }
                        cn.jiguang.bb.f.i("JSM", "no md5, skip d");
                        aVar = a6;
                        i6 = 3074;
                    }
                    aVar.h(i6);
                } catch (Exception e6) {
                    a6.h(3076);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("err d");
                    sb3.append(z5 ? " load" : "");
                    sb3.append(": ");
                    sb3.append(e6.getMessage());
                    cn.jiguang.bb.f.l("JSM", sb3.toString());
                }
            }
        });
    }

    private boolean d(String str) {
        String str2;
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        String b6 = d.b();
        StringBuilder sb = new StringBuilder();
        sb.append("c m: ");
        String str3 = "null";
        if (b6 == null) {
            str2 = "null";
        } else {
            str2 = b6;
        }
        sb.append(str2);
        cn.jiguang.bb.f.c("JSM", sb.toString());
        if (TextUtils.isEmpty(b6)) {
            a6.h(3068);
            cn.jiguang.bb.f.c("JSM", "no c m, no verify");
            return false;
        }
        String g6 = j.g(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("a m: ");
        if (g6 != null) {
            str3 = g6;
        }
        sb2.append(str3);
        cn.jiguang.bb.f.c("JSM", sb2.toString());
        return TextUtils.equals(b6, g6);
    }

    public boolean b(String str) {
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        AtomicBoolean atomicBoolean = f2581a;
        if (atomicBoolean.get()) {
            cn.jiguang.bb.f.c("JSM", "loaded, skip");
            return true;
        }
        try {
            JNAction.loadPath(str);
            boolean b6 = e.b();
            atomicBoolean.set(true);
            if (b6) {
                cn.jiguang.bb.f.c("JSM", "load complete");
            }
            return b6;
        } catch (Exception unused) {
            a6.h(3059);
            f2581a.set(false);
            return false;
        }
    }

    public boolean a(String str) {
        int i6;
        cn.jiguang.bw.a a6 = cn.jiguang.bw.a.a();
        if (f2581a.get()) {
            cn.jiguang.bb.f.c("JSM", "loaded, skip");
            return true;
        }
        String a7 = cn.jiguang.bv.a.a(cn.jiguang.bz.d.a(), str);
        if (j.f(a7)) {
            a6.h(3065);
            if (d(a7)) {
                a6.h(3067);
                cn.jiguang.bb.f.c("JSM", "local ok, load");
                boolean b6 = b(a7);
                if (!b6) {
                    a6.h(3058);
                    return b6;
                }
                a6.h(3057);
                if (d.e()) {
                    c();
                    d.g();
                }
                return b6;
            }
            i6 = 3066;
        } else {
            i6 = 3064;
        }
        a6.h(Integer.valueOf(i6));
        a(str, a7, true);
        return false;
    }
}
