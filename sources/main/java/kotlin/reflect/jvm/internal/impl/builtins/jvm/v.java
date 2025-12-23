package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.InputStream;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.w;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u3.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.c {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f44532f = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.v finder, @NotNull f0 moduleDescriptor, @NotNull k0 notFoundClasses, @NotNull r3.a additionalClassPartsProvider, @NotNull r3.c platformDependentDeclarationFilter, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.n deserializationConfiguration, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.p kotlinTypeChecker, @NotNull b4.a samConversionResolver) {
        super(storageManager, finder, moduleDescriptor);
        g0.p(storageManager, "storageManager");
        g0.p(finder, "finder");
        g0.p(moduleDescriptor, "moduleDescriptor");
        g0.p(notFoundClasses, "notFoundClasses");
        g0.p(additionalClassPartsProvider, "additionalClassPartsProvider");
        g0.p(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        g0.p(deserializationConfiguration, "deserializationConfiguration");
        g0.p(kotlinTypeChecker, "kotlinTypeChecker");
        g0.p(samConversionResolver, "samConversionResolver");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.p pVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.p(this);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a aVar = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f46819r;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.e eVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.e(moduleDescriptor, notFoundClasses, aVar);
        a0.a aVar2 = a0.a.f46814a;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.v DO_NOTHING = kotlin.reflect.jvm.internal.impl.serialization.deserialization.v.f47070a;
        g0.o(DO_NOTHING, "DO_NOTHING");
        k(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.m(storageManager, moduleDescriptor, deserializationConfiguration, pVar, eVar, this, aVar2, DO_NOTHING, c.a.f54673a, w.a.f47079a, kotlin.collections.f0.Q(new kotlin.reflect.jvm.internal.impl.builtins.functions.a(storageManager, moduleDescriptor), new g(storageManager, moduleDescriptor, null, 4, null)), notFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.l.f46991a.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, aVar.e(), kotlinTypeChecker, samConversionResolver, null, y.f47086a, 262144, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.c
    @Nullable
    protected kotlin.reflect.jvm.internal.impl.serialization.deserialization.q e(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        InputStream c6 = h().c(fqName);
        if (c6 != null) {
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.c.f46821o.a(fqName, j(), i(), c6, false);
        }
        return null;
    }
}
