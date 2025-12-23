package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
interface ObservableReference<T> {
    void addListener(T t5);

    WeakListener<T> getListener();

    void removeListener(T t5);

    void setLifecycleOwner(LifecycleOwner lifecycleOwner);
}
