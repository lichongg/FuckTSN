package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.Preference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class IdGenerator {
    public static final int INITIAL_ID = 0;
    public static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    public static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    public static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";
    private final WorkDatabase mWorkDatabase;

    public static void migrateLegacyIdGenerator(@NonNull Context context, @NonNull SupportSQLiteDatabase sqLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        if (sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY) || sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY)) {
            int i6 = sharedPreferences.getInt(NEXT_JOB_SCHEDULER_ID_KEY, 0);
            int i7 = sharedPreferences.getInt(NEXT_ALARM_MANAGER_ID_KEY, 0);
            sqLiteDatabase.beginTransaction();
            try {
                sqLiteDatabase.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{NEXT_JOB_SCHEDULER_ID_KEY, Integer.valueOf(i6)});
                sqLiteDatabase.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{NEXT_ALARM_MANAGER_ID_KEY, Integer.valueOf(i7)});
                sharedPreferences.edit().clear().apply();
                sqLiteDatabase.setTransactionSuccessful();
            } finally {
                sqLiteDatabase.endTransaction();
            }
        }
    }

    private int nextId(String key) {
        this.mWorkDatabase.beginTransaction();
        try {
            Long longValue = this.mWorkDatabase.preferenceDao().getLongValue(key);
            int i6 = 0;
            int intValue = longValue != null ? longValue.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i6 = intValue + 1;
            }
            update(key, i6);
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            return intValue;
        } catch (Throwable th) {
            this.mWorkDatabase.endTransaction();
            throw th;
        }
    }

    private void update(String key, int value) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference(key, value));
    }

    public int nextAlarmManagerId() {
        int nextId;
        synchronized (IdGenerator.class) {
            nextId = nextId(NEXT_ALARM_MANAGER_ID_KEY);
        }
        return nextId;
    }

    public int nextJobSchedulerIdWithRange(int minInclusive, int maxInclusive) {
        synchronized (IdGenerator.class) {
            int nextId = nextId(NEXT_JOB_SCHEDULER_ID_KEY);
            if (nextId >= minInclusive && nextId <= maxInclusive) {
                minInclusive = nextId;
            }
            update(NEXT_JOB_SCHEDULER_ID_KEY, minInclusive + 1);
        }
        return minInclusive;
    }

    public IdGenerator(@NonNull WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }
}
