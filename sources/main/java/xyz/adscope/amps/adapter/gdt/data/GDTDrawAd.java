package xyz.adscope.amps.adapter.gdt.data;

import android.view.View;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.util.AdError;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdExpressListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdVideoListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.adapter.gdt.GDTDrawAdapter;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GDTDrawAd implements AMPSDrawAdExpressInfo {
    public GDTDrawAdapter adapter;
    public NativeExpressADView gdtNativeExpressAd;

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void destroy() {
        try {
            NativeExpressADView nativeExpressADView = this.gdtNativeExpressAd;
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
                this.gdtNativeExpressAd = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public View getDrawView() {
        NativeExpressADView nativeExpressADView = this.gdtNativeExpressAd;
        if (nativeExpressADView != null) {
            return nativeExpressADView;
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void render() {
        GDTDrawAdapter gDTDrawAdapter = this.adapter;
        if (gDTDrawAdapter != null) {
            gDTDrawAdapter.onRender();
        }
        NativeExpressADView nativeExpressADView = this.gdtNativeExpressAd;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdExpressInfoListener(AMPSDrawAdExpressListener aMPSDrawAdExpressListener) {
        GDTDrawAdapter gDTDrawAdapter = this.adapter;
        if (gDTDrawAdapter != null) {
            gDTDrawAdapter.setAMPSDrawAdExpressInfoListener(this.gdtNativeExpressAd, aMPSDrawAdExpressListener);
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdVideoListener(final AMPSDrawAdVideoListener aMPSDrawAdVideoListener) {
        NativeExpressADView nativeExpressADView = this.gdtNativeExpressAd;
        if (nativeExpressADView == null) {
            return;
        }
        nativeExpressADView.setMediaListener(new NativeExpressMediaListener() { // from class: xyz.adscope.amps.adapter.gdt.data.GDTDrawAd.1
            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdComplete();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                if (aMPSDrawAdVideoListener != null) {
                    int errorCode = adError != null ? adError.getErrorCode() : -1;
                    aMPSDrawAdVideoListener.onVideoError(errorCode, errorCode);
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPause(NativeExpressADView nativeExpressADView2) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdPaused();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoReady(NativeExpressADView nativeExpressADView2, long j6) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoLoad();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoStart(NativeExpressADView nativeExpressADView2) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdStartPlay();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoCached(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoInit(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
            }
        });
    }

    public GDTDrawAd(NativeExpressADView nativeExpressADView, GDTDrawAdapter gDTDrawAdapter) {
        this.gdtNativeExpressAd = nativeExpressADView;
        this.adapter = gDTDrawAdapter;
    }
}
