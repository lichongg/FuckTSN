package com.bytedance.sdk.component.cw.xt.j.cw;

import com.bytedance.sdk.component.cw.xt.jy;
import com.bytedance.sdk.component.cw.xt.mi;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.w;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class up {

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f26178j = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long j(p pVar) {
        return j(pVar.ae());
    }

    public static Set<String> xt(w wVar) {
        Set<String> set = Collections.EMPTY_SET;
        int j6 = wVar.j();
        for (int i6 = 0; i6 < j6; i6++) {
            if ("Vary".equalsIgnoreCase(wVar.j(i6))) {
                String xt = wVar.xt(i6);
                if (set.isEmpty()) {
                    set = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : xt.split(",")) {
                    set.add(str.trim());
                }
            }
        }
        return set;
    }

    public static long j(w wVar) {
        return j(wVar.j("Content-Length"));
    }

    public static boolean cw(p pVar) {
        if (pVar.j().xt().equals("HEAD")) {
            return false;
        }
        int cw = pVar.cw();
        if (((cw >= 100 && cw < 200) || cw == 204 || cw == 304) && j(pVar) == -1 && !HttpHeaders.Values.CHUNKED.equalsIgnoreCase(pVar.j("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    private static long j(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static w j(w wVar, w wVar2) {
        Set<String> xt = xt(wVar2);
        if (xt.isEmpty()) {
            return new w.j().j();
        }
        w.j jVar = new w.j();
        int j6 = wVar.j();
        for (int i6 = 0; i6 < j6; i6++) {
            String j7 = wVar.j(i6);
            if (xt.contains(j7)) {
                jVar.j(j7, wVar.xt(i6));
            }
        }
        return jVar.j();
    }

    public static w xt(p pVar) {
        return j(pVar.oq().j().cw(), pVar.ae());
    }

    public static void j(jy jyVar, mi miVar, w wVar) {
        if (jyVar == jy.f26322j) {
            return;
        }
        com.bytedance.sdk.component.cw.xt.vl.j(miVar, wVar).isEmpty();
    }

    public static int xt(String str, int i6) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i6;
        }
    }

    public static int j(String str, int i6, String str2) {
        while (i6 < str.length() && str2.indexOf(str.charAt(i6)) == -1) {
            i6++;
        }
        return i6;
    }

    public static int j(String str, int i6) {
        char charAt;
        while (i6 < str.length() && ((charAt = str.charAt(i6)) == ' ' || charAt == '\t')) {
            i6++;
        }
        return i6;
    }
}
