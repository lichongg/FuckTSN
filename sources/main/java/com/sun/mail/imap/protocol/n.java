package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import javax.mail.Flags;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public Flags f39478a;

    /* renamed from: b, reason: collision with root package name */
    public Flags f39479b;

    /* renamed from: c, reason: collision with root package name */
    public int f39480c;

    /* renamed from: d, reason: collision with root package name */
    public int f39481d;

    /* renamed from: e, reason: collision with root package name */
    public int f39482e;

    /* renamed from: f, reason: collision with root package name */
    public long f39483f;

    /* renamed from: g, reason: collision with root package name */
    public long f39484g;

    /* renamed from: h, reason: collision with root package name */
    public int f39485h;

    public n(com.sun.mail.iap.g[] gVarArr) throws ParsingException {
        this.f39478a = null;
        this.f39479b = null;
        this.f39480c = -1;
        this.f39481d = -1;
        this.f39482e = -1;
        this.f39483f = -1L;
        this.f39484g = -1L;
        for (int i6 = 0; i6 < gVarArr.length; i6++) {
            com.sun.mail.iap.g gVar = gVarArr[i6];
            if (gVar != null && (gVar instanceof i)) {
                i iVar = (i) gVar;
                if (iVar.F("EXISTS")) {
                    this.f39480c = iVar.E();
                    gVarArr[i6] = null;
                } else if (iVar.F("RECENT")) {
                    this.f39481d = iVar.E();
                    gVarArr[i6] = null;
                } else if (iVar.F("FLAGS")) {
                    this.f39478a = new FLAGS(iVar);
                    gVarArr[i6] = null;
                } else if (iVar.k() && iVar.h()) {
                    iVar.B();
                    if (iVar.r() != 91) {
                        iVar.z();
                    } else {
                        String o5 = iVar.o();
                        if (o5.equalsIgnoreCase("UNSEEN")) {
                            this.f39482e = iVar.v();
                        } else if (o5.equalsIgnoreCase("UIDVALIDITY")) {
                            this.f39483f = iVar.u();
                        } else if (o5.equalsIgnoreCase("PERMANENTFLAGS")) {
                            this.f39479b = new FLAGS(iVar);
                        } else if (o5.equalsIgnoreCase("UIDNEXT")) {
                            this.f39484g = iVar.u();
                        } else {
                            iVar.z();
                        }
                        gVarArr[i6] = null;
                    }
                }
            }
        }
        if (this.f39479b == null) {
            Flags flags = this.f39478a;
            if (flags != null) {
                this.f39479b = new Flags(flags);
            } else {
                this.f39479b = new Flags();
            }
        }
    }
}
