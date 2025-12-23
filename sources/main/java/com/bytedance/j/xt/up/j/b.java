package com.bytedance.j.xt.up.j;

import android.content.Context;
import android.os.Process;
import com.bytedance.j.xt.cw;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected cw f24277a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f24278b;

    /* renamed from: c, reason: collision with root package name */
    protected com.bytedance.j.xt.f f24279c = com.bytedance.j.xt.e.d().a();

    /* renamed from: d, reason: collision with root package name */
    protected h f24280d;

    /* renamed from: e, reason: collision with root package name */
    protected e f24281e;

    protected boolean c() {
        return true;
    }

    protected boolean g() {
        return true;
    }

    void a(com.bytedance.j.xt.cw.b bVar) {
        Map<String, Object> b6 = com.bytedance.j.xt.e.d().b();
        if (b6 == null) {
            return;
        }
        if (b6.containsKey("app_version")) {
            bVar.l("crash_version", b6.get("app_version"));
        }
        if (b6.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            bVar.l("app_version", b6.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        }
        if (b6.containsKey("version_code")) {
            try {
                bVar.l("crash_version_code", Integer.valueOf(Integer.parseInt(b6.get("version_code").toString())));
            } catch (Exception unused) {
                bVar.l("crash_version_code", b6.get("version_code"));
            }
        }
        if (b6.containsKey("update_version_code")) {
            try {
                bVar.l("crash_update_version_code", Integer.valueOf(Integer.parseInt(b6.get("update_version_code").toString())));
            } catch (Exception unused2) {
                bVar.l("crash_update_version_code", b6.get("update_version_code"));
            }
        }
    }

    public com.bytedance.j.xt.cw.b b(com.bytedance.j.xt.cw.b bVar) {
        if (bVar == null) {
            bVar = new com.bytedance.j.xt.cw.b();
        }
        f(bVar);
        e(bVar);
        return bVar;
    }

    b(cw cwVar, Context context, h hVar, e eVar) {
        this.f24277a = cwVar;
        this.f24278b = context;
        this.f24280d = hVar;
        this.f24281e = eVar;
    }

    private void e(com.bytedance.j.xt.cw.b bVar) {
        List<com.bytedance.j.xt.b> b6 = com.bytedance.j.xt.e.l().b(this.f24277a);
        if (b6 != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<com.bytedance.j.xt.b> it = b6.iterator();
            while (it.hasNext()) {
                Map<? extends String, ? extends String> a6 = it.next().a(this.f24277a);
                if (a6 != null) {
                    try {
                        for (String str : a6.keySet()) {
                            jSONObject.put(str, a6.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            bVar.l("custom", jSONObject);
        }
    }

    protected void d(com.bytedance.j.xt.cw.b bVar) {
        bVar.m(com.bytedance.j.xt.up.f.b(com.bytedance.j.xt.e.k().d(), com.bytedance.j.xt.e.k().e()));
    }

    void f(com.bytedance.j.xt.cw.b bVar) {
        boolean z5;
        h hVar;
        if (g() && (hVar = this.f24280d) != null) {
            bVar.f(hVar);
        }
        bVar.c(com.bytedance.j.xt.e.f());
        h hVar2 = this.f24280d;
        if ((hVar2 == null || !hVar2.f()) && !com.bytedance.j.xt.tl.f.h(this.f24278b)) {
            z5 = true;
        } else {
            z5 = false;
        }
        bVar.l("is_background", Boolean.valueOf(z5));
        bVar.l("pid", Integer.valueOf(Process.myPid()));
        bVar.l(bi.Z, Integer.valueOf(this.f24281e.a()));
        bVar.i(this.f24279c.up());
        bVar.n(com.bytedance.j.xt.e.c());
        bVar.b(com.bytedance.j.xt.e.g(), com.bytedance.j.xt.e.h());
        bVar.h(this.f24279c.m());
        bVar.j(com.bytedance.j.xt.tl.c.e(this.f24278b));
        if (c()) {
            d(bVar);
        }
        bVar.g(this.f24279c.r());
        String a6 = com.bytedance.j.xt.e.a();
        if (a6 != null) {
            bVar.l("business", a6);
        }
        if (com.bytedance.j.xt.e.j()) {
            bVar.l("is_mp", 1);
        }
        bVar.a(com.bytedance.j.xt.e.l().c());
        bVar.l("crash_uuid", UUID.randomUUID().toString());
    }
}
