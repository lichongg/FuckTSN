package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: D:\Downloads\app\classes8.dex */
class r implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final t f44509a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Boolean G;
        G = t.G(this.f44509a, (CallableMemberDescriptor) obj);
        return G;
    }

    public r(t tVar) {
        this.f44509a = tVar;
    }
}
