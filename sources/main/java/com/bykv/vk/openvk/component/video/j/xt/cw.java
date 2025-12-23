package com.bykv.vk.openvk.component.video.j.xt;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private final long cw;

    /* renamed from: j, reason: collision with root package name */
    private final long f23045j;
    private final long xt;

    public long j(int i6) {
        return i6 <= 0 ? this.f23045j : Math.min(this.f23045j + (this.xt * i6), this.cw);
    }
}
