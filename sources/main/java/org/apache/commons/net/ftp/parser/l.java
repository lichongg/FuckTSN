package org.apache.commons.net.ftp.parser;

import androidx.exifinterface.media.ExifInterface;
import java.text.ParseException;
import org.apache.commons.net.ftp.FTPFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class l extends b {

    /* renamed from: g, reason: collision with root package name */
    private static final String f50769g = "MMM dd yyyy";

    /* renamed from: h, reason: collision with root package name */
    private static final String f50770h = "MMM dd HH:mm";

    /* renamed from: i, reason: collision with root package name */
    private static final String f50771i = "(d|-){1}\\s+\\[([-A-Z]+)\\]\\s+(\\S+)\\s+(\\d+)\\s+(\\S+\\s+\\S+\\s+((\\d+:\\d+)|(\\d{4})))\\s+(.*)";

    public l() {
        this(null);
    }

    public l(org.apache.commons.net.ftp.d dVar) {
        super(f50771i);
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
        String h9 = h(4);
        String h10 = h(5);
        String h11 = h(9);
        try {
            fTPFile.setTimestamp(super.m(h10));
        } catch (ParseException unused) {
        }
        if (h6.trim().equals("d")) {
            fTPFile.setType(1);
        } else {
            fTPFile.setType(0);
        }
        fTPFile.setUser(h8);
        fTPFile.setName(h11.trim());
        fTPFile.setSize(Long.parseLong(h9.trim()));
        if (h7.indexOf("R") != -1) {
            fTPFile.setPermission(0, 0, true);
        }
        if (h7.indexOf(ExifInterface.LONGITUDE_WEST) != -1) {
            fTPFile.setPermission(0, 1, true);
        }
        return fTPFile;
    }

    @Override // org.apache.commons.net.ftp.parser.b
    protected org.apache.commons.net.ftp.d l() {
        return new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50606r, f50769g, f50770h);
    }
}
