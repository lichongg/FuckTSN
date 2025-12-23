package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nEntityInsertAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityInsertAdapter.kt\nandroidx/room/EntityInsertAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n13402#2,2:265\n1863#3,2:267\n*S KotlinDebug\n*F\n+ 1 EntityInsertAdapter.kt\nandroidx/room/EntityInsertAdapter\n*L\n223#1:265,2\n250#1:267,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class EntityInsertAdapter<T> {
    protected abstract void bind(@NotNull SQLiteStatement sQLiteStatement, T t5);

    @NotNull
    protected abstract String createQuery();

    public final void insert(@NotNull SQLiteConnection connection, @Nullable T t5) {
        g0.p(connection, "connection");
        if (t5 == null) {
            return;
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            bind(prepare, t5);
            prepare.step();
            kotlin.jdk7.a.c(prepare, null);
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull SQLiteConnection connection, @Nullable Collection<? extends T> collection) {
        long j6;
        g0.p(connection, "connection");
        if (collection == null) {
            return new long[0];
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            int size = collection.size();
            long[] jArr = new long[size];
            for (int i6 = 0; i6 < size; i6++) {
                Object k22 = f0.k2(collection, i6);
                if (k22 != null) {
                    bind(prepare, k22);
                    prepare.step();
                    prepare.reset();
                    j6 = SQLiteConnectionUtil.getLastInsertedRowId(connection);
                } else {
                    j6 = -1;
                }
                jArr[i6] = j6;
            }
            kotlin.jdk7.a.c(prepare, null);
            return jArr;
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull SQLiteConnection connection, @Nullable Collection<? extends T> collection) {
        long j6;
        g0.p(connection, "connection");
        if (collection == null) {
            return new Long[0];
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i6 = 0; i6 < size; i6++) {
                Object k22 = f0.k2(collection, i6);
                if (k22 != null) {
                    bind(prepare, k22);
                    prepare.step();
                    prepare.reset();
                    j6 = SQLiteConnectionUtil.getLastInsertedRowId(connection);
                } else {
                    j6 = -1;
                }
                lArr[i6] = Long.valueOf(j6);
            }
            kotlin.jdk7.a.c(prepare, null);
            return lArr;
        } finally {
        }
    }

    @NotNull
    public final List<Long> insertAndReturnIdsList(@NotNull SQLiteConnection connection, @Nullable T[] tArr) {
        g0.p(connection, "connection");
        if (tArr == null) {
            return f0.J();
        }
        List j6 = f0.j();
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            for (T t5 : tArr) {
                if (t5 != null) {
                    bind(prepare, t5);
                    prepare.step();
                    prepare.reset();
                    j6.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(connection)));
                } else {
                    j6.add(-1L);
                }
            }
            n1 n1Var = n1.f44123a;
            kotlin.jdk7.a.c(prepare, null);
            return f0.b(j6);
        } finally {
        }
    }

    public final long insertAndReturnId(@NotNull SQLiteConnection connection, @Nullable T t5) {
        g0.p(connection, "connection");
        if (t5 == null) {
            return -1L;
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            bind(prepare, t5);
            prepare.step();
            kotlin.jdk7.a.c(prepare, null);
            return SQLiteConnectionUtil.getLastInsertedRowId(connection);
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void insert(@NotNull SQLiteConnection connection, @Nullable T[] tArr) {
        g0.p(connection, "connection");
        if (tArr == null) {
            return;
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            Iterator a6 = kotlin.jvm.internal.h.a(tArr);
            while (a6.hasNext()) {
                Object next = a6.next();
                if (next != null) {
                    bind(prepare, next);
                    prepare.step();
                    prepare.reset();
                }
            }
            n1 n1Var = n1.f44123a;
            kotlin.jdk7.a.c(prepare, null);
        } finally {
        }
    }

    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull SQLiteConnection connection, @Nullable T[] tArr) {
        long j6;
        g0.p(connection, "connection");
        if (tArr == null) {
            return new long[0];
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            int length = tArr.length;
            long[] jArr = new long[length];
            for (int i6 = 0; i6 < length; i6++) {
                T t5 = tArr[i6];
                if (t5 != null) {
                    bind(prepare, t5);
                    prepare.step();
                    prepare.reset();
                    j6 = SQLiteConnectionUtil.getLastInsertedRowId(connection);
                } else {
                    j6 = -1;
                }
                jArr[i6] = j6;
            }
            kotlin.jdk7.a.c(prepare, null);
            return jArr;
        } finally {
        }
    }

    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull SQLiteConnection connection, @Nullable T[] tArr) {
        long j6;
        g0.p(connection, "connection");
        if (tArr == null) {
            return new Long[0];
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            for (int i6 = 0; i6 < length; i6++) {
                T t5 = tArr[i6];
                if (t5 != null) {
                    bind(prepare, t5);
                    prepare.step();
                    prepare.reset();
                    j6 = SQLiteConnectionUtil.getLastInsertedRowId(connection);
                } else {
                    j6 = -1;
                }
                lArr[i6] = Long.valueOf(j6);
            }
            kotlin.jdk7.a.c(prepare, null);
            return lArr;
        } finally {
        }
    }

    public final void insert(@NotNull SQLiteConnection connection, @Nullable Iterable<? extends T> iterable) {
        g0.p(connection, "connection");
        if (iterable == null) {
            return;
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            for (T t5 : iterable) {
                if (t5 != null) {
                    bind(prepare, t5);
                    prepare.step();
                    prepare.reset();
                }
            }
            n1 n1Var = n1.f44123a;
            kotlin.jdk7.a.c(prepare, null);
        } finally {
        }
    }

    @NotNull
    public final List<Long> insertAndReturnIdsList(@NotNull SQLiteConnection connection, @Nullable Collection<? extends T> collection) {
        g0.p(connection, "connection");
        if (collection == null) {
            return f0.J();
        }
        List j6 = f0.j();
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            for (T t5 : collection) {
                if (t5 != null) {
                    bind(prepare, t5);
                    prepare.step();
                    prepare.reset();
                    j6.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(connection)));
                } else {
                    j6.add(-1L);
                }
            }
            n1 n1Var = n1.f44123a;
            kotlin.jdk7.a.c(prepare, null);
            return f0.b(j6);
        } finally {
        }
    }
}
