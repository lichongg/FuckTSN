package org.apache.commons.net.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {

    /* renamed from: j, reason: collision with root package name */
    private static final int f51263j = 32;

    /* renamed from: a, reason: collision with root package name */
    private int f51264a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f51265b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f51266c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f51267d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f51268e = false;

    /* renamed from: f, reason: collision with root package name */
    private static final String f51259f = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f51261h = Pattern.compile(f51259f);

    /* renamed from: g, reason: collision with root package name */
    private static final String f51260g = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,3})";

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f51262i = Pattern.compile(f51260g);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class b {

        /* renamed from: b, reason: collision with root package name */
        private static final long f51269b = 4294967295L;

        /* synthetic */ b(f fVar, a aVar) {
            this();
        }

        public boolean p(int i6) {
            long j6 = i6 & 4294967295L;
            return j6 >= (((long) r()) & 4294967295L) && j6 <= (4294967295L & ((long) o()));
        }

        private b() {
        }

        private int a() {
            return f.this.f51265b;
        }

        private int c() {
            return f.this.f51267d;
        }

        private long d() {
            return f.this.f51267d & 4294967295L;
        }

        private int o() {
            if (f.this.l()) {
                return c();
            }
            if (d() - u() > 1) {
                return c() - 1;
            }
            return 0;
        }

        private int r() {
            if (f.this.l()) {
                return t();
            }
            if (d() - u() > 1) {
                return t() + 1;
            }
            return 0;
        }

        private int s() {
            return f.this.f51264a;
        }

        private int t() {
            return f.this.f51266c;
        }

        private long u() {
            return f.this.f51266c & 4294967295L;
        }

        public int b(String str) {
            return f.this.s(str);
        }

        public String e() {
            f fVar = f.this;
            return fVar.j(fVar.q(a()));
        }

        public String i() {
            f fVar = f.this;
            return fVar.j(fVar.q(c()));
        }

        public String j() {
            f fVar = f.this;
            String j6 = fVar.j(fVar.q(a()));
            f fVar2 = f.this;
            return fVar.r(j6, fVar2.j(fVar2.q(s())));
        }

        public String k() {
            f fVar = f.this;
            return fVar.j(fVar.q(o()));
        }

        public String l() {
            f fVar = f.this;
            return fVar.j(fVar.q(r()));
        }

        public String m() {
            f fVar = f.this;
            return fVar.j(fVar.q(s()));
        }

        public String n() {
            f fVar = f.this;
            return fVar.j(fVar.q(t()));
        }

        public boolean q(String str) {
            return p(f.this.s(str));
        }

        public String toString() {
            return "CIDR Signature:\t[" + j() + "] Netmask: [" + m() + "]\nNetwork:\t[" + n() + "]\nBroadcast:\t[" + i() + "]\nFirst Address:\t[" + l() + "]\nLast Address:\t[" + k() + "]\n# Addresses:\t[" + f() + "]\n";
        }

        @Deprecated
        public int f() {
            long g6 = g();
            if (g6 <= 2147483647L) {
                return (int) g6;
            }
            throw new RuntimeException("Count is larger than an integer: " + g6);
        }

        public long g() {
            int i6;
            long d6 = d() - u();
            if (f.this.l()) {
                i6 = 1;
            } else {
                i6 = -1;
            }
            long j6 = d6 + i6;
            if (j6 < 0) {
                return 0L;
            }
            return j6;
        }

        public String[] h() {
            int f6 = f();
            String[] strArr = new String[f6];
            if (f6 != 0) {
                int r5 = r();
                int i6 = 0;
                while (r5 <= o()) {
                    f fVar = f.this;
                    strArr[i6] = fVar.j(fVar.q(r5));
                    r5++;
                    i6++;
                }
            }
            return strArr;
        }
    }

    public f(String str) {
        i(str);
    }

    private int m(Matcher matcher) {
        int i6 = 0;
        for (int i7 = 1; i7 <= 4; i7++) {
            i6 |= (o(Integer.parseInt(matcher.group(i7)), 0, 255) & 255) << ((4 - i7) * 8);
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] q(int i6) {
        int[] iArr = new int[4];
        for (int i7 = 3; i7 >= 0; i7--) {
            iArr[i7] = iArr[i7] | ((i6 >>> ((3 - i7) * 8)) & 255);
        }
        return iArr;
    }

    private void i(String str) {
        Matcher matcher = f51262i.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Could not parse [" + str + "]");
        }
        this.f51265b = m(matcher);
        int o5 = o(Integer.parseInt(matcher.group(5)), 0, 32);
        for (int i6 = 0; i6 < o5; i6++) {
            this.f51264a |= 1 << (31 - i6);
        }
        int i7 = this.f51265b;
        int i8 = this.f51264a;
        int i9 = i7 & i8;
        this.f51266c = i9;
        this.f51267d = i9 | (~i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < iArr.length; i6++) {
            sb.append(iArr[i6]);
            if (i6 != iArr.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private int o(int i6, int i7, int i8) {
        if (i6 >= i7 && i6 <= i8) {
            return i6;
        }
        throw new IllegalArgumentException("Value [" + i6 + "] not in range [" + i7 + "," + i8 + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String r(String str, String str2) {
        return str + "/" + n(s(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s(String str) {
        Matcher matcher = f51261h.matcher(str);
        if (matcher.matches()) {
            return m(matcher);
        }
        throw new IllegalArgumentException("Could not parse [" + str + "]");
    }

    public final b k() {
        return new b(this, null);
    }

    public boolean l() {
        return this.f51268e;
    }

    int n(int i6) {
        int i7 = i6 - ((i6 >>> 1) & 1431655765);
        int i8 = (i7 & 858993459) + ((i7 >>> 2) & 858993459);
        int i9 = 252645135 & (i8 + (i8 >>> 4));
        int i10 = i9 + (i9 >>> 8);
        return (i10 + (i10 >>> 16)) & 63;
    }

    public void p(boolean z5) {
        this.f51268e = z5;
    }

    public f(String str, String str2) {
        i(r(str, str2));
    }
}
