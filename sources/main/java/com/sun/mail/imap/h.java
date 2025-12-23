package com.sun.mail.imap;

import java.util.Vector;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.MultipartDataSource;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends MimePartDataSource implements MultipartDataSource {

    /* renamed from: a, reason: collision with root package name */
    private Vector f39329a;

    @Override // javax.mail.MultipartDataSource
    public BodyPart getBodyPart(int i6) throws MessagingException {
        return (BodyPart) this.f39329a.elementAt(i6);
    }

    @Override // javax.mail.MultipartDataSource
    public int getCount() {
        return this.f39329a.size();
    }

    protected h(MimePart mimePart, com.sun.mail.imap.protocol.d[] dVarArr, String str, g gVar) {
        super(mimePart);
        String str2;
        this.f39329a = new Vector(dVarArr.length);
        for (int i6 = 0; i6 < dVarArr.length; i6++) {
            Vector vector = this.f39329a;
            com.sun.mail.imap.protocol.d dVar = dVarArr[i6];
            if (str == null) {
                str2 = Integer.toString(i6 + 1);
            } else {
                str2 = str + "." + Integer.toString(i6 + 1);
            }
            vector.addElement(new d(dVar, str2, gVar));
        }
    }
}
