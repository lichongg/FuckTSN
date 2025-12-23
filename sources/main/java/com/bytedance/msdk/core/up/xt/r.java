package com.bytedance.msdk.core.up.xt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.r.jy;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.tl.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends com.bytedance.msdk.core.up.j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile r f24744j;
    private int jy;
    private List<String> qv;
    private int vl;
    private final Map<String, Integer> xt = new HashMap();
    private final Map<String, Long> cw = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, com.bytedance.msdk.api.j.xt> f24747r = new HashMap();
    private final Map<String, ConcurrentHashMap<String, List<ae>>> up = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, Map<String, com.bytedance.msdk.api.j>> f24746m = new HashMap();
    private final Map<String, Boolean> ae = new HashMap();
    private final Map<String, com.bytedance.msdk.core.up.xt.xt> tl = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private boolean f24745g = false;
    private int oq = 20;

    public interface cw {
        void j(String str, boolean z5, int i6, List<com.bytedance.msdk.xt.cw> list);
    }

    private class j {
        private int ae;
        private final int cw;

        /* renamed from: m, reason: collision with root package name */
        private final xt f24756m;

        /* renamed from: r, reason: collision with root package name */
        private final int f24757r;
        private int tl;
        private final List<jy> up;
        private final Activity xt;

        j(Activity activity, List<jy> list, int i6, int i7, xt xtVar) {
            this.xt = activity;
            this.up = list;
            this.cw = i6;
            this.f24757r = i7;
            this.f24756m = xtVar;
            this.ae = list.size();
            this.tl = list.size();
        }

        static /* synthetic */ int cw(j jVar) {
            int i6 = jVar.tl;
            jVar.tl = i6 - 1;
            return i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            jy remove;
            for (int i6 = 0; i6 < this.cw; i6++) {
                if (this.up.size() > 0 && (remove = this.up.remove(0)) != null) {
                    com.bytedance.msdk.api.j.xt j6 = remove.j();
                    String str = remove.xt().get(0);
                    if (j6 == null) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为空，广告位：".concat(String.valueOf(str)));
                    } else if (j6.f() == 1) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为banner类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                    } else if (j6.f() == 2) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为插屏类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                    } else if (j6.f() == 9) {
                        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为Draw类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                    } else {
                        r.this.j(str, j6);
                        j6.r(str);
                        com.bytedance.msdk.core.oq.xt j7 = com.bytedance.msdk.ae.j.cw.j().j(str, 0, 101);
                        if (j7 != null) {
                            j6.g(j7.wq());
                        } else if (j6.f() == 8) {
                            j6.g(10);
                        }
                        r.this.j(this.xt, str, 5, 0, new cw() { // from class: com.bytedance.msdk.core.up.xt.r.j.1
                            @Override // com.bytedance.msdk.core.up.xt.r.cw
                            public void j(String str2, boolean z5, int i7, List<com.bytedance.msdk.xt.cw> list) {
                                j.xt(j.this);
                                if (!z5) {
                                    j.cw(j.this);
                                }
                                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- pendingLoadNum: " + j.this.ae);
                                if (j.this.ae > 0 || j.this.f24756m == null) {
                                    return;
                                }
                                j.this.f24756m.j(j.this.tl <= 0);
                            }
                        });
                    }
                }
            }
            if (this.up.size() > 0) {
                com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.up.xt.r.j.2
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.j();
                    }
                }, this.f24757r * 1000);
            }
        }

        static /* synthetic */ int xt(j jVar) {
            int i6 = jVar.ae;
            jVar.ae = i6 - 1;
            return i6;
        }
    }

    public interface xt {
        void j(boolean z5);
    }

    private static void m(String str) {
        l j6 = l.j((String) null, com.bytedance.msdk.core.xt.getContext());
        String xt2 = j6.xt("preload_rit_ts");
        try {
            JSONObject jSONObject = TextUtils.isEmpty(xt2) ? new JSONObject() : new JSONObject(xt2);
            jSONObject.put(str, System.currentTimeMillis());
            j6.j("preload_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public static long up(String str) {
        String xt2 = l.j((String) null, com.bytedance.msdk.core.xt.getContext()).xt("preload_rit_ts");
        try {
            if (!TextUtils.isEmpty(xt2)) {
                return new JSONObject(xt2).optLong(str, -1L);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        return -1L;
    }

    public List<ae> r(String str) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, List<ae>> concurrentHashMap = this.up.get(str);
        if (concurrentHashMap != null) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                List<ae> list = concurrentHashMap.get(it.next());
                if (list != null && list.size() > 0) {
                    arrayList.addAll(list);
                }
            }
        }
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        Map<String, com.bytedance.msdk.api.j> map = this.f24746m.get(str);
        if (map != null) {
            map.clear();
        }
        return arrayList;
    }

    public boolean cw(String str, int i6) {
        int xt2 = xt(str, i6);
        return xt2 == 2 || xt2 == 3 || xt2 == 4;
    }

    private r() {
    }

    public com.bytedance.msdk.core.up.xt.xt cw(String str) {
        return this.tl.get(str);
    }

    private void cw(String str, com.bytedance.msdk.api.j.xt xtVar) {
        ConcurrentHashMap<String, List<ae>> concurrentHashMap = this.up.get(str);
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                List<ae> list = concurrentHashMap.get(str2);
                if (list != null && list.size() > 0 && list.get(0) != null) {
                    ae aeVar = list.get(0);
                    if (j(aeVar, aeVar.r(), xtVar, "聚合预缓存") != -1) {
                        concurrentHashMap.remove(str2);
                    }
                }
            }
        }
    }

    public int xt(String str, int i6) {
        Integer num;
        if (i6 == 2 || (num = this.xt.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public static r j() {
        if (f24744j == null) {
            synchronized (r.class) {
                try {
                    if (f24744j == null) {
                        f24744j = new r();
                    }
                } finally {
                }
            }
        }
        return f24744j;
    }

    public com.bytedance.msdk.api.j.xt xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f24747r.get(str);
    }

    public double xt(String str, com.bytedance.msdk.api.j.xt xtVar) {
        String key;
        List<ae> list;
        ConcurrentHashMap<String, List<ae>> concurrentHashMap = this.up.get(str);
        double d6 = -1.0d;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, List<ae>> entry : concurrentHashMap.entrySet()) {
                if (entry != null && (key = entry.getKey()) != null && (list = concurrentHashMap.get(key)) != null && list.size() > 0) {
                    for (ae aeVar : list) {
                        if (aeVar != null && j(aeVar, aeVar.r(), xtVar, "聚合预缓存-ra") == -1 && aeVar.f24739j.t() > d6) {
                            d6 = aeVar.f24739j.t();
                        }
                    }
                }
            }
        }
        return d6;
    }

    public int r() {
        return this.jy;
    }

    public int cw() {
        return this.vl;
    }

    public void j(String str, int i6) {
        this.xt.put(str, Integer.valueOf(i6));
    }

    public void j(String str, long j6) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.cw.put(str, Long.valueOf(j6));
    }

    public Long j(String str) {
        return this.cw.get(str);
    }

    public void j(String str, com.bytedance.msdk.api.j.xt xtVar) {
        if (xtVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24747r.put(str, xtVar);
    }

    public void j(String str, ae aeVar) {
        if (j(str) == null || j(str).longValue() == aeVar.j()) {
            ConcurrentHashMap<String, List<ae>> concurrentHashMap = this.up.get(str);
            String qa = aeVar.f24739j.qa();
            if (TextUtils.isEmpty(qa)) {
                return;
            }
            if (concurrentHashMap == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(aeVar);
                ConcurrentHashMap<String, List<ae>> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(qa, copyOnWriteArrayList);
                this.up.put(str, concurrentHashMap2);
                return;
            }
            List<ae> list = concurrentHashMap.get(qa);
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                copyOnWriteArrayList2.add(aeVar);
                concurrentHashMap.put(qa, copyOnWriteArrayList2);
                return;
            }
            list.add(aeVar);
        }
    }

    public void xt(final Context context, final String str, final int i6) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.up.xt.r.2
            @Override // java.lang.Runnable
            public void run() {
                r.this.j(context, str, 4, i6, (cw) null);
            }
        });
    }

    public List<String> xt() {
        return this.qv;
    }

    public boolean j(String str, com.bytedance.msdk.api.j.xt xtVar, String str2) {
        boolean z5;
        this.ae.put(str, Boolean.FALSE);
        com.bytedance.msdk.core.up.xt.xt xtVar2 = this.tl.get(str);
        if (xtVar2 == null) {
            return false;
        }
        List<oq> xt2 = xtVar2.xt();
        if (com.bytedance.msdk.j.up.cw.xt()) {
            for (oq oqVar : xt2) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "waterfall: " + oqVar.az() + ", loadSort: " + oqVar.x() + ", showSort: " + oqVar.ch() + ", eCpm: " + oqVar.v());
            }
        }
        boolean[] zArr = {true};
        String j6 = j(xt2, str, xtVar, xtVar2, zArr);
        cw(str, xtVar);
        ConcurrentHashMap<String, List<ae>> concurrentHashMap = this.up.get(str);
        if (concurrentHashMap != null) {
            for (int i6 = 0; i6 < xt2.size(); i6++) {
                List<ae> list = concurrentHashMap.get(xt2.get(i6).w());
                if (list != null && list.size() > 0) {
                    z5 = true;
                    break;
                }
            }
        }
        z5 = false;
        if (j6 != null) {
            if (z5) {
                com.bytedance.msdk.up.m.j(this.f24747r.get(str), j6);
                return z5;
            }
            xtVar.xt(3);
            if (zArr[0]) {
                xtVar.xt(1);
            }
            com.bytedance.msdk.up.m.j(xtVar, j6);
        }
        return z5;
    }

    private String j(List<oq> list, String str, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.core.up.xt.xt xtVar2, boolean[] zArr) {
        List<ae> list2;
        if (list.size() <= 0) {
            return null;
        }
        ConcurrentHashMap<String, List<ae>> concurrentHashMap = this.up.get(str);
        if (concurrentHashMap != null && (list2 = concurrentHashMap.get(list.get(0).w())) != null && list2.size() > 0 && list2.get(0) != null) {
            ae aeVar = list2.get(0);
            if (j(aeVar, aeVar.r(), xtVar, "聚合预请求") == -1) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "--==-- 命中最优广告： " + aeVar.f24739j.ff() + ", loadSort: " + aeVar.f24739j.wi() + ", showSort: " + aeVar.f24739j.d());
                return null;
            }
        }
        List<com.bytedance.msdk.core.up.xt.j> j6 = j(list, str, concurrentHashMap, xtVar, xtVar2, zArr);
        if (j6.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i6 = 0; i6 < j6.size(); i6++) {
                sb.append(j6.get(i6).j());
                if (i6 == j6.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                String jSONArray = new JSONArray(sb.toString()).toString();
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "adCannotUseInfo: " + jSONArray);
                return jSONArray;
            } catch (JSONException e6) {
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "adCannotUseInfo json err: " + e6.getMessage());
            }
        }
        return null;
    }

    private List<com.bytedance.msdk.core.up.xt.j> j(List<oq> list, String str, Map<String, List<ae>> map, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.core.up.xt.xt xtVar2, boolean[] zArr) {
        com.bytedance.msdk.xt.cw cwVar;
        List<ae> list2;
        ArrayList arrayList = new ArrayList();
        int e_ = xtVar2.e_();
        for (int i6 = 0; i6 < list.size() && i6 < e_; i6++) {
            String w5 = list.get(i6).w();
            com.bytedance.msdk.core.up.xt.j jVar = new com.bytedance.msdk.core.up.xt.j();
            jVar.xt(w5);
            jVar.up(list.get(i6).ch());
            jVar.r(list.get(i6).x());
            ae aeVar = (map == null || (list2 = map.get(w5)) == null || list2.size() <= 0) ? null : list2.get(0);
            if (aeVar != null && (cwVar = aeVar.f24739j) != null) {
                jVar.j(cwVar.qb() ? 1 : 0);
                zArr[0] = false;
                int j6 = j(aeVar, this.f24747r.get(str), xtVar, "预缓存");
                if (j6 != -1) {
                    jVar.xt(j6);
                    arrayList.add(jVar);
                }
            } else {
                Map<String, com.bytedance.msdk.api.j> map2 = this.f24746m.get(str);
                com.bytedance.msdk.api.j jVar2 = map2 != null ? map2.get(w5) : null;
                if (jVar2 != null) {
                    jVar.xt(3);
                    jVar.cw(jVar2.cw);
                    jVar.j(jVar2.f24335r);
                } else {
                    jVar.xt(4);
                }
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    public void j(final Context context, final String str, final int i6) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.up.xt.r.1
            @Override // java.lang.Runnable
            public void run() {
                r.this.j(context, str, 2, i6, (cw) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, String str, int i6, int i7, cw cwVar) {
        int xt2 = xt(str, i7);
        if (!cw(str, i7)) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "--==-- 配置未开启预加载缓存，req_type: " + xt2);
            if (cwVar != null) {
                cwVar.j(str, false, 0, null);
                return;
            }
            return;
        }
        Boolean bool = this.ae.get(str);
        if (bool != null && bool.booleanValue()) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "--==-- 已发起过预缓存，还未使用掉，此次不发起");
            if (cwVar != null) {
                cwVar.j(str, true, 0, null);
                return;
            }
            return;
        }
        com.bytedance.msdk.api.j.xt xtVar = this.f24747r.get(str);
        if (xtVar == null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "--==-- 预缓存取消，adslot为null，rit：" + str);
            return;
        }
        com.bytedance.msdk.api.j.xt xtVar2 = new com.bytedance.msdk.api.j.xt(xtVar);
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(str) + "--==-- 预缓存开始请求, req_type: " + xt2);
        com.bytedance.msdk.core.up.xt.xt j6 = up.j(context, str, xtVar2.f());
        this.tl.put(str, j6);
        this.ae.put(str, Boolean.TRUE);
        xtVar2.r(str);
        xtVar2.xt(i6);
        xtVar2.m(3);
        j6.j(context, xtVar2, cwVar);
        m(str);
    }

    public void j(int i6) {
        this.oq = i6;
    }

    public void j(final Activity activity, final List<jy> list, final int i6, final int i7) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.up.xt.r.3
            @Override // java.lang.Runnable
            public void run() {
                if (r.this.f24745g) {
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "注意：预加载preload只能调用一次");
                    return;
                }
                if (activity == null) {
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "预加载preload传入的activity不能是null");
                    return;
                }
                List list2 = list;
                if (list2 == null || list2.size() <= 0) {
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "预加载preload传入的requestInfos不能是null或者size为0");
                    return;
                }
                r.this.f24745g = true;
                r.this.vl = i6;
                r.this.jy = i7;
                r.this.qv = new ArrayList();
                for (jy jyVar : list) {
                    if (jyVar != null && jyVar.xt() != null) {
                        r.this.qv.addAll(jyVar.xt());
                    }
                }
                int i8 = i6;
                int i9 = (i8 <= 0 || i8 > 20) ? 2 : i8;
                int i10 = i7;
                int i11 = (i10 <= 0 || i10 > 10) ? 2 : i10;
                List j6 = r.this.j((List<jy>) list);
                if (j6.isEmpty()) {
                    return;
                }
                r.this.new j(activity, j6, i9, i11, new xt() { // from class: com.bytedance.msdk.core.up.xt.r.3.1
                    @Override // com.bytedance.msdk.core.up.xt.r.xt
                    public void j(boolean z5) {
                        if (z5) {
                            return;
                        }
                        com.bytedance.msdk.core.g.up.r().j(r.this.up);
                    }
                }).j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<jy> j(List<jy> list) {
        ArrayList arrayList = new ArrayList();
        int i6 = this.oq;
        HashSet hashSet = new HashSet();
        for (jy jyVar : list) {
            if (arrayList.size() >= i6) {
                break;
            }
            if (jyVar != null && jyVar.xt() != null) {
                for (String str : jyVar.xt()) {
                    if (arrayList.size() < i6) {
                        if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                            hashSet.add(str);
                            ArrayList arrayList2 = new ArrayList(1);
                            arrayList2.add(str);
                            arrayList.add(new jy(jyVar.j(), arrayList2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void j(Context context, String str, int i6, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.xt.cw cwVar, cw cwVar2) {
        com.bytedance.msdk.core.up.xt.cw j6 = m.j(i6, context, str, xtVar == null ? 0 : xtVar.f());
        if (j6 != null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 预缓存补充请求发起 reqType: " + i6);
            j6.j(xtVar, cwVar, cwVar2);
        }
    }
}
