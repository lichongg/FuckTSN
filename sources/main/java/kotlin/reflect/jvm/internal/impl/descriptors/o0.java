package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class o0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f44941a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean g6;
        g6 = p0.g(this.f44941a, (kotlin.reflect.jvm.internal.impl.name.c) obj);
        return Boolean.valueOf(g6);
    }

    public o0(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        this.f44941a = cVar;
    }
}
