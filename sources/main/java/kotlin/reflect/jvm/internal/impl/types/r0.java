package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class r0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final s0 f47325a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        e1 k6;
        k6 = s0.k(this.f47325a, (kotlin.reflect.jvm.internal.impl.types.checker.g) obj);
        return k6;
    }

    public r0(s0 s0Var) {
        this.f47325a = s0Var;
    }
}
