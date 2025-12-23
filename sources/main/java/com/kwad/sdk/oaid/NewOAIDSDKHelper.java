package com.kwad.sdk.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NewOAIDSDKHelper {
    private static boolean mIsRequestIng;
    private static boolean sGetOaidFail;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void OnOAIDValid(String str);
    }

    static /* synthetic */ boolean access$002(boolean z5) {
        sGetOaidFail = true;
        return true;
    }

    static /* synthetic */ boolean access$102(boolean z5) {
        mIsRequestIng = false;
        return false;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean isSupport() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.NewOAIDSDKHelper.1
                public void onSupport(IdSupplier idSupplier) {
                }
            }.onSupport((IdSupplier) null);
            e.a();
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, NewOAIDSDKHelper.class.getClassLoader());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class IIdentifierListenerImpl implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListenerImpl(long j6, a aVar) {
            this.mStartTime = j6;
            this.mOaidListener = aVar;
        }

        public void onSupport(IdSupplier idSupplier) {
            System.currentTimeMillis();
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    this.mOaidListener.OnOAIDValid(oaid);
                } else {
                    NewOAIDSDKHelper.access$002(true);
                }
            }
            NewOAIDSDKHelper.access$102(false);
        }
    }

    public static void a(Context context, a aVar) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
            return;
        }
        if (mIsRequestIng) {
            return;
        }
        mIsRequestIng = true;
        try {
            MdidSdkHelper.InitSdk(StubApp.getOrigApplicationContext(context.getApplicationContext()), true, new IIdentifierListenerImpl(System.currentTimeMillis(), aVar));
            System.currentTimeMillis();
        } catch (Throwable unused) {
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }
}
