package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zaa = {"data"};
    private final Parcelable.Creator zab;

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    @KeepForSdk
    public T get(int i6) {
        DataHolder dataHolder = (DataHolder) Preconditions.checkNotNull(this.mDataHolder);
        byte[] byteArray = dataHolder.getByteArray("data", i6, dataHolder.getWindowIndex(i6));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        T t5 = (T) this.zab.createFromParcel(obtain);
        obtain.recycle();
        return t5;
    }

    @NonNull
    @KeepForSdk
    public static DataHolder.Builder buildDataHolder() {
        return DataHolder.builder(zaa);
    }

    @KeepForSdk
    public DataBufferSafeParcelable(@NonNull DataHolder dataHolder, @NonNull Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.zab = creator;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void addValue(@NonNull DataHolder.Builder builder, @NonNull T t5) {
        Parcel obtain = Parcel.obtain();
        t5.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        builder.withRow(contentValues);
        obtain.recycle();
    }
}
