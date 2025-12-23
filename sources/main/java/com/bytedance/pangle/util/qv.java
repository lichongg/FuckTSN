package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class qv {

    /* renamed from: j, reason: collision with root package name */
    static volatile ArrayList<String> f25546j;
    private static String xt;

    public static List<String> j() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e6) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e6);
            assetManager = null;
        }
        return j(assetManager);
    }

    public static String xt(AssetManager assetManager) {
        return j(j(assetManager));
    }

    public static synchronized List<String> xt() {
        ArrayList<String> arrayList;
        synchronized (qv.class) {
            try {
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_WEB, "start");
                if (f25546j == null) {
                    synchronized (qv.class) {
                        if (f25546j == null) {
                            f25546j = new ArrayList<>();
                            if (g.up()) {
                                try {
                                    Resources resources = Zeus.getAppApplication().getResources();
                                    f25546j.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", ResIdentify.RES_TYPE_STRING, FaceEnvironment.OS)), 0).getApplicationInfo().sourceDir);
                                } catch (Exception e6) {
                                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e6);
                                }
                            } else if (g.qv()) {
                                try {
                                    Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                                    if (g.av()) {
                                        Collections.addAll(f25546j, j(((Context) invokeStaticMethod).getApplicationInfo()));
                                    } else {
                                        f25546j.add(((Context) invokeStaticMethod).getApplicationInfo().sourceDir);
                                    }
                                } catch (Exception e7) {
                                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e7);
                                }
                            }
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_WEB, "finish :" + f25546j);
                arrayList = f25546j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public static List<String> j(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager != null) {
            try {
                if (g.az()) {
                    Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                    if (objArr != null && objArr.length > 0) {
                        for (Object obj : objArr) {
                            arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                        }
                    }
                } else {
                    int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                    for (int i6 = 0; i6 < intValue; i6++) {
                        try {
                            String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i6 + 1));
                            if (!TextUtils.isEmpty(str)) {
                                arrayList.add(str);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                }
            } catch (Throwable th) {
                ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
            }
        }
        return arrayList;
    }

    public static boolean j(AssetManager assetManager, String str) {
        try {
            if (g.az()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                            return true;
                        }
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i6 = 0;
                while (i6 < intValue) {
                    i6++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i6)), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
        }
        return false;
    }

    public static String j(List<String> list) {
        StringBuilder sb = new StringBuilder("[");
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(" , ");
            }
            sb.delete(sb.lastIndexOf(" , "), sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    @RequiresApi(api = 21)
    private static String[] j(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) com.bytedance.pangle.xt.xt.j.j((Class<?>) ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i6 = 0; i6 < 3; i6++) {
            String[] strArr3 = strArr2[i6];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
