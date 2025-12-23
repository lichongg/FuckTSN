package com.bytedance.sdk.openadsdk.core.g.j.j.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends j {
    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j.j
    public boolean cw(int i6) {
        Function<SparseArray<Object>, Object> function = this.f28975g;
        return function != null && com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(function, i6) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j.j
    public void xt(boolean z5, int i6) {
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(z5, com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(this.f28976j, this.f28977m), i6);
    }

    public r(n nVar, Context context, String str, com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw cwVar, String str2) {
        this.f28976j = nVar;
        this.xt = context;
        this.cw = str;
        this.f28978r = cwVar;
        this.up = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j.j
    public com.bytedance.sdk.openadsdk.core.qv.j.up j(Map<String, Object> map, final la<String, Object> laVar) {
        final int cw = j.cw(laVar);
        return new com.bytedance.sdk.openadsdk.core.qv.j.up() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.r.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.j.up
            public void onItemClick() {
                if (r.this.ae || r.this.f28976j.mz()) {
                    com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.xt(1, cw);
                    laVar.remove("itemClickListener");
                    r.this.f28975g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(17).j(Void.class).j(0, laVar).xt());
                    return;
                }
                r rVar = r.this;
                n nVar = rVar.f28976j;
                Context context = rVar.xt;
                String str = rVar.cw;
                com.bytedance.sdk.openadsdk.core.g.j.j.xt.j jVar = new com.bytedance.sdk.openadsdk.core.g.j.j.xt.j(nVar, context, str, uf.xt(str));
                jVar.cw(true);
                jVar.j((Map<String, Object>) new HashMap());
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j.j
    public com.bytedance.sdk.openadsdk.core.qv.j.xt r(final Map<String, Object> map) {
        final int cw = j.cw(map);
        String str = this.cw;
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(str, str, uf.mi(this.f28976j), cw);
        map.put("action_type_button", 2);
        n nVar = this.f28976j;
        if (nVar != null && !TextUtils.isEmpty(nVar.fs())) {
            map.put("id", Long.valueOf(Double.valueOf(this.f28976j.fs()).longValue()));
        }
        if (!cw(cw)) {
            j(map, true);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.qv.j.xt xtVar = new com.bytedance.sdk.openadsdk.core.qv.j.xt() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.r.1
            @Override // w2.h
            public void j(boolean z5) {
            }

            @Override // w2.h
            public void j() {
                if (map == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(0, cw);
                r rVar = r.this;
                rVar.f28978r.j(rVar.xt(cw));
                map.remove("downloadButtonClickListener");
                if (r.this.j((com.bytedance.sdk.openadsdk.core.tj.r) null, (com.bytedance.sdk.openadsdk.core.qv.j.xt) null, map)) {
                    return;
                }
                r.this.j(map, true);
            }
        };
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(map, xtVar);
        return xtVar;
    }
}
