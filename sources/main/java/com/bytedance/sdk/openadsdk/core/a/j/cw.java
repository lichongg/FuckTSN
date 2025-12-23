package com.bytedance.sdk.openadsdk.core.a.j;

import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.ae;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {
    /* JADX INFO: Access modifiers changed from: private */
    public f j() {
        f fVar = new f(v.getContext(), 1, oq.i().up());
        boolean j6 = fVar.j(0);
        j(j6 ? 1 : 0, System.currentTimeMillis(), 0L);
        try {
            fVar.xt(0);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void j(JSONObject jSONObject, int i6) {
        if (System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.a.j.j().xt() > j(i6)) {
            ae.j(new g("reg_sensor") { // from class: com.bytedance.sdk.openadsdk.core.a.j.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.j();
                }
            });
        }
    }
}
