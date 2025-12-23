package cn.jiguang.am;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bi.g;
import cn.jiguang.bz.h;
import cn.jiguang.m.b;
import com.amap.api.services.core.AMapException;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static void a(Context context, int i6) {
        boolean z5;
        boolean z6;
        f.c("JNotificationState", "triggerScene:" + i6);
        if (cn.jiguang.g.a.a().a(AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING)) {
            boolean z7 = true;
            if (1 == i6 && !g.a().d()) {
                f.e("JNotificationState", "ismLoggedIn is false, triggerScene:" + i6);
                return;
            }
            String i7 = b.i(context);
            boolean a6 = a(context);
            if (!a6) {
                f.e("JNotificationState", "notification trigger is off, will not show notification");
            }
            if (!TextUtils.isEmpty(i7)) {
                if (TextUtils.equals("ON", i7)) {
                    z5 = false;
                    z6 = true;
                } else {
                    z5 = !TextUtils.equals("OFF", i7);
                    z6 = false;
                }
                if (z5) {
                    f.c("JNotificationState", "notification state do not changed");
                    z7 = z5;
                } else if (z6 == a6) {
                    z7 = false;
                }
            }
            f.c("JNotificationState", "lastCacheNotificationState:" + i7 + ",currentNotificationSate:" + a6 + ",isNeedReport:" + z7 + ",triggerScene:" + i6);
            if (!z7) {
                f.c("JNotificationState", "do not need report notification state");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notification_state", a6);
                if (cn.jiguang.g.a.a().a(AMapException.CODE_AMAP_CLIENT_ERROR_PROTOCOL)) {
                    jSONObject.put("imei", cn.jiguang.bz.a.a().d(context, ""));
                }
                if (cn.jiguang.g.a.a().a(AMapException.CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION)) {
                    jSONObject.put("device_id", h.b(context));
                }
                jSONObject.put("trigger_scene", i6);
                cn.jiguang.be.b.a(context, jSONObject, "android_notification_state");
                b.t(context, a6 ? "ON" : "OFF");
            } catch (Throwable th) {
                f.i("JNotificationState", "report notification state failed, error:" + th.getMessage());
            }
        }
    }

    private static boolean c(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
            int i6 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i6), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        } catch (Throwable th) {
            f.i("JNotificationState", "getNotificationStateCommon failed, other error:" + th.getMessage());
            return true;
        }
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? b(context) : c(context);
    }

    @TargetApi(24)
    private static boolean b(Context context) {
        boolean areNotificationsEnabled;
        try {
            areNotificationsEnabled = ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
            return areNotificationsEnabled;
        } catch (Throwable th) {
            f.i("JNotificationState", "invoke areNotificationsEnabled method failed, error:" + th.getMessage());
            return true;
        }
    }
}
