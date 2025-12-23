package xyz.adscope.common.v2.beta;

import java.util.HashMap;
import java.util.Map;
import xyz.adscope.common.v2.tool.roll.RandomProbability;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class BetaTestImpl implements IBetaTest {
    private final Map<String, BetaTestRandomProbability> probabilityMap = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.beta.BetaTestImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class BetaTestRandomProbability {
        private Boolean hasCheckInvoke;
        private final IBetaTestConfig mConfig;

        /* synthetic */ BetaTestRandomProbability(IBetaTestConfig iBetaTestConfig, AnonymousClass1 anonymousClass1) {
            this(iBetaTestConfig);
        }

        private BetaTestRandomProbability(IBetaTestConfig iBetaTestConfig) {
            this.hasCheckInvoke = null;
            this.mConfig = iBetaTestConfig;
        }

        private boolean checkInvokeRealTime() {
            IBetaTestConfig iBetaTestConfig = this.mConfig;
            if (iBetaTestConfig != null && RandomProbability.roll(iBetaTestConfig.getRandomProbability())) {
                long currentTimeMillis = System.currentTimeMillis();
                long startTimestamp = this.mConfig.getStartTimestamp();
                long endTimestamp = this.mConfig.getEndTimestamp();
                long durationMillisecond = this.mConfig.getDurationMillisecond();
                if (startTimestamp > 0 && endTimestamp > 0 && currentTimeMillis >= startTimestamp && currentTimeMillis <= endTimestamp) {
                    return true;
                }
                if (currentTimeMillis >= startTimestamp && currentTimeMillis <= startTimestamp + durationMillisecond) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean invokeBetaTest(int i6) {
            if (i6 == 9) {
                return checkInvokeRealTime();
            }
            if (i6 != 8) {
                return false;
            }
            if (this.hasCheckInvoke == null) {
                this.hasCheckInvoke = Boolean.valueOf(checkInvokeRealTime());
            }
            return this.hasCheckInvoke.booleanValue();
        }
    }

    @Override // xyz.adscope.common.v2.beta.IBetaTest
    public void initBetaConfig(IBetaTestConfig iBetaTestConfig) {
        if (iBetaTestConfig != null) {
            this.probabilityMap.put(iBetaTestConfig.getBetaTestPlanID() + "_" + iBetaTestConfig.getSDKBizID(), new BetaTestRandomProbability(iBetaTestConfig, null));
        }
    }

    @Override // xyz.adscope.common.v2.beta.IBetaTest
    public boolean invokeBetaTest(String str, String str2, int i6) {
        BetaTestRandomProbability betaTestRandomProbability;
        String str3 = str + "_" + str2;
        if (!this.probabilityMap.containsKey(str3) || (betaTestRandomProbability = this.probabilityMap.get(str3)) == null) {
            return false;
        }
        return betaTestRandomProbability.invokeBetaTest(i6);
    }

    BetaTestImpl() {
    }
}
