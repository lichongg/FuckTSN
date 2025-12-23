package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class g0 implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f44351a = new g0();

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        kotlin.reflect.jvm.internal.impl.descriptors.w0 m02;
        m02 = h0.m0((kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0) obj, (ProtoBuf.Property) obj2);
        return m02;
    }
}
