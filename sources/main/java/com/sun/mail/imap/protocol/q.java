package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class q implements l {

    /* renamed from: c, reason: collision with root package name */
    static final char[] f39493c = {'R', 'F', 'C', '8', '2', '2'};

    /* renamed from: a, reason: collision with root package name */
    public int f39494a;

    /* renamed from: b, reason: collision with root package name */
    public com.sun.mail.iap.d f39495b;

    public com.sun.mail.iap.d a() {
        return this.f39495b;
    }

    public ByteArrayInputStream b() {
        com.sun.mail.iap.d dVar = this.f39495b;
        if (dVar != null) {
            return dVar.g();
        }
        return null;
    }

    public q(f fVar) throws ParsingException {
        this.f39494a = fVar.E();
        fVar.B();
        this.f39495b = fVar.s();
    }
}
