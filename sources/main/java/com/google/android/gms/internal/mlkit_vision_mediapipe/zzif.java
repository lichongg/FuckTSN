package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzif {
    private final Map zza = new HashMap();

    public final String zza(Class cls) {
        return (String) this.zza.get(cls);
    }

    public final void zzb(Class cls, String str) {
        if (this.zza.containsKey(cls) && !((String) this.zza.get(cls)).equals("drishti.InferenceCalculatorOptions.Delegate")) {
            throw new zzhu(zzht.ALREADY_EXISTS.ordinal(), "Protobuf type name: drishti.InferenceCalculatorOptions.Delegate conflicts with: ".concat(String.valueOf((String) this.zza.get(cls))));
        }
        this.zza.put(cls, "drishti.InferenceCalculatorOptions.Delegate");
    }

    zzif() {
    }
}
