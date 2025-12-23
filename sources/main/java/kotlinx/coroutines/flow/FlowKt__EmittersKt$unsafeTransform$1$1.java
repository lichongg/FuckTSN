package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n*L\n1#1,222:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowKt__EmittersKt$unsafeTransform$1$1<T> implements j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function3<j<? super R>, T, kotlin.coroutines.e<? super n1>, Object> f48615a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ j<R> f48616b;

    @Nullable
    public final Object a(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        kotlin.jvm.internal.d0.e(4);
        new FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(this, eVar);
        kotlin.jvm.internal.d0.e(5);
        this.f48615a.invoke(this.f48616b, t5, eVar);
        return n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$unsafeTransform$1$1(Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, j<? super R> jVar) {
        this.f48615a = function3;
        this.f48616b = jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.j
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.g0.n(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.g0.n(r6)
            kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.j<? super R>, T, kotlin.coroutines.e<? super kotlin.n1>, java.lang.Object> r6 = r4.f48615a
            kotlinx.coroutines.flow.j<R> r2 = r4.f48616b
            r0.label = r3
            java.lang.Object r5 = r6.invoke(r2, r5, r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            kotlin.n1 r5 = kotlin.n1.f44123a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
    }
}
