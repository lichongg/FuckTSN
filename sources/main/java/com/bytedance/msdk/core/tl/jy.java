package com.bytedance.msdk.core.tl;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class jy {

    /* renamed from: j, reason: collision with root package name */
    private Map<String, Long> f24702j;
    private Map<String, Pair<String, String>> xt;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static jy f24705j = new jy();
    }

    public void xt() {
        this.xt = new ConcurrentHashMap();
        this.f24702j = new ConcurrentHashMap();
    }

    private jy() {
        xt();
    }

    public static jy j() {
        return j.f24705j;
    }

    public void ae(final String str) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.tl.jy.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + str);
                ae oq = jy.this.oq(str);
                if (oq == null || !oq.tl()) {
                    return;
                }
                for (up upVar : oq.qv()) {
                    if (upVar.up() < upVar.j()) {
                        jy.this.j(oq, upVar.cw(), upVar.up() + 1);
                    }
                }
            }
        });
    }

    public Pair<String, String> m(String str) {
        return this.xt.get(str);
    }

    public boolean cw(String str) {
        g up = up(str);
        if (up != null && up.tl() && up.vl()) {
            long time = new Date().getTime();
            long qv = up.qv();
            long qv2 = up.qv() + up.g();
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + m.xt(time) + " showTime = " + m.xt(qv) + " pacingBean.getPacing() = " + up.g() + " pacingTime = " + m.xt(qv2));
            if (time <= qv2) {
                this.f24702j.put(str, Long.valueOf(time - qv));
                return false;
            }
        }
        return true;
    }

    public void g(String str) {
        tl.j().j(str);
    }

    public long j(String str) {
        Long l6 = this.f24702j.get(str);
        if (l6 == null) {
            return -2L;
        }
        return l6.longValue();
    }

    public ae oq(String str) {
        return tl.j().xt(str);
    }

    public void r(String str) {
        oq.j().j(str);
    }

    public boolean tl(String str) {
        ae oq = oq(str);
        if (oq != null && oq.tl()) {
            for (up upVar : oq.qv()) {
                Date date = new Date();
                com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + upVar.r());
                if (date.getTime() <= upVar.r()) {
                    if (upVar.up() < upVar.j()) {
                        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "checkFreqctl 未到上线可以展示 ruleId = " + upVar.cw() + " count = " + upVar.up());
                    } else {
                        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "checkFreqctl 到了上线不可以展示 ruleId = " + upVar.cw() + " count = " + upVar.up());
                        Map<String, Pair<String, String>> map = this.xt;
                        String cw = upVar.cw();
                        StringBuilder sb = new StringBuilder();
                        sb.append(upVar.up());
                        map.put(str, new Pair<>(cw, sb.toString()));
                        return false;
                    }
                } else {
                    j(oq, upVar.cw(), 0);
                    j(oq, upVar.cw(), m.j(upVar.xt()));
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + upVar.cw());
                }
            }
            return true;
        }
        return true;
    }

    public g up(String str) {
        return oq.j().xt(str);
    }

    public void xt(final String str) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.tl.jy.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "updateShowPacingTime ritId = " + str);
                g up = jy.this.up(str);
                if (up == null || !up.tl()) {
                    return;
                }
                Date date = new Date();
                com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "updateShowPacingTime save time = " + m.xt(date.getTime()));
                jy.this.j(str, date.getTime());
            }
        });
    }

    public void xt(g gVar) {
        oq.j().j(gVar);
    }

    public boolean j(g gVar) {
        if (gVar == null) {
            return false;
        }
        g up = up(gVar.xt());
        if (up == null) {
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(gVar.oq())) {
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "pacing ruleId 为空 清空本地数据 ");
            r(gVar.r());
            return false;
        }
        if (TextUtils.equals(up.oq(), gVar.oq())) {
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "pacing ruleId 一致 ruleId = " + up.oq() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "pacing ruleId不一致，缓存新规则 old ruleId = " + up.oq() + "  new ruleId = " + gVar.oq());
        StringBuilder sb = new StringBuilder("pacing 删除 ritId = ");
        sb.append(gVar.r());
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", sb.toString());
        r(gVar.r());
        return true;
    }

    public void xt(ae aeVar) {
        tl.j().j(aeVar);
    }

    public void j(String str, long j6) {
        oq.j().j(str, j6);
    }

    public boolean j(ae aeVar) {
        if (aeVar == null) {
            return false;
        }
        ae oq = oq(aeVar.xt());
        if (oq == null) {
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(aeVar.up())) {
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "freqctl version 为空 清空本地数据 ");
            g(oq.xt());
            return false;
        }
        if (TextUtils.equals(oq.up(), aeVar.up())) {
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "freqctl version 一致 version = " + oq.up() + "无需处理");
            return false;
        }
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_IntervalShowControl", "freqctl version不一致，缓存新规则 old version = " + oq.up() + "  new version " + aeVar.up());
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
