package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class d0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f46831a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.n f46832b;

    /* renamed from: c, reason: collision with root package name */
    private final AnnotatedCallableKind f46833c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        List k6;
        k6 = j0.k(this.f46831a, this.f46832b, this.f46833c);
        return k6;
    }

    public d0(j0 j0Var, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind) {
        this.f46831a = j0Var;
        this.f46832b = nVar;
        this.f46833c = annotatedCallableKind;
    }
}
