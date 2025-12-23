package javax.mail;

import java.util.Vector;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.MailEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Service {
    protected boolean debug;

    /* renamed from: q, reason: collision with root package name */
    private EventQueue f43457q;
    protected Session session;
    protected URLName url;
    private boolean connected = false;
    private Vector connectionListeners = null;
    private Object qLock = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = 5542172141759168416L;

        TerminatorEvent() {
            super(new Object());
        }

        @Override // javax.mail.event.MailEvent
        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        try {
            if (this.connectionListeners == null) {
                this.connectionListeners = new Vector();
            }
            this.connectionListeners.addElement(connectionListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() throws MessagingException {
        setConnected(false);
        notifyConnectionListeners(3);
    }

    public void connect() throws MessagingException {
        connect(null, null, null);
    }

    public synchronized URLName getURLName() {
        try {
            URLName uRLName = this.url;
            if (uRLName == null || (uRLName.getPassword() == null && this.url.getFile() == null)) {
                return this.url;
            }
            return new URLName(this.url.getProtocol(), this.url.getHost(), this.url.getPort(), null, this.url.getUsername(), null);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean isConnected() {
        return this.connected;
    }

    protected synchronized void notifyConnectionListeners(int i6) {
        try {
            if (this.connectionListeners != null) {
                queueEvent(new ConnectionEvent(this, i6), this.connectionListeners);
            }
            if (i6 == 3) {
                terminateQueue();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected boolean protocolConnect(String str, int i6, String str2, String str3) throws MessagingException {
        return false;
    }

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        Vector vector = this.connectionListeners;
        if (vector != null) {
            vector.removeElement(connectionListener);
        }
    }

    protected synchronized void setConnected(boolean z5) {
        this.connected = z5;
    }

    protected synchronized void setURLName(URLName uRLName) {
        this.url = uRLName;
    }

    private void terminateQueue() {
        synchronized (this.qLock) {
            try {
                if (this.f43457q != null) {
                    Vector vector = new Vector();
                    vector.setSize(1);
                    this.f43457q.enqueue(new TerminatorEvent(), vector);
                    this.f43457q = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void connect(String str, String str2, String str3) throws MessagingException {
        connect(str, -1, str2, str3);
    }

    protected void queueEvent(MailEvent mailEvent, Vector vector) {
        synchronized (this.qLock) {
            try {
                if (this.f43457q == null) {
                    this.f43457q = new EventQueue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f43457q.enqueue(mailEvent, (Vector) vector.clone());
    }

    protected Service(Session session, URLName uRLName) {
        this.debug = false;
        this.session = session;
        this.url = uRLName;
        this.debug = session.getDebug();
    }

    public void connect(String str, String str2) throws MessagingException {
        connect(null, str, str2);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        terminateQueue();
    }

    public String toString() {
        URLName uRLName = getURLName();
        if (uRLName != null) {
            return uRLName.toString();
        }
        return super.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:5|(6:7|(1:9)|10|(1:12)|(2:14|(1:16))(1:(1:81))|17)(1:82)|18|(2:(1:21)|(1:23))|(1:25)|26|(1:28)|(2:70|71)|30|31|(1:69)(2:35|(1:(1:38)(2:65|(1:67)))(6:68|40|41|42|(4:56|57|58|(1:60))|(1:(1:46)(2:48|49))(4:50|(1:52)|53|54)))|39|40|41|42|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0104, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130 A[Catch: all -> 0x0019, TryCatch #2 {all -> 0x0019, SecurityException -> 0x00af, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000c, B:9:0x0012, B:12:0x0020, B:14:0x0028, B:16:0x0030, B:17:0x004b, B:21:0x005c, B:23:0x0077, B:25:0x0092, B:28:0x009d, B:71:0x00a7, B:33:0x00c3, B:35:0x00c7, B:38:0x00e0, B:41:0x00fe, B:57:0x0107, B:46:0x0129, B:48:0x012a, B:49:0x012f, B:50:0x0130, B:52:0x013d, B:53:0x014b, B:58:0x010b, B:60:0x0119, B:65:0x00ea, B:67:0x00f4, B:75:0x00b1, B:77:0x00b5, B:79:0x0039, B:81:0x0045, B:83:0x0153, B:84:0x015a), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void connect(java.lang.String r11, int r12, java.lang.String r13, java.lang.String r14) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Service.connect(java.lang.String, int, java.lang.String, java.lang.String):void");
    }
}
