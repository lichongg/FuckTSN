package com.bytedance.sdk.component.cw.xt;

import android.text.TextUtils;
import com.snail.antifake.deviceid.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class w {

    /* renamed from: j, reason: collision with root package name */
    public final String[] f26409j;

    public static final class j {

        /* renamed from: j, reason: collision with root package name */
        final List<String> f26410j = new ArrayList(20);

        j j(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? xt(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? xt("", str.substring(1)) : xt("", str);
        }

        j xt(String str, String str2) {
            this.f26410j.add(str);
            this.f26410j.add(str2.trim());
            return this;
        }

        private void r(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = str.charAt(i6);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.cw.xt.j.cw.j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i6), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i7 = 0; i7 < length2; i7++) {
                char charAt2 = str2.charAt(i7);
                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.cw.xt.j.cw.j("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i7), str, str2));
                }
            }
        }

        public j cw(String str, String str2) {
            try {
                r(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i6 = 0; i6 < length; i6++) {
                            char charAt = str2.charAt(i6);
                            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                            } else {
                                sb.append(charAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                        return this;
                    }
                }
                return this;
            }
            xt(str);
            xt(str, str2);
            return this;
        }

        public j xt(String str) {
            int i6 = 0;
            while (i6 < this.f26410j.size()) {
                if (str.equalsIgnoreCase(this.f26410j.get(i6))) {
                    this.f26410j.remove(i6);
                    this.f26410j.remove(i6);
                    i6 -= 2;
                }
                i6 += 2;
            }
            return this;
        }

        public j j(String str, String str2) {
            try {
                r(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i6 = 0; i6 < length; i6++) {
                            char charAt = str2.charAt(i6);
                            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                            } else {
                                sb.append(charAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                        return this;
                    }
                }
                return this;
            }
            return xt(str, str2);
        }

        public w j() {
            return new w(this);
        }
    }

    w(j jVar) {
        List<String> list = jVar.f26410j;
        this.f26409j = (String[]) list.toArray(new String[list.size()]);
    }

    public String j(String str) {
        return j(this.f26409j, str);
    }

    public String xt(int i6) {
        return this.f26409j[(i6 * 2) + 1];
    }

    public Map<String, List<String>> cw() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int j6 = j();
        for (int i6 = 0; i6 < j6; i6++) {
            String lowerCase = j(i6).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(xt(i6));
        }
        return treeMap;
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && Arrays.equals(((w) obj).f26409j, this.f26409j);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f26409j);
    }

    public int j() {
        return this.f26409j.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int j6 = j();
        for (int i6 = 0; i6 < j6; i6++) {
            sb.append(j(i6));
            sb.append(": ");
            sb.append(xt(i6));
            sb.append(e.f37542d);
        }
        return sb.toString();
    }

    public List<String> xt(String str) {
        int j6 = j();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < j6; i6++) {
            if (str.equalsIgnoreCase(j(i6))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(xt(i6));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    private w(String[] strArr) {
        this.f26409j = strArr;
    }

    public String j(int i6) {
        return this.f26409j[i6 * 2];
    }

    private static String j(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static w j(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i6 = 0; i6 < strArr2.length; i6++) {
                    String str = strArr2[i6];
                    if (str != null) {
                        strArr2[i6] = str.trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i7 = 0; i7 < strArr2.length; i7 += 2) {
                    String str2 = strArr2[i7];
                    String str3 = strArr2[i7 + 1];
                    if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                        throw new IllegalArgumentException("Unexpected header: " + str2 + ": " + str3);
                    }
                }
                return new w(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    public j xt() {
        j jVar = new j();
        Collections.addAll(jVar.f26410j, this.f26409j);
        return jVar;
    }
}
