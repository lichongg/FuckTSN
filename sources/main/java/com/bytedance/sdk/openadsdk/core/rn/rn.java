package com.bytedance.sdk.openadsdk.core.rn;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class rn {

    /* renamed from: j, reason: collision with root package name */
    private static final Set<Integer> f30153j = new CopyOnWriteArraySet();
    private static final com.bytedance.sdk.component.utils.v xt = new com.bytedance.sdk.component.utils.v() { // from class: com.bytedance.sdk.openadsdk.core.rn.rn.1
        @Override // com.bytedance.sdk.component.utils.v
        public boolean j(int i6) {
            if (!com.bytedance.sdk.openadsdk.core.v.xt().uh()) {
                return true;
            }
            return rn.f30153j.contains(Integer.valueOf(i6));
        }
    };

    public static com.bytedance.sdk.component.widget.xt.j j(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return null;
        }
        com.bytedance.sdk.component.widget.xt.j jVar = new com.bytedance.sdk.component.widget.xt.j();
        jVar.j(nVar.ae());
        jVar.j(nVar.os());
        jVar.xt(nVar.fs());
        return jVar;
    }

    public static void xt(int i6) {
        f30153j.remove(Integer.valueOf(i6));
        xt.xt(i6);
    }

    public static void j() {
        if (com.bytedance.sdk.openadsdk.core.v.xt().uh()) {
            com.bytedance.sdk.component.utils.f.j(xt);
        } else {
            f30153j.clear();
        }
    }

    public static void j(int i6) {
        if (com.bytedance.sdk.openadsdk.core.v.xt().uh()) {
            f30153j.add(Integer.valueOf(i6));
        }
        xt.cw(i6);
    }
}
