package com.bytedance.msdk.cw.ae;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.oq.xt;
import com.bytedance.msdk.j.up.up;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static void j(xt xtVar, com.bytedance.msdk.cw.m.j.xt xtVar2, List<oq> list) {
        if (xtVar == null || xtVar2 == null || list == null || list.size() == 0) {
            return;
        }
        Iterator<cw> it = xtVar2.tl().iterator();
        while (it.hasNext()) {
            cw next = it.next();
            Iterator<oq> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, up.j(xtVar) + "已经响应的广告: " + next.qa() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                    xtVar2.tl().remove(next);
                    xtVar2.g().add(next);
                    break;
                }
                oq next2 = it2.next();
                if (next == null || next2 == null || !next.qa().equals(next2.w())) {
                }
            }
        }
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, up.j(xtVar) + "已经响应的广告被serverBidding过滤完还剩: " + xtVar2.tl().size());
    }

    public static boolean j(com.bytedance.msdk.cw.m.j.j jVar, List<oq> list, String str) {
        if (list == null || jVar == null || TextUtils.isEmpty(str) || jVar.xt() != 1) {
            return false;
        }
        Iterator<oq> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().w())) {
                return false;
            }
        }
        return true;
    }
}
