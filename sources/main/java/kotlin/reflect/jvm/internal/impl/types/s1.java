package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface s1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static /* synthetic */ t1 a(s1 s1Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, w1 w1Var, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
            }
            if ((i6 & 2) != 0) {
                w1Var = null;
            }
            if ((i6 & 4) != 0) {
                kVar = null;
            }
            return s1Var.a(gVar, w1Var, kVar);
        }
    }

    @NotNull
    t1 a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @Nullable w1 w1Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar);
}
