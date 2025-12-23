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
public interface b {
    @Nullable
    Object a(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Query("SELECT * FROM environment WHERE deviceId = :deviceId ")
    @Nullable
    Object b(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.a>> eVar);

    @Query("UPDATE environment SET oppo = :oppo WHERE deviceId = :deviceId")
    @Nullable
    Object c(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super Integer> eVar);

    @Query("UPDATE environment SET safe = :safe WHERE deviceId = :deviceId")
    @Nullable
    Object d(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super Integer> eVar);

    @Nullable
    Object e(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Nullable
    Object f(@NotNull kotlin.coroutines.e<? super m0.a> eVar);

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull m0.a aVar, @NotNull kotlin.coroutines.e<? super n1> eVar);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @Deprecated
        @Nullable
        public static Object a(@NotNull b bVar, @NotNull kotlin.coroutines.e<? super m0.a> eVar) {
            Object a6;
            a6 = com.bxkj.student.v2.common.db.dao.a.a(bVar, eVar);
            return a6;
        }

        @Deprecated
        @Nullable
        public static Object b(@NotNull b bVar, @NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object b6;
            b6 = com.bxkj.student.v2.common.db.dao.a.b(bVar, str, eVar);
            if (b6 == kotlin.coroutines.intrinsics.a.l()) {
                return b6;
            }
            return n1.f44123a;
        }

        @Deprecated
        @Nullable
        public static Object c(@NotNull b bVar, @NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object c6;
            c6 = com.bxkj.student.v2.common.db.dao.a.c(bVar, str, eVar);
            if (c6 == kotlin.coroutines.intrinsics.a.l()) {
                return c6;
            }
            return n1.f44123a;
        }
    }
}
