package androidx.databinding;

import androidx.databinding.ViewDataBindingKtx;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1", f = "ViewDataBindingKtx.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class ViewDataBindingKtx$StateFlowListener$startCollection$1 extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {
    final /* synthetic */ i<Object> $flow;
    final /* synthetic */ LifecycleOwner $owner;
    int label;
    final /* synthetic */ ViewDataBindingKtx.StateFlowListener this$0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1", f = "ViewDataBindingKtx.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {
        final /* synthetic */ i<Object> $flow;
        int label;
        final /* synthetic */ ViewDataBindingKtx.StateFlowListener this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(i<? extends Object> iVar, ViewDataBindingKtx.StateFlowListener stateFlowListener, e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$flow = iVar;
            this.this$0 = stateFlowListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(Object obj, e<?> eVar) {
            return new AnonymousClass1(this.$flow, this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, e<? super n1> eVar) {
            return ((AnonymousClass1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.label;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                i<Object> iVar = this.$flow;
                final ViewDataBindingKtx.StateFlowListener stateFlowListener = this.this$0;
                j<? super Object> jVar = new j() { // from class: androidx.databinding.ViewDataBindingKtx.StateFlowListener.startCollection.1.1.1
                    @Override // kotlinx.coroutines.flow.j
                    public final Object emit(Object obj2, e<? super n1> eVar) {
                        WeakListener weakListener;
                        WeakListener weakListener2;
                        WeakListener weakListener3;
                        weakListener = ViewDataBindingKtx.StateFlowListener.this.listener;
                        ViewDataBinding binder = weakListener.getBinder();
                        if (binder != null) {
                            weakListener2 = ViewDataBindingKtx.StateFlowListener.this.listener;
                            int i7 = weakListener2.mLocalFieldId;
                            weakListener3 = ViewDataBindingKtx.StateFlowListener.this.listener;
                            binder.handleFieldChange(i7, weakListener3.getTarget(), 0);
                        }
                        return n1.f44123a;
                    }
                };
                this.label = 1;
                if (iVar.collect(jVar, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewDataBindingKtx$StateFlowListener$startCollection$1(LifecycleOwner lifecycleOwner, i<? extends Object> iVar, ViewDataBindingKtx.StateFlowListener stateFlowListener, e<? super ViewDataBindingKtx$StateFlowListener$startCollection$1> eVar) {
        super(2, eVar);
        this.$owner = lifecycleOwner;
        this.$flow = iVar;
        this.this$0 = stateFlowListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final e<n1> create(Object obj, e<?> eVar) {
        return new ViewDataBindingKtx$StateFlowListener$startCollection$1(this.$owner, this.$flow, this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, e<? super n1> eVar) {
        return ((ViewDataBindingKtx$StateFlowListener$startCollection$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                g0.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            g0.n(obj);
            Lifecycle lifecycle = this.$owner.getLifecycle();
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flow, this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, anonymousClass1, this) == l6) {
                return l6;
            }
        }
        return n1.f44123a;
    }
}
