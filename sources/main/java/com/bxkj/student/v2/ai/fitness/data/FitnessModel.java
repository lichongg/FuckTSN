package com.bxkj.student.v2.ai.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Parcelize
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FitnessModel implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FitnessModel> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private String f20599a;

    /* renamed from: b, reason: collision with root package name */
    private final int f20600b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f20601c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f20602d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f20603e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements Parcelable.Creator<FitnessModel> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FitnessModel createFromParcel(Parcel parcel) {
            g0.p(parcel, "parcel");
            return new FitnessModel(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FitnessModel[] newArray(int i6) {
            return new FitnessModel[i6];
        }
    }

    public FitnessModel(@NotNull String name, int i6, @NotNull String poseClass, @NotNull String poseFile, boolean z5) {
        g0.p(name, "name");
        g0.p(poseClass, "poseClass");
        g0.p(poseFile, "poseFile");
        this.f20599a = name;
        this.f20600b = i6;
        this.f20601c = poseClass;
        this.f20602d = poseFile;
        this.f20603e = z5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int a() {
        return this.f20600b;
    }

    @NotNull
    public final String b() {
        return this.f20599a;
    }

    @NotNull
    public final String c() {
        return this.f20601c;
    }

    @NotNull
    public final String d() {
        return this.f20602d;
    }

    public final boolean e() {
        return this.f20603e;
    }

    public final void f(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f20599a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int i6) {
        g0.p(dest, "dest");
        dest.writeString(this.f20599a);
        dest.writeInt(this.f20600b);
        dest.writeString(this.f20601c);
        dest.writeString(this.f20602d);
        dest.writeInt(this.f20603e ? 1 : 0);
    }

    public /* synthetic */ FitnessModel(String str, int i6, String str2, String str3, boolean z5, int i7, v vVar) {
        this(str, i6, str2, str3, (i7 & 16) != 0 ? true : z5);
    }
}
