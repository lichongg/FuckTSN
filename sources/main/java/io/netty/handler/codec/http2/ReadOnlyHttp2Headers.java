package io.netty.handler.codec.http2;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.EmptyArrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ReadOnlyHttp2Headers implements Http2Headers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte PSEUDO_HEADER_TOKEN = 58;
    private final AsciiString[] otherHeaders;
    private final AsciiString[] pseudoHeaders;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.ReadOnlyHttp2Headers$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ReadOnlyIterator implements Map.Entry<CharSequence, CharSequence>, Iterator<Map.Entry<CharSequence, CharSequence>> {
        private AsciiString[] current;

        /* renamed from: i, reason: collision with root package name */
        private int f43071i;
        private AsciiString key;
        private AsciiString value;

        private ReadOnlyIterator() {
            this.current = ReadOnlyHttp2Headers.this.pseudoHeaders.length != 0 ? ReadOnlyHttp2Headers.this.pseudoHeaders : ReadOnlyHttp2Headers.this.otherHeaders;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public CharSequence getKey() {
            return this.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public CharSequence getValue() {
            return this.value;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f43071i != this.current.length;
        }

        @Override // java.util.Iterator
        public Map.Entry<CharSequence, CharSequence> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AsciiString[] asciiStringArr = this.current;
            int i6 = this.f43071i;
            this.key = asciiStringArr[i6];
            this.value = asciiStringArr[i6 + 1];
            int i7 = i6 + 2;
            this.f43071i = i7;
            if (i7 == asciiStringArr.length && asciiStringArr == ReadOnlyHttp2Headers.this.pseudoHeaders) {
                this.current = ReadOnlyHttp2Headers.this.otherHeaders;
                this.f43071i = 0;
            }
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        @Override // java.util.Map.Entry
        public CharSequence setValue(CharSequence charSequence) {
            throw new UnsupportedOperationException("read only");
        }

        public String toString() {
            return this.key.toString() + '=' + this.value.toString();
        }

        /* synthetic */ ReadOnlyIterator(ReadOnlyHttp2Headers readOnlyHttp2Headers, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ReadOnlyValueIterator implements Iterator<CharSequence> {
        private AsciiString[] current;

        /* renamed from: i, reason: collision with root package name */
        private int f43072i;
        private final CharSequence name;
        private final int nameHash;
        private AsciiString next;

        ReadOnlyValueIterator(CharSequence charSequence) {
            this.current = ReadOnlyHttp2Headers.this.pseudoHeaders.length != 0 ? ReadOnlyHttp2Headers.this.pseudoHeaders : ReadOnlyHttp2Headers.this.otherHeaders;
            this.nameHash = AsciiString.hashCode(charSequence);
            this.name = charSequence;
            calculateNext();
        }

        private void calculateNext() {
            while (true) {
                int i6 = this.f43072i;
                AsciiString[] asciiStringArr = this.current;
                if (i6 >= asciiStringArr.length) {
                    if (i6 < asciiStringArr.length || asciiStringArr != ReadOnlyHttp2Headers.this.pseudoHeaders) {
                        this.next = null;
                        return;
                    }
                    this.f43072i = 0;
                    this.current = ReadOnlyHttp2Headers.this.otherHeaders;
                    calculateNext();
                    return;
                }
                AsciiString asciiString = asciiStringArr[i6];
                if (asciiString.hashCode() == this.nameHash && asciiString.contentEqualsIgnoreCase(this.name)) {
                    AsciiString[] asciiStringArr2 = this.current;
                    int i7 = this.f43072i;
                    this.next = asciiStringArr2[i7 + 1];
                    this.f43072i = i7 + 2;
                    return;
                }
                this.f43072i += 2;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CharSequence next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AsciiString asciiString = this.next;
            calculateNext();
            return asciiString;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }
    }

    private static void validateHeaders(AsciiString[] asciiStringArr, AsciiString... asciiStringArr2) {
        for (int i6 = 1; i6 < asciiStringArr.length; i6 += 2) {
            if (asciiStringArr[i6] == null) {
                throw new IllegalArgumentException("pseudoHeaders value at index " + i6 + " is null");
            }
        }
        int length = asciiStringArr2.length - 1;
        boolean z5 = false;
        for (int i7 = 0; i7 < length; i7 += 2) {
            AsciiString asciiString = asciiStringArr2[i7];
            DefaultHttp2Headers.HTTP2_NAME_VALIDATOR.validateName(asciiString);
            if (!z5 && !asciiString.isEmpty() && asciiString.byteAt(0) != 58) {
                z5 = true;
            } else if (z5 && !asciiString.isEmpty() && asciiString.byteAt(0) == 58) {
                throw new IllegalArgumentException("otherHeaders name at index " + i7 + " is a pseudo header that appears after non-pseudo headers.");
            }
            int i8 = i7 + 1;
            if (asciiStringArr2[i8] == null) {
                throw new IllegalArgumentException("otherHeaders value at index " + i8 + " is null");
            }
        }
    }

    @Override // io.netty.handler.codec.Headers
    public /* bridge */ /* synthetic */ Http2Headers addObject(CharSequence charSequence, Iterable iterable) {
        return addObject2(charSequence, (Iterable<?>) iterable);
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers authority(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsFloat(CharSequence charSequence, float f6) {
        return false;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers method(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers path(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers scheme(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public /* bridge */ /* synthetic */ Http2Headers setObject(CharSequence charSequence, Iterable iterable) {
        return setObject2(charSequence, (Iterable<?>) iterable);
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers status(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    public static ReadOnlyHttp2Headers clientHeaders(boolean z5, AsciiString asciiString, AsciiString asciiString2, AsciiString asciiString3, AsciiString asciiString4, AsciiString... asciiStringArr) {
        return new ReadOnlyHttp2Headers(z5, new AsciiString[]{Http2Headers.PseudoHeaderName.METHOD.value(), asciiString, Http2Headers.PseudoHeaderName.PATH.value(), asciiString2, Http2Headers.PseudoHeaderName.SCHEME.value(), asciiString3, Http2Headers.PseudoHeaderName.AUTHORITY.value(), asciiString4}, asciiStringArr);
    }

    private static IllegalArgumentException newInvalidArraySizeException() {
        return new IllegalArgumentException("pseudoHeaders and otherHeaders must be arrays of [name, value] pairs");
    }

    public static ReadOnlyHttp2Headers serverHeaders(boolean z5, AsciiString asciiString, AsciiString... asciiStringArr) {
        return new ReadOnlyHttp2Headers(z5, new AsciiString[]{Http2Headers.PseudoHeaderName.STATUS.value(), asciiString}, asciiStringArr);
    }

    public static ReadOnlyHttp2Headers trailers(boolean z5, AsciiString... asciiStringArr) {
        return new ReadOnlyHttp2Headers(z5, EmptyArrays.EMPTY_ASCII_STRINGS, asciiStringArr);
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addBoolean(CharSequence charSequence, boolean z5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addByte(CharSequence charSequence, byte b6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addChar(CharSequence charSequence, char c6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addDouble(CharSequence charSequence, double d6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addFloat(CharSequence charSequence, float f6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addInt(CharSequence charSequence, int i6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addLong(CharSequence charSequence, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addShort(CharSequence charSequence, short s5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addTimeMillis(CharSequence charSequence, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence authority() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.AUTHORITY.value());
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers clear() {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsBoolean(CharSequence charSequence, boolean z5) {
        return contains(charSequence, (CharSequence) String.valueOf(z5));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsByte(CharSequence charSequence, byte b6) {
        return contains(charSequence, (CharSequence) String.valueOf((int) b6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsChar(CharSequence charSequence, char c6) {
        return contains(charSequence, (CharSequence) String.valueOf(c6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsDouble(CharSequence charSequence, double d6) {
        return contains(charSequence, (CharSequence) String.valueOf(d6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsInt(CharSequence charSequence, int i6) {
        return contains(charSequence, (CharSequence) String.valueOf(i6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsLong(CharSequence charSequence, long j6) {
        return contains(charSequence, (CharSequence) String.valueOf(j6));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsObject(CharSequence charSequence, Object obj) {
        return obj instanceof CharSequence ? contains(charSequence, (CharSequence) obj) : contains(charSequence, (CharSequence) obj.toString());
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsShort(CharSequence charSequence, short s5) {
        return contains(charSequence, (CharSequence) String.valueOf((int) s5));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsTimeMillis(CharSequence charSequence, long j6) {
        return contains(charSequence, (CharSequence) String.valueOf(j6));
    }

    @Override // io.netty.handler.codec.Headers
    public List<CharSequence> getAll(CharSequence charSequence) {
        int hashCode = AsciiString.hashCode(charSequence);
        ArrayList arrayList = new ArrayList();
        int length = this.pseudoHeaders.length - 1;
        for (int i6 = 0; i6 < length; i6 += 2) {
            AsciiString asciiString = this.pseudoHeaders[i6];
            if (asciiString.hashCode() == hashCode && asciiString.contentEqualsIgnoreCase(charSequence)) {
                arrayList.add(this.pseudoHeaders[i6 + 1]);
            }
        }
        int length2 = this.otherHeaders.length - 1;
        for (int i7 = 0; i7 < length2; i7 += 2) {
            AsciiString asciiString2 = this.otherHeaders[i7];
            if (asciiString2.hashCode() == hashCode && asciiString2.contentEqualsIgnoreCase(charSequence)) {
                arrayList.add(this.otherHeaders[i7 + 1]);
            }
        }
        return arrayList;
    }

    @Override // io.netty.handler.codec.Headers
    public List<CharSequence> getAllAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean isEmpty() {
        return this.pseudoHeaders.length == 0 && this.otherHeaders.length == 0;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers, io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<CharSequence, CharSequence>> iterator() {
        return new ReadOnlyIterator(this, null);
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence method() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.METHOD.value());
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence path() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.PATH.value());
    }

    @Override // io.netty.handler.codec.Headers
    public boolean remove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence scheme() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.SCHEME.value());
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setAll(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setBoolean(CharSequence charSequence, boolean z5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setByte(CharSequence charSequence, byte b6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setChar(CharSequence charSequence, char c6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setDouble(CharSequence charSequence, double d6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setFloat(CharSequence charSequence, float f6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setInt(CharSequence charSequence, int i6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setLong(CharSequence charSequence, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setShort(CharSequence charSequence, short s5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setTimeMillis(CharSequence charSequence, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public int size() {
        return (this.pseudoHeaders.length + this.otherHeaders.length) >>> 1;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence status() {
        return get((CharSequence) Http2Headers.PseudoHeaderName.STATUS.value());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(ReadOnlyHttp2Headers.class.getSimpleName());
        sb.append('[');
        Iterator<Map.Entry<CharSequence, CharSequence>> it = iterator();
        String str = "";
        while (it.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = it.next();
            sb.append(str);
            sb.append(next.getKey());
            sb.append(": ");
            sb.append(next.getValue());
            str = ", ";
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Iterator<CharSequence> valueIterator(CharSequence charSequence) {
        return new ReadOnlyValueIterator(charSequence);
    }

    private ReadOnlyHttp2Headers(boolean z5, AsciiString[] asciiStringArr, AsciiString... asciiStringArr2) {
        if ((asciiStringArr2.length & 1) == 0) {
            if (z5) {
                validateHeaders(asciiStringArr, asciiStringArr2);
            }
            this.pseudoHeaders = asciiStringArr;
            this.otherHeaders = asciiStringArr2;
            return;
        }
        throw newInvalidArraySizeException();
    }

    private AsciiString get0(CharSequence charSequence) {
        int hashCode = AsciiString.hashCode(charSequence);
        int length = this.pseudoHeaders.length - 1;
        for (int i6 = 0; i6 < length; i6 += 2) {
            AsciiString asciiString = this.pseudoHeaders[i6];
            if (asciiString.hashCode() == hashCode && asciiString.contentEqualsIgnoreCase(charSequence)) {
                return this.pseudoHeaders[i6 + 1];
            }
        }
        int length2 = this.otherHeaders.length - 1;
        for (int i7 = 0; i7 < length2; i7 += 2) {
            AsciiString asciiString2 = this.otherHeaders[i7];
            if (asciiString2.hashCode() == hashCode && asciiString2.contentEqualsIgnoreCase(charSequence)) {
                return this.otherHeaders[i7 + 1];
            }
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(CharSequence charSequence) {
        return get(charSequence) != null;
    }

    @Override // io.netty.handler.codec.Headers
    public CharSequence get(CharSequence charSequence) {
        return get0(charSequence);
    }

    @Override // io.netty.handler.codec.Headers
    public CharSequence getAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBoolean(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Boolean.valueOf(CharSequenceValueConverter.INSTANCE.convertToBoolean((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBooleanAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByte(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Byte.valueOf(CharSequenceValueConverter.INSTANCE.convertToByte((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByteAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Character getChar(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Character.valueOf(CharSequenceValueConverter.INSTANCE.convertToChar((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getCharAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDouble(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Double.valueOf(CharSequenceValueConverter.INSTANCE.convertToDouble((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDoubleAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloat(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Float.valueOf(CharSequenceValueConverter.INSTANCE.convertToFloat((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloatAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getInt(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Integer.valueOf(CharSequenceValueConverter.INSTANCE.convertToInt((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getIntAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLong(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToLong((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLongAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShort(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Short.valueOf(CharSequenceValueConverter.INSTANCE.convertToShort((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShortAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillis(CharSequence charSequence) {
        AsciiString asciiString = get0(charSequence);
        if (asciiString != null) {
            return Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToTimeMillis((CharSequence) asciiString));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillisAndRemove(CharSequence charSequence) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Set<CharSequence> names() {
        if (isEmpty()) {
            return Collections.EMPTY_SET;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        int length = this.pseudoHeaders.length - 1;
        for (int i6 = 0; i6 < length; i6 += 2) {
            linkedHashSet.add(this.pseudoHeaders[i6]);
        }
        int length2 = this.otherHeaders.length - 1;
        for (int i7 = 0; i7 < length2; i7 += 2) {
            linkedHashSet.add(this.otherHeaders[i7]);
        }
        return linkedHashSet;
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addObject(CharSequence charSequence, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, false);
    }

    @Override // io.netty.handler.codec.Headers
    public CharSequence get(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3 = get(charSequence);
        return charSequence3 != null ? charSequence3 : charSequence2;
    }

    @Override // io.netty.handler.codec.Headers
    public CharSequence getAndRemove(CharSequence charSequence, CharSequence charSequence2) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBooleanAndRemove(CharSequence charSequence, boolean z5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByteAndRemove(CharSequence charSequence, byte b6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public char getCharAndRemove(CharSequence charSequence, char c6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public double getDoubleAndRemove(CharSequence charSequence, double d6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloatAndRemove(CharSequence charSequence, float f6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public int getIntAndRemove(CharSequence charSequence, int i6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public long getLongAndRemove(CharSequence charSequence, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public short getShortAndRemove(CharSequence charSequence, short s5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillisAndRemove(CharSequence charSequence, long j6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setObject(CharSequence charSequence, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers add(CharSequence charSequence, CharSequence charSequence2) {
        throw new UnsupportedOperationException("read only");
    }

    /* renamed from: addObject, reason: avoid collision after fix types in other method */
    public Http2Headers addObject2(CharSequence charSequence, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z5) {
        int hashCode = AsciiString.hashCode(charSequence);
        HashingStrategy<CharSequence> hashingStrategy = z5 ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER;
        int hashCode2 = hashingStrategy.hashCode(charSequence2);
        return contains(charSequence, hashCode, charSequence2, hashCode2, hashingStrategy, this.otherHeaders) || contains(charSequence, hashCode, charSequence2, hashCode2, hashingStrategy, this.pseudoHeaders);
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBoolean(CharSequence charSequence, boolean z5) {
        Boolean bool = getBoolean(charSequence);
        return bool != null ? bool.booleanValue() : z5;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByte(CharSequence charSequence, byte b6) {
        Byte b7 = getByte(charSequence);
        return b7 != null ? b7.byteValue() : b6;
    }

    @Override // io.netty.handler.codec.Headers
    public char getChar(CharSequence charSequence, char c6) {
        Character ch = getChar(charSequence);
        return ch != null ? ch.charValue() : c6;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDouble(CharSequence charSequence, double d6) {
        Double d7 = getDouble(charSequence);
        return d7 != null ? d7.doubleValue() : d6;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloat(CharSequence charSequence, float f6) {
        Float f7 = getFloat(charSequence);
        return f7 != null ? f7.floatValue() : f6;
    }

    @Override // io.netty.handler.codec.Headers
    public int getInt(CharSequence charSequence, int i6) {
        Integer num = getInt(charSequence);
        return num != null ? num.intValue() : i6;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLong(CharSequence charSequence, long j6) {
        Long l6 = getLong(charSequence);
        return l6 != null ? l6.longValue() : j6;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShort(CharSequence charSequence, short s5) {
        Short sh = getShort(charSequence);
        return sh != null ? sh.shortValue() : s5;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillis(CharSequence charSequence, long j6) {
        Long timeMillis = getTimeMillis(charSequence);
        return timeMillis != null ? timeMillis.longValue() : j6;
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers set(CharSequence charSequence, CharSequence charSequence2) {
        throw new UnsupportedOperationException("read only");
    }

    /* renamed from: setObject, reason: avoid collision after fix types in other method */
    public Http2Headers setObject2(CharSequence charSequence, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers add(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers addObject(CharSequence charSequence, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers set(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers setObject(CharSequence charSequence, Object... objArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers add(CharSequence charSequence, CharSequence... charSequenceArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers set(CharSequence charSequence, CharSequence... charSequenceArr) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers add(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.Headers
    public Http2Headers set(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
        throw new UnsupportedOperationException("read only");
    }

    private static boolean contains(CharSequence charSequence, int i6, CharSequence charSequence2, int i7, HashingStrategy<CharSequence> hashingStrategy, AsciiString[] asciiStringArr) {
        int length = asciiStringArr.length - 1;
        for (int i8 = 0; i8 < length; i8 += 2) {
            AsciiString asciiString = asciiStringArr[i8];
            AsciiString asciiString2 = asciiStringArr[i8 + 1];
            if (asciiString.hashCode() == i6 && asciiString2.hashCode() == i7 && asciiString.contentEqualsIgnoreCase(charSequence) && hashingStrategy.equals(asciiString2, charSequence2)) {
                return true;
            }
        }
        return false;
    }
}
