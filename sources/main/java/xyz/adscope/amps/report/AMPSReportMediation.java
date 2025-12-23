package xyz.adscope.amps.report;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import com.umeng.socialize.common.SocializeConstants;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.BuildConfig;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.config.inter.IConfigUpdateCallBack;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.model.config.response.AMPSConfigResponseModel;
import xyz.adscope.amps.model.config.response.LogStrategyModel;
import xyz.adscope.amps.model.crash.AMPSCrashRequestModel;
import xyz.adscope.amps.plan.BetaPlanMediation;
import xyz.adscope.amps.report.model.request.AMPSReportRequestModel;
import xyz.adscope.amps.report.model.request.AdModel;
import xyz.adscope.amps.report.model.request.EventModel;
import xyz.adscope.amps.tool.crash.AMPSCrashHandler;
import xyz.adscope.common.analyse2.publish.IScopeAnalyserUpdater;
import xyz.adscope.common.analyse2.publish.IScopeEventAnalyser;
import xyz.adscope.common.analyse2.publish.ScopeEventAnalyserManager;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.json.util.JsonUtil;
import xyz.adscope.common.tool.security.Base64Util;
import xyz.adscope.common.v2.encrypt.EncryptConfig;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSReportMediation {
    private static AMPSReportMediation instance;
    private String AMPS_TAG = "mediation";
    private boolean isExecuteBetaPlan;
    private boolean isJudgeBetaPlan;
    private Context mContext;
    private IScopeEventAnalyser scopeEventAnalyser;

    public void reportEvent(AMPSReportRequestModel aMPSReportRequestModel, String str) {
        AMPSConfigResponseModel configureResponseModel;
        LogStrategyModel logStrategy;
        if (isExecuteBetaPlan() && aMPSReportRequestModel != null) {
            try {
                EventModel eventModel = aMPSReportRequestModel.getEventModel();
                if (eventModel == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                String eventId = eventModel.getEventId();
                if (!TextUtils.isEmpty(eventId)) {
                    jSONObject.put("event_id", eventId);
                }
                jSONObject.put("event_code", str);
                String logTime = eventModel.getLogTime();
                if (!TextUtils.isEmpty(logTime)) {
                    jSONObject.put("event_time", logTime);
                }
                String errorCode = eventModel.getErrorCode();
                if (!TextUtils.isEmpty(errorCode)) {
                    jSONObject.put("error_code", errorCode);
                }
                String errorInfo = eventModel.getErrorInfo();
                if (!TextUtils.isEmpty(errorInfo)) {
                    jSONObject.put("error_info", errorInfo);
                }
                String roundTripTime = eventModel.getRoundTripTime();
                if (!TextUtils.isEmpty(roundTripTime)) {
                    jSONObject.put("cost_time", roundTripTime);
                }
                String adSourceAppId = eventModel.getAdSourceAppId();
                if (!TextUtils.isEmpty(adSourceAppId)) {
                    jSONObject.put("s_app_id", adSourceAppId);
                }
                String adSourceSpaceId = eventModel.getAdSourceSpaceId();
                if (!TextUtils.isEmpty(adSourceSpaceId)) {
                    jSONObject.put("s_space_id", adSourceSpaceId);
                }
                String adSourceId = eventModel.getAdSourceId();
                if (!TextUtils.isEmpty(adSourceSpaceId)) {
                    jSONObject.put("seat_id", adSourceId);
                }
                if (!TextUtils.isEmpty(eventModel.getEcpm())) {
                    jSONObject.put("ecpm", eventModel.getEcpm());
                }
                String biddingType = eventModel.getBiddingType();
                if (!TextUtils.isEmpty(biddingType)) {
                    jSONObject.put("bid_type", biddingType);
                }
                String isHitAuction = eventModel.getIsHitAuction();
                if (!TextUtils.isEmpty(isHitAuction)) {
                    jSONObject.put("is_hit_auction", isHitAuction);
                }
                String isLastLook = eventModel.getIsLastLook();
                if (!TextUtils.isEmpty(isHitAuction)) {
                    jSONObject.put("is_last_look", isLastLook);
                }
                String adsCustomData = eventModel.getAdsCustomData();
                if (!TextUtils.isEmpty(adsCustomData)) {
                    jSONObject.put("s_custom_data", adsCustomData);
                }
                String noticePrice = eventModel.getNoticePrice();
                if (!TextUtils.isEmpty(noticePrice)) {
                    jSONObject.put("notice_price", noticePrice);
                }
                String lossReason = eventModel.getLossReason();
                if (!TextUtils.isEmpty(lossReason)) {
                    jSONObject.put("loss_reason", lossReason);
                }
                String realPrice = eventModel.getRealPrice();
                if (!TextUtils.isEmpty(realPrice)) {
                    jSONObject.put("real_price", realPrice);
                }
                String bidSeatId = eventModel.getBidSeatId();
                if (!TextUtils.isEmpty(bidSeatId)) {
                    jSONObject.put("bid_seat_id", bidSeatId);
                }
                String bidSpaceId = eventModel.getBidSpaceId();
                if (!TextUtils.isEmpty(bidSpaceId)) {
                    jSONObject.put("bid_space_id", bidSpaceId);
                }
                JSONObject jSONObject2 = new JSONObject();
                String mediationSpaceId = eventModel.getMediationSpaceId();
                if (!TextUtils.isEmpty(mediationSpaceId)) {
                    jSONObject2.put("space_id", mediationSpaceId);
                }
                String sessionId = eventModel.getSessionId();
                if (!TextUtils.isEmpty(sessionId)) {
                    jSONObject2.put("session_id", sessionId);
                }
                String mdCustomData = eventModel.getMdCustomData();
                if (!TextUtils.isEmpty(mdCustomData)) {
                    jSONObject2.put("custom_data", mdCustomData);
                }
                jSONObject2.put("currency", "CNY");
                AdModel ad = aMPSReportRequestModel.getAd();
                if (ad != null) {
                    String adType = ad.getAdType();
                    if (!TextUtils.isEmpty(adType)) {
                        jSONObject2.put("ad_type", adType);
                    }
                    String quantity = ad.getQuantity();
                    if (!TextUtils.isEmpty(quantity)) {
                        jSONObject2.put("quantity", quantity);
                    }
                    String adTimeOut = ad.getAdTimeOut();
                    if (!TextUtils.isEmpty(adTimeOut)) {
                        jSONObject2.put("time_out", adTimeOut);
                    }
                    String loadType = ad.getLoadType();
                    if (!TextUtils.isEmpty(loadType)) {
                        jSONObject.put("load_type", loadType);
                    }
                    String maxWaitTime = ad.getMaxWaitTime();
                    if (!TextUtils.isEmpty(maxWaitTime)) {
                        jSONObject.put("s_time_out", maxWaitTime);
                    }
                    String floorPrice = ad.getFloorPrice();
                    if (!TextUtils.isEmpty(floorPrice)) {
                        jSONObject.put("floor_price", floorPrice);
                    }
                }
                jSONObject.putOpt(AMPSConstants.RESOURCE_HEAD, jSONObject2);
                AMPSGlobalModel globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
                if (globalModel != null && (configureResponseModel = globalModel.getConfigureResponseModel()) != null && (logStrategy = configureResponseModel.getLogStrategy()) != null) {
                    String version = logStrategy.getVersion();
                    if (this.scopeEventAnalyser == null) {
                        return;
                    }
                    this.scopeEventAnalyser.reportEvent(Base64Util.encode(jSONObject.toString()), version, this.AMPS_TAG);
                }
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
    }

    public static synchronized AMPSReportMediation getInstance() {
        AMPSReportMediation aMPSReportMediation;
        synchronized (AMPSReportMediation.class) {
            try {
                if (instance == null) {
                    synchronized (AMPSReportMediation.class) {
                        instance = new AMPSReportMediation();
                    }
                }
                aMPSReportMediation = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aMPSReportMediation;
    }

    private boolean isExecuteBetaPlan() {
        if (this.isJudgeBetaPlan) {
            return this.isExecuteBetaPlan;
        }
        boolean isExecuteBetaPlan = BetaPlanMediation.getInstance().isExecuteBetaPlan();
        this.isExecuteBetaPlan = isExecuteBetaPlan;
        this.isJudgeBetaPlan = true;
        return isExecuteBetaPlan;
    }

    private void reportHistoryEvent() {
        IScopeEventAnalyser iScopeEventAnalyser = this.scopeEventAnalyser;
        if (iScopeEventAnalyser == null) {
            return;
        }
        iScopeEventAnalyser.scheduleHistoryEvent(30L, 300L, TimeUnit.SECONDS, this.AMPS_TAG);
    }

    public void initLogStrategy() {
        String str;
        String str2;
        IScopeEventAnalyser orCreateImplement;
        DeviceInfo deviceInfo;
        if (this.mContext == null) {
            return;
        }
        try {
            if (isExecuteBetaPlan()) {
                AMPSGlobalModel globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
                String startId = globalModel.getStartId();
                String appId = globalModel.getAppId();
                AMPSConfigResponseModel configureResponseModel = globalModel.getConfigureResponseModel();
                String str3 = null;
                if (configureResponseModel != null) {
                    str2 = String.valueOf(configureResponseModel.getLastUpdateTime());
                    str = configureResponseModel.getVersion();
                } else {
                    str = null;
                    str2 = "0";
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_id", startId);
                jSONObject.put("app_id", appId);
                jSONObject.put("custom_id", "mediation");
                jSONObject.put("lastUpdateTime", str2);
                jSONObject.put("config_version_md5", str);
                AMPSInitConfig aMPSAdConfig = AMPSSDKManager.getInstance().getAMPSAdConfig();
                JSONObject jSONObject2 = new JSONObject();
                if (aMPSAdConfig != null) {
                    String userId = aMPSAdConfig.getUserId();
                    if (!TextUtils.isEmpty(userId)) {
                        jSONObject2.put(SocializeConstants.TENCENT_UID, userId);
                    }
                    String optionInfo = aMPSAdConfig.getOptionInfo();
                    if (!TextUtils.isEmpty(optionInfo)) {
                        jSONObject2.put("user_custom_data", optionInfo);
                    }
                    if (aMPSAdConfig.isPersonalRecommend()) {
                        jSONObject2.put("lmt", "1");
                    } else {
                        jSONObject2.put("lmt", "0");
                        jSONObject2.put("oaid_auth", "mediation");
                    }
                    String customOAID = aMPSAdConfig.getCustomOAID();
                    Context context = this.mContext;
                    if (context != null && (deviceInfo = DeviceInfo.getInstance(context)) != null) {
                        str3 = deviceInfo.getOaid();
                        jSONObject2.put("said", deviceInfo.getSdkid());
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        customOAID = str3;
                    }
                    jSONObject2.put("oaid", customOAID);
                }
                jSONObject.putOpt(au.f40908m, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("version", BuildConfig.VERSION_NAME);
                jSONObject.putOpt("sdk", jSONObject3);
                AMPSConfigResponseModel configureResponseModel2 = globalModel.getConfigureResponseModel();
                if (configureResponseModel2 != null) {
                    jSONObject.putOpt("logStrategy", JsonUtil.objectToJsonObject(configureResponseModel2.getLogStrategy()));
                }
                String encode = Base64Util.encode(jSONObject.toString());
                if (this.mContext == null || (orCreateImplement = ScopeEventAnalyserManager.getInstance().getOrCreateImplement(this.mContext)) == null) {
                    return;
                }
                orCreateImplement.initializeAnalyse(encode);
                reportHistoryEvent();
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    public void registerAnalyseUpdate(final IConfigUpdateCallBack iConfigUpdateCallBack) {
        try {
            IScopeEventAnalyser iScopeEventAnalyser = this.scopeEventAnalyser;
            if (iScopeEventAnalyser == null) {
                return;
            }
            iScopeEventAnalyser.registerAnalyseUpdate(new IScopeAnalyserUpdater() { // from class: xyz.adscope.amps.report.AMPSReportMediation.1
                @Override // xyz.adscope.common.analyse2.publish.IScopeAnalyserUpdater
                public void requireUpdate() {
                    try {
                        IConfigUpdateCallBack iConfigUpdateCallBack2 = iConfigUpdateCallBack;
                        if (iConfigUpdateCallBack2 != null) {
                            iConfigUpdateCallBack2.onUpdate();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private AMPSReportMediation() {
        if (AMPSSDKManager.getInstance().getContext() != null) {
            this.mContext = AMPSSDKManager.getInstance().getContext();
            this.scopeEventAnalyser = ScopeEventAnalyserManager.getInstance().getOrCreateImplement(AMPSSDKManager.getInstance().getContext());
            LinkedEncryptManager.getInstance().getOrCreateImplement(this.mContext).initAesConfig(EncryptConfig.CONFIG_AES);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00d0 A[Catch: JSONException -> 0x002d, TRY_LEAVE, TryCatch #0 {JSONException -> 0x002d, blocks: (B:4:0x0008, B:6:0x0014, B:8:0x0020, B:11:0x00c4, B:13:0x00d0, B:19:0x0032, B:21:0x0038, B:23:0x0047, B:24:0x004c, B:26:0x0056, B:27:0x005b, B:29:0x0061, B:30:0x0066, B:32:0x0070, B:33:0x0075, B:35:0x007f, B:36:0x0084, B:38:0x008a, B:39:0x008f, B:43:0x009e, B:47:0x00a5, B:51:0x00ac, B:55:0x00b5), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reportInitEvent(xyz.adscope.amps.report.model.request.AMPSReportRequestModel r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            boolean r0 = r3.isExecuteBetaPlan()
            if (r0 != 0) goto L8
            goto Ld3
        L8:
            xyz.adscope.amps.report.AMPSEventReportCode r0 = xyz.adscope.amps.report.AMPSEventReportCode.EVENT_INIT_START_CODE     // Catch: org.json.JSONException -> L2d
            java.lang.String r0 = r0.getCodeStr()     // Catch: org.json.JSONException -> L2d
            boolean r0 = r0.equals(r5)     // Catch: org.json.JSONException -> L2d
            if (r0 != 0) goto L30
            xyz.adscope.amps.report.AMPSEventReportCode r0 = xyz.adscope.amps.report.AMPSEventReportCode.EVENT_INIT_SUCCESS_CODE     // Catch: org.json.JSONException -> L2d
            java.lang.String r0 = r0.getCodeStr()     // Catch: org.json.JSONException -> L2d
            boolean r0 = r0.equals(r5)     // Catch: org.json.JSONException -> L2d
            if (r0 != 0) goto L30
            xyz.adscope.amps.report.AMPSEventReportCode r0 = xyz.adscope.amps.report.AMPSEventReportCode.EVENT_INIT_FAIL_CODE     // Catch: org.json.JSONException -> L2d
            java.lang.String r0 = r0.getCodeStr()     // Catch: org.json.JSONException -> L2d
            boolean r0 = r0.equals(r5)     // Catch: org.json.JSONException -> L2d
            if (r0 == 0) goto Lc4
            goto L30
        L2d:
            r4 = move-exception
            goto Ld4
        L30:
            if (r4 == 0) goto Lc4
            xyz.adscope.amps.report.model.request.EventModel r4 = r4.getEventModel()     // Catch: org.json.JSONException -> L2d
            if (r4 == 0) goto Lc4
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L2d
            r0.<init>()     // Catch: org.json.JSONException -> L2d
            java.lang.String r1 = r4.getEventId()     // Catch: org.json.JSONException -> L2d
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: org.json.JSONException -> L2d
            if (r2 != 0) goto L4c
            java.lang.String r2 = "event_id"
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L2d
        L4c:
            java.lang.String r1 = r4.getLogTime()     // Catch: org.json.JSONException -> L2d
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: org.json.JSONException -> L2d
            if (r2 != 0) goto L5b
            java.lang.String r2 = "event_time"
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L2d
        L5b:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: org.json.JSONException -> L2d
            if (r1 != 0) goto L66
            java.lang.String r1 = "event_code"
            r0.put(r1, r5)     // Catch: org.json.JSONException -> L2d
        L66:
            java.lang.String r1 = r4.getErrorCode()     // Catch: org.json.JSONException -> L2d
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: org.json.JSONException -> L2d
            if (r2 != 0) goto L75
            java.lang.String r2 = "error_code"
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L2d
        L75:
            java.lang.String r4 = r4.getErrorInfo()     // Catch: org.json.JSONException -> L2d
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: org.json.JSONException -> L2d
            if (r1 != 0) goto L84
            java.lang.String r1 = "error_info"
            r0.put(r1, r4)     // Catch: org.json.JSONException -> L2d
        L84:
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch: org.json.JSONException -> L2d
            if (r4 != 0) goto L8f
            java.lang.String r4 = "cost_time"
            r0.put(r4, r6)     // Catch: org.json.JSONException -> L2d
        L8f:
            xyz.adscope.amps.manager.AMPSSDKManager r4 = xyz.adscope.amps.manager.AMPSSDKManager.getInstance()     // Catch: org.json.JSONException -> L2d
            xyz.adscope.amps.init.inter.IAMPSInitInterface r4 = r4.getIAMPSInitInterface()     // Catch: org.json.JSONException -> L2d
            xyz.adscope.amps.model.AMPSGlobalModel r4 = r4.getGlobalModel()     // Catch: org.json.JSONException -> L2d
            if (r4 != 0) goto L9e
            goto Ld3
        L9e:
            xyz.adscope.amps.model.config.response.AMPSConfigResponseModel r4 = r4.getConfigureResponseModel()     // Catch: org.json.JSONException -> L2d
            if (r4 != 0) goto La5
            goto Ld3
        La5:
            xyz.adscope.amps.model.config.response.LogStrategyModel r4 = r4.getLogStrategy()     // Catch: org.json.JSONException -> L2d
            if (r4 != 0) goto Lac
            goto Ld3
        Lac:
            java.lang.String r4 = r4.getVersion()     // Catch: org.json.JSONException -> L2d
            xyz.adscope.common.analyse2.publish.IScopeEventAnalyser r6 = r3.scopeEventAnalyser     // Catch: org.json.JSONException -> L2d
            if (r6 != 0) goto Lb5
            goto Ld3
        Lb5:
            java.lang.String r6 = r0.toString()     // Catch: org.json.JSONException -> L2d
            java.lang.String r6 = xyz.adscope.common.tool.security.Base64Util.encode(r6)     // Catch: org.json.JSONException -> L2d
            xyz.adscope.common.analyse2.publish.IScopeEventAnalyser r0 = r3.scopeEventAnalyser     // Catch: org.json.JSONException -> L2d
            java.lang.String r1 = r3.AMPS_TAG     // Catch: org.json.JSONException -> L2d
            r0.reportEvent(r6, r4, r1)     // Catch: org.json.JSONException -> L2d
        Lc4:
            xyz.adscope.amps.report.AMPSEventReportCode r4 = xyz.adscope.amps.report.AMPSEventReportCode.EVENT_CRASH_CODE     // Catch: org.json.JSONException -> L2d
            java.lang.String r4 = r4.getCodeStr()     // Catch: org.json.JSONException -> L2d
            boolean r4 = r4.equals(r5)     // Catch: org.json.JSONException -> L2d
            if (r4 == 0) goto Ld3
            r3.uploadCrashLog()     // Catch: org.json.JSONException -> L2d
        Ld3:
            return
        Ld4:
            r4.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.report.AMPSReportMediation.reportInitEvent(xyz.adscope.amps.report.model.request.AMPSReportRequestModel, java.lang.String, java.lang.String):void");
    }

    public void uploadCrashLog() {
        AMPSGlobalModel globalModel;
        AMPSConfigResponseModel configureResponseModel;
        LogStrategyModel logStrategy;
        if (isExecuteBetaPlan()) {
            try {
                JSONArray jSONArray = new JSONArray();
                List<AMPSCrashRequestModel> crashData = AMPSCrashHandler.getInstance().getCrashData();
                if (crashData != null && crashData.size() > 0) {
                    for (AMPSCrashRequestModel aMPSCrashRequestModel : crashData) {
                        String exception = aMPSCrashRequestModel.getException();
                        if (!TextUtils.isEmpty(exception)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("exception", exception);
                            if (!TextUtils.isEmpty(aMPSCrashRequestModel.getAffiliated())) {
                                jSONObject.put("affiliated", aMPSCrashRequestModel.getAffiliated());
                            }
                            if (!TextUtils.isEmpty(aMPSCrashRequestModel.getLog_time())) {
                                jSONObject.put("time", aMPSCrashRequestModel.getLog_time());
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                    if (jSONArray.length() > 0 && (globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel()) != null && (configureResponseModel = globalModel.getConfigureResponseModel()) != null && (logStrategy = configureResponseModel.getLogStrategy()) != null) {
                        String version = logStrategy.getVersion();
                        if (this.scopeEventAnalyser != null) {
                            this.scopeEventAnalyser.reportCrash(Base64Util.encode(jSONArray.toString()), version, this.AMPS_TAG);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
