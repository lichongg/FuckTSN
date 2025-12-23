package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cj;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class bx implements cj.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bw f10822a;

    bx(bw bwVar) {
        this.f10822a = bwVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cj.a
    public void a(by byVar) {
        this.f10822a.a(ca.f10845k, byVar, "download apk successfully, downloader exit");
        bw unused = bw.f10812h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.cj.a
    public void b(by byVar) {
        this.f10822a.a(ca.f10846l, byVar, "downloadApk failed");
    }
}
