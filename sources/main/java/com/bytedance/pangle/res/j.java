package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.qv;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, Integer> f25475j = new HashMap();
    private LinkedHashMap<String, Integer> xt;

    public AssetManager j(AssetManager assetManager, String str, boolean z5) {
        AssetManager j6;
        if (str.endsWith(".frro")) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(str));
            return assetManager;
        }
        if (!g.j()) {
            j6 = j(assetManager, str);
        } else if (g.ae()) {
            j6 = cw(assetManager, str, z5);
            if (!qv.j(j6, str)) {
                j6 = xt(assetManager, str, z5);
            }
        } else {
            j6 = xt(assetManager, str, z5);
        }
        synchronized (this.xt) {
            this.xt.put(str, 0);
        }
        return j6;
    }

    static {
        List<String> j6 = qv.j();
        if (j6 == null || j6.size() <= 0) {
            return;
        }
        Iterator<String> it = j6.iterator();
        while (it.hasNext()) {
            f25475j.put(it.next(), 0);
        }
    }

    private AssetManager cw(AssetManager assetManager, String str, boolean z5) {
        int i6;
        Throwable th = null;
        int i7 = 3;
        loop0: while (true) {
            int i8 = i7 - 1;
            if (i7 < 0) {
                break;
            }
            try {
                synchronized (assetManager) {
                    i6 = 0;
                    for (int i9 = 0; i9 < 3; i9++) {
                        try {
                            if (g.up()) {
                                i6 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                            } else if (g.vl()) {
                                i6 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z5)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                            }
                            if (i6 != 0) {
                                break loop0;
                            }
                        } finally {
                        }
                    }
                    break loop0;
                }
            } catch (Throwable th2) {
                th = th2;
                i7 = i8;
            }
        }
        if (i6 == 0) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + i6 + " " + str);
        } else {
            Object readField = FieldUtils.readField(assetManager, "mStringBlocks");
            int length = readField != null ? Array.getLength(readField) : 0;
            int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            Object newInstance = Array.newInstance(readField.getClass().getComponentType(), intValue);
            for (int i10 = 0; i10 < intValue; i10++) {
                if (i10 < length) {
                    Array.set(newInstance, i10, Array.get(readField, i10));
                } else {
                    Long l6 = (Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", new Object[]{Integer.valueOf(i10)}, new Class[]{Integer.TYPE});
                    l6.longValue();
                    Array.set(newInstance, i10, MethodUtils.invokeConstructor(readField.getClass().getComponentType(), new Object[]{l6, Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                }
            }
            FieldUtils.writeField(assetManager, "mStringBlocks", newInstance);
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
        }
        if (th != null) {
            if (!g.tj()) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
        }
        return assetManager;
    }

    private AssetManager xt(AssetManager assetManager, String str, boolean z5) {
        int intValue;
        String str2 = "addAssetPath";
        String str3 = z5 ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        if (g.w() && !z5 && str.startsWith("/product/overlay/")) {
            str3 = "addOverlayPath";
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z5) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z5 + " methodName:" + str2);
            return assetManager;
        }
        int i6 = 3;
        while (true) {
            int i7 = i6 - 1;
            if (i6 < 0) {
                break;
            }
            try {
                intValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
            } catch (Exception e6) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z5 + ", methodName = " + str2, e6);
            }
            if (intValue != 0) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + intValue + ", path = " + str);
                break;
            }
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + intValue + " " + str);
            i6 = i7;
        }
        return assetManager;
    }

    public j() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.xt = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    private AssetManager j(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> j6 = qv.j(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : j6) {
            if (!f25475j.containsKey(str2) && !this.xt.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(String.valueOf(str)));
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(null).newInstance(null);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.xt) {
                try {
                    for (Map.Entry<String, Integer> entry : this.xt.entrySet()) {
                        if (!f25475j.containsKey(entry.getKey())) {
                            sb.append(entry.getKey());
                            xt(assetManager2, entry.getKey(), false);
                        }
                    }
                } finally {
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                xt(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + f25475j.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            xt(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    xt(assetManager2, str3, false);
                }
            }
            if (g.m() && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", ResIdentify.RES_TYPE_STRING, FaceEnvironment.OS)), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        xt(assetManager2, str4, false);
                    }
                } catch (Exception e6) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e6);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e7) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e7);
            xt(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e8) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e8);
        }
        return assetManager;
    }
}
