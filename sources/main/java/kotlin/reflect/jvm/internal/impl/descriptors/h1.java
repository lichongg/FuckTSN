package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface h1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements h1 {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f44688a = new a();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.types.t0> a(@NotNull w1 currentTypeConstructor, @NotNull Collection<? extends kotlin.reflect.jvm.internal.impl.types.t0> superTypes, @NotNull Function1<? super w1, ? extends Iterable<? extends kotlin.reflect.jvm.internal.impl.types.t0>> neighbors, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.types.t0, kotlin.n1> reportLoop) {
            kotlin.jvm.internal.g0.p(currentTypeConstructor, "currentTypeConstructor");
            kotlin.jvm.internal.g0.p(superTypes, "superTypes");
            kotlin.jvm.internal.g0.p(neighbors, "neighbors");
            kotlin.jvm.internal.g0.p(reportLoop, "reportLoop");
            return superTypes;
        }

        private a() {
        }
    }

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.types.t0> a(@NotNull w1 w1Var, @NotNull Collection<? extends kotlin.reflect.jvm.internal.impl.types.t0> collection, @NotNull Function1<? super w1, ? extends Iterable<? extends kotlin.reflect.jvm.internal.impl.types.t0>> function1, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.types.t0, kotlin.n1> function12);
}
