package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMVideo extends BaseMediaObject {

    /* renamed from: f, reason: collision with root package name */
    private String f42398f;

    /* renamed from: g, reason: collision with root package name */
    private String f42399g;

    /* renamed from: h, reason: collision with root package name */
    private String f42400h;

    /* renamed from: i, reason: collision with root package name */
    private String f42401i;

    /* renamed from: j, reason: collision with root package name */
    private int f42402j;

    /* renamed from: k, reason: collision with root package name */
    private File f42403k;

    public UMVideo(String str) {
        super(str);
    }

    public UMVideo(File file) {
        this.f42403k = file;
    }

    public int getDuration() {
        return this.f42402j;
    }

    public String getH5Url() {
        return this.f42401i;
    }

    public String getHighBandDataUrl() {
        return this.f42400h;
    }

    public File getLocalVideoFile() {
        return this.f42403k;
    }

    public String getLowBandDataUrl() {
        return this.f42399g;
    }

    public String getLowBandUrl() {
        return this.f42398f;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.VEDIO;
    }

    public void setDuration(int i6) {
        this.f42402j = i6;
    }

    public void setH5Url(String str) {
        this.f42401i = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f42400h = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f42399g = str;
    }

    public void setLowBandUrl(String str) {
        this.f42398f = str;
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
        return "UMVedio [media_url=" + this.f42355a + ", qzone_title=" + this.f42356b + ", qzone_thumb=media_url=" + this.f42355a + ", qzone_title=" + this.f42356b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f42355a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }
}
