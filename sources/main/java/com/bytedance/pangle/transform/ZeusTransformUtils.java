package com.bytedance.pangle.transform;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Keep;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.FileProvider;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.activity.GenerateProxyActivity;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.service.PluginIntentService;
import com.bytedance.pangle.service.PluginService;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper;
import com.bytedance.sdk.openadsdk.api.m;
import com.stub.StubApp;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;

@Keep
/* loaded from: D:\Downloads\app\classes4.dex */
public class ZeusTransformUtils {
    private static final String TAG = "PluginContextUtils";
    public static Class fragmentClazz;
    private static boolean sCanThrowException;
    private static boolean sSupportFragmentWrapper;
    static HashMap<String, WeakReference<Context>> contextCache = new HashMap<>();
    static boolean hasEnsure = false;
    static HashMap<String, Constructor<View>> sConstructorMap = null;

    /* JADX WARN: Code restructure failed: missing block: B:46:0x009e, code lost:
    
        if (android.text.TextUtils.equals(r1, r5) == false) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Context getContextIfNeedWrap(android.content.Context r3, android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            boolean r1 = r4 instanceof com.bytedance.pangle.activity.IPluginActivity
            if (r1 == 0) goto L17
            com.bytedance.pangle.activity.IPluginActivity r4 = (com.bytedance.pangle.activity.IPluginActivity) r4
            java.lang.String r4 = r4.getPluginPkgName()
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 != 0) goto L16
            goto Lbc
        L16:
            return r0
        L17:
            boolean r1 = r4 instanceof com.bytedance.pangle.PluginContext
            if (r1 == 0) goto L2b
            com.bytedance.pangle.PluginContext r4 = (com.bytedance.pangle.PluginContext) r4
            com.bytedance.pangle.plugin.Plugin r3 = r4.mPlugin
            java.lang.String r3 = r3.mPkgName
            boolean r3 = android.text.TextUtils.equals(r3, r5)
            if (r3 == 0) goto L28
            return r0
        L28:
            android.content.Context r3 = r4.mOriginContext
            return r3
        L2b:
            boolean r1 = r4 instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper
            if (r1 == 0) goto L41
            com.bytedance.pangle.wrapper.PluginActivityWrapper r4 = (com.bytedance.pangle.wrapper.PluginActivityWrapper) r4
            com.bytedance.pangle.PluginContext r3 = r4.pluginContext
            com.bytedance.pangle.plugin.Plugin r3 = r3.mPlugin
            java.lang.String r3 = r3.mPkgName
            boolean r3 = android.text.TextUtils.equals(r3, r5)
            if (r3 == 0) goto L3e
            return r0
        L3e:
            android.app.Activity r3 = r4.mOriginActivity
            return r3
        L41:
            isSupportLibIso(r5)
            boolean r1 = r4 instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper
            if (r1 == 0) goto L5a
            com.bytedance.pangle.wrapper.PluginApplicationWrapper r4 = (com.bytedance.pangle.wrapper.PluginApplicationWrapper) r4
            com.bytedance.pangle.PluginContext r3 = r4.mPluginContext
            com.bytedance.pangle.plugin.Plugin r3 = r3.mPlugin
            java.lang.String r3 = r3.mPkgName
            boolean r3 = android.text.TextUtils.equals(r3, r5)
            if (r3 == 0) goto L57
            return r0
        L57:
            android.app.Application r3 = r4.mOriginApplication
            return r3
        L5a:
            android.content.res.Resources r1 = r4.getResources()
            boolean r1 = r1 instanceof com.bytedance.pangle.res.PluginResources
            if (r1 == 0) goto La5
            android.content.res.Resources r4 = r4.getResources()
            com.bytedance.pangle.res.PluginResources r4 = (com.bytedance.pangle.res.PluginResources) r4
            java.lang.String r1 = "pluginPkg"
            java.lang.Object r1 = com.bytedance.pangle.util.FieldUtils.readField(r4, r1)     // Catch: java.lang.Throwable -> L98
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L98
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L98
            if (r2 == 0) goto L9a
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = getAssetPaths(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98
            java.lang.String r2 = "/"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L98
            r1.append(r5)     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = "/version"
            r1.append(r5)     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L98
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Throwable -> L98
            if (r4 != 0) goto La4
            goto Lbc
        L98:
            r3 = move-exception
            goto La1
        L9a:
            boolean r4 = android.text.TextUtils.equals(r1, r5)     // Catch: java.lang.Throwable -> L98
            if (r4 != 0) goto La4
            goto Lbc
        La1:
            com.bytedance.sdk.openadsdk.api.m.j(r3)
        La4:
            return r0
        La5:
            boolean r0 = r4 instanceof android.content.ContextWrapper
            if (r0 == 0) goto Lbc
            java.lang.String r0 = "mBase"
            java.lang.Object r0 = com.bytedance.pangle.util.FieldUtils.readField(r4, r0)     // Catch: java.lang.Throwable -> Lb2
            android.content.Context r0 = (android.content.Context) r0     // Catch: java.lang.Throwable -> Lb2
            goto Lb8
        Lb2:
            android.content.ContextWrapper r4 = (android.content.ContextWrapper) r4
            android.content.Context r0 = r4.getBaseContext()
        Lb8:
            android.content.Context r3 = getContextIfNeedWrap(r3, r0, r5)
        Lbc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.transform.ZeusTransformUtils.getContextIfNeedWrap(android.content.Context, android.content.Context, java.lang.String):android.content.Context");
    }

    private static int[] handleAttrBefore(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(copyOf);
        return copyOf;
    }

    public static View inflate(LayoutInflater layoutInflater, int i6, ViewGroup viewGroup, boolean z5, String str) {
        Context context = layoutInflater.getContext();
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper)) {
            isSupportLibIso(str);
            if (!(context instanceof PluginApplicationWrapper)) {
                Context wrapperContext = wrapperContext(context, str);
                LayoutInflater.Factory factory = layoutInflater.getFactory();
                LayoutInflater.Factory2 factory2 = layoutInflater.getFactory2();
                LayoutInflater layoutInflater2 = (LayoutInflater) wrapperContext.getSystemService("layout_inflater");
                if (isSupportLibIso(str)) {
                    if (factory != null) {
                        try {
                            FieldUtils.writeField(layoutInflater2, "mFactory", factory);
                        } catch (Throwable unused) {
                            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "set Factory failed.");
                        }
                    }
                    if (factory2 != null) {
                        try {
                            FieldUtils.writeField(layoutInflater2, "mFactory2", factory2);
                        } catch (Throwable unused2) {
                            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "set Factory2 failed.");
                        }
                    }
                }
                layoutInflater = layoutInflater2;
            }
        }
        clearConstructorCache();
        View inflate = layoutInflater.inflate(i6, viewGroup, z5);
        clearConstructorCache();
        return inflate;
    }

    public static boolean instanceOf(Class cls, Object obj) {
        return instanceOf(obj, cls);
    }

    public static TypedArray obtainStyledAttributes(Object obj, AttributeSet attributeSet, int[] iArr, String str) {
        if (!(obj instanceof Context)) {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr);
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
        int[] handleAttrBefore = handleAttrBefore(iArr);
        TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
        handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
        return obtainStyledAttributes;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str) {
        if (obj instanceof Context) {
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter);
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void setResult(Object obj, int i6, Intent intent, String str) {
        if (obj instanceof Activity) {
            try {
                Object readField = FieldUtils.readField(obj, "mProxyActivity");
                if (readField == null) {
                    readField = FieldUtils.readField(obj, "mOriginActivity");
                }
                if (readField != null) {
                    MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i6), intent);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i6), intent);
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void startActivity(Object obj, Intent intent, String str) {
        startActivity(obj, intent, null, str);
    }

    public static void startActivityForResult(Object obj, Intent intent, int i6, String str) {
        startActivityForResult(obj, intent, i6, null, str);
    }

    public static Context wrapperContext(Object obj, String str) {
        return wrapperContext(obj, str, null);
    }

    static Activity _getActivity(Object obj, String str) {
        try {
            Activity activity = (Activity) MethodUtils.invokeMethod(obj, "getActivity", new Object[0]);
            Activity activity2 = (Activity) wrapperContext(activity, str);
            if (activity2 instanceof GenerateProxyActivity) {
                return ((GenerateProxyActivity) activity2).mTargetActivity;
            }
            isSupportLibIso(str);
            return (Activity) wrapperContext(activity, str);
        } catch (IllegalAccessException e6) {
            m.j(e6);
            return null;
        } catch (NoSuchMethodException e7) {
            m.j(e7);
            return null;
        } catch (InvocationTargetException e8) {
            m.j(e8);
            return null;
        }
    }

    public static boolean bindService(Object obj, Intent intent, ServiceConnection serviceConnection, int i6, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().bindServiceNative((Context) obj, intent, serviceConnection, i6, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "bindService", new Object[]{intent, serviceConnection, Integer.valueOf(i6)}, new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE})).booleanValue();
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void canThrowException(boolean z5) {
        sCanThrowException = z5;
    }

    public static void clearConstructorCache() {
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                if (sConstructorMap == null) {
                    sConstructorMap = (HashMap) FieldUtils.readStaticField(LayoutInflater.class, "sConstructorMap");
                }
                for (String str : new HashSet(sConstructorMap.keySet())) {
                    if (!str.startsWith("android.view.") && !str.startsWith("android.widget.") && !str.startsWith("android.webkit.") && str.contains(".")) {
                        sConstructorMap.remove(str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static Context convertProxy2PluginActivity(Context context) {
        try {
            return context instanceof GenerateProxyActivity ? (Activity) FieldUtils.readField(context, "mTargetActivity") : context;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "convertProxy2PluginActivity failed.", th);
            return context;
        }
    }

    private static void ensureFragmentActivity() {
        if (hasEnsure) {
            return;
        }
        try {
            try {
                fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
        }
        hasEnsure = true;
    }

    public static String getAssetPaths(AssetManager assetManager) {
        int i6;
        int i7;
        StringBuilder sb = new StringBuilder();
        if (assetManager == null) {
            return "";
        }
        try {
            i6 = Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "TransformUtils GetAssetsPaths error. ", th);
        }
        if (i6 < 28) {
            if (i6 == 27) {
                i7 = Build.VERSION.PREVIEW_SDK_INT;
                if (i7 > 0) {
                }
            }
            int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            for (int i8 = 0; i8 < intValue; i8++) {
                try {
                    String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i8 + 1));
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            return sb.toString();
        }
        Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
            }
        }
        return sb.toString();
    }

    public static Context getContext(Object obj, String str) {
        try {
            Context context = (Context) MethodUtils.invokeMethod(obj, "getContext", new Object[0]);
            return (isSupportLibIso(str) || !instanceOfFragmentActivity(context)) ? context instanceof Activity ? wrapperContext(context, str) : context instanceof Application ? wrapperContext(context, str) : context instanceof PluginContext ? context : wrapperContext(context, str) : wrapperContext(context, str);
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static int getIdentifier(Object obj, String str, String str2, String str3, String str4) {
        if (!(obj instanceof Resources)) {
            try {
                return ((Integer) MethodUtils.invokeMethod(obj, "getIdentifier", str, str2, str3)).intValue();
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
        Resources resources = (Resources) obj;
        if (!TextUtils.equals(FaceEnvironment.OS, str3)) {
            str3 = str4;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        if (android.text.TextUtils.equals(r0, r4) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.res.Resources getResources(java.lang.Object r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "getResources"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L55
            java.lang.Object r3 = com.bytedance.pangle.util.MethodUtils.invokeMethod(r3, r0, r1)     // Catch: java.lang.Exception -> L55
            android.content.res.Resources r3 = (android.content.res.Resources) r3     // Catch: java.lang.Exception -> L55
            if (r3 != 0) goto Lf
            r3 = 0
            return r3
        Lf:
            boolean r0 = r3 instanceof com.bytedance.pangle.res.PluginResources     // Catch: java.lang.Exception -> L55
            if (r0 == 0) goto L4a
            java.lang.String r0 = "pluginPkg"
            java.lang.Object r0 = com.bytedance.pangle.util.FieldUtils.readField(r3, r0)     // Catch: java.lang.Exception -> L55
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L55
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L55
            if (r1 == 0) goto L43
            android.content.res.AssetManager r0 = r3.getAssets()     // Catch: java.lang.Exception -> L55
            java.lang.String r0 = getAssetPaths(r0)     // Catch: java.lang.Exception -> L55
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L55
            java.lang.String r2 = "/"
            r1.<init>(r2)     // Catch: java.lang.Exception -> L55
            r1.append(r4)     // Catch: java.lang.Exception -> L55
            java.lang.String r2 = "/version"
            r1.append(r2)     // Catch: java.lang.Exception -> L55
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L55
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Exception -> L55
            if (r0 == 0) goto L4a
            goto L49
        L43:
            boolean r0 = android.text.TextUtils.equals(r0, r4)     // Catch: java.lang.Exception -> L55
            if (r0 == 0) goto L4a
        L49:
            return r3
        L4a:
            com.bytedance.pangle.plugin.PluginManager r3 = com.bytedance.pangle.plugin.PluginManager.getInstance()     // Catch: java.lang.Exception -> L55
            com.bytedance.pangle.plugin.Plugin r3 = r3.getPlugin(r4)     // Catch: java.lang.Exception -> L55
            android.content.res.Resources r3 = r3.mResources     // Catch: java.lang.Exception -> L55
            return r3
        L55:
            r3 = move-exception
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.transform.ZeusTransformUtils.getResources(java.lang.Object, java.lang.String):android.content.res.Resources");
    }

    private static Context getWrapperFromCache(Object obj, String str) {
        WeakReference<Context> weakReference = contextCache.get(str + System.identityHashCode(obj));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static boolean instanceOf(Object obj, Class cls) {
        Object readField;
        if (obj instanceof PluginContext) {
            return cls.isInstance(((PluginContext) obj).mOriginContext);
        }
        if (obj instanceof PluginActivityWrapper) {
            return cls.isInstance(((PluginActivityWrapper) obj).mOriginActivity);
        }
        if (!(obj instanceof PluginFragmentActivityWrapper)) {
            return obj instanceof PluginApplicationWrapper ? cls.isInstance(((PluginApplicationWrapper) obj).mOriginApplication) : obj instanceof GenerateProxyActivity ? cls.isInstance(((GenerateProxyActivity) obj).mTargetActivity) : cls.isInstance(obj);
        }
        try {
            try {
                readField = ((PluginFragmentActivityWrapper) obj).getOriginActivity();
            } catch (Throwable unused) {
                readField = FieldUtils.readField(obj, "mOriginActivity");
            }
            return cls.isInstance(readField);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static int mapRes(int i6, String str, String str2) {
        if (i6 < 2130706432) {
            return i6;
        }
        int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2, str, Zeus.getAppApplication().getPackageName());
        if (identifier == 0) {
            identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.replace("_", "."), str, Zeus.getAppApplication().getPackageName());
        }
        if (identifier == 0) {
            ZeusLogger.d(ZeusLogger.TAG_RESOURCES, "Cant find res, resName = " + str2 + ", pluginResId = " + i6);
        }
        return identifier;
    }

    public static TypedArray obtainAttributes(Object obj, AttributeSet attributeSet, int[] iArr, String str) {
        if (!(obj instanceof Resources)) {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainAttributes", attributeSet, iArr);
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
        int[] handleAttrBefore = handleAttrBefore(iArr);
        TypedArray obtainAttributes = ((Resources) obj).obtainAttributes(attributeSet, handleAttrBefore);
        handleAttrAfter(obtainAttributes, handleAttrBefore, iArr);
        return obtainAttributes;
    }

    public static Object preCheckCast(Object obj, Class cls, String str) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Context)) {
            return obj;
        }
        boolean isInstance = cls.isInstance(obj);
        if (equalsFragmentActivity(cls)) {
            return wrapperContext2FragmentActivity(obj, str);
        }
        if (cls == Activity.class) {
            return wrapperContext2Activity(obj, str);
        }
        if (cls == Application.class) {
            return wrapperContext2Application(obj, str);
        }
        if ((obj instanceof PluginContext) && !isInstance) {
            return ((PluginContext) obj).mOriginContext;
        }
        if (!(obj instanceof PluginFragmentActivityWrapper) || isInstance) {
            return (!(obj instanceof PluginActivityWrapper) || isInstance) ? (!(obj instanceof PluginApplicationWrapper) || isInstance) ? (!(obj instanceof GenerateProxyActivity) || isInstance) ? obj : ((GenerateProxyActivity) obj).mTargetActivity : ((PluginApplicationWrapper) obj).mOriginApplication : ((PluginActivityWrapper) obj).mOriginActivity;
        }
        try {
            try {
                return ((PluginFragmentActivityWrapper) obj).getOriginActivity();
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        } catch (Throwable unused) {
            return FieldUtils.readField(obj, "mOriginActivity");
        }
    }

    public static void requestPermissions(Object obj, String[] strArr, int i6, String str) {
        Object obj2;
        if (obj instanceof IPluginActivity) {
            ((IPluginActivity) obj)._requestPermissions(strArr, i6);
            return;
        }
        if (obj instanceof Activity) {
            try {
                obj2 = FieldUtils.readField(obj, "mOriginActivity");
            } catch (IllegalAccessException unused) {
                obj2 = null;
            }
            if (obj2 != null) {
                obj = obj2;
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "requestPermissions", strArr, Integer.valueOf(i6));
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void startActivity(Object obj, Intent intent, Bundle bundle, String str) {
        try {
            ComponentManager.startActivity(obj, intent, bundle, str);
        } catch (Throwable th) {
            if (obj instanceof Context) {
                ComponentManager.startActivity((Context) obj, intent, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivity", new Object[]{intent, bundle}, new Class[]{Intent.class, Bundle.class});
            } catch (Throwable th2) {
                th2.addSuppressed(th);
                throw new RuntimeException(th2);
            }
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i6, Bundle bundle, String str) {
        try {
            ComponentManager.startActivityForResult(obj, intent, i6, bundle, str);
        } catch (Throwable th) {
            if (obj instanceof Activity) {
                ComponentManager.startActivityForResult((Activity) obj, intent, i6, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivityForResult", new Object[]{intent, Integer.valueOf(i6), bundle}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});
            } catch (Throwable th2) {
                th2.addSuppressed(th);
                throw new RuntimeException(th2);
            }
        }
    }

    public static ComponentName startService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().startServiceNative((Context) obj, intent, str);
        }
        try {
            return (ComponentName) MethodUtils.invokeMethod(obj, "startService", intent);
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static boolean stopService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().stopServiceNative((Context) obj, intent, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "stopService", intent)).booleanValue();
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void supportFragmentWrapper(boolean z5) {
        sSupportFragmentWrapper = z5;
    }

    public static void unbindService(Object obj, ServiceConnection serviceConnection, String str) {
        if (obj instanceof Context) {
            ServiceManagerNative.getInstance().unbindServiceNative(serviceConnection);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unbindService", serviceConnection);
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void unregisterReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, String str) {
        if (obj instanceof Context) {
            ComponentManager.unregisterReceiver((Context) obj, pluginBroadcastReceiver);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unregisterReceiver", pluginBroadcastReceiver);
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static Context wrapperContext(Object obj, String str, StringBuilder sb) {
        Context pluginContext;
        Application application;
        if (Zeus.getAppApplication() == null && (application = (Application) StubApp.getOrigApplicationContext(((Context) obj).getApplicationContext())) != null) {
            Zeus.setAppContext(application);
        }
        if (obj == null) {
            if (sb == null) {
                return null;
            }
            sb.append("context1 == null");
            return null;
        }
        Context wrapperFromCache = getWrapperFromCache(obj, str);
        if (wrapperFromCache != null) {
            if (sb != null) {
                sb.append("cache1:");
                sb.append(wrapperFromCache);
            }
            return wrapperFromCache;
        }
        Context context = (Context) obj;
        Context contextIfNeedWrap = getContextIfNeedWrap(context, context, str);
        if (contextIfNeedWrap == null) {
            if (sb != null) {
                sb.append("context2 == null");
                sb.append(obj);
            }
            return context;
        }
        if (!isSupportLibIso(str) && instanceOfFragmentActivity(contextIfNeedWrap) && sSupportFragmentWrapper) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            try {
                try {
                    pluginContext = new PluginFragmentActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
                    if (sb != null) {
                        sb.append("new PluginFragmentActivityWrapper:");
                        sb.append(pluginContext);
                    }
                } catch (Throwable unused) {
                    if (sb != null) {
                        sb.append("context3 == null");
                        sb.append(contextIfNeedWrap);
                    }
                    return contextIfNeedWrap;
                }
            } catch (Throwable unused2) {
                pluginContext = (Context) MethodUtils.invokeConstructor(PluginFragmentActivityWrapper.class, new Object[]{contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false)}, new Class[]{fragmentClazz, PluginContext.class});
                if (sb != null) {
                    sb.append("new invokeConstructor:");
                    sb.append(pluginContext);
                }
            }
        } else if (contextIfNeedWrap instanceof Activity) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            pluginContext = new PluginActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
            if (sb != null) {
                sb.append("new PluginActivityWrapper:");
                sb.append(pluginContext);
            }
        } else if (contextIfNeedWrap instanceof Application) {
            pluginContext = new PluginApplicationWrapper((Application) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), true));
            if (sb != null) {
                sb.append("new PluginApplicationWrapper:");
                sb.append(pluginContext);
            }
        } else {
            pluginContext = new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false);
            if (sb != null) {
                sb.append("new PluginContext:");
                sb.append(pluginContext);
            }
        }
        if (pluginContext != null) {
            contextCache.put(str + System.identityHashCode(contextIfNeedWrap), new WeakReference<>(pluginContext));
        }
        if (sb != null) {
            sb.append("cache2:");
            sb.append(pluginContext);
        }
        return pluginContext;
    }

    public static Activity wrapperContext2Activity(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Context wrapperContext = wrapperContext(obj, str, sb);
        if (wrapperContext instanceof Activity) {
            return (Activity) wrapperContext;
        }
        if (wrapperContext instanceof PluginContext) {
            return wrapperContext2Activity(((PluginContext) wrapperContext).mOriginContext, str);
        }
        sb.append("SupportFragment=");
        sb.append(sSupportFragmentWrapper);
        if (!sCanThrowException) {
            return (Activity) obj;
        }
        throw new RuntimeException("强转失败 context:" + obj + " wrapperContext:" + wrapperContext + " log:" + ((Object) sb));
    }

    public static Application wrapperContext2Application(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Context wrapperContext = wrapperContext(obj, str, sb);
        if (wrapperContext instanceof Application) {
            return (Application) wrapperContext;
        }
        if (wrapperContext instanceof PluginContext) {
            return wrapperContext2Application(((PluginContext) wrapperContext).mOriginContext, str);
        }
        sb.append("SupportFragment=");
        sb.append(sSupportFragmentWrapper);
        if (!sCanThrowException) {
            return (Application) obj;
        }
        throw new RuntimeException("强转失败 context:" + obj + " wrapperContext:" + wrapperContext + " log:" + ((Object) sb));
    }

    private static Object wrapperContext2FragmentActivity(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Context wrapperContext = wrapperContext(obj, str, sb);
        if (!isSupportLibIso(str) && instanceOfFragmentActivity(wrapperContext)) {
            return wrapperContext;
        }
        if (wrapperContext instanceof PluginContext) {
            return wrapperContext2FragmentActivity(((PluginContext) wrapperContext).mOriginContext, str);
        }
        sb.append("SupportFragment=");
        sb.append(sSupportFragmentWrapper);
        if (!sCanThrowException) {
            return obj;
        }
        throw new RuntimeException("强转失败 context:" + obj + " wrapperContext:" + wrapperContext + " log:" + ((Object) sb));
    }

    public static Object wrapperContextForParams(Object obj, Class cls, String str) {
        if (!(obj instanceof PluginService)) {
            if (obj instanceof PluginIntentService) {
                return obj;
            }
            if (obj instanceof Context) {
                Context convertProxy2PluginActivity = convertProxy2PluginActivity(wrapperContext(obj, str));
                if (cls.isInstance(convertProxy2PluginActivity)) {
                    return convertProxy2PluginActivity;
                }
            }
        }
        return obj;
    }

    private static boolean equalsFragmentActivity(Class cls) {
        ensureFragmentActivity();
        Class cls2 = fragmentClazz;
        if (cls2 == null || cls != cls2) {
            return false;
        }
        return true;
    }

    public static Class forName(String str, String str2) throws ClassNotFoundException {
        return Zeus.getPlugin(str2).mClassLoader.loadClass(str);
    }

    public static Activity getActivity(Object obj, String str) {
        return _getActivity(obj, str);
    }

    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        try {
            return FileProvider.getUriForFile(file);
        } catch (NoClassDefFoundError unused) {
            return Uri.parse("");
        }
    }

    public static Window getWindow(Activity activity, String str) {
        Window window = activity.getWindow();
        if (window == null) {
            try {
                return (Window) MethodUtils.invokeMethod(activity, "getWindow", new Object[0]);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        return window;
    }

    private static void handleAttrAfter(TypedArray typedArray, int[] iArr, int[] iArr2) {
        if (Arrays.equals(iArr, iArr2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < iArr.length; i6++) {
            hashMap.put(Integer.valueOf(iArr[i6]), Integer.valueOf(i6));
        }
        HashMap hashMap2 = new HashMap();
        for (int i7 = 0; i7 < iArr2.length; i7++) {
            hashMap2.put((Integer) hashMap.get(Integer.valueOf(iArr2[i7])), Integer.valueOf(i7));
        }
        try {
            int[] iArr3 = (int[]) FieldUtils.readField(typedArray, "mData");
            int[] copyOf = Arrays.copyOf(iArr3, iArr3.length);
            for (Integer num : hashMap2.keySet()) {
                Integer num2 = (Integer) hashMap2.get(num);
                if (!num.equals(num2)) {
                    System.arraycopy(iArr3, num.intValue() * 7, copyOf, num2.intValue() * 7, 7);
                }
            }
            System.arraycopy(copyOf, 0, iArr3, 0, iArr3.length);
        } catch (IllegalAccessException unused) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "read mData failed.");
        }
    }

    private static boolean instanceOfFragmentActivity(Object obj) {
        ensureFragmentActivity();
        Class cls = fragmentClazz;
        if (cls == null) {
            return false;
        }
        return cls.isInstance(obj);
    }

    private static boolean isSupportLibIso(String str) {
        try {
            return PluginManager.getInstance().getPlugin(str).mIsSupportLibIso;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void registerZeusActivityStub(String str, String[] strArr, String str2) {
        ComponentManager.registerActivity(str2, str, strArr);
    }

    public static void setComponentEnabledSetting(PackageManager packageManager, ComponentName componentName, int i6, int i7) {
        try {
            packageManager.setComponentEnabledSetting(componentName, i6, i7);
        } catch (Throwable unused) {
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[4 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler);
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static TypedArray obtainStyledAttributes(Object obj, AttributeSet attributeSet, int[] iArr, int i6, int i7, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        }
        if (obj instanceof Resources.Theme) {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(attributeSet, handleAttrBefore2, i6, i7);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        }
        try {
            return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr, Integer.valueOf(i6), Integer.valueOf(i7));
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void setResult(Object obj, int i6, String str) {
        if (obj instanceof Activity) {
            try {
                Object readField = FieldUtils.readField(obj, "mProxyActivity");
                if (readField != null) {
                    MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i6));
                    return;
                }
            } catch (Exception unused) {
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = ".concat(String.valueOf(obj)));
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i6));
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i6, String str) {
        if (obj instanceof Context) {
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, i6, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, Integer.valueOf(i6));
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i6, String str2) {
        if (obj instanceof Context) {
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, i6, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i6));
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, int i6, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, i6, viewGroup, viewGroup != null, str);
    }

    public static TypedArray obtainStyledAttributes(Object obj, int i6, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(i6, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        }
        if (obj instanceof Resources.Theme) {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(i6, handleAttrBefore2);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        }
        try {
            return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", Integer.valueOf(i6), iArr);
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, xmlPullParser, viewGroup, viewGroup != null, str);
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z5, String str) {
        Context context = layoutInflater.getContext();
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper)) {
            isSupportLibIso(str);
            if (!(context instanceof PluginApplicationWrapper)) {
                context = wrapperContext(context, str);
            }
        }
        LayoutInflater layoutInflater2 = (LayoutInflater) context.getSystemService("layout_inflater");
        clearConstructorCache();
        View inflate = layoutInflater2.inflate(xmlPullParser, viewGroup, z5);
        clearConstructorCache();
        return inflate;
    }

    public static View inflate(Context context, int i6, ViewGroup viewGroup, String str) {
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper)) {
            isSupportLibIso(str);
            if (!(context instanceof PluginApplicationWrapper)) {
                context = wrapperContext(context, str);
            }
        }
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        clearConstructorCache();
        View inflate = layoutInflater.inflate(i6, viewGroup);
        clearConstructorCache();
        return inflate;
    }

    public static TypedArray obtainStyledAttributes(Object obj, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        }
        if (obj instanceof Resources.Theme) {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(handleAttrBefore2);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        }
        try {
            return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", iArr, new Class[]{int[].class});
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }
}
