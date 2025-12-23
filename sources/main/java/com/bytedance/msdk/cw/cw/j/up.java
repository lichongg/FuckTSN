package com.bytedance.msdk.cw.cw.j;

import android.text.TextUtils;
import com.bytedance.msdk.cw.cw.j.j;
import com.bytedance.msdk.tl.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up implements j {
    private int j(int i6) {
        switch (i6) {
            case 1:
                return 840032;
            case 2:
                return 840033;
            case 3:
                return 840034;
            case 4:
            case 6:
            default:
                return 840029;
            case 5:
                return 840035;
            case 7:
                return 840036;
            case 8:
                return 840037;
            case 9:
                return 840030;
            case 10:
                return 840039;
        }
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void j(j.InterfaceC0365j interfaceC0365j) {
        com.bytedance.msdk.cw.m.j.xt j6 = interfaceC0365j.j();
        com.bytedance.msdk.api.j.xt mi = j6.mi();
        com.bytedance.msdk.api.xt.j jVar = !com.bytedance.msdk.core.xt.xt().j(j6.mi().v(), j6.mi().f()) ? new com.bytedance.msdk.api.xt.j(840031, com.bytedance.msdk.api.j.j(840031)) : null;
        if (jVar == null && !com.bytedance.msdk.core.xt.xt().j(j6.mi().f())) {
            jVar = new com.bytedance.msdk.api.xt.j(j(j6.mi().f()), com.bytedance.msdk.api.j.j(j(j6.mi().f())));
        }
        if (jVar == null && !com.bytedance.msdk.m.cw.xt()) {
            jVar = new com.bytedance.msdk.api.xt.j(1, com.bytedance.msdk.api.j.j(1));
        }
        if (jVar == null && j6.m()) {
            jVar = new com.bytedance.msdk.api.xt.j(41044, com.bytedance.msdk.api.j.j(41044));
        }
        if (jVar == null && j6.getContext() == null) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "Context为null！！！");
            jVar = new com.bytedance.msdk.api.xt.j(41005, com.bytedance.msdk.api.j.j(41005));
        }
        if (jVar == null && TextUtils.isEmpty(j6.mi().v())) {
            jVar = new com.bytedance.msdk.api.xt.j(840026, "广告位id不能为空");
        }
        if (jVar == null && (j6.vl() == null || p.j(j6.vl().ol()))) {
            if (com.bytedance.msdk.ae.j.cw.j().cw()) {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(mi.v()) + "settings config.......没有settings config配置信息,AdUnitId = " + mi.v());
                jVar = new com.bytedance.msdk.api.xt.j(840040, com.bytedance.msdk.api.j.j(840040));
                com.bytedance.msdk.up.m.xt(mi, 1);
            } else if (j6.vl() == null || !p.j(j6.vl().ol())) {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(mi.v()) + "settings config.......注意，AdUnitId = " + mi.v() + " 的配置信息为 null ！！");
                jVar = new com.bytedance.msdk.api.xt.j(44406, "检查广告位ID的状态是否正常、初始化 useMediation 参数是否为 true、新建广告位ID生效期为20min左右");
                com.bytedance.msdk.up.m.xt(mi, 2);
            } else {
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(mi.v()) + "settings config.......注意，AdUnitId = " + mi.v() + "  没有对应的waterfall配置信息");
                com.bytedance.msdk.up.m.xt(mi, 3);
            }
            com.bytedance.msdk.core.ws.xt.j(com.bytedance.msdk.core.xt.xt()).xt(1);
        }
        if (jVar == null) {
            String nd = mi.nd();
            if (!TextUtils.isEmpty(nd) && !mi.rh() && !com.bytedance.msdk.cw.tl.r.j(mi.v(), nd)) {
                jVar = new com.bytedance.msdk.api.xt.j(840044, "本次请求未包含聚合广告位头层设价最高的代码位，导致聚合请求失败；请调整请求，确保包含聚合广告位头层设价最高的代码位。");
            }
        }
        com.bytedance.msdk.api.xt.j jVar2 = jVar;
        if (jVar2 == null) {
            interfaceC0365j.j(interfaceC0365j.j());
        } else {
            com.bytedance.msdk.up.m.j(mi, j6.vl() != null ? j6.vl().hh() : null, !j6.v(), j6.wq().f24631j, jVar2.f24334j, (Map<String, Object>) null);
            j6.j(jVar2);
        }
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void xt(j.InterfaceC0365j interfaceC0365j) {
        com.bytedance.msdk.cw.m.j.xt j6 = interfaceC0365j.j();
        if (j6.m()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "调用过销毁方法_destroy()！！！");
            j6.j(new com.bytedance.msdk.api.j(41044, com.bytedance.msdk.api.j.j(41044)));
        } else if (j6.jy().up()) {
            j6.j(new com.bytedance.msdk.api.j(10010, "延长瀑布流总超时时长或者缩短层超时并添加兜底代码位"));
        } else {
            interfaceC0365j.j((String) null);
        }
    }
}
