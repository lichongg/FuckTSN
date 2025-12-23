package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.Iterator;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class EntityDeleteOrUpdateAdapter<T> {
    protected abstract void bind(@NotNull SQLiteStatement sQLiteStatement, T t5);

    @NotNull
    protected abstract String createQuery();

    public final int handleMultiple(@NotNull SQLiteConnection connection, @Nullable Iterable<? extends T> iterable) {
        g0.p(connection, "connection");
        int i6 = 0;
        if (iterable == null) {
            return 0;
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            for (T t5 : iterable) {
                if (t5 != null) {
                    bind(prepare, t5);
                    prepare.step();
                    prepare.reset();
                    i6 += SQLiteConnectionUtil.getTotalChangedRows(connection);
                }
            }
            n1 n1Var = n1.f44123a;
            kotlin.jdk7.a.c(prepare, null);
            return i6;
        } finally {
        }
    }

    public final int handle(@NotNull SQLiteConnection connection, @Nullable T t5) {
        g0.p(connection, "connection");
        if (t5 == null) {
            return 0;
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            bind(prepare, t5);
            prepare.step();
            kotlin.jdk7.a.c(prepare, null);
            return SQLiteConnectionUtil.getTotalChangedRows(connection);
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int handleMultiple(@NotNull SQLiteConnection connection, @Nullable T[] tArr) {
        g0.p(connection, "connection");
        int i6 = 0;
        if (tArr == null) {
            return 0;
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
                    i6 += SQLiteConnectionUtil.getTotalChangedRows(connection);
                }
            }
            n1 n1Var = n1.f44123a;
            kotlin.jdk7.a.c(prepare, null);
            return i6;
        } finally {
        }
    }
}
