package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class u1 implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final u1 f47602a = new u1();

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        kotlin.reflect.jvm.internal.impl.descriptors.w0 d02;
        d02 = a2.d0((kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0) obj, (ProtoBuf.Property) obj2);
        return d02;
    }
}
