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
public interface q0 {
    @Query("SELECT * FROM sports_set WHERE userId = :userId AND type =:type")
    @Nullable
    Object a(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super List<m0.e>> eVar);

    @Nullable
    Object b(@NotNull String str, @NotNull kotlin.coroutines.e<? super String> eVar);

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull m0.e eVar, @NotNull kotlin.coroutines.e<? super n1> eVar2);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @Deprecated
        @Nullable
        public static Object a(@NotNull q0 q0Var, @NotNull String str, @NotNull kotlin.coroutines.e<? super String> eVar) {
            Object a6;
            a6 = p0.a(q0Var, str, eVar);
            return a6;
        }
    }
}
