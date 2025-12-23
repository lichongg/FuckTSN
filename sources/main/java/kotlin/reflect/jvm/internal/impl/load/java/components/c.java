package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJavaAnnotationMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaAnnotationDescriptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class c implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.g {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45379f = {o0.u(new PropertyReference1Impl(c.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0))};

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.c f45380a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final e1 f45381b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45382c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final y3.b f45383d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f45384e;

    public c(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @Nullable y3.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        e1 NO_SOURCE;
        Collection<y3.b> arguments;
        g0.p(c6, "c");
        g0.p(fqName, "fqName");
        this.f45380a = fqName;
        if (aVar == null || (NO_SOURCE = c6.a().t().a(aVar)) == null) {
            NO_SOURCE = e1.f44683a;
            g0.o(NO_SOURCE, "NO_SOURCE");
        }
        this.f45381b = NO_SOURCE;
        this.f45382c = c6.e().e(new b(c6, this));
        this.f45383d = (aVar == null || (arguments = aVar.getArguments()) == null) ? null : (y3.b) f0.J2(arguments);
        boolean z5 = false;
        if (aVar != null && aVar.e()) {
            z5 = true;
        }
        this.f45384e = z5;
    }

    @Nullable
    protected final y3.b c() {
        return this.f45383d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c d() {
        return this.f45380a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.g
    public boolean e() {
        return this.f45384e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public e1 getSource() {
        return this.f45381b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.e1 getType() {
        return (kotlin.reflect.jvm.internal.impl.types.e1) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45382c, this, f45379f[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.e1 f(kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, c cVar) {
        kotlin.reflect.jvm.internal.impl.types.e1 s5 = kVar.d().p().p(cVar.d()).s();
        g0.o(s5, "getDefaultType(...)");
        return s5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return i1.z();
    }
}
