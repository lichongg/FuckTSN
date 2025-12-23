package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class r0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f47057a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.f v5;
        v5 = v0.v(this.f47057a, ((Number) obj).intValue());
        return v5;
    }

    public r0(v0 v0Var) {
        this.f47057a = v0Var;
    }
}
