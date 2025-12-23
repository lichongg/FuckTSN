package com.sun.mail.iap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ProtocolException extends Exception {
    private static final long serialVersionUID = -4360500807971797439L;
    protected transient g response;

    public ProtocolException() {
        this.response = null;
    }

    public g getResponse() {
        return this.response;
    }

    public ProtocolException(String str) {
        super(str);
        this.response = null;
    }

    public ProtocolException(g gVar) {
        super(gVar.toString());
        this.response = gVar;
    }
}
