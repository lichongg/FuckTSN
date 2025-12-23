package cn.jpush.android.service;

import android.app.Application;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.d.a;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JPushInterface;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes2.dex */
public class InitProvider extends ContentProvider {
    private static final String TAG = "InitProvider";
    private Class<?> actionHelperClass;
    private Object actionHelperInstance;
    private Method onJPushMessageReceiveMethod;

    private String getProviderProcessName(Context context) {
        try {
            return context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), InitProvider.class.getName()), 0).processName;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            Context context = getContext();
            if (JConstants.isCallInit.get() && context != null) {
                if (context.checkCallingPermission(context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX) == 0) {
                    if (this.actionHelperClass == null) {
                        this.actionHelperClass = Class.forName(new String(Base64.decode("Y24uanB1c2guYW5kcm9pZC5sb2NhbC5BY3Rpb25IZWxwZXI=", 2)));
                    }
                    if (this.actionHelperInstance == null) {
                        this.actionHelperInstance = this.actionHelperClass.getMethod(new String(Base64.decode("Z2V0SW5zdGFuY2U=", 2)), null).invoke(null, null);
                    }
                    if (this.onJPushMessageReceiveMethod == null) {
                        this.onJPushMessageReceiveMethod = this.actionHelperClass.getMethod(new String(Base64.decode("b25KUHVzaE1lc3NhZ2VSZWNlaXZl", 2)), Context.class, String.class, String.class, Bundle.class);
                    }
                    this.onJPushMessageReceiveMethod.invoke(this.actionHelperInstance, context, str, str2, bundle);
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Application application = (Application) getContext();
            String providerProcessName = getProviderProcessName(application);
            JConstants.getAppContext(application);
            if (application != null && TextUtils.equals(providerProcessName, application.getPackageName())) {
                a.a((Context) application, false);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
