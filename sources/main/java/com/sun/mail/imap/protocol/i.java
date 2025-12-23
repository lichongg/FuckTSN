package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.util.ASCIIUtility;
import java.io.IOException;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i extends com.sun.mail.iap.g {

    /* renamed from: r, reason: collision with root package name */
    private String f39452r;

    /* renamed from: s, reason: collision with root package name */
    private int f39453s;

    public i(com.sun.mail.iap.f fVar) throws IOException, ProtocolException {
        super(fVar);
        if (!k() || h() || g() || d() || e()) {
            return;
        }
        String o5 = o();
        this.f39452r = o5;
        try {
            this.f39453s = Integer.parseInt(o5);
            this.f39452r = o();
        } catch (NumberFormatException unused) {
        }
    }

    public static i G(com.sun.mail.iap.f fVar) throws IOException, ProtocolException {
        i iVar = new i(fVar);
        return iVar.F("FETCH") ? new f(iVar) : iVar;
    }

    public String D() {
        return this.f39452r;
    }

    public int E() {
        return this.f39453s;
    }

    public boolean F(String str) {
        String str2 = this.f39452r;
        return str2 != null && str2.equalsIgnoreCase(str);
    }

    public String[] H() {
        byte[] bArr;
        int i6;
        B();
        byte[] bArr2 = this.f39210d;
        int i7 = this.f39207a;
        if (bArr2[i7] != 40) {
            return null;
        }
        this.f39207a = i7 + 1;
        Vector vector = new Vector();
        int i8 = this.f39207a;
        while (true) {
            bArr = this.f39210d;
            i6 = this.f39207a;
            byte b6 = bArr[i6];
            if (b6 == 41) {
                break;
            }
            if (b6 == 32) {
                vector.addElement(ASCIIUtility.toString(bArr, i8, i6));
                i8 = this.f39207a + 1;
            }
            this.f39207a++;
        }
        if (i6 > i8) {
            vector.addElement(ASCIIUtility.toString(bArr, i8, i6));
        }
        this.f39207a++;
        int size = vector.size();
        if (size <= 0) {
            return null;
        }
        String[] strArr = new String[size];
        vector.copyInto(strArr);
        return strArr;
    }

    public i(i iVar) {
        super(iVar);
        this.f39452r = iVar.f39452r;
        this.f39453s = iVar.f39453s;
    }
}
