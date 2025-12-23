package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f50420a = new String[0];

    /* renamed from: b, reason: collision with root package name */
    private static final String f50421b = "";

    public static String[] i(char c6) {
        return b(c6, h.f50440d);
    }

    public static String[] j(char c6) {
        return b(c6, h.f50442f);
    }

    public static String[] k(char c6) {
        return b(c6, h.f50439c);
    }

    public static String[] l(char c6) {
        return b(c6, h.f50441e);
    }

    private e() {
    }

    private static String[] a(char c6) {
        String[] d6 = d(c6);
        if (d6 != null) {
            String[] strArr = new String[d6.length];
            for (int i6 = 0; i6 < d6.length; i6++) {
                strArr[i6] = c.a(d6[i6]);
            }
            return strArr;
        }
        return f50420a;
    }

    private static String[] b(char c6, h hVar) {
        String[] d6 = d(c6);
        if (d6 != null) {
            String[] strArr = new String[d6.length];
            for (int i6 = 0; i6 < d6.length; i6++) {
                strArr[i6] = g.a(d6[i6], h.f50438b, hVar);
            }
            return strArr;
        }
        return f50420a;
    }

    private static String[] c(char c6, net.sourceforge.pinyin4j.format.b bVar) throws BadHanyuPinyinOutputFormatCombination {
        String[] d6 = d(c6);
        if (d6 != null) {
            for (int i6 = 0; i6 < d6.length; i6++) {
                d6[i6] = d.b(d6[i6], bVar);
            }
            return d6;
        }
        return f50420a;
    }

    private static String[] d(char c6) {
        return a.d().b(c6);
    }

    public static String[] e(char c6) {
        return a(c6);
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static java.lang.String f(java.lang.String r9, net.sourceforge.pinyin4j.format.b r10, java.lang.String r11, boolean r12) throws net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination {
        /*
            net.sourceforge.pinyin4j.a r0 = net.sourceforge.pinyin4j.a.d()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char[] r9 = r9.toCharArray()
            r2 = 0
            r3 = 0
        Lf:
            int r4 = r9.length
            if (r3 >= r4) goto L75
            char r4 = r9[r3]
            x4.b r5 = r0.e()
            r6 = 0
            r7 = r3
            r8 = r7
        L1b:
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            java.lang.String r4 = r4.toUpperCase()
            x4.b r4 = r5.a(r4)
            if (r4 == 0) goto L38
            java.lang.String r5 = r4.c()
            if (r5 == 0) goto L34
            java.lang.String r6 = r4.c()
            r8 = r7
        L34:
            x4.b r4 = r4.b()
        L38:
            r5 = r4
            int r7 = r7 + 1
            int r4 = r9.length
            if (r7 >= r4) goto L42
            char r4 = r9[r7]
            if (r5 != 0) goto L1b
        L42:
            if (r6 != 0) goto L4c
            if (r12 == 0) goto L72
            char r3 = r9[r3]
            r1.append(r3)
            goto L72
        L4c:
            java.lang.String[] r4 = r0.h(r6)
            if (r4 == 0) goto L72
            r5 = 0
        L53:
            int r6 = r4.length
            if (r5 >= r6) goto L72
            r6 = r4[r5]
            java.lang.String r6 = net.sourceforge.pinyin4j.d.b(r6, r10)
            r1.append(r6)
            int r6 = r9.length
            if (r7 < r6) goto L69
            int r6 = r4.length
            int r6 = r6 + (-1)
            if (r5 >= r6) goto L6c
            if (r3 == r8) goto L6c
        L69:
            r1.append(r11)
        L6c:
            if (r3 != r8) goto L6f
            goto L72
        L6f:
            int r5 = r5 + 1
            goto L53
        L72:
            int r3 = r8 + 1
            goto Lf
        L75:
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sourceforge.pinyin4j.e.f(java.lang.String, net.sourceforge.pinyin4j.format.b, java.lang.String, boolean):java.lang.String");
    }

    public static String[] g(char c6) {
        return d(c6);
    }

    public static String[] h(char c6, net.sourceforge.pinyin4j.format.b bVar) throws BadHanyuPinyinOutputFormatCombination {
        return c(c6, bVar);
    }
}
