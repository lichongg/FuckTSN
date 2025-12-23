package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: D:\Downloads\app\classes8.dex */
class g implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g f45428a = new g();

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean p5;
        p5 = h.p((CallableMemberDescriptor) obj);
        return Boolean.valueOf(p5);
    }
}
