package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdGlobalConfigInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -2622260965144406821L;

    @Nullable
    public AdVideoPreCacheConfig adVideoPreCacheConfig;
    public CycleAggregationInfo cycleAggregationInfo;
    public int neoPageType;
    public NeoScanAggregationSceneInfo neoScanAggregationSceneInfo;
    public boolean uaidEnable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class CycleAggregationInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 6065877559133029298L;
        public int cycleAggregationInterval;
        public boolean cycleAggregationSwitch;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class NeoScanAggregationSceneInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -4381505798843439175L;
        public boolean guidSwipezShowMore;
        public boolean mute;
        public boolean neoCountDownNeedSwipeTrigger;
        public int neoCountDownTime;
        public boolean noActionStopCountDown;
        public int noActionTime;
    }

    public boolean isNeoScan() {
        return this.neoPageType == 1;
    }
}
