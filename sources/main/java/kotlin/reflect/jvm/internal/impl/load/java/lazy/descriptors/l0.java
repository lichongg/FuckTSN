package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class l0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final t0 f45592a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Collection H;
        H = t0.H(this.f45592a, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return H;
    }

    public l0(t0 t0Var) {
        this.f45592a = t0Var;
    }
}
