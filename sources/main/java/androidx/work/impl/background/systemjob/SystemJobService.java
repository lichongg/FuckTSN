package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class SystemJobService extends JobService implements ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix("SystemJobService");
    private final Map<String, JobParameters> mJobParameters = new HashMap();
    private WorkManagerImpl mWorkManagerImpl;

    @Nullable
    private static String getWorkSpecIdFromJobParameters(@NonNull JobParameters parameters) {
        try {
            PersistableBundle extras = parameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(@NonNull JobParameters params) {
        WorkerParameters.RuntimeExtras runtimeExtras;
        Uri[] triggeredContentUris;
        String[] triggeredContentAuthorities;
        Network network;
        String[] triggeredContentAuthorities2;
        Uri[] triggeredContentUris2;
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(params, true);
            return false;
        }
        String workSpecIdFromJobParameters = getWorkSpecIdFromJobParameters(params);
        if (TextUtils.isEmpty(workSpecIdFromJobParameters)) {
            Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.mJobParameters) {
            try {
                if (this.mJobParameters.containsKey(workSpecIdFromJobParameters)) {
                    Logger.get().debug(TAG, String.format("Job is already being executed by SystemJobService: %s", workSpecIdFromJobParameters), new Throwable[0]);
                    return false;
                }
                Logger.get().debug(TAG, String.format("onStartJob for %s", workSpecIdFromJobParameters), new Throwable[0]);
                this.mJobParameters.put(workSpecIdFromJobParameters, params);
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 24) {
                    runtimeExtras = new WorkerParameters.RuntimeExtras();
                    triggeredContentUris = params.getTriggeredContentUris();
                    if (triggeredContentUris != null) {
                        triggeredContentUris2 = params.getTriggeredContentUris();
                        runtimeExtras.triggeredContentUris = Arrays.asList(triggeredContentUris2);
                    }
                    triggeredContentAuthorities = params.getTriggeredContentAuthorities();
                    if (triggeredContentAuthorities != null) {
                        triggeredContentAuthorities2 = params.getTriggeredContentAuthorities();
                        runtimeExtras.triggeredContentAuthorities = Arrays.asList(triggeredContentAuthorities2);
                    }
                    if (i6 >= 28) {
                        network = params.getNetwork();
                        runtimeExtras.network = network;
                    }
                } else {
                    runtimeExtras = null;
                }
                this.mWorkManagerImpl.startWork(workSpecIdFromJobParameters, runtimeExtras);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@NonNull JobParameters params) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String workSpecIdFromJobParameters = getWorkSpecIdFromJobParameters(params);
        if (TextUtils.isEmpty(workSpecIdFromJobParameters)) {
            Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger.get().debug(TAG, String.format("onStopJob for %s", workSpecIdFromJobParameters), new Throwable[0]);
        synchronized (this.mJobParameters) {
            this.mJobParameters.remove(workSpecIdFromJobParameters);
        }
        this.mWorkManagerImpl.stopWork(workSpecIdFromJobParameters);
        return !this.mWorkManagerImpl.getProcessor().isCancelled(workSpecIdFromJobParameters);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
            this.mWorkManagerImpl = workManagerImpl;
            workManagerImpl.getProcessor().addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl != null) {
            workManagerImpl.getProcessor().removeExecutionListener(this);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String workSpecId, boolean needsReschedule) {
        JobParameters remove;
        Logger.get().debug(TAG, String.format("%s executed on JobScheduler", workSpecId), new Throwable[0]);
        synchronized (this.mJobParameters) {
            remove = this.mJobParameters.remove(workSpecId);
        }
        if (remove != null) {
            jobFinished(remove, needsReschedule);
        }
    }
}
