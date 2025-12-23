package com.google.mlkit.vision.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.ClientPriority;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class MultiFlavorDetectorCreator {
    private final Map zza = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface DetectorCreator<DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> {
        @NonNull
        @KeepForSdk
        DetectorT create(@NonNull OptionsT optionst);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface DetectorOptions<DetectorT> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public interface MultiFlavorDetector {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class Registration {
        private final Class zza;
        private final Provider zzb;

        @ClientPriority
        private final int zzc;

        @KeepForSdk
        public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> Registration(@NonNull Class<? extends OptionsT> cls, @NonNull Provider<? extends DetectorCreator<DetectorT, OptionsT>> provider, @ClientPriority int i6) {
            this.zza = cls;
            this.zzb = provider;
            this.zzc = i6;
        }

        @KeepForSdk
        public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> Registration(@NonNull Class<? extends OptionsT> cls, @NonNull Provider<? extends DetectorCreator<DetectorT, OptionsT>> provider) {
            this(cls, provider, 100);
        }

        @ClientPriority
        final int zza() {
            return this.zzc;
        }

        final Provider zzb() {
            return this.zzb;
        }

        final Class zzc() {
            return this.zza;
        }
    }

    @NonNull
    @KeepForSdk
    public static synchronized MultiFlavorDetectorCreator getInstance() {
        MultiFlavorDetectorCreator multiFlavorDetectorCreator;
        synchronized (MultiFlavorDetectorCreator.class) {
            multiFlavorDetectorCreator = (MultiFlavorDetectorCreator) MlKitContext.getInstance().get(MultiFlavorDetectorCreator.class);
        }
        return multiFlavorDetectorCreator;
    }

    @NonNull
    @KeepForSdk
    public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> DetectorT create(@NonNull OptionsT optionst) {
        return (DetectorT) ((DetectorCreator) ((Provider) Preconditions.checkNotNull((Provider) this.zza.get(optionst.getClass()))).get()).create(optionst);
    }

    MultiFlavorDetectorCreator(Set set) {
        HashMap hashMap = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Registration registration = (Registration) it.next();
            Class zzc = registration.zzc();
            if (!this.zza.containsKey(zzc) || registration.zza() >= ((Integer) Preconditions.checkNotNull((Integer) hashMap.get(zzc))).intValue()) {
                this.zza.put(zzc, registration.zzb());
                hashMap.put(zzc, Integer.valueOf(registration.zza()));
            }
        }
    }
}
