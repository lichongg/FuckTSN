package androidx.room;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import net.sqlcipher.database.SQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class Room {

    @NotNull
    public static final Room INSTANCE = new Room();

    @NotNull
    public static final String LOG_TAG = "ROOM";

    @NotNull
    public static final String MASTER_TABLE_NAME = "room_master_table";

    @JvmStatic
    @NotNull
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(@NotNull Context context, @NotNull Class<T> klass, @Nullable String str) {
        g0.p(context, "context");
        g0.p(klass, "klass");
        if (str == null || kotlin.text.u.M3(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        if (g0.g(str, SQLiteDatabase.MEMORY)) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.Builder<>(context, klass, str);
    }

    public static /* synthetic */ RoomDatabase.Builder databaseBuilder$default(Room room, Context context, String name, Function0 factory, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            g0.w();
            factory = Room$databaseBuilder$3.INSTANCE;
        }
        g0.p(context, "context");
        g0.p(name, "name");
        g0.p(factory, "factory");
        if (kotlin.text.u.M3(name)) {
            throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
        if (g0.g(name, SQLiteDatabase.MEMORY)) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new RoomDatabase.Builder(o0.d(RoomDatabase.class), name, factory, context);
    }

    @JvmStatic
    @NotNull
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@NotNull Context context, @NotNull Class<T> klass) {
        g0.p(context, "context");
        g0.p(klass, "klass");
        return new RoomDatabase.Builder<>(context, klass, null);
    }

    public static /* synthetic */ RoomDatabase.Builder inMemoryDatabaseBuilder$default(Room room, Context context, Function0 factory, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            g0.w();
            factory = Room$inMemoryDatabaseBuilder$1.INSTANCE;
        }
        g0.p(context, "context");
        g0.p(factory, "factory");
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new RoomDatabase.Builder(o0.d(RoomDatabase.class), null, factory, context);
    }

    public final /* synthetic */ <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Function0<? extends T> factory) {
        g0.p(context, "context");
        g0.p(factory, "factory");
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new RoomDatabase.Builder<>(o0.d(RoomDatabase.class), null, factory, context);
    }

    private Room() {
    }

    public final /* synthetic */ <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, String name, Function0<? extends T> factory) {
        g0.p(context, "context");
        g0.p(name, "name");
        g0.p(factory, "factory");
        if (!kotlin.text.u.M3(name)) {
            if (!g0.g(name, SQLiteDatabase.MEMORY)) {
                g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
                return new RoomDatabase.Builder<>(o0.d(RoomDatabase.class), name, factory, context);
            }
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
        throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
    }
}
