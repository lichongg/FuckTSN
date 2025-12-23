package com.bytedance.sdk.openadsdk.core.qv.j;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.ae;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    public static boolean hasPermission(Context context, String str) {
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5;
        if (com.kuaishou.weapon.p0.g.f36050j.equalsIgnoreCase(str) && (w5 = com.bytedance.sdk.openadsdk.core.oq.i().w()) != null && !w5.up()) {
            return false;
        }
        if (context == null) {
            context = v.getContext();
        }
        return com.bytedance.sdk.openadsdk.core.x.up.j().j(context, str);
    }

    public static void requestPermission(Activity activity, final String[] strArr, final ITTPermissionCallback iTTPermissionCallback) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                if (com.kuaishou.weapon.p0.g.f36050j.equalsIgnoreCase(strArr[i6])) {
                    com.bytedance.sdk.openadsdk.i.cw.cw.r kt = com.bytedance.sdk.openadsdk.core.oq.i().kt();
                    if (kt != null && iTTPermissionCallback != null && !kt.up()) {
                        iTTPermissionCallback.onDenied(com.kuaishou.weapon.p0.g.f36050j);
                        return;
                    }
                } else {
                    i6++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && com.bytedance.sdk.openadsdk.core.tl.j.cw(activity) < 23) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
                return;
            }
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
                return;
            }
            return;
        }
        long hashCode = activity.hashCode();
        for (String str : strArr) {
            hashCode += str.hashCode();
        }
        if (activity.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && strArr.length == 1) {
            String str2 = strArr[0];
            if (TextUtils.equals(str2, com.kuaishou.weapon.p0.g.f36049i) || TextUtils.equals(str2, com.kuaishou.weapon.p0.g.f36050j)) {
                if (iTTPermissionCallback != null) {
                    iTTPermissionCallback.onDenied(str2);
                }
                ws.j().j(false, new String[]{str2});
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.rn.ae.j(String.valueOf(hashCode), strArr, new ae.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.j.g.1
            @Override // com.bytedance.sdk.openadsdk.core.rn.ae.j
            public void onDenied(String str3) {
                ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                if (iTTPermissionCallback2 != null) {
                    iTTPermissionCallback2.onDenied(str3);
                }
                ws.j().j(false, new String[]{str3});
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.ae.j
            public void onGranted() {
                ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                if (iTTPermissionCallback2 != null) {
                    iTTPermissionCallback2.onGranted();
                }
                ws.j().j(true, strArr);
            }
        });
    }
}
