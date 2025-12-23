package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ParcelableWorkQuery implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkQuery> CREATOR = new Parcelable.Creator<ParcelableWorkQuery>() { // from class: androidx.work.multiprocess.parcelable.ParcelableWorkQuery.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkQuery createFromParcel(Parcel parcel) {
            return new ParcelableWorkQuery(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWorkQuery[] newArray(int i6) {
            return new ParcelableWorkQuery[i6];
        }
    };
    private final WorkQuery mWorkQuery;

    public ParcelableWorkQuery(@NonNull WorkQuery workQuery) {
        this.mWorkQuery = workQuery;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public WorkQuery getWorkQuery() {
        return this.mWorkQuery;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        List<UUID> ids = this.mWorkQuery.getIds();
        parcel.writeInt(ids.size());
        if (!ids.isEmpty()) {
            Iterator<UUID> it = ids.iterator();
            while (it.hasNext()) {
                parcel.writeString(it.next().toString());
            }
        }
        parcel.writeStringList(this.mWorkQuery.getUniqueWorkNames());
        parcel.writeStringList(this.mWorkQuery.getTags());
        List<WorkInfo.State> states = this.mWorkQuery.getStates();
        parcel.writeInt(states.size());
        if (states.isEmpty()) {
            return;
        }
        Iterator<WorkInfo.State> it2 = states.iterator();
        while (it2.hasNext()) {
            parcel.writeInt(WorkTypeConverters.stateToInt(it2.next()));
        }
    }

    protected ParcelableWorkQuery(@NonNull Parcel parcel) {
        List list = Collections.EMPTY_LIST;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            list = new ArrayList(readInt);
            for (int i6 = 0; i6 < readInt; i6++) {
                list.add(UUID.fromString(parcel.readString()));
            }
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        ArrayList<String> createStringArrayList2 = parcel.createStringArrayList();
        List<WorkInfo.State> list2 = Collections.EMPTY_LIST;
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            list2 = new ArrayList<>(readInt2);
            for (int i7 = 0; i7 < readInt2; i7++) {
                list2.add(WorkTypeConverters.intToState(parcel.readInt()));
            }
        }
        this.mWorkQuery = WorkQuery.Builder.fromIds(list).addUniqueWorkNames(createStringArrayList).addTags(createStringArrayList2).addStates(list2).build();
    }
}
