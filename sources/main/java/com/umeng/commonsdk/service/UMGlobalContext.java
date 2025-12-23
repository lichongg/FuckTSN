package com.umeng.commonsdk.service;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMGlobalContext {
    private static final String TAG = "UMGlobalContext";
    private String mAppVersion;
    private String mAppkey;
    private Context mApplicationContext;
    private String mChannel;
    private String mProcessName;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.service.UMGlobalContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final UMGlobalContext f41838a = new UMGlobalContext(null);

        private a() {
        }
    }

    /* synthetic */ UMGlobalContext(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static Context getAppContext(Context context) {
        if (a.f41838a.mApplicationContext == null && context != null) {
            a.f41838a.mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f41838a.mApplicationContext;
    }

    private UMGlobalContext() {
        this.mProcessName = "";
    }

    public String getAppVersion() {
        if (TextUtils.isEmpty(this.mAppVersion)) {
            this.mAppVersion = UMUtils.getAppVersionName(this.mApplicationContext);
        }
        return this.mAppVersion;
    }

    public String getAppkey() {
        if (TextUtils.isEmpty(this.mAppkey)) {
            this.mAppkey = UMConfigure.sAppkey;
        }
        return this.mAppkey;
    }

    public String getChannel() {
        if (TextUtils.isEmpty(this.mChannel)) {
            this.mChannel = UMConfigure.sChannel;
        }
        return this.mChannel;
    }

    public String getProcessName(Context context) {
        if (TextUtils.isEmpty(this.mProcessName)) {
            if (context != null) {
                Context context2 = a.f41838a.mApplicationContext;
                if (context2 != null) {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context2);
                } else {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context);
                }
            } else {
                this.mProcessName = UMFrUtils.getCurrentProcessName(a.f41838a.mApplicationContext);
            }
        }
        return this.mProcessName;
    }

    public static UMGlobalContext getInstance(Context context) {
        if (a.f41838a.mApplicationContext == null && context != null) {
            a.f41838a.mApplicationContext = context;
        }
        return a.f41838a;
    }

    public boolean isMainProcess(Context context) {
        return UMUtils.isMainProgress(context);
    }

    public String toString() {
        if (a.f41838a.mApplicationContext != null) {
            StringBuilder sb = new StringBuilder("[");
            sb.append("appkey:" + this.mAppkey + ",");
            sb.append("channel:" + this.mChannel + ",");
            sb.append("procName:" + this.mProcessName + "]");
            return sb.toString();
        }
        return "uninitialized.";
    }

    public static Context getAppContext() {
        return a.f41838a.mApplicationContext;
    }
}
