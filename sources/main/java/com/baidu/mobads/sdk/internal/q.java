package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOAdEvent f11078a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f11079b;

    q(p pVar, IOAdEvent iOAdEvent) {
        this.f11079b = pVar;
        this.f11078a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        IOAdEvent iOAdEvent = this.f11078a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f11078a.getType();
        if (z.ap.equals(type)) {
            List<CpuChannelResponse> a6 = n.a((JSONArray) this.f11078a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.f11079b.f11077a.f11074t;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.f11079b.f11077a.f11074t;
                cpuChannelListListener4.onChannelListLoaded(a6);
                return;
            }
            return;
        }
        if (z.aq.equals(type)) {
            Map<String, Object> data = this.f11078a.getData();
            int i6 = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                Object obj = data.get("error_code");
                if (obj == null) {
                    obj = 0;
                }
                i6 = ((Integer) obj).intValue();
            } else {
                str = "";
            }
            cpuChannelListListener = this.f11079b.f11077a.f11074t;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.f11079b.f11077a.f11074t;
                cpuChannelListListener2.onChannelListError(str, i6);
            }
        }
    }
}
