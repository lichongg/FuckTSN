package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Intent;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws {

    /* renamed from: j, reason: collision with root package name */
    private static volatile ws f30171j;
    private com.bytedance.sdk.component.r.j.xt xt;

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.r.j.xt xt() {
        if (this.xt == null) {
            this.xt = h.j("hide_recent_activity_recorder");
        }
        return this.xt;
    }

    public static ws j() {
        if (f30171j == null) {
            synchronized (ws.class) {
                try {
                    if (f30171j == null) {
                        f30171j = new ws();
                    }
                } finally {
                }
            }
        }
        return f30171j;
    }

    public void j(Intent intent) {
        final boolean z5 = (intent.getFlags() & 8388608) == 8388608;
        com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.ws.1
            @Override // java.lang.Runnable
            public void run() {
                int i6 = 0;
                int xt = ws.this.xt().xt("all_activity_count", 0) + 1;
                if (z5) {
                    int xt2 = ws.this.xt().xt("hide_activity_count", 0) + 1;
                    if (xt2 >= 10) {
                        ws.this.j(xt);
                        xt = 0;
                    } else {
                        i6 = xt2;
                    }
                    ws.this.xt().j("hide_activity_count", i6);
                }
                ws.this.xt().j("all_activity_count", xt);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final int i6) {
        try {
            com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.ws.2
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ac", i6);
                    return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("hide_activity_record").xt(jSONObject.toString());
                }
            }, "hide_activity_record");
        } catch (Throwable unused) {
        }
    }
}
