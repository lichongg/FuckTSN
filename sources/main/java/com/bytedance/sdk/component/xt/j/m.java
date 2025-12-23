package com.bytedance.sdk.component.xt.j;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class m {

    /* renamed from: j, reason: collision with root package name */
    private final String[] f27297j;

    public static final class j {

        /* renamed from: j, reason: collision with root package name */
        final List<String> f27298j = new ArrayList(20);

        public m j() {
            return new m(this);
        }

        private void cw(String str, String str2) {
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
                    throw new IllegalArgumentException(com.bytedance.sdk.component.xt.j.xt.oq.j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i6), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i7 = 0; i7 < length2; i7++) {
                char charAt2 = str2.charAt(i7);
                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.xt.j.xt.oq.j("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i7), str, str2));
                }
            }
        }

        j j(String str, String str2) {
            this.f27298j.add(str);
            this.f27298j.add(str2.trim());
            return this;
        }

        public j xt(String str, String str2) {
            try {
                cw(str, str2);
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
            return j(str, str2);
        }
    }

    public m(String[] strArr) {
        this.f27297j = strArr;
    }

    public int j() {
        return this.f27297j.length / 2;
    }

    public String xt(int i6) {
        return this.f27297j[(i6 * 2) + 1];
    }

    public String j(int i6) {
        return this.f27297j[i6 * 2];
    }

    public Map<String, List<String>> xt() {
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

    m(j jVar) {
        List<String> list = jVar.f27298j;
        this.f27297j = (String[]) list.toArray(new String[list.size()]);
    }
}
