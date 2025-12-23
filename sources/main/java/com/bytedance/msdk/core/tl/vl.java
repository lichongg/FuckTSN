package com.bytedance.msdk.core.tl;

import android.text.TextUtils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl {

    /* renamed from: j, reason: collision with root package name */
    private static final String f24718j = "TTMediationSDK_" + vl.class.getSimpleName();
    private Map<String, Long> xt;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static vl f24720j = new vl();
    }

    private vl() {
        this.xt = new ConcurrentHashMap();
    }

    public static vl j() {
        return j.f24720j;
    }

    public boolean cw(String str, String str2) {
        String str3 = f24718j;
        com.bytedance.msdk.j.up.cw.j(str3, "adn checkPacing ritId = " + str + " adnSlotId = " + str2);
        g r5 = r(str, str2);
        if (r5 != null && r5.tl() && r5.vl()) {
            long time = new Date().getTime();
            long qv = r5.qv();
            long qv2 = r5.qv() + r5.g();
            com.bytedance.msdk.j.up.cw.j(str3, "adn checkPacing currentTime = " + m.xt(time) + " showTime = " + m.xt(qv) + " pacingBean.getPacing() = " + r5.g() + " pacingTime = " + m.xt(qv2));
            if (time <= qv2) {
                this.xt.put(str + "_" + str2, Long.valueOf(time - qv));
                return false;
            }
        }
        return true;
    }

    public void xt(final String str, final String str2) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.tl.vl.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.j.up.cw.j(vl.f24718j, "adn updateShowPacingTime ritId = " + str + " adnSlotId = " + str2);
                g r5 = vl.this.r(str, str2);
                if (r5 != null && r5.tl()) {
                    Date date = new Date();
                    com.bytedance.msdk.j.up.cw.j(vl.f24718j, "adn updateShowPacingTime save time = " + m.xt(date.getTime()));
                    vl.this.j(str, str2, date.getTime());
                }
            }
        });
    }

    public void delete(String str, String str2) {
        oq.j().j(str, str2);
    }

    public long j(String str, String str2) {
        Long l6 = this.xt.get(str + "_" + str2);
        if (l6 == null) {
            return -2L;
        }
        return l6.longValue();
    }

    public g r(String str, String str2) {
        return oq.j().xt(str, str2);
    }

    public void xt(g gVar) {
        oq.j().j(gVar);
    }

    public boolean j(g gVar) {
        if (gVar == null) {
            return false;
        }
        g r5 = r(gVar.xt(), gVar.cw());
        if (r5 == null) {
            com.bytedance.msdk.j.up.cw.j(f24718j, "adn pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(gVar.oq())) {
            com.bytedance.msdk.j.up.cw.j(f24718j, "adn pacing ruleId 为空 清空本地数据 ");
            delete(gVar.xt(), gVar.cw());
            return false;
        }
        if (TextUtils.equals(r5.oq(), gVar.oq())) {
            com.bytedance.msdk.j.up.cw.j(f24718j, "adn pacing ruleId 一致 ruleId = " + r5.oq() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.j.up.cw.j(f24718j, "adn pacing ruleId不一致，缓存新规则 old ruleId = " + r5.oq() + "  new ruleId = " + gVar.oq());
        delete(gVar.xt(), gVar.cw());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, long j6) {
        oq.j().j(str, str2, j6);
    }
}
