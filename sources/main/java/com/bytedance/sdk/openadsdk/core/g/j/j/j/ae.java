package com.bytedance.sdk.openadsdk.core.g.j.j.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements com.bytedance.sdk.openadsdk.core.g.j.j.j {
    private n cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.tj.up f28962j;

    /* renamed from: r, reason: collision with root package name */
    private String f28963r;
    private Context xt;

    private void xt() {
        new CountDownTimer(3000L, 3000L) { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.ae.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (oq.i() == null || oq.i().j()) {
                    ae.this.j(true);
                } else {
                    ae.this.j(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j6) {
            }
        }.start();
    }

    public void j(n nVar) {
        this.cw = nVar;
    }

    public ae(com.bytedance.sdk.openadsdk.core.tj.up upVar, Context context) {
        this.f28962j = upVar;
        this.xt = context;
    }

    public void j(String str) {
        this.f28963r = str;
    }

    public boolean xt(String str) {
        if (this.xt == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            com.bytedance.sdk.component.utils.xt.startActivity(this.xt, intent, TextUtils.equals("main", UMModuleRegister.INNER));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
    public boolean j(Map<String, Object> map) {
        return j();
    }

    private boolean j() {
        com.bytedance.sdk.openadsdk.core.tj.up upVar = this.f28962j;
        if (upVar == null) {
            return false;
        }
        String j6 = upVar.j();
        if (tj.m(this.cw) != 3 || TextUtils.isEmpty(j6)) {
            return false;
        }
        boolean xt = xt(j6);
        if (xt) {
            xt();
            return xt;
        }
        j(false);
        return xt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z5) {
        if (z5) {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.cw, this.f28963r, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.cw, this.f28963r, "quickapp_fail");
        }
    }
}
