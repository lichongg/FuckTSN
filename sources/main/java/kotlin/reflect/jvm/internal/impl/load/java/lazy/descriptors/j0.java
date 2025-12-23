package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* loaded from: D:\Downloads\app\classes8.dex */
class j0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final t0 f45586a;

    /* renamed from: b, reason: collision with root package name */
    private final y3.n f45587b;

    /* renamed from: c, reason: collision with root package name */
    private final Ref.ObjectRef f45588c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g d02;
        d02 = t0.d0(this.f45586a, this.f45587b, this.f45588c);
        return d02;
    }

    public j0(t0 t0Var, y3.n nVar, Ref.ObjectRef objectRef) {
        this.f45586a = t0Var;
        this.f45587b = nVar;
        this.f45588c = objectRef;
    }
}
