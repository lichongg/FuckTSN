package xyz.adscope.common.v2.log;

import android.content.Context;
import xyz.adscope.common.v2.dev.info.PropertiesUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SDKLog {
    private static int CURRENT_LOG_LEVEL = 0;
    private static final String LOG_CONFIG = "Scope_LogConfig.properties";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum LOG_LEVEL {
        LOG_LEVEL_ERROR(2),
        LOG_LEVEL_WARN(4),
        LOG_LEVEL_DEBUG(8),
        LOG_LEVEL_STACK(16),
        LOG_LEVEL_RENDER(32),
        LOG_LEVEL_ALL(268435455);

        private final int value;

        public int getValue() {
            return this.value;
        }

        LOG_LEVEL(int i6) {
            this.value = i6;
        }
    }

    public static void d(String str, String str2) {
        isLogLevel(LOG_LEVEL.LOG_LEVEL_DEBUG);
    }

    public static void dd(String str, String str2) {
        if (!isLogLevel(LOG_LEVEL.LOG_LEVEL_DEBUG) || str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str2.length() <= 3072) {
            return;
        }
        while (str2.length() > 3072) {
            str2 = str2.replace(str2.substring(0, 3072), "");
        }
    }

    public static void e(String str, String str2) {
        isLogLevel(LOG_LEVEL.LOG_LEVEL_ERROR);
    }

    public static boolean isLogLevel(LOG_LEVEL log_level) {
        int i6 = CURRENT_LOG_LEVEL;
        return i6 != 0 && i6 >= log_level.getValue();
    }

    public static void renderError(String str, String str2) {
        isLogLevel(LOG_LEVEL.LOG_LEVEL_RENDER);
    }

    public static void renderInfo(String str, String str2) {
        isLogLevel(LOG_LEVEL.LOG_LEVEL_RENDER);
    }

    public static void stack(Throwable th) {
        if (!isLogLevel(LOG_LEVEL.LOG_LEVEL_STACK) || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void w(String str, String str2) {
        isLogLevel(LOG_LEVEL.LOG_LEVEL_WARN);
    }

    public static void initSDKLog(Context context) {
        PropertiesUtils.getInstance().loadPropertiesFormAssets(context, LOG_CONFIG);
        int logLevel = PropertiesUtils.getInstance().getLogLevel();
        if (logLevel > 0) {
            if (logLevel > 5) {
                CURRENT_LOG_LEVEL = LOG_LEVEL.LOG_LEVEL_ALL.getValue();
            } else {
                CURRENT_LOG_LEVEL = 1 << logLevel;
            }
        }
    }

    public static void setLogLevel(LOG_LEVEL log_level) {
        CURRENT_LOG_LEVEL = log_level.getValue();
    }

    public static void i(String str, String str2) {
    }
}
