package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class u0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final u0 f47069a = new u0();

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        int A;
        A = v0.A((ProtoBuf.Type) obj);
        return Integer.valueOf(A);
    }
}
