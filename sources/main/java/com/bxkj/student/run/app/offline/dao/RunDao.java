package com.bxkj.student.run.app.offline.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.bxkj.student.run.app.offline.table.RunDb;
import java.util.List;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Dao
/* loaded from: D:\Downloads\app\classes3.dex */
public interface RunDao {
    @Query("DELETE FROM runDb WHERE identify=:identify")
    @Nullable
    Object deleteByIdentify(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Delete
    @Nullable
    Object deleteSports(@NotNull RunDb runDb, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("SELECT * FROM runDb WHERE userNumber = :userNumber AND uploadType =='-1'")
    @Nullable
    Object getExceptionSports(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<RunDb>> eVar);

    @Query("SELECT * FROM runDb WHERE identify = :identify")
    @Nullable
    Object getLocalRecordById(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<RunDb>> eVar);

    @Query("SELECT * FROM runDb WHERE userNumber = :userNumber AND uploadType !='-1'")
    @Nullable
    Object getUploadFailSports(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<RunDb>> eVar);

    @Query("SELECT * FROM runDb WHERE userNumber = :userNumber AND uploadType !='-1' AND sportsType=:sportsType")
    @Nullable
    Object getUploadFailSportsByType(@NotNull String str, int i6, @NotNull kotlin.coroutines.e<? super List<RunDb>> eVar);

    @Insert(onConflict = 1)
    @Nullable
    Object insertRun(@NotNull RunDb[] runDbArr, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("UPDATE runDb SET endTime=:endTime,uploadType=:uploadType WHERE identify=:identify")
    @Nullable
    Object updateSports(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull kotlin.coroutines.e<? super n1> eVar);
}
