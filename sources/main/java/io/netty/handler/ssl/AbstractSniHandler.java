package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractSniHandler<T> extends ByteToMessageDecoder implements ChannelOutboundHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractSniHandler.class);
    private boolean handshakeFailed;
    private boolean readPending;
    private boolean suppressRead;

    protected abstract Future<T> lookup(ChannelHandlerContext channelHandlerContext, String str) throws Exception;

    protected abstract void onLookupComplete(ChannelHandlerContext channelHandlerContext, String str, Future<T> future) throws Exception;

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readerIndex;
        int readableBytes;
        if (this.suppressRead || this.handshakeFailed) {
            return;
        }
        try {
            readerIndex = byteBuf.readerIndex();
            readableBytes = byteBuf.readableBytes();
        } catch (NotSslRecordException e6) {
            throw e6;
        } catch (Exception e7) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Unexpected client hello packet: " + ByteBufUtil.hexDump(byteBuf), (Throwable) e7);
            }
        }
        if (readableBytes < 5) {
            return;
        }
        switch (byteBuf.getUnsignedByte(readerIndex)) {
            case 20:
            case 21:
                int encryptedPacketLength = SslUtils.getEncryptedPacketLength(byteBuf, readerIndex);
                if (encryptedPacketLength == -2) {
                    this.handshakeFailed = true;
                    NotSslRecordException notSslRecordException = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(byteBuf));
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    channelHandlerContext.fireUserEventTriggered((Object) new SniCompletionEvent(notSslRecordException));
                    SslUtils.handleHandshakeFailure(channelHandlerContext, notSslRecordException, true);
                    throw notSslRecordException;
                }
                if (encryptedPacketLength == -1) {
                    return;
                }
                break;
            case 22:
                if (byteBuf.getUnsignedByte(readerIndex + 1) == 3) {
                    int unsignedShort = byteBuf.getUnsignedShort(readerIndex + 3) + 5;
                    if (readableBytes >= unsignedShort) {
                        int i6 = unsignedShort + readerIndex;
                        int i7 = readerIndex + 43;
                        if (i6 - i7 >= 6) {
                            int unsignedByte = i7 + byteBuf.getUnsignedByte(i7) + 1;
                            int unsignedShort2 = unsignedByte + byteBuf.getUnsignedShort(unsignedByte) + 2;
                            int unsignedByte2 = unsignedShort2 + byteBuf.getUnsignedByte(unsignedShort2) + 1;
                            int unsignedShort3 = byteBuf.getUnsignedShort(unsignedByte2);
                            int i8 = unsignedByte2 + 2;
                            int i9 = unsignedShort3 + i8;
                            if (i9 <= i6) {
                                while (true) {
                                    if (i9 - i8 < 4) {
                                        break;
                                    } else {
                                        int unsignedShort4 = byteBuf.getUnsignedShort(i8);
                                        int unsignedShort5 = byteBuf.getUnsignedShort(i8 + 2);
                                        int i10 = i8 + 4;
                                        if (i9 - i10 < unsignedShort5) {
                                            break;
                                        } else if (unsignedShort4 == 0) {
                                            int i11 = i8 + 6;
                                            if (i9 - i11 < 3) {
                                                break;
                                            } else {
                                                int i12 = i8 + 7;
                                                if (byteBuf.getUnsignedByte(i11) == 0) {
                                                    int unsignedShort6 = byteBuf.getUnsignedShort(i12);
                                                    int i13 = i8 + 9;
                                                    if (i9 - i13 >= unsignedShort6) {
                                                        try {
                                                            select(channelHandlerContext, byteBuf.toString(i13, unsignedShort6, CharsetUtil.US_ASCII).toLowerCase(Locale.US));
                                                            return;
                                                        } catch (Throwable th) {
                                                            PlatformDependent.throwException(th);
                                                            return;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                        } else {
                                            i8 = i10 + unsignedShort5;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
                break;
        }
        select(channelHandlerContext, null);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.suppressRead) {
            this.readPending = true;
        } else {
            channelHandlerContext.read();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireSniCompletionEvent(ChannelHandlerContext channelHandlerContext, String str, Future<T> future) {
        Throwable cause = future.cause();
        if (cause == null) {
            channelHandlerContext.fireUserEventTriggered((Object) new SniCompletionEvent(str));
        } else {
            channelHandlerContext.fireUserEventTriggered((Object) new SniCompletionEvent(str, cause));
        }
    }

    private void select(final ChannelHandlerContext channelHandlerContext, final String str) throws Exception {
        Future<T> lookup = lookup(channelHandlerContext, str);
        if (lookup.isDone()) {
            fireSniCompletionEvent(channelHandlerContext, str, lookup);
            onLookupComplete(channelHandlerContext, str, lookup);
        } else {
            this.suppressRead = true;
            lookup.addListener(new FutureListener<T>() { // from class: io.netty.handler.ssl.AbstractSniHandler.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<T> future) throws Exception {
                    try {
                        AbstractSniHandler.this.suppressRead = false;
                        try {
                            try {
                                AbstractSniHandler.this.fireSniCompletionEvent(channelHandlerContext, str, future);
                                AbstractSniHandler.this.onLookupComplete(channelHandlerContext, str, future);
                            } catch (DecoderException e6) {
                                channelHandlerContext.fireExceptionCaught((Throwable) e6);
                            } catch (Exception e7) {
                                channelHandlerContext.fireExceptionCaught((Throwable) new DecoderException(e7));
                            }
                        } catch (Throwable th) {
                            channelHandlerContext.fireExceptionCaught(th);
                        }
                        if (AbstractSniHandler.this.readPending) {
                            AbstractSniHandler.this.readPending = false;
                            channelHandlerContext.read();
                        }
                    } catch (Throwable th2) {
                        if (AbstractSniHandler.this.readPending) {
                            AbstractSniHandler.this.readPending = false;
                            channelHandlerContext.read();
                        }
                        throw th2;
                    }
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.write(obj, channelPromise);
    }
}
