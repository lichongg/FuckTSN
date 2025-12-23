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
public interface g {
    @Query("DELETE FROM face")
    @Nullable
    Object a(@NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("SELECT * FROM face WHERE identify=:identify")
    @Nullable
    Object b(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.b>> eVar);

    @Query("DELETE FROM face WHERE identify=:identify")
    @Nullable
    Object deleteByIdentify(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull m0.b bVar, @NotNull kotlin.coroutines.e<? super n1> eVar);
}
