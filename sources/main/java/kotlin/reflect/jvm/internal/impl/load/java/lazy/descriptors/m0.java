package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class m0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final t0 f45594a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.w0 G;
        G = t0.G(this.f45594a, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return G;
    }

    public m0(t0 t0Var) {
        this.f45594a = t0Var;
    }
}
