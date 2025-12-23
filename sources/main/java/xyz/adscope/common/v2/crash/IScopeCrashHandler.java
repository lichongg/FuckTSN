package xyz.adscope.common.v2.crash;

import android.content.Context;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IScopeCrashHandler {
    List<ScopeCrashLog> getUnReportCrash(Context context, String str);

    boolean hasASNPCausedCrash(Context context, String str);

    void registerCrashHandler(boolean z5);
}
