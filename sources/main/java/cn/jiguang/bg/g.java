package cn.jiguang.bg;

import android.text.TextUtils;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f2081a;

    /* renamed from: b, reason: collision with root package name */
    public int f2082b;

    /* renamed from: c, reason: collision with root package name */
    public transient InetAddress f2083c;

    public g(String str, int i6) {
        this.f2081a = str;
        this.f2082b = i6;
    }

    public static g a(String str) {
        int lastIndexOf;
        String substring;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(":")) < 0) {
            return null;
        }
        try {
            int intValue = Integer.decode(str.substring(lastIndexOf + 1)).intValue();
            if (lastIndexOf == 0) {
                substring = "";
            } else {
                boolean startsWith = str.startsWith("[");
                if (str.charAt(lastIndexOf - 1) == ']') {
                    lastIndexOf--;
                }
                substring = str.substring(startsWith ? 1 : 0, lastIndexOf);
            }
            return new g(substring, intValue);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f2082b == gVar.f2082b) {
                String str = this.f2081a;
                String str2 = gVar.f2081a;
                if (str == null ? str2 == null : str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public g(InetAddress inetAddress, int i6) {
        this.f2081a = inetAddress.getHostAddress();
        this.f2082b = i6;
        this.f2083c = inetAddress;
    }

    public static String a(LinkedHashSet<g> linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<g> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static LinkedHashSet<g> c(String str) {
        String str2;
        cn.jiguang.bb.f.c("IpPort", " string2Set=" + str);
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("-sis-");
            cn.jiguang.bb.f.c("IpPort", " string2Set split=" + Arrays.toString(split));
            if (split != null) {
                if (split.length >= 2) {
                    if (b(split[1])) {
                        return linkedHashSet;
                    }
                    str2 = split[0];
                } else if (split.length >= 1) {
                    str2 = split[0];
                }
                a(str2, linkedHashSet);
            }
        }
        cn.jiguang.bb.f.c("IpPort", " string2Set list=" + linkedHashSet);
        return linkedHashSet;
    }

    public int hashCode() {
        String str = this.f2081a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f2082b;
    }

    public String toString() {
        StringBuilder sb;
        String str = ":";
        if (TextUtils.isEmpty(this.f2081a) || !this.f2081a.contains(":")) {
            sb = new StringBuilder();
            sb.append(this.f2081a);
        } else {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f2081a);
            str = "]:";
        }
        sb.append(str);
        sb.append(this.f2082b);
        return sb.toString();
    }

    public static LinkedHashSet<g> a(LinkedHashMap<String, Integer> linkedHashMap) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            g gVar = new g(entry.getKey(), entry.getValue().intValue());
            if (gVar.a()) {
                linkedHashSet.add(gVar);
            }
        }
        return linkedHashSet;
    }

    public static boolean b(String str) {
        try {
            if (Math.abs(System.currentTimeMillis() - Long.valueOf(str).longValue()) > 259200000) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void a(String str, LinkedHashSet<g> linkedHashSet) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(",")) {
            g a6 = a(str2);
            if (a6 != null && a6.a()) {
                linkedHashSet.add(a6);
            }
        }
    }

    public boolean a() {
        int i6;
        return !TextUtils.isEmpty(this.f2081a) && (i6 = this.f2082b) > 0 && i6 <= 65535;
    }

    public static boolean a(String str, int i6) {
        return !TextUtils.isEmpty(str) && i6 > 0 && i6 <= 65535;
    }
}
