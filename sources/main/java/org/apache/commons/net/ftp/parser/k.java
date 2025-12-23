package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import org.apache.commons.net.ftp.FTPFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class k extends b {

    /* renamed from: h, reason: collision with root package name */
    private static final String f50765h = "MM-dd-yy hh:mma";

    /* renamed from: i, reason: collision with root package name */
    private static final String f50766i = "MM-dd-yy kk:mm";

    /* renamed from: j, reason: collision with root package name */
    private static final String f50767j = "(\\S+)\\s+(\\S+)\\s+(?:(<DIR>)|([0-9]+))\\s+(\\S.*)";

    /* renamed from: g, reason: collision with root package name */
    private final f f50768g;

    public k() {
        this(null);
    }

    public k(org.apache.commons.net.ftp.d dVar) {
        super(f50767j, 32);
        c(dVar);
        org.apache.commons.net.ftp.d dVar2 = new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50600l, f50766i, null);
        dVar2.l(f50766i);
        g gVar = new g();
        this.f50768g = gVar;
        gVar.c(dVar2);
    }

    @Override // org.apache.commons.net.ftp.f
    public FTPFile a(String str) {
        FTPFile fTPFile = new FTPFile();
        fTPFile.setRawListing(str);
        if (i(str)) {
            String str2 = h(1) + " " + h(2);
            String h6 = h(3);
            String h7 = h(4);
            String h8 = h(5);
            try {
                try {
                    fTPFile.setTimestamp(super.m(str2));
                } catch (ParseException unused) {
                }
            } catch (ParseException unused2) {
                fTPFile.setTimestamp(this.f50768g.a(str2));
            }
            if (h8 != null && !h8.equals(".") && !h8.equals("..")) {
                fTPFile.setName(h8);
                if ("<DIR>".equals(h6)) {
                    fTPFile.setType(1);
                    fTPFile.setSize(0L);
                } else {
                    fTPFile.setType(0);
                    if (h7 != null) {
                        fTPFile.setSize(Long.parseLong(h7));
                    }
                }
                return fTPFile;
            }
        }
        return null;
    }

    @Override // org.apache.commons.net.ftp.parser.b
    public org.apache.commons.net.ftp.d l() {
        return new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50600l, f50765h, null);
    }
}
