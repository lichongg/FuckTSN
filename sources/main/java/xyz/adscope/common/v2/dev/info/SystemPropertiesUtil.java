package xyz.adscope.common.v2.dev.info;

import com.acse.ottn.l3;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class SystemPropertiesUtil {
    public static final String PROP_UTC = "ro.build.date.utc";
    private Method sysPropGet;
    private Method sysPropGetLong;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.dev.info.SystemPropertiesUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static SystemPropertiesUtil instance = new SystemPropertiesUtil(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ SystemPropertiesUtil(AnonymousClass1 anonymousClass1) {
        this();
    }

    private SystemPropertiesUtil() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
        initMethod();
    }

    private void initMethod() {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("getLong")) {
                    this.sysPropGetLong = method;
                } else if (name.equals(l3.f4736f)) {
                    this.sysPropGet = method;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    public static String get(String str, String str2) {
        try {
            if (InstanceHolder.instance.sysPropGet != null) {
                return InstanceHolder.instance.sysPropGet.invoke(null, str, str2).toString();
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    public static long getLong(String str, long j6) {
        try {
            if (InstanceHolder.instance.sysPropGetLong != null) {
                return ((Long) InstanceHolder.instance.sysPropGetLong.invoke(null, str, Long.valueOf(j6))).longValue();
            }
        } catch (Throwable unused) {
        }
        return j6;
    }
}
