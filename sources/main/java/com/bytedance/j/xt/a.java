package com.bytedance.j.xt;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.j.xt.ae.xt;
import com.bytedance.j.xt.tl.k;
import com.bytedance.j.xt.tl.l;
import com.bytedance.sdk.component.utils.vl;
import com.stub.StubApp;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f24136a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f24137b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f24138c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f24139d;

    /* renamed from: com.bytedance.j.xt.a$a, reason: collision with other inner class name */
    static class RunnableC0342a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f24140a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f24141b;

        RunnableC0342a(Context context, boolean z5) {
            this.f24140a = context;
            this.f24141b = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.a.a().b(this.f24140a);
            f.a(this.f24140a);
            if (this.f24141b) {
                com.bytedance.j.xt.j.c.a(this.f24140a).b();
            }
        }
    }

    static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.j.j.b f24142a;

        b(com.bytedance.j.j.b bVar) {
            this.f24142a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.j.j.a.c(this.f24142a);
        }
    }

    public interface c {
        String j(String str, byte[] bArr);
    }

    public class d {

        /* renamed from: b, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        private static volatile d f24143b;

        /* renamed from: a, reason: collision with root package name */
        private volatile Context f24144a;

        /* renamed from: com.bytedance.j.xt.a$d$a, reason: collision with other inner class name */
        class RunnableC0343a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONObject f24145a;

            RunnableC0343a(JSONObject jSONObject) {
                this.f24145a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                String g6 = xt.g(com.bytedance.j.xt.e.d().b());
                try {
                    this.f24145a.put("upload_scene", "direct");
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                xt.d(g6, this.f24145a.toString());
            }
        }

        @Nullable
        public String c(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.length() > 0) {
                try {
                    return k.c(l.b(this.f24144a), l.c(), xt.g(com.bytedance.j.xt.e.d().b()), jSONObject, xt.h());
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        public static d b() {
            if (f24143b == null) {
                f24143b = new d(com.bytedance.j.xt.e.i());
            }
            return f24143b;
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return;
            }
            com.bytedance.j.xt.tl.b.a(new RunnableC0343a(jSONObject));
        }

        public void d(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            try {
                String g6 = xt.g(com.bytedance.j.xt.e.d().b());
                String c6 = k.c(l.b(this.f24144a), l.e(), g6, jSONObject, xt.l());
                jSONObject.put("upload_scene", "direct");
                if (xt.d(g6, jSONObject.toString()).a()) {
                    k.h(c6);
                }
            } catch (Throwable unused) {
            }
        }

        private d(@NonNull Context context) {
            this.f24144a = context;
        }
    }

    public class e {

        /* renamed from: a, reason: collision with root package name */
        private final int f24147a;

        /* renamed from: b, reason: collision with root package name */
        private String f24148b;

        /* renamed from: c, reason: collision with root package name */
        private JSONObject f24149c;

        public e(int i6) {
            this.f24147a = i6;
        }

        public boolean a() {
            return this.f24147a == 0;
        }

        public e(int i6, Throwable th) {
            this.f24147a = i6;
            if (th != null) {
                this.f24148b = th.getMessage();
            }
        }

        public e(int i6, String str) {
            this.f24147a = i6;
            this.f24148b = str;
        }

        public e(int i6, JSONObject jSONObject) {
            this.f24147a = i6;
            this.f24149c = jSONObject;
        }
    }

    public final class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f24150a;

        public static void a(Context context) {
            b(context, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new com.bytedance.j.xt.up.b(this.f24150a).c(com.bytedance.j.xt.tl.e.d(this.f24150a));
            } finally {
                try {
                } finally {
                }
            }
        }

        private f(Context context) {
            this.f24150a = context;
        }

        public static void b(Context context, int i6) {
            try {
                if (!com.bytedance.j.xt.e.d().d().equals(context.getPackageName())) {
                    return;
                }
            } catch (Exception unused) {
            }
            com.bytedance.j.xt.up.a.b().postDelayed(new f(context), i6);
        }
    }

    public class g {

        /* renamed from: a, reason: collision with root package name */
        private String f24151a;

        /* renamed from: b, reason: collision with root package name */
        private String f24152b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f24153c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f24154d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f24155e;

        /* renamed from: com.bytedance.j.xt.a$g$a, reason: collision with other inner class name */
        public static class C0344a {

            /* renamed from: a, reason: collision with root package name */
            private String f24156a;

            /* renamed from: b, reason: collision with root package name */
            private String f24157b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f24158c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f24159d;

            /* renamed from: e, reason: collision with root package name */
            private byte[] f24160e;

            public C0344a a(String str) {
                this.f24156a = str;
                return this;
            }

            public C0344a b(boolean z5) {
                this.f24159d = z5;
                return this;
            }

            public C0344a c(byte[] bArr) {
                this.f24160e = bArr;
                return this;
            }

            public g d() {
                g gVar = new g();
                gVar.f24151a = this.f24156a;
                gVar.f24152b = this.f24157b;
                gVar.f24153c = this.f24158c;
                gVar.f24154d = this.f24159d;
                gVar.f24155e = this.f24160e;
                return gVar;
            }
        }

        public byte[] a() {
            return this.f24155e;
        }

        public String b() {
            return this.f24151a;
        }

        public boolean g() {
            return this.f24154d;
        }
    }

    public static synchronized void a(@NonNull Context context, @NonNull com.bytedance.j.xt.f fVar, boolean z5, boolean z6) {
        synchronized (a.class) {
            b(context, fVar, z5, false, z6);
        }
    }

    public static synchronized void b(@NonNull Context context, @NonNull com.bytedance.j.xt.f fVar, boolean z5, boolean z6, boolean z7) {
        synchronized (a.class) {
            c(context, fVar, z5, z5, z6, z7);
        }
    }

    public static synchronized void c(@NonNull Context context, @NonNull com.bytedance.j.xt.f fVar, boolean z5, boolean z6, boolean z7, boolean z8) {
        synchronized (a.class) {
            try {
                if (f24136a) {
                    return;
                }
                if (context == null) {
                    throw new IllegalArgumentException("context must be not null.");
                }
                if (fVar == null) {
                    throw new IllegalArgumentException("params must be not null.");
                }
                if (!(context instanceof Application)) {
                    context = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                if (com.bytedance.j.xt.tl.f.b(context)) {
                    return;
                }
                com.bytedance.j.xt.e.e(context, fVar);
                com.bytedance.j.xt.up.j.f.d(context);
                if (z5 || z6) {
                    com.bytedance.j.xt.r.b b6 = com.bytedance.j.xt.r.b.b();
                    if (z5) {
                        b6.c(new com.bytedance.j.xt.r.a(context));
                    }
                    f24137b = true;
                }
                f24139d = z7;
                f24136a = true;
                f24138c = z8;
                com.bytedance.j.xt.up.a.b().post(new RunnableC0342a(context, z8));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void g(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        com.bytedance.j.xt.e.l().e(map);
    }

    public static void d(com.bytedance.j.j.b bVar) {
        com.bytedance.j.xt.up.a.b().post(new b(bVar));
    }

    public static void e(com.bytedance.j.xt.c cVar) {
        com.bytedance.j.xt.e.l().d(cVar);
    }

    @Deprecated
    public static void f(String str) {
        if (!com.bytedance.j.xt.e.k().b()) {
            return;
        }
        com.bytedance.j.xt.r.b.d(str);
    }
}
