package com.bytedance.msdk.cw.up;

import android.text.TextUtils;
import com.bytedance.msdk.api.j.xt;
import com.bytedance.msdk.core.up.xt.ae;
import com.bytedance.msdk.tl.la;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.openadsdk.i.cw.cw.xt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private static volatile j xt;

    /* renamed from: j, reason: collision with root package name */
    private final Map<Integer, CopyOnWriteArrayList<ae>> f25129j = new ConcurrentHashMap();
    private final Comparator<ae> cw = new Comparator<ae>() { // from class: com.bytedance.msdk.cw.up.j.1
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(ae aeVar, ae aeVar2) {
            cw cwVar;
            if (aeVar != null && aeVar2 != null && (cwVar = aeVar.f24739j) != null && aeVar2.f24739j != null) {
                if (cwVar.t() > aeVar2.f24739j.t()) {
                    return -1;
                }
                if (aeVar.f24739j.t() < aeVar2.f24739j.t()) {
                    return 1;
                }
                if (aeVar.f24739j.t() == aeVar2.f24739j.t() && aeVar.f24739j.pz() == 1) {
                    return -1;
                }
            }
            return 0;
        }
    };

    public static j j() {
        if (xt == null) {
            synchronized (com.bytedance.msdk.core.up.j.j.class) {
                try {
                    if (xt == null) {
                        xt = new j();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    private j() {
    }

    private static boolean xt(List<cw> list, cw cwVar) {
        for (cw cwVar2 : list) {
            if (cwVar != null && cwVar2 == cwVar) {
                return true;
            }
        }
        return false;
    }

    public synchronized void j(xt xtVar, List<cw> list) {
        try {
            if (com.bytedance.msdk.core.xt.xt().m()) {
                if (xtVar == null) {
                    return;
                }
                if (xtVar.sm()) {
                    return;
                }
                StringBuilder sb = new StringBuilder("广告位：");
                sb.append(xtVar.v());
                sb.append("  type:");
                sb.append(xtVar.f());
                sb.append(" show后把二价广告放入公共缓存池 数量：");
                sb.append(list == null ? "没有二价" : Integer.valueOf(list.size()));
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, sb.toString());
                if (list != null && !list.isEmpty()) {
                    CopyOnWriteArrayList<ae> copyOnWriteArrayList = this.f25129j.get(Integer.valueOf(xtVar.f()));
                    if (copyOnWriteArrayList == null) {
                        copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    }
                    for (cw cwVar : list) {
                        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "广告位：" + xtVar.v() + "  代码位：" + cwVar.qa() + "   adnName:" + cwVar.zz() + "  loadSort:" + cwVar.wi() + "  showSort:" + cwVar.d() + "  ecpm:" + cwVar.t());
                        if (!j(copyOnWriteArrayList, cwVar)) {
                            copyOnWriteArrayList.add(new ae(cwVar, 0L, xtVar));
                        }
                    }
                    Iterator<ae> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ae next = it.next();
                        if (!next.up()) {
                            copyOnWriteArrayList.remove(next);
                        }
                    }
                    la.j(copyOnWriteArrayList, this.cw);
                    while (3 < copyOnWriteArrayList.size()) {
                        copyOnWriteArrayList.remove(3);
                    }
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "广告位：" + xtVar.v() + "  type:" + xtVar.f() + "  公共缓存池二价广告的数量：" + copyOnWriteArrayList.size());
                    this.f25129j.put(Integer.valueOf(xtVar.f()), copyOnWriteArrayList);
                }
            }
        } finally {
        }
    }

    public synchronized List<ae> j(xt xtVar) {
        if (xtVar == null) {
            return null;
        }
        try {
            CopyOnWriteArrayList<ae> copyOnWriteArrayList = this.f25129j.get(Integer.valueOf(xtVar.f()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                int a6 = xtVar.f() == 5 ? xtVar.a() : 1;
                ArrayList arrayList = new ArrayList();
                for (ae aeVar : copyOnWriteArrayList) {
                    if (arrayList.size() >= a6) {
                        break;
                    }
                    if (aeVar.ae() && aeVar.f24739j != null) {
                        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- 公共缓存池，广告：" + aeVar.xt() + "  adnName:" + aeVar.f24739j.zz() + " showSort:" + aeVar.f24739j.d() + " 暂不可用， 已经被使用中...");
                    }
                    if (j(xtVar, aeVar.r()) && aeVar.up() && !aeVar.ae()) {
                        arrayList.add(aeVar);
                        copyOnWriteArrayList.remove(aeVar);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ae) it.next()).xt(true);
                }
                return arrayList;
            }
            return null;
        } finally {
        }
    }

    public static List<cw> j(xt xtVar, List<cw> list, List<cw> list2) {
        if (!com.bytedance.msdk.core.xt.xt().m() || xtVar == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int a6 = xtVar.f() == 5 ? xtVar.a() : 1;
        ArrayList arrayList = new ArrayList();
        for (cw cwVar : list2) {
            if (!xt(list, cwVar)) {
                if (arrayList.size() >= a6) {
                    break;
                }
                if (!cwVar.dj() && !cwVar.qo() && (!cwVar.qe() || cwVar.t() > 0.0d)) {
                    arrayList.add(cwVar);
                }
            }
        }
        return arrayList;
    }

    private boolean j(List<ae> list, cw cwVar) {
        for (ae aeVar : list) {
            if (aeVar != null && cwVar != null && aeVar.f24739j == cwVar) {
                return true;
            }
        }
        return false;
    }

    private boolean j(xt xtVar, xt xtVar2) {
        if (xtVar == null || xtVar2 == null || xtVar.f() != xtVar2.f()) {
            return false;
        }
        if ((xtVar.f() == 7 || xtVar.f() == 10) && xtVar.rn() == xtVar2.rn()) {
            return true;
        }
        return (xtVar.f() == 1 || xtVar.f() == 5) && xtVar.ch() == xtVar2.ch() && xtVar.s() == xtVar2.s();
    }

    public static void j(xt xtVar, String str) {
        if (TextUtils.isEmpty(str) || xtVar == null) {
            return;
        }
        if (TextUtils.isEmpty(xtVar.vl())) {
            xtVar.cw(xtVar.v());
        }
        if (str.equals(xtVar.v())) {
            return;
        }
        xt.j jVar = new xt.j(new com.bytedance.sdk.openadsdk.i.cw.cw.xt(xtVar.gx()));
        jVar.r(str);
        xtVar.j(com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j(jVar.j()));
    }
}
