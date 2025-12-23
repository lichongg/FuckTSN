package com.huawei.agconnect.core.a;

import android.content.Context;
import com.huawei.agconnect.e;
import com.huawei.agconnect.f;
import com.huawei.agconnect.g;
import com.huawei.agconnect.h;
import com.huawei.agconnect.i;
import com.huawei.hmf.tasks.k;
import com.stub.StubApp;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes5.dex */
public class b extends com.huawei.agconnect.d {

    /* renamed from: d, reason: collision with root package name */
    private static List<com.huawei.agconnect.core.b> f32961d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f32962e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, com.huawei.agconnect.d> f32963f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private static String f32964g;

    /* renamed from: a, reason: collision with root package name */
    private final e f32965a;

    /* renamed from: b, reason: collision with root package name */
    private final com.huawei.agconnect.core.a.d f32966b;

    /* renamed from: c, reason: collision with root package name */
    private final com.huawei.agconnect.core.a.d f32967c;

    class c implements l1.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f32968a;

        c(h hVar) {
            this.f32968a = hVar;
        }

        @Override // l1.b
        public k<l1.d> a(boolean z5) {
            return this.f32968a.a(z5);
        }

        @Override // l1.b
        public k<l1.d> b() {
            return this.f32968a.a(false);
        }
    }

    class d implements l1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f32970a;

        d(g gVar) {
            this.f32970a = gVar;
        }

        @Override // l1.a
        public k<l1.d> a(boolean z5) {
            return this.f32970a.a(z5);
        }

        @Override // l1.a
        public k<l1.d> b() {
            return this.f32970a.a(false);
        }

        @Override // l1.a
        public String getUid() {
            return "";
        }

        @Override // l1.a
        public void c(l1.c cVar) {
        }

        @Override // l1.a
        public void d(l1.c cVar) {
        }
    }

    public static com.huawei.agconnect.d i(e eVar) {
        return j(eVar, false);
    }

    static class a implements i.a {
        a() {
        }

        @Override // com.huawei.agconnect.i.a
        public String a(e eVar) {
            String str;
            if (eVar.c().equals(com.huawei.agconnect.b.f32911c)) {
                str = "/agcgw_all/CN";
            } else if (eVar.c().equals(com.huawei.agconnect.b.f32913e)) {
                str = "/agcgw_all/RU";
            } else if (eVar.c().equals(com.huawei.agconnect.b.f32912d)) {
                str = "/agcgw_all/DE";
            } else if (eVar.c().equals(com.huawei.agconnect.b.f32914f)) {
                str = "/agcgw_all/SG";
            } else {
                return null;
            }
            return eVar.getString(str);
        }
    }

    /* renamed from: com.huawei.agconnect.core.a.b$b, reason: collision with other inner class name */
    static class C0538b implements i.a {
        C0538b() {
        }

        @Override // com.huawei.agconnect.i.a
        public String a(e eVar) {
            String str;
            if (eVar.c().equals(com.huawei.agconnect.b.f32911c)) {
                str = "/agcgw_all/CN_back";
            } else if (eVar.c().equals(com.huawei.agconnect.b.f32913e)) {
                str = "/agcgw_all/RU_back";
            } else if (eVar.c().equals(com.huawei.agconnect.b.f32912d)) {
                str = "/agcgw_all/DE_back";
            } else if (eVar.c().equals(com.huawei.agconnect.b.f32914f)) {
                str = "/agcgw_all/SG_back";
            } else {
                return null;
            }
            return eVar.getString(str);
        }
    }

    public static com.huawei.agconnect.d h() {
        String str = f32964g;
        return str == null ? k(com.huawei.agconnect.config.impl.b.f32919c) : k(str);
    }

    private static com.huawei.agconnect.d j(e eVar, boolean z5) {
        com.huawei.agconnect.d dVar;
        synchronized (f32962e) {
            Map<String, com.huawei.agconnect.d> map = f32963f;
            dVar = map.get(eVar.getIdentifier());
            if (dVar == null || z5) {
                dVar = new b(eVar);
                map.put(eVar.getIdentifier(), dVar);
            }
        }
        return dVar;
    }

    public static com.huawei.agconnect.d k(String str) {
        com.huawei.agconnect.d dVar;
        synchronized (f32962e) {
            try {
                dVar = f32963f.get(str);
                if (dVar == null) {
                    com.huawei.agconnect.config.impl.b.f32919c.equals(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public static synchronized void l(Context context) {
        synchronized (b.class) {
            if (f32963f.size() > 0) {
                return;
            }
            m(context, j1.a.d(context));
        }
    }

    private static synchronized void m(Context context, e eVar) {
        synchronized (b.class) {
            try {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (origApplicationContext != null) {
                    context = origApplicationContext;
                }
                q();
                com.huawei.agconnect.config.impl.c.o(context);
                if (f32961d == null) {
                    f32961d = new com.huawei.agconnect.core.a.c(context).b();
                }
                j(eVar, true);
                f32964g = eVar.getIdentifier();
                eVar.c().a();
                com.huawei.agconnect.core.a.a.c();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void n(Context context, f fVar) {
        synchronized (b.class) {
            r(context, fVar);
            m(context, fVar.a(context));
        }
    }

    private static void q() {
        i.b("/agcgw/url", new a());
        i.b("/agcgw/backurl", new C0538b());
    }

    private static void r(Context context, f fVar) {
        j1.a d6 = j1.a.d(context);
        if (fVar.d() != null) {
            try {
                String g6 = com.huawei.agconnect.config.impl.b.g(fVar.d(), "UTF-8");
                fVar.d().reset();
                d6.g(new ByteArrayInputStream(g6.getBytes(Charset.forName("UTF-8"))));
            } catch (IOException unused) {
            }
        }
        for (Map.Entry<String, String> entry : fVar.c().entrySet()) {
            d6.h(entry.getKey(), entry.getValue());
        }
        if (fVar.e() != com.huawei.agconnect.b.f32910b) {
            d6.i(fVar.e());
        }
    }

    @Override // com.huawei.agconnect.d
    public e d() {
        return this.f32965a;
    }

    @Override // com.huawei.agconnect.d
    public <T> T e(Class<? super T> cls) {
        T t5 = (T) this.f32967c.b(this, cls);
        return t5 != null ? t5 : (T) this.f32966b.b(this, cls);
    }

    @Override // com.huawei.agconnect.d
    public Context getContext() {
        return this.f32965a.getContext();
    }

    @Override // com.huawei.agconnect.d
    public String getIdentifier() {
        return this.f32965a.getIdentifier();
    }

    public void o(g gVar) {
        this.f32967c.e(Collections.singletonList(com.huawei.agconnect.core.b.e(l1.a.class, new d(gVar)).a()), this.f32965a.getContext());
    }

    public void p(h hVar) {
        this.f32967c.e(Collections.singletonList(com.huawei.agconnect.core.b.e(l1.b.class, new c(hVar)).a()), this.f32965a.getContext());
    }

    public b(e eVar) {
        this.f32965a = eVar;
        this.f32966b = new com.huawei.agconnect.core.a.d(f32961d, eVar.getContext());
        com.huawei.agconnect.core.a.d dVar = new com.huawei.agconnect.core.a.d(null, eVar.getContext());
        this.f32967c = dVar;
        if (eVar instanceof com.huawei.agconnect.config.impl.d) {
            dVar.e(((com.huawei.agconnect.config.impl.d) eVar).e(), eVar.getContext());
        }
    }
}
