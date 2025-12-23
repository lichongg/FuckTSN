package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class DnsResponseDecoder<A extends SocketAddress> {
    private final DnsRecordDecoder recordDecoder;

    protected abstract DnsResponse newResponse(A a6, A a7, int i6, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) throws Exception;

    private void decodeQuestions(DnsResponse dnsResponse, ByteBuf byteBuf, int i6) throws Exception {
        while (i6 > 0) {
            dnsResponse.addRecord(DnsSection.QUESTION, (DnsRecord) this.recordDecoder.decodeQuestion(byteBuf));
            i6--;
        }
    }

    private void decodeRecords(DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf, int i6) throws Exception {
        while (i6 > 0) {
            DnsRecord decodeRecord = this.recordDecoder.decodeRecord(byteBuf);
            if (decodeRecord == null) {
                return;
            }
            dnsResponse.addRecord(dnsSection, decodeRecord);
            i6--;
        }
    }

    DnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.recordDecoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "recordDecoder");
    }

    final DnsResponse decode(A a6, A a7, ByteBuf byteBuf) throws Exception {
        boolean z5;
        boolean z6;
        boolean z7;
        int readUnsignedShort = byteBuf.readUnsignedShort();
        int readUnsignedShort2 = byteBuf.readUnsignedShort();
        if ((readUnsignedShort2 >> 15) != 0) {
            DnsResponse newResponse = newResponse(a6, a7, readUnsignedShort, DnsOpCode.valueOf((byte) ((readUnsignedShort2 >> 11) & 15)), DnsResponseCode.valueOf((byte) (readUnsignedShort2 & 15)));
            boolean z8 = true;
            if (((readUnsignedShort2 >> 8) & 1) == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            newResponse.setRecursionDesired(z5);
            if (((readUnsignedShort2 >> 10) & 1) == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            newResponse.setAuthoritativeAnswer(z6);
            if (((readUnsignedShort2 >> 9) & 1) == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            newResponse.setTruncated(z7);
            if (((readUnsignedShort2 >> 7) & 1) != 1) {
                z8 = false;
            }
            newResponse.setRecursionAvailable(z8);
            newResponse.setZ((readUnsignedShort2 >> 4) & 7);
            try {
                int readUnsignedShort3 = byteBuf.readUnsignedShort();
                int readUnsignedShort4 = byteBuf.readUnsignedShort();
                int readUnsignedShort5 = byteBuf.readUnsignedShort();
                int readUnsignedShort6 = byteBuf.readUnsignedShort();
                decodeQuestions(newResponse, byteBuf, readUnsignedShort3);
                decodeRecords(newResponse, DnsSection.ANSWER, byteBuf, readUnsignedShort4);
                decodeRecords(newResponse, DnsSection.AUTHORITY, byteBuf, readUnsignedShort5);
                decodeRecords(newResponse, DnsSection.ADDITIONAL, byteBuf, readUnsignedShort6);
                return newResponse;
            } catch (Throwable th) {
                newResponse.release();
                throw th;
            }
        }
        throw new CorruptedFrameException("not a response");
    }
}
