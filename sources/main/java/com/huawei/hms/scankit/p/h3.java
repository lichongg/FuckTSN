package com.huawei.hms.scankit.p;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h3 {

    /* renamed from: a, reason: collision with root package name */
    private final s f34335a;

    /* renamed from: b, reason: collision with root package name */
    private final List<g3> f34336b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f34337c = new int[5];

    /* renamed from: d, reason: collision with root package name */
    private final v6 f34338d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements Comparator<g3>, Serializable {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g3 g3Var, g3 g3Var2) {
            return Float.compare(g3Var2.e(), g3Var.e());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements Comparator<g3>, Serializable {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g3 g3Var, g3 g3Var2) {
            return Integer.compare(g3Var2.a(), g3Var.a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class d implements Comparator<g3>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final float f34339a;

        /* synthetic */ d(float f6, a aVar) {
            this(f6);
        }

        private d(float f6) {
            this.f34339a = f6;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g3 g3Var, g3 g3Var2) {
            return Float.compare(Math.abs(g3Var.e() - this.f34339a), Math.abs(g3Var2.e() - this.f34339a));
        }
    }

    protected static boolean b(int[] iArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < 5; i7++) {
            int i8 = iArr[i7];
            if (i8 == 0) {
                return false;
            }
            i6 += i8;
        }
        if (i6 < 6) {
            return false;
        }
        float f6 = i6 / 6.0f;
        float f7 = f6 / 1.5f;
        return Math.abs(f6 - ((float) iArr[0])) < f7 && Math.abs(f6 - ((float) iArr[1])) < f7 && Math.abs((f6 * 2.0f) - ((float) iArr[2])) < 2.0f * f7 && Math.abs(f6 - ((float) iArr[3])) < f7 && Math.abs(f6 - ((float) iArr[4])) < f7;
    }

    protected static boolean c(int[] iArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < 5; i7++) {
            int i8 = iArr[i7];
            if (i8 == 0) {
                return false;
            }
            i6 += i8;
        }
        if (i6 < 6) {
            return false;
        }
        float f6 = i6 / 6.0f;
        float f7 = f6 / 1.0f;
        return Math.abs(f6 - ((float) iArr[0])) < f7 && Math.abs(f6 - ((float) iArr[1])) < f7 && Math.abs((f6 * 2.0f) - ((float) iArr[2])) < 2.0f * f7 && Math.abs(f6 - ((float) iArr[3])) < f7 && Math.abs(f6 - ((float) iArr[4])) < f7;
    }

    private void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    final g3[] a(Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        int c6 = this.f34335a.c();
        int e6 = this.f34335a.e();
        int[] iArr = new int[5];
        for (int i6 = 0; i6 < c6; i6++) {
            a(iArr);
            int i7 = 0;
            for (int i8 = 0; i8 < e6; i8++) {
                if (this.f34335a.b(i8, i6)) {
                    if ((i7 & 1) == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if ((i7 & 1) != 0) {
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 == 4) {
                    if (!b(iArr)) {
                        d(iArr);
                    } else if (a(iArr, i6, i8)) {
                        a(iArr);
                        i7 = 0;
                    } else {
                        d(iArr);
                    }
                    i7 = 3;
                } else {
                    i7++;
                    iArr[i7] = iArr[i7] + 1;
                }
            }
            if (b(iArr)) {
                a(iArr, i6, e6);
            }
        }
        return b();
    }

    public h3(s sVar, v6 v6Var) {
        this.f34335a = sVar;
        this.f34338d = v6Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0086, code lost:
    
        if (r11 >= r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008c, code lost:
    
        if (r0.b(r12, r11) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008e, code lost:
    
        r9 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0090, code lost:
    
        if (r9 >= r13) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        r2[4] = r9 + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0099, code lost:
    
        r12 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009b, code lost:
    
        if (r12 < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009d, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b3, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r12) - r14) * 5) < (r14 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b5, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ba, code lost:
    
        if (b(r2) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c0, code lost:
    
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float b(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            com.huawei.hms.scankit.p.s r0 = r10.f34335a
            int r1 = r0.c()
            int[] r2 = r10.a()
            r3 = r11
        Lb:
            r4 = 2
            r5 = 1
            if (r3 < 0) goto L1d
            boolean r6 = r0.b(r12, r3)
            if (r6 == 0) goto L1d
            r6 = r2[r4]
            int r6 = r6 + r5
            r2[r4] = r6
            int r3 = r3 + (-1)
            goto Lb
        L1d:
            r6 = 2143289344(0x7fc00000, float:NaN)
            if (r3 >= 0) goto L22
            return r6
        L22:
            if (r3 < 0) goto L35
            boolean r7 = r0.b(r12, r3)
            if (r7 != 0) goto L35
            r7 = r2[r5]
            if (r7 > r13) goto L35
            int r7 = r7 + 1
            r2[r5] = r7
            int r3 = r3 + (-1)
            goto L22
        L35:
            if (r3 < 0) goto Lc1
            r7 = r2[r5]
            if (r7 <= r13) goto L3d
            goto Lc1
        L3d:
            r7 = 0
            if (r3 < 0) goto L51
            boolean r8 = r0.b(r12, r3)
            if (r8 == 0) goto L51
            r8 = r2[r7]
            if (r8 > r13) goto L51
            int r8 = r8 + 1
            r2[r7] = r8
            int r3 = r3 + (-1)
            goto L3d
        L51:
            r3 = r2[r7]
            if (r3 <= r13) goto L56
            return r6
        L56:
            int r11 = r11 + r5
        L57:
            if (r11 >= r1) goto L67
            boolean r3 = r0.b(r12, r11)
            if (r3 == 0) goto L67
            r3 = r2[r4]
            int r3 = r3 + r5
            r2[r4] = r3
            int r11 = r11 + 1
            goto L57
        L67:
            if (r11 != r1) goto L6a
            return r6
        L6a:
            r3 = 3
            if (r11 >= r1) goto L7e
            boolean r8 = r0.b(r12, r11)
            if (r8 != 0) goto L7e
            r8 = r2[r3]
            if (r8 >= r13) goto L7e
            int r8 = r8 + 1
            r2[r3] = r8
            int r11 = r11 + 1
            goto L6a
        L7e:
            if (r11 == r1) goto Lc1
            r8 = r2[r3]
            if (r8 < r13) goto L85
            goto Lc1
        L85:
            r8 = 4
            if (r11 >= r1) goto L99
            boolean r9 = r0.b(r12, r11)
            if (r9 == 0) goto L99
            r9 = r2[r8]
            if (r9 >= r13) goto L99
            int r9 = r9 + 1
            r2[r8] = r9
            int r11 = r11 + 1
            goto L85
        L99:
            r12 = r2[r8]
            if (r12 < r13) goto L9e
            return r6
        L9e:
            r13 = r2[r7]
            r0 = r2[r5]
            int r13 = r13 + r0
            r0 = r2[r4]
            int r13 = r13 + r0
            r0 = r2[r3]
            int r13 = r13 + r0
            int r13 = r13 + r12
            int r13 = r13 - r14
            int r12 = java.lang.Math.abs(r13)
            int r12 = r12 * 5
            int r14 = r14 * 2
            if (r12 < r14) goto Lb6
            return r6
        Lb6:
            boolean r12 = b(r2)
            if (r12 == 0) goto Lc1
            float r11 = a(r2, r11)
            return r11
        Lc1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.h3.b(int, int, int, int):float");
    }

    private static float a(int[] iArr, int i6) {
        return ((i6 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private int[] a() {
        a(this.f34337c);
        return this.f34337c;
    }

    private void a(int[] iArr) {
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr[i6] = 0;
        }
    }

    private boolean a(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int[] a6 = a();
        int i11 = 0;
        while (i6 >= i11 && i7 >= i11 && this.f34335a.b(i7 - i11, i6 - i11)) {
            a6[2] = a6[2] + 1;
            i11++;
        }
        if (a6[2] == 0) {
            return false;
        }
        while (i6 >= i11 && i7 >= i11 && !this.f34335a.b(i7 - i11, i6 - i11)) {
            a6[1] = a6[1] + 1;
            i11++;
        }
        if (a6[1] == 0) {
            return false;
        }
        while (i6 >= i11 && i7 >= i11 && this.f34335a.b(i7 - i11, i6 - i11)) {
            a6[0] = a6[0] + 1;
            i11++;
        }
        if (a6[0] == 0) {
            return false;
        }
        int c6 = this.f34335a.c();
        int e6 = this.f34335a.e();
        int i12 = 1;
        while (true) {
            int i13 = i6 + i12;
            if (i13 >= c6 || (i10 = i7 + i12) >= e6 || !this.f34335a.b(i10, i13)) {
                break;
            }
            a6[2] = a6[2] + 1;
            i12++;
        }
        while (true) {
            int i14 = i6 + i12;
            if (i14 >= c6 || (i9 = i7 + i12) >= e6 || this.f34335a.b(i9, i14)) {
                break;
            }
            a6[3] = a6[3] + 1;
            i12++;
        }
        if (a6[3] == 0) {
            return false;
        }
        while (true) {
            int i15 = i6 + i12;
            if (i15 >= c6 || (i8 = i7 + i12) >= e6 || !this.f34335a.b(i8, i15)) {
                break;
            }
            a6[4] = a6[4] + 1;
            i12++;
        }
        if (a6[4] == 0) {
            return false;
        }
        return c(a6);
    }

    private g3[] b() throws com.huawei.hms.scankit.p.a {
        int i6 = 0;
        while (i6 < this.f34336b.size()) {
            g3 g3Var = this.f34336b.get(i6);
            if (g3Var.e() <= 5.0f && g3Var.a() <= 2) {
                this.f34336b.remove(i6);
                i6--;
            }
            i6++;
        }
        int size = this.f34336b.size();
        int i7 = 3;
        if (size >= 3) {
            a aVar = null;
            if (size >= 4) {
                float f6 = 0.0f;
                float f7 = 0.0f;
                while (this.f34336b.iterator().hasNext()) {
                    f7 += r8.next().a();
                }
                float f8 = f7 / size;
                int i8 = 0;
                while (i8 < this.f34336b.size() && this.f34336b.size() > 4) {
                    if (this.f34336b.get(i8).a() <= 0.5f * f8) {
                        this.f34336b.remove(i8);
                        i8--;
                    }
                    i8++;
                }
                int size2 = this.f34336b.size();
                Iterator<g3> it = this.f34336b.iterator();
                float f9 = 0.0f;
                while (it.hasNext()) {
                    float e6 = it.next().e();
                    f6 += e6;
                    f9 += e6 * e6;
                }
                float f10 = f6 / size2;
                float sqrt = (float) Math.sqrt((f9 / r2) - (f10 * f10));
                Collections.sort(this.f34336b, new d(f10, aVar));
                float max = Math.max(0.36f * f10, sqrt);
                int i9 = 0;
                while (i9 < this.f34336b.size() && this.f34336b.size() > 4) {
                    if (Math.abs(this.f34336b.get(i9).e() - f10) > max) {
                        this.f34336b.remove(i9);
                        i9--;
                    }
                    i9++;
                }
                int size3 = this.f34336b.size();
                if (size3 >= 4) {
                    Collections.sort(this.f34336b, new c(aVar));
                    if (size3 > 4 && this.f34336b.get(3).a() - this.f34336b.get(4).a() > 2) {
                        while (4 < this.f34336b.size()) {
                            this.f34336b.remove(4);
                        }
                    }
                    double[] dArr = new double[3];
                    while (i7 < this.f34336b.size()) {
                        dArr[0] = a(this.f34336b.get(0), this.f34336b.get(1));
                        dArr[1] = a(this.f34336b.get(1), this.f34336b.get(i7));
                        dArr[2] = a(this.f34336b.get(0), this.f34336b.get(i7));
                        Arrays.sort(dArr);
                        double d6 = dArr[1];
                        double d7 = dArr[0];
                        double sqrt2 = ((d6 + d7) - dArr[2]) / ((Math.sqrt(d7) * 2.0d) * Math.sqrt(dArr[1]));
                        dArr[0] = a(this.f34336b.get(0), this.f34336b.get(2));
                        dArr[1] = a(this.f34336b.get(2), this.f34336b.get(i7));
                        dArr[2] = a(this.f34336b.get(0), this.f34336b.get(i7));
                        Arrays.sort(dArr);
                        double d8 = dArr[1];
                        double d9 = dArr[0];
                        double sqrt3 = ((d8 + d9) - dArr[2]) / ((Math.sqrt(d9) * 2.0d) * Math.sqrt(dArr[1]));
                        if (Math.abs(sqrt2) > 0.25d || Math.abs(sqrt3) > 0.25d) {
                            this.f34336b.remove(i7);
                            i7--;
                        }
                        i7++;
                    }
                }
            }
            Collections.sort(this.f34336b, new b(aVar));
            List<g3> list = this.f34336b;
            return (g3[]) list.toArray(new g3[list.size()]);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0086, code lost:
    
        if (r11 >= r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008c, code lost:
    
        if (r0.b(r11, r12) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008e, code lost:
    
        r9 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0090, code lost:
    
        if (r9 >= r13) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        r2[4] = r9 + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0099, code lost:
    
        r12 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009b, code lost:
    
        if (r12 < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009d, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b1, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r12) - r14) * 5) < r14) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b3, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b8, code lost:
    
        if (b(r2) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:
    
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            com.huawei.hms.scankit.p.s r0 = r10.f34335a
            int r1 = r0.e()
            int[] r2 = r10.a()
            r3 = r11
        Lb:
            r4 = 2
            r5 = 1
            if (r3 < 0) goto L1d
            boolean r6 = r0.b(r3, r12)
            if (r6 == 0) goto L1d
            r6 = r2[r4]
            int r6 = r6 + r5
            r2[r4] = r6
            int r3 = r3 + (-1)
            goto Lb
        L1d:
            r6 = 2143289344(0x7fc00000, float:NaN)
            if (r3 >= 0) goto L22
            return r6
        L22:
            if (r3 < 0) goto L35
            boolean r7 = r0.b(r3, r12)
            if (r7 != 0) goto L35
            r7 = r2[r5]
            if (r7 > r13) goto L35
            int r7 = r7 + 1
            r2[r5] = r7
            int r3 = r3 + (-1)
            goto L22
        L35:
            if (r3 < 0) goto Lbf
            r7 = r2[r5]
            if (r7 <= r13) goto L3d
            goto Lbf
        L3d:
            r7 = 0
            if (r3 < 0) goto L51
            boolean r8 = r0.b(r3, r12)
            if (r8 == 0) goto L51
            r8 = r2[r7]
            if (r8 > r13) goto L51
            int r8 = r8 + 1
            r2[r7] = r8
            int r3 = r3 + (-1)
            goto L3d
        L51:
            r3 = r2[r7]
            if (r3 <= r13) goto L56
            return r6
        L56:
            int r11 = r11 + r5
        L57:
            if (r11 >= r1) goto L67
            boolean r3 = r0.b(r11, r12)
            if (r3 == 0) goto L67
            r3 = r2[r4]
            int r3 = r3 + r5
            r2[r4] = r3
            int r11 = r11 + 1
            goto L57
        L67:
            if (r11 != r1) goto L6a
            return r6
        L6a:
            r3 = 3
            if (r11 >= r1) goto L7e
            boolean r8 = r0.b(r11, r12)
            if (r8 != 0) goto L7e
            r8 = r2[r3]
            if (r8 >= r13) goto L7e
            int r8 = r8 + 1
            r2[r3] = r8
            int r11 = r11 + 1
            goto L6a
        L7e:
            if (r11 == r1) goto Lbf
            r8 = r2[r3]
            if (r8 < r13) goto L85
            goto Lbf
        L85:
            r8 = 4
            if (r11 >= r1) goto L99
            boolean r9 = r0.b(r11, r12)
            if (r9 == 0) goto L99
            r9 = r2[r8]
            if (r9 >= r13) goto L99
            int r9 = r9 + 1
            r2[r8] = r9
            int r11 = r11 + 1
            goto L85
        L99:
            r12 = r2[r8]
            if (r12 < r13) goto L9e
            return r6
        L9e:
            r13 = r2[r7]
            r0 = r2[r5]
            int r13 = r13 + r0
            r0 = r2[r4]
            int r13 = r13 + r0
            r0 = r2[r3]
            int r13 = r13 + r0
            int r13 = r13 + r12
            int r13 = r13 - r14
            int r12 = java.lang.Math.abs(r13)
            int r12 = r12 * 5
            if (r12 < r14) goto Lb4
            return r6
        Lb4:
            boolean r12 = b(r2)
            if (r12 == 0) goto Lbf
            float r11 = a(r2, r11)
            return r11
        Lbf:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.h3.a(int, int, int, int):float");
    }

    protected final boolean a(int[] iArr, int i6, int i7) {
        int i8 = 0;
        int i9 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a6 = (int) a(iArr, i7);
        float b6 = b(i6, a6, iArr[2], i9);
        if (!Float.isNaN(b6)) {
            int i10 = (int) b6;
            float a7 = a(a6, i10, iArr[2], i9);
            if (!Float.isNaN(a7) && a(i10, (int) a7)) {
                float f6 = i9 / 6.0f;
                while (true) {
                    if (i8 < this.f34336b.size()) {
                        g3 g3Var = this.f34336b.get(i8);
                        if (g3Var.b(f6, b6, a7)) {
                            this.f34336b.set(i8, g3Var.c(b6, a7, f6));
                            break;
                        }
                        i8++;
                    } else {
                        g3 g3Var2 = new g3(a7, b6, f6);
                        this.f34336b.add(g3Var2);
                        v6 v6Var = this.f34338d;
                        if (v6Var != null) {
                            v6Var.a(g3Var2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static double a(g3 g3Var, g3 g3Var2) {
        double b6 = g3Var.b() - g3Var2.b();
        double c6 = g3Var.c() - g3Var2.c();
        return (b6 * b6) + (c6 * c6);
    }
}
