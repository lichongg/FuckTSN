package com.sun.mail.imap;

import com.sun.mail.imap.protocol.w;
import java.util.Vector;
import javax.mail.Message;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class o {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean a(g gVar);
    }

    public static com.sun.mail.imap.protocol.o[] a(Message[] messageArr, a aVar) {
        Vector vector = new Vector(1);
        int i6 = 0;
        while (i6 < messageArr.length) {
            g gVar = (g) messageArr[i6];
            if (!gVar.isExpunged()) {
                int w5 = gVar.w();
                if (aVar == null || aVar.a(gVar)) {
                    com.sun.mail.imap.protocol.o oVar = new com.sun.mail.imap.protocol.o();
                    oVar.f39486a = w5;
                    while (true) {
                        i6++;
                        if (i6 >= messageArr.length) {
                            break;
                        }
                        g gVar2 = (g) messageArr[i6];
                        if (!gVar2.isExpunged()) {
                            int w6 = gVar2.w();
                            if (aVar == null || aVar.a(gVar2)) {
                                if (w6 != w5 + 1) {
                                    i6--;
                                    break;
                                }
                                w5 = w6;
                            }
                        }
                    }
                    oVar.f39487b = w5;
                    vector.addElement(oVar);
                }
            }
            i6++;
        }
        if (vector.isEmpty()) {
            return null;
        }
        com.sun.mail.imap.protocol.o[] oVarArr = new com.sun.mail.imap.protocol.o[vector.size()];
        vector.copyInto(oVarArr);
        return oVarArr;
    }

    public static w[] b(Message[] messageArr) {
        Vector vector = new Vector(1);
        int i6 = 0;
        while (i6 < messageArr.length) {
            g gVar = (g) messageArr[i6];
            if (!gVar.isExpunged()) {
                long x5 = gVar.x();
                w wVar = new w();
                wVar.f39511a = x5;
                while (true) {
                    i6++;
                    if (i6 < messageArr.length) {
                        g gVar2 = (g) messageArr[i6];
                        if (!gVar2.isExpunged()) {
                            long x6 = gVar2.x();
                            if (x6 != 1 + x5) {
                                i6--;
                                break;
                            }
                            x5 = x6;
                        }
                    } else {
                        break;
                    }
                }
                wVar.f39512b = x5;
                vector.addElement(wVar);
            }
            i6++;
        }
        if (vector.isEmpty()) {
            return null;
        }
        w[] wVarArr = new w[vector.size()];
        vector.copyInto(wVarArr);
        return wVarArr;
    }

    private o() {
    }
}
