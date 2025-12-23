package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class WorkRequest {
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;

    @NonNull
    private UUID mId;

    @NonNull
    private Set<String> mTags;

    @NonNull
    private WorkSpec mWorkSpec;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {
        WorkSpec mWorkSpec;
        Class<? extends ListenableWorker> mWorkerClass;
        boolean mBackoffCriteriaSet = false;
        Set<String> mTags = new HashSet();
        UUID mId = UUID.randomUUID();

        @NonNull
        abstract W buildInternal();

        @NonNull
        abstract B getThis();

        @NonNull
        public final B keepResultsForAtLeast(long duration, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.minimumRetentionDuration = timeUnit.toMillis(duration);
            return getThis();
        }

        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, long backoffDelay, @NonNull TimeUnit timeUnit) {
            this.mBackoffCriteriaSet = true;
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(timeUnit.toMillis(backoffDelay));
            return getThis();
        }

        @NonNull
        public B setInitialDelay(long duration, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.initialDelay = timeUnit.toMillis(duration);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.mWorkSpec.initialDelay) {
                return getThis();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @NonNull
        public final B addTag(@NonNull String tag) {
            this.mTags.add(tag);
            return getThis();
        }

        @NonNull
        public final B setConstraints(@NonNull Constraints constraints) {
            this.mWorkSpec.constraints = constraints;
            return getThis();
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public B setExpedited(@NonNull OutOfQuotaPolicy policy) {
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.expedited = true;
            workSpec.outOfQuotaPolicy = policy;
            return getThis();
        }

        @NonNull
        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setInitialRunAttemptCount(int runAttemptCount) {
            this.mWorkSpec.runAttemptCount = runAttemptCount;
            return getThis();
        }

        @NonNull
        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setInitialState(@NonNull WorkInfo.State state) {
            this.mWorkSpec.state = state;
            return getThis();
        }

        @NonNull
        public final B setInputData(@NonNull Data inputData) {
            this.mWorkSpec.input = inputData;
            return getThis();
        }

        @NonNull
        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setPeriodStartTime(long periodStartTime, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.periodStartTime = timeUnit.toMillis(periodStartTime);
            return getThis();
        }

        @NonNull
        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setScheduleRequestedAt(long scheduleRequestedAt, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.scheduleRequestedAt = timeUnit.toMillis(scheduleRequestedAt);
            return getThis();
        }

        Builder(@NonNull Class<? extends ListenableWorker> workerClass) {
            this.mWorkerClass = workerClass;
            this.mWorkSpec = new WorkSpec(this.mId.toString(), workerClass.getName());
            addTag(workerClass.getName());
        }

        @NonNull
        public final W build() {
            boolean z5;
            W buildInternal = buildInternal();
            Constraints constraints = this.mWorkSpec.constraints;
            int i6 = Build.VERSION.SDK_INT;
            if ((i6 < 24 || !constraints.hasContentUriTriggers()) && !constraints.requiresBatteryNotLow() && !constraints.requiresCharging() && (i6 < 23 || !constraints.requiresDeviceIdle())) {
                z5 = false;
            } else {
                z5 = true;
            }
            WorkSpec workSpec = this.mWorkSpec;
            if (workSpec.expedited) {
                if (!z5) {
                    if (workSpec.initialDelay > 0) {
                        throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                    }
                } else {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
            }
            this.mId = UUID.randomUUID();
            WorkSpec workSpec2 = new WorkSpec(this.mWorkSpec);
            this.mWorkSpec = workSpec2;
            workSpec2.id = this.mId.toString();
            return buildInternal;
        }

        @NonNull
        @RequiresApi(26)
        public final B keepResultsForAtLeast(@NonNull Duration duration) {
            long millis;
            WorkSpec workSpec = this.mWorkSpec;
            millis = duration.toMillis();
            workSpec.minimumRetentionDuration = millis;
            return getThis();
        }

        @NonNull
        @RequiresApi(26)
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, @NonNull Duration duration) {
            long millis;
            this.mBackoffCriteriaSet = true;
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.backoffPolicy = backoffPolicy;
            millis = duration.toMillis();
            workSpec.setBackoffDelayDuration(millis);
            return getThis();
        }

        @NonNull
        @RequiresApi(26)
        public B setInitialDelay(@NonNull Duration duration) {
            long millis;
            WorkSpec workSpec = this.mWorkSpec;
            millis = duration.toMillis();
            workSpec.initialDelay = millis;
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.mWorkSpec.initialDelay) {
                return getThis();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getStringId() {
        return this.mId.toString();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<String> getTags() {
        return this.mTags;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected WorkRequest(@NonNull UUID id, @NonNull WorkSpec workSpec, @NonNull Set<String> tags) {
        this.mId = id;
        this.mWorkSpec = workSpec;
        this.mTags = tags;
    }
}
