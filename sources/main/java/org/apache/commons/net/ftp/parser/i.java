package org.apache.commons.net.ftp.parser;

import com.umeng.socialize.net.dplus.db.DBConfig;
import java.text.ParseException;
import java.util.List;
import org.apache.commons.net.ftp.FTPFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i extends b {

    /* renamed from: i, reason: collision with root package name */
    static final int f50749i = -1;

    /* renamed from: j, reason: collision with root package name */
    static final int f50750j = 0;

    /* renamed from: k, reason: collision with root package name */
    static final int f50751k = 1;

    /* renamed from: l, reason: collision with root package name */
    static final int f50752l = 2;

    /* renamed from: m, reason: collision with root package name */
    static final int f50753m = 3;

    /* renamed from: n, reason: collision with root package name */
    static final int f50754n = 4;

    /* renamed from: o, reason: collision with root package name */
    static final String f50755o = "yyyy/MM/dd HH:mm";

    /* renamed from: p, reason: collision with root package name */
    static final String f50756p = "\\S+\\s+\\S+\\s+\\S+\\s+\\S+\\s+\\S+\\s+[FV]\\S*\\s+\\S+\\s+\\S+\\s+(PS|PO|PO-E)\\s+(\\S+)\\s*";

    /* renamed from: q, reason: collision with root package name */
    static final String f50757q = "(\\S+)\\s+\\S+\\s+\\S+\\s+(\\S+)\\s+(\\S+)\\s+\\S+\\s+\\S+\\s+\\S+\\s+\\S+\\s*";

    /* renamed from: r, reason: collision with root package name */
    static final String f50758r = "(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s*";

    /* renamed from: s, reason: collision with root package name */
    static final String f50759s = "(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+).*";

    /* renamed from: g, reason: collision with root package name */
    private int f50760g;

    /* renamed from: h, reason: collision with root package name */
    private p f50761h;

    private boolean r(FTPFile fTPFile, String str) {
        if (str == null || str.trim().length() <= 0) {
            return false;
        }
        fTPFile.setRawListing(str);
        fTPFile.setName(str.split(" ")[0]);
        fTPFile.setType(0);
        return true;
    }

    public i() {
        super("");
        this.f50760g = -1;
        super.c(null);
    }

    private boolean s(FTPFile fTPFile, String str) {
        return this.f50761h.a(str) != null;
    }

    @Override // org.apache.commons.net.ftp.f
    public FTPFile a(String str) {
        boolean s5;
        FTPFile fTPFile = new FTPFile();
        int i6 = this.f50760g;
        if (i6 == 0) {
            s5 = n(fTPFile, str);
        } else if (i6 == 1) {
            boolean q5 = q(fTPFile, str);
            s5 = !q5 ? r(fTPFile, str) : q5;
        } else {
            s5 = i6 == 2 ? s(fTPFile, str) : i6 == 3 ? o(fTPFile, str) : i6 == 4 ? p(fTPFile, str) : false;
        }
        if (s5) {
            return fTPFile;
        }
        return null;
    }

    @Override // org.apache.commons.net.ftp.g, org.apache.commons.net.ftp.f
    public List<String> d(List<String> list) {
        if (list != null && list.size() > 0) {
            String str = list.get(0);
            if (str.indexOf("Volume") >= 0 && str.indexOf("Dsname") >= 0) {
                t(0);
                super.j(f50756p);
            } else if (str.indexOf("Name") >= 0 && str.indexOf(DBConfig.ID) >= 0) {
                t(1);
                super.j(f50757q);
            } else if (str.indexOf("total") == 0) {
                t(2);
                this.f50761h = new p();
            } else if (str.indexOf("Spool Files") >= 30) {
                t(3);
                super.j(f50758r);
            } else if (str.indexOf("JOBNAME") != 0 || str.indexOf("JOBID") <= 8) {
                t(-1);
            } else {
                t(4);
                super.j(f50759s);
            }
            if (this.f50760g != 3) {
                list.remove(0);
            }
        }
        return list;
    }

    @Override // org.apache.commons.net.ftp.parser.b
    protected org.apache.commons.net.ftp.d l() {
        return new org.apache.commons.net.ftp.d(org.apache.commons.net.ftp.d.f50604p, f50755o, null);
    }

    void t(int i6) {
        this.f50760g = i6;
    }

    private boolean n(FTPFile fTPFile, String str) {
        if (!i(str)) {
            return false;
        }
        fTPFile.setRawListing(str);
        String h6 = h(2);
        String h7 = h(1);
        fTPFile.setName(h6);
        if ("PS".equals(h7)) {
            fTPFile.setType(0);
        } else {
            if (!"PO".equals(h7) && !"PO-E".equals(h7)) {
                return false;
            }
            fTPFile.setType(1);
        }
        return true;
    }

    private boolean o(FTPFile fTPFile, String str) {
        if (!i(str) || !h(3).equalsIgnoreCase("OUTPUT")) {
            return false;
        }
        fTPFile.setRawListing(str);
        fTPFile.setName(h(2));
        fTPFile.setType(0);
        return true;
    }

    private boolean p(FTPFile fTPFile, String str) {
        if (!i(str) || !h(4).equalsIgnoreCase("OUTPUT")) {
            return false;
        }
        fTPFile.setRawListing(str);
        fTPFile.setName(h(2));
        fTPFile.setType(0);
        return true;
    }

    private boolean q(FTPFile fTPFile, String str) {
        if (i(str)) {
            fTPFile.setRawListing(str);
            String h6 = h(1);
            String str2 = h(2) + " " + h(3);
            fTPFile.setName(h6);
            fTPFile.setType(0);
            try {
                fTPFile.setTimestamp(super.m(str2));
                return true;
            } catch (ParseException e6) {
                e6.printStackTrace();
            }
        }
        return false;
    }
}
