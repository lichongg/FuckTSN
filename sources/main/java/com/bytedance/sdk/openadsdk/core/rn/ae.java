package com.bytedance.sdk.openadsdk.core.rn;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.av;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, j> f30052j = Collections.synchronizedMap(new HashMap());
    private static com.bytedance.sdk.openadsdk.core.av xt;

    public interface j {
        void onDenied(String str);

        void onGranted();
    }

    private static j xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f30052j.remove(str);
    }

    public static void j(String str, String[] strArr, j jVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        j(str, jVar);
        TTDelegateActivity.j(str, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.av xt() {
        if (xt == null) {
            xt = av.j.j(com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(com.bytedance.sdk.openadsdk.core.v.getContext()).j(4));
        }
        return xt;
    }

    public static void j(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            com.bytedance.sdk.component.oq.ae.cw().execute(new com.bytedance.sdk.component.oq.g("handleYes", 5) { // from class: com.bytedance.sdk.openadsdk.core.rn.ae.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ae.xt().xt(str, (String) null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        j xt2 = xt(str);
        if (xt2 == null) {
            return;
        }
        xt2.onGranted();
    }

    public static void j(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            com.bytedance.sdk.component.oq.ae.cw().execute(new com.bytedance.sdk.component.oq.g("handleNo", 5) { // from class: com.bytedance.sdk.openadsdk.core.rn.ae.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ae.xt().xt(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        j xt2 = xt(str);
        if (xt2 == null) {
            return;
        }
        xt2.onDenied(str2);
    }

    private static void j(final String str, final j jVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("addListener") { // from class: com.bytedance.sdk.openadsdk.core.rn.ae.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.vl.r("MultiProcess", "getListenerManager().registerPermissionListener...");
                        ae.xt().j(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.xt(jVar));
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.vl.j(th);
                        com.bytedance.sdk.component.utils.vl.r("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            f30052j.put(str, jVar);
        }
    }
}
