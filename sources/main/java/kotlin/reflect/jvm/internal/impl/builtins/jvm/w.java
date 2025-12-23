package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.f0;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmBuiltInsSignatures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltInsSignatures.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSignatures\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,212:1\n13#2:213\n13#2:219\n13#2:225\n13#2:226\n13#2:227\n13#2:228\n13#2:229\n13#2:230\n1460#3,5:214\n1460#3,5:220\n*S KotlinDebug\n*F\n+ 1 JvmBuiltInsSignatures.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSignatures\n*L\n64#1:213\n185#1:219\n23#1:225\n71#1:226\n80#1:227\n136#1:228\n163#1:229\n180#1:230\n65#1:214,5\n189#1:220,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f44533a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Set<String> f44534b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Set<String> f44535c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Set<String> f44536d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Set<String> f44537e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Set<String> f44538f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Set<String> f44539g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Set<String> f44540h;

    static {
        w wVar = new w();
        f44533a = wVar;
        f0 f0Var = f0.f45887a;
        f44534b = u1.D(f0Var.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f44535c = u1.C(u1.C(u1.C(u1.C(u1.C(u1.C(wVar.b(), f0Var.f("List", "sort(Ljava/util/Comparator;)V", "reversed()Ljava/util/List;")), f0Var.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), f0Var.e("Double", "isInfinite()Z", "isNaN()Z")), f0Var.e("Float", "isInfinite()Z", "isNaN()Z")), f0Var.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), f0Var.e("CharSequence", "isEmpty()Z"));
        f44536d = f0Var.f("List", "getFirst()Ljava/lang/Object;", "getLast()Ljava/lang/Object;");
        f44537e = u1.C(u1.C(u1.C(u1.C(u1.C(u1.C(f0Var.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), f0Var.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), f0Var.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), f0Var.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), f0Var.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), f0Var.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), f0Var.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f44538f = u1.C(u1.C(f0Var.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), f0Var.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), f0Var.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Set<String> a6 = wVar.a();
        String[] b6 = f0Var.b("D");
        Set C = u1.C(a6, f0Var.e("Float", (String[]) Arrays.copyOf(b6, b6.length)));
        String[] b7 = f0Var.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        f44539g = u1.C(C, f0Var.e("String", (String[]) Arrays.copyOf(b7, b7.length)));
        String[] b8 = f0Var.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f44540h = f0Var.e("Throwable", (String[]) Arrays.copyOf(b8, b8.length));
    }

    private final Set<String> a() {
        f0 f0Var = f0.f45887a;
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BYTE;
        List Q = kotlin.collections.f0.Q(JvmPrimitiveType.BOOLEAN, jvmPrimitiveType, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, jvmPrimitiveType, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = Q.iterator();
        while (it.hasNext()) {
            String b6 = ((JvmPrimitiveType) it.next()).getWrapperFqName().f().b();
            g0.o(b6, "asString(...)");
            String[] b7 = f0Var.b("Ljava/lang/String;");
            kotlin.collections.f0.s0(linkedHashSet, f0Var.e(b6, (String[]) Arrays.copyOf(b7, b7.length)));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        f0 f0Var = f0.f45887a;
        List<JvmPrimitiveType> Q = kotlin.collections.f0.Q(JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType : Q) {
            String b6 = jvmPrimitiveType.getWrapperFqName().f().b();
            g0.o(b6, "asString(...)");
            kotlin.collections.f0.s0(linkedHashSet, f0Var.e(b6, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> c() {
        return f44536d;
    }

    @NotNull
    public final Set<String> d() {
        return f44534b;
    }

    @NotNull
    public final Set<String> e() {
        return f44539g;
    }

    @NotNull
    public final Set<String> f() {
        return f44535c;
    }

    @NotNull
    public final Set<String> g() {
        return f44538f;
    }

    @NotNull
    public final Set<String> h() {
        return f44540h;
    }

    @NotNull
    public final Set<String> i() {
        return f44537e;
    }

    public final boolean j(@NotNull kotlin.reflect.jvm.internal.impl.name.d fqName) {
        g0.p(fqName, "fqName");
        return g0.g(fqName, o.a.f44599i) || kotlin.reflect.jvm.internal.impl.builtins.o.e(fqName);
    }

    public final boolean k(@NotNull kotlin.reflect.jvm.internal.impl.name.d fqName) {
        g0.p(fqName, "fqName");
        if (j(fqName)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.name.b n6 = c.f44463a.n(fqName);
        if (n6 == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(n6.a().a()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private w() {
    }
}
