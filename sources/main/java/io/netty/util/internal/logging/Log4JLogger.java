package io.netty.util.internal.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class Log4JLogger extends AbstractInternalLogger {
    static final String FQCN = "io.netty.util.internal.logging.Log4JLogger";
    private static final long serialVersionUID = 2851357342488183058L;
    final transient Logger logger;
    final boolean traceCapable;

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str) {
        this.logger.log(FQCN, Level.DEBUG, str, (Throwable) null);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str) {
        this.logger.log(FQCN, Level.ERROR, str, (Throwable) null);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str) {
        this.logger.log(FQCN, Level.INFO, str, (Throwable) null);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str) {
        this.logger.log(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, str, (Throwable) null);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str) {
        this.logger.log(FQCN, Level.WARN, str, (Throwable) null);
    }

    private boolean isTraceCapable() {
        try {
            this.logger.isTraceEnabled();
            return true;
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj) {
        if (this.logger.isDebugEnabled()) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            this.logger.log(FQCN, Level.DEBUG, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj) {
        if (this.logger.isEnabledFor(Level.ERROR)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            this.logger.log(FQCN, Level.ERROR, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object obj) {
        if (this.logger.isInfoEnabled()) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            this.logger.log(FQCN, Level.INFO, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isEnabledFor(Level.ERROR);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.traceCapable ? this.logger.isTraceEnabled() : this.logger.isDebugEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isEnabledFor(Level.WARN);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj) {
        if (isTraceEnabled()) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            this.logger.log(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj) {
        if (this.logger.isEnabledFor(Level.WARN)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            this.logger.log(FQCN, Level.WARN, format.getMessage(), format.getThrowable());
        }
    }

    Log4JLogger(Logger logger) {
        super(logger.getName());
        this.logger = logger;
        this.traceCapable = isTraceCapable();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj, Object obj2) {
        if (this.logger.isDebugEnabled()) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            this.logger.log(FQCN, Level.DEBUG, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj, Object obj2) {
        if (this.logger.isEnabledFor(Level.ERROR)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            this.logger.log(FQCN, Level.ERROR, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object obj, Object obj2) {
        if (this.logger.isInfoEnabled()) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            this.logger.log(FQCN, Level.INFO, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj, Object obj2) {
        if (this.logger.isEnabledFor(Level.WARN)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            this.logger.log(FQCN, Level.WARN, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj, Object obj2) {
        if (isTraceEnabled()) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            this.logger.log(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object... objArr) {
        if (this.logger.isDebugEnabled()) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            this.logger.log(FQCN, Level.DEBUG, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object... objArr) {
        if (this.logger.isEnabledFor(Level.ERROR)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            this.logger.log(FQCN, Level.ERROR, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object... objArr) {
        if (this.logger.isInfoEnabled()) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            this.logger.log(FQCN, Level.INFO, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object... objArr) {
        if (this.logger.isEnabledFor(Level.WARN)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            this.logger.log(FQCN, Level.WARN, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Throwable th) {
        this.logger.log(FQCN, Level.DEBUG, str, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Throwable th) {
        this.logger.log(FQCN, Level.ERROR, str, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Throwable th) {
        this.logger.log(FQCN, Level.INFO, str, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Throwable th) {
        this.logger.log(FQCN, Level.WARN, str, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object... objArr) {
        if (isTraceEnabled()) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            this.logger.log(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Throwable th) {
        this.logger.log(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, str, th);
    }
}
