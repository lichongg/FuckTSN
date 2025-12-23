package com.bxkj.base.v2.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Parcelize
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ParcelableMap implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ParcelableMap> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private Map<String, Object> f16997a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Parcelable.Creator<ParcelableMap> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ParcelableMap createFromParcel(Parcel parcel) {
            g0.p(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i6 = 0; i6 != readInt; i6++) {
                linkedHashMap.put(parcel.readString(), parcel.readValue(ParcelableMap.class.getClassLoader()));
            }
            return new ParcelableMap(linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ParcelableMap[] newArray(int i6) {
            return new ParcelableMap[i6];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ParcelableMap(@NotNull Map<String, Object> map) {
        g0.p(map, "map");
        this.f16997a = map;
    }

    @NotNull
    public final Map<String, Object> a() {
        return this.f16997a;
    }

    public final void b(@NotNull Map<String, Object> map) {
        g0.p(map, "<set-?>");
        this.f16997a = map;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int i6) {
        g0.p(dest, "dest");
        Map<String, Object> map = this.f16997a;
        dest.writeInt(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeValue(entry.getValue());
        }
    }
}
