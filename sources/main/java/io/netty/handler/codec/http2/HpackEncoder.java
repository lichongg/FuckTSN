package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.HpackUtil;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.MathUtil;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class HpackEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int HUFF_CODE_THRESHOLD = 512;
    private final byte hashMask;
    private final HeaderEntry head;
    private final HeaderEntry[] headerFields;
    private final HpackHuffmanEncoder hpackHuffmanEncoder;
    private final int huffCodeThreshold;
    private final boolean ignoreMaxHeaderListSize;
    private long maxHeaderListSize;
    private long maxHeaderTableSize;
    private long size;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class HeaderEntry extends HpackHeaderField {
        HeaderEntry after;
        HeaderEntry before;
        int hash;
        int index;
        HeaderEntry next;

        /* JADX INFO: Access modifiers changed from: private */
        public void addBefore(HeaderEntry headerEntry) {
            this.after = headerEntry;
            HeaderEntry headerEntry2 = headerEntry.before;
            this.before = headerEntry2;
            headerEntry2.after = this;
            this.after.before = this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove() {
            HeaderEntry headerEntry = this.before;
            headerEntry.after = this.after;
            this.after.before = headerEntry;
            this.before = null;
            this.after = null;
            this.next = null;
        }

        HeaderEntry(int i6, CharSequence charSequence, CharSequence charSequence2, int i7, HeaderEntry headerEntry) {
            super(charSequence, charSequence2);
            this.index = i7;
            this.hash = i6;
            this.next = headerEntry;
        }
    }

    HpackEncoder() {
        this(false);
    }

    private static void encodeInteger(ByteBuf byteBuf, int i6, int i7, int i8) {
        encodeInteger(byteBuf, i6, i7, i8);
    }

    private void encodeLiteral(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, int i6) {
        boolean z5 = i6 != -1;
        int i7 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[indexType.ordinal()];
        if (i7 == 1) {
            if (!z5) {
                i6 = 0;
            }
            encodeInteger(byteBuf, 64, 6, i6);
        } else if (i7 == 2) {
            if (!z5) {
                i6 = 0;
            }
            encodeInteger(byteBuf, 0, 4, i6);
        } else {
            if (i7 != 3) {
                throw new Error("should not reach here");
            }
            if (!z5) {
                i6 = 0;
            }
            encodeInteger(byteBuf, 16, 4, i6);
        }
        if (!z5) {
            encodeStringLiteral(byteBuf, charSequence);
        }
        encodeStringLiteral(byteBuf, charSequence2);
    }

    private int getIndex(CharSequence charSequence) {
        if (length() != 0 && charSequence != null) {
            int hashCode = AsciiString.hashCode(charSequence);
            for (HeaderEntry headerEntry = this.headerFields[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
                if (headerEntry.hash == hashCode && HpackUtil.equalsConstantTime(charSequence, headerEntry.name) != 0) {
                    return getIndex(headerEntry.index);
                }
            }
        }
        return -1;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.HpackEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType = iArr;
            try {
                iArr[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    HpackEncoder(boolean z5) {
        this(z5, 16, 512);
    }

    private void add(CharSequence charSequence, CharSequence charSequence2, long j6) {
        if (j6 > this.maxHeaderTableSize) {
            clear();
            return;
        }
        while (this.maxHeaderTableSize - this.size < j6) {
            remove();
        }
        int hashCode = AsciiString.hashCode(charSequence);
        int index = index(hashCode);
        HeaderEntry headerEntry = new HeaderEntry(hashCode, charSequence, charSequence2, this.head.before.index - 1, this.headerFields[index]);
        this.headerFields[index] = headerEntry;
        headerEntry.addBefore(this.head);
        this.size += j6;
    }

    private void clear() {
        Arrays.fill(this.headerFields, (Object) null);
        HeaderEntry headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0L;
    }

    private void encodeHeader(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, boolean z5, long j6) {
        if (z5) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NEVER, getNameIndex(charSequence));
            return;
        }
        long j7 = this.maxHeaderTableSize;
        if (j7 == 0) {
            int index = HpackStaticTable.getIndex(charSequence, charSequence2);
            if (index != -1) {
                encodeInteger(byteBuf, 128, 7, index);
                return;
            } else {
                encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, HpackStaticTable.getIndex(charSequence));
                return;
            }
        }
        if (j6 > j7) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, getNameIndex(charSequence));
            return;
        }
        HeaderEntry entry = getEntry(charSequence, charSequence2);
        if (entry != null) {
            encodeInteger(byteBuf, 128, 7, getIndex(entry.index) + HpackStaticTable.length);
            return;
        }
        int index2 = HpackStaticTable.getIndex(charSequence, charSequence2);
        if (index2 != -1) {
            encodeInteger(byteBuf, 128, 7, index2);
            return;
        }
        ensureCapacity(j6);
        encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.INCREMENTAL, getNameIndex(charSequence));
        add(charSequence, charSequence2, j6);
    }

    private static void encodeInteger(ByteBuf byteBuf, int i6, int i7, long j6) {
        int i8 = 255 >>> (8 - i7);
        long j7 = i8;
        if (j6 < j7) {
            byteBuf.writeByte((int) (i6 | j6));
            return;
        }
        byteBuf.writeByte(i6 | i8);
        long j8 = j6 - j7;
        while (((-128) & j8) != 0) {
            byteBuf.writeByte((int) ((127 & j8) | 128));
            j8 >>>= 7;
        }
        byteBuf.writeByte((int) j8);
    }

    private void ensureCapacity(long j6) {
        while (this.maxHeaderTableSize - this.size < j6 && length() != 0) {
            remove();
        }
    }

    private int index(int i6) {
        return i6 & this.hashMask;
    }

    private HpackHeaderField remove() {
        if (this.size == 0) {
            return null;
        }
        HeaderEntry headerEntry = this.head.after;
        int index = index(headerEntry.hash);
        HeaderEntry headerEntry2 = this.headerFields[index];
        HeaderEntry headerEntry3 = headerEntry2;
        while (headerEntry2 != null) {
            HeaderEntry headerEntry4 = headerEntry2.next;
            if (headerEntry2 == headerEntry) {
                if (headerEntry3 == headerEntry) {
                    this.headerFields[index] = headerEntry4;
                } else {
                    headerEntry3.next = headerEntry4;
                }
                headerEntry.remove();
                this.size -= headerEntry.size();
                return headerEntry;
            }
            headerEntry3 = headerEntry2;
            headerEntry2 = headerEntry4;
        }
        return null;
    }

    public void encodeHeaders(int i6, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        if (this.ignoreMaxHeaderListSize) {
            encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
        } else {
            encodeHeadersEnforceMaxHeaderListSize(i6, byteBuf, http2Headers, sensitivityDetector);
        }
    }

    HpackHeaderField getHeaderField(int i6) {
        HeaderEntry headerEntry = this.head;
        while (true) {
            int i7 = i6 - 1;
            if (i6 < 0) {
                return headerEntry;
            }
            headerEntry = headerEntry.before;
            i6 = i7;
        }
    }

    public long getMaxHeaderListSize() {
        return this.maxHeaderListSize;
    }

    public long getMaxHeaderTableSize() {
        return this.maxHeaderTableSize;
    }

    int length() {
        if (this.size == 0) {
            return 0;
        }
        HeaderEntry headerEntry = this.head;
        return (headerEntry.after.index - headerEntry.before.index) + 1;
    }

    long size() {
        return this.size;
    }

    HpackEncoder(boolean z5, int i6, int i7) {
        AsciiString asciiString = AsciiString.EMPTY_STRING;
        HeaderEntry headerEntry = new HeaderEntry(-1, asciiString, asciiString, Integer.MAX_VALUE, null);
        this.head = headerEntry;
        this.hpackHuffmanEncoder = new HpackHuffmanEncoder();
        this.ignoreMaxHeaderListSize = z5;
        this.maxHeaderTableSize = 4096L;
        this.maxHeaderListSize = 4294967295L;
        this.headerFields = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i6, 128)))];
        this.hashMask = (byte) (r7.length - 1);
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.huffCodeThreshold = i7;
    }

    private void encodeHeadersEnforceMaxHeaderListSize(int i6, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        long j6 = 0;
        for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
            j6 += HpackHeaderField.sizeOf(entry.getKey(), entry.getValue());
            long j7 = this.maxHeaderListSize;
            if (j6 > j7) {
                Http2CodecUtil.headerListSizeExceeded(i6, j7, false);
            }
        }
        encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
    }

    private void encodeHeadersIgnoreMaxHeaderListSize(ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
            CharSequence key = entry.getKey();
            CharSequence value = entry.getValue();
            encodeHeader(byteBuf, key, value, sensitivityDetector.isSensitive(key, value), HpackHeaderField.sizeOf(key, value));
        }
    }

    private void encodeStringLiteral(ByteBuf byteBuf, CharSequence charSequence) {
        int encodedLength;
        if (charSequence.length() >= this.huffCodeThreshold && (encodedLength = this.hpackHuffmanEncoder.getEncodedLength(charSequence)) < charSequence.length()) {
            encodeInteger(byteBuf, 128, 7, encodedLength);
            this.hpackHuffmanEncoder.encode(byteBuf, charSequence);
            return;
        }
        encodeInteger(byteBuf, 0, 7, charSequence.length());
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            byteBuf.writeBytes(asciiString.array(), asciiString.arrayOffset(), asciiString.length());
        } else {
            byteBuf.writeCharSequence(charSequence, CharsetUtil.ISO_8859_1);
        }
    }

    private HeaderEntry getEntry(CharSequence charSequence, CharSequence charSequence2) {
        if (length() != 0 && charSequence != null && charSequence2 != null) {
            int hashCode = AsciiString.hashCode(charSequence);
            for (HeaderEntry headerEntry = this.headerFields[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
                if (headerEntry.hash == hashCode && (HpackUtil.equalsConstantTime(charSequence, headerEntry.name) & HpackUtil.equalsConstantTime(charSequence2, headerEntry.value)) != 0) {
                    return headerEntry;
                }
            }
        }
        return null;
    }

    private int getNameIndex(CharSequence charSequence) {
        int index = HpackStaticTable.getIndex(charSequence);
        if (index == -1) {
            int index2 = getIndex(charSequence);
            if (index2 >= 0) {
                return index2 + HpackStaticTable.length;
            }
            return index2;
        }
        return index;
    }

    public void setMaxHeaderListSize(long j6) throws Http2Exception {
        if (j6 >= 0 && j6 <= 4294967295L) {
            this.maxHeaderListSize = j6;
            return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j6));
    }

    public void setMaxHeaderTableSize(ByteBuf byteBuf, long j6) throws Http2Exception {
        if (j6 >= 0 && j6 <= 4294967295L) {
            if (this.maxHeaderTableSize == j6) {
                return;
            }
            this.maxHeaderTableSize = j6;
            ensureCapacity(0L);
            encodeInteger(byteBuf, 32, 5, j6);
            return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j6));
    }

    private int getIndex(int i6) {
        if (i6 == -1) {
            return -1;
        }
        return (i6 - this.head.before.index) + 1;
    }
}
