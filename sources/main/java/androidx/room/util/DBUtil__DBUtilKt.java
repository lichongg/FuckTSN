package androidx.room.util;

import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.room.PooledConnection;
import androidx.room.RoomDatabase;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.coroutines.e;
import kotlin.jdk7.a;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDBUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DBUtil.kt\nandroidx/room/util/DBUtil__DBUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1863#2,2:169\n*S KotlinDebug\n*F\n+ 1 DBUtil.kt\nandroidx/room/util/DBUtil__DBUtilKt\n*L\n106#1:169,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
final /* synthetic */ class DBUtil__DBUtilKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(@NotNull SQLiteConnection connection) {
        g0.p(connection, "connection");
        List j6 = f0.j();
        SQLiteStatement prepare = connection.prepare("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (prepare.step()) {
            try {
                j6.add(prepare.getText(0));
            } finally {
            }
        }
        n1 n1Var = n1.f44123a;
        a.c(prepare, null);
        for (String str : f0.b(j6)) {
            if (u.H2(str, "room_fts_content_sync_", false, 2, null)) {
                SQLite.execSQL(connection, "DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(@NotNull SQLiteConnection db, @NotNull String tableName) {
        g0.p(db, "db");
        g0.p(tableName, "tableName");
        SQLiteStatement prepare = db.prepare("PRAGMA foreign_key_check(`" + tableName + "`)");
        try {
            if (prepare.step()) {
                throw new SQLException(processForeignKeyCheckFailure$DBUtil__DBUtilKt(prepare));
            }
            n1 n1Var = n1.f44123a;
            a.c(prepare, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a.c(prepare, th);
                throw th2;
            }
        }
    }

    @Nullable
    public static final <R> Object internalPerform(@NotNull RoomDatabase roomDatabase, boolean z5, boolean z6, @NotNull Function2<? super PooledConnection, ? super e<? super R>, ? extends Object> function2, @NotNull e<? super R> eVar) {
        return roomDatabase.useConnection$room_runtime_release(z5, new DBUtil__DBUtilKt$internalPerform$2(z6, z5, roomDatabase, function2, null), eVar);
    }

    private static final <R> Object internalPerform$$forInline(RoomDatabase roomDatabase, boolean z5, boolean z6, Function2<? super PooledConnection, ? super e<? super R>, ? extends Object> function2, e<? super R> eVar) {
        DBUtil__DBUtilKt$internalPerform$2 dBUtil__DBUtilKt$internalPerform$2 = new DBUtil__DBUtilKt$internalPerform$2(z6, z5, roomDatabase, function2, null);
        d0.e(0);
        Object useConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(z5, dBUtil__DBUtilKt$internalPerform$2, eVar);
        d0.e(1);
        return useConnection$room_runtime_release;
    }

    private static final String processForeignKeyCheckFailure$DBUtil__DBUtilKt(SQLiteStatement sQLiteStatement) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i6 = 0;
        do {
            if (i6 == 0) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(sQLiteStatement.getText(0));
                sb.append("'.\n");
            }
            String text = sQLiteStatement.getText(3);
            if (!linkedHashMap.containsKey(text)) {
                linkedHashMap.put(text, sQLiteStatement.getText(2));
            }
            i6++;
        } while (sQLiteStatement.step());
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append(com.snail.antifake.deviceid.e.f37542d);
        sb.append("Number of rows in violation: ");
        sb.append(i6);
        sb.append(com.snail.antifake.deviceid.e.f37542d);
        sb.append("Violation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            sb.append("\tParent Table = ");
            sb.append(str2);
            sb.append(", Foreign Key Constraint Index = ");
            sb.append(str);
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        return sb.toString();
    }
}
