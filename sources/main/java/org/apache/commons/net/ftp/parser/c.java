package org.apache.commons.net.ftp.parser;

import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f50732a = "\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*";

    /* renamed from: b, reason: collision with root package name */
    private static final String f50733b = "(\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*\\.)+\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*";

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f50734c = Pattern.compile(f50733b);

    public org.apache.commons.net.ftp.f e() {
        return f(null);
    }

    public org.apache.commons.net.ftp.f i() {
        return j(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.commons.net.ftp.f c(java.lang.String r5, org.apache.commons.net.ftp.d r6) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.c.c(java.lang.String, org.apache.commons.net.ftp.d):org.apache.commons.net.ftp.f");
    }

    private org.apache.commons.net.ftp.f f(org.apache.commons.net.ftp.d dVar) {
        if (dVar != null && org.apache.commons.net.ftp.d.f50600l.equals(dVar.e())) {
            return new k(dVar);
        }
        org.apache.commons.net.ftp.d dVar2 = dVar != null ? new org.apache.commons.net.ftp.d(dVar) : null;
        return new a(new org.apache.commons.net.ftp.f[]{new k(dVar), new p(dVar2, dVar2 != null && org.apache.commons.net.ftp.d.f50598j.equals(dVar2.e()))});
    }

    private org.apache.commons.net.ftp.f j(org.apache.commons.net.ftp.d dVar) {
        if (dVar != null && org.apache.commons.net.ftp.d.f50602n.equals(dVar.e())) {
            return new n(dVar);
        }
        org.apache.commons.net.ftp.d dVar2 = dVar != null ? new org.apache.commons.net.ftp.d(dVar) : null;
        return new a(new org.apache.commons.net.ftp.f[]{new n(dVar), new p(dVar2, dVar2 != null && org.apache.commons.net.ftp.d.f50598j.equals(dVar2.e()))});
    }

    @Override // org.apache.commons.net.ftp.parser.e
    public org.apache.commons.net.ftp.f a(String str) {
        if (str != null) {
            return c(str, null);
        }
        throw new ParserInitializationException("Parser key cannot be null");
    }

    public org.apache.commons.net.ftp.f d() {
        return new i();
    }

    public org.apache.commons.net.ftp.f g() {
        return new l();
    }

    public org.apache.commons.net.ftp.f h() {
        return new m();
    }

    public org.apache.commons.net.ftp.f k() {
        return new p();
    }

    public org.apache.commons.net.ftp.f l() {
        return new r();
    }

    @Override // org.apache.commons.net.ftp.parser.e
    public org.apache.commons.net.ftp.f b(org.apache.commons.net.ftp.d dVar) throws ParserInitializationException {
        return c(dVar.e(), dVar);
    }
}
