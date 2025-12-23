package org.apache.commons.net.ftp.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.StringTokenizer;
import org.apache.commons.net.ftp.FTPFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class q extends b {

    /* renamed from: g, reason: collision with root package name */
    private static final String f50790g = "d-MMM-yyyy HH:mm:ss";

    /* renamed from: h, reason: collision with root package name */
    private static final String f50791h = "(.*?;[0-9]+)\\s*(\\d+)/\\d+\\s*(\\S+)\\s+(\\S+)\\s+\\[(([0-9$A-Za-z_]+)|([0-9$A-Za-z_]+),([0-9$a-zA-Z_]+))\\]?\\s*\\([a-zA-Z]*,([a-zA-Z]*),([a-zA-Z]*),([a-zA-Z]*)\\)";

    public q() {
        this(null);
    }

    protected boolean n() {
        return false;
    }

    public q(org.apache.commons.net.ftp.d dVar) {
        super(f50791h);
        c(dVar);
    }

    @Override // org.apache.commons.net.ftp.f
    public FTPFile a(String str) {
        String nextToken;
        String str2 = null;
        if (!i(str)) {
            return null;
        }
        FTPFile fTPFile = new FTPFile();
        fTPFile.setRawListing(str);
        String h6 = h(1);
        String h7 = h(2);
        String str3 = h(3) + " " + h(4);
        String h8 = h(5);
        String[] strArr = {h(9), h(10), h(11)};
        try {
            fTPFile.setTimestamp(super.m(str3));
        } catch (ParseException unused) {
        }
        StringTokenizer stringTokenizer = new StringTokenizer(h8, ",");
        int countTokens = stringTokenizer.countTokens();
        if (countTokens == 1) {
            nextToken = stringTokenizer.nextToken();
        } else if (countTokens != 2) {
            nextToken = null;
        } else {
            str2 = stringTokenizer.nextToken();
            nextToken = stringTokenizer.nextToken();
        }
        if (h6.lastIndexOf(".DIR") != -1) {
            fTPFile.setType(1);
        } else {
            fTPFile.setType(0);
        }
        if (n()) {
            fTPFile.setName(h6);
        } else {
            fTPFile.setName(h6.substring(0, h6.lastIndexOf(";")));
        }
        fTPFile.setSize(Long.parseLong(h7) * 512);
        fTPFile.setGroup(str2);
        fTPFile.setUser(nextToken);
        for (int i6 = 0; i6 < 3; i6++) {
            String str4 = strArr[i6];
            fTPFile.setPermission(i6, 0, str4.indexOf(82) >= 0);
            fTPFile.setPermission(i6, 1, str4.indexOf(87) >= 0);
            fTPFile.setPermission(i6, 2, str4.indexOf(69) >= 0);
        }
        return fTPFile;
    }

    @Override // org.apache.commons.net.ftp.parser.b
    protected org.apache.commons.net.ftp.d l() {
        return new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50599k, f50790g, null);
    }

    @Deprecated
    public FTPFile[] o(InputStream inputStream) throws IOException {
        org.apache.commons.net.ftp.k kVar = new org.apache.commons.net.ftp.k(this);
        kVar.h(inputStream, null);
        return kVar.a();
    }

    @Override // org.apache.commons.net.ftp.g, org.apache.commons.net.ftp.f
    public String b(BufferedReader bufferedReader) throws IOException {
        String readLine = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();
        while (readLine != null) {
            if (!readLine.startsWith("Directory") && !readLine.startsWith("Total")) {
                sb.append(readLine);
                if (readLine.trim().endsWith(")")) {
                    break;
                }
                readLine = bufferedReader.readLine();
            } else {
                readLine = bufferedReader.readLine();
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }
}
