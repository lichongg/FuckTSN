package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(message = "No longer used by generated code.", replaceWith = @ReplaceWith(expression = "EntityInsertAdapter", imports = {}))
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nEntityInsertionAdapter.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityInsertionAdapter.android.kt\nandroidx/room/EntityInsertionAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,231:1\n13402#2,2:232\n13467#2,3:239\n13402#2,2:242\n1863#3,2:234\n1872#3,3:236\n1863#3,2:244\n*S KotlinDebug\n*F\n+ 1 EntityInsertionAdapter.android.kt\nandroidx/room/EntityInsertionAdapter\n*L\n65#1:232,2\n137#1:239,3\n201#1:242,2\n82#1:234,2\n117#1:236,3\n221#1:244,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    protected abstract void bind(@NotNull SupportSQLiteStatement supportSQLiteStatement, T t5);

    public final void insert(T t5) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t5);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull Collection<? extends T> entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            int i6 = 0;
            for (T t5 : entities) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    f0.b0();
                }
                bind(acquire, t5);
                jArr[i6] = acquire.executeInsert();
                i6 = i7;
            }
            release(acquire);
            return jArr;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull Collection<? extends T> entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator<? extends T> it = entities.iterator();
        try {
            int size = entities.size();
            Long[] lArr = new Long[size];
            for (int i6 = 0; i6 < size; i6++) {
                bind(acquire, it.next());
                lArr[i6] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    @NotNull
    public final List<Long> insertAndReturnIdsList(@NotNull T[] entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List j6 = f0.j();
            for (T t5 : entities) {
                bind(acquire, t5);
                j6.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> b6 = f0.b(j6);
            release(acquire);
            return b6;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(@NotNull RoomDatabase database) {
        super(database);
        g0.p(database, "database");
    }

    public final long insertAndReturnId(T t5) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t5);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final void insert(@NotNull T[] entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t5 : entities) {
                bind(acquire, t5);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull T[] entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int length = entities.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                int i8 = i7 + 1;
                bind(acquire, entities[i6]);
                jArr[i7] = acquire.executeInsert();
                i6++;
                i7 = i8;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull T[] entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator a6 = kotlin.jvm.internal.h.a(entities);
        try {
            int length = entities.length;
            Long[] lArr = new Long[length];
            for (int i6 = 0; i6 < length; i6++) {
                bind(acquire, a6.next());
                lArr[i6] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    @NotNull
    public final List<Long> insertAndReturnIdsList(@NotNull Collection<? extends T> entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List j6 = f0.j();
            Iterator<T> it = entities.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                j6.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> b6 = f0.b(j6);
            release(acquire);
            return b6;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(@NotNull Iterable<? extends T> entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            Iterator<? extends T> it = entities.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }
}
