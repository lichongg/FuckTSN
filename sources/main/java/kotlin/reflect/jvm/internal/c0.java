package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: D:\Downloads\app\classes8.dex */
class c0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final CallableMemberDescriptor f44267a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44268b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.descriptors.t0 t5;
        t5 = e0.t(this.f44267a, this.f44268b);
        return t5;
    }

    public c0(CallableMemberDescriptor callableMemberDescriptor, int i6) {
        this.f44267a = callableMemberDescriptor;
        this.f44268b = i6;
    }
}
