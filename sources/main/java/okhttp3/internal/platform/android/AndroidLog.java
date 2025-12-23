package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.i1;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressSignatureCheck
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;

    @NotNull
    private static final Map<String, String> knownLoggers;

    @NotNull
    public static final AndroidLog INSTANCE = new AndroidLog();

    @NotNull
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = OkHttpClient.class.getPackage();
        String name = r22 != null ? r22.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(Http2.class.getName(), "okhttp.Http2");
        linkedHashMap.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = i1.D0(linkedHashMap);
    }

    public static /* synthetic */ void androidLog$okhttp$default(AndroidLog androidLog, String str, int i6, String str2, Throwable th, int i7, Object obj) {
        if ((i7 & 8) != 0) {
            th = null;
        }
        androidLog.androidLog$okhttp(str, i6, str2, th);
    }

    private final String loggerTag(String str) {
        String str2 = knownLoggers.get(str);
        return str2 == null ? u.y9(str, 23) : str2;
    }

    public final void androidLog$okhttp(@NotNull String loggerName, int i6, @NotNull String message, @Nullable Throwable th) {
        int min;
        g0.p(loggerName, "loggerName");
        g0.p(message, "message");
        String loggerTag = loggerTag(loggerName);
        if (Log.isLoggable(loggerTag, i6)) {
            if (th != null) {
                message = message + '\n' + Log.getStackTraceString(th);
            }
            String str = message;
            int length = str.length();
            int i7 = 0;
            while (i7 < length) {
                int G3 = u.G3(str, '\n', i7, false, 4, null);
                if (G3 == -1) {
                    G3 = length;
                }
                while (true) {
                    min = Math.min(G3, i7 + 4000);
                    String substring = str.substring(i7, min);
                    g0.o(substring, "substring(...)");
                    Log.println(i6, loggerTag, substring);
                    if (min >= G3) {
                        break;
                    } else {
                        i7 = min;
                    }
                }
                i7 = min + 1;
            }
        }
    }

    public final void enable() {
        try {
            for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
                enableLogging(entry.getKey(), entry.getValue());
            }
        } catch (RuntimeException e6) {
            System.err.getClass();
            e6.printStackTrace();
        } catch (UnsatisfiedLinkError e7) {
            System.err.getClass();
            e7.printStackTrace();
        }
    }

    private AndroidLog() {
    }

    private final void enableLogging(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else if (Log.isLoggable(str2, 4)) {
                level = Level.INFO;
            } else {
                level = Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }
}
