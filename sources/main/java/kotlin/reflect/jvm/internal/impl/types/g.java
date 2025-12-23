package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class g implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final TypeCheckerState f47252a;

    /* renamed from: b, reason: collision with root package name */
    private final e4.r f47253b;

    /* renamed from: c, reason: collision with root package name */
    private final e4.h f47254c;

    /* renamed from: d, reason: collision with root package name */
    private final e4.h f47255d;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        boolean y5;
        y5 = h.y(this.f47252a, this.f47253b, this.f47254c, this.f47255d);
        return Boolean.valueOf(y5);
    }

    public g(TypeCheckerState typeCheckerState, e4.r rVar, e4.h hVar, e4.h hVar2) {
        this.f47252a = typeCheckerState;
        this.f47253b = rVar;
        this.f47254c = hVar;
        this.f47255d = hVar2;
    }
}
