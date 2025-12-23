package com.sun.mail.smtp;

import javax.mail.Session;
import javax.mail.URLName;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SMTPSSLTransport extends SMTPTransport {
    public SMTPSSLTransport(Session session, URLName uRLName) {
        super(session, uRLName, "smtps", 465, true);
    }
}
