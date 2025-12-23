package io.netty.channel.oio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractOioMessageChannel extends AbstractOioChannel {
    private final List<Object> readBuf;

    protected abstract int doReadMessages(List<Object> list) throws Exception;

    @Override // io.netty.channel.oio.AbstractOioChannel
    protected void doRead() {
        Throwable th;
        boolean z5;
        if (this.readPending) {
            boolean z6 = false;
            this.readPending = false;
            ChannelConfig config = config();
            ChannelPipeline pipeline = pipeline();
            RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
            recvBufAllocHandle.reset(config);
            do {
                try {
                    int doReadMessages = doReadMessages(this.readBuf);
                    if (doReadMessages == 0) {
                        break;
                    }
                    if (doReadMessages < 0) {
                        z5 = true;
                        break;
                    }
                    recvBufAllocHandle.incMessagesRead(doReadMessages);
                } catch (Throwable th2) {
                    th = th2;
                    z5 = false;
                }
            } while (recvBufAllocHandle.continueReading());
            z5 = false;
            th = null;
            int size = this.readBuf.size();
            if (size > 0) {
                for (int i6 = 0; i6 < size; i6++) {
                    this.readPending = false;
                    pipeline.fireChannelRead(this.readBuf.get(i6));
                }
                this.readBuf.clear();
                recvBufAllocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                z6 = true;
            }
            if (th != null) {
                boolean z7 = th instanceof IOException ? true : z5;
                pipeline.fireExceptionCaught(th);
                z5 = z7;
            }
            if (z5) {
                if (isOpen()) {
                    unsafe().close(unsafe().voidPromise());
                }
            } else if (this.readPending || config.isAutoRead() || (!z6 && isActive())) {
                read();
            }
        }
    }

    protected AbstractOioMessageChannel(Channel channel) {
        super(channel);
        this.readBuf = new ArrayList();
    }
}
