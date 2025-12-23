package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import net.sqlcipher.database.SQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSupportSQLiteOpenHelper.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SupportSQLiteOpenHelper.android.kt\nandroidx/sqlite/db/SupportSQLiteOpenHelper$Callback\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,366:1\n1#2:367\n1863#3,2:368\n108#4:370\n80#4,22:371\n*S KotlinDebug\n*F\n+ 1 SupportSQLiteOpenHelper.android.kt\nandroidx/sqlite/db/SupportSQLiteOpenHelper$Callback\n*L\n220#1:368,2\n228#1:370\n228#1:371,22\n*E\n"})
    public static abstract class Callback {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final String TAG = "SupportSQLite";

        @JvmField
        public final int version;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            private Companion() {
            }
        }

        public abstract void onCreate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onUpgrade(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, int i6, int i7);

        private final void deleteDatabaseFile(String str) {
            if (u.a2(str, SQLiteDatabase.MEMORY, true)) {
                return;
            }
            int length = str.length() - 1;
            int i6 = 0;
            boolean z5 = false;
            while (i6 <= length) {
                boolean z6 = g0.t(str.charAt(!z5 ? i6 : length), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z6) {
                    i6++;
                } else {
                    z5 = true;
                }
            }
            if (str.subSequence(i6, length + 1).toString().length() == 0) {
                return;
            }
            try {
                android.database.sqlite.SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception unused) {
            }
        }

        public void onConfigure(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
        }

        public void onCorruption(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
            Objects.toString(db);
            if (!db.isOpen()) {
                String path = db.getPath();
                if (path != null) {
                    deleteDatabaseFile(path);
                    return;
                }
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = db.getAttachedDbs();
                } catch (SQLiteException unused) {
                }
                try {
                    db.close();
                } catch (IOException unused2) {
                }
                if (list != null) {
                    return;
                }
            } finally {
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        Object second = ((Pair) it.next()).second;
                        g0.o(second, "second");
                        deleteDatabaseFile((String) second);
                    }
                } else {
                    String path2 = db.getPath();
                    if (path2 != null) {
                        deleteDatabaseFile(path2);
                    }
                }
            }
        }

        public void onDowngrade(@NotNull SupportSQLiteDatabase db, int i6, int i7) {
            g0.p(db, "db");
            throw new SQLiteException("Can't downgrade database from version " + i6 + " to " + i7);
        }

        public void onOpen(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
        }

        public Callback(int i6) {
            this.version = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Configuration {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        public final boolean allowDataLossOnRecovery;

        @JvmField
        @NotNull
        public final Callback callback;

        @JvmField
        @NotNull
        public final Context context;

        @JvmField
        @Nullable
        public final String name;

        @JvmField
        public final boolean useNoBackupDirectory;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nSupportSQLiteOpenHelper.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SupportSQLiteOpenHelper.android.kt\nandroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,366:1\n1#2:367\n*E\n"})
        public static class Builder {
            private boolean allowDataLossOnRecovery;

            @Nullable
            private Callback callback;

            @NotNull
            private final Context context;

            @Nullable
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(@NotNull Context context) {
                g0.p(context, "context");
                this.context = context;
            }

            @NotNull
            public Builder allowDataLossOnRecovery(boolean z5) {
                this.allowDataLossOnRecovery = z5;
                return this;
            }

            @NotNull
            public Configuration build() {
                String str;
                Callback callback = this.callback;
                if (callback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.useNoBackupDirectory && ((str = this.name) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new Configuration(this.context, this.name, callback, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
            }

            @NotNull
            public Builder callback(@NotNull Callback callback) {
                g0.p(callback, "callback");
                this.callback = callback;
                return this;
            }

            @NotNull
            public Builder name(@Nullable String str) {
                this.name = str;
                return this;
            }

            @NotNull
            public Builder noBackupDirectory(boolean z5) {
                this.useNoBackupDirectory = z5;
                return this;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Builder builder(@NotNull Context context) {
                g0.p(context, "context");
                return new Builder(context);
            }
        }

        public Configuration(@NotNull Context context, @Nullable String str, @NotNull Callback callback, boolean z5, boolean z6) {
            g0.p(context, "context");
            g0.p(callback, "callback");
            this.context = context;
            this.name = str;
            this.callback = callback;
            this.useNoBackupDirectory = z5;
            this.allowDataLossOnRecovery = z6;
        }

        @JvmStatic
        @NotNull
        public static final Builder builder(@NotNull Context context) {
            return Companion.builder(context);
        }

        public /* synthetic */ Configuration(Context context, String str, Callback callback, boolean z5, boolean z6, int i6, v vVar) {
            this(context, str, callback, (i6 & 8) != 0 ? false : z5, (i6 & 16) != 0 ? false : z6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Factory {
        @NotNull
        SupportSQLiteOpenHelper create(@NotNull Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Nullable
    String getDatabaseName();

    @NotNull
    SupportSQLiteDatabase getReadableDatabase();

    @NotNull
    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z5);
}
