package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface g extends Iterable<c>, m3.a {

    /* renamed from: q0, reason: collision with root package name */
    @NotNull
    public static final a f44655q0 = a.f44656a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f44656a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final g f44657b = new C0877a();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.annotations.g$a$a, reason: collision with other inner class name */
        public static final class C0877a implements g {
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
            public boolean isEmpty() {
                return true;
            }

            public Void a(kotlin.reflect.jvm.internal.impl.name.c fqName) {
                g0.p(fqName, "fqName");
                return null;
            }

            public String toString() {
                return "EMPTY";
            }

            C0877a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
            public /* bridge */ /* synthetic */ c b(kotlin.reflect.jvm.internal.impl.name.c cVar) {
                return (c) a(cVar);
            }

            @Override // java.lang.Iterable
            public Iterator<c> iterator() {
                return f0.J().iterator();
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
            public boolean l(kotlin.reflect.jvm.internal.impl.name.c cVar) {
                return b.b(this, cVar);
            }
        }

        @NotNull
        public final g a(@NotNull List<? extends c> annotations) {
            g0.p(annotations, "annotations");
            return annotations.isEmpty() ? f44657b : new h(annotations);
        }

        @NotNull
        public final g b() {
            return f44657b;
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/Annotations$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n295#2,2:124\n*S KotlinDebug\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/Annotations$DefaultImpls\n*L\n29#1:124,2\n*E\n"})
    public static final class b {
        @Nullable
        public static c a(@NotNull g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            c cVar;
            g0.p(fqName, "fqName");
            Iterator<c> it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = it.next();
                if (g0.g(cVar.d(), fqName)) {
                    break;
                }
            }
            return cVar;
        }

        public static boolean b(@NotNull g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            g0.p(fqName, "fqName");
            return gVar.b(fqName) != null;
        }
    }

    @Nullable
    c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    boolean isEmpty();

    boolean l(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);
}
