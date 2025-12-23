package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class u {

    /* renamed from: g, reason: collision with root package name */
    static final String[] f39501g = {"MESSAGES", "RECENT", "UNSEEN", "UIDNEXT", "UIDVALIDITY"};

    /* renamed from: a, reason: collision with root package name */
    public String f39502a;

    /* renamed from: b, reason: collision with root package name */
    public int f39503b;

    /* renamed from: c, reason: collision with root package name */
    public int f39504c;

    /* renamed from: d, reason: collision with root package name */
    public long f39505d;

    /* renamed from: e, reason: collision with root package name */
    public long f39506e;

    /* renamed from: f, reason: collision with root package name */
    public int f39507f;

    public static void a(u uVar, u uVar2) {
        int i6 = uVar2.f39503b;
        if (i6 != -1) {
            uVar.f39503b = i6;
        }
        int i7 = uVar2.f39504c;
        if (i7 != -1) {
            uVar.f39504c = i7;
        }
        long j6 = uVar2.f39505d;
        if (j6 != -1) {
            uVar.f39505d = j6;
        }
        long j7 = uVar2.f39506e;
        if (j7 != -1) {
            uVar.f39506e = j7;
        }
        int i8 = uVar2.f39507f;
        if (i8 != -1) {
            uVar.f39507f = i8;
        }
    }

    public u(com.sun.mail.iap.g gVar) throws ParsingException {
        this.f39502a = null;
        this.f39503b = -1;
        this.f39504c = -1;
        this.f39505d = -1L;
        this.f39506e = -1L;
        this.f39507f = -1;
        this.f39502a = gVar.q();
        gVar.B();
        if (gVar.r() == 40) {
            do {
                String o5 = gVar.o();
                if (o5.equalsIgnoreCase("MESSAGES")) {
                    this.f39503b = gVar.v();
                } else if (o5.equalsIgnoreCase("RECENT")) {
                    this.f39504c = gVar.v();
                } else if (o5.equalsIgnoreCase("UIDNEXT")) {
                    this.f39505d = gVar.u();
                } else if (o5.equalsIgnoreCase("UIDVALIDITY")) {
                    this.f39506e = gVar.u();
                } else if (o5.equalsIgnoreCase("UNSEEN")) {
                    this.f39507f = gVar.v();
                }
            } while (gVar.r() != 41);
            return;
        }
        throw new ParsingException("parse error in STATUS");
    }
}
