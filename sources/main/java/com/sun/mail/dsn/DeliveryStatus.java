package com.sun.mail.dsn;

import com.sun.mail.util.LineOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DeliveryStatus {
    private static boolean debug;
    protected InternetHeaders messageDSN;
    protected InternetHeaders[] recipientDSN;

    public DeliveryStatus() throws MessagingException {
        this.messageDSN = new InternetHeaders();
        this.recipientDSN = new InternetHeaders[0];
    }

    static {
        try {
            String property = System.getProperty("mail.dsn.debug");
            debug = (property == null || property.equalsIgnoreCase("false")) ? false : true;
        } catch (SecurityException unused) {
        }
    }

    public void addRecipientDSN(InternetHeaders internetHeaders) {
        InternetHeaders[] internetHeadersArr = this.recipientDSN;
        InternetHeaders[] internetHeadersArr2 = new InternetHeaders[internetHeadersArr.length + 1];
        System.arraycopy(internetHeadersArr, 0, internetHeadersArr2, 0, internetHeadersArr.length);
        this.recipientDSN = internetHeadersArr2;
        internetHeadersArr2[internetHeadersArr2.length - 1] = internetHeaders;
    }

    public InternetHeaders getMessageDSN() {
        return this.messageDSN;
    }

    public InternetHeaders getRecipientDSN(int i6) {
        return this.recipientDSN[i6];
    }

    public int getRecipientDSNCount() {
        return this.recipientDSN.length;
    }

    public void setMessageDSN(InternetHeaders internetHeaders) {
        this.messageDSN = internetHeaders;
    }

    public String toString() {
        return "DeliveryStatus: Reporting-MTA=" + this.messageDSN.getHeader("Reporting-MTA", null) + ", #Recipients=" + this.recipientDSN.length;
    }

    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream);
        writeInternetHeaders(this.messageDSN, lineOutputStream);
        lineOutputStream.writeln();
        int i6 = 0;
        while (true) {
            InternetHeaders[] internetHeadersArr = this.recipientDSN;
            if (i6 >= internetHeadersArr.length) {
                return;
            }
            writeInternetHeaders(internetHeadersArr[i6], lineOutputStream);
            lineOutputStream.writeln();
            i6++;
        }
    }

    private static void writeInternetHeaders(InternetHeaders internetHeaders, LineOutputStream lineOutputStream) throws IOException {
        Enumeration allHeaderLines = internetHeaders.getAllHeaderLines();
        while (allHeaderLines.hasMoreElements()) {
            try {
                lineOutputStream.writeln((String) allHeaderLines.nextElement());
            } catch (MessagingException e6) {
                Exception nextException = e6.getNextException();
                if (nextException instanceof IOException) {
                    throw ((IOException) nextException);
                }
                throw new IOException("Exception writing headers: " + e6);
            }
        }
    }

    public DeliveryStatus(InputStream inputStream) throws MessagingException, IOException {
        this.messageDSN = new InternetHeaders(inputStream);
        if (debug) {
            System.out.getClass();
        }
        Vector vector = new Vector();
        while (inputStream.available() > 0) {
            try {
                InternetHeaders internetHeaders = new InternetHeaders(inputStream);
                if (debug) {
                    System.out.getClass();
                }
                vector.addElement(internetHeaders);
            } catch (EOFException unused) {
                if (debug) {
                    System.out.getClass();
                }
            }
        }
        if (debug) {
            PrintStream printStream = System.out;
            vector.size();
            printStream.getClass();
        }
        InternetHeaders[] internetHeadersArr = new InternetHeaders[vector.size()];
        this.recipientDSN = internetHeadersArr;
        vector.copyInto(internetHeadersArr);
    }
}
