package org.apache.commons.net.ftp.parser;

import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class p extends b {

    /* renamed from: h, reason: collision with root package name */
    static final String f50779h = "MMM d yyyy";

    /* renamed from: i, reason: collision with root package name */
    static final String f50780i = "MMM d HH:mm";

    /* renamed from: k, reason: collision with root package name */
    private static final String f50782k = "月";

    /* renamed from: l, reason: collision with root package name */
    private static final String f50783l = "日";

    /* renamed from: m, reason: collision with root package name */
    private static final String f50784m = "年";

    /* renamed from: n, reason: collision with root package name */
    private static final String f50785n = "M'月' d'日' yyyy'年'";

    /* renamed from: o, reason: collision with root package name */
    private static final String f50786o = "M'月' d'日' HH:mm";

    /* renamed from: q, reason: collision with root package name */
    private static final String f50788q = "([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s*(\\d+)\\s+(?:(\\S+(?:\\s\\S+)*?)\\s+)?(?:(\\S+(?:\\s\\S+)*)\\s+)?(\\d+(?:,\\s*\\d+)?)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3})|(?:\\d{1,2}月\\s+\\d{1,2}日))\\s+((?:\\d+(?::\\d+)?)|(?:\\d{4}年))\\s(.*)";

    /* renamed from: g, reason: collision with root package name */
    final boolean f50789g;

    /* renamed from: j, reason: collision with root package name */
    static final String f50781j = "yyyy-MM-dd HH:mm";

    /* renamed from: p, reason: collision with root package name */
    public static final org.apache.commons.net.ftp.d f50787p = new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50597i, f50781j, null);

    public p() {
        this(null);
    }

    public p(org.apache.commons.net.ftp.d dVar) {
        this(dVar, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:3|(1:5)|(3:6|7|(1:9)(1:52))|10|(14:12|(11:14|17|(3:19|(2:26|27)(2:23|24)|25)|28|29|(2:44|45)|31|32|33|(2:35|(1:37)(1:40))(1:41)|38)|50|16|17|(0)|28|29|(0)|31|32|33|(0)(0)|38)|51|16|17|(0)|28|29|(0)|31|32|33|(0)(0)|38) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // org.apache.commons.net.ftp.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.commons.net.ftp.FTPFile a(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.p.a(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    @Override // org.apache.commons.net.ftp.parser.b
    protected org.apache.commons.net.ftp.d l() {
        return new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50597i, "MMM d yyyy", "MMM d HH:mm");
    }

    public p(org.apache.commons.net.ftp.d dVar, boolean z5) {
        super(f50788q);
        c(dVar);
        this.f50789g = z5;
    }

    @Override // org.apache.commons.net.ftp.g, org.apache.commons.net.ftp.f
    public List<String> d(List<String> list) {
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().matches("^total \\d+$")) {
                listIterator.remove();
            }
        }
        return list;
    }
}
