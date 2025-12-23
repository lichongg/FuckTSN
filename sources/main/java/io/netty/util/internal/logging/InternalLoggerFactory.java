package io.netty.util.internal.logging;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class InternalLoggerFactory {
    private static volatile InternalLoggerFactory defaultFactory;

    public static InternalLogger getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    protected abstract InternalLogger newInstance(String str);

    public static InternalLoggerFactory getDefaultFactory() {
        if (defaultFactory == null) {
            defaultFactory = newDefaultFactory(InternalLoggerFactory.class.getName());
        }
        return defaultFactory;
    }

    public static InternalLogger getInstance(String str) {
        return getDefaultFactory().newInstance(str);
    }

    private static InternalLoggerFactory newDefaultFactory(String str) {
        try {
            try {
                try {
                    Slf4JLoggerFactory slf4JLoggerFactory = new Slf4JLoggerFactory(true);
                    slf4JLoggerFactory.newInstance(str).debug("Using SLF4J as the default logging framework");
                    return slf4JLoggerFactory;
                } catch (Throwable unused) {
                    InternalLoggerFactory internalLoggerFactory = Log4J2LoggerFactory.INSTANCE;
                    internalLoggerFactory.newInstance(str).debug("Using Log4J2 as the default logging framework");
                    return internalLoggerFactory;
                }
            } catch (Throwable unused2) {
                InternalLoggerFactory internalLoggerFactory2 = JdkLoggerFactory.INSTANCE;
                internalLoggerFactory2.newInstance(str).debug("Using java.util.logging as the default logging framework");
                return internalLoggerFactory2;
            }
        } catch (Throwable unused3) {
            InternalLoggerFactory internalLoggerFactory3 = Log4JLoggerFactory.INSTANCE;
            internalLoggerFactory3.newInstance(str).debug("Using Log4J as the default logging framework");
            return internalLoggerFactory3;
        }
    }

    public static void setDefaultFactory(InternalLoggerFactory internalLoggerFactory) {
        if (internalLoggerFactory == null) {
            throw new NullPointerException("defaultFactory");
        }
        defaultFactory = internalLoggerFactory;
    }
}
