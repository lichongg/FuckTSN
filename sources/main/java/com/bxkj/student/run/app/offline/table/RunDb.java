package com.bxkj.student.run.app.offline.table;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.umeng.analytics.AnalyticsConfig;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Entity(tableName = "runDb")
@Parcelize
/* loaded from: D:\Downloads\app\classes3.dex */
public final class RunDb implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RunDb> CREATOR = new Creator();

    @ColumnInfo(name = "countTime", typeAffinity = 2)
    @NotNull
    private String countTime;

    @ColumnInfo(name = "distance", typeAffinity = 2)
    @NotNull
    private String distance;

    @ColumnInfo(name = "endTime", typeAffinity = 2)
    @NotNull
    private String endTime;

    @ColumnInfo(name = "faceDetectCount", typeAffinity = 2)
    @NotNull
    private String faceDetectCount;

    @PrimaryKey
    @ColumnInfo(name = "identify", typeAffinity = 2)
    @NotNull
    private String identify;

    @ColumnInfo(name = "isFaceOut", typeAffinity = 2)
    @NotNull
    private String isFaceOut;

    @ColumnInfo(name = "latLngList", typeAffinity = 2)
    @NotNull
    private String latLngList;

    @ColumnInfo(name = "passLatLngList", typeAffinity = 2)
    @NotNull
    private String passLatLngList;

    @ColumnInfo(name = "sportsSet", typeAffinity = 2)
    @NotNull
    private String sportsSet;

    @ColumnInfo(name = "sportsType", typeAffinity = 2)
    @NotNull
    private String sportsType;

    @ColumnInfo(name = AnalyticsConfig.RTD_START_TIME, typeAffinity = 2)
    @NotNull
    private String startTime;

    @ColumnInfo(name = "stepList", typeAffinity = 2)
    @NotNull
    private String stepList;

    @ColumnInfo(name = "uploadType", typeAffinity = 2)
    @NotNull
    private String uploadType;

    @ColumnInfo(name = "userNumber", typeAffinity = 2)
    @NotNull
    private String userNumber;

    @ColumnInfo(name = "points", typeAffinity = 2)
    @NotNull
    private String userPassPointList;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Creator implements Parcelable.Creator<RunDb> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RunDb createFromParcel(Parcel parcel) {
            g0.p(parcel, "parcel");
            return new RunDb(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RunDb[] newArray(int i6) {
            return new RunDb[i6];
        }
    }

    public RunDb(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String userPassPointList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType) {
        g0.p(identify, "identify");
        g0.p(userNumber, "userNumber");
        g0.p(sportsType, "sportsType");
        g0.p(sportsSet, "sportsSet");
        g0.p(startTime, "startTime");
        g0.p(endTime, "endTime");
        g0.p(countTime, "countTime");
        g0.p(distance, "distance");
        g0.p(latLngList, "latLngList");
        g0.p(stepList, "stepList");
        g0.p(passLatLngList, "passLatLngList");
        g0.p(userPassPointList, "userPassPointList");
        g0.p(isFaceOut, "isFaceOut");
        g0.p(faceDetectCount, "faceDetectCount");
        g0.p(uploadType, "uploadType");
        this.identify = identify;
        this.userNumber = userNumber;
        this.sportsType = sportsType;
        this.sportsSet = sportsSet;
        this.startTime = startTime;
        this.endTime = endTime;
        this.countTime = countTime;
        this.distance = distance;
        this.latLngList = latLngList;
        this.stepList = stepList;
        this.passLatLngList = passLatLngList;
        this.userPassPointList = userPassPointList;
        this.isFaceOut = isFaceOut;
        this.faceDetectCount = faceDetectCount;
        this.uploadType = uploadType;
    }

    @NotNull
    public final RunDb copy(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String userPassPointList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType) {
        g0.p(identify, "identify");
        g0.p(userNumber, "userNumber");
        g0.p(sportsType, "sportsType");
        g0.p(sportsSet, "sportsSet");
        g0.p(startTime, "startTime");
        g0.p(endTime, "endTime");
        g0.p(countTime, "countTime");
        g0.p(distance, "distance");
        g0.p(latLngList, "latLngList");
        g0.p(stepList, "stepList");
        g0.p(passLatLngList, "passLatLngList");
        g0.p(userPassPointList, "userPassPointList");
        g0.p(isFaceOut, "isFaceOut");
        g0.p(faceDetectCount, "faceDetectCount");
        g0.p(uploadType, "uploadType");
        return new RunDb(identify, userNumber, sportsType, sportsSet, startTime, endTime, countTime, distance, latLngList, stepList, passLatLngList, userPassPointList, isFaceOut, faceDetectCount, uploadType);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RunDb)) {
            return false;
        }
        RunDb runDb = (RunDb) obj;
        return g0.g(this.identify, runDb.identify) && g0.g(this.userNumber, runDb.userNumber) && g0.g(this.sportsType, runDb.sportsType) && g0.g(this.sportsSet, runDb.sportsSet) && g0.g(this.startTime, runDb.startTime) && g0.g(this.endTime, runDb.endTime) && g0.g(this.countTime, runDb.countTime) && g0.g(this.distance, runDb.distance) && g0.g(this.latLngList, runDb.latLngList) && g0.g(this.stepList, runDb.stepList) && g0.g(this.passLatLngList, runDb.passLatLngList) && g0.g(this.userPassPointList, runDb.userPassPointList) && g0.g(this.isFaceOut, runDb.isFaceOut) && g0.g(this.faceDetectCount, runDb.faceDetectCount) && g0.g(this.uploadType, runDb.uploadType);
    }

    @NotNull
    public final String component1() {
        return this.identify;
    }

    @NotNull
    public final String component10() {
        return this.stepList;
    }

    @NotNull
    public final String component11() {
        return this.passLatLngList;
    }

    @NotNull
    public final String component12() {
        return this.userPassPointList;
    }

    @NotNull
    public final String component13() {
        return this.isFaceOut;
    }

    @NotNull
    public final String component14() {
        return this.faceDetectCount;
    }

    @NotNull
    public final String component15() {
        return this.uploadType;
    }

    @NotNull
    public final String component2() {
        return this.userNumber;
    }

    @NotNull
    public final String component3() {
        return this.sportsType;
    }

    @NotNull
    public final String component4() {
        return this.sportsSet;
    }

    @NotNull
    public final String component5() {
        return this.startTime;
    }

    @NotNull
    public final String component6() {
        return this.endTime;
    }

    @NotNull
    public final String component7() {
        return this.countTime;
    }

    @NotNull
    public final String component8() {
        return this.distance;
    }

    @NotNull
    public final String component9() {
        return this.latLngList;
    }

    @NotNull
    public final String getCountTime() {
        return this.countTime;
    }

    @NotNull
    public final String getDistance() {
        return this.distance;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getFaceDetectCount() {
        return this.faceDetectCount;
    }

    @NotNull
    public final String getIdentify() {
        return this.identify;
    }

    @NotNull
    public final String getLatLngList() {
        return this.latLngList;
    }

    @NotNull
    public final String getPassLatLngList() {
        return this.passLatLngList;
    }

    @NotNull
    public final String getSportsSet() {
        return this.sportsSet;
    }

    @NotNull
    public final String getSportsType() {
        return this.sportsType;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getStepList() {
        return this.stepList;
    }

    @NotNull
    public final String getUploadType() {
        return this.uploadType;
    }

    @NotNull
    public final String getUserNumber() {
        return this.userNumber;
    }

    @NotNull
    public final String getUserPassPointList() {
        return this.userPassPointList;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.identify.hashCode() * 31) + this.userNumber.hashCode()) * 31) + this.sportsType.hashCode()) * 31) + this.sportsSet.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.countTime.hashCode()) * 31) + this.distance.hashCode()) * 31) + this.latLngList.hashCode()) * 31) + this.stepList.hashCode()) * 31) + this.passLatLngList.hashCode()) * 31) + this.userPassPointList.hashCode()) * 31) + this.isFaceOut.hashCode()) * 31) + this.faceDetectCount.hashCode()) * 31) + this.uploadType.hashCode();
    }

    @NotNull
    public final String isFaceOut() {
        return this.isFaceOut;
    }

    public final void setCountTime(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.countTime = str;
    }

    public final void setDistance(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.distance = str;
    }

    public final void setEndTime(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.endTime = str;
    }

    public final void setFaceDetectCount(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.faceDetectCount = str;
    }

    public final void setFaceOut(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.isFaceOut = str;
    }

    public final void setIdentify(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.identify = str;
    }

    public final void setLatLngList(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.latLngList = str;
    }

    public final void setPassLatLngList(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.passLatLngList = str;
    }

    public final void setSportsSet(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.sportsSet = str;
    }

    public final void setSportsType(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.sportsType = str;
    }

    public final void setStartTime(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.startTime = str;
    }

    public final void setStepList(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.stepList = str;
    }

    public final void setUploadType(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.uploadType = str;
    }

    public final void setUserNumber(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.userNumber = str;
    }

    public final void setUserPassPointList(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.userPassPointList = str;
    }

    @NotNull
    public String toString() {
        return "RunDb(identify=" + this.identify + ", userNumber=" + this.userNumber + ", sportsType=" + this.sportsType + ", sportsSet=" + this.sportsSet + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", countTime=" + this.countTime + ", distance=" + this.distance + ", latLngList=" + this.latLngList + ", stepList=" + this.stepList + ", passLatLngList=" + this.passLatLngList + ", userPassPointList=" + this.userPassPointList + ", isFaceOut=" + this.isFaceOut + ", faceDetectCount=" + this.faceDetectCount + ", uploadType=" + this.uploadType + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int i6) {
        g0.p(dest, "dest");
        dest.writeString(this.identify);
        dest.writeString(this.userNumber);
        dest.writeString(this.sportsType);
        dest.writeString(this.sportsSet);
        dest.writeString(this.startTime);
        dest.writeString(this.endTime);
        dest.writeString(this.countTime);
        dest.writeString(this.distance);
        dest.writeString(this.latLngList);
        dest.writeString(this.stepList);
        dest.writeString(this.passLatLngList);
        dest.writeString(this.userPassPointList);
        dest.writeString(this.isFaceOut);
        dest.writeString(this.faceDetectCount);
        dest.writeString(this.uploadType);
    }

    public /* synthetic */ RunDb(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i6, v vVar) {
        this(str, str2, str3, str4, str5, str6, (i6 & 64) != 0 ? "0" : str7, (i6 & 128) != 0 ? "0" : str8, str9, str10, str11, str12, str13, str14, str15);
    }
}
