package com.bykv.vk.component.ttvideo.model;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.component.utils.vl;
import com.google.android.gms.actions.SearchIntents;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class LiveStreamInfo {
    public static final int LIVE_STREAM_INFO_CMAF_INVALID = 1;
    public static final int LIVE_STREAM_INFO_LLS_INVALID = 2;
    public static final String MPD_VERSION = "1.0";
    private JSONObject mCommonInfo;
    private String mDefaultResolution;
    private int mFlag;
    private String mHost;
    private String mIp;
    private boolean mIsABRListMatch;
    private String mRequestParams;
    private JSONObject mStreamInfo;
    private boolean mEnableOriginResolution = false;
    private long mAdjustedOriginBitRate = -1;
    private int mIsCodecSame = -1;
    private String mTransportProtocol = "";
    private String mPortNum = "";
    private int mRtcFallback = 0;
    private final String TAG = "LiveStreamInfo";
    public int mSRShorterSideUpperBound = 0;
    public int mSRLongerSideUpperBound = 0;
    private int mSRFrameRateUpperBound = 0;
    public int mSharpenLongerSideUpperBound = 0;
    public int mSharpenLongerSideLowerBound = 0;
    public int mSharpenShorterSideUpperBound = 0;
    public int mSharpenShorterSideLowerBound = 0;

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
    
        r6.mIsABRListMatch = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LiveStreamInfo(org.json.JSONObject r7) {
        /*
            r6 = this;
            java.lang.String r0 = "list"
            java.lang.String r1 = "default"
            java.lang.String r2 = "common"
            r6.<init>()
            r3 = 0
            r6.mEnableOriginResolution = r3
            r4 = -1
            r6.mAdjustedOriginBitRate = r4
            r4 = -1
            r6.mIsCodecSame = r4
            java.lang.String r4 = ""
            r6.mTransportProtocol = r4
            r6.mPortNum = r4
            r6.mRtcFallback = r3
            java.lang.String r4 = "LiveStreamInfo"
            r6.TAG = r4
            r6.mSRShorterSideUpperBound = r3
            r6.mSRLongerSideUpperBound = r3
            r6.mSRFrameRateUpperBound = r3
            r6.mIsABRListMatch = r3
            r6.mSharpenLongerSideUpperBound = r3
            r6.mSharpenLongerSideLowerBound = r3
            r6.mSharpenShorterSideUpperBound = r3
            r6.mSharpenShorterSideLowerBound = r3
            if (r7 != 0) goto L32
            return
        L32:
            java.lang.String r5 = "data"
            org.json.JSONObject r5 = r7.getJSONObject(r5)     // Catch: org.json.JSONException -> L47
            r6.mStreamInfo = r5     // Catch: org.json.JSONException -> L47
            boolean r5 = r7.has(r2)     // Catch: org.json.JSONException -> L47
            if (r5 == 0) goto L49
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch: org.json.JSONException -> L47
            r6.mCommonInfo = r7     // Catch: org.json.JSONException -> L47
            goto L49
        L47:
            r7 = move-exception
            goto La2
        L49:
            org.json.JSONObject r7 = r6.mCommonInfo     // Catch: org.json.JSONException -> L47
            if (r7 == 0) goto La5
            java.lang.String r2 = "auto"
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch: org.json.JSONException -> L47
            if (r7 == 0) goto L74
            boolean r2 = r7.has(r1)     // Catch: org.json.JSONException -> L47
            if (r2 == 0) goto L74
            java.lang.String r1 = r7.getString(r1)     // Catch: org.json.JSONException -> L47
            r6.mDefaultResolution = r1     // Catch: org.json.JSONException -> L47
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L47
            java.lang.String r2 = "mDefaultResolution: "
            r1.<init>(r2)     // Catch: org.json.JSONException -> L47
            java.lang.String r2 = r6.mDefaultResolution     // Catch: org.json.JSONException -> L47
            r1.append(r2)     // Catch: org.json.JSONException -> L47
            java.lang.String r1 = r1.toString()     // Catch: org.json.JSONException -> L47
            com.bykv.vk.component.ttvideo.log.MyLog.i(r4, r1)     // Catch: org.json.JSONException -> L47
        L74:
            r1 = 1
            r6.mIsABRListMatch = r1     // Catch: org.json.JSONException -> L47
            if (r7 == 0) goto La5
            boolean r1 = r7.has(r0)     // Catch: org.json.JSONException -> L47
            if (r1 == 0) goto La5
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch: org.json.JSONException -> L47
            if (r7 == 0) goto La5
            int r0 = r7.length()     // Catch: org.json.JSONException -> L47
            if (r0 <= 0) goto La5
            r0 = 0
        L8c:
            int r1 = r7.length()     // Catch: org.json.JSONException -> L47
            if (r0 >= r1) goto La5
            java.lang.String r1 = r7.getString(r0)     // Catch: org.json.JSONException -> L47
            boolean r1 = r6.isSupport(r1)     // Catch: org.json.JSONException -> L47
            if (r1 != 0) goto L9f
            r6.mIsABRListMatch = r3     // Catch: org.json.JSONException -> L47
            goto La5
        L9f:
            int r0 = r0 + 1
            goto L8c
        La2:
            com.bytedance.sdk.component.utils.vl.j(r7)
        La5:
            r6.mFlag = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.<init>(org.json.JSONObject):void");
    }

    private String set_url_port_scheme(String str) {
        int indexOf;
        int indexOf2 = str.indexOf(".com");
        int indexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.mPortNum)) {
            if (indexOf3 != -1) {
                int i6 = indexOf3 + 5;
                int i7 = indexOf3 + 6;
                while (i7 < sb.length() && sb.charAt(i7) - '0' >= 0 && sb.charAt(i7) - '0' <= 9) {
                    i7++;
                }
                sb.replace(i6, i7, this.mPortNum);
            } else if (indexOf2 != -1 && ((indexOf = str.indexOf("vhost")) == -1 || indexOf > indexOf2)) {
                sb.insert(indexOf2 + 4, ":" + this.mPortNum);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int indexOf4 = sb2.indexOf("://");
        if (!TextUtils.isEmpty(this.mTransportProtocol)) {
            if (this.mTransportProtocol.equals(LiveConfigKey.KCP)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpk");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpq");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TLS)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, b.f50155b);
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && indexOf4 != -1) {
                sb2.replace(0, indexOf4, b.f50154a);
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007f, code lost:
    
        if (r5.equals("origin") == false) goto L20;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean adjustOriginBitRate(java.lang.String r20, java.lang.String r21, long r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            r2 = r22
            long r4 = r0.mAdjustedOriginBitRate
            r6 = 1
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L10
            return r6
        L10:
            java.lang.String r4 = "ld"
            r9 = -1
            r5 = r4
        L15:
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            r12 = 0
            if (r11 != 0) goto L92
            r11 = r20
            java.lang.String r13 = r0.getStreamUrlForResolution(r5, r11, r1)
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            java.lang.String r14 = "origin"
            if (r13 != 0) goto L40
            long r15 = r0.getBitrate(r5, r1)
            boolean r13 = r5.equals(r14)
            if (r13 == 0) goto L3f
            int r13 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r13 > 0) goto L3f
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 <= 0) goto L3f
            r0.mAdjustedOriginBitRate = r2
            r15 = r2
        L3f:
            r9 = r15
        L40:
            r5.getClass()
            int r13 = r5.hashCode()
            java.lang.String r15 = "uhd"
            r16 = 1
            java.lang.String r6 = "sd"
            r17 = r7
            java.lang.String r7 = "hd"
            r8 = -1
            switch(r13) {
                case -1008619738: goto L7b;
                case 3324: goto L72;
                case 3448: goto L69;
                case 3665: goto L60;
                case 115761: goto L57;
                default: goto L55;
            }
        L55:
            r12 = -1
            goto L82
        L57:
            boolean r5 = r5.equals(r15)
            if (r5 != 0) goto L5e
            goto L55
        L5e:
            r12 = 4
            goto L82
        L60:
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L67
            goto L55
        L67:
            r12 = 3
            goto L82
        L69:
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L70
            goto L55
        L70:
            r12 = 2
            goto L82
        L72:
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L79
            goto L55
        L79:
            r12 = 1
            goto L82
        L7b:
            boolean r5 = r5.equals(r14)
            if (r5 != 0) goto L82
            goto L55
        L82:
            r5 = 0
            switch(r12) {
                case 0: goto L86;
                case 1: goto L90;
                case 2: goto L8e;
                case 3: goto L8c;
                case 4: goto L8a;
                default: goto L86;
            }
        L86:
            r7 = r17
            r6 = 1
            goto L15
        L8a:
            r5 = r14
            goto L86
        L8c:
            r5 = r7
            goto L86
        L8e:
            r5 = r6
            goto L86
        L90:
            r5 = r15
            goto L86
        L92:
            r17 = r7
            r16 = 1
            long r1 = r0.mAdjustedOriginBitRate
            int r3 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r3 <= 0) goto L9d
            return r16
        L9d:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.adjustOriginBitRate(java.lang.String, java.lang.String, long):boolean");
    }

    public JSONObject getAbrInfo() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject("auto");
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    public String getDefaultResolution() {
        return this.mDefaultResolution;
    }

    public Map<String, String> getHTTPHeaders() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has("header")) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject("header");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.getString(next));
                }
                return hashMap;
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        return null;
    }

    public String getLabelfromBitrate(long j6, String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        Iterator<String> keys = this.mStreamInfo.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (isEnableAdaptive(next) && j6 == getBitrate(next, str) / 1000) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae A[Catch: JSONException -> 0x0083, TryCatch #0 {JSONException -> 0x0083, blocks: (B:27:0x0052, B:31:0x0079, B:33:0x007f, B:34:0x0090, B:36:0x00ae, B:38:0x00b5, B:39:0x00ca, B:41:0x00d2, B:45:0x00ee, B:47:0x00f8, B:48:0x0107, B:50:0x010e, B:51:0x0115, B:54:0x0104, B:55:0x0089, B:71:0x013d), top: B:26:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010e A[Catch: JSONException -> 0x0083, TryCatch #0 {JSONException -> 0x0083, blocks: (B:27:0x0052, B:31:0x0079, B:33:0x007f, B:34:0x0090, B:36:0x00ae, B:38:0x00b5, B:39:0x00ca, B:41:0x00d2, B:45:0x00ee, B:47:0x00f8, B:48:0x0107, B:50:0x010e, B:51:0x0115, B:54:0x0104, B:55:0x0089, B:71:0x013d), top: B:26:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getMPDForFormat(java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.getMPDForFormat(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public String getPortNum(String str, String str2, String str3) {
        String str4;
        if (this.mCommonInfo == null) {
            return null;
        }
        try {
            str4 = new JSONObject(this.mCommonInfo.getJSONObject(str.equals(LiveConfigKey.RTMP) ? "rtmp_ports" : "http_ports").optString(str2)).optString(str3);
        } catch (JSONException e6) {
            vl.j(e6);
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        return str4;
    }

    public String getQueryItems() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has(SearchIntents.EXTRA_QUERY)) {
            StringBuilder sb = new StringBuilder();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject(SearchIntents.EXTRA_QUERY);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject2.getString(next);
                    String encode = URLEncoder.encode(next, "UTF-8");
                    String encode2 = URLEncoder.encode(string, "UTF-8");
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                    sb.append(encode);
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(encode2);
                }
                return sb.toString();
            } catch (UnsupportedEncodingException e6) {
                e = e6;
                vl.j(e);
                return null;
            } catch (JSONException e7) {
                e = e7;
                vl.j(e);
                return null;
            }
        }
        return null;
    }

    public String getRuleIds() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("rule_ids")) {
            return null;
        }
        return this.mCommonInfo.optString("rule_ids");
    }

    public int getSRLongerSideUpperBound() {
        return this.mSRLongerSideUpperBound;
    }

    public int getSRShorterSideUpperBound() {
        return this.mSRShorterSideUpperBound;
    }

    public String getSessionID() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("session_id")) {
            return null;
        }
        return this.mCommonInfo.optString("session_id");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getStreamUrlForResolution(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.model.LiveStreamInfo.getStreamUrlForResolution(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public boolean isABRListMatch() {
        return this.mIsABRListMatch;
    }

    public boolean isCodecSame(String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return false;
        }
        int i6 = this.mIsCodecSame;
        if (i6 >= 0) {
            return i6 == 1;
        }
        this.mIsCodecSame = 1;
        Iterator<String> keys = this.mStreamInfo.keys();
        String str2 = null;
        String str3 = null;
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            str3 = getVCodec(keys.next(), str);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.mIsCodecSame = 0;
                break;
            }
            if (!TextUtils.isEmpty(str3)) {
                str2 = str3;
            }
        }
        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
            this.mIsCodecSame = 0;
        }
        return this.mIsCodecSame == 1;
    }

    public boolean isEnableAdaptive(String str) {
        JSONArray optJSONArray;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return false;
        }
        try {
            JSONObject abrInfo = getAbrInfo();
            if (abrInfo != null && abrInfo.has("list") && (optJSONArray = abrInfo.optJSONArray("list")) != null && optJSONArray.length() > 0) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    String string = optJSONArray.getString(i6);
                    if (string != null && string.equals(str) && (!string.equals("origin") || this.mEnableOriginResolution)) {
                        return true;
                    }
                }
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        return false;
    }

    public boolean isSupport(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.mStreamInfo;
        if (jSONObject2 == null) {
            return false;
        }
        try {
            jSONObject = jSONObject2.getJSONObject(str);
        } catch (JSONException e6) {
            vl.j(e6);
            jSONObject = null;
        }
        return jSONObject != null;
    }

    public void setEnableOriginResolution(boolean z5) {
        this.mEnableOriginResolution = z5;
    }

    public boolean setFlag(int i6) {
        this.mFlag = i6 | this.mFlag;
        return true;
    }

    public void setRequestParams(String str) {
        this.mRequestParams = str;
    }

    public void setRequestParamsWithDNSIp(String str, String str2, String str3) {
        this.mRequestParams = str;
        this.mIp = str2;
        this.mHost = str3;
    }

    public void setRtcFallback(int i6) {
        this.mRtcFallback = i6;
    }

    public void setTransportProtocol(String str, String str2) {
        this.mTransportProtocol = str;
        this.mPortNum = str2;
    }

    private boolean isNeedUseDefaultResolution(String str) {
        if (!TextUtils.isEmpty(str) && str.equals("auto") && !TextUtils.isEmpty(this.mDefaultResolution)) {
            return true;
        }
        return false;
    }

    public String getAvLinesParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        try {
            String sDKParams = getSDKParams(str, str2);
            if (sDKParams == null) {
                return null;
            }
            return new JSONObject(sDKParams).optString("AvLines");
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    public long getBitrate(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return 0L;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("vbitrate");
        } catch (JSONException e6) {
            vl.j(e6);
            return 0L;
        }
    }

    public int getCheckSilenceInterval(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return -1;
        }
        try {
            String sDKParams = getSDKParams(str, str2);
            if (sDKParams == null) {
                return -1;
            }
            return new JSONObject(sDKParams).optInt("CheckSilenceInterval");
        } catch (JSONException e6) {
            vl.j(e6);
            return -1;
        }
    }

    public long getGopDuration(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return 0L;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("gop");
        } catch (JSONException e6) {
            vl.j(e6);
            return 0L;
        }
    }

    public String getSDKParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            return this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params");
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    public boolean getSREnabled(String str, String str2, int i6) {
        int i7;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params"));
            long optLong = jSONObject.optLong("vbitrate");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("NNSR"));
            if (i6 == 1) {
                i7 = jSONObject2.optInt("Enabled");
            } else {
                i7 = 0;
            }
            long optLong2 = jSONObject2.optLong("VBitrateLowerBoundInKbps");
            this.mSRShorterSideUpperBound = jSONObject2.optInt("ShorterSideUpperBound");
            this.mSRLongerSideUpperBound = jSONObject2.optInt("LongerSideUpperBound");
            int optInt = jSONObject2.optInt("FrameRateUpperBound");
            this.mSRFrameRateUpperBound = optInt;
            if (i7 != 1 || optLong < optLong2 * 1000 || this.mSRShorterSideUpperBound <= 0 || this.mSRLongerSideUpperBound <= 0 || optInt <= 0) {
                return false;
            }
            return true;
        } catch (JSONException e6) {
            vl.j(e6);
            return false;
        }
    }

    public JSONObject getSharpenParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("ASF"));
            this.mSharpenLongerSideUpperBound = jSONObject.optInt("LongerSideUpperBound");
            this.mSharpenLongerSideLowerBound = jSONObject.optInt("LongerSideLowerBound");
            this.mSharpenShorterSideUpperBound = jSONObject.optInt("ShorterSideUpperBound");
            this.mSharpenShorterSideLowerBound = jSONObject.optInt("ShorterSideLowerBound");
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    public String getSuggestFormat(String str, String str2) {
        String str3;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            str3 = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestFormat");
        } catch (JSONException e6) {
            vl.j(e6);
            str3 = null;
        }
        if (str3 == null || str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public String getSuggestProtocol(String str, String str2) {
        String str3;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestProtocol");
            str3 = LiveConfigKey.TCP;
        } catch (JSONException e6) {
            vl.j(e6);
            str3 = null;
        }
        if (str3 == null || str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public String getVCodec(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("VCodec");
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    public boolean isSupportSR(int i6, int i7, float f6) {
        int max = Math.max(i6, i7);
        int min = Math.min(i6, i7);
        if (max <= this.mSRLongerSideUpperBound && min <= this.mSRShorterSideUpperBound && f6 <= this.mSRFrameRateUpperBound && i6 < i7) {
            return true;
        }
        return false;
    }

    public boolean isSupportSharpen(int i6, int i7) {
        int max = Math.max(i6, i7);
        int min = Math.min(i6, i7);
        if (max >= this.mSharpenLongerSideLowerBound && max <= this.mSharpenLongerSideUpperBound && min >= this.mSharpenShorterSideLowerBound && min <= this.mSharpenShorterSideUpperBound) {
            return true;
        }
        return false;
    }

    public void setDefaultResolution(String str) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return;
        }
        this.mDefaultResolution = str;
    }
}
