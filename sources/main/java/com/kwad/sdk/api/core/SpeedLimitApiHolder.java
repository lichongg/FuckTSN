package com.kwad.sdk.api.core;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.loader.Loader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SpeedLimitApiHolder {
    private static volatile SpeedLimitApi instance;

    @Nullable
    public static SpeedLimitApi getInstance() {
        if (instance == null) {
            synchronized (SpeedLimitApiHolder.class) {
                try {
                    if (instance == null) {
                        instance = (SpeedLimitApi) Loader.get().newInstance(SpeedLimitApi.class);
                    }
                } finally {
                }
            }
        }
        return instance;
    }
}
