package androidx.room;

import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import java.util.Collection;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nEntityUpsertAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityUpsertAdapter.kt\nandroidx/room/EntityUpsertAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,238:1\n13402#2,2:239\n13402#2,2:243\n1863#3,2:241\n1863#3,2:245\n*S KotlinDebug\n*F\n+ 1 EntityUpsertAdapter.kt\nandroidx/room/EntityUpsertAdapter\n*L\n61#1:239,2\n139#1:243,2\n73#1:241,2\n157#1:245,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class EntityUpsertAdapter<T> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String ErrorMsg = "unique";

    @NotNull
    private static final String SQLITE_CONSTRAINT_PRIMARYKEY = "1555";

    @NotNull
    private static final String SQLITE_CONSTRAINT_UNIQUE = "2067";

    @NotNull
    private final EntityInsertAdapter<T> entityInsertAdapter;

    @NotNull
    private final EntityDeleteOrUpdateAdapter<T> updateAdapter;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
            this();
        }

        private Companion() {
        }
    }

    public final void upsert(@NotNull SQLiteConnection connection, @Nullable T t5) {
        g0.p(connection, "connection");
        try {
            this.entityInsertAdapter.insert(connection, (SQLiteConnection) t5);
        } catch (SQLException e6) {
            checkUniquenessException(e6);
            this.updateAdapter.handle(connection, t5);
        }
    }

    @NotNull
    public final long[] upsertAndReturnIdsArray(@NotNull SQLiteConnection connection, @Nullable T[] tArr) {
        long j6;
        g0.p(connection, "connection");
        if (tArr == null) {
            return new long[0];
        }
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i6 = 0; i6 < length; i6++) {
            try {
                j6 = this.entityInsertAdapter.insertAndReturnId(connection, tArr[i6]);
            } catch (SQLException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(connection, tArr[i6]);
                j6 = -1;
            }
            jArr[i6] = j6;
        }
        return jArr;
    }

    @NotNull
    public final Long[] upsertAndReturnIdsArrayBox(@NotNull SQLiteConnection connection, @Nullable T[] tArr) {
        long j6;
        g0.p(connection, "connection");
        if (tArr == null) {
            return new Long[0];
        }
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i6 = 0; i6 < length; i6++) {
            try {
                j6 = this.entityInsertAdapter.insertAndReturnId(connection, tArr[i6]);
            } catch (SQLException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(connection, tArr[i6]);
                j6 = -1;
            }
            lArr[i6] = Long.valueOf(j6);
        }
        return lArr;
    }

    @NotNull
    public final List<Long> upsertAndReturnIdsList(@NotNull SQLiteConnection connection, @Nullable T[] tArr) {
        g0.p(connection, "connection");
        if (tArr == null) {
            return f0.J();
        }
        List j6 = f0.j();
        for (T t5 : tArr) {
            try {
                j6.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(connection, t5)));
            } catch (SQLException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(connection, t5);
                j6.add(-1L);
            }
        }
        return f0.b(j6);
    }

    public EntityUpsertAdapter(@NotNull EntityInsertAdapter<T> entityInsertAdapter, @NotNull EntityDeleteOrUpdateAdapter<T> updateAdapter) {
        g0.p(entityInsertAdapter, "entityInsertAdapter");
        g0.p(updateAdapter, "updateAdapter");
        this.entityInsertAdapter = entityInsertAdapter;
        this.updateAdapter = updateAdapter;
    }

    public final long upsertAndReturnId(@NotNull SQLiteConnection connection, @Nullable T t5) {
        g0.p(connection, "connection");
        try {
            return this.entityInsertAdapter.insertAndReturnId(connection, t5);
        } catch (SQLException e6) {
            checkUniquenessException(e6);
            this.updateAdapter.handle(connection, t5);
            return -1L;
        }
    }

    private final void checkUniquenessException(SQLException sQLException) {
        String message = sQLException.getMessage();
        if (message != null) {
            if (!kotlin.text.u.i3(message, ErrorMsg, true) && !kotlin.text.u.l3(message, SQLITE_CONSTRAINT_UNIQUE, false, 2, null) && !kotlin.text.u.l3(message, SQLITE_CONSTRAINT_PRIMARYKEY, false, 2, null)) {
                throw sQLException;
            }
            return;
        }
        throw sQLException;
    }

    public final void upsert(@NotNull SQLiteConnection connection, @Nullable T[] tArr) {
        g0.p(connection, "connection");
        if (tArr == null) {
            return;
        }
        for (T t5 : tArr) {
            try {
                this.entityInsertAdapter.insert(connection, (SQLiteConnection) t5);
            } catch (SQLException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(connection, t5);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final long[] upsertAndReturnIdsArray(@NotNull SQLiteConnection connection, @Nullable Collection<? extends T> collection) {
        long j6;
        g0.p(connection, "connection");
        if (collection == null) {
            return new long[0];
        }
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i6 = 0; i6 < size; i6++) {
            try {
                j6 = this.entityInsertAdapter.insertAndReturnId(connection, f0.k2(collection, i6));
            } catch (SQLException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(connection, f0.k2(collection, i6));
                j6 = -1;
            }
            jArr[i6] = j6;
        }
        return jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Long[] upsertAndReturnIdsArrayBox(@NotNull SQLiteConnection connection, @Nullable Collection<? extends T> collection) {
        long j6;
        g0.p(connection, "connection");
        if (collection == null) {
            return new Long[0];
        }
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i6 = 0; i6 < size; i6++) {
            try {
                j6 = this.entityInsertAdapter.insertAndReturnId(connection, f0.k2(collection, i6));
            } catch (SQLException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(connection, f0.k2(collection, i6));
                j6 = -1;
            }
            lArr[i6] = Long.valueOf(j6);
        }
        return lArr;
    }

    public final void upsert(@NotNull SQLiteConnection connection, @Nullable Iterable<? extends T> iterable) {
        g0.p(connection, "connection");
        if (iterable == null) {
            return;
        }
        for (T t5 : iterable) {
            try {
                this.entityInsertAdapter.insert(connection, (SQLiteConnection) t5);
            } catch (SQLException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(connection, t5);
            }
        }
    }

    @NotNull
    public final List<Long> upsertAndReturnIdsList(@NotNull SQLiteConnection connection, @Nullable Collection<? extends T> collection) {
        g0.p(connection, "connection");
        if (collection == null) {
            return f0.J();
        }
        List j6 = f0.j();
        for (T t5 : collection) {
            try {
                j6.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(connection, t5)));
            } catch (SQLException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(connection, t5);
                j6.add(-1L);
            }
        }
        return f0.b(j6);
    }
}
