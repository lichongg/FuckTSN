package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public a[] f39488a;

    /* renamed from: b, reason: collision with root package name */
    public a[] f39489b;

    /* renamed from: c, reason: collision with root package name */
    public a[] f39490c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f39491a;

        /* renamed from: b, reason: collision with root package name */
        public char f39492b;

        public a(com.sun.mail.iap.g gVar) throws ProtocolException {
            if (gVar.r() == 40) {
                this.f39491a = com.sun.mail.imap.protocol.a.b(gVar.w());
                gVar.B();
                if (gVar.n() == 34) {
                    gVar.r();
                    char r5 = (char) gVar.r();
                    this.f39492b = r5;
                    if (r5 == '\\') {
                        this.f39492b = (char) gVar.r();
                    }
                    if (gVar.r() != 34) {
                        throw new ProtocolException("Missing '\"' at end of QUOTED_CHAR");
                    }
                } else {
                    String o5 = gVar.o();
                    if (o5 != null) {
                        if (o5.equalsIgnoreCase("NIL")) {
                            this.f39492b = (char) 0;
                        } else {
                            throw new ProtocolException("Expected NIL, got " + o5);
                        }
                    } else {
                        throw new ProtocolException("Expected NIL, got null");
                    }
                }
                if (gVar.n() != 41) {
                    gVar.B();
                    gVar.w();
                    gVar.B();
                    gVar.y();
                }
                if (gVar.r() == 41) {
                    return;
                } else {
                    throw new ProtocolException("Missing ')' at end of Namespace");
                }
            }
            throw new ProtocolException("Missing '(' at start of Namespace");
        }
    }

    public p(com.sun.mail.iap.g gVar) throws ProtocolException {
        this.f39488a = a(gVar);
        this.f39489b = a(gVar);
        this.f39490c = a(gVar);
    }

    private a[] a(com.sun.mail.iap.g gVar) throws ProtocolException {
        gVar.B();
        if (gVar.n() == 40) {
            Vector vector = new Vector();
            gVar.r();
            do {
                vector.addElement(new a(gVar));
            } while (gVar.n() != 41);
            gVar.r();
            a[] aVarArr = new a[vector.size()];
            vector.copyInto(aVarArr);
            return aVarArr;
        }
        String o5 = gVar.o();
        if (o5 != null) {
            if (o5.equalsIgnoreCase("NIL")) {
                return null;
            }
            throw new ProtocolException("Expected NIL, got " + o5);
        }
        throw new ProtocolException("Expected NIL, got null");
    }
}
