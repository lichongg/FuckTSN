package com.bytedance.sdk.openadsdk.core.i.j;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class w extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private final WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29164j;
    private final String xt;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("interactiveStart", (com.bytedance.sdk.component.j.up<?, ?>) new w(rnVar, "interactiveStart"));
        iVar.j("interactiveFinish", (com.bytedance.sdk.component.j.up<?, ?>) new w(rnVar, "interactiveFinish"));
        iVar.j("interactiveEnd", (com.bytedance.sdk.component.j.up<?, ?>) new w(rnVar, "interactiveEnd"));
    }

    public w(com.bytedance.sdk.openadsdk.core.rn rnVar, String str) {
        this.f29164j = new WeakReference<>(rnVar);
        this.xt = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        char c6;
        JSONObject jSONObject2 = new JSONObject();
        if (this.f29164j.get() != null) {
            com.bytedance.sdk.openadsdk.core.rn rnVar = this.f29164j.get();
            n tl = rnVar.tl();
            String str = this.xt;
            str.getClass();
            int i6 = -1;
            boolean z5 = true;
            switch (str.hashCode()) {
                case -1055587680:
                    if (str.equals("interactiveStart")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 803356313:
                    if (str.equals("interactiveEnd")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1254561301:
                    if (str.equals("interactiveFinish")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                    rnVar.az();
                    break;
                case 1:
                    rnVar.av();
                    break;
                case 2:
                    try {
                        if (jSONObject.optInt(ConstantHelper.LOG_FINISH, 1) != 1) {
                            z5 = false;
                        }
                        int j6 = j(tl, jSONObject.optInt("reduce_duration", -1));
                        if (z5) {
                            rnVar.r(j6);
                            i6 = 0;
                        }
                        jSONObject2.put("code", i6);
                        jSONObject2.put("reduce_duration", j6);
                        break;
                    } catch (JSONException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                        return jSONObject2;
                    }
            }
        }
        return jSONObject2;
    }

    public static int j(n nVar, int i6) {
        int ju = nVar != null ? nVar.ju() : 0;
        if (i6 >= 0 && ju >= 0) {
            i6 = Math.min(i6, ju);
        } else if (i6 < 0) {
            i6 = ju >= 0 ? ju : 0;
        }
        if (com.bytedance.sdk.openadsdk.core.tj.e.up(nVar)) {
            return 0;
        }
        return i6;
    }
}
