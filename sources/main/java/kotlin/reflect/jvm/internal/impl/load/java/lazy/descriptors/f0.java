package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g0;

/* loaded from: D:\Downloads\app\classes8.dex */
class f0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final g0 f45559a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45560b;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.d j02;
        j02 = g0.j0(this.f45559a, this.f45560b, (g0.a) obj);
        return j02;
    }

    public f0(g0 g0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar) {
        this.f45559a = g0Var;
        this.f45560b = kVar;
    }
}
