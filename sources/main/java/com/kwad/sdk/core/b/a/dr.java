package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class dr implements com.kwad.sdk.core.d<DownloadParams> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(DownloadParams downloadParams, JSONObject jSONObject) {
        a2(downloadParams, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(DownloadParams downloadParams, JSONObject jSONObject) {
        return b2(downloadParams, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadParams.mDownloadid = jSONObject.optString("mDownloadid");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(downloadParams.mDownloadid)) {
            downloadParams.mDownloadid = "";
        }
        downloadParams.mAppName = jSONObject.optString("mAppName");
        if (obj.toString().equals(downloadParams.mAppName)) {
            downloadParams.mAppName = "";
        }
        downloadParams.mPkgname = jSONObject.optString("mPkgname");
        if (obj.toString().equals(downloadParams.mPkgname)) {
            downloadParams.mPkgname = "";
        }
        downloadParams.mVersion = jSONObject.optString("mVersion");
        if (obj.toString().equals(downloadParams.mVersion)) {
            downloadParams.mVersion = "";
        }
        downloadParams.mVersionCode = jSONObject.optString("mVersionCode");
        if (obj.toString().equals(downloadParams.mVersionCode)) {
            downloadParams.mVersionCode = "";
        }
        downloadParams.mAppSize = jSONObject.optLong("mAppSize");
        downloadParams.mFileMd5 = jSONObject.optString("mFileMd5");
        if (obj.toString().equals(downloadParams.mFileMd5)) {
            downloadParams.mFileMd5 = "";
        }
        downloadParams.mFileUrl = jSONObject.optString("mFileUrl");
        if (obj.toString().equals(downloadParams.mFileUrl)) {
            downloadParams.mFileUrl = "";
        }
        downloadParams.mAppIcon = jSONObject.optString("mAppIcon");
        if (obj.toString().equals(downloadParams.mAppIcon)) {
            downloadParams.mAppIcon = "";
        }
        downloadParams.mShortDesc = jSONObject.optString("mShortDesc");
        if (obj.toString().equals(downloadParams.mShortDesc)) {
            downloadParams.mShortDesc = "";
        }
        downloadParams.mTaskId = jSONObject.optInt("mTaskId");
        downloadParams.filePath = jSONObject.optString("filePath");
        if (obj.toString().equals(downloadParams.filePath)) {
            downloadParams.filePath = "";
        }
        downloadParams.requestInstallPermission = jSONObject.optBoolean("requestInstallPermission");
        downloadParams.downloadEnablePause = jSONObject.optBoolean("downloadEnablePause");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadParams.mDownloadid;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDownloadid", downloadParams.mDownloadid);
        }
        String str2 = downloadParams.mAppName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mAppName", downloadParams.mAppName);
        }
        String str3 = downloadParams.mPkgname;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mPkgname", downloadParams.mPkgname);
        }
        String str4 = downloadParams.mVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mVersion", downloadParams.mVersion);
        }
        String str5 = downloadParams.mVersionCode;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mVersionCode", downloadParams.mVersionCode);
        }
        long j6 = downloadParams.mAppSize;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mAppSize", j6);
        }
        String str6 = downloadParams.mFileMd5;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mFileMd5", downloadParams.mFileMd5);
        }
        String str7 = downloadParams.mFileUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mFileUrl", downloadParams.mFileUrl);
        }
        String str8 = downloadParams.mAppIcon;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mAppIcon", downloadParams.mAppIcon);
        }
        String str9 = downloadParams.mShortDesc;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mShortDesc", downloadParams.mShortDesc);
        }
        int i6 = downloadParams.mTaskId;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mTaskId", i6);
        }
        String str10 = downloadParams.filePath;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "filePath", downloadParams.filePath);
        }
        boolean z5 = downloadParams.requestInstallPermission;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestInstallPermission", z5);
        }
        boolean z6 = downloadParams.downloadEnablePause;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadEnablePause", z6);
        }
        int i7 = downloadParams.downloadPlace;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadPlace", i7);
        }
        return jSONObject;
    }
}
