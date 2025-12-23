package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {

    /* renamed from: a, reason: collision with root package name */
    private NativeUnifiedADData f36675a;

    /* renamed from: b, reason: collision with root package name */
    private NativeADEventListener f36676b;

    /* renamed from: c, reason: collision with root package name */
    private NativeADMediaListener f36677c;

    /* renamed from: d, reason: collision with root package name */
    private DownloadConfirmListener f36678d;

    /* renamed from: e, reason: collision with root package name */
    private NegativeFeedbackListener f36679e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedADDataAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class UnifiedAdListener implements ADListener {
        private UnifiedAdListener() {
        }

        /* synthetic */ UnifiedAdListener(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeUnifiedADDataAdapter.this.a(aDEvent) || NativeUnifiedADDataAdapter.this.b(aDEvent)) {
                return;
            }
            NativeUnifiedADDataAdapter.this.c(aDEvent);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.f36675a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i6) {
        this.f36675a.bindImageViews(list, i6);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i6, int i7, String str) {
        this.f36675a.sendLossNotification(i6, i7, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i6) {
        this.f36675a.sendWinNotification(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ADEvent aDEvent) {
        if (this.f36676b == null) {
            return false;
        }
        int type = aDEvent.getType();
        if (type == 103) {
            this.f36676b.onADExposed();
            return true;
        }
        if (type == 105) {
            NativeADEventListener nativeADEventListener = this.f36676b;
            if (!(nativeADEventListener instanceof NativeADEventListenerWithClickInfo)) {
                nativeADEventListener.onADClicked();
                return true;
            }
            ((NativeADEventListenerWithClickInfo) this.f36676b).onADClicked((View) aDEvent.getParam(View.class));
            return true;
        }
        if (type != 107) {
            if (type != 111) {
                return false;
            }
            this.f36676b.onADStatusChanged();
            return true;
        }
        Integer num = (Integer) aDEvent.getParam(Integer.class);
        if (num == null) {
            return true;
        }
        this.f36676b.onADError(AdErrorConvertor.formatErrorCode(num.intValue()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ADEvent aDEvent) {
        if (this.f36677c == null) {
            return false;
        }
        switch (aDEvent.getType()) {
            case 201:
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    this.f36677c.onVideoLoaded(num.intValue());
                    break;
                }
                break;
            case 202:
                this.f36677c.onVideoStart();
                break;
            case 203:
                this.f36677c.onVideoResume();
                break;
            case 204:
                this.f36677c.onVideoPause();
                break;
            case 205:
                this.f36677c.onVideoStop();
                break;
            case 206:
                this.f36677c.onVideoCompleted();
                break;
            case 207:
                Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                if (num2 != null) {
                    this.f36677c.onVideoError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                    break;
                }
                break;
            case 208:
                this.f36677c.onVideoClicked();
                break;
            case 209:
                this.f36677c.onVideoInit();
                break;
            case 210:
                this.f36677c.onVideoReady();
                break;
            case 211:
                this.f36677c.onVideoLoading();
                break;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(ADEvent aDEvent) {
        if (this.f36679e == null || aDEvent.getType() != 304) {
            return false;
        }
        this.f36679e.onComplainSuccess();
        return true;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) {
        this.f36675a.bindAdToCustomVideo(viewGroup, context, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.f36675a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.f36675a.bindCTAViews(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        this.f36675a.bindImageViews(list, bArr);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f36677c = nativeADMediaListener;
        this.f36675a.bindMediaView(mediaView, videoOption, nativeADMediaListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.f36675a.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f36675a.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.f36675a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.f36675a.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f36675a.getApkInfoUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return this.f36675a.getAppMiitInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f36675a.getAppPrice();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f36675a.getAppScore();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f36675a.getAppStatus();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        return this.f36675a.getButtonText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f36675a.getCTAText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        return this.f36675a.getCustomizeVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f36675a.getDesc();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f36675a.getDownloadCount();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f36675a.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.f36675a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f36675a.getExtraInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f36675a.getIconUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f36675a.getImgList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f36675a.getImgUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f36675a.getPictureHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f36675a.getPictureWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f36675a.getProgress();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f36675a.getTitle();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.f36675a.getVideoCurrentPosition();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f36675a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f36675a.isAppAd();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.f36675a.isValid();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.f36675a.isWeChatCanvasAd();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f36675a.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i6, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f36678d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i6, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.f36675a.pauseAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.f36675a.pauseVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.f36675a.resumeAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.f36675a.resumeVideo();
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.f36675a.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f36675a.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i6) {
        this.f36675a.setBidECPM(i6);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f36678d = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.f36675a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f36676b = nativeADEventListener;
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f36679e = negativeFeedbackListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z5) {
        this.f36675a.setVideoMute(z5);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.f36675a.startVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.f36675a.stopVideo();
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.f36675a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener(this, null));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }
}
