package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.t0;

/* loaded from: D:\Downloads\app\classes8.dex */
class z implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final t0 f46691a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        t0 b6;
        b6 = a0.b(this.f46691a, (kotlin.reflect.jvm.internal.impl.descriptors.f0) obj);
        return b6;
    }

    public z(t0 t0Var) {
        this.f46691a = t0Var;
    }
}
