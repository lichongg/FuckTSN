package com.bytedance.msdk.cw.cw.xt.j;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.j.up.m;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class xt extends com.bytedance.sdk.openadsdk.core.wq.r implements com.bytedance.msdk.cw.j.j, com.bytedance.msdk.cw.j.xt {

    /* renamed from: j, reason: collision with root package name */
    protected com.bytedance.msdk.cw.j.xt f24916j;
    private boolean xt = false;
    private boolean cw = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map) {
        this.xt = false;
        this.cw = false;
        if (com.bytedance.msdk.core.j.qv().ch()) {
            xt(context, xtVar, xtVar2, map);
            j(xtVar);
            return;
        }
        try {
            xt(context, xtVar, xtVar2, map);
            j(xtVar);
        } catch (Throwable th) {
            j(new com.bytedance.msdk.api.j(com.bytedance.msdk.core.ws.xt.j(th)));
            vl.j(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    public String j(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2) {
        return null;
    }

    public abstract void xt(Context context, com.bytedance.msdk.cw.m.xt.xt xtVar, com.bytedance.msdk.api.j.xt xtVar2, Map<String, Object> map);

    public boolean xt() {
        return this.xt;
    }

    public xt(com.bytedance.msdk.cw.j.xt xtVar) {
        this.f24916j = xtVar;
    }

    @Override // com.bytedance.msdk.cw.j.j
    public final void j(final Context context, final com.bytedance.msdk.cw.m.xt.xt xtVar, final com.bytedance.msdk.api.j.xt xtVar2, final Map<String, Object> map) {
        if (xtVar != null && (TextUtils.equals(MediationConstant.ADN_MINTEGRAL, xtVar.jy()) || TextUtils.equals("baidu", xtVar.jy()) || TextUtils.equals(MediationConstant.ADN_ADMOB, xtVar.jy()))) {
            m.cw(new Runnable() { // from class: com.bytedance.msdk.cw.cw.xt.j.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.cw(context, xtVar, xtVar2, map);
                }
            });
        } else {
            cw(context, xtVar, xtVar2, map);
        }
    }

    private void j(com.bytedance.msdk.cw.m.xt.xt xtVar) {
        if (xtVar != null) {
            com.bytedance.msdk.core.cw.cw.xt(xtVar.jy(), xtVar.xt(), xtVar.vl());
        }
    }

    public void j(com.bytedance.msdk.xt.cw cwVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(cwVar);
        j(arrayList);
    }

    public void j(List<com.bytedance.msdk.xt.cw> list) {
        if (this.xt) {
            return;
        }
        this.xt = true;
        com.bytedance.msdk.cw.j.xt xtVar = this.f24916j;
        if (xtVar != null) {
            xtVar.j(list);
        }
    }

    @Override // com.bytedance.msdk.cw.j.xt
    public void j(com.bytedance.msdk.api.j jVar) {
        this.cw = true;
        if (this.xt) {
            return;
        }
        this.xt = true;
        com.bytedance.msdk.cw.j.xt xtVar = this.f24916j;
        if (xtVar != null) {
            xtVar.j(jVar);
        }
    }

    public void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j jVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(cwVar);
        j(arrayList, jVar);
    }

    @Override // com.bytedance.msdk.cw.j.xt
    public void j(List<com.bytedance.msdk.xt.cw> list, com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.cw.j.xt xtVar;
        if (this.cw || (xtVar = this.f24916j) == null) {
            return;
        }
        xtVar.j(list, jVar);
    }

    @Override // com.bytedance.msdk.cw.j.xt
    public void j(com.bytedance.msdk.xt.cw cwVar, String str) {
        com.bytedance.msdk.cw.j.xt xtVar = this.f24916j;
        if (xtVar != null) {
            xtVar.j(cwVar, str);
        }
    }

    public boolean j() {
        return this.cw;
    }
}
