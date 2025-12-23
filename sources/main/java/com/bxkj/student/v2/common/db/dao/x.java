package com.bxkj.student.v2.common.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Dao
/* loaded from: D:\Downloads\app\classes3.dex */
public interface x {
    @Query("UPDATE sports SET isValid=:isValid WHERE identify=:identify")
    @Nullable
    Object a(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("UPDATE sports SET confirmCount=confirmCount+1 WHERE identify=:identity")
    @Nullable
    Object b(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("UPDATE sports SET isFaceOut=:isFaceOut WHERE identify=:identify")
    @Nullable
    Object c(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime !='' AND confirmCount==0 AND startTime BETWEEN :startTime And :endTime")
    @Nullable
    Object d(@NotNull String str, long j6, long j7, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar);

    @Query("DELETE FROM sports WHERE identify=:identify")
    @Nullable
    Object deleteByIdentify(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("UPDATE sports SET sportsSet=:sportsSet WHERE identify=:identify")
    @Nullable
    Object e(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime !='' AND confirmCount==0")
    @Nullable
    Object f(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar);

    @Query("UPDATE sports SET isException=:isException,isValid=:isValid, endTime=:endTime WHERE identify=:identify")
    @Nullable
    Object g(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime ==''")
    @Nullable
    Object getExceptionSports(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar);

    @Query("SELECT * FROM sports WHERE identify = :identify")
    @Nullable
    Object getLocalRecordById(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar);

    @Query("UPDATE sports SET confirmCount=1 WHERE identify=:identify")
    @Nullable
    Object h(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Insert(onConflict = 1)
    @Nullable
    Object i(@NotNull m0.d[] dVarArr, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("UPDATE sports SET countTime=:countTime,distance=:distance ,gpsDistance=:gpsDistance,latLngList=:latLngList ,stepList=:stepList,passLatLngList=:passLatLngList,isFaceOut=:isFaceOut ,faceDetectCount=:faceDetectCount ,faceCheckingDistance=:faceCheckingDistance,pauseLatLng=:pauseLatLng ,isOpenDevelop=:isOpenDevelop WHERE identify=:identify")
    @Nullable
    Object j(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("UPDATE sports SET endTime=:endTime WHERE identify=:identify")
    @Nullable
    Object k(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND  confirmCount > 0")
    @Nullable
    Object l(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar);

    @Query("SELECT COUNT(identify) as count, sum(distance) AS distance,sum(countTime) AS time FROM sports WHERE userNumber = :userNumber AND endTime !='' AND confirmCount==0 AND startTime BETWEEN :startTime And :endTime")
    @Nullable
    Object m(@NotNull String str, long j6, long j7, @NotNull kotlin.coroutines.e<? super List<l0.a>> eVar);

    @Query("UPDATE sports SET uploadType=:uploadType WHERE identify=:identify")
    @Nullable
    Object n(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar);
}
