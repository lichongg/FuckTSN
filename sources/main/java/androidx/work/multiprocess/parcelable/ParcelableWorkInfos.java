package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ParcelableWorkInfos implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkInfos> CREATOR = new Parcelable.Creator<ParcelableWorkInfos>() { // from class: androidx.work.multiprocess.parcelable.ParcelableWorkInfos.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkInfos createFromParcel(Parcel parcel) {
            return new ParcelableWorkInfos(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkInfos[] newArray(int i6) {
            return new ParcelableWorkInfos[i6];
        }
    };
    private final List<WorkInfo> mInfos;

    public ParcelableWorkInfos(@NonNull List<WorkInfo> list) {
        this.mInfos = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<WorkInfo> getWorkInfos() {
        return this.mInfos;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        ParcelableWorkInfo[] parcelableWorkInfoArr = new ParcelableWorkInfo[this.mInfos.size()];
        for (int i7 = 0; i7 < this.mInfos.size(); i7++) {
            parcelableWorkInfoArr[i7] = new ParcelableWorkInfo(this.mInfos.get(i7));
        }
        parcel.writeParcelableArray(parcelableWorkInfoArr, i6);
    }

    protected ParcelableWorkInfos(@NonNull Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(getClass().getClassLoader());
        this.mInfos = new ArrayList(readParcelableArray.length);
        for (Parcelable parcelable : readParcelableArray) {
            this.mInfos.add(((ParcelableWorkInfo) parcelable).getWorkInfo());
        }
    }
}
