package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface q1 extends t0, s1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static boolean a(@NotNull q1 q1Var) {
            return false;
        }
    }

    @NotNull
    q1 I(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, int i6);

    boolean Q();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    q1 a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    kotlin.reflect.jvm.internal.impl.descriptors.a b();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    Collection<q1> e();

    int getIndex();

    boolean u0();

    boolean w0();

    @Nullable
    kotlin.reflect.jvm.internal.impl.types.t0 z0();
}
