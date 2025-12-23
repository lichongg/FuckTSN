package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import org.apache.commons.net.ftp.FTPFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class m extends b {

    /* renamed from: g, reason: collision with root package name */
    private static final String f50772g = "MM-dd-yy HH:mm";

    /* renamed from: h, reason: collision with root package name */
    private static final String f50773h = "\\s*([0-9]+)\\s*(\\s+|[A-Z]+)\\s*(DIR|\\s+)\\s*(\\S+)\\s+(\\S+)\\s+(\\S.*)";

    public m() {
        this(null);
    }

    public m(org.apache.commons.net.ftp.d dVar) {
        super(f50773h);
        c(dVar);
    }

    @Override // org.apache.commons.net.ftp.f
    public FTPFile a(String str) {
        FTPFile fTPFile = new FTPFile();
        if (!i(str)) {
            return null;
        }
        String h6 = h(1);
        String h7 = h(2);
        String h8 = h(3);
        String str2 = h(4) + " " + h(5);
        String h9 = h(6);
        try {
            fTPFile.setTimestamp(super.m(str2));
        } catch (ParseException unused) {
        }
        if (h8.trim().equals("DIR") || h7.trim().equals("DIR")) {
            fTPFile.setType(1);
        } else {
            fTPFile.setType(0);
        }
        fTPFile.setName(h9.trim());
        fTPFile.setSize(Long.parseLong(h6.trim()));
        return fTPFile;
    }

    @Override // org.apache.commons.net.ftp.parser.b
    protected org.apache.commons.net.ftp.d l() {
        return new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50601m, f50772g, null);
    }
}
