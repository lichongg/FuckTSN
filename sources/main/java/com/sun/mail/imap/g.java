package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.e;
import com.sun.mail.imap.o;
import com.sun.mail.imap.protocol.q;
import com.sun.mail.imap.protocol.r;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.UIDFolder;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParameterList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g extends MimeMessage {

    /* renamed from: n, reason: collision with root package name */
    private static String f39308n = "ENVELOPE INTERNALDATE RFC822.SIZE";

    /* renamed from: a, reason: collision with root package name */
    protected com.sun.mail.imap.protocol.d f39309a;

    /* renamed from: b, reason: collision with root package name */
    protected com.sun.mail.imap.protocol.e f39310b;

    /* renamed from: c, reason: collision with root package name */
    private Date f39311c;

    /* renamed from: d, reason: collision with root package name */
    private int f39312d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f39313e;

    /* renamed from: f, reason: collision with root package name */
    private int f39314f;

    /* renamed from: g, reason: collision with root package name */
    private long f39315g;

    /* renamed from: h, reason: collision with root package name */
    protected String f39316h;

    /* renamed from: i, reason: collision with root package name */
    private String f39317i;

    /* renamed from: j, reason: collision with root package name */
    private String f39318j;

    /* renamed from: k, reason: collision with root package name */
    private String f39319k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f39320l;

    /* renamed from: m, reason: collision with root package name */
    private Hashtable f39321m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements o.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f39322a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f39323b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f39324c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f39325d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f39326e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f39327f;

        /* renamed from: g, reason: collision with root package name */
        private String[] f39328g;

        @Override // com.sun.mail.imap.o.a
        public boolean a(g gVar) {
            if (this.f39322a && gVar.b() == null) {
                return true;
            }
            if (this.f39323b && gVar.c() == null) {
                return true;
            }
            if (this.f39324c && gVar.a() == null) {
                return true;
            }
            if (this.f39325d && gVar.x() == -1) {
                return true;
            }
            if (this.f39326e && !gVar.m()) {
                return true;
            }
            if (this.f39327f && gVar.f39312d == -1) {
                return true;
            }
            int i6 = 0;
            while (true) {
                String[] strArr = this.f39328g;
                if (i6 >= strArr.length) {
                    return false;
                }
                if (!gVar.z(strArr[i6])) {
                    return true;
                }
                i6++;
            }
        }

        public a(FetchProfile fetchProfile) {
            this.f39322a = false;
            this.f39323b = false;
            this.f39324c = false;
            this.f39325d = false;
            this.f39326e = false;
            this.f39327f = false;
            this.f39328g = null;
            if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
                this.f39322a = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.FLAGS)) {
                this.f39323b = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.CONTENT_INFO)) {
                this.f39324c = true;
            }
            if (fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
                this.f39325d = true;
            }
            if (fetchProfile.contains(e.t.f39295a)) {
                this.f39326e = true;
            }
            if (fetchProfile.contains(e.t.f39296b)) {
                this.f39327f = true;
            }
            this.f39328g = fetchProfile.getHeaderNames();
        }
    }

    protected g(e eVar, int i6, int i7) {
        super(eVar, i6);
        this.f39312d = -1;
        this.f39315g = -1L;
        this.f39320l = false;
        this.f39314f = i7;
        this.flags = null;
    }

    private synchronized void B() throws MessagingException {
        if (this.f39309a != null) {
            return;
        }
        synchronized (t()) {
            try {
                try {
                    com.sun.mail.imap.protocol.h v5 = v();
                    n();
                    com.sun.mail.imap.protocol.d R = v5.R(w());
                    this.f39309a = R;
                    if (R == null) {
                        q();
                        throw new MessagingException("Unable to load BODYSTRUCTURE");
                    }
                } catch (ProtocolException e6) {
                    q();
                    throw new MessagingException(e6.getMessage(), e6);
                }
            } catch (ConnectionException e7) {
                throw new FolderClosedException(this.folder, e7.getMessage());
            }
        }
    }

    private synchronized void C() throws MessagingException {
        if (this.f39310b != null) {
            return;
        }
        synchronized (t()) {
            try {
                com.sun.mail.imap.protocol.h v5 = v();
                n();
                int w5 = w();
                com.sun.mail.iap.g[] J = v5.J(w5, f39308n);
                for (int i6 = 0; i6 < J.length; i6++) {
                    com.sun.mail.iap.g gVar = J[i6];
                    if (gVar != null && (gVar instanceof com.sun.mail.imap.protocol.f) && ((com.sun.mail.imap.protocol.f) gVar).E() == w5) {
                        com.sun.mail.imap.protocol.f fVar = (com.sun.mail.imap.protocol.f) J[i6];
                        int L = fVar.L();
                        for (int i7 = 0; i7 < L; i7++) {
                            com.sun.mail.imap.protocol.l I = fVar.I(i7);
                            if (I instanceof com.sun.mail.imap.protocol.e) {
                                this.f39310b = (com.sun.mail.imap.protocol.e) I;
                            } else if (I instanceof com.sun.mail.imap.protocol.k) {
                                this.f39311c = ((com.sun.mail.imap.protocol.k) I).b();
                            } else if (I instanceof r) {
                                this.f39312d = ((r) I).f39498b;
                            }
                        }
                    }
                }
                v5.j(J);
                v5.h(J[J.length - 1]);
            } catch (ConnectionException e6) {
                throw new FolderClosedException(this.folder, e6.getMessage());
            } catch (ProtocolException e7) {
                q();
                throw new MessagingException(e7.getMessage(), e7);
            }
        }
        if (this.f39310b == null) {
            throw new MessagingException("Failed to load IMAP envelope");
        }
    }

    private synchronized void D() throws MessagingException {
        if (this.flags != null) {
            return;
        }
        synchronized (t()) {
            try {
                try {
                    com.sun.mail.imap.protocol.h v5 = v();
                    n();
                    this.flags = v5.S(w());
                } catch (ProtocolException e6) {
                    q();
                    throw new MessagingException(e6.getMessage(), e6);
                }
            } catch (ConnectionException e7) {
                throw new FolderClosedException(this.folder, e7.getMessage());
            }
        }
    }

    private synchronized void E() throws MessagingException {
        ByteArrayInputStream b6;
        if (this.f39320l) {
            return;
        }
        synchronized (t()) {
            try {
                try {
                    com.sun.mail.imap.protocol.h v5 = v();
                    n();
                    if (v5.i0()) {
                        com.sun.mail.imap.protocol.c u02 = v5.u0(w(), K("HEADER"));
                        if (u02 != null) {
                            b6 = u02.b();
                        }
                        b6 = null;
                    } else {
                        q T = v5.T(w(), "HEADER");
                        if (T != null) {
                            b6 = T.b();
                        }
                        b6 = null;
                    }
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this.folder, e6.getMessage());
                } catch (ProtocolException e7) {
                    q();
                    throw new MessagingException(e7.getMessage(), e7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (b6 == null) {
            throw new MessagingException("Cannot load header");
        }
        this.headers = new InternetHeaders(b6);
        this.f39320l = true;
    }

    private synchronized void F(String str) {
        try {
            if (this.f39321m == null) {
                this.f39321m = new Hashtable(1);
            }
            this.f39321m.put(str.toUpperCase(Locale.ENGLISH), str);
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void G(boolean z5) {
        this.f39320l = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean m() {
        return this.f39320l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean z(String str) {
        if (this.f39320l) {
            return true;
        }
        Hashtable hashtable = this.f39321m;
        return hashtable != null ? hashtable.containsKey(str.toUpperCase(Locale.ENGLISH)) : false;
    }

    public synchronized void H(boolean z5) {
        this.f39313e = z5;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        String str;
        try {
            n();
            if (this.dh == null) {
                B();
                if (this.f39317i == null) {
                    com.sun.mail.imap.protocol.d dVar = this.f39309a;
                    this.f39317i = new ContentType(dVar.f39407b, dVar.f39408c, dVar.f39417l).toString();
                }
                if (this.f39309a.a()) {
                    this.dh = new DataHandler(new h(this, this.f39309a.f39420o, this.f39316h, this));
                } else if (this.f39309a.b() && A()) {
                    com.sun.mail.imap.protocol.d dVar2 = this.f39309a;
                    com.sun.mail.imap.protocol.d dVar3 = dVar2.f39420o[0];
                    com.sun.mail.imap.protocol.e eVar = dVar2.f39421p;
                    String str2 = this.f39316h;
                    if (str2 == null) {
                        str = "1";
                    } else {
                        str = String.valueOf(str2) + ".1";
                    }
                    this.dh = new DataHandler(new i(this, dVar3, eVar, str), this.f39317i);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized Flags getFlags() throws MessagingException {
        n();
        D();
        return super.getFlags();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        ByteArrayInputStream b6;
        n();
        if (z(str)) {
            return this.headers.getHeader(str);
        }
        synchronized (t()) {
            try {
                try {
                    com.sun.mail.imap.protocol.h v5 = v();
                    n();
                    if (v5.i0()) {
                        com.sun.mail.imap.protocol.c u02 = v5.u0(w(), K("HEADER.FIELDS (" + str + ")"));
                        if (u02 != null) {
                            b6 = u02.b();
                        }
                        b6 = null;
                    } else {
                        q T = v5.T(w(), "HEADER.LINES (" + str + ")");
                        if (T != null) {
                            b6 = T.b();
                        }
                        b6 = null;
                    }
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this.folder, e6.getMessage());
                } catch (ProtocolException e7) {
                    q();
                    throw new MessagingException(e7.getMessage(), e7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (b6 == null) {
            return null;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        this.headers.load(b6);
        F(str);
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized boolean isSet(Flags.Flag flag) throws MessagingException {
        n();
        D();
        return super.isSet(flag);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z5) throws MessagingException {
        synchronized (t()) {
            try {
                com.sun.mail.imap.protocol.h v5 = v();
                n();
                v5.M0(w(), flags, z5);
            } catch (ConnectionException e6) {
                throw new FolderClosedException(this.folder, e6.getMessage());
            } catch (ProtocolException e7) {
                throw new MessagingException(e7.getMessage(), e7);
            }
        }
    }

    public synchronized boolean u() {
        return this.f39313e;
    }

    public synchronized void y() {
        this.f39320l = false;
        this.f39321m = null;
        this.f39310b = null;
        this.f39309a = null;
        this.f39311c = null;
        this.f39312d = -1;
        this.f39317i = null;
        this.f39318j = null;
        this.f39319k = null;
    }

    private String K(String str) {
        String str2 = this.f39316h;
        if (str2 == null) {
            return str;
        }
        return String.valueOf(str2) + "." + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sun.mail.imap.protocol.d a() {
        return this.f39309a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sun.mail.imap.protocol.e b() {
        return this.f39310b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Flags c() {
        return this.flags;
    }

    private InternetAddress[] f(InternetAddress[] internetAddressArr) {
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01ee A[Catch: all -> 0x00bc, TryCatch #2 {all -> 0x00bc, blocks: (B:47:0x00b4, B:49:0x00ba, B:52:0x00bf, B:54:0x00c4, B:56:0x00e2, B:60:0x00e5, B:143:0x00e8, B:145:0x00ee, B:146:0x00f6, B:62:0x00f8, B:66:0x011c, B:67:0x00fd, B:69:0x0101, B:71:0x0105, B:139:0x0119, B:73:0x011f, B:75:0x0127, B:79:0x0132, B:83:0x01f8, B:86:0x0145, B:88:0x0149, B:89:0x014e, B:91:0x0152, B:92:0x015b, B:94:0x015f, B:95:0x0166, B:97:0x016a, B:98:0x016f, B:100:0x0173, B:102:0x017d, B:103:0x0184, B:104:0x0195, B:106:0x019d, B:108:0x01a1, B:110:0x01a5, B:111:0x01b2, B:115:0x01c1, B:116:0x01c5, B:128:0x01ee, B:131:0x01f5, B:133:0x0200, B:118:0x01cc, B:121:0x01dc, B:135:0x01ea, B:136:0x01ac, B:154:0x00d6, B:155:0x00df, B:151:0x0208, B:152:0x0211), top: B:46:0x00b4, inners: #4, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void p(com.sun.mail.imap.e r17, javax.mail.Message[] r18, javax.mail.FetchProfile r19) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.g.p(com.sun.mail.imap.e, javax.mail.Message[], javax.mail.FetchProfile):void");
    }

    protected boolean A() throws FolderClosedException {
        com.sun.mail.imap.protocol.h hVar = ((e) this.folder).f39240j;
        if (hVar != null) {
            return hVar.i0();
        }
        throw new FolderClosedException(this.folder);
    }

    protected void I(int i6) {
        this.f39314f = i6;
    }

    protected void J(long j6) {
        this.f39315g = j6;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addFrom(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    Session d() {
        return this.session;
    }

    void e(Flags flags) {
        this.flags = flags;
    }

    protected void n() throws MessageRemovedException {
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    protected int r() {
        return ((k) this.folder.getStore()).h();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setContentID(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentLanguage(String[] strArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setFrom(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSender(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setSentDate(Date date) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSubject(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    protected Object t() {
        return ((e) this.folder).f39242l;
    }

    protected com.sun.mail.imap.protocol.h v() throws ProtocolException, FolderClosedException {
        ((e) this.folder).S();
        com.sun.mail.imap.protocol.h hVar = ((e) this.folder).f39240j;
        if (hVar != null) {
            return hVar;
        }
        throw new FolderClosedException(this.folder);
    }

    protected int w() {
        return this.f39314f;
    }

    protected long x() {
        return this.f39315g;
    }

    private static String o(com.sun.mail.imap.protocol.h hVar, String[] strArr) {
        StringBuffer stringBuffer;
        if (hVar.i0()) {
            stringBuffer = new StringBuffer("BODY.PEEK[HEADER.FIELDS (");
        } else {
            stringBuffer = new StringBuffer("RFC822.HEADER.LINES (");
        }
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (i6 > 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(strArr[i6]);
        }
        if (hVar.i0()) {
            stringBuffer.append(")]");
        } else {
            stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        n();
        E();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        n();
        E();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        n();
        B();
        return this.f39309a.f39413h;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String[] getContentLanguage() throws MessagingException {
        n();
        B();
        String[] strArr = this.f39309a.f39419n;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        n();
        B();
        return this.f39309a.f39415j;
    }

    @Override // javax.mail.internet.MimeMessage
    protected InputStream getContentStream() throws MessagingException {
        ByteArrayInputStream b6;
        com.sun.mail.imap.protocol.c M;
        boolean u5 = u();
        synchronized (t()) {
            try {
                try {
                    com.sun.mail.imap.protocol.h v5 = v();
                    n();
                    if (v5.i0()) {
                        int i6 = -1;
                        if (r() != -1) {
                            String K = K("TEXT");
                            com.sun.mail.imap.protocol.d dVar = this.f39309a;
                            if (dVar != null) {
                                i6 = dVar.f39411f;
                            }
                            return new f(this, K, i6, u5);
                        }
                    }
                    if (v5.i0()) {
                        if (u5) {
                            M = v5.u0(w(), K("TEXT"));
                        } else {
                            M = v5.M(w(), K("TEXT"));
                        }
                        if (M != null) {
                            b6 = M.b();
                        }
                        b6 = null;
                    } else {
                        q T = v5.T(w(), "TEXT");
                        if (T != null) {
                            b6 = T.b();
                        }
                        b6 = null;
                    }
                    if (b6 != null) {
                        return b6;
                    }
                    throw new MessagingException("No content");
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this.folder, e6.getMessage());
                } catch (ProtocolException e7) {
                    q();
                    throw new MessagingException(e7.getMessage(), e7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getContentType() throws MessagingException {
        n();
        if (this.f39317i == null) {
            B();
            com.sun.mail.imap.protocol.d dVar = this.f39309a;
            this.f39317i = new ContentType(dVar.f39407b, dVar.f39408c, dVar.f39417l).toString();
        }
        return this.f39317i;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDescription() throws MessagingException {
        n();
        String str = this.f39319k;
        if (str != null) {
            return str;
        }
        B();
        String str2 = this.f39309a.f39414i;
        if (str2 == null) {
            return null;
        }
        try {
            this.f39319k = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f39319k = this.f39309a.f39414i;
        }
        return this.f39319k;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDisposition() throws MessagingException {
        n();
        B();
        return this.f39309a.f39412g;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        n();
        B();
        return this.f39309a.f39409d;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getFileName() throws MessagingException {
        String str;
        ParameterList parameterList;
        n();
        B();
        ParameterList parameterList2 = this.f39309a.f39418m;
        if (parameterList2 != null) {
            str = parameterList2.get("filename");
        } else {
            str = null;
        }
        if (str == null && (parameterList = this.f39309a.f39417l) != null) {
            return parameterList.get(CommonNetImpl.NAME);
        }
        return str;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getFrom() throws MessagingException {
        n();
        C();
        return f(this.f39310b.f39428d);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getLineCount() throws MessagingException {
        n();
        B();
        return this.f39309a.f39410e;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        n();
        E();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        n();
        E();
        return super.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage
    public String getMessageID() throws MessagingException {
        n();
        C();
        return this.f39310b.f39435k;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        n();
        E();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        n();
        E();
        return super.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getReceivedDate() throws MessagingException {
        n();
        C();
        if (this.f39311c == null) {
            return null;
        }
        return new Date(this.f39311c.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getRecipients(Message.RecipientType recipientType) throws MessagingException {
        n();
        C();
        if (recipientType == Message.RecipientType.TO) {
            return f(this.f39310b.f39431g);
        }
        if (recipientType == Message.RecipientType.CC) {
            return f(this.f39310b.f39432h);
        }
        if (recipientType == Message.RecipientType.BCC) {
            return f(this.f39310b.f39433i);
        }
        return super.getRecipients(recipientType);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getReplyTo() throws MessagingException {
        n();
        C();
        return f(this.f39310b.f39430f);
    }

    @Override // javax.mail.internet.MimeMessage
    public Address getSender() throws MessagingException {
        n();
        C();
        InternetAddress[] internetAddressArr = this.f39310b.f39429e;
        if (internetAddressArr != null) {
            return internetAddressArr[0];
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getSentDate() throws MessagingException {
        n();
        C();
        if (this.f39310b.f39426b == null) {
            return null;
        }
        return new Date(this.f39310b.f39426b.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        n();
        if (this.f39312d == -1) {
            C();
        }
        return this.f39312d;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public String getSubject() throws MessagingException {
        n();
        String str = this.f39318j;
        if (str != null) {
            return str;
        }
        C();
        String str2 = this.f39310b.f39427c;
        if (str2 == null) {
            return null;
        }
        try {
            this.f39318j = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f39318j = this.f39310b.f39427c;
        }
        return this.f39318j;
    }

    protected void q() throws MessageRemovedException, FolderClosedException {
        synchronized (t()) {
            try {
                v().r0();
            } catch (ConnectionException e6) {
                throw new FolderClosedException(this.folder, e6.getMessage());
            } catch (ProtocolException unused) {
            }
        }
        if (!this.expunged) {
        } else {
            throw new MessageRemovedException();
        }
    }

    public String s() throws MessagingException {
        n();
        C();
        return this.f39310b.f39434j;
    }

    @Override // javax.mail.Message
    protected void setExpunged(boolean z5) {
        super.setExpunged(z5);
        this.f39314f = -1;
    }

    @Override // javax.mail.Message
    protected void setMessageNumber(int i6) {
        super.setMessageNumber(i6);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        com.sun.mail.imap.protocol.c M;
        boolean u5 = u();
        synchronized (t()) {
            try {
                try {
                    com.sun.mail.imap.protocol.h v5 = v();
                    n();
                    byteArrayInputStream = null;
                    if (v5.i0()) {
                        if (u5) {
                            M = v5.u0(w(), this.f39316h);
                        } else {
                            M = v5.M(w(), this.f39316h);
                        }
                        if (M != null) {
                            byteArrayInputStream = M.b();
                        }
                    } else {
                        q T = v5.T(w(), null);
                        if (T != null) {
                            byteArrayInputStream = T.b();
                        }
                    }
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this.folder, e6.getMessage());
                } catch (ProtocolException e7) {
                    q();
                    throw new MessagingException(e7.getMessage(), e7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (byteArrayInputStream != null) {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (read == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, read);
                }
            }
        } else {
            throw new MessagingException("No content");
        }
    }

    protected g(Session session) {
        super(session);
        this.f39312d = -1;
        this.f39315g = -1L;
        this.f39320l = false;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        n();
        if (getHeader(str) == null) {
            return null;
        }
        return this.headers.getHeader(str, str2);
    }
}
