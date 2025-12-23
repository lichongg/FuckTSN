package com.bytedance.sdk.openadsdk.core.qv;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final LruCache<String, com.bytedance.sdk.openadsdk.core.tj.r> f29951j = new LruCache<>(10);

    public static void j(String str, com.bytedance.sdk.openadsdk.core.tj.r rVar) {
        if (v.xt().ij() && !TextUtils.isEmpty(str) && rVar != null && rVar.up()) {
            f29951j.put(str, rVar);
        }
    }

    public static com.bytedance.sdk.openadsdk.core.tj.r j(String str) {
        com.bytedance.sdk.openadsdk.core.tj.r rVar;
        if (v.xt().ij() && (rVar = f29951j.get(str)) != null && rVar.up()) {
            return rVar;
        }
        return null;
    }

    public static void j(final n nVar) {
        if (v.xt().ij() && nVar != null) {
            final String xt = nVar.by() != null ? nVar.by().xt() : "";
            if (!TextUtils.isEmpty(xt) && nVar.jl() == 4 && TextUtils.isEmpty(nVar.vm())) {
                if ((nVar.fx() == null || nVar.fx().xt() == 0) && oq.j(nVar) == 2) {
                    com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("preloadAppInfo") { // from class: com.bytedance.sdk.openadsdk.core.qv.j.1
                        @Override // java.lang.Runnable
                        public void run() {
                            v.j().j(nVar, xt);
                        }
                    });
                }
            }
        }
    }
}
