package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ObservableInt extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new Parcelable.Creator<ObservableInt>() { // from class: androidx.databinding.ObservableInt.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableInt createFromParcel(Parcel parcel) {
            return new ObservableInt(parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableInt[] newArray(int i6) {
            return new ObservableInt[i6];
        }
    };
    static final long serialVersionUID = 1;
    private int mValue;

    public ObservableInt(int i6) {
        this.mValue = i6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mValue;
    }

    public void set(int i6) {
        if (i6 != this.mValue) {
            this.mValue = i6;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.mValue);
    }

    public ObservableInt() {
    }

    public ObservableInt(Observable... observableArr) {
        super(observableArr);
    }
}
