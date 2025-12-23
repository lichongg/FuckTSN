package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i6 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f34410a;

    public void a(u6[] u6VarArr) {
        if (!this.f34410a || u6VarArr == null || u6VarArr.length < 3) {
            return;
        }
        u6 u6Var = u6VarArr[0];
        u6VarArr[0] = u6VarArr[2];
        u6VarArr[2] = u6Var;
    }

    i6(boolean z5) {
        this.f34410a = z5;
    }
}
