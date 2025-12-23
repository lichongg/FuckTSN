package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: D:\Downloads\app\classes8.dex */
class o0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final o0 f45729a = new o0();

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean h6;
        h6 = r0.h((CallableMemberDescriptor) obj);
        return Boolean.valueOf(h6);
    }
}
