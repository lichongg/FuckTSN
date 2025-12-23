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
public class HTTPDNSHosts {
    private static final String TAG = "BatchParseHTTPDNSHosts";
    private static String mTTDNSServer = "/q?host=";
    protected boolean mCancelled = false;
    protected Handler mHandler;
    public String[] mHostnames;
    private int mHttpDNSType;
    public String mId;
    protected AVMDLNetClient mNetClient;

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(JPushConstants.HTTPS_PRE + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            String[] strArr = this.mHostnames;
            if (i6 >= strArr.length) {
                return sb.toString();
            }
            if (!TextUtils.isEmpty(strArr[i6])) {
                if (i7 == 0) {
                    sb.append(this.mHostnames[i6]);
                } else {
                    sb.append("," + this.mHostnames[i6]);
                }
                i7++;
            }
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        String.format("****http dns id:%s type:%d", this.mId, Integer.valueOf(this.mHttpDNSType));
        if (error != null) {
            String.format("handle response receive err:%s", error.errStr);
            return;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            String.format("json null err", new Object[0]);
            return;
        }
        try {
            parseResult(jSONObject);
        } catch (Throwable th) {
            String.format("handle response exception:%s", th.toString());
        }
        String.format("****parse end", new Object[0]);
    }

    private void parseResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dns");
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                AVMDLDNSInfo parserResultForSingleHost = parserResultForSingleHost(jSONArray.getJSONObject(i6));
                if (parserResultForSingleHost != null) {
                    IPCache.getInstance().put(parserResultForSingleHost.mHost, parserResultForSingleHost);
                }
            }
        } catch (Exception unused) {
        }
    }

    private AVMDLDNSInfo parserResultForSingleHost(JSONObject jSONObject) {
        String str;
        long j6;
        String str2;
        int i6 = this.mHttpDNSType;
        String str3 = "";
        if (i6 == 2 || i6 == 1) {
            if (jSONObject != null && jSONObject.length() != 0) {
                int optInt = jSONObject.has(RtspHeaders.Values.TTL) ? jSONObject.optInt(RtspHeaders.Values.TTL) : 60;
                String optString = jSONObject.has("host") ? jSONObject.optString("host") : null;
                long currentTimeMillis = System.currentTimeMillis() + (optInt * 1000);
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                        try {
                            str2 = optJSONArray.getString(i7);
                        } catch (Exception e6) {
                            vl.j(e6);
                            str2 = null;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            str3 = TextUtils.isEmpty(str3) ? str3 + str2 : str3 + "," + str2;
                        }
                    }
                    str = optString;
                    j6 = currentTimeMillis;
                }
            }
            return null;
        }
        str = null;
        j6 = 0;
        String str4 = str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str4)) {
            String.format("parse result host:%s ips:%s expiredT:%d", str, str4, Long.valueOf(j6));
            return new AVMDLDNSInfo(this.mHttpDNSType, str, str4, j6, this.mId);
        }
        return null;
    }

    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    public HTTPDNSHosts(String[] strArr, AVMDLNetClient aVMDLNetClient, int i6, Handler handler) throws Exception {
        this.mHttpDNSType = 2;
        this.mNetClient = null;
        if (i6 == 2) {
            if (strArr != null && strArr.length != 0) {
                this.mHttpDNSType = i6;
                this.mHostnames = strArr;
                this.mNetClient = aVMDLNetClient;
                if (aVMDLNetClient == null) {
                    this.mNetClient = new AVMDLHTTPNetwork();
                }
                this.mHttpDNSType = i6;
                this.mHandler = handler;
                return;
            }
            throw new Exception("host array is valid");
        }
        throw new Exception("type is not own");
    }

    public void start() {
        String _getURL = _getURL();
        for (Method method : this.mNetClient.getClass().getDeclaredMethods()) {
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                this.mNetClient.startTask(_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNSHosts.1
                    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                    public void onCompletion(JSONObject jSONObject, Error error) {
                        HTTPDNSHosts.this._handleResponse(jSONObject, error);
                    }
                });
                return;
            }
        }
        this.mNetClient.startTask(_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNSHosts.2
            @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
            public void onCompletion(JSONObject jSONObject, Error error) {
                HTTPDNSHosts.this._handleResponse(jSONObject, error);
            }
        });
    }
}
