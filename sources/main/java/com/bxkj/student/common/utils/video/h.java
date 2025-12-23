package com.bxkj.student.common.utils.video;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import com.orhanobut.logger.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h {
    public static Bitmap a(String videoFilePath) {
        if (videoFilePath == null) {
            return null;
        }
        return ThumbnailUtils.createVideoThumbnail(videoFilePath, 2);
    }

    public static long b(String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(path);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        if (extractMetadata == null) {
            extractMetadata = "0";
        }
        j.c("duration=" + extractMetadata);
        return Long.parseLong(extractMetadata);
    }
}
