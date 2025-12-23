package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class SocketWritableByteChannel implements WritableByteChannel {
    private final FileDescriptor fd;

    protected abstract ByteBufAllocator alloc();

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.fd.close();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.fd.isOpen();
    }

    protected SocketWritableByteChannel(FileDescriptor fileDescriptor) {
        this.fd = (FileDescriptor) ObjectUtil.checkNotNull(fileDescriptor, IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) throws IOException {
        int write;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            write = this.fd.write(byteBuffer, position, byteBuffer.limit());
        } else {
            int i6 = limit - position;
            ByteBuf byteBuf = null;
            try {
                if (i6 == 0) {
                    byteBuf = Unpooled.EMPTY_BUFFER;
                } else {
                    ByteBufAllocator alloc = alloc();
                    if (alloc.isDirectBufferPooled()) {
                        byteBuf = alloc.directBuffer(i6);
                    } else {
                        byteBuf = ByteBufUtil.threadLocalDirectBuffer();
                        if (byteBuf == null) {
                            byteBuf = Unpooled.directBuffer(i6);
                        }
                    }
                }
                byteBuf.writeBytes(byteBuffer.duplicate());
                ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), i6);
                write = this.fd.write(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
                byteBuf.release();
            } catch (Throwable th) {
                if (byteBuf != null) {
                    byteBuf.release();
                }
                throw th;
            }
        }
        if (write > 0) {
            byteBuffer.position(position + write);
        }
        return write;
    }
}
