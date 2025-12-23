package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.acse.ottn.l3;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.stub.StubApp;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private IKsAdSDK auA;
    private m auB;
    private final AtomicBoolean mHasInit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final Loader auC = new Loader(0);
    }

    /* synthetic */ Loader(byte b6) {
        this();
    }

    private boolean bc(Context context) {
        try {
            String aX = i.aX(context);
            String aY = i.aY(context);
            if (TextUtils.isEmpty(aX) && TextUtils.isEmpty(aY)) {
                return false;
            }
            if (!TextUtils.isEmpty(aY) && i.L(aY, aX)) {
                i.p(context, aY);
                z(context, aX);
                i.q(context, "");
                aX = aY;
            }
            return !TextUtils.isEmpty(aX);
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
            return false;
        }
    }

    private Loader() {
        this.auB = null;
        this.mHasInit = new AtomicBoolean(false);
    }

    @NonNull
    @MainThread
    static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                Object invoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod(l3.f4736f, null).invoke(null, null);
                if (invoke == null) {
                    throw new RuntimeException("Can not get sdk form " + classLoader);
                }
                iKsAdSDK = (IKsAdSDK) invoke;
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
        return iKsAdSDK;
    }

    private static void bd(Context context) {
        try {
            String aZ = i.aZ(context);
            boolean b6 = b.b(context, i.auf, false);
            if (!TextUtils.isEmpty(aZ) && aZ.equals(BuildConfig.VERSION_NAME) && !b6) {
                return;
            }
            String aX = i.aX(context);
            i.p(context, "");
            i.q(context, "");
            b.a(context, i.auf, false);
            j.j(j.u(context, aX));
            i.r(context, BuildConfig.VERSION_NAME);
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
        }
    }

    public static void checkInitSDK(Context context) {
        if (KsAdSDK.sHasInit.get()) {
            return;
        }
        if (context == null) {
            context = KSLifecycleObserver.getInstance().getApplication();
        }
        if (context == null) {
            context = c.Dl();
        }
        KsAdSDK.init(context, SdkConfig.create(b.getString(context, "sdkconfig")));
    }

    public Context getContext() {
        return mContext;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        m mVar = this.auB;
        ClassLoader classLoader = mVar != null ? mVar.getClassLoader() : null;
        if (com.kwad.sdk.api.a.atz.booleanValue()) {
            classLoader = this.auA.getClass().getClassLoader();
            Objects.toString(classLoader);
        }
        Objects.toString(classLoader);
        return classLoader;
    }

    @MainThread
    public Resources getExternalResource() {
        m mVar = this.auB;
        if (mVar != null) {
            return mVar.Dm();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        m mVar = this.auB;
        return mVar != null ? mVar.getClassLoader() : getClass().getClassLoader();
    }

    public IKsAdSDK init(@NonNull Context context, ClassLoader classLoader) {
        if (this.mHasInit.get()) {
            return this.auA;
        }
        mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        bd(context);
        if (bc(context)) {
            this.auB = m.a(context, classLoader, i.aX(context));
        }
        boolean booleanValue = com.kwad.sdk.api.a.atz.booleanValue();
        m mVar = this.auB;
        if (mVar == null && booleanValue) {
            ClassLoader initDex = DexLoader.initDex(context, classLoader);
            if (initDex == null) {
                return null;
            }
            initDex.toString();
            this.auA = a(initDex);
            Objects.toString(this.auA);
        } else if (mVar == null) {
            IKsAdSDK a6 = a(getClass().getClassLoader());
            this.auA = a6;
            a6.setIsExternal(false);
        } else {
            IKsAdSDK Dn = mVar.Dn();
            this.auA = Dn;
            Dn.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.auA);
        if (this.auB != null) {
            Dq();
        }
        this.mHasInit.set(true);
        return this.auA;
    }

    public boolean isExternalLoaded() {
        return this.auB != null;
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.auA.newInstance(cls);
    }

    public void rest() {
        this.mHasInit.set(false);
        mContext = null;
        this.auA = null;
        this.auB = null;
    }

    private static void Dq() {
        try {
            int Df = com.kwad.sdk.api.c.Df();
            if (Df > 0) {
                try {
                    f.aW(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(f.aW(mContext));
                    f.aW(mContext).cp(Df);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static Loader get() {
        return a.auC;
    }

    private static void z(Context context, String str) {
        j.y(context, str);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.auA.newComponentProxy(cls, obj);
    }
}
