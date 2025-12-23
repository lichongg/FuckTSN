package com.beizi.fusion;

import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface NativeUnifiedAdResponse {
    String getActionText();

    String getAdLogoUrl();

    String getDescription();

    UnifiedAdDownloadAppInfo getDownloadAppInfo();

    int getECPM();

    String getIconUrl();

    String getImageUrl();

    List<String> getImgList();

    int getMaterialType();

    String getTitle();

    View getVideoView();

    ViewGroup getViewContainer();

    boolean isVideo();

    void registerDownloadAppInfoClickEvent(View view);

    void registerViewForInteraction(List<View> list);
}
