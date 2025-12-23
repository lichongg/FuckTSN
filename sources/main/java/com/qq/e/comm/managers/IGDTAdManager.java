package com.qq.e.comm.managers;

import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.devtool.DevTools;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IGDTAdManager {
    String getBuyerId(Map<String, Object> map);

    DevTools getDevTools();

    String getSDKInfo(String str);

    int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);
}
