package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ParcelableWorkerParameters implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkerParameters> CREATOR = new Parcelable.Creator<ParcelableWorkerParameters>() { // from class: androidx.work.multiprocess.parcelable.ParcelableWorkerParameters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public ParcelableWorkerParameters createFromParcel(Parcel parcel) {
            return new ParcelableWorkerParameters(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkerParameters[] newArray(int i6) {
            return new ParcelableWorkerParameters[i6];
        }
    };

    @NonNull
    private final Data mData;

    @NonNull
    private final UUID mId;
    private final int mRunAttemptCount;

    @NonNull
    private final WorkerParameters.RuntimeExtras mRuntimeExtras;

    @NonNull
    private final Set<String> mTags;

    public ParcelableWorkerParameters(@NonNull WorkerParameters workerParameters) {
        this.mId = workerParameters.getId();
        this.mData = workerParameters.getInputData();
        this.mTags = workerParameters.getTags();
        this.mRuntimeExtras = workerParameters.getRuntimeExtras();
        this.mRunAttemptCount = workerParameters.getRunAttemptCount();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public Data getData() {
        return this.mData;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    @NonNull
    public Set<String> getTags() {
        return this.mTags;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        parcel.writeString(this.mId.toString());
        new ParcelableData(this.mData).writeToParcel(parcel, i6);
        parcel.writeStringList(new ArrayList(this.mTags));
        new ParcelableRuntimeExtras(this.mRuntimeExtras).writeToParcel(parcel, i6);
        parcel.writeInt(this.mRunAttemptCount);
    }

    @NonNull
    public WorkerParameters toWorkerParameters(@NonNull WorkManagerImpl workManagerImpl) {
        Configuration configuration = workManagerImpl.getConfiguration();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        TaskExecutor workTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        return new WorkerParameters(this.mId, this.mData, this.mTags, this.mRuntimeExtras, this.mRunAttemptCount, configuration.getExecutor(), workTaskExecutor, configuration.getWorkerFactory(), new WorkProgressUpdater(workDatabase, workTaskExecutor), new WorkForegroundUpdater(workDatabase, workManagerImpl.getProcessor(), workTaskExecutor));
    }

    public ParcelableWorkerParameters(@NonNull Parcel parcel) {
        this.mId = UUID.fromString(parcel.readString());
        this.mData = new ParcelableData(parcel).getData();
        this.mTags = new HashSet(parcel.createStringArrayList());
        this.mRuntimeExtras = new ParcelableRuntimeExtras(parcel).getRuntimeExtras();
        this.mRunAttemptCount = parcel.readInt();
    }
}
