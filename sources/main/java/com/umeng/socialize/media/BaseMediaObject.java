package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class BaseMediaObject implements UMediaObject {

    /* renamed from: a, reason: collision with root package name */
    protected String f42355a;

    /* renamed from: b, reason: collision with root package name */
    protected String f42356b;

    /* renamed from: c, reason: collision with root package name */
    protected Map<String, Object> f42357c;

    /* renamed from: d, reason: collision with root package name */
    protected String f42358d;

    /* renamed from: e, reason: collision with root package name */
    protected UMImage f42359e;
    public String mText;

    public BaseMediaObject() {
        this.mText = null;
        this.f42355a = "";
        this.f42356b = "";
        this.f42357c = new HashMap();
        this.f42358d = "";
    }

    public String getDescription() {
        return this.f42358d;
    }

    public UMImage getThumbImage() {
        return this.f42359e;
    }

    public String getTitle() {
        return this.f42356b;
    }

    public Map<String, Object> getmExtra() {
        return this.f42357c;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public boolean isUrlMedia() {
        return !TextUtils.isEmpty(this.f42355a);
    }

    public void setDescription(String str) {
        this.f42358d = str;
    }

    public void setThumb(UMImage uMImage) {
        this.f42359e = uMImage;
    }

    public void setTitle(String str) {
        this.f42356b = str;
    }

    public void setmExtra(String str, Object obj) {
        this.f42357c.put(str, obj);
    }

    public String toString() {
        return "BaseMediaObject [media_url=" + this.f42355a + ", qzone_title=" + this.f42356b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public String toUrl() {
        return this.f42355a;
    }

    public BaseMediaObject(String str) {
        this.mText = null;
        this.f42355a = "";
        this.f42356b = "";
        this.f42357c = new HashMap();
        this.f42358d = "";
        this.f42355a = str;
    }

    protected BaseMediaObject(Parcel parcel) {
        this.mText = null;
        this.f42355a = "";
        this.f42356b = "";
        this.f42357c = new HashMap();
        this.f42358d = "";
        if (parcel != null) {
            this.f42355a = parcel.readString();
            this.f42356b = parcel.readString();
        }
    }
}
