package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ObservableLong extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableLong> CREATOR = new Parcelable.Creator<ObservableLong>() { // from class: androidx.databinding.ObservableLong.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableLong createFromParcel(Parcel parcel) {
            return new ObservableLong(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableLong[] newArray(int i6) {
            return new ObservableLong[i6];
        }
    };
    static final long serialVersionUID = 1;
    private long mValue;

    public ObservableLong(long j6) {
        this.mValue = j6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long get() {
        return this.mValue;
    }

    public void set(long j6) {
        if (j6 != this.mValue) {
            this.mValue = j6;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.mValue);
    }

    public ObservableLong() {
    }

    public ObservableLong(Observable... observableArr) {
        super(observableArr);
    }
}
