package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.e1;

/* loaded from: D:\Downloads\app\classes8.dex */
class g implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f45714a;

    /* renamed from: b, reason: collision with root package name */
    private final h f45715b;

    /* renamed from: c, reason: collision with root package name */
    private final e1 f45716c;

    /* renamed from: d, reason: collision with root package name */
    private final a f45717d;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        e1 k6;
        k6 = h.k(this.f45714a, this.f45715b, this.f45716c, this.f45717d, (kotlin.reflect.jvm.internal.impl.types.checker.g) obj);
        return k6;
    }

    public g(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, h hVar, e1 e1Var, a aVar) {
        this.f45714a = dVar;
        this.f45715b = hVar;
        this.f45716c = e1Var;
        this.f45717d = aVar;
    }
}
