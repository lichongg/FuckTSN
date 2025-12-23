package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nInvalidationTracker.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.android.kt\nandroidx/room/ObserverWrapper\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,592:1\n13497#2,3:593\n1755#3,3:596\n1863#3,2:599\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.android.kt\nandroidx/room/ObserverWrapper\n*L\n532#1:593,3\n550#1:596,3\n558#1:599,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ObserverWrapper {

    @NotNull
    private final InvalidationTracker.Observer observer;

    @NotNull
    private final Set<String> singleTableSet;

    @NotNull
    private final int[] tableIds;

    @NotNull
    private final String[] tableNames;

    public ObserverWrapper(@NotNull InvalidationTracker.Observer observer, @NotNull int[] tableIds, @NotNull String[] tableNames) {
        g0.p(observer, "observer");
        g0.p(tableIds, "tableIds");
        g0.p(tableNames, "tableNames");
        this.observer = observer;
        this.tableIds = tableIds;
        this.tableNames = tableNames;
        if (tableIds.length != tableNames.length) {
            throw new IllegalStateException("Check failed.");
        }
        this.singleTableSet = !(tableNames.length == 0) ? u1.f(tableNames[0]) : u1.k();
    }

    @NotNull
    public final InvalidationTracker.Observer getObserver$room_runtime_release() {
        return this.observer;
    }

    @NotNull
    public final int[] getTableIds$room_runtime_release() {
        return this.tableIds;
    }

    public final void notifyByTableIds$room_runtime_release(@NotNull Set<Integer> invalidatedTablesIds) {
        Set<String> k6;
        g0.p(invalidatedTablesIds, "invalidatedTablesIds");
        int[] iArr = this.tableIds;
        int length = iArr.length;
        if (length != 0) {
            int i6 = 0;
            if (length != 1) {
                Set d6 = u1.d();
                int[] iArr2 = this.tableIds;
                int length2 = iArr2.length;
                int i7 = 0;
                while (i6 < length2) {
                    int i8 = i7 + 1;
                    if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i6]))) {
                        d6.add(this.tableNames[i7]);
                    }
                    i6++;
                    i7 = i8;
                }
                k6 = u1.a(d6);
            } else {
                k6 = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.singleTableSet : u1.k();
            }
        } else {
            k6 = u1.k();
        }
        if (k6.isEmpty()) {
            return;
        }
        this.observer.onInvalidated(k6);
    }

    public final void notifyByTableNames$room_runtime_release(@NotNull Set<String> invalidatedTablesNames) {
        Set<String> k6;
        g0.p(invalidatedTablesNames, "invalidatedTablesNames");
        int length = this.tableNames.length;
        if (length == 0) {
            k6 = u1.k();
        } else if (length != 1) {
            Set d6 = u1.d();
            for (String str : invalidatedTablesNames) {
                String[] strArr = this.tableNames;
                int length2 = strArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 < length2) {
                        String str2 = strArr[i6];
                        if (kotlin.text.u.a2(str2, str, true)) {
                            d6.add(str2);
                            break;
                        }
                        i6++;
                    }
                }
            }
            k6 = u1.a(d6);
        } else {
            if (!androidx.activity.k.a(invalidatedTablesNames) || !invalidatedTablesNames.isEmpty()) {
                Iterator<T> it = invalidatedTablesNames.iterator();
                while (it.hasNext()) {
                    if (kotlin.text.u.a2((String) it.next(), this.tableNames[0], true)) {
                        k6 = this.singleTableSet;
                        break;
                    }
                }
            }
            k6 = u1.k();
        }
        if (k6.isEmpty()) {
            return;
        }
        this.observer.onInvalidated(k6);
    }
}
