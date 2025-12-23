package javax.mail.internet;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownServiceException;
import javax.activation.DataSource;
import javax.mail.MessageAware;
import javax.mail.MessageContext;
import javax.mail.MessagingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MimePartDataSource implements DataSource, MessageAware {
    private static boolean ignoreMultipartEncoding = true;
    private MessageContext context;
    protected MimePart part;

    @Override // javax.mail.MessageAware
    public synchronized MessageContext getMessageContext() {
        try {
            if (this.context == null) {
                this.context = new MessageContext(this.part);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.context;
    }

    static {
        try {
            String property = System.getProperty("mail.mime.ignoremultipartencoding");
            ignoreMultipartEncoding = property == null || !property.equalsIgnoreCase("false");
        } catch (SecurityException unused) {
        }
    }

    private static String restrictEncoding(String str, MimePart mimePart) throws MessagingException {
        String contentType;
        if (!ignoreMultipartEncoding || str == null || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit") || str.equalsIgnoreCase(HttpHeaders.Values.BINARY) || (contentType = mimePart.getContentType()) == null) {
            return str;
        }
        try {
            ContentType contentType2 = new ContentType(contentType);
            if (!contentType2.match("multipart/*")) {
                if (!contentType2.match("message/*")) {
                    return str;
                }
            }
            return null;
        } catch (ParseException unused) {
            return str;
        }
    }

    @Override // javax.activation.DataSource
    public String getContentType() {
        try {
            return this.part.getContentType();
        } catch (MessagingException unused) {
            return "application/octet-stream";
        }
    }

    @Override // javax.activation.DataSource
    public InputStream getInputStream() throws IOException {
        InputStream contentStream;
        try {
            MimePart mimePart = this.part;
            if (mimePart instanceof MimeBodyPart) {
                contentStream = ((MimeBodyPart) mimePart).getContentStream();
            } else {
                if (!(mimePart instanceof MimeMessage)) {
                    throw new MessagingException("Unknown part");
                }
                contentStream = ((MimeMessage) mimePart).getContentStream();
            }
            String restrictEncoding = restrictEncoding(this.part.getEncoding(), this.part);
            return restrictEncoding != null ? MimeUtility.decode(contentStream, restrictEncoding) : contentStream;
        } catch (MessagingException e6) {
            throw new IOException(e6.getMessage());
        }
    }

    @Override // javax.activation.DataSource
    public String getName() {
        try {
            MimePart mimePart = this.part;
            return mimePart instanceof MimeBodyPart ? ((MimeBodyPart) mimePart).getFileName() : "";
        } catch (MessagingException unused) {
            return "";
        }
    }

    @Override // javax.activation.DataSource
    public OutputStream getOutputStream() throws IOException {
        throw new UnknownServiceException();
    }

    public MimePartDataSource(MimePart mimePart) {
        this.part = mimePart;
    }
}
