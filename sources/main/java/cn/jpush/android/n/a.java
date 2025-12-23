package cn.jpush.android.n;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static void a(Context context, String str) {
        Logger.dd("GeoCallbackHelper", "onGeofenceReceived,geos:" + str);
        a(context, "cn.jpush.android.intent.GEO_RECEIVED", str, 0.0d, 0.0d);
    }

    public static void a(Context context, String str, double d6, double d7) {
        Logger.dd("GeoCallbackHelper", "onGeofenceRegion,geo:" + str + ",lat:" + d6 + ",lng:" + d7);
        a(context, "cn.jpush.android.intent.GEO_REGION", str, d6, d7);
    }

    public static void a(Context context, String str, String str2, double d6, double d7) {
        if (context == null) {
            return;
        }
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.d("GeoCallbackHelper", "not found messageReceiver");
                return;
            }
            Intent intent = new Intent(context, Class.forName(messageReceiverClass));
            intent.setAction(str);
            intent.putExtra("geo", str2);
            intent.putExtra("geoLat", d6);
            intent.putExtra("geoLng", d7);
            cn.jpush.android.helper.a.a(context, intent);
        } catch (Throwable th) {
            Logger.ww("GeoCallbackHelper", "onResult error:" + th);
        }
    }
}
