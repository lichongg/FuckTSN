package com.bxkj.student.run.app.offline;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.bxkj.student.App;
import com.bxkj.student.run.app.offline.dao.RunDao;
import com.bxkj.student.run.app.offline.table.RunDb;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.s;
import kotlin.t;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Database(entities = {RunDb.class}, exportSchema = true, version = 2)
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class RunDatabase extends RoomDatabase {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String DATABASE_NAME = "TSNRun.db";

    @NotNull
    private static final SupportFactory factory;

    @NotNull
    private static final s<RunDatabase> instance$delegate;

    @NotNull
    private static final byte[] passphrase;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final RunDatabase getInstance() {
            return (RunDatabase) RunDatabase.instance$delegate.getValue();
        }
    }

    @Nullable
    public abstract RunDao runDao();

    static {
        char[] charArray = c0.b.f1042a.k(App.f17573d.a()).toCharArray();
        g0.o(charArray, "toCharArray(...)");
        byte[] bytes = SQLiteDatabase.getBytes(charArray);
        g0.o(bytes, "getBytes(...)");
        passphrase = bytes;
        factory = new SupportFactory(bytes);
        instance$delegate = t.b(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.bxkj.student.run.app.offline.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RunDatabase instance_delegate$lambda$0;
                instance_delegate$lambda$0 = RunDatabase.instance_delegate$lambda$0();
                return instance_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RunDatabase instance_delegate$lambda$0() {
        return (RunDatabase) Room.databaseBuilder(App.f17573d.a(), RunDatabase.class, DATABASE_NAME).openHelperFactory(factory).build();
    }
}
