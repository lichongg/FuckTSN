package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMusic extends BaseMediaObject {

    /* renamed from: f, reason: collision with root package name */
    private String f42404f;

    /* renamed from: g, reason: collision with root package name */
    private String f42405g;

    /* renamed from: h, reason: collision with root package name */
    private String f42406h;

    /* renamed from: i, reason: collision with root package name */
    private String f42407i;

    /* renamed from: j, reason: collision with root package name */
    private int f42408j;

    /* renamed from: k, reason: collision with root package name */
    private String f42409k;

    public UMusic(String str) {
        super(str);
    }

    protected UMusic(Parcel parcel) {
        super(parcel);
    }

    public int getDuration() {
        return this.f42408j;
    }

    public String getH5Url() {
        return this.f42406h;
    }

    public String getHighBandDataUrl() {
        return this.f42405g;
    }

    public String getLowBandDataUrl() {
        return this.f42404f;
    }

    public String getLowBandUrl() {
        return this.f42407i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.MUSIC;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f42359e;
    }

    public String getmTargetUrl() {
        return this.f42409k;
    }

    public void setDuration(int i6) {
        this.f42408j = i6;
    }

    public void setH5Url(String str) {
        this.f42406h = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f42405g = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f42404f = str;
    }

    public void setLowBandUrl(String str) {
        this.f42407i = str;
    }

    public void setmTargetUrl(String str) {
        this.f42409k = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f42359e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public String toString() {
        return "UMusic [title=" + this.f42356b + "media_url=" + this.f42355a + ", qzone_title=" + this.f42356b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f42355a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f42356b);
        }
        return hashMap;
    }
}
