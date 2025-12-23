package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface Observable<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Observer<T> {
        void onError(@NonNull Throwable th);

        void onNewData(@Nullable T t5);
    }

    void addObserver(@NonNull Executor executor, @NonNull Observer<? super T> observer);

    @NonNull
    ListenableFuture<T> fetchData();

    void removeObserver(@NonNull Observer<? super T> observer);
}
