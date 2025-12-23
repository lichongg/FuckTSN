package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.b;

/* loaded from: D:\Downloads\app\classes8.dex */
class c implements b.d {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f46696a;

    @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
    public Iterable a(Object obj) {
        Iterable j6;
        j6 = e.j(this.f46696a, (CallableMemberDescriptor) obj);
        return j6;
    }

    public c(boolean z5) {
        this.f46696a = z5;
    }
}
