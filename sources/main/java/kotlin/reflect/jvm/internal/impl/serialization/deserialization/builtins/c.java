package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.t;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c extends t implements kotlin.reflect.jvm.internal.impl.builtins.c {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f46821o = new a(null);

    /* renamed from: n, reason: collision with root package name */
    private final boolean f46822n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final c a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull n storageManager, @NotNull f0 module, @NotNull InputStream inputStream, boolean z5) {
            g0.p(fqName, "fqName");
            g0.p(storageManager, "storageManager");
            g0.p(module, "module");
            g0.p(inputStream, "inputStream");
            Pair<ProtoBuf.PackageFragment, z3.a> a6 = z3.c.a(inputStream);
            ProtoBuf.PackageFragment component1 = a6.component1();
            z3.a component2 = a6.component2();
            if (component1 != null) {
                return new c(fqName, storageManager, module, component1, component2, z5, null);
            }
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + z3.a.f56811h + ", actual " + component2 + ". Please update Kotlin");
        }
    }

    public /* synthetic */ c(kotlin.reflect.jvm.internal.impl.name.c cVar, n nVar, f0 f0Var, ProtoBuf.PackageFragment packageFragment, z3.a aVar, boolean z5, v vVar) {
        this(cVar, nVar, f0Var, packageFragment, aVar, z5);
    }

    private c(kotlin.reflect.jvm.internal.impl.name.c cVar, n nVar, f0 f0Var, ProtoBuf.PackageFragment packageFragment, z3.a aVar, boolean z5) {
        super(cVar, nVar, f0Var, packageFragment, aVar, null);
        this.f46822n = z5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h0, kotlin.reflect.jvm.internal.impl.descriptors.impl.m
    @NotNull
    public String toString() {
        return "builtins package fragment for " + d() + " from " + e.s(this);
    }
}
