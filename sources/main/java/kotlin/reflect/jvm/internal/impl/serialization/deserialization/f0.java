package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class f0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f46963a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.n f46964b;

    /* renamed from: c, reason: collision with root package name */
    private final AnnotatedCallableKind f46965c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        List p5;
        p5 = j0.p(this.f46963a, this.f46964b, this.f46965c);
        return p5;
    }

    public f0(j0 j0Var, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind) {
        this.f46963a = j0Var;
        this.f46964b = nVar;
        this.f46965c = annotatedCallableKind;
    }
}
