package io.netty.handler.codec.http;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.util.AsciiString;
import java.util.AbstractMap;
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
public final class ReadOnlyHttpHeaders extends HttpHeaders {
    private final CharSequence[] nameValuePairs;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.ReadOnlyHttpHeaders$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ReadOnlyIterator implements Map.Entry<CharSequence, CharSequence>, Iterator<Map.Entry<CharSequence, CharSequence>> {
        private CharSequence key;
        private int nextNameIndex;
        private CharSequence value;

        private ReadOnlyIterator() {
        }

        /* synthetic */ ReadOnlyIterator(ReadOnlyHttpHeaders readOnlyHttpHeaders, AnonymousClass1 anonymousClass1) {
            this();
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
            return this.nextNameIndex != ReadOnlyHttpHeaders.this.nameValuePairs.length;
        }

        @Override // java.util.Iterator
        public Map.Entry<CharSequence, CharSequence> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.key = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex];
            CharSequence[] charSequenceArr = ReadOnlyHttpHeaders.this.nameValuePairs;
            int i6 = this.nextNameIndex;
            this.value = charSequenceArr[i6 + 1];
            this.nextNameIndex = i6 + 2;
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
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ReadOnlyStringIterator implements Map.Entry<String, String>, Iterator<Map.Entry<String, String>> {
        private String key;
        private int nextNameIndex;
        private String value;

        private ReadOnlyStringIterator() {
        }

        /* synthetic */ ReadOnlyStringIterator(ReadOnlyHttpHeaders readOnlyHttpHeaders, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public String getValue() {
            return this.value;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextNameIndex != ReadOnlyHttpHeaders.this.nameValuePairs.length;
        }

        @Override // java.util.Iterator
        public Map.Entry<String, String> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.key = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex].toString();
            this.value = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex + 1].toString();
            this.nextNameIndex += 2;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        @Override // java.util.Map.Entry
        public String setValue(String str) {
            throw new UnsupportedOperationException("read only");
        }

        public String toString() {
            return this.key + '=' + this.value;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ReadOnlyStringValueIterator implements Iterator<String> {
        private final CharSequence name;
        private final int nameHash;
        private int nextNameIndex = findNextValue();

        ReadOnlyStringValueIterator(CharSequence charSequence) {
            this.name = charSequence;
            this.nameHash = AsciiString.hashCode(charSequence);
        }

        private int findNextValue() {
            for (int i6 = this.nextNameIndex; i6 < ReadOnlyHttpHeaders.this.nameValuePairs.length; i6 += 2) {
                CharSequence charSequence = ReadOnlyHttpHeaders.this.nameValuePairs[i6];
                if (this.nameHash == AsciiString.hashCode(charSequence) && AsciiString.contentEqualsIgnoreCase(this.name, charSequence)) {
                    return i6;
                }
            }
            return -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextNameIndex != -1;
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String charSequence = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex + 1].toString();
            this.nextNameIndex = findNextValue();
            return charSequence;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ReadOnlyValueIterator implements Iterator<CharSequence> {
        private final CharSequence name;
        private final int nameHash;
        private int nextNameIndex = findNextValue();

        ReadOnlyValueIterator(CharSequence charSequence) {
            this.name = charSequence;
            this.nameHash = AsciiString.hashCode(charSequence);
        }

        private int findNextValue() {
            for (int i6 = this.nextNameIndex; i6 < ReadOnlyHttpHeaders.this.nameValuePairs.length; i6 += 2) {
                CharSequence charSequence = ReadOnlyHttpHeaders.this.nameValuePairs[i6];
                if (this.nameHash == AsciiString.hashCode(charSequence) && AsciiString.contentEqualsIgnoreCase(this.name, charSequence)) {
                    return i6;
                }
            }
            return -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextNameIndex != -1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CharSequence next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            CharSequence charSequence = ReadOnlyHttpHeaders.this.nameValuePairs[this.nextNameIndex + 1];
            this.nextNameIndex = findNextValue();
            return charSequence;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }
    }

    private static void validateHeaders(CharSequence... charSequenceArr) {
        for (int i6 = 0; i6 < charSequenceArr.length; i6 += 2) {
            DefaultHttpHeaders.HttpNameValidator.validateName(charSequenceArr[i6]);
        }
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str) {
        return get0(str) != null;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean containsValue(CharSequence charSequence, CharSequence charSequence2, boolean z5) {
        if (!z5) {
            int i6 = 0;
            while (true) {
                CharSequence[] charSequenceArr = this.nameValuePairs;
                if (i6 >= charSequenceArr.length) {
                    break;
                }
                if (AsciiString.contentEqualsIgnoreCase(charSequenceArr[i6], charSequence) && AsciiString.contentEquals(this.nameValuePairs[i6 + 1], charSequence2)) {
                    return true;
                }
                i6 += 2;
            }
        } else {
            int i7 = 0;
            while (true) {
                CharSequence[] charSequenceArr2 = this.nameValuePairs;
                if (i7 >= charSequenceArr2.length) {
                    break;
                }
                if (AsciiString.contentEqualsIgnoreCase(charSequenceArr2[i7], charSequence) && AsciiString.contentEqualsIgnoreCase(this.nameValuePairs[i7 + 1], charSequence2)) {
                    return true;
                }
                i7 += 2;
            }
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Integer getInt(CharSequence charSequence) {
        CharSequence charSequence2 = get0(charSequence);
        if (charSequence2 == null) {
            return null;
        }
        return Integer.valueOf(CharSequenceValueConverter.INSTANCE.convertToInt(charSequence2));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Short getShort(CharSequence charSequence) {
        CharSequence charSequence2 = get0(charSequence);
        if (charSequence2 == null) {
            return null;
        }
        return Short.valueOf(CharSequenceValueConverter.INSTANCE.convertToShort(charSequence2));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Long getTimeMillis(CharSequence charSequence) {
        CharSequence charSequence2 = get0(charSequence);
        if (charSequence2 == null) {
            return null;
        }
        return Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToTimeMillis(charSequence2));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Object obj) {
        throw new UnsupportedOperationException("read only");
    }

    private static IllegalArgumentException newInvalidArraySizeException() {
        return new IllegalArgumentException("nameValuePairs must be arrays of [name, value] pairs");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addInt(CharSequence charSequence, int i6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addShort(CharSequence charSequence, short s5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders clear() {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str, String str2, boolean z5) {
        return containsValue(str, str2, z5);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean isEmpty() {
        return this.nameValuePairs.length == 0;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders, java.lang.Iterable
    public Iterator<Map.Entry<String, String>> iterator() {
        return new ReadOnlyStringIterator(this, null);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence() {
        return new ReadOnlyIterator(this, null);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders remove(String str) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Iterable<?> iterable) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setInt(CharSequence charSequence, int i6) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setShort(CharSequence charSequence, short s5) {
        throw new UnsupportedOperationException("read only");
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int size() {
        return this.nameValuePairs.length >>> 1;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<CharSequence> valueCharSequenceIterator(CharSequence charSequence) {
        return new ReadOnlyValueIterator(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<String> valueStringIterator(CharSequence charSequence) {
        return new ReadOnlyStringValueIterator(charSequence);
    }

    public ReadOnlyHttpHeaders(boolean z5, CharSequence... charSequenceArr) {
        if ((charSequenceArr.length & 1) == 0) {
            if (z5) {
                validateHeaders(charSequenceArr);
            }
            this.nameValuePairs = charSequenceArr;
            return;
        }
        throw newInvalidArraySizeException();
    }

    private CharSequence get0(CharSequence charSequence) {
        int hashCode = AsciiString.hashCode(charSequence);
        int i6 = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.nameValuePairs;
            if (i6 < charSequenceArr.length) {
                CharSequence charSequence2 = charSequenceArr[i6];
                if (AsciiString.hashCode(charSequence2) == hashCode && AsciiString.contentEqualsIgnoreCase(charSequence2, charSequence)) {
                    return this.nameValuePairs[i6 + 1];
                }
                i6 += 2;
            } else {
                return null;
            }
        }
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<Map.Entry<String, String>> entries() {
        if (isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(size());
        for (int i6 = 0; i6 < this.nameValuePairs.length; i6 += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(this.nameValuePairs[i6].toString(), this.nameValuePairs[i6 + 1].toString()));
        }
        return arrayList;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public String get(String str) {
        CharSequence charSequence = get0(str);
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<String> getAll(String str) {
        if (isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        int hashCode = AsciiString.hashCode(str);
        ArrayList arrayList = new ArrayList(4);
        int i6 = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.nameValuePairs;
            if (i6 < charSequenceArr.length) {
                CharSequence charSequence = charSequenceArr[i6];
                if (AsciiString.hashCode(charSequence) == hashCode && AsciiString.contentEqualsIgnoreCase(charSequence, str)) {
                    arrayList.add(this.nameValuePairs[i6 + 1].toString());
                }
                i6 += 2;
            } else {
                return arrayList;
            }
        }
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int getInt(CharSequence charSequence, int i6) {
        CharSequence charSequence2 = get0(charSequence);
        return charSequence2 == null ? i6 : CharSequenceValueConverter.INSTANCE.convertToInt(charSequence2);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public short getShort(CharSequence charSequence, short s5) {
        CharSequence charSequence2 = get0(charSequence);
        return charSequence2 == null ? s5 : CharSequenceValueConverter.INSTANCE.convertToShort(charSequence2);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public long getTimeMillis(CharSequence charSequence, long j6) {
        CharSequence charSequence2 = get0(charSequence);
        return charSequence2 == null ? j6 : CharSequenceValueConverter.INSTANCE.convertToTimeMillis(charSequence2);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Set<String> names() {
        if (isEmpty()) {
            return Collections.EMPTY_SET;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        int i6 = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.nameValuePairs;
            if (i6 < charSequenceArr.length) {
                linkedHashSet.add(charSequenceArr[i6].toString());
                i6 += 2;
            } else {
                return linkedHashSet;
            }
        }
    }
}
