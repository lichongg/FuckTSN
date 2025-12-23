package com.kwad.framework.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] bV(int i6) {
            return new b[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i6) {
            return bV(i6);
        }
    };
    private HashMap<String, List<String>> aoV;

    public b() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    protected b(Parcel parcel) {
        this.aoV = parcel.readHashMap(String.class.getClassLoader());
    }

    public final void bw(String str) {
        HashMap<String, List<String>> hashMap = this.aoV;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    public final String toString() {
        return this.aoV.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeMap(this.aoV);
    }

    public final HashMap<String, List<String>> yY() {
        return this.aoV;
    }

    public final void y(String str, String str2) {
        ax.hh(str);
        ax.hh(str2);
        if (this.aoV == null) {
            this.aoV = new HashMap<>();
        }
        List<String> list = this.aoV.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.aoV.put(str, list);
        }
        if (!list.contains(str2)) {
            list.add(str2);
        }
    }
}
