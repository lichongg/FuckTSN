package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.stub.StubApp;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMShareAPI {

    /* renamed from: a, reason: collision with root package name */
    private static UMShareAPI f42177a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f42178b = true;
    public boolean isZyb = true;

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a() {
        try {
            Class<?> a6 = a("com.umeng.commonsdk.framework.UMEnvelopeBuild");
            if (a6 != null) {
                if (a6.getDeclaredMethod("buildEnvelopeWithExtHeader", Context.class, JSONObject.class, JSONObject.class, String.class, String.class, String.class) != null) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String getSdkVersion() {
        return "7.3.2";
    }

    public static boolean getSmartEnableFlag() {
        return f42178b;
    }

    public static void setSmartEnable(boolean z5) {
        f42178b = z5;
    }

    public void deleteOauth(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f42177a.deleteOauth(activity, share_media, uMAuthListener);
    }

    @Deprecated
    public void doOauthVerify(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f42177a.doOauthVerify(activity, share_media, uMAuthListener);
    }

    public void doShare(Activity activity, ShareAction shareAction, UMShareListener uMShareListener) {
        f42177a.doShare(activity, shareAction, uMShareListener);
    }

    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        f42177a.fetchAuthResultWithBundle(activity, bundle, uMAuthListener);
    }

    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        return f42177a.getHandler(share_media);
    }

    public void getPlatformInfo(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f42177a.getPlatformInfo(activity, share_media, uMAuthListener);
    }

    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return f42177a.getversion(activity, share_media);
    }

    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return f42177a.isAuthorize(activity, share_media);
    }

    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return f42177a.isInstall(activity, share_media);
    }

    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return f42177a.isSupport(activity, share_media);
    }

    public void onActivityResult(int i6, int i7, Intent intent) {
        f42177a.onActivityResult(i6, i7, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        f42177a.onSaveInstanceState(bundle);
    }

    public void release() {
        f42177a.release();
    }

    public void setShareConfig(UMShareConfig uMShareConfig) {
        f42177a.setShareConfig(uMShareConfig);
    }

    public static UMShareAPI get(Context context) {
        if (a(context) && !CommonUtil.isSilentMode(context)) {
            if (f42177a == null) {
                f42177a = new a(context);
                SLog.welcome();
            }
            return f42177a;
        }
        b bVar = new b(context);
        f42177a = bVar;
        return bVar;
    }

    public static void init(Context context, String str) {
        if (!a(context)) {
            return;
        }
        SocializeConstants.APPKEY = str;
        get(context);
        UMWorkDispatch.sendEvent(context, SocializeConstants.REGIST_TO_WORK_QUEUE, CommonNetImpl.get(context), null);
    }

    private static boolean a(final Context context) {
        if (a()) {
            return true;
        }
        new Thread() { // from class: com.umeng.socialize.UMShareAPI.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Looper.prepare();
                    Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), UmengText.CHECK.DEPENDENT_COMMON_NOT_MATCH, 1).show();
                    Looper.loop();
                } catch (Throwable unused) {
                }
            }
        }.start();
        SLog.E(UmengText.CHECK.DEPENDENT_COMMON_NOT_MATCH);
        return false;
    }
}
