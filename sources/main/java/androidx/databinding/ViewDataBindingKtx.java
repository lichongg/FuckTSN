package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewDataBindingKtx {

    @NotNull
    public static final ViewDataBindingKtx INSTANCE = new ViewDataBindingKtx();

    @NotNull
    private static final CreateWeakListener CREATE_STATE_FLOW_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.c
        @Override // androidx.databinding.CreateWeakListener
        public final WeakListener create(ViewDataBinding viewDataBinding, int i6, ReferenceQueue referenceQueue) {
            WeakListener CREATE_STATE_FLOW_LISTENER$lambda$0;
            CREATE_STATE_FLOW_LISTENER$lambda$0 = ViewDataBindingKtx.CREATE_STATE_FLOW_LISTENER$lambda$0(viewDataBinding, i6, referenceQueue);
            return CREATE_STATE_FLOW_LISTENER$lambda$0;
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class StateFlowListener implements ObservableReference<i<? extends Object>> {

        @Nullable
        private WeakReference<LifecycleOwner> _lifecycleOwnerRef;

        @NotNull
        private final WeakListener<i<Object>> listener;

        @Nullable
        private e2 observerJob;

        public StateFlowListener(@Nullable ViewDataBinding viewDataBinding, int i6, @NotNull ReferenceQueue<ViewDataBinding> referenceQueue) {
            g0.p(referenceQueue, "referenceQueue");
            this.listener = new WeakListener<>(viewDataBinding, i6, this, referenceQueue);
        }

        private final void startCollection(LifecycleOwner lifecycleOwner, i<? extends Object> iVar) {
            e2 f6;
            e2 e2Var = this.observerJob;
            if (e2Var != null) {
                e2.a.b(e2Var, null, 1, null);
            }
            f6 = k.f(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new ViewDataBindingKtx$StateFlowListener$startCollection$1(lifecycleOwner, iVar, this, null), 3, null);
            this.observerJob = f6;
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(@Nullable i<? extends Object> iVar) {
            LifecycleOwner lifecycleOwner;
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if (weakReference == null || (lifecycleOwner = weakReference.get()) == null || iVar == null) {
                return;
            }
            startCollection(lifecycleOwner, iVar);
        }

        @Override // androidx.databinding.ObservableReference
        @NotNull
        public WeakListener<i<? extends Object>> getListener() {
            return this.listener;
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(@Nullable i<? extends Object> iVar) {
            e2 e2Var = this.observerJob;
            if (e2Var != null) {
                e2.a.b(e2Var, null, 1, null);
            }
            this.observerJob = null;
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if ((weakReference != null ? weakReference.get() : null) == lifecycleOwner) {
                return;
            }
            e2 e2Var = this.observerJob;
            if (e2Var != null) {
                e2.a.b(e2Var, null, 1, null);
            }
            if (lifecycleOwner == null) {
                this._lifecycleOwnerRef = null;
                return;
            }
            this._lifecycleOwnerRef = new WeakReference<>(lifecycleOwner);
            i<? extends Object> iVar = (i) this.listener.getTarget();
            if (iVar != null) {
                startCollection(lifecycleOwner, iVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeakListener CREATE_STATE_FLOW_LISTENER$lambda$0(ViewDataBinding viewDataBinding, int i6, ReferenceQueue referenceQueue) {
        g0.m(referenceQueue);
        return new StateFlowListener(viewDataBinding, i6, referenceQueue).getListener();
    }

    private ViewDataBindingKtx() {
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean updateStateFlowRegistration(@NotNull ViewDataBinding viewDataBinding, int i6, @Nullable i<?> iVar) {
        g0.p(viewDataBinding, "viewDataBinding");
        viewDataBinding.mInStateFlowRegisterObserver = true;
        try {
            return viewDataBinding.updateRegistration(i6, iVar, CREATE_STATE_FLOW_LISTENER);
        } finally {
            viewDataBinding.mInStateFlowRegisterObserver = false;
        }
    }
}
