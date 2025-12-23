package com.bytedance.sdk.openadsdk.core.qv.cw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends m {
    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up
    public boolean m() {
        if (this.up.m111if() == null) {
            return false;
        }
        String xt = this.up.m111if().xt();
        if (!TextUtils.isEmpty(xt)) {
            i.j((String) null);
            Uri parse = Uri.parse(xt);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            uf.xt(intent);
            if (this.f29921i) {
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.up, this.f29922m, "lp_open_dpl", j(xt));
            }
            try {
                Context context = getContext();
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                if (!j(this.f29922m, "open_url_app", this.up)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SocialConstants.PARAM_SOURCE, "AndroidRDMLicManager");
                    com.bytedance.sdk.openadsdk.core.jy.cw.tl(this.up, this.f29922m, "open_url_app", hashMap);
                }
                uf.j(this.f29921i, this.up, this.f29922m);
                com.bytedance.sdk.component.utils.xt.startActivity(context, intent, TextUtils.equals("main", UMModuleRegister.INNER));
                com.bytedance.sdk.openadsdk.core.jy.m.j().j(this.up, this.f29922m, this.f29921i);
                if (this.f29921i) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.cw(this.up, this.f29922m, "lp_openurl");
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, this.f29922m, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, this.f29922m, "deeplink_success_realtime", (Throwable) null);
                }
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.core.jy.cw.cw(this.up, this.f29922m, "open_fallback_download");
                if (this.f29921i) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.cw(this.up, this.f29922m, "lp_openurl_failed");
                    j(this.up, this.f29922m, "lp_deeplink_fail_realtime", th);
                } else {
                    j(this.up, this.f29922m, "deeplink_fail_realtime", th);
                }
            }
        }
        if (this.ae.get() == 4 || this.ae.get() == 3) {
            return false;
        }
        if (this.f29920g && !this.tl.get()) {
            return false;
        }
        this.f29920g = true;
        if (j(this.f29922m, "open_fallback_url", this.up)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.tl(this.up, this.f29922m, "open_fallback_url", null);
        return false;
    }

    public xt(Context context, n nVar, String str, boolean z5) {
        super(context, nVar, str, z5);
    }
}
