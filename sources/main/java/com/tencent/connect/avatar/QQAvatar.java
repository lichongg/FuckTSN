package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QQAvatar extends BaseApi {
    public static final String FROM_SDK_AVATAR_SET_IMAGE = "FROM_SDK_AVATAR_SET_IMAGE";

    /* renamed from: a, reason: collision with root package name */
    private IUiListener f40335a;

    private Intent a(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ImageActivity.class);
        return intent;
    }

    public void setAvatar(Activity activity, Uri uri, IUiListener iUiListener, int i6) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f40335a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f40335a = iUiListener;
        Bundle bundle = new Bundle();
        bundle.putString("picture", uri.toString());
        bundle.putInt("exitAnim", i6);
        bundle.putString("appid", this.f40366c.getAppId());
        bundle.putString("access_token", this.f40366c.getAccessToken());
        bundle.putLong("expires_in", this.f40366c.getExpireTimeInSecond());
        bundle.putString("openid", this.f40366c.getOpenId());
        Intent a6 = a(activity);
        Bundle a7 = m.a(this.f40366c.getOpenId(), Constants.VIA_SET_AVATAR, Constants.VIA_REPORT_TYPE_SET_AVATAR, "18", this.f40366c.getAppId());
        a6.putExtra(Constants.KEY_PASS_REPORT_VIA_TIMELY, true);
        a6.putExtra(Constants.KEY_PASS_REPORT_VIA_PARAM, a7);
        a(activity, bundle, a6);
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f40335a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f40335a = iUiListener;
        if (!k.b(activity)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (k.c(activity, "8.0.0") < 0) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String a6 = m.a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_avatar_edit?");
        if (!TextUtils.isEmpty(a6)) {
            if (a6.length() > 20) {
                a6 = a6.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(a6), 2));
        }
        String appId = this.f40366c.getAppId();
        String openId = this.f40366c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openId), 2));
        }
        String b6 = m.b(activity, uri);
        if (!TextUtils.isEmpty(b6)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&set_uri=" + Base64.encodeToString(m.j(uri.toString()), 2));
            } catch (Exception e6) {
                SLog.e("QQAvatar", "Exception", e6);
            }
        }
        if (!TextUtils.isEmpty(b6)) {
            stringBuffer.append("&set_path=" + Base64.encodeToString(m.j(b6), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(m.j(Constants.SDK_VERSION), 2));
        SLog.v("QQAVATAR", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.tencent.mobileqq");
        intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_AVATAR, iUiListener);
        a(activity, Constants.REQUEST_EDIT_AVATAR, intent, false);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f40335a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f40335a = iUiListener;
        if (!k.b(activity)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (k.c(activity, "8.0.5") < 0) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String a6 = m.a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_dynamic_avatar_edit?");
        if (!TextUtils.isEmpty(a6)) {
            if (a6.length() > 20) {
                a6 = a6.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(a6), 2));
        }
        String appId = this.f40366c.getAppId();
        String openId = this.f40366c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openId), 2));
        }
        String b6 = m.b(activity, uri);
        if (!TextUtils.isEmpty(b6)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&video_uri=");
                stringBuffer.append(Base64.encodeToString(m.j(uri.toString()), 2));
            } catch (Exception e6) {
                SLog.e("QQAvatar", "Exception", e6);
            }
        }
        if (!TextUtils.isEmpty(b6)) {
            stringBuffer.append("&video_path=" + Base64.encodeToString(m.j(b6), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(m.j(Constants.SDK_VERSION), 2));
        SLog.v("QQAVATAR", "-->set dynamic avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.tencent.mobileqq");
        intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_DYNAMIC_AVATAR, iUiListener);
        a(activity, Constants.REQUEST_EDIT_DYNAMIC_AVATAR, intent, false);
    }

    public QQAvatar(QQToken qQToken) {
        super(qQToken);
    }

    private void a(Activity activity, Bundle bundle, Intent intent) {
        a(bundle);
        intent.putExtra(Constants.KEY_ACTION, "action_avatar");
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_AVATER, this.f40335a);
        a(activity, intent, Constants.REQUEST_AVATER);
    }

    private void a(Bundle bundle) {
        QQToken qQToken = this.f40366c;
        if (qQToken != null) {
            bundle.putString("appid", qQToken.getAppId());
            if (this.f40366c.isSessionValid()) {
                bundle.putString(Constants.PARAM_KEY_STR, this.f40366c.getAccessToken());
                bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
            }
            String openId = this.f40366c.getOpenId();
            if (openId != null) {
                bundle.putString("hopenid", openId);
            }
            bundle.putString("platform", "androidqz");
            try {
                bundle.putString("pf", g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString("pf", Constants.DEFAULT_PF));
            } catch (Exception e6) {
                e6.printStackTrace();
                bundle.putString("pf", Constants.DEFAULT_PF);
            }
        }
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
    }
}
