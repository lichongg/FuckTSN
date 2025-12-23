package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.Date;
import java.util.Vector;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MailDateFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e implements l {

    /* renamed from: l, reason: collision with root package name */
    static final char[] f39423l = {'E', 'N', 'V', 'E', 'L', 'O', 'P', 'E'};

    /* renamed from: m, reason: collision with root package name */
    private static MailDateFormat f39424m = new MailDateFormat();

    /* renamed from: a, reason: collision with root package name */
    public int f39425a;

    /* renamed from: b, reason: collision with root package name */
    public Date f39426b;

    /* renamed from: c, reason: collision with root package name */
    public String f39427c;

    /* renamed from: d, reason: collision with root package name */
    public InternetAddress[] f39428d;

    /* renamed from: e, reason: collision with root package name */
    public InternetAddress[] f39429e;

    /* renamed from: f, reason: collision with root package name */
    public InternetAddress[] f39430f;

    /* renamed from: g, reason: collision with root package name */
    public InternetAddress[] f39431g;

    /* renamed from: h, reason: collision with root package name */
    public InternetAddress[] f39432h;

    /* renamed from: i, reason: collision with root package name */
    public InternetAddress[] f39433i;

    /* renamed from: j, reason: collision with root package name */
    public String f39434j;

    /* renamed from: k, reason: collision with root package name */
    public String f39435k;

    public e(f fVar) throws ParsingException {
        this.f39426b = null;
        this.f39425a = fVar.E();
        fVar.B();
        if (fVar.r() == 40) {
            String w5 = fVar.w();
            if (w5 != null) {
                try {
                    this.f39426b = f39424m.parse(w5);
                } catch (Exception unused) {
                }
            }
            this.f39427c = fVar.w();
            this.f39428d = a(fVar);
            this.f39429e = a(fVar);
            this.f39430f = a(fVar);
            this.f39431g = a(fVar);
            this.f39432h = a(fVar);
            this.f39433i = a(fVar);
            this.f39434j = fVar.w();
            this.f39435k = fVar.w();
            if (fVar.r() == 41) {
                return;
            } else {
                throw new ParsingException("ENVELOPE parse error");
            }
        }
        throw new ParsingException("ENVELOPE parse error");
    }

    private InternetAddress[] a(com.sun.mail.iap.g gVar) throws ParsingException {
        gVar.B();
        byte r5 = gVar.r();
        if (r5 == 40) {
            Vector vector = new Vector();
            do {
                g gVar2 = new g(gVar);
                if (!gVar2.a()) {
                    vector.addElement(gVar2);
                }
            } while (gVar.n() != 41);
            gVar.A(1);
            InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
            vector.copyInto(internetAddressArr);
            return internetAddressArr;
        }
        if (r5 != 78 && r5 != 110) {
            throw new ParsingException("ADDRESS parse error");
        }
        gVar.A(2);
        return null;
    }
}
