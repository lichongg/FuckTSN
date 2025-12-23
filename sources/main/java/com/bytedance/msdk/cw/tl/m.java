package com.bytedance.msdk.cw.tl;

import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.tl.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    public static boolean cw(int i6) {
        return i6 == -100;
    }

    public static boolean j(int i6) {
        return i6 >= -299 && i6 < -100;
    }

    public static boolean xt(int i6) {
        return i6 == 0;
    }

    public static List<oq> cw(List<oq> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (oq oqVar : list) {
            if (oqVar != null && (oqVar.mi() == 1 || oqVar.mi() == 3)) {
                arrayList.add(oqVar);
            }
        }
        return arrayList;
    }

    public static boolean j(int i6, List<Integer> list) {
        if (p.j(list) || i6 >= list.size() || list.get(i6).intValue() <= 0) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (list.get(i7).intValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static List<oq> xt(List<oq> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (oq oqVar : list) {
            if (oqVar != null && oqVar.mi() == 0) {
                arrayList.add(oqVar);
            }
        }
        return arrayList;
    }

    public static int j(com.bytedance.msdk.core.oq.xt xtVar, oq oqVar) {
        if (xtVar == null || oqVar == null) {
            return -999;
        }
        if (xtVar.qv() && oqVar.uf()) {
            return oqVar.ch();
        }
        return oqVar.x();
    }

    public static int j(com.bytedance.msdk.core.oq.xt xtVar, com.bytedance.msdk.xt.cw cwVar) {
        if (xtVar == null || cwVar == null) {
            return -999;
        }
        if (xtVar.qv() && cwVar.qe()) {
            return cwVar.d();
        }
        return cwVar.wi();
    }

    public static Map<Integer, List<oq>> j(List<oq> list, boolean z5) {
        int x5;
        HashMap hashMap = new HashMap();
        if (!p.j(list)) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                oq oqVar = list.get(i6);
                if (oqVar != null) {
                    if (z5 && oqVar.uf()) {
                        x5 = oqVar.ch();
                    } else {
                        x5 = oqVar.x();
                    }
                    List list2 = (List) hashMap.get(Integer.valueOf(x5));
                    if (list2 == null) {
                        list2 = new ArrayList();
                    }
                    list2.add(oqVar);
                    hashMap.put(Integer.valueOf(x5), list2);
                }
            }
        }
        return hashMap;
    }

    public static List<oq> j(List<oq> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (oq oqVar : list) {
            if (oqVar != null && oqVar.mi() == 100) {
                arrayList.add(oqVar);
            }
        }
        return arrayList;
    }
}
