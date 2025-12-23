package com.bytedance.sdk.openadsdk.core.h;

import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.j.xt;
import com.bytedance.sdk.component.oq.qv;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.v;
import com.qq.e.comm.constants.ErrorCode;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f29119j = true;
    private static boolean xt;

    public static void j() {
        if (xt) {
            return;
        }
        xt = true;
        qv qvVar = qv.xt;
        qvVar.j(11);
        qvVar.r(h.j());
        qvVar.cw(true);
        qvVar.j(true);
        qvVar.xt(true);
        qvVar.j(new xt() { // from class: com.bytedance.sdk.openadsdk.core.h.j.1
            @Override // com.bytedance.sdk.component.oq.j.xt
            public String j(String str) {
                return str != null ? str.startsWith("csj") ? str : "csj_".concat(str) : "csj_uk";
            }
        });
    }

    public static void xt() {
        JSONObject xq = v.xt().xq();
        if (xq == null) {
            return;
        }
        qv qvVar = qv.xt;
        int optInt = xq.optInt("big_max_mum", 50);
        if (optInt > 0) {
            qvVar.r(optInt);
        }
        int optInt2 = xq.optInt("core_count", 0);
        if (optInt2 > 0) {
            qvVar.cw(optInt2);
        }
        int optInt3 = xq.optInt("big_keep_alive", 0);
        if (optInt3 > 0) {
            qvVar.j(optInt3);
        }
        qvVar.up(xq.optBoolean("big_priority", false));
        qvVar.cw(xq.optBoolean("catch_oom", true));
        qvVar.xt(xq.optBoolean("forbid_autosize_oom", true));
        qvVar.m(xq.optBoolean("enable_proxy", true));
        f29119j = xq.optBoolean("can_set_crash", true);
        ae.j(xq.optBoolean("autosize", true));
        qvVar.g(xq.optBoolean("report_task", false));
        qvVar.xt(xq.optInt("wait_in_big", 50));
        qvVar.cw(xq.optInt("wait_in_little", 2000));
        qvVar.r(xq.optInt("run_cost", ErrorCode.UNKNOWN_ERROR));
    }
}
