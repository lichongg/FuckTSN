package com.tencent.connect.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.stub.StubApp;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private AuthAgent f40297a;

    /* renamed from: b, reason: collision with root package name */
    private QQToken f40298b;

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("bcb3903995", str);
        edit.apply();
    }

    public int b(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQAuth", "reAuth()");
        return this.f40297a.a(activity, str, iUiListener, true, null, false);
    }

    public boolean c() {
        StringBuilder sb = new StringBuilder();
        sb.append("isSessionValid(), result = ");
        sb.append(this.f40298b.isSessionValid() ? "true" : "false");
        SLog.i("openSDK_LOG.QQAuth", sb.toString());
        return this.f40298b.isSessionValid();
    }

    private c(String str, Context context) {
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f40298b = new QQToken(str);
        this.f40297a = new AuthAgent(this.f40298b);
        com.tencent.connect.a.a.c(context, this.f40298b);
        a(context, Constants.SDK_VERSION);
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public QQToken b() {
        return this.f40298b;
    }

    public void b(Context context, String str) {
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.f40298b.setOpenId(str);
        com.tencent.connect.a.a.d(context, this.f40298b);
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --end");
    }

    public static c a(String str, Context context) {
        g.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        c cVar = new c(str, context);
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
        return cVar;
    }

    public int a(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, str, iUiListener, "");
    }

    public int a(Activity activity, String str, IUiListener iUiListener, boolean z5) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, null, str, iUiListener, "", z5);
    }

    public int a(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.i("openSDK_LOG.QQAuth", "login--params");
        return a(activity, (Fragment) null, m.a(map, Constants.KEY_SCOPE, "all"), iUiListener, "", m.a(map, Constants.KEY_QRCODE, false), map);
    }

    public int a(Activity activity, String str, IUiListener iUiListener, String str2) {
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, (Fragment) null, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        FragmentActivity activity = fragment.getActivity();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z5) {
        FragmentActivity activity = fragment.getActivity();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2, z5);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        return a(activity, fragment, str, iUiListener, str2, false);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z5) {
        return a(activity, fragment, str, iUiListener, str2, z5, (Map<String, Object>) null);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z5, Map<String, Object> map) {
        try {
            String a6 = k.a(activity);
            if (a6 != null) {
                String a7 = com.tencent.open.utils.b.a(new File(a6));
                if (!TextUtils.isEmpty(a7)) {
                    SLog.v("openSDK_LOG.QQAuth", "-->login channelId: " + a7);
                    return a(activity, str, iUiListener, z5, a7, a7, "");
                }
            }
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
        }
        SLog.d("openSDK_LOG.QQAuth", "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.f40297a.doLogin(activity, str, iUiListener, false, fragment, z5, map);
    }

    @Deprecated
    public int a(Activity activity, String str, IUiListener iUiListener, boolean z5, String str2, String str3, String str4) {
        SLog.i("openSDK_LOG.QQAuth", "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals("")) {
            str2 = "null";
        }
        if (str3.equals("")) {
            str3 = "null";
        }
        if (str4.equals("")) {
            str4 = "null";
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.f40297a.a(activity, str, iUiListener, false, null, z5);
    }

    public void a() {
        this.f40297a.a((IUiListener) null);
    }

    public void a(IUiListener iUiListener) {
        this.f40297a.b(iUiListener);
    }

    public void a(String str, String str2) {
        SLog.i("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
        this.f40298b.setAccessToken(str, str2);
    }
}
