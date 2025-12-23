package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface q1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements q1 {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f47324a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.types.q1
        public void a(@NotNull h2 substitutor, @NotNull t0 unsubstitutedArgument, @NotNull t0 argument, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 typeParameter) {
            kotlin.jvm.internal.g0.p(substitutor, "substitutor");
            kotlin.jvm.internal.g0.p(unsubstitutedArgument, "unsubstitutedArgument");
            kotlin.jvm.internal.g0.p(argument, "argument");
            kotlin.jvm.internal.g0.p(typeParameter, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q1
        public void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.i1 typeAlias) {
            kotlin.jvm.internal.g0.p(typeAlias, "typeAlias");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q1
        public void c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotation) {
            kotlin.jvm.internal.g0.p(annotation, "annotation");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q1
        public void d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.i1 typeAlias, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var, @NotNull t0 substitutedArgument) {
            kotlin.jvm.internal.g0.p(typeAlias, "typeAlias");
            kotlin.jvm.internal.g0.p(substitutedArgument, "substitutedArgument");
        }

        private a() {
        }
    }

    void a(@NotNull h2 h2Var, @NotNull t0 t0Var, @NotNull t0 t0Var2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var);

    void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.i1 i1Var);

    void c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar);

    void d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.i1 i1Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var, @NotNull t0 t0Var);
}
