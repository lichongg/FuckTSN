package com.umeng.socialize;

import com.umeng.socialize.bean.SHARE_MEDIA;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface UMShareListener {
    void onCancel(SHARE_MEDIA share_media);

    void onError(SHARE_MEDIA share_media, Throwable th);

    void onResult(SHARE_MEDIA share_media);

    void onStart(SHARE_MEDIA share_media);
}
