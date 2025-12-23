package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class MutableStateObservable<T> extends StateObservable<T> {
    @NonNull
    public static <T> MutableStateObservable<T> withInitialError(@NonNull Throwable th) {
        return new MutableStateObservable<>(th, true);
    }

    @NonNull
    public static <T> MutableStateObservable<T> withInitialState(@Nullable T t5) {
        return new MutableStateObservable<>(t5, false);
    }

    private MutableStateObservable(@Nullable Object obj, boolean z5) {
        super(obj, z5);
    }

    public void setError(@NonNull Throwable th) {
        updateStateAsError(th);
    }

    public void setState(@Nullable T t5) {
        updateState(t5);
    }
}
