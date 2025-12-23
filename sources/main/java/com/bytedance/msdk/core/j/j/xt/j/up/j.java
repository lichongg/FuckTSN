package com.bytedance.msdk.core.j.j.xt.j.up;

import a1.a;
import a1.b;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.g;
import com.bytedance.msdk.j.up.m;
import com.bytedance.sdk.openadsdk.core.wq.r;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.msdk.core.j.j.xt.j {

    /* renamed from: com.bytedance.msdk.core.j.j.xt.j.up.j$j, reason: collision with other inner class name */
    static class C0357j extends r {

        /* renamed from: j, reason: collision with root package name */
        private com.bytedance.msdk.core.j.j.xt.j f24588j;
        private xt xt;

        private void j(Function<SparseArray<Object>, Object> function) {
            if (this.xt != null || function == null) {
                return;
            }
            this.xt = new xt(this.f24588j, function);
        }

        public C0357j(com.bytedance.msdk.core.j.j.xt.j jVar) {
            this.f24588j = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.r
        public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i6 == 60008) {
                Function<SparseArray<Object>, Object> a6 = b.a(pluginValueSet.objectValue(50005, a.a()));
                com.bytedance.msdk.core.j.j.xt.j jVar = this.f24588j;
                if (jVar != null) {
                    if (a6 != null) {
                        j(a6);
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(this.xt);
                        this.f24588j.j(arrayList);
                        return null;
                    }
                    jVar.j(-999, "adn return data is null");
                    return null;
                }
                return null;
            }
            if (i6 == 60001 && this.f24588j != null) {
                com.bytedance.msdk.core.j.j.xt.j.m.xt xtVar = new com.bytedance.msdk.core.j.j.xt.j.m.xt(b.a(pluginValueSet.objectValue(50006, a.a())));
                this.f24588j.j(xtVar.j(), xtVar.xt());
                return null;
            }
            return null;
        }
    }

    private void ae() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40018).j(Void.class).j(50010, this.f24490j.c()).xt());
        }
    }

    private void cw(Context context) {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40017).j(Void.class).j(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, this.xt.w()).j(10000, context).xt());
        }
    }

    private void m() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40020).j(Void.class).j(50010, this.f24490j.c()).xt());
        }
    }

    private void r() {
        HashMap hashMap = new HashMap();
        g xt = com.bytedance.msdk.core.j.qv().p().xt();
        if (xt != null) {
            hashMap.put(d.D, String.valueOf(xt.xt()));
            hashMap.put(d.C, String.valueOf(xt.j()));
            hashMap.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (hashMap.size() <= 0 || this.cw == null) {
            return;
        }
        this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40025).j(Void.class).j(50010, hashMap).xt());
    }

    private void tl() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40002).j(Void.class).j(10004, new C0357j(this)).xt());
        }
    }

    private void up() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40019).j(Void.class).j(50010, this.f24490j.c()).xt());
        }
    }

    @Override // com.bytedance.msdk.core.j.j.xt.j
    protected void j(final Context context) {
        if (cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.up.j.1
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
        r();
        cw(context);
        ae();
        up();
        m();
        tl();
    }
}
