package xyz.adscope.amps.adapter.ks.util;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import xyz.adscope.amps.adapter.ks.KSInitMediation;
import xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.ks.model.AdBidsModel;
import xyz.adscope.amps.adapter.ks.model.BidResponseModel;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.json.util.JsonUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class KSBiddingRequestUtil {
    /* JADX INFO: Access modifiers changed from: private */
    public static String buildPostData(String str, String str2, String str3, int i6) {
        try {
            JSONObject jSONObject = new JSONObject();
            String ipAddress = KSInitMediation.getInstance().getIpAddress();
            if (!TextUtils.isEmpty(ipAddress)) {
                jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, ipAddress);
            }
            jSONObject.put("adxId", str);
            jSONObject.put("sdkToken", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("posId", str3);
            jSONObject2.put("adCount", 1);
            jSONObject2.put("cpmBidFloor", i6);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("adImpInfos", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callBackBiddingFail(final BiddingRequestCallback biddingRequestCallback, final int i6, final String str) {
        ThreadUtils.runOnUIThread(new Runnable() { // from class: xyz.adscope.amps.adapter.ks.util.KSBiddingRequestUtil.3
            @Override // java.lang.Runnable
            public void run() {
                BiddingRequestCallback biddingRequestCallback2 = BiddingRequestCallback.this;
                if (biddingRequestCallback2 != null) {
                    biddingRequestCallback2.fail(i6, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HttpURLConnection createConnection(String str, String str2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod(str2);
        return httpURLConnection;
    }

    public static void sendWinNotice(BidResponseModel bidResponseModel) {
        if (bidResponseModel == null || bidResponseModel.getAdBids() == null || bidResponseModel.getAdBids().isEmpty()) {
            return;
        }
        final String winNoticeUrl = bidResponseModel.getAdBids().get(0).getWinNoticeUrl();
        if (TextUtils.isEmpty(winNoticeUrl)) {
            return;
        }
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: xyz.adscope.amps.adapter.ks.util.KSBiddingRequestUtil.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    KSBiddingRequestUtil.createConnection(winNoticeUrl, "GET").getResponseCode();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public static void getBidResponse(final String str, final String str2, final String str3, final int i6, final BiddingRequestCallback biddingRequestCallback) {
        final String bidToken = KSInitMediation.getInstance().getBidToken(str3);
        if (TextUtils.isEmpty(bidToken)) {
            if (biddingRequestCallback != null) {
                biddingRequestCallback.fail(1001, "bid token is null");
                return;
            }
            return;
        }
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: xyz.adscope.amps.adapter.ks.util.KSBiddingRequestUtil.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection createConnection = KSBiddingRequestUtil.createConnection(str, "POST");
                    String buildPostData = KSBiddingRequestUtil.buildPostData(str2, bidToken, str3, i6);
                    if (!TextUtils.isEmpty(buildPostData)) {
                        OutputStream outputStream = createConnection.getOutputStream();
                        outputStream.write(buildPostData.getBytes());
                        outputStream.flush();
                    }
                    int responseCode = createConnection.getResponseCode();
                    if (responseCode != 200) {
                        KSBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, responseCode, "");
                        return;
                    }
                    String stringContent = KSBiddingRequestUtil.getStringContent(createConnection);
                    if (TextUtils.isEmpty(stringContent)) {
                        KSBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, 1002, "bid response is null");
                        return;
                    }
                    final BidResponseModel bidResponseModel = (BidResponseModel) new JSONParse().fromJson(stringContent, BidResponseModel.class);
                    if (bidResponseModel != null && bidResponseModel.getResult() != 1) {
                        KSBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, bidResponseModel.getResult(), bidResponseModel.getErrorMsg());
                        return;
                    }
                    if (bidResponseModel != null && bidResponseModel.getAdBids() != null && !bidResponseModel.getAdBids().isEmpty()) {
                        for (AdBidsModel adBidsModel : bidResponseModel.getAdBids()) {
                            adBidsModel.setBidEcpm(adBidsModel.getEcpm());
                            adBidsModel.setWinNoticeUrl(adBidsModel.getWinNoticeUrl().replace("${WIN_PRICE}", String.valueOf(adBidsModel.getEcpm())));
                        }
                        final int ecpm = bidResponseModel.getAdBids().get(0).getEcpm();
                        ThreadUtils.runOnUIThread(new Runnable() { // from class: xyz.adscope.amps.adapter.ks.util.KSBiddingRequestUtil.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BiddingRequestCallback biddingRequestCallback2 = biddingRequestCallback;
                                if (biddingRequestCallback2 != null) {
                                    biddingRequestCallback2.success(JsonUtil.toJson(bidResponseModel), ecpm, bidResponseModel);
                                }
                            }
                        });
                        return;
                    }
                    KSBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, 1003, "bid response adBids is null");
                } catch (Exception e6) {
                    KSBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, 1004, "bid exception is " + e6.getMessage());
                }
            }
        });
    }

    private static byte[] getBytesContent(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            inputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStringContent(HttpURLConnection httpURLConnection) {
        byte[] bytesContent = getBytesContent(httpURLConnection);
        String str = null;
        if (bytesContent == null) {
            return null;
        }
        if (bytesContent.length == 0) {
            return "";
        }
        try {
            str = httpURLConnection.getContentEncoding();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (str == null) {
            str = "UTF-8";
        }
        return new String(bytesContent, str);
    }
}
