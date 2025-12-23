package xyz.adscope.amps.ad.unified.view;

import android.view.ViewGroup;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSRootInsertHelper {
    public static void insertRootView(AMPSUnifiedRootContainer aMPSUnifiedRootContainer, ViewGroup viewGroup) {
        if (aMPSUnifiedRootContainer == null || viewGroup == null) {
            return;
        }
        aMPSUnifiedRootContainer.insertChannelSpecifiedContainer(viewGroup);
    }

    private AMPSRootInsertHelper() {
        throw new IllegalStateException("Utility class");
    }
}
