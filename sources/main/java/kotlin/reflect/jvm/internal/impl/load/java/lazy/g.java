package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final k f45677a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final y3.d f45678b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f45679c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.h<y3.a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f45680d;

    public g(@NotNull k c6, @NotNull y3.d annotationOwner, boolean z5) {
        g0.p(c6, "c");
        g0.p(annotationOwner, "annotationOwner");
        this.f45677a = c6;
        this.f45678b = annotationOwner;
        this.f45679c = z5;
        this.f45680d = c6.a().u().c(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c d(g gVar, y3.a annotation) {
        g0.p(annotation, "annotation");
        return kotlin.reflect.jvm.internal.impl.load.java.components.d.f45385a.e(annotation, gVar.f45677a, gVar.f45679c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c invoke;
        g0.p(fqName, "fqName");
        y3.a b6 = this.f45678b.b(fqName);
        return (b6 == null || (invoke = this.f45680d.invoke(b6)) == null) ? kotlin.reflect.jvm.internal.impl.load.java.components.d.f45385a.a(fqName, this.f45678b, this.f45677a) : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return this.f45678b.getAnnotations().isEmpty() && !this.f45678b.s();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        return kotlin.sequences.p.X0(kotlin.sequences.p.S2(kotlin.sequences.p.N1(f0.E1(this.f45678b.getAnnotations()), this.f45680d), kotlin.reflect.jvm.internal.impl.load.java.components.d.f45385a.a(o.a.f44631y, this.f45678b, this.f45677a))).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean l(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return g.b.b(this, cVar);
    }

    public /* synthetic */ g(k kVar, y3.d dVar, boolean z5, int i6, v vVar) {
        this(kVar, dVar, (i6 & 4) != 0 ? false : z5);
    }
}
