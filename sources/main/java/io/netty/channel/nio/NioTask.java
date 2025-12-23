package io.netty.channel.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface NioTask<C extends SelectableChannel> {
    void channelReady(C c6, SelectionKey selectionKey) throws Exception;

    void channelUnregistered(C c6, Throwable th) throws Exception;
}
