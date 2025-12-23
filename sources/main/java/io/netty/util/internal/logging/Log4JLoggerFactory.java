package io.netty.util.internal.logging;

import org.apache.log4j.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Log4JLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE = new Log4JLoggerFactory();

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return new Log4JLogger(Logger.getLogger(str));
    }

    @Deprecated
    public Log4JLoggerFactory() {
    }
}
