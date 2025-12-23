package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.IWorkManagerImplCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class RemoteCallback extends IWorkManagerImplCallback.Stub {
    private IBinder mBinder = null;
    private final SettableFuture<byte[]> mFuture = SettableFuture.create();
    private final IBinder.DeathRecipient mRecipient = new DeathRecipient(this);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DeathRecipient implements IBinder.DeathRecipient {
        private final RemoteCallback mCallback;

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mCallback.onFailure("Binder died");
        }

        public DeathRecipient(@NonNull RemoteCallback remoteCallback) {
            this.mCallback = remoteCallback;
        }
    }

    @Override // androidx.work.multiprocess.IWorkManagerImplCallback
    public void onFailure(@NonNull String str) {
        onFailure(new RuntimeException(str));
    }

    private void onFailure(@NonNull Throwable th) {
        this.mFuture.setException(th);
        unlinkToDeath();
        onRequestCompleted();
    }

    private void unlinkToDeath() {
        IBinder iBinder = this.mBinder;
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this.mRecipient, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @NonNull
    public ListenableFuture<byte[]> getFuture() {
        return this.mFuture;
    }

    @Override // androidx.work.multiprocess.IWorkManagerImplCallback
    public void onSuccess(@NonNull byte[] bArr) throws RemoteException {
        this.mFuture.set(bArr);
        unlinkToDeath();
        onRequestCompleted();
    }

    public void setBinder(@NonNull IBinder iBinder) {
        this.mBinder = iBinder;
        try {
            iBinder.linkToDeath(this.mRecipient, 0);
        } catch (RemoteException e6) {
            onFailure(e6);
        }
    }

    protected void onRequestCompleted() {
    }
}
