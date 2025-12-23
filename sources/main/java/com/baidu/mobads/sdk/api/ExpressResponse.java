package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface ExpressResponse {
    public static final int INFO_FLOW_GROUP_PIC = 35;
    public static final int INFO_FLOW_GROUP_PIC_LOGO = 36;
    public static final int INFO_FLOW_LEFT_PIC = 33;
    public static final int INFO_FLOW_PIC_BOTTOM_TITLE = 28;
    public static final int INFO_FLOW_PIC_LOGO = 30;
    public static final int INFO_FLOW_PIC_TOP_TITLE = 29;
    public static final int INFO_FLOW_RIGHT_PIC = 34;
    public static final int INFO_FLOW_VERTICAL_VIDEO = 41;
    public static final int INFO_FLOW_VIDEO_TOP_TITLE = 37;
    public static final int THEME_DARK = 1;
    public static final int THEME_DEFAULT = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ExpressAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADFunctionClick();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ExpressCloseListener {
        void onAdClose(ExpressResponse expressResponse);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ExpressDislikeListener {
        void onDislikeItemClick(String str);

        void onDislikeWindowClose();

        void onDislikeWindowShow();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ExpressInteractionListener {
        void onAdClick();

        void onAdExposed();

        void onAdRenderFail(View view, String str, int i6);

        void onAdRenderSuccess(View view, float f6, float f7);

        void onAdUnionClick();
    }

    void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener);

    void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener);

    void bindInteractionActivity(Activity activity);

    void destroy();

    int getAdActionType();

    ExpressAdData getAdData();

    Object getAdDataForKey(String str);

    String getECPMLevel();

    View getExpressAdView();

    String getPECPM();

    int getStyleType();

    @Deprecated
    boolean isAdAvailable();

    boolean isReady(Context context);

    void render();

    void setAdCloseListener(ExpressCloseListener expressCloseListener);

    void setAdDislikeListener(ExpressDislikeListener expressDislikeListener);

    void setAdPrivacyListener(ExpressAdDownloadWindowListener expressAdDownloadWindowListener);

    void setExpectedSizePixel(int i6, int i7);

    void setInteractionListener(ExpressInteractionListener expressInteractionListener);

    boolean switchTheme(int i6);
}
