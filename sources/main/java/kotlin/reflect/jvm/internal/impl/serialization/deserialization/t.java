package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDeserializedPackageFragmentImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedPackageFragmentImpl.kt\norg/jetbrains/kotlin/serialization/deserialization/DeserializedPackageFragmentImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n774#2:64\n865#2,2:65\n1563#2:67\n1634#2,3:68\n*S KotlinDebug\n*F\n+ 1 DeserializedPackageFragmentImpl.kt\norg/jetbrains/kotlin/serialization/deserialization/DeserializedPackageFragmentImpl\n*L\n54#1:64\n54#1:65,2\n56#1:67\n56#1:68,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class t extends q {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f47061h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s f47062i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.e f47063j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final l0 f47064k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private ProtoBuf.PackageFragment f47065l;

    /* renamed from: m, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.k f47066m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module, @NotNull ProtoBuf.PackageFragment proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s sVar) {
        super(fqName, storageManager, module);
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(module, "module");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        this.f47061h = metadataVersion;
        this.f47062i = sVar;
        ProtoBuf.StringTable strings = proto.getStrings();
        kotlin.jvm.internal.g0.o(strings, "getStrings(...)");
        ProtoBuf.QualifiedNameTable qualifiedNames = proto.getQualifiedNames();
        kotlin.jvm.internal.g0.o(qualifiedNames, "getQualifiedNames(...)");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.e eVar = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.e(strings, qualifiedNames);
        this.f47063j = eVar;
        this.f47064k = new l0(proto, eVar, metadataVersion, new r(this));
        this.f47065l = proto;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e1 J0(t tVar, kotlin.reflect.jvm.internal.impl.name.b it) {
        kotlin.jvm.internal.g0.p(it, "it");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s sVar = tVar.f47062i;
        if (sVar != null) {
            return sVar;
        }
        e1 NO_SOURCE = e1.f44683a;
        kotlin.jvm.internal.g0.o(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.q
    public void G0(@NotNull m components) {
        kotlin.jvm.internal.g0.p(components, "components");
        ProtoBuf.PackageFragment packageFragment = this.f47065l;
        if (packageFragment == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize");
        }
        this.f47065l = null;
        ProtoBuf.Package r42 = packageFragment.getPackage();
        kotlin.jvm.internal.g0.o(r42, "getPackage(...)");
        this.f47066m = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m0(this, r42, this.f47063j, this.f47061h, this.f47062i, components, "scope of " + this, new s(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.q
    @NotNull
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public l0 E0() {
        return this.f47064k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar = this.f47066m;
        if (kVar != null) {
            return kVar;
        }
        kotlin.jvm.internal.g0.S("_memberScope");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection L0(t tVar) {
        Collection<kotlin.reflect.jvm.internal.impl.name.b> b6 = tVar.E0().b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : b6) {
            kotlin.reflect.jvm.internal.impl.name.b bVar = (kotlin.reflect.jvm.internal.impl.name.b) obj;
            if (!bVar.j() && !k.f46985c.a().contains(bVar)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((kotlin.reflect.jvm.internal.impl.name.b) it.next()).h());
        }
        return arrayList2;
    }
}
