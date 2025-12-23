package io.netty.util.internal.logging;

import j5.a;
import org.slf4j.c;
import org.slf4j.d;
import org.slf4j.helpers.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class Slf4JLoggerFactory extends InternalLoggerFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLoggerFactory INSTANCE = new Slf4JLoggerFactory();

    @Deprecated
    public Slf4JLoggerFactory() {
    }

    Slf4JLoggerFactory(boolean z5) {
        if (d.h() instanceof e) {
            throw new NoClassDefFoundError("NOPLoggerFactory not supported");
        }
    }

    static InternalLogger wrapLogger(c cVar) {
        return cVar instanceof a ? new LocationAwareSlf4JLogger((a) cVar) : new Slf4JLogger(cVar);
    }

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return wrapLogger(d.j(str));
    }
}
