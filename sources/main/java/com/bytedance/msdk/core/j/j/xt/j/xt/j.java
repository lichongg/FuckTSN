package com.bytedance.msdk.core.j.j.xt.j.xt;

import a1.a;
import a1.b;
import android.content.Context;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.g;
import com.bytedance.msdk.j.up.m;
import com.bytedance.sdk.openadsdk.core.wq.r;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.msdk.core.j.j.xt.j {

    /* renamed from: com.bytedance.msdk.core.j.j.xt.j.xt.j$j, reason: collision with other inner class name */
    static class C0358j extends r {

        /* renamed from: j, reason: collision with root package name */
        private com.bytedance.msdk.core.j.j.xt.j f24599j;
        private Context xt;

        public void j(Context context) {
            this.xt = context;
        }

        public C0358j(com.bytedance.msdk.core.j.j.xt.j jVar) {
            this.f24599j = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.r
        public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i6 == 60000) {
                List list = (List) pluginValueSet.objectValue(50015, List.class);
                if (this.f24599j != null) {
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList = new ArrayList(list.size());
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new xt(this.xt, this.f24599j, b.a(it.next())));
                        }
                        this.f24599j.j(arrayList);
                        return null;
                    }
                    this.f24599j.j(-999, "adn return data is null");
                    return null;
                }
                return null;
            }
            if (i6 == 60001 && this.f24599j != null) {
                com.bytedance.msdk.core.j.j.xt.j.m.xt xtVar = new com.bytedance.msdk.core.j.j.xt.j.m.xt(b.a(pluginValueSet.objectValue(50006, a.a())));
                this.f24599j.j(xtVar.j(), xtVar.xt());
                return null;
            }
            return null;
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
        if (hashMap.size() > 0) {
            e.a().f(50010, hashMap);
            if (this.cw != null) {
                this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40025).j(50010, hashMap).j(Void.class).xt());
            }
        }
    }

    private void cw(Context context) {
        if (this.cw == null || this.f24490j == null) {
            return;
        }
        C0358j c0358j = new C0358j(this);
        c0358j.j(context);
        this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40037).j(10004, c0358j).j(10013, Integer.valueOf(this.f24490j.a())).j(Void.class).xt());
    }

    private void m() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40020).j(50010, this.f24490j.c()).j(Void.class).xt());
        }
    }

    private void up() {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40019).j(50010, this.f24490j.c()).j(Void.class).xt());
        }
    }

    @Override // com.bytedance.msdk.core.j.j.xt.j
    protected void j(final Context context) {
        if (cw()) {
            m.r(new Runnable() { // from class: com.bytedance.msdk.core.j.j.xt.j.xt.j.1
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
        r(context);
        up();
        m();
        cw(context);
    }

    private void r(Context context) {
        if (this.cw != null) {
            this.cw.apply(com.bytedance.sdk.openadsdk.i.r.j().j(40036).j(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, this.xt.w()).j(10000, context).j(Void.class).xt());
        }
    }
}
