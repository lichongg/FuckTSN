package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SmtpRequestEncoder extends MessageToMessageEncoder<Object> {
    private static final int CRLF_SHORT = 3338;
    private static final ByteBuf DOT_CRLF_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(3).writeByte(46).writeByte(13).writeByte(10));
    private static final byte SP = 32;
    private boolean contentExpected;

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return (obj instanceof SmtpRequest) || (obj instanceof SmtpContent);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        boolean z5 = false;
        if (obj instanceof SmtpRequest) {
            SmtpRequest smtpRequest = (SmtpRequest) obj;
            if (this.contentExpected) {
                if (!smtpRequest.command().equals(SmtpCommand.RSET)) {
                    throw new IllegalStateException("SmtpContent expected");
                }
                this.contentExpected = false;
            }
            ByteBuf buffer = channelHandlerContext.alloc().buffer();
            try {
                smtpRequest.command().encode(buffer);
                writeParameters(smtpRequest.parameters(), buffer);
                ByteBufUtil.writeShortBE(buffer, CRLF_SHORT);
                list.add(buffer);
                try {
                    if (smtpRequest.command().isContentExpected()) {
                        this.contentExpected = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (z5) {
                        buffer.release();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z5 = true;
            }
        }
        if (obj instanceof SmtpContent) {
            if (!this.contentExpected) {
                throw new IllegalStateException("No SmtpContent expected");
            }
            list.add(((SmtpContent) obj).content().retain());
            if (obj instanceof LastSmtpContent) {
                list.add(DOT_CRLF_BUFFER.retainedDuplicate());
                this.contentExpected = false;
            }
        }
    }

    private static void writeParameters(List<CharSequence> list, ByteBuf byteBuf) {
        if (!list.isEmpty()) {
            byteBuf.writeByte(32);
            if (list instanceof RandomAccess) {
                int size = list.size() - 1;
                for (int i6 = 0; i6 < size; i6++) {
                    ByteBufUtil.writeAscii(byteBuf, list.get(i6));
                    byteBuf.writeByte(32);
                }
                ByteBufUtil.writeAscii(byteBuf, list.get(size));
                return;
            }
            Iterator<CharSequence> it = list.iterator();
            while (true) {
                ByteBufUtil.writeAscii(byteBuf, it.next());
                if (it.hasNext()) {
                    byteBuf.writeByte(32);
                } else {
                    return;
                }
            }
        }
    }
}
