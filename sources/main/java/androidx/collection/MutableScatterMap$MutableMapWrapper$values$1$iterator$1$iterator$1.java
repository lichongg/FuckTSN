package androidx.collection;

import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.sequences.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.collection.MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1511}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$1", "I$0", "I$1", "J$0", "I$2", "I$3"})
@SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1850:1\n363#2,6:1851\n373#2,3:1858\n376#2,9:1862\n1826#3:1857\n1688#3:1861\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1\n*L\n1510#1:1851,6\n1510#1:1858,3\n1510#1:1862,9\n1510#1:1857\n1510#1:1861\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
final class MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1 extends RestrictedSuspendLambda implements Function2<o<? super Integer>, e<? super n1>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap, e<? super MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1> eVar) {
        super(2, eVar);
        this.this$0 = mutableScatterMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final e<n1> create(@Nullable Object obj, @NotNull e<?> eVar) {
        MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1 mutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1 = new MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1(this.this$0, eVar);
        mutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1.L$0 = obj;
        return mutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull o<? super Integer> oVar, @Nullable e<? super n1> eVar) {
        return ((MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1) create(oVar, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0087 -> B:5:0x008a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004d -> B:15:0x0093). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004f -> B:6:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x006a -> B:5:0x008a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 0
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L2e
            if (r2 != r5) goto L26
            int r2 = r0.I$3
            int r6 = r0.I$2
            long r7 = r0.J$0
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.L$0
            kotlin.sequences.o r12 = (kotlin.sequences.o) r12
            kotlin.g0.n(r21)
            goto L8a
        L26:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L2e:
            kotlin.g0.n(r21)
            java.lang.Object r2 = r0.L$0
            kotlin.sequences.o r2 = (kotlin.sequences.o) r2
            androidx.collection.MutableScatterMap<K, V> r6 = r0.this$0
            long[] r6 = r6.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L98
            r8 = 0
        L3f:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 == 0) goto L93
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            int r11 = 8 - r11
            r12 = r11
            r11 = r6
            r6 = r12
            r12 = r2
            r2 = 0
            r18 = r9
            r10 = r7
            r9 = r8
            r7 = r18
        L61:
            if (r2 >= r6) goto L8d
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r7
            r15 = 128(0x80, double:6.3E-322)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 >= 0) goto L8a
            int r13 = r9 << 3
            int r13 = r13 + r2
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.a.f(r13)
            r0.L$0 = r12
            r0.L$1 = r11
            r0.I$0 = r10
            r0.I$1 = r9
            r0.J$0 = r7
            r0.I$2 = r6
            r0.I$3 = r2
            r0.label = r5
            java.lang.Object r13 = r12.c(r13, r0)
            if (r13 != r1) goto L8a
            return r1
        L8a:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L61
        L8d:
            if (r6 != r4) goto L98
            r8 = r9
            r7 = r10
            r6 = r11
            r2 = r12
        L93:
            if (r8 == r7) goto L98
            int r8 = r8 + 1
            goto L3f
        L98:
            kotlin.n1 r1 = kotlin.n1.f44123a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
