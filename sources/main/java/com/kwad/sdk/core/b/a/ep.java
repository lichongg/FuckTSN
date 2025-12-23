package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ep {
    @InvokeBy(invokerClass = go.class, methodId = "registerHolder")
    public static void Hk() {
        go.Hl().put(h.a.class, new fs());
        go.Hl().put(SdkConfigData.CouponActiveConfig.class, new dc());
        go.Hl().put(com.kwad.sdk.core.response.model.a.class, new iu());
        go.Hl().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new fw());
        go.Hl().put(SdkConfigData.TemplateConfigMap.class, new lf());
        go.Hl().put(ActivityInfo.class, new f());
        go.Hl().put(j.a.class, new fv());
    }
}
