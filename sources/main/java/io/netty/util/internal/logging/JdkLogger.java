package io.netty.util.internal.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class JdkLogger extends AbstractInternalLogger {
    static final String SELF = "io.netty.util.internal.logging.JdkLogger";
    static final String SUPER = AbstractInternalLogger.class.getName();
    private static final long serialVersionUID = -1767272577989225979L;
    final transient Logger logger;

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str) {
        Logger logger = this.logger;
        Level level = Level.INFO;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    private static void fillCallerData(String str, LogRecord logRecord) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int i6 = 0;
        while (true) {
            if (i6 >= stackTrace.length) {
                i6 = -1;
                break;
            }
            String className = stackTrace[i6].getClassName();
            if (className.equals(str) || className.equals(SUPER)) {
                break;
            } else {
                i6++;
            }
        }
        while (true) {
            i6++;
            if (i6 >= stackTrace.length) {
                i6 = -1;
                break;
            }
            String className2 = stackTrace[i6].getClassName();
            if (!className2.equals(str) && !className2.equals(SUPER)) {
                break;
            }
        }
        if (i6 != -1) {
            StackTraceElement stackTraceElement = stackTrace[i6];
            logRecord.setSourceClassName(stackTraceElement.getClassName());
            logRecord.setSourceMethodName(stackTraceElement.getMethodName());
        }
    }

    private void log(String str, Level level, String str2, Throwable th) {
        LogRecord logRecord = new LogRecord(level, str2);
        logRecord.setLoggerName(name());
        logRecord.setThrown(th);
        fillCallerData(str, logRecord);
        this.logger.log(logRecord);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isLoggable(Level.FINE);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isLoggable(Level.SEVERE);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isLoggable(Level.INFO);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.logger.isLoggable(Level.FINEST);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isLoggable(Level.WARNING);
    }

    JdkLogger(Logger logger) {
        super(logger.getName());
        this.logger = logger;
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.INFO;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.INFO;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.INFO;
        if (logger.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.INFO;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }
}
