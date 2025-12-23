package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class Schedulers {
    public static final String GCM_SCHEDULER = "androidx.work.impl.background.gcm.GcmScheduler";
    private static final String TAG = Logger.tagWithPrefix("Schedulers");

    @NonNull
    static Scheduler createBestAvailableBackgroundScheduler(@NonNull Context context, @NonNull WorkManagerImpl workManager) {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workManager);
            PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
            Logger.get().debug(TAG, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return systemJobScheduler;
        }
        Scheduler tryCreateGcmBasedScheduler = tryCreateGcmBasedScheduler(context);
        if (tryCreateGcmBasedScheduler != null) {
            return tryCreateGcmBasedScheduler;
        }
        SystemAlarmScheduler systemAlarmScheduler = new SystemAlarmScheduler(context);
        PackageManagerHelper.setComponentEnabled(context, SystemAlarmService.class, true);
        Logger.get().debug(TAG, "Created SystemAlarmScheduler", new Throwable[0]);
        return systemAlarmScheduler;
    }

    public static void schedule(@NonNull Configuration configuration, @NonNull WorkDatabase workDatabase, List<Scheduler> schedulers) {
        if (schedulers == null || schedulers.size() == 0) {
            return;
        }
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> eligibleWorkForScheduling = workSpecDao.getEligibleWorkForScheduling(configuration.getMaxSchedulerLimit());
            List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
            if (eligibleWorkForScheduling != null && eligibleWorkForScheduling.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<WorkSpec> it = eligibleWorkForScheduling.iterator();
                while (it.hasNext()) {
                    workSpecDao.markWorkSpecScheduled(it.next().id, currentTimeMillis);
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (eligibleWorkForScheduling != null && eligibleWorkForScheduling.size() > 0) {
                WorkSpec[] workSpecArr = (WorkSpec[]) eligibleWorkForScheduling.toArray(new WorkSpec[eligibleWorkForScheduling.size()]);
                for (Scheduler scheduler : schedulers) {
                    if (scheduler.hasLimitedSchedulingSlots()) {
                        scheduler.schedule(workSpecArr);
                    }
                }
            }
            if (allEligibleWorkSpecsForScheduling == null || allEligibleWorkSpecsForScheduling.size() <= 0) {
                return;
            }
            WorkSpec[] workSpecArr2 = (WorkSpec[]) allEligibleWorkSpecsForScheduling.toArray(new WorkSpec[allEligibleWorkSpecsForScheduling.size()]);
            for (Scheduler scheduler2 : schedulers) {
                if (!scheduler2.hasLimitedSchedulingSlots()) {
                    scheduler2.schedule(workSpecArr2);
                }
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }

    @Nullable
    private static Scheduler tryCreateGcmBasedScheduler(@NonNull Context context) {
        try {
            Scheduler scheduler = (Scheduler) Class.forName(GCM_SCHEDULER).getConstructor(Context.class).newInstance(context);
            Logger.get().debug(TAG, String.format("Created %s", GCM_SCHEDULER), new Throwable[0]);
            return scheduler;
        } catch (Throwable th) {
            Logger.get().debug(TAG, "Unable to create GCM Scheduler", th);
            return null;
        }
    }

    private Schedulers() {
    }
}
