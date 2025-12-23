package androidx.work.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.core.os.BuildCompat;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.R;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class WorkManagerImpl extends WorkManager {
    public static final int MAX_PRE_JOB_SCHEDULER_API_LEVEL = 22;
    public static final int MIN_JOB_SCHEDULER_API_LEVEL = 23;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;
    private static final String TAG = Logger.tagWithPrefix("WorkManagerImpl");
    private static WorkManagerImpl sDelegatedInstance = null;
    private static WorkManagerImpl sDefaultInstance = null;
    private static final Object sLock = new Object();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor workTaskExecutor) {
        this(context, configuration, workTaskExecutor, context.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public static WorkManagerImpl getInstance() {
        synchronized (sLock) {
            try {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                if (workManagerImpl != null) {
                    return workManagerImpl;
                }
                return sDefaultInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void tryInitializeMultiProcessSupport() {
        try {
            this.mRemoteWorkManager = (RemoteWorkManager) Class.forName(REMOTE_WORK_MANAGER_CLIENT).getConstructor(Context.class, WorkManagerImpl.class).newInstance(this.mContext, this);
        } catch (Throwable th) {
            Logger.get().debug(TAG, "Unable to initialize multi-process support", th);
        }
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation cancelUniqueWork(@NonNull String uniqueWorkName) {
        CancelWorkRunnable forName = CancelWorkRunnable.forName(uniqueWorkName, this, true);
        this.mWorkTaskExecutor.executeOnBackgroundThread(forName);
        return forName.getOperation();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void startWork(@NonNull String workSpecId) {
        startWork(workSpecId, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        r4 = r4.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (androidx.work.impl.WorkManagerImpl.sDefaultInstance != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        androidx.work.impl.WorkManagerImpl.sDefaultInstance = new androidx.work.impl.WorkManagerImpl(r4, r5, new androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor(r5.getTaskExecutor()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        androidx.work.impl.WorkManagerImpl.sDelegatedInstance = androidx.work.impl.WorkManagerImpl.sDefaultInstance;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void initialize(@androidx.annotation.NonNull android.content.Context r4, @androidx.annotation.NonNull androidx.work.Configuration r5) {
        /*
            java.lang.Object r0 = androidx.work.impl.WorkManagerImpl.sLock
            monitor-enter(r0)
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.sDelegatedInstance     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L16
            androidx.work.impl.WorkManagerImpl r2 = androidx.work.impl.WorkManagerImpl.sDefaultInstance     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto Lc
            goto L16
        Lc:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            java.lang.String r5 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L14
            throw r4     // Catch: java.lang.Throwable -> L14
        L14:
            r4 = move-exception
            goto L36
        L16:
            if (r1 != 0) goto L34
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.sDefaultInstance     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L30
            androidx.work.impl.WorkManagerImpl r1 = new androidx.work.impl.WorkManagerImpl     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor r2 = new androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor     // Catch: java.lang.Throwable -> L14
            java.util.concurrent.Executor r3 = r5.getTaskExecutor()     // Catch: java.lang.Throwable -> L14
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L14
            r1.<init>(r4, r5, r2)     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.WorkManagerImpl.sDefaultInstance = r1     // Catch: java.lang.Throwable -> L14
        L30:
            androidx.work.impl.WorkManagerImpl r4 = androidx.work.impl.WorkManagerImpl.sDefaultInstance     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.WorkManagerImpl.sDelegatedInstance = r4     // Catch: java.lang.Throwable -> L14
        L34:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L36:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkManagerImpl.initialize(android.content.Context, androidx.work.Configuration):void");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDelegate(@Nullable WorkManagerImpl delegate) {
        synchronized (sLock) {
            sDelegatedInstance = delegate;
        }
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public PendingIntent createCancelPendingIntent(@NonNull UUID id) {
        return PendingIntent.getService(this.mContext, 0, SystemForegroundDispatcher.createCancelWorkIntent(this.mContext, id.toString()), BuildCompat.isAtLeastS() ? 167772160 : AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    @NonNull
    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(@NonNull String uniqueWorkName, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull PeriodicWorkRequest periodicWork) {
        return new WorkContinuationImpl(this, uniqueWorkName, existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE, Collections.singletonList(periodicWork));
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation enqueueUniqueWork(@NonNull String uniqueWorkName, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> work) {
        return new WorkContinuationImpl(this, uniqueWorkName, existingWorkPolicy, work).enqueue();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Context getApplicationContext() {
        return this.mContext;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Processor getProcessor() {
        return this.mProcessor;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteWorkManager getRemoteWorkManager() {
        if (this.mRemoteWorkManager == null) {
            synchronized (sLock) {
                try {
                    if (this.mRemoteWorkManager == null) {
                        tryInitializeMultiProcessSupport();
                        if (this.mRemoteWorkManager == null && !TextUtils.isEmpty(this.mConfiguration.getDefaultProcessName())) {
                            throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                        }
                    }
                } finally {
                }
            }
        }
        return this.mRemoteWorkManager;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<WorkInfo> getWorkInfoByIdLiveData(@NonNull UUID id) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(id.toString())), new Function<List<WorkSpec.WorkInfoPojo>, WorkInfo>() { // from class: androidx.work.impl.WorkManagerImpl.2
            @Override // androidx.arch.core.util.Function
            public WorkInfo apply(List<WorkSpec.WorkInfoPojo> input) {
                if (input == null || input.size() <= 0) {
                    return null;
                }
                return input.get(0).toWorkInfo();
            }
        }, this.mWorkTaskExecutor);
    }

    LiveData<List<WorkInfo>> getWorkInfosById(@NonNull List<String> workSpecIds) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(workSpecIds), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(@NonNull String tag) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForTag(tag), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(@NonNull String uniqueWorkName) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForName(uniqueWorkName), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosLiveData(@NonNull WorkQuery workQuery) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.rawWorkInfoDao().getWorkInfoPojosLiveData(RawQueries.workQueryToRawQuery(workQuery)), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onForceStopRunnableCompleted() {
        synchronized (sLock) {
            try {
                this.mForceStopRunnableCompleted = true;
                BroadcastReceiver.PendingResult pendingResult = this.mRescheduleReceiverResult;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation pruneWork() {
        PruneWorkRunnable pruneWorkRunnable = new PruneWorkRunnable(this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(pruneWorkRunnable);
        return pruneWorkRunnable.getOperation();
    }

    public void rescheduleEligibleWork() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.cancelAll(getApplicationContext());
        }
        getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(getConfiguration(), getWorkDatabase(), getSchedulers());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setReschedulePendingResult(@NonNull BroadcastReceiver.PendingResult rescheduleReceiverResult) {
        synchronized (sLock) {
            try {
                this.mRescheduleReceiverResult = rescheduleReceiverResult;
                if (this.mForceStopRunnableCompleted) {
                    rescheduleReceiverResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void startWork(@NonNull String workSpecId, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StartWorkRunnable(this, workSpecId, runtimeExtras));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stopForegroundWork(@NonNull String workSpecId) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(this, workSpecId, true));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stopWork(@NonNull String workSpecId) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(this, workSpecId, false));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor workTaskExecutor, boolean useTestDatabase) {
        this(context, configuration, workTaskExecutor, WorkDatabase.create(context.getApplicationContext(), workTaskExecutor.getBackgroundExecutor(), useTestDatabase));
    }

    private void internalInit(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor workTaskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> schedulers, @NonNull Processor processor) {
        boolean isDeviceProtectedStorage;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = schedulers;
        this.mProcessor = processor;
        this.mPreferenceUtils = new PreferenceUtils(workDatabase);
        this.mForceStopRunnableCompleted = false;
        if (Build.VERSION.SDK_INT >= 24) {
            isDeviceProtectedStorage = applicationContext.isDeviceProtectedStorage();
            if (isDeviceProtectedStorage) {
                throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
            }
        }
        this.mWorkTaskExecutor.executeOnBackgroundThread(new ForceStopRunnable(applicationContext, this));
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public WorkContinuation beginUniqueWork(@NonNull String uniqueWorkName, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> work) {
        if (!work.isEmpty()) {
            return new WorkContinuationImpl(this, uniqueWorkName, existingWorkPolicy, work);
        }
        throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public WorkContinuation beginWith(@NonNull List<OneTimeWorkRequest> work) {
        if (!work.isEmpty()) {
            return new WorkContinuationImpl(this, work);
        }
        throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation cancelAllWork() {
        CancelWorkRunnable forAll = CancelWorkRunnable.forAll(this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(forAll);
        return forAll.getOperation();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation cancelAllWorkByTag(@NonNull final String tag) {
        CancelWorkRunnable forTag = CancelWorkRunnable.forTag(tag, this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(forTag);
        return forTag.getOperation();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation cancelWorkById(@NonNull UUID id) {
        CancelWorkRunnable forId = CancelWorkRunnable.forId(id, this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(forId);
        return forId.getOperation();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> createSchedulers(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor) {
        return Arrays.asList(Schedulers.createBestAvailableBackgroundScheduler(context, this), new GreedyScheduler(context, configuration, taskExecutor, this));
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation enqueue(@NonNull List<? extends WorkRequest> requests) {
        if (!requests.isEmpty()) {
            return new WorkContinuationImpl(this, requests).enqueue();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation enqueueUniquePeriodicWork(@NonNull String uniqueWorkName, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull PeriodicWorkRequest periodicWork) {
        return createWorkContinuationForUniquePeriodicWork(uniqueWorkName, existingPeriodicWorkPolicy, periodicWork).enqueue();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public ListenableFuture<Long> getLastCancelAllTimeMillis() {
        final SettableFuture create = SettableFuture.create();
        final PreferenceUtils preferenceUtils = this.mPreferenceUtils;
        this.mWorkTaskExecutor.executeOnBackgroundThread(new Runnable() { // from class: androidx.work.impl.WorkManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    create.set(Long.valueOf(preferenceUtils.getLastCancelAllTimeMillis()));
                } catch (Throwable th) {
                    create.setException(th);
                }
            }
        });
        return create;
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public ListenableFuture<WorkInfo> getWorkInfoById(@NonNull UUID id) {
        StatusRunnable<WorkInfo> forUUID = StatusRunnable.forUUID(this, id);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(forUUID);
        return forUUID.getFuture();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfos(@NonNull WorkQuery workQuery) {
        StatusRunnable<List<WorkInfo>> forWorkQuerySpec = StatusRunnable.forWorkQuerySpec(this, workQuery);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(forWorkQuerySpec);
        return forWorkQuerySpec.getFuture();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfosByTag(@NonNull String tag) {
        StatusRunnable<List<WorkInfo>> forTag = StatusRunnable.forTag(this, tag);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(forTag);
        return forTag.getFuture();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(@NonNull String uniqueWorkName) {
        StatusRunnable<List<WorkInfo>> forUniqueWork = StatusRunnable.forUniqueWork(this, uniqueWorkName);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(forUniqueWork);
        return forUniqueWork.getFuture();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkManagerImpl getInstance(@NonNull Context context) {
        WorkManagerImpl workManagerImpl;
        synchronized (sLock) {
            try {
                workManagerImpl = getInstance();
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext instanceof Configuration.Provider) {
                        initialize(applicationContext, ((Configuration.Provider) applicationContext).getWorkManagerConfiguration());
                        workManagerImpl = getInstance(applicationContext);
                    } else {
                        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return workManagerImpl;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor workTaskExecutor, @NonNull WorkDatabase database) {
        Context applicationContext = context.getApplicationContext();
        Logger.setLogger(new Logger.LogcatLogger(configuration.getMinimumLoggingLevel()));
        List<Scheduler> createSchedulers = createSchedulers(applicationContext, configuration, workTaskExecutor);
        internalInit(context, configuration, workTaskExecutor, database, createSchedulers, new Processor(context, configuration, workTaskExecutor, database, createSchedulers));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor workTaskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> schedulers, @NonNull Processor processor) {
        internalInit(context, configuration, workTaskExecutor, workDatabase, schedulers, processor);
    }
}
