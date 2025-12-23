package com.bytedance.sdk.openadsdk.core.ae;

import android.content.Context;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f27950j;

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt() {
        ae.xt(new g("fetch_lg_command") { // from class: com.bytedance.sdk.openadsdk.core.ae.j.2
            @Override // java.lang.Runnable
            public void run() {
                cw.xt();
            }
        });
    }

    public static void cw(String str, String str2) {
        if (f27950j) {
            cw.cw(str, str2);
        }
    }

    private static void j(Context context, xt xtVar) {
        if (xtVar != null && LogAdapter.f31848j == null && i.j(v.getContext()) && xtVar.r()) {
            String path = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context).getPath();
            String file = com.bytedance.sdk.openadsdk.api.plugin.xt.j(context).toString();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("buffer_dir_path", path + "/aa");
                jSONObject.putOpt("log_dir_path", file + "/aa");
                Boolean bool = Boolean.TRUE;
                jSONObject.putOpt("compress", bool);
                jSONObject.putOpt("encrypt", bool);
                jSONObject.putOpt("level", Integer.valueOf(xtVar.j()));
                jSONObject.putOpt("log_file_exp_days", Integer.valueOf(xtVar.xt()));
                jSONObject.putOpt("max_dir_size", Integer.valueOf(xtVar.cw() * 1048576));
                jSONObject.putOpt("per_size", 2097152);
                jSONObject.putOpt("offload_main_write", bool);
                if (!cw.j(context, jSONObject)) {
                    vl.r("ACL", "init failed");
                    return;
                }
                vl.j(new up());
                cw.j(context, "3892", m.j().cw());
                cw.j("mon.zijieapi.com");
                f27950j = true;
                cw.cw();
            } catch (JSONException e6) {
                vl.r("ACL", "init failed:" + e6.getMessage());
            }
        }
    }

    public static void r(String str, String str2) {
        if (f27950j) {
            cw.r(str, str2);
        }
    }

    public static void xt(String str, String str2) {
        if (f27950j) {
            cw.xt(str, str2);
        }
    }

    public static void xt(String str, String str2, Throwable th) {
        if (f27950j) {
            cw.xt(str, str2, th);
        }
    }

    public static void j(xt xtVar) {
        if (!f27950j) {
            j(v.getContext(), xtVar);
        } else if (xtVar != null && xtVar.r()) {
            cw.j(xtVar.j());
            tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ae.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.xt();
                }
            }, 5000L);
        } else {
            cw.j();
        }
    }

    public static void j(String str, String str2) {
        if (f27950j) {
            cw.j(str, str2);
        }
    }

    public static void j(String str, String str2, Throwable th) {
        if (f27950j) {
            cw.j(str, str2, th);
        }
    }

    public static void j(String str, Throwable th) {
        if (f27950j) {
            cw.j(str, th);
        }
    }
}
