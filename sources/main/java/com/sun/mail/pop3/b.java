package com.sun.mail.pop3;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import javax.mail.Store;
import javax.mail.UIDFolder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends Folder {

    /* renamed from: a, reason: collision with root package name */
    private String f39513a;

    /* renamed from: b, reason: collision with root package name */
    private f f39514b;

    /* renamed from: c, reason: collision with root package name */
    private int f39515c;

    /* renamed from: d, reason: collision with root package name */
    private int f39516d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f39517e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f39518f;

    /* renamed from: g, reason: collision with root package name */
    private Vector f39519g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f39520h;

    @Override // javax.mail.Folder
    public synchronized void close(boolean z5) throws MessagingException {
        try {
            c();
            try {
                try {
                    if (((e) this.store).f39535j) {
                        this.f39514b.j();
                    }
                    if (z5 && this.mode == 2) {
                        for (int i6 = 0; i6 < this.f39519g.size(); i6++) {
                            c cVar = (c) this.f39519g.elementAt(i6);
                            if (cVar != null && cVar.isSet(Flags.Flag.DELETED)) {
                                try {
                                    this.f39514b.a(i6 + 1);
                                } catch (IOException e6) {
                                    throw new MessagingException("Exception deleting messages during close", e6);
                                }
                            }
                        }
                    }
                    this.f39514b.h();
                    this.f39514b = null;
                    ((e) this.store).b(this);
                    this.f39519g = null;
                } catch (Throwable th) {
                    this.f39514b = null;
                    ((e) this.store).b(this);
                    this.f39519g = null;
                    this.f39518f = false;
                    notifyConnectionListeners(3);
                    throw th;
                }
            } catch (IOException unused) {
                this.f39514b = null;
                ((e) this.store).b(this);
                this.f39519g = null;
            }
            this.f39518f = false;
            notifyConnectionListeners(3);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // javax.mail.Folder
    public boolean create(int i6) throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        try {
            d();
            if (!this.f39520h && fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
                int size = this.f39519g.size();
                String[] strArr = new String[size];
                try {
                    if (!this.f39514b.p(strArr)) {
                        return;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        if (strArr[i6] != null) {
                            ((c) getMessage(i6 + 1)).f39525d = strArr[i6];
                        }
                    }
                    this.f39520h = true;
                } catch (EOFException e6) {
                    close(false);
                    throw new FolderClosedException(this, e6.toString());
                } catch (IOException e7) {
                    throw new MessagingException("error getting UIDL", e7);
                }
            }
            if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
                for (Message message : messageArr) {
                    try {
                        c cVar = (c) message;
                        cVar.getHeader("");
                        cVar.getSize();
                    } catch (MessageRemovedException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i6) throws MessagingException {
        c cVar;
        c();
        int i7 = i6 - 1;
        cVar = (c) this.f39519g.elementAt(i7);
        if (cVar == null) {
            cVar = f(this, i6);
            this.f39519g.setElementAt(cVar, i7);
        }
        return cVar;
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        if (!this.f39518f) {
            return -1;
        }
        d();
        return this.f39515c;
    }

    @Override // javax.mail.Folder
    public char getSeparator() {
        return (char) 0;
    }

    @Override // javax.mail.Folder
    public int getType() {
        return 1;
    }

    public synchronized int h() throws MessagingException {
        c();
        return this.f39516d;
    }

    @Override // javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0021, code lost:
    
        if (r2 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0023, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x006b, code lost:
    
        if (r2 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int[] i() throws javax.mail.MessagingException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.c()     // Catch: java.lang.Throwable -> L1e
            int r0 = r6.f39515c     // Catch: java.lang.Throwable -> L1e
            int[] r0 = new int[r0]     // Catch: java.lang.Throwable -> L1e
            r1 = 0
            com.sun.mail.pop3.f r2 = r6.f39514b     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            java.io.InputStream r2 = r2.d()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            com.sun.mail.util.LineInputStream r3 = new com.sun.mail.util.LineInputStream     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
        L14:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            if (r1 != 0) goto L27
            r3.close()     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L20
            goto L21
        L1e:
            r0 = move-exception
            goto L70
        L20:
        L21:
            if (r2 == 0) goto L6e
        L23:
            r2.close()     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L6e
            goto L6e
        L27:
            java.util.StringTokenizer r4 = new java.util.StringTokenizer     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L47
            r4.<init>(r1)     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L47
            java.lang.String r1 = r4.nextToken()     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L47
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L47
            java.lang.String r4 = r4.nextToken()     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L47
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L47
            if (r1 <= 0) goto L14
            int r5 = r6.f39515c     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L47
            if (r1 > r5) goto L14
            int r1 = r1 + (-1)
            r0[r1] = r4     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L47
            goto L14
        L47:
            r0 = move-exception
            r1 = r3
            goto L57
        L4a:
            r1 = r3
            goto L64
        L4d:
            r0 = move-exception
            goto L57
        L4f:
            goto L64
        L51:
            r0 = move-exception
            r2 = r1
            goto L57
        L54:
            r2 = r1
            goto L64
        L57:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L5d
            goto L5e
        L5d:
        L5e:
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L63
        L63:
            throw r0     // Catch: java.lang.Throwable -> L1e
        L64:
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L6a
            goto L6b
        L6a:
        L6b:
            if (r2 == 0) goto L6e
            goto L23
        L6e:
            monitor-exit(r6)
            return r0
        L70:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L1e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.b.i():int[]");
    }

    public synchronized String j(Message message) throws MessagingException {
        c cVar;
        try {
            c();
            cVar = (c) message;
            try {
                if (cVar.f39525d == "UNKNOWN") {
                    cVar.f39525d = this.f39514b.o(cVar.getMessageNumber());
                }
            } catch (EOFException e6) {
                close(false);
                throw new FolderClosedException(this, e6.toString());
            } catch (IOException e7) {
                throw new MessagingException("error getting UIDL", e7);
            }
        } catch (Throwable th) {
            throw th;
        }
        return cVar.f39525d;
    }

    public synchronized InputStream k() throws MessagingException, IOException {
        c();
        return this.f39514b.d();
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i6) throws MessagingException {
        Store store;
        b();
        if (!this.f39517e) {
            throw new FolderNotFoundException(this, "folder is not INBOX");
        }
        try {
            f c6 = ((e) this.store).c(this);
            this.f39514b = c6;
            i l6 = c6.l();
            this.f39515c = l6.f39551a;
            this.f39516d = l6.f39552b;
            this.mode = i6;
            this.f39518f = true;
            Vector vector = new Vector(this.f39515c);
            this.f39519g = vector;
            vector.setSize(this.f39515c);
            this.f39520h = false;
            notifyConnectionListeners(1);
        } catch (IOException e6) {
            try {
                f fVar = this.f39514b;
                if (fVar != null) {
                    fVar.h();
                }
                this.f39514b = null;
                store = this.store;
            } catch (IOException unused) {
                this.f39514b = null;
                store = this.store;
            } catch (Throwable th) {
                this.f39514b = null;
                ((e) this.store).b(this);
                throw th;
            }
            ((e) store).b(this);
            throw new MessagingException("Open failed", e6);
        }
    }

    @Override // javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    void b() throws IllegalStateException {
        if (this.f39518f) {
            throw new IllegalStateException("Folder is Open");
        }
    }

    void c() throws IllegalStateException {
        if (!this.f39518f) {
            throw new IllegalStateException("Folder is not Open");
        }
    }

    void d() throws IllegalStateException {
        int i6;
        if (!this.f39518f || ((i6 = this.mode) != 1 && i6 != 2)) {
            throw new IllegalStateException("Folder is not Readable");
        }
    }

    @Override // javax.mail.Folder
    public boolean delete(boolean z5) throws MessagingException {
        throw new MethodNotSupportedException("delete");
    }

    void e() throws IllegalStateException {
        if (!this.f39518f || this.mode != 2) {
            throw new IllegalStateException("Folder is not Writable");
        }
    }

    @Override // javax.mail.Folder
    public boolean exists() {
        return this.f39517e;
    }

    @Override // javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Expunge not supported");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.sun.mail.pop3.c f(javax.mail.Folder r4, int r5) throws javax.mail.MessagingException {
        /*
            r3 = this;
            javax.mail.Store r4 = r3.store
            com.sun.mail.pop3.e r4 = (com.sun.mail.pop3.e) r4
            java.lang.reflect.Constructor r4 = r4.f39538m
            if (r4 == 0) goto L1d
            java.lang.Integer r0 = new java.lang.Integer     // Catch: java.lang.Exception -> L1d
            r0.<init>(r5)     // Catch: java.lang.Exception -> L1d
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L1d
            r2 = 0
            r1[r2] = r3     // Catch: java.lang.Exception -> L1d
            r2 = 1
            r1[r2] = r0     // Catch: java.lang.Exception -> L1d
            java.lang.Object r4 = r4.newInstance(r1)     // Catch: java.lang.Exception -> L1d
            com.sun.mail.pop3.c r4 = (com.sun.mail.pop3.c) r4     // Catch: java.lang.Exception -> L1d
            goto L1e
        L1d:
            r4 = 0
        L1e:
            if (r4 != 0) goto L25
            com.sun.mail.pop3.c r4 = new com.sun.mail.pop3.c
            r4.<init>(r3, r5)
        L25:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.b.f(javax.mail.Folder, int):com.sun.mail.pop3.c");
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return this.f39513a;
    }

    @Override // javax.mail.Folder
    public String getName() {
        return this.f39513a;
    }

    @Override // javax.mail.Folder
    public Folder getParent() {
        return new a((e) this.store);
    }

    @Override // javax.mail.Folder
    public Flags getPermanentFlags() {
        return new Flags();
    }

    @Override // javax.mail.Folder
    public boolean isOpen() {
        if (!this.f39518f) {
            return false;
        }
        if (this.store.isConnected()) {
            return true;
        }
        try {
            close(false);
        } catch (MessagingException unused) {
        }
        return false;
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    @Override // javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("renameTo");
    }

    b(e eVar, String str) {
        super(eVar);
        this.f39517e = false;
        this.f39518f = false;
        this.f39520h = false;
        this.f39513a = str;
        if (str.equalsIgnoreCase("INBOX")) {
            this.f39517e = true;
        }
    }

    @Override // javax.mail.Folder
    protected void finalize() throws Throwable {
        super.finalize();
        close(false);
    }

    f g() throws MessagingException {
        c();
        return this.f39514b;
    }

    @Override // javax.mail.Folder
    protected void notifyMessageChangedListeners(int i6, Message message) {
        super.notifyMessageChangedListeners(i6, message);
    }
}
