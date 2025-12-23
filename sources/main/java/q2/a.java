package q2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.PermissionChecker;
import com.snail.antifake.deviceid.e;
import com.snail.antifake.jni.PropertiesGet;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import p2.b;
import p2.c;
import tv.cjump.jni.DeviceUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: q2.a$a, reason: collision with other inner class name */
    public interface InterfaceC1005a {
        void a();

        void b(boolean z5);
    }

    public static boolean a(Context context, String str) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion < 23) {
                    return PermissionChecker.checkSelfPermission(context, str) == 0;
                }
                checkSelfPermission = context.checkSelfPermission(str);
                return checkSelfPermission == 0;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public static String b() {
        e.a b6 = e.b("cat /proc/cpuinfo", false);
        return b6 == null ? "" : b6.f37544b;
    }

    public static String c() {
        return PropertiesGet.a("ro.kernel.qemu");
    }

    public static String g() {
        File file = new File("/proc/tty/drivers");
        StringBuilder sb = new StringBuilder();
        if (!file.exists() || !file.canRead()) {
            return "";
        }
        try {
            char[] cArr = new char[1024];
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            while (true) {
                int read = inputStreamReader.read(cArr, 0, 1024);
                if (read < 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return sb.toString();
    }

    public static boolean h() {
        return new File("/dev/socket/qemud").exists();
    }

    public static boolean i() {
        return new File("/dev/socket/qemud").exists();
    }

    private static boolean k() {
        e.a b6 = e.b("cat /proc/cpuinfo", false);
        String str = b6 == null ? "" : b6.f37544b;
        return !TextUtils.isEmpty(str) && (str.toLowerCase().contains("intel") || str.toLowerCase().contains("amd"));
    }

    public static boolean l(Context context) {
        if (!TextUtils.isEmpty(PropertiesGet.a("ro.product.model")) && PropertiesGet.a("ro.product.model").toLowerCase().contains("sdk")) {
            return true;
        }
        if (TextUtils.isEmpty(PropertiesGet.a("ro.product.manufacturer")) || !PropertiesGet.a("ro.product.manufacture").toLowerCase().contains("unknown")) {
            return !TextUtils.isEmpty(PropertiesGet.a("ro.product.device")) && PropertiesGet.a("ro.product.device").toLowerCase().contains("generic");
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean m(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            str = null;
        }
        return !TextUtils.isEmpty(str) && TextUtils.isEmpty(b.b(context)) && TextUtils.isEmpty(c.b(context));
    }

    public static boolean o(Context context) {
        return "1".equals(PropertiesGet.a("ro.kernel.qemu"));
    }

    public static String d(Context context) {
        return p2.a.a(context);
    }

    public static String e(Context context) {
        return b.b(context);
    }

    public static String f(Context context) {
        return c.b(context);
    }

    private static boolean j() {
        String e6 = com.snail.antifake.deviceid.a.e();
        if (!TextUtils.isEmpty(e6) && e6.contains(DeviceUtils.f54642a)) {
            return true;
        }
        return false;
    }

    public static boolean n(Context context) {
        if (!o(context) && !l(context) && !j() && !k()) {
            return false;
        }
        return true;
    }
}
