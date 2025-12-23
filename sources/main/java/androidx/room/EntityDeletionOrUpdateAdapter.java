package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(message = "No longer used by generated code.", replaceWith = @ReplaceWith(expression = "EntityDeleteOrUpdateAdapter", imports = {}))
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nEntityDeletionOrUpdateAdapter.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityDeletionOrUpdateAdapter.android.kt\nandroidx/room/EntityDeletionOrUpdateAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,105:1\n1863#2,2:106\n13402#3,2:108\n*S KotlinDebug\n*F\n+ 1 EntityDeletionOrUpdateAdapter.android.kt\nandroidx/room/EntityDeletionOrUpdateAdapter\n*L\n75#1:106,2\n95#1:108,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    protected abstract void bind(@NotNull SupportSQLiteStatement supportSQLiteStatement, T t5);

    @Override // androidx.room.SharedSQLiteStatement
    @NotNull
    protected abstract String createQuery();

    public final int handleMultiple(@NotNull Iterable<? extends T> entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            Iterator<? extends T> it = entities.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                bind(acquire, it.next());
                i6 += acquire.executeUpdateDelete();
            }
            return i6;
        } finally {
            release(acquire);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityDeletionOrUpdateAdapter(@NotNull RoomDatabase database) {
        super(database);
        g0.p(database, "database");
    }

    public final int handle(T t5) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t5);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(@NotNull T[] entities) {
        g0.p(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            int i6 = 0;
            for (T t5 : entities) {
                bind(acquire, t5);
                i6 += acquire.executeUpdateDelete();
            }
            return i6;
        } finally {
            release(acquire);
        }
    }
}
