package com.tencent.mm.opensdk.diffdev.a;

import com.bytedance.sdk.openadsdk.TTAdConstant;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(TTAdConstant.INTERACTION_TYPE_CODE),
    UUID_ERROR(500);


    /* renamed from: a, reason: collision with root package name */
    private int f40440a;

    public int a() {
        return this.f40440a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f40440a;
    }

    d(int i6) {
        this.f40440a = i6;
    }
}
