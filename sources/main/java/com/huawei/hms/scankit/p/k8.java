package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k8 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34499b = Pattern.compile("WIFI:[^:]", 2);

    /* renamed from: c, reason: collision with root package name */
    static final String[] f34500c = new String[0];

    static String[] a(String str, String str2, char c6, boolean z5) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i6 = 0;
        while (i6 < length) {
            int indexOf = str2.indexOf(str, i6);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            ArrayList arrayList2 = arrayList;
            boolean z6 = true;
            int i7 = length2;
            while (z6) {
                int indexOf2 = str2.indexOf(c6, i7);
                if (indexOf2 < 0) {
                    i7 = str2.length();
                } else if (a(str2, indexOf2) % 2 != 0) {
                    i7 = indexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String b6 = t6.b(str2.substring(length2, indexOf2));
                    if (z5) {
                        b6 = b6.trim();
                    }
                    arrayList2.add(b6);
                    i7 = indexOf2 + 1;
                }
                z6 = false;
            }
            i6 = i7;
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(f34500c);
    }

    private static int c(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equalsIgnoreCase("WEP")) {
            return 2;
        }
        if ((str.equalsIgnoreCase("WPA") | str.equalsIgnoreCase("WPA2") | str.equalsIgnoreCase("WPA/WPA2")) || str.equalsIgnoreCase("WPA2/WPA")) {
            return 1;
        }
        return str.equalsIgnoreCase("SAE") ? 3 : 0;
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String str;
        String a6 = t6.a(s6Var);
        if (TextUtils.isEmpty(a6)) {
            return null;
        }
        Matcher matcher = f34499b.matcher(a6);
        if (matcher.find() && matcher.start() == 0) {
            String substring = a6.substring(5);
            if (!substring.endsWith(";")) {
                substring = substring + ";";
            }
            String b6 = b("S:", substring, ';', false);
            if (b6 != null && !b6.isEmpty()) {
                String b7 = b("P:", substring, ';', false);
                String b8 = b("T:", substring, ';', false);
                StringBuilder sb = new StringBuilder();
                sb.append(b6);
                if (b7 == null || b7.isEmpty()) {
                    str = "";
                } else {
                    str = " " + b7;
                }
                sb.append(str);
                return new HmsScan(s6Var.k(), t6.a(s6Var.c()), sb.toString(), HmsScan.WIFI_CONNECT_INFO_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.WiFiConnectionInfo(b6, b7, c(b8))));
            }
        }
        return null;
    }

    private static int a(CharSequence charSequence, int i6) {
        int i7 = 0;
        for (int i8 = i6 - 1; i8 >= 0 && charSequence.charAt(i8) == '\\'; i8--) {
            i7++;
        }
        return i7;
    }

    private String b(String str, String str2, char c6, boolean z5) {
        String str3;
        String[] a6 = a(str, str2, c6, z5);
        return (a6 == null || a6.length == 0 || (str3 = a6[0]) == null) ? "" : str3;
    }
}
