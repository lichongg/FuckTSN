package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;

/* loaded from: D:\Downloads\app\classes8.dex */
class f1 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final q1 f45771a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.types.t0 o5;
        o5 = j1.o(this.f45771a, (CallableMemberDescriptor) obj);
        return o5;
    }

    public f1(q1 q1Var) {
        this.f45771a = q1Var;
    }
}
