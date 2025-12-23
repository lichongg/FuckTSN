package com.bytedance.sdk.component.xt.j;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.v0;
import master.flame.danmaku.danmaku.parser.b;
import okhttp3.internal.url._UrlKt;
import org.slf4j.Marker;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class ae {

    /* renamed from: r, reason: collision with root package name */
    private static final char[] f27256r = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final List<String> ae;
    final int cw;

    /* renamed from: g, reason: collision with root package name */
    private final String f27257g;

    /* renamed from: j, reason: collision with root package name */
    final String f27258j;

    /* renamed from: m, reason: collision with root package name */
    private final String f27259m;
    private final String oq;
    private final List<String> tl;
    private final String up;
    final String xt;

    public static final class j {
        List<String> ae;

        /* renamed from: j, reason: collision with root package name */
        String f27260j;

        /* renamed from: m, reason: collision with root package name */
        final List<String> f27261m;

        /* renamed from: r, reason: collision with root package name */
        String f27262r;
        String tl;
        String xt = "";
        String cw = "";
        int up = -1;

        /* renamed from: com.bytedance.sdk.component.xt.j.ae$j$j, reason: collision with other inner class name */
        enum EnumC0423j {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        private boolean m(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private boolean up(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public j cw(String str) {
            if (str != null) {
                return j(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public j j(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(b.f50154a)) {
                this.f27260j = b.f50154a;
                return this;
            }
            if (str.equalsIgnoreCase(b.f50155b)) {
                this.f27260j = b.f50155b;
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + str);
        }

        public j r(String str) {
            this.ae = str != null ? ae.xt(ae.j(str, _UrlKt.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public j xt(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String up = up(str, 0, str.length());
            if (up != null) {
                this.f27262r = up;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        private static String up(String str, int i6, int i7) {
            return com.bytedance.sdk.component.xt.j.xt.oq.j(ae.j(str, i6, i7, false));
        }

        public j query(String str) {
            this.ae = str != null ? ae.xt(ae.j(str, _UrlKt.QUERY_ENCODE_SET, false, false, true, true)) : null;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f27260j);
            sb.append("://");
            if (!this.xt.isEmpty() || !this.cw.isEmpty()) {
                sb.append(this.xt);
                if (!this.cw.isEmpty()) {
                    sb.append(':');
                    sb.append(this.cw);
                }
                sb.append('@');
            }
            if (this.f27262r.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f27262r);
                sb.append(']');
            } else {
                sb.append(this.f27262r);
            }
            int j6 = j();
            if (j6 != ae.j(this.f27260j)) {
                sb.append(':');
                sb.append(j6);
            }
            ae.j(sb, this.f27261m);
            if (this.ae != null) {
                sb.append('?');
                ae.xt(sb, this.ae);
            }
            if (this.tl != null) {
                sb.append('#');
                sb.append(this.tl);
            }
            return sb.toString();
        }

        public j() {
            ArrayList arrayList = new ArrayList();
            this.f27261m = arrayList;
            arrayList.add("");
        }

        private void cw() {
            if (this.f27261m.remove(r0.size() - 1).isEmpty() && !this.f27261m.isEmpty()) {
                this.f27261m.set(r0.size() - 1, "");
            } else {
                this.f27261m.add("");
            }
        }

        private static int r(String str, int i6, int i7) {
            while (i6 < i7) {
                char charAt = str.charAt(i6);
                if (charAt == ':') {
                    return i6;
                }
                if (charAt == '[') {
                    do {
                        i6++;
                        if (i6 < i7) {
                        }
                    } while (str.charAt(i6) != ']');
                }
                i6++;
            }
            return i7;
        }

        private static int m(String str, int i6, int i7) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(ae.j(str, i6, i7, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public ae xt() {
            if (this.f27260j != null) {
                if (this.f27262r != null) {
                    return new ae(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private static int cw(String str, int i6, int i7) {
            int i8 = 0;
            while (i6 < i7) {
                char charAt = str.charAt(i6);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i8++;
                i6++;
            }
            return i8;
        }

        int j() {
            int i6 = this.up;
            return i6 != -1 ? i6 : ae.j(this.f27260j);
        }

        private j j(String str, boolean z5) {
            int i6 = 0;
            while (true) {
                int j6 = com.bytedance.sdk.component.xt.j.xt.oq.j(str, i6, str.length(), "/\\");
                String str2 = str;
                boolean z6 = z5;
                j(str2, i6, j6, j6 < str.length(), z6);
                i6 = j6 + 1;
                if (i6 > str2.length()) {
                    return this;
                }
                str = str2;
                z5 = z6;
            }
        }

        private static int xt(String str, int i6, int i7) {
            if (i7 - i6 < 2) {
                return -1;
            }
            char charAt = str.charAt(i6);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i6++;
                    if (i6 >= i7) {
                        break;
                    }
                    char charAt2 = str.charAt(i6);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i6;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public j j(String str, String str2) {
            if (str != null) {
                if (this.ae == null) {
                    this.ae = new ArrayList();
                }
                this.ae.add(ae.j(str, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
                this.ae.add(str2 != null ? ae.j(str2, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        EnumC0423j j(ae aeVar, String str) {
            int j6;
            String str2;
            int i6;
            String str3;
            String str4 = str;
            int j7 = com.bytedance.sdk.component.xt.j.xt.oq.j(str4, 0, str4.length());
            int xt = com.bytedance.sdk.component.xt.j.xt.oq.xt(str4, j7, str4.length());
            if (xt(str4, j7, xt) != -1) {
                if (str4.regionMatches(true, j7, "https:", 0, 6)) {
                    this.f27260j = b.f50155b;
                    j7 += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (str4.regionMatches(true, j7, "http:", 0, 5)) {
                        this.f27260j = b.f50154a;
                        j7 += 5;
                    } else {
                        return EnumC0423j.UNSUPPORTED_SCHEME;
                    }
                }
            } else if (aeVar != null) {
                this.f27260j = aeVar.f27258j;
            } else {
                return EnumC0423j.MISSING_SCHEME;
            }
            int cw = cw(str4, j7, xt);
            char c6 = '#';
            if (cw < 2 && aeVar != null && aeVar.f27258j.equals(this.f27260j)) {
                this.xt = aeVar.xt();
                this.cw = aeVar.cw();
                this.f27262r = aeVar.xt;
                this.up = aeVar.cw;
                this.f27261m.clear();
                this.f27261m.addAll(aeVar.r());
                if (j7 == xt || str4.charAt(j7) == '#') {
                    r(aeVar.up());
                }
                str2 = str4;
            } else {
                int i7 = j7 + cw;
                boolean z5 = false;
                boolean z6 = false;
                while (true) {
                    j6 = com.bytedance.sdk.component.xt.j.xt.oq.j(str4, i7, xt, "@/\\?#");
                    char charAt = j6 != xt ? str4.charAt(j6) : (char) 65535;
                    if (charAt == 65535 || charAt == c6 || charAt == '/' || charAt == '\\' || charAt == '?') {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z5) {
                            int j8 = com.bytedance.sdk.component.xt.j.xt.oq.j(str4, i7, j6, ':');
                            String j9 = ae.j(str, i7, j8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z6) {
                                j9 = this.xt + "%40" + j9;
                            }
                            this.xt = j9;
                            if (j8 != j6) {
                                i6 = j6;
                                this.cw = ae.j(str, j8 + 1, i6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z5 = true;
                            } else {
                                i6 = j6;
                            }
                            str3 = str;
                            z6 = true;
                        } else {
                            i6 = j6;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.cw);
                            sb.append("%40");
                            str3 = str;
                            sb.append(ae.j(str3, i7, i6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                            this.cw = sb.toString();
                        }
                        i7 = i6 + 1;
                        str4 = str3;
                        c6 = '#';
                    }
                }
                str2 = str4;
                int i8 = i7;
                int r5 = r(str2, i8, j6);
                int i9 = r5 + 1;
                if (i9 < j6) {
                    this.f27262r = up(str2, i8, r5);
                    int m6 = m(str2, i9, j6);
                    this.up = m6;
                    if (m6 == -1) {
                        return EnumC0423j.INVALID_PORT;
                    }
                } else {
                    this.f27262r = up(str2, i8, r5);
                    this.up = ae.j(this.f27260j);
                }
                if (this.f27262r == null) {
                    return EnumC0423j.INVALID_HOST;
                }
                j7 = j6;
            }
            int j10 = com.bytedance.sdk.component.xt.j.xt.oq.j(str2, j7, xt, "?#");
            j(str2, j7, j10);
            if (j10 < xt && str2.charAt(j10) == '?') {
                int j11 = com.bytedance.sdk.component.xt.j.xt.oq.j(str2, j10, xt, '#');
                this.ae = ae.xt(ae.j(str2, j10 + 1, j11, _UrlKt.QUERY_ENCODE_SET, true, false, true, true, null));
                j10 = j11;
            }
            if (j10 < xt && str2.charAt(j10) == '#') {
                this.tl = ae.j(str2, j10 + 1, xt, "", true, false, false, false, null);
            }
            return EnumC0423j.SUCCESS;
        }

        private void j(String str, int i6, int i7) {
            if (i6 == i7) {
                return;
            }
            char charAt = str.charAt(i6);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.f27261m;
                list.set(list.size() - 1, "");
            } else {
                this.f27261m.clear();
                this.f27261m.add("");
                i6++;
            }
            int i8 = i6;
            while (i8 < i7) {
                int j6 = com.bytedance.sdk.component.xt.j.xt.oq.j(str, i8, i7, "/\\");
                boolean z5 = j6 < i7;
                String str2 = str;
                j(str2, i8, j6, z5, true);
                if (z5) {
                    j6++;
                }
                i8 = j6;
                str = str2;
            }
        }

        private void j(String str, int i6, int i7, boolean z5, boolean z6) {
            String j6 = ae.j(str, i6, i7, _UrlKt.PATH_SEGMENT_ENCODE_SET, z6, false, false, true, null);
            if (up(j6)) {
                return;
            }
            if (m(j6)) {
                cw();
                return;
            }
            if (this.f27261m.get(r11.size() - 1).isEmpty()) {
                this.f27261m.set(r11.size() - 1, j6);
            } else {
                this.f27261m.add(j6);
            }
            if (z5) {
                this.f27261m.add("");
            }
        }
    }

    public String cw() {
        if (this.f27259m.isEmpty()) {
            return "";
        }
        return this.oq.substring(this.oq.indexOf(58, this.f27258j.length() + 3) + 1, this.oq.indexOf(64));
    }

    public URL j() {
        try {
            return new URL(this.oq);
        } catch (MalformedURLException e6) {
            throw new RuntimeException(e6);
        }
    }

    public String xt() {
        if (this.up.isEmpty()) {
            return "";
        }
        int length = this.f27258j.length() + 3;
        String str = this.oq;
        return this.oq.substring(length, com.bytedance.sdk.component.xt.j.xt.oq.j(str, length, str.length(), ":@"));
    }

    public j ae() {
        j jVar = new j();
        jVar.f27260j = this.f27258j;
        jVar.xt = xt();
        jVar.cw = cw();
        jVar.f27262r = this.xt;
        jVar.up = this.cw != j(this.f27258j) ? this.cw : -1;
        jVar.f27261m.clear();
        jVar.f27261m.addAll(r());
        jVar.r(up());
        jVar.tl = m();
        return jVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ae) && ((ae) obj).oq.equals(this.oq);
    }

    public int hashCode() {
        return this.oq.hashCode();
    }

    public String m() {
        if (this.f27257g == null) {
            return null;
        }
        return this.oq.substring(this.oq.indexOf(35) + 1);
    }

    public String query() {
        if (this.tl == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        xt(sb, this.tl);
        return sb.toString();
    }

    public List<String> r() {
        int indexOf = this.oq.indexOf(47, this.f27258j.length() + 3);
        String str = this.oq;
        int j6 = com.bytedance.sdk.component.xt.j.xt.oq.j(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < j6) {
            int i6 = indexOf + 1;
            int j7 = com.bytedance.sdk.component.xt.j.xt.oq.j(this.oq, i6, j6, '/');
            arrayList.add(this.oq.substring(i6, j7));
            indexOf = j7;
        }
        return arrayList;
    }

    public String toString() {
        return this.oq;
    }

    public String up() {
        if (this.tl == null) {
            return null;
        }
        int indexOf = this.oq.indexOf(63) + 1;
        String str = this.oq;
        return this.oq.substring(indexOf, com.bytedance.sdk.component.xt.j.xt.oq.j(str, indexOf, str.length(), '#'));
    }

    ae(j jVar) {
        List<String> list;
        this.f27258j = jVar.f27260j;
        this.up = j(jVar.xt, false);
        this.f27259m = j(jVar.cw, false);
        this.xt = jVar.f27262r;
        this.cw = jVar.j();
        this.ae = j(jVar.f27261m, false);
        List<String> list2 = jVar.ae;
        if (list2 != null) {
            list = j(list2, true);
        } else {
            list = null;
        }
        this.tl = list;
        String str = jVar.tl;
        this.f27257g = str != null ? j(str, false) : null;
        this.oq = jVar.toString();
    }

    public static int j(String str) {
        if (str.equals(b.f50154a)) {
            return 80;
        }
        return str.equals(b.f50155b) ? 443 : -1;
    }

    public static ae cw(String str) {
        j jVar = new j();
        if (jVar.j((ae) null, str) == j.EnumC0423j.SUCCESS) {
            return jVar.xt();
        }
        return null;
    }

    static void j(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            sb.append('/');
            sb.append(list.get(i6));
        }
    }

    static void xt(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6 += 2) {
            String str = list.get(i6);
            String str2 = list.get(i6 + 1);
            if (i6 > 0) {
                sb.append(v0.f47960d);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static String j(String str, boolean z5) {
        return j(str, 0, str.length(), z5);
    }

    private List<String> j(List<String> list, boolean z5) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i6 = 0; i6 < size; i6++) {
            String str = list.get(i6);
            arrayList.add(str != null ? j(str, z5) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static List<String> xt(String str) {
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 <= str.length()) {
            int indexOf = str.indexOf(38, i6);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i6);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i6, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i6, indexOf));
                arrayList.add(null);
            }
            i6 = indexOf + 1;
        }
        return arrayList;
    }

    static String j(String str, int i6, int i7, boolean z5) {
        for (int i8 = i6; i8 < i7; i8++) {
            char charAt = str.charAt(i8);
            if (charAt == '%' || (charAt == '+' && z5)) {
                com.bytedance.sdk.component.xt.j.xt.j jVar = new com.bytedance.sdk.component.xt.j.xt.j();
                jVar.j(str, i6, i8);
                j(jVar, str, i8, i7, z5);
                return jVar.cw();
            }
        }
        return str.substring(i6, i7);
    }

    static void j(com.bytedance.sdk.component.xt.j.xt.j jVar, String str, int i6, int i7, boolean z5) {
        int i8;
        while (i6 < i7) {
            int codePointAt = str.codePointAt(i6);
            if (codePointAt == 37 && (i8 = i6 + 2) < i7) {
                int j6 = com.bytedance.sdk.component.xt.j.xt.oq.j(str.charAt(i6 + 1));
                int j7 = com.bytedance.sdk.component.xt.j.xt.oq.j(str.charAt(i8));
                if (j6 != -1 && j7 != -1) {
                    jVar.xt((j6 << 4) + j7);
                    i6 = i8;
                }
                jVar.j(codePointAt);
            } else {
                if (codePointAt == 43 && z5) {
                    jVar.xt(32);
                }
                jVar.j(codePointAt);
            }
            i6 += Character.charCount(codePointAt);
        }
    }

    static boolean j(String str, int i6, int i7) {
        int i8 = i6 + 2;
        return i8 < i7 && str.charAt(i6) == '%' && com.bytedance.sdk.component.xt.j.xt.oq.j(str.charAt(i6 + 1)) != -1 && com.bytedance.sdk.component.xt.j.xt.oq.j(str.charAt(i8)) != -1;
    }

    static String j(String str, int i6, int i7, String str2, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset) {
        int i8 = i6;
        while (i8 < i7) {
            int codePointAt = str.codePointAt(i8);
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z8) && str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z5 && (!z6 || j(str, i8, i7)))) && (codePointAt != 43 || !z7)))) {
                i8 += Character.charCount(codePointAt);
            } else {
                com.bytedance.sdk.component.xt.j.xt.j jVar = new com.bytedance.sdk.component.xt.j.xt.j();
                jVar.j(str, i6, i8);
                j(jVar, str, i8, i7, str2, z5, z6, z7, z8, charset);
                return jVar.cw();
            }
        }
        return str.substring(i6, i7);
    }

    static void j(com.bytedance.sdk.component.xt.j.xt.j jVar, String str, int i6, int i7, String str2, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset) {
        com.bytedance.sdk.component.xt.j.xt.j jVar2 = null;
        while (i6 < i7) {
            int codePointAt = str.codePointAt(i6);
            if (!z5 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z7) {
                    jVar.j(z5 ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z8) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z5 && (!z6 || j(str, i6, i7)))))) {
                    jVar.j(codePointAt);
                } else {
                    if (jVar2 == null) {
                        jVar2 = new com.bytedance.sdk.component.xt.j.xt.j();
                    }
                    if (charset != null && !charset.equals(com.bytedance.sdk.component.xt.j.xt.oq.f27325j)) {
                        jVar2.j(str, i6, Character.charCount(codePointAt) + i6, charset);
                    } else {
                        jVar2.j(codePointAt);
                    }
                    while (!jVar2.j()) {
                        byte xt = jVar2.xt();
                        jVar.xt(37);
                        char[] cArr = f27256r;
                        jVar.xt((int) cArr[((xt & 255) >> 4) & 15]);
                        jVar.xt((int) cArr[xt & 15]);
                    }
                }
            }
            i6 += Character.charCount(codePointAt);
        }
    }

    static String j(String str, String str2, boolean z5, boolean z6, boolean z7, boolean z8) {
        return j(str, 0, str.length(), str2, z5, z6, z7, z8, null);
    }
}
