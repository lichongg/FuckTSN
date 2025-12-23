package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n;

/* loaded from: D:\Downloads\app\classes8.dex */
class p implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final n.c f46896a;

    /* renamed from: b, reason: collision with root package name */
    private final n f46897b;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.d f6;
        f6 = n.c.f(this.f46896a, this.f46897b, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return f6;
    }

    public p(n.c cVar, n nVar) {
        this.f46896a = cVar;
        this.f46897b = nVar;
    }
}
