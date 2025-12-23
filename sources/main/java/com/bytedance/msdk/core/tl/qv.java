package com.bytedance.msdk.core.tl;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv {

    /* renamed from: j, reason: collision with root package name */
    private static final String f24708j = "TTMediationSDK_" + qv.class.getSimpleName();
    private Map<String, Pair<String, String>> xt;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static qv f24710j = new qv();
    }

    private qv() {
        this.xt = new ConcurrentHashMap();
    }

    public boolean cw(String str, String str2) {
        com.bytedance.msdk.j.up.cw.j(f24708j, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2);
        ae r5 = r(str, str2);
        if (r5 == null || !r5.tl()) {
            return true;
        }
        for (up upVar : r5.qv()) {
            Date date = new Date();
            String str3 = f24708j;
            com.bytedance.msdk.j.up.cw.j(str3, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2 + "  date = " + date.getTime() + " item.getEffectiveTime() = " + upVar.r());
            if (date.getTime() > upVar.r()) {
                j(r5, upVar.cw(), 0);
                j(r5, upVar.cw(), m.j(upVar.xt()));
                com.bytedance.msdk.j.up.cw.j(str3, "adn checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + upVar.cw());
            } else {
                if (upVar.up() >= upVar.j()) {
                    com.bytedance.msdk.j.up.cw.j(str3, "adn checkFreqctl 到了上线不可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + upVar.cw() + " count = " + upVar.up());
                    Map<String, Pair<String, String>> map = this.xt;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("_");
                    sb.append(str2);
                    String sb2 = sb.toString();
                    String cw = upVar.cw();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(upVar.up());
                    map.put(sb2, new Pair<>(cw, sb3.toString()));
                    return false;
                }
                com.bytedance.msdk.j.up.cw.j(str3, "adn checkFreqctl 未到上线可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + upVar.cw() + " count = " + upVar.up());
            }
        }
        return true;
    }

    public void xt(final String str, final String str2) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.tl.qv.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.j.up.cw.j(qv.f24708j, "adn addShowFreqctlCount ritId = " + str + " adnSlotId = " + str2);
                ae r5 = qv.this.r(str, str2);
                if (r5 != null && r5.tl()) {
                    for (up upVar : r5.qv()) {
                        if (upVar.up() < upVar.j()) {
                            qv.this.j(r5, upVar.cw(), upVar.up() + 1);
                        }
                    }
                }
            }
        });
    }

    public static qv j() {
        return j.f24710j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ae r(String str, String str2) {
        return tl.j().xt(str, str2);
    }

    public void delete(String str, String str2) {
        tl.j().j(str, str2);
    }

    public void xt(ae aeVar) {
        jy.j().xt(aeVar);
    }

    public Pair<String, String> j(String str, String str2) {
        return this.xt.get(str + "_" + str2);
    }

    public boolean j(ae aeVar) {
        if (aeVar == null) {
            return false;
        }
        ae r5 = r(aeVar.xt(), aeVar.cw());
        if (r5 == null) {
            com.bytedance.msdk.j.up.cw.j(f24708j, "adn freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(aeVar.m())) {
            com.bytedance.msdk.j.up.cw.j(f24708j, "adn freqctl version 为空 清空本地数据 ");
            delete(r5.xt(), r5.cw());
            return false;
        }
        if (TextUtils.equals(r5.m(), aeVar.m())) {
            com.bytedance.msdk.j.up.cw.j(f24708j, "adn freqctl version 一致 version = " + r5.m() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.j.up.cw.j(f24708j, "adn freqctl version不一致，缓存新规则 old version = " + r5.m() + "  new version " + aeVar.m());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ae aeVar, String str, int i6) {
        tl.j().j(aeVar, str, i6);
    }

    private void j(ae aeVar, String str, long j6) {
        tl.j().j(aeVar, str, j6);
    }
}
