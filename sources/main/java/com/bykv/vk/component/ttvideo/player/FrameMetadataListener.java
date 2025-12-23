package com.bykv.vk.component.ttvideo.player;

import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface FrameMetadataListener {
    void frameDTSNotify(int i6, long j6, long j7);

    void onFrameAboutToBeRendered(int i6, long j6, long j7, Map<Integer, String> map);

    void updateFrameTerminatedDTS(int i6, long j6, long j7);
}
