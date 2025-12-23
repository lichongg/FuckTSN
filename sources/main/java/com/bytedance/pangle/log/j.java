package com.bytedance.pangle.log;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f25397j;

    /* renamed from: r, reason: collision with root package name */
    private long f25398r;
    private long up;
    private String xt;

    public static j j(String str, String str2, String str3) {
        return new j(str, str2, str3);
    }

    public long j(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.up;
        long currentTimeMillis2 = System.currentTimeMillis() - this.f25398r;
        ZeusLogger.i(this.f25397j, this.xt + String.format(" watcher[%s]-%s cost=%s, total=%s", this.cw, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }

    private j(String str, String str2, String str3) {
        this.f25397j = str;
        this.xt = str2;
        this.cw = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.up = currentTimeMillis;
        this.f25398r = currentTimeMillis;
        ZeusLogger.i(this.f25397j, this.xt + String.format(" watcher[%s]-start", str3));
    }

    public long j() {
        return System.currentTimeMillis() - this.f25398r;
    }
}
