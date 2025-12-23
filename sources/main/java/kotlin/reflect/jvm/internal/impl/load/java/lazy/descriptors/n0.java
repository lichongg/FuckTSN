package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class n0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final t0 f45614a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Collection K;
        K = t0.K(this.f45614a, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return K;
    }

    public n0(t0 t0Var) {
        this.f45614a = t0Var;
    }
}
