package xyz.adscope.amps.config.inter;

import android.content.Context;
import xyz.adscope.amps.model.AMPSGlobalModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IConfigInterface {
    boolean checkConfig();

    void initConfigureFile(AMPSGlobalModel aMPSGlobalModel, IConfigInfoCallback iConfigInfoCallback);

    void requestConfigureFile(AMPSGlobalModel aMPSGlobalModel, IConfigInfoCallback iConfigInfoCallback);

    void schedulerUpdateConfigureFile();

    void setContext(Context context);

    void updateConfigureFile(AMPSGlobalModel aMPSGlobalModel, String str);
}
