package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import io.netty.util.internal.StringUtil;
import java.util.Vector;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class g extends InternetAddress {
    private static final long serialVersionUID = -3835822029483122232L;

    /* renamed from: a, reason: collision with root package name */
    private boolean f39439a;

    /* renamed from: b, reason: collision with root package name */
    private InternetAddress[] f39440b;

    /* renamed from: c, reason: collision with root package name */
    private String f39441c;

    boolean a() {
        return this.f39439a && this.f39441c == null;
    }

    @Override // javax.mail.internet.InternetAddress
    public InternetAddress[] getGroup(boolean z5) throws AddressException {
        InternetAddress[] internetAddressArr = this.f39440b;
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    @Override // javax.mail.internet.InternetAddress
    public boolean isGroup() {
        return this.f39439a;
    }

    g(com.sun.mail.iap.g gVar) throws ParsingException {
        this.f39439a = false;
        gVar.B();
        if (gVar.r() == 40) {
            this.encodedPersonal = gVar.w();
            gVar.w();
            String w5 = gVar.w();
            String w6 = gVar.w();
            if (gVar.r() == 41) {
                if (w6 == null) {
                    this.f39439a = true;
                    this.f39441c = w5;
                    if (w5 == null) {
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(this.f39441c);
                    stringBuffer.append(':');
                    Vector vector = new Vector();
                    while (gVar.n() != 41) {
                        g gVar2 = new g(gVar);
                        if (gVar2.a()) {
                            break;
                        }
                        if (vector.size() != 0) {
                            stringBuffer.append(StringUtil.COMMA);
                        }
                        stringBuffer.append(gVar2.toString());
                        vector.addElement(gVar2);
                    }
                    stringBuffer.append(';');
                    this.address = stringBuffer.toString();
                    g[] gVarArr = new g[vector.size()];
                    this.f39440b = gVarArr;
                    vector.copyInto(gVarArr);
                    return;
                }
                if (w5 != null && w5.length() != 0) {
                    if (w6.length() == 0) {
                        this.address = w5;
                        return;
                    }
                    this.address = w5 + "@" + w6;
                    return;
                }
                this.address = w6;
                return;
            }
            throw new ParsingException("ADDRESS parse error");
        }
        throw new ParsingException("ADDRESS parse error");
    }
}
