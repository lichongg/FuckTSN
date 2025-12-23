package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() { // from class: com.github.mikephil.charting.data.Entry.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Entry[] newArray(int i6) {
            return new Entry[i6];
        }
    };

    /* renamed from: x, reason: collision with root package name */
    private float f32559x;

    public Entry() {
        this.f32559x = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equalTo(Entry entry) {
        if (entry == null || entry.getData() != getData()) {
            return false;
        }
        float abs = Math.abs(entry.f32559x - this.f32559x);
        float f6 = Utils.FLOAT_EPSILON;
        return abs <= f6 && Math.abs(entry.getY() - getY()) <= f6;
    }

    public Entry copy() {
        return new Entry(this.f32559x, getY(), getData());
    }

    public float getX() {
        return this.f32559x;
    }

    public void setX(float f6) {
        this.f32559x = f6;
    }

    public String toString() {
        return "Entry, x: " + this.f32559x + " y: " + getY();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.f32559x);
        parcel.writeFloat(getY());
        if (getData() == null) {
            parcel.writeInt(0);
        } else {
            if (!(getData() instanceof Parcelable)) {
                throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
            }
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) getData(), i6);
        }
    }

    public Entry(float f6, float f7) {
        super(f7);
        this.f32559x = f6;
    }

    public Entry(float f6, float f7, Object obj) {
        super(f7, obj);
        this.f32559x = f6;
    }

    public Entry(float f6, float f7, Drawable drawable) {
        super(f7, drawable);
        this.f32559x = f6;
    }

    public Entry(float f6, float f7, Drawable drawable, Object obj) {
        super(f7, drawable, obj);
        this.f32559x = f6;
    }

    protected Entry(Parcel parcel) {
        this.f32559x = 0.0f;
        this.f32559x = parcel.readFloat();
        setY(parcel.readFloat());
        if (parcel.readInt() == 1) {
            setData(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
