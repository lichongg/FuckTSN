package io.netty.handler.codec.http2;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.UnsupportedValueConverter;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class CharSequenceMap<V> extends DefaultHeaders<CharSequence, V, CharSequenceMap<V>> {
    public CharSequenceMap() {
        this(true);
    }

    public CharSequenceMap(boolean z5) {
        this(z5, UnsupportedValueConverter.instance());
    }

    public CharSequenceMap(boolean z5, ValueConverter<V> valueConverter) {
        super(z5 ? AsciiString.CASE_SENSITIVE_HASHER : AsciiString.CASE_INSENSITIVE_HASHER, valueConverter);
    }

    public CharSequenceMap(boolean z5, ValueConverter<V> valueConverter, int i6) {
        super(z5 ? AsciiString.CASE_SENSITIVE_HASHER : AsciiString.CASE_INSENSITIVE_HASHER, valueConverter, DefaultHeaders.NameValidator.NOT_NULL, i6);
    }
}
