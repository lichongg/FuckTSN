package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;

/* loaded from: D:\Downloads\app\classes8.dex */
class d implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final d1 f45412a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean l6;
        l6 = e.l(this.f45412a, (CallableMemberDescriptor) obj);
        return Boolean.valueOf(l6);
    }

    public d(d1 d1Var) {
        this.f45412a = d1Var;
    }
}
