package androidx.databinding;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
class WeakListener<T> extends WeakReference<ViewDataBinding> {
    protected final int mLocalFieldId;
    private final ObservableReference<T> mObservable;
    private T mTarget;

    public T getTarget() {
        return this.mTarget;
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.mObservable.setLifecycleOwner(lifecycleOwner);
    }

    public boolean unregister() {
        boolean z5;
        T t5 = this.mTarget;
        if (t5 != null) {
            this.mObservable.removeListener(t5);
            z5 = true;
        } else {
            z5 = false;
        }
        this.mTarget = null;
        return z5;
    }

    public WeakListener(ViewDataBinding viewDataBinding, int i6, ObservableReference<T> observableReference, ReferenceQueue<ViewDataBinding> referenceQueue) {
        super(viewDataBinding, referenceQueue);
        this.mLocalFieldId = i6;
        this.mObservable = observableReference;
    }

    @Nullable
    protected ViewDataBinding getBinder() {
        ViewDataBinding viewDataBinding = (ViewDataBinding) get();
        if (viewDataBinding == null) {
            unregister();
        }
        return viewDataBinding;
    }

    public void setTarget(T t5) {
        unregister();
        this.mTarget = t5;
        if (t5 != null) {
            this.mObservable.addListener(t5);
        }
    }
}
