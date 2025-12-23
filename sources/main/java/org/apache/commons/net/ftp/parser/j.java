package org.apache.commons.net.ftp.parser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j extends b {

    /* renamed from: g, reason: collision with root package name */
    static final String f50762g = "MMM d yyyy";

    /* renamed from: h, reason: collision with root package name */
    static final String f50763h = "MMM d HH:mm";

    /* renamed from: i, reason: collision with root package name */
    private static final String f50764i = "([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s+((folder\\s+)|((\\d+)\\s+(\\d+)\\s+))(\\d+)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3}))\\s+(\\d+(?::\\d+)?)\\s+(\\S*)(\\s*.*)";

    public j() {
        this(null);
    }

    public j(org.apache.commons.net.ftp.d dVar) {
        super(f50764i);
        c(dVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:3|(2:4|5)|6|(14:8|(11:10|13|(3:15|(2:22|23)(2:19|20)|21)|24|25|(2:43|44)|27|28|29|(1:31)(2:34|(2:36|(1:38)(1:39))(1:40))|32)|49|12|13|(0)|24|25|(0)|27|28|29|(0)(0)|32)|50|12|13|(0)|24|25|(0)|27|28|29|(0)(0)|32) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // org.apache.commons.net.ftp.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.commons.net.ftp.FTPFile a(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.j.a(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    @Override // org.apache.commons.net.ftp.parser.b
    protected org.apache.commons.net.ftp.d l() {
        return new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50597i, "MMM d yyyy", "MMM d HH:mm");
    }
}
