package io.netty.handler.codec.spdy;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.HeadersUtils;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSpdyHeaders extends DefaultHeaders<CharSequence, CharSequence, SpdyHeaders> implements SpdyHeaders {
    private static final DefaultHeaders.NameValidator<CharSequence> SpdyNameValidator = new DefaultHeaders.NameValidator<CharSequence>() { // from class: io.netty.handler.codec.spdy.DefaultSpdyHeaders.1
        @Override // io.netty.handler.codec.DefaultHeaders.NameValidator
        public void validateName(CharSequence charSequence) {
            SpdyCodecUtil.validateHeaderName(charSequence);
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class HeaderValueConverterAndValidator extends CharSequenceValueConverter {
        public static final HeaderValueConverterAndValidator INSTANCE = new HeaderValueConverterAndValidator();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.handler.codec.CharSequenceValueConverter, io.netty.handler.codec.ValueConverter
        public CharSequence convertObject(Object obj) {
            CharSequence convertObject = super.convertObject(obj);
            SpdyCodecUtil.validateHeaderValue(convertObject);
            return convertObject;
        }

        private HeaderValueConverterAndValidator() {
        }
    }

    public DefaultSpdyHeaders() {
        this(true);
    }

    public DefaultSpdyHeaders(boolean z5) {
        super(AsciiString.CASE_INSENSITIVE_HASHER, z5 ? HeaderValueConverterAndValidator.INSTANCE : CharSequenceValueConverter.INSTANCE, z5 ? SpdyNameValidator : DefaultHeaders.NameValidator.NOT_NULL);
    }

    @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
    public boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, false);
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaders
    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z5) {
        return contains((DefaultSpdyHeaders) charSequence, charSequence2, (HashingStrategy<? super CharSequence>) (z5 ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER));
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaders
    public List<String> getAllAsString(CharSequence charSequence) {
        return HeadersUtils.getAllAsString(this, charSequence);
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaders
    public String getAsString(CharSequence charSequence) {
        return HeadersUtils.getAsString(this, charSequence);
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaders
    public Iterator<Map.Entry<String, String>> iteratorAsString() {
        return HeadersUtils.iteratorAsString(this);
    }
}
