package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static Logger sLogger;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class LogcatLogger extends Logger {
        private int mLoggingLevel;

        @Override // androidx.work.Logger
        public void debug(String tag, String message, Throwable... throwables) {
            if (this.mLoggingLevel > 3 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th = throwables[0];
        }

        @Override // androidx.work.Logger
        public void error(String tag, String message, Throwable... throwables) {
            if (this.mLoggingLevel > 6 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th = throwables[0];
        }

        @Override // androidx.work.Logger
        public void info(String tag, String message, Throwable... throwables) {
            if (this.mLoggingLevel > 4 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th = throwables[0];
        }

        @Override // androidx.work.Logger
        public void verbose(String tag, String message, Throwable... throwables) {
            if (this.mLoggingLevel > 2 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th = throwables[0];
        }

        @Override // androidx.work.Logger
        public void warning(String tag, String message, Throwable... throwables) {
            if (this.mLoggingLevel > 5 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th = throwables[0];
        }

        public LogcatLogger(int loggingLevel) {
            super(loggingLevel);
            this.mLoggingLevel = loggingLevel;
        }
    }

    public abstract void debug(String tag, String message, Throwable... throwables);

    public abstract void error(String tag, String message, Throwable... throwables);

    public abstract void info(String tag, String message, Throwable... throwables);

    public abstract void verbose(String tag, String message, Throwable... throwables);

    public abstract void warning(String tag, String message, Throwable... throwables);

    public static synchronized Logger get() {
        Logger logger;
        synchronized (Logger.class) {
            try {
                if (sLogger == null) {
                    sLogger = new LogcatLogger(3);
                }
                logger = sLogger;
            } catch (Throwable th) {
                throw th;
            }
        }
        return logger;
    }

    public static synchronized void setLogger(Logger logger) {
        synchronized (Logger.class) {
            sLogger = logger;
        }
    }

    public Logger(int loggingLevel) {
    }

    public static String tagWithPrefix(@NonNull String tag) {
        int length = tag.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append(TAG_PREFIX);
        int i6 = MAX_PREFIXED_TAG_LENGTH;
        if (length >= i6) {
            sb.append(tag.substring(0, i6));
        } else {
            sb.append(tag);
        }
        return sb.toString();
    }
}
