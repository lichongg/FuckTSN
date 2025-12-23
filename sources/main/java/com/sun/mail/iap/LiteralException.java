package com.sun.mail.iap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiteralException extends ProtocolException {
    private static final long serialVersionUID = -6919179828339609913L;

    public LiteralException(g gVar) {
        super(gVar.toString());
        this.response = gVar;
    }
}
