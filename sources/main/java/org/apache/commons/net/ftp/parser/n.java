package org.apache.commons.net.ftp.parser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class n extends b {

    /* renamed from: g, reason: collision with root package name */
    private static final String f50774g = "yy/MM/dd HH:mm:ss";

    /* renamed from: h, reason: collision with root package name */
    private static final String f50775h = "(\\S+)\\s+(?:(\\d+)\\s+)?(?:(\\S+)\\s+(\\S+)\\s+)?(\\*STMF|\\*DIR|\\*FILE|\\*MEM)\\s+(?:(\\S+)\\s*)?";

    public n() {
        this(null);
    }

    public n(org.apache.commons.net.ftp.d dVar) {
        super(f50775h);
        c(dVar);
    }

    private boolean n(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:3|(1:64)(1:7)|8|(2:9|10)|11|(2:13|(1:34)(1:17))(10:35|(2:37|(1:42)(1:41))(3:43|(1:(1:49))(2:50|(2:52|(1:59)(1:60))(1:61))|48)|19|20|21|22|(1:24)|(1:28)|29|30)|18|19|20|21|22|(0)|(2:26|28)|29|30) */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ec  */
    @Override // org.apache.commons.net.ftp.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.commons.net.ftp.FTPFile a(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.n.a(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    @Override // org.apache.commons.net.ftp.parser.b
    protected org.apache.commons.net.ftp.d l() {
        return new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50602n, f50774g, null);
    }
}
