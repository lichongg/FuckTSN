package com.bytedance.msdk.tl.xt;

import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.oq.xt;
import com.bytedance.msdk.core.up.xt.ae;
import com.bytedance.msdk.j.up.cw;
import com.bytedance.msdk.j.up.up;
import com.bytedance.msdk.up.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static boolean j(xt xtVar) {
        if (xtVar == null) {
            return false;
        }
        int wq = xtVar.wq();
        Map<String, Integer> q5 = com.bytedance.msdk.core.xt.xt().q();
        if (q5 == null) {
            return false;
        }
        Integer num = q5.get(String.valueOf(wq));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = q5.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    public static boolean xt(xt xtVar) {
        if (xtVar == null) {
            return false;
        }
        int wq = xtVar.wq();
        Map<String, Integer> qb = com.bytedance.msdk.core.xt.xt().qb();
        if (qb == null) {
            return false;
        }
        Integer num = qb.get(String.valueOf(wq));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = qb.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x012a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x004f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean j(com.bytedance.msdk.cw.m.j.xt r10, java.util.List<java.lang.Integer> r11, java.util.Map<java.lang.Integer, java.util.List<com.bytedance.msdk.core.oq.oq>> r12) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.tl.xt.j.j(com.bytedance.msdk.cw.m.j.xt, java.util.List, java.util.Map):boolean");
    }

    public static void j(com.bytedance.msdk.cw.m.j.xt xtVar, oq oqVar, int i6) {
        if (xtVar == null || xtVar.mi() == null || oqVar == null) {
            return;
        }
        com.bytedance.msdk.api.j.xt mi = xtVar.mi();
        String v5 = mi.v();
        cw.xt(MediationConstant.TAG, up.j(v5) + "----------总超时后尝试从复用池中查找广告：id:" + oqVar.w() + "   loadSort:" + oqVar.x() + "  showSort:" + oqVar.ch() + "   adnName:" + oqVar.az());
        String w5 = oqVar.w();
        if (oqVar.kt() && com.bytedance.msdk.core.up.j.j.j().r(v5, w5, mi.up()) && com.bytedance.msdk.core.up.j.j.j().j(w5, mi, true) == 3) {
            cw.xt(MediationConstant.TAG, up.j(v5) + "----------可复用：id:" + oqVar.w() + "   loadSort:" + oqVar.x() + "  showSort:" + oqVar.ch() + "   adnName:" + oqVar.az());
            com.bytedance.msdk.core.up.j.j.j().j(v5, w5, oqVar, i6);
            List<ae> j6 = com.bytedance.msdk.core.up.j.j.j().j(w5, mi, mi.up());
            if (j6 == null || j6.size() <= 0) {
                return;
            }
            int tl = j6.get(0).f24739j.tl(mi.j());
            m.j(oqVar, mi, com.bytedance.msdk.core.up.j.j.j().j(w5), !xtVar.v(), 4, i6, 3, tl, (com.bytedance.msdk.api.j) null, -1L, xtVar.xt(), true);
            ArrayList arrayList = new ArrayList();
            for (ae aeVar : j6) {
                aeVar.f24739j.g(3);
                aeVar.f24739j.oq(tl);
                aeVar.f24739j.cw(xtVar.xt());
                aeVar.f24739j.xt(true);
                j(v5, aeVar.f24739j, w5);
                arrayList.add(aeVar.f24739j);
            }
            m.j(j6.get(0).f24739j, 0, "adn cache命中", 0L, mi, i6, arrayList.size(), 4, (String) null, 0L, -1L);
            com.bytedance.msdk.cw.tl.j.j(xtVar, arrayList, true);
            com.bytedance.msdk.xt.cw cwVar = arrayList.get(0);
            if (cwVar.px()) {
                xtVar.j(arrayList);
                for (com.bytedance.msdk.xt.cw cwVar2 : arrayList) {
                    cw.j(MediationConstant.TAG, up.j(v5) + "复用池回溯成功...........回溯到了P层广告_当前P层广告缓存池数量：" + xtVar.ae().size() + ",slotId：" + cwVar2.qa() + ",广告类型：" + cwVar2.ff() + ",loadSort=" + cwVar2.wi() + ",showSort=" + cwVar2.d() + ",CPM=" + cwVar2.t());
                }
                return;
            }
            if (cwVar.qe()) {
                xtVar.j(arrayList);
                for (com.bytedance.msdk.xt.cw cwVar3 : arrayList) {
                    cw.j(MediationConstant.TAG, up.j(v5) + "复用池回溯成功...........回溯到了普通层广告_当前普通广告缓存池数量：" + xtVar.tl().size() + ",slotId：" + cwVar3.qa() + ",广告类型：" + cwVar3.ff() + ",loadSort=" + cwVar3.wi() + ",showSort=" + cwVar3.d() + ",CPM=" + cwVar3.t());
                }
            }
        }
    }

    private static void j(String str, com.bytedance.msdk.xt.cw cwVar, String str2) {
        oq up = com.bytedance.msdk.core.up.j.j.j().up(str, str2);
        if (cwVar == null || up == null) {
            return;
        }
        cwVar.i(up.x());
        cwVar.av(up.ch());
        cwVar.az(up.ws());
        cwVar.az(up.mi());
        cwVar.j(up.v());
        cwVar.up(up.m());
    }
}
