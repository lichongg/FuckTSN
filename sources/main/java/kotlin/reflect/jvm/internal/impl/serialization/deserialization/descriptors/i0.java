package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w;

/* loaded from: D:\Downloads\app\classes8.dex */
class i0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final w.c f46851a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Collection s5;
        s5 = w.c.s(this.f46851a, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return s5;
    }

    public i0(w.c cVar) {
        this.f46851a = cVar;
    }
}
