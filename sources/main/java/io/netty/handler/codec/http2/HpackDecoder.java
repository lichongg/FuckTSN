package io.netty.handler.codec.http2;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.HpackUtil;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class HpackDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Http2Exception DECODE_ILLEGAL_INDEX_VALUE;
    private static final Http2Exception DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception INDEX_HEADER_ILLEGAL_INDEX_VALUE;
    private static final Http2Exception INVALID_MAX_DYNAMIC_TABLE_SIZE;
    private static final Http2Exception MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
    private static final byte READ_HEADER_REPRESENTATION = 0;
    private static final byte READ_INDEXED_HEADER = 2;
    private static final byte READ_INDEXED_HEADER_NAME = 3;
    private static final byte READ_LITERAL_HEADER_NAME = 6;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH = 5;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH_PREFIX = 4;
    private static final byte READ_LITERAL_HEADER_VALUE = 9;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH = 8;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH_PREFIX = 7;
    private static final byte READ_MAX_DYNAMIC_TABLE_SIZE = 1;
    private static final Http2Exception READ_NAME_ILLEGAL_INDEX_VALUE;
    private long encoderMaxDynamicTableSize;
    private final HpackDynamicTable hpackDynamicTable;
    private final HpackHuffmanDecoder huffmanDecoder;
    private long maxDynamicTableSize;
    private boolean maxDynamicTableSizeChangeRequired;
    private long maxHeaderListSize;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum HeaderType {
        REGULAR_HEADER,
        REQUEST_PSEUDO_HEADER,
        RESPONSE_PSEUDO_HEADER
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Http2HeadersSink implements Sink {
        private boolean exceededMaxLength;
        private final Http2Headers headers;
        private long headersLength;
        private final long maxHeaderListSize;
        private HeaderType previousType;
        private final int streamId;
        private final boolean validate;
        private Http2Exception validationException;

        @Override // io.netty.handler.codec.http2.HpackDecoder.Sink
        public void appendToHeaderList(CharSequence charSequence, CharSequence charSequence2) {
            long sizeOf = this.headersLength + HpackHeaderField.sizeOf(charSequence, charSequence2);
            this.headersLength = sizeOf;
            boolean z5 = (sizeOf > this.maxHeaderListSize) | this.exceededMaxLength;
            this.exceededMaxLength = z5;
            if (z5 || this.validationException != null) {
                return;
            }
            if (this.validate) {
                try {
                    this.previousType = HpackDecoder.validate(this.streamId, charSequence, this.previousType);
                } catch (Http2Exception e6) {
                    this.validationException = e6;
                    return;
                }
            }
            this.headers.add((Http2Headers) charSequence, charSequence2);
        }

        @Override // io.netty.handler.codec.http2.HpackDecoder.Sink
        public void finish() throws Http2Exception {
            if (this.exceededMaxLength) {
                Http2CodecUtil.headerListSizeExceeded(this.streamId, this.maxHeaderListSize, true);
                return;
            }
            Http2Exception http2Exception = this.validationException;
            if (http2Exception != null) {
                throw http2Exception;
            }
        }

        Http2HeadersSink(int i6, Http2Headers http2Headers, long j6, boolean z5) {
            this.headers = http2Headers;
            this.maxHeaderListSize = j6;
            this.streamId = i6;
            this.validate = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface Sink {
        void appendToHeaderList(CharSequence charSequence, CharSequence charSequence2);

        void finish() throws Http2Exception;
    }

    HpackDecoder(long j6) {
        this(j6, 4096);
    }

    static int decodeULE128(ByteBuf byteBuf, int i6) throws Http2Exception {
        int readerIndex = byteBuf.readerIndex();
        long decodeULE128 = decodeULE128(byteBuf, i6);
        if (decodeULE128 <= 2147483647L) {
            return (int) decodeULE128;
        }
        byteBuf.readerIndex(readerIndex);
        throw DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION;
    }

    public void decode(int i6, ByteBuf byteBuf, Http2Headers http2Headers, boolean z5) throws Http2Exception {
        Http2HeadersSink http2HeadersSink = new Http2HeadersSink(i6, http2Headers, this.maxHeaderListSize, z5);
        decode(byteBuf, http2HeadersSink);
        http2HeadersSink.finish();
    }

    @Deprecated
    public void setMaxHeaderListSize(long j6, long j7) throws Http2Exception {
        setMaxHeaderListSize(j6);
    }

    public void setMaxHeaderTableSize(long j6) throws Http2Exception {
        if (j6 < 0 || j6 > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j6));
        }
        this.maxDynamicTableSize = j6;
        if (j6 < this.encoderMaxDynamicTableSize) {
            this.maxDynamicTableSizeChangeRequired = true;
            this.hpackDynamicTable.setCapacity(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.HpackDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType = iArr;
            try {
                iArr[HpackUtil.IndexType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        Http2Error http2Error = Http2Error.COMPRESSION_ERROR;
        Http2Exception.ShutdownHint shutdownHint = Http2Exception.ShutdownHint.HARD_SHUTDOWN;
        DECODE_ULE_128_DECOMPRESSION_EXCEPTION = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(http2Error, "HPACK - decompression failure", shutdownHint), HpackDecoder.class, "decodeULE128(..)");
        DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(http2Error, "HPACK - long overflow", shutdownHint), HpackDecoder.class, "decodeULE128(..)");
        DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(http2Error, "HPACK - int overflow", shutdownHint), HpackDecoder.class, "decodeULE128ToInt(..)");
        DECODE_ILLEGAL_INDEX_VALUE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(http2Error, "HPACK - illegal index value", shutdownHint), HpackDecoder.class, "decode(..)");
        INDEX_HEADER_ILLEGAL_INDEX_VALUE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(http2Error, "HPACK - illegal index value", shutdownHint), HpackDecoder.class, "indexHeader(..)");
        READ_NAME_ILLEGAL_INDEX_VALUE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(http2Error, "HPACK - illegal index value", shutdownHint), HpackDecoder.class, "readName(..)");
        INVALID_MAX_DYNAMIC_TABLE_SIZE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(http2Error, "HPACK - invalid max dynamic table size", shutdownHint), HpackDecoder.class, "setDynamicTableSize(..)");
        MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(http2Error, "HPACK - max dynamic table size change required", shutdownHint), HpackDecoder.class, "decode(..)");
    }

    HpackDecoder(long j6, int i6) {
        this.huffmanDecoder = new HpackHuffmanDecoder();
        this.maxHeaderListSize = ObjectUtil.checkPositive(j6, "maxHeaderListSize");
        long j7 = i6;
        this.encoderMaxDynamicTableSize = j7;
        this.maxDynamicTableSize = j7;
        this.maxDynamicTableSizeChangeRequired = false;
        this.hpackDynamicTable = new HpackDynamicTable(j7);
    }

    private HpackHeaderField getIndexedHeader(int i6) throws Http2Exception {
        int i7 = HpackStaticTable.length;
        if (i6 <= i7) {
            return HpackStaticTable.getEntry(i6);
        }
        if (i6 - i7 <= this.hpackDynamicTable.length()) {
            return this.hpackDynamicTable.getEntry(i6 - i7);
        }
        throw INDEX_HEADER_ILLEGAL_INDEX_VALUE;
    }

    private static IllegalArgumentException notEnoughDataException(ByteBuf byteBuf) {
        return new IllegalArgumentException("decode only works with an entire header block! " + byteBuf);
    }

    private CharSequence readName(int i6) throws Http2Exception {
        int i7 = HpackStaticTable.length;
        if (i6 <= i7) {
            return HpackStaticTable.getEntry(i6).name;
        }
        if (i6 - i7 <= this.hpackDynamicTable.length()) {
            return this.hpackDynamicTable.getEntry(i6 - i7).name;
        }
        throw READ_NAME_ILLEGAL_INDEX_VALUE;
    }

    private CharSequence readStringLiteral(ByteBuf byteBuf, int i6, boolean z5) throws Http2Exception {
        if (z5) {
            return this.huffmanDecoder.decode(byteBuf, i6);
        }
        byte[] bArr = new byte[i6];
        byteBuf.readBytes(bArr);
        return new AsciiString(bArr, false);
    }

    private void setDynamicTableSize(long j6) throws Http2Exception {
        if (j6 > this.maxDynamicTableSize) {
            throw INVALID_MAX_DYNAMIC_TABLE_SIZE;
        }
        this.encoderMaxDynamicTableSize = j6;
        this.maxDynamicTableSizeChangeRequired = false;
        this.hpackDynamicTable.setCapacity(j6);
    }

    HpackHeaderField getHeaderField(int i6) {
        return this.hpackDynamicTable.getEntry(i6 + 1);
    }

    public long getMaxHeaderListSize() {
        return this.maxHeaderListSize;
    }

    public long getMaxHeaderTableSize() {
        return this.hpackDynamicTable.capacity();
    }

    int length() {
        return this.hpackDynamicTable.length();
    }

    public void setMaxHeaderListSize(long j6) throws Http2Exception {
        if (j6 < 0 || j6 > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j6));
        }
        this.maxHeaderListSize = j6;
    }

    long size() {
        return this.hpackDynamicTable.size();
    }

    private void insertHeader(Sink sink, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType) {
        sink.appendToHeaderList(charSequence, charSequence2);
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[indexType.ordinal()];
        if (i6 != 1 && i6 != 2) {
            if (i6 == 3) {
                this.hpackDynamicTable.add(new HpackHeaderField(charSequence, charSequence2));
                return;
            }
            throw new Error("should not reach here");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HeaderType validate(int i6, CharSequence charSequence, HeaderType headerType) throws Http2Exception {
        HeaderType headerType2;
        if (Http2Headers.PseudoHeaderName.hasPseudoHeaderFormat(charSequence)) {
            if (headerType != HeaderType.REGULAR_HEADER) {
                Http2Headers.PseudoHeaderName pseudoHeader = Http2Headers.PseudoHeaderName.getPseudoHeader(charSequence);
                if (pseudoHeader != null) {
                    if (pseudoHeader.isRequestOnly()) {
                        headerType2 = HeaderType.REQUEST_PSEUDO_HEADER;
                    } else {
                        headerType2 = HeaderType.RESPONSE_PSEUDO_HEADER;
                    }
                    if (headerType != null && headerType2 != headerType) {
                        throw Http2Exception.streamError(i6, Http2Error.PROTOCOL_ERROR, "Mix of request and response pseudo-headers.", new Object[0]);
                    }
                    return headerType2;
                }
                throw Http2Exception.streamError(i6, Http2Error.PROTOCOL_ERROR, "Invalid HTTP/2 pseudo-header '%s' encountered.", charSequence);
            }
            throw Http2Exception.streamError(i6, Http2Error.PROTOCOL_ERROR, "Pseudo-header field '%s' found after regular header.", charSequence);
        }
        return HeaderType.REGULAR_HEADER;
    }

    private void decode(ByteBuf byteBuf, Sink sink) throws Http2Exception {
        HpackUtil.IndexType indexType = HpackUtil.IndexType.NONE;
        CharSequence charSequence = null;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        boolean z5 = false;
        while (byteBuf.isReadable()) {
            switch (i6) {
                case 0:
                    byte readByte = byteBuf.readByte();
                    if (this.maxDynamicTableSizeChangeRequired && (readByte & 224) != 32) {
                        throw MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
                    }
                    if (readByte < 0) {
                        i7 = readByte & Byte.MAX_VALUE;
                        if (i7 == 0) {
                            throw DECODE_ILLEGAL_INDEX_VALUE;
                        }
                        if (i7 != 127) {
                            HpackHeaderField indexedHeader = getIndexedHeader(i7);
                            sink.appendToHeaderList(indexedHeader.name, indexedHeader.value);
                        } else {
                            i6 = 2;
                        }
                    } else if ((readByte & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                        indexType = HpackUtil.IndexType.INCREMENTAL;
                        i7 = readByte & Utf8.REPLACEMENT_BYTE;
                        if (i7 == 0) {
                            i6 = 4;
                        } else if (i7 != 63) {
                            charSequence = readName(i7);
                            i8 = charSequence.length();
                            i6 = 7;
                        } else {
                            i6 = 3;
                        }
                    } else if ((readByte & 32) == 32) {
                        i7 = readByte & Ascii.US;
                        if (i7 == 31) {
                            i6 = 1;
                        } else {
                            setDynamicTableSize(i7);
                            i6 = 0;
                        }
                    } else {
                        indexType = (readByte & 16) == 16 ? HpackUtil.IndexType.NEVER : HpackUtil.IndexType.NONE;
                        i7 = readByte & 15;
                        if (i7 == 0) {
                            i6 = 4;
                        } else if (i7 != 15) {
                            charSequence = readName(i7);
                            i8 = charSequence.length();
                            i6 = 7;
                        } else {
                            i6 = 3;
                        }
                    }
                    break;
                case 1:
                    setDynamicTableSize(decodeULE128(byteBuf, i7));
                    i6 = 0;
                case 2:
                    HpackHeaderField indexedHeader2 = getIndexedHeader(decodeULE128(byteBuf, i7));
                    sink.appendToHeaderList(indexedHeader2.name, indexedHeader2.value);
                    i6 = 0;
                case 3:
                    charSequence = readName(decodeULE128(byteBuf, i7));
                    i8 = charSequence.length();
                    i6 = 7;
                case 4:
                    byte readByte2 = byteBuf.readByte();
                    z5 = (readByte2 & 128) == 128;
                    i7 = readByte2 & Byte.MAX_VALUE;
                    if (i7 == 127) {
                        i6 = 5;
                    } else {
                        i8 = i7;
                        i6 = 6;
                    }
                case 5:
                    i8 = decodeULE128(byteBuf, i7);
                    i6 = 6;
                case 6:
                    if (byteBuf.readableBytes() >= i8) {
                        charSequence = readStringLiteral(byteBuf, i8, z5);
                        i6 = 7;
                    } else {
                        throw notEnoughDataException(byteBuf);
                    }
                case 7:
                    byte readByte3 = byteBuf.readByte();
                    z5 = (readByte3 & 128) == 128;
                    i7 = readByte3 & Byte.MAX_VALUE;
                    if (i7 == 0) {
                        insertHeader(sink, charSequence, AsciiString.EMPTY_STRING, indexType);
                        i6 = 0;
                    } else if (i7 != 127) {
                        i9 = i7;
                        i6 = 9;
                    } else {
                        i6 = 8;
                    }
                case 8:
                    i9 = decodeULE128(byteBuf, i7);
                    i6 = 9;
                case 9:
                    if (byteBuf.readableBytes() >= i9) {
                        insertHeader(sink, charSequence, readStringLiteral(byteBuf, i9, z5), indexType);
                        i6 = 0;
                    } else {
                        throw notEnoughDataException(byteBuf);
                    }
                default:
                    throw new Error("should not reach here state: " + i6);
            }
        }
        if (i6 != 0) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "Incomplete header block fragment.", new Object[0]);
        }
    }

    static long decodeULE128(ByteBuf byteBuf, long j6) throws Http2Exception {
        int i6 = 0;
        boolean z5 = j6 == 0;
        int writerIndex = byteBuf.writerIndex();
        int readerIndex = byteBuf.readerIndex();
        while (readerIndex < writerIndex) {
            byte b6 = byteBuf.getByte(readerIndex);
            if (i6 == 56 && ((b6 & 128) != 0 || (b6 == Byte.MAX_VALUE && !z5))) {
                throw DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION;
            }
            if ((b6 & 128) == 0) {
                byteBuf.readerIndex(readerIndex + 1);
                return j6 + ((b6 & 127) << i6);
            }
            j6 += (b6 & 127) << i6;
            readerIndex++;
            i6 += 7;
        }
        throw DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    }
}
