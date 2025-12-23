package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.load.kotlin.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w {
    @Nullable
    public static final x a(@NotNull v vVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c metadataVersion) {
        kotlin.jvm.internal.g0.p(vVar, "<this>");
        kotlin.jvm.internal.g0.p(classId, "classId");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        v.a a6 = vVar.a(classId, metadataVersion);
        if (a6 != null) {
            return a6.a();
        }
        return null;
    }

    @Nullable
    public static final x b(@NotNull v vVar, @NotNull y3.g javaClass, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c metadataVersion) {
        kotlin.jvm.internal.g0.p(vVar, "<this>");
        kotlin.jvm.internal.g0.p(javaClass, "javaClass");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        v.a b6 = vVar.b(javaClass, metadataVersion);
        if (b6 != null) {
            return b6.a();
        }
        return null;
    }
}
