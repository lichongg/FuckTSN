package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function2;

/* loaded from: D:\Downloads\app\classes8.dex */
class e1 implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final e1 f44340a = new e1();

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        int M;
        M = KDeclarationContainerImpl.M((kotlin.reflect.jvm.internal.impl.descriptors.s) obj, (kotlin.reflect.jvm.internal.impl.descriptors.s) obj2);
        return Integer.valueOf(M);
    }
}
