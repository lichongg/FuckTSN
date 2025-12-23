package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class b1 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final c1 f44674a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f44675b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k d6;
        d6 = c1.d(this.f44674a, this.f44675b);
        return d6;
    }

    public b1(c1 c1Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        this.f44674a = c1Var;
        this.f44675b = gVar;
    }
}
