package androidx.work.multiprocess;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class RemoteClientUtils {
    public static final Function<byte[], Void> sVoidMapper = new Function<byte[], Void>() { // from class: androidx.work.multiprocess.RemoteClientUtils.1
        @Override // androidx.arch.core.util.Function
        public Void apply(byte[] bArr) {
            return null;
        }
    };

    private RemoteClientUtils() {
    }

    @NonNull
    public static <I, O> ListenableFuture<O> map(@NonNull final ListenableFuture<I> listenableFuture, @NonNull final Function<I, O> function, @NonNull Executor executor) {
        final SettableFuture create = SettableFuture.create();
        listenableFuture.addListener(new Runnable() { // from class: androidx.work.multiprocess.RemoteClientUtils.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    create.set(function.apply(ListenableFuture.this.get()));
                } catch (Throwable th) {
                    th = th;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    create.setException(th);
                }
            }
        }, executor);
        return create;
    }
}
