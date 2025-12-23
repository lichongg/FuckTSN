package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ParcelableWorkRequests implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkRequests> CREATOR = new Parcelable.Creator<ParcelableWorkRequests>() { // from class: androidx.work.multiprocess.parcelable.ParcelableWorkRequests.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkRequests createFromParcel(Parcel parcel) {
            return new ParcelableWorkRequests(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkRequests[] newArray(int i6) {
            return new ParcelableWorkRequests[i6];
        }
    };
    private final List<WorkRequest> mRequests;

    public ParcelableWorkRequests(@NonNull List<WorkRequest> list) {
        this.mRequests = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<WorkRequest> getRequests() {
        return this.mRequests;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        ParcelableWorkRequest[] parcelableWorkRequestArr = new ParcelableWorkRequest[this.mRequests.size()];
        for (int i7 = 0; i7 < this.mRequests.size(); i7++) {
            parcelableWorkRequestArr[i7] = new ParcelableWorkRequest(this.mRequests.get(i7));
        }
        parcel.writeParcelableArray(parcelableWorkRequestArr, i6);
    }

    protected ParcelableWorkRequests(@NonNull Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(getClass().getClassLoader());
        this.mRequests = new ArrayList(readParcelableArray.length);
        for (Parcelable parcelable : readParcelableArray) {
            this.mRequests.add(((ParcelableWorkRequest) parcelable).getWorkRequest());
        }
    }
}
