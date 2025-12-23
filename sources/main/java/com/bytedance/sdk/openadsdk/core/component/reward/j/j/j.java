package com.bytedance.sdk.openadsdk.core.component.reward.j.j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.xt.r;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v.up;
import com.bytedance.sdk.openadsdk.l.g;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<n, Long> f28290j = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.j.j.j$j, reason: collision with other inner class name */
    public interface InterfaceC0440j<T> {
        void j(boolean z5, T t5);
    }

    public static void j(final boolean z5, final n nVar, final InterfaceC0440j<Object> interfaceC0440j) {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            return;
        }
        f28290j.put(nVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (!TextUtils.isEmpty(ln.j(nVar))) {
            if (interfaceC0440j != null) {
                interfaceC0440j.j(false, null);
            }
            xt(z5, false, nVar, -1L, " meta == null or meta.getVideo() == null ");
        } else {
            String j6 = ln.j(nVar);
            File j7 = j(ln.ae(nVar), nVar.ly());
            com.bytedance.sdk.component.g.xt.xt r5 = up.j().xt().r();
            r5.j(j6);
            r5.j(j7.getParent(), j7.getName());
            r5.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.j.j.j.1
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                    if (xtVar.tl() && xtVar.ae() != null && xtVar.ae().exists()) {
                        InterfaceC0440j interfaceC0440j2 = InterfaceC0440j.this;
                        if (interfaceC0440j2 != null) {
                            interfaceC0440j2.j(true, null);
                        }
                        vl.j("MetaResourceCacheManager", "onResponse: RewardFullVideo preload success ");
                        j.xt(z5, true, nVar, xtVar.j(), xtVar.xt());
                        return;
                    }
                    InterfaceC0440j interfaceC0440j3 = InterfaceC0440j.this;
                    if (interfaceC0440j3 != null) {
                        interfaceC0440j3.j(false, null);
                    }
                    vl.j("MetaResourceCacheManager", "onResponse: RewardFullVideo preload fail ");
                    j.xt(z5, false, nVar, xtVar.j(), xtVar.xt());
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(r rVar, IOException iOException) {
                    InterfaceC0440j interfaceC0440j2 = InterfaceC0440j.this;
                    if (interfaceC0440j2 != null) {
                        interfaceC0440j2.j(false, null);
                    }
                    vl.j("MetaResourceCacheManager", "onFailure: RewardFullVideo preload fail ");
                    j.xt(z5, false, nVar, -2L, iOException.getMessage());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(boolean z5, boolean z6, n nVar, long j6, String str) {
        Long remove = f28290j.remove(nVar);
        long elapsedRealtime = remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue();
        String str2 = z6 ? "load_video_success" : "load_video_error";
        if (z6 || str == null) {
            str = null;
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.up(nVar, z5 ? "rewarded_video" : "fullscreen_interstitial_ad", str2, uf.j(z6, nVar, elapsedRealtime, j6, str));
    }

    private static File j(String str, int i6) {
        return new File(g.j(i6).j(), str);
    }
}
