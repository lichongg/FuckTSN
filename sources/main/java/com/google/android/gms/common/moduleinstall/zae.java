package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zae implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i6) {
        return new ModuleInstallStatusUpdate[i6];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Long l6 = null;
        Long l7 = null;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                if (fieldId != 2) {
                    if (fieldId != 3) {
                        if (fieldId != 4) {
                            if (fieldId != 5) {
                                SafeParcelReader.skipUnknownField(parcel, readHeader);
                            } else {
                                i8 = SafeParcelReader.readInt(parcel, readHeader);
                            }
                        } else {
                            l7 = SafeParcelReader.readLongObject(parcel, readHeader);
                        }
                    } else {
                        l6 = SafeParcelReader.readLongObject(parcel, readHeader);
                    }
                } else {
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                }
            } else {
                i6 = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ModuleInstallStatusUpdate(i6, i7, l6, l7, i8);
    }
}
