package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkRequestHolder;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ParcelableWorkRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkRequest> CREATOR = new Parcelable.Creator<ParcelableWorkRequest>() { // from class: androidx.work.multiprocess.parcelable.ParcelableWorkRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkRequest createFromParcel(Parcel parcel) {
            return new ParcelableWorkRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkRequest[] newArray(int i6) {
            return new ParcelableWorkRequest[i6];
        }
    };
    private final WorkRequest mWorkRequest;

    public ParcelableWorkRequest(@NonNull WorkRequest workRequest) {
        this.mWorkRequest = workRequest;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public WorkRequest getWorkRequest() {
        return this.mWorkRequest;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        parcel.writeString(this.mWorkRequest.getStringId());
        parcel.writeStringList(new ArrayList(this.mWorkRequest.getTags()));
        WorkSpec workSpec = this.mWorkRequest.getWorkSpec();
        parcel.writeString(workSpec.workerClassName);
        parcel.writeString(workSpec.inputMergerClassName);
        parcel.writeInt(WorkTypeConverters.stateToInt(workSpec.state));
        new ParcelableData(workSpec.input).writeToParcel(parcel, i6);
        new ParcelableData(workSpec.output).writeToParcel(parcel, i6);
        parcel.writeLong(workSpec.initialDelay);
        parcel.writeLong(workSpec.intervalDuration);
        parcel.writeLong(workSpec.flexDuration);
        parcel.writeInt(workSpec.runAttemptCount);
        parcel.writeParcelable(new ParcelableConstraints(workSpec.constraints), i6);
        parcel.writeInt(WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
        parcel.writeLong(workSpec.backoffDelayDuration);
        parcel.writeLong(workSpec.minimumRetentionDuration);
        parcel.writeLong(workSpec.scheduleRequestedAt);
        ParcelUtils.writeBooleanValue(parcel, workSpec.expedited);
        parcel.writeInt(WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
    }

    protected ParcelableWorkRequest(@NonNull Parcel parcel) {
        String readString = parcel.readString();
        HashSet hashSet = new HashSet(parcel.createStringArrayList());
        WorkSpec workSpec = new WorkSpec(readString, parcel.readString());
        workSpec.inputMergerClassName = parcel.readString();
        workSpec.state = WorkTypeConverters.intToState(parcel.readInt());
        workSpec.input = new ParcelableData(parcel).getData();
        workSpec.output = new ParcelableData(parcel).getData();
        workSpec.initialDelay = parcel.readLong();
        workSpec.intervalDuration = parcel.readLong();
        workSpec.flexDuration = parcel.readLong();
        workSpec.runAttemptCount = parcel.readInt();
        workSpec.constraints = ((ParcelableConstraints) parcel.readParcelable(getClass().getClassLoader())).getConstraints();
        workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(parcel.readInt());
        workSpec.backoffDelayDuration = parcel.readLong();
        workSpec.minimumRetentionDuration = parcel.readLong();
        workSpec.scheduleRequestedAt = parcel.readLong();
        workSpec.expedited = ParcelUtils.readBooleanValue(parcel);
        workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(parcel.readInt());
        this.mWorkRequest = new WorkRequestHolder(UUID.fromString(readString), workSpec, hashSet);
    }
}
