package com.bykv.vk.component.ttvideo;

/* loaded from: D:\Downloads\app\classes3.dex */
public class PreloaderURLItem {

    /* renamed from: a, reason: collision with root package name */
    private String f22836a;

    /* renamed from: b, reason: collision with root package name */
    private String f22837b;

    /* renamed from: c, reason: collision with root package name */
    private final String f22838c;

    /* renamed from: d, reason: collision with root package name */
    private final long f22839d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f22840e;

    /* renamed from: f, reason: collision with root package name */
    private IPreLoaderItemCallBackListener f22841f;

    public PreloaderURLItem(String str, String str2, long j6, String[] strArr) {
        this.f22837b = null;
        this.f22841f = null;
        this.f22836a = str;
        this.f22838c = str2;
        this.f22839d = j6;
        this.f22840e = strArr;
    }

    public PreloaderURLItem(String str, String str2, long j6, String[] strArr, String str3) {
        this.f22841f = null;
        this.f22836a = str;
        this.f22837b = str3;
        this.f22838c = str2;
        this.f22839d = j6;
        this.f22840e = strArr;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.f22841f;
    }

    public String getFilePath() {
        return this.f22837b;
    }

    public String getKey() {
        return this.f22836a;
    }

    public long getPreloadSize() {
        return this.f22839d;
    }

    public String[] getUrls() {
        return this.f22840e;
    }

    public String getVideoId() {
        return this.f22838c;
    }

    public void setCallBackListener(IPreLoaderItemCallBackListener iPreLoaderItemCallBackListener) {
        this.f22841f = iPreLoaderItemCallBackListener;
    }

    public void setKey(String str) {
        this.f22836a = str;
    }
}
