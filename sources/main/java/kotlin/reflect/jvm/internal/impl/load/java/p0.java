package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: D:\Downloads\app\classes8.dex */
class p0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final p0 f45731a = new p0();

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean i6;
        i6 = r0.i((CallableMemberDescriptor) obj);
        return Boolean.valueOf(i6);
    }
}
