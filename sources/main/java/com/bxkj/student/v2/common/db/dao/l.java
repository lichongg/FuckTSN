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
public interface l {
    @Query("DELETE FROM menu")
    @Nullable
    Object a(@NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("UPDATE menu SET iconS=:iconS WHERE mkey=:mkey")
    @Nullable
    Object b(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("UPDATE menu SET type=:type WHERE mkey=:mkey")
    @Nullable
    Object c(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("DELETE  FROM menu WHERE type=:menuType")
    @Nullable
    Object d(int i6, @NotNull kotlin.coroutines.e<? super Integer> eVar);

    @Query("SELECT * FROM menu WHERE isShowIndex='1' Order By cast(homeSort as INTEGER)")
    @Nullable
    Object e(@NotNull kotlin.coroutines.e<? super List<m0.c>> eVar);

    @Query("SELECT * FROM menu")
    @Nullable
    Object f(@NotNull kotlin.coroutines.e<? super List<m0.c>> eVar);

    @Query("DELETE FROM menu WHERE mkey=:mkey")
    @Nullable
    Object g(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("SELECT * FROM menu WHERE mkey=:mkey")
    @Nullable
    Object h(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.c>> eVar);

    @Query("UPDATE menu SET icon=:icon WHERE mkey=:mkey")
    @Nullable
    Object i(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("SELECT * FROM menu WHERE type=:menuType Order By cast(sort as INTEGER)")
    @Nullable
    Object j(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.c>> eVar);

    @Insert(onConflict = 1)
    @Nullable
    Object k(@NotNull m0.c[] cVarArr, @NotNull kotlin.coroutines.e<? super n1> eVar);
}
