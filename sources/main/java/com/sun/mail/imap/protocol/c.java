package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c implements l {

    /* renamed from: e, reason: collision with root package name */
    static final char[] f39396e = {'B', 'O', 'D', 'Y'};

    /* renamed from: a, reason: collision with root package name */
    public int f39397a;

    /* renamed from: b, reason: collision with root package name */
    public com.sun.mail.iap.d f39398b;

    /* renamed from: c, reason: collision with root package name */
    public String f39399c;

    /* renamed from: d, reason: collision with root package name */
    public int f39400d;

    public com.sun.mail.iap.d a() {
        return this.f39398b;
    }

    public ByteArrayInputStream b() {
        com.sun.mail.iap.d dVar = this.f39398b;
        if (dVar != null) {
            return dVar.g();
        }
        return null;
    }

    public c(f fVar) throws ParsingException {
        byte r5;
        this.f39400d = 0;
        this.f39397a = fVar.E();
        fVar.B();
        do {
            r5 = fVar.r();
            if (r5 == 93) {
                if (fVar.r() == 60) {
                    this.f39400d = fVar.v();
                    fVar.A(1);
                }
                this.f39398b = fVar.s();
                return;
            }
        } while (r5 != 0);
        throw new ParsingException("BODY parse error: missing ``]'' at section end");
    }
}
