package xyz.adscope.common.v2.beta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IBetaTest {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CheckFrequency {
        public static final int CHECK_FREQUENCY_INIT = 8;
        public static final int CHECK_FREQUENCY_REALTIME = 9;
    }

    void initBetaConfig(IBetaTestConfig iBetaTestConfig);

    boolean invokeBetaTest(String str, String str2, int i6);
}
