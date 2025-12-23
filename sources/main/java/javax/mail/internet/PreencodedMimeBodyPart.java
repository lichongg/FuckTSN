package javax.mail.internet;

import com.sun.mail.util.LineOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.mail.MessagingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class PreencodedMimeBodyPart extends MimeBodyPart {
    private String encoding;

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        return this.encoding;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream);
        Enumeration allHeaderLines = getAllHeaderLines();
        while (allHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln((String) allHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        getDataHandler().writeTo(outputStream);
        outputStream.flush();
    }

    public PreencodedMimeBodyPart(String str) {
        this.encoding = str;
    }

    @Override // javax.mail.internet.MimeBodyPart
    protected void updateHeaders() throws MessagingException {
        super.updateHeaders();
        MimeBodyPart.setEncoding(this, this.encoding);
    }
}
