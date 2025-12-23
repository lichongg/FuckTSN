package com.bytedance.msdk.core.up.j;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.api.r.qv;
import com.bytedance.msdk.core.oq.g;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.up.xt.ae;
import com.bytedance.msdk.cw.j.xt;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.la;
import com.bytedance.msdk.up.m;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.msdk.core.up.j {
    private static volatile j tl;

    /* renamed from: j, reason: collision with root package name */
    private final String[] f24725j = {MediationConstant.ADN_UNITY, MediationConstant.ADN_KS};
    private final Map<String, Integer> xt = new HashMap();
    private final Map<String, Integer> cw = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, CopyOnWriteArrayList<ae>> f24727r = new ConcurrentHashMap();
    private final Map<String, oq> up = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, String> f24726m = new HashMap();
    private final Map<String, Integer> ae = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Comparator<ae> f24724g = new Comparator<ae>() { // from class: com.bytedance.msdk.core.up.j.j.4
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(ae aeVar, ae aeVar2) {
            cw cwVar;
            if (aeVar == null || aeVar2 == null || (cwVar = aeVar.f24739j) == null || aeVar2.f24739j == null) {
                return 0;
            }
            return ((int) cwVar.sm()) - ((int) aeVar2.f24739j.sm());
        }
    };

    /* renamed from: com.bytedance.msdk.core.up.j.j$j, reason: collision with other inner class name */
    private class C0361j implements xt {
        private long ae = System.currentTimeMillis();
        private final com.bytedance.msdk.api.j.xt cw;

        /* renamed from: j, reason: collision with root package name */
        int f24736j;

        /* renamed from: m, reason: collision with root package name */
        private g f24737m;

        /* renamed from: r, reason: collision with root package name */
        private oq f24738r;
        private com.bytedance.msdk.cw.m.xt.xt up;

        @Override // com.bytedance.msdk.cw.j.xt
        public void j(cw cwVar, String str) {
        }

        C0361j(com.bytedance.msdk.api.j.xt xtVar, oq oqVar, com.bytedance.msdk.cw.m.xt.xt xtVar2, g gVar, int i6) {
            this.cw = xtVar;
            this.f24738r = oqVar;
            this.up = xtVar2;
            this.f24736j = i6;
            this.f24737m = gVar;
        }

        @Override // com.bytedance.msdk.cw.j.xt
        public void j(List<cw> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (cw cwVar : list) {
                if (cwVar != null) {
                    oq oqVar = this.f24738r;
                    com.bytedance.msdk.cw.tl.cw.j(cwVar, this.cw, this.up, this.f24737m, oqVar != null ? j.this.j(oqVar.w()) : "");
                    cwVar.j(SystemClock.elapsedRealtime());
                    arrayList.add(new ae(cwVar, 0L, this.cw));
                }
            }
            if (arrayList.size() > 0) {
                cw cwVar2 = ((ae) arrayList.get(0)).f24739j;
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告load成功 --- " + cwVar2.ff() + ", adType: " + com.bytedance.msdk.xt.j.j(cwVar2.om(), cwVar2.rh()) + ", adnSlotId: " + cwVar2.qa() + ", ad个数: " + arrayList.size());
                j.this.j(cwVar2.qa(), (List<ae>) arrayList, false);
            }
            m.j(list.get(0), 20000, "load success", System.currentTimeMillis() - this.ae, this.cw, this.f24736j, list.size(), 0, (String) null, -1L, -1L);
        }

        @Override // com.bytedance.msdk.cw.j.xt
        public void j(com.bytedance.msdk.api.j jVar) {
            if (jVar != null && this.f24738r != null) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告load失败 --- " + this.f24738r.i() + ", " + this.f24738r.w() + ", " + com.bytedance.msdk.xt.j.j(this.f24738r.jy(), this.f24738r.m()) + ", errCode: " + jVar.cw + ",msg=" + jVar.f24335r);
            }
            m.j(jVar, this.cw, this.f24738r, this.f24736j, 4, 1, j.j().j(this.f24738r.w()), System.currentTimeMillis() - this.ae, (String) null, (String) null, (String) null, 0L);
        }

        @Override // com.bytedance.msdk.cw.j.xt
        public void j(List<cw> list, com.bytedance.msdk.api.j jVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            for (cw cwVar : list) {
                oq oqVar = this.f24738r;
                com.bytedance.msdk.cw.tl.cw.j(cwVar, this.cw, this.up, this.f24737m, oqVar != null ? j.this.j(oqVar.w()) : "");
                cwVar.g(true);
            }
            cw cwVar2 = list.get(0);
            if (cwVar2 != null) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告cache成功 --- " + cwVar2.ff() + ", adType: " + com.bytedance.msdk.xt.j.j(cwVar2.om(), cwVar2.rh()) + ", adnSlotId: " + cwVar2.qa() + ", ad个数: " + list.size());
            }
            m.j(this.cw, cwVar2, this.f24738r);
        }
    }

    public void cw(String str, String str2, int i6) {
        this.xt.put(str + "_" + str2, Integer.valueOf(i6));
    }

    public boolean r(String str, String str2, int i6) {
        if (i6 == 2) {
            return false;
        }
        Integer num = this.xt.get(str + "_" + str2);
        return num != null && (num.intValue() == 1 || num.intValue() == 2);
    }

    public int up(String str, String str2, int i6) {
        if (i6 == 2) {
            return 0;
        }
        Integer num = this.xt.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void xt() {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.up.j.j.1
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                int i7;
                String str;
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用lowMemory，start clean");
                int i8 = 0;
                int i9 = 0;
                for (Map.Entry entry : j.this.f24727r.entrySet()) {
                    List<ae> list = (List) entry.getValue();
                    if (list != null && list.size() > 0) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理前, 缓存总数: " + list.size());
                        int i10 = 1;
                        int i11 = 0;
                        for (ae aeVar : list) {
                            if (aeVar != null && aeVar.f24739j != null) {
                                if (aeVar.r() != null) {
                                    str = aeVar.r().v();
                                    i7 = aeVar.r().a();
                                } else {
                                    i7 = i10;
                                    str = "";
                                }
                                if (aeVar.f24739j.qb() || !aeVar.f24739j.wq(str)) {
                                    list.remove(aeVar);
                                    i11++;
                                }
                                i10 = i7;
                            }
                        }
                        if (list.size() > i10) {
                            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理无效广告后仍需清理，缓存总数: " + list.size() + "，adCount: " + i10 + ", invalidCnt: " + i11);
                            i6 = 0;
                            for (ae aeVar2 : list) {
                                if (list.size() <= i10) {
                                    break;
                                }
                                list.remove(aeVar2);
                                i6++;
                            }
                        } else {
                            i6 = 0;
                        }
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理后，缓存总数: " + list.size() + ", adCount: " + i10 + ", invalidCnt: " + i11 + ", foceCleanCnt：" + i6);
                        i8 += i11;
                        i9 += i6;
                    }
                    l.j(i8, i9);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, List<ae>> xt(List<cw> list, String str, com.bytedance.msdk.api.j.xt xtVar, int i6, cw cwVar) {
        HashMap hashMap = new HashMap();
        for (cw cwVar2 : list) {
            if (cwVar2 != null && cwVar2 != cwVar) {
                cwVar2.j(false);
            }
            if (cwVar2 != null && cwVar2 != cwVar && up(str, cwVar2.qa(), i6) == 2 && cwVar2.wq(str) && !cwVar2.qb()) {
                List list2 = (List) hashMap.get(cwVar2.qa());
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new ae(cwVar2, 0L, xtVar));
                    hashMap.put(cwVar2.qa(), arrayList);
                } else {
                    list2.add(new ae(cwVar2, 0L, xtVar));
                }
            }
        }
        return hashMap;
    }

    public boolean cw(String str, String str2) {
        Integer num = this.cw.get(str + "_" + str2);
        return num != null && num.intValue() == 1;
    }

    public void m(String str, String str2, int i6) {
        this.cw.put(str + "_" + str2, Integer.valueOf(i6));
    }

    private j() {
    }

    public void r(String str, String str2) {
        this.f24726m.put(str, str2);
    }

    public oq up(String str, String str2) {
        return this.up.get(str + "_" + str2);
    }

    public static j j() {
        if (tl == null) {
            synchronized (j.class) {
                try {
                    if (tl == null) {
                        tl = new j();
                    }
                } finally {
                }
            }
        }
        return tl;
    }

    public void j(String str, String str2, oq oqVar, int i6) {
        if (oqVar != null) {
            this.up.put(str + "_" + str2, oqVar);
        }
        this.ae.put(str2, Integer.valueOf(i6));
    }

    private int xt(String str, com.bytedance.msdk.api.j.xt xtVar, boolean z5) {
        boolean z6;
        int i6;
        CopyOnWriteArrayList<ae> copyOnWriteArrayList = this.f24727r.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            String v5 = xtVar != null ? xtVar.v() : "";
            ArrayList arrayList = new ArrayList();
            ae aeVar = null;
            boolean z7 = false;
            for (ae aeVar2 : copyOnWriteArrayList) {
                Integer m6 = aeVar2.f24739j.m();
                int intValue = m6 != null ? m6.intValue() : 0;
                if (intValue == 4) {
                    z6 = j(v5, aeVar2.f24739j);
                } else {
                    z6 = intValue != 2;
                }
                if (!z6) {
                    if (com.bytedance.msdk.core.up.j.j(aeVar2.r(), xtVar, aeVar2.f24739j)) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:复用成功：--------" + aeVar2.f24739j.ff() + ", adSlotId: " + str);
                        z7 = true;
                    } else {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:AdSlot不符合 -------: " + aeVar2.f24739j.ff() + ", adSlotId: " + str);
                        i6 = 6;
                    }
                } else {
                    copyOnWriteArrayList.remove(aeVar2);
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:广告过期了 -------: " + aeVar2.f24739j.ff() + ", adSlotId: " + str);
                    i6 = 5;
                }
                if (aeVar == null) {
                    aeVar = aeVar2;
                }
                com.bytedance.msdk.core.up.xt.j jVar = new com.bytedance.msdk.core.up.xt.j();
                jVar.r(aeVar2.f24739j.wi());
                jVar.up(aeVar2.f24739j.d());
                jVar.xt(aeVar2.f24739j.qa());
                jVar.xt(i6);
                jVar.j(aeVar2.f24739j.qb() ? 1 : 0);
                arrayList.add(jVar);
            }
            if (z7) {
                return 3;
            }
            if (z5 && aeVar != null) {
                m.j(xtVar, aeVar.f24739j, j(arrayList));
            }
            return 2;
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    public String j(String str) {
        return this.f24726m.get(str);
    }

    public void j(final String str, final com.bytedance.msdk.api.j.xt xtVar, final Map<String, Object> map, final boolean z5, final qv qvVar, final g gVar, final Context context) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.up.j.j.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3;
                ae aeVar;
                List<ae> list = (List) j.this.f24727r.get(str);
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (ae aeVar2 : list) {
                        if (aeVar2 != null && aeVar2.f24739j.qb()) {
                            list.remove(aeVar2);
                            arrayList.add(aeVar2);
                        }
                    }
                }
                boolean z6 = false;
                if (com.bytedance.msdk.j.up.cw.xt()) {
                    if (arrayList.size() <= 0 || (aeVar = (ae) arrayList.get(0)) == null) {
                        str2 = "";
                        str3 = str2;
                    } else {
                        str3 = com.bytedance.msdk.xt.j.j(aeVar.f24739j.om(), aeVar.f24739j.rh());
                        str2 = aeVar.f24739j.ff();
                    }
                    StringBuilder sb = new StringBuilder("--==-- 广告复用:show时缓存移除 -----：");
                    sb.append(str2);
                    sb.append(", ");
                    sb.append(str3);
                    sb.append(", ");
                    sb.append(str);
                    sb.append(arrayList.size() > 0 ? ", size: " + arrayList.size() : "移除广告数为0");
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, sb.toString());
                }
                com.bytedance.msdk.api.j.xt xtVar2 = xtVar;
                String v5 = xtVar2 != null ? xtVar2.v() : "";
                com.bytedance.msdk.api.j.xt xtVar3 = xtVar;
                int f6 = xtVar3 != null ? xtVar3.f() : 0;
                com.bytedance.msdk.api.j.xt xtVar4 = xtVar;
                boolean z7 = xtVar4 == null || xtVar4.f() == 1;
                if (!com.bytedance.msdk.core.xt.xt().j(v5, str, f6) && z5) {
                    z6 = true;
                }
                if (!xtVar.sm() && z6 && !z7 && j.this.cw(v5, str)) {
                    j.this.j(str, xtVar, (Map<String, Object>) map, context, qvVar, gVar);
                    return;
                }
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，因为：已发起waterfall预加载，或feed多广告，或未开启adn预加载，或是banner轮播 --: " + str);
            }
        });
    }

    public void j(final List<cw> list, final String str, final com.bytedance.msdk.api.j.xt xtVar, final int i6, final cw cwVar) {
        if (list == null || list.isEmpty() || xtVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.up.j.j.3
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : j.this.xt(list, str, xtVar, i6, cwVar).entrySet()) {
                    String str2 = (String) entry.getKey();
                    List<ae> list2 = (List) entry.getValue();
                    if (!TextUtils.isEmpty(str2) && list2 != null && list2.size() > 0) {
                        j.this.j(str2, list2, true);
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用，show后放回复用池：adnSlotId:" + str2 + ", 个数：" + list2.size());
                    }
                }
            }
        });
    }

    public void j(String str, List<ae> list, boolean z5) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<ae> copyOnWriteArrayList = this.f24727r.get(str);
        if (copyOnWriteArrayList != null) {
            for (ae aeVar : list) {
                if (!j(copyOnWriteArrayList, aeVar)) {
                    copyOnWriteArrayList.add(aeVar);
                }
            }
        } else {
            this.f24727r.put(str, new CopyOnWriteArrayList<>(list));
        }
        if (z5) {
            la.j(this.f24727r.get(str), this.f24724g);
        }
    }

    private boolean j(List<ae> list, ae aeVar) {
        for (ae aeVar2 : list) {
            if (aeVar2 != null && aeVar != null && aeVar2.f24739j == aeVar.f24739j) {
                return true;
            }
        }
        return false;
    }

    public synchronized List<ae> j(String str, com.bytedance.msdk.api.j.xt xtVar, int i6) {
        try {
            CopyOnWriteArrayList<ae> copyOnWriteArrayList = this.f24727r.get(str);
            if (copyOnWriteArrayList == null) {
                return null;
            }
            int a6 = xtVar != null ? xtVar.a() : 1;
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            if (xtVar != null) {
                str2 = xtVar.v();
            }
            int up = up(str2, str, i6);
            if (up == 1) {
                for (int i7 = 0; arrayList.size() < a6 && i7 < copyOnWriteArrayList.size(); i7++) {
                    if (!copyOnWriteArrayList.get(i7).cw() && com.bytedance.msdk.core.up.j.j(copyOnWriteArrayList.get(i7).r(), xtVar, copyOnWriteArrayList.get(i7).f24739j)) {
                        arrayList.add(copyOnWriteArrayList.get(i7));
                    }
                }
                for (int i8 = 0; arrayList.size() < a6 && i8 < copyOnWriteArrayList.size(); i8++) {
                    if (copyOnWriteArrayList.get(i8).cw() && com.bytedance.msdk.core.up.j.j(copyOnWriteArrayList.get(i8).r(), xtVar, copyOnWriteArrayList.get(i8).f24739j)) {
                        arrayList.add(copyOnWriteArrayList.get(i8));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ae) it.next()).j(true);
                }
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 复用模式1，不从复用池移除，获取缓存: " + str + ", " + arrayList.size());
            } else if (up == 2) {
                for (ae aeVar : copyOnWriteArrayList) {
                    if (arrayList.size() >= a6) {
                        break;
                    }
                    if (aeVar.ae() && aeVar.f24739j != null) {
                        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- 复用模式2，广告：" + aeVar.xt() + "  adnName:" + aeVar.f24739j.zz() + " showSort:" + aeVar.f24739j.d() + " 暂不可用， 已经被使用中...");
                    }
                    if (com.bytedance.msdk.core.up.j.j(aeVar.r(), xtVar, aeVar.f24739j) && !aeVar.ae()) {
                        copyOnWriteArrayList.remove(aeVar);
                        arrayList.add(aeVar);
                    }
                }
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 复用模式2，从复用池移除，获取缓存: " + str + ", " + arrayList.size());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((ae) it2.next()).xt(true);
            }
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int j(String str, com.bytedance.msdk.api.j.xt xtVar, boolean z5) {
        String v5;
        if (xtVar != null) {
            try {
                v5 = xtVar.v();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            v5 = "";
        }
        if (xt(v5, str) == 0) {
            return xt(str, xtVar, z5);
        }
        CopyOnWriteArrayList<ae> copyOnWriteArrayList = this.f24727r.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            ae aeVar = null;
            ArrayList arrayList = z5 ? new ArrayList() : null;
            boolean z6 = false;
            for (ae aeVar2 : copyOnWriteArrayList) {
                int j6 = j(aeVar2, aeVar2.r(), xtVar, "广告复用");
                if (j6 == -1) {
                    z6 = true;
                } else {
                    if (j6 != 6) {
                        copyOnWriteArrayList.remove(aeVar2);
                    }
                    if (z5) {
                        if (aeVar == null) {
                            aeVar = aeVar2;
                        }
                        com.bytedance.msdk.core.up.xt.j jVar = new com.bytedance.msdk.core.up.xt.j();
                        jVar.r(aeVar2.f24739j.wi());
                        jVar.up(aeVar2.f24739j.d());
                        jVar.xt(aeVar2.f24739j.qa());
                        jVar.xt(j6);
                        jVar.j(aeVar2.f24739j.qb() ? 1 : 0);
                        arrayList.add(jVar);
                    }
                }
            }
            if (z6) {
                return 3;
            }
            if (z5 && aeVar != null) {
                m.j(xtVar, aeVar.f24739j, j(arrayList));
            }
            return 2;
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    private String j(List<com.bytedance.msdk.core.up.xt.j> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i6 = 0; i6 < list.size(); i6++) {
                sb.append(list.get(i6).j());
                if (i6 == list.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e6) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用：adCannotUseInfo json err: " + e6.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : "[]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, com.bytedance.msdk.api.j.xt xtVar, Map<String, Object> map, Context context, qv qvVar, g gVar) {
        String j6;
        if (xtVar == null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，adSlot为空 -------: " + str);
            return;
        }
        if (context == null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，context为null -------: " + str);
            return;
        }
        oq up = up(xtVar.v(), str);
        if (up != null) {
            try {
                j6 = com.bytedance.msdk.core.ae.cw.j(up.ae(), com.bytedance.msdk.core.ae.cw.j(up.az()), com.bytedance.msdk.xt.j.j(up.jy(), up.m()));
            } catch (Throwable th) {
                vl.j(th);
            }
            if (TextUtils.isEmpty(j6) && com.bytedance.msdk.core.ae.cw.xt(j6) && up != null) {
                for (String str2 : this.f24725j) {
                    if (TextUtils.equals(str2, up.az())) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，" + str2 + "为单例模式 -------: " + str);
                        return;
                    }
                }
                int intValue = this.ae.get(str) != null ? this.ae.get(str).intValue() : -1;
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求开始 -------: " + str);
                com.bytedance.msdk.cw.m.xt.xt j7 = com.bytedance.msdk.cw.m.xt.xt.j(up, (com.bytedance.msdk.cw.xt.xt.j) null);
                j7.cw(4);
                j7.xt(1);
                com.bytedance.msdk.cw.j.j j8 = com.bytedance.msdk.cw.tl.cw.j(j7, xtVar, new C0361j(xtVar, up, j7, gVar, intValue));
                if (j8 != null) {
                    if (!com.bytedance.msdk.core.tl.qv.j().cw(xtVar.v(), up.w())) {
                        com.bytedance.msdk.j.up.cw.j("TMe", "adn 代码位预请求触发次数拦截............");
                        Pair<String, String> j9 = com.bytedance.msdk.core.tl.qv.j().j(xtVar.v(), up.w());
                        if (j9 != null) {
                            com.bytedance.msdk.api.xt.xt xtVar2 = new com.bytedance.msdk.api.xt.xt(41041, com.bytedance.msdk.api.j.j(41041), (String) j9.second, (String) j9.first);
                            m.j(up, xtVar, j().j(up.w()), true, 2, intValue, 4, 1, (com.bytedance.msdk.api.j) xtVar2, -1L, false, false);
                            m.j(xtVar2, xtVar, up, intValue, 4, 1, j().j(up.w()), 0L, (String) null, (String) null, (String) null, 0L);
                            return;
                        }
                        return;
                    }
                    m.j(up, xtVar, j().j(up.w()), j7.up(), 3, j7.cw(), 4, 1, (com.bytedance.msdk.api.j) null, j7.r(), false, false);
                    j8.j(context, j7, xtVar, com.bytedance.msdk.cw.tl.cw.j(j7, xtVar, map));
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求已发完 -------: " + str);
                    return;
                }
                m.j(up, xtVar, 4, 1);
                return;
            }
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: " + j6 + ", wfcBean: " + up + ", adnSlotId: " + str);
        }
        j6 = null;
        if (TextUtils.isEmpty(j6)) {
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: " + j6 + ", wfcBean: " + up + ", adnSlotId: " + str);
    }
}
