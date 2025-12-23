package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fw implements com.kwad.sdk.core.d<InstallActivateReminderConfigItem.InstallActivateReminderConfig> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        a2(installActivateReminderConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        return b2(installActivateReminderConfig, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        installActivateReminderConfig.noticeTotalCount = jSONObject.optInt("noticeTotalCount", new Integer("3").intValue());
        installActivateReminderConfig.perAppNoticeCount = jSONObject.optInt("perAppNoticeCount", new Integer("2").intValue());
        installActivateReminderConfig.noticeAppearTime = jSONObject.optInt("noticeAppearTime", new Integer("15000").intValue());
        installActivateReminderConfig.noticeContinueTime = jSONObject.optInt("noticeContinueTime", new Integer("15000").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "noticeTotalCount", installActivateReminderConfig.noticeTotalCount);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "perAppNoticeCount", installActivateReminderConfig.perAppNoticeCount);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "noticeAppearTime", installActivateReminderConfig.noticeAppearTime);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "noticeContinueTime", installActivateReminderConfig.noticeContinueTime);
        return jSONObject;
    }
}
