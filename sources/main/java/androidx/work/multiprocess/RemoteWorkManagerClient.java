package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.core.os.HandlerCompat;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.IWorkManagerImpl;
import androidx.work.multiprocess.ListenableCallback;
import androidx.work.multiprocess.parcelable.ParcelConverters;
import androidx.work.multiprocess.parcelable.ParcelableUpdateRequest;
import androidx.work.multiprocess.parcelable.ParcelableWorkContinuationImpl;
import androidx.work.multiprocess.parcelable.ParcelableWorkInfos;
import androidx.work.multiprocess.parcelable.ParcelableWorkQuery;
import androidx.work.multiprocess.parcelable.ParcelableWorkRequests;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanKeepAnnotation"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class RemoteWorkManagerClient extends RemoteWorkManager {
    private static final long SESSION_TIMEOUT_MILLIS = 60000;
    static final String TAG = Logger.tagWithPrefix("RemoteWorkManagerClient");
    final Context mContext;
    final Executor mExecutor;
    private final Handler mHandler;
    final Object mLock;
    Session mSession;
    private volatile long mSessionIndex;
    private final long mSessionTimeout;
    private final SessionTracker mSessionTracker;
    final WorkManagerImpl mWorkManager;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class Session implements ServiceConnection {
        private static final String TAG = Logger.tagWithPrefix("RemoteWMgr.Connection");
        final RemoteWorkManagerClient mClient;
        final SettableFuture<IWorkManagerImpl> mFuture = SettableFuture.create();

        @Override // android.content.ServiceConnection
        public void onBindingDied(@NonNull ComponentName componentName) {
            onBindingDied();
        }

        public void onBindingDied() {
            Logger.get().debug(TAG, "Binding died", new Throwable[0]);
            this.mFuture.setException(new RuntimeException("Binding died"));
            this.mClient.cleanUp();
        }

        public Session(@NonNull RemoteWorkManagerClient remoteWorkManagerClient) {
            this.mClient = remoteWorkManagerClient;
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(@NonNull ComponentName componentName) {
            Logger.get().error(TAG, "Unable to bind to service", new Throwable[0]);
            this.mFuture.setException(new RuntimeException(String.format("Cannot bind to service %s", componentName)));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
            Logger.get().debug(TAG, "Service connected", new Throwable[0]);
            this.mFuture.set(IWorkManagerImpl.Stub.asInterface(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@NonNull ComponentName componentName) {
            Logger.get().debug(TAG, "Service disconnected", new Throwable[0]);
            this.mFuture.setException(new RuntimeException("Service disconnected"));
            this.mClient.cleanUp();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SessionTracker implements Runnable {
        private static final String TAG = Logger.tagWithPrefix("SessionHandler");
        private final RemoteWorkManagerClient mClient;

        @Override // java.lang.Runnable
        public void run() {
            long sessionIndex = this.mClient.getSessionIndex();
            synchronized (this.mClient.getSessionLock()) {
                try {
                    long sessionIndex2 = this.mClient.getSessionIndex();
                    Session currentSession = this.mClient.getCurrentSession();
                    if (currentSession != null) {
                        if (sessionIndex == sessionIndex2) {
                            Logger.get().debug(TAG, "Unbinding service", new Throwable[0]);
                            this.mClient.getContext().unbindService(currentSession);
                            currentSession.onBindingDied();
                        } else {
                            Logger.get().debug(TAG, "Ignoring request to unbind.", new Throwable[0]);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public SessionTracker(@NonNull RemoteWorkManagerClient remoteWorkManagerClient) {
            this.mClient = remoteWorkManagerClient;
        }
    }

    public RemoteWorkManagerClient(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, 60000L);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueue(@NonNull WorkRequest workRequest) {
        return enqueue(Collections.singletonList(workRequest));
    }

    @NonNull
    public ListenableFuture<byte[]> execute(@NonNull RemoteDispatcher<IWorkManagerImpl> remoteDispatcher) {
        return execute(getSession(), remoteDispatcher, new SessionRemoteCallback(this));
    }

    @NonNull
    public ListenableFuture<IWorkManagerImpl> getSession() {
        return getSession(newIntent(this.mContext));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SessionRemoteCallback extends RemoteCallback {
        private final RemoteWorkManagerClient mClient;

        public SessionRemoteCallback(@NonNull RemoteWorkManagerClient remoteWorkManagerClient) {
            this.mClient = remoteWorkManagerClient;
        }

        @Override // androidx.work.multiprocess.RemoteCallback
        protected void onRequestCompleted() {
            super.onRequestCompleted();
            this.mClient.getSessionHandler().postDelayed(this.mClient.getSessionTracker(), this.mClient.getSessionTimeout());
        }
    }

    public RemoteWorkManagerClient(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, long j6) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
        this.mExecutor = workManagerImpl.getWorkTaskExecutor().getBackgroundExecutor();
        this.mLock = new Object();
        this.mSession = null;
        this.mSessionTracker = new SessionTracker(this);
        this.mSessionTimeout = j6;
        this.mHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    private static Intent newIntent(@NonNull Context context) {
        return new Intent(context, (Class<?>) RemoteWorkManagerService.class);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public RemoteWorkContinuation beginUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list) {
        return new RemoteWorkContinuationImpl(this, this.mWorkManager.beginUniqueWork(str, existingWorkPolicy, list));
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public RemoteWorkContinuation beginWith(@NonNull List<OneTimeWorkRequest> list) {
        return new RemoteWorkContinuationImpl(this, this.mWorkManager.beginWith(list));
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> cancelAllWork() {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.6
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws Throwable {
                iWorkManagerImpl.cancelAllWork(iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> cancelAllWorkByTag(@NonNull final String str) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.4
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws Throwable {
                iWorkManagerImpl.cancelAllWorkByTag(str, iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> cancelUniqueWork(@NonNull final String str) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.5
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws Throwable {
                iWorkManagerImpl.cancelUniqueWork(str, iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> cancelWorkById(@NonNull final UUID uuid) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.3
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws Throwable {
                iWorkManagerImpl.cancelWorkById(uuid.toString(), iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    public void cleanUp() {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Cleaning up.", new Throwable[0]);
            this.mSession = null;
        }
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueue(@NonNull final List<WorkRequest> list) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.1
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                iWorkManagerImpl.enqueueWorkRequests(ParcelConverters.marshall(new ParcelableWorkRequests((List<WorkRequest>) list)), iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueueUniquePeriodicWork(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull PeriodicWorkRequest periodicWorkRequest) {
        return enqueue(this.mWorkManager.createWorkContinuationForUniquePeriodicWork(str, existingPeriodicWorkPolicy, periodicWorkRequest));
    }

    @NonNull
    @VisibleForTesting
    ListenableFuture<byte[]> execute(@NonNull final ListenableFuture<IWorkManagerImpl> listenableFuture, @NonNull final RemoteDispatcher<IWorkManagerImpl> remoteDispatcher, @NonNull final RemoteCallback remoteCallback) {
        listenableFuture.addListener(new Runnable() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final IWorkManagerImpl iWorkManagerImpl = (IWorkManagerImpl) listenableFuture.get();
                    remoteCallback.setBinder(iWorkManagerImpl.asBinder());
                    RemoteWorkManagerClient.this.mExecutor.execute(new Runnable() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                remoteDispatcher.execute(iWorkManagerImpl, remoteCallback);
                            } catch (Throwable th) {
                                Logger.get().error(RemoteWorkManagerClient.TAG, "Unable to execute", th);
                                ListenableCallback.ListenableCallbackRunnable.reportFailure(remoteCallback, th);
                            }
                        }
                    });
                } catch (InterruptedException | ExecutionException unused) {
                    Logger.get().error(RemoteWorkManagerClient.TAG, "Unable to bind to service", new Throwable[0]);
                    ListenableCallback.ListenableCallbackRunnable.reportFailure(remoteCallback, new RuntimeException("Unable to bind to service"));
                    RemoteWorkManagerClient.this.cleanUp();
                }
            }
        }, this.mExecutor);
        return remoteCallback.getFuture();
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public Session getCurrentSession() {
        return this.mSession;
    }

    @NonNull
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @NonNull
    @VisibleForTesting
    ListenableFuture<IWorkManagerImpl> getSession(@NonNull Intent intent) {
        SettableFuture<IWorkManagerImpl> settableFuture;
        synchronized (this.mLock) {
            try {
                this.mSessionIndex++;
                if (this.mSession == null) {
                    Logger.get().debug(TAG, "Creating a new session", new Throwable[0]);
                    Session session = new Session(this);
                    this.mSession = session;
                    try {
                        if (!this.mContext.bindService(intent, session, 1)) {
                            unableToBind(this.mSession, new RuntimeException("Unable to bind to service"));
                        }
                    } catch (Throwable th) {
                        unableToBind(this.mSession, th);
                    }
                }
                this.mHandler.removeCallbacks(this.mSessionTracker);
                settableFuture = this.mSession.mFuture;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return settableFuture;
    }

    @NonNull
    public Handler getSessionHandler() {
        return this.mHandler;
    }

    public long getSessionIndex() {
        return this.mSessionIndex;
    }

    @NonNull
    public Object getSessionLock() {
        return this.mLock;
    }

    public long getSessionTimeout() {
        return this.mSessionTimeout;
    }

    @NonNull
    public SessionTracker getSessionTracker() {
        return this.mSessionTracker;
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfos(@NonNull final WorkQuery workQuery) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.7
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws Throwable {
                iWorkManagerImpl.queryWorkInfo(ParcelConverters.marshall(new ParcelableWorkQuery(workQuery)), iWorkManagerImplCallback);
            }
        }), new Function<byte[], List<WorkInfo>>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.8
            @Override // androidx.arch.core.util.Function
            public List<WorkInfo> apply(byte[] bArr) {
                return ((ParcelableWorkInfos) ParcelConverters.unmarshall(bArr, ParcelableWorkInfos.CREATOR)).getWorkInfos();
            }
        }, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> setProgress(@NonNull final UUID uuid, @NonNull final Data data) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.9
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws Throwable {
                iWorkManagerImpl.setProgress(ParcelConverters.marshall(new ParcelableUpdateRequest(uuid, data)), iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    private void unableToBind(@NonNull Session session, @NonNull Throwable th) {
        Logger.get().error(TAG, "Unable to bind to service", th);
        session.mFuture.setException(th);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueueUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list) {
        return beginUniqueWork(str, existingWorkPolicy, list).enqueue();
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueue(@NonNull final WorkContinuation workContinuation) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.2
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws Throwable {
                iWorkManagerImpl.enqueueContinuation(ParcelConverters.marshall(new ParcelableWorkContinuationImpl((WorkContinuationImpl) workContinuation)), iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }
}
