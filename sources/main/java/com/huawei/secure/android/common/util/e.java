package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f35267a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: b, reason: collision with root package name */
    private static final char f35268b = '*';

    /* renamed from: c, reason: collision with root package name */
    private static final int f35269c = 2;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends Throwable {

        /* renamed from: d, reason: collision with root package name */
        private static final long f35270d = 7129050843360571879L;

        /* renamed from: a, reason: collision with root package name */
        private String f35271a;

        /* renamed from: b, reason: collision with root package name */
        private Throwable f35272b;

        /* renamed from: c, reason: collision with root package name */
        private Throwable f35273c;

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            Throwable th;
            th = this.f35272b;
            if (th == this) {
                th = null;
            }
            return th;
        }

        public void a(String str) {
            this.f35271a = str;
        }

        public void b(Throwable th) {
            this.f35272b = th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f35271a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.f35273c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f35271a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f35271a.startsWith(str)) {
                return this.f35271a;
            }
            return str + this.f35271a;
        }

        public a(Throwable th) {
            this.f35273c = th;
        }
    }

    private static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(a(str2));
        }
        return sb.toString();
    }

    private static String c(String str, boolean z5) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z5) {
                sb.append(a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static Throwable d(Throwable th) {
        if (th == null) {
            return null;
        }
        a aVar = new a(th);
        aVar.setStackTrace(th.getStackTrace());
        aVar.a(e(th.getMessage()));
        Throwable cause = th.getCause();
        a aVar2 = aVar;
        while (cause != null) {
            a aVar3 = new a(cause);
            aVar3.setStackTrace(cause.getStackTrace());
            aVar3.a(e(cause.getMessage()));
            aVar2.b(aVar3);
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }

    public static void A(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, false);
        d(th);
    }

    public static void B(String str, String str2, Throwable th, boolean z5) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, z5);
        d(th);
    }

    public static void C(String str, String str2, boolean z5) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z5);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i6 = 1;
        if (1 == length) {
            return String.valueOf(f35268b);
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i7 = 0; i7 < length; i7++) {
            char charAt = str.charAt(i7);
            if (f35267a.matcher(String.valueOf(charAt)).matches()) {
                if (i6 % 2 == 0) {
                    charAt = f35268b;
                }
                i6++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i6 = 0; i6 < charArray.length; i6++) {
            if (i6 % 2 == 0) {
                charArray[i6] = f35268b;
            }
        }
        return new String(charArray);
    }

    public static void f(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }

    public static void g(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
    }

    public static void h(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
        d(th);
    }

    public static void i(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, false);
        d(th);
    }

    public static void j(String str, String str2, Throwable th, boolean z5) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z5);
        d(th);
    }

    public static void k(String str, String str2, boolean z5) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z5);
    }

    public static void l(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }

    public static void m(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
    }

    public static void n(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
        d(th);
    }

    public static void o(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, false);
        d(th);
    }

    public static void p(String str, String str2, Throwable th, boolean z5) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, z5);
        d(th);
    }

    public static void q(String str, String str2, boolean z5) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z5);
    }

    public static void r(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }

    public static void s(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
    }

    public static void t(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
        d(th);
    }

    public static void u(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, false);
        d(th);
    }

    public static void v(String str, String str2, Throwable th, boolean z5) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, z5);
        d(th);
    }

    public static void w(String str, String str2, boolean z5) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z5);
    }

    public static void x(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }

    public static void y(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
    }

    public static void z(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
        d(th);
    }
}
