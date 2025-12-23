package com.bytedance.sdk.openadsdk.i.j;

import android.util.Pair;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.tj.j.j.j.cw;
import com.bytedance.sdk.openadsdk.tj.j.j.j.m;
import com.bytedance.sdk.openadsdk.tj.j.j.j.r;
import com.bytedance.sdk.openadsdk.tj.j.j.j.up;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {

    /* renamed from: com.bytedance.sdk.openadsdk.i.j.j$j, reason: collision with other inner class name */
    public static class C0501j implements TTAdNative {

        /* renamed from: j, reason: collision with root package name */
        private final j f31488j;

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f31488j.g(j(adSlot), new up(nativeExpressAdListener));
            } catch (Exception e6) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> j6 = this.f31488j.j(e6);
                    nativeExpressAdListener.onError(((Integer) j6.first).intValue(), (String) j6.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.f31488j.cw(j(adSlot), new com.bytedance.sdk.openadsdk.tj.j.j.j.j(drawFeedAdListener));
            } catch (Exception e6) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> j6 = this.f31488j.j(e6);
                    drawFeedAdListener.onError(((Integer) j6.first).intValue(), (String) j6.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f31488j.tl(j(adSlot), new up(nativeExpressAdListener));
            } catch (Exception e6) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> j6 = this.f31488j.j(e6);
                    nativeExpressAdListener.onError(((Integer) j6.first).intValue(), (String) j6.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f31488j.j(j(adSlot), new com.bytedance.sdk.openadsdk.tj.j.j.j.xt(feedAdListener));
            } catch (Exception e6) {
                if (feedAdListener != null) {
                    Pair<Integer, String> j6 = this.f31488j.j(e6);
                    feedAdListener.onError(((Integer) j6.first).intValue(), (String) j6.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.f31488j.m(j(adSlot), new cw(fullScreenVideoAdListener));
            } catch (Exception e6) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> j6 = this.f31488j.j(e6);
                    fullScreenVideoAdListener.onError(((Integer) j6.first).intValue(), (String) j6.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.f31488j.r(j(adSlot), new r(nativeAdListener));
            } catch (Exception e6) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> j6 = this.f31488j.j(e6);
                    nativeAdListener.onError(((Integer) j6.first).intValue(), (String) j6.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f31488j.ae(j(adSlot), new up(nativeExpressAdListener));
            } catch (Exception e6) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> j6 = this.f31488j.j(e6);
                    nativeExpressAdListener.onError(((Integer) j6.first).intValue(), (String) j6.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.f31488j.up(j(adSlot), new m(rewardVideoAdListener));
            } catch (Exception e6) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> j6 = this.f31488j.j(e6);
                    rewardVideoAdListener.onError(((Integer) j6.first).intValue(), (String) j6.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i6) {
            try {
                this.f31488j.j(j(adSlot), new xt(cSJSplashAdListener), i6);
            } catch (Exception e6) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> j6 = this.f31488j.j(e6);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.i.j.j.j.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) j6.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) j6.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f31488j.xt(j(adSlot), new com.bytedance.sdk.openadsdk.tj.j.j.j.xt(feedAdListener));
            } catch (Exception e6) {
                if (feedAdListener != null) {
                    Pair<Integer, String> j6 = this.f31488j.j(e6);
                    feedAdListener.onError(((Integer) j6.first).intValue(), (String) j6.second);
                }
            }
        }

        protected C0501j(j jVar) {
            this.f31488j = jVar;
        }

        private ValueSet j(AdSlot adSlot) {
            a j6 = a.j(com.bytedance.sdk.openadsdk.i.j.cw.xt.j(adSlot));
            j6.g(8302, MediationAdClassLoader.getInstance());
            return j6.k();
        }
    }

    public abstract void ae(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void cw(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void g(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract Pair<Integer, String> j(Exception exc);

    public TTAdNative j() {
        return new C0501j(this);
    }

    public abstract void j(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void j(ValueSet valueSet, Function<SparseArray<Object>, Object> function, int i6);

    public abstract void m(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void r(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void tl(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void up(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void xt(ValueSet valueSet, Function<SparseArray<Object>, Object> function);
}
