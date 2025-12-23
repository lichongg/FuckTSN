package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.h0;

/* loaded from: D:\Downloads\app\classes8.dex */
class s0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.t0 f47580a;

    /* renamed from: b, reason: collision with root package name */
    private final h0.b f47581b;

    /* renamed from: c, reason: collision with root package name */
    private final h0 f47582c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        Type k02;
        k02 = h0.b.k0(this.f47580a, this.f47581b, this.f47582c);
        return k02;
    }

    public s0(kotlin.reflect.jvm.internal.impl.types.t0 t0Var, h0.b bVar, h0 h0Var) {
        this.f47580a = t0Var;
        this.f47581b = bVar;
        this.f47582c = h0Var;
    }
}
