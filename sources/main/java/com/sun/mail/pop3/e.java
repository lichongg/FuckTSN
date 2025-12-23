package com.sun.mail.pop3;

import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends Store {

    /* renamed from: a, reason: collision with root package name */
    private String f39526a;

    /* renamed from: b, reason: collision with root package name */
    private int f39527b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f39528c;

    /* renamed from: d, reason: collision with root package name */
    private f f39529d;

    /* renamed from: e, reason: collision with root package name */
    private b f39530e;

    /* renamed from: f, reason: collision with root package name */
    private String f39531f;

    /* renamed from: g, reason: collision with root package name */
    private int f39532g;

    /* renamed from: h, reason: collision with root package name */
    private String f39533h;

    /* renamed from: i, reason: collision with root package name */
    private String f39534i;

    /* renamed from: j, reason: collision with root package name */
    boolean f39535j;

    /* renamed from: k, reason: collision with root package name */
    boolean f39536k;

    /* renamed from: l, reason: collision with root package name */
    boolean f39537l;

    /* renamed from: m, reason: collision with root package name */
    Constructor f39538m;

    public e(Session session, URLName uRLName) {
        this(session, uRLName, "pop3", 110, false);
    }

    synchronized void b(b bVar) {
        if (this.f39530e == bVar) {
            this.f39529d = null;
            this.f39530e = null;
        }
    }

    synchronized f c(b bVar) throws IOException {
        f fVar = this.f39529d;
        if (fVar != null && this.f39530e == null) {
            this.f39530e = bVar;
            return fVar;
        }
        f fVar2 = new f(this.f39531f, this.f39532g, this.session.getDebug(), this.session.getDebugOut(), this.session.getProperties(), "mail." + this.f39526a, this.f39528c);
        String e6 = fVar2.e(this.f39533h, this.f39534i);
        if (e6 != null) {
            try {
                fVar2.h();
            } catch (Throwable unused) {
            }
            throw new EOFException(e6);
        }
        if (this.f39529d == null && bVar != null) {
            this.f39529d = fVar2;
            this.f39530e = bVar;
        }
        if (this.f39530e == null) {
            this.f39530e = bVar;
        }
        return fVar2;
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        try {
            try {
                f fVar = this.f39529d;
                if (fVar != null) {
                    fVar.h();
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f39529d = null;
                super.close();
                throw th;
            }
            this.f39529d = null;
            super.close();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // javax.mail.Store
    public Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new b(this, str);
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (!super.isConnected()) {
            return false;
        }
        synchronized (this) {
            try {
                try {
                    try {
                        f fVar = this.f39529d;
                        if (fVar == null) {
                            this.f39529d = c(null);
                        } else {
                            fVar.g();
                        }
                        return true;
                    } catch (IOException unused) {
                        super.close();
                        return false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    @Override // javax.mail.Service
    protected synchronized boolean protocolConnect(String str, int i6, String str2, String str3) throws MessagingException {
        if (str == null || str3 == null || str2 == null) {
            return false;
        }
        if (i6 == -1) {
            try {
                String property = this.session.getProperty("mail." + this.f39526a + ".port");
                if (property != null) {
                    i6 = Integer.parseInt(property);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i6 == -1) {
            i6 = this.f39527b;
        }
        this.f39531f = str;
        this.f39532g = i6;
        this.f39533h = str2;
        this.f39534i = str3;
        try {
            this.f39529d = c(null);
            return true;
        } catch (EOFException e6) {
            throw new AuthenticationFailedException(e6.getMessage());
        } catch (IOException e7) {
            throw new MessagingException("Connect failed", e7);
        }
    }

    public e(Session session, URLName uRLName, String str, int i6, boolean z5) {
        super(session, uRLName);
        Class<?> cls;
        this.f39526a = "pop3";
        this.f39527b = 110;
        this.f39528c = false;
        this.f39529d = null;
        this.f39530e = null;
        this.f39531f = null;
        this.f39532g = -1;
        this.f39533h = null;
        this.f39534i = null;
        this.f39535j = false;
        this.f39536k = false;
        this.f39537l = false;
        this.f39538m = null;
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.f39526a = str;
        this.f39527b = i6;
        this.f39528c = z5;
        String property = session.getProperty("mail." + str + ".rsetbeforequit");
        if (property != null && property.equalsIgnoreCase("true")) {
            this.f39535j = true;
        }
        String property2 = session.getProperty("mail." + str + ".disabletop");
        if (property2 != null && property2.equalsIgnoreCase("true")) {
            this.f39536k = true;
        }
        String property3 = session.getProperty("mail." + str + ".forgettopheaders");
        if (property3 != null && property3.equalsIgnoreCase("true")) {
            this.f39537l = true;
        }
        String property4 = session.getProperty("mail." + str + ".message.class");
        if (property4 != null) {
            if (session.getDebug()) {
                session.getDebugOut().getClass();
            }
            try {
                try {
                    cls = getClass().getClassLoader().loadClass(property4);
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName(property4);
                }
                this.f39538m = cls.getConstructor(Folder.class, Integer.TYPE);
            } catch (Exception e6) {
                if (session.getDebug()) {
                    PrintStream debugOut = session.getDebugOut();
                    e6.toString();
                    debugOut.getClass();
                }
            }
        }
    }

    private void checkConnected() throws MessagingException {
        if (super.isConnected()) {
        } else {
            throw new MessagingException("Not connected");
        }
    }

    @Override // javax.mail.Service
    protected void finalize() throws Throwable {
        super.finalize();
        if (this.f39529d != null) {
            close();
        }
    }

    @Override // javax.mail.Store
    public Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new a(this);
    }

    @Override // javax.mail.Store
    public Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new b(this, uRLName.getFile());
    }
}
