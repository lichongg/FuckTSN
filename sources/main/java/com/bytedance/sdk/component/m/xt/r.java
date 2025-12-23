package com.bytedance.sdk.component.m.xt;

import com.bytedance.sdk.component.m.ae;
import com.bytedance.sdk.component.m.m;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r<T> implements m {
    private T cw;

    /* renamed from: j, reason: collision with root package name */
    Map<String, String> f26608j;

    /* renamed from: r, reason: collision with root package name */
    private String f26609r;
    private ae up;
    private int xt;

    public r(int i6, T t5, String str) {
        this.xt = i6;
        this.cw = t5;
        this.f26609r = str;
    }

    @Override // com.bytedance.sdk.component.m.m
    public ae j() {
        return this.up;
    }

    @Override // com.bytedance.sdk.component.m.m
    public T cw() {
        return this.cw;
    }

    public void j(ae aeVar) {
        this.up = aeVar;
    }

    @Override // com.bytedance.sdk.component.m.m
    public String r() {
        return this.f26609r;
    }

    @Override // com.bytedance.sdk.component.m.m
    public Map<String, String> up() {
        return this.f26608j;
    }

    @Override // com.bytedance.sdk.component.m.m
    public int xt() {
        return this.xt;
    }

    public r(int i6, T t5, String str, Map<String, String> map) {
        this(i6, t5, str);
        this.f26608j = map;
    }
}
