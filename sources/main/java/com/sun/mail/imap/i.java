package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import javax.mail.Flags;
import javax.mail.FolderClosedException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i extends g {

    /* renamed from: o, reason: collision with root package name */
    private g f39330o;

    @Override // com.sun.mail.imap.g, javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z5) throws MessagingException {
        throw new MethodNotSupportedException("Cannot set flags on this nested message");
    }

    @Override // com.sun.mail.imap.g
    protected boolean A() throws FolderClosedException {
        return this.f39330o.A();
    }

    @Override // com.sun.mail.imap.g, javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.f39309a.f39411f;
    }

    @Override // javax.mail.Message
    public boolean isExpunged() {
        return this.f39330o.isExpunged();
    }

    @Override // com.sun.mail.imap.g
    protected void n() throws MessageRemovedException {
        this.f39330o.n();
    }

    @Override // com.sun.mail.imap.g
    protected int r() {
        return this.f39330o.r();
    }

    @Override // com.sun.mail.imap.g
    protected Object t() {
        return this.f39330o.t();
    }

    @Override // com.sun.mail.imap.g
    protected com.sun.mail.imap.protocol.h v() throws ProtocolException, FolderClosedException {
        return this.f39330o.v();
    }

    @Override // com.sun.mail.imap.g
    protected int w() {
        return this.f39330o.w();
    }

    i(g gVar, com.sun.mail.imap.protocol.d dVar, com.sun.mail.imap.protocol.e eVar, String str) {
        super(gVar.d());
        this.f39330o = gVar;
        this.f39309a = dVar;
        this.f39310b = eVar;
        this.f39316h = str;
    }
}
