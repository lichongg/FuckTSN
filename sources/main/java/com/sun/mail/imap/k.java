package com.sun.mail.imap;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.p;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Quota;
import javax.mail.QuotaAwareStore;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.StoreClosedException;
import javax.mail.URLName;
import kotlin.jvm.internal.q;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class k extends Store implements QuotaAwareStore, com.sun.mail.iap.h {
    public static final int A = 1000;
    static final /* synthetic */ boolean B = false;

    /* renamed from: a, reason: collision with root package name */
    private String f39331a;

    /* renamed from: b, reason: collision with root package name */
    private int f39332b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f39333c;

    /* renamed from: d, reason: collision with root package name */
    private int f39334d;

    /* renamed from: e, reason: collision with root package name */
    private int f39335e;

    /* renamed from: f, reason: collision with root package name */
    private int f39336f;

    /* renamed from: g, reason: collision with root package name */
    private int f39337g;

    /* renamed from: h, reason: collision with root package name */
    private int f39338h;

    /* renamed from: i, reason: collision with root package name */
    private String f39339i;

    /* renamed from: j, reason: collision with root package name */
    private String f39340j;

    /* renamed from: k, reason: collision with root package name */
    private String f39341k;

    /* renamed from: l, reason: collision with root package name */
    private String f39342l;

    /* renamed from: m, reason: collision with root package name */
    private String f39343m;

    /* renamed from: n, reason: collision with root package name */
    private String f39344n;

    /* renamed from: o, reason: collision with root package name */
    private p f39345o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f39346p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f39347r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f39348s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f39349t;

    /* renamed from: u, reason: collision with root package name */
    private String[] f39350u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f39351v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f39352w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f39353x;

    /* renamed from: y, reason: collision with root package name */
    private PrintStream f39354y;

    /* renamed from: z, reason: collision with root package name */
    private a f39355z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: m, reason: collision with root package name */
        private static final int f39356m = 0;

        /* renamed from: n, reason: collision with root package name */
        private static final int f39357n = 1;

        /* renamed from: o, reason: collision with root package name */
        private static final int f39358o = 2;

        /* renamed from: b, reason: collision with root package name */
        private Vector f39360b;

        /* renamed from: g, reason: collision with root package name */
        private long f39365g;

        /* renamed from: l, reason: collision with root package name */
        private com.sun.mail.imap.protocol.h f39370l;

        /* renamed from: a, reason: collision with root package name */
        private Vector f39359a = new Vector();

        /* renamed from: c, reason: collision with root package name */
        private boolean f39361c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f39362d = false;

        /* renamed from: e, reason: collision with root package name */
        private long f39363e = 45000;

        /* renamed from: f, reason: collision with root package name */
        private long f39364f = 1800000;

        /* renamed from: h, reason: collision with root package name */
        private int f39366h = 1;

        /* renamed from: i, reason: collision with root package name */
        private long f39367i = 60000;

        /* renamed from: j, reason: collision with root package name */
        private boolean f39368j = false;

        /* renamed from: k, reason: collision with root package name */
        private int f39369k = 0;

        a() {
        }
    }

    public k(Session session, URLName uRLName) {
        this(session, uRLName, "imap", 143, false);
    }

    private void c() {
        d(false);
    }

    private synchronized p j() throws MessagingException {
        checkConnected();
        if (this.f39345o == null) {
            com.sun.mail.imap.protocol.h hVar = null;
            try {
                try {
                    try {
                        hVar = n();
                        this.f39345o = hVar.q0();
                        w(hVar);
                    } catch (BadCommandException unused) {
                    } catch (ProtocolException e6) {
                        throw new MessagingException(e6.getMessage(), e6);
                    }
                } catch (ConnectionException e7) {
                    throw new StoreClosedException(this, e7.getMessage());
                }
            } finally {
                w(hVar);
                if (hVar == null) {
                    c();
                }
            }
        }
        return this.f39345o;
    }

    private Folder[] u(p.a[] aVarArr, String str) {
        int length = aVarArr.length;
        Folder[] folderArr = new Folder[length];
        for (int i6 = 0; i6 < length; i6++) {
            String str2 = aVarArr[i6].f39491a;
            if (str == null) {
                int length2 = str2.length();
                if (length2 > 0) {
                    int i7 = length2 - 1;
                    if (str2.charAt(i7) == aVarArr[i6].f39492b) {
                        str2 = str2.substring(0, i7);
                    }
                }
            } else {
                str2 = String.valueOf(str2) + str;
            }
            folderArr[i6] = new e(str2, aVarArr[i6].f39492b, this, str == null);
        }
        return folderArr;
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        boolean isEmpty;
        if (super.isConnected()) {
            try {
                try {
                    synchronized (this.f39355z) {
                        isEmpty = this.f39355z.f39359a.isEmpty();
                    }
                    if (isEmpty) {
                        if (this.f39355z.f39368j) {
                            this.f39354y.getClass();
                        }
                        c();
                        w(null);
                        return;
                    }
                    com.sun.mail.imap.protocol.h n6 = n();
                    synchronized (this.f39355z) {
                        this.f39355z.f39359a.removeElement(n6);
                    }
                    n6.n0();
                    w(n6);
                } catch (ProtocolException e6) {
                    c();
                    throw new MessagingException(e6.getMessage(), e6);
                }
            } catch (Throwable th) {
                w(null);
                throw th;
            }
        }
    }

    @Override // javax.mail.Store
    public synchronized Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new c(this);
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new e(str, q.f44042c, this);
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized Quota[] getQuota(String str) throws MessagingException {
        Quota[] d02;
        checkConnected();
        com.sun.mail.imap.protocol.h hVar = null;
        try {
            try {
                try {
                    hVar = n();
                    d02 = hVar.d0(str);
                    w(hVar);
                } catch (BadCommandException e6) {
                    throw new MessagingException("QUOTA not supported", e6);
                } catch (ConnectionException e7) {
                    throw new StoreClosedException(this, e7.getMessage());
                }
            } catch (ProtocolException e8) {
                throw new MessagingException(e8.getMessage(), e8);
            }
        } catch (Throwable th) {
            w(hVar);
            if (hVar == null) {
                c();
            }
            throw th;
        }
        return d02;
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (!this.f39353x) {
            super.setConnected(false);
            return false;
        }
        com.sun.mail.imap.protocol.h hVar = null;
        try {
            try {
                hVar = n();
                hVar.r0();
            } catch (ProtocolException unused) {
                if (hVar == null) {
                    c();
                }
            }
            return super.isConnected();
        } finally {
            w(hVar);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:6|7|(8:16|(1:18)|19|20|(2:31|32)|22|23|(3:25|(1:27)|28))|39|(1:41)|42|43|(5:63|64|65|66|(1:68))|45|46|47|(3:49|23|(0))(3:50|51|52)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00db, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00dd, code lost:
    
        if (r1 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e4, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00df, code lost:
    
        r1.c();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ed A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:7:0x0008, B:9:0x0014, B:11:0x0021, B:13:0x0029, B:16:0x0036, B:18:0x003a, B:19:0x0048, B:32:0x0070, B:22:0x007c, B:23:0x00e8, B:25:0x00ed, B:27:0x00f5, B:28:0x00ff, B:29:0x0108, B:35:0x007a, B:39:0x0081, B:41:0x0085, B:43:0x008a, B:64:0x008e, B:66:0x0099, B:68:0x00a8, B:45:0x00b4, B:47:0x00d3, B:51:0x010b, B:52:0x0112, B:60:0x00df), top: B:6:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.sun.mail.imap.protocol.h k(com.sun.mail.imap.e r12) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.k.k(com.sun.mail.imap.e):com.sun.mail.imap.protocol.h");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005d A[Catch: all -> 0x0025, TRY_ENTER, TryCatch #2 {, blocks: (B:6:0x0008, B:8:0x0017, B:10:0x001f, B:12:0x0028, B:14:0x0047, B:16:0x005d, B:17:0x0095, B:27:0x009d, B:19:0x00a4, B:21:0x00b2, B:23:0x00b8, B:24:0x00bb, B:32:0x006a, B:33:0x0071, B:41:0x0055, B:46:0x0072, B:48:0x007a, B:49:0x0088), top: B:5:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.sun.mail.imap.protocol.h n() throws com.sun.mail.iap.ProtocolException {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            if (r1 == 0) goto L5
            return r1
        L5:
            com.sun.mail.imap.k$a r2 = r11.f39355z
            monitor-enter(r2)
            r11.A()     // Catch: java.lang.Throwable -> L25
            com.sun.mail.imap.k$a r3 = r11.f39355z     // Catch: java.lang.Throwable -> L25
            java.util.Vector r3 = com.sun.mail.imap.k.a.c(r3)     // Catch: java.lang.Throwable -> L25
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L72
            com.sun.mail.imap.k$a r3 = r11.f39355z     // Catch: java.lang.Throwable -> L25
            boolean r3 = com.sun.mail.imap.k.a.p(r3)     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L28
            java.io.PrintStream r3 = r11.f39354y     // Catch: java.lang.Throwable -> L25
            r3.getClass()     // Catch: java.lang.Throwable -> L25
            goto L28
        L25:
            r0 = move-exception
            goto Lbe
        L28:
            com.sun.mail.imap.protocol.h r3 = new com.sun.mail.imap.protocol.h     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            java.lang.String r4 = r11.f39331a     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            java.lang.String r5 = r11.f39339i     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            int r6 = r11.f39334d     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            javax.mail.Session r7 = r11.session     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            boolean r7 = r7.getDebug()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            javax.mail.Session r8 = r11.session     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            java.io.PrintStream r8 = r8.getDebugOut()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            javax.mail.Session r9 = r11.session     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            java.util.Properties r9 = r9.getProperties()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            boolean r10 = r11.f39333c     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L52
            java.lang.String r1 = r11.f39340j     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L4f
            java.lang.String r4 = r11.f39341k     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L4f
            r11.t(r3, r1, r4)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L4f
            goto L5b
        L4f:
            r1 = r3
            goto L53
        L52:
        L53:
            if (r1 == 0) goto L5a
            r1.n0()     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L59
            goto L5a
        L59:
        L5a:
            r3 = r0
        L5b:
            if (r3 == 0) goto L6a
            r3.a(r11)     // Catch: java.lang.Throwable -> L25
            com.sun.mail.imap.k$a r1 = r11.f39355z     // Catch: java.lang.Throwable -> L25
            java.util.Vector r1 = com.sun.mail.imap.k.a.c(r1)     // Catch: java.lang.Throwable -> L25
            r1.addElement(r3)     // Catch: java.lang.Throwable -> L25
            goto L95
        L6a:
            com.sun.mail.iap.ConnectionException r0 = new com.sun.mail.iap.ConnectionException     // Catch: java.lang.Throwable -> L25
            java.lang.String r1 = "failed to create new store connection"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L25
            throw r0     // Catch: java.lang.Throwable -> L25
        L72:
            com.sun.mail.imap.k$a r1 = r11.f39355z     // Catch: java.lang.Throwable -> L25
            boolean r1 = com.sun.mail.imap.k.a.p(r1)     // Catch: java.lang.Throwable -> L25
            if (r1 == 0) goto L88
            java.io.PrintStream r1 = r11.f39354y     // Catch: java.lang.Throwable -> L25
            com.sun.mail.imap.k$a r3 = r11.f39355z     // Catch: java.lang.Throwable -> L25
            java.util.Vector r3 = com.sun.mail.imap.k.a.c(r3)     // Catch: java.lang.Throwable -> L25
            r3.size()     // Catch: java.lang.Throwable -> L25
            r1.getClass()     // Catch: java.lang.Throwable -> L25
        L88:
            com.sun.mail.imap.k$a r1 = r11.f39355z     // Catch: java.lang.Throwable -> L25
            java.util.Vector r1 = com.sun.mail.imap.k.a.c(r1)     // Catch: java.lang.Throwable -> L25
            java.lang.Object r1 = r1.firstElement()     // Catch: java.lang.Throwable -> L25
            r3 = r1
            com.sun.mail.imap.protocol.h r3 = (com.sun.mail.imap.protocol.h) r3     // Catch: java.lang.Throwable -> L25
        L95:
            com.sun.mail.imap.k$a r1 = r11.f39355z     // Catch: java.lang.Throwable -> L25
            boolean r1 = com.sun.mail.imap.k.a.e(r1)     // Catch: java.lang.Throwable -> L25
            if (r1 == 0) goto La4
            com.sun.mail.imap.k$a r1 = r11.f39355z     // Catch: java.lang.Throwable -> L25 java.lang.InterruptedException -> La2
            r1.wait()     // Catch: java.lang.Throwable -> L25 java.lang.InterruptedException -> La2
        La2:
            r1 = r0
            goto Lb8
        La4:
            com.sun.mail.imap.k$a r1 = r11.f39355z     // Catch: java.lang.Throwable -> L25
            r4 = 1
            com.sun.mail.imap.k.a.h(r1, r4)     // Catch: java.lang.Throwable -> L25
            com.sun.mail.imap.k$a r1 = r11.f39355z     // Catch: java.lang.Throwable -> L25
            boolean r1 = com.sun.mail.imap.k.a.p(r1)     // Catch: java.lang.Throwable -> L25
            if (r1 == 0) goto Lb7
            java.io.PrintStream r1 = r11.f39354y     // Catch: java.lang.Throwable -> L25
            r1.getClass()     // Catch: java.lang.Throwable -> L25
        Lb7:
            r1 = r3
        Lb8:
            r11.z()     // Catch: java.lang.Throwable -> L25
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L25
            goto L2
        Lbe:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L25
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.k.n():com.sun.mail.imap.protocol.h");
    }

    public synchronized boolean p(String str) throws MessagingException {
        com.sun.mail.imap.protocol.h hVar;
        hVar = null;
        try {
            try {
                hVar = n();
            } catch (ProtocolException e6) {
                if (hVar == null) {
                    c();
                }
                throw new MessagingException(e6.getMessage(), e6);
            }
        } finally {
            w(hVar);
        }
        return hVar.e0(str);
    }

    @Override // javax.mail.Service
    protected synchronized boolean protocolConnect(String str, int i6, String str2, String str3) throws MessagingException {
        CommandFailedException commandFailedException;
        boolean isEmpty;
        try {
            if (str == null || str3 == null || str2 == null) {
                if (this.debug) {
                    this.f39354y.getClass();
                }
                return false;
            }
            if (i6 != -1) {
                this.f39334d = i6;
            } else {
                String property = this.session.getProperty("mail." + this.f39331a + ".port");
                if (property != null) {
                    this.f39334d = Integer.parseInt(property);
                }
            }
            if (this.f39334d == -1) {
                this.f39334d = this.f39332b;
            }
            com.sun.mail.imap.protocol.h hVar = null;
            try {
                synchronized (this.f39355z) {
                    isEmpty = this.f39355z.f39359a.isEmpty();
                }
                if (isEmpty) {
                    com.sun.mail.imap.protocol.h hVar2 = new com.sun.mail.imap.protocol.h(this.f39331a, str, this.f39334d, this.session.getDebug(), this.session.getDebugOut(), this.session.getProperties(), this.f39333c);
                    try {
                        if (this.debug) {
                            this.f39354y.getClass();
                        }
                        t(hVar2, str2, str3);
                        hVar2.a(this);
                        this.f39339i = str;
                        this.f39340j = str2;
                        this.f39341k = str3;
                        synchronized (this.f39355z) {
                            this.f39355z.f39359a.addElement(hVar2);
                        }
                    } catch (CommandFailedException e6) {
                        commandFailedException = e6;
                        hVar = hVar2;
                        if (hVar != null) {
                            hVar.c();
                        }
                        throw new AuthenticationFailedException(commandFailedException.getResponse().b());
                    }
                }
                this.f39353x = true;
                return true;
            } catch (CommandFailedException e7) {
                commandFailedException = e7;
            }
        } catch (ProtocolException e8) {
            throw new MessagingException(e8.getMessage(), e8);
        } catch (IOException e9) {
            throw new MessagingException(e9.getMessage(), e9);
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
    
        if (r5.f39352w == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        if (r1.k() == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003f, code lost:
    
        notifyStoreListeners(1000, r1.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.k.r():void");
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized void setQuota(Quota quota) throws MessagingException {
        checkConnected();
        com.sun.mail.imap.protocol.h hVar = null;
        try {
            try {
                try {
                    hVar = n();
                    hVar.I0(quota);
                    w(hVar);
                } catch (BadCommandException e6) {
                    throw new MessagingException("QUOTA not supported", e6);
                } catch (ConnectionException e7) {
                    throw new StoreClosedException(this, e7.getMessage());
                }
            } catch (ProtocolException e8) {
                throw new MessagingException(e8.getMessage(), e8);
            }
        } catch (Throwable th) {
            w(hVar);
            if (hVar == null) {
                c();
            }
            throw th;
        }
    }

    public synchronized void x(String str) {
        this.f39341k = str;
    }

    public synchronized void y(String str) {
        this.f39340j = str;
    }

    protected k(Session session, URLName uRLName, String str, int i6, boolean z5) {
        super(session, uRLName);
        this.f39331a = "imap";
        this.f39332b = 143;
        this.f39333c = false;
        this.f39334d = -1;
        this.f39335e = 16384;
        this.f39336f = 1000;
        this.f39337g = -1;
        this.f39338h = 10;
        this.f39346p = false;
        this.f39347r = false;
        this.f39348s = false;
        this.f39349t = false;
        this.f39351v = false;
        this.f39352w = false;
        this.f39353x = false;
        this.f39355z = new a();
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.f39331a = str;
        this.f39332b = i6;
        this.f39333c = z5;
        this.f39355z.f39365g = System.currentTimeMillis();
        this.debug = session.getDebug();
        PrintStream debugOut = session.getDebugOut();
        this.f39354y = debugOut;
        if (debugOut == null) {
            this.f39354y = System.out;
        }
        String property = session.getProperty("mail." + str + ".connectionpool.debug");
        if (property != null && property.equalsIgnoreCase("true")) {
            this.f39355z.f39368j = true;
        }
        String property2 = session.getProperty("mail." + str + ".partialfetch");
        if (property2 == null || !property2.equalsIgnoreCase("false")) {
            String property3 = session.getProperty("mail." + str + ".fetchsize");
            if (property3 != null) {
                this.f39335e = Integer.parseInt(property3);
            }
            if (this.debug) {
                this.f39354y.getClass();
            }
        } else {
            this.f39335e = -1;
            if (this.debug) {
                this.f39354y.getClass();
            }
        }
        String property4 = session.getProperty("mail." + str + ".statuscachetimeout");
        if (property4 != null) {
            this.f39336f = Integer.parseInt(property4);
            if (this.debug) {
                this.f39354y.getClass();
            }
        }
        String property5 = session.getProperty("mail." + str + ".appendbuffersize");
        if (property5 != null) {
            this.f39337g = Integer.parseInt(property5);
            if (this.debug) {
                this.f39354y.getClass();
            }
        }
        String property6 = session.getProperty("mail." + str + ".minidletime");
        if (property6 != null) {
            this.f39338h = Integer.parseInt(property6);
            if (this.debug) {
                this.f39354y.getClass();
            }
        }
        String property7 = session.getProperty("mail." + str + ".connectionpoolsize");
        if (property7 != null) {
            try {
                int parseInt = Integer.parseInt(property7);
                if (parseInt > 0) {
                    this.f39355z.f39366h = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            if (this.f39355z.f39368j) {
                PrintStream printStream = this.f39354y;
                int unused2 = this.f39355z.f39366h;
                printStream.getClass();
            }
        }
        String property8 = session.getProperty("mail." + str + ".connectionpooltimeout");
        if (property8 != null) {
            try {
                int parseInt2 = Integer.parseInt(property8);
                if (parseInt2 > 0) {
                    this.f39355z.f39363e = parseInt2;
                }
            } catch (NumberFormatException unused3) {
            }
            if (this.f39355z.f39368j) {
                PrintStream printStream2 = this.f39354y;
                long unused4 = this.f39355z.f39363e;
                printStream2.getClass();
            }
        }
        String property9 = session.getProperty("mail." + str + ".servertimeout");
        if (property9 != null) {
            try {
                int parseInt3 = Integer.parseInt(property9);
                if (parseInt3 > 0) {
                    this.f39355z.f39364f = parseInt3;
                }
            } catch (NumberFormatException unused5) {
            }
            if (this.f39355z.f39368j) {
                PrintStream printStream3 = this.f39354y;
                long unused6 = this.f39355z.f39364f;
                printStream3.getClass();
            }
        }
        String property10 = session.getProperty("mail." + str + ".separatestoreconnection");
        if (property10 != null && property10.equalsIgnoreCase("true")) {
            if (this.f39355z.f39368j) {
                this.f39354y.getClass();
            }
            this.f39355z.f39361c = true;
        }
        String property11 = session.getProperty("mail." + str + ".proxyauth.user");
        if (property11 != null) {
            this.f39342l = property11;
            if (this.debug) {
                this.f39354y.getClass();
            }
        }
        String property12 = session.getProperty("mail." + str + ".auth.login.disable");
        if (property12 != null && property12.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f39354y.getClass();
            }
            this.f39346p = true;
        }
        String property13 = session.getProperty("mail." + str + ".auth.plain.disable");
        if (property13 != null && property13.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f39354y.getClass();
            }
            this.f39347r = true;
        }
        String property14 = session.getProperty("mail." + str + ".starttls.enable");
        if (property14 != null && property14.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f39354y.getClass();
            }
            this.f39348s = true;
        }
        String property15 = session.getProperty("mail." + str + ".sasl.enable");
        if (property15 != null && property15.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f39354y.getClass();
            }
            this.f39349t = true;
        }
        if (this.f39349t) {
            String property16 = session.getProperty("mail." + str + ".sasl.mechanisms");
            if (property16 != null && property16.length() > 0) {
                if (this.debug) {
                    this.f39354y.getClass();
                }
                Vector vector = new Vector(5);
                StringTokenizer stringTokenizer = new StringTokenizer(property16, " ,");
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.length() > 0) {
                        vector.addElement(nextToken);
                    }
                }
                String[] strArr = new String[vector.size()];
                this.f39350u = strArr;
                vector.copyInto(strArr);
            }
        }
        String property17 = session.getProperty("mail." + str + ".sasl.authorizationid");
        if (property17 != null) {
            this.f39343m = property17;
            if (this.debug) {
                this.f39354y.getClass();
            }
        }
        String property18 = session.getProperty("mail." + str + ".sasl.realm");
        if (property18 != null) {
            this.f39344n = property18;
            if (this.debug) {
                this.f39354y.getClass();
            }
        }
        String property19 = session.getProperty("mail." + str + ".forcepasswordrefresh");
        if (property19 != null && property19.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f39354y.getClass();
            }
            this.f39351v = true;
        }
        String property20 = session.getProperty("mail." + str + ".enableimapevents");
        if (property20 == null || !property20.equalsIgnoreCase("true")) {
            return;
        }
        if (this.debug) {
            this.f39354y.getClass();
        }
        this.f39352w = true;
    }

    private void A() throws ProtocolException {
        while (this.f39355z.f39369k != 0) {
            if (this.f39355z.f39369k == 1) {
                this.f39355z.f39370l.f0();
                this.f39355z.f39369k = 2;
            }
            try {
                this.f39355z.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private void checkConnected() {
        if (this.f39353x) {
            return;
        }
        super.setConnected(false);
        throw new IllegalStateException("Not connected");
    }

    private void d(boolean z5) {
        boolean z6;
        if (this.debug) {
            this.f39354y.getClass();
        }
        Vector vector = null;
        while (true) {
            synchronized (this.f39355z) {
                try {
                    if (this.f39355z.f39360b != null) {
                        vector = this.f39355z.f39360b;
                        this.f39355z.f39360b = null;
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z6) {
                break;
            }
            int size = vector.size();
            for (int i6 = 0; i6 < size; i6++) {
                e eVar = (e) vector.elementAt(i6);
                if (z5) {
                    try {
                        if (this.debug) {
                            this.f39354y.getClass();
                        }
                        eVar.w();
                    } catch (IllegalStateException | MessagingException unused) {
                    }
                } else {
                    if (this.debug) {
                        this.f39354y.getClass();
                    }
                    eVar.close(false);
                }
            }
        }
        synchronized (this.f39355z) {
            e(z5);
        }
        this.f39353x = false;
        notifyConnectionListeners(3);
        if (this.debug) {
            this.f39354y.getClass();
        }
    }

    private void e(boolean z5) {
        synchronized (this.f39355z) {
            for (int size = this.f39355z.f39359a.size() - 1; size >= 0; size--) {
                try {
                    com.sun.mail.imap.protocol.h hVar = (com.sun.mail.imap.protocol.h) this.f39355z.f39359a.elementAt(size);
                    hVar.m(this);
                    if (z5) {
                        hVar.c();
                    } else {
                        hVar.n0();
                    }
                } catch (ProtocolException unused) {
                }
            }
            this.f39355z.f39359a.removeAllElements();
        }
        if (this.f39355z.f39368j) {
            this.f39354y.getClass();
        }
    }

    private void t(com.sun.mail.imap.protocol.h hVar, String str, String str2) throws ProtocolException {
        com.sun.mail.imap.protocol.h hVar2;
        String str3;
        String str4;
        if (this.f39348s && hVar.e0("STARTTLS")) {
            hVar.J0();
            hVar.w();
        }
        if (hVar.h0()) {
            return;
        }
        hVar.a0().put("__PRELOGIN__", "");
        String str5 = this.f39343m;
        String str6 = (str5 == null && (str5 = this.f39342l) == null) ? str : str5;
        if (this.f39349t) {
            hVar2 = hVar;
            str3 = str;
            str4 = str2;
            hVar2.B0(this.f39350u, this.f39344n, str6, str3, str4);
        } else {
            hVar2 = hVar;
            str3 = str;
            str4 = str2;
        }
        if (!hVar2.h0()) {
            if (hVar2.e0("AUTH=PLAIN") && !this.f39347r) {
                hVar2.v(str6, str3, str4);
            } else if ((hVar2.e0("AUTH-LOGIN") || hVar2.e0("AUTH=LOGIN")) && !this.f39346p) {
                hVar2.u(str3, str4);
            } else {
                if (hVar2.e0("LOGINDISABLED")) {
                    throw new ProtocolException("No login methods supported!");
                }
                hVar2.m0(str3, str4);
            }
        }
        String str7 = this.f39342l;
        if (str7 != null) {
            hVar2.y0(str7);
        }
        if (hVar2.e0("__PRELOGIN__")) {
            try {
                hVar2.w();
            } catch (ConnectionException e6) {
                throw e6;
            } catch (ProtocolException unused) {
            }
        }
    }

    private void z() {
        synchronized (this.f39355z) {
            try {
                if (System.currentTimeMillis() - this.f39355z.f39365g > this.f39355z.f39367i && this.f39355z.f39359a.size() > 1) {
                    if (this.f39355z.f39368j) {
                        PrintStream printStream = this.f39354y;
                        System.currentTimeMillis();
                        long unused = this.f39355z.f39365g;
                        printStream.getClass();
                        PrintStream printStream2 = this.f39354y;
                        long unused2 = this.f39355z.f39363e;
                        printStream2.getClass();
                    }
                    for (int size = this.f39355z.f39359a.size() - 1; size > 0; size--) {
                        com.sun.mail.imap.protocol.h hVar = (com.sun.mail.imap.protocol.h) this.f39355z.f39359a.elementAt(size);
                        if (this.f39355z.f39368j) {
                            PrintStream printStream3 = this.f39354y;
                            System.currentTimeMillis();
                            hVar.g();
                            printStream3.getClass();
                        }
                        if (System.currentTimeMillis() - hVar.g() > this.f39355z.f39363e) {
                            if (this.f39355z.f39368j) {
                                this.f39354y.getClass();
                                this.f39354y.getClass();
                            }
                            hVar.m(this);
                            this.f39355z.f39359a.removeElementAt(size);
                            try {
                                hVar.n0();
                            } catch (ProtocolException unused3) {
                            }
                        }
                    }
                    this.f39355z.f39365g = System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean b() {
        String property = this.session.getProperty("mail." + this.f39331a + ".allowreadonlyselect");
        return property != null && property.equalsIgnoreCase("true");
    }

    int f() {
        return this.f39337g;
    }

    boolean g() {
        return this.f39355z.f39368j;
    }

    int h() {
        return this.f39335e;
    }

    int i() {
        return this.f39338h;
    }

    Session l() {
        return this.session;
    }

    int m() {
        return this.f39336f;
    }

    boolean q() {
        return this.f39355z.f39361c;
    }

    boolean s() {
        boolean z5;
        synchronized (this.f39355z) {
            try {
                if (this.f39355z.f39368j) {
                    PrintStream printStream = this.f39354y;
                    this.f39355z.f39359a.size();
                    int unused = this.f39355z.f39366h;
                    printStream.getClass();
                }
                z5 = this.f39355z.f39359a.size() >= this.f39355z.f39366h;
            } finally {
            }
        }
        return z5;
    }

    void v(e eVar, com.sun.mail.imap.protocol.h hVar) {
        synchronized (this.f39355z) {
            if (hVar != null) {
                try {
                    if (s()) {
                        if (this.debug) {
                            this.f39354y.getClass();
                        }
                        try {
                            hVar.n0();
                        } catch (ProtocolException unused) {
                        }
                    } else {
                        hVar.a(this);
                        this.f39355z.f39359a.addElement(hVar);
                        if (this.debug) {
                            PrintStream printStream = this.f39354y;
                            this.f39355z.f39359a.size();
                            printStream.getClass();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f39355z.f39360b != null) {
                this.f39355z.f39360b.removeElement(eVar);
            }
            z();
        }
    }

    void w(com.sun.mail.imap.protocol.h hVar) {
        if (hVar == null) {
            return;
        }
        synchronized (this.f39355z) {
            try {
                this.f39355z.f39362d = false;
                this.f39355z.notifyAll();
                if (this.f39355z.f39368j) {
                    this.f39354y.getClass();
                }
                z();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.sun.mail.iap.h
    public void a(com.sun.mail.iap.g gVar) {
        if (gVar.h() || gVar.g() || gVar.d() || gVar.e()) {
            o(gVar);
        }
        if (gVar.e()) {
            if (this.debug) {
                this.f39354y.getClass();
            }
            if (this.f39353x) {
                d(gVar.i());
            }
        }
    }

    @Override // javax.mail.Service
    protected void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new e(uRLName.getFile(), q.f44042c, this);
    }

    @Override // javax.mail.Store
    public Folder[] getPersonalNamespaces() throws MessagingException {
        p.a[] aVarArr;
        p j6 = j();
        if (j6 != null && (aVarArr = j6.f39488a) != null) {
            return u(aVarArr, null);
        }
        return super.getPersonalNamespaces();
    }

    @Override // javax.mail.Store
    public Folder[] getSharedNamespaces() throws MessagingException {
        p.a[] aVarArr;
        p j6 = j();
        if (j6 != null && (aVarArr = j6.f39490c) != null) {
            return u(aVarArr, null);
        }
        return super.getSharedNamespaces();
    }

    @Override // javax.mail.Store
    public Folder[] getUserNamespaces(String str) throws MessagingException {
        p.a[] aVarArr;
        p j6 = j();
        if (j6 != null && (aVarArr = j6.f39489b) != null) {
            return u(aVarArr, str);
        }
        return super.getUserNamespaces(str);
    }

    void o(com.sun.mail.iap.g gVar) {
        String b6 = gVar.b();
        boolean z5 = false;
        if (b6.startsWith("[")) {
            int indexOf = b6.indexOf(93);
            if (indexOf > 0 && b6.substring(0, indexOf + 1).equalsIgnoreCase("[ALERT]")) {
                z5 = true;
            }
            b6 = b6.substring(indexOf + 1).trim();
        }
        if (z5) {
            notifyStoreListeners(1, b6);
        } else if (gVar.k() && b6.length() > 0) {
            notifyStoreListeners(2, b6);
        }
    }
}
