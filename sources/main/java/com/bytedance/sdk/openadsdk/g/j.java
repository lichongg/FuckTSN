package com.bytedance.sdk.openadsdk.g;

import android.content.Context;
import com.bytedance.sdk.component.m.az;
import com.bytedance.sdk.component.m.cw.up;
import com.bytedance.sdk.component.m.jy;
import com.bytedance.sdk.component.m.r;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.m;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    @ATSMethod
    public static az j(Context context, jy jyVar) {
        return com.bytedance.sdk.component.m.cw.xt.j(context, jyVar);
    }

    @ATSMethod
    public static jy j() {
        return new up.j().j(new com.bytedance.sdk.component.m.cw.j.j(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760), 5242880), 0, 41943040L, true, true, new File(g.m()))).j(ae.j()).j(new r() { // from class: com.bytedance.sdk.openadsdk.g.j.1
            private Map<String, String> j(com.bytedance.sdk.component.m.up upVar, av avVar) {
                HashMap hashMap = new HashMap();
                if (upVar.xt()) {
                    m ae = avVar.ae();
                    int j6 = ae.j();
                    for (int i6 = 0; i6 < j6; i6++) {
                        String j7 = ae.j(i6);
                        String xt = ae.xt(i6);
                        if (j7 != null) {
                            hashMap.put(j7, xt);
                        }
                    }
                }
                return hashMap;
            }

            @Override // com.bytedance.sdk.component.m.r
            public com.bytedance.sdk.component.m.xt.r call(com.bytedance.sdk.component.m.up upVar) {
                long currentTimeMillis = System.currentTimeMillis();
                vl m6 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().m();
                ws xt = new ws.j().j(upVar.j()).j().j("csj_client_source_from", "2").xt();
                av avVar = null;
                com.bytedance.sdk.component.m.xt.up upVar2 = upVar.cw() ? new com.bytedance.sdk.component.m.xt.up() : null;
                if (upVar2 != null) {
                    upVar2.j(currentTimeMillis);
                }
                try {
                    av j6 = m6.j(xt).j();
                    if (upVar2 != null) {
                        try {
                            upVar2.xt(System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            avVar = j6;
                            try {
                                return j(upVar2, th);
                            } finally {
                                com.bytedance.sdk.component.m.cw.cw.xt.j(avVar);
                            }
                        }
                    }
                    if (upVar.r() != null) {
                        upVar.r().j(3, null);
                    }
                    Map<String, String> j7 = j(upVar, j6);
                    byte[] r5 = j6.m().r();
                    j7.put("image_size", String.valueOf(r5 == null ? 0 : r5.length));
                    com.bytedance.sdk.component.m.xt.r rVar = new com.bytedance.sdk.component.m.xt.r(j6.cw(), r5, "", j7);
                    if (upVar2 != null) {
                        upVar2.cw(System.currentTimeMillis());
                    }
                    rVar.j(upVar2);
                    com.bytedance.sdk.component.m.cw.cw.xt.j(j6);
                    return rVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            private com.bytedance.sdk.component.m.xt.r j(com.bytedance.sdk.component.m.xt.up upVar, Throwable th) {
                com.bytedance.sdk.component.utils.vl.xt("ImageConfig", th.getMessage());
                if (upVar != null) {
                    upVar.cw(System.currentTimeMillis());
                }
                com.bytedance.sdk.component.m.xt.r rVar = new com.bytedance.sdk.component.m.xt.r(0, th, "net failed");
                rVar.j(upVar);
                return rVar;
            }
        }).j();
    }

    @ATSMethod
    public static Context getContext() {
        return v.getContext();
    }
}
