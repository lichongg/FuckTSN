package io.netty.handler.codec.http2;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.PlatformDependent;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2Headers extends DefaultHeaders<CharSequence, CharSequence, Http2Headers> implements Http2Headers {
    private DefaultHeaders.HeaderEntry<CharSequence, CharSequence> firstNonPseudo;
    private static final ByteProcessor HTTP2_NAME_VALIDATOR_PROCESSOR = new ByteProcessor() { // from class: io.netty.handler.codec.http2.DefaultHttp2Headers.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) {
            return !AsciiString.isUpperCase(b6);
        }
    };
    static final DefaultHeaders.NameValidator<CharSequence> HTTP2_NAME_VALIDATOR = new DefaultHeaders.NameValidator<CharSequence>() { // from class: io.netty.handler.codec.http2.DefaultHttp2Headers.2
        @Override // io.netty.handler.codec.DefaultHeaders.NameValidator
        public void validateName(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() == 0) {
                PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "empty headers are not allowed [%s]", charSequence));
            }
            if (!(charSequence instanceof AsciiString)) {
                for (int i6 = 0; i6 < charSequence.length(); i6++) {
                    if (AsciiString.isUpperCase(charSequence.charAt(i6))) {
                        PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "invalid header name [%s]", charSequence));
                    }
                }
                return;
            }
            try {
                if (((AsciiString) charSequence).forEachByte(DefaultHttp2Headers.HTTP2_NAME_VALIDATOR_PROCESSOR) != -1) {
                    PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "invalid header name [%s]", charSequence));
                }
            } catch (Http2Exception e6) {
                PlatformDependent.throwException(e6);
            } catch (Throwable th) {
                PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, th, "unexpected error. invalid header name [%s]", charSequence));
            }
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Http2HeaderEntry extends DefaultHeaders.HeaderEntry<CharSequence, CharSequence> {
        /* JADX WARN: Multi-variable type inference failed */
        protected Http2HeaderEntry(int i6, CharSequence charSequence, CharSequence charSequence2, DefaultHeaders.HeaderEntry<CharSequence, CharSequence> headerEntry) {
            super(i6, charSequence);
            this.value = charSequence2;
            this.next = headerEntry;
            if (Http2Headers.PseudoHeaderName.hasPseudoHeaderFormat(charSequence)) {
                this.after = DefaultHttp2Headers.this.firstNonPseudo;
                this.before = DefaultHttp2Headers.this.firstNonPseudo.before();
            } else {
                this.after = ((DefaultHeaders) DefaultHttp2Headers.this).head;
                this.before = ((DefaultHeaders) DefaultHttp2Headers.this).head.before();
                if (DefaultHttp2Headers.this.firstNonPseudo == ((DefaultHeaders) DefaultHttp2Headers.this).head) {
                    DefaultHttp2Headers.this.firstNonPseudo = this;
                }
            }
            pointNeighborsToThis();
        }

        @Override // io.netty.handler.codec.DefaultHeaders.HeaderEntry
        protected void remove() {
            if (this == DefaultHttp2Headers.this.firstNonPseudo) {
                DefaultHttp2Headers defaultHttp2Headers = DefaultHttp2Headers.this;
                defaultHttp2Headers.firstNonPseudo = defaultHttp2Headers.firstNonPseudo.after();
            }
            super.remove();
        }
    }

    public DefaultHttp2Headers() {
        this(true);
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers authority(CharSequence charSequence) {
        set((DefaultHttp2Headers) Http2Headers.PseudoHeaderName.AUTHORITY.value(), (AsciiString) charSequence);
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers method(CharSequence charSequence) {
        set((DefaultHttp2Headers) Http2Headers.PseudoHeaderName.METHOD.value(), (AsciiString) charSequence);
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers path(CharSequence charSequence) {
        set((DefaultHttp2Headers) Http2Headers.PseudoHeaderName.PATH.value(), (AsciiString) charSequence);
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers scheme(CharSequence charSequence) {
        set((DefaultHttp2Headers) Http2Headers.PseudoHeaderName.SCHEME.value(), (AsciiString) charSequence);
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public Http2Headers status(CharSequence charSequence) {
        set((DefaultHttp2Headers) Http2Headers.PseudoHeaderName.STATUS.value(), (AsciiString) charSequence);
        return this;
    }

    public DefaultHttp2Headers(boolean z5) {
        super(AsciiString.CASE_SENSITIVE_HASHER, CharSequenceValueConverter.INSTANCE, z5 ? HTTP2_NAME_VALIDATOR : DefaultHeaders.NameValidator.NOT_NULL);
        this.firstNonPseudo = this.head;
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence authority() {
        return get(Http2Headers.PseudoHeaderName.AUTHORITY.value());
    }

    @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
    public Http2Headers clear() {
        this.firstNonPseudo = this.head;
        return (Http2Headers) super.clear();
    }

    @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
    public boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, false);
    }

    @Override // io.netty.handler.codec.DefaultHeaders
    public boolean equals(Object obj) {
        return (obj instanceof Http2Headers) && equals((Http2Headers) obj, AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.DefaultHeaders
    public int hashCode() {
        return hashCode(AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence method() {
        return get(Http2Headers.PseudoHeaderName.METHOD.value());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.DefaultHeaders
    public final DefaultHeaders.HeaderEntry<CharSequence, CharSequence> newHeaderEntry(int i6, CharSequence charSequence, CharSequence charSequence2, DefaultHeaders.HeaderEntry<CharSequence, CharSequence> headerEntry) {
        return new Http2HeaderEntry(i6, charSequence, charSequence2, headerEntry);
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence path() {
        return get(Http2Headers.PseudoHeaderName.PATH.value());
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence scheme() {
        return get(Http2Headers.PseudoHeaderName.SCHEME.value());
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public CharSequence status() {
        return get(Http2Headers.PseudoHeaderName.STATUS.value());
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z5) {
        return contains((DefaultHttp2Headers) charSequence, charSequence2, (HashingStrategy<? super CharSequence>) (z5 ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER));
    }

    @Override // io.netty.handler.codec.http2.Http2Headers
    public /* bridge */ /* synthetic */ Iterator valueIterator(CharSequence charSequence) {
        return super.valueIterator((DefaultHttp2Headers) charSequence);
    }

    public DefaultHttp2Headers(boolean z5, int i6) {
        super(AsciiString.CASE_SENSITIVE_HASHER, CharSequenceValueConverter.INSTANCE, z5 ? HTTP2_NAME_VALIDATOR : DefaultHeaders.NameValidator.NOT_NULL, i6);
        this.firstNonPseudo = this.head;
    }
}
