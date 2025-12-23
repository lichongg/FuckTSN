package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f34536a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f34537b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f34538c;

    /* renamed from: d, reason: collision with root package name */
    private static int f34539d;

    /* renamed from: e, reason: collision with root package name */
    private static LinkedList<i2> f34540e = new LinkedList<>();

    /* renamed from: f, reason: collision with root package name */
    private static LinkedList<c6> f34541f = new LinkedList<>();

    /* renamed from: g, reason: collision with root package name */
    private static LinkedList<c6> f34542g = new LinkedList<>();

    /* renamed from: h, reason: collision with root package name */
    private static boolean f34543h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f34544i;

    /* renamed from: j, reason: collision with root package name */
    private static long f34545j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f34546k;

    public static s6 a(List<BarcodeFormat> list, n1 n1Var) {
        if (list.size() > 0) {
            return n1Var.e(list, null);
        }
        return null;
    }

    public static s6[] b(Bitmap bitmap, x6 x6Var) {
        byte[] bArr = null;
        try {
            x6Var.f35006a = bitmap.getWidth();
            x6Var.f35007b = bitmap.getHeight();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(allocate);
            allocate.flip();
            bArr = new m6(x6Var.f35006a, x6Var.f35007b, allocate).b();
            allocate.clear();
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
        } catch (Exception unused2) {
            o4.b("exception", "Exception");
        } catch (OutOfMemoryError unused3) {
            o4.b("exception", "OutOfMemoryError");
        } catch (UnsatisfiedLinkError unused4) {
            o4.b("exception", "UnsatisfiedLinkError");
        } catch (UnsupportedOperationException unused5) {
            o4.b("exception", "UnsupportedArgumentException");
        }
        return c(bArr, x6Var);
    }

    static {
        f34543h = !r3.f34730a || r3.f34732c;
        f34544i = false;
        f34546k = false;
        if (DynamicModuleInitializer.getContext() != null) {
            y4.c(DynamicModuleInitializer.getContext(), "detect.ms");
            y4.a(DynamicModuleInitializer.getContext(), "angle.ms");
            y4.b(DynamicModuleInitializer.getContext(), "corner.ms");
        }
    }

    public static s6[] c(byte[] bArr, x6 x6Var) {
        s6[] s6VarArr = new s6[0];
        try {
            return a(bArr, x6Var, true);
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
            return s6VarArr;
        } catch (UnsatisfiedLinkError unused2) {
            o4.b("exception", "UnsatisfiedLinkError");
            return s6VarArr;
        } catch (UnsupportedOperationException unused3) {
            o4.b("exception", "UnsupportedArgumentException");
            return s6VarArr;
        } catch (Exception unused4) {
            o4.b("exception", "Exception");
            return s6VarArr;
        } catch (OutOfMemoryError unused5) {
            o4.b("exception", "OutOfMemoryError");
            return s6VarArr;
        }
    }

    public static s6[] a(Bitmap bitmap, x6 x6Var) {
        o4.b("scankit mul", "start decodeMultiCode pre");
        byte[] bArr = null;
        try {
            x6Var.f35006a = bitmap.getWidth();
            x6Var.f35007b = bitmap.getHeight();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(allocate);
            allocate.flip();
            bArr = new m6(x6Var.f35006a, x6Var.f35007b, allocate).b();
            allocate.clear();
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
        } catch (UnsupportedOperationException unused2) {
            o4.b("exception", "UnsupportedArgumentException");
        } catch (Exception unused3) {
            o4.b("exception", "Exception");
        } catch (OutOfMemoryError unused4) {
            o4.b("exception", "OutOfMemoryError");
        } catch (UnsatisfiedLinkError unused5) {
            o4.b("exception", "UnsatisfiedLinkError");
        }
        o4.b("scankit mul", "end decodeMultiCode pre");
        return b(bArr, x6Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f3  */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.scankit.p.s6[] b(com.huawei.hms.scankit.p.p4 r32, com.huawei.hms.scankit.p.x6 r33) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.m1.b(com.huawei.hms.scankit.p.p4, com.huawei.hms.scankit.p.x6):com.huawei.hms.scankit.p.s6[]");
    }

    public static s6[] a(ByteBuffer byteBuffer, x6 x6Var) {
        return b(byteBuffer.array(), x6Var);
    }

    public static s6[] a(p4 p4Var, x6 x6Var) {
        s6 a6;
        boolean z5;
        List arrayList = new ArrayList();
        r3.a(x6Var);
        r3.a(1);
        if (x6Var.f35006a >= 30 && x6Var.f35007b >= 30 && p4Var != null) {
            List<List<BarcodeFormat>> a7 = n3.a(x6Var.f35008c);
            List<BarcodeFormat> list = a7.get(0);
            List<BarcodeFormat> list2 = a7.get(1);
            List<BarcodeFormat> list3 = a7.get(2);
            List<BarcodeFormat> list4 = a7.get(3);
            n1 n1Var = new n1(p4Var);
            o4.b("scankit mul", "start detectCodes");
            List<i2> a8 = n1Var.a(1, r3.f34746q);
            o4.b("scankit mul", "end detectCodes");
            if (a8.size() > 0) {
                arrayList = a(a8, n1Var, a7);
            } else if ((r3.f34732c || !r3.f34730a) && (a6 = a(n1Var, list, list2, list3, list4)) != null && a6.k() != null) {
                arrayList.add(a6);
            }
            List<s6> a9 = v7.a(arrayList);
            if (r3.f34736g && a9.size() > 0 && a9.get(0).k() != null) {
                return (s6[]) a9.toArray(new s6[0]);
            }
            float f6 = 1.0f;
            if (r3.f34732c || !r3.f34736g) {
                z5 = false;
            } else {
                if (a9.size() > 0) {
                    z5 = a9.get(0).p();
                    f6 = Math.max(1.0f, a9.get(0).l());
                } else {
                    z5 = false;
                }
                int i6 = r3.f34740k - 1;
                if (i6 <= 0) {
                    i6 = 0;
                }
                r3.f34740k = i6;
                if (a8.size() > 0) {
                    z5 = z5 || n1Var.c(a8);
                }
                if (z5 && n1Var.c(n1Var.a()) < 20.0f) {
                    z5 = false;
                }
                if (z5) {
                    f6 = Math.max(f6, n1Var.e());
                }
            }
            if (r3.f34736g && z5) {
                s6 s6Var = new s6(f6);
                s6Var.c(true);
                a9.clear();
                a9.add(s6Var);
                return (s6[]) a9.toArray(new s6[0]);
            }
            if (a9.size() > 0) {
                return (s6[]) a9.toArray(new s6[0]);
            }
            return new s6[0];
        }
        throw new IllegalArgumentException("width or Height is Illeagle");
    }

    private static s6 a(n1 n1Var, List<BarcodeFormat> list, List<BarcodeFormat> list2, List<BarcodeFormat> list3, List<BarcodeFormat> list4) {
        s6 f6 = list.size() > 0 ? n1Var.f(list, null) : null;
        if (a(f6) && list3.size() > 0) {
            f6 = n1Var.d(list3, null);
        }
        if (a(f6) && list2.size() > 0 && f34543h) {
            f6 = n1Var.a(list2, (i2) null);
        }
        return (!a(f6) || list4.size() <= 0) ? f6 : n1Var.b(list4, (i2) null);
    }

    public static List<s6> a(List<i2> list, n1 n1Var, List<List<BarcodeFormat>> list2) {
        s6 g6;
        s6 s6Var;
        List<BarcodeFormat> list3;
        float max;
        List<BarcodeFormat> list4 = list2.get(0);
        List<BarcodeFormat> list5 = list2.get(1);
        List<BarcodeFormat> list6 = list2.get(2);
        List<BarcodeFormat> list7 = list2.get(3);
        List<BarcodeFormat> list8 = list2.get(4);
        List<BarcodeFormat> list9 = list2.get(5);
        List<BarcodeFormat> list10 = list2.get(6);
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 < list.size()) {
            n1Var.f34587i.a();
            i2 i2Var = list.get(i6);
            boolean z5 = i2Var.g() == 5.0f;
            boolean z6 = i2Var.g() == 1.0f;
            boolean z7 = i2Var.g() == 3.0f;
            boolean z8 = i2Var.g() == 2.0f;
            boolean z9 = i2Var.g() == 4.0f;
            boolean z10 = i2Var.g() == 6.0f;
            boolean z11 = i2Var.g() == 7.0f;
            if (r3.f34731b) {
                z5 = i2Var.g() == 1.0f;
                z6 = i2Var.g() == 2.0f;
                z7 = i2Var.g() == 2.0f;
                z9 = i2Var.g() == 1.0f;
                s6Var = null;
                z8 = i2Var.g() == 2.0f;
            } else {
                s6Var = null;
            }
            o4.d("scankit mul", "start cropAndRotate");
            n1Var.b(i2Var);
            o4.d("scankit mul", "end cropAndRotate");
            o4.d("scankit mul", "start decode");
            s6 e6 = (a(s6Var) && list4.size() > 0 && z6) ? n1Var.e(list4, i2Var) : s6Var;
            if (a(e6) && list7.size() > 0 && z7) {
                e6 = n1Var.b(list7, i2Var);
            }
            if (a(e6) && list6.size() > 0 && z9) {
                e6 = n1Var.d(list6, i2Var);
            }
            if (a(e6) && list8.size() > 0 && z8) {
                e6 = n1Var.b(list8, i2Var);
            }
            if (a(e6) && list5.size() > 0 && z5) {
                e6 = n1Var.a(list5, i2Var);
            }
            if (a(e6) && list9.size() > 0 && z11) {
                e6 = n1Var.c(list9, i2Var);
            }
            if (a(e6) && list10.size() > 0 && z10) {
                list3 = list5;
                if (i2Var.h() > 0.6d || r3.f34732c) {
                    s6 h6 = n1Var.h(list10, i2Var);
                    e6 = (h6 == null || n1.b(n1Var.a(), i2Var)) ? h6 : s6Var;
                }
            } else {
                list3 = list5;
            }
            if (r3.f34736g && e6 != null && n1Var.b()) {
                if (n1Var.e() > 0.0f) {
                    max = Math.max(1.0f, n1Var.e());
                } else {
                    max = Math.max(1.0f, Math.max(n1Var.c(), n1Var.d()));
                }
                s6 s6Var2 = new s6(max);
                s6Var2.c(true);
                arrayList.add(s6Var2);
            } else if (e6 != null && e6.k() != null) {
                arrayList.add(e6);
            }
            i6++;
            list5 = list3;
        }
        if (arrayList.size() == 0 && list4.size() > 0 && !r3.f34736g && (g6 = n1Var.g(list4, null)) != null && g6.k() != null) {
            arrayList.add(g6);
        }
        o4.d("scankit mul", "end decode");
        return arrayList;
    }

    public static s6 b(List<i2> list, n1 n1Var, List<List<BarcodeFormat>> list2) {
        List<BarcodeFormat> list3;
        List<BarcodeFormat> list4 = list2.get(0);
        List<BarcodeFormat> list5 = list2.get(1);
        List<BarcodeFormat> list6 = list2.get(2);
        List<BarcodeFormat> list7 = list2.get(3);
        List<BarcodeFormat> list8 = list2.get(4);
        List<BarcodeFormat> list9 = list2.get(5);
        List<BarcodeFormat> list10 = list2.get(6);
        s6 s6Var = null;
        int i6 = 0;
        while (i6 < list.size()) {
            if (i6 > 0) {
                n1Var.f34587i.a();
            }
            i2 i2Var = list.get(i6);
            boolean z5 = i2Var.g() == 5.0f;
            boolean z6 = i2Var.g() == 1.0f;
            boolean z7 = i2Var.g() == 2.0f;
            boolean z8 = i2Var.g() == 3.0f;
            boolean z9 = i2Var.g() == 4.0f;
            boolean z10 = i2Var.g() == 6.0f;
            boolean z11 = i2Var.g() == 7.0f;
            if (r3.f34731b) {
                z5 = i2Var.g() == 1.0f;
                z6 = i2Var.g() == 2.0f;
                z7 = i2Var.g() == 2.0f;
                z8 = i2Var.g() == 2.0f;
                z9 = i2Var.g() == 1.0f;
            }
            n1Var.b(i2Var);
            if (a(s6Var) && list4.size() > 0 && z6) {
                f34537b = true;
                s6Var = n1Var.e(list4, i2Var);
            }
            if (a(s6Var) && list7.size() > 0 && z8) {
                s6Var = n1Var.b(list7, i2Var);
            }
            if (a(s6Var) && list8.size() > 0 && z7) {
                s6Var = n1Var.b(list8, i2Var);
            }
            if (a(s6Var) && list6.size() > 0 && z9) {
                s6Var = n1Var.d(list6, i2Var);
            }
            if (a(s6Var) && list5.size() > 0 && z5) {
                s6Var = n1Var.a(list5, i2Var);
            }
            if (a(s6Var) && list9.size() > 0 && z11) {
                s6Var = n1Var.c(list9, i2Var);
            }
            if (a(s6Var) && list10.size() > 0 && z10) {
                list3 = list4;
                if (i2Var.h() > 0.6d || r3.f34732c) {
                    s6 h6 = n1Var.h(list10, i2Var);
                    s6Var = (h6 == null || n1.b(n1Var.a(), i2Var)) ? h6 : null;
                }
            } else {
                list3 = list4;
            }
            if (s6Var != null && s6Var.k() != null) {
                return s6Var;
            }
            i6++;
            list4 = list3;
        }
        return s6Var;
    }

    private static p4 a(byte[] bArr, x6 x6Var) {
        int i6 = x6Var.f35006a;
        int i7 = x6Var.f35007b;
        if (x6Var.f35009d) {
            int i8 = i6 * i7;
            byte[] bArr2 = new byte[i8];
            float f6 = 0.0f;
            for (int i9 = 0; i9 < i7; i9++) {
                for (int i10 = 0; i10 < i6; i10++) {
                    f6 += r9 & 255;
                    bArr2[(((i10 * i7) + i7) - i9) - 1] = bArr[(i9 * i6) + i10];
                }
            }
            float f7 = f6 / i8;
            if (f7 < 25.0f) {
                r3.f34734e = true;
            } else if (f7 > 215.0f) {
                r3.f34733d = true;
            }
            x6Var.f35006a = i7;
            x6Var.f35007b = i6;
            return new e6(bArr2, i7, i6, 0, 0, i7, i6, false);
        }
        return new e6(bArr, i6, i7, 0, 0, i6, i7, false);
    }

    public static void a(boolean z5) {
        r3.f34730a = z5;
    }

    private static void a() {
        f34538c = false;
        f34540e = new LinkedList<>();
        f34541f = new LinkedList<>();
        f34542g = new LinkedList<>();
        r3.f34733d = false;
        r3.f34734e = false;
    }

    public static s6[] b(byte[] bArr, x6 x6Var) {
        s6[] a6;
        o4.b("scankit mul", "start decodeMultiCode");
        s6[] s6VarArr = new s6[0];
        try {
            a6 = a(bArr, x6Var, false);
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
        } catch (Exception unused2) {
            o4.b("exception", "Exception");
        } catch (OutOfMemoryError unused3) {
            o4.b("exception", "OutOfMemoryError");
        } catch (UnsatisfiedLinkError unused4) {
            o4.b("exception", "UnsatisfiedLinkError");
        } catch (UnsupportedOperationException unused5) {
            o4.b("exception", "UnsupportedArgumentException");
        }
        if (r3.f34736g && a6.length > 0 && a6[0].p()) {
            return a6;
        }
        int length = a6.length;
        int[] iArr = new int[length];
        int i6 = 0;
        int i7 = 0;
        while (i6 < a6.length) {
            int i8 = i6 + 1;
            for (int i9 = i8; i9 < a6.length; i9++) {
                if (v7.a(a6[i6].j(), a6[i9].j()) > 0.7d) {
                    iArr[i9] = 1;
                    i7++;
                }
            }
            i6 = i8;
        }
        int length2 = a6.length - i7;
        s6VarArr = new s6[length2];
        for (int i10 = 0; i10 < length2; i10++) {
            int i11 = i10;
            while (i11 < length) {
                if (iArr[i11] != 1) {
                    break;
                }
                i11++;
            }
            s6VarArr[i10] = a6[i11];
        }
        o4.b("scankit mul", "end decodeMultiCode");
        return s6VarArr;
    }

    public static s6[] a(byte[] bArr, x6 x6Var, boolean z5) {
        int i6;
        int i7;
        o4.d("scankit mul", "start pre");
        LinkedList linkedList = new LinkedList();
        a();
        int min = Math.min(x6Var.f35006a, x6Var.f35007b);
        float f6 = min;
        float max = Math.max(x6Var.f35006a, x6Var.f35007b) / f6;
        int i8 = (int) (f6 * 1.78f);
        p4 a6 = a(bArr, x6Var);
        o4.d("Scankit", "init " + f34546k);
        if ((r3.f34733d || r3.f34734e) && f34546k) {
            return new s6[0];
        }
        f34546k = true;
        x6 x6Var2 = new x6(x6Var);
        o4.d("scankit mul", "end pre");
        if (min > 500 && x6Var.f35006a >= x6Var.f35007b && x6Var.f35010e && max > 3.0f) {
            f34538c = true;
            x6Var2.f35006a = i8;
            int i9 = x6Var.f35006a - 1;
            while (i9 >= 0) {
                i9 -= i8;
                int i10 = i9 >= 0 ? i9 : 0;
                x6Var2.f35013h = i10;
                x6Var2.f35014i = 0;
                a(a6, i10, 0, x6Var2);
            }
            Collections.sort(f34540e);
            s6 a7 = a(a6, x6Var2, linkedList, z5, true, i8);
            if (a7 != null) {
                return new s6[]{a7};
            }
            f34540e = new LinkedList<>();
            Collections.sort(f34541f);
            HashSet hashSet = new HashSet();
            Iterator<c6> it = f34541f.iterator();
            while (it.hasNext()) {
                c6 next = it.next();
                if (hashSet.add(Integer.valueOf(next.f34089b)) && (i7 = next.f34089b) >= i8 && i7 <= (x6Var.f35006a - 1) - i8) {
                    x6Var2.f35006a = i8;
                    x6Var2.f35015j = true;
                    int i11 = i7 - (i8 / 2);
                    x6Var2.f35013h = i11;
                    x6Var2.f35014i = 0;
                    a(a6, i11, 0, x6Var2);
                }
            }
            Collections.sort(f34540e);
            s6 a8 = a(a6, x6Var2, linkedList, z5, true, i8);
            if (a8 != null) {
                return new s6[]{a8};
            }
        } else if (min > 500 && x6Var.f35010e && max > 3.0f) {
            f34538c = true;
            x6Var2.f35007b = i8;
            int i12 = x6Var.f35007b - 1;
            while (i12 >= 0) {
                i12 -= i8;
                int i13 = i12 >= 0 ? i12 : 0;
                x6Var2.f35013h = 0;
                x6Var2.f35014i = i13;
                a(a6, 0, i13, x6Var2);
            }
            Collections.sort(f34540e);
            s6 a9 = a(a6, x6Var, linkedList, z5, false, i8);
            if (a9 != null) {
                return new s6[]{a9};
            }
            f34540e = new LinkedList<>();
            Collections.sort(f34542g);
            HashSet hashSet2 = new HashSet();
            Iterator<c6> it2 = f34542g.iterator();
            while (it2.hasNext()) {
                c6 next2 = it2.next();
                if (hashSet2.add(Integer.valueOf(next2.f34089b)) && (i6 = next2.f34089b) >= i8 && i6 <= (x6Var.f35007b - 1) - i8) {
                    int i14 = i6 - (i8 / 2);
                    x6Var2.f35007b = i8;
                    x6Var2.f35015j = true;
                    x6Var2.f35013h = 0;
                    x6Var2.f35014i = i14;
                    a(a6, 0, i14, x6Var2);
                }
            }
            Collections.sort(f34540e);
            s6 a10 = a(a6, x6Var, linkedList, z5, false, i8);
            if (a10 != null) {
                return new s6[]{a10};
            }
        } else {
            f34538c = false;
            if (z5) {
                return b(a6, x6Var);
            }
            return a(a6, x6Var);
        }
        s6[] s6VarArr = new s6[linkedList.size()];
        linkedList.toArray(s6VarArr);
        return s6VarArr;
    }

    private static void a(p4 p4Var, int i6, int i7, x6 x6Var) {
        r3.a(x6Var);
        byte[] b6 = p4Var.a(i6, i7, x6Var.f35006a, x6Var.f35007b).b();
        int i8 = x6Var.f35006a;
        int i9 = x6Var.f35007b;
        List<i2> a6 = new n1(new e6(b6, i8, i9, 0, 0, i8, i9, false)).a(0, r3.f34746q);
        if (!x6Var.f35015j) {
            a(a6, x6Var);
        }
        for (i2 i2Var : a6) {
            i2Var.a(x6Var.f35013h, x6Var.f35014i);
            f34540e.offer(i2Var);
        }
    }

    private static s6 a(p4 p4Var, x6 x6Var, LinkedList<s6> linkedList, boolean z5, boolean z6, int i6) {
        n1 n1Var = new n1(p4Var);
        List<List<BarcodeFormat>> a6 = n3.a(x6Var.f35008c);
        if (z5) {
            s6 b6 = b(f34540e, n1Var, a6);
            if (b6 == null || b6.k() == null) {
                return null;
            }
            return b6;
        }
        Iterator<s6> it = a(f34540e, n1Var, a6).iterator();
        while (it.hasNext()) {
            linkedList.offer(it.next());
        }
        return null;
    }

    private static void a(List<i2> list, x6 x6Var) {
        for (i2 i2Var : list) {
            if (i2Var.d() < x6Var.f35006a * 0.1f) {
                f34541f.offer(new c6(i2Var, x6Var.f35013h));
            } else {
                float d6 = i2Var.d() + i2Var.f();
                int i6 = x6Var.f35006a;
                if (d6 > i6 * 0.9f) {
                    f34541f.offer(new c6(i2Var, x6Var.f35013h + i6));
                }
            }
            if (i2Var.e() < x6Var.f35007b * 0.1f) {
                f34542g.offer(new c6(i2Var, x6Var.f35014i));
            } else {
                float e6 = i2Var.e() + i2Var.c();
                int i7 = x6Var.f35007b;
                if (e6 > i7 * 0.9f) {
                    f34542g.offer(new c6(i2Var, x6Var.f35014i + i7));
                }
            }
        }
    }

    private static boolean a(s6 s6Var) {
        return s6Var == null || s6Var.k() == null;
    }
}
