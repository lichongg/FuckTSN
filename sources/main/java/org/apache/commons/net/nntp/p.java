package org.apache.commons.net.nntp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class p {
    public o e(Iterable<? extends o> iterable) {
        if (iterable == null) {
            return null;
        }
        HashMap<String, n> hashMap = new HashMap<>();
        for (o oVar : iterable) {
            if (!oVar.f()) {
                a(oVar, hashMap);
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        n b6 = b(hashMap);
        hashMap.clear();
        d(b6);
        b6.c();
        c(b6);
        if (b6.f50953c != null) {
            throw new RuntimeException("root node has a next:" + b6);
        }
        for (n nVar = b6.f50954d; nVar != null; nVar = nVar.f50953c) {
            if (nVar.f50951a == null) {
                nVar.f50951a = nVar.f50954d.f50951a.b();
            }
        }
        n nVar2 = b6.f50954d;
        o oVar2 = nVar2 != null ? nVar2.f50951a : null;
        b6.b();
        return oVar2;
    }

    private n b(HashMap<String, n> hashMap) {
        n nVar = new n();
        Iterator<Map.Entry<String, n>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            n value = it.next().getValue();
            if (value.f50952b == null) {
                if (value.f50953c != null) {
                    throw new RuntimeException("c.next is " + value.f50953c.toString());
                }
                value.f50953c = nVar.f50954d;
                nVar.f50954d = value;
            }
        }
        return nVar;
    }

    private void c(n nVar) {
        n nVar2;
        o oVar;
        n nVar3;
        o oVar2;
        o oVar3;
        int i6 = 0;
        int i7 = 0;
        for (n nVar4 = nVar.f50954d; nVar4 != null; nVar4 = nVar4.f50953c) {
            i7++;
        }
        HashMap hashMap = new HashMap((int) (i7 * 1.2d), 0.9f);
        for (n nVar5 = nVar.f50954d; nVar5 != null; nVar5 = nVar5.f50953c) {
            o oVar4 = nVar5.f50951a;
            if (oVar4 == null) {
                oVar4 = nVar5.f50954d.f50951a;
            }
            String d6 = oVar4.d();
            if (d6 != null && d6.length() != 0 && ((nVar3 = (n) hashMap.get(d6)) == null || ((nVar5.f50951a == null && nVar3.f50951a != null) || ((oVar2 = nVar3.f50951a) != null && oVar2.e() && (oVar3 = nVar5.f50951a) != null && !oVar3.e())))) {
                hashMap.put(d6, nVar5);
                i6++;
            }
        }
        if (i6 == 0) {
            return;
        }
        n nVar6 = nVar.f50954d;
        n nVar7 = nVar6.f50953c;
        n nVar8 = null;
        while (nVar6 != null) {
            o oVar5 = nVar6.f50951a;
            if (oVar5 == null) {
                oVar5 = nVar6.f50954d.f50951a;
            }
            String d7 = oVar5.d();
            if (d7 == null || d7.length() == 0 || (nVar2 = (n) hashMap.get(d7)) == nVar6) {
                nVar8 = nVar6;
            } else {
                if (nVar8 == null) {
                    nVar.f50954d = nVar6.f50953c;
                } else {
                    nVar8.f50953c = nVar6.f50953c;
                }
                nVar6.f50953c = null;
                o oVar6 = nVar2.f50951a;
                if (oVar6 == null && nVar6.f50951a == null) {
                    n nVar9 = nVar2.f50954d;
                    while (nVar9 != null) {
                        n nVar10 = nVar9.f50953c;
                        if (nVar10 == null) {
                            break;
                        } else {
                            nVar9 = nVar10;
                        }
                    }
                    if (nVar9 != null) {
                        nVar9.f50953c = nVar6.f50954d;
                    }
                    for (n nVar11 = nVar6.f50954d; nVar11 != null; nVar11 = nVar11.f50953c) {
                        nVar11.f50952b = nVar2;
                    }
                    nVar6.f50954d = null;
                } else if (oVar6 == null || !((oVar = nVar6.f50951a) == null || !oVar.e() || nVar2.f50951a.e())) {
                    nVar6.f50952b = nVar2;
                    nVar6.f50953c = nVar2.f50954d;
                    nVar2.f50954d = nVar6;
                } else {
                    n nVar12 = new n();
                    nVar12.f50951a = nVar2.f50951a;
                    n nVar13 = nVar2.f50954d;
                    nVar12.f50954d = nVar13;
                    while (nVar13 != null) {
                        nVar13.f50952b = nVar12;
                        nVar13 = nVar13.f50953c;
                    }
                    nVar2.f50951a = null;
                    nVar6.f50952b = nVar2;
                    nVar12.f50952b = nVar2;
                    nVar2.f50954d = nVar6;
                    nVar6.f50953c = nVar12;
                }
            }
            n nVar14 = nVar7;
            nVar7 = nVar7 == null ? null : nVar7.f50953c;
            nVar6 = nVar14;
        }
        hashMap.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(org.apache.commons.net.nntp.n r8) {
        /*
            r7 = this;
            org.apache.commons.net.nntp.n r0 = r8.f50954d
            org.apache.commons.net.nntp.n r1 = r0.f50953c
            r2 = 0
            r3 = r2
        L6:
            if (r0 == 0) goto L57
            org.apache.commons.net.nntp.o r4 = r0.f50951a
            if (r4 != 0) goto L1d
            org.apache.commons.net.nntp.n r5 = r0.f50954d
            if (r5 != 0) goto L1d
            if (r3 != 0) goto L17
            org.apache.commons.net.nntp.n r0 = r0.f50953c
            r8.f50954d = r0
            goto L1b
        L17:
            org.apache.commons.net.nntp.n r0 = r0.f50953c
            r3.f50953c = r0
        L1b:
            r0 = r1
            goto L50
        L1d:
            if (r4 != 0) goto L47
            org.apache.commons.net.nntp.n r4 = r0.f50954d
            if (r4 == 0) goto L47
            org.apache.commons.net.nntp.n r5 = r0.f50952b
            if (r5 != 0) goto L2b
            org.apache.commons.net.nntp.n r5 = r4.f50953c
            if (r5 != 0) goto L47
        L2b:
            if (r3 != 0) goto L30
            r8.f50954d = r4
            goto L32
        L30:
            r3.f50953c = r4
        L32:
            r1 = r4
        L33:
            org.apache.commons.net.nntp.n r5 = r1.f50953c
            if (r5 == 0) goto L3d
            org.apache.commons.net.nntp.n r6 = r0.f50952b
            r1.f50952b = r6
            r1 = r5
            goto L33
        L3d:
            org.apache.commons.net.nntp.n r5 = r0.f50952b
            r1.f50952b = r5
            org.apache.commons.net.nntp.n r0 = r0.f50953c
            r1.f50953c = r0
            r0 = r4
            goto L50
        L47:
            org.apache.commons.net.nntp.n r3 = r0.f50954d
            if (r3 == 0) goto L4e
            r7.d(r0)
        L4e:
            r3 = r0
            goto L1b
        L50:
            if (r0 != 0) goto L54
            r1 = r2
            goto L6
        L54:
            org.apache.commons.net.nntp.n r1 = r0.f50953c
            goto L6
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.nntp.p.d(org.apache.commons.net.nntp.n):void");
    }

    @Deprecated
    public o g(o[] oVarArr) {
        if (oVarArr == null) {
            return null;
        }
        return f(Arrays.asList(oVarArr));
    }

    private void a(o oVar, HashMap<String, n> hashMap) {
        String a6 = oVar.a();
        n nVar = hashMap.get(a6);
        if (nVar != null) {
            if (nVar.f50951a != null) {
                a6 = "<Bogus-id:1>";
                nVar = null;
            } else {
                nVar.f50951a = oVar;
            }
        }
        if (nVar == null) {
            nVar = new n();
            nVar.f50951a = oVar;
            hashMap.put(a6, nVar);
        }
        String[] g6 = oVar.g();
        int length = g6.length;
        int i6 = 0;
        n nVar2 = null;
        while (i6 < length) {
            String str = g6[i6];
            n nVar3 = hashMap.get(str);
            if (nVar3 == null) {
                nVar3 = new n();
                hashMap.put(str, nVar3);
            }
            if (nVar2 != null && nVar3.f50952b == null && nVar2 != nVar3 && !nVar3.a(nVar2)) {
                nVar3.f50952b = nVar2;
                nVar3.f50953c = nVar2.f50954d;
                nVar2.f50954d = nVar3;
            }
            i6++;
            nVar2 = nVar3;
        }
        if (nVar2 != null && (nVar2 == nVar || nVar.a(nVar2))) {
            nVar2 = null;
        }
        n nVar4 = nVar.f50952b;
        if (nVar4 != null) {
            n nVar5 = nVar4.f50954d;
            n nVar6 = null;
            while (nVar5 != null && nVar5 != nVar) {
                nVar6 = nVar5;
                nVar5 = nVar5.f50953c;
            }
            if (nVar5 != null) {
                if (nVar6 == null) {
                    nVar.f50952b.f50954d = nVar.f50953c;
                } else {
                    nVar6.f50953c = nVar.f50953c;
                }
                nVar.f50953c = null;
                nVar.f50952b = null;
            } else {
                throw new RuntimeException("Didnt find " + nVar + " in parent" + nVar.f50952b);
            }
        }
        if (nVar2 != null) {
            nVar.f50952b = nVar2;
            nVar.f50953c = nVar2.f50954d;
            nVar2.f50954d = nVar;
        }
    }

    public o f(List<? extends o> list) {
        return e(list);
    }
}
