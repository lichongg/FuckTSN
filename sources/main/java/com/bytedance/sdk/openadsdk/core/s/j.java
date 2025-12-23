package com.bytedance.sdk.openadsdk.core.s;

import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.live.up.xt;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.l.qv;
import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final int f30184j;

    public j(int i6) {
        this.f30184j = i6;
    }

    public int r() {
        return 2;
    }

    public int xt() {
        return j(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ae.j(new g("csj-plugin-check") { // from class: com.bytedance.sdk.openadsdk.core.s.j.2
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.xt() == 5) {
                    xt.j();
                }
            }
        });
    }

    public int cw() {
        return j(8);
    }

    public int j(int i6) {
        int i7 = this.f30184j >> i6;
        int i8 = i7 & 7;
        return i8 == 0 ? r() : ((i7 & 8) >> 3) == 1 ? -i8 : i8;
    }

    public String toString() {
        return String.valueOf(this.f30184j);
    }

    public j(int i6, boolean z5) {
        this.f30184j = i6;
        tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.m();
            }
        }, 5000L);
    }

    public void up() {
        JSONObject hk = v.xt().hk();
        if (hk == null) {
            return;
        }
        try {
            j(hk, "com.byted.live.lite", 4, true);
            j(hk, "com.byted.csj.ext", 8, true);
            j(hk, "com.byted.mixed", 0, true);
            j(hk, "com.byted.pangle", 0, false);
        } catch (Throwable th) {
            vl.xt("onReceiveServerStatus", th);
        }
    }

    public int j() {
        return j(0);
    }

    public int j(String str) {
        if ("com.byted.live.lite".equals(str)) {
            if (v.xt().id()) {
                return xt();
            }
            return 4;
        }
        if ("com.byted.csj.ext".equals(str)) {
            return cw();
        }
        if ("com.byted.pangle".equals(str)) {
            return j();
        }
        return r();
    }

    private void j(JSONObject jSONObject, String str, int i6, boolean z5) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return;
        }
        int optInt = optJSONObject.optInt("state", 2);
        if (optInt == 5) {
            int xt = qv.xt(str);
            int cw = qv.cw(str);
            int r5 = qv.r(str);
            if (z5 || cw > r5) {
                String optString = optJSONObject.optString("api_rule", ContainerUtils.KEY_VALUE_DELIMITER);
                String optString2 = optJSONObject.optString("plugin_rule", ContainerUtils.KEY_VALUE_DELIMITER);
                int optInt2 = optJSONObject.optInt("api_v", 0);
                int optInt3 = optJSONObject.optInt("plugin_v", 0);
                if (j(xt, optInt2, optString) && j(cw, optInt3, optString2)) {
                    qv.j(str);
                    return;
                }
                return;
            }
            return;
        }
        if (optInt == -1 && j(i6) == 5 && qv.cw(str) > qv.r(str)) {
            qv.j(str);
        }
    }

    private boolean j(int i6, int i7, String str) {
        str.getClass();
        switch (str) {
            case "<":
                return i6 < i7;
            case "=":
            case "==":
                return i6 == i7;
            case ">":
                return i6 > i7;
            case "<=":
                return i6 <= i7;
            case ">=":
                return i6 >= i7;
            default:
                return false;
        }
    }
}
