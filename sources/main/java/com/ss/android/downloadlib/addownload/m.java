package com.ss.android.downloadlib.addownload;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.j.j.up.b;
import com.ss.android.socialbase.downloader.ae.cw;
import com.stub.StubApp;
import org.json.JSONObject;
import w2.p;
import w2.s;
import w2.u;
import w2.v;
import w2.w;
import w2.x;
import w2.y;

/* loaded from: D:\Downloads\app\classes6.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final JSONObject f37891a = new JSONObject();

    /* renamed from: b, reason: collision with root package name */
    private static Context f37892b;

    /* renamed from: c, reason: collision with root package name */
    private static w2.a f37893c;

    /* renamed from: d, reason: collision with root package name */
    private static w2.e f37894d;

    /* renamed from: e, reason: collision with root package name */
    private static w f37895e;

    /* renamed from: f, reason: collision with root package name */
    private static w2.g f37896f;

    /* renamed from: g, reason: collision with root package name */
    private static w2.n f37897g;

    /* renamed from: h, reason: collision with root package name */
    private static u f37898h;

    /* renamed from: i, reason: collision with root package name */
    private static com.ss.android.j.j.up.b f37899i;

    /* renamed from: j, reason: collision with root package name */
    private static y f37900j;

    /* renamed from: k, reason: collision with root package name */
    private static x2.e f37901k;

    /* renamed from: l, reason: collision with root package name */
    private static p f37902l;

    /* renamed from: m, reason: collision with root package name */
    private static s f37903m;

    /* renamed from: n, reason: collision with root package name */
    private static v f37904n;

    /* renamed from: o, reason: collision with root package name */
    private static w2.j f37905o;

    /* renamed from: p, reason: collision with root package name */
    private static x f37906p;

    /* renamed from: q, reason: collision with root package name */
    private static w2.b f37907q;

    /* renamed from: r, reason: collision with root package name */
    private static w2.c f37908r;

    /* renamed from: s, reason: collision with root package name */
    private static w2.m f37909s;

    /* renamed from: t, reason: collision with root package name */
    private static v2.a f37910t;

    /* renamed from: u, reason: collision with root package name */
    private static w2.k f37911u;

    /* renamed from: v, reason: collision with root package name */
    private static w2.f f37912v;

    /* renamed from: w, reason: collision with root package name */
    private static w2.o f37913w;

    static class a implements w2.e {
        a() {
        }
    }

    static class b implements x2.e {
        b() {
        }

        @Override // x2.e
        public void j(cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, int i6) {
        }
    }

    static class c implements w2.m {
        c() {
        }
    }

    static class d implements v2.a {
        d() {
        }

        @Override // v2.a
        public void j(Throwable th, String str) {
        }
    }

    static class e implements w2.f {
        e() {
        }
    }

    public static w2.c A() {
        return f37908r;
    }

    public static w2.g B() {
        return f37896f;
    }

    @NonNull
    public static w2.f C() {
        if (f37912v == null) {
            f37912v = new e();
        }
        return f37912v;
    }

    @NonNull
    public static w2.m D() {
        if (f37909s == null) {
            f37909s = new c();
        }
        return f37909s;
    }

    @NonNull
    public static w2.n E() {
        if (f37897g == null) {
            f37897g = new com.ss.android.j.j.j.b();
        }
        return f37897g;
    }

    @Nullable
    public static y G() {
        return f37900j;
    }

    @NonNull
    public static w2.k H() {
        return f37911u;
    }

    public static String I() {
        return "1.7.0";
    }

    public static boolean J() {
        return (f37893c == null || f37896f == null || f37898h == null || f37900j == null || f37911u == null) ? false : true;
    }

    @NonNull
    public static w2.e K() {
        if (f37894d == null) {
            f37894d = new a();
        }
        return f37894d;
    }

    public static void L(Context context) {
        if (f37892b != null || context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            return;
        }
        f37892b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static v a() {
        return f37904n;
    }

    public static s b() {
        return f37903m;
    }

    public static p c() {
        return f37902l;
    }

    @NonNull
    public static w d() {
        if (f37895e == null) {
            f37895e = new com.ss.android.j.j.j.a();
        }
        return f37895e;
    }

    public static w2.o e() {
        return f37913w;
    }

    @NonNull
    public static JSONObject f() {
        u uVar = f37898h;
        return (uVar == null || uVar.j() == null) ? f37891a : f37898h.j();
    }

    public static w2.j g() {
        return f37905o;
    }

    public static Context getContext() {
        Context context = f37892b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static w2.a h() {
        return f37893c;
    }

    public static void i(Context context) {
        if (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f37892b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static void j(@NonNull com.ss.android.j.j.up.b bVar) {
        f37899i = bVar;
    }

    public static void l(v2.a aVar) {
        f37910t = aVar;
    }

    public static void m(@NonNull w2.a aVar) {
        f37893c = aVar;
    }

    public static void n(@NonNull w2.g gVar) {
        f37896f = gVar;
    }

    public static void o(w2.k kVar) {
        f37911u = kVar;
    }

    public static void p(@NonNull w2.n nVar) {
        f37897g = nVar;
    }

    public static void q(w2.o oVar) {
        f37913w = oVar;
    }

    public static void r(@NonNull u uVar) {
        f37898h = uVar;
    }

    public static void s(@NonNull w wVar) {
        f37895e = wVar;
    }

    public static void t(@NonNull y yVar) {
        f37900j = yVar;
    }

    @Nullable
    public static w2.b v() {
        return f37907q;
    }

    @NonNull
    public static v2.a w() {
        if (f37910t == null) {
            f37910t = new d();
        }
        return f37910t;
    }

    public static x2.e x() {
        if (f37901k == null) {
            f37901k = new b();
        }
        return f37901k;
    }

    public static x y() {
        return f37906p;
    }

    @NonNull
    public static com.ss.android.j.j.up.b z() {
        if (f37899i == null) {
            f37899i = new b.a().d();
        }
        return f37899i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r0 > 29) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r1 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        return getContext().getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String F() {
        /*
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L52
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch: java.lang.Throwable -> L52
            int r0 = r0.targetSdkVersion     // Catch: java.lang.Throwable -> L52
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L52
            r2 = 29
            if (r1 < r2) goto L29
            if (r0 != r2) goto L18
            boolean r1 = com.bumptech.glide.load.model.stream.g.a()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L1a
        L18:
            if (r0 <= r2) goto L29
        L1a:
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L52
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L52
            return r0
        L29:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r0.<init>()     // Catch: java.lang.Throwable -> L52
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = r1.getPath()     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            org.json.JSONObject r1 = f()     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = "default_save_dir_name"
            java.lang.String r3 = "ByteDownload"
            java.lang.String r1 = r1.optString(r2, r3)     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L52
            return r0
        L52:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.m.F():java.lang.String");
    }

    public static void k(String str) {
        com.ss.android.socialbase.appdownloader.f.L().z(str);
    }

    public static void u(x2.d dVar) {
        com.ss.android.socialbase.appdownloader.f.L().C(dVar);
    }
}
