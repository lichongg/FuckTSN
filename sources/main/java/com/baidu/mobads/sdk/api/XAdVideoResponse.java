package com.baidu.mobads.sdk.api;

import android.view.View;
import com.baidu.mobads.sdk.api.NativeResponse;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class XAdVideoResponse implements PrerollVideoResponse {
    XAdNativeResponse adNativeResponse;

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void handleClick(View view) {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            xAdNativeResponse.handleClick(view);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.mobads.sdk.api.XAdVideoResponse$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType;

        static {
            int[] iArr = new int[NativeResponse.MaterialType.values().length];
            $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType = iArr;
            try {
                iArr[NativeResponse.MaterialType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[NativeResponse.MaterialType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getAdLogoUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getAdLogoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getBaiduLogoUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getBaiduLogoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getDesc() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getDesc();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getIconUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getIconUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getImageUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getImageUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getMaterialType() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse == null) {
            return PrerollVideoResponse.NORMAL;
        }
        int i6 = AnonymousClass1.$SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[xAdNativeResponse.getMaterialType().ordinal()];
        return i6 != 1 ? (i6 == 2 && this.adNativeResponse.getImageUrl().contains(".gif")) ? "gif" : PrerollVideoResponse.NORMAL : "video";
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getTitle() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getTitle();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getVideoUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getVideoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void recordImpression(View view) {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            xAdNativeResponse.recordImpression(view);
        }
    }

    public XAdVideoResponse(NativeResponse nativeResponse) {
        this.adNativeResponse = (XAdNativeResponse) nativeResponse;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void handleClick(View view, int i6) {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            xAdNativeResponse.handleClick(view, i6);
        }
    }
}
