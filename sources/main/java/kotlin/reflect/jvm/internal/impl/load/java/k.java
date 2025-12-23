package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: D:\Downloads\app\classes8.dex */
class k implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final k f45494a = new k();

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean c6;
        c6 = l.c((CallableMemberDescriptor) obj);
        return Boolean.valueOf(c6);
    }
}
