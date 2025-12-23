package com.hw.videoprocessor;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaMetadataRetriever;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f {
    public static void a(Context context, String str, String str2, @Nullable Integer num, float f6, int i6) throws Exception {
        String str3;
        Integer num2;
        List<File> l6;
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(context.getCacheDir(), "kichiku_" + System.currentTimeMillis());
        file.mkdir();
        if (num == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            str3 = str;
            mediaMetadataRetriever.setDataSource(str3);
            Integer valueOf = Integer.valueOf(Integer.parseInt(mediaMetadataRetriever.extractMetadata(20)));
            mediaMetadataRetriever.release();
            num2 = valueOf;
        } else {
            str3 = str;
            num2 = num;
        }
        int d6 = i.d(str3);
        try {
            com.hw.videoprocessor.util.c.t("切割视频+", new Object[0]);
            l6 = i.l(context, str3, file.getAbsolutePath(), i6, 500, Integer.valueOf(d6), f6, 0);
        } catch (MediaCodec.CodecException e6) {
            com.hw.videoprocessor.util.c.g(e6);
            l6 = i.l(context, str, file.getAbsolutePath(), i6, 500, Integer.valueOf(d6), f6, -1);
        }
        com.hw.videoprocessor.util.c.t("切割视频-", new Object[0]);
        com.hw.videoprocessor.util.c.t("合并视频+", new Object[0]);
        i.b(l6, str2, num2, 1);
        com.hw.videoprocessor.util.c.t("合并视频-", new Object[0]);
        long currentTimeMillis2 = System.currentTimeMillis();
        com.hw.videoprocessor.util.c.f("鬼畜已完成,耗时:" + ((currentTimeMillis2 - currentTimeMillis) / 1000.0f) + "s", new Object[0]);
    }
}
