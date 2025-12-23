package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class g0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f46966a;

    /* renamed from: b, reason: collision with root package name */
    private final m0 f46967b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.n f46968c;

    /* renamed from: d, reason: collision with root package name */
    private final AnnotatedCallableKind f46969d;

    /* renamed from: e, reason: collision with root package name */
    private final int f46970e;

    /* renamed from: f, reason: collision with root package name */
    private final ProtoBuf.ValueParameter f46971f;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        List D;
        D = j0.D(this.f46966a, this.f46967b, this.f46968c, this.f46969d, this.f46970e, this.f46971f);
        return D;
    }

    public g0(j0 j0Var, m0 m0Var, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind, int i6, ProtoBuf.ValueParameter valueParameter) {
        this.f46966a = j0Var;
        this.f46967b = m0Var;
        this.f46968c = nVar;
        this.f46969d = annotatedCallableKind;
        this.f46970e = i6;
        this.f46971f = valueParameter;
    }
}
