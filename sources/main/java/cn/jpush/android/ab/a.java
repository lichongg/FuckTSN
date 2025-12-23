package cn.jpush.android.ab;

import android.content.Context;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ab.c;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import com.kwad.library.solder.lib.ext.PluginError;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f3345a = "JPushStatusUtils";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f3346b;

    public static void a(Context context) {
        try {
            if (Math.abs(System.currentTimeMillis() - ((Long) Sp.get(context, Key.PushStatusSyncTime())).longValue()) > -1702967296) {
                boolean e6 = cn.jpush.android.cache.a.e(context);
                String str = f3345a;
                StringBuilder sb = new StringBuilder();
                sb.append("push current status  =");
                sb.append(e6 ? "stop " : "resume");
                Logger.d(str, sb.toString());
                if (e6) {
                    f3346b = true;
                    JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "resume", null);
                    ActionHelper.getInstance().setPushStatusWithCallBack(context, 4, 0);
                }
            }
        } catch (Throwable th) {
            Logger.d(f3345a, "syncCurrentStatus throwable=" + th);
        }
    }

    public static void a(Context context, int i6, int i7) {
        if (i6 != 0) {
            if (i7 == 0) {
                cn.jpush.android.x.b.a(context, PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD, i6, "set fail");
                return;
            } else {
                if (1 == i7) {
                    cn.jpush.android.x.b.a(context, PluginError.ERROR_UPD_REQUEST, i6, "set fail");
                    return;
                }
                return;
            }
        }
        if (i7 != 0) {
            if (1 == i7) {
                cn.jpush.android.x.b.a(context, PluginError.ERROR_UPD_REQUEST, i6, "set success");
                return;
            }
            return;
        }
        if (f3346b) {
            f3346b = false;
            Sp.set(context, Key.PushStatusSyncTime().set(Long.valueOf(System.currentTimeMillis())));
        } else {
            cn.jpush.android.x.b.a(context, PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD, i6, "set success");
        }
        cn.jpush.android.cache.a.a(context, 1);
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 0, null, null, new Object[0]);
        ActionHelper.getInstance().doSingleAction(context, "third_stop", null);
    }

    public static void a(Context context, long j6, int i6) {
        Logger.d(f3345a, "dealCallBack code=" + i6);
        c.a a6 = c.a().a(context, j6, i6);
        a(context, i6, a6 != null ? a6.f3352b : -1);
    }
}
