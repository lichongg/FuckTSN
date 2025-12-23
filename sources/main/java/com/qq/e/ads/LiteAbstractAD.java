package com.qq.e.ads;

import android.app.Activity;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.LADI;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class LiteAbstractAD<T extends LADI> extends AbstractAD<T> implements LADI, DownloadConfirmListener {

    /* renamed from: h, reason: collision with root package name */
    private DownloadConfirmListener f36560h;

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i6, int i7, String str) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((LADI) t5).sendLossNotification(i6, i7, str);
        } else {
            a("sendLossNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i6) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((LADI) t5).sendWinNotification(i6);
        } else {
            a("sendWinNotification");
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((LADI) t5).getApkInfoUrl();
        }
        a("getApkInfoUrl");
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((LADI) t5).getECPM();
        }
        a("getECPM");
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((LADI) t5).getECPMLevel();
        }
        a("getECPMLevel");
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((LADI) t5).getExtraInfo();
        }
        a("getExtraInfo");
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((LADI) t5).isValid();
        }
        a("isValid");
        return false;
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i6, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f36560h;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i6, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((LADI) t5).sendLossNotification(map);
        } else {
            a("sendLossNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((LADI) t5).sendWinNotification(map);
        } else {
            a("sendWinNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i6) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((LADI) t5).setBidECPM(i6);
        } else {
            a("setBidECPM");
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f36560h = downloadConfirmListener;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((LADI) t5).setDownloadConfirmListener(this);
        }
    }
}
