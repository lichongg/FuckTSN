package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* loaded from: D:\Downloads\app\classes8.dex */
class i0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final t0 f45574a;

    /* renamed from: b, reason: collision with root package name */
    private final y3.n f45575b;

    /* renamed from: c, reason: collision with root package name */
    private final Ref.ObjectRef f45576c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.storage.j c02;
        c02 = t0.c0(this.f45574a, this.f45575b, this.f45576c);
        return c02;
    }

    public i0(t0 t0Var, y3.n nVar, Ref.ObjectRef objectRef) {
        this.f45574a = t0Var;
        this.f45575b = nVar;
        this.f45576c = objectRef;
    }
}
