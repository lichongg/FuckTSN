package com.bytedance.sdk.openadsdk.core.component.splash;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.sm;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    public static void j(long j6, boolean z5, boolean z6, n nVar, long j7, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j6;
        String str2 = z5 ? z6 ? "load_video_success" : "load_video_error" : z6 ? "download_video_image_success" : "download_video_image_fail";
        if (z5) {
            Map<String, Object> j8 = uf.j(z6, nVar, elapsedRealtime, j7, str);
            j8.put("splash_show_type", 1);
            com.bytedance.sdk.openadsdk.core.jy.cw.up(nVar, "splash_ad", str2, j8);
        } else {
            Map<String, Object> xt = uf.xt(z6, nVar, elapsedRealtime, j7, str);
            xt.put("splash_show_type", 2);
            com.bytedance.sdk.openadsdk.core.jy.cw.r(nVar, "splash_ad", str2, xt);
        }
    }

    public static boolean xt(com.bytedance.sdk.openadsdk.core.tj.j jVar) {
        return (jVar == null || jVar.xt() == null || jVar.xt().isEmpty() || jVar.xt().get(0) == null) ? false : true;
    }

    public static int cw(com.bytedance.sdk.openadsdk.core.tj.j jVar) {
        if (jVar != null) {
            return jVar.j();
        }
        return 0;
    }

    public static boolean xt(n nVar) {
        if (nVar == null || nVar.wf() == 1 || ln.ws(nVar) == null || TextUtils.isEmpty(ln.j(nVar))) {
            return true;
        }
        nVar.g(true);
        return false;
    }

    public static void j(com.bytedance.sdk.openadsdk.core.tj.j jVar) {
        com.bykv.vk.openvk.component.video.api.cw.r j6;
        if (xt(jVar)) {
            n nVar = jVar.xt().get(0);
            int g6 = uf.g(nVar);
            com.bykv.vk.openvk.component.video.api.cw.cw ws = ln.ws(nVar);
            if (ws != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String vl = ws.vl();
                if (TextUtils.isEmpty(vl)) {
                    j(elapsedRealtime, true, false, nVar, -1L, "preLoadVideo videoUrl is null");
                    return;
                }
                if (TextUtils.isEmpty(ws.az())) {
                    com.bytedance.sdk.component.utils.up.xt(vl);
                }
                if (nVar.ih()) {
                    j6 = ln.j(2, nVar);
                } else {
                    j6 = ln.j(3, nVar);
                }
                j6.j("material_meta", nVar);
                if (!v.xt().tl(String.valueOf(g6)) || ws.r(v.getContext())) {
                    ws.up(0);
                    com.bykv.vk.openvk.component.video.j.j.j();
                    com.bytedance.sdk.openadsdk.core.video.r.xt.j(j6, new com.bykv.vk.openvk.component.video.api.up.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.m.1
                        @Override // com.bykv.vk.openvk.component.video.api.up.j.InterfaceC0307j
                        public void j(com.bykv.vk.openvk.component.video.api.cw.r rVar, int i6) {
                        }

                        @Override // com.bykv.vk.openvk.component.video.api.up.j.InterfaceC0307j
                        public void j(com.bykv.vk.openvk.component.video.api.cw.r rVar, int i6, String str) {
                        }
                    });
                }
            }
        }
    }

    public static int j(sm smVar) {
        if (smVar == null) {
            return 0;
        }
        int cw = cw(smVar.xt());
        return cw <= 0 ? j(smVar.j()) : cw;
    }

    public static int j(n nVar) {
        if (nVar != null) {
            return uf.g(nVar);
        }
        return 0;
    }
}
