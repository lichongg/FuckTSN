package com.kwad.sdk.api.proxy.app;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.loader.b;
import com.stub.StubApp;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdSdkFileProvider extends FileProvider {
    private static final String SP_INSTALLER_CHECK_PKG_AB_SWITCH = "installerCheckPkgAbSwitch";
    private static final String SP_INSTALLER_EXTRA_PKGS_KEY = "installerCheckExtraPkgs";
    private static final String SP_OPEN_FILE_RECORD = "SP_OPEN_FILE_RECORD";
    private static final String TAG = "AdSdkFileProvider";
    public static long sLaunchTime;
    private static Set<String> sSystemInstallers;

    private boolean isInstallerPkgCheckOpen() {
        return ApiConfigUtils.readInt(getContext(), SP_INSTALLER_CHECK_PKG_AB_SWITCH, 0) == 1;
    }

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        sSystemInstallers = copyOnWriteArraySet;
        copyOnWriteArraySet.add("com.android.packageinstaller");
        sSystemInstallers.add("com.google.android.packageinstaller");
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) {
        boolean z5;
        String jSONArray;
        Objects.toString(uri);
        if (isInstallerPkgCheckOpen()) {
            checkLocalConfig();
            String callingPackage = getCallingPackage();
            z5 = sSystemInstallers.contains(callingPackage);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callingPkg", callingPackage);
                jSONObject.put("checkResult", String.valueOf(z5));
                jSONObject.put(ContentProviderManager.PROVIDER_URI, uri.toString());
                String b6 = b.b(getContext(), SP_OPEN_FILE_RECORD, "");
                if (TextUtils.isEmpty(b6)) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONObject);
                    jSONArray = jSONArray2.toString();
                } else {
                    JSONArray jSONArray3 = new JSONArray(b6);
                    jSONArray3.put(jSONObject);
                    jSONArray = jSONArray3.toString();
                }
                b.c(getContext(), SP_OPEN_FILE_RECORD, jSONArray);
            } catch (Throwable unused) {
            }
        } else {
            z5 = true;
        }
        if (z5) {
            return super.openFile(uri, str);
        }
        return null;
    }

    private void checkLocalConfig() {
        try {
            String readString = ApiConfigUtils.readString(getContext(), SP_INSTALLER_EXTRA_PKGS_KEY, "");
            if (!TextUtils.isEmpty(readString)) {
                JSONArray jSONArray = new JSONArray(getDecodeString(readString));
                int length = jSONArray.length();
                for (int i6 = 0; i6 < length; i6++) {
                    String string = jSONArray.getString(i6);
                    if (!TextUtils.isEmpty(string)) {
                        sSystemInstallers.add(string);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static String getDecodeString(String str) {
        if (!TextUtils.isEmpty(str) && ApiBase64.isEncodeKsSdk(str)) {
            return ApiBase64.decodeKsSdk(str);
        }
        return str;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        sLaunchTime = System.currentTimeMillis();
        try {
            KSLifecycleObserver.getInstance().init(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        } catch (Throwable unused) {
        }
        return super.onCreate();
    }
}
