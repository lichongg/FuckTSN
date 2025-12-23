package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum c3 {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: f, reason: collision with root package name */
    private static final c3[] f34079f;

    /* renamed from: a, reason: collision with root package name */
    private final int f34081a;

    static {
        c3 c3Var = L;
        c3 c3Var2 = M;
        c3 c3Var3 = Q;
        f34079f = new c3[]{c3Var2, c3Var, H, c3Var3};
    }

    public static c3 a(int i6) {
        if (i6 >= 0) {
            c3[] c3VarArr = f34079f;
            if (i6 < c3VarArr.length) {
                return c3VarArr[i6];
            }
        }
        throw new IllegalArgumentException();
    }

    c3(int i6) {
        this.f34081a = i6;
    }
}
