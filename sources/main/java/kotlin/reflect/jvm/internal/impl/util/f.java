package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @Nullable
        public static String a(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
            g0.p(functionDescriptor, "functionDescriptor");
            if (fVar.b(functionDescriptor)) {
                return null;
            }
            return fVar.getDescription();
        }
    }

    @Nullable
    String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar);

    boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar);

    @NotNull
    String getDescription();
}
