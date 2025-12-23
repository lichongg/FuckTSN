package io.netty.util.internal.logging;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.StringUtil;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractInternalLogger implements InternalLogger, Serializable {
    static final String EXCEPTION_MESSAGE = "Unexpected exception:";
    private static final long serialVersionUID = -6382972526573193470L;
    private final String name;

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str, Throwable th) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i6 == 1) {
            trace(str, th);
            return;
        }
        if (i6 == 2) {
            debug(str, th);
            return;
        }
        if (i6 == 3) {
            info(str, th);
        } else if (i6 == 4) {
            warn(str, th);
        } else {
            if (i6 != 5) {
                throw new Error();
            }
            error(str, th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.util.internal.logging.AbstractInternalLogger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$util$internal$logging$InternalLogLevel;

        static {
            int[] iArr = new int[InternalLogLevel.values().length];
            $SwitchMap$io$netty$util$internal$logging$InternalLogLevel = iArr;
            try {
                iArr[InternalLogLevel.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(Throwable th) {
        debug(EXCEPTION_MESSAGE, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(Throwable th) {
        error(EXCEPTION_MESSAGE, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(Throwable th) {
        info(EXCEPTION_MESSAGE, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isEnabled(InternalLogLevel internalLogLevel) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i6 == 1) {
            return isTraceEnabled();
        }
        if (i6 == 2) {
            return isDebugEnabled();
        }
        if (i6 == 3) {
            return isInfoEnabled();
        }
        if (i6 == 4) {
            return isWarnEnabled();
        }
        if (i6 == 5) {
            return isErrorEnabled();
        }
        throw new Error();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public String name() {
        return this.name;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + name() + ')';
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(Throwable th) {
        trace(EXCEPTION_MESSAGE, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(Throwable th) {
        warn(EXCEPTION_MESSAGE, th);
    }

    protected AbstractInternalLogger(String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new NullPointerException(CommonNetImpl.NAME);
    }

    protected Object readResolve() throws ObjectStreamException {
        return InternalLoggerFactory.getInstance(name());
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, Throwable th) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i6 == 1) {
            trace(th);
            return;
        }
        if (i6 == 2) {
            debug(th);
            return;
        }
        if (i6 == 3) {
            info(th);
        } else if (i6 == 4) {
            warn(th);
        } else {
            if (i6 == 5) {
                error(th);
                return;
            }
            throw new Error();
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i6 == 1) {
            trace(str);
            return;
        }
        if (i6 == 2) {
            debug(str);
            return;
        }
        if (i6 == 3) {
            info(str);
        } else if (i6 == 4) {
            warn(str);
        } else {
            if (i6 == 5) {
                error(str);
                return;
            }
            throw new Error();
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str, Object obj) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i6 == 1) {
            trace(str, obj);
            return;
        }
        if (i6 == 2) {
            debug(str, obj);
            return;
        }
        if (i6 == 3) {
            info(str, obj);
        } else if (i6 == 4) {
            warn(str, obj);
        } else {
            if (i6 == 5) {
                error(str, obj);
                return;
            }
            throw new Error();
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str, Object obj, Object obj2) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i6 == 1) {
            trace(str, obj, obj2);
            return;
        }
        if (i6 == 2) {
            debug(str, obj, obj2);
            return;
        }
        if (i6 == 3) {
            info(str, obj, obj2);
        } else if (i6 == 4) {
            warn(str, obj, obj2);
        } else {
            if (i6 == 5) {
                error(str, obj, obj2);
                return;
            }
            throw new Error();
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str, Object... objArr) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i6 == 1) {
            trace(str, objArr);
            return;
        }
        if (i6 == 2) {
            debug(str, objArr);
            return;
        }
        if (i6 == 3) {
            info(str, objArr);
        } else if (i6 == 4) {
            warn(str, objArr);
        } else {
            if (i6 == 5) {
                error(str, objArr);
                return;
            }
            throw new Error();
        }
    }
}
