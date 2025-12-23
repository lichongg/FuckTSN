package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {
    @NotNull
    public static final h a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module, @NotNull k0 notFoundClasses, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull v kotlinClassFinder, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c metadataVersion) {
        kotlin.jvm.internal.g0.p(module, "module");
        kotlin.jvm.internal.g0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(kotlinClassFinder, "kotlinClassFinder");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        h hVar = new h(module, notFoundClasses, storageManager, kotlinClassFinder);
        hVar.S(metadataVersion);
        return hVar;
    }
}
