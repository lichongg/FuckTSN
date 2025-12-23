package xyz.adscope.amps.tool.crash;

import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.crash.inter.ICrashRouter;
import xyz.adscope.amps.tool.persistent.sp.AMPSSpUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSCrashRouter implements ICrashRouter {
    @Override // xyz.adscope.amps.tool.crash.inter.ICrashRouter
    public boolean lastLaunchCrashedBecauseOfSDK() {
        return ((Boolean) AMPSSpUtil.get(AMPSConstants.AMPS_CRASH_REASON_KEY, Boolean.FALSE)).booleanValue();
    }
}
