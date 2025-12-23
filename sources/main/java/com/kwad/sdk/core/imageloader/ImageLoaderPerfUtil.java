package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ImageLoaderPerfUtil {
    private static final String TAG = "ImageLoaderPerfUtil";

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = ag.QL();
        imageLoaderInfo.successCount = ag.QM();
        imageLoaderInfo.failedCount = ag.QN();
        imageLoaderInfo.duration = ag.QK();
        return imageLoaderInfo;
    }

    public static void report() {
        h.execute(new bg() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            @Override // com.kwad.sdk.utils.bg
            public void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount != 0) {
                    c.d(ImageLoaderPerfUtil.TAG, "ImageLoaderInfo:" + info.toJson().toString());
                    b.r(info);
                    return;
                }
                c.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
            }
        });
    }
}
