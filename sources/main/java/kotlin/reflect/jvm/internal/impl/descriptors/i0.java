package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class i0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final k0 f44689a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        l0 e6;
        e6 = k0.e(this.f44689a, (kotlin.reflect.jvm.internal.impl.name.c) obj);
        return e6;
    }

    public i0(k0 k0Var) {
        this.f44689a = k0Var;
    }
}
