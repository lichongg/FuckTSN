package com.bytedance.sdk.openadsdk.core.xt.j.cw;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends xt {
    private Map<String, Object> ae;

    /* renamed from: g, reason: collision with root package name */
    private EmptyView f31321g;

    /* renamed from: m, reason: collision with root package name */
    private String f31322m;
    private Double tl;
    j up;

    public interface j {
        boolean j();
    }

    public cw() {
    }

    public void j(j jVar) {
        this.up = jVar;
    }

    public cw(n nVar, Context context) {
        this.f31325j = nVar;
        this.xt = context;
        this.ae = new HashMap();
    }

    public void j(String str) {
        this.f31322m = str;
    }

    public void j(EmptyView emptyView) {
        this.f31321g = emptyView;
    }

    public void j(Map<String, Object> map) {
        Map<String, Object> map2 = this.ae;
        if (map2 == null) {
            this.ae = map;
        } else {
            map2.putAll(map);
        }
    }

    public void j(Double d6) {
        this.tl = d6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.j.cw.xt, com.bytedance.sdk.openadsdk.core.xt.j.j
    public int j(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xt.j.cw cwVar) {
        j jVar;
        if (!v.xt().ua() || (jVar = this.up) == null || jVar.j()) {
            return 0;
        }
        EmptyView emptyView = this.f31321g;
        if (emptyView == null) {
            this.ae.put("show_send_type", 1);
            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.f31325j, this.f31322m, this.ae, this.tl);
        } else {
            emptyView.j("checkWhenClicked");
        }
        return 0;
    }
}
