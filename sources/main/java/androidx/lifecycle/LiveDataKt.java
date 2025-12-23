package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LiveDataKt {
    @Deprecated(message = "This extension method is not required when using Kotlin 1.4. You should remove \"import androidx.lifecycle.observe\"")
    @MainThread
    @NotNull
    public static final <T> Observer<T> observe(@NotNull LiveData<T> liveData, @NotNull LifecycleOwner owner, @NotNull final Function1<? super T, n1> onChanged) {
        g0.p(liveData, "<this>");
        g0.p(owner, "owner");
        g0.p(onChanged, "onChanged");
        Observer<T> observer = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t5) {
                onChanged.invoke(t5);
            }
        };
        liveData.observe(owner, observer);
        return observer;
    }
}
