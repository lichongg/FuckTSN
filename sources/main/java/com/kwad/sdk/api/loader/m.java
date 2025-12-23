package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.g;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class m {
    private final String auu;
    private final String auv;
    private final String auw;
    private Resources aux;
    private ClassLoader auy;
    private IKsAdSDK auz;

    static synchronized m a(Context context, ClassLoader classLoader, String str) {
        m b6;
        synchronized (m.class) {
            try {
                b6 = b(context, classLoader, j.v(context, str), j.w(context, str), j.x(context, str));
            } catch (Throwable th) {
                com.kwad.sdk.api.c.m(th);
                return null;
            }
        }
        return b6;
    }

    private void Do() {
        if (TextUtils.isEmpty(this.auu)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.auu);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    final Resources Dm() {
        return this.aux;
    }

    final IKsAdSDK Dn() {
        return this.auz;
    }

    final ClassLoader getClassLoader() {
        return this.auy;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.auu + "', mDexDir='" + this.auv + "', mNativeLibDir='" + this.auw + "', mResource=" + this.aux + ", mClassLoader=" + this.auy + ", mKsSdk=" + this.auz + '}';
    }

    private m(String str, String str2, String str3) {
        this.auu = str;
        this.auv = str2;
        this.auw = str3;
    }

    static m b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                        file.setReadOnly();
                    }
                } catch (Throwable unused) {
                }
                m mVar = new m(str, str2, str3);
                mVar.a(context, classLoader);
                return mVar;
            }
            throw new RuntimeException("mApk not a file");
        }
        throw new RuntimeException("mApk is null");
    }

    private void a(Context context, ClassLoader classLoader) {
        Do();
        Resources a6 = w.a(context, context.getResources(), this.auu);
        ClassLoader a7 = g.a(context, classLoader, this.auu, this.auv, this.auw);
        IKsAdSDK a8 = Loader.a(a7);
        this.aux = a6;
        this.auy = a7;
        this.auz = a8;
        if (a8.getClass().getClassLoader() instanceof g.a) {
            int sDKType = a8.getSDKType();
            if (sDKType == 1) {
                return;
            }
            throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
        }
        throw new RuntimeException("classLoader is not expect dynamic classloader:");
    }
}
