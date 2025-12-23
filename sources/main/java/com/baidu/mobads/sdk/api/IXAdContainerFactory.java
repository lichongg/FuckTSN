package com.baidu.mobads.sdk.api;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IXAdContainerFactory {
    Object getRemoteParam(String str, Object... objArr);

    double getRemoteVersion();

    void initCommonModuleObj(Object obj);

    void initConfig(JSONObject jSONObject);

    void onTaskDistribute(String str, JSONObject jSONObject);
}
