package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.multiprocess.IWorkManagerImpl;
import androidx.work.multiprocess.ListenableCallback;
import androidx.work.multiprocess.parcelable.ParcelConverters;
import androidx.work.multiprocess.parcelable.ParcelableUpdateRequest;
import androidx.work.multiprocess.parcelable.ParcelableWorkContinuationImpl;
import androidx.work.multiprocess.parcelable.ParcelableWorkInfos;
import androidx.work.multiprocess.parcelable.ParcelableWorkQuery;
import androidx.work.multiprocess.parcelable.ParcelableWorkRequests;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class RemoteWorkManagerImpl extends IWorkManagerImpl.Stub {
    static byte[] sEMPTY = new byte[0];
    private final WorkManagerImpl mWorkManager;

    @Override // androidx.work.multiprocess.IWorkManagerImpl
    public void cancelAllWork(@NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            new ListenableCallback<Operation.State.SUCCESS>(this.mWorkManager.getWorkTaskExecutor().getBackgroundExecutor(), iWorkManagerImplCallback, this.mWorkManager.cancelAllWork().getResult()) { // from class: androidx.work.multiprocess.RemoteWorkManagerImpl.6
                @Override // androidx.work.multiprocess.ListenableCallback
                @NonNull
                public byte[] toByteArray(@NonNull Operation.State.SUCCESS success) {
                    return RemoteWorkManagerImpl.sEMPTY;
                }
            }.dispatchCallbackSafely();
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    @Override // androidx.work.multiprocess.IWorkManagerImpl
    public void cancelAllWorkByTag(@NonNull String str, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            new ListenableCallback<Operation.State.SUCCESS>(this.mWorkManager.getWorkTaskExecutor().getBackgroundExecutor(), iWorkManagerImplCallback, this.mWorkManager.cancelAllWorkByTag(str).getResult()) { // from class: androidx.work.multiprocess.RemoteWorkManagerImpl.4
                @Override // androidx.work.multiprocess.ListenableCallback
                @NonNull
                public byte[] toByteArray(@NonNull Operation.State.SUCCESS success) {
                    return RemoteWorkManagerImpl.sEMPTY;
                }
            }.dispatchCallbackSafely();
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    @Override // androidx.work.multiprocess.IWorkManagerImpl
    public void cancelUniqueWork(@NonNull String str, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            new ListenableCallback<Operation.State.SUCCESS>(this.mWorkManager.getWorkTaskExecutor().getBackgroundExecutor(), iWorkManagerImplCallback, this.mWorkManager.cancelUniqueWork(str).getResult()) { // from class: androidx.work.multiprocess.RemoteWorkManagerImpl.5
                @Override // androidx.work.multiprocess.ListenableCallback
                @NonNull
                public byte[] toByteArray(@NonNull Operation.State.SUCCESS success) {
                    return RemoteWorkManagerImpl.sEMPTY;
                }
            }.dispatchCallbackSafely();
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    @Override // androidx.work.multiprocess.IWorkManagerImpl
    public void cancelWorkById(@NonNull String str, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            new ListenableCallback<Operation.State.SUCCESS>(this.mWorkManager.getWorkTaskExecutor().getBackgroundExecutor(), iWorkManagerImplCallback, this.mWorkManager.cancelWorkById(UUID.fromString(str)).getResult()) { // from class: androidx.work.multiprocess.RemoteWorkManagerImpl.3
                @Override // androidx.work.multiprocess.ListenableCallback
                @NonNull
                public byte[] toByteArray(@NonNull Operation.State.SUCCESS success) {
                    return RemoteWorkManagerImpl.sEMPTY;
                }
            }.dispatchCallbackSafely();
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    @Override // androidx.work.multiprocess.IWorkManagerImpl
    public void enqueueContinuation(@NonNull byte[] bArr, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            new ListenableCallback<Operation.State.SUCCESS>(this.mWorkManager.getWorkTaskExecutor().getBackgroundExecutor(), iWorkManagerImplCallback, ((ParcelableWorkContinuationImpl) ParcelConverters.unmarshall(bArr, ParcelableWorkContinuationImpl.CREATOR)).toWorkContinuationImpl(this.mWorkManager).enqueue().getResult()) { // from class: androidx.work.multiprocess.RemoteWorkManagerImpl.2
                @Override // androidx.work.multiprocess.ListenableCallback
                @NonNull
                public byte[] toByteArray(@NonNull Operation.State.SUCCESS success) {
                    return RemoteWorkManagerImpl.sEMPTY;
                }
            }.dispatchCallbackSafely();
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    @Override // androidx.work.multiprocess.IWorkManagerImpl
    @MainThread
    public void enqueueWorkRequests(@NonNull byte[] bArr, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            new ListenableCallback<Operation.State.SUCCESS>(this.mWorkManager.getWorkTaskExecutor().getBackgroundExecutor(), iWorkManagerImplCallback, this.mWorkManager.enqueue(((ParcelableWorkRequests) ParcelConverters.unmarshall(bArr, ParcelableWorkRequests.CREATOR)).getRequests()).getResult()) { // from class: androidx.work.multiprocess.RemoteWorkManagerImpl.1
                @Override // androidx.work.multiprocess.ListenableCallback
                @NonNull
                public byte[] toByteArray(@NonNull Operation.State.SUCCESS success) {
                    return RemoteWorkManagerImpl.sEMPTY;
                }
            }.dispatchCallbackSafely();
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    @Override // androidx.work.multiprocess.IWorkManagerImpl
    public void queryWorkInfo(@NonNull byte[] bArr, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            new ListenableCallback<List<WorkInfo>>(this.mWorkManager.getWorkTaskExecutor().getBackgroundExecutor(), iWorkManagerImplCallback, this.mWorkManager.getWorkInfos(((ParcelableWorkQuery) ParcelConverters.unmarshall(bArr, ParcelableWorkQuery.CREATOR)).getWorkQuery())) { // from class: androidx.work.multiprocess.RemoteWorkManagerImpl.7
                @Override // androidx.work.multiprocess.ListenableCallback
                @NonNull
                public byte[] toByteArray(@NonNull List<WorkInfo> list) {
                    return ParcelConverters.marshall(new ParcelableWorkInfos(list));
                }
            }.dispatchCallbackSafely();
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    @Override // androidx.work.multiprocess.IWorkManagerImpl
    public void setProgress(@NonNull byte[] bArr, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            ParcelableUpdateRequest parcelableUpdateRequest = (ParcelableUpdateRequest) ParcelConverters.unmarshall(bArr, ParcelableUpdateRequest.CREATOR);
            Context applicationContext = this.mWorkManager.getApplicationContext();
            TaskExecutor workTaskExecutor = this.mWorkManager.getWorkTaskExecutor();
            new ListenableCallback<Void>(workTaskExecutor.getBackgroundExecutor(), iWorkManagerImplCallback, new WorkProgressUpdater(this.mWorkManager.getWorkDatabase(), workTaskExecutor).updateProgress(applicationContext, UUID.fromString(parcelableUpdateRequest.getId()), parcelableUpdateRequest.getData())) { // from class: androidx.work.multiprocess.RemoteWorkManagerImpl.8
                @Override // androidx.work.multiprocess.ListenableCallback
                @NonNull
                public byte[] toByteArray(@NonNull Void r12) {
                    return RemoteWorkManagerImpl.sEMPTY;
                }
            }.dispatchCallbackSafely();
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    RemoteWorkManagerImpl(@NonNull Context context) {
        this.mWorkManager = WorkManagerImpl.getInstance(context);
    }
}
