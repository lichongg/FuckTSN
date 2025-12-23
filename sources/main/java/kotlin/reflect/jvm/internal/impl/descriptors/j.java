package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface j extends y {
    @NotNull
    d J();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    g b();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.g1
    @Nullable
    j c(@NotNull h2 h2Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    kotlin.reflect.jvm.internal.impl.types.t0 getReturnType();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    List<j1> getTypeParameters();

    boolean m0();
}
