package com.umeng.socialize.shareboard;

import com.umeng.socialize.bean.SHARE_MEDIA;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SnsPlatform {
    public String mGrayIcon;
    public String mIcon;
    public int mIndex;
    public String mKeyword;
    public SHARE_MEDIA mPlatform;
    public String mShowWord;

    public SnsPlatform(String str) {
        this.mKeyword = str;
        this.mPlatform = SHARE_MEDIA.convertToEmun(str);
    }

    public SnsPlatform() {
    }
}
