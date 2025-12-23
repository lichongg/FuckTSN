package com.huawei.hms.scankit.p;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j3 {

    /* renamed from: a, reason: collision with root package name */
    private final s f34442a;

    /* renamed from: b, reason: collision with root package name */
    private final List<f3> f34443b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f34444c = new int[5];

    /* renamed from: d, reason: collision with root package name */
    private final v6 f34445d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements Comparator<f3>, Serializable {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f3 f3Var, f3 f3Var2) {
            return Float.compare(f3Var2.e(), f3Var.e());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements Comparator<f3>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final float f34446a;

        /* synthetic */ c(float f6, a aVar) {
            this(f6);
        }

        private c(float f6) {
            this.f34446a = f6;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f3 f3Var, f3 f3Var2) {
            return Float.compare(Math.abs(f3Var2.e() - this.f34446a), Math.abs(f3Var.e() - this.f34446a));
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
        if (i6 < 5) {
            return false;
        }
        float f6 = i6 / 5.0f;
        float f7 = f6 / 1.6f;
        float f8 = f6 * 0.8f;
        float f9 = 0.8f * f7;
        if (Math.abs(f8 - iArr[0]) < f9) {
            float f10 = f6 * 1.2f;
            float f11 = 1.2f * f7;
            if (Math.abs(f10 - iArr[1]) < f11 && Math.abs(f6 - iArr[2]) < f7 && Math.abs(f10 - iArr[3]) < f11 && Math.abs(f8 - iArr[4]) < f9) {
                return true;
            }
        }
        return false;
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
        if (i6 < 5) {
            return false;
        }
        float f6 = i6 / 5.0f;
        float f7 = f6 / 1.0f;
        float f8 = f6 * 0.8f;
        float f9 = 0.8f * f7;
        if (Math.abs(f8 - iArr[0]) < f9) {
            float f10 = f6 * 1.2f;
            float f11 = 1.2f * f7;
            if (Math.abs(f10 - iArr[1]) < f11 && Math.abs(f6 - iArr[2]) < f7 && Math.abs(f10 - iArr[3]) < f11 && Math.abs(f8 - iArr[4]) < f9) {
                return true;
            }
        }
        return false;
    }

    private void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    final f3[] a(Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        int c6 = this.f34442a.c();
        int e6 = this.f34442a.e();
        int[] iArr = new int[5];
        for (int i6 = 1; i6 < c6; i6 += 2) {
            a(iArr);
            int i7 = 0;
            for (int i8 = 0; i8 < e6; i8++) {
                if (this.f34442a.b(i8, i6)) {
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

    public j3(s sVar, v6 v6Var) {
        this.f34442a = sVar;
        this.f34445d = v6Var;
    }

    private float d(int i6, int i7, int i8) {
        s sVar = this.f34442a;
        int c6 = sVar.c();
        int[] a6 = a();
        int i9 = i6;
        while (i9 >= 0 && sVar.b(i7, i9)) {
            a6[2] = a6[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            return Float.NaN;
        }
        while (i9 >= 0 && !sVar.b(i7, i9)) {
            a6[1] = a6[1] + 1;
            i9--;
        }
        if (i9 >= 0 && a6[1] != 0) {
            while (i9 >= 0 && sVar.b(i7, i9)) {
                a6[0] = a6[0] + 1;
                i9--;
            }
            if (a6[0] == 0) {
                return Float.NaN;
            }
            int i10 = i6 + 1;
            while (i10 < c6 && sVar.b(i7, i10)) {
                a6[2] = a6[2] + 1;
                i10++;
            }
            if (i10 != c6 && a6[2] != 0) {
                while (i10 < c6 && !sVar.b(i7, i10)) {
                    a6[3] = a6[3] + 1;
                    i10++;
                }
                if (i10 != c6 && a6[3] != 0) {
                    while (i10 < c6 && sVar.b(i7, i10)) {
                        a6[4] = a6[4] + 1;
                        i10++;
                    }
                    if (a6[4] != 0 && Math.abs(((((a6[0] + a6[1]) + a6[2]) + a6[3]) + r12) - i8) < i8 * 0.4f && b(a6)) {
                        return a(a6, i10);
                    }
                }
            }
        }
        return Float.NaN;
    }

    private boolean b(int i6, int i7, int i8) {
        int i9;
        int i10;
        int[] a6 = a();
        int c6 = this.f34442a.c();
        int e6 = this.f34442a.e();
        int i11 = 0;
        while (true) {
            int i12 = i6 + i11;
            if (i12 >= c6 || i7 < i11 || !this.f34442a.b(i7 - i11, i12)) {
                break;
            }
            a6[2] = a6[2] + 1;
            i11++;
        }
        if (a6[2] == 0) {
            return false;
        }
        while (true) {
            int i13 = i6 + i11;
            if (i13 >= c6 || i7 < i11 || this.f34442a.b(i7 - i11, i13)) {
                break;
            }
            a6[1] = a6[1] + 1;
            i11++;
        }
        if (a6[1] == 0) {
            return false;
        }
        while (true) {
            int i14 = i6 + i11;
            if (i14 >= c6 || i7 < i11 || !this.f34442a.b(i7 - i11, i14)) {
                break;
            }
            a6[0] = a6[0] + 1;
            i11++;
        }
        if (a6[0] == 0) {
            return false;
        }
        int i15 = 1;
        while (i6 >= i15) {
            int i16 = i7 + i15;
            if (i16 >= e6 || !this.f34442a.b(i16, i6 - i15)) {
                break;
            }
            a6[2] = a6[2] + 1;
            i15++;
        }
        while (i6 >= i15 && (i10 = i7 + i15) < e6 && !this.f34442a.b(i10, i6 - i15)) {
            a6[3] = a6[3] + 1;
            i15++;
        }
        if (a6[3] == 0) {
            return false;
        }
        while (i6 >= i15 && (i9 = i7 + i15) < e6 && this.f34442a.b(i9, i6 - i15)) {
            a6[4] = a6[4] + 1;
            i15++;
        }
        if (a6[4] != 0 && Math.abs(((((a6[0] + a6[1]) + a6[2]) + a6[3]) + r12) - i8) < i8 * 0.5f) {
            return c(a6);
        }
        return false;
    }

    private float c(int i6, int i7, int i8) {
        s sVar = this.f34442a;
        int e6 = sVar.e();
        int[] a6 = a();
        int i9 = i6;
        while (i9 >= 0 && sVar.b(i9, i7)) {
            a6[2] = a6[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            return Float.NaN;
        }
        while (i9 >= 0 && !sVar.b(i9, i7)) {
            a6[1] = a6[1] + 1;
            i9--;
        }
        if (i9 >= 0 && a6[1] != 0) {
            while (i9 >= 0 && sVar.b(i9, i7)) {
                a6[0] = a6[0] + 1;
                i9--;
            }
            if (a6[0] == 0) {
                return Float.NaN;
            }
            int i10 = i6 + 1;
            while (i10 < e6 && sVar.b(i10, i7)) {
                a6[2] = a6[2] + 1;
                i10++;
            }
            if (i10 != e6 && a6[2] != 0) {
                while (i10 < e6 && !sVar.b(i10, i7)) {
                    a6[3] = a6[3] + 1;
                    i10++;
                }
                if (i10 != e6 && a6[3] != 0) {
                    while (i10 < e6 && sVar.b(i10, i7)) {
                        a6[4] = a6[4] + 1;
                        i10++;
                    }
                    if (a6[4] != 0 && Math.abs(((((a6[0] + a6[1]) + a6[2]) + a6[3]) + r12) - i8) < i8 * 0.2f && b(a6)) {
                        return a(a6, i10);
                    }
                }
            }
        }
        return Float.NaN;
    }

    private static float a(int[] iArr, int i6) {
        return ((i6 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private int[] a() {
        a(this.f34444c);
        return this.f34444c;
    }

    private void a(int[] iArr) {
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr[i6] = 0;
        }
    }

    private boolean a(int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int[] a6 = a();
        int i12 = 0;
        while (i6 >= i12 && i7 >= i12 && this.f34442a.b(i7 - i12, i6 - i12)) {
            a6[2] = a6[2] + 1;
            i12++;
        }
        if (a6[2] == 0) {
            return false;
        }
        while (i6 >= i12 && i7 >= i12 && !this.f34442a.b(i7 - i12, i6 - i12)) {
            a6[1] = a6[1] + 1;
            i12++;
        }
        if (a6[1] == 0) {
            return false;
        }
        while (i6 >= i12 && i7 >= i12 && this.f34442a.b(i7 - i12, i6 - i12)) {
            a6[0] = a6[0] + 1;
            i12++;
        }
        if (a6[0] == 0) {
            return false;
        }
        int c6 = this.f34442a.c();
        int e6 = this.f34442a.e();
        int i13 = 1;
        while (true) {
            int i14 = i6 + i13;
            if (i14 >= c6 || (i11 = i7 + i13) >= e6 || !this.f34442a.b(i11, i14)) {
                break;
            }
            a6[2] = a6[2] + 1;
            i13++;
        }
        while (true) {
            int i15 = i6 + i13;
            if (i15 >= c6 || (i10 = i7 + i13) >= e6 || this.f34442a.b(i10, i15)) {
                break;
            }
            a6[3] = a6[3] + 1;
            i13++;
        }
        if (a6[3] == 0) {
            return false;
        }
        while (true) {
            int i16 = i6 + i13;
            if (i16 >= c6 || (i9 = i7 + i13) >= e6 || !this.f34442a.b(i9, i16)) {
                break;
            }
            a6[4] = a6[4] + 1;
            i13++;
        }
        if (a6[4] != 0 && Math.abs(((((a6[0] + a6[1]) + a6[2]) + a6[3]) + r13) - i8) < i8 * 0.5f) {
            return c(a6);
        }
        return false;
    }

    private f3[] b() throws com.huawei.hms.scankit.p.a {
        int i6 = 0;
        int i7 = 0;
        while (i7 < this.f34443b.size()) {
            f3 f3Var = this.f34443b.get(i7);
            if (f3Var.e() <= 5.0f || f3Var.a() <= 2) {
                this.f34443b.remove(i7);
                i7--;
            }
            i7++;
        }
        int size = this.f34443b.size();
        if (size >= 3) {
            Iterator<f3> it = this.f34443b.iterator();
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            while (it.hasNext()) {
                float e6 = it.next().e();
                f7 += e6;
                f8 += e6 * e6;
            }
            float f9 = f7 / size;
            float sqrt = (float) Math.sqrt((f8 / r1) - (f9 * f9));
            a aVar = null;
            Collections.sort(this.f34443b, new c(f9, aVar));
            float max = Math.max(0.36f * f9, sqrt);
            int i8 = 0;
            while (i8 < this.f34443b.size() && this.f34443b.size() > 3) {
                if (Math.abs(this.f34443b.get(i8).e() - f9) > max) {
                    this.f34443b.remove(i8);
                    i8--;
                }
                i8++;
            }
            int size2 = this.f34443b.size();
            while (this.f34443b.iterator().hasNext()) {
                f6 += r3.next().a();
            }
            float f10 = f6 / size2;
            while (i6 < this.f34443b.size() && this.f34443b.size() > 3) {
                if (this.f34443b.get(i6).a() <= 0.5f * f10) {
                    this.f34443b.remove(i6);
                    i6--;
                }
                i6++;
            }
            Collections.sort(this.f34443b, new b(aVar));
            List<f3> list = this.f34443b;
            return (f3[]) list.toArray(new f3[list.size()]);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    protected final boolean a(int[] iArr, int i6, int i7) {
        int i8 = 0;
        int i9 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a6 = (int) a(iArr, i7);
        float d6 = d(i6, a6, i9);
        if (!Float.isNaN(d6)) {
            int i10 = (int) d6;
            float c6 = c(a6, i10, i9);
            if (!Float.isNaN(c6)) {
                int i11 = (int) c6;
                if (a(i10, i11, i9) && b(i10, i11, i9)) {
                    float f6 = i9 / 5.0f;
                    while (true) {
                        if (i8 < this.f34443b.size()) {
                            f3 f3Var = this.f34443b.get(i8);
                            if (f3Var.b(f6, d6, c6)) {
                                this.f34443b.set(i8, f3Var.c(d6, c6, f6));
                                break;
                            }
                            i8++;
                        } else {
                            f3 f3Var2 = new f3(c6, d6, f6);
                            this.f34443b.add(f3Var2);
                            v6 v6Var = this.f34445d;
                            if (v6Var != null) {
                                v6Var.a(f3Var2);
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
