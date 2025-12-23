package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.e;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.n;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.w;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;
import u3.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBuiltInsLoaderImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInsLoaderImpl.kt\norg/jetbrains/kotlin/serialization/deserialization/builtins/BuiltInsLoaderImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1617#2,9:94\n1869#2:103\n1870#2:106\n1626#2:107\n1#3:104\n1#3:105\n*S KotlinDebug\n*F\n+ 1 BuiltInsLoaderImpl.kt\norg/jetbrains/kotlin/serialization/deserialization/builtins/BuiltInsLoaderImpl\n*L\n57#1:94,9\n57#1:103\n57#1:106\n57#1:107\n57#1:105\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b implements kotlin.reflect.jvm.internal.impl.builtins.b {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final d f46820b = new d();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<String, InputStream> {
        a(Object obj) {
            super(1, obj, d.class, "loadResource", "loadResource(Ljava/lang/String;)Ljava/io/InputStream;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final InputStream invoke(String p02) {
            g0.p(p02, "p0");
            return ((d) this.receiver).a(p02);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.b
    @NotNull
    public m0 a(@NotNull n storageManager, @NotNull f0 builtInsModule, @NotNull Iterable<? extends r3.b> classDescriptorFactories, @NotNull r3.c platformDependentDeclarationFilter, @NotNull r3.a additionalClassPartsProvider, boolean z5) {
        g0.p(storageManager, "storageManager");
        g0.p(builtInsModule, "builtInsModule");
        g0.p(classDescriptorFactories, "classDescriptorFactories");
        g0.p(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        g0.p(additionalClassPartsProvider, "additionalClassPartsProvider");
        return b(storageManager, builtInsModule, o.K, classDescriptorFactories, platformDependentDeclarationFilter, additionalClassPartsProvider, z5, new a(this.f46820b));
    }

    @NotNull
    public final m0 b(@NotNull n nVar, @NotNull f0 f0Var, @NotNull Set<kotlin.reflect.jvm.internal.impl.name.c> packageFqNames, @NotNull Iterable<? extends r3.b> classDescriptorFactories, @NotNull r3.c platformDependentDeclarationFilter, @NotNull r3.a additionalClassPartsProvider, boolean z5, @NotNull Function1<? super String, ? extends InputStream> loadResource) {
        c cVar;
        n storageManager = nVar;
        f0 module = f0Var;
        g0.p(storageManager, "storageManager");
        g0.p(module, "module");
        g0.p(packageFqNames, "packageFqNames");
        g0.p(classDescriptorFactories, "classDescriptorFactories");
        g0.p(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        g0.p(additionalClassPartsProvider, "additionalClassPartsProvider");
        g0.p(loadResource, "loadResource");
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.name.c cVar2 : packageFqNames) {
            InputStream invoke = loadResource.invoke(kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f46819r.r(cVar2));
            if (invoke != null) {
                f0 f0Var2 = module;
                cVar = c.f46821o.a(cVar2, nVar, f0Var2, invoke, z5);
                storageManager = nVar;
                module = f0Var2;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        p0 p0Var = new p0(arrayList);
        k0 k0Var = new k0(storageManager, module);
        n.a aVar = n.a.f47029a;
        p pVar = new p(p0Var);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a aVar2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f46819r;
        e eVar = new e(module, k0Var, aVar2);
        a0.a aVar3 = a0.a.f46814a;
        v DO_NOTHING = v.f47070a;
        g0.o(DO_NOTHING, "DO_NOTHING");
        m mVar = new m(storageManager, f0Var, aVar, pVar, eVar, p0Var, aVar3, DO_NOTHING, c.a.f54673a, w.a.f47079a, classDescriptorFactories, k0Var, l.f46991a.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, aVar2.e(), null, new b4.b(storageManager, kotlin.collections.f0.J()), null, null, 851968, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).G0(mVar);
        }
        return p0Var;
    }
}
