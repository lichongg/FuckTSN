package com.bytedance.msdk.core.r;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, C0360j> f24682j = new ConcurrentHashMap();

    public static void j(com.bytedance.msdk.api.j.xt xtVar, oq oqVar, Map<String, Object> map) {
        C0360j c0360j;
        if (xtVar == null || oqVar == null || map == null || !oqVar.la() || !"baidu".equals(oqVar.az()) || (c0360j = f24682j.get(xtVar.v())) == null) {
            return;
        }
        map.put(MediationConstant.BIDDING_WIN_ADN, c0360j.f24683j);
        map.put(MediationConstant.BIDDING_WIN_PRICE, Double.valueOf(c0360j.cw));
        boolean xq = com.bytedance.msdk.core.xt.xt().xq();
        map.put(MediationConstant.BIDDING_IS_OPEN_ECPM, Boolean.valueOf(xq));
        if (xq) {
            map.put(MediationConstant.BIDDING_REQUEST_ID_MAP, c0360j.f24684r);
            map.put(MediationConstant.BIDDING_WIN_ADN_ID, c0360j.xt);
        }
    }

    /* renamed from: com.bytedance.msdk.core.r.j$j, reason: collision with other inner class name */
    static class C0360j {
        double cw;

        /* renamed from: j, reason: collision with root package name */
        String f24683j;

        /* renamed from: r, reason: collision with root package name */
        Map<String, String> f24684r;
        String xt;

        public C0360j(String str, String str2, double d6, Map<String, String> map) {
            this.f24683j = str2;
            this.cw = d6;
            this.f24684r = map;
            this.xt = str;
        }
    }

    public static void j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.core.oq.xt xtVar2, List<com.bytedance.msdk.xt.cw> list, List<com.bytedance.msdk.xt.cw> list2) {
        HashMap hashMap;
        com.bytedance.msdk.xt.cw cwVar;
        if (xtVar == null || xtVar2 == null || list == null || list.size() == 0 || !xtVar.ed() || !j(xtVar2)) {
            return;
        }
        Iterator<com.bytedance.msdk.xt.cw> it = list.iterator();
        while (true) {
            hashMap = null;
            if (!it.hasNext()) {
                cwVar = null;
                break;
            }
            cwVar = it.next();
            if (cwVar != null && "baidu".equals(cwVar.ff())) {
                break;
            }
        }
        if (cwVar == null) {
            cwVar = list.get(0);
        }
        if (cwVar != null) {
            if (com.bytedance.msdk.core.xt.xt().xq() && (list2 != null || list2.size() != 0)) {
                hashMap = new HashMap();
                for (com.bytedance.msdk.xt.cw cwVar2 : list2) {
                    hashMap.put(cwVar2.qa(), cwVar2.o());
                }
            }
            f24682j.put(xtVar2.rn(), new C0360j(cwVar.qa(), cwVar.ff(), cwVar.t(), hashMap));
        }
    }

    private static boolean j(com.bytedance.msdk.core.oq.xt xtVar) {
        if (xtVar == null) {
            return false;
        }
        for (oq oqVar : xtVar.ol()) {
            if (TextUtils.equals(oqVar.az(), "baidu") && oqVar.la()) {
                return true;
            }
        }
        return false;
    }
}
