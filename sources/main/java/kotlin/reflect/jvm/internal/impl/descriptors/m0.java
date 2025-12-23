package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface m0 {
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    List<l0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.name.c> q(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1);
}
