package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.kotlin.e;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g<A, C> extends e.a<A> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<a0, List<A>> f45888a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<a0, C> f45889b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<a0, C> f45890c;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull Map<a0, ? extends List<? extends A>> memberAnnotations, @NotNull Map<a0, ? extends C> propertyConstants, @NotNull Map<a0, ? extends C> annotationParametersDefaultValues) {
        kotlin.jvm.internal.g0.p(memberAnnotations, "memberAnnotations");
        kotlin.jvm.internal.g0.p(propertyConstants, "propertyConstants");
        kotlin.jvm.internal.g0.p(annotationParametersDefaultValues, "annotationParametersDefaultValues");
        this.f45888a = memberAnnotations;
        this.f45889b = propertyConstants;
        this.f45890c = annotationParametersDefaultValues;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.e.a
    @NotNull
    public Map<a0, List<A>> a() {
        return this.f45888a;
    }

    @NotNull
    public final Map<a0, C> b() {
        return this.f45890c;
    }

    @NotNull
    public final Map<a0, C> c() {
        return this.f45889b;
    }
}
