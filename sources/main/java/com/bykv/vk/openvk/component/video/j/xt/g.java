package com.bykv.vk.openvk.component.video.j.xt;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g {
    public final j cw;

    /* renamed from: j, reason: collision with root package name */
    public final cw f23046j;
    public final List<xt> xt;

    static final class cw {
        final String cw;

        /* renamed from: j, reason: collision with root package name */
        final String f23047j;
        final String xt;

        static cw j(String str) throws r {
            int indexOf = str.indexOf(32);
            if (indexOf == -1) {
                throw new r("request line format error, line: ".concat(str));
            }
            int lastIndexOf = str.lastIndexOf(32);
            if (lastIndexOf <= indexOf) {
                throw new r("request line format error, line: ".concat(str));
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
            String trim3 = str.substring(lastIndexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0 || trim3.length() == 0) {
                throw new r("request line format error, line: ".concat(str));
            }
            return new cw(trim, trim2, trim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.f23047j + "', path='" + this.xt + "', version='" + this.cw + "'}";
        }

        private cw(String str, String str2, String str3) {
            this.f23047j = str;
            this.xt = str2;
            this.cw = str3;
        }
    }

    static final class j {
        final List<String> ae;
        final String cw;

        /* renamed from: j, reason: collision with root package name */
        final int f23048j;

        /* renamed from: m, reason: collision with root package name */
        final String f23049m;

        /* renamed from: r, reason: collision with root package name */
        final int f23050r;
        final int up;
        final String xt;

        static j j(cw cwVar, List<xt> list) throws r {
            String str;
            int i6;
            int i7;
            int indexOf = cwVar.xt.indexOf("?");
            if (indexOf == -1) {
                throw new r("path format error, path: " + cwVar.xt);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int i8 = 0;
            for (String str5 : cwVar.xt.substring(indexOf + 1).split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str5.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    if ("rk".equals(split[0])) {
                        str2 = Uri.decode(split[1]);
                    } else if ("k".equals(split[0])) {
                        str3 = Uri.decode(split[1]);
                    } else if (split[0].startsWith("u")) {
                        arrayList.add(Uri.decode(split[1]));
                    } else if ("f".equals(split[0]) && com.bykv.vk.openvk.component.video.j.cw.j.xt(split[1]) == 1) {
                        i8 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new r("rawKey or key is empty, path: " + cwVar.xt);
            }
            if (list != null) {
                int i9 = 0;
                int i10 = 0;
                for (xt xtVar : list) {
                    if (xtVar != null && "Range".equalsIgnoreCase(xtVar.f23051j)) {
                        int indexOf2 = xtVar.xt.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (indexOf2 == -1) {
                            throw new r("Range format error, Range: " + xtVar.xt);
                        }
                        if (!"bytes".equalsIgnoreCase(xtVar.xt.substring(0, indexOf2).trim())) {
                            throw new r("Range format error, Range: " + xtVar.xt);
                        }
                        String substring = xtVar.xt.substring(indexOf2 + 1);
                        if (substring.contains(",")) {
                            throw new r("Range format error, Range: " + xtVar.xt);
                        }
                        int indexOf3 = substring.indexOf("-");
                        if (indexOf3 == -1) {
                            throw new r("Range format error, Range: " + xtVar.xt);
                        }
                        String trim = substring.substring(0, indexOf3).trim();
                        String trim2 = substring.substring(indexOf3 + 1).trim();
                        try {
                            if (trim.length() > 0) {
                                i9 = Integer.parseInt(trim);
                            }
                            if (trim2.length() > 0 && i9 > (i10 = Integer.parseInt(trim2))) {
                                throw new r("Range format error, Range: " + xtVar.xt);
                            }
                            str4 = xtVar.xt;
                        } catch (NumberFormatException unused) {
                            throw new r("Range format error, Range: " + xtVar.xt);
                        }
                    }
                }
                i6 = i9;
                str = str4;
                i7 = i10;
            } else {
                str = null;
                i6 = 0;
                i7 = 0;
            }
            if (!arrayList.isEmpty()) {
                return new j(i8, str2, str3, i6, i7, str, arrayList);
            }
            throw new r("no url found: path: " + cwVar.xt);
        }

        public String toString() {
            return "Extra{flag=" + this.f23048j + ", rawKey='" + this.xt + "', key='" + this.cw + "', from=" + this.f23050r + ", to=" + this.up + ", urls=" + this.ae + '}';
        }

        private j(int i6, String str, String str2, int i7, int i8, String str3, List<String> list) {
            this.f23048j = i6;
            this.xt = str;
            this.cw = str2;
            this.f23050r = i7;
            this.up = i8;
            this.f23049m = str3;
            this.ae = list;
        }
    }

    public static final class xt {

        /* renamed from: j, reason: collision with root package name */
        public final String f23051j;
        public final String xt;

        static xt j(String str) throws r {
            int indexOf = str.indexOf(":");
            if (indexOf == -1) {
                throw new r("request header format error, header: ".concat(str));
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0) {
                throw new r("request header format error, header: ".concat(str));
            }
            return new xt(trim, trim2);
        }

        public String toString() {
            return "Header{name='" + this.f23051j + "', value='" + this.xt + "'}";
        }

        public xt(String str, String str2) {
            this.f23051j = str;
            this.xt = str2;
        }
    }

    public static g j(InputStream inputStream) throws IOException, r {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bykv.vk.openvk.component.video.j.cw.j.f22978j));
        ArrayList arrayList = new ArrayList();
        cw cwVar = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                break;
            }
            String trim = readLine.trim();
            if (cwVar == null) {
                cwVar = cw.j(trim);
            } else {
                arrayList.add(xt.j(trim));
            }
        }
        if (cwVar != null) {
            return new g(cwVar, arrayList, j.j(cwVar, arrayList));
        }
        throw new r("request line is null");
    }

    static final class r extends Exception {
        r(String str) {
            super(str);
        }
    }

    public String toString() {
        return "Request{requestLine=" + this.f23046j + ", headers=" + this.xt + ", extra=" + this.cw + '}';
    }

    public g(cw cwVar, List<xt> list, j jVar) {
        this.f23046j = cwVar;
        this.xt = list;
        this.cw = jVar;
    }

    static String j(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String str3 = null;
        do {
            if (str3 != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            str3 = j(sb, str, str2, list);
        } while (str3.length() > 3072);
        return str3;
    }

    private static String j(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk=");
        sb.append(Uri.encode(str));
        sb.append("&k=");
        sb.append(Uri.encode(str2));
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            sb.append("&u");
            sb.append(i6);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(Uri.encode(list.get(i6)));
        }
        return sb.toString();
    }
}
