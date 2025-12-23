package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.ListenableWorker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class ParcelableResult implements Parcelable {
    public static final Parcelable.Creator<ParcelableResult> CREATOR = new Parcelable.Creator<ParcelableResult>() { // from class: androidx.work.multiprocess.parcelable.ParcelableResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public ParcelableResult createFromParcel(Parcel parcel) {
            return new ParcelableResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableResult[] newArray(int i6) {
            return new ParcelableResult[i6];
        }
    };
    private final ListenableWorker.Result mResult;

    public ParcelableResult(@NonNull ListenableWorker.Result result) {
        this.mResult = result;
    }

    @NonNull
    private static ListenableWorker.Result intToResultType(int i6, @NonNull Data data) {
        if (i6 == 1) {
            return ListenableWorker.Result.retry();
        }
        if (i6 == 2) {
            return ListenableWorker.Result.success(data);
        }
        if (i6 == 3) {
            return ListenableWorker.Result.failure(data);
        }
        throw new IllegalStateException(String.format("Unknown result type %s", Integer.valueOf(i6)));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private static int resultTypeOf(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Retry) {
            return 1;
        }
        if (result instanceof ListenableWorker.Result.Success) {
            return 2;
        }
        if (result instanceof ListenableWorker.Result.Failure) {
            return 3;
        }
        throw new IllegalStateException(String.format("Unknown Result %s", result));
    }

    @NonNull
    public ListenableWorker.Result getResult() {
        return this.mResult;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        parcel.writeInt(resultTypeOf(this.mResult));
        new ParcelableData(this.mResult.getOutputData()).writeToParcel(parcel, i6);
    }

    public ParcelableResult(@NonNull Parcel parcel) {
        this.mResult = intToResultType(parcel.readInt(), new ParcelableData(parcel).getData());
    }
}
