package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.e;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import kotlin.jvm.internal.q;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e.u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ String f39222b;

        a(String str) {
            this.f39222b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.k0("", this.f39222b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements e.u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ String f39224b;

        b(String str) {
            this.f39224b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.o0("", this.f39224b);
        }
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Folder getParent() {
        return null;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    protected c(k kVar) {
        super("", q.f44042c, kVar);
        this.f39237g = true;
        this.f39233c = 2;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Cannot append to Default Folder");
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public boolean delete(boolean z5) throws MessagingException {
        throw new MethodNotSupportedException("Cannot delete Default Folder");
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Cannot expunge Default Folder");
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        return new e(str, q.f44042c, (k) this.store);
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public String getName() {
        return this.f39231a;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) p(new a(str));
        if (mVarArr == null) {
            return new Folder[0];
        }
        int length = mVarArr.length;
        e[] eVarArr = new e[length];
        for (int i6 = 0; i6 < length; i6++) {
            eVarArr[i6] = new e(mVarArr[i6], (k) this.store);
        }
        return eVarArr;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Folder[] listSubscribed(String str) throws MessagingException {
        com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) p(new b(str));
        if (mVarArr == null) {
            return new Folder[0];
        }
        int length = mVarArr.length;
        e[] eVarArr = new e[length];
        for (int i6 = 0; i6 < length; i6++) {
            eVarArr[i6] = new e(mVarArr[i6], (k) this.store);
        }
        return eVarArr;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("Cannot rename Default Folder");
    }
}
