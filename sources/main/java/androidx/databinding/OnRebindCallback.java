package androidx.databinding;

import androidx.databinding.ViewDataBinding;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class OnRebindCallback<T extends ViewDataBinding> {
    public boolean onPreBind(T t5) {
        return true;
    }

    public void onBound(T t5) {
    }

    public void onCanceled(T t5) {
    }
}
