package com.bytedance.msdk.core.up;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.api.j.xt;
import com.bytedance.msdk.core.up.xt.ae;
import com.bytedance.msdk.j.up.cw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, Integer> f24723j = new HashMap();
    private final Map<String, Integer> xt = new HashMap();

    public void j(String str, String str2, int i6) {
        this.f24723j.put(str + "_" + str2, Integer.valueOf(i6));
    }

    public void xt(String str, String str2, int i6) {
        this.xt.put(str + "_" + str2, Integer.valueOf(i6));
    }

    public int j(String str, String str2) {
        Integer num = this.f24723j.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    public int xt(String str, String str2) {
        Integer num = this.xt.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    protected int j(ae aeVar, xt xtVar, xt xtVar2, String str) {
        if (aeVar == null || aeVar.f24739j == null) {
            return 4;
        }
        String v5 = xtVar2 != null ? xtVar2.v() : "";
        String ff = aeVar.f24739j.ff();
        String qa = aeVar.f24739j.qa();
        Integer m6 = aeVar.f24739j.m();
        if (m6.intValue() == 1) {
            if (aeVar.f24739j.qb()) {
                cw.j(MediationConstant.TAG, "--==-- " + str + ":广告已show过 ---: " + ff + ", adSlotId: " + qa);
                return 7;
            }
            if (j(v5, aeVar.f24739j)) {
                cw.j(MediationConstant.TAG, "--==-- " + str + ":广告过期了(M配置) ---: " + ff + ", adSlotId: " + qa);
                return 2;
            }
            if (!j(xtVar, xtVar2, aeVar.f24739j)) {
                cw.j(MediationConstant.TAG, "--==-- " + str + ":AdSlot不符合 ---: " + ff + ", adSlotId: " + qa);
                return 6;
            }
            cw.j(MediationConstant.TAG, "--==-- " + str + ":复用成功：---" + ff + ", adSlotId: " + qa);
            return -1;
        }
        if (aeVar.f24739j.qb()) {
            cw.j(MediationConstant.TAG, "--==-- " + str + ":广告已show过 ---: " + ff + ", adSlotId: " + qa);
            return 7;
        }
        if (m6.intValue() == 3) {
            cw.j(MediationConstant.TAG, "--==-- " + str + ":广告过期了(adn api) ---: " + ff + ", adSlotId: " + qa);
            return 1;
        }
        if (m6.intValue() == 4) {
            cw.j(MediationConstant.TAG, "--==-- " + str + ":isReady是false ---: " + ff + ", adSlotId: " + qa);
            return 5;
        }
        if (!j(xtVar, xtVar2, aeVar.f24739j)) {
            cw.j(MediationConstant.TAG, "--==-- " + str + ":AdSlot不符合 ---: " + ff + ", adSlotId: " + qa);
            return 6;
        }
        cw.j(MediationConstant.TAG, "--==-- " + str + ":复用成功：---" + ff + ", adSlotId: " + qa);
        return -1;
    }

    public final boolean j(String str, com.bytedance.msdk.xt.cw cwVar) {
        if (cwVar == null || cwVar.up()) {
            cw.j(MediationConstant.TAG, "--==-- 广告已经destroy了，视为过期 ------");
            return true;
        }
        boolean z5 = SystemClock.elapsedRealtime() > cwVar.sm() + ((long) j(str, cwVar.qa()));
        cw.j(MediationConstant.TAG, "--==-- 使用了配置的过期时间进行判断 ------");
        return z5;
    }

    public static boolean j(xt xtVar, xt xtVar2, com.bytedance.msdk.xt.cw cwVar) {
        if (xtVar != null && xtVar2 != null) {
            if (xtVar.rn() != xtVar2.rn()) {
                cw.j("TMe", "--==-- orientation, a1: " + xtVar.rn() + ", a2: " + xtVar2.rn());
                return false;
            }
            if (xtVar.wq() != xtVar2.wq()) {
                cw.j("TMe", "--==-- isMuted, a1: " + xtVar.wq() + ", a2: " + xtVar2.wq());
                return false;
            }
            if (xtVar.ch() != xtVar2.ch()) {
                cw.j("TMe", "--==-- ImgWidth, a1: " + xtVar.ch() + ", a2: " + xtVar2.ch());
                return false;
            }
            if (xtVar.s() != xtVar2.s()) {
                cw.j("TMe", "--==-- ImgHeight, a1: " + xtVar.s() + ", a2: " + xtVar2.s());
                return false;
            }
            if (xtVar.p() != null && xtVar2.p() != null) {
                if (!xtVar.p().equals(xtVar2.p())) {
                    cw.j("TMe", "--==-- rewardName, a1: " + xtVar.p() + ", a2: " + xtVar2.p());
                    return false;
                }
            } else if (xtVar.p() != null || xtVar2.p() != null) {
                cw.j("TMe", "--==-- rewardName=null, a1: " + xtVar.p() + ", a2: " + xtVar2.p());
                return false;
            }
            if (xtVar.h() != xtVar2.h()) {
                cw.j("TMe", "--==-- rewardAmount, a1: " + xtVar.h() + ", a2: " + xtVar2.h());
                return false;
            }
            if (xtVar.gq() != null && xtVar2.gq() != null) {
                if (!xtVar.gq().equals(xtVar2.gq())) {
                    cw.j("TMe", "--==-- reward, userId, a1: " + xtVar.gq() + ", a2: " + xtVar2.gq());
                    return false;
                }
            } else if (xtVar.gq() != null || xtVar2.gq() != null) {
                cw.j("TMe", "--==-- reward, userId=null, a1: " + xtVar.gq() + ", a2: " + xtVar2.gq());
                return false;
            }
            if (xtVar.c() != null && xtVar2.c() != null) {
                if (j(xtVar.c(), xtVar2.c())) {
                    return true;
                }
                cw.j("TMe", "--==-- customData, a1: " + xtVar.c().toString() + ", a2: " + xtVar2.c().toString());
                return false;
            }
            if (xtVar.c() == null && xtVar2.c() == null) {
                return true;
            }
            cw.j("TMe", "--==-- customData=null, a1: " + xtVar.c() + ", a2: " + xtVar2.c());
            return false;
        }
        cw.j("TMe", "--==-- adSlot = null, a1: " + xtVar + ", a2: " + xtVar2);
        return false;
    }

    public static boolean j(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<String> keySet = map.keySet();
        if (keySet != null) {
            for (String str : keySet) {
                if (str != null) {
                    Object obj = map.get(str);
                    String str2 = obj instanceof String ? (String) obj : null;
                    Object obj2 = map2.get(str);
                    String str3 = obj2 instanceof String ? (String) obj2 : null;
                    if (str2 != null || str3 != null) {
                        if (!TextUtils.equals(str2, str3)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
