package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.cw.xt.r;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.qv;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.vl;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    public static void j() {
        com.bytedance.adsdk.ugeno.r.j().j(v.getContext(), new com.bytedance.adsdk.ugeno.cw.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1
            @Override // com.bytedance.adsdk.ugeno.cw.cw
            public List<com.bytedance.adsdk.ugeno.cw.xt> j() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("View") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.1
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("CustomComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.12
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Text") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.23
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.xt(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Image") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.32
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.image.xt(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("UpieImage") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.33
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.cw.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("FlexLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.34
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.flexbox.up(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("FrameLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.35
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("InteractContainerView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.36
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new qv(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("ScrollLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.37
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.scroll.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("RichText") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.2
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Input") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.3
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.input.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Dislike") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.4
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.dislike.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("RatingBar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.5
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("RatingStar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.6
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("UgenProgressView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.7
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("ProgressButton") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.8
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Button") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.9
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.j.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("RecyclerLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.10
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Video") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.11
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt(Registry.f14550k) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.13
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.gif.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("VideoPlaceholder") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.14
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.r.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Lottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.15
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("InterLottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.16
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("InteractionWebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.17
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new vl(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("WebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.18
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.webview.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Blur") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.19
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Swiper") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.20
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.xt(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("FVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.21
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("RVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.22
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("CycleCountDownView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.24
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xt(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("CycleSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.25
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("RewardClickCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.26
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.cw(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("Icon") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.27
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.j.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("FVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.28
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.xt(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("RVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.29
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.xt(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("VideoV3") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.30
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.r.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.cw.xt("PlayableComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.1.31
                    @Override // com.bytedance.adsdk.ugeno.cw.xt
                    public com.bytedance.adsdk.ugeno.xt.cw j(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.j(context);
                    }
                });
                return arrayList;
            }
        }, new r());
        com.bytedance.adsdk.ugeno.r.j().j(new com.bytedance.adsdk.ugeno.up.tl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.2
            @Override // com.bytedance.adsdk.ugeno.up.tl
            public List<com.bytedance.adsdk.ugeno.up.ae> j() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.up.ae("shake") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.2.1
                    @Override // com.bytedance.adsdk.ugeno.up.ae
                    public com.bytedance.adsdk.ugeno.up.cw.xt j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.xt.j(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.up.ae("twist") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.2.2
                    @Override // com.bytedance.adsdk.ugeno.up.ae
                    public com.bytedance.adsdk.ugeno.up.cw.xt j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.xt.xt(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.up.ae("videoProgress") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.2.3
                    @Override // com.bytedance.adsdk.ugeno.up.ae
                    public com.bytedance.adsdk.ugeno.up.cw.xt j(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.xt.cw(context);
                    }
                });
                return arrayList;
            }
        });
        com.bytedance.adsdk.ugeno.r.j().j(new com.bytedance.adsdk.xt.cw());
        com.bytedance.adsdk.ugeno.r.j().j(new com.bytedance.adsdk.ugeno.cw.xt.r() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.3
            @Override // com.bytedance.adsdk.ugeno.cw.xt.r
            public r.j j(Context context, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
                return new m(context, cwVar);
            }
        });
        com.bytedance.adsdk.ugeno.r.j().j(new com.bytedance.adsdk.ugeno.cw.j.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.4
            @Override // com.bytedance.adsdk.ugeno.cw.j.j
            public com.bytedance.adsdk.ugeno.cw.j.xt j(w wVar) {
                return new g(wVar);
            }
        });
        com.bytedance.adsdk.ugeno.r.j().j(new com.bytedance.adsdk.ugeno.up.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.5
            @Override // com.bytedance.adsdk.ugeno.up.cw
            public List<com.bytedance.adsdk.ugeno.up.xt> j() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.up.xt("interactiveFinish") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.up.5.1
                    @Override // com.bytedance.adsdk.ugeno.up.xt
                    public com.bytedance.adsdk.ugeno.up.xt.j j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
                        return new com.bytedance.adsdk.ugeno.up.xt.cw(cwVar, str, jVar);
                    }
                });
                return arrayList;
            }
        });
    }
}
