package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AndroidLogHandler extends Handler {

    @NotNull
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    @Override // java.util.logging.Handler
    public void publish(@NotNull LogRecord record) {
        int androidLevel;
        g0.p(record, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = record.getLoggerName();
        g0.o(loggerName, "getLoggerName(...)");
        androidLevel = AndroidLogKt.getAndroidLevel(record);
        String message = record.getMessage();
        g0.o(message, "getMessage(...)");
        androidLog.androidLog$okhttp(loggerName, androidLevel, message, record.getThrown());
    }

    private AndroidLogHandler() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }
}
