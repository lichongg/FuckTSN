package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Objects {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static final class ToStringHelper {
        private final List zza;
        private final Object zzb;

        @NonNull
        @KeepForSdk
        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzb.getClass().getSimpleName());
            sb.append('{');
            int size = this.zza.size();
            for (int i6 = 0; i6 < size; i6++) {
                sb.append((String) this.zza.get(i6));
                if (i6 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }

        /* synthetic */ ToStringHelper(Object obj, zzai zzaiVar) {
            Preconditions.checkNotNull(obj);
            this.zzb = obj;
            this.zza = new ArrayList();
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public ToStringHelper add(@NonNull String str, @Nullable Object obj) {
            Preconditions.checkNotNull(str);
            this.zza.add(str + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(obj));
            return this;
        }
    }

    @KeepForSdk
    public static boolean checkBundlesEquality(@NonNull Bundle bundle, @NonNull Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> keySet = bundle.keySet();
        if (!keySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!equal(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    @KeepForSdk
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @NonNull
    @KeepForSdk
    public static ToStringHelper toStringHelper(@NonNull Object obj) {
        return new ToStringHelper(obj, null);
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static int hashCode(@NonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
