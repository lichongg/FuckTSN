package xyz.adscope.common.info.deviceinfo;

import com.acse.ottn.l3;
import java.lang.reflect.Method;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SysProp {

    /* renamed from: a, reason: collision with root package name */
    private static Method f56419a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f56420b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f56421c;

    static {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("getLong")) {
                    f56419a = method;
                } else if (name.equals(l3.f4738h)) {
                    f56421c = method;
                } else if (name.equals(l3.f4736f)) {
                    f56420b = method;
                }
            }
        } catch (ClassNotFoundException e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
        }
    }

    public static String get(String str, String str2) {
        try {
            return (String) f56420b.invoke(null, str, str2);
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
            return str2;
        }
    }

    public static long getLong(String str, long j6) {
        try {
            return ((Long) f56419a.invoke(null, str, Long.valueOf(j6))).longValue();
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
            return j6;
        }
    }

    public static void set(String str, String str2) {
        try {
            f56421c.invoke(null, str, str2);
        } catch (Throwable th) {
            LogUtil.e(CommonConstants.TAG, "e : " + th);
        }
    }

    private SysProp() {
    }
}
