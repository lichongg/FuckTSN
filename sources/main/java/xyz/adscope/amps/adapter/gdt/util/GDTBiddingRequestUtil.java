package xyz.adscope.amps.adapter.gdt.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.bn;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.au;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import xyz.adscope.amps.adapter.gdt.GDTAdManagerHolder;
import xyz.adscope.amps.adapter.gdt.GDTInitMediation;
import xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.gdt.model.BidModel;
import xyz.adscope.amps.adapter.gdt.model.BidResponseModel;
import xyz.adscope.amps.adapter.gdt.model.SeatBidModel;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.tool.util.AMPSScreenUtil;
import xyz.adscope.amps.tool.util.AMPSStringUtil;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.security.MD5Util;
import xyz.adscope.common.v2.dev.info.PackageUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GDTBiddingRequestUtil {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String buildPostData(Context context, String str, String str2, int i6, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", AMPSStringUtil.createRequestId());
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", AMPSStringUtil.createRequestId());
            jSONObject2.put("bidfloorcur", "CNY");
            jSONObject2.put("tagid", str2);
            jSONObject2.put("ad_count", 1);
            jSONArray.put(jSONObject2);
            jSONObject.put(au.f40898c, jSONArray);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", str);
            jSONObject3.put("bundle", context.getPackageName());
            jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(au.f40899d, GDTInitMediation.getInstance().getUserAgent(context));
            JSONObject jSONObject5 = new JSONObject();
            AMPSPrivacyConfig ampsPrivacyConfig = GDTInitMediation.getInstance().getAmpsPrivacyConfig();
            if (ampsPrivacyConfig != null) {
                String ip = ampsPrivacyConfig.getIP();
                if (!TextUtils.isEmpty(ip)) {
                    jSONObject4.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, ip);
                }
                String devImei = ampsPrivacyConfig.getDevImei();
                if (!TextUtils.isEmpty(devImei)) {
                    jSONObject4.put("ifa", devImei);
                    jSONObject4.put("didmd5", MD5Util.md5(devImei));
                }
                String androidId = ampsPrivacyConfig.getAndroidId();
                if (!TextUtils.isEmpty(androidId)) {
                    jSONObject5.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, androidId);
                }
            }
            jSONObject4.put("h", AMPSScreenUtil.getScreenHeight(context));
            jSONObject4.put(IAdInterListener.AdReqParam.WIDTH, AMPSScreenUtil.getScreenWidth(context));
            DeviceInfo deviceInfo = DeviceInfo.getInstance(context);
            if (deviceInfo != null) {
                String connectType = deviceInfo.getConnectType();
                int i7 = 3;
                switch (connectType.hashCode()) {
                    case 48:
                        connectType.equals("0");
                        break;
                    case 49:
                        if (connectType.equals("1")) {
                            i7 = 2;
                            break;
                        }
                        break;
                    case 50:
                        if (connectType.equals("2")) {
                            i7 = 4;
                            break;
                        }
                        break;
                    case 51:
                        if (connectType.equals("3")) {
                            i7 = 5;
                            break;
                        }
                        break;
                    case 52:
                        if (connectType.equals("4")) {
                            i7 = 6;
                            break;
                        }
                        break;
                    case 53:
                        if (connectType.equals("5")) {
                            i7 = 7;
                            break;
                        }
                        break;
                }
                jSONObject4.put("connectiontype", i7);
                jSONObject4.put("make", deviceInfo.getManufacturer());
                jSONObject4.put(bn.f10753i, deviceInfo.getModel());
                jSONObject4.put("os", "Android");
                jSONObject4.put("osv", deviceInfo.getOsVersion());
                jSONObject4.put("devicetype", 1);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("country", deviceInfo.getCountry_CN());
                jSONObject4.put("geo", jSONObject6);
                String oaid = deviceInfo.getOaid();
                if (TextUtils.isEmpty(oaid) && ampsPrivacyConfig != null) {
                    oaid = ampsPrivacyConfig.getDevOaid();
                }
                if (!TextUtils.isEmpty(oaid)) {
                    jSONObject5.put("oaid", deviceInfo.getOaid());
                }
                jSONObject5.put("time_zone", deviceInfo.getTimeZone());
            }
            jSONObject4.put("language", "zh-cn");
            jSONObject4.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, jSONObject5);
            jSONObject.put(ConstantHelper.LOG_DE, jSONObject4);
            ArrayList arrayList = new ArrayList();
            arrayList.add("CNY");
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(arrayList);
            jSONObject.put("cur", jSONArray2);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("buyer_id", str3);
            jSONObject7.put("wx_installed", PackageUtil.isInstall(context, "com.tencent.mm"));
            jSONObject7.put("sdk_info", str4);
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, jSONObject7);
            return jSONObject.toString();
        } catch (JSONException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callBackBiddingFail(final BiddingRequestCallback biddingRequestCallback, final int i6, final String str) {
        ThreadUtils.runOnUIThread(new Runnable() { // from class: xyz.adscope.amps.adapter.gdt.util.GDTBiddingRequestUtil.2
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
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("Accept-Language", "zh-cn");
        httpURLConnection.setRequestProperty("X-OpenRTB-Version", "2.5");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod(str2);
        return httpURLConnection;
    }

    private static Map<String, String> getRequestProperty(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("User-Agent", GDTInitMediation.getInstance().getUserAgent(context));
        hashMap.put("Accept", "application/json");
        hashMap.put("Accept-Language", "zh-cn");
        hashMap.put("X-OpenRTB-Version", "2.5");
        return hashMap;
    }

    public static void sendLossNotice(BidResponseModel bidResponseModel, int i6, int i7, String str) {
        SeatBidModel seatBidModel;
        List<BidModel> bid;
        BidModel bidModel;
        if (bidResponseModel == null) {
            return;
        }
        try {
            List<SeatBidModel> seatbid = bidResponseModel.getSeatbid();
            if (seatbid != null && !seatbid.isEmpty() && (seatBidModel = seatbid.get(0)) != null && (bid = seatBidModel.getBid()) != null && !bid.isEmpty() && (bidModel = bid.get(0)) != null) {
                String lurl = bidModel.getLurl();
                if (TextUtils.isEmpty(lurl)) {
                    return;
                }
                final String replace = lurl.replace("${AUCTION_PRICE}", RSAEncryptUtil.encrypt(String.valueOf(i6), str)).replace("${AUCTION_SEAT_ID}", "2").replace("${AUCTION_LOSS}", i7 != 1 ? i7 != 2 ? "10001" : "101" : "1");
                ThreadUtils.runOnThreadPool(new Runnable() { // from class: xyz.adscope.amps.adapter.gdt.util.GDTBiddingRequestUtil.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            GDTBiddingRequestUtil.createConnection(replace, "GET").getResponseCode();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void sendWinNotice(BidResponseModel bidResponseModel, String str) {
        SeatBidModel seatBidModel;
        List<BidModel> bid;
        BidModel bidModel;
        if (bidResponseModel == null) {
            return;
        }
        try {
            List<SeatBidModel> seatbid = bidResponseModel.getSeatbid();
            if (seatbid != null && !seatbid.isEmpty() && (seatBidModel = seatbid.get(0)) != null && (bid = seatBidModel.getBid()) != null && !bid.isEmpty() && (bidModel = bid.get(0)) != null) {
                String nurl = bidModel.getNurl();
                if (TextUtils.isEmpty(nurl)) {
                    return;
                }
                int price = (int) bidModel.getPrice();
                final String replace = nurl.replace("${AUCTION_PRICE}", RSAEncryptUtil.encrypt(String.valueOf(price), str)).replace("${HIGHEST_LOSS_PRICE}", String.valueOf(price - 1));
                ThreadUtils.runOnThreadPool(new Runnable() { // from class: xyz.adscope.amps.adapter.gdt.util.GDTBiddingRequestUtil.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            GDTBiddingRequestUtil.createConnection(replace, "GET").getResponseCode();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void getBidResponse(final Context context, final String str, final String str2, final String str3, final int i6, final BiddingRequestCallback biddingRequestCallback) {
        if (TextUtils.isEmpty(str)) {
            if (biddingRequestCallback != null) {
                biddingRequestCallback.fail(1001, "serverUrl  is null");
                return;
            }
            return;
        }
        final String bidToken = GDTAdManagerHolder.getBidToken();
        final String bidSdkInfo = GDTAdManagerHolder.getBidSdkInfo(str3);
        if (!TextUtils.isEmpty(bidToken) && !TextUtils.isEmpty(bidSdkInfo)) {
            ThreadUtils.runOnThreadPool(new Runnable() { // from class: xyz.adscope.amps.adapter.gdt.util.GDTBiddingRequestUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    BiddingRequestCallback biddingRequestCallback2;
                    String str4;
                    BidModel bidModel;
                    try {
                        HttpURLConnection createConnection = GDTBiddingRequestUtil.createConnection(str, "POST");
                        createConnection.setRequestProperty("User-Agent", GDTInitMediation.getInstance().getUserAgent(context));
                        String buildPostData = GDTBiddingRequestUtil.buildPostData(context, str2, str3, i6, bidToken, bidSdkInfo);
                        if (!TextUtils.isEmpty(buildPostData)) {
                            OutputStream outputStream = createConnection.getOutputStream();
                            outputStream.write(buildPostData.getBytes());
                            outputStream.flush();
                        }
                        int responseCode = createConnection.getResponseCode();
                        if (responseCode == 200) {
                            String stringContent = GDTBiddingRequestUtil.getStringContent(createConnection);
                            if (TextUtils.isEmpty(stringContent)) {
                                GDTBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, 1003, "bid response is null");
                                return;
                            }
                            final BidResponseModel bidResponseModel = (BidResponseModel) new JSONParse().fromJson(stringContent, BidResponseModel.class);
                            if (bidResponseModel == null) {
                                GDTBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, 1004, "bid response is null");
                                return;
                            }
                            responseCode = bidResponseModel.getNbr();
                            if (!TextUtils.isEmpty(bidResponseModel.getToken())) {
                                if (bidResponseModel.getSeatbid() != null && !bidResponseModel.getSeatbid().isEmpty()) {
                                    final String token = bidResponseModel.getToken();
                                    SeatBidModel seatBidModel = bidResponseModel.getSeatbid().get(0);
                                    if (seatBidModel != null) {
                                        List<BidModel> bid = seatBidModel.getBid();
                                        if (bid != null && !bid.isEmpty() && (bidModel = bid.get(0)) != null) {
                                            final int price = (int) bidModel.getPrice();
                                            ThreadUtils.runOnUIThread(new Runnable() { // from class: xyz.adscope.amps.adapter.gdt.util.GDTBiddingRequestUtil.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    BiddingRequestCallback biddingRequestCallback3 = biddingRequestCallback;
                                                    if (biddingRequestCallback3 != null) {
                                                        biddingRequestCallback3.success(token, price, bidResponseModel);
                                                    }
                                                }
                                            });
                                            return;
                                        }
                                        GDTBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, responseCode, "bid response bid is null");
                                        return;
                                    }
                                }
                                GDTBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, responseCode, "bid response seatbid is null");
                                return;
                            }
                            biddingRequestCallback2 = biddingRequestCallback;
                            str4 = "bid response token is null";
                        } else {
                            biddingRequestCallback2 = biddingRequestCallback;
                            str4 = "";
                        }
                        GDTBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback2, responseCode, str4);
                    } catch (Exception e6) {
                        GDTBiddingRequestUtil.callBackBiddingFail(biddingRequestCallback, 1005, "bid exception is " + e6.getMessage());
                    }
                }
            });
        } else if (biddingRequestCallback != null) {
            biddingRequestCallback.fail(1002, "bid token is null");
        }
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
