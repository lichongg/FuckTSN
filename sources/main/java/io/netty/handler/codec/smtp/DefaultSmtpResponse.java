package io.netty.handler.codec.smtp;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultSmtpResponse implements SmtpResponse {
    private final int code;
    private final List<CharSequence> details;

    public DefaultSmtpResponse(int i6) {
        this(i6, (List<CharSequence>) null);
    }

    public DefaultSmtpResponse(int i6, CharSequence... charSequenceArr) {
        this(i6, SmtpUtils.toUnmodifiableList(charSequenceArr));
    }

    @Override // io.netty.handler.codec.smtp.SmtpResponse
    public int code() {
        return this.code;
    }

    @Override // io.netty.handler.codec.smtp.SmtpResponse
    public List<CharSequence> details() {
        return this.details;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultSmtpResponse)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        DefaultSmtpResponse defaultSmtpResponse = (DefaultSmtpResponse) obj;
        return code() == defaultSmtpResponse.code() && details().equals(defaultSmtpResponse.details());
    }

    public int hashCode() {
        return (this.code * 31) + this.details.hashCode();
    }

    public String toString() {
        return "DefaultSmtpResponse{code=" + this.code + ", details=" + this.details + '}';
    }

    DefaultSmtpResponse(int i6, List<CharSequence> list) {
        if (i6 >= 100 && i6 <= 599) {
            this.code = i6;
            if (list == null) {
                this.details = Collections.EMPTY_LIST;
                return;
            } else {
                this.details = Collections.unmodifiableList(list);
                return;
            }
        }
        throw new IllegalArgumentException("code must be 100 <= code <= 599");
    }
}
