package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.SinceKotlin;
import kotlin.collections.n;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "StreamsKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,731:1\n31#2:732\n*E\n"})
    public static final class a<T> implements kotlin.sequences.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Stream f47833a;

        public a(Stream stream) {
            this.f47833a = stream;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            Iterator<T> it;
            it = this.f47833a.iterator();
            g0.o(it, "iterator(...)");
            return it;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,731:1\n39#2:732\n*E\n"})
    public static final class b implements kotlin.sequences.m<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IntStream f47834a;

        public b(IntStream intStream) {
            this.f47834a = intStream;
        }

        @Override // kotlin.sequences.m
        public Iterator<Integer> iterator() {
            PrimitiveIterator.OfInt it;
            it = this.f47834a.iterator();
            g0.o(it, "iterator(...)");
            return it;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,731:1\n47#2:732\n*E\n"})
    public static final class c implements kotlin.sequences.m<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LongStream f47835a;

        public c(LongStream longStream) {
            this.f47835a = longStream;
        }

        @Override // kotlin.sequences.m
        public Iterator<Long> iterator() {
            PrimitiveIterator.OfLong it;
            it = this.f47835a.iterator();
            g0.o(it, "iterator(...)");
            return it;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,731:1\n55#2:732\n*E\n"})
    public static final class d implements kotlin.sequences.m<Double> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DoubleStream f47836a;

        public d(DoubleStream doubleStream) {
            this.f47836a = doubleStream;
        }

        @Override // kotlin.sequences.m
        public Iterator<Double> iterator() {
            PrimitiveIterator.OfDouble it;
            it = this.f47836a.iterator();
            g0.o(it, "iterator(...)");
            return it;
        }
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final kotlin.sequences.m<Double> b(@NotNull DoubleStream doubleStream) {
        g0.p(doubleStream, "<this>");
        return new d(doubleStream);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final kotlin.sequences.m<Integer> c(@NotNull IntStream intStream) {
        g0.p(intStream, "<this>");
        return new b(intStream);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final kotlin.sequences.m<Long> d(@NotNull LongStream longStream) {
        g0.p(longStream, "<this>");
        return new c(longStream);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> kotlin.sequences.m<T> e(@NotNull Stream<T> stream) {
        g0.p(stream, "<this>");
        return new a(stream);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Stream<T> f(@NotNull final kotlin.sequences.m<? extends T> mVar) {
        Stream<T> stream;
        g0.p(mVar, "<this>");
        stream = StreamSupport.stream(new Supplier() { // from class: kotlin.streams.jdk8.h
            @Override // java.util.function.Supplier
            public final Object get() {
                Spliterator g6;
                g6 = j.g(kotlin.sequences.m.this);
                return g6;
            }
        }, 16, false);
        g0.o(stream, "stream(...)");
        return stream;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Double> h(@NotNull DoubleStream doubleStream) {
        double[] array;
        g0.p(doubleStream, "<this>");
        array = doubleStream.toArray();
        g0.o(array, "toArray(...)");
        return n.p(array);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Integer> i(@NotNull IntStream intStream) {
        int[] array;
        g0.p(intStream, "<this>");
        array = intStream.toArray();
        g0.o(array, "toArray(...)");
        return n.r(array);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Long> j(@NotNull LongStream longStream) {
        long[] array;
        g0.p(longStream, "<this>");
        array = longStream.toArray();
        g0.o(array, "toArray(...)");
        return n.s(array);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> k(@NotNull Stream<T> stream) {
        Collector list;
        Object collect;
        g0.p(stream, "<this>");
        list = Collectors.toList();
        collect = stream.collect(list);
        g0.o(collect, "collect(...)");
        return (List) collect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Spliterator g(kotlin.sequences.m mVar) {
        Spliterator spliteratorUnknownSize;
        spliteratorUnknownSize = Spliterators.spliteratorUnknownSize(mVar.iterator(), 16);
        return spliteratorUnknownSize;
    }
}
