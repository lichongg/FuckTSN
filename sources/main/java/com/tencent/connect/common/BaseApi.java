package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class BaseApi {
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM;
    public static String registerChannel;

    /* renamed from: b, reason: collision with root package name */
    protected c f40365b;

    /* renamed from: c, reason: collision with root package name */
    protected QQToken f40366c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class TempRequestListener implements IRequestListener {

        /* renamed from: b, reason: collision with root package name */
        private final IUiListener f40368b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f40369c;

        public TempRequestListener(IUiListener iUiListener) {
            this.f40368b = iUiListener;
            this.f40369c = new Handler(g.a().getMainLooper()) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.f40368b.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.f40368b.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Message obtainMessage = this.f40369c.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.f40369c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Message obtainMessage = this.f40369c.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.f40369c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Message obtainMessage = this.f40369c.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.f40369c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Message obtainMessage = this.f40369c.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.f40369c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message obtainMessage = this.f40369c.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.f40369c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.f40369c.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.f40369c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.f40369c.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.f40369c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Message obtainMessage = this.f40369c.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.f40369c.sendMessage(obtainMessage);
        }
    }

    public BaseApi(c cVar, QQToken qQToken) {
        this.f40365b = cVar;
        this.f40366c = qQToken;
    }

    protected Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString(IjkMediaMeta.IJKM_KEY_FORMAT, "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", f.a().c(g.a()));
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        QQToken qQToken = this.f40366c;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString("access_token", this.f40366c.getAccessToken());
            bundle.putString("oauth_consumer_key", this.f40366c.getAppId());
            bundle.putString("openid", this.f40366c.getOpenId());
        }
        SharedPreferences sharedPreferences = g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (!isOEM) {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
            return bundle;
        }
        bundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + FaceEnvironment.OS + "-" + registerChannel + "-" + businessId);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f40366c.getAppId());
        if (this.f40366c.isSessionValid()) {
            bundle.putString(Constants.PARAM_KEY_STR, this.f40366c.getAccessToken());
            bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
        }
        String openId = this.f40366c.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + FaceEnvironment.OS + "-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
    
        if (com.tencent.open.utils.k.b(com.tencent.open.utils.g.a(), r0) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected android.content.Intent c() {
        /*
            r3 = this;
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            android.content.Context r1 = com.tencent.open.utils.g.a()
            boolean r1 = com.tencent.open.utils.m.c(r1)
            java.lang.String r2 = "com.tencent.open.agent.AgentActivity"
            if (r1 == 0) goto L21
            java.lang.String r1 = "com.tencent.minihd.qq"
            r0.setClassName(r1, r2)
            android.content.Context r1 = com.tencent.open.utils.g.a()
            boolean r1 = com.tencent.open.utils.k.b(r1, r0)
            if (r1 == 0) goto L21
            goto L40
        L21:
            java.lang.String r1 = "com.tencent.mobileqq"
            r0.setClassName(r1, r2)
            android.content.Context r1 = com.tencent.open.utils.g.a()
            boolean r1 = com.tencent.open.utils.k.b(r1, r0)
            if (r1 == 0) goto L31
            goto L40
        L31:
            java.lang.String r1 = "com.tencent.tim"
            r0.setClassName(r1, r2)
            android.content.Context r1 = com.tencent.open.utils.g.a()
            boolean r1 = com.tencent.open.utils.k.b(r1, r0)
            if (r1 == 0) goto L41
        L40:
            return r0
        L41:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.common.BaseApi.c():android.content.Intent");
    }

    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
    }

    protected Intent c(String str) {
        Intent intent = new Intent();
        Intent b6 = b(str);
        if (b6 == null || b6.getComponent() == null) {
            return null;
        }
        intent.setClassName(b6.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        Bundle a6 = a();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            a6.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(HttpUtils.encodeUrl(a6));
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
    
        if (com.tencent.open.utils.k.a(com.tencent.open.utils.g.a(), r0) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected android.content.Intent b(java.lang.String r3) {
        /*
            r2 = this;
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            android.content.Context r1 = com.tencent.open.utils.g.a()
            boolean r1 = com.tencent.open.utils.m.c(r1)
            if (r1 == 0) goto L1f
            java.lang.String r1 = "com.tencent.minihd.qq"
            r0.setClassName(r1, r3)
            android.content.Context r1 = com.tencent.open.utils.g.a()
            boolean r1 = com.tencent.open.utils.k.a(r1, r0)
            if (r1 == 0) goto L1f
            goto L3e
        L1f:
            java.lang.String r1 = "com.tencent.mobileqq"
            r0.setClassName(r1, r3)
            android.content.Context r1 = com.tencent.open.utils.g.a()
            boolean r1 = com.tencent.open.utils.k.a(r1, r0)
            if (r1 == 0) goto L2f
            goto L3e
        L2f:
            java.lang.String r1 = "com.tencent.tim"
            r0.setClassName(r1, r3)
            android.content.Context r3 = com.tencent.open.utils.g.a()
            boolean r3 = com.tencent.open.utils.k.a(r3, r0)
            if (r3 == 0) goto L3f
        L3e:
            return r0
        L3f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.common.BaseApi.b(java.lang.String):android.content.Intent");
    }

    public void releaseResource() {
    }

    protected void a(StringBuilder sb, Activity activity) {
        if (sb.indexOf("?") < 0) {
            sb.append("?");
        } else {
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        sb.append(Constants.JumpUrlConstants.URL_KEY_SRC);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(Constants.JumpUrlConstants.SRC_TYPE_APP);
        String appId = this.f40366c.getAppId();
        String openId = this.f40366c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            a(sb, "app_id", appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            a(sb, Constants.JumpUrlConstants.URL_KEY_OPENID, m.k(openId));
        }
        String a6 = m.a(activity);
        if (!TextUtils.isEmpty(a6)) {
            if (a6.length() > 20) {
                a6 = a6.substring(0, 20) + "...";
            }
            a(sb, "app_name", m.k(a6));
        }
        a(sb, "sdk_version", m.k(Constants.SDK_VERSION));
    }

    protected void a(StringBuilder sb, String str, String str2) {
        sb.append(ContainerUtils.FIELD_DELIMITER);
        sb.append(str);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(m.f(str2));
    }

    private Intent a(Activity activity, Intent intent, Map<String, Object> map) {
        Intent intent2 = new Intent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), (Class<?>) AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        if (map != null) {
            try {
                if (map.containsKey(Constants.KEY_RESTORE_LANDSCAPE)) {
                    intent2.putExtra(Constants.KEY_RESTORE_LANDSCAPE, ((Boolean) map.get(Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
                    return intent2;
                }
            } catch (Exception e6) {
                SLog.e("openSDK_LOG.BaseApi", "Exception", e6);
                return intent2;
            }
        }
        return intent2;
    }

    protected void a(Activity activity, int i6, Intent intent, boolean z5) {
        Intent intent2 = new Intent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), (Class<?>) AssistActivity.class);
        if (z5) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        try {
            activity.startActivityForResult(intent2, i6);
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.BaseApi", "startAssistActivity exception", e6);
        }
    }

    protected void a(Activity activity, Intent intent, int i6) {
        a(activity, intent, i6, (Map<String, Object>) null);
    }

    protected void a(Activity activity, Intent intent, int i6, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i6);
        try {
            activity.startActivityForResult(a(activity, intent, map), i6);
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.BaseApi", "startAssitActivity exception", e6);
        }
    }

    protected void a(Fragment fragment, Intent intent, int i6, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i6);
        try {
            fragment.startActivityForResult(a(fragment.getActivity(), intent, map), i6);
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.BaseApi", "startAssitActivity exception", e6);
        }
    }

    protected void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new TDialog(activity, "", "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.encodeUrl(bundle), null, this.f40366c).show();
    }
}
