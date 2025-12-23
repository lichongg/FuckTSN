package b4;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.e1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSamConversionResolverImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SamConversionResolverImpl.kt\norg/jetbrains/kotlin/resolve/sam/SamConversionResolverImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,180:1\n1761#2,3:181\n*S KotlinDebug\n*F\n+ 1 SamConversionResolverImpl.kt\norg/jetbrains/kotlin/resolve/sam/SamConversionResolverImpl\n*L\n39#1:181,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Iterable<Object> f1033a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.b<d, e1> f1034b;

    public b(@NotNull n storageManager, @NotNull Iterable<? extends Object> samWithReceiverResolvers) {
        g0.p(storageManager, "storageManager");
        g0.p(samWithReceiverResolvers, "samWithReceiverResolvers");
        this.f1033a = samWithReceiverResolvers;
        this.f1034b = storageManager.h();
    }
}
