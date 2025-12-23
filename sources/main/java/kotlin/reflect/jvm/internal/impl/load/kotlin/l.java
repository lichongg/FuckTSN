package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.load.java.components.i;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.e;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j1;
import kotlin.reflect.jvm.internal.impl.load.java.u;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.n;
import org.jetbrains.annotations.NotNull;
import u3.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements kotlin.reflect.jvm.internal.impl.load.java.z {
        @Override // kotlin.reflect.jvm.internal.impl.load.java.z
        public List<y3.a> a(kotlin.reflect.jvm.internal.impl.name.b classId) {
            kotlin.jvm.internal.g0.p(classId, "classId");
            return null;
        }

        a() {
        }
    }

    @NotNull
    public static final k a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull k0 notFoundClasses, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.j lazyJavaPackageFragmentProvider, @NotNull v reflectKotlinClassFinder, @NotNull n deserializedDescriptorResolver, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.v errorReporter, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c metadataVersion) {
        kotlin.jvm.internal.g0.p(module, "module");
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.g0.p(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        kotlin.jvm.internal.g0.p(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.g0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.g0.p(errorReporter, "errorReporter");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        return new k(storageManager, module, n.a.f47029a, new o(reflectKotlinClassFinder, deserializedDescriptorResolver), i.a(module, notFoundClasses, storageManager, reflectKotlinClassFinder, metadataVersion), lazyJavaPackageFragmentProvider, notFoundClasses, errorReporter, c.a.f54673a, kotlin.reflect.jvm.internal.impl.serialization.deserialization.l.f46991a.a(), kotlin.reflect.jvm.internal.impl.types.checker.p.f47188b.a(), new d4.a(kotlin.collections.f0.l(kotlin.reflect.jvm.internal.impl.types.y.f47369a)));
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.j b(@NotNull kotlin.reflect.jvm.internal.impl.load.java.t javaClassFinder, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull k0 notFoundClasses, @NotNull v reflectKotlinClassFinder, @NotNull n deserializedDescriptorResolver, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.v errorReporter, @NotNull x3.b javaSourceElementFactory, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.n singleModuleClassResolver, @NotNull d0 packagePartProvider) {
        kotlin.jvm.internal.g0.p(javaClassFinder, "javaClassFinder");
        kotlin.jvm.internal.g0.p(module, "module");
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.g0.p(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.g0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.g0.p(errorReporter, "errorReporter");
        kotlin.jvm.internal.g0.p(javaSourceElementFactory, "javaSourceElementFactory");
        kotlin.jvm.internal.g0.p(singleModuleClassResolver, "singleModuleClassResolver");
        kotlin.jvm.internal.g0.p(packagePartProvider, "packagePartProvider");
        kotlin.reflect.jvm.internal.impl.load.java.d0 b6 = kotlin.reflect.jvm.internal.impl.load.java.d0.f45413d.b(new kotlin.p(1, 9));
        kotlin.reflect.jvm.internal.impl.load.java.components.o DO_NOTHING = kotlin.reflect.jvm.internal.impl.load.java.components.o.f45405a;
        kotlin.jvm.internal.g0.o(DO_NOTHING, "DO_NOTHING");
        kotlin.reflect.jvm.internal.impl.load.java.components.j EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.j.f45398a;
        kotlin.jvm.internal.g0.o(EMPTY, "EMPTY");
        i.a aVar = i.a.f45397a;
        b4.b bVar = new b4.b(storageManager, kotlin.collections.f0.J());
        h1.a aVar2 = h1.a.f44688a;
        c.a aVar3 = c.a.f54673a;
        kotlin.reflect.jvm.internal.impl.builtins.n nVar = new kotlin.reflect.jvm.internal.impl.builtins.n(module, notFoundClasses);
        kotlin.reflect.jvm.internal.impl.load.java.c cVar = new kotlin.reflect.jvm.internal.impl.load.java.c(b6);
        e.b bVar2 = e.b.f45675b;
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.j(new kotlin.reflect.jvm.internal.impl.load.java.lazy.d(storageManager, javaClassFinder, reflectKotlinClassFinder, deserializedDescriptorResolver, DO_NOTHING, errorReporter, EMPTY, aVar, bVar, javaSourceElementFactory, singleModuleClassResolver, packagePartProvider, aVar2, aVar3, module, nVar, cVar, new j1(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g(bVar2)), u.a.f45846a, bVar2, kotlin.reflect.jvm.internal.impl.types.checker.p.f47188b.a(), b6, new a(), null, 8388608, null));
    }
}
