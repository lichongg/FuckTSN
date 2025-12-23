package cn.jpush.android.x;

import android.content.Context;
import cn.jpush.android.helper.Logger;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("jpush_notification_icon", ResIdentify.RES_TYPE_DRAWABLE, context.getPackageName());
        if (identifier == 0) {
            try {
                identifier = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).icon;
                Logger.i("ResourceHelper", "JPush.mPackageInconId == 0 ?, get icon from application info.");
                return identifier;
            } catch (Throwable th) {
                Logger.ee("ResourceHelper", "failed to get application info and icon.", th);
            }
        }
        return identifier;
    }
}
