package cn.jpush.android.data;

import java.io.Serializable;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JPushConfig implements Serializable {
    private static final long serialVersionUID = -3135447319267244288L;

    /* renamed from: a, reason: collision with root package name */
    private String f3612a;

    /* renamed from: b, reason: collision with root package name */
    private String f3613b;

    /* renamed from: c, reason: collision with root package name */
    private String f3614c;

    /* renamed from: d, reason: collision with root package name */
    private String f3615d;

    /* renamed from: e, reason: collision with root package name */
    private String f3616e;

    /* renamed from: f, reason: collision with root package name */
    private String f3617f;

    /* renamed from: g, reason: collision with root package name */
    private String f3618g;

    /* renamed from: h, reason: collision with root package name */
    private String f3619h;

    public String getMzAppId() {
        return this.f3616e;
    }

    public String getMzAppKey() {
        return this.f3617f;
    }

    public String getOppoAppId() {
        return this.f3614c;
    }

    public String getOppoAppKey() {
        return this.f3613b;
    }

    public String getOppoAppSecret() {
        return this.f3615d;
    }

    public String getXmAppId() {
        return this.f3618g;
    }

    public String getXmAppKey() {
        return this.f3619h;
    }

    public String getjAppKey() {
        return this.f3612a;
    }

    public void setMzAppId(String str) {
        this.f3616e = str;
    }

    public void setMzAppKey(String str) {
        this.f3617f = str;
    }

    public void setOppoAppId(String str) {
        this.f3614c = str;
    }

    public void setOppoAppKey(String str) {
        this.f3613b = str;
    }

    public void setOppoAppSecret(String str) {
        this.f3615d = str;
    }

    public void setXmAppId(String str) {
        this.f3618g = str;
    }

    public void setXmAppKey(String str) {
        this.f3619h = str;
    }

    public void setjAppKey(String str) {
        this.f3612a = str;
    }
}
