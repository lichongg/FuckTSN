package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class UploadEntryNative extends NativeObject implements e {
    public UploadEntryNative(long j6) {
        this.mPtr = j6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UploadEntryNative uploadEntryNative = (UploadEntryNative) obj;
            String uploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String uploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            if (uploadEntryGetPackageName == null ? a(uploadEntryNative) != null : !uploadEntryGetPackageName.equals(a(uploadEntryNative))) {
                return false;
            }
            if (uploadEntryGetOriginFilePath != null) {
                return uploadEntryGetOriginFilePath.equals(AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative));
            }
            if (AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative) == null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.collector.model.e
    @Nullable
    @WorkerThread
    public final JSONObject DM() {
        try {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, AppStatusNative.uploadEntryGetPackageName(this));
            aa.putValue(jSONObject, "content", com.kwad.sdk.collector.e.cD(AppStatusNative.uploadEntryGetOriginFilePath(this)));
            aa.putValue(jSONObject, "fileName", DO());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j6 = this.mPtr;
        if (j6 != 0) {
            AppStatusNative.nativeDeleteUploadEntry(j6);
            this.mPtr = 0L;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME);
        String optString2 = jSONObject.optString("originFilePath");
        AppStatusNative.uploadEntrySetPackageName(this, optString);
        AppStatusNative.uploadEntrySetOriginFilePath(this, optString2);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, AppStatusNative.uploadEntryGetPackageName(this));
        aa.putValue(jSONObject, "originFilePath", AppStatusNative.uploadEntryGetOriginFilePath(this));
        return jSONObject;
    }

    public String toString() {
        return "UploadEntry{packageName='" + AppStatusNative.uploadEntryGetPackageName(this) + "', originFile=" + AppStatusNative.uploadEntryGetOriginFilePath(this) + '}';
    }

    public UploadEntryNative() {
        this.mPtr = AppStatusNative.nativeCreateUploadEntry();
    }

    private String DO() {
        try {
            String uploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String uploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            return uploadEntryGetOriginFilePath.substring(uploadEntryGetOriginFilePath.indexOf(uploadEntryGetPackageName)).replaceFirst(uploadEntryGetPackageName, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(UploadEntryNative uploadEntryNative) {
        return AppStatusNative.uploadEntryGetPackageName(uploadEntryNative);
    }

    public int hashCode() {
        int i6;
        String uploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
        String uploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
        int i7 = 0;
        if (uploadEntryGetPackageName != null) {
            i6 = uploadEntryGetPackageName.hashCode();
        } else {
            i6 = 0;
        }
        int i8 = i6 * 31;
        if (uploadEntryGetOriginFilePath != null) {
            i7 = uploadEntryGetOriginFilePath.hashCode();
        }
        return i8 + i7;
    }
}
