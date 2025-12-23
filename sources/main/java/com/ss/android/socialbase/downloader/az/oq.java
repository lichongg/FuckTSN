package com.ss.android.socialbase.downloader.az;

import android.content.Context;
import android.content.pm.ServiceInfo;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes6.dex */
public class oq {
    public static boolean j(Context context, String str, String str2) {
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(str, 4).services) {
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        return false;
    }
}
