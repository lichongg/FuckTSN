package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: D:\Downloads\app\classes8.dex */
class q0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final q0 f45735a = new q0();

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean k6;
        k6 = r0.k((CallableMemberDescriptor) obj);
        return Boolean.valueOf(k6);
    }
}
