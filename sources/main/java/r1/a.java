package r1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    public static String c(Context context, String str, String str2) {
        if (context == null) {
            return String.format(Locale.ROOT, str + "/%s", a());
        }
        String packageName = (ContextHolder.getAppContext() == null ? context : ContextHolder.getAppContext()).getPackageName();
        String b6 = b(context);
        Locale locale = Locale.ROOT;
        String str3 = "%s/%s (Linux; Android %s; %s) " + str + "/%s %s";
        String a6 = a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        return String.format(locale, str3, packageName, b6, Build.VERSION.RELEASE, Build.MODEL, a6, str2);
    }

    public static String a() {
        return "7.0.2.301";
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e6) {
            Logger.w("AgentUtil", "", e6);
            return "";
        }
    }

    public static String d(Context context, String str, String str2) {
        return c(context, str, str2);
    }
}
