package kotlinx.coroutines;

import java.util.Collection;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n37#2,2:128\n13579#3,2:130\n1855#4,2:132\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n*L\n42#1:128,2\n54#1:130,2\n66#1:132,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {54}, m = "joinAll", n = {"$this$forEach$iv"}, s = {"L$0"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48571a;

        /* renamed from: b, reason: collision with root package name */
        int f48572b;

        /* renamed from: c, reason: collision with root package name */
        int f48573c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48574d;

        /* renamed from: e, reason: collision with root package name */
        int f48575e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48574d = obj;
            this.f48575e |= Integer.MIN_VALUE;
            return f.d(null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {}, l = {66}, m = "joinAll", n = {}, s = {})
    static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48576a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48577b;

        /* renamed from: c, reason: collision with root package name */
        int f48578c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48577b = obj;
            this.f48578c |= Integer.MIN_VALUE;
            return f.c(null, this);
        }

        b(kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
        }
    }

    @Nullable
    public static final <T> Object b(@NotNull x0<? extends T>[] x0VarArr, @NotNull kotlin.coroutines.e<? super List<? extends T>> eVar) {
        return x0VarArr.length == 0 ? kotlin.collections.f0.J() : new e(x0VarArr).c(eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlinx.coroutines.e2> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.f.b
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.f$b r0 = (kotlinx.coroutines.f.b) r0
            int r1 = r0.f48578c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48578c = r1
            goto L18
        L13:
            kotlinx.coroutines.f$b r0 = new kotlinx.coroutines.f$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f48577b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48578c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f48576a
            java.util.Iterator r4 = (java.util.Iterator) r4
            kotlin.g0.n(r5)
            goto L3e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r5)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L3e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L55
            java.lang.Object r5 = r4.next()
            kotlinx.coroutines.e2 r5 = (kotlinx.coroutines.e2) r5
            r0.f48576a = r4
            r0.f48578c = r3
            java.lang.Object r5 = r5.M(r0)
            if (r5 != r1) goto L3e
            return r1
        L55:
            kotlin.n1 r4 = kotlin.n1.f44123a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.f.c(java.util.Collection, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0052 -> B:10:0x0055). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.e2[] r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.f.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.f$a r0 = (kotlinx.coroutines.f.a) r0
            int r1 = r0.f48575e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48575e = r1
            goto L18
        L13:
            kotlinx.coroutines.f$a r0 = new kotlinx.coroutines.f$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f48574d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48575e
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r6 = r0.f48573c
            int r2 = r0.f48572b
            java.lang.Object r4 = r0.f48571a
            kotlinx.coroutines.e2[] r4 = (kotlinx.coroutines.e2[]) r4
            kotlin.g0.n(r7)
            r7 = r4
            goto L55
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.g0.n(r7)
            int r7 = r6.length
            r2 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L42:
            if (r2 >= r6) goto L57
            r4 = r7[r2]
            r0.f48571a = r7
            r0.f48572b = r2
            r0.f48573c = r6
            r0.f48575e = r3
            java.lang.Object r4 = r4.M(r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            int r2 = r2 + r3
            goto L42
        L57:
            kotlin.n1 r6 = kotlin.n1.f44123a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.f.d(kotlinx.coroutines.e2[], kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public static final <T> Object a(@NotNull Collection<? extends x0<? extends T>> collection, @NotNull kotlin.coroutines.e<? super List<? extends T>> eVar) {
        if (collection.isEmpty()) {
            return kotlin.collections.f0.J();
        }
        return new e((x0[]) collection.toArray(new x0[0])).c(eVar);
    }
}
