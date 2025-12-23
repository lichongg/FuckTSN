package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;

/* loaded from: D:\Downloads\app\classes8.dex */
class j implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final k f46982a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.d c6;
        c6 = k.c(this.f46982a, (k.a) obj);
        return c6;
    }

    public j(k kVar) {
        this.f46982a = kVar;
    }
}
