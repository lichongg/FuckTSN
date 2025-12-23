package io.netty.util.internal.logging;

import java.util.logging.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class JdkLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE = new JdkLoggerFactory();

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return new JdkLogger(Logger.getLogger(str));
    }

    @Deprecated
    public JdkLoggerFactory() {
    }
}
