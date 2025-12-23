package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@hk(a = "update_item_download_info")
/* loaded from: D:\Downloads\app\classes2.dex */
class o0 {

    /* renamed from: a, reason: collision with root package name */
    @hl(a = "mAdcode", b = 6)
    private String f6813a;

    /* renamed from: b, reason: collision with root package name */
    @hl(a = "fileLength", b = 5)
    private long f6814b;

    /* renamed from: c, reason: collision with root package name */
    @hl(a = "splitter", b = 2)
    private int f6815c;

    /* renamed from: d, reason: collision with root package name */
    @hl(a = "startPos", b = 5)
    private long f6816d;

    /* renamed from: e, reason: collision with root package name */
    @hl(a = "endPos", b = 5)
    private long f6817e;

    public o0() {
        this.f6813a = "";
        this.f6814b = 0L;
        this.f6815c = 0;
        this.f6816d = 0L;
        this.f6817e = 0L;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }

    public o0(String str, long j6, int i6, long j7, long j8) {
        this.f6813a = str;
        this.f6814b = j6;
        this.f6815c = i6;
        this.f6816d = j7;
        this.f6817e = j8;
    }
}
