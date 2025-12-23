package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.c3;
import com.amap.api.col.p0003l.d3;
import com.amap.api.col.p0003l.f4;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.g2;
import com.amap.api.col.p0003l.h4;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.u6;
import com.amap.api.col.p0003l.v5;
import com.amap.api.col.p0003l.y2;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.NetworkProxyManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapLoader implements u6.a {
    private static final int GET_METHOD = 0;
    private static final String NETWORK_RESPONSE_CODE_STRING = "网络异常状态码：";
    private Context context;
    private u6 downloadManager;
    private ADataRequestParam mDataRequestParam;
    private boolean mRequestCancel;
    private volatile boolean isCanceled = false;
    private long requestMapDataTimestamp = 0;
    private long requestMapDataPackageSize = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class AMapGridDownloadRequest extends g2 {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        @Override // com.amap.api.col.p0003l.g2, com.amap.api.col.p0003l.Cif
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public boolean isSupportIPV6() {
            return true;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public String getURL() {
            return this.sUrl;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public String getIPV6URL() {
            return b3.y(getURL());
        }

        @Override // com.amap.api.col.p0003l.Cif
        public Map<String, String> getRequestHead() {
            String str;
            p4 s5 = b3.s();
            if (s5 != null) {
                str = s5.e();
            } else {
                str = null;
            }
            String j6 = f4.j(this.mContext);
            try {
                j6 = URLEncoder.encode(j6, "UTF-8");
            } catch (Throwable unused) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", str, "3dmap"));
            hashtable.put("x-INFO", h4.b(this.mContext));
            hashtable.put("key", j6);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager == null || this.isCanceled) {
            return;
        }
        synchronized (this.downloadManager) {
            try {
                this.isCanceled = true;
                this.downloadManager.a();
            } finally {
            }
        }
    }

    private String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String j6 = f4.j(this.context);
        try {
            j6 = URLEncoder.encode(j6, "UTF-8");
        } catch (Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(j6);
        String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String a6 = h4.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a6)));
        stringBuffer.append("&scode=" + h4.c(context, a6, sortReEncoderParams));
        stringBuffer.append("&dip=16300");
        return stringBuffer.toString();
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private void onCancel() {
        if (this.mDataRequestParam != null) {
            NetworkProxyManager.getInstance().netCancel(this.mDataRequestParam.handler, -1);
        }
    }

    private String sortReEncoderParams(String str) {
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(strReEncoder(str2));
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private void staticNetworkPerformance() {
        y2.f(this.context, hashCode(), System.currentTimeMillis() - this.requestMapDataTimestamp, this.requestMapDataPackageSize);
    }

    private String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            v5.p(e6, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e7) {
            v5.p(e7, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public void doRequest() {
        if (ft.a(this.context, b3.s()).f6803a != ft.c.SuccessCode) {
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, -1);
                return;
            }
            return;
        }
        if (this.mRequestCancel) {
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, -1);
                return;
            }
            return;
        }
        ADataRequestParam aDataRequestParam = this.mDataRequestParam;
        String str = aDataRequestParam.requestBaseUrl;
        String str2 = aDataRequestParam.requestUrl;
        if (!str.endsWith("?")) {
            str = str + "?";
        }
        String requestParams = getRequestParams(str2.replaceAll(";", getEncodeRequestParams(";").toString()), str != null && str.contains("http://m5.amap.com/"), this.mDataRequestParam.nRequestType);
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mDataRequestParam.nRequestType == 0) {
            stringBuffer.append(requestParams);
            stringBuffer.append("&csid=" + UUID.randomUUID().toString());
        } else {
            stringBuffer.append("csid=" + UUID.randomUUID().toString());
        }
        try {
            AMapGridDownloadRequest aMapGridDownloadRequest = new AMapGridDownloadRequest(this.context, str + generateQueryString(this.context, stringBuffer.toString()), NetworkProxyManager.getInstance().getUserAgent());
            aMapGridDownloadRequest.setConnectionTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
            aMapGridDownloadRequest.setSoTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
            if (this.mDataRequestParam.nRequestType != 0) {
                aMapGridDownloadRequest.setPostEntityBytes(requestParams.getBytes("UTF-8"));
            }
            this.requestMapDataTimestamp = System.currentTimeMillis();
            this.requestMapDataPackageSize = aMapGridDownloadRequest.getEntityBytes() == null ? 0L : aMapGridDownloadRequest.getEntityBytes().length;
            u6 u6Var = new u6(aMapGridDownloadRequest, 0L, -1L, MapsInitializer.getProtocol() == 2);
            this.downloadManager = u6Var;
            u6Var.b(this);
        } catch (Throwable th) {
            try {
                onException(th);
            } finally {
                doCancel();
            }
        }
    }

    protected String getRequestParams(String str, boolean z5, int i6) {
        StringBuffer stringBuffer = new StringBuffer(str);
        if (z5) {
            stringBuffer.append("&channel=amap7&div=GNaviMap");
        } else {
            stringBuffer.append("&channel=amapapi");
            stringBuffer.append("&div=GNaviMap");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.3l.u6.a
    public void onDownload(byte[] bArr, long j6) {
        if (bArr == null || this.mDataRequestParam == null) {
            return;
        }
        NetworkProxyManager.getInstance().receiveNetData(this.mDataRequestParam.handler, bArr, bArr.length);
    }

    @Override // com.amap.api.col.3l.u6.a
    public void onException(Throwable th) {
        int indexOf;
        try {
            String str = new String(th.getMessage().getBytes("UTF-8"), "UTF-8");
            int parseInt = (TextUtils.isEmpty(str) || (indexOf = str.indexOf(NETWORK_RESPONSE_CODE_STRING)) == -1) ? -1 : Integer.parseInt(str.substring(indexOf + 8));
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, parseInt);
            }
        } catch (Throwable unused) {
            if (this.mDataRequestParam != null) {
                NetworkProxyManager.getInstance().netError(this.mDataRequestParam.handler, -1, -1);
            }
        }
        y2.e(this.context, hashCode(), !NetworkProxyManager.getInstance().isNetworkConnected() ? 1 : 0, getNetworkFailedReason(th.getMessage()));
        v5.p(th, "AMapLoader", "download onException");
        d3.l(c3.f5805e, "map loader exception " + th.getMessage());
    }

    @Override // com.amap.api.col.3l.u6.a
    public void onFinish() {
        if (this.mDataRequestParam != null) {
            NetworkProxyManager.getInstance().finishDownLoad(this.mDataRequestParam.handler);
        }
        staticNetworkPerformance();
    }

    @Override // com.amap.api.col.3l.u6.a
    public void onStop() {
        if (this.mDataRequestParam != null) {
            NetworkProxyManager.getInstance().netStop(this.mDataRequestParam.handler, -1);
        }
        staticNetworkPerformance();
    }

    public AMapLoader(Context context, ADataRequestParam aDataRequestParam) {
        this.mRequestCancel = false;
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mDataRequestParam = aDataRequestParam;
        this.mRequestCancel = false;
    }

    private String getNetworkFailedReason(String str) {
        if (!NetworkProxyManager.getInstance().isNetworkConnected()) {
            return "无网络";
        }
        return str;
    }

    public void doCancelAndNotify() {
        onCancel();
        doCancel();
    }
}
