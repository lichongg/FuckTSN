package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new Parcelable.Creator<ParcelableMMKV>() { // from class: com.tencent.mmkv.ParcelableMMKV.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMMKV createFromParcel(Parcel source) {
            String readString = source.readString();
            Parcelable.Creator creator = ParcelFileDescriptor.CREATOR;
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) creator.createFromParcel(source);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) creator.createFromParcel(source);
            String readString2 = source.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMMKV[] newArray(int size) {
            return new ParcelableMMKV[size];
        }
    };
    private int ashmemFD;
    private int ashmemMetaFD;
    private String cryptKey;
    private final String mmapID;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    public ParcelableMMKV(MMKV mmkv) {
        this.ashmemFD = -1;
        this.ashmemMetaFD = -1;
        this.cryptKey = null;
        this.mmapID = mmkv.mmapID();
        this.ashmemFD = mmkv.ashmemFD();
        this.ashmemMetaFD = mmkv.ashmemMetaFD();
        this.cryptKey = mmkv.cryptKey();
    }

    public MMKV toMMKV() {
        int i6;
        int i7 = this.ashmemFD;
        if (i7 < 0 || (i6 = this.ashmemMetaFD) < 0) {
            return null;
        }
        return MMKV.mmkvWithAshmemFD(this.mmapID, i7, i6, this.cryptKey);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        try {
            dest.writeString(this.mmapID);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.ashmemFD);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.ashmemMetaFD);
            int i6 = flags | 1;
            fromFd.writeToParcel(dest, i6);
            fromFd2.writeToParcel(dest, i6);
            String str = this.cryptKey;
            if (str != null) {
                dest.writeString(str);
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    private ParcelableMMKV(String id, int fd, int metaFD, String key) {
        this.mmapID = id;
        this.ashmemFD = fd;
        this.ashmemMetaFD = metaFD;
        this.cryptKey = key;
    }
}
