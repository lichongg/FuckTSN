package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;
import kotlin.reflect.jvm.internal.impl.types.s1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r3.a;
import r3.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n f46998a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.f0 f46999b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final n f47000c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final i f47001d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final d<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f47002e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.m0 f47003f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final a0 f47004g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final v f47005h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final u3.c f47006i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final w f47007j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final Iterable<r3.b> f47008k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.k0 f47009l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final l f47010m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final r3.a f47011n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final r3.c f47012o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.protobuf.f f47013p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.types.checker.p f47014q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private final b4.a f47015r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private final List<s1> f47016s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private final u f47017t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private final k f47018u;

    /* JADX WARN: Multi-variable type inference failed */
    public m(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 moduleDescriptor, @NotNull n configuration, @NotNull i classDataFinder, @NotNull d<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> annotationAndConstantLoader, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.m0 packageFragmentProvider, @NotNull a0 localClassifierTypeSettings, @NotNull v errorReporter, @NotNull u3.c lookupTracker, @NotNull w flexibleTypeDeserializer, @NotNull Iterable<? extends r3.b> fictitiousClassDescriptorFactories, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k0 notFoundClasses, @NotNull l contractDeserializer, @NotNull r3.a additionalClassPartsProvider, @NotNull r3.c platformDependentDeclarationFilter, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.f extensionRegistryLite, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.p kotlinTypeChecker, @NotNull b4.a samConversionResolver, @NotNull List<? extends s1> typeAttributeTranslators, @NotNull u enumEntriesDeserializationSupport) {
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.g0.p(configuration, "configuration");
        kotlin.jvm.internal.g0.p(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.g0.p(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.g0.p(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.g0.p(localClassifierTypeSettings, "localClassifierTypeSettings");
        kotlin.jvm.internal.g0.p(errorReporter, "errorReporter");
        kotlin.jvm.internal.g0.p(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.g0.p(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        kotlin.jvm.internal.g0.p(fictitiousClassDescriptorFactories, "fictitiousClassDescriptorFactories");
        kotlin.jvm.internal.g0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.g0.p(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.g0.p(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.g0.p(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.g0.p(extensionRegistryLite, "extensionRegistryLite");
        kotlin.jvm.internal.g0.p(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.g0.p(samConversionResolver, "samConversionResolver");
        kotlin.jvm.internal.g0.p(typeAttributeTranslators, "typeAttributeTranslators");
        kotlin.jvm.internal.g0.p(enumEntriesDeserializationSupport, "enumEntriesDeserializationSupport");
        this.f46998a = storageManager;
        this.f46999b = moduleDescriptor;
        this.f47000c = configuration;
        this.f47001d = classDataFinder;
        this.f47002e = annotationAndConstantLoader;
        this.f47003f = packageFragmentProvider;
        this.f47004g = localClassifierTypeSettings;
        this.f47005h = errorReporter;
        this.f47006i = lookupTracker;
        this.f47007j = flexibleTypeDeserializer;
        this.f47008k = fictitiousClassDescriptorFactories;
        this.f47009l = notFoundClasses;
        this.f47010m = contractDeserializer;
        this.f47011n = additionalClassPartsProvider;
        this.f47012o = platformDependentDeclarationFilter;
        this.f47013p = extensionRegistryLite;
        this.f47014q = kotlinTypeChecker;
        this.f47015r = samConversionResolver;
        this.f47016s = typeAttributeTranslators;
        this.f47017t = enumEntriesDeserializationSupport;
        this.f47018u = new k(this);
    }

    @NotNull
    public final o a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.l0 descriptor, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.j versionRequirementTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s sVar) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(typeTable, "typeTable");
        kotlin.jvm.internal.g0.p(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        return new o(this, nameResolver, descriptor, typeTable, versionRequirementTable, metadataVersion, sVar, null, kotlin.collections.f0.J());
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        kotlin.jvm.internal.g0.p(classId, "classId");
        return k.f(this.f47018u, classId, null, 2, null);
    }

    @NotNull
    public final r3.a c() {
        return this.f47011n;
    }

    @NotNull
    public final d<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d() {
        return this.f47002e;
    }

    @NotNull
    public final i e() {
        return this.f47001d;
    }

    @NotNull
    public final k f() {
        return this.f47018u;
    }

    @NotNull
    public final n g() {
        return this.f47000c;
    }

    @NotNull
    public final l h() {
        return this.f47010m;
    }

    @NotNull
    public final u i() {
        return this.f47017t;
    }

    @NotNull
    public final v j() {
        return this.f47005h;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.protobuf.f k() {
        return this.f47013p;
    }

    @NotNull
    public final Iterable<r3.b> l() {
        return this.f47008k;
    }

    @NotNull
    public final w m() {
        return this.f47007j;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.checker.p n() {
        return this.f47014q;
    }

    @NotNull
    public final a0 o() {
        return this.f47004g;
    }

    @NotNull
    public final u3.c p() {
        return this.f47006i;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.f0 q() {
        return this.f46999b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.k0 r() {
        return this.f47009l;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.m0 s() {
        return this.f47003f;
    }

    @NotNull
    public final r3.c t() {
        return this.f47012o;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.n u() {
        return this.f46998a;
    }

    @NotNull
    public final List<s1> v() {
        return this.f47016s;
    }

    public /* synthetic */ m(kotlin.reflect.jvm.internal.impl.storage.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var, n nVar2, i iVar, d dVar, kotlin.reflect.jvm.internal.impl.descriptors.m0 m0Var, a0 a0Var, v vVar, u3.c cVar, w wVar, Iterable iterable, kotlin.reflect.jvm.internal.impl.descriptors.k0 k0Var, l lVar, r3.a aVar, r3.c cVar2, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, kotlin.reflect.jvm.internal.impl.types.checker.p pVar, b4.a aVar2, List list, u uVar, int i6, kotlin.jvm.internal.v vVar2) {
        this(nVar, f0Var, nVar2, iVar, dVar, m0Var, a0Var, vVar, cVar, wVar, iterable, k0Var, lVar, (i6 & 8192) != 0 ? a.C1006a.f51989a : aVar, (i6 & 16384) != 0 ? c.a.f51990a : cVar2, fVar, (65536 & i6) != 0 ? kotlin.reflect.jvm.internal.impl.types.checker.p.f47188b.a() : pVar, aVar2, (262144 & i6) != 0 ? kotlin.collections.f0.l(kotlin.reflect.jvm.internal.impl.types.y.f47369a) : list, (i6 & 524288) != 0 ? u.a.f47068a : uVar);
    }
}
