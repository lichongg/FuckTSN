package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface n {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nResolutionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResolutionScope.kt\norg/jetbrains/kotlin/resolve/scopes/ResolutionScope$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(n nVar, d dVar, Function1 function1, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i6 & 1) != 0) {
                dVar = d.f46751o;
            }
            if ((i6 & 2) != 0) {
                function1 = k.f46777a.c();
            }
            return nVar.h(dVar, function1);
        }

        public static void b(@NotNull n nVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            g0.p(name, "name");
            g0.p(location, "location");
            nVar.a(name, location);
        }
    }

    @NotNull
    Collection<? extends y> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar);

    void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar);

    @Nullable
    kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar);

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull d dVar, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1);
}
