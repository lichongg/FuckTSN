package com.amap.api.services.core;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SuggestionCity {

    /* renamed from: a, reason: collision with root package name */
    private String f9246a;

    /* renamed from: b, reason: collision with root package name */
    private String f9247b;

    /* renamed from: c, reason: collision with root package name */
    private String f9248c;

    /* renamed from: d, reason: collision with root package name */
    private int f9249d;

    protected SuggestionCity() {
    }

    public SuggestionCity(String str, String str2, String str3, int i6) {
        this.f9246a = str;
        this.f9247b = str2;
        this.f9248c = str3;
        this.f9249d = i6;
    }

    public String getAdCode() {
        return this.f9248c;
    }

    public String getCityCode() {
        return this.f9247b;
    }

    public String getCityName() {
        return this.f9246a;
    }

    public int getSuggestionNum() {
        return this.f9249d;
    }

    public void setAdCode(String str) {
        this.f9248c = str;
    }

    public void setCityCode(String str) {
        this.f9247b = str;
    }

    public void setCityName(String str) {
        this.f9246a = str;
    }

    public void setSuggestionNum(int i6) {
        this.f9249d = i6;
    }
}
