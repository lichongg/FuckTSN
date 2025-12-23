package kotlin.reflect.jvm.internal.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.load.java.h0;
import kotlin.reflect.jvm.internal.impl.load.java.i0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSpecialJvmAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialJvmAnnotations.kt\norg/jetbrains/kotlin/SpecialJvmAnnotations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n1634#2,3:43\n*S KotlinDebug\n*F\n+ 1 SpecialJvmAnnotations.kt\norg/jetbrains/kotlin/SpecialJvmAnnotations\n*L\n22#1:43,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f44394a = new a();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Set<b> f44395b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final b f44396c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.a$a, reason: collision with other inner class name */
    public static final class C0873a implements x.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f44397a;

        C0873a(Ref.BooleanRef booleanRef) {
            this.f44397a = booleanRef;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.c
        public x.a b(b classId, e1 source) {
            g0.p(classId, "classId");
            g0.p(source, "source");
            if (!g0.g(classId, h0.f45435a.a())) {
                return null;
            }
            this.f44397a.element = true;
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.c
        public void visitEnd() {
        }
    }

    static {
        List Q = f0.Q(i0.f45446a, i0.f45457l, i0.f45458m, i0.f45449d, i0.f45451f, i0.f45454i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        b.a aVar = b.f46334d;
        Iterator it = Q.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(aVar.c((c) it.next()));
        }
        f44395b = linkedHashSet;
        b.a aVar2 = b.f46334d;
        c REPEATABLE_ANNOTATION = i0.f45455j;
        g0.o(REPEATABLE_ANNOTATION, "REPEATABLE_ANNOTATION");
        f44396c = aVar2.c(REPEATABLE_ANNOTATION);
    }

    @NotNull
    public final b a() {
        return f44396c;
    }

    @NotNull
    public final Set<b> b() {
        return f44395b;
    }

    public final boolean c(@NotNull x klass) {
        g0.p(klass, "klass");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        klass.f(new C0873a(booleanRef), null);
        return booleanRef.element;
    }

    private a() {
    }
}
