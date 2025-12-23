package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import javax.mail.MessagingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LineOutputStream extends FilterOutputStream {
    private static byte[] newline = {13, 10};

    public void writeln(String str) throws MessagingException {
        try {
            ((FilterOutputStream) this).out.write(ASCIIUtility.getBytes(str));
            ((FilterOutputStream) this).out.write(newline);
        } catch (Exception e6) {
            throw new MessagingException("IOException", e6);
        }
    }

    public LineOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void writeln() throws MessagingException {
        try {
            ((FilterOutputStream) this).out.write(newline);
        } catch (Exception e6) {
            throw new MessagingException("IOException", e6);
        }
    }
}
