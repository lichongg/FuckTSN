package com.huawei.hms.hatool;

import android.util.Pair;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class q0 {
    public static long a(String str, long j6) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j6))).getTime();
        } catch (ParseException unused) {
            j1.m("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0L;
        }
    }

    public static Pair<String, String> b(String str) {
        String str2;
        String str3;
        if ("_default_config_tag".equals(str)) {
            return new Pair<>(str, "");
        }
        String[] split = str.split("-");
        if (split.length > 2) {
            str3 = split[split.length - 1];
            str2 = str.substring(0, (str.length() - str3.length()) - 1);
        } else {
            str2 = split[0];
            str3 = split[1];
        }
        return new Pair<>(str2, str3);
    }

    public static String c(int i6) {
        return i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper";
    }

    public static String d(String str, String str2) {
        if ("_default_config_tag".equals(str)) {
            return str;
        }
        return str + "-" + str2;
    }

    public static String e(String str, String str2, String str3) {
        if ("_default_config_tag".equals(str)) {
            return "_default_config_tag#" + str3;
        }
        return str + "-" + str2 + "#" + str3;
    }

    public static Set<String> f(Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if ("_default_config_tag".equals(str)) {
                hashSet.add("_default_config_tag");
            } else {
                String str2 = str + "-oper";
                String str3 = str + "-maint";
                hashSet.add(str2);
                hashSet.add(str3);
                hashSet.add(str + "-diffprivacy");
            }
        }
        return hashSet;
    }
}
