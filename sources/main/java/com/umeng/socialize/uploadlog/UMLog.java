package com.umeng.socialize.uploadlog;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.umeng.socialize.Config;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.utils.ContextUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMLog {
    private static boolean isAuth;
    private static boolean isShare;

    public static Bundle getShareAndAuth() {
        Bundle bundle = new Bundle();
        if (ContextUtil.getContext() == null) {
            bundle.putBoolean("share", false);
            bundle.putBoolean("auth", false);
            bundle.putBoolean("isjump", false);
            return bundle;
        }
        SharedPreferences sharedPreferences = ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0);
        bundle.putBoolean("share", sharedPreferences.getBoolean("share", false));
        bundle.putBoolean("auth", sharedPreferences.getBoolean("auth", false));
        bundle.putBoolean("isjump", sharedPreferences.getBoolean("isjump", false));
        return bundle;
    }

    public static boolean isOpenShareEdit() {
        if (ContextUtil.getContext() == null) {
            return true;
        }
        return ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).getBoolean(SocializeConstants.SP_KEY_IS_OPEN_SHARE_EDIT, true);
    }

    public static void putAuth() {
        if (ContextUtil.getContext() != null && !isAuth) {
            SharedPreferences.Editor edit = ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit();
            edit.putBoolean("auth", true);
            edit.putBoolean("isjump", Config.isJumptoAppStore);
            edit.commit();
            isShare = true;
        }
    }

    public static void putShare() {
        if (ContextUtil.getContext() != null && !isShare) {
            SharedPreferences.Editor edit = ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit();
            edit.putBoolean("share", true);
            edit.putBoolean("isjump", Config.isJumptoAppStore);
            edit.commit();
            isShare = true;
        }
    }

    public static void setIsOpenShareEdit(boolean z5) {
        if (ContextUtil.getContext() != null) {
            ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit().putBoolean(SocializeConstants.SP_KEY_IS_OPEN_SHARE_EDIT, z5).apply();
        }
    }
}
