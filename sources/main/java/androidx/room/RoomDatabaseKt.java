package androidx.room;

import java.util.Set;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: D:\Downloads\app\classes.dex */
public final class RoomDatabaseKt {
    @Deprecated(message = "Replaced by equivalent API in InvalidationTracker.", replaceWith = @ReplaceWith(expression = "this.invalidationTracker.createFlow(*tables)", imports = {}))
    @NotNull
    public static final kotlinx.coroutines.flow.i<Set<String>> invalidationTrackerFlow(@NotNull RoomDatabase roomDatabase, @NotNull String[] strArr, boolean z5) {
        return RoomDatabaseKt__RoomDatabase_androidKt.invalidationTrackerFlow(roomDatabase, strArr, z5);
    }

    @Nullable
    public static final <R> Object useReaderConnection(@NotNull RoomDatabase roomDatabase, @NotNull Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return RoomDatabaseKt__RoomDatabaseKt.useReaderConnection(roomDatabase, function2, eVar);
    }

    @Nullable
    public static final <R> Object useWriterConnection(@NotNull RoomDatabase roomDatabase, @NotNull Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return RoomDatabaseKt__RoomDatabaseKt.useWriterConnection(roomDatabase, function2, eVar);
    }

    public static final void validateAutoMigrations(@NotNull RoomDatabase roomDatabase, @NotNull DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateAutoMigrations(roomDatabase, databaseConfiguration);
    }

    public static final void validateMigrationsNotRequired(@NotNull Set<Integer> set, @NotNull Set<Integer> set2) {
        RoomDatabaseKt__RoomDatabaseKt.validateMigrationsNotRequired(set, set2);
    }

    public static final void validateTypeConverters(@NotNull RoomDatabase roomDatabase, @NotNull DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateTypeConverters(roomDatabase, databaseConfiguration);
    }

    @Nullable
    public static final <R> Object withTransaction(@NotNull RoomDatabase roomDatabase, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransaction(roomDatabase, function1, eVar);
    }

    @Nullable
    public static final <R> Object withTransactionContext(@NotNull RoomDatabase roomDatabase, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransactionContext(roomDatabase, function1, eVar);
    }
}
