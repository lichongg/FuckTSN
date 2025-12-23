package com.bytedance.sdk.openadsdk.api.plugin.xt;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements Result {

    /* renamed from: j, reason: collision with root package name */
    private String f27599j;

    @Override // com.bykv.vk.openvk.api.proto.Result
    public int code() {
        return 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public boolean isSuccess() {
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public ValueSet values() {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public String message() {
        return this.f27599j;
    }

    public r(String str) {
        this.f27599j = str;
    }
}
