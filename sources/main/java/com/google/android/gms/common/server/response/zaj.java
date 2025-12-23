package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zaj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i6) {
        return new FastJsonResponse.Field[i6];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        com.google.android.gms.common.server.converter.zaa zaaVar = null;
        int i6 = 0;
        int i7 = 0;
        boolean z5 = false;
        int i8 = 0;
        boolean z6 = false;
        int i9 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    i9 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    zaaVar = (com.google.android.gms.common.server.converter.zaa) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.common.server.converter.zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new FastJsonResponse.Field(i6, i7, z5, i8, z6, str, i9, str2, zaaVar);
    }
}
