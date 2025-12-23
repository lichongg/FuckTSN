package com.sun.mail.iap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ConnectionException extends ProtocolException {
    private static final long serialVersionUID = 5749739604257464727L;

    /* renamed from: p, reason: collision with root package name */
    private transient f f39173p;

    public ConnectionException() {
    }

    public ConnectionException(String str) {
        super(str);
    }

    public f getProtocol() {
        return this.f39173p;
    }

    public ConnectionException(f fVar, g gVar) {
        super(gVar);
        this.f39173p = fVar;
    }
}
