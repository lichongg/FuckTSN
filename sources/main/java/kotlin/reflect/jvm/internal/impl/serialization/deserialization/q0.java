package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class q0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f47055a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.f f6;
        f6 = v0.f(this.f47055a, ((Number) obj).intValue());
        return f6;
    }

    public q0(v0 v0Var) {
        this.f47055a = v0Var;
    }
}
