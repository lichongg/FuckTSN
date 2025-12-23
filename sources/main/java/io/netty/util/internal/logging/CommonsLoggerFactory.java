package io.netty.util.internal.logging;

import org.apache.commons.logging.LogFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class CommonsLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE = new CommonsLoggerFactory();

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return new CommonsLogger(LogFactory.getLog(str), str);
    }

    @Deprecated
    public CommonsLoggerFactory() {
    }
}
