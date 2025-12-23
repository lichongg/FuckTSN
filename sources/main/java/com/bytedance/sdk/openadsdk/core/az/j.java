package com.bytedance.sdk.openadsdk.core.az;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.xt;
import com.bytedance.sdk.component.g.xt.cw;
import com.bytedance.sdk.component.g.xt.r;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.h;
import com.bytedance.sdk.openadsdk.core.tj.wq;
import com.bytedance.sdk.openadsdk.core.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public static String f27963j = "";
    public static String xt = "";

    /* renamed from: com.bytedance.sdk.openadsdk.core.az.j$j, reason: collision with other inner class name */
    public static class RunnableC0434j implements Runnable {

        /* renamed from: j, reason: collision with root package name */
        private WeakReference<Runnable> f27967j;

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Runnable> weakReference = this.f27967j;
            Runnable runnable = weakReference != null ? weakReference.get() : null;
            if (runnable != null) {
                runnable.run();
            }
        }

        public RunnableC0434j(Runnable runnable) {
            if (runnable != null) {
                this.f27967j = new WeakReference<>(runnable);
            }
        }
    }

    public static void j(final RunnableC0434j runnableC0434j) {
        wq qb = v.xt().qb();
        final String j6 = qb == null ? null : qb.j();
        if (TextUtils.isEmpty(j6)) {
            return;
        }
        if (TextUtils.isEmpty(xt)) {
            xt = j6;
        }
        ae.xt(new g("loadPfJs") { // from class: com.bytedance.sdk.openadsdk.core.az.j.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC0434j runnableC0434j2;
                String str = j6;
                if (str != null && str.equalsIgnoreCase(j.xt)) {
                    if (TextUtils.isEmpty(j.f27963j)) {
                        j.f27963j = h.j("js_pform").xt(up.xt(j6), "");
                    }
                    if (!TextUtils.isEmpty(j.f27963j) && (runnableC0434j2 = runnableC0434j) != null) {
                        runnableC0434j2.run();
                        return;
                    }
                }
                cw cw = com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
                cw.j(j6);
                HashMap hashMap = new HashMap();
                hashMap.put("content-type", "application/json; charset=utf-8");
                cw.r(hashMap);
                cw.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.az.j.1.1
                    @Override // com.bytedance.sdk.component.g.j.j
                    public void j(r rVar, IOException iOException) {
                    }

                    @Override // com.bytedance.sdk.component.g.j.j
                    public void j(r rVar, xt xtVar) {
                        try {
                            j.f27963j = xtVar.r();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            j.xt = j6;
                            RunnableC0434j runnableC0434j3 = runnableC0434j;
                            if (runnableC0434j3 != null) {
                                runnableC0434j3.run();
                            }
                            h.j("js_pform").j();
                            h.j("js_pform").j(up.xt(j6), j.f27963j);
                        } catch (Throwable th) {
                            vl.cw("performanceH5", "TTWebViewClient : onPageFinished", th);
                        }
                    }
                });
            }
        });
    }

    public static void j(StringBuilder sb, String str, String str2) {
        int indexOf;
        if (sb == null || TextUtils.isEmpty(str) || (indexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(indexOf, str.length() + indexOf, str2);
    }
}
