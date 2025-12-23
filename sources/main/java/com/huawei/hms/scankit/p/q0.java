package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q0 extends h5 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f34689a;

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f34690b = {'T', 'N', '*', 'E'};

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f34691c = {'/', ':', '+', '.'};

    /* renamed from: d, reason: collision with root package name */
    private static final char f34692d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f34689a = cArr;
        f34692d = cArr[0];
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int i6;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            char c6 = f34692d;
            sb.append(c6);
            sb.append(str);
            sb.append(c6);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f34689a;
            boolean a6 = p0.a(cArr, upperCase);
            boolean a7 = p0.a(cArr, upperCase2);
            char[] cArr2 = f34690b;
            boolean a8 = p0.a(cArr2, upperCase);
            boolean a9 = p0.a(cArr2, upperCase2);
            if (a6) {
                if (!a7) {
                    throw new IllegalArgumentException("Invalid start/end guards: error contents");
                }
            } else if (a8) {
                if (!a9) {
                    throw new IllegalArgumentException("Invalid start/end guards: error contents");
                }
            } else if (!a7 && !a9) {
                StringBuilder sb2 = new StringBuilder();
                char c7 = f34692d;
                sb2.append(c7);
                sb2.append(str);
                sb2.append(c7);
                str = sb2.toString();
            } else {
                throw new IllegalArgumentException("Invalid start/end guards: error contents");
            }
        }
        int i7 = 20;
        for (int i8 = 1; i8 < str.length() - 1; i8++) {
            if (!Character.isDigit(str.charAt(i8)) && str.charAt(i8) != '-' && str.charAt(i8) != '$') {
                if (p0.a(f34691c, str.charAt(i8))) {
                    i7 += 10;
                } else {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i8) + '\'');
                }
            } else {
                i7 += 9;
            }
        }
        boolean[] zArr = new boolean[i7 + (str.length() - 1)];
        int i9 = 0;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i10));
            if (i10 == 0 || i10 == str.length() - 1) {
                if (upperCase3 != '*') {
                    if (upperCase3 != 'E') {
                        if (upperCase3 != 'N') {
                            if (upperCase3 == 'T') {
                                upperCase3 = 'A';
                            }
                        } else {
                            upperCase3 = 'B';
                        }
                    } else {
                        upperCase3 = 'D';
                    }
                } else {
                    upperCase3 = 'C';
                }
            }
            int i11 = 0;
            while (true) {
                char[] cArr3 = p0.f34668e;
                if (i11 < cArr3.length) {
                    if (upperCase3 == cArr3[i11]) {
                        i6 = p0.f34669f[i11];
                        break;
                    }
                    i11++;
                } else {
                    i6 = 0;
                    break;
                }
            }
            int i12 = 0;
            boolean z5 = true;
            while (true) {
                int i13 = 0;
                while (i12 < 7) {
                    zArr[i9] = z5;
                    i9++;
                    if (((i6 >> (6 - i12)) & 1) != 0 && i13 != 1) {
                        i13++;
                    } else {
                        z5 = !z5;
                        i12++;
                    }
                }
                break;
            }
            if (i10 < str.length() - 1) {
                zArr[i9] = false;
                i9++;
            }
        }
        return zArr;
    }
}
