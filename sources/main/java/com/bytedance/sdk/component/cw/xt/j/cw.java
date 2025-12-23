package com.bytedance.sdk.component.cw.xt.j;

import com.bytedance.sdk.component.cw.j.m;
import com.bytedance.sdk.component.cw.j.mi;
import com.bytedance.sdk.component.cw.j.up;
import com.bytedance.sdk.component.cw.xt.a;
import com.bytedance.sdk.component.cw.xt.h;
import com.bytedance.sdk.component.cw.xt.tj;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.net.ftp.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw {
    public static final h cw;

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f26163j;

    /* renamed from: r, reason: collision with root package name */
    public static final a f26165r;
    public static final String[] xt = new String[0];

    /* renamed from: g, reason: collision with root package name */
    private static final m f26161g = m.xt("efbbbf");
    private static final m oq = m.xt("feff");
    private static final m qv = m.xt("fffe");
    private static final m vl = m.xt("0000ffff");
    private static final m jy = m.xt("ffff0000");
    public static final Charset up = Charset.forName("UTF-8");

    /* renamed from: m, reason: collision with root package name */
    public static final Charset f26164m = Charset.forName(b.T);
    private static final Charset ws = Charset.forName("UTF-16BE");
    private static final Charset az = Charset.forName("UTF-16LE");
    private static final Charset av = Charset.forName("UTF-32BE");

    /* renamed from: i, reason: collision with root package name */
    private static final Charset f26162i = Charset.forName("UTF-32LE");
    public static final TimeZone ae = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> tl = new Comparator<String>() { // from class: com.bytedance.sdk.component.cw.xt.j.cw.1
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    /* renamed from: w, reason: collision with root package name */
    private static final Pattern f26166w = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = new byte[0];
        f26163j = bArr;
        cw = h.j(null, bArr);
        f26165r = a.j((tj) null, bArr);
    }

    public static String cw(String str, int i6, int i7) {
        int j6 = j(str, i6, i7);
        return str.substring(j6, xt(str, j6, i7));
    }

    public static int j(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return c6 - '0';
        }
        if (c6 >= 'a' && c6 <= 'f') {
            return c6 - 'W';
        }
        if (c6 < 'A' || c6 > 'F') {
            return -1;
        }
        return c6 - '7';
    }

    private static boolean r(String str) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean xt(mi miVar, int i6, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long o_ = miVar.j().cw() ? miVar.j().o_() - nanoTime : Long.MAX_VALUE;
        miVar.j().j(Math.min(o_, timeUnit.toNanos(i6)) + nanoTime);
        try {
            com.bytedance.sdk.component.cw.j.cw cwVar = new com.bytedance.sdk.component.cw.j.cw();
            while (miVar.j(cwVar, 8192L) != -1) {
                cwVar.w();
            }
            if (o_ == Long.MAX_VALUE) {
                miVar.j().m();
                return true;
            }
            miVar.j().j(nanoTime + o_);
            return true;
        } catch (InterruptedIOException unused) {
            if (o_ == Long.MAX_VALUE) {
                miVar.j().m();
                return false;
            }
            miVar.j().j(nanoTime + o_);
            return false;
        } catch (Throwable th) {
            if (o_ == Long.MAX_VALUE) {
                miVar.j().m();
            } else {
                miVar.j().j(nanoTime + o_);
            }
            throw th;
        }
    }

    public static void j(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean j(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean cw(String str) {
        return f26166w.matcher(str).matches();
    }

    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress r(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = -1
            r6 = -1
        L9:
            r7 = 0
            if (r13 >= r14) goto L78
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r13 + 2
            r9 = 2
            if (r8 > r14) goto L27
            java.lang.String r10 = "::"
            boolean r10 = r12.regionMatches(r13, r10, r2, r9)
            if (r10 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L25
            goto L78
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L34
            java.lang.String r8 = ":"
            r10 = 1
            boolean r8 = r12.regionMatches(r13, r8, r2, r10)
            if (r8 == 0) goto L36
            int r13 = r13 + 1
        L34:
            r6 = r13
            goto L4b
        L36:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r2, r10)
            if (r13 == 0) goto L4a
            int r13 = r4 + (-2)
            boolean r12 = j(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L78
        L4a:
            return r7
        L4b:
            r13 = r6
            r8 = 0
        L4d:
            if (r13 >= r14) goto L5f
            char r10 = r12.charAt(r13)
            int r10 = j(r10)
            if (r10 == r3) goto L5f
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L5f:
            int r10 = r13 - r6
            if (r10 == 0) goto L77
            r11 = 4
            if (r10 <= r11) goto L67
            goto L77
        L67:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r1[r4] = r10
            int r4 = r4 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L77:
            return r7
        L78:
            if (r4 == r0) goto L89
            if (r5 != r3) goto L7d
            return r7
        L7d:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L89:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8e
            return r12
        L8e:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.j.cw.r(java.lang.String, int, int):java.net.InetAddress");
    }

    public static void j(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e6) {
                if (!j(e6)) {
                    throw e6;
                }
            } catch (RuntimeException | Exception unused) {
            }
        }
    }

    public static boolean j(mi miVar, int i6, TimeUnit timeUnit) {
        try {
            return xt(miVar, i6, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> j(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> j(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory j(final String str, final boolean z5) {
        return new ThreadFactory() { // from class: com.bytedance.sdk.component.cw.xt.j.cw.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.oq.r.cw cwVar = new com.bytedance.sdk.component.oq.r.cw(runnable, "csj_" + str);
                cwVar.setDaemon(z5);
                cwVar.setPriority(10);
                return cwVar;
            }
        };
    }

    public static String[] j(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i6]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i6++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean xt(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String j(com.bytedance.sdk.component.cw.xt.mi miVar, boolean z5) {
        String ae2;
        if (miVar.ae().contains(":")) {
            ae2 = "[" + miVar.ae() + "]";
        } else {
            ae2 = miVar.ae();
        }
        if (!z5 && miVar.tl() == com.bytedance.sdk.component.cw.xt.mi.j(miVar.cw())) {
            return ae2;
        }
        return ae2 + ":" + miVar.tl();
    }

    public static int xt(String str, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            char charAt = str.charAt(i8);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i8 + 1;
            }
        }
        return i6;
    }

    public static int xt(String str) {
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt <= 31 || charAt >= 127) {
                return i6;
            }
        }
        return -1;
    }

    public static boolean j(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int j(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (comparator.compare(strArr[i6], str) == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static String[] j(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    public static int j(String str, int i6, int i7) {
        while (i6 < i7) {
            char charAt = str.charAt(i6);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static int j(String str, int i6, int i7, String str2) {
        while (i6 < i7) {
            if (str2.indexOf(str.charAt(i6)) != -1) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static int j(String str, int i6, int i7, char c6) {
        while (i6 < i7) {
            if (str.charAt(i6) == c6) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static String j(String str) {
        InetAddress r5;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                r5 = r(str, 1, str.length() - 1);
            } else {
                r5 = r(str, 0, str.length());
            }
            if (r5 == null) {
                return null;
            }
            byte[] address = r5.getAddress();
            if (address.length == 16) {
                return j(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (r(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String j(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset j(up upVar, Charset charset) throws IOException {
        if (upVar.j(0L, f26161g)) {
            upVar.tl(r0.ae());
            return up;
        }
        if (upVar.j(0L, oq)) {
            upVar.tl(r0.ae());
            return ws;
        }
        if (upVar.j(0L, qv)) {
            upVar.tl(r0.ae());
            return az;
        }
        if (upVar.j(0L, vl)) {
            upVar.tl(r0.ae());
            return av;
        }
        if (!upVar.j(0L, jy)) {
            return charset;
        }
        upVar.tl(r0.ae());
        return f26162i;
    }

    public static int j(String str, long j6, TimeUnit timeUnit) {
        if (j6 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j6);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j6 <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }
        throw new NullPointerException("unit == null");
    }

    public static AssertionError j(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    private static boolean j(String str, int i6, int i7, byte[] bArr, int i8) {
        int i9 = i8;
        while (i6 < i7) {
            if (i9 == bArr.length) {
                return false;
            }
            if (i9 != i8) {
                if (str.charAt(i6) != '.') {
                    return false;
                }
                i6++;
            }
            int i10 = i6;
            int i11 = 0;
            while (i10 < i7) {
                char charAt = str.charAt(i10);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i11 == 0 && i6 != i10) || (i11 = ((i11 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i10++;
            }
            if (i10 - i6 == 0) {
                return false;
            }
            bArr[i9] = (byte) i11;
            i9++;
            i6 = i10;
        }
        return i9 == i8 + 4;
    }

    private static String j(byte[] bArr) {
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < bArr.length) {
            int i10 = i8;
            while (i10 < 16 && bArr[i10] == 0 && bArr[i10 + 1] == 0) {
                i10 += 2;
            }
            int i11 = i10 - i8;
            if (i11 > i9 && i11 >= 4) {
                i6 = i8;
                i9 = i11;
            }
            i8 = i10 + 2;
        }
        com.bytedance.sdk.component.cw.j.cw cwVar = new com.bytedance.sdk.component.cw.j.cw();
        while (i7 < bArr.length) {
            if (i7 == i6) {
                cwVar.g(58);
                i7 += i9;
                if (i7 == 16) {
                    cwVar.g(58);
                }
            } else {
                if (i7 > 0) {
                    cwVar.g(58);
                }
                cwVar.qv(((bArr[i7] & 255) << 8) | (bArr[i7 + 1] & 255));
                i7 += 2;
            }
        }
        return cwVar.az();
    }
}
