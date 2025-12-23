package com.bytedance.msdk.core.r;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.msdk.core.jy.j;
import com.bytedance.msdk.core.oq.ae;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.oq.tl;
import com.bytedance.msdk.core.r.r;
import com.bytedance.msdk.tl.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m implements r {
    @Override // com.bytedance.msdk.core.r.r
    public void j(Map<String, com.bytedance.msdk.cw.j.j> map, Context context, final cw cwVar, @NonNull final r.j jVar) {
        if (cwVar != null && cwVar.f24679j != null && cwVar.f24681r != null && !p.j(cwVar.xt)) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(cwVar.f24679j.v()) + "开启server bidding网络请求......：");
            com.bytedance.msdk.up.m.j(cwVar.f24679j, (JSONObject) null);
            final long currentTimeMillis = System.currentTimeMillis();
            final int[] iArr = {4};
            com.bytedance.msdk.core.jy.j.j().j(map, context, cwVar.f24679j, cwVar.xt, cwVar.cw, cwVar.f24681r, cwVar.up, cwVar.f24680m, new j.InterfaceC0359j() { // from class: com.bytedance.msdk.core.r.m.1
                @Override // com.bytedance.msdk.core.jy.j.InterfaceC0359j
                public void j(ae aeVar) {
                    m mVar = m.this;
                    long j6 = currentTimeMillis;
                    cw cwVar2 = cwVar;
                    mVar.j(j6, cwVar2.f24679j, cwVar2.f24681r, iArr[0], aeVar, jVar);
                }

                @Override // com.bytedance.msdk.core.jy.j.InterfaceC0359j
                public void j(com.bytedance.msdk.api.j jVar2) {
                    m.this.j(currentTimeMillis, iArr[0], jVar2, cwVar.f24679j, jVar);
                }
            });
            return;
        }
        jVar.j(null);
    }

    public void j(String str, final long j6, final com.bytedance.msdk.api.j.xt xtVar, final com.bytedance.msdk.core.oq.xt xtVar2, @NonNull final r.j jVar) {
        com.bytedance.msdk.core.jy.j.j().j(str, new j.InterfaceC0359j() { // from class: com.bytedance.msdk.core.r.m.2
            @Override // com.bytedance.msdk.core.jy.j.InterfaceC0359j
            public void j(ae aeVar) {
                m.this.j(j6, xtVar, xtVar2, 4, aeVar, jVar);
            }

            @Override // com.bytedance.msdk.core.jy.j.InterfaceC0359j
            public void j(com.bytedance.msdk.api.j jVar2) {
                m.this.j(j6, 4, jVar2, xtVar, jVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.core.oq.xt xtVar2, int i6, ae aeVar, r.j jVar) {
        int i7;
        xt xtVar3;
        int i8;
        oq m6;
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.v()) + "server bidding网络请求响返回.............");
        long currentTimeMillis = System.currentTimeMillis() - j6;
        if (xtVar2 != null && aeVar != null && !p.j(aeVar.r())) {
            List<tl> r5 = aeVar.r();
            xtVar3 = new xt();
            xtVar3.vl = aeVar.j();
            xtVar3.jy = aeVar.xt();
            xtVar3.ws = aeVar.cw();
            xtVar3.qv = aeVar.ae();
            xtVar3.f24689g = r5.size();
            xtVar3.f24690j = aeVar.g();
            xtVar3.oq = xtVar2.m();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            sb.append("winners : {");
            for (tl tlVar : r5) {
                if (tlVar != null && (m6 = xtVar2.m(tlVar.ae())) != null) {
                    oq up = m6.up();
                    sb.append(" [ AdnName:" + up.az() + ",slotId:" + up.w() + ",loadSort:" + up.x() + ",showSort:" + up.ch() + "] ");
                    up.j(tlVar);
                    arrayList.add(up);
                }
            }
            sb.append("}");
            if (p.j(arrayList)) {
                i7 = p.j(aeVar.g()) ? i6 : 2;
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.v()) + "server bidding网络请求响应失败......：数据有返回，但没有返回winner数据......");
            } else {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.v()) + "server bidding网络请求响应成功......：" + sb.toString());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.addAll(arrayList);
                List<oq> j7 = j(aeVar.g(), xtVar2, xtVar3);
                if (j7 != null && j7.size() > 0) {
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.v()) + "server bidding网络请求响应成功......waterfall+server bidding物料......");
                    copyOnWriteArrayList.addAll(j7);
                    i8 = 1;
                } else {
                    com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.v()) + "server bidding网络请求响应成功......server bidding物料......");
                    i8 = 3;
                }
                xtVar3.xt = copyOnWriteArrayList;
                i7 = i8;
            }
        } else {
            i7 = (aeVar == null || p.j(aeVar.g())) ? i6 : 2;
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.v()) + "server bidding网络请求响应失败......没有返回serverBiddingModel相关数据");
            xtVar3 = null;
        }
        if (aeVar != null) {
            String m7 = aeVar.m();
            if (!TextUtils.isEmpty(m7)) {
                if (xtVar3 == null) {
                    xtVar3 = new xt();
                }
                xtVar3.f24692r = m7;
            }
            if (aeVar.tl()) {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.v()) + "server bidding发现config过期了，需要重新拉取配置......：");
                if (xtVar3 == null) {
                    xtVar3 = new xt();
                }
                xtVar3.cw = true;
            }
            if (!p.j(aeVar.up())) {
                if (xtVar3 == null) {
                    xtVar3 = new xt();
                }
                xtVar3.up = aeVar.up();
            }
        }
        if (xtVar3 == null) {
            xtVar3 = new xt();
        }
        xtVar3.f24691m = i7;
        xtVar3.ae = currentTimeMillis;
        if (jVar != null) {
            jVar.j(xtVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6, int i6, com.bytedance.msdk.api.j jVar, com.bytedance.msdk.api.j.xt xtVar, r.j jVar2) {
        int i7 = (jVar == null || jVar.f24334j != -1) ? 5 : 4;
        com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(xtVar.v()) + "server bidding网络请求响应失败......onFail  result:" + i7);
        xt xtVar2 = new xt();
        xtVar2.f24691m = i7;
        xtVar2.ae = System.currentTimeMillis() - j6;
        xtVar2.tl = jVar;
        if (jVar2 != null) {
            jVar2.j(xtVar2);
        }
    }

    private List<oq> j(List<oq> list, com.bytedance.msdk.core.oq.xt xtVar, xt xtVar2) {
        List<oq> ol;
        if (list == null || list.size() == 0 || xtVar == null) {
            return null;
        }
        boolean booleanValue = xtVar.up().get("serverBidding_timeout") instanceof Boolean ? ((Boolean) xtVar.up().get("serverBidding_timeout")).booleanValue() : false;
        if (xtVar.m() == 4 && !booleanValue) {
            com.bytedance.msdk.core.oq.xt j6 = com.bytedance.msdk.ae.j.cw.j().j(xtVar.rn(), xtVar.wq(), 102);
            if (j6 == null) {
                return null;
            }
            ol = com.bytedance.msdk.core.g.cw.j(j6, j6.rn(), xtVar2 == null ? 0.0d : xtVar2.vl, xtVar2 != null ? xtVar2.ws : 0.0d);
            xtVar.up().putAll(j6.up());
        } else {
            ol = xtVar.ol();
        }
        if (ol != null && ol.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (oq oqVar : ol) {
                Iterator<oq> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        oq next = it.next();
                        if (oqVar != null && next != null && oqVar.mi() == 0 && !TextUtils.isEmpty(oqVar.w()) && oqVar.w().equals(next.w())) {
                            arrayList.add(oqVar);
                            break;
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }
}
