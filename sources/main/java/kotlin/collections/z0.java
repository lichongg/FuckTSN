package kotlin.collections;

import defpackage.H5BaseWebChromeClient;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nGrouping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n1#1,291:1\n80#1,6:292\n53#1:298\n80#1,6:299\n80#1,6:305\n53#1:311\n80#1,6:312\n80#1,6:318\n53#1:324\n80#1,6:325\n80#1,6:331\n189#1:337\n80#1,6:338\n*S KotlinDebug\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n53#1:292,6\n112#1:298\n112#1:299,6\n143#1:305,6\n164#1:311\n164#1:312,6\n189#1:318,6\n211#1:324\n211#1:325,6\n239#1:331,6\n257#1:337\n257#1:338,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class z0 extends y0 {
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> c(@NotNull w0<T, ? extends K> w0Var, @NotNull Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b6 = w0Var.b();
        while (b6.hasNext()) {
            ?? next = b6.next();
            Object a6 = w0Var.a(next);
            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) linkedHashMap.get(a6);
            linkedHashMap.put(a6, operation.invoke(a6, h5BaseWebChromeClient, next, Boolean.valueOf(h5BaseWebChromeClient == null && !linkedHashMap.containsKey(a6))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M d(@NotNull w0<T, ? extends K> w0Var, @NotNull M destination, @NotNull Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<T> b6 = w0Var.b();
        while (b6.hasNext()) {
            ?? next = b6.next();
            Object a6 = w0Var.a(next);
            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) destination.get(a6);
            destination.put(a6, operation.invoke(a6, h5BaseWebChromeClient, next, Boolean.valueOf(h5BaseWebChromeClient == null && !destination.containsKey(a6))));
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, M extends Map<? super K, Integer>> M e(@NotNull w0<T, ? extends K> w0Var, @NotNull M destination) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        Iterator<T> b6 = w0Var.b();
        while (b6.hasNext()) {
            K a6 = w0Var.a(b6.next());
            Object obj = destination.get(a6);
            if (obj == null && !destination.containsKey(a6)) {
                obj = 0;
            }
            destination.put(a6, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> f(@NotNull w0<T, ? extends K> w0Var, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b6 = w0Var.b();
        while (b6.hasNext()) {
            ?? next = b6.next();
            K a6 = w0Var.a(next);
            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) linkedHashMap.get(a6);
            if (h5BaseWebChromeClient == null && !linkedHashMap.containsKey(a6)) {
                h5BaseWebChromeClient = (Object) r5;
            }
            linkedHashMap.put(a6, operation.invoke(h5BaseWebChromeClient, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> g(@NotNull w0<T, ? extends K> w0Var, @NotNull Function2<? super K, ? super T, ? extends R> initialValueSelector, @NotNull Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        kotlin.jvm.internal.g0.p(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.g0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b6 = w0Var.b();
        while (b6.hasNext()) {
            ?? next = b6.next();
            Object a6 = w0Var.a(next);
            R r5 = (Object) linkedHashMap.get(a6);
            if (r5 == null && !linkedHashMap.containsKey(a6)) {
                r5 = initialValueSelector.invoke(a6, next);
            }
            linkedHashMap.put(a6, operation.invoke(a6, r5, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M h(@NotNull w0<T, ? extends K> w0Var, @NotNull M destination, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<T> b6 = w0Var.b();
        while (b6.hasNext()) {
            ?? next = b6.next();
            K a6 = w0Var.a(next);
            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) destination.get(a6);
            if (h5BaseWebChromeClient == null && !destination.containsKey(a6)) {
                h5BaseWebChromeClient = (Object) r5;
            }
            destination.put(a6, operation.invoke(h5BaseWebChromeClient, next));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M i(@NotNull w0<T, ? extends K> w0Var, @NotNull M destination, @NotNull Function2<? super K, ? super T, ? extends R> initialValueSelector, @NotNull Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<T> b6 = w0Var.b();
        while (b6.hasNext()) {
            ?? next = b6.next();
            Object a6 = w0Var.a(next);
            R r5 = (Object) destination.get(a6);
            if (r5 == null && !destination.containsKey(a6)) {
                r5 = initialValueSelector.invoke(a6, next);
            }
            destination.put(a6, operation.invoke(a6, r5, next));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S, T extends S, K> Map<K, S> j(@NotNull w0<T, ? extends K> w0Var, @NotNull Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator b6 = w0Var.b();
        while (b6.hasNext()) {
            S s5 = (Object) b6.next();
            Object a6 = w0Var.a(s5);
            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) linkedHashMap.get(a6);
            if (!(h5BaseWebChromeClient == null && !linkedHashMap.containsKey(a6))) {
                s5 = operation.invoke(a6, h5BaseWebChromeClient, s5);
            }
            linkedHashMap.put(a6, s5);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S, T extends S, K, M extends Map<? super K, S>> M k(@NotNull w0<T, ? extends K> w0Var, @NotNull M destination, @NotNull Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator b6 = w0Var.b();
        while (b6.hasNext()) {
            S s5 = (Object) b6.next();
            Object a6 = w0Var.a(s5);
            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) destination.get(a6);
            if (!(h5BaseWebChromeClient == null && !destination.containsKey(a6))) {
                s5 = operation.invoke(a6, h5BaseWebChromeClient, s5);
            }
            destination.put(a6, s5);
        }
        return destination;
    }
}
