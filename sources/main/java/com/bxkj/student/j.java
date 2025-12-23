package com.bxkj.student;

import cn.bluemobi.dylan.http.HttpJsonKey;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class j implements HttpJsonKey {
    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    public int getSuccessCode() {
        return 0;
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    @NotNull
    public String getCode() {
        return "code";
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    @NotNull
    public String getData() {
        return "data";
    }

    @Override // cn.bluemobi.dylan.http.HttpJsonKey
    @NotNull
    public String getMsg() {
        return CrashHianalyticsData.MESSAGE;
    }
}
