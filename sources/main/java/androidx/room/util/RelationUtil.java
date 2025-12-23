package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* loaded from: D:\Downloads\app\classes.dex */
public final class RelationUtil {
    public static final int MAX_BIND_PARAMETER_CNT = 999;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchArrayMap(@NotNull ArrayMap<K, V> arrayMap, boolean z5, @NotNull Function1<? super ArrayMap<K, V>, n1> function1) {
        RelationUtil__RelationUtil_androidKt.recursiveFetchArrayMap(arrayMap, z5, function1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchHashMap(@NotNull HashMap<K, V> hashMap, boolean z5, @NotNull Function1<? super HashMap<K, V>, n1> function1) {
        RelationUtil__RelationUtil_androidKt.recursiveFetchHashMap(hashMap, z5, function1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <V> void recursiveFetchLongSparseArray(@NotNull LongSparseArray<V> longSparseArray, boolean z5, @NotNull Function1<? super LongSparseArray<V>, n1> function1) {
        RelationUtil__RelationUtilKt.recursiveFetchLongSparseArray(longSparseArray, z5, function1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchMap(@NotNull Map<K, V> map, boolean z5, @NotNull Function1<? super Map<K, V>, n1> function1) {
        RelationUtil__RelationUtilKt.recursiveFetchMap(map, z5, function1);
    }
}
