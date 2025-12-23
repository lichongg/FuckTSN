package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "e", "bufferInitialCapacity", "gap", "skip", "$this$iterator", "buffer", "bufferInitialCapacity", "gap", "skip", "$this$iterator", "buffer", "e", "bufferInitialCapacity", "gap", "$this$iterator", "buffer", "bufferInitialCapacity", "gap", "$this$iterator", "buffer", "bufferInitialCapacity", "gap"}, nl = {35, 43, 50, 56, 61}, s = {"L$0", "L$1", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "L$3", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class a<T> extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super List<? extends T>>, kotlin.coroutines.e<? super kotlin.n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f43711a;

        /* renamed from: b, reason: collision with root package name */
        Object f43712b;

        /* renamed from: c, reason: collision with root package name */
        Object f43713c;

        /* renamed from: d, reason: collision with root package name */
        int f43714d;

        /* renamed from: e, reason: collision with root package name */
        int f43715e;

        /* renamed from: f, reason: collision with root package name */
        int f43716f;

        /* renamed from: g, reason: collision with root package name */
        int f43717g;

        /* renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f43718h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f43719i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f43720j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Iterator<T> f43721k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f43722l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f43723m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(int i6, int i7, Iterator<? extends T> it, boolean z5, boolean z6, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f43719i = i6;
            this.f43720j = i7;
            this.f43721k = it;
            this.f43722l = z5;
            this.f43723m = z6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<kotlin.n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            a aVar = new a(this.f43719i, this.f43720j, this.f43721k, this.f43722l, this.f43723m, eVar);
            aVar.f43718h = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlin.sequences.o<? super List<? extends T>> oVar, kotlin.coroutines.e<? super kotlin.n1> eVar) {
            return ((a) create(oVar, eVar)).invokeSuspend(kotlin.n1.f44123a);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00c6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00bc  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0176 -> B:16:0x0179). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0142 -> B:31:0x0145). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x00b0 -> B:50:0x005f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 421
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.z1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 SlidingWindow.kt\nkotlin/collections/SlidingWindowKt\n*L\n1#1,731:1\n19#2:732\n*E\n"})
    public static final class b<T> implements kotlin.sequences.m<List<? extends T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m f43724a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f43725b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f43726c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f43727d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f43728e;

        public b(kotlin.sequences.m mVar, int i6, int i7, boolean z5, boolean z6) {
            this.f43724a = mVar;
            this.f43725b = i6;
            this.f43726c = i7;
            this.f43727d = z5;
            this.f43728e = z6;
        }

        @Override // kotlin.sequences.m
        public Iterator<List<? extends T>> iterator() {
            return z1.b(this.f43724a.iterator(), this.f43725b, this.f43726c, this.f43727d, this.f43728e);
        }
    }

    public static final void a(int i6, int i7) {
        String str;
        if (i6 <= 0 || i7 <= 0) {
            if (i6 != i7) {
                str = "Both size " + i6 + " and step " + i7 + " must be greater than zero.";
            } else {
                str = "size " + i6 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    @NotNull
    public static final <T> Iterator<List<T>> b(@NotNull Iterator<? extends T> iterator, int i6, int i7, boolean z5, boolean z6) {
        kotlin.jvm.internal.g0.p(iterator, "iterator");
        return !iterator.hasNext() ? t0.f43688a : kotlin.sequences.p.a(new a(i6, i7, iterator, z6, z5, null));
    }

    @NotNull
    public static final <T> kotlin.sequences.m<List<T>> c(@NotNull kotlin.sequences.m<? extends T> mVar, int i6, int i7, boolean z5, boolean z6) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        a(i6, i7);
        return new b(mVar, i6, i7, z5, z6);
    }
}
