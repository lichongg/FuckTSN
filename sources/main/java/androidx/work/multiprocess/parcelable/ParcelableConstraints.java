package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ParcelableConstraints implements Parcelable {
    public static final Parcelable.Creator<ParcelableConstraints> CREATOR = new Parcelable.Creator<ParcelableConstraints>() { // from class: androidx.work.multiprocess.parcelable.ParcelableConstraints.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableConstraints createFromParcel(Parcel parcel) {
            return new ParcelableConstraints(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableConstraints[] newArray(int i6) {
            return new ParcelableConstraints[i6];
        }
    };
    private final Constraints mConstraints;

    public ParcelableConstraints(@NonNull Constraints constraints) {
        this.mConstraints = constraints;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public Constraints getConstraints() {
        return this.mConstraints;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        parcel.writeInt(WorkTypeConverters.networkTypeToInt(this.mConstraints.getRequiredNetworkType()));
        ParcelUtils.writeBooleanValue(parcel, this.mConstraints.requiresBatteryNotLow());
        ParcelUtils.writeBooleanValue(parcel, this.mConstraints.requiresCharging());
        ParcelUtils.writeBooleanValue(parcel, this.mConstraints.requiresStorageNotLow());
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 23) {
            ParcelUtils.writeBooleanValue(parcel, this.mConstraints.requiresDeviceIdle());
        }
        if (i7 >= 24) {
            boolean hasContentUriTriggers = this.mConstraints.hasContentUriTriggers();
            ParcelUtils.writeBooleanValue(parcel, hasContentUriTriggers);
            if (hasContentUriTriggers) {
                parcel.writeByteArray(WorkTypeConverters.contentUriTriggersToByteArray(this.mConstraints.getContentUriTriggers()));
            }
            parcel.writeLong(this.mConstraints.getTriggerMaxContentDelay());
            parcel.writeLong(this.mConstraints.getTriggerContentUpdateDelay());
        }
    }

    public ParcelableConstraints(@NonNull Parcel parcel) {
        Constraints.Builder builder = new Constraints.Builder();
        builder.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(parcel.readInt()));
        builder.setRequiresBatteryNotLow(ParcelUtils.readBooleanValue(parcel));
        builder.setRequiresCharging(ParcelUtils.readBooleanValue(parcel));
        builder.setRequiresStorageNotLow(ParcelUtils.readBooleanValue(parcel));
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23) {
            builder.setRequiresDeviceIdle(ParcelUtils.readBooleanValue(parcel));
        }
        if (i6 >= 24) {
            if (ParcelUtils.readBooleanValue(parcel)) {
                for (ContentUriTriggers.Trigger trigger : WorkTypeConverters.byteArrayToContentUriTriggers(parcel.createByteArray()).getTriggers()) {
                    builder.addContentUriTrigger(trigger.getUri(), trigger.shouldTriggerForDescendants());
                }
            }
            long readLong = parcel.readLong();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builder.setTriggerContentMaxDelay(readLong, timeUnit);
            builder.setTriggerContentUpdateDelay(parcel.readLong(), timeUnit);
        }
        this.mConstraints = builder.build();
    }
}
