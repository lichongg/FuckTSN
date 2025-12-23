package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.mobads.sdk.internal.ay;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;
import com.tencent.connect.api.QQAuthManage;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.commonchannel.CommonChannelApi;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialOperation;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.b.b;
import com.tencent.open.im.IM;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    public static boolean USE_ONE_HOUR;

    /* renamed from: c, reason: collision with root package name */
    private static Tencent f40693c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f40694d;

    /* renamed from: a, reason: collision with root package name */
    private final c f40695a;

    /* renamed from: b, reason: collision with root package name */
    private String f40696b;

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.Tencent", "checkManifestConfig exception", th);
        }
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
            return true;
        } catch (PackageManager.NameNotFoundException unused2) {
            SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
            return false;
        } catch (Throwable th2) {
            SLog.e("openSDK_LOG.Tencent", "checkManifestConfig exception", th2);
            return true;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context, String str2) {
        Tencent createInstance;
        synchronized (Tencent.class) {
            try {
                createInstance = createInstance(str, context);
                SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
                a("createInstance_authority", "appid", str, "authorities", str2);
                if (createInstance != null) {
                    createInstance.f40696b = str2;
                } else {
                    SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return createInstance;
    }

    public static Map<String, String> parseMiniParameters(Intent intent) {
        a("parseMiniParameters", new Object[0]);
        HashMap hashMap = new HashMap();
        if (intent == null) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return hashMap;
        }
        try {
            String stringExtra = intent.getStringExtra("appParameter");
            if (TextUtils.isEmpty(stringExtra)) {
                Uri data = intent.getData();
                if (data == null) {
                    SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
                    return hashMap;
                }
                String uri = data.toString();
                if (TextUtils.isEmpty(uri)) {
                    SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
                    return hashMap;
                }
                String substring = uri.substring(uri.lastIndexOf(63) + 1);
                if (TextUtils.isEmpty(substring)) {
                    SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
                    return hashMap;
                }
                SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + substring);
                for (String str : substring.split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    }
                }
            } else {
                SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
                JSONObject jSONObject = new JSONObject(stringExtra);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            }
            return hashMap;
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e6);
            return hashMap;
        }
    }

    public static void setIsPermissionGranted(boolean z5) {
        String str;
        SLog.i("openSDK_LOG.Tencent", "setIsPermissionGranted, isPermissionGranted: " + z5);
        if (z5) {
            f.a().a(g.a());
            str = f.a().b();
            if (str == null || str.isEmpty()) {
                str = Build.MODEL;
            }
        } else {
            str = "";
        }
        setIsPermissionGranted(z5, str);
    }

    public void initSessionCache(JSONObject jSONObject) {
        a("initSessionCache", new Object[0]);
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            SLog.i("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (Exception e6) {
            SLog.i("QQToken", "initSessionCache " + e6.toString());
        }
    }

    public boolean isQQInstalled(Context context) {
        boolean b6 = k.b(context);
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + b6);
        a("isQQInstalled", Boolean.valueOf(b6));
        return b6;
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        a("login_scope", Constants.PARAM_SCOPE, str);
        return this.f40695a.a(activity, str, iUiListener);
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        a("loginServerSide_activity", Constants.PARAM_SCOPE, str);
        return this.f40695a.a(activity, str + ",server_side", iUiListener);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar", new Object[0]);
        String string = bundle.getString("picture");
        new QQAvatar(this.f40695a.b()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        a("startIMConversation", "chatType", str, "uin", str2, Constants.PARAM_PKG_NAME, str3);
        return new IM(getQQToken()).startIMConversation(activity, str, str2, str3);
    }

    public static synchronized String getAuthorities(String str) {
        synchronized (Tencent.class) {
            a("getAuthorities", "appid", str);
            if (TextUtils.isEmpty(str)) {
                SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
                return null;
            }
            Tencent tencent = f40693c;
            if (tencent != null) {
                return str.equals(tencent.getAppId()) ? f40693c.f40696b : "";
            }
            SLog.i("openSDK_LOG.Tencent", "sInstance == null");
            return null;
        }
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleResultData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("handleResultData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean isPermissionNotGranted() {
        return !f40694d || TextUtils.isEmpty(f.a().b());
    }

    public static boolean isSupportPushToQZone(Context context) {
        boolean z5 = k.c(context, "5.9.5") >= 0;
        SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z5);
        a("isSupportPushToQZone", Boolean.valueOf(z5));
        return z5;
    }

    public static boolean isSupportShareToQQ(Context context) {
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z5 = true;
        if (m.c(context) && k.a(context, Constants.PACKAGE_QQ_PAD) != null) {
            a("isSupportShareToQQ", Boolean.TRUE);
            return true;
        }
        if (k.c(context, "4.1") < 0 && k.a(context, Constants.PACKAGE_TIM) == null) {
            z5 = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z5);
        a("isSupportShareToQQ", Boolean.valueOf(z5));
        return z5;
    }

    public static boolean onActivityResultData(int i6, int i7, Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i6);
        sb.append(", resultcode = ");
        sb.append(i7);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("onActivityResultData", "requestCode", Integer.valueOf(i6), "resultCode", Integer.valueOf(i7));
        return UIListenerManager.getInstance().onActivityResult(i6, i7, intent, iUiListener);
    }

    public static void resetQQAppInfoCache() {
        k.a("com.tencent.mobileqq");
    }

    public static void resetTimAppInfoCache() {
        k.a(Constants.PACKAGE_TIM);
    }

    public static void setCustomLogger(Tracer tracer) {
        SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
        a("setCustomLogger", new Object[0]);
        SLog.getInstance().setCustomLogger(tracer);
    }

    public void bindQQGroup(Activity activity, String str, String str2, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "bindQQGroup()");
        a("bindQQGroup", "organizationId", str, "organizationName", str2);
        new SocialOperation(getQQToken()).bindQQGroup(activity, str, str2, iUiListener);
    }

    public void callCommonChannelApi(Activity activity, Bundle bundle, IUiListener iUiListener) {
        c cVar = this.f40695a;
        SLog.i("openSDK_LOG.Tencent", "callCommonChannelApi ret: " + new CommonChannelApi(cVar, cVar.b()).launchQQ(activity, bundle, iUiListener));
    }

    public void checkLogin(IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "checkLogin()");
        a("checkLogin", new Object[0]);
        this.f40695a.a(iUiListener);
    }

    public String getAccessToken() {
        String accessToken = this.f40695a.b().getAccessToken();
        SLog.i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + accessToken);
        a("getAccessToken", new Object[0]);
        return accessToken;
    }

    public String getAppId() {
        String appId = this.f40695a.b().getAppId();
        SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
        a("getAppId", appId);
        return appId;
    }

    public long getExpiresIn() {
        long expireTimeInSecond = this.f40695a.b().getExpireTimeInSecond();
        SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
        a("getExpiresIn", Long.valueOf(expireTimeInSecond));
        return expireTimeInSecond;
    }

    public String getOpenId() {
        String openId = this.f40695a.b().getOpenId();
        SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
        a("getOpenId", new Object[0]);
        return openId;
    }

    public QQToken getQQToken() {
        SLog.i("openSDK_LOG.Tencent", "getQQToken()");
        a("getQQToken", new Object[0]);
        return this.f40695a.b();
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("handleLoginData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public boolean isSessionValid() {
        boolean c6 = this.f40695a.c();
        SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + c6);
        a("isSessionValid", Boolean.valueOf(c6));
        return c6;
    }

    public boolean isSupportSSOLogin(Activity activity) {
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z5 = true;
        if (m.c(activity) && k.a((Context) activity, Constants.PACKAGE_QQ_PAD) != null) {
            a("isSupportSSOLogin", Boolean.TRUE);
            return true;
        }
        if (k.c(activity, "4.1") < 0 && k.d(activity, "1.1") < 0) {
            z5 = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z5);
        a("isSupportSSOLogin", Boolean.valueOf(z5));
        return z5;
    }

    public void joinQQGroup(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "joinQQGroup()");
        a("joinQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).joinGroup(activity, str, iUiListener);
    }

    public JSONObject loadSession(String str) {
        JSONObject loadSession = this.f40695a.b().loadSession(str);
        StringBuilder sb = new StringBuilder();
        sb.append("loadSession() appid ");
        sb.append(str);
        sb.append(", length=");
        sb.append(loadSession != null ? loadSession.length() : 0);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("loadSession", "appid", str);
        return loadSession;
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, boolean z5, String str2, String str3, String str4) {
        SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        a("loginWithOEM", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z5), "registerChannel", str2, "installChannel", str3, "businessId", str4);
        return this.f40695a.a(activity, str, iUiListener, z5, str2, str3, str4);
    }

    public void logout(Context context) {
        SLog.i("openSDK_LOG.Tencent", "logout()");
        a(ay.f10666b, new Object[0]);
        this.f40695a.b().setAccessToken(null, "0");
        this.f40695a.b().setOpenId(null);
        this.f40695a.b().removeSession(this.f40695a.b().getAppId());
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
        a("publishToQzone", new Object[0]);
        new QzonePublish(activity, this.f40695a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        a("reAuth", Constants.PARAM_SCOPE, str);
        return this.f40695a.b(activity, str, iUiListener);
    }

    public void reportDAU() {
        SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
        a("reportDAU", new Object[0]);
        this.f40695a.a();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        SLog.i("openSDK_LOG.Tencent", "request()");
        a("request", "graphPath", str, "httpMethod", str2);
        return HttpUtils.request(this.f40695a.b(), g.a(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        SLog.i("openSDK_LOG.Tencent", "requestAsync()");
        a("requestAsync", "graphPath", str, "httpMethod", str2);
        HttpUtils.requestAsync(this.f40695a.b(), g.a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("saveSession() length=");
        sb.append(jSONObject != null ? jSONObject.length() : 0);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("saveSession", new Object[0]);
        this.f40695a.b().saveSession(jSONObject);
    }

    public void setAccessToken(String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        a("setAccessToken", new Object[0]);
        this.f40695a.a(str, str2);
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        a("setAvatarByQQ", new Object[0]);
        new QQAvatar(this.f40695a.b()).setAvatarByQQ(activity, uri, iUiListener);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        a("setDynamicAvatar", new Object[0]);
        new QQAvatar(this.f40695a.b()).setDynamicAvatar(activity, uri, iUiListener);
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
        a("setEmotions", new Object[0]);
        new QQEmotion(this.f40695a.b()).setEmotions(activity, arrayList, iUiListener);
    }

    public void setOpenId(String str) {
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
        a("setOpenId", new Object[0]);
        this.f40695a.b(g.a(), str);
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
        a("shareToQQ", new Object[0]);
        if (TextUtils.isEmpty(this.f40696b)) {
            iUiListener.onWarning(-19);
        }
        new QQShare(activity, this.f40695a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
        a("shareToQzone", new Object[0]);
        new QzoneShare(activity, this.f40695a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public void startAuthManagePage(Activity activity, IApiCallback iApiCallback) {
        SLog.i("openSDK_LOG.Tencent", "startAuthManagePage");
        new QQAuthManage(this.f40695a, getQQToken()).gotoManagePage(activity, iApiCallback);
    }

    public int startIMAio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAio()");
        a("startIMAio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_AIO, str, str2);
    }

    public int startIMAudio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
        a("startIMAudio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
    }

    public int startIMVideo(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
        a("startIMVideo", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3) {
        SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
        a("startMiniApp", "miniAppId", str, "miniAppPath", str2, "miniAppVersion", str3);
        return new MiniApp(getQQToken()).startMiniApp(activity, MiniApp.MINIAPP_TYPE_NORMAL, str, "21", str2, str3);
    }

    public void unBindQQGroup(Context context, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "unBindQQGroup()");
        a("unBindQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).unBindGroup(context, str, iUiListener);
    }

    private Tencent(String str, Context context) {
        this.f40695a = c.a(str, context);
        b.a().a(str, context);
        f.a().a(context);
    }

    public static void resetTargetAppInfoCache() {
        k.a();
    }

    public boolean isReady() {
        boolean z5;
        if (isSessionValid() && getOpenId() != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + z5);
        a("isReady", Boolean.valueOf(z5));
        return z5;
    }

    public boolean isQQInstalled(Context context, String str) {
        boolean z5 = k.c(context, str) >= 0;
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled version[" + str + "] = " + z5);
        return z5;
    }

    public int login(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.i("openSDK_LOG.Tencent", "login activity with params");
        a("login_param", new Object[0]);
        return this.f40695a.a(activity, iUiListener, map);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        a("loginServerSide_fragment", Constants.PARAM_SCOPE, str);
        return this.f40695a.a(fragment, str + ",server_side", iUiListener, "");
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            g.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
            if (TextUtils.isEmpty(str)) {
                SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");
                return null;
            }
            Tencent tencent = f40693c;
            if (tencent == null) {
                f40693c = new Tencent(str, context);
            } else if (!str.equals(tencent.getAppId())) {
                f40693c.logout(context);
                f40693c = new Tencent(str, context);
            }
            if (!a(context, str)) {
                return null;
            }
            a("createInstance", "appid", str);
            com.tencent.open.a.f.a().a(i.a(context, str));
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");
            return f40693c;
        }
    }

    public int login(Activity activity, String str, IUiListener iUiListener, boolean z5) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        a("login_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z5));
        return this.f40695a.a(activity, str, iUiListener, z5);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i6, int i7) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar_anim", new Object[0]);
        bundle.putInt("exitAnim", i7);
        activity.overridePendingTransition(i6, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public static void setIsPermissionGranted(boolean z5, String str) {
        SLog.i("openSDK_LOG.Tencent", "setIsPermissionGranted, isPermissionGranted: " + z5 + ", model = " + str);
        if (z5) {
            if (str == null || str.trim().isEmpty()) {
                SLog.e("openSDK_LOG.Tencent", "setIsPermissionGranted error! model= [" + str + "]");
                z5 = false;
            }
            f40694d = z5;
            f.a().a(g.a(), str);
        }
        str = null;
        f40694d = z5;
        f.a().a(g.a(), str);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        a("login_fragment_scope", Constants.PARAM_SCOPE, str);
        return this.f40695a.a(fragment, str, iUiListener, "");
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, boolean z5) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        a("login_fragment_scope_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z5));
        return this.f40695a.a(fragment, str, iUiListener, "", z5);
    }

    private static void a(String str, Object... objArr) {
        b.a().a(str, a(objArr));
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0 || objArr.length % 2 != 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i6 = 0; i6 < length; i6 += 2) {
            if (i6 > 0) {
                sb.append('|');
            }
            sb.append(objArr[i6]);
            sb.append(':');
            sb.append(objArr[i6 + 1]);
        }
        return sb.toString();
    }

    private static void a(String str, Object obj) {
        b.a().a(str, obj);
    }
}
