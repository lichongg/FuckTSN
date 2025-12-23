package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@FunctionalInterface
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface AsyncFunction<I, O> {
    @NonNull
    ListenableFuture<O> apply(@Nullable I i6) throws Exception;
}
