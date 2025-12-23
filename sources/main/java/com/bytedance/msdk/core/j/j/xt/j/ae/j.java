package com.bytedance.msdk.core.j.j.xt.j.ae;

import a1.a;
import a1.b;
import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.g;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.j.up.m;
import com.bytedance.sdk.openadsdk.core.wq.r;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.msdk.core.j.j.xt.j {

    /* renamed from: com.bytedance.msdk.core.j.j.xt.j.ae.j$j, reason: collision with other inner class name */
    static class C0352j extends r {

        /* renamed from: j, reason: collision with root package name */
        private com.bytedance.msdk.core.j.j.xt.j f24493j;
        private xt xt;

        private void j(Function<SparseArray<Object>, Object> function) {
            if (this.xt != null || function == null) {
                return;
            }
            this.xt = new xt(this.f24493j, function);
        }

        public C0352j(com.bytedance.msdk.core.j.j.xt.j jVar) {
            this.f24493j = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.r
        public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i6 == 60000) {
                Function<SparseArray<Object>, Object> a6 = b.a(pluginValueSet.objectValue(50005, a.a()));
                long longValue = pluginValueSet.longValue(50012) - SystemClock.elapsedRealtime();
                com.bytedance.msdk.core.j.j.xt.j jVar = this.f24493j;
                if (jVar != null && longValue > 1000) {
                    if (a6 != null) {
                        j(a6);
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(this.xt);
                        this.f24493j.j(arrayList);
                        return null;
                    }
                    jVar.j(-999, "adn return data is null");
                    return null;
                }
                return null;
            }
            if (i6 == 60001 && this.f24493j != null) {
                com.bytedance.msdk.core.j.j.xt.j.m.xt xtVar = new com.bytedance.msdk.core.j.j.xt.j.m.xt(b.a(pluginValueSet.objectValue(50006, a.a())));
                if (xtVar.j() != 4004 && xtVar.j() != 4005) {
                    this.f24493j.j(xtVar.j(), xtVar.xt());
                    return null;
                }
                xt xtVar2 = this.xt;
                if (xtVar2 != null) {
                    xtVar2.j(xtVar);
                    return null;
                }
                return null;
            }
            return null;
        }
    }

    private void cw(Context context) {
        if (this.cw != null) {
            int i6 = this.f24490j.i();
            if (i6 < 0) {
                i6 = 3000;
            } else if (i6 > 5000) {
                i6 = 5000;
            }
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40024).j(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, this.xt.w()).j(50011, Integer.valueOf(i6)).j(10000, context).j(Void.class).xt());
        }
    }

    private void m() {
        oq oqVar;
        if (this.cw == null || (oqVar = this.xt) == null) {
            return;
        }
        int oq = oqVar.oq();
        if (oq == 2) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40027).j(10004, new C0352j(this)).j(Void.class).xt());
        } else if (oq == 0 || oq == 1) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40028).j(10004, new C0352j(this)).j(Void.class).xt());
        }
    }

    private void r() {
        if (this.f24490j.kt() || this.cw == null) {
            return;
        }
        this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40026).j(Void.class).xt());
    }

    private void up() {
        HashMap hashMap = new HashMap();
        g xt = com.bytedance.msdk.core.j.qv().p().xt();
        if (xt != null) {
            hashMap.put(d.D, String.valueOf(xt.xt()));
            hashMap.put(d.C, String.valueOf(xt.j()));
            hashMap.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (!this.f24490j.mi()) {
            hashMap.put("shakable", "0");
        }
        if (hashMap.size() > 0) {
            e.a().f(50010, hashMap);
            Function<SparseArray<Object>, Object> function = this.cw;
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40025).j(Void.class).xt());
            }
        }
    }

    @Override // com.bytedance.msdk.core.j.j.xt.j
    protected void j(final Context context) {
        if (cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.ae.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xt(context);
                }
            });
        } else {
            xt(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(Context context) {
        up();
        cw(context);
        r();
        m();
    }
}
