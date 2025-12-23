package com.sun.mail.imap;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.v;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Vector;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Quota;
import javax.mail.StoreClosedException;
import javax.mail.UIDFolder;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends Folder implements UIDFolder, com.sun.mail.iap.h {
    protected static final char C = 65535;
    private static final int D = 0;
    private static final int E = 1;
    private static final int F = 2;
    static final /* synthetic */ boolean G = false;
    private PrintStream A;
    private boolean B;

    /* renamed from: a, reason: collision with root package name */
    protected String f39231a;

    /* renamed from: b, reason: collision with root package name */
    protected String f39232b;

    /* renamed from: c, reason: collision with root package name */
    protected int f39233c;

    /* renamed from: d, reason: collision with root package name */
    protected char f39234d;

    /* renamed from: e, reason: collision with root package name */
    protected Flags f39235e;

    /* renamed from: f, reason: collision with root package name */
    protected Flags f39236f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f39237g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f39238h;

    /* renamed from: i, reason: collision with root package name */
    protected String[] f39239i;

    /* renamed from: j, reason: collision with root package name */
    protected com.sun.mail.imap.protocol.h f39240j;

    /* renamed from: k, reason: collision with root package name */
    protected Vector f39241k;

    /* renamed from: l, reason: collision with root package name */
    protected Object f39242l;

    /* renamed from: m, reason: collision with root package name */
    protected Hashtable f39243m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f39244n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f39245o;

    /* renamed from: p, reason: collision with root package name */
    private int f39246p;

    /* renamed from: r, reason: collision with root package name */
    private int f39247r;

    /* renamed from: s, reason: collision with root package name */
    private int f39248s;

    /* renamed from: t, reason: collision with root package name */
    private int f39249t;

    /* renamed from: u, reason: collision with root package name */
    private long f39250u;

    /* renamed from: v, reason: collision with root package name */
    private long f39251v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f39252w;

    /* renamed from: x, reason: collision with root package name */
    private com.sun.mail.imap.protocol.u f39253x;

    /* renamed from: y, reason: collision with root package name */
    private long f39254y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f39255z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ Flags f39257b;

        /* renamed from: c, reason: collision with root package name */
        private final /* synthetic */ Date f39258c;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ com.sun.mail.imap.m f39259d;

        a(Flags flags, Date date, com.sun.mail.imap.m mVar) {
            this.f39257b = flags;
            this.f39258c = date;
            this.f39259d = mVar;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.r(e.this.f39231a, this.f39257b, this.f39258c, this.f39259d);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ Flags f39261b;

        /* renamed from: c, reason: collision with root package name */
        private final /* synthetic */ Date f39262c;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ com.sun.mail.imap.m f39263d;

        b(Flags flags, Date date, com.sun.mail.imap.m mVar) {
            this.f39261b = flags;
            this.f39262c = date;
            this.f39263d = mVar;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.s(e.this.f39231a, this.f39261b, this.f39262c, this.f39263d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements u {
        c() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.d0(e.this.f39231a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ Quota f39266b;

        d(Quota quota) {
            this.f39266b = quota;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.I0(this.f39266b);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.sun.mail.imap.e$e, reason: collision with other inner class name */
    class C0805e implements u {
        C0805e() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.Y(e.this.f39231a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ String f39269b;

        f(String str) {
            this.f39269b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.E(e.this.f39231a, this.f39269b);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ String f39271b;

        g(String str) {
            this.f39271b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.l0(e.this.f39231a, this.f39271b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements u {
        h() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.p0(e.this.f39231a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ char f39274b;

        /* renamed from: c, reason: collision with root package name */
        private final /* synthetic */ com.sun.mail.imap.a f39275c;

        i(char c6, com.sun.mail.imap.a aVar) {
            this.f39274b = c6;
            this.f39275c = aVar;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.G0(e.this.f39231a, this.f39274b, this.f39275c);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j implements u {
        j() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            if (e.this.f39246p != 0) {
                try {
                    e.this.f39242l.wait();
                } catch (InterruptedException unused) {
                }
                return Boolean.FALSE;
            }
            hVar.g0();
            e.this.f39246p = 1;
            return Boolean.TRUE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class k implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ String f39278b;

        k(String str) {
            this.f39278b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.k0("", this.f39278b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class l implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ boolean f39280b;

        /* renamed from: c, reason: collision with root package name */
        private final /* synthetic */ char f39281c;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ String f39282d;

        l(boolean z5, char c6, String str) {
            this.f39280b = z5;
            this.f39281c = c6;
            this.f39282d = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            if (this.f39280b) {
                return hVar.o0("", String.valueOf(e.this.f39231a) + this.f39281c + this.f39282d);
            }
            return hVar.k0("", String.valueOf(e.this.f39231a) + this.f39281c + this.f39282d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class m implements u {
        m() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            if (hVar.i0()) {
                return hVar.k0(e.this.f39231a, "");
            }
            return hVar.k0("", e.this.f39231a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class n implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ String f39285b;

        n(String str) {
            this.f39285b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.o0("", this.f39285b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class o implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ boolean f39287b;

        o(boolean z5) {
            this.f39287b = z5;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            if (this.f39287b) {
                hVar.P0(e.this.f39231a);
                return null;
            }
            hVar.R0(e.this.f39231a);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class p implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ int f39289b;

        /* renamed from: c, reason: collision with root package name */
        private final /* synthetic */ char f39290c;

        p(int i6, char c6) {
            this.f39289b = i6;
            this.f39290c = c6;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            com.sun.mail.imap.protocol.m[] k02;
            if ((this.f39289b & 1) == 0) {
                hVar.C(String.valueOf(e.this.f39231a) + this.f39290c);
            } else {
                hVar.C(e.this.f39231a);
                if ((this.f39289b & 2) != 0 && (k02 = hVar.k0("", e.this.f39231a)) != null && !k02[0].f39474c) {
                    hVar.delete(e.this.f39231a);
                    throw new ProtocolException("Unsupported type");
                }
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class q implements u {
        q() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            com.sun.mail.imap.protocol.m[] k02 = hVar.k0("", e.this.f39231a);
            if (k02 != null) {
                int i6 = k02[0].f39476e;
                if (i6 == 1) {
                    return Boolean.TRUE;
                }
                if (i6 == 2) {
                    return Boolean.FALSE;
                }
            }
            return e.this.C().f39504c > 0 ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class r implements u {
        r() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.delete(e.this.f39231a);
            return Boolean.TRUE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class s implements u {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ Folder f39294b;

        s(Folder folder) {
            this.f39294b = folder;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.A0(e.this.f39231a, this.f39294b.getFullName());
            return Boolean.TRUE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface u {
        Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException;
    }

    protected e(String str, char c6, com.sun.mail.imap.k kVar) {
        super(kVar);
        int indexOf;
        this.f39237g = false;
        this.f39238h = false;
        this.f39244n = false;
        this.f39245o = true;
        this.f39246p = 0;
        this.f39247r = -1;
        this.f39248s = -1;
        this.f39249t = -1;
        this.f39250u = -1L;
        this.f39251v = -1L;
        this.f39252w = true;
        this.f39253x = null;
        this.f39254y = 0L;
        this.f39255z = false;
        if (str == null) {
            throw new NullPointerException("Folder name is null");
        }
        this.f39231a = str;
        this.f39234d = c6;
        this.f39242l = new Object();
        this.f39255z = kVar.l().getDebug();
        this.B = kVar.g();
        PrintStream debugOut = kVar.l().getDebugOut();
        this.A = debugOut;
        if (debugOut == null) {
            this.A = System.out;
        }
        this.f39238h = false;
        if (c6 == 65535 || c6 == 0 || (indexOf = this.f39231a.indexOf(c6)) <= 0 || indexOf != this.f39231a.length() - 1) {
            return;
        }
        this.f39231a = this.f39231a.substring(0, indexOf);
        this.f39238h = true;
    }

    private synchronized void R(ConnectionException connectionException) throws FolderClosedException, StoreClosedException {
        try {
            if (this.f39240j != null) {
                if (connectionException.getProtocol() != this.f39240j) {
                }
                throw new FolderClosedException(this, connectionException.getMessage());
            }
            if (this.f39240j != null || this.f39245o) {
                throw new StoreClosedException(this.store, connectionException.getMessage());
            }
            throw new FolderClosedException(this, connectionException.getMessage());
        } catch (Throwable th) {
            throw th;
        }
    }

    private void m(int i6) throws MessagingException {
        if (i6 < 1) {
            throw new IndexOutOfBoundsException();
        }
        if (i6 <= this.f39247r) {
            return;
        }
        synchronized (this.f39242l) {
            try {
                I(false);
            } catch (ConnectionException e6) {
                throw new FolderClosedException(this, e6.getMessage());
            } catch (ProtocolException e7) {
                throw new MessagingException(e7.getMessage(), e7);
            }
        }
        if (i6 > this.f39247r) {
            throw new IndexOutOfBoundsException();
        }
    }

    private synchronized Folder[] r(String str, boolean z5) throws MessagingException {
        j();
        int i6 = 0;
        if (!H()) {
            return new Folder[0];
        }
        char separator = getSeparator();
        com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) q(new l(z5, separator, str));
        if (mVarArr == null) {
            return new Folder[0];
        }
        if (mVarArr.length > 0) {
            if (mVarArr[0].f39472a.equals(String.valueOf(this.f39231a) + separator)) {
                i6 = 1;
            }
        }
        e[] eVarArr = new e[mVarArr.length - i6];
        for (int i7 = i6; i7 < mVarArr.length; i7++) {
            eVarArr[i7 - i6] = new e(mVarArr[i7], (com.sun.mail.imap.k) this.store);
        }
        return eVarArr;
    }

    private int v(com.sun.mail.imap.protocol.m[] mVarArr, String str) {
        int i6 = 0;
        while (i6 < mVarArr.length && !mVarArr[i6].f39472a.equals(str)) {
            i6++;
        }
        if (i6 >= mVarArr.length) {
            return 0;
        }
        return i6;
    }

    protected synchronized com.sun.mail.imap.protocol.h D() throws ProtocolException {
        try {
            if (this.B) {
                this.A.getClass();
            }
        } catch (Throwable th) {
            throw th;
        }
        return ((com.sun.mail.imap.k) this.store).n();
    }

    public synchronized long E() throws MessagingException {
        Throwable th;
        ProtocolException e6;
        com.sun.mail.imap.protocol.h hVar;
        BadCommandException e7;
        if (this.f39244n) {
            return this.f39251v;
        }
        com.sun.mail.imap.protocol.u uVar = null;
        try {
            try {
                hVar = D();
            } catch (BadCommandException e8) {
                e7 = e8;
            } catch (ConnectionException e9) {
                e = e9;
                hVar = null;
            } catch (ProtocolException e10) {
                e6 = e10;
            } catch (Throwable th2) {
                th = th2;
                M(null);
                throw th;
            }
            try {
                uVar = hVar.K0(this.f39231a, new String[]{"UIDNEXT"});
            } catch (BadCommandException e11) {
                e7 = e11;
                throw new MessagingException("Cannot obtain UIDNext", e7);
            } catch (ConnectionException e12) {
                e = e12;
                R(e);
                M(hVar);
                return uVar.f39505d;
            } catch (ProtocolException e13) {
                e6 = e13;
                throw new MessagingException(e6.getMessage(), e6);
            }
            M(hVar);
            return uVar.f39505d;
        } catch (Throwable th3) {
            th = th3;
            M(null);
            throw th;
        }
    }

    void F(com.sun.mail.iap.g[] gVarArr) {
        for (com.sun.mail.iap.g gVar : gVarArr) {
            if (gVar != null) {
                a(gVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        r0 = ((com.sun.mail.imap.k) r3.store).i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        if (r0 <= 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        java.lang.Thread.sleep(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void G() throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.l()     // Catch: java.lang.Throwable -> L19
            java.lang.String r0 = "IDLE not supported"
            com.sun.mail.imap.e$j r1 = new com.sun.mail.imap.e$j     // Catch: java.lang.Throwable -> L19
            r1.<init>()     // Catch: java.lang.Throwable -> L19
            java.lang.Object r0 = r3.s(r0, r1)     // Catch: java.lang.Throwable -> L19
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L19
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L19
            if (r0 != 0) goto L1b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L19
            return
        L19:
            r0 = move-exception
            goto L62
        L1b:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L19
        L1c:
            com.sun.mail.imap.protocol.h r0 = r3.f39240j
            com.sun.mail.iap.g r0 = r0.z0()
            java.lang.Object r1 = r3.f39242l     // Catch: com.sun.mail.iap.ProtocolException -> L50 com.sun.mail.iap.ConnectionException -> L52
            monitor-enter(r1)     // Catch: com.sun.mail.iap.ProtocolException -> L50 com.sun.mail.iap.ConnectionException -> L52
            if (r0 == 0) goto L36
            com.sun.mail.imap.protocol.h r2 = r3.f39240j     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L36
            boolean r0 = r2.x0(r0)     // Catch: java.lang.Throwable -> L34
            if (r0 != 0) goto L32
            goto L36
        L32:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L34
            goto L1c
        L34:
            r0 = move-exception
            goto L4e
        L36:
            r0 = 0
            r3.f39246p = r0     // Catch: java.lang.Throwable -> L34
            java.lang.Object r0 = r3.f39242l     // Catch: java.lang.Throwable -> L34
            r0.notifyAll()     // Catch: java.lang.Throwable -> L34
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L34
            javax.mail.Store r0 = r3.store
            com.sun.mail.imap.k r0 = (com.sun.mail.imap.k) r0
            int r0 = r0.i()
            if (r0 <= 0) goto L4d
            long r0 = (long) r0
            java.lang.Thread.sleep(r0)     // Catch: java.lang.InterruptedException -> L4d
        L4d:
            return
        L4e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L34
            throw r0     // Catch: com.sun.mail.iap.ProtocolException -> L50 com.sun.mail.iap.ConnectionException -> L52
        L50:
            r0 = move-exception
            goto L54
        L52:
            r0 = move-exception
            goto L5e
        L54:
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L5e:
            r3.R(r0)
            goto L1c
        L62:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L19
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.e.G():void");
    }

    protected synchronized void M(com.sun.mail.imap.protocol.h hVar) {
        if (hVar != this.f39240j) {
            ((com.sun.mail.imap.k) this.store).w(hVar);
        }
    }

    @Override // javax.mail.Folder
    public synchronized void appendMessages(Message[] messageArr) throws MessagingException {
        try {
            j();
            int f6 = ((com.sun.mail.imap.k) this.store).f();
            for (Message message : messageArr) {
                try {
                    com.sun.mail.imap.m mVar = new com.sun.mail.imap.m(message, message.getSize() > f6 ? 0 : f6);
                    Date receivedDate = message.getReceivedDate();
                    if (receivedDate == null) {
                        receivedDate = message.getSentDate();
                    }
                    p(new a(message.getFlags(), receivedDate, mVar));
                } catch (IOException e6) {
                    throw new MessagingException("IOException while appending messages", e6);
                } catch (MessageRemovedException unused) {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z5) throws MessagingException {
        o(z5, false);
    }

    @Override // javax.mail.Folder
    public synchronized void copyMessages(Message[] messageArr, Folder folder) throws MessagingException {
        try {
            l();
            if (messageArr.length == 0) {
                return;
            }
            if (folder.getStore() == this.store) {
                synchronized (this.f39242l) {
                    try {
                        try {
                            com.sun.mail.imap.protocol.h A = A();
                            com.sun.mail.imap.protocol.o[] a6 = com.sun.mail.imap.o.a(messageArr, null);
                            if (a6 == null) {
                                throw new MessageRemovedException("Messages have been removed");
                            }
                            A.B(a6, folder.getFullName());
                        } catch (CommandFailedException e6) {
                            if (e6.getMessage().indexOf("TRYCREATE") == -1) {
                                throw new MessagingException(e6.getMessage(), e6);
                            }
                            throw new FolderNotFoundException(folder, String.valueOf(folder.getFullName()) + " does not exist");
                        } catch (ProtocolException e7) {
                            throw new MessagingException(e7.getMessage(), e7);
                        }
                    } catch (ConnectionException e8) {
                        throw new FolderClosedException(this, e8.getMessage());
                    }
                }
            } else {
                super.copyMessages(messageArr, folder);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean create(int i6) throws MessagingException {
        char separator;
        if ((i6 & 1) == 0) {
            try {
                separator = getSeparator();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            separator = 0;
        }
        if (q(new p(i6, separator)) == null) {
            return false;
        }
        boolean exists = exists();
        if (exists) {
            notifyFolderListeners(1);
        }
        return exists;
    }

    @Override // javax.mail.Folder
    public synchronized boolean delete(boolean z5) throws MessagingException {
        try {
            i();
            if (z5) {
                for (Folder folder : list()) {
                    folder.delete(z5);
                }
            }
            if (q(new r()) == null) {
                return false;
            }
            this.f39237g = false;
            this.f39239i = null;
            notifyFolderListeners(2);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void e(com.sun.mail.imap.a aVar) throws MessagingException {
        P(aVar, (char) 0);
    }

    @Override // javax.mail.Folder
    public synchronized boolean exists() throws MessagingException {
        String str;
        try {
            if (!this.f39238h || this.f39234d == 0) {
                str = this.f39231a;
            } else {
                str = String.valueOf(this.f39231a) + this.f39234d;
            }
            com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) p(new k(str));
            if (mVarArr != null) {
                int v5 = v(mVarArr, str);
                com.sun.mail.imap.protocol.m mVar = mVarArr[v5];
                String str2 = mVar.f39472a;
                this.f39231a = str2;
                this.f39234d = mVar.f39473b;
                int length = str2.length();
                if (this.f39234d != 0 && length > 0) {
                    int i6 = length - 1;
                    if (this.f39231a.charAt(i6) == this.f39234d) {
                        this.f39231a = this.f39231a.substring(0, i6);
                    }
                }
                this.f39233c = 0;
                com.sun.mail.imap.protocol.m mVar2 = mVarArr[v5];
                if (mVar2.f39474c) {
                    this.f39233c = 2;
                }
                if (mVar2.f39475d) {
                    this.f39233c |= 1;
                }
                this.f39237g = true;
                this.f39239i = mVar2.f39477f;
            } else {
                this.f39237g = this.f39244n;
                this.f39239i = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f39237g;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] expunge() throws MessagingException {
        return u(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Message[] f(Message[] messageArr) throws MessagingException {
        MimeMessage[] mimeMessageArr;
        l();
        mimeMessageArr = new MimeMessage[messageArr.length];
        com.sun.mail.imap.b[] h6 = h(messageArr);
        for (int i6 = 0; i6 < h6.length; i6++) {
            com.sun.mail.imap.b bVar = h6[i6];
            if (bVar != null && bVar.f39219a == this.f39250u) {
                try {
                    mimeMessageArr[i6] = getMessageByUID(bVar.f39220b);
                } catch (MessagingException unused) {
                }
            }
        }
        return mimeMessageArr;
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        l();
        com.sun.mail.imap.g.p(this, messageArr, fetchProfile);
    }

    @Override // javax.mail.Folder
    public synchronized int getDeletedMessageCount() throws MessagingException {
        int length;
        if (!this.f39244n) {
            j();
            return -1;
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.DELETED);
        try {
            synchronized (this.f39242l) {
                length = A().D0(new FlagTerm(flags, true)).length;
            }
            return length;
        } catch (ConnectionException e6) {
            throw new FolderClosedException(this, e6.getMessage());
        } catch (ProtocolException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        }
    }

    @Override // javax.mail.Folder
    public synchronized String getFullName() {
        return this.f39231a;
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i6) throws MessagingException {
        l();
        m(i6);
        return (Message) this.f39241k.elementAt(i6 - 1);
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message getMessageByUID(long j6) throws MessagingException {
        com.sun.mail.imap.g gVar;
        int i6;
        l();
        try {
            synchronized (this.f39242l) {
                Long l6 = new Long(j6);
                Hashtable hashtable = this.f39243m;
                if (hashtable != null) {
                    gVar = (com.sun.mail.imap.g) hashtable.get(l6);
                    if (gVar != null) {
                        return gVar;
                    }
                } else {
                    this.f39243m = new Hashtable();
                    gVar = null;
                }
                v U = A().U(j6);
                if (U != null && (i6 = U.f39509a) <= this.f39247r) {
                    gVar = z(i6);
                    gVar.J(U.f39510b);
                    this.f39243m.put(l6, gVar);
                }
                return gVar;
            }
        } catch (ConnectionException e6) {
            throw new FolderClosedException(this, e6.getMessage());
        } catch (ProtocolException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        int i6;
        if (this.f39244n) {
            synchronized (this.f39242l) {
                try {
                    I(true);
                    i6 = this.f39247r;
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this, e6.getMessage());
                } catch (ProtocolException e7) {
                    throw new MessagingException(e7.getMessage(), e7);
                }
            }
            return i6;
        }
        j();
        try {
            try {
                try {
                    return C().f39503b;
                } catch (ProtocolException e8) {
                    throw new MessagingException(e8.getMessage(), e8);
                }
            } catch (BadCommandException unused) {
                com.sun.mail.imap.protocol.h hVar = null;
                try {
                    try {
                        hVar = D();
                        com.sun.mail.imap.protocol.n G2 = hVar.G(this.f39231a);
                        hVar.y();
                        return G2.f39480c;
                    } catch (ProtocolException e9) {
                        throw new MessagingException(e9.getMessage(), e9);
                    }
                } finally {
                    M(hVar);
                }
            }
        } catch (ConnectionException e10) {
            throw new StoreClosedException(this.store, e10.getMessage());
        }
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long j6, long j7) throws MessagingException {
        Message[] messageArr;
        l();
        try {
            synchronized (this.f39242l) {
                try {
                    if (this.f39243m == null) {
                        this.f39243m = new Hashtable();
                    }
                    v[] V = A().V(j6, j7);
                    messageArr = new Message[V.length];
                    for (int i6 = 0; i6 < V.length; i6++) {
                        com.sun.mail.imap.g z5 = z(V[i6].f39509a);
                        z5.J(V[i6].f39510b);
                        messageArr[i6] = z5;
                        this.f39243m.put(new Long(V[i6].f39510b), z5);
                    }
                } finally {
                }
            }
        } catch (ConnectionException e6) {
            throw new FolderClosedException(this, e6.getMessage());
        } catch (ProtocolException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        }
        return messageArr;
    }

    @Override // javax.mail.Folder
    public synchronized String getName() {
        if (this.f39232b == null) {
            try {
                String str = this.f39231a;
                this.f39232b = str.substring(str.lastIndexOf(getSeparator()) + 1);
            } catch (MessagingException unused) {
            }
        }
        return this.f39232b;
    }

    @Override // javax.mail.Folder
    public synchronized int getNewMessageCount() throws MessagingException {
        int i6;
        if (this.f39244n) {
            synchronized (this.f39242l) {
                try {
                    I(true);
                    i6 = this.f39248s;
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this, e6.getMessage());
                } catch (ProtocolException e7) {
                    throw new MessagingException(e7.getMessage(), e7);
                }
            }
            return i6;
        }
        j();
        try {
            try {
                try {
                    return C().f39504c;
                } catch (ProtocolException e8) {
                    throw new MessagingException(e8.getMessage(), e8);
                }
            } catch (BadCommandException unused) {
                com.sun.mail.imap.protocol.h hVar = null;
                try {
                    try {
                        hVar = D();
                        com.sun.mail.imap.protocol.n G2 = hVar.G(this.f39231a);
                        hVar.y();
                        return G2.f39481d;
                    } catch (ProtocolException e9) {
                        throw new MessagingException(e9.getMessage(), e9);
                    }
                } finally {
                    M(hVar);
                }
            }
        } catch (ConnectionException e10) {
            throw new StoreClosedException(this.store, e10.getMessage());
        }
    }

    @Override // javax.mail.Folder
    public synchronized Folder getParent() throws MessagingException {
        char separator = getSeparator();
        int lastIndexOf = this.f39231a.lastIndexOf(separator);
        if (lastIndexOf != -1) {
            return new e(this.f39231a.substring(0, lastIndexOf), separator, (com.sun.mail.imap.k) this.store);
        }
        return new com.sun.mail.imap.c((com.sun.mail.imap.k) this.store);
    }

    @Override // javax.mail.Folder
    public synchronized Flags getPermanentFlags() {
        return (Flags) this.f39236f.clone();
    }

    @Override // javax.mail.Folder
    public synchronized char getSeparator() throws MessagingException {
        try {
            if (this.f39234d == 65535) {
                com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) p(new m());
                if (mVarArr != null) {
                    this.f39234d = mVarArr[0].f39473b;
                } else {
                    this.f39234d = '/';
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f39234d;
    }

    @Override // javax.mail.Folder
    public synchronized int getType() throws MessagingException {
        try {
            if (!this.f39244n) {
                j();
            } else if (this.f39239i == null) {
                exists();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f39233c;
    }

    @Override // javax.mail.UIDFolder
    public synchronized long getUID(Message message) throws MessagingException {
        try {
            if (message.getFolder() != this) {
                throw new NoSuchElementException("Message does not belong to this folder");
            }
            l();
            com.sun.mail.imap.g gVar = (com.sun.mail.imap.g) message;
            long x5 = gVar.x();
            if (x5 != -1) {
                return x5;
            }
            synchronized (this.f39242l) {
                try {
                    com.sun.mail.imap.protocol.h A = A();
                    gVar.n();
                    v X = A.X(gVar.w());
                    if (X != null) {
                        x5 = X.f39510b;
                        gVar.J(x5);
                        if (this.f39243m == null) {
                            this.f39243m = new Hashtable();
                        }
                        this.f39243m.put(new Long(x5), gVar);
                    }
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this, e6.getMessage());
                } catch (ProtocolException e7) {
                    throw new MessagingException(e7.getMessage(), e7);
                }
            }
            return x5;
        } catch (Throwable th) {
            throw th;
        } finally {
        }
    }

    @Override // javax.mail.UIDFolder
    public synchronized long getUIDValidity() throws MessagingException {
        Throwable th;
        ProtocolException e6;
        com.sun.mail.imap.protocol.h hVar;
        BadCommandException e7;
        if (this.f39244n) {
            return this.f39250u;
        }
        com.sun.mail.imap.protocol.u uVar = null;
        try {
            try {
                hVar = D();
            } catch (BadCommandException e8) {
                e7 = e8;
            } catch (ConnectionException e9) {
                e = e9;
                hVar = null;
            } catch (ProtocolException e10) {
                e6 = e10;
            } catch (Throwable th2) {
                th = th2;
                M(null);
                throw th;
            }
            try {
                uVar = hVar.K0(this.f39231a, new String[]{"UIDVALIDITY"});
            } catch (BadCommandException e11) {
                e7 = e11;
                throw new MessagingException("Cannot obtain UIDValidity", e7);
            } catch (ConnectionException e12) {
                e = e12;
                R(e);
                M(hVar);
                return uVar.f39506e;
            } catch (ProtocolException e13) {
                e6 = e13;
                throw new MessagingException(e6.getMessage(), e6);
            }
            M(hVar);
            return uVar.f39506e;
        } catch (Throwable th3) {
            th = th3;
            M(null);
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getUnreadMessageCount() throws MessagingException {
        int length;
        if (!this.f39244n) {
            j();
            try {
                try {
                    return C().f39507f;
                } catch (BadCommandException unused) {
                    return -1;
                } catch (ConnectionException e6) {
                    throw new StoreClosedException(this.store, e6.getMessage());
                }
            } catch (ProtocolException e7) {
                throw new MessagingException(e7.getMessage(), e7);
            }
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.SEEN);
        try {
            try {
                synchronized (this.f39242l) {
                    length = A().D0(new FlagTerm(flags, false)).length;
                }
                return length;
            } catch (ProtocolException e8) {
                throw new MessagingException(e8.getMessage(), e8);
            }
        } catch (ConnectionException e9) {
            throw new FolderClosedException(this, e9.getMessage());
        }
    }

    public synchronized com.sun.mail.imap.b[] h(Message[] messageArr) throws MessagingException {
        com.sun.mail.imap.b[] bVarArr;
        try {
            j();
            int f6 = ((com.sun.mail.imap.k) this.store).f();
            bVarArr = new com.sun.mail.imap.b[messageArr.length];
            for (int i6 = 0; i6 < messageArr.length; i6++) {
                Message message = messageArr[i6];
                try {
                    com.sun.mail.imap.m mVar = new com.sun.mail.imap.m(message, message.getSize() > f6 ? 0 : f6);
                    Date receivedDate = message.getReceivedDate();
                    if (receivedDate == null) {
                        receivedDate = message.getSentDate();
                    }
                    bVarArr[i6] = (com.sun.mail.imap.b) p(new b(message.getFlags(), receivedDate, mVar));
                } catch (IOException e6) {
                    throw new MessagingException("IOException while appending messages", e6);
                } catch (MessageRemovedException unused) {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return bVarArr;
    }

    @Override // javax.mail.Folder
    public synchronized boolean hasNewMessages() throws MessagingException {
        boolean z5;
        try {
            if (!this.f39244n) {
                j();
                Boolean bool = (Boolean) q(new q());
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            }
            synchronized (this.f39242l) {
                try {
                    I(true);
                    z5 = this.f39248s > 0;
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this, e6.getMessage());
                } catch (ProtocolException e7) {
                    throw new MessagingException(e7.getMessage(), e7);
                }
            }
            return z5;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean isOpen() {
        synchronized (this.f39242l) {
            if (this.f39244n) {
                try {
                    I(false);
                } catch (ProtocolException unused) {
                }
            }
        }
        return this.f39244n;
    }

    @Override // javax.mail.Folder
    public synchronized boolean isSubscribed() {
        String str;
        com.sun.mail.imap.protocol.m[] mVarArr;
        try {
            if (!this.f39238h || this.f39234d == 0) {
                str = this.f39231a;
            } else {
                str = String.valueOf(this.f39231a) + this.f39234d;
            }
            try {
                mVarArr = (com.sun.mail.imap.protocol.m[]) t(new n(str));
            } catch (ProtocolException unused) {
                mVarArr = null;
            }
            if (mVarArr == null) {
                return false;
            }
            return mVarArr[v(mVarArr, str)].f39475d;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        return r(str, false);
    }

    @Override // javax.mail.Folder
    public Folder[] listSubscribed(String str) throws MessagingException {
        return r(str, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d5, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ef, code lost:
    
        throw r8;
     */
    @Override // javax.mail.Folder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void open(int r8) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.e.open(int):void");
    }

    public Object q(u uVar) throws MessagingException {
        try {
            return t(uVar);
        } catch (CommandFailedException unused) {
            return null;
        } catch (ConnectionException e6) {
            R(e6);
            return null;
        } catch (ProtocolException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean renameTo(Folder folder) throws MessagingException {
        i();
        j();
        if (folder.getStore() != this.store) {
            throw new MessagingException("Can't rename across Stores");
        }
        if (q(new s(folder)) == null) {
            return false;
        }
        this.f39237g = false;
        this.f39239i = null;
        notifyFolderRenamedListeners(folder);
        return true;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm) throws MessagingException {
        com.sun.mail.imap.g[] gVarArr;
        l();
        try {
            try {
                synchronized (this.f39242l) {
                    try {
                        int[] D0 = A().D0(searchTerm);
                        if (D0 != null) {
                            gVarArr = new com.sun.mail.imap.g[D0.length];
                            for (int i6 = 0; i6 < D0.length; i6++) {
                                gVarArr[i6] = z(D0[i6]);
                            }
                        } else {
                            gVarArr = null;
                        }
                    } finally {
                    }
                }
            } catch (CommandFailedException unused) {
                return super.search(searchTerm);
            } catch (ConnectionException e6) {
                throw new FolderClosedException(this, e6.getMessage());
            }
        } catch (ProtocolException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        } catch (SearchException unused2) {
            return super.search(searchTerm);
        }
        return gVarArr;
    }

    @Override // javax.mail.Folder
    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z5) throws MessagingException {
        l();
        k(flags);
        if (messageArr.length == 0) {
            return;
        }
        synchronized (this.f39242l) {
            try {
                try {
                    com.sun.mail.imap.protocol.h A = A();
                    com.sun.mail.imap.protocol.o[] a6 = com.sun.mail.imap.o.a(messageArr, null);
                    if (a6 == null) {
                        throw new MessageRemovedException("Messages have been removed");
                    }
                    A.O0(a6, flags, z5);
                } catch (ProtocolException e6) {
                    throw new MessagingException(e6.getMessage(), e6);
                }
            } catch (ConnectionException e7) {
                throw new FolderClosedException(this, e7.getMessage());
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized void setSubscribed(boolean z5) throws MessagingException {
        q(new o(z5));
    }

    protected Object t(u uVar) throws ProtocolException {
        com.sun.mail.imap.protocol.h hVar;
        Object a6;
        synchronized (this) {
            if (this.f39244n && !((com.sun.mail.imap.k) this.store).q()) {
                synchronized (this.f39242l) {
                    a6 = uVar.a(A());
                }
                return a6;
            }
            try {
                hVar = D();
                try {
                    Object a7 = uVar.a(hVar);
                    M(hVar);
                    return a7;
                } catch (Throwable th) {
                    th = th;
                    M(hVar);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                hVar = null;
            }
        }
    }

    public synchronized Message[] u(Message[] messageArr) throws MessagingException {
        Message[] messageArr2;
        try {
            l();
            Vector vector = new Vector();
            if (messageArr != null) {
                FetchProfile fetchProfile = new FetchProfile();
                fetchProfile.add(UIDFolder.FetchProfileItem.UID);
                fetch(messageArr, fetchProfile);
            }
            synchronized (this.f39242l) {
                int i6 = 0;
                this.f39252w = false;
                try {
                    try {
                        try {
                            try {
                                com.sun.mail.imap.protocol.h A = A();
                                if (messageArr != null) {
                                    A.Q0(com.sun.mail.imap.o.b(messageArr));
                                } else {
                                    A.H();
                                }
                                this.f39252w = true;
                                while (i6 < this.f39241k.size()) {
                                    com.sun.mail.imap.g gVar = (com.sun.mail.imap.g) this.f39241k.elementAt(i6);
                                    if (gVar.isExpunged()) {
                                        vector.addElement(gVar);
                                        this.f39241k.removeElementAt(i6);
                                        if (this.f39243m != null) {
                                            long x5 = gVar.x();
                                            if (x5 != -1) {
                                                this.f39243m.remove(new Long(x5));
                                            }
                                        }
                                    } else {
                                        gVar.setMessageNumber(gVar.w());
                                        i6++;
                                    }
                                }
                            } catch (ProtocolException e6) {
                                throw new MessagingException(e6.getMessage(), e6);
                            }
                        } catch (CommandFailedException e7) {
                            if (this.mode == 2) {
                                throw new MessagingException(e7.getMessage(), e7);
                            }
                            throw new IllegalStateException("Cannot expunge READ_ONLY folder: " + this.f39231a);
                        }
                    } catch (ConnectionException e8) {
                        throw new FolderClosedException(this, e8.getMessage());
                    }
                } catch (Throwable th) {
                    this.f39252w = true;
                    throw th;
                }
            }
            this.f39247r = this.f39241k.size();
            int size = vector.size();
            messageArr2 = new Message[size];
            vector.copyInto(messageArr2);
            if (size > 0) {
                notifyMessageRemovedListeners(true, messageArr2);
            }
        } finally {
        }
        return messageArr2;
    }

    public synchronized void w() throws MessagingException {
        o(false, true);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class t extends FetchProfile.Item {

        /* renamed from: a, reason: collision with root package name */
        public static final t f39295a = new t("HEADERS");

        /* renamed from: b, reason: collision with root package name */
        public static final t f39296b = new t("SIZE");

        protected t(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sun.mail.imap.protocol.u C() throws ProtocolException {
        com.sun.mail.imap.protocol.h D2;
        int m6 = ((com.sun.mail.imap.k) this.store).m();
        if (m6 > 0 && this.f39253x != null && System.currentTimeMillis() - this.f39254y < m6) {
            return this.f39253x;
        }
        com.sun.mail.imap.protocol.h hVar = null;
        try {
            D2 = D();
        } catch (Throwable th) {
            th = th;
        }
        try {
            com.sun.mail.imap.protocol.u K0 = D2.K0(this.f39231a, null);
            if (m6 > 0) {
                this.f39253x = K0;
                this.f39254y = System.currentTimeMillis();
            }
            M(D2);
            return K0;
        } catch (Throwable th2) {
            th = th2;
            hVar = D2;
            M(hVar);
            throw th;
        }
    }

    private boolean H() {
        return (this.f39233c & 2) != 0;
    }

    private void L(boolean z5) {
        com.sun.mail.imap.protocol.h hVar = this.f39240j;
        if (hVar != null) {
            hVar.m(this);
            if (z5) {
                ((com.sun.mail.imap.k) this.store).v(this, this.f39240j);
            } else {
                ((com.sun.mail.imap.k) this.store).v(this, null);
            }
        }
    }

    private void P(com.sun.mail.imap.a aVar, char c6) throws MessagingException {
        s("ACL not supported", new i(c6, aVar));
    }

    private void i() {
        if (this.f39244n) {
            throw new IllegalStateException("This operation is not allowed on an open folder");
        }
    }

    private void j() throws MessagingException {
        if (this.f39237g || exists()) {
            return;
        }
        throw new FolderNotFoundException(this, String.valueOf(this.f39231a) + " not found");
    }

    private void k(Flags flags) throws MessagingException {
        if (this.mode == 2) {
            return;
        }
        throw new IllegalStateException("Cannot change flags on READ_ONLY folder: " + this.f39231a);
    }

    private void l() throws FolderClosedException {
        if (this.f39244n) {
            return;
        }
        if (!this.f39245o) {
            throw new FolderClosedException(this, "Lost folder connection to server");
        }
        throw new IllegalStateException("This operation is not allowed on a closed folder");
    }

    private void o(boolean z5, boolean z6) throws MessagingException {
        synchronized (this.f39242l) {
            try {
                boolean z7 = this.f39244n;
                if (!z7 && this.f39245o) {
                    throw new IllegalStateException("This operation is not allowed on a closed folder");
                }
                this.f39245o = true;
                if (z7) {
                    try {
                        S();
                        if (z6) {
                            if (this.f39255z) {
                                this.A.getClass();
                            }
                            com.sun.mail.imap.protocol.h hVar = this.f39240j;
                            if (hVar != null) {
                                hVar.c();
                            }
                        } else if (((com.sun.mail.imap.k) this.store).s()) {
                            if (this.f39255z) {
                                this.A.getClass();
                            }
                            if (z5) {
                                this.f39240j.y();
                            }
                            com.sun.mail.imap.protocol.h hVar2 = this.f39240j;
                            if (hVar2 != null) {
                                hVar2.n0();
                            }
                        } else {
                            if (!z5 && this.mode == 2) {
                                try {
                                    this.f39240j.G(this.f39231a);
                                } catch (ProtocolException unused) {
                                    com.sun.mail.imap.protocol.h hVar3 = this.f39240j;
                                    if (hVar3 != null) {
                                        hVar3.c();
                                    }
                                }
                            }
                            com.sun.mail.imap.protocol.h hVar4 = this.f39240j;
                            if (hVar4 != null) {
                                hVar4.y();
                            }
                        }
                        if (this.f39244n) {
                            n(true);
                        }
                    } catch (ProtocolException e6) {
                        throw new MessagingException(e6.getMessage(), e6);
                    }
                }
            } catch (Throwable th) {
                if (this.f39244n) {
                    n(true);
                }
                throw th;
            } finally {
            }
        }
    }

    public Quota[] B() throws MessagingException {
        return (Quota[]) s("QUOTA not supported", new c());
    }

    public com.sun.mail.imap.n[] J(String str) throws MessagingException {
        return (com.sun.mail.imap.n[]) s("ACL not supported", new g(str));
    }

    public com.sun.mail.imap.n K() throws MessagingException {
        return (com.sun.mail.imap.n) s("ACL not supported", new h());
    }

    public void N(String str) throws MessagingException {
        s("ACL not supported", new f(str));
    }

    public void O(com.sun.mail.imap.a aVar) throws MessagingException {
        P(aVar, '-');
    }

    public void Q(Quota quota) throws MessagingException {
        s("QUOTA not supported", new d(quota));
    }

    void S() throws ProtocolException {
        while (true) {
            int i6 = this.f39246p;
            if (i6 == 0) {
                return;
            }
            if (i6 == 1) {
                this.f39240j.f0();
                this.f39246p = 2;
            }
            try {
                this.f39242l.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void g(com.sun.mail.imap.a aVar) throws MessagingException {
        P(aVar, '+');
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        if (this.f39239i != null && !H()) {
            throw new MessagingException("Cannot contain subfolders");
        }
        char separator = getSeparator();
        return new e(String.valueOf(this.f39231a) + separator + str, separator, (com.sun.mail.imap.k) this.store);
    }

    public com.sun.mail.imap.a[] x() throws MessagingException {
        return (com.sun.mail.imap.a[]) s("ACL not supported", new C0805e());
    }

    public String[] y() throws MessagingException {
        if (this.f39239i == null) {
            exists();
        }
        return (String[]) this.f39239i.clone();
    }

    com.sun.mail.imap.g z(int i6) {
        for (int i7 = i6 - 1; i7 < this.f39247r; i7++) {
            com.sun.mail.imap.g gVar = (com.sun.mail.imap.g) this.f39241k.elementAt(i7);
            if (gVar.w() == i6) {
                return gVar;
            }
        }
        return null;
    }

    private com.sun.mail.imap.protocol.h A() throws ProtocolException {
        S();
        return this.f39240j;
    }

    private void I(boolean z5) throws ProtocolException {
        if (System.currentTimeMillis() - this.f39240j.g() > 1000) {
            S();
            this.f39240j.r0();
        }
        if (z5 && ((com.sun.mail.imap.k) this.store).q()) {
            com.sun.mail.imap.protocol.h hVar = null;
            try {
                hVar = ((com.sun.mail.imap.k) this.store).n();
                if (System.currentTimeMillis() - hVar.g() > 1000) {
                    hVar.r0();
                }
            } finally {
                ((com.sun.mail.imap.k) this.store).w(hVar);
            }
        }
    }

    private void n(boolean z5) {
        L(z5);
        this.f39240j = null;
        this.f39241k = null;
        this.f39243m = null;
        this.f39237g = false;
        this.f39239i = null;
        this.f39244n = false;
        this.f39246p = 0;
        notifyConnectionListeners(3);
    }

    @Override // com.sun.mail.iap.h
    public void a(com.sun.mail.iap.g gVar) {
        com.sun.mail.imap.g z5;
        if (gVar.h() || gVar.g() || gVar.d() || gVar.e()) {
            ((com.sun.mail.imap.k) this.store).o(gVar);
        }
        if (gVar.e()) {
            if (this.f39244n) {
                n(false);
                return;
            }
            return;
        }
        if (!gVar.h() && gVar.k()) {
            if (!(gVar instanceof com.sun.mail.imap.protocol.i)) {
                PrintStream printStream = this.A;
                gVar.toString();
                printStream.getClass();
                this.A.getClass();
                return;
            }
            com.sun.mail.imap.protocol.i iVar = (com.sun.mail.imap.protocol.i) gVar;
            if (iVar.F("EXISTS")) {
                int E2 = iVar.E();
                int i6 = this.f39249t;
                if (E2 > i6) {
                    int i7 = E2 - i6;
                    Message[] messageArr = new Message[i7];
                    for (int i8 = 0; i8 < i7; i8++) {
                        int i9 = this.f39247r + 1;
                        this.f39247r = i9;
                        int i10 = this.f39249t + 1;
                        this.f39249t = i10;
                        com.sun.mail.imap.g gVar2 = new com.sun.mail.imap.g(this, i9, i10);
                        messageArr[i8] = gVar2;
                        this.f39241k.addElement(gVar2);
                    }
                    notifyMessageAddedListeners(messageArr);
                    return;
                }
                return;
            }
            if (iVar.F("EXPUNGE")) {
                com.sun.mail.imap.g z6 = z(iVar.E());
                z6.setExpunged(true);
                for (int messageNumber = z6.getMessageNumber(); messageNumber < this.f39247r; messageNumber++) {
                    com.sun.mail.imap.g gVar3 = (com.sun.mail.imap.g) this.f39241k.elementAt(messageNumber);
                    if (!gVar3.isExpunged()) {
                        gVar3.I(gVar3.w() - 1);
                    }
                }
                this.f39249t--;
                if (this.f39252w) {
                    notifyMessageRemovedListeners(false, new Message[]{z6});
                    return;
                }
                return;
            }
            if (iVar.F("FETCH")) {
                com.sun.mail.imap.protocol.f fVar = (com.sun.mail.imap.protocol.f) iVar;
                Flags flags = (Flags) fVar.J(Flags.class);
                if (flags != null && (z5 = z(fVar.E())) != null) {
                    z5.e(flags);
                    notifyMessageChangedListeners(1, z5);
                    return;
                }
                return;
            }
            if (iVar.F("RECENT")) {
                this.f39248s = iVar.E();
            }
        }
    }

    public Object p(u uVar) throws MessagingException {
        try {
            return t(uVar);
        } catch (ConnectionException e6) {
            R(e6);
            return null;
        } catch (ProtocolException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        }
    }

    public Object s(String str, u uVar) throws MessagingException {
        try {
            return t(uVar);
        } catch (BadCommandException e6) {
            throw new MessagingException(str, e6);
        } catch (ConnectionException e7) {
            R(e7);
            return null;
        } catch (ProtocolException e8) {
            throw new MessagingException(e8.getMessage(), e8);
        }
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm, Message[] messageArr) throws MessagingException {
        com.sun.mail.imap.g[] gVarArr;
        l();
        if (messageArr.length == 0) {
            return messageArr;
        }
        try {
            try {
                synchronized (this.f39242l) {
                    try {
                        com.sun.mail.imap.protocol.h A = A();
                        gVarArr = null;
                        com.sun.mail.imap.protocol.o[] a6 = com.sun.mail.imap.o.a(messageArr, null);
                        if (a6 != null) {
                            int[] E0 = A.E0(a6, searchTerm);
                            if (E0 != null) {
                                gVarArr = new com.sun.mail.imap.g[E0.length];
                                for (int i6 = 0; i6 < E0.length; i6++) {
                                    gVarArr[i6] = z(E0[i6]);
                                }
                            }
                        } else {
                            throw new MessageRemovedException("Messages have been removed");
                        }
                    } finally {
                    }
                }
                return gVarArr;
            } catch (CommandFailedException unused) {
                return super.search(searchTerm, messageArr);
            } catch (ProtocolException e6) {
                throw new MessagingException(e6.getMessage(), e6);
            }
        } catch (ConnectionException e7) {
            throw new FolderClosedException(this, e7.getMessage());
        } catch (SearchException unused2) {
            return super.search(searchTerm, messageArr);
        }
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long[] jArr) throws MessagingException {
        long[] jArr2;
        Message[] messageArr;
        l();
        try {
            synchronized (this.f39242l) {
                try {
                    if (this.f39243m != null) {
                        Vector vector = new Vector();
                        for (long j6 : jArr) {
                            Hashtable hashtable = this.f39243m;
                            Long l6 = new Long(j6);
                            if (!hashtable.containsKey(l6)) {
                                vector.addElement(l6);
                            }
                        }
                        int size = vector.size();
                        jArr2 = new long[size];
                        for (int i6 = 0; i6 < size; i6++) {
                            jArr2[i6] = ((Long) vector.elementAt(i6)).longValue();
                        }
                    } else {
                        this.f39243m = new Hashtable();
                        jArr2 = jArr;
                    }
                    if (jArr2.length > 0) {
                        v[] W = A().W(jArr2);
                        for (int i7 = 0; i7 < W.length; i7++) {
                            com.sun.mail.imap.g z5 = z(W[i7].f39509a);
                            z5.J(W[i7].f39510b);
                            this.f39243m.put(new Long(W[i7].f39510b), z5);
                        }
                    }
                    messageArr = new Message[jArr.length];
                    for (int i8 = 0; i8 < jArr.length; i8++) {
                        messageArr[i8] = (Message) this.f39243m.get(new Long(jArr[i8]));
                    }
                } finally {
                }
            }
        } catch (ConnectionException e6) {
            throw new FolderClosedException(this, e6.getMessage());
        } catch (ProtocolException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        }
        return messageArr;
    }

    protected e(String str, char c6, com.sun.mail.imap.k kVar, boolean z5) {
        this(str, c6, kVar);
        this.f39238h = z5;
    }

    protected e(com.sun.mail.imap.protocol.m mVar, com.sun.mail.imap.k kVar) {
        this(mVar.f39472a, mVar.f39473b, kVar);
        if (mVar.f39474c) {
            this.f39233c |= 2;
        }
        if (mVar.f39475d) {
            this.f39233c |= 1;
        }
        this.f39237g = true;
        this.f39239i = mVar.f39477f;
    }
}
