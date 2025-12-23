package io.netty.handler.codec.http;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.DefaultHeadersImpl;
import io.netty.handler.codec.HeadersUtils;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttpHeaders extends HttpHeaders {
    private static final int HIGHEST_INVALID_VALUE_CHAR_MASK = -16;
    private final DefaultHeaders<CharSequence, CharSequence, ?> headers;
    private static final ByteProcessor HEADER_NAME_VALIDATOR = new ByteProcessor() { // from class: io.netty.handler.codec.http.DefaultHttpHeaders.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            DefaultHttpHeaders.validateHeaderNameElement(b6);
            return true;
        }
    };
    static final DefaultHeaders.NameValidator<CharSequence> HttpNameValidator = new DefaultHeaders.NameValidator<CharSequence>() { // from class: io.netty.handler.codec.http.DefaultHttpHeaders.2
        @Override // io.netty.handler.codec.DefaultHeaders.NameValidator
        public void validateName(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() == 0) {
                throw new IllegalArgumentException("empty headers are not allowed [" + ((Object) charSequence) + "]");
            }
            if (charSequence instanceof AsciiString) {
                try {
                    ((AsciiString) charSequence).forEachByte(DefaultHttpHeaders.HEADER_NAME_VALIDATOR);
                    return;
                } catch (Exception e6) {
                    PlatformDependent.throwException(e6);
                    return;
                }
            }
            for (int i6 = 0; i6 < charSequence.length(); i6++) {
                DefaultHttpHeaders.validateHeaderNameElement(charSequence.charAt(i6));
            }
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class HeaderValueConverter extends CharSequenceValueConverter {
        static final HeaderValueConverter INSTANCE = new HeaderValueConverter();

        private HeaderValueConverter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.handler.codec.CharSequenceValueConverter, io.netty.handler.codec.ValueConverter
        public CharSequence convertObject(Object obj) {
            return obj instanceof CharSequence ? (CharSequence) obj : obj instanceof Date ? DateFormatter.format((Date) obj) : obj instanceof Calendar ? DateFormatter.format(((Calendar) obj).getTime()) : obj.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class HeaderValueConverterAndValidator extends HeaderValueConverter {
        static final HeaderValueConverterAndValidator INSTANCE = new HeaderValueConverterAndValidator();

        private HeaderValueConverterAndValidator() {
            super();
        }

        private static int validateValueChar(CharSequence charSequence, int i6, char c6) {
            if ((c6 & 65520) == 0) {
                if (c6 == 0) {
                    throw new IllegalArgumentException("a header value contains a prohibited character '\u0000': " + ((Object) charSequence));
                }
                if (c6 == 11) {
                    throw new IllegalArgumentException("a header value contains a prohibited character '\\v': " + ((Object) charSequence));
                }
                if (c6 == '\f') {
                    throw new IllegalArgumentException("a header value contains a prohibited character '\\f': " + ((Object) charSequence));
                }
            }
            if (i6 != 0) {
                if (i6 == 1) {
                    if (c6 == '\n') {
                        return 2;
                    }
                    throw new IllegalArgumentException("only '\\n' is allowed after '\\r': " + ((Object) charSequence));
                }
                if (i6 == 2) {
                    if (c6 == '\t' || c6 == ' ') {
                        return 0;
                    }
                    throw new IllegalArgumentException("only ' ' and '\\t' are allowed after '\\n': " + ((Object) charSequence));
                }
            } else {
                if (c6 == '\n') {
                    return 2;
                }
                if (c6 == '\r') {
                    return 1;
                }
            }
            return i6;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.handler.codec.http.DefaultHttpHeaders.HeaderValueConverter, io.netty.handler.codec.CharSequenceValueConverter, io.netty.handler.codec.ValueConverter
        public CharSequence convertObject(Object obj) {
            CharSequence convertObject = super.convertObject(obj);
            int i6 = 0;
            for (int i7 = 0; i7 < convertObject.length(); i7++) {
                i6 = validateValueChar(convertObject, i6, convertObject.charAt(i7));
            }
            if (i6 == 0) {
                return convertObject;
            }
            throw new IllegalArgumentException("a header value must not end with '\\r' or '\\n':" + ((Object) convertObject));
        }
    }

    public DefaultHttpHeaders() {
        this(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateHeaderNameElement(byte b6) {
        if (b6 != 0 && b6 != 32 && b6 != 44 && b6 != 61 && b6 != 58 && b6 != 59) {
            switch (b6) {
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    if (b6 >= 0) {
                        return;
                    }
                    throw new IllegalArgumentException("a header name cannot contain non-ASCII character: " + ((int) b6));
            }
        }
        throw new IllegalArgumentException("a header name cannot contain the following prohibited characters: =,;: \\t\\r\\n\\v\\f: " + ((int) b6));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(HttpHeaders httpHeaders) {
        if (!(httpHeaders instanceof DefaultHttpHeaders)) {
            return super.add(httpHeaders);
        }
        this.headers.add(((DefaultHttpHeaders) httpHeaders).headers);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str) {
        return contains((CharSequence) str);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public String get(String str) {
        return get((CharSequence) str);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<String> getAll(String str) {
        return getAll((CharSequence) str);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Integer getInt(CharSequence charSequence) {
        return this.headers.getInt(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Short getShort(CharSequence charSequence) {
        return this.headers.getShort(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Long getTimeMillis(CharSequence charSequence) {
        return this.headers.getTimeMillis(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders remove(String str) {
        this.headers.remove(str);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(HttpHeaders httpHeaders) {
        if (!(httpHeaders instanceof DefaultHttpHeaders)) {
            return super.set(httpHeaders);
        }
        this.headers.set(((DefaultHttpHeaders) httpHeaders).headers);
        return this;
    }

    public DefaultHttpHeaders(boolean z5) {
        this(z5, nameValidator(z5));
    }

    static DefaultHeaders.NameValidator<CharSequence> nameValidator(boolean z5) {
        return z5 ? HttpNameValidator : DefaultHeaders.NameValidator.NOT_NULL;
    }

    static ValueConverter<CharSequence> valueConverter(boolean z5) {
        return z5 ? HeaderValueConverterAndValidator.INSTANCE : HeaderValueConverter.INSTANCE;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addInt(CharSequence charSequence, int i6) {
        this.headers.addInt(charSequence, i6);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addShort(CharSequence charSequence, short s5) {
        this.headers.addShort(charSequence, s5);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders clear() {
        this.headers.clear();
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(CharSequence charSequence) {
        return this.headers.contains(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders copy() {
        return new DefaultHttpHeaders(this.headers.copy());
    }

    public boolean equals(Object obj) {
        return (obj instanceof DefaultHttpHeaders) && this.headers.equals(((DefaultHttpHeaders) obj).headers, AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public String get(CharSequence charSequence) {
        return HeadersUtils.getAsString(this.headers, charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<String> getAll(CharSequence charSequence) {
        return HeadersUtils.getAllAsString(this.headers, charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int getInt(CharSequence charSequence, int i6) {
        return this.headers.getInt(charSequence, i6);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public short getShort(CharSequence charSequence, short s5) {
        return this.headers.getShort(charSequence, s5);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public long getTimeMillis(CharSequence charSequence, long j6) {
        return this.headers.getTimeMillis(charSequence, j6);
    }

    public int hashCode() {
        return this.headers.hashCode(AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean isEmpty() {
        return this.headers.isEmpty();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders, java.lang.Iterable
    @Deprecated
    public Iterator<Map.Entry<String, String>> iterator() {
        return HeadersUtils.iteratorAsString(this.headers);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence() {
        return this.headers.iterator();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Set<String> names() {
        return HeadersUtils.namesAsString(this.headers);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders remove(CharSequence charSequence) {
        this.headers.remove(charSequence);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setInt(CharSequence charSequence, int i6) {
        this.headers.setInt(charSequence, i6);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setShort(CharSequence charSequence, short s5) {
        this.headers.setShort(charSequence, s5);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int size() {
        return this.headers.size();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<CharSequence> valueCharSequenceIterator(CharSequence charSequence) {
        return this.headers.valueIterator(charSequence);
    }

    protected DefaultHttpHeaders(boolean z5, DefaultHeaders.NameValidator<CharSequence> nameValidator) {
        this(new DefaultHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, valueConverter(z5), nameValidator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateHeaderNameElement(char c6) {
        if (c6 != 0 && c6 != ' ' && c6 != ',' && c6 != '=' && c6 != ':' && c6 != ';') {
            switch (c6) {
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                    break;
                default:
                    if (c6 <= 127) {
                        return;
                    }
                    throw new IllegalArgumentException("a header name cannot contain non-ASCII character: " + c6);
            }
        }
        throw new IllegalArgumentException("a header name cannot contain the following prohibited characters: =,;: \\t\\r\\n\\v\\f: " + c6);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str, String str2, boolean z5) {
        return contains((CharSequence) str, (CharSequence) str2, z5);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<Map.Entry<String, String>> entries() {
        if (isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(this.headers.size());
        Iterator<Map.Entry<String, String>> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<String> valueStringIterator(CharSequence charSequence) {
        final Iterator<CharSequence> valueCharSequenceIterator = valueCharSequenceIterator(charSequence);
        return new Iterator<String>() { // from class: io.netty.handler.codec.http.DefaultHttpHeaders.3
            @Override // java.util.Iterator
            public boolean hasNext() {
                return valueCharSequenceIterator.hasNext();
            }

            @Override // java.util.Iterator
            public String next() {
                return ((CharSequence) valueCharSequenceIterator.next()).toString();
            }

            @Override // java.util.Iterator
            public void remove() {
                valueCharSequenceIterator.remove();
            }
        };
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Object obj) {
        this.headers.addObject((DefaultHeaders<CharSequence, CharSequence, ?>) str, obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z5) {
        return this.headers.contains(charSequence, charSequence2, z5 ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Object obj) {
        this.headers.setObject((DefaultHeaders<CharSequence, CharSequence, ?>) str, obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(CharSequence charSequence, Object obj) {
        this.headers.addObject((DefaultHeaders<CharSequence, CharSequence, ?>) charSequence, obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(CharSequence charSequence, Object obj) {
        this.headers.setObject((DefaultHeaders<CharSequence, CharSequence, ?>) charSequence, obj);
        return this;
    }

    protected DefaultHttpHeaders(DefaultHeaders<CharSequence, CharSequence, ?> defaultHeaders) {
        this.headers = defaultHeaders;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Iterable<?> iterable) {
        this.headers.addObject((DefaultHeaders<CharSequence, CharSequence, ?>) str, iterable);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Iterable<?> iterable) {
        this.headers.setObject((DefaultHeaders<CharSequence, CharSequence, ?>) str, iterable);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(CharSequence charSequence, Iterable<?> iterable) {
        this.headers.addObject((DefaultHeaders<CharSequence, CharSequence, ?>) charSequence, iterable);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(CharSequence charSequence, Iterable<?> iterable) {
        this.headers.setObject((DefaultHeaders<CharSequence, CharSequence, ?>) charSequence, iterable);
        return this;
    }
}
