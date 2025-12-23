package com.huawei.hms.mlsdk.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import cn.jpush.android.local.JPushConstants;
import com.huawei.agconnect.d;
import com.huawei.hms.ml.common.utils.SmartLog;
import j1.a;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class AgConnectInfo {
    private String apiKey;
    private String appMLKitGrsPolicy;
    private String applicationId;
    private String certFingerprint;
    private List<String> haCollectorUrls;
    private List<String> mlServiceUrls;
    private String packageName;
    private String projectId;
    private String region;

    public AgConnectInfo(Context context) {
        this.mlServiceUrls = new ArrayList();
        this.haCollectorUrls = new ArrayList();
        context = context == null ? d.b().getContext() : context;
        if (context == null) {
            throw new IllegalStateException("Context not found.");
        }
        a d6 = a.d(context);
        SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + d6 + "context: " + context);
        this.region = d6.getString(AgConnectKey.REGION);
        SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + d6 + "region: " + this.region);
        String string = d6.getString(AgConnectKey.PACKAGE_NAME);
        this.packageName = string;
        if (string == null) {
            this.packageName = context.getPackageName();
        } else {
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + d6 + "packageName: " + this.packageName);
        }
        String string2 = d6.getString(AgConnectKey.APPLICATION_ID);
        this.applicationId = string2;
        if (string2 == null) {
            this.applicationId = this.packageName;
        } else {
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + d6 + "packageName: " + this.packageName);
        }
        String string3 = d6.getString(AgConnectKey.API_KEY);
        this.apiKey = string3;
        if (string3 != null) {
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + d6 + "apiKey: apiKey is secret");
        }
        String rawSignature = getRawSignature(context);
        this.certFingerprint = rawSignature;
        if (rawSignature != null) {
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + d6 + "certFingerprint: certFingerprint is secret");
        }
        String string4 = d6.getString(AgConnectKey.ML_SERVICE_URL);
        if (string4 != null) {
            for (String str : string4.split(",")) {
                String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
                if (!lowerCase.startsWith(JPushConstants.HTTP_PRE) && !lowerCase.startsWith(JPushConstants.HTTPS_PRE)) {
                    lowerCase = JPushConstants.HTTPS_PRE + lowerCase;
                }
                if (!lowerCase.endsWith("/")) {
                    lowerCase = lowerCase + "/";
                }
                this.mlServiceUrls.add(lowerCase);
            }
        }
        String string5 = d6.getString(AgConnectKey.ANALYTICS_COLLECTOR_URL);
        if (string5 != null) {
            for (String str2 : string5.split(",")) {
                String lowerCase2 = str2.trim().toLowerCase(Locale.ENGLISH);
                if (!lowerCase2.startsWith(JPushConstants.HTTP_PRE) && !lowerCase2.startsWith(JPushConstants.HTTPS_PRE)) {
                    lowerCase2 = JPushConstants.HTTPS_PRE + lowerCase2;
                }
                this.haCollectorUrls.add(lowerCase2);
            }
        }
        this.projectId = d6.getString(AgConnectKey.PROJECT_ID);
        SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + d6 + "project_id: " + this.projectId);
        this.appMLKitGrsPolicy = d6.getString(AgConnectKey.APP_MLKIT_GRS_POLICY);
        SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + d6 + "processing_location_policy/mlkit: " + this.appMLKitGrsPolicy);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AgConnectKey {
        public static final String ANALYTICS_COLLECTOR_URL = "service/analytics/collector_url";
        public static final String API_KEY = "client/api_key";
        public static final String APPLICATION_ID = "client/app_id";
        public static final String APP_MLKIT_GRS_POLICY = "processing_location_policy/mlkit";
        public static final String ML_SERVICE_URL = "service/ml/mlservice_url";
        public static final String PACKAGE_NAME = "client/package_name";
        public static final String PROJECT_ID = "client/project_id";
        public static final String REGION = "region";

        private AgConnectKey() {
        }
    }

    private String getRawSignature(Context context) {
        PackageInfo packageInfo;
        Signature signature;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return "";
        }
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            SmartLog.i("AgConnectInfo", "signature is null ");
            signature = null;
        } else {
            signature = signatureArr[0];
            SmartLog.i("AgConnectInfo", "signature is not null ");
        }
        if (signature != null) {
            return getSignatureString(signature, "SHA256");
        }
        return "";
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getAppMLKitGrsPolicy() {
        return this.appMLKitGrsPolicy;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getCertFingerprint() {
        return this.certFingerprint;
    }

    public List<String> getHaCollectorUrls() {
        return this.haCollectorUrls;
    }

    public List<String> getMLServiceUrls() {
        return this.mlServiceUrls;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getRegion() {
        return this.region;
    }

    private final String getSignatureString(Signature signature, String str) {
        try {
            byte[] byteArray = signature.toByteArray();
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.reset();
            messageDigest.update(byteArray);
            byte[] digest = messageDigest.digest();
            for (int i6 = 0; i6 < digest.length; i6++) {
                if (Integer.toHexString(digest[i6] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(digest[i6] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i6] & 255));
                }
                if (i6 != digest.length - 1) {
                    stringBuffer.append(":");
                }
            }
            return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
        } catch (Throwable unused) {
            return null;
        }
    }

    public AgConnectInfo() {
        this(null);
    }
}
