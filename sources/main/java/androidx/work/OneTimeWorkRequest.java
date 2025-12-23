package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
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
        public OneTimeWorkRequest buildInternal() {
            if (this.mBackoffCriteriaSet && Build.VERSION.SDK_INT >= 23 && this.mWorkSpec.constraints.requiresDeviceIdle()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new OneTimeWorkRequest(this);
        }

        @NonNull
        public Builder setInputMerger(@NonNull Class<? extends InputMerger> inputMerger) {
            this.mWorkSpec.inputMergerClassName = inputMerger.getName();
            return this;
        }

        public Builder(@NonNull Class<? extends ListenableWorker> workerClass) {
            super(workerClass);
            this.mWorkSpec.inputMergerClassName = OverwritingInputMerger.class.getName();
        }
    }

    @NonNull
    public static OneTimeWorkRequest from(@NonNull Class<? extends ListenableWorker> workerClass) {
        return new Builder(workerClass).build();
    }

    OneTimeWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }

    @NonNull
    public static List<OneTimeWorkRequest> from(@NonNull List<Class<? extends ListenableWorker>> workerClasses) {
        ArrayList arrayList = new ArrayList(workerClasses.size());
        Iterator<Class<? extends ListenableWorker>> it = workerClasses.iterator();
        while (it.hasNext()) {
            arrayList.add(new Builder(it.next()).build());
        }
        return arrayList;
    }
}
