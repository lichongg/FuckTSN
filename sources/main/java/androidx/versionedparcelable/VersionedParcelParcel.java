package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
class VersionedParcelParcel extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mFieldId;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;

    VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        if (bArr == null) {
            this.mParcel.writeInt(-1);
        } else {
            this.mParcel.writeInt(bArr.length);
            this.mParcel.writeByteArray(bArr);
        }
    }

    private VersionedParcelParcel(Parcel parcel, int i6, int i7, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mFieldId = -1;
        this.mParcel = parcel;
        this.mOffset = i6;
        this.mEnd = i7;
        this.mNextRead = i6;
        this.mPrefix = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int i6 = this.mCurrentField;
        if (i6 >= 0) {
            int i7 = this.mPositionLookup.get(i6);
            int dataPosition = this.mParcel.dataPosition();
            this.mParcel.setDataPosition(i7);
            this.mParcel.writeInt(dataPosition - i7);
            this.mParcel.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel createSubParcel() {
        Parcel parcel = this.mParcel;
        int dataPosition = parcel.dataPosition();
        int i6 = this.mNextRead;
        if (i6 == this.mOffset) {
            i6 = this.mEnd;
        }
        return new VersionedParcelParcel(parcel, dataPosition, i6, this.mPrefix + "  ", this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        return this.mParcel.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        return this.mParcel.readBundle(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int readInt = this.mParcel.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.mParcel.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mParcel.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i6) {
        while (this.mNextRead < this.mEnd) {
            int i7 = this.mFieldId;
            if (i7 == i6) {
                return true;
            }
            if (String.valueOf(i7).compareTo(String.valueOf(i6)) > 0) {
                return false;
            }
            this.mParcel.setDataPosition(this.mNextRead);
            int readInt = this.mParcel.readInt();
            this.mFieldId = this.mParcel.readInt();
            this.mNextRead += readInt;
        }
        return this.mFieldId == i6;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.mParcel.readFloat();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.mParcel.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.mParcel.readLong();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return (T) this.mParcel.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        return this.mParcel.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z5) {
        this.mParcel.writeInt(z5 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) {
        this.mParcel.writeBundle(bundle);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void writeCharSequence(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.mParcel, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d6) {
        this.mParcel.writeDouble(d6);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f6) {
        this.mParcel.writeFloat(f6);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i6) {
        this.mParcel.writeInt(i6);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j6) {
        this.mParcel.writeLong(j6);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        this.mParcel.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        this.mParcel.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        this.mParcel.writeStrongBinder(iBinder);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        this.mParcel.writeStrongInterface(iInterface);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i6) {
        closeField();
        this.mCurrentField = i6;
        this.mPositionLookup.put(i6, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(i6);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i6, int i7) {
        if (bArr != null) {
            this.mParcel.writeInt(bArr.length);
            this.mParcel.writeByteArray(bArr, i6, i7);
        } else {
            this.mParcel.writeInt(-1);
        }
    }
}
