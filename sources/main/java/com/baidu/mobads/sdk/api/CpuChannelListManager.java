package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.o;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CpuChannelListManager {
    private static final String TAG = "CpuChannelListManager";
    private o mCPUChannelListProd;
    private CpuChannelListListener mChannelIdListListener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CpuChannelListListener {
        void onChannelListError(String str, int i6);

        void onChannelListLoaded(List<CpuChannelResponse> list);
    }

    public CpuChannelListManager(Context context, CpuChannelListListener cpuChannelListListener) {
        o oVar = new o(context);
        this.mCPUChannelListProd = oVar;
        this.mChannelIdListListener = cpuChannelListListener;
        oVar.a(cpuChannelListListener);
    }

    public void loadChannelList(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            bu.a().c(TAG, "SubChannelId is null!");
            CpuChannelListListener cpuChannelListListener = this.mChannelIdListListener;
            if (cpuChannelListListener != null) {
                cpuChannelListListener.onChannelListError("SubChannelId is null.", bq.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bu.a().c(TAG, "appsid is null!");
            CpuChannelListListener cpuChannelListListener2 = this.mChannelIdListListener;
            if (cpuChannelListListener2 != null) {
                cpuChannelListListener2.onChannelListError("appsid is null.", bq.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        try {
            int parseInt = Integer.parseInt(str2);
            o oVar = this.mCPUChannelListProd;
            if (oVar != null) {
                oVar.a(str, parseInt);
                this.mCPUChannelListProd.a();
            }
        } catch (Exception unused) {
            bu.a().c(TAG, "SubChannelId is not Integer!");
            if (this.mChannelIdListListener != null) {
                this.mChannelIdListListener.onChannelListError("SubChannelId is not Integer!", bq.INTERFACE_USE_PROBLEM.b());
            }
        }
    }
}
