package com.sun.mail.smtp;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SMTPAddressSucceededException extends MessagingException {
    private static final long serialVersionUID = -1168335848623096749L;
    protected InternetAddress addr;
    protected String cmd;
    protected int rc;

    public InternetAddress getAddress() {
        return this.addr;
    }

    public String getCommand() {
        return this.cmd;
    }

    public int getReturnCode() {
        return this.rc;
    }

    public SMTPAddressSucceededException(InternetAddress internetAddress, String str, int i6, String str2) {
        super(str2);
        this.addr = internetAddress;
        this.cmd = str;
        this.rc = i6;
    }
}
