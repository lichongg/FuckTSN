package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface TraceListener {
    void onFinished(int i6, List<LatLng> list, int i7, int i8);

    void onRequestFailed(int i6, String str);

    void onTraceProcessing(int i6, int i7, List<LatLng> list);
}
