package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.a$a, reason: collision with other inner class name */
    public static final class C0908a implements a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0908a f46560a = new C0908a();

        @Override // kotlin.reflect.jvm.internal.impl.renderer.a
        @NotNull
        public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f classifier, @NotNull m renderer) {
            g0.p(classifier, "classifier");
            g0.p(renderer, "renderer");
            if (classifier instanceof j1) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((j1) classifier).getName();
                g0.o(name, "getName(...)");
                return renderer.S(name, false);
            }
            kotlin.reflect.jvm.internal.impl.name.d m6 = kotlin.reflect.jvm.internal.impl.resolve.i.m(classifier);
            g0.o(m6, "getFqName(...)");
            return renderer.R(m6);
        }

        private C0908a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f46561a = new b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.f] */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.h0, kotlin.reflect.jvm.internal.impl.descriptors.k] */
        /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.k] */
        @Override // kotlin.reflect.jvm.internal.impl.renderer.a
        @NotNull
        public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f classifier, @NotNull m renderer) {
            g0.p(classifier, "classifier");
            g0.p(renderer, "renderer");
            if (classifier instanceof j1) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((j1) classifier).getName();
                g0.o(name, "getName(...)");
                return renderer.S(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(classifier.getName());
                classifier = classifier.b();
            } while (classifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.d);
            return a0.c(f0.d1(arrayList));
        }

        private b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f46562a = new c();

        private final String c(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                return b((kotlin.reflect.jvm.internal.impl.descriptors.f) kVar);
            }
            if (kVar instanceof l0) {
                return a0.a(((l0) kVar).d().i());
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.a
        @NotNull
        public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f classifier, @NotNull m renderer) {
            g0.p(classifier, "classifier");
            g0.p(renderer, "renderer");
            return b(classifier);
        }

        private c() {
        }

        private final String b(kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
            kotlin.reflect.jvm.internal.impl.name.f name = fVar.getName();
            g0.o(name, "getName(...)");
            String b6 = a0.b(name);
            if (fVar instanceof j1) {
                return b6;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.k b7 = fVar.b();
            g0.o(b7, "getContainingDeclaration(...)");
            String c6 = c(b7);
            if (c6 != null && !g0.g(c6, "")) {
                return c6 + '.' + b6;
            }
            return b6;
        }
    }

    @NotNull
    String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar, @NotNull m mVar);
}
