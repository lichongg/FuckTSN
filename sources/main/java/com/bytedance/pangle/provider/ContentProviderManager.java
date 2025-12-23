package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.up.r;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class ContentProviderManager {
    public static final String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final String PLUGIN_PROCESS_NAME = "process_name";
    public static final String PROVIDER_PARAM_FEILD = "provider_params";
    public static final String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final String PROVIDER_URI = "uri";
    private static ContentProviderManager sInstance;
    private final Map<xt, j> mContentProviderMap = new HashMap();
    private final Map<String, String> mAuthorityProcessNameMap = new HashMap();
    private final Map<String, cw> mSystemProviderInfoMap = new HashMap();

    protected static final class cw extends xt {

        /* renamed from: r, reason: collision with root package name */
        public final ProviderInfo f25448r;

        public cw(String str, String str2, ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
            this.f25448r = providerInfo;
        }
    }

    public static class xt {
        public final String cw;

        /* renamed from: j, reason: collision with root package name */
        public final String f25450j;
        public final String xt;

        public boolean equals(Object obj) {
            if (obj instanceof xt) {
                xt xtVar = (xt) obj;
                if (TextUtils.equals(this.cw, xtVar.cw) && TextUtils.equals(this.xt, xtVar.xt) && TextUtils.equals(this.f25450j, xtVar.f25450j)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f25450j, this.xt, this.cw);
        }

        public xt(String str, String str2, String str3) {
            this.f25450j = str2;
            this.xt = str3;
            this.cw = str;
        }
    }

    public Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        return a.a(contentResolver, uri, str, str2, bundle, str3);
    }

    public int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        return a.a(contentResolver, uri, str, strArr, str2);
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        return a.a(contentResolver, uri, contentValues, str);
    }

    protected boolean isPluginProvider(Uri uri) {
        if (uri == null) {
            return true;
        }
        String authority = uri.getAuthority();
        Set<String> keySet = this.mAuthorityProcessNameMap.keySet();
        return keySet != null && keySet.contains(authority);
    }

    @RequiresApi(api = 16)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        return a.a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        return a.a(contentResolver, uri, contentValues, str, strArr, str2);
    }

    public static final class j {
        public final PluginContentProvider cw;

        /* renamed from: j, reason: collision with root package name */
        public final xt f25449j;
        public final ProviderInfo xt;

        public j(xt xtVar, ProviderInfo providerInfo, PluginContentProvider pluginContentProvider) {
            this.xt = providerInfo;
            this.f25449j = xtVar;
            this.cw = pluginContentProvider;
        }
    }

    public static ContentProviderManager getInstance() {
        if (sInstance == null) {
            synchronized (ContentProviderManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ContentProviderManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private void installProvider(String str, ProviderInfo providerInfo, Plugin plugin) {
        if (providerInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + plugin.mPkgName + "】");
            return;
        }
        if (TextUtils.equals(str, providerInfo.processName)) {
            ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + providerInfo.authority + "] [className:" + providerInfo.name + "]");
            try {
                PluginContentProvider instantiateProvider = instantiateProvider(plugin, providerInfo);
                if (instantiateProvider == null) {
                    return;
                }
                instantiateProvider.attachInfo(ZeusTransformUtils.wrapperContext(plugin.mHostApplication, plugin.mPkgName), providerInfo);
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + providerInfo.name + "]");
                xt xtVar = new xt(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
                this.mContentProviderMap.put(xtVar, new j(xtVar, providerInfo, instantiateProvider));
            } catch (Exception e6) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e6);
                return;
            }
        }
        this.mAuthorityProcessNameMap.put(providerInfo.authority, providerInfo.processName);
    }

    private PluginContentProvider instantiateProvider(Plugin plugin, ProviderInfo providerInfo) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Object newInstance = plugin.mClassLoader.loadClass(providerInfo.name).newInstance();
        if (!(newInstance instanceof FileProvider)) {
            return (PluginContentProvider) newInstance;
        }
        Bundle bundle = providerInfo.metaData;
        if (bundle == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data. provider:".concat(String.valueOf(newInstance)));
        }
        com.bytedance.pangle.FileProvider.j(plugin, plugin.mResources.getXml(bundle.getInt("android.support.FILE_PROVIDER_PATHS")));
        return null;
    }

    public final Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        return a.a(contentResolver, str, str2, str3, bundle, str4);
    }

    public int delete(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        return a.a(contentResolver, uri, bundle, str);
    }

    public String getPluginProcessNameByAuthority(String str) {
        return this.mAuthorityProcessNameMap.get(str);
    }

    public PluginContentProvider getPluginProvider(xt xtVar) {
        j jVar = this.mContentProviderMap.get(xtVar);
        if (jVar == null) {
            return null;
        }
        return jVar.cw;
    }

    public Map<String, cw> getSystemProviderInfoMap() {
        return this.mSystemProviderInfoMap;
    }

    public void initSystemContentProviderInfo() {
        String str;
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_CONTENT_PROVIDER, "start");
        try {
            ProviderInfo[] providerInfoArr = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;
            if (providerInfoArr == null || providerInfoArr.length == 0) {
                return;
            }
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo != null && (str = providerInfo.authority) != null && str.contains(".pangle.provider.proxy.")) {
                    try {
                        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.provider.proxy.")) {
                            String j6 = r.j(providerInfo.processName);
                            this.mSystemProviderInfoMap.put(j6, new cw(Zeus.getAppApplication().getPackageName(), j6, providerInfo));
                            ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        }
                    } catch (Exception e6) {
                        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception：", e6);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
        }
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return a.a(contentResolver, uri, contentValues, bundle, str);
    }

    public void installContentProviders(Collection<ProviderInfo> collection, Plugin plugin) {
        if (collection == null || collection.size() == 0 || plugin == null) {
            return;
        }
        String j6 = r.j(r.j(Zeus.getAppApplication()));
        for (ProviderInfo providerInfo : collection) {
            if (ZeusLogger.isDebug()) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name);
                sb.append("]");
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, sb.toString());
            }
            installProvider(j6, providerInfo, plugin);
        }
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        return a.a(contentResolver, uri, strArr, str, strArr2, str2, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return a.b(contentResolver, uri, contentValues, bundle, str);
    }

    private ContentProviderManager() {
    }

    public String getType(ContentResolver contentResolver, Uri uri, String str) {
        return a.a(contentResolver, uri, str);
    }

    @RequiresApi(api = 26)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        return a.a(contentResolver, uri, strArr, bundle, cancellationSignal, str);
    }
}
