package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;

/* loaded from: D:\Downloads\app\classes8.dex */
class f implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a f46705a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a f46706b;

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        boolean i6;
        i6 = g.i(this.f46705a, this.f46706b, (kotlin.reflect.jvm.internal.impl.descriptors.k) obj, (kotlin.reflect.jvm.internal.impl.descriptors.k) obj2);
        return Boolean.valueOf(i6);
    }

    public f(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        this.f46705a = aVar;
        this.f46706b = aVar2;
    }
}
