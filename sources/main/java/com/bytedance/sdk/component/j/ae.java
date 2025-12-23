package com.bytedance.sdk.component.j;

import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.sdk.component.j.f;
import com.bytedance.sdk.component.j.mi;
import com.bytedance.sdk.component.j.r;
import com.bytedance.sdk.component.j.tj;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* loaded from: D:\Downloads\app\classes4.dex */
class ae implements f.j {
    private final jy ae;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f26464g;

    /* renamed from: j, reason: collision with root package name */
    private final tl f26465j;
    private final com.bytedance.sdk.component.j.j oq;
    private final boolean tl;
    private final kt xt;
    private final Map<String, xt> cw = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, r.xt> f26467r = new HashMap();
    private final List<av> up = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final Set<r> f26466m = new HashSet();

    static final class j {

        /* renamed from: j, reason: collision with root package name */
        boolean f26470j;
        String xt;

        private j(boolean z5, String str) {
            this.f26470j = z5;
            this.xt = str;
        }
    }

    private v xt(String str, xt xtVar) {
        return this.f26464g ? v.PRIVATE : this.xt.j(this.tl, str, xtVar);
    }

    @MainThread
    j j(av avVar, m mVar) throws Exception {
        xt xtVar = this.cw.get(avVar.f26473r);
        if (xtVar != null) {
            try {
                v xt = xt(mVar.xt, xtVar);
                mVar.f26494r = xt;
                if (xt == null) {
                    g.j("Permission denied, call: ".concat(String.valueOf(avVar)));
                    throw new w(-1);
                }
                if (xtVar instanceof up) {
                    g.j("Processing stateless call: ".concat(String.valueOf(avVar)));
                    return j(avVar, (up) xtVar, mVar);
                }
                if (xtVar instanceof cw) {
                    g.j("Processing raw call: ".concat(String.valueOf(avVar)));
                    return j(avVar, (cw) xtVar, xt);
                }
            } catch (tj.j e6) {
                g.j("No remote permission config fetched, call pending: ".concat(String.valueOf(avVar)), e6);
                this.up.add(avVar);
                return new j(false, x.j());
            }
        }
        r.xt xtVar2 = this.f26467r.get(avVar.f26473r);
        if (xtVar2 == null) {
            g.xt("Received call: " + avVar + ", but not registered.");
            return null;
        }
        r j6 = xtVar2.j();
        j6.j(avVar.f26473r);
        v xt2 = xt(mVar.xt, j6);
        mVar.f26494r = xt2;
        if (xt2 != null) {
            g.j("Processing stateful call: ".concat(String.valueOf(avVar)));
            return j(avVar, j6, mVar);
        }
        g.j("Permission denied, call: ".concat(String.valueOf(avVar)));
        j6.up();
        throw new w(-1);
    }

    ae(oq oqVar, com.bytedance.sdk.component.j.j jVar, tj tjVar) {
        this.oq = jVar;
        this.f26465j = oqVar.f26500r;
        kt ktVar = new kt(tjVar, oqVar.vl, oqVar.jy);
        this.xt = ktVar;
        ktVar.j(this);
        ktVar.j(oqVar.av);
        this.ae = oqVar.f26497g;
        this.tl = oqVar.tl;
        this.f26464g = oqVar.az;
    }

    void j(String str, up<?, ?> upVar) {
        upVar.j(str);
        this.cw.put(str, upVar);
        g.j("JsBridge stateless method registered: ".concat(String.valueOf(str)));
    }

    void j(String str, r.xt xtVar) {
        this.f26467r.put(str, xtVar);
        g.j("JsBridge stateful method registered: ".concat(String.valueOf(str)));
    }

    void j() {
        Iterator<r> it = this.f26466m.iterator();
        while (it.hasNext()) {
            it.next().m();
        }
        this.f26466m.clear();
        this.cw.clear();
        this.f26467r.clear();
        this.xt.xt(this);
    }

    @MainThread
    private j j(av avVar, up upVar, m mVar) throws Exception {
        return new j(true, x.j(this.f26465j.j((tl) upVar.j(j(avVar.up, (xt) upVar), mVar))));
    }

    @MainThread
    private j j(final av avVar, final r rVar, m mVar) throws Exception {
        this.f26466m.add(rVar);
        rVar.j(j(avVar.up, rVar), mVar, new r.j() { // from class: com.bytedance.sdk.component.j.ae.1
            @Override // com.bytedance.sdk.component.j.r.j
            public void j(Object obj) {
                if (ae.this.oq == null) {
                    return;
                }
                ae.this.oq.xt(x.j(ae.this.f26465j.j((tl) obj)), avVar);
                ae.this.f26466m.remove(rVar);
            }

            @Override // com.bytedance.sdk.component.j.r.j
            public void j(Throwable th) {
                if (ae.this.oq == null) {
                    return;
                }
                ae.this.oq.xt(x.j(th), avVar);
                ae.this.f26466m.remove(rVar);
            }
        });
        return new j(false, x.j());
    }

    @MainThread
    private j j(final av avVar, cw cwVar, v vVar) throws Exception {
        new mi(avVar.f26473r, vVar, new mi.j() { // from class: com.bytedance.sdk.component.j.ae.2
        });
        return new j(false, x.j());
    }

    private Object j(String str, xt xtVar) throws JSONException {
        return this.f26465j.j(str, j(xtVar)[0]);
    }

    private static Type[] j(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }
}
