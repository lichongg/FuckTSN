package androidx.core.view;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {TTAdConstant.IMAGE_LIST_CODE, 411}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super View>, kotlin.coroutines.e<? super kotlin.n1>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewKt$allViews$1(View view, kotlin.coroutines.e<? super ViewKt$allViews$1> eVar) {
        super(2, eVar);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<kotlin.n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, eVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull kotlin.sequences.o<? super View> oVar, @Nullable kotlin.coroutines.e<? super kotlin.n1> eVar) {
        return ((ViewKt$allViews$1) create(oVar, eVar)).invokeSuspend(kotlin.n1.f44123a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
    
        if (r1.g(r5, r4) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r1.c(r5, r4) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.g0.n(r5)
            goto L4f
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            java.lang.Object r1 = r4.L$0
            kotlin.sequences.o r1 = (kotlin.sequences.o) r1
            kotlin.g0.n(r5)
            goto L37
        L22:
            kotlin.g0.n(r5)
            java.lang.Object r5 = r4.L$0
            r1 = r5
            kotlin.sequences.o r1 = (kotlin.sequences.o) r1
            android.view.View r5 = r4.$this_allViews
            r4.L$0 = r1
            r4.label = r3
            java.lang.Object r5 = r1.c(r5, r4)
            if (r5 != r0) goto L37
            goto L4e
        L37:
            android.view.View r5 = r4.$this_allViews
            boolean r3 = r5 instanceof android.view.ViewGroup
            if (r3 == 0) goto L4f
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            kotlin.sequences.m r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r3 = 0
            r4.L$0 = r3
            r4.label = r2
            java.lang.Object r5 = r1.g(r5, r4)
            if (r5 != r0) goto L4f
        L4e:
            return r0
        L4f:
            kotlin.n1 r5 = kotlin.n1.f44123a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewKt$allViews$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
