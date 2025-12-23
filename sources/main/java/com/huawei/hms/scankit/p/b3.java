package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum b3 {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: f, reason: collision with root package name */
    private static final b3[] f34018f;

    /* renamed from: a, reason: collision with root package name */
    private final int f34020a;

    public int a() {
        return this.f34020a;
    }

    static {
        b3 b3Var = L;
        b3 b3Var2 = M;
        b3 b3Var3 = Q;
        f34018f = new b3[]{b3Var2, b3Var, H, b3Var3};
    }

    public static b3 a(int i6) {
        if (i6 >= 0) {
            b3[] b3VarArr = f34018f;
            if (i6 < b3VarArr.length) {
                return b3VarArr[i6];
            }
        }
        throw new IllegalArgumentException();
    }

    b3(int i6) {
        this.f34020a = i6;
    }
}
