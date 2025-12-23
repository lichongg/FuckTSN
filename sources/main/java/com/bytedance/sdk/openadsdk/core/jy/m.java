package com.bytedance.sdk.openadsdk.core.jy;

import android.text.TextUtils;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.ed;
import com.bytedance.sdk.openadsdk.core.jy.ae;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private static volatile m f29254j;

    public static m j() {
        if (f29254j == null) {
            synchronized (m.class) {
                try {
                    if (f29254j == null) {
                        f29254j = new m();
                    }
                } finally {
                }
            }
        }
        return f29254j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(n nVar, String str) {
        if (nVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        j6.j("save_jump_success_time", System.currentTimeMillis());
        JSONObject tv2 = nVar.tv();
        if (tv2 == null) {
            return;
        }
        j6.j("save_dpl_success_materialmeta", tv2.toString());
        j6.j("save_jump_success_ad_tag", str);
    }

    private m() {
    }

    public void j(final n nVar, final String str, final boolean z5) {
        if (nVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        new ae().j(new ae.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.m.1

            /* renamed from: m, reason: collision with root package name */
            private boolean f29256m = false;

            @Override // com.bytedance.sdk.openadsdk.core.jy.ae.j
            public void j() {
                j(false, "resume");
                if (!z5) {
                    xt(str);
                }
                com.bytedance.sdk.openadsdk.core.xt.j().j("dpl_reject_by_dialog", true);
                cw.j(nVar, str, "dpl_popup", System.currentTimeMillis() - currentTimeMillis);
            }

            private void xt(String str2) {
                n nVar2 = nVar;
                if (nVar2 == null || this.f29256m) {
                    return;
                }
                boolean sh = nVar2.sh();
                i m111if = nVar.m111if();
                if (m111if == null || m111if.j()) {
                    return;
                }
                int cw = m111if.cw();
                if (sh) {
                    return;
                }
                if (cw == 1 || cw == 2) {
                    ed.j(nVar, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jy.ae.j
            public void j(String str2) {
                j(false, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jy.ae.j
            public void j(boolean z6) {
                this.f29256m = z6;
                j(z6, "stop");
                if (!this.f29256m && !z5) {
                    xt(str);
                }
                com.bytedance.sdk.openadsdk.core.xt.j().j("dpl_reject_by_dialog", false);
            }

            private void j(final boolean z6, final String str2) {
                com.bytedance.sdk.component.oq.ae.j(new g("EventData") { // from class: com.bytedance.sdk.openadsdk.core.jy.m.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (z5) {
                            cw.cw(nVar, str, z6 ? "lp_dpl_success" : "lp_dpl_failed");
                            return;
                        }
                        String str3 = z6 ? "dpl_success" : "dpl_failed";
                        HashMap hashMap = new HashMap();
                        boolean j6 = oq.i().j();
                        hashMap.put("has_focus", Boolean.valueOf(oq.i().j(true)));
                        hashMap.put("is_background", Boolean.valueOf(j6));
                        hashMap.put("life", str2);
                        hashMap.put("total_duration", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        cw.tl(nVar, str, str3, hashMap);
                        AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                        n nVar2 = nVar;
                        if (nVar2 != null) {
                            m.xt(nVar2, str);
                        }
                    }
                }, 5);
            }
        });
    }
}
