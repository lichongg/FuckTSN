package com.bytedance.sdk.openadsdk.core.live.cw;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.jy.cw;
import com.bytedance.sdk.openadsdk.core.jy.m;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private String f29459j = "";

    public j j(String str) {
        this.f29459j = str;
        return this;
    }

    public void j(final Context context, final n nVar) {
        if (nVar == null || nVar.m111if() == null || TextUtils.isEmpty(nVar.m111if().xt())) {
            return;
        }
        tj.m().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.cw.j.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(nVar.m111if().xt()));
                    intent.addFlags(268435456);
                    if (com.bytedance.sdk.component.utils.xt.j(context, intent, null, TextUtils.equals("main", UMModuleRegister.INNER))) {
                        cw.j(nVar, j.this.f29459j, "deeplink_success_realtime", (Throwable) null);
                    } else {
                        cw.j(nVar, j.this.f29459j, "deeplink_fail_realtime", (Throwable) null);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(SocialConstants.PARAM_SOURCE, "LiveDoubleOpenProcessor");
                    cw.tl(nVar, j.this.f29459j, "open_url_app", hashMap);
                    m.j().j(nVar, j.this.f29459j, false);
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }, 50L);
    }
}
