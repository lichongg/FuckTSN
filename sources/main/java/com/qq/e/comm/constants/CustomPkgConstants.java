package com.qq.e.comm.constants;

import android.text.TextUtils;
import com.qq.e.ads.ADActivity;
import com.qq.e.ads.LandscapeADActivity;
import com.qq.e.ads.PortraitADActivity;
import com.qq.e.ads.RewardvideoLandscapeADActivity;
import com.qq.e.ads.RewardvideoPortraitADActivity;
import com.qq.e.comm.DownloadService;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class CustomPkgConstants {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36727a = DownloadService.class.getName();

    /* renamed from: b, reason: collision with root package name */
    private static final String f36728b = ADActivity.class.getName();

    /* renamed from: c, reason: collision with root package name */
    private static final String f36729c = PortraitADActivity.class.getName();

    /* renamed from: d, reason: collision with root package name */
    private static final String f36730d = RewardvideoPortraitADActivity.class.getName();

    /* renamed from: e, reason: collision with root package name */
    private static final String f36731e = LandscapeADActivity.class.getName();

    /* renamed from: f, reason: collision with root package name */
    private static final String f36732f = RewardvideoLandscapeADActivity.class.getName();

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static String getDownLoadServiceName() {
        return f36727a;
    }

    public static String getADActivityName() {
        String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
        if (!TextUtils.isEmpty(customADActivityClassName)) {
            return customADActivityClassName;
        }
        return f36728b;
    }

    public static String getLandscapeADActivityName() {
        String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
        if (!TextUtils.isEmpty(customLandscapeActivityClassName)) {
            return customLandscapeActivityClassName;
        }
        return f36731e;
    }

    public static String getPortraitADActivityName() {
        String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
        if (!TextUtils.isEmpty(customPortraitActivityClassName)) {
            return customPortraitActivityClassName;
        }
        return f36729c;
    }

    public static String getRewardvideoLandscapeADActivityName() {
        String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        if (!TextUtils.isEmpty(customRewardvideoLandscapeActivityClassName)) {
            return customRewardvideoLandscapeActivityClassName;
        }
        return f36732f;
    }

    public static String getRewardvideoPortraitADActivityName() {
        String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        if (!TextUtils.isEmpty(customRewardvideoPortraitActivityClassName)) {
            return customRewardvideoPortraitActivityClassName;
        }
        return f36730d;
    }
}
