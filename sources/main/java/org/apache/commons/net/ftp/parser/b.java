package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import java.util.Calendar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class b extends o implements org.apache.commons.net.ftp.a {

    /* renamed from: f, reason: collision with root package name */
    private final f f50731f;

    public b(String str) {
        super(str);
        this.f50731f = new g();
    }

    protected abstract org.apache.commons.net.ftp.d l();

    @Override // org.apache.commons.net.ftp.a
    public void c(org.apache.commons.net.ftp.d dVar) {
        if (this.f50731f instanceof org.apache.commons.net.ftp.a) {
            org.apache.commons.net.ftp.d l6 = l();
            if (dVar == null) {
                ((org.apache.commons.net.ftp.a) this.f50731f).c(l6);
                return;
            }
            if (dVar.b() == null) {
                dVar.l(l6.b());
            }
            if (dVar.c() == null) {
                dVar.n(l6.c());
            }
            ((org.apache.commons.net.ftp.a) this.f50731f).c(dVar);
        }
    }

    public Calendar m(String str) throws ParseException {
        return this.f50731f.a(str);
    }

    public b(String str, int i6) {
        super(str, i6);
        this.f50731f = new g();
    }
}
