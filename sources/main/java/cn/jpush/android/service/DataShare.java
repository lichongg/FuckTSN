package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import cn.jiguang.android.IDataShare;
import cn.jiguang.bb.f;
import cn.jiguang.bz.a;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class DataShare extends IDataShare.Stub {
    private static final String TAG = "DataShare";
    private static final Map<String, IDataShare> aidlMap = new HashMap();
    private static boolean isBinding;

    public static void setBinding() {
        isBinding = true;
    }

    @Override // cn.jiguang.android.IDataShare
    public Bundle execute(String str, String str2, Bundle bundle) {
        try {
            return JCoreInternalHelper.getInstance().directHandle(JConstants.getAppContext(null), str, str2, bundle);
        } catch (Throwable th) {
            f.j(TAG, "onAction error:" + th);
            return null;
        }
    }

    @Override // cn.jiguang.android.IDataShare
    public IBinder getBinderByType(String str, String str2) {
        return null;
    }

    public static IDataShare getInstance(String str) {
        return aidlMap.get(str);
    }

    public static boolean isBinding() {
        return isBinding;
    }

    @Override // cn.jiguang.android.IDataShare
    public String bind(IDataShare iDataShare, String str) {
        aidlMap.put(str, iDataShare);
        f.c(TAG, str + "'s aidl bound");
        return a.a((Context) null);
    }

    public static void init(IDataShare iDataShare, String str) {
        if (iDataShare != getInstance(str)) {
            aidlMap.put(str, iDataShare);
            f.c(TAG, str + "'s aidl created");
            try {
                Context appContext = JConstants.getAppContext(null);
                if (appContext != null) {
                    String a6 = a.a(appContext);
                    if (appContext.getPackageName().equals(a6)) {
                        iDataShare.bind(new DataShare(), a6);
                    }
                }
            } catch (RemoteException e6) {
                f.l(TAG, "bind failed=" + e6);
            }
        }
        isBinding = false;
    }

    @Override // cn.jiguang.android.IDataShare
    public void onAction(String str, String str2, Bundle bundle) {
        try {
            JCoreInternalHelper.getInstance().directHandle(JConstants.getAppContext(null), str, str2, bundle);
        } catch (Throwable th) {
            f.j(TAG, "onAction error:" + th);
        }
    }
}
