package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class c4 {

    /* renamed from: b, reason: collision with root package name */
    static final String[] f34082b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: c, reason: collision with root package name */
    static final int[][] f34083c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f34084d;

    /* renamed from: e, reason: collision with root package name */
    static final int[][] f34085e;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f34086a;

    public r a() {
        int i6;
        Collection<b7> singletonList = Collections.singletonList(b7.f34042e);
        int i7 = 0;
        while (true) {
            byte[] bArr = this.f34086a;
            if (i7 >= bArr.length) {
                return ((b7) Collections.min(singletonList, new a())).a(this.f34086a);
            }
            int i8 = i7 + 1;
            byte b6 = i8 < bArr.length ? bArr[i8] : (byte) 0;
            byte b7 = bArr[i7];
            if (b7 == 13) {
                if (b6 == 10) {
                    i6 = 2;
                }
                i6 = 0;
            } else if (b7 == 44) {
                if (b6 == 32) {
                    i6 = 4;
                }
                i6 = 0;
            } else if (b7 != 46) {
                if (b7 == 58 && b6 == 32) {
                    i6 = 5;
                }
                i6 = 0;
            } else {
                if (b6 == 32) {
                    i6 = 3;
                }
                i6 = 0;
            }
            if (i6 > 0) {
                singletonList = a(singletonList, i7, i6);
                i7 = i8;
            } else {
                singletonList = a(singletonList, i7);
            }
            i7++;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<State> implements Comparator<b7> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b7 b7Var, b7 b7Var2) {
            return b7Var.b() - b7Var2.b();
        }
    }

    static {
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, 5, 256);
        f34084d = iArr;
        iArr[0][32] = 1;
        for (int i6 = 65; i6 <= 90; i6++) {
            f34084d[0][i6] = i6 - 63;
        }
        f34084d[1][32] = 1;
        for (int i7 = 97; i7 <= 122; i7++) {
            f34084d[1][i7] = i7 - 95;
        }
        f34084d[2][32] = 1;
        for (int i8 = 48; i8 <= 57; i8++) {
            f34084d[2][i8] = i8 - 46;
        }
        int[] iArr2 = f34084d[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i9 = 0; i9 < 28; i9++) {
            f34084d[3][iArr3[i9]] = i9;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i10 = 0; i10 < 31; i10++) {
            int i11 = iArr4[i10];
            if (i11 > 0) {
                f34084d[4][i11] = i10;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) cls, 6, 6);
        f34085e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f34085e;
        if (w7.a(iArr7, 0) && w7.a(iArr7[0], 4)) {
            iArr7[0][4] = 0;
        }
        if (w7.a(iArr7, 1) && w7.a(iArr7[1], 4)) {
            iArr7[1][4] = 0;
        }
        if (w7.a(iArr7, 1) && w7.a(iArr7[1], 0)) {
            iArr7[1][0] = 28;
        }
        if (w7.a(iArr7, 3) && w7.a(iArr7[3], 4)) {
            iArr7[3][4] = 0;
        }
        if (w7.a(iArr7, 2) && w7.a(iArr7[2], 4)) {
            iArr7[2][4] = 0;
        }
        if (w7.a(iArr7, 2) && w7.a(iArr7[2], 0)) {
            iArr7[2][0] = 15;
        }
    }

    public c4(byte[] bArr) {
        this.f34086a = bArr;
    }

    private Collection<b7> a(Iterable<b7> iterable, int i6) {
        LinkedList linkedList = new LinkedList();
        Iterator<b7> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i6, linkedList);
        }
        return a(linkedList);
    }

    private void a(b7 b7Var, int i6, Collection<b7> collection) {
        if (w7.a(this.f34086a, i6)) {
            char c6 = (char) (this.f34086a[i6] & 255);
            int[][] iArr = f34084d;
            boolean z5 = w7.a(iArr, b7Var.c()) && w7.a(iArr[b7Var.c()], (int) c6) && iArr[b7Var.c()][c6] > 0;
            b7 b7Var2 = null;
            for (int i7 = 0; i7 <= 4; i7++) {
                int[][] iArr2 = f34084d;
                int i8 = (w7.a(iArr2, i7) && w7.a(iArr2[i7], (int) c6)) ? iArr2[i7][c6] : 0;
                if (i8 > 0) {
                    if (b7Var2 == null) {
                        b7Var2 = b7Var.b(i6);
                    }
                    if (!z5 || i7 == b7Var.c() || i7 == 2) {
                        collection.add(b7Var2.a(i7, i8));
                    }
                    if (!z5 && f34085e[b7Var.c()][i7] >= 0) {
                        collection.add(b7Var2.b(i7, i8));
                    }
                }
            }
            int[][] iArr3 = f34084d;
            if (w7.a(iArr3, b7Var.c()) && w7.a(iArr3[b7Var.c()], (int) c6)) {
                if (b7Var.a() > 0 || iArr3[b7Var.c()][c6] == 0) {
                    collection.add(b7Var.a(i6));
                }
            }
        }
    }

    private static Collection<b7> a(Iterable<b7> iterable, int i6, int i7) {
        LinkedList linkedList = new LinkedList();
        Iterator<b7> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i6, i7, linkedList);
        }
        return a(linkedList);
    }

    private static void a(b7 b7Var, int i6, int i7, Collection<b7> collection) {
        b7 b6 = b7Var.b(i6);
        collection.add(b6.a(4, i7));
        if (b7Var.c() != 4) {
            collection.add(b6.b(4, i7));
        }
        if (i7 == 3 || i7 == 4) {
            collection.add(b6.a(2, 16 - i7).a(2, 1));
        }
        if (b7Var.a() > 0) {
            collection.add(b7Var.a(i6).a(i6 + 1));
        }
    }

    private static Collection<b7> a(Iterable<b7> iterable) {
        LinkedList linkedList = new LinkedList();
        for (b7 b7Var : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (it.hasNext()) {
                    b7 b7Var2 = (b7) it.next();
                    if (b7Var2.a(b7Var)) {
                        break;
                    }
                    if (b7Var.a(b7Var2)) {
                        it.remove();
                    }
                } else {
                    linkedList.add(b7Var);
                    break;
                }
            }
        }
        return linkedList;
    }
}
