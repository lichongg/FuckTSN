package com.bytedance.msdk.core.tl;

import android.text.TextUtils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private Map<String, xt> f24697j;
    private Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.tl.j>> xt;

    /* renamed from: com.bytedance.msdk.core.tl.cw$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static cw f24698j = new cw(null);
    }

    /* synthetic */ cw(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static cw j() {
        return j.f24698j;
    }

    private cw() {
        this.xt = new ConcurrentHashMap();
    }

    public void j(ConcurrentHashMap<String, xt> concurrentHashMap) {
        this.f24697j = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "mAdnControlMap = ".concat(String.valueOf(concurrentHashMap)));
        } else {
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
        }
    }

    public void j(String str, String str2, String str3) {
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, xt> map = this.f24697j;
        xt xtVar = map != null ? map.get(str) : null;
        if (xtVar != null) {
            for (String str4 : xtVar.xt()) {
                if (TextUtils.equals(str4, str3)) {
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "setAdnError 命中errorCode = ".concat(String.valueOf(str4)));
                    long time = new Date().getTime() + xtVar.j();
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "setAdnError 更新时间 = " + m.xt(time));
                    com.bytedance.msdk.core.tl.j jVar = new com.bytedance.msdk.core.tl.j(str, str2, time);
                    if (this.xt != null) {
                        ConcurrentHashMap<String, com.bytedance.msdk.core.tl.j> concurrentHashMap = new ConcurrentHashMap<>();
                        concurrentHashMap.put(str2, jVar);
                        this.xt.put(str, concurrentHashMap);
                        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.xt);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public com.bytedance.msdk.api.j j(String str, String str2) {
        com.bytedance.msdk.core.tl.j jVar;
        ConcurrentHashMap<String, com.bytedance.msdk.core.tl.j> concurrentHashMap;
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.tl.j>> map = this.xt;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            jVar = null;
        } else {
            jVar = concurrentHashMap.get(str2);
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "checkLoad 取出的showBean = ".concat(String.valueOf(jVar)));
        }
        if (jVar != null && jVar.j() != 0) {
            long time = new Date().getTime();
            if (time <= jVar.j()) {
                com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "checkLoad 当前时间 = " + m.xt(time));
                com.bytedance.msdk.j.up.cw.j("TTMediationSDK_AdnShowControl", "checkLoad 规则有效时间 = " + m.xt(jVar.j()));
                return new com.bytedance.msdk.api.xt.j(40044, com.bytedance.msdk.api.j.j(40044));
            }
        }
        return null;
    }
}
