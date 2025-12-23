package com.kwad.sdk.core.response.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static boolean ea(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && e.ed(adTemplate)) {
            return eb(adTemplate).slideClick;
        }
        return false;
    }

    public static long dX(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return eb(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String dY(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : eb(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String dZ(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : eb(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    @NonNull
    private static AdStyleInfo eb(@NonNull AdTemplate adTemplate) {
        return e.el(adTemplate).adStyleInfo;
    }

    public static List<String> ec(@NonNull AdTemplate adTemplate) {
        AdStyleInfo eb = eb(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<AdStyleInfo.ExposeTagInfo> it = eb.extraDisplayInfo.exposeTagInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
