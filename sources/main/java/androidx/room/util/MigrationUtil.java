package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@JvmName(name = "MigrationUtil")
/* loaded from: D:\Downloads\app\classes.dex */
public final class MigrationUtil {
    public static final boolean contains(@NotNull RoomDatabase.MigrationContainer migrationContainer, int i6, int i7) {
        g0.p(migrationContainer, "<this>");
        Map<Integer, Map<Integer, Migration>> migrations = migrationContainer.getMigrations();
        if (!migrations.containsKey(Integer.valueOf(i6))) {
            return false;
        }
        Map<Integer, Migration> map = migrations.get(Integer.valueOf(i6));
        if (map == null) {
            map = i1.z();
        }
        return map.containsKey(Integer.valueOf(i7));
    }

    @Nullable
    public static final List<Migration> findMigrationPath(@NotNull RoomDatabase.MigrationContainer migrationContainer, int i6, int i7) {
        g0.p(migrationContainer, "<this>");
        if (i6 == i7) {
            return f0.J();
        }
        return findUpMigrationPath(migrationContainer, new ArrayList(), i7 > i6, i6, i7);
    }

    private static final List<Migration> findUpMigrationPath(RoomDatabase.MigrationContainer migrationContainer, List<Migration> list, boolean z5, int i6, int i7) {
        int i8;
        boolean z6;
        while (true) {
            if (z5) {
                if (i6 >= i7) {
                    return list;
                }
            } else if (i6 <= i7) {
                return list;
            }
            Pair<Map<Integer, Migration>, Iterable<Integer>> sortedDescendingNodes$room_runtime_release = z5 ? migrationContainer.getSortedDescendingNodes$room_runtime_release(i6) : migrationContainer.getSortedNodes$room_runtime_release(i6);
            if (sortedDescendingNodes$room_runtime_release == null) {
                return null;
            }
            Map<Integer, Migration> component1 = sortedDescendingNodes$room_runtime_release.component1();
            Iterator<Integer> it = sortedDescendingNodes$room_runtime_release.component2().iterator();
            while (it.hasNext()) {
                i8 = it.next().intValue();
                if (!z5) {
                    if (i7 <= i8 && i8 < i6) {
                        Migration migration = component1.get(Integer.valueOf(i8));
                        g0.m(migration);
                        list.add(migration);
                        z6 = true;
                        break;
                    }
                } else if (i6 + 1 <= i8 && i8 <= i7) {
                    Migration migration2 = component1.get(Integer.valueOf(i8));
                    g0.m(migration2);
                    list.add(migration2);
                    z6 = true;
                    break;
                }
            }
            i8 = i6;
            z6 = false;
            if (!z6) {
                return null;
            }
            i6 = i8;
        }
    }

    public static final boolean isMigrationRequired(@NotNull DatabaseConfiguration databaseConfiguration, int i6, int i7) {
        g0.p(databaseConfiguration, "<this>");
        if (i6 > i7 && databaseConfiguration.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        Set<Integer> migrationNotRequiredFrom$room_runtime_release = databaseConfiguration.getMigrationNotRequiredFrom$room_runtime_release();
        return databaseConfiguration.requireMigration && (migrationNotRequiredFrom$room_runtime_release == null || !migrationNotRequiredFrom$room_runtime_release.contains(Integer.valueOf(i6)));
    }
}
