package io.netty.channel.socket;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ChannelOutputShutdownException extends IOException {
    private static final long serialVersionUID = 6712549938359321378L;

    public ChannelOutputShutdownException(String str) {
        super(str);
    }

    public ChannelOutputShutdownException(String str, Throwable th) {
        super(str, th);
    }
}
