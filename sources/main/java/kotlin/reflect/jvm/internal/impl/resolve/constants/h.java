package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.t0;

/* loaded from: D:\Downloads\app\classes8.dex */
class h implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final PrimitiveType f46666a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        t0 d6;
        d6 = i.d(this.f46666a, (kotlin.reflect.jvm.internal.impl.descriptors.f0) obj);
        return d6;
    }

    public h(PrimitiveType primitiveType) {
        this.f46666a = primitiveType;
    }
}
