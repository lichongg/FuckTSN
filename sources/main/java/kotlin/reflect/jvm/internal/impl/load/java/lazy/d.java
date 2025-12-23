package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.load.java.t;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j1;
import kotlin.reflect.jvm.internal.impl.load.java.u;
import kotlin.reflect.jvm.internal.impl.load.java.z;
import kotlin.reflect.jvm.internal.impl.load.kotlin.d0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n f45504a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final t f45505b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final v f45506c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.n f45507d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.components.o f45508e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.v f45509f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.components.j f45510g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.components.i f45511h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final b4.a f45512i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final x3.b f45513j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final n f45514k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final d0 f45515l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final h1 f45516m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final u3.c f45517n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final f0 f45518o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.builtins.n f45519p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.c f45520q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private final j1 f45521r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private final u f45522s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private final e f45523t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.types.checker.p f45524u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.d0 f45525v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    private final z f45526w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.resolve.jvm.e f45527x;

    public d(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull t finder, @NotNull v kotlinClassFinder, @NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.n deserializedDescriptorResolver, @NotNull kotlin.reflect.jvm.internal.impl.load.java.components.o signaturePropagator, @NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.v errorReporter, @NotNull kotlin.reflect.jvm.internal.impl.load.java.components.j javaResolverCache, @NotNull kotlin.reflect.jvm.internal.impl.load.java.components.i javaPropertyInitializerEvaluator, @NotNull b4.a samConversionResolver, @NotNull x3.b sourceElementFactory, @NotNull n moduleClassResolver, @NotNull d0 packagePartProvider, @NotNull h1 supertypeLoopChecker, @NotNull u3.c lookupTracker, @NotNull f0 module, @NotNull kotlin.reflect.jvm.internal.impl.builtins.n reflectionTypes, @NotNull kotlin.reflect.jvm.internal.impl.load.java.c annotationTypeQualifierResolver, @NotNull j1 signatureEnhancement, @NotNull u javaClassesTracker, @NotNull e settings, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.p kotlinTypeChecker, @NotNull kotlin.reflect.jvm.internal.impl.load.java.d0 javaTypeEnhancementState, @NotNull z javaModuleResolver, @NotNull kotlin.reflect.jvm.internal.impl.resolve.jvm.e syntheticPartsProvider) {
        g0.p(storageManager, "storageManager");
        g0.p(finder, "finder");
        g0.p(kotlinClassFinder, "kotlinClassFinder");
        g0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        g0.p(signaturePropagator, "signaturePropagator");
        g0.p(errorReporter, "errorReporter");
        g0.p(javaResolverCache, "javaResolverCache");
        g0.p(javaPropertyInitializerEvaluator, "javaPropertyInitializerEvaluator");
        g0.p(samConversionResolver, "samConversionResolver");
        g0.p(sourceElementFactory, "sourceElementFactory");
        g0.p(moduleClassResolver, "moduleClassResolver");
        g0.p(packagePartProvider, "packagePartProvider");
        g0.p(supertypeLoopChecker, "supertypeLoopChecker");
        g0.p(lookupTracker, "lookupTracker");
        g0.p(module, "module");
        g0.p(reflectionTypes, "reflectionTypes");
        g0.p(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        g0.p(signatureEnhancement, "signatureEnhancement");
        g0.p(javaClassesTracker, "javaClassesTracker");
        g0.p(settings, "settings");
        g0.p(kotlinTypeChecker, "kotlinTypeChecker");
        g0.p(javaTypeEnhancementState, "javaTypeEnhancementState");
        g0.p(javaModuleResolver, "javaModuleResolver");
        g0.p(syntheticPartsProvider, "syntheticPartsProvider");
        this.f45504a = storageManager;
        this.f45505b = finder;
        this.f45506c = kotlinClassFinder;
        this.f45507d = deserializedDescriptorResolver;
        this.f45508e = signaturePropagator;
        this.f45509f = errorReporter;
        this.f45510g = javaResolverCache;
        this.f45511h = javaPropertyInitializerEvaluator;
        this.f45512i = samConversionResolver;
        this.f45513j = sourceElementFactory;
        this.f45514k = moduleClassResolver;
        this.f45515l = packagePartProvider;
        this.f45516m = supertypeLoopChecker;
        this.f45517n = lookupTracker;
        this.f45518o = module;
        this.f45519p = reflectionTypes;
        this.f45520q = annotationTypeQualifierResolver;
        this.f45521r = signatureEnhancement;
        this.f45522s = javaClassesTracker;
        this.f45523t = settings;
        this.f45524u = kotlinTypeChecker;
        this.f45525v = javaTypeEnhancementState;
        this.f45526w = javaModuleResolver;
        this.f45527x = syntheticPartsProvider;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.c a() {
        return this.f45520q;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.kotlin.n b() {
        return this.f45507d;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.v c() {
        return this.f45509f;
    }

    @NotNull
    public final t d() {
        return this.f45505b;
    }

    @NotNull
    public final u e() {
        return this.f45522s;
    }

    @NotNull
    public final z f() {
        return this.f45526w;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.components.i g() {
        return this.f45511h;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.components.j h() {
        return this.f45510g;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.d0 i() {
        return this.f45525v;
    }

    @NotNull
    public final v j() {
        return this.f45506c;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.checker.p k() {
        return this.f45524u;
    }

    @NotNull
    public final u3.c l() {
        return this.f45517n;
    }

    @NotNull
    public final f0 m() {
        return this.f45518o;
    }

    @NotNull
    public final n n() {
        return this.f45514k;
    }

    @NotNull
    public final d0 o() {
        return this.f45515l;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.builtins.n p() {
        return this.f45519p;
    }

    @NotNull
    public final e q() {
        return this.f45523t;
    }

    @NotNull
    public final j1 r() {
        return this.f45521r;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.components.o s() {
        return this.f45508e;
    }

    @NotNull
    public final x3.b t() {
        return this.f45513j;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.n u() {
        return this.f45504a;
    }

    @NotNull
    public final h1 v() {
        return this.f45516m;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.jvm.e w() {
        return this.f45527x;
    }

    @NotNull
    public final d x(@NotNull kotlin.reflect.jvm.internal.impl.load.java.components.j javaResolverCache) {
        g0.p(javaResolverCache, "javaResolverCache");
        return new d(this.f45504a, this.f45505b, this.f45506c, this.f45507d, this.f45508e, this.f45509f, javaResolverCache, this.f45511h, this.f45512i, this.f45513j, this.f45514k, this.f45515l, this.f45516m, this.f45517n, this.f45518o, this.f45519p, this.f45520q, this.f45521r, this.f45522s, this.f45523t, this.f45524u, this.f45525v, this.f45526w, null, 8388608, null);
    }

    public /* synthetic */ d(kotlin.reflect.jvm.internal.impl.storage.n nVar, t tVar, v vVar, kotlin.reflect.jvm.internal.impl.load.kotlin.n nVar2, kotlin.reflect.jvm.internal.impl.load.java.components.o oVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.v vVar2, kotlin.reflect.jvm.internal.impl.load.java.components.j jVar, kotlin.reflect.jvm.internal.impl.load.java.components.i iVar, b4.a aVar, x3.b bVar, n nVar3, d0 d0Var, h1 h1Var, u3.c cVar, f0 f0Var, kotlin.reflect.jvm.internal.impl.builtins.n nVar4, kotlin.reflect.jvm.internal.impl.load.java.c cVar2, j1 j1Var, u uVar, e eVar, kotlin.reflect.jvm.internal.impl.types.checker.p pVar, kotlin.reflect.jvm.internal.impl.load.java.d0 d0Var2, z zVar, kotlin.reflect.jvm.internal.impl.resolve.jvm.e eVar2, int i6, kotlin.jvm.internal.v vVar3) {
        this(nVar, tVar, vVar, nVar2, oVar, vVar2, jVar, iVar, aVar, bVar, nVar3, d0Var, h1Var, cVar, f0Var, nVar4, cVar2, j1Var, uVar, eVar, pVar, d0Var2, zVar, (i6 & 8388608) != 0 ? kotlin.reflect.jvm.internal.impl.resolve.jvm.e.f46718a.a() : eVar2);
    }
}
