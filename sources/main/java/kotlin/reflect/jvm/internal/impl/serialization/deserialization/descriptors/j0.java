package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w;

/* loaded from: D:\Downloads\app\classes8.dex */
class j0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final w.c f46853a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        i1 t5;
        t5 = w.c.t(this.f46853a, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return t5;
    }

    public j0(w.c cVar) {
        this.f46853a = cVar;
    }
}
