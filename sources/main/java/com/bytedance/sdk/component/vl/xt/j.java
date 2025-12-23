package com.bytedance.sdk.component.vl.xt;

import android.content.Context;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.bytedance.sdk.component.utils.vl;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f26929j;
    private static final AtomicBoolean xt = new AtomicBoolean(false);

    public static void j(Context context, String str, int i6, String[] strArr, long[] jArr, VideoEventEngineUploader videoEventEngineUploader) {
        if (f26929j) {
            return;
        }
        try {
            TTVideoEngine.setCacheInfoLists(strArr, jArr);
            TTVideoEngine.setStringValue(0, str);
            TTVideoEngine.setIntValue(1, i6);
            TTVideoEngine.setIntValue(11, 5);
            TTVideoEngine.setIntValue(2, 10);
            TTVideoEngine.setIntValue(3, 10);
            TTVideoEngine.setIntValue(4, 3);
            TTVideoEngine.setVideoEventUploader(videoEventEngineUploader);
        } catch (Exception e6) {
            vl.j(e6);
        }
        f26929j = true;
    }

    public static void j(boolean z5) {
        if (z5) {
            TTVideoEngineLog.turnOn(1, 1);
            AVMDLLog.turnOn(1, 1);
        } else {
            TTVideoEngineLog.turnOn(1, 0);
        }
    }

    public static TTVideoEngine j(Context context) {
        if (!xt.getAndSet(true)) {
            TTVideoEngine.startDataLoader(context);
        }
        TTVideoEngine tTVideoEngine = new TTVideoEngine(context, 0);
        tTVideoEngine.setIntOption(160, 1);
        tTVideoEngine.setIntOption(11, 10);
        tTVideoEngine.setIntOption(12, 10);
        tTVideoEngine.setMaxRetryCount(2);
        tTVideoEngine.setScreenOnWhilePlaying(true);
        return tTVideoEngine;
    }
}
