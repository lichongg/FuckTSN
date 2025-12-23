package cn.jiguang.bq;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bt.d;
import cn.jiguang.bt.e;
import cn.jiguang.bt.f;
import cn.jiguang.bt.g;
import cn.jiguang.bt.h;
import cn.jiguang.bt.j;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import com.stub.StubApp;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, cn.jiguang.br.a> f2532a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f2533b;

    /* renamed from: c, reason: collision with root package name */
    private Context f2534c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2535d;

    /* renamed from: e, reason: collision with root package name */
    private String f2536e;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f2540a = new c();
    }

    private c() {
        this.f2533b = new AtomicBoolean(false);
        this.f2536e = "netmt.catch";
    }

    public static c a() {
        return a.f2540a;
    }

    public String c(String str, int i6, int i7) {
        String str2 = "";
        if (this.f2533b.get()) {
            try {
                f fVar = new f(this.f2534c);
                fVar.a(str, i6, i7 + "");
                str2 = fVar.c();
                this.f2532a.put(str2, fVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "tcpLoginStart wrong:" + th.getMessage());
            }
        }
        return str2;
    }

    public String d(String str, int i6, int i7) {
        String str2 = "";
        if (this.f2533b.get()) {
            try {
                h hVar = new h(this.f2534c);
                hVar.a(str, i6, i7 + "");
                str2 = hVar.c();
                this.f2532a.put(str2, hVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "tcpReportStart wrong:" + th.getMessage());
            }
        }
        return str2;
    }

    public String a(Context context, HttpRequest httpRequest, boolean z5) {
        String str = "";
        try {
            if (!b(context)) {
                return "";
            }
            j jVar = new j(this.f2534c);
            jVar.a(httpRequest, z5);
            str = jVar.c();
            this.f2532a.put(str, jVar);
            return str;
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("NetMoniterManager", "httpStart wrong:" + th.getMessage());
            return str;
        }
    }

    public String b(String str, int i6) {
        String str2 = "";
        if (this.f2533b.get()) {
            try {
                cn.jiguang.bt.c cVar = new cn.jiguang.bt.c(this.f2534c);
                cVar.a(str, i6);
                str2 = cVar.c();
                this.f2532a.put(str2, cVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "sisStart wrong:" + th.getMessage());
            }
        }
        return str2;
    }

    public void c(String str, int i6) {
        cn.jiguang.br.a remove;
        if (this.f2533b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f2532a.remove(str)) == null || !(remove instanceof cn.jiguang.bt.c)) {
                    return;
                }
                ((cn.jiguang.bt.c) remove).a(i6);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "sisEnd wrong:" + th.getMessage());
            }
        }
    }

    public void d(String str, int i6) {
        cn.jiguang.br.a remove;
        if (this.f2533b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f2532a.remove(str)) == null || !(remove instanceof d)) {
                    return;
                }
                ((d) remove).a(i6);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "tcpConnEnd wrong:" + th.getMessage());
            }
        }
    }

    public void e(String str, int i6) {
        cn.jiguang.br.a remove;
        if (this.f2533b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f2532a.remove(str)) == null || !(remove instanceof g)) {
                    return;
                }
                ((g) remove).a(i6);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "tcpRegisterEnd wrong:" + th.getMessage());
            }
        }
    }

    public void f(String str, int i6) {
        cn.jiguang.br.a remove;
        if (this.f2533b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f2532a.remove(str)) == null || !(remove instanceof f)) {
                    return;
                }
                ((f) remove).a(i6);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "tcpLoginEnd wrong:" + th.getMessage());
            }
        }
    }

    public void g(String str, int i6) {
        cn.jiguang.br.a remove;
        if (this.f2533b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f2532a.remove(str)) == null || !(remove instanceof h)) {
                    return;
                }
                ((h) remove).a(i6);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "tcpReportEnd wrong:" + th.getMessage());
            }
        }
    }

    public String b(String str, int i6, int i7) {
        String str2 = "";
        if (this.f2533b.get()) {
            try {
                g gVar = new g(this.f2534c);
                gVar.a(str, i6, i7 + "");
                str2 = gVar.c();
                this.f2532a.put(str2, gVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "tcpRegisterStart wrong:" + th.getMessage());
            }
        }
        return str2;
    }

    public String a(String str) {
        String str2 = "";
        if (this.f2533b.get()) {
            try {
                cn.jiguang.bt.a aVar = new cn.jiguang.bt.a(this.f2534c);
                aVar.a(str);
                str2 = aVar.c();
                this.f2532a.put(str2, aVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "dnsStart wrong:" + th.getMessage());
            }
        }
        return str2;
    }

    public void b() {
        if (this.f2533b.get()) {
            cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bq.c.2
                @Override // cn.jiguang.by.b
                public void a() {
                    try {
                        synchronized (c.class) {
                            try {
                                JSONObject a6 = cn.jiguang.bz.j.a(c.this.f2536e);
                                if (a6 != null && a6.has("data")) {
                                    cn.jiguang.bb.f.c("NetMoniterManager", "start report moniter data");
                                    cn.jiguang.be.b.a(c.this.f2534c, a6, "sdk_moniter");
                                    cn.jiguang.bz.j.d(c.this.f2536e);
                                }
                            } finally {
                            }
                        }
                    } catch (Throwable th) {
                        cn.jiguang.bb.f.i("NetMoniterManager", "save data error:" + th.getMessage());
                    }
                }
            });
        }
    }

    private boolean b(Context context) {
        a(context);
        return this.f2533b.get();
    }

    public String a(String str, int i6, int i7) {
        String str2 = "";
        if (this.f2533b.get()) {
            try {
                d dVar = new d(this.f2534c);
                dVar.a(str, i6, i7 + "");
                str2 = dVar.c();
                this.f2532a.put(str2, dVar);
                return str2;
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "tcpConnStart wrong:" + th.getMessage());
            }
        }
        return str2;
    }

    public String a(String str, int i6, int i7, int i8) {
        if (this.f2533b.get()) {
            try {
                e eVar = new e(this.f2534c);
                eVar.a(str, i6, i7 + "", i8);
                a(eVar);
                return "";
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "tcpDisconnect wrong:" + th.getMessage());
            }
        }
        return "";
    }

    public void a(Context context) {
        if (this.f2535d) {
            return;
        }
        this.f2534c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f2533b.set(((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aG())).booleanValue());
        try {
            String replace = cn.jiguang.bz.a.a(this.f2534c).replace(this.f2534c.getPackageName(), "");
            if (!TextUtils.isEmpty(replace)) {
                if (replace.startsWith(":")) {
                    replace = replace.substring(1);
                }
                if (!this.f2536e.contains(replace)) {
                    this.f2536e = "netmt." + replace;
                }
            }
        } catch (Throwable unused) {
        }
        cn.jiguang.bb.f.c("NetMoniterManager", "init DATAPATH :" + this.f2536e);
        cn.jiguang.bb.f.c("NetMoniterManager", "init state :" + this.f2533b.get());
        if (this.f2533b.get()) {
            this.f2532a = new ConcurrentHashMap<>();
        } else {
            cn.jiguang.bz.j.d(this.f2536e);
        }
        this.f2535d = true;
    }

    public void a(Context context, String str, HttpResponse httpResponse) {
        cn.jiguang.br.a remove;
        try {
            if (!b(context) || TextUtils.isEmpty(str) || (remove = this.f2532a.remove(str)) == null || !(remove instanceof j)) {
                return;
            }
            ((j) remove).a(httpResponse);
            a(remove);
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("NetMoniterManager", "httpEnd wrong:" + th.getMessage());
        }
    }

    public void a(Context context, boolean z5) {
        a(context);
        synchronized (c.class) {
            try {
                if (this.f2533b.get() != z5) {
                    this.f2533b.set(z5);
                    cn.jiguang.e.b.a(this.f2534c, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aG().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(z5))});
                    cn.jiguang.bb.f.c("NetMoniterManager", "change state :" + this.f2533b.get());
                    if (this.f2533b.get()) {
                        this.f2532a = new ConcurrentHashMap<>();
                    } else {
                        this.f2532a = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(final cn.jiguang.br.a aVar) {
        cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bq.c.1
            @Override // cn.jiguang.by.b
            public void a() {
                JSONArray jSONArray;
                try {
                    synchronized (c.class) {
                        try {
                            JSONObject b6 = aVar.b();
                            cn.jiguang.bb.f.c("NetMoniterManager", "save moniter data:" + b6);
                            JSONObject a6 = cn.jiguang.bz.j.a(c.this.f2536e);
                            if (a6 != null && a6.has("data")) {
                                jSONArray = a6.optJSONArray("data");
                                jSONArray.put(b6);
                                a6.put("data", jSONArray);
                                cn.jiguang.bz.j.a(c.this.f2536e, a6);
                            }
                            a6 = new JSONObject();
                            a6.put("type", "sdk_moniter");
                            jSONArray = new JSONArray();
                            jSONArray.put(b6);
                            a6.put("data", jSONArray);
                            cn.jiguang.bz.j.a(c.this.f2536e, a6);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    cn.jiguang.bb.f.i("NetMoniterManager", "save data error:" + th2.getMessage());
                }
            }
        });
    }

    public void a(String str, int i6) {
        cn.jiguang.br.a remove;
        if (this.f2533b.get()) {
            try {
                if (TextUtils.isEmpty(str) || (remove = this.f2532a.remove(str)) == null || !(remove instanceof cn.jiguang.bt.a)) {
                    return;
                }
                ((cn.jiguang.bt.a) remove).a(i6);
                a(remove);
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("NetMoniterManager", "dnsEnd wrong:" + th.getMessage());
            }
        }
    }
}
