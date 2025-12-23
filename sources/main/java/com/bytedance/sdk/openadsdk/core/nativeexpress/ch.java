package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ch extends v {
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.v
    public void j(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(context, nVar, xtVar, "embeded_ad");
        ((v) this).f29720j = nativeExpressVideoView;
        j(nativeExpressVideoView, this.cw);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt
    public com.bytedance.sdk.openadsdk.core.multipro.xt.j qv() {
        WeakReference<jy> weakReference = this.up;
        if (weakReference != null && weakReference.get() != null) {
            return this.up.get().getVideoModel();
        }
        NativeExpressView nativeExpressView = ((v) this).f29720j;
        if (!(nativeExpressView instanceof NativeExpressVideoView)) {
            return null;
        }
        ((NativeExpressVideoView) nativeExpressView).az();
        return ((NativeExpressVideoView) ((v) this).f29720j).getVideoModel();
    }

    public ch(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        super(context, nVar, xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(final com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
        NativeExpressView nativeExpressView = ((v) this).f29720j;
        if (nativeExpressView != null) {
            nativeExpressView.setVideoAdListener(new cw.r() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ch.1
                @Override // com.bykv.vk.openvk.component.video.api.r.cw.r
                public void j(int i6, int i7) {
                    com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(i6, i7);
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.r.cw.r
                public void p_() {
                    com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j();
                    }
                }
            });
            ((v) this).f29720j.setVideoAdInteractionListener(new cw.InterfaceC0306cw() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ch.2
                @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
                public void j(long j6, long j7) {
                    com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.j(j6, j7);
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
                public void q_() {
                    com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.xt();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
                public void r_() {
                    com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.cw();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
                public void s_() {
                    com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.r();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
                public void t_() {
                    com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.up();
                    }
                }
            });
        }
    }
}
