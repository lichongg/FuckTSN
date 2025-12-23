package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PeriodicWorkRequest extends WorkRequest {

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> workerClass, long repeatInterval, @NonNull TimeUnit repeatIntervalTimeUnit) {
            super(workerClass);
            this.mWorkSpec.setPeriodic(repeatIntervalTimeUnit.toMillis(repeatInterval));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.work.WorkRequest.Builder
        @NonNull
        public Builder getThis() {
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.work.WorkRequest.Builder
        @NonNull
        public PeriodicWorkRequest buildInternal() {
            if (this.mBackoffCriteriaSet && Build.VERSION.SDK_INT >= 23 && this.mWorkSpec.constraints.requiresDeviceIdle()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (this.mWorkSpec.expedited) {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
            return new PeriodicWorkRequest(this);
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> workerClass, @NonNull Duration repeatInterval) {
            super(workerClass);
            long millis;
            WorkSpec workSpec = this.mWorkSpec;
            millis = repeatInterval.toMillis();
            workSpec.setPeriodic(millis);
        }

        public Builder(@NonNull Class<? extends ListenableWorker> workerClass, long repeatInterval, @NonNull TimeUnit repeatIntervalTimeUnit, long flexInterval, @NonNull TimeUnit flexIntervalTimeUnit) {
            super(workerClass);
            this.mWorkSpec.setPeriodic(repeatIntervalTimeUnit.toMillis(repeatInterval), flexIntervalTimeUnit.toMillis(flexInterval));
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> workerClass, @NonNull Duration repeatInterval, @NonNull Duration flexInterval) {
            super(workerClass);
            long millis;
            long millis2;
            WorkSpec workSpec = this.mWorkSpec;
            millis = repeatInterval.toMillis();
            millis2 = flexInterval.toMillis();
            workSpec.setPeriodic(millis, millis2);
        }
    }

    PeriodicWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }
}
