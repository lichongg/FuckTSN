package xyz.adscope.amps.plan;

import android.text.TextUtils;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.model.config.response.AMPSConfigResponseModel;
import xyz.adscope.amps.model.config.response.TestPlanModel;
import xyz.adscope.amps.tool.util.AMPSRandomUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BetaPlanMediation {
    private static BetaPlanMediation instance;
    private boolean isExecuteBetaPlan;
    private boolean isExecuteHapAppBetaPlan;
    private boolean isHaveJudgeBetaPlan;
    private boolean isHaveJudgeHapAppBetaPlan;
    private String logPlanId = "aa2623c4a099eaa875162146c8a9e483";
    private String hapAppPlanId = "c0447125b1a93ba9aa0b3399bcc902ce";

    public static synchronized BetaPlanMediation getInstance() {
        BetaPlanMediation betaPlanMediation;
        synchronized (BetaPlanMediation.class) {
            try {
                if (instance == null) {
                    synchronized (BetaPlanMediation.class) {
                        instance = new BetaPlanMediation();
                    }
                }
                betaPlanMediation = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return betaPlanMediation;
    }

    public boolean isExecuteBetaPlan() {
        AMPSConfigResponseModel configureResponseModel;
        TestPlanModel testPlan;
        if (this.isHaveJudgeBetaPlan) {
            return this.isExecuteBetaPlan;
        }
        this.isHaveJudgeBetaPlan = true;
        AMPSGlobalModel globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
        if (globalModel == null || (configureResponseModel = globalModel.getConfigureResponseModel()) == null || (testPlan = configureResponseModel.getTestPlan()) == null || !this.logPlanId.equals(testPlan.getPlanId())) {
            return false;
        }
        try {
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (!AMPSRandomUtil.isHitRandomNum(Integer.parseInt(testPlan.getRandom()))) {
            return false;
        }
        String startTime = testPlan.getStartTime();
        String endTime = testPlan.getEndTime();
        String duration = testPlan.getDuration();
        long currentTimeMillis = System.currentTimeMillis();
        long parseLong = (TextUtils.isEmpty(startTime) || "0".equals(startTime)) ? 0L : Long.parseLong(startTime);
        long parseLong2 = (TextUtils.isEmpty(endTime) || "0".equals(endTime)) ? 0L : Long.parseLong(endTime);
        int parseInt = (TextUtils.isEmpty(duration) || "0".equals(duration)) ? 0 : Integer.parseInt(duration);
        if (parseLong > 0 && parseLong2 > 0 && currentTimeMillis >= parseLong && currentTimeMillis <= parseLong2) {
            this.isExecuteBetaPlan = true;
            return true;
        }
        if (currentTimeMillis >= parseLong && currentTimeMillis <= parseLong + parseInt) {
            this.isExecuteBetaPlan = true;
            return true;
        }
        return false;
    }

    public boolean isExecuteHapBetaPlan() {
        AMPSConfigResponseModel configureResponseModel;
        TestPlanModel testPlan;
        if (this.isHaveJudgeHapAppBetaPlan) {
            return this.isExecuteHapAppBetaPlan;
        }
        this.isHaveJudgeHapAppBetaPlan = true;
        AMPSGlobalModel globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
        if (globalModel == null || (configureResponseModel = globalModel.getConfigureResponseModel()) == null || (testPlan = configureResponseModel.getTestPlan()) == null || !this.hapAppPlanId.equals(testPlan.getPlanId())) {
            return false;
        }
        try {
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (!AMPSRandomUtil.isHitRandomNum(Integer.parseInt(testPlan.getRandom()))) {
            return false;
        }
        String startTime = testPlan.getStartTime();
        String endTime = testPlan.getEndTime();
        String duration = testPlan.getDuration();
        long currentTimeMillis = System.currentTimeMillis();
        long parseLong = (TextUtils.isEmpty(startTime) || "0".equals(startTime)) ? 0L : Long.parseLong(startTime);
        long parseLong2 = (TextUtils.isEmpty(endTime) || "0".equals(endTime)) ? 0L : Long.parseLong(endTime);
        int parseInt = (TextUtils.isEmpty(duration) || "0".equals(duration)) ? 0 : Integer.parseInt(duration);
        if (parseLong > 0 && parseLong2 > 0 && currentTimeMillis >= parseLong && currentTimeMillis <= parseLong2) {
            this.isExecuteHapAppBetaPlan = true;
            return true;
        }
        if (currentTimeMillis >= parseLong && currentTimeMillis <= parseLong + parseInt) {
            this.isExecuteHapAppBetaPlan = true;
            return true;
        }
        return false;
    }
}
