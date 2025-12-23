package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class WorkQuery {
    private final List<UUID> mIds;
    private final List<WorkInfo.State> mStates;
    private final List<String> mTags;
    private final List<String> mUniqueWorkNames;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        List<UUID> mIds = new ArrayList();
        List<String> mUniqueWorkNames = new ArrayList();
        List<String> mTags = new ArrayList();
        List<WorkInfo.State> mStates = new ArrayList();

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromIds(@NonNull List<UUID> ids) {
            Builder builder = new Builder();
            builder.addIds(ids);
            return builder;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromStates(@NonNull List<WorkInfo.State> states) {
            Builder builder = new Builder();
            builder.addStates(states);
            return builder;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromTags(@NonNull List<String> tags) {
            Builder builder = new Builder();
            builder.addTags(tags);
            return builder;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromUniqueWorkNames(@NonNull List<String> uniqueWorkNames) {
            Builder builder = new Builder();
            builder.addUniqueWorkNames(uniqueWorkNames);
            return builder;
        }

        @NonNull
        public Builder addIds(@NonNull List<UUID> ids) {
            this.mIds.addAll(ids);
            return this;
        }

        @NonNull
        public Builder addStates(@NonNull List<WorkInfo.State> states) {
            this.mStates.addAll(states);
            return this;
        }

        @NonNull
        public Builder addTags(@NonNull List<String> tags) {
            this.mTags.addAll(tags);
            return this;
        }

        @NonNull
        public Builder addUniqueWorkNames(@NonNull List<String> uniqueWorkNames) {
            this.mUniqueWorkNames.addAll(uniqueWorkNames);
            return this;
        }

        @NonNull
        public WorkQuery build() {
            if (this.mIds.isEmpty() && this.mUniqueWorkNames.isEmpty() && this.mTags.isEmpty() && this.mStates.isEmpty()) {
                throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
            }
            return new WorkQuery(this);
        }

        private Builder() {
        }
    }

    @NonNull
    public List<UUID> getIds() {
        return this.mIds;
    }

    @NonNull
    public List<WorkInfo.State> getStates() {
        return this.mStates;
    }

    @NonNull
    public List<String> getTags() {
        return this.mTags;
    }

    @NonNull
    public List<String> getUniqueWorkNames() {
        return this.mUniqueWorkNames;
    }

    WorkQuery(@NonNull Builder builder) {
        this.mIds = builder.mIds;
        this.mUniqueWorkNames = builder.mUniqueWorkNames;
        this.mTags = builder.mTags;
        this.mStates = builder.mStates;
    }
}
