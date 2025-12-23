package com.sun.mail.smtp;

import javax.mail.Address;
import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SMTPSendFailedException extends SendFailedException {
    private static final long serialVersionUID = 8049122628728932894L;
    protected InternetAddress addr;
    protected String cmd;
    protected int rc;

    public SMTPSendFailedException(String str, int i6, String str2, Exception exc, Address[] addressArr, Address[] addressArr2, Address[] addressArr3) {
        super(str2, exc, addressArr, addressArr2, addressArr3);
        this.cmd = str;
        this.rc = i6;
    }

    public String getCommand() {
        return this.cmd;
    }

    public int getReturnCode() {
        return this.rc;
    }
}
