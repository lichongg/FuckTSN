package com.baidu.idl.face.platform;

import android.graphics.Rect;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface ILivenessStrategy {
    void livenessStrategy(byte[] bArr);

    void reset();

    void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, ILivenessStrategyCallback iLivenessStrategyCallback);

    void setLivenessStrategySoundEnable(boolean z5);

    void setPreviewDegree(int i6);
}
