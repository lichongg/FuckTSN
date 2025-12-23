package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.multiprocess.IListenableWorkerImpl;
import androidx.work.multiprocess.ListenableCallback;
import androidx.work.multiprocess.parcelable.ParcelConverters;
import androidx.work.multiprocess.parcelable.ParcelableRemoteWorkRequest;
import androidx.work.multiprocess.parcelable.ParcelableWorkerParameters;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ListenableWorkerImpl extends IListenableWorkerImpl.Stub {
    static final String TAG = Logger.tagWithPrefix("ListenableWorkerImpl");
    static byte[] sEMPTY = new byte[0];
    static final Object sLock = new Object();
    final Configuration mConfiguration;
    final Context mContext;
    final Map<String, ListenableFuture<ListenableWorker.Result>> mFutureMap;
    final TaskExecutor mTaskExecutor;
    final WorkManagerImpl mWorkManager;

    @Override // androidx.work.multiprocess.IListenableWorkerImpl
    public void interrupt(@NonNull byte[] bArr, @NonNull final IWorkManagerImplCallback iWorkManagerImplCallback) {
        final ListenableFuture<ListenableWorker.Result> remove;
        try {
            String uuid = ((ParcelableWorkerParameters) ParcelConverters.unmarshall(bArr, ParcelableWorkerParameters.CREATOR)).getId().toString();
            Logger.get().debug(TAG, String.format("Interrupting work with id (%s)", uuid), new Throwable[0]);
            synchronized (sLock) {
                remove = this.mFutureMap.remove(uuid);
            }
            if (remove != null) {
                this.mWorkManager.getWorkTaskExecutor().getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.multiprocess.ListenableWorkerImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        remove.cancel(true);
                        ListenableCallback.ListenableCallbackRunnable.reportSuccess(iWorkManagerImplCallback, ListenableWorkerImpl.sEMPTY);
                    }
                });
            } else {
                ListenableCallback.ListenableCallbackRunnable.reportSuccess(iWorkManagerImplCallback, sEMPTY);
            }
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    @Override // androidx.work.multiprocess.IListenableWorkerImpl
    public void startWork(@NonNull byte[] bArr, @NonNull final IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            ParcelableRemoteWorkRequest parcelableRemoteWorkRequest = (ParcelableRemoteWorkRequest) ParcelConverters.unmarshall(bArr, ParcelableRemoteWorkRequest.CREATOR);
            WorkerParameters workerParameters = parcelableRemoteWorkRequest.getParcelableWorkerParameters().toWorkerParameters(this.mWorkManager);
            final String uuid = workerParameters.getId().toString();
            String workerClassName = parcelableRemoteWorkRequest.getWorkerClassName();
            Logger.get().debug(TAG, String.format("Executing work request (%s, %s)", uuid, workerClassName), new Throwable[0]);
            final ListenableFuture<ListenableWorker.Result> executeWorkRequest = executeWorkRequest(uuid, workerClassName, workerParameters);
            executeWorkRequest.addListener(new Runnable() { // from class: androidx.work.multiprocess.ListenableWorkerImpl.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:30:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        r7 = this;
                        com.google.common.util.concurrent.ListenableFuture r0 = r2     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
                        java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
                        androidx.work.ListenableWorker$Result r0 = (androidx.work.ListenableWorker.Result) r0     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
                        androidx.work.multiprocess.parcelable.ParcelableResult r1 = new androidx.work.multiprocess.parcelable.ParcelableResult     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
                        r1.<init>(r0)     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
                        byte[] r0 = androidx.work.multiprocess.parcelable.ParcelConverters.marshall(r1)     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
                        androidx.work.multiprocess.IWorkManagerImplCallback r1 = r3     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
                        androidx.work.multiprocess.ListenableCallback.ListenableCallbackRunnable.reportSuccess(r1, r0)     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
                        java.lang.Object r0 = androidx.work.multiprocess.ListenableWorkerImpl.sLock
                        monitor-enter(r0)
                        androidx.work.multiprocess.ListenableWorkerImpl r1 = androidx.work.multiprocess.ListenableWorkerImpl.this     // Catch: java.lang.Throwable -> L24
                        java.util.Map<java.lang.String, com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker$Result>> r1 = r1.mFutureMap     // Catch: java.lang.Throwable -> L24
                        java.lang.String r2 = r4     // Catch: java.lang.Throwable -> L24
                        r1.remove(r2)     // Catch: java.lang.Throwable -> L24
                        monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
                        return
                    L24:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
                        throw r1
                    L27:
                        r0 = move-exception
                        goto L74
                    L29:
                        r0 = move-exception
                        goto L2f
                    L2b:
                        r0 = move-exception
                        goto L5e
                    L2d:
                        r0 = move-exception
                        goto L5e
                    L2f:
                        androidx.work.Logger r1 = androidx.work.Logger.get()     // Catch: java.lang.Throwable -> L27
                        java.lang.String r2 = androidx.work.multiprocess.ListenableWorkerImpl.TAG     // Catch: java.lang.Throwable -> L27
                        java.lang.String r3 = "Worker (%s) was cancelled"
                        java.lang.String r4 = r4     // Catch: java.lang.Throwable -> L27
                        r5 = 1
                        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L27
                        r6 = 0
                        r5[r6] = r4     // Catch: java.lang.Throwable -> L27
                        java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch: java.lang.Throwable -> L27
                        java.lang.Throwable[] r4 = new java.lang.Throwable[r6]     // Catch: java.lang.Throwable -> L27
                        r1.debug(r2, r3, r4)     // Catch: java.lang.Throwable -> L27
                        androidx.work.multiprocess.IWorkManagerImplCallback r1 = r3     // Catch: java.lang.Throwable -> L27
                        androidx.work.multiprocess.ListenableCallback.ListenableCallbackRunnable.reportFailure(r1, r0)     // Catch: java.lang.Throwable -> L27
                        java.lang.Object r0 = androidx.work.multiprocess.ListenableWorkerImpl.sLock
                        monitor-enter(r0)
                        androidx.work.multiprocess.ListenableWorkerImpl r1 = androidx.work.multiprocess.ListenableWorkerImpl.this     // Catch: java.lang.Throwable -> L5b
                        java.util.Map<java.lang.String, com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker$Result>> r1 = r1.mFutureMap     // Catch: java.lang.Throwable -> L5b
                        java.lang.String r2 = r4     // Catch: java.lang.Throwable -> L5b
                        r1.remove(r2)     // Catch: java.lang.Throwable -> L5b
                        monitor-exit(r0)     // Catch: java.lang.Throwable -> L5b
                        goto L70
                    L5b:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch: java.lang.Throwable -> L5b
                        throw r1
                    L5e:
                        androidx.work.multiprocess.IWorkManagerImplCallback r1 = r3     // Catch: java.lang.Throwable -> L27
                        androidx.work.multiprocess.ListenableCallback.ListenableCallbackRunnable.reportFailure(r1, r0)     // Catch: java.lang.Throwable -> L27
                        java.lang.Object r0 = androidx.work.multiprocess.ListenableWorkerImpl.sLock
                        monitor-enter(r0)
                        androidx.work.multiprocess.ListenableWorkerImpl r1 = androidx.work.multiprocess.ListenableWorkerImpl.this     // Catch: java.lang.Throwable -> L71
                        java.util.Map<java.lang.String, com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker$Result>> r1 = r1.mFutureMap     // Catch: java.lang.Throwable -> L71
                        java.lang.String r2 = r4     // Catch: java.lang.Throwable -> L71
                        r1.remove(r2)     // Catch: java.lang.Throwable -> L71
                        monitor-exit(r0)     // Catch: java.lang.Throwable -> L71
                    L70:
                        return
                    L71:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch: java.lang.Throwable -> L71
                        throw r1
                    L74:
                        java.lang.Object r1 = androidx.work.multiprocess.ListenableWorkerImpl.sLock
                        monitor-enter(r1)
                        androidx.work.multiprocess.ListenableWorkerImpl r2 = androidx.work.multiprocess.ListenableWorkerImpl.this     // Catch: java.lang.Throwable -> L82
                        java.util.Map<java.lang.String, com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker$Result>> r2 = r2.mFutureMap     // Catch: java.lang.Throwable -> L82
                        java.lang.String r3 = r4     // Catch: java.lang.Throwable -> L82
                        r2.remove(r3)     // Catch: java.lang.Throwable -> L82
                        monitor-exit(r1)     // Catch: java.lang.Throwable -> L82
                        throw r0
                    L82:
                        r0 = move-exception
                        monitor-exit(r1)     // Catch: java.lang.Throwable -> L82
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.work.multiprocess.ListenableWorkerImpl.AnonymousClass1.run():void");
                }
            }, this.mTaskExecutor.getBackgroundExecutor());
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    ListenableWorkerImpl(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(applicationContext);
        this.mWorkManager = workManagerImpl;
        this.mConfiguration = workManagerImpl.getConfiguration();
        this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        this.mFutureMap = new HashMap();
    }

    @NonNull
    private ListenableFuture<ListenableWorker.Result> executeWorkRequest(@NonNull String str, @NonNull String str2, @NonNull WorkerParameters workerParameters) {
        SettableFuture create = SettableFuture.create();
        Logger logger = Logger.get();
        String str3 = TAG;
        logger.debug(str3, String.format("Tracking execution of %s (%s)", str, str2), new Throwable[0]);
        synchronized (sLock) {
            this.mFutureMap.put(str, create);
        }
        ListenableWorker createWorkerWithDefaultFallback = this.mConfiguration.getWorkerFactory().createWorkerWithDefaultFallback(this.mContext, str2, workerParameters);
        if (createWorkerWithDefaultFallback == null) {
            String format = String.format("Unable to create an instance of %s", str2);
            Logger.get().error(str3, format, new Throwable[0]);
            create.setException(new IllegalStateException(format));
            return create;
        }
        if (!(createWorkerWithDefaultFallback instanceof RemoteListenableWorker)) {
            String format2 = String.format("%s does not extend %s", str2, RemoteListenableWorker.class.getName());
            Logger.get().error(str3, format2, new Throwable[0]);
            create.setException(new IllegalStateException(format2));
            return create;
        }
        try {
            create.setFuture(((RemoteListenableWorker) createWorkerWithDefaultFallback).startRemoteWork());
            return create;
        } catch (Throwable th) {
            create.setException(th);
            return create;
        }
    }
}
