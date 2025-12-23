package com.sun.mail.imap;

import com.sun.mail.util.CRLFOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.mail.Message;
import javax.mail.MessagingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class m implements com.sun.mail.iap.e {

    /* renamed from: a, reason: collision with root package name */
    private Message f39374a;

    /* renamed from: b, reason: collision with root package name */
    private int f39375b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f39376c;

    @Override // com.sun.mail.iap.e
    public int size() {
        return this.f39375b;
    }

    @Override // com.sun.mail.iap.e
    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = this.f39376c;
            if (bArr != null) {
                outputStream.write(bArr, 0, this.f39375b);
            } else {
                this.f39374a.writeTo(new CRLFOutputStream(outputStream));
            }
        } catch (MessagingException e6) {
            throw new IOException("MessagingException while appending message: " + e6);
        }
    }

    public m(Message message, int i6) throws MessagingException, IOException {
        this.f39375b = -1;
        this.f39374a = message;
        l lVar = new l(i6);
        CRLFOutputStream cRLFOutputStream = new CRLFOutputStream(lVar);
        message.writeTo(cRLFOutputStream);
        cRLFOutputStream.flush();
        this.f39375b = lVar.b();
        this.f39376c = lVar.a();
    }
}
