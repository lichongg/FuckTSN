package com.google.mlkit.acceleration.internal;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_acceleration.zzaf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public interface AcceleratableDetectorOptions<OptionsT> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class KeyValueDecoder {
        private final Map zza;

        @Nullable
        private static Integer zza(@Nullable String str) {
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                if (Log.isLoggable("AcceleratableOptions", 3)) {
                    "Value cannot be parsed to int: ".concat(str);
                }
                return null;
            }
        }

        @NonNull
        @KeepForSdk
        public static KeyValueDecoder newInstance(@NonNull String str) {
            return new KeyValueDecoder(str);
        }

        @Nullable
        @KeepForSdk
        public String getString(@NonNull String str) {
            return (String) this.zza.get(str);
        }

        private KeyValueDecoder(String str) {
            this.zza = zzaf.zzd(" && ").zzc().zzb(" == ").zza(str);
        }

        @Nullable
        @KeepForSdk
        public Boolean getBoolean(@NonNull String str) {
            String string = getString(str);
            if (string != null) {
                Boolean bool = Boolean.TRUE;
                if (bool.toString().equals(string)) {
                    return bool;
                }
                Boolean bool2 = Boolean.FALSE;
                if (bool2.toString().equals(string)) {
                    return bool2;
                }
                return null;
            }
            return null;
        }

        @Nullable
        @KeepForSdk
        public Integer getInt(@NonNull String str) {
            return zza(getString(str));
        }

        @Nullable
        @KeepForSdk
        public int[] getIntArray(@NonNull String str) {
            String string = getString(str);
            if (string == null) {
                return null;
            }
            Iterable zzf = zzaf.zzd(" , ").zze(com.google.android.gms.internal.mlkit_acceleration.zzp.zzb()).zzc().zzf(string);
            ArrayList arrayList = new ArrayList();
            Iterator it = zzf.iterator();
            while (it.hasNext()) {
                Integer zza = zza((String) it.next());
                if (zza == null) {
                    return null;
                }
                arrayList.add(zza);
            }
            Object[] array = arrayList.toArray();
            int length = array.length;
            int[] iArr = new int[length];
            for (int i6 = 0; i6 < length; i6++) {
                Object obj = array[i6];
                obj.getClass();
                iArr[i6] = ((Number) obj).intValue();
            }
            return iArr;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class KeyValueEncoder {
        private final List zza = new ArrayList();

        @NonNull
        @KeepForSdk
        public static KeyValueEncoder newInstance() {
            return new KeyValueEncoder();
        }

        @NonNull
        @KeepForSdk
        public KeyValueEncoder addBoolean(@NonNull String str, boolean z5) {
            StringBuilder sb = new StringBuilder();
            sb.append(z5);
            addString(str, sb.toString());
            return this;
        }

        @NonNull
        @KeepForSdk
        public KeyValueEncoder addInt(@NonNull String str, int i6) {
            StringBuilder sb = new StringBuilder();
            sb.append(i6);
            addString(str, sb.toString());
            return this;
        }

        @NonNull
        @KeepForSdk
        public KeyValueEncoder addIntArray(@NonNull String str, @Nullable int[] iArr) {
            if (iArr == null) {
                return this;
            }
            StringBuilder sb = new StringBuilder();
            for (int i6 : iArr) {
                sb.append(i6);
                sb.append(" , ");
            }
            addString(str, sb.toString());
            return this;
        }

        @NonNull
        @KeepForSdk
        public KeyValueEncoder addString(@NonNull String str, @Nullable String str2) {
            if (str2 != null) {
                this.zza.add(new Pair(str, str2));
            }
            return this;
        }

        @NonNull
        @KeepForSdk
        public String encode() {
            StringBuilder sb = new StringBuilder();
            for (Pair pair : this.zza) {
                sb.append((String) pair.first);
                sb.append(" == ");
                sb.append((String) pair.second);
                sb.append(" && ");
            }
            return sb.toString();
        }
    }

    @NonNull
    @KeepForSdk
    OptionsT cloneWithRunConfigAssigned(@NonNull String str, boolean z5);

    @NonNull
    @KeepForSdk
    OptionsT decode(@NonNull String str);

    @NonNull
    @KeepForSdk
    String encode();

    @NonNull
    @KeepForSdk
    int[] getPreferredHardwareConfigs();

    @Nullable
    @KeepForSdk
    String getRunConfigName();

    @KeepForSdk
    boolean isForBenchmark();
}
