package cn.jiguang.bh;

import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private static Integer[] f2174a = new Integer[64];

    /* renamed from: d, reason: collision with root package name */
    private String f2177d;

    /* renamed from: e, reason: collision with root package name */
    private int f2178e;

    /* renamed from: f, reason: collision with root package name */
    private String f2179f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2181h;

    /* renamed from: b, reason: collision with root package name */
    private HashMap f2175b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private HashMap f2176c = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private int f2180g = Integer.MAX_VALUE;

    private String a(String str) {
        int i6 = this.f2178e;
        return i6 == 2 ? str.toUpperCase() : i6 == 3 ? str.toLowerCase() : str;
    }

    static {
        int i6 = 0;
        while (true) {
            Integer[] numArr = f2174a;
            if (i6 >= numArr.length) {
                return;
            }
            numArr[i6] = Integer.valueOf(i6);
            i6++;
        }
    }

    public static Integer b(int i6) {
        if (i6 >= 0) {
            Integer[] numArr = f2174a;
            if (i6 < numArr.length) {
                return numArr[i6];
            }
        }
        return Integer.valueOf(i6);
    }

    public void a(int i6) {
        this.f2180g = i6;
    }

    public void c(int i6) {
        if (i6 < 0 || i6 > this.f2180g) {
            throw new IllegalArgumentException(this.f2177d + " " + i6 + "is out of range");
        }
    }

    public f(String str, int i6) {
        this.f2177d = str;
        this.f2178e = i6;
    }

    public void a(int i6, String str) {
        c(i6);
        Integer b6 = b(i6);
        String a6 = a(str);
        this.f2175b.put(a6, b6);
        this.f2176c.put(b6, a6);
    }

    public String d(int i6) {
        c(i6);
        String str = (String) this.f2176c.get(b(i6));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i6);
        if (this.f2179f != null) {
            return this.f2179f + num;
        }
        return num;
    }

    public void a(boolean z5) {
        this.f2181h = z5;
    }
}
