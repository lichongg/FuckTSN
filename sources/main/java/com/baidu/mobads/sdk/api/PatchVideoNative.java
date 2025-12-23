package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PatchVideoNative {
    private String mAdPlaceId;
    private PrerollVideoResponse mAdResponse;
    private String mAppSid;
    private BaiduNativeManager mBaiduNativeManager;
    private Context mContext;
    private boolean mIsMute;
    private IPatchVideoNativeListener mListener;
    private RelativeLayout mParentView;
    private PatchAdView mPatchView;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IPatchVideoNativeListener {
        void onAdClick();

        void onAdFailed(int i6, String str);

        void onAdLoad(String str);

        void onAdShow();

        void playCompletion();

        void playError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdClick() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdShow() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callLoadFail(int i6, String str) {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdFailed(i6, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callLoadSucc() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdLoad(this.mAdResponse.getMaterialType());
        }
        PatchAdView patchAdView = new PatchAdView(this.mContext);
        this.mPatchView = patchAdView;
        patchAdView.setVideoVolume(this.mIsMute);
        this.mParentView.addView(this.mPatchView, new RelativeLayout.LayoutParams(-1, -1));
        this.mPatchView.setPatchAdListener(new IPatchAdListener() { // from class: com.baidu.mobads.sdk.api.PatchVideoNative.2
            @Override // com.baidu.mobads.sdk.api.IPatchAdListener
            public void onAdClicked() {
                PatchVideoNative.this.callAdClick();
            }

            @Override // com.baidu.mobads.sdk.api.IPatchAdListener
            public void onAdShow() {
                PatchVideoNative.this.callAdShow();
            }

            @Override // com.baidu.mobads.sdk.api.IPatchAdListener
            public void playCompletion() {
                PatchVideoNative.this.callPlayCompletion();
            }

            @Override // com.baidu.mobads.sdk.api.IPatchAdListener
            public void playError() {
                PatchVideoNative.this.callPlayError();
            }
        });
        this.mPatchView.setAdData((XAdVideoResponse) this.mAdResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPlayCompletion() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.playCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPlayError() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.playError();
        }
    }

    public long getCurrentPosition() {
        PatchAdView patchAdView = this.mPatchView;
        if (patchAdView != null) {
            return patchAdView.getCurrentPosition();
        }
        return 0L;
    }

    public long getDuration() {
        PatchAdView patchAdView = this.mPatchView;
        if (patchAdView != null) {
            return patchAdView.getDuration();
        }
        return 0L;
    }

    public void requestAd(RequestParameters requestParameters) {
        BaiduNativeManager baiduNativeManager = this.mBaiduNativeManager;
        if (baiduNativeManager != null) {
            baiduNativeManager.setAppSid(this.mAppSid);
            this.mBaiduNativeManager.loadPrerollVideo(requestParameters, new BaiduNativeManager.FeedAdListener() { // from class: com.baidu.mobads.sdk.api.PatchVideoNative.1
                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNativeFail(int i6, String str, NativeResponse nativeResponse) {
                    PatchVideoNative.this.callLoadFail(i6, str);
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNativeLoad(List<NativeResponse> list) {
                    ArrayList arrayList = new ArrayList();
                    for (int i6 = 0; i6 < list.size(); i6++) {
                        arrayList.add(new XAdVideoResponse(list.get(i6)));
                    }
                    PatchVideoNative.this.mAdResponse = (PrerollVideoResponse) arrayList.get(0);
                    PatchVideoNative.this.callLoadSucc();
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNoAd(int i6, String str, NativeResponse nativeResponse) {
                    PatchVideoNative.this.callLoadFail(i6, str);
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onLpClosed() {
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onVideoDownloadFailed() {
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onVideoDownloadSuccess() {
                }
            });
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setVideoMute(boolean z5) {
        this.mIsMute = z5;
        PatchAdView patchAdView = this.mPatchView;
        if (patchAdView != null) {
            patchAdView.setVideoVolume(z5);
        }
    }

    public PatchVideoNative(Context context, String str, RelativeLayout relativeLayout, IPatchVideoNativeListener iPatchVideoNativeListener) {
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mParentView = relativeLayout;
        this.mListener = iPatchVideoNativeListener;
        this.mBaiduNativeManager = new BaiduNativeManager(this.mContext, this.mAdPlaceId);
    }
}
