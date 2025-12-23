package com.google.research.xeno.effect;

import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class AssetRegistry {
    private final long zza;

    public AssetRegistry() {
        this(null);
    }

    private native long nativeCreateAssetRegistry();

    private native void nativeRegisterAsset(long j6, String str, String str2);

    public AssetRegistry(@Nullable Map map) {
        this.zza = nativeCreateAssetRegistry();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                nativeRegisterAsset(this.zza, (String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public final long zza() {
        return this.zza;
    }
}
