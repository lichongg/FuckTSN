package com.bytedance.sdk.component.xt.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class az {
    public oq cw;

    /* renamed from: j, reason: collision with root package name */
    private String f27266j;

    /* renamed from: m, reason: collision with root package name */
    public j f27267m;

    /* renamed from: r, reason: collision with root package name */
    public String f27268r;
    public byte[] up;
    private String xt;

    public enum j {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public az() {
    }

    public String j() {
        return this.f27266j;
    }

    public az(oq oqVar, String str, j jVar) {
        this.cw = oqVar;
        this.f27268r = str;
        this.f27267m = jVar;
    }

    public static az j(oq oqVar, String str) {
        return new az(oqVar, str, j.STRING_TYPE);
    }

    public String xt() {
        return this.xt;
    }

    public static az j(oq oqVar, byte[] bArr) {
        return new az(oqVar, bArr, j.BYTE_ARRAY_TYPE);
    }

    public static az j(oq oqVar, byte[] bArr, String str, String str2) {
        return new az(oqVar, bArr, str, str2, j.FILE_TYPE);
    }

    public az(oq oqVar, byte[] bArr, String str, String str2, j jVar) {
        this.cw = oqVar;
        this.up = bArr;
        this.xt = str;
        this.f27266j = str2;
        this.f27267m = jVar;
    }

    public az(oq oqVar, byte[] bArr, j jVar) {
        this.cw = oqVar;
        this.up = bArr;
        this.f27267m = jVar;
    }
}
