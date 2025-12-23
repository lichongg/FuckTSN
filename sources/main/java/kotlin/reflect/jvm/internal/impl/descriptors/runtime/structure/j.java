package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface j extends y3.d {
    @Override // y3.d
    @Nullable
    g b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    @Override // y3.d
    @NotNull
    List<g> getAnnotations();

    @Nullable
    AnnotatedElement getElement();
}
