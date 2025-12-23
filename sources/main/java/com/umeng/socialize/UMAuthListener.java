package com.umeng.socialize;

import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface UMAuthListener {
    public static final int ACTION_AUTHORIZE = 0;
    public static final int ACTION_DELETE = 1;
    public static final int ACTION_GET_PROFILE = 2;

    void onCancel(SHARE_MEDIA share_media, int i6);

    void onComplete(SHARE_MEDIA share_media, int i6, Map<String, String> map);

    void onError(SHARE_MEDIA share_media, int i6, Throwable th);

    void onStart(SHARE_MEDIA share_media);
}
