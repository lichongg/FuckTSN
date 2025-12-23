package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum l {
    NEWS("news", 0),
    IMAGE(SocializeProtocolConstants.IMAGE, 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD(com.umeng.analytics.pro.bi.az, 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);


    /* renamed from: j, reason: collision with root package name */
    String f11070j;

    /* renamed from: k, reason: collision with root package name */
    int f11071k;

    public String b() {
        return this.f11070j;
    }

    public static l b(String str) {
        for (l lVar : values()) {
            if (lVar != null && TextUtils.isEmpty(lVar.f11070j) && lVar.f11070j.equals(str)) {
                return lVar;
            }
        }
        return null;
    }

    public int c() {
        return this.f11071k;
    }

    l(String str, int i6) {
        this.f11070j = str;
        this.f11071k = i6;
    }
}
