package kotlin.sequences;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.daimajia.numberprogressbar.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.a1;
import kotlin.collections.u1;
import kotlin.collections.w0;
import kotlin.collections.z1;
import kotlin.comparisons.g;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.d1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.sequences.k0;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,3218:1\n183#1,2:3219\n320#1,7:3221\n1332#1,3:3229\n747#1,4:3232\n712#1,4:3236\n730#1,4:3240\n783#1,4:3244\n1025#1,3:3248\n1028#1,3:3258\n1045#1,3:3261\n1048#1,3:3271\n1332#1,3:3288\n1321#1,2:3291\n1#2:3228\n382#3,7:3251\n382#3,7:3264\n382#3,7:3274\n382#3,7:3281\n*S KotlinDebug\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n91#1:3219,2\n103#1:3221,7\n462#1:3229,3\n666#1:3232,4\n682#1:3236,4\n697#1:3240,4\n768#1:3244,4\n996#1:3248,3\n996#1:3258,3\n1011#1:3261,3\n1011#1:3271,3\n1114#1:3288,3\n1152#1:3291,2\n996#1:3251,7\n1011#1:3264,7\n1027#1:3274,7\n1047#1:3281,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class k0 extends z {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,70:1\n3027#2:71\n*E\n"})
    public static final class a<T> implements Iterable<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m f47699a;

        public a(kotlin.sequences.m mVar) {
            this.f47699a = mVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f47699a.iterator();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt$filterIsInstance$1\n*L\n1#1,3218:1\n*E\n"})
    public static final class b implements Function1<Object, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f47700a = new b();

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            kotlin.jvm.internal.g0.y(3, "R");
            return Boolean.valueOf(androidx.activity.k.a(obj));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class c<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f47701a = new c();

        c() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> invoke(Iterable<? extends R> p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return p02.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class d<R> extends FunctionReferenceImpl implements Function1<kotlin.sequences.m<? extends R>, Iterator<? extends R>> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f47702a = new d();

        d() {
            super(1, kotlin.sequences.m.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> invoke(kotlin.sequences.m<? extends R> p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return p02.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class e<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f47703a = new e();

        e() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> invoke(Iterable<? extends R> p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return p02.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class f<R> extends FunctionReferenceImpl implements Function1<kotlin.sequences.m<? extends R>, Iterator<? extends R>> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f47704a = new f();

        f() {
            super(1, kotlin.sequences.m.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> invoke(kotlin.sequences.m<? extends R> p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return p02.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt$groupingBy$1\n*L\n1#1,3218:1\n*E\n"})
    public static final class g<K, T> implements w0<T, K> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47705a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<T, K> f47706b;

        /* JADX WARN: Multi-variable type inference failed */
        public g(kotlin.sequences.m<? extends T> mVar, Function1<? super T, ? extends K> function1) {
            this.f47705a = mVar;
            this.f47706b = function1;
        }

        @Override // kotlin.collections.w0
        public K a(T t5) {
            return this.f47706b.invoke(t5);
        }

        @Override // kotlin.collections.w0
        public Iterator<T> b() {
            return this.f47705a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class h<T> implements kotlin.sequences.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47707a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ T f47708b;

        /* JADX WARN: Multi-variable type inference failed */
        h(kotlin.sequences.m<? extends T> mVar, T t5) {
            this.f47707a = mVar;
            this.f47708b = t5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(Ref.BooleanRef booleanRef, Object obj, Object obj2) {
            if (booleanRef.element || !kotlin.jvm.internal.g0.g(obj2, obj)) {
                return true;
            }
            booleanRef.element = true;
            return false;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            kotlin.sequences.m<T> mVar = this.f47707a;
            final T t5 = this.f47708b;
            return k0.P0(mVar, new Function1() { // from class: kotlin.sequences.l0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean d6;
                    d6 = k0.h.d(Ref.BooleanRef.this, t5, obj);
                    return Boolean.valueOf(d6);
                }
            }).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class i<T> implements kotlin.sequences.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47709a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ T[] f47710b;

        /* JADX WARN: Multi-variable type inference failed */
        i(kotlin.sequences.m<? extends T> mVar, T[] tArr) {
            this.f47709a = mVar;
            this.f47710b = tArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            kotlin.sequences.m<T> mVar = this.f47709a;
            final T[] tArr = this.f47710b;
            return k0.W0(mVar, new Function1() { // from class: kotlin.sequences.m0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean d6;
                    d6 = k0.i.d(tArr, obj);
                    return Boolean.valueOf(d6);
                }
            }).iterator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(Object[] objArr, Object obj) {
            return kotlin.collections.n.B8(objArr, obj);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class j<T> implements kotlin.sequences.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable<T> f47711a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47712b;

        /* JADX WARN: Multi-variable type inference failed */
        j(Iterable<? extends T> iterable, kotlin.sequences.m<? extends T> mVar) {
            this.f47711a = iterable;
            this.f47712b = mVar;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            final Collection v02 = kotlin.collections.f0.v0(this.f47711a);
            return v02.isEmpty() ? this.f47712b.iterator() : k0.W0(this.f47712b, new Function1() { // from class: kotlin.sequences.n0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean d6;
                    d6 = k0.j.d(v02, obj);
                    return Boolean.valueOf(d6);
                }
            }).iterator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(Collection collection, Object obj) {
            return collection.contains(obj);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class k<T> implements kotlin.sequences.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47713a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47714b;

        /* JADX WARN: Multi-variable type inference failed */
        k(kotlin.sequences.m<? extends T> mVar, kotlin.sequences.m<? extends T> mVar2) {
            this.f47713a = mVar;
            this.f47714b = mVar2;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            final List I3 = k0.I3(this.f47713a);
            return I3.isEmpty() ? this.f47714b.iterator() : k0.W0(this.f47714b, new Function1() { // from class: kotlin.sequences.o0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean d6;
                    d6 = k0.k.d(I3, obj);
                    return Boolean.valueOf(d6);
                }
            }).iterator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(List list, Object obj) {
            return list.contains(obj);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2423, 2427}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "element"}, nl = {2424, 2429}, s = {"L$0", "L$0", "L$1", "L$3"}, v = 2)
    static final class l<R> extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super R>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f47715a;

        /* renamed from: b, reason: collision with root package name */
        Object f47716b;

        /* renamed from: c, reason: collision with root package name */
        Object f47717c;

        /* renamed from: d, reason: collision with root package name */
        int f47718d;

        /* renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f47719e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ R f47720f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47721g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<R, T, R> f47722h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        l(R r5, kotlin.sequences.m<? extends T> mVar, Function2<? super R, ? super T, ? extends R> function2, kotlin.coroutines.e<? super l> eVar) {
            super(2, eVar);
            this.f47720f = r5;
            this.f47721g = mVar;
            this.f47722h = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            l lVar = new l(this.f47720f, this.f47721g, this.f47722h, eVar);
            lVar.f47719e = obj;
            return lVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlin.sequences.o<? super R> oVar, kotlin.coroutines.e<? super n1> eVar) {
            return ((l) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
        
            if (r0.c(r7, r6) == r1) goto L18;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.f47719e
                kotlin.sequences.o r0 = (kotlin.sequences.o) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r6.f47718d
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L29
                if (r2 == r4) goto L25
                if (r2 != r3) goto L1d
                java.lang.Object r2 = r6.f47716b
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r4 = r6.f47715a
                kotlin.g0.n(r7)
                r7 = r4
                goto L41
            L1d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L25:
                kotlin.g0.n(r7)
                goto L39
            L29:
                kotlin.g0.n(r7)
                R r7 = r6.f47720f
                r6.f47719e = r0
                r6.f47718d = r4
                java.lang.Object r7 = r0.c(r7, r6)
                if (r7 != r1) goto L39
                goto L65
            L39:
                R r7 = r6.f47720f
                kotlin.sequences.m<T> r2 = r6.f47721g
                java.util.Iterator r2 = r2.iterator()
            L41:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L66
                java.lang.Object r4 = r2.next()
                kotlin.jvm.functions.Function2<R, T, R> r5 = r6.f47722h
                java.lang.Object r7 = r5.invoke(r7, r4)
                r6.f47719e = r0
                r6.f47715a = r7
                r6.f47716b = r2
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.j.a(r4)
                r6.f47717c = r4
                r6.f47718d = r3
                java.lang.Object r4 = r0.c(r7, r6)
                if (r4 != r1) goto L41
            L65:
                return r1
            L66:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.k0.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1, 1}, l = {2451, 2456}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "element", "index"}, nl = {2452, 2458}, s = {"L$0", "L$0", "L$1", "L$3", "I$0"}, v = 2)
    static final class m<R> extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super R>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f47723a;

        /* renamed from: b, reason: collision with root package name */
        Object f47724b;

        /* renamed from: c, reason: collision with root package name */
        Object f47725c;

        /* renamed from: d, reason: collision with root package name */
        int f47726d;

        /* renamed from: e, reason: collision with root package name */
        int f47727e;

        /* renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f47728f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ R f47729g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47730h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, R, T, R> f47731i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        m(R r5, kotlin.sequences.m<? extends T> mVar, Function3<? super Integer, ? super R, ? super T, ? extends R> function3, kotlin.coroutines.e<? super m> eVar) {
            super(2, eVar);
            this.f47729g = r5;
            this.f47730h = mVar;
            this.f47731i = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            m mVar = new m(this.f47729g, this.f47730h, this.f47731i, eVar);
            mVar.f47728f = obj;
            return mVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlin.sequences.o<? super R> oVar, kotlin.coroutines.e<? super n1> eVar) {
            return ((m) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
        
            if (r0.c(r9, r8) == r1) goto L21;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:9:0x004c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.f47728f
                kotlin.sequences.o r0 = (kotlin.sequences.o) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r8.f47727e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L2b
                if (r2 == r4) goto L27
                if (r2 != r3) goto L1f
                int r2 = r8.f47726d
                java.lang.Object r4 = r8.f47724b
                java.util.Iterator r4 = (java.util.Iterator) r4
                java.lang.Object r5 = r8.f47723a
                kotlin.g0.n(r9)
                r9 = r5
                goto L46
            L1f:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L27:
                kotlin.g0.n(r9)
                goto L3b
            L2b:
                kotlin.g0.n(r9)
                R r9 = r8.f47729g
                r8.f47728f = r0
                r8.f47727e = r4
                java.lang.Object r9 = r0.c(r9, r8)
                if (r9 != r1) goto L3b
                goto L77
            L3b:
                R r9 = r8.f47729g
                kotlin.sequences.m<T> r2 = r8.f47730h
                java.util.Iterator r2 = r2.iterator()
                r4 = 0
                r4 = r2
                r2 = 0
            L46:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L7a
                java.lang.Object r5 = r4.next()
                kotlin.jvm.functions.Function3<java.lang.Integer, R, T, R> r6 = r8.f47731i
                int r7 = r2 + 1
                if (r2 >= 0) goto L59
                kotlin.collections.f0.b0()
            L59:
                java.lang.Integer r2 = kotlin.coroutines.jvm.internal.a.f(r2)
                java.lang.Object r9 = r6.invoke(r2, r9, r5)
                r8.f47728f = r0
                r8.f47723a = r9
                r8.f47724b = r4
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.j.a(r5)
                r8.f47725c = r2
                r8.f47726d = r7
                r8.f47727e = r3
                java.lang.Object r2 = r0.c(r9, r8)
                if (r2 != r1) goto L78
            L77:
                return r1
            L78:
                r2 = r7
                goto L46
            L7a:
                kotlin.n1 r9 = kotlin.n1.f44123a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.k0.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2480, 2483}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, nl = {2481, 2486}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    static final class n<S> extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super S>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f47732a;

        /* renamed from: b, reason: collision with root package name */
        Object f47733b;

        /* renamed from: c, reason: collision with root package name */
        int f47734c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f47735d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47736e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function2<S, T, S> f47737f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        n(kotlin.sequences.m<? extends T> mVar, Function2<? super S, ? super T, ? extends S> function2, kotlin.coroutines.e<? super n> eVar) {
            super(2, eVar);
            this.f47736e = mVar;
            this.f47737f = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            n nVar = new n(this.f47736e, this.f47737f, eVar);
            nVar.f47735d = obj;
            return nVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlin.sequences.o<? super S> oVar, kotlin.coroutines.e<? super n1> eVar) {
            return ((n) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            Iterator it;
            kotlin.sequences.o oVar = (kotlin.sequences.o) this.f47735d;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f47734c;
            if (i6 == 0) {
                kotlin.g0.n(obj);
                Iterator it2 = this.f47736e.iterator();
                if (it2.hasNext()) {
                    next = it2.next();
                    this.f47735d = oVar;
                    this.f47732a = it2;
                    this.f47733b = next;
                    this.f47734c = 1;
                    if (oVar.c(next, this) != l6) {
                        it = it2;
                    }
                    return l6;
                }
                return n1.f44123a;
            }
            if (i6 != 1 && i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            next = this.f47733b;
            it = (Iterator) this.f47732a;
            kotlin.g0.n(obj);
            while (it.hasNext()) {
                next = this.f47737f.invoke(next, it.next());
                this.f47735d = oVar;
                this.f47732a = it;
                this.f47733b = next;
                this.f47734c = 2;
                if (oVar.c(next, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {AVMDLDataLoader.KeyIsPreconnectNum, 2513}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, nl = {AVMDLDataLoader.KeyIsEnableLoaderPreempt, 2516}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class o<S> extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super S>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f47738a;

        /* renamed from: b, reason: collision with root package name */
        Object f47739b;

        /* renamed from: c, reason: collision with root package name */
        int f47740c;

        /* renamed from: d, reason: collision with root package name */
        int f47741d;

        /* renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f47742e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47743f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, S, T, S> f47744g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        o(kotlin.sequences.m<? extends T> mVar, Function3<? super Integer, ? super S, ? super T, ? extends S> function3, kotlin.coroutines.e<? super o> eVar) {
            super(2, eVar);
            this.f47743f = mVar;
            this.f47744g = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            o oVar = new o(this.f47743f, this.f47744g, eVar);
            oVar.f47742e = obj;
            return oVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlin.sequences.o<? super S> oVar, kotlin.coroutines.e<? super n1> eVar) {
            return ((o) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
        
            if (r0.c(r2, r9) == r1) goto L22;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.f47742e
                kotlin.sequences.o r0 = (kotlin.sequences.o) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r9.f47741d
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L33
                if (r2 == r4) goto L29
                if (r2 != r3) goto L21
                int r2 = r9.f47740c
                java.lang.Object r4 = r9.f47739b
                java.lang.Object r5 = r9.f47738a
                java.util.Iterator r5 = (java.util.Iterator) r5
                kotlin.g0.n(r10)
                r8 = r4
                r4 = r2
                r2 = r8
                goto L55
            L21:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L29:
                java.lang.Object r2 = r9.f47739b
                java.lang.Object r5 = r9.f47738a
                java.util.Iterator r5 = (java.util.Iterator) r5
                kotlin.g0.n(r10)
                goto L55
            L33:
                kotlin.g0.n(r10)
                kotlin.sequences.m<T> r10 = r9.f47743f
                java.util.Iterator r5 = r10.iterator()
                boolean r10 = r5.hasNext()
                if (r10 == 0) goto L84
                java.lang.Object r2 = r5.next()
                r9.f47742e = r0
                r9.f47738a = r5
                r9.f47739b = r2
                r9.f47741d = r4
                java.lang.Object r10 = r0.c(r2, r9)
                if (r10 != r1) goto L55
                goto L80
            L55:
                boolean r10 = r5.hasNext()
                if (r10 == 0) goto L84
                kotlin.jvm.functions.Function3<java.lang.Integer, S, T, S> r10 = r9.f47744g
                int r6 = r4 + 1
                if (r4 >= 0) goto L64
                kotlin.collections.f0.b0()
            L64:
                java.lang.Integer r4 = kotlin.coroutines.jvm.internal.a.f(r4)
                java.lang.Object r7 = r5.next()
                java.lang.Object r4 = r10.invoke(r4, r2, r7)
                r9.f47742e = r0
                r9.f47738a = r5
                r9.f47739b = r4
                r9.f47740c = r6
                r9.f47741d = r3
                java.lang.Object r10 = r0.c(r4, r9)
                if (r10 != r1) goto L81
            L80:
                return r1
            L81:
                r2 = r4
                r4 = r6
                goto L55
            L84:
                kotlin.n1 r10 = kotlin.n1.f44123a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.k0.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class p<T> implements kotlin.sequences.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47745a;

        /* JADX WARN: Multi-variable type inference failed */
        p(kotlin.sequences.m<? extends T> mVar) {
            this.f47745a = mVar;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            List J3 = k0.J3(this.f47745a);
            kotlin.collections.f0.o0(J3);
            return J3.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class q<T> implements kotlin.sequences.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47746a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f47747b;

        /* JADX WARN: Multi-variable type inference failed */
        q(kotlin.sequences.m<? extends T> mVar, Comparator<? super T> comparator) {
            this.f47746a = mVar;
            this.f47747b = comparator;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            List J3 = k0.J3(this.f47746a);
            kotlin.collections.f0.r0(J3, this.f47747b);
            return J3.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0, 0}, l = {2979}, m = "invokeSuspend", n = {"$this$result", "iterator", "current", "next"}, nl = {2980}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class r<R> extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super R>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f47748a;

        /* renamed from: b, reason: collision with root package name */
        Object f47749b;

        /* renamed from: c, reason: collision with root package name */
        Object f47750c;

        /* renamed from: d, reason: collision with root package name */
        int f47751d;

        /* renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f47752e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f47753f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function2<T, T, R> f47754g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        r(kotlin.sequences.m<? extends T> mVar, Function2<? super T, ? super T, ? extends R> function2, kotlin.coroutines.e<? super r> eVar) {
            super(2, eVar);
            this.f47753f = mVar;
            this.f47754g = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            r rVar = new r(this.f47753f, this.f47754g, eVar);
            rVar.f47752e = obj;
            return rVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlin.sequences.o<? super R> oVar, kotlin.coroutines.e<? super n1> eVar) {
            return ((r) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            Iterator it;
            kotlin.sequences.o oVar = (kotlin.sequences.o) this.f47752e;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f47751d;
            if (i6 == 0) {
                kotlin.g0.n(obj);
                Iterator it2 = this.f47753f.iterator();
                if (!it2.hasNext()) {
                    return n1.f44123a;
                }
                next = it2.next();
                it = it2;
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                next = this.f47750c;
                it = (Iterator) this.f47748a;
                kotlin.g0.n(obj);
            }
            while (it.hasNext()) {
                Object next2 = it.next();
                R invoke = this.f47754g.invoke(next, next2);
                this.f47752e = oVar;
                this.f47748a = it;
                this.f47749b = kotlin.coroutines.jvm.internal.j.a(next);
                this.f47750c = next2;
                this.f47751d = 1;
                if (oVar.c(invoke, this) == l6) {
                    return l6;
                }
                next = next2;
            }
            return n1.f44123a;
        }
    }

    @JvmName(name = "averageOfShort")
    public static final double A0(@NotNull kotlin.sequences.m<Short> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Short> it = mVar.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().shortValue();
            i6++;
            if (i6 < 0) {
                kotlin.collections.f0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> w0<T, K> A1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        return new g(mVar, keySelector);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final double A2(@NotNull kotlin.sequences.m<Double> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final <T> long A3(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Long> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += selector.invoke(it.next()).longValue();
        }
        return j6;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> kotlin.sequences.m<List<T>> B0(@NotNull kotlin.sequences.m<? extends T> mVar, int i6) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return M3(mVar, i6, i6, true);
    }

    public static final <T> int B1(@NotNull kotlin.sequences.m<? extends T> mVar, T t5) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        int i6 = 0;
        for (T t6 : mVar) {
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            if (kotlin.jvm.internal.g0.g(t5, t6)) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final float B2(@NotNull kotlin.sequences.m<Float> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return floatValue;
    }

    @JvmName(name = "sumOfShort")
    public static final int B3(@NotNull kotlin.sequences.m<Short> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Short> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += it.next().shortValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> kotlin.sequences.m<R> C0(@NotNull kotlin.sequences.m<? extends T> mVar, int i6, @NotNull Function1<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return N3(mVar, i6, i6, true, transform);
    }

    public static final <T> int C1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (T t5 : mVar) {
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            if (predicate.invoke(t5).booleanValue()) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    @NotNull
    public static final <T extends Comparable<? super T>> T C2(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final <T> int C3(kotlin.sequences.m<? extends T> mVar, Function1<? super T, z0> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = z0.k(0);
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            k6 = z0.k(k6 + selector.invoke(it.next()).q0());
        }
        return k6;
    }

    public static <T> boolean D0(@NotNull kotlin.sequences.m<? extends T> mVar, T t5) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return B1(mVar, t5) >= 0;
    }

    public static final <T> int D1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = -1;
        int i7 = 0;
        for (T t5 : mVar) {
            if (i7 < 0) {
                kotlin.collections.f0.b0();
            }
            if (predicate.invoke(t5).booleanValue()) {
                i6 = i7;
            }
            i7++;
        }
        return i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T D2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) > 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final <T> long D3(kotlin.sequences.m<? extends T> mVar, Function1<? super T, d1> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = d1.k(0L);
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            k6 = d1.k(k6 + selector.invoke(it.next()).q0());
        }
        return k6;
    }

    public static <T> int E0(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            it.next();
            i6++;
            if (i6 < 0) {
                kotlin.collections.f0.a0();
            }
        }
        return i6;
    }

    @NotNull
    public static final <T, A extends Appendable> A E1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (T t5 : mVar) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            kotlin.text.u.b(buffer, t5, function1);
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final <T> T E2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) > 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    @NotNull
    public static final <T> kotlin.sequences.m<T> E3(@NotNull kotlin.sequences.m<? extends T> mVar, int i6) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        if (i6 >= 0) {
            return i6 == 0 ? x.l() : mVar instanceof kotlin.sequences.e ? ((kotlin.sequences.e) mVar).b(i6) : new q0(mVar, i6);
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    public static final <T> int F0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue() && (i6 = i6 + 1) < 0) {
                kotlin.collections.f0.a0();
            }
        }
        return i6;
    }

    @NotNull
    public static final <T> kotlin.sequences.m<T> F2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return new j(elements, mVar);
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> F3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        return new r0(mVar, predicate);
    }

    @NotNull
    public static final <T> kotlin.sequences.m<T> G0(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return I0(mVar, new Function1() { // from class: kotlin.sequences.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object H0;
                H0 = k0.H0(obj);
                return H0;
            }
        });
    }

    @NotNull
    public static final <T> String G1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) E1(mVar, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @NotNull
    public static final <T> kotlin.sequences.m<T> G2(@NotNull kotlin.sequences.m<? extends T> mVar, T t5) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return new h(mVar, t5);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C G3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static /* synthetic */ String H1(kotlin.sequences.m mVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return G1(mVar, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @NotNull
    public static final <T> kotlin.sequences.m<T> H2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return new k(elements, mVar);
    }

    @NotNull
    public static final <T> HashSet<T> H3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return (HashSet) G3(mVar, new HashSet());
    }

    @NotNull
    public static final <T, K> kotlin.sequences.m<T> I0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return new kotlin.sequences.c(mVar, selector);
    }

    public static <T> T I1(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> kotlin.sequences.m<T> I2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return elements.length == 0 ? mVar : new i(mVar, elements);
    }

    @NotNull
    public static <T> List<T> I3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return kotlin.collections.f0.J();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return kotlin.collections.f0.l(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> kotlin.sequences.m<T> J0(@NotNull kotlin.sequences.m<? extends T> mVar, int i6) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        if (i6 >= 0) {
            return i6 == 0 ? mVar : mVar instanceof kotlin.sequences.e ? ((kotlin.sequences.e) mVar).a(i6) : new kotlin.sequences.d(mVar, i6);
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T J1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        boolean z5 = false;
        for (T t6 : mVar) {
            if (predicate.invoke(t6).booleanValue()) {
                z5 = true;
                t5 = t6;
            }
        }
        if (z5) {
            return t5;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @InlineOnly
    private static final <T> kotlin.sequences.m<T> J2(kotlin.sequences.m<? extends T> mVar, T t5) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return G2(mVar, t5);
    }

    @NotNull
    public static <T> List<T> J3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return (List) G3(mVar, new ArrayList());
    }

    @NotNull
    public static final <T> kotlin.sequences.m<T> K0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        return new kotlin.sequences.f(mVar, predicate);
    }

    public static final <T> int K1(@NotNull kotlin.sequences.m<? extends T> mVar, T t5) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        int i6 = -1;
        int i7 = 0;
        for (T t6 : mVar) {
            if (i7 < 0) {
                kotlin.collections.f0.b0();
            }
            if (kotlin.jvm.internal.g0.g(t5, t6)) {
                i6 = i7;
            }
            i7++;
        }
        return i6;
    }

    public static final <T> boolean K2(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return !mVar.iterator().hasNext();
    }

    @NotNull
    public static final <T> Set<T> K3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static final <T> T L0(@NotNull kotlin.sequences.m<? extends T> mVar, final int i6) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return (T) N0(mVar, i6, new Function1() { // from class: kotlin.sequences.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object M0;
                M0 = k0.M0(i6, ((Integer) obj).intValue());
                return M0;
            }
        });
    }

    @Nullable
    public static final <T> T L1(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T> boolean L2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <T> Set<T> L3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return u1.k();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return u1.f(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object M0(int i6, int i7) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + i6 + '.');
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @Nullable
    public static final <T> T M1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        for (T t6 : mVar) {
            if (predicate.invoke(t6).booleanValue()) {
                t5 = t6;
            }
        }
        return t5;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> kotlin.sequences.m<T> M2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull final Function1<? super T, n1> action) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        return N1(mVar, new Function1() { // from class: kotlin.sequences.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object N2;
                N2 = k0.N2(Function1.this, obj);
                return N2;
            }
        });
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> kotlin.sequences.m<List<T>> M3(@NotNull kotlin.sequences.m<? extends T> mVar, int i6, int i7, boolean z5) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return z1.c(mVar, i6, i7, z5, false);
    }

    public static final <T> T N0(@NotNull kotlin.sequences.m<? extends T> mVar, int i6, @NotNull Function1<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        if (i6 < 0) {
            return defaultValue.invoke(Integer.valueOf(i6));
        }
        int i7 = 0;
        for (T t5 : mVar) {
            int i8 = i7 + 1;
            if (i6 == i7) {
                return t5;
            }
            i7 = i8;
        }
        return defaultValue.invoke(Integer.valueOf(i6));
    }

    @NotNull
    public static <T, R> kotlin.sequences.m<R> N1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return new t0(mVar, transform);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> kotlin.sequences.m<R> N3(@NotNull kotlin.sequences.m<? extends T> mVar, int i6, int i7, boolean z5, @NotNull Function1<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return N1(z1.c(mVar, i6, i7, z5, true), transform);
    }

    @Nullable
    public static final <T> T O0(@NotNull kotlin.sequences.m<? extends T> mVar, int i6) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        if (i6 < 0) {
            return null;
        }
        int i7 = 0;
        for (T t5 : mVar) {
            int i8 = i7 + 1;
            if (i6 == i7) {
                return t5;
            }
            i7 = i8;
        }
        return null;
    }

    @NotNull
    public static final <T, R> kotlin.sequences.m<R> O1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return new s0(mVar, transform);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T> kotlin.sequences.m<T> O2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull final Function2<? super Integer, ? super T, n1> action) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        return O1(mVar, new Function2() { // from class: kotlin.sequences.i0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Object P2;
                P2 = k0.P2(Function2.this, ((Integer) obj).intValue(), obj2);
                return P2;
            }
        });
    }

    public static /* synthetic */ kotlin.sequences.m O3(kotlin.sequences.m mVar, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return M3(mVar, i6, i7, z5);
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> P0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        return new kotlin.sequences.h(mVar, true, predicate);
    }

    @NotNull
    public static final <T, R> kotlin.sequences.m<R> P1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return X0(new s0(mVar, transform));
    }

    public static /* synthetic */ kotlin.sequences.m P3(kotlin.sequences.m mVar, int i6, int i7, boolean z5, Function1 function1, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return N3(mVar, i6, i7, z5, function1);
    }

    @NotNull
    public static final <T> kotlin.sequences.m<T> Q0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull final Function2<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        return new t0(new kotlin.sequences.h(new kotlin.sequences.k(mVar), true, new Function1() { // from class: kotlin.sequences.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean R0;
                R0 = k0.R0(Function2.this, (a1) obj);
                return Boolean.valueOf(R0);
            }
        }), new Function1() { // from class: kotlin.sequences.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object S0;
                S0 = k0.S0((a1) obj);
                return S0;
            }
        });
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C Q1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        for (T t5 : mVar) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            R invoke = transform.invoke(Integer.valueOf(i6), t5);
            if (invoke != null) {
                destination.add(invoke);
            }
            i6 = i7;
        }
        return destination;
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> Q2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t5 : mVar) {
            if (predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
            } else {
                arrayList2.add(t5);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final <T> kotlin.sequences.m<a1<T>> Q3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return new kotlin.sequences.k(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R0(Function2 function2, a1 it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return ((Boolean) function2.invoke(Integer.valueOf(it.e()), it.f())).booleanValue();
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C R1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        for (T t5 : mVar) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            destination.add(transform.invoke(Integer.valueOf(i6), t5));
            i6 = i7;
        }
        return destination;
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> R2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return x.n(x.C(mVar, kotlin.collections.f0.E1(elements)));
    }

    @NotNull
    public static final <T, R> kotlin.sequences.m<Pair<T, R>> R3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull kotlin.sequences.m<? extends R> other) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        return new kotlin.sequences.l(mVar, other, new Function2() { // from class: kotlin.sequences.a0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair T3;
                T3 = k0.T3(obj, obj2);
                return T3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object S0(a1 it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.f();
    }

    @NotNull
    public static <T, R> kotlin.sequences.m<R> S1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return X0(new t0(mVar, transform));
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> S2(@NotNull kotlin.sequences.m<? extends T> mVar, T t5) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return x.n(x.C(mVar, x.B(t5)));
    }

    @NotNull
    public static final <T, R, V> kotlin.sequences.m<V> S3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull kotlin.sequences.m<? extends R> other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return new kotlin.sequences.l(mVar, other, transform);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C T0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (T t5 : mVar) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            if (predicate.invoke(Integer.valueOf(i6), t5).booleanValue()) {
                destination.add(t5);
            }
            i6 = i7;
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C T1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> T2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return x.n(x.C(mVar, elements));
    }

    public static final /* synthetic */ <R> kotlin.sequences.m<R> U0(kotlin.sequences.m<?> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.w();
        kotlin.sequences.m<R> P0 = P0(mVar, b.f47700a);
        kotlin.jvm.internal.g0.n(P0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return P0;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C U1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    @NotNull
    public static final <T> kotlin.sequences.m<T> U2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        return R2(mVar, kotlin.collections.n.t(elements));
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> kotlin.sequences.m<Pair<T, T>> U3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return V3(mVar, new Function2() { // from class: kotlin.sequences.e0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair W3;
                W3 = k0.W3(obj, obj2);
                return W3;
            }
        });
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C V0(kotlin.sequences.m<?> mVar, C destination) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (Object obj : mVar) {
            kotlin.jvm.internal.g0.y(3, "R");
            if (androidx.activity.k.a(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T, R extends Comparable<? super R>> T V1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @InlineOnly
    private static final <T> kotlin.sequences.m<T> V2(kotlin.sequences.m<? extends T> mVar, T t5) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return S2(mVar, t5);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> kotlin.sequences.m<R> V3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function2<? super T, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return kotlin.sequences.q.b(new r(mVar, transform, null));
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> W0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        return new kotlin.sequences.h(mVar, false, predicate);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T W1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    public static final <S, T extends S> S W2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
        }
        return next;
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> X0(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.sequences.m<T> W0 = W0(mVar, new Function1() { // from class: kotlin.sequences.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean Y0;
                Y0 = k0.Y0(obj);
                return Boolean.valueOf(Y0);
            }
        });
        kotlin.jvm.internal.g0.n(W0, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return W0;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double X1(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return doubleValue;
    }

    public static final <S, T extends S> S X2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it.next();
        int i6 = 1;
        while (it.hasNext()) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            next = operation.invoke(Integer.valueOf(i6), next, it.next());
            i6 = i7;
        }
        return next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y0(Object obj) {
        return obj == null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> float Y1(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(it.next()).floatValue());
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S Y2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i6 = 1;
        while (it.hasNext()) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            next = operation.invoke(Integer.valueOf(i6), next, it.next());
            i6 = i7;
        }
        return next;
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C Z0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (T t5 : mVar) {
            if (t5 != null) {
                destination.add(t5);
            }
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R Z1(kotlin.sequences.m<? extends T> mVar, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S Z2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
        }
        return next;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C a1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : mVar) {
            if (!predicate.invoke(t5).booleanValue()) {
                destination.add(t5);
            }
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R a2(kotlin.sequences.m<? extends T> mVar, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @NotNull
    public static final <T> kotlin.sequences.m<T> a3(@NotNull final kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return N1(mVar, new Function1() { // from class: kotlin.sequences.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object b32;
                b32 = k0.b3(m.this, obj);
                return b32;
            }
        });
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C b1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : mVar) {
            if (predicate.invoke(t5).booleanValue()) {
                destination.add(t5);
            }
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Double b2(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object b3(kotlin.sequences.m mVar, Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException("null element found in " + mVar + '.');
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @InlineOnly
    private static final <T> T c1(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : mVar) {
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Float c2(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> kotlin.sequences.m<R> c3(@NotNull kotlin.sequences.m<? extends T> mVar, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        return kotlin.sequences.q.b(new l(r5, mVar, operation, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @InlineOnly
    private static final <T> T d1(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        for (T t6 : mVar) {
            if (predicate.invoke(t6).booleanValue()) {
                t5 = t6;
            }
        }
        return t5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R d2(kotlin.sequences.m<? extends T> mVar, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> kotlin.sequences.m<R> d3(@NotNull kotlin.sequences.m<? extends T> mVar, R r5, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        return kotlin.sequences.q.b(new m(r5, mVar, operation, null));
    }

    public static final <T> T e1(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R e2(kotlin.sequences.m<? extends T> mVar, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <S, T extends S> kotlin.sequences.m<S> e3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        return kotlin.sequences.q.b(new n(mVar, operation, null));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T f1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : mVar) {
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T extends Comparable<? super T>> T f2(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <S, T extends S> kotlin.sequences.m<S> f3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        return kotlin.sequences.q.b(new o(mVar, operation, null));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R g1(kotlin.sequences.m<? extends T> mVar, Function1<? super T, ? extends R> transform) {
        R r5;
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (true) {
            if (!it.hasNext()) {
                r5 = null;
                break;
            }
            r5 = transform.invoke(it.next());
            if (r5 != null) {
                break;
            }
        }
        if (r5 != null) {
            return r5;
        }
        throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double g2(@NotNull kotlin.sequences.m<Double> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> kotlin.sequences.m<R> g3(@NotNull kotlin.sequences.m<? extends T> mVar, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        return c3(mVar, r5, operation);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R h1(kotlin.sequences.m<? extends T> mVar, Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float h2(@NotNull kotlin.sequences.m<Float> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> kotlin.sequences.m<R> h3(@NotNull kotlin.sequences.m<? extends T> mVar, R r5, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        return d3(mVar, r5, operation);
    }

    public static final <T> boolean i0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static <T> T i1(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final double i2(@NotNull kotlin.sequences.m<Double> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return doubleValue;
    }

    public static final <T> T i3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        return next;
    }

    public static final <T> boolean j0(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return mVar.iterator().hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Nullable
    public static final <T> T j1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : mVar) {
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final float j2(@NotNull kotlin.sequences.m<Float> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T j3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        boolean z5 = false;
        for (T t6 : mVar) {
            if (predicate.invoke(t6).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
                z5 = true;
                t5 = t6;
            }
        }
        if (z5) {
            return t5;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> boolean k0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static <T, R> kotlin.sequences.m<R> k1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return new kotlin.sequences.i(mVar, transform, d.f47702a);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    @NotNull
    public static final <T extends Comparable<? super T>> T k2(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @Nullable
    public static final <T> T k3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @NotNull
    public static <T> Iterable<T> l0(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return new a(mVar);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapIndexedIterable")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> kotlin.sequences.m<R> l1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return x.m(mVar, transform, e.f47703a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T l2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    @Nullable
    public static final <T> T l3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        boolean z5 = false;
        T t5 = null;
        for (T t6 : mVar) {
            if (predicate.invoke(t6).booleanValue()) {
                if (z5) {
                    return null;
                }
                z5 = true;
                t5 = t6;
            }
        }
        if (z5) {
            return t5;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> kotlin.sequences.m<T> m0(kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return mVar;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C m1(kotlin.sequences.m<? extends T> mVar, C destination, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        for (T t5 : mVar) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            kotlin.collections.f0.s0(destination, transform.invoke(Integer.valueOf(i6), t5));
            i6 = i7;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final <T> T m2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> kotlin.sequences.m<T> m3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return new p(mVar);
    }

    @NotNull
    public static final <T, K, V> Map<K, V> n0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapIndexedSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> kotlin.sequences.m<R> n1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function2<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return x.m(mVar, transform, f.f47704a);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T, R extends Comparable<? super R>> T n2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> kotlin.sequences.m<T> n3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return q3(mVar, new g.a(selector));
    }

    @NotNull
    public static final <T, K> Map<K, T> o0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t5 : mVar) {
            linkedHashMap.put(keySelector.invoke(t5), t5);
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedSequenceTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C o1(kotlin.sequences.m<? extends T> mVar, C destination, Function2<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int i6 = 0;
        for (T t5 : mVar) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            kotlin.collections.f0.t0(destination, transform.invoke(Integer.valueOf(i6), t5));
            i6 = i7;
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T o2(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> kotlin.sequences.m<T> o3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return q3(mVar, new g.c(selector));
    }

    @NotNull
    public static final <T, K, V> Map<K, V> p0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t5 : mVar) {
            linkedHashMap.put(keySelector.invoke(t5), valueTransform.invoke(t5));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapIterable")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> kotlin.sequences.m<R> p1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        return new kotlin.sequences.i(mVar, transform, c.f47701a);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double p2(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return doubleValue;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> kotlin.sequences.m<T> p3(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return q3(mVar, kotlin.comparisons.a.x());
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M q0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (T t5 : mVar) {
            destination.put(keySelector.invoke(t5), t5);
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapIterableTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R, C extends Collection<? super R>> C q1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            kotlin.collections.f0.s0(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> float q2(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(it.next()).floatValue());
        }
        return floatValue;
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> q3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return new q(mVar, comparator);
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M r0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (T t5 : mVar) {
            destination.put(keySelector.invoke(t5), valueTransform.invoke(t5));
        }
        return destination;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C r1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull C destination, @NotNull Function1<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            kotlin.collections.f0.t0(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R r2(kotlin.sequences.m<? extends T> mVar, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int r3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Integer> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += selector.invoke(it.next()).intValue();
        }
        return i6;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M s0(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull M destination, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final <T, R> R s1(@NotNull kotlin.sequences.m<? extends T> mVar, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            r5 = operation.invoke(r5, it.next());
        }
        return r5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R s2(kotlin.sequences.m<? extends T> mVar, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double s3(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            d6 += selector.invoke(it.next()).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V> Map<K, V> t0(@NotNull kotlin.sequences.m<? extends K> mVar, @NotNull Function1<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k6 : mVar) {
            linkedHashMap.put(k6, valueSelector.invoke(k6));
        }
        return linkedHashMap;
    }

    public static final <T, R> R t1(@NotNull kotlin.sequences.m<? extends T> mVar, R r5, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int i6 = 0;
        for (T t5 : mVar) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            r5 = operation.invoke(Integer.valueOf(i6), r5, t5);
            i6 = i7;
        }
        return r5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Double t2(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @JvmName(name = "sumOfByte")
    public static final int t3(@NotNull kotlin.sequences.m<Byte> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Byte> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += it.next().byteValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M u0(@NotNull kotlin.sequences.m<? extends K> mVar, @NotNull M destination, @NotNull Function1<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (K k6 : mVar) {
            destination.put(k6, valueSelector.invoke(k6));
        }
        return destination;
    }

    public static final <T> void u1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, n1> action) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Float u2(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @JvmName(name = "sumOfDouble")
    public static final double u3(@NotNull kotlin.sequences.m<Double> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            d6 += it.next().doubleValue();
        }
        return d6;
    }

    @JvmName(name = "averageOfByte")
    public static final double v0(@NotNull kotlin.sequences.m<Byte> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Byte> it = mVar.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().byteValue();
            i6++;
            if (i6 < 0) {
                kotlin.collections.f0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    public static final <T> void v1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function2<? super Integer, ? super T, n1> action) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int i6 = 0;
        for (T t5 : mVar) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            action.invoke(Integer.valueOf(i6), t5);
            i6 = i7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R v2(kotlin.sequences.m<? extends T> mVar, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final <T> double v3(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            d6 += selector.invoke(it.next()).doubleValue();
        }
        return d6;
    }

    @JvmName(name = "averageOfDouble")
    public static final double w0(@NotNull kotlin.sequences.m<Double> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().doubleValue();
            i6++;
            if (i6 < 0) {
                kotlin.collections.f0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> w1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t5 : mVar) {
            K invoke = keySelector.invoke(t5);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(t5);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R w2(kotlin.sequences.m<? extends T> mVar, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @JvmName(name = "sumOfFloat")
    public static final float w3(@NotNull kotlin.sequences.m<Float> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        float f6 = 0.0f;
        while (it.hasNext()) {
            f6 += it.next().floatValue();
        }
        return f6;
    }

    @JvmName(name = "averageOfFloat")
    public static final double x0(@NotNull kotlin.sequences.m<Float> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().floatValue();
            i6++;
            if (i6 < 0) {
                kotlin.collections.f0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @NotNull
    public static final <T, K, V> Map<K, List<V>> x1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t5 : mVar) {
            K invoke = keySelector.invoke(t5);
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(t5));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T extends Comparable<? super T>> T x2(@NotNull kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @JvmName(name = "sumOfInt")
    public static final int x3(@NotNull kotlin.sequences.m<Integer> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Integer> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += it.next().intValue();
        }
        return i6;
    }

    @JvmName(name = "averageOfInt")
    public static final double y0(@NotNull kotlin.sequences.m<Integer> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Integer> it = mVar.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().intValue();
            i6++;
            if (i6 < 0) {
                kotlin.collections.f0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, List<T>>> M y1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (T t5 : mVar) {
            K invoke = keySelector.invoke(t5);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(t5);
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double y2(@NotNull kotlin.sequences.m<Double> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final <T> int y3(kotlin.sequences.m<? extends T> mVar, Function1<? super T, Integer> selector) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += selector.invoke(it.next()).intValue();
        }
        return i6;
    }

    @JvmName(name = "averageOfLong")
    public static final double z0(@NotNull kotlin.sequences.m<Long> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Long> it = mVar.iterator();
        double d6 = 0.0d;
        int i6 = 0;
        while (it.hasNext()) {
            d6 += it.next().longValue();
            i6++;
            if (i6 < 0) {
                kotlin.collections.f0.a0();
            }
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M z1(@NotNull kotlin.sequences.m<? extends T> mVar, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (T t5 : mVar) {
            K invoke = keySelector.invoke(t5);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(t5));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float z2(@NotNull kotlin.sequences.m<Float> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @JvmName(name = "sumOfLong")
    public static final long z3(@NotNull kotlin.sequences.m<Long> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        Iterator<Long> it = mVar.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += it.next().longValue();
        }
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object N2(Function1 function1, Object obj) {
        function1.invoke(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object P2(Function2 function2, int i6, Object obj) {
        function2.invoke(Integer.valueOf(i6), obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair T3(Object obj, Object obj2) {
        return kotlin.o0.a(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair W3(Object obj, Object obj2) {
        return kotlin.o0.a(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object H0(Object obj) {
        return obj;
    }
}
