package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.acse.ottn.l3;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.k1;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 3 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder\n*L\n1#1,347:1\n287#1:349\n13#2:348\n293#3:350\n293#3:351\n293#3:352\n293#3:353\n293#3:354\n293#3:355\n293#3:356\n293#3:357\n293#3:358\n293#3:359\n293#3:360\n293#3:361\n293#3:362\n293#3:363\n293#3:364\n293#3:365\n293#3:366\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n*L\n67#1:349\n56#1:348\n68#1:350\n73#1:351\n78#1:352\n93#1:353\n117#1:354\n134#1:355\n154#1:356\n202#1:357\n214#1:358\n234#1:359\n240#1:360\n246#1:361\n253#1:362\n258#1:363\n264#1:364\n270#1:365\n277#1:366\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final h f45752a = new h(NullabilityQualifier.NULLABLE, null, false, false, 8, null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final h f45753b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final h f45754c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<String, d1> f45755d;

    static {
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        f45753b = new h(nullabilityQualifier, null, false, false, 8, null);
        f45754c = new h(nullabilityQualifier, null, true, false, 8, null);
        kotlin.reflect.jvm.internal.impl.load.kotlin.f0 f0Var = kotlin.reflect.jvm.internal.impl.load.kotlin.f0.f45887a;
        String h6 = f0Var.h("Object");
        String g6 = f0Var.g("Predicate");
        String g7 = f0Var.g("Function");
        String g8 = f0Var.g("Consumer");
        String g9 = f0Var.g("BiFunction");
        String g10 = f0Var.g("BiConsumer");
        String g11 = f0Var.g("UnaryOperator");
        String i6 = f0Var.i("stream/Stream");
        String i7 = f0Var.i("Optional");
        k1 k1Var = new k1();
        k1.a.b(new k1.a(k1Var, f0Var.i("Iterator")), "forEachRemaining", null, new k(g8), 2, null);
        k1.a.b(new k1.a(k1Var, f0Var.h("Iterable")), "spliterator", null, new v(f0Var), 2, null);
        k1.a aVar = new k1.a(k1Var, f0Var.i("Collection"));
        k1.a.b(aVar, "removeIf", null, new g0(g6), 2, null);
        k1.a.b(aVar, "stream", null, new r0(i6), 2, null);
        k1.a.b(aVar, "parallelStream", null, new w0(i6), 2, null);
        k1.a aVar2 = new k1.a(k1Var, f0Var.i("List"));
        k1.a.b(aVar2, "replaceAll", null, new x0(g11), 2, null);
        aVar2.a("addFirst", "2.1", new y0(h6));
        aVar2.a("addLast", "2.1", new z0(h6));
        aVar2.a("removeFirst", "2.1", new a1(h6));
        aVar2.a("removeLast", "2.1", new b1(h6));
        k1.a aVar3 = new k1.a(k1Var, f0Var.i("LinkedList"));
        aVar3.a("addFirst", "2.1", new l(h6));
        aVar3.a("addLast", "2.1", new m(h6));
        aVar3.a("removeFirst", "2.1", new n(h6));
        aVar3.a("removeLast", "2.1", new o(h6));
        k1.a aVar4 = new k1.a(k1Var, f0Var.i("LinkedHashSet"));
        aVar4.a("addFirst", "2.2", new p(h6));
        aVar4.a("addLast", "2.2", new q(h6));
        aVar4.a("removeFirst", "2.2", new r(h6));
        aVar4.a("removeLast", "2.2", new s(h6));
        aVar4.a("getFirst", "2.2", new t(h6));
        aVar4.a("getLast", "2.2", new u(h6));
        k1.a aVar5 = new k1.a(k1Var, f0Var.i("Map"));
        k1.a.b(aVar5, "forEach", null, new w(g10), 2, null);
        k1.a.b(aVar5, "putIfAbsent", null, new x(h6), 2, null);
        k1.a.b(aVar5, "replace", null, new y(h6), 2, null);
        k1.a.b(aVar5, "replace", null, new z(h6), 2, null);
        k1.a.b(aVar5, "replaceAll", null, new a0(g9), 2, null);
        k1.a.b(aVar5, "compute", null, new b0(h6, g9), 2, null);
        k1.a.b(aVar5, "computeIfAbsent", null, new c0(h6, g7), 2, null);
        k1.a.b(aVar5, "computeIfPresent", null, new d0(h6, g9), 2, null);
        k1.a.b(aVar5, "merge", null, new e0(h6, g9), 2, null);
        k1.a aVar6 = new k1.a(k1Var, f0Var.i("LinkedHashMap"));
        aVar6.a("putFirst", "2.2", new f0(h6));
        aVar6.a("putLast", "2.2", new h0(h6));
        k1.a aVar7 = new k1.a(k1Var, i7);
        k1.a.b(aVar7, "empty", null, new i0(i7), 2, null);
        k1.a.b(aVar7, "of", null, new j0(h6, i7), 2, null);
        k1.a.b(aVar7, "ofNullable", null, new k0(h6, i7), 2, null);
        k1.a.b(aVar7, l3.f4736f, null, new l0(h6), 2, null);
        k1.a.b(aVar7, "ifPresent", null, new m0(g8), 2, null);
        k1.a.b(new k1.a(k1Var, f0Var.h("ref/Reference")), l3.f4736f, null, new n0(h6), 2, null);
        k1.a.b(new k1.a(k1Var, g6), "test", null, new o0(h6), 2, null);
        k1.a.b(new k1.a(k1Var, f0Var.g("BiPredicate")), "test", null, new p0(h6), 2, null);
        k1.a.b(new k1.a(k1Var, g8), "accept", null, new q0(h6), 2, null);
        k1.a.b(new k1.a(k1Var, g10), "accept", null, new s0(h6), 2, null);
        k1.a.b(new k1.a(k1Var, g7), "apply", null, new t0(h6), 2, null);
        k1.a.b(new k1.a(k1Var, g9), "apply", null, new u0(h6), 2, null);
        k1.a.b(new k1.a(k1Var, f0Var.g("Supplier")), l3.f4736f, null, new v0(h6), 2, null);
        f45755d = k1Var.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 A(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.b(str, hVar);
        function.c(str, f45752a);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 B(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.b(str, hVar);
        function.c(str, f45752a);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 C(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b, f45754c);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 D(String str, String str2, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45754c;
        function.b(str, hVar);
        function.c(str2, f45753b, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 E(String str, String str2, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45752a);
        function.c(str2, f45753b, f45754c);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 F(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45754c);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 G(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45753b, f45754c);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 H(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45752a);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 I(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45753b);
        function.d(JvmPrimitiveType.BOOLEAN);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 J(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.b(str, hVar);
        function.d(JvmPrimitiveType.BOOLEAN);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 K(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45753b);
        return kotlin.n1.f44123a;
    }

    @NotNull
    public static final Map<String, d1> K0() {
        return f45755d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 L(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.b(str, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 M(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.c(str, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 N(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.b(str, hVar);
        function.c(str, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 O(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 P(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar, hVar);
        function.d(JvmPrimitiveType.BOOLEAN);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 Q(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.c(str, hVar, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 R(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.c(str, hVar, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 a(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 b(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 c(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 d(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 e(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 f(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 g(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 h(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 i(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 j(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 k(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 l(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.b(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 m(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 n(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 o(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 p(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        function.c(str, f45753b);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 q(kotlin.reflect.jvm.internal.impl.load.kotlin.f0 f0Var, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        String i6 = f0Var.i("Spliterator");
        h hVar = f45753b;
        function.c(i6, hVar, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 r(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar, hVar, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 s(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.b(str, hVar);
        function.c(str, f45752a);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 t(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.b(str, hVar);
        function.c(str, f45752a);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 u(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.b(str, hVar);
        function.b(str, hVar);
        function.d(JvmPrimitiveType.BOOLEAN);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 v(String str, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar, hVar, hVar, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 w(String str, String str2, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        h hVar2 = f45752a;
        function.b(str2, hVar, hVar, hVar2, hVar2);
        function.c(str, hVar2);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 x(String str, String str2, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        function.b(str2, hVar, hVar, hVar);
        function.c(str, hVar);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 y(String str, String str2, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        h hVar2 = f45752a;
        function.b(str2, hVar, hVar, f45754c, hVar2);
        function.c(str, hVar2);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 z(String str, String str2, k1.a.C0890a function) {
        kotlin.jvm.internal.g0.p(function, "$this$function");
        h hVar = f45753b;
        function.b(str, hVar);
        h hVar2 = f45754c;
        function.b(str, hVar2);
        h hVar3 = f45752a;
        function.b(str2, hVar, hVar2, hVar2, hVar3);
        function.c(str, hVar3);
        return kotlin.n1.f44123a;
    }
}
