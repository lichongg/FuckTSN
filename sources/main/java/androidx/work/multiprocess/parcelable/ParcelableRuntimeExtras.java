package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ParcelableRuntimeExtras implements Parcelable {
    public static final Parcelable.Creator<ParcelableRuntimeExtras> CREATOR = new Parcelable.Creator<ParcelableRuntimeExtras>() { // from class: androidx.work.multiprocess.parcelable.ParcelableRuntimeExtras.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public ParcelableRuntimeExtras createFromParcel(Parcel parcel) {
            return new ParcelableRuntimeExtras(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableRuntimeExtras[] newArray(int i6) {
            return new ParcelableRuntimeExtras[i6];
        }
    };
    private WorkerParameters.RuntimeExtras mRuntimeExtras;

    public ParcelableRuntimeExtras(@NonNull WorkerParameters.RuntimeExtras runtimeExtras) {
        this.mRuntimeExtras = runtimeExtras;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public WorkerParameters.RuntimeExtras getRuntimeExtras() {
        return this.mRuntimeExtras;
    }

    @Override // android.os.Parcelable
    @SuppressLint({"NewApi"})
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        List<String> list;
        int i7 = Build.VERSION.SDK_INT;
        List<Uri> list2 = null;
        Network network = i7 >= 28 ? this.mRuntimeExtras.network : null;
        boolean z5 = false;
        boolean z6 = network != null;
        ParcelUtils.writeBooleanValue(parcel, z6);
        if (z6) {
            parcel.writeParcelable(network, i6);
        }
        if (i7 >= 24) {
            WorkerParameters.RuntimeExtras runtimeExtras = this.mRuntimeExtras;
            list2 = runtimeExtras.triggeredContentUris;
            list = runtimeExtras.triggeredContentAuthorities;
        } else {
            list = null;
        }
        boolean z7 = (list2 == null || list2.isEmpty()) ? false : true;
        ParcelUtils.writeBooleanValue(parcel, z7);
        if (z7) {
            int size = list2.size();
            Uri[] uriArr = new Uri[size];
            for (int i8 = 0; i8 < size; i8++) {
                uriArr[i8] = list2.get(i8);
            }
            parcel.writeParcelableArray(uriArr, i6);
        }
        if (list != null && !list.isEmpty()) {
            z5 = true;
        }
        ParcelUtils.writeBooleanValue(parcel, z5);
        if (z5) {
            parcel.writeStringList(list);
        }
    }

    public ParcelableRuntimeExtras(@NonNull Parcel parcel) {
        ArrayList arrayList;
        ClassLoader classLoader = getClass().getClassLoader();
        Network network = ParcelUtils.readBooleanValue(parcel) ? (Network) parcel.readParcelable(classLoader) : null;
        if (ParcelUtils.readBooleanValue(parcel)) {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            arrayList = new ArrayList(readParcelableArray.length);
            for (Parcelable parcelable : readParcelableArray) {
                arrayList.add((Uri) parcelable);
            }
        } else {
            arrayList = null;
        }
        ArrayList<String> createStringArrayList = ParcelUtils.readBooleanValue(parcel) ? parcel.createStringArrayList() : null;
        WorkerParameters.RuntimeExtras runtimeExtras = new WorkerParameters.RuntimeExtras();
        this.mRuntimeExtras = runtimeExtras;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 28) {
            runtimeExtras.network = network;
        }
        if (i6 >= 24) {
            if (arrayList != null) {
                runtimeExtras.triggeredContentUris = arrayList;
            }
            if (createStringArrayList != null) {
                runtimeExtras.triggeredContentAuthorities = createStringArrayList;
            }
        }
    }
}
