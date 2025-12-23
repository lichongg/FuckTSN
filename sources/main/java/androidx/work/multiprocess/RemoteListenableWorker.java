package androidx.work.multiprocess;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.parcelable.ParcelConverters;
import androidx.work.multiprocess.parcelable.ParcelableRemoteWorkRequest;
import androidx.work.multiprocess.parcelable.ParcelableResult;
import androidx.work.multiprocess.parcelable.ParcelableWorkerParameters;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class RemoteListenableWorker extends ListenableWorker {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME";
    public static final String ARGUMENT_PACKAGE_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME";
    static final String TAG = Logger.tagWithPrefix("RemoteListenableWorker");
    final ListenableWorkerImplClient mClient;

    @Nullable
    private ComponentName mComponentName;
    final Executor mExecutor;
    final WorkManagerImpl mWorkManager;

    @Nullable
    String mWorkerClassName;
    final WorkerParameters mWorkerParameters;

    @NonNull
    public abstract ListenableFuture<ListenableWorker.Result> startRemoteWork();

    public RemoteListenableWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.mWorkerParameters = workerParameters;
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
        this.mWorkManager = workManagerImpl;
        SerialExecutor backgroundExecutor = workManagerImpl.getWorkTaskExecutor().getBackgroundExecutor();
        this.mExecutor = backgroundExecutor;
        this.mClient = new ListenableWorkerImplClient(getApplicationContext(), backgroundExecutor);
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ComponentName componentName = this.mComponentName;
        if (componentName != null) {
            this.mClient.execute(componentName, new RemoteDispatcher<IListenableWorkerImpl>() { // from class: androidx.work.multiprocess.RemoteListenableWorker.3
                @Override // androidx.work.multiprocess.RemoteDispatcher
                public void execute(@NonNull IListenableWorkerImpl iListenableWorkerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                    iListenableWorkerImpl.interrupt(ParcelConverters.marshall(new ParcelableWorkerParameters(RemoteListenableWorker.this.mWorkerParameters)), iWorkManagerImplCallback);
                }
            });
        }
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public ListenableFuture<Void> setProgressAsync(@NonNull Data data) {
        return RemoteWorkManager.getInstance(getApplicationContext()).setProgress(getId(), data);
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        SettableFuture create = SettableFuture.create();
        Data inputData = getInputData();
        final String uuid = this.mWorkerParameters.getId().toString();
        String string = inputData.getString(ARGUMENT_PACKAGE_NAME);
        String string2 = inputData.getString(ARGUMENT_CLASS_NAME);
        if (TextUtils.isEmpty(string)) {
            Logger.get().error(TAG, "Need to specify a package name for the Remote Service.", new Throwable[0]);
            create.setException(new IllegalArgumentException("Need to specify a package name for the Remote Service."));
            return create;
        }
        if (TextUtils.isEmpty(string2)) {
            Logger.get().error(TAG, "Need to specify a class name for the Remote Service.", new Throwable[0]);
            create.setException(new IllegalArgumentException("Need to specify a class name for the Remote Service."));
            return create;
        }
        ComponentName componentName = new ComponentName(string, string2);
        this.mComponentName = componentName;
        return RemoteClientUtils.map(this.mClient.execute(componentName, new RemoteDispatcher<IListenableWorkerImpl>() { // from class: androidx.work.multiprocess.RemoteListenableWorker.1
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IListenableWorkerImpl iListenableWorkerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                WorkSpec workSpec = RemoteListenableWorker.this.mWorkManager.getWorkDatabase().workSpecDao().getWorkSpec(uuid);
                RemoteListenableWorker.this.mWorkerClassName = workSpec.workerClassName;
                iListenableWorkerImpl.startWork(ParcelConverters.marshall(new ParcelableRemoteWorkRequest(workSpec.workerClassName, RemoteListenableWorker.this.mWorkerParameters)), iWorkManagerImplCallback);
            }
        }), new Function<byte[], ListenableWorker.Result>() { // from class: androidx.work.multiprocess.RemoteListenableWorker.2
            @Override // androidx.arch.core.util.Function
            public ListenableWorker.Result apply(byte[] bArr) {
                ParcelableResult parcelableResult = (ParcelableResult) ParcelConverters.unmarshall(bArr, ParcelableResult.CREATOR);
                Logger.get().debug(RemoteListenableWorker.TAG, "Cleaning up", new Throwable[0]);
                RemoteListenableWorker.this.mClient.unbindService();
                return parcelableResult.getResult();
            }
        }, this.mExecutor);
    }
}
