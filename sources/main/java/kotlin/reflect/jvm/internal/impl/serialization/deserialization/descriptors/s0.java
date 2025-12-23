package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s0 extends b {
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull Function0<? extends List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> compute) {
        super(storageManager, compute);
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(compute, "compute");
    }
}
