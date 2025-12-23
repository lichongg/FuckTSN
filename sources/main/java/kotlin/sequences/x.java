package kotlin.sequences;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.daimajia.numberprogressbar.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class x extends r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n*L\n1#1,731:1\n*E\n"})
    public static final class a<T> implements m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Iterator<T>> f47804a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends Iterator<? extends T>> function0) {
            this.f47804a = function0;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            return this.f47804a.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt\n*L\n1#1,731:1\n31#2:732\n*E\n"})
    public static final class b<T> implements m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f47805a;

        public b(Iterator it) {
            this.f47805a = it;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            return this.f47805a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400}, m = "invokeSuspend", n = {"$this$sequence", "element", "result", "index"}, nl = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500}, s = {"L$0", "L$2", "L$3", "I$0"}, v = 2)
    static final class c<R> extends RestrictedSuspendLambda implements Function2<o<? super R>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f47806a;

        /* renamed from: b, reason: collision with root package name */
        Object f47807b;

        /* renamed from: c, reason: collision with root package name */
        Object f47808c;

        /* renamed from: d, reason: collision with root package name */
        int f47809d;

        /* renamed from: e, reason: collision with root package name */
        int f47810e;

        /* renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f47811f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ m<T> f47812g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, T, C> f47813h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Function1<C, Iterator<R>> f47814i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(m<? extends T> mVar, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f47812g = mVar;
            this.f47813h = function2;
            this.f47814i = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            c cVar = new c(this.f47812g, this.f47813h, this.f47814i, eVar);
            cVar.f47811f = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(o<? super R> oVar, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i6;
            Iterator it;
            o oVar = (o) this.f47811f;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i7 = this.f47810e;
            if (i7 == 0) {
                kotlin.g0.n(obj);
                i6 = 0;
                it = this.f47812g.iterator();
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i6 = this.f47809d;
                it = (Iterator) this.f47806a;
                kotlin.g0.n(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                Function2<Integer, T, C> function2 = this.f47813h;
                int i8 = i6 + 1;
                if (i6 < 0) {
                    kotlin.collections.f0.b0();
                }
                Object invoke = function2.invoke(kotlin.coroutines.jvm.internal.a.f(i6), next);
                Iterator<R> invoke2 = this.f47814i.invoke(invoke);
                this.f47811f = oVar;
                this.f47806a = it;
                this.f47807b = kotlin.coroutines.jvm.internal.j.a(next);
                this.f47808c = kotlin.coroutines.jvm.internal.j.a(invoke);
                this.f47809d = i8;
                this.f47810e = 1;
                if (oVar.f(invoke2, this) == l6) {
                    return l6;
                }
                i6 = i8;
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {0, 0, 1, 1}, l = {102, 104}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "$this$sequence", "iterator"}, nl = {104, 106}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class d<T> extends RestrictedSuspendLambda implements Function2<o<? super T>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f47815a;

        /* renamed from: b, reason: collision with root package name */
        int f47816b;

        /* renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f47817c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ m<T> f47818d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<m<T>> f47819e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(m<? extends T> mVar, Function0<? extends m<? extends T>> function0, kotlin.coroutines.e<? super d> eVar) {
            super(2, eVar);
            this.f47818d = mVar;
            this.f47819e = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            d dVar = new d(this.f47818d, this.f47819e, eVar);
            dVar.f47817c = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(o<? super T> oVar, kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        
            if (r0.f(r6, r5) == r1) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
        
            if (r0.g(r2, r5) == r1) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.f47817c
                kotlin.sequences.o r0 = (kotlin.sequences.o) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r5.f47816b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L23
                if (r2 == r4) goto L1b
                if (r2 != r3) goto L13
                goto L1b
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1b:
                java.lang.Object r0 = r5.f47815a
                java.util.Iterator r0 = (java.util.Iterator) r0
                kotlin.g0.n(r6)
                goto L64
            L23:
                kotlin.g0.n(r6)
                kotlin.sequences.m<T> r6 = r5.f47818d
                java.util.Iterator r6 = r6.iterator()
                boolean r2 = r6.hasNext()
                if (r2 == 0) goto L47
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r0)
                r5.f47817c = r2
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r6)
                r5.f47815a = r2
                r5.f47816b = r4
                java.lang.Object r6 = r0.f(r6, r5)
                if (r6 != r1) goto L64
                goto L63
            L47:
                kotlin.jvm.functions.Function0<kotlin.sequences.m<T>> r2 = r5.f47819e
                java.lang.Object r2 = r2.invoke()
                kotlin.sequences.m r2 = (kotlin.sequences.m) r2
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.j.a(r0)
                r5.f47817c = r4
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.j.a(r6)
                r5.f47815a = r6
                r5.f47816b = r3
                java.lang.Object r6 = r0.g(r2, r5)
                if (r6 != r1) goto L64
            L63:
                return r1
            L64:
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.x.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt\n*L\n1#1,731:1\n49#2,11:732\n*E\n"})
    public static final class e<T> implements m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f47820a;

        public e(Object obj) {
            this.f47820a = obj;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            return new f(this.f47820a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f<T> implements Iterator<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f47821a = true;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ T f47822b;

        f(T t5) {
            this.f47822b = t5;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47821a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f47821a) {
                throw new NoSuchElementException();
            }
            this.f47821a = false;
            return this.f47822b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0, 0, 0, 0}, l = {178}, m = "invokeSuspend", n = {"$this$sequence", "buffer", "last", "value", "j"}, nl = {180}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    static final class g<T> extends RestrictedSuspendLambda implements Function2<o<? super T>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f47823a;

        /* renamed from: b, reason: collision with root package name */
        Object f47824b;

        /* renamed from: c, reason: collision with root package name */
        Object f47825c;

        /* renamed from: d, reason: collision with root package name */
        int f47826d;

        /* renamed from: e, reason: collision with root package name */
        int f47827e;

        /* renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f47828f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ m<T> f47829g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Random f47830h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(m<? extends T> mVar, Random random, kotlin.coroutines.e<? super g> eVar) {
            super(2, eVar);
            this.f47829g = mVar;
            this.f47830h = random;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            g gVar = new g(this.f47829g, this.f47830h, eVar);
            gVar.f47828f = obj;
            return gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(o<? super T> oVar, kotlin.coroutines.e<? super n1> eVar) {
            return ((g) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List J3;
            o oVar = (o) this.f47828f;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f47827e;
            if (i6 == 0) {
                kotlin.g0.n(obj);
                J3 = k0.J3(this.f47829g);
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                J3 = (List) this.f47823a;
                kotlin.g0.n(obj);
            }
            while (!J3.isEmpty()) {
                int nextInt = this.f47830h.nextInt(J3.size());
                Object Q0 = kotlin.collections.f0.Q0(J3);
                Object obj2 = nextInt < J3.size() ? J3.set(nextInt, Q0) : Q0;
                this.f47828f = oVar;
                this.f47823a = J3;
                this.f47824b = kotlin.coroutines.jvm.internal.j.a(Q0);
                this.f47825c = kotlin.coroutines.jvm.internal.j.a(obj2);
                this.f47826d = nextInt;
                this.f47827e = 1;
                if (oVar.c(obj2, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    @SinceKotlin(version = "2.2")
    @NotNull
    public static <T> m<T> B(T t5) {
        return new e(t5);
    }

    @NotNull
    public static <T> m<T> C(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return kotlin.collections.n.T5(elements);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T> m<T> D(@NotNull m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return E(mVar, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T> m<T> E(@NotNull m<? extends T> mVar, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        return q.b(new g(mVar, random, null));
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> F(@NotNull m<? extends Pair<? extends T, ? extends R>> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : mVar) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.o0.a(arrayList, arrayList2);
    }

    @InlineOnly
    private static final <T> m<T> i(Function0<? extends Iterator<? extends T>> iterator) {
        kotlin.jvm.internal.g0.p(iterator, "iterator");
        return new a(iterator);
    }

    @NotNull
    public static <T> m<T> j(@NotNull Iterator<? extends T> it) {
        kotlin.jvm.internal.g0.p(it, "<this>");
        return k(new b(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> m<T> k(@NotNull m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return mVar instanceof kotlin.sequences.a ? mVar : new kotlin.sequences.a(mVar);
    }

    @NotNull
    public static <T> m<T> l() {
        return kotlin.sequences.g.f47670a;
    }

    @NotNull
    public static final <T, C, R> m<R> m(@NotNull m<? extends T> source, @NotNull Function2<? super Integer, ? super T, ? extends C> transform, @NotNull Function1<? super C, ? extends Iterator<? extends R>> iterator) {
        kotlin.jvm.internal.g0.p(source, "source");
        kotlin.jvm.internal.g0.p(transform, "transform");
        kotlin.jvm.internal.g0.p(iterator, "iterator");
        return q.b(new c(source, transform, iterator, null));
    }

    @NotNull
    public static final <T> m<T> n(@NotNull m<? extends m<? extends T>> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return o(mVar, new Function1() { // from class: kotlin.sequences.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Iterator p5;
                p5 = x.p((m) obj);
                return p5;
            }
        });
    }

    private static final <T, R> m<R> o(m<? extends T> mVar, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        return mVar instanceof t0 ? ((t0) mVar).e(function1) : new i(mVar, new Function1() { // from class: kotlin.sequences.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object r5;
                r5 = x.r(obj);
                return r5;
            }
        }, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator p(m it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator q(Iterable it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.iterator();
    }

    @JvmName(name = "flattenSequenceOfIterable")
    @NotNull
    public static final <T> m<T> s(@NotNull m<? extends Iterable<? extends T>> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return o(mVar, new Function1() { // from class: kotlin.sequences.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Iterator q5;
                q5 = x.q((Iterable) obj);
                return q5;
            }
        });
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static <T> m<T> t(@Nullable final T t5, @NotNull Function1<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.g0.p(nextFunction, "nextFunction");
        return t5 == null ? kotlin.sequences.g.f47670a : new j(new Function0() { // from class: kotlin.sequences.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object x5;
                x5 = x.x(t5);
                return x5;
            }
        }, nextFunction);
    }

    @NotNull
    public static <T> m<T> u(@NotNull final Function0<? extends T> nextFunction) {
        kotlin.jvm.internal.g0.p(nextFunction, "nextFunction");
        return k(new j(nextFunction, new Function1() { // from class: kotlin.sequences.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object w5;
                w5 = x.w(Function0.this, obj);
                return w5;
            }
        }));
    }

    @NotNull
    public static <T> m<T> v(@NotNull Function0<? extends T> seedFunction, @NotNull Function1<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.g0.p(seedFunction, "seedFunction");
        kotlin.jvm.internal.g0.p(nextFunction, "nextFunction");
        return new j(seedFunction, nextFunction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object w(Function0 function0, Object it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return function0.invoke();
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> m<T> y(@NotNull m<? extends T> mVar, @NotNull Function0<? extends m<? extends T>> defaultValue) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return q.b(new d(mVar, defaultValue, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> m<T> z(m<? extends T> mVar) {
        return mVar == 0 ? l() : mVar;
    }

    @SinceKotlin(version = "2.2")
    @InlineOnly
    private static final <T> m<T> A() {
        return l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object r(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object x(Object obj) {
        return obj;
    }
}
