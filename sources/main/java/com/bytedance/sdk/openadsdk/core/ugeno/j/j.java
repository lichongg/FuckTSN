package com.bytedance.sdk.openadsdk.core.ugeno.j;

import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements xt {
    private static int up(n nVar) {
        int tl;
        if (nVar == null) {
            return -1;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr = nVar.rr();
        int kt = rr != null ? rr.kt() : -1;
        return ((kt <= 0 || kt >= 10) && (tl = uf.tl(nVar)) > 0 && tl < 10) ? tl : kt;
    }

    public static boolean xt(n nVar) {
        return nVar != null && hh.cw(nVar) == 2 && cw(nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.j.xt
    public String j(n nVar) {
        int up = up(nVar);
        int r5 = r(nVar);
        if (up <= 0 || up > 9 || r5 == -1) {
            return null;
        }
        return j(nVar, up, r5);
    }

    protected abstract String j(n nVar, int i6, int i7);

    private int r(n nVar) {
        if (nVar == null) {
            return -1;
        }
        return nVar.ve();
    }

    public static boolean cw(n nVar) {
        if (up(nVar) == 5) {
            return true;
        }
        return false;
    }

    public static xt j(n nVar, jy jyVar) {
        if (nVar == null || up(nVar) != 5) {
            return null;
        }
        if ((jyVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.xt) && ((com.bytedance.sdk.openadsdk.core.ugeno.express.xt) jyVar).wq()) {
            return new com.bytedance.sdk.openadsdk.core.ugeno.j.xt.j();
        }
        return new com.bytedance.sdk.openadsdk.core.ugeno.j.j.j();
    }
}
