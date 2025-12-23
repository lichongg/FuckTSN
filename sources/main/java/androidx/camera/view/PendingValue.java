package androidx.camera.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
class PendingValue<T> {

    @Nullable
    private Pair<CallbackToFutureAdapter.Completer<Void>, T> mCompleterAndValue;

    public static /* synthetic */ Object a(PendingValue pendingValue, Object obj, CallbackToFutureAdapter.Completer completer) {
        Pair<CallbackToFutureAdapter.Completer<Void>, T> pair = pendingValue.mCompleterAndValue;
        if (pair != null) {
            CallbackToFutureAdapter.Completer<Void> completer2 = pair.first;
            Objects.requireNonNull(completer2);
            completer2.setCancelled();
        }
        pendingValue.mCompleterAndValue = new Pair<>(completer, obj);
        return "PendingValue " + obj;
    }

    PendingValue() {
    }

    @MainThread
    void propagateIfHasValue(Function<T, ListenableFuture<Void>> function) {
        Threads.checkMainThread();
        Pair<CallbackToFutureAdapter.Completer<Void>, T> pair = this.mCompleterAndValue;
        if (pair != null) {
            ListenableFuture<Void> apply = function.apply(pair.second);
            CallbackToFutureAdapter.Completer<Void> completer = this.mCompleterAndValue.first;
            Objects.requireNonNull(completer);
            Futures.propagate(apply, completer);
            this.mCompleterAndValue = null;
        }
    }

    @MainThread
    ListenableFuture<Void> setValue(@NonNull final T t5) {
        Threads.checkMainThread();
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.k
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return PendingValue.a(PendingValue.this, t5, completer);
            }
        });
    }
}
