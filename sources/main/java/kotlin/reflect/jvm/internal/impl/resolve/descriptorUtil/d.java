package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.sequences.m;

/* loaded from: D:\Downloads\app\classes8.dex */
class d implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f46697a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        m A;
        A = e.A(this.f46697a, (CallableMemberDescriptor) obj);
        return A;
    }

    public d(boolean z5) {
        this.f46697a = z5;
    }
}
