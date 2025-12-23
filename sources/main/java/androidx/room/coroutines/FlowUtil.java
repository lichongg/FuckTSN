package androidx.room.coroutines;

import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.SQLiteConnection;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "FlowUtil")
@SourceDebugExtension({"SMAP\nFlowBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowBuilder.kt\nandroidx/room/coroutines/FlowUtil\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,40:1\n53#2:41\n55#2:45\n50#3:42\n55#3:44\n107#4:43\n*S KotlinDebug\n*F\n+ 1 FlowBuilder.kt\nandroidx/room/coroutines/FlowUtil\n*L\n37#1:41\n37#1:45\n37#1:42\n37#1:44\n37#1:43\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class FlowUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public static final <R> i<R> createFlow(@NotNull final RoomDatabase db, final boolean z5, @NotNull String[] tableNames, @NotNull final Function1<? super SQLiteConnection, ? extends R> block) {
        g0.p(db, "db");
        g0.p(tableNames, "tableNames");
        g0.p(block, "block");
        final i W = k.W(db.getInvalidationTracker().createFlow((String[]) Arrays.copyOf(tableNames, tableNames.length), true));
        return new i<R>() { // from class: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 FlowBuilder.kt\nandroidx/room/coroutines/FlowUtil\n*L\n1#1,222:1\n54#2:223\n38#3:224\n*E\n"})
            /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements j {
                final /* synthetic */ Function1 $block$inlined;
                final /* synthetic */ RoomDatabase $db$inlined;
                final /* synthetic */ boolean $inTransaction$inlined;
                final /* synthetic */ j $this_unsafeFlow;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2", f = "FlowBuilder.kt", i = {}, l = {224, 223}, m = "emit", n = {}, s = {})
                /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.e eVar) {
                        super(eVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(j jVar, RoomDatabase roomDatabase, boolean z5, Function1 function1) {
                    this.$this_unsafeFlow = jVar;
                    this.$db$inlined = roomDatabase;
                    this.$inTransaction$inlined = z5;
                    this.$block$inlined = function1;
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
                
                    if (r8.emit(r9, r0) != r1) goto L23;
                 */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.j
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.e r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = (androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = new androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.g0.n(r9)
                        goto L63
                    L2c:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L34:
                        java.lang.Object r8 = r0.L$0
                        kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) r8
                        kotlin.g0.n(r9)
                        goto L57
                    L3c:
                        kotlin.g0.n(r9)
                        kotlinx.coroutines.flow.j r9 = r7.$this_unsafeFlow
                        java.util.Set r8 = (java.util.Set) r8
                        androidx.room.RoomDatabase r8 = r7.$db$inlined
                        boolean r2 = r7.$inTransaction$inlined
                        kotlin.jvm.functions.Function1 r5 = r7.$block$inlined
                        r0.L$0 = r9
                        r0.label = r4
                        java.lang.Object r8 = androidx.room.util.DBUtil.performSuspending(r8, r4, r2, r5, r0)
                        if (r8 != r1) goto L54
                        goto L62
                    L54:
                        r6 = r9
                        r9 = r8
                        r8 = r6
                    L57:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r8 = r8.emit(r9, r0)
                        if (r8 != r1) goto L63
                    L62:
                        return r1
                    L63:
                        kotlin.n1 r8 = kotlin.n1.f44123a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
                Object collect = i.this.collect(new AnonymousClass2(jVar, db, z5, block), eVar);
                return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
            }
        };
    }
}
