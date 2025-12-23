package com.bytedance.sdk.openadsdk.core.qv.cw;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {
    public static int j(n nVar) {
        if (nVar == null || nVar.om() != 1) {
            return 0;
        }
        if (nVar.nu() == 0) {
            return 1;
        }
        return nVar.nu() == 1 ? cw(nVar) ? 0 : 1 : nVar.nu() == 2 ? 2 : 1;
    }

    public static boolean cw(n nVar) {
        if (nVar == null) {
            return false;
        }
        return r(nVar);
    }

    public static String xt(n nVar) {
        if (nVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.tj.up by = nVar.by();
        return (by == null || TextUtils.isEmpty(by.cw())) ? !TextUtils.isEmpty(nVar.rs()) ? nVar.rs() : !TextUtils.isEmpty(nVar.zk()) ? nVar.zk() : !TextUtils.isEmpty(nVar.ij()) ? nVar.ij() : "" : by.cw();
    }

    public static boolean r(n nVar) {
        com.bytedance.sdk.openadsdk.core.tj.m et = nVar.et();
        if (et == null || TextUtils.isEmpty(et.ws()) || TextUtils.isEmpty(et.up()) || TextUtils.isEmpty(et.ae()) || et.j() == null || et.j().size() <= 0 || TextUtils.isEmpty(et.tl()) || TextUtils.isEmpty(et.g())) {
            return false;
        }
        return true;
    }

    public static void j(final Context context) {
        if (context == null) {
            context = v.getContext();
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a.j(context, "应用信息缺失，暂无法响应下载", 1);
        } else {
            tj.m().post(new com.bytedance.sdk.component.oq.g("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.oq.1
                @Override // java.lang.Runnable
                public void run() {
                    a.j(context, "应用信息缺失，暂无法响应下载", 1);
                }
            });
        }
    }
}
