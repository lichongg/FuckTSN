package io.netty.channel;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ChannelException extends RuntimeException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 2908618315971075004L;

    public ChannelException() {
    }

    public ChannelException(String str, Throwable th) {
        super(str, th);
    }

    public ChannelException(String str) {
        super(str);
    }

    static ChannelException newStatic(String str, Throwable th) {
        if (PlatformDependent.javaVersion() >= 7) {
            return new ChannelException(str, th, true);
        }
        return new ChannelException(str, th);
    }

    public ChannelException(Throwable th) {
        super(th);
    }

    @SuppressJava6Requirement(reason = "uses Java 7+ RuntimeException.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    protected ChannelException(String str, Throwable th, boolean z5) {
        super(str, th, false, true);
    }
}
