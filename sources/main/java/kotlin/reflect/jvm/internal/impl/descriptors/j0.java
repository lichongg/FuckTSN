package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;

/* loaded from: D:\Downloads\app\classes8.dex */
class j0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final k0 f44927a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        d c6;
        c6 = k0.c(this.f44927a, (k0.a) obj);
        return c6;
    }

    public j0(k0 k0Var) {
        this.f44927a = k0Var;
    }
}
