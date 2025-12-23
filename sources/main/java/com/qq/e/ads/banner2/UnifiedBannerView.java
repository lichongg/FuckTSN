package com.qq.e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes6.dex */
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface, IBidding, NFBI, IReward {

    /* renamed from: a, reason: collision with root package name */
    final UnifiedBannerAD f36571a;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, null);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i6, int i7, String str) {
        this.f36571a.sendLossNotification(i6, i7, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i6) {
        this.f36571a.sendWinNotification(i6);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f36571a = new UnifiedBannerAD(activity, this, str, unifiedBannerADListener);
        a();
    }

    private void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void destroy() {
        this.f36571a.destroy();
    }

    public String getAdNetWorkName() {
        return this.f36571a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f36571a.getApkInfoUrl();
    }

    public int getECPM() {
        return this.f36571a.getECPM();
    }

    public String getECPMLevel() {
        return this.f36571a.getECPMLevel();
    }

    public Map<String, Object> getExtraInfo() {
        return this.f36571a.getExtraInfo();
    }

    public boolean isValid() {
        return this.f36571a.isValid();
    }

    public void loadAD() {
        this.f36571a.loadAD();
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.f36571a.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f36571a.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i6) {
        this.f36571a.setBidECPM(i6);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f36571a.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f36571a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f36571a.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    public void setRefresh(int i6) {
        this.f36571a.c(i6);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f36571a.setRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f36571a.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map, String str2) {
        super(activity);
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.e(getClass().getSimpleName() + "构造函数中 token 参数不可为空");
        }
        this.f36571a = new UnifiedBannerAD(activity, this, str, str2, unifiedBannerADListener);
        a();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        this.f36571a.onWindowFocusChanged(z5);
    }
}
