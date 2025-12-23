package com.umeng.socialize.net.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class URequest {
    protected static String APPLICATION = "application/x-www-form-urlencoded";
    protected static String GET = "GET";
    protected static String MULTIPART = "multipart/form-data";
    protected static String POST = "POST";
    protected String mBaseUrl;
    public Context mContext;
    public Map<String, String> mHeaders;
    public RequestMethod mMethod;
    protected MIME mMimeType;
    public Class<? extends SocializeReseponse> mResponseClz;
    public Map<String, String> mParams = new HashMap();
    public PostStyle postStyle = PostStyle.MULTIPART;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.socialize.net.utils.URequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected enum MIME {
        DEFAULT("application/x-www-form-urlencoded;charset=utf-8"),
        JSON("application/json;charset=utf-8");

        private String mimeType;

        @Override // java.lang.Enum
        public String toString() {
            return this.mimeType;
        }

        MIME(String str) {
            this.mimeType = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum PostStyle {
        MULTIPART { // from class: com.umeng.socialize.net.utils.URequest.PostStyle.1
            @Override // java.lang.Enum
            public String toString() {
                return URequest.MULTIPART;
            }
        },
        APPLICATION { // from class: com.umeng.socialize.net.utils.URequest.PostStyle.2
            @Override // java.lang.Enum
            public String toString() {
                return URequest.APPLICATION;
            }
        };

        /* synthetic */ PostStyle(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum RequestMethod {
        GET { // from class: com.umeng.socialize.net.utils.URequest.RequestMethod.1
            @Override // java.lang.Enum
            public String toString() {
                return URequest.GET;
            }
        },
        POST { // from class: com.umeng.socialize.net.utils.URequest.RequestMethod.2
            @Override // java.lang.Enum
            public String toString() {
                return URequest.POST;
            }
        };

        /* synthetic */ RequestMethod(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public abstract Map<String, Object> buildParams();

    public Map<String, Object> getBodyPair() {
        return null;
    }

    public Map<String, FilePair> getFilePair() {
        return null;
    }

    public abstract String toGetUrl();

    public abstract JSONObject toJson();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class FilePair {
        byte[] mBinaryData;
        String mFileName;

        public FilePair(String str, byte[] bArr) {
            this.mFileName = str;
            this.mBinaryData = bArr;
        }
    }

    public static String buildGetParams(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (map.get(str) != null) {
                sb.append(str + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(map.get(str).toString()) + ContainerUtils.FIELD_DELIMITER);
            }
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    protected String getHttpMethod() {
        return this.mMethod.toString();
    }

    public void setBaseUrl(String str) {
        this.mBaseUrl = str;
    }

    public URequest(String str) {
        this.mBaseUrl = str;
    }

    public void addStringParams(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.mParams.put(str, str2);
        }
    }

    public String buildGetUrl(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && map != null && map.size() != 0) {
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            String buildGetParams = buildGetParams(map);
            SLog.debug(UmengText.NET.assertURL(str, buildGetParams));
            try {
                buildGetParams = getEcryptString(buildGetParams);
            } catch (Exception e6) {
                SLog.error(UmengText.NET.PARSEERROR, e6);
            }
            return str + buildGetParams;
        }
        return str;
    }

    public String generateGetURL(String str, Map<String, Object> map) {
        return buildGetUrl(str, map);
    }

    public void onPrepareRequest() {
    }

    public String getDecryptString(String str) {
        return str;
    }

    public String getEcryptString(String str) {
        return str;
    }
}
