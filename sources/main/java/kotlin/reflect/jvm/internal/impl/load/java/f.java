package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: D:\Downloads\app\classes8.dex */
class f implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final f f45426a = new f();

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean m6;
        m6 = h.m((CallableMemberDescriptor) obj);
        return Boolean.valueOf(m6);
    }
}
