package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ObservableChar extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableChar> CREATOR = new Parcelable.Creator<ObservableChar>() { // from class: androidx.databinding.ObservableChar.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableChar createFromParcel(Parcel parcel) {
            return new ObservableChar((char) parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ObservableChar[] newArray(int i6) {
            return new ObservableChar[i6];
        }
    };
    static final long serialVersionUID = 1;
    private char mValue;

    public ObservableChar(char c6) {
        this.mValue = c6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public char get() {
        return this.mValue;
    }

    public void set(char c6) {
        if (c6 != this.mValue) {
            this.mValue = c6;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.mValue);
    }

    public ObservableChar() {
    }

    public ObservableChar(Observable... observableArr) {
        super(observableArr);
    }
}
