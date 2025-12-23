package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q6 {

    /* renamed from: a, reason: collision with root package name */
    private final o3 f34715a;

    /* renamed from: b, reason: collision with root package name */
    private final List<p3> f34716b;

    private p3 a(int i6) {
        if (i6 >= this.f34716b.size()) {
            List<p3> list = this.f34716b;
            p3 p3Var = list.get(list.size() - 1);
            for (int size = this.f34716b.size(); size <= i6; size++) {
                o3 o3Var = this.f34715a;
                p3Var = p3Var.c(new p3(o3Var, new int[]{1, o3Var.a((size - 1) + o3Var.a())}));
                this.f34716b.add(p3Var);
            }
        }
        return this.f34716b.get(i6);
    }

    public q6(o3 o3Var) {
        this.f34715a = o3Var;
        ArrayList arrayList = new ArrayList();
        this.f34716b = arrayList;
        arrayList.add(new p3(o3Var, new int[]{1}));
    }

    public void a(int[] iArr, int i6) {
        if (i6 != 0) {
            int length = iArr.length - i6;
            if (length > 0) {
                p3 a6 = a(i6);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] a7 = new p3(this.f34715a, iArr2).a(i6, 1).b(a6)[1].a();
                int length2 = i6 - a7.length;
                for (int i7 = 0; i7 < length2; i7++) {
                    iArr[length + i7] = 0;
                }
                System.arraycopy(a7, 0, iArr, length + length2, a7.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
