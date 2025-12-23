package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;

/* loaded from: D:\Downloads\app\classes8.dex */
class f implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final Collection f47239a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeCheckerState f47240b;

    /* renamed from: c, reason: collision with root package name */
    private final e4.r f47241c;

    /* renamed from: d, reason: collision with root package name */
    private final e4.h f47242d;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.n1 x5;
        x5 = h.x(this.f47239a, this.f47240b, this.f47241c, this.f47242d, (TypeCheckerState.a) obj);
        return x5;
    }

    public f(Collection collection, TypeCheckerState typeCheckerState, e4.r rVar, e4.h hVar) {
        this.f47239a = collection;
        this.f47240b = typeCheckerState;
        this.f47241c = rVar;
        this.f47242d = hVar;
    }
}
