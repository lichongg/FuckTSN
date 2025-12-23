package androidx.room;

import java.util.Set;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.flow.j0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/ObservedTableVersions\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,604:1\n230#2,5:605\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/ObservedTableVersions\n*L\n590#1:605,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ObservedTableVersions {

    @NotNull
    private final kotlinx.coroutines.flow.t<int[]> versions;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.j<? super int[]> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.room.ObservedTableVersions$collect$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.ObservedTableVersions$collect$1 r0 = (androidx.room.ObservedTableVersions$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.ObservedTableVersions$collect$1 r0 = new androidx.room.ObservedTableVersions$collect$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.g0.n(r6)
            goto L3f
        L31:
            kotlin.g0.n(r6)
            kotlinx.coroutines.flow.t<int[]> r6 = r4.versions
            r0.label = r3
            java.lang.Object r5 = r6.collect(r5, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableVersions.collect(kotlinx.coroutines.flow.j, kotlin.coroutines.e):java.lang.Object");
    }

    public final void increment(@NotNull Set<Integer> tableIds) {
        int[] value;
        int[] iArr;
        g0.p(tableIds, "tableIds");
        if (tableIds.isEmpty()) {
            return;
        }
        kotlinx.coroutines.flow.t<int[]> tVar = this.versions;
        do {
            value = tVar.getValue();
            int[] iArr2 = value;
            int length = iArr2.length;
            iArr = new int[length];
            for (int i6 = 0; i6 < length; i6++) {
                iArr[i6] = tableIds.contains(Integer.valueOf(i6)) ? iArr2[i6] + 1 : iArr2[i6];
            }
        } while (!tVar.compareAndSet(value, iArr));
    }

    public ObservedTableVersions(int i6) {
        this.versions = j0.a(new int[i6]);
    }
}
