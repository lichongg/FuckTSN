package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import com.umeng.analytics.pro.bm;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.StringName;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class UMSSOHandler {
    protected static final String ACCESSTOKEN = "accessToken";
    protected static final String ACCESS_SECRET = "access_secret";
    protected static final String ACCESS_TOKEN = "access_token";
    protected static final String CITY = "city";
    protected static final String CODE = "code";
    protected static final String COUNTRY = "country";
    protected static final String EMAIL = "email";
    protected static final String EXPIRATION = "expiration";
    protected static final String EXPIRES_IN = "expires_in";
    protected static final String FIRST_NAME = "first_name";
    protected static final String GENDER = "gender";
    protected static final String ICON = "iconurl";
    protected static final String ID = "id";
    protected static final String JSON = "json";
    protected static final String LAST_NAME = "last_name";
    protected static final String MIDDLE_NAME = "middle_name";
    protected static final String NAME = "name";
    protected static final String OPENID = "openid";

    @Deprecated
    protected static final String PROFILE_IMAGE_URL = "profile_image_url";
    protected static final String PROVINCE = "province";
    protected static final String REFRESHTOKEN = "refreshToken";
    protected static final String REFRESH_TOKEN = "refresh_token";
    protected static final String REGION = "region";

    @Deprecated
    protected static final String SCREEN_NAME = "screen_name";
    protected static final String UID = "uid";
    protected static final String UNIONID = "unionid";
    protected static final String USERID = "UserId";
    protected static final String USID = "usid";
    private static final UMShareConfig mDefaultShareConfig = new UMShareConfig();
    protected UMShareConfig mShareConfig;
    protected WeakReference<Activity> mWeakAct;
    private Context mContext = null;
    private PlatformConfig.Platform mConfig = null;
    protected String VERSION = "";
    private boolean isInit = false;
    protected int mThumbLimit = 32768;

    public int getRequestCode() {
        return 0;
    }

    public abstract String getVersion();

    public boolean isHasAuthListener() {
        return true;
    }

    public boolean isSupportAuth() {
        return false;
    }

    public abstract boolean share(ShareContent shareContent, UMShareListener uMShareListener);

    public UMAuthListener getAuthListener(UMAuthListener uMAuthListener) {
        return uMAuthListener != null ? uMAuthListener : new UMAuthListener() { // from class: com.umeng.socialize.handler.UMSSOHandler.2
            @Override // com.umeng.socialize.UMAuthListener
            public void onCancel(SHARE_MEDIA share_media, int i6) {
                SLog.E(UmengText.CHECK.LISTENRNULL);
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onComplete(SHARE_MEDIA share_media, int i6, Map<String, String> map) {
                SLog.E(UmengText.CHECK.LISTENRNULL);
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onError(SHARE_MEDIA share_media, int i6, Throwable th) {
                SLog.E(UmengText.CHECK.LISTENRNULL);
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        };
    }

    public PlatformConfig.Platform getConfig() {
        return this.mConfig;
    }

    public Context getContext() {
        return this.mContext;
    }

    protected Activity getCurrentActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = this.mWeakAct;
        if (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    public String getGender(Object obj) {
        String str = StringName.male;
        String str2 = StringName.female;
        if (obj == null) {
            return "";
        }
        if (!(obj instanceof String)) {
            if (!(obj instanceof Integer)) {
                return obj.toString();
            }
            Integer num = (Integer) obj;
            if (num.intValue() != 1) {
                if (num.intValue() != 0) {
                    return obj.toString();
                }
                return str2;
            }
            return str;
        }
        if (!obj.equals(t.f36152m) && !obj.equals("1") && !obj.equals("男")) {
            if (!obj.equals("f") && !obj.equals("0") && !obj.equals("女")) {
                return obj.toString();
            }
            return str2;
        }
        return str;
    }

    public String getSDKVersion() {
        return "";
    }

    protected final UMShareConfig getShareConfig() {
        UMShareConfig uMShareConfig = this.mShareConfig;
        return uMShareConfig == null ? mDefaultShareConfig : uMShareConfig;
    }

    public UMShareListener getShareListener(UMShareListener uMShareListener) {
        return uMShareListener != null ? uMShareListener : new UMShareListener() { // from class: com.umeng.socialize.handler.UMSSOHandler.1
            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA share_media) {
                SLog.E(UmengText.CHECK.LISTENRNULL);
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA share_media, Throwable th) {
                SLog.E(UmengText.CHECK.LISTENRNULL);
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA share_media) {
                SLog.E(UmengText.CHECK.LISTENRNULL);
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        };
    }

    public boolean isAuthorize() {
        SLog.E(UmengText.CHECK.NO_SUPPORT_AUTH);
        return true;
    }

    public boolean isInstall() {
        SLog.E(UmengText.CHECK.NO_SUPPORT_INSTALL);
        return true;
    }

    public boolean isSupport() {
        SLog.E(UmengText.CHECK.NO_SUPPORT_SDKL);
        return true;
    }

    public void onCreate(Context context, PlatformConfig.Platform platform) {
        SLog.E("xxxxxx UMSSOHandler 7.3.2");
        this.mContext = ContextUtil.getContext();
        this.mConfig = platform;
        if (context instanceof Activity) {
            this.mWeakAct = new WeakReference<>((Activity) context);
        }
        if (this.isInit) {
            return;
        }
        SLog.mutlI(UmengText.INTER.PINFO, UmengText.INTER.getVersion(platform.getName().getName()) + getVersion(), UmengText.INTER.HANDLERID + toString());
        this.isInit = true;
    }

    public final void setShareConfig(UMShareConfig uMShareConfig) {
        this.mShareConfig = uMShareConfig;
    }

    public Uri getImageContentUri(File file) {
        String absolutePath = file.getAbsolutePath();
        Context origApplicationContext = StubApp.getOrigApplicationContext(this.mContext.getApplicationContext());
        ContentResolver contentResolver = origApplicationContext.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor query = contentResolver.query(uri, new String[]{bm.f41039d}, "_data=? ", new String[]{absolutePath}, null);
        if (query != null && query.moveToFirst()) {
            int i6 = query.getInt(query.getColumnIndex(bm.f41039d));
            try {
                query.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + i6);
        }
        if (file.exists()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            return origApplicationContext.getContentResolver().insert(uri, contentValues);
        }
        return null;
    }

    public void onResume() {
    }

    public void release() {
    }

    public void authorize(UMAuthListener uMAuthListener) {
    }

    public void deleteAuth(UMAuthListener uMAuthListener) {
    }

    public void getPlatformInfo(UMAuthListener uMAuthListener) {
    }

    public void setAuthListener(UMAuthListener uMAuthListener) {
    }

    public void onActivityResult(int i6, int i7, Intent intent) {
    }
}
