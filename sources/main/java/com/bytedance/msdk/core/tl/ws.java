package com.bytedance.msdk.core.tl;

import android.text.TextUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws {

    /* renamed from: j, reason: collision with root package name */
    private static volatile ws f24721j;
    private Map<String, ConcurrentHashMap<String, j>> cw = new ConcurrentHashMap();
    private Map<String, List<xt>> xt;

    public static ws j() {
        if (f24721j == null) {
            synchronized (ws.class) {
                try {
                    if (f24721j == null) {
                        f24721j = new ws();
                    }
                } finally {
                }
            }
        }
        return f24721j;
    }

    private ws() {
    }

    public void j(ConcurrentHashMap<String, List<xt>> concurrentHashMap) {
        this.xt = concurrentHashMap;
        if (concurrentHashMap == null) {
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap is null ");
            return;
        }
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap = " + this.xt);
    }

    public void j(String str, String str2, String str3, String str4) {
        List<xt> list;
        xt xtVar;
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level adnName = " + str2 + " slotId = " + str3 + " error = " + str4);
        Map<String, List<xt>> map = this.xt;
        if (map == null || (list = map.get(str2)) == null || list.size() == 0) {
            return;
        }
        Iterator<xt> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                xtVar = it.next();
                if (xtVar.cw().contains(str)) {
                    break;
                }
            } else {
                xtVar = null;
                break;
            }
        }
        if (xtVar != null) {
            for (String str5 : xtVar.xt()) {
                if (TextUtils.equals(str5, str4)) {
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "setAdnError rit_level 命中errorCode = ".concat(String.valueOf(str5)));
                    long j6 = xtVar.j() + new Date().getTime();
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level 更新时间 = " + m.xt(j6));
                    j jVar = new j(str2, str3, j6, str4);
                    Map<String, ConcurrentHashMap<String, j>> map2 = this.cw;
                    if (map2 != null) {
                        ConcurrentHashMap<String, j> concurrentHashMap = map2.get(str2);
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap<>();
                        }
                        concurrentHashMap.put(str + "_" + str3, jVar);
                        this.cw.put(str2, concurrentHashMap);
                        StringBuilder sb = new StringBuilder("setRitAdnError rit_level mAdnControlMap = ");
                        sb.append(this.cw);
                        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", sb.toString());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public com.bytedance.msdk.api.j j(String str, String str2, String str3) {
        j jVar;
        ConcurrentHashMap<String, j> concurrentHashMap;
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level adnName = " + str2 + " slotId = " + str3 + " primeRit = " + str);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Map<String, ConcurrentHashMap<String, j>> map = this.cw;
            if (map == null || (concurrentHashMap = map.get(str2)) == null) {
                jVar = null;
            } else {
                jVar = concurrentHashMap.get(str + "_" + str3);
                com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 取出的showBean = ".concat(String.valueOf(jVar)));
            }
            if (jVar != null && jVar.j() != 0) {
                long time = new Date().getTime();
                if (time <= jVar.j()) {
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 当前时间 = " + m.xt(time));
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 规则有效时间 = " + m.xt(jVar.j()));
                    return new com.bytedance.msdk.api.xt.j(40064, com.bytedance.msdk.api.j.j(40064) + ", " + jVar.xt());
                }
            }
        }
        return null;
    }

    public boolean j(String str, String str2) {
        Map<String, List<xt>> map;
        List<xt> list;
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_RitAdnShowControl", "hasRitAdnConfig rit_level adnName = " + str2 + " primeRit = " + str);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (map = this.xt) != null && map.size() != 0 && (list = this.xt.get(str2)) != null && list.size() != 0) {
            Iterator<xt> it = list.iterator();
            while (it.hasNext()) {
                List<String> cw = it.next().cw();
                if (cw != null && cw.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
