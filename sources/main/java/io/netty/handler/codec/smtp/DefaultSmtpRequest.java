package io.netty.handler.codec.smtp;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultSmtpRequest implements SmtpRequest {
    private final SmtpCommand command;
    private final List<CharSequence> parameters;

    public DefaultSmtpRequest(SmtpCommand smtpCommand) {
        this.command = (SmtpCommand) ObjectUtil.checkNotNull(smtpCommand, "command");
        this.parameters = Collections.EMPTY_LIST;
    }

    @Override // io.netty.handler.codec.smtp.SmtpRequest
    public SmtpCommand command() {
        return this.command;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultSmtpRequest)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        DefaultSmtpRequest defaultSmtpRequest = (DefaultSmtpRequest) obj;
        return command().equals(defaultSmtpRequest.command()) && parameters().equals(defaultSmtpRequest.parameters());
    }

    public int hashCode() {
        return (this.command.hashCode() * 31) + this.parameters.hashCode();
    }

    @Override // io.netty.handler.codec.smtp.SmtpRequest
    public List<CharSequence> parameters() {
        return this.parameters;
    }

    public String toString() {
        return "DefaultSmtpRequest{command=" + this.command + ", parameters=" + this.parameters + '}';
    }

    public DefaultSmtpRequest(SmtpCommand smtpCommand, CharSequence... charSequenceArr) {
        this.command = (SmtpCommand) ObjectUtil.checkNotNull(smtpCommand, "command");
        this.parameters = SmtpUtils.toUnmodifiableList(charSequenceArr);
    }

    public DefaultSmtpRequest(CharSequence charSequence, CharSequence... charSequenceArr) {
        this(SmtpCommand.valueOf(charSequence), charSequenceArr);
    }

    DefaultSmtpRequest(SmtpCommand smtpCommand, List<CharSequence> list) {
        this.command = (SmtpCommand) ObjectUtil.checkNotNull(smtpCommand, "command");
        this.parameters = list != null ? Collections.unmodifiableList(list) : Collections.EMPTY_LIST;
    }
}
