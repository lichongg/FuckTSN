package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface f0 extends k {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @Nullable
        public static k b(@NotNull f0 f0Var) {
            return null;
        }

        @Nullable
        public static <R, D> R a(@NotNull f0 f0Var, @NotNull m<R, D> visitor, D d6) {
            kotlin.jvm.internal.g0.p(visitor, "visitor");
            return visitor.m(f0Var, d6);
        }
    }

    boolean B(@NotNull f0 f0Var);

    @NotNull
    s0 M(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    @NotNull
    List<f0> P();

    @Nullable
    <T> T U(@NotNull e0<T> e0Var);

    @NotNull
    kotlin.reflect.jvm.internal.impl.builtins.j p();

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.name.c> q(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1);
}
