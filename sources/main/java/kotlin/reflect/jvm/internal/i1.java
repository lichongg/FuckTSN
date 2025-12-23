package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;

/* loaded from: D:\Downloads\app\classes8.dex */
class i1 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final KDeclarationContainerImpl f44391a;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k c6;
        c6 = KDeclarationContainerImpl.b.c(this.f44391a);
        return c6;
    }

    public i1(KDeclarationContainerImpl kDeclarationContainerImpl) {
        this.f44391a = kDeclarationContainerImpl;
    }
}
