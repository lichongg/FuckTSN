package com.sun.mail.dsn;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class MessageHeaders extends MimeMessage {
    public MessageHeaders() throws MessagingException {
        super((Session) null);
        this.content = new byte[0];
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() {
        return 0;
    }

    @Override // javax.mail.internet.MimeMessage
    protected InputStream getContentStream() {
        return new ByteArrayInputStream(this.content);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.content);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new MessagingException("Can't set content for MessageHeaders");
    }

    public MessageHeaders(InputStream inputStream) throws MessagingException {
        super((Session) null, inputStream);
        this.content = new byte[0];
    }

    public MessageHeaders(InternetHeaders internetHeaders) throws MessagingException {
        super((Session) null);
        this.headers = internetHeaders;
        this.content = new byte[0];
    }
}
