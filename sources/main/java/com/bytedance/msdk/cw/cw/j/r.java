package com.bytedance.msdk.cw.cw.j;

import com.bytedance.msdk.cw.cw.j.j;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements j {
    @Override // com.bytedance.msdk.cw.cw.j.j
    public void xt(j.InterfaceC0365j interfaceC0365j) {
        interfaceC0365j.j((String) null);
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void j(j.InterfaceC0365j interfaceC0365j) {
        com.bytedance.msdk.cw.m.j.xt j6 = interfaceC0365j.j();
        j6.jy().j(0);
        int cw = j6.mi().cw();
        List<com.bytedance.msdk.core.oq.oq> list = j6.vl().ch().get(0);
        JSONObject jSONObject = new JSONObject();
        String j7 = com.bytedance.msdk.core.jy.j.j().j(j6.tj(), j6.getContext(), j6.mi(), list, j6.vl(), cw, !j6.v(), jSONObject);
        com.bytedance.msdk.up.m.j(j6.mi(), jSONObject);
        j6.j(j7);
    }
}
