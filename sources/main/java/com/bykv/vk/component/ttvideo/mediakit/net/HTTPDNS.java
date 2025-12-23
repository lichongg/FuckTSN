package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import com.bytedance.sdk.component.utils.vl;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGoogleDNSServer = "/resolve?name=";
    private static String mTTDNSServer = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        int i6 = this.mHttpDNSType;
        if (i6 == 2 || i6 == 1) {
            sb.append(JPushConstants.HTTPS_PRE + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        } else if (i6 == 3) {
            sb.append(JPushConstants.HTTPS_PRE + AVMDLDNSParser.mGlobalGoogleDNSParseHost + mGoogleDNSServer);
        }
        sb.append(this.mHostname);
        int i7 = this.mHttpDNSType;
        if (i7 == 2 || i7 == 1) {
            sb.append("&source=vod");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        AVMDLDNSInfo aVMDLDNSInfo;
        String.format("****http dns id:%s type:%d host:%s", this.mId, Integer.valueOf(this.mHttpDNSType), this.mHostname);
        AVMDLDNSInfo aVMDLDNSInfo2 = new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, (String) null, 0L, this.mId);
        if (error != null) {
            String str = error.errStr;
            aVMDLDNSInfo2.mErrorStr = str;
            String.format("handle response receive err:%s", str);
        } else if (jSONObject == null || jSONObject.length() == 0) {
            int i6 = this.mHttpDNSType;
            new Error(i6, this.mHostname, this.mId, String.format("HTTP dns empty, type:%d", Integer.valueOf(i6)));
            String.format("json null err", new Object[0]);
        } else {
            try {
                aVMDLDNSInfo = parserResult(jSONObject);
            } catch (Throwable th) {
                String.format("handle response exception:%s", th.toString());
                aVMDLDNSInfo = null;
            }
            if (aVMDLDNSInfo != null) {
                String.format("****parse suc for host:%s iplist:%s", this.mHostname, aVMDLDNSInfo.mIpList);
                IPCache.getInstance().put(this.mHostname, aVMDLDNSInfo);
                notifySuccess(aVMDLDNSInfo);
                return;
            }
            String.format("info null err", new Object[0]);
        }
        String.format("****parse failed for host:%s", this.mHostname);
        notifyError(aVMDLDNSInfo2);
    }

    private AVMDLDNSInfo parserResult(JSONObject jSONObject) {
        AVMDLDNSInfo aVMDLDNSInfo;
        long currentTimeMillis;
        String str;
        char c6;
        int i6 = this.mHttpDNSType;
        String str2 = "";
        if (i6 == 2 || i6 == 1) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            r12 = jSONObject.has(RtspHeaders.Values.TTL) ? jSONObject.optInt(RtspHeaders.Values.TTL) : 60;
            String.format("receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(r12), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
            int i7 = AVMDLDNSParser.mGlobalForceExpiredTime;
            if (i7 > 0) {
                r12 = i7;
            }
            int i8 = r12;
            aVMDLDNSInfo = null;
            currentTimeMillis = System.currentTimeMillis() + (r12 * 1000);
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return null;
            }
            str = null;
            c6 = 0;
            for (int i9 = 0; i9 < optJSONArray.length(); i9++) {
                try {
                    str = optJSONArray.getString(i9);
                } catch (Exception e6) {
                    vl.j(e6);
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    str2 = TextUtils.isEmpty(str2) ? str2 + str : str2 + "," + str;
                }
            }
            r12 = i8;
        } else {
            currentTimeMillis = 0;
            str = null;
            aVMDLDNSInfo = null;
            c6 = 0;
        }
        if (this.mHttpDNSType == 3) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Answer");
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    if (jSONObject2.has("type") && jSONObject2.getInt("type") == 1) {
                        if (jSONObject2.has("TTL")) {
                            r12 = jSONObject2.optInt("TTL");
                        }
                        if (jSONObject2.has("data")) {
                            str = jSONObject2.optString("data");
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str2 = TextUtils.isEmpty(str2) ? str2 + str : str2 + "," + str;
                        }
                    }
                }
                Integer valueOf = Integer.valueOf(r12);
                Integer valueOf2 = Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime);
                Object[] objArr = new Object[2];
                objArr[c6] = valueOf;
                objArr[1] = valueOf2;
                String.format("receive expiredtime:%d force expiredtime:%d ", objArr);
                int i11 = AVMDLDNSParser.mGlobalForceExpiredTime;
                if (i11 > 0) {
                    r12 = i11;
                }
                currentTimeMillis = System.currentTimeMillis() + (r12 * 1000);
            } catch (Exception e7) {
                vl.j(e7);
                return aVMDLDNSInfo;
            }
        }
        return new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, str2, currentTimeMillis, this.mId);
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    public HTTPDNS(String str, AVMDLNetClient aVMDLNetClient, int i6, Handler handler) {
        super(str, aVMDLNetClient, handler);
        this.mHttpDNSType = i6;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void start() {
        String _getURL = _getURL();
        for (Method method : this.mNetClient.getClass().getDeclaredMethods()) {
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                this.mNetClient.startTask(_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.1
                    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                    public void onCompletion(JSONObject jSONObject, Error error) {
                        HTTPDNS.this._handleResponse(jSONObject, error);
                    }
                });
                return;
            }
        }
        this.mNetClient.startTask(_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.2
            @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
            public void onCompletion(JSONObject jSONObject, Error error) {
                HTTPDNS.this._handleResponse(jSONObject, error);
            }
        });
    }
}
