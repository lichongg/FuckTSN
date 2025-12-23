package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpHeaders;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class HttpPostBodyUtil {
    public static final String DEFAULT_BINARY_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TEXT_CONTENT_TYPE = "text/plain";
    public static final int chunkSize = 8096;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SeekAheadOptimize {
        ByteBuf buffer;
        byte[] bytes;
        int limit;
        int origPos;
        int pos;
        int readerIndex;

        int getReadPosition(int i6) {
            return (i6 - this.origPos) + this.readerIndex;
        }

        void setReadPosition(int i6) {
            int i7 = this.pos - i6;
            this.pos = i7;
            int readPosition = getReadPosition(i7);
            this.readerIndex = readPosition;
            this.buffer.readerIndex(readPosition);
        }

        SeekAheadOptimize(ByteBuf byteBuf) {
            if (byteBuf.hasArray()) {
                this.buffer = byteBuf;
                this.bytes = byteBuf.array();
                this.readerIndex = byteBuf.readerIndex();
                int arrayOffset = byteBuf.arrayOffset() + this.readerIndex;
                this.pos = arrayOffset;
                this.origPos = arrayOffset;
                this.limit = byteBuf.arrayOffset() + byteBuf.writerIndex();
                return;
            }
            throw new IllegalArgumentException("buffer hasn't backing byte array");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum TransferEncodingMechanism {
        BIT7("7bit"),
        BIT8("8bit"),
        BINARY(HttpHeaders.Values.BINARY);

        private final String value;

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        TransferEncodingMechanism(String str) {
            this.value = str;
        }
    }

    private HttpPostBodyUtil() {
    }

    static int findEndOfString(String str) {
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    static int findNonWhitespace(String str, int i6) {
        while (i6 < str.length() && Character.isWhitespace(str.charAt(i6))) {
            i6++;
        }
        return i6;
    }
}
