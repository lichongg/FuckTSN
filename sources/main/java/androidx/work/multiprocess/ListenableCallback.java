package androidx.work.multiprocess;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ListenableCallback<I> {
    final IWorkManagerImplCallback mCallback;
    final Executor mExecutor;
    final ListenableFuture<I> mFuture;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class ListenableCallbackRunnable<I> implements Runnable {
        private static final String TAG = Logger.tagWithPrefix("ListenableCallbackRbl");
        private final ListenableCallback<I> mCallback;

        @Override // java.lang.Runnable
        public void run() {
            try {
                I i6 = this.mCallback.mFuture.get();
                ListenableCallback<I> listenableCallback = this.mCallback;
                reportSuccess(listenableCallback.mCallback, listenableCallback.toByteArray(i6));
            } catch (Throwable th) {
                reportFailure(this.mCallback.mCallback, th);
            }
        }

        public ListenableCallbackRunnable(@NonNull ListenableCallback<I> listenableCallback) {
            this.mCallback = listenableCallback;
        }

        public static void reportFailure(@NonNull IWorkManagerImplCallback iWorkManagerImplCallback, @NonNull Throwable th) {
            try {
                iWorkManagerImplCallback.onFailure(th.getMessage());
            } catch (RemoteException e6) {
                Logger.get().error(TAG, "Unable to notify failures in operation", e6);
            }
        }

        public static void reportSuccess(@NonNull IWorkManagerImplCallback iWorkManagerImplCallback, @NonNull byte[] bArr) {
            try {
                iWorkManagerImplCallback.onSuccess(bArr);
            } catch (RemoteException e6) {
                Logger.get().error(TAG, "Unable to notify successful operation", e6);
            }
        }
    }

    @NonNull
    public abstract byte[] toByteArray(@NonNull I i6);

    public void dispatchCallbackSafely() {
        this.mFuture.addListener(new ListenableCallbackRunnable(this), this.mExecutor);
    }

    public ListenableCallback(@NonNull Executor executor, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback, @NonNull ListenableFuture<I> listenableFuture) {
        this.mExecutor = executor;
        this.mCallback = iWorkManagerImplCallback;
        this.mFuture = listenableFuture;
    }
}
