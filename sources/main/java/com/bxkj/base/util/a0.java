package com.bxkj.base.util;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a0 {
    public static boolean a(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
        if (runningServices.size() <= 0) {
            return false;
        }
        for (int i6 = 0; i6 < runningServices.size(); i6++) {
            if (runningServices.get(i6).service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
