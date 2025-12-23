package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMQQMini extends BaseMediaObject {

    /* renamed from: f, reason: collision with root package name */
    private String f42395f;

    /* renamed from: g, reason: collision with root package name */
    private String f42396g;

    /* renamed from: h, reason: collision with root package name */
    private String f42397h;

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
    }

    public String getMiniAppId() {
        return this.f42395f;
    }

    public String getPath() {
        return this.f42396g;
    }

    public String getType() {
        return this.f42397h;
    }

    public void setMiniAppId(String str) {
        this.f42395f = str;
    }

    public void setPath(String str) {
        this.f42396g = str;
    }

    public void setType(String str) {
        this.f42397h = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f42359e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f42355a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f42356b);
        }
        return hashMap;
    }

    public UMQQMini(String str) {
        super(str);
        this.f42395f = "";
        this.f42396g = "";
        this.f42397h = "";
    }
}
