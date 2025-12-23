package com.bytedance.sdk.openadsdk.mediation.init;

import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface IMediationPrivacyConfig {
    @Nullable
    List<String> getCustomAppList();

    @Nullable
    List<String> getCustomDevImeis();

    boolean isCanUseOaid();

    boolean isLimitPersonalAds();

    boolean isProgrammaticRecommend();
}
