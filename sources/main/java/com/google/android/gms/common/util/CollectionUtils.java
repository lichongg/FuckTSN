package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class CollectionUtils {
    @NonNull
    @Deprecated
    @InlineMe(imports = {"java.util.Collections"}, replacement = "Collections.emptyList()")
    @KeepForSdk
    public static <T> List<T> listOf() {
        return Collections.EMPTY_LIST;
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k6, @NonNull V v5, @NonNull K k7, @NonNull V v6, @NonNull K k8, @NonNull V v7) {
        Map zza = zza(3, false);
        zza.put(k6, v5);
        zza.put(k7, v6);
        zza.put(k8, v7);
        return Collections.unmodifiableMap(zza);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(@NonNull K[] kArr, @NonNull V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        }
        if (length == 0) {
            return Collections.EMPTY_MAP;
        }
        if (length == 1) {
            return Collections.singletonMap(kArr[0], vArr[0]);
        }
        Map zza = zza(length, false);
        for (int i6 = 0; i6 < kArr.length; i6++) {
            zza.put(kArr[i6], vArr[i6]);
        }
        return Collections.unmodifiableMap(zza);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T t5, @NonNull T t6, @NonNull T t7) {
        Set zzb = zzb(3, false);
        zzb.add(t5);
        zzb.add(t6);
        zzb.add(t7);
        return Collections.unmodifiableSet(zzb);
    }

    private static Set zzb(int i6, boolean z5) {
        if (i6 <= (true != z5 ? 256 : 128)) {
            return new ArraySet(i6);
        }
        return new HashSet(i6, true != z5 ? 1.0f : 0.75f);
    }

    @KeepForSdk
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @NonNull
    @Deprecated
    @InlineMe(imports = {"java.util.Collections"}, replacement = "Collections.singletonList(item)")
    @KeepForSdk
    public static <T> List<T> listOf(@NonNull T t5) {
        return Collections.singletonList(t5);
    }

    @NonNull
    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i6) {
        return i6 == 0 ? new ArraySet() : zzb(i6, true);
    }

    private static Map zza(int i6, boolean z5) {
        return i6 <= 256 ? new ArrayMap(i6) : new HashMap(i6, 1.0f);
    }

    private CollectionUtils() {
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.EMPTY_LIST;
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k6, @NonNull V v5, @NonNull K k7, @NonNull V v6, @NonNull K k8, @NonNull V v7, @NonNull K k9, @NonNull V v8, @NonNull K k10, @NonNull V v9, @NonNull K k11, @NonNull V v10) {
        Map zza = zza(6, false);
        zza.put(k6, v5);
        zza.put(k7, v6);
        zza.put(k8, v7);
        zza.put(k9, v8);
        zza.put(k10, v9);
        zza.put(k11, v10);
        return Collections.unmodifiableMap(zza);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.EMPTY_SET;
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t5 = tArr[0];
            T t6 = tArr[1];
            Set zzb = zzb(2, false);
            zzb.add(t5);
            zzb.add(t6);
            return Collections.unmodifiableSet(zzb);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set zzb2 = zzb(length, false);
            Collections.addAll(zzb2, tArr);
            return Collections.unmodifiableSet(zzb2);
        }
        T t7 = tArr[0];
        T t8 = tArr[1];
        T t9 = tArr[2];
        T t10 = tArr[3];
        Set zzb3 = zzb(4, false);
        zzb3.add(t7);
        zzb3.add(t8);
        zzb3.add(t9);
        zzb3.add(t10);
        return Collections.unmodifiableSet(zzb3);
    }
}
