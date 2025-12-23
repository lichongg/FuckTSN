package com.bytedance.sdk.openadsdk.core.up.up;

import com.bytedance.sdk.openadsdk.l.ae;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements up {

    /* renamed from: j, reason: collision with root package name */
    private up f30902j;

    @Override // com.bytedance.sdk.openadsdk.core.up.up.up
    public void j(final Object obj) {
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.up.up.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f30902j != null) {
                    m.this.f30902j.j(obj);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.up.up
    public void xt(final Object obj) {
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.up.up.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f30902j != null) {
                    m.this.f30902j.xt(obj);
                }
            }
        });
    }

    public m(up upVar) {
        this.f30902j = upVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.up.up
    public void j(final int i6, final String str) {
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.up.up.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f30902j != null) {
                    m.this.f30902j.j(i6, str);
                }
            }
        });
    }
}
