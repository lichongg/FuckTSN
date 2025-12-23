package com.bytedance.sdk.openadsdk.core.qv.r;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.ae;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl {
    public static void j(Activity activity, final String[] strArr, final m mVar) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                if (com.kuaishou.weapon.p0.g.f36050j.equalsIgnoreCase(strArr[i6])) {
                    com.bytedance.sdk.openadsdk.i.cw.cw.r kt = com.bytedance.sdk.openadsdk.core.oq.i().kt();
                    if (kt != null && mVar != null && !kt.up()) {
                        mVar.j(com.kuaishou.weapon.p0.g.f36050j);
                        return;
                    }
                } else {
                    i6++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && com.bytedance.sdk.openadsdk.core.tl.j.cw(activity) < 23) {
            if (mVar != null) {
                mVar.j();
                return;
            }
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            if (mVar != null) {
                mVar.j();
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
                if (mVar != null) {
                    mVar.j(str2);
                }
                com.bytedance.sdk.openadsdk.core.kt.ws.j().j(false, new String[]{str2});
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.rn.ae.j(String.valueOf(hashCode), strArr, new ae.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.vl.1
            @Override // com.bytedance.sdk.openadsdk.core.rn.ae.j
            public void onDenied(String str3) {
                m mVar2 = m.this;
                if (mVar2 != null) {
                    mVar2.j(str3);
                }
                com.bytedance.sdk.openadsdk.core.kt.ws.j().j(false, new String[]{str3});
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.ae.j
            public void onGranted() {
                m mVar2 = m.this;
                if (mVar2 != null) {
                    mVar2.j();
                }
                com.bytedance.sdk.openadsdk.core.kt.ws.j().j(true, strArr);
            }
        });
    }

    public static boolean j(Context context, String str) {
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5;
        if (com.kuaishou.weapon.p0.g.f36050j.equalsIgnoreCase(str) && (w5 = com.bytedance.sdk.openadsdk.core.oq.i().w()) != null && !w5.up()) {
            return false;
        }
        if (context == null) {
            context = v.getContext();
        }
        return com.bytedance.sdk.openadsdk.core.x.up.j().j(context, str);
    }
}
