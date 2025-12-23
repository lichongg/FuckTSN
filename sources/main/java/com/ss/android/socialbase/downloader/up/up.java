package com.ss.android.socialbase.downloader.up;

/* loaded from: D:\Downloads\app\classes6.dex */
public class up extends j {

    /* renamed from: j, reason: collision with root package name */
    private final long f38984j;
    private final long xt;

    public long r() {
        return this.f38984j;
    }

    public long up() {
        return this.xt;
    }

    public up(long j6, long j7) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j7), String.valueOf(j6)));
        this.f38984j = j6;
        this.xt = j7;
    }
}
