package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
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
@Deprecated(message = "No longer used by generated code.", replaceWith = @ReplaceWith(expression = "EntityUpsertAdapter", imports = {}))
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nEntityUpsertionAdapter.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityUpsertionAdapter.android.kt\nandroidx/room/EntityUpsertionAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,217:1\n13402#2,2:218\n13402#2,2:222\n1863#3,2:220\n1863#3,2:224\n*S KotlinDebug\n*F\n+ 1 EntityUpsertionAdapter.android.kt\nandroidx/room/EntityUpsertionAdapter\n*L\n73#1:218,2\n145#1:222,2\n84#1:220,2\n159#1:224,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class EntityUpsertionAdapter<T> {

    @NotNull
    private final EntityInsertionAdapter<T> insertionAdapter;

    @NotNull
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public final void upsert(T t5) {
        try {
            this.insertionAdapter.insert((EntityInsertionAdapter<T>) t5);
        } catch (SQLiteConstraintException e6) {
            checkUniquenessException(e6);
            this.updateAdapter.handle(t5);
        }
    }

    @NotNull
    public final long[] upsertAndReturnIdsArray(@NotNull T[] entities) {
        long j6;
        g0.p(entities, "entities");
        int length = entities.length;
        long[] jArr = new long[length];
        for (int i6 = 0; i6 < length; i6++) {
            try {
                j6 = this.insertionAdapter.insertAndReturnId(entities[i6]);
            } catch (SQLiteConstraintException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(entities[i6]);
                j6 = -1;
            }
            jArr[i6] = j6;
        }
        return jArr;
    }

    @NotNull
    public final Long[] upsertAndReturnIdsArrayBox(@NotNull T[] entities) {
        long j6;
        g0.p(entities, "entities");
        int length = entities.length;
        Long[] lArr = new Long[length];
        for (int i6 = 0; i6 < length; i6++) {
            try {
                j6 = this.insertionAdapter.insertAndReturnId(entities[i6]);
            } catch (SQLiteConstraintException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(entities[i6]);
                j6 = -1;
            }
            lArr[i6] = Long.valueOf(j6);
        }
        return lArr;
    }

    @NotNull
    public final List<Long> upsertAndReturnIdsList(@NotNull T[] entities) {
        g0.p(entities, "entities");
        List j6 = f0.j();
        for (T t5 : entities) {
            try {
                j6.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t5)));
            } catch (SQLiteConstraintException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(t5);
                j6.add(-1L);
            }
        }
        return f0.b(j6);
    }

    public EntityUpsertionAdapter(@NotNull EntityInsertionAdapter<T> insertionAdapter, @NotNull EntityDeletionOrUpdateAdapter<T> updateAdapter) {
        g0.p(insertionAdapter, "insertionAdapter");
        g0.p(updateAdapter, "updateAdapter");
        this.insertionAdapter = insertionAdapter;
        this.updateAdapter = updateAdapter;
    }

    public final long upsertAndReturnId(T t5) {
        try {
            return this.insertionAdapter.insertAndReturnId(t5);
        } catch (SQLiteConstraintException e6) {
            checkUniquenessException(e6);
            this.updateAdapter.handle(t5);
            return -1L;
        }
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message != null) {
            if (!kotlin.text.u.i3(message, "unique", true) && !kotlin.text.u.l3(message, "2067", false, 2, null) && !kotlin.text.u.l3(message, "1555", false, 2, null)) {
                throw sQLiteConstraintException;
            }
            return;
        }
        throw sQLiteConstraintException;
    }

    public final void upsert(@NotNull T[] entities) {
        g0.p(entities, "entities");
        for (T t5 : entities) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t5);
            } catch (SQLiteConstraintException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(t5);
            }
        }
    }

    @NotNull
    public final long[] upsertAndReturnIdsArray(@NotNull Collection<? extends T> entities) {
        long j6;
        g0.p(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        long[] jArr = new long[size];
        for (int i6 = 0; i6 < size; i6++) {
            T next = it.next();
            try {
                j6 = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(next);
                j6 = -1;
            }
            jArr[i6] = j6;
        }
        return jArr;
    }

    @NotNull
    public final Long[] upsertAndReturnIdsArrayBox(@NotNull Collection<? extends T> entities) {
        long j6;
        g0.p(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        Long[] lArr = new Long[size];
        for (int i6 = 0; i6 < size; i6++) {
            T next = it.next();
            try {
                j6 = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(next);
                j6 = -1;
            }
            lArr[i6] = Long.valueOf(j6);
        }
        return lArr;
    }

    public final void upsert(@NotNull Iterable<? extends T> entities) {
        g0.p(entities, "entities");
        for (T t5 : entities) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t5);
            } catch (SQLiteConstraintException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(t5);
            }
        }
    }

    @NotNull
    public final List<Long> upsertAndReturnIdsList(@NotNull Collection<? extends T> entities) {
        g0.p(entities, "entities");
        List j6 = f0.j();
        for (T t5 : entities) {
            try {
                j6.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t5)));
            } catch (SQLiteConstraintException e6) {
                checkUniquenessException(e6);
                this.updateAdapter.handle(t5);
                j6.add(-1L);
            }
        }
        return f0.b(j6);
    }
}
