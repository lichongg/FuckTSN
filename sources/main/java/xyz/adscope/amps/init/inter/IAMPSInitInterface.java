package xyz.adscope.amps.init.inter;

import android.content.Context;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.model.AMPSGlobalModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IAMPSInitInterface {
    AMPSGlobalModel getGlobalModel();

    void init(Context context, AMPSInitConfig aMPSInitConfig, AMPSGlobalModel aMPSGlobalModel, IAMPSInitCallback iAMPSInitCallback);

    boolean isInitSuccess();
}
