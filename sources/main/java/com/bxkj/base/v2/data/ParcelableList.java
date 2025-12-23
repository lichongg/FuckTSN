package com.bxkj.base.v2.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Parcelize
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ParcelableList implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ParcelableList> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private List<? extends Map<String, ? extends Object>> f16996a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Parcelable.Creator<ParcelableList> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ParcelableList createFromParcel(Parcel parcel) {
            g0.p(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i6 = 0; i6 != readInt; i6++) {
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
                for (int i7 = 0; i7 != readInt2; i7++) {
                    linkedHashMap.put(parcel.readString(), parcel.readValue(ParcelableList.class.getClassLoader()));
                }
                arrayList.add(linkedHashMap);
            }
            return new ParcelableList(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ParcelableList[] newArray(int i6) {
            return new ParcelableList[i6];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ParcelableList(@NotNull List<? extends Map<String, ? extends Object>> list) {
        g0.p(list, "list");
        this.f16996a = list;
    }

    @NotNull
    public final List<Map<String, Object>> a() {
        return this.f16996a;
    }

    public final void b(@NotNull List<? extends Map<String, ? extends Object>> list) {
        g0.p(list, "<set-?>");
        this.f16996a = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int i6) {
        g0.p(dest, "dest");
        List<? extends Map<String, ? extends Object>> list = this.f16996a;
        dest.writeInt(list.size());
        for (Map<String, ? extends Object> map : list) {
            dest.writeInt(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                dest.writeString(entry.getKey());
                dest.writeValue(entry.getValue());
            }
        }
    }
}
