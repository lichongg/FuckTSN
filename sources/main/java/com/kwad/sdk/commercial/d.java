package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.bp;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static BusinessType ct(int i6) {
        return i6 == 3 ? BusinessType.AD_FULLSCREEN : i6 == 2 ? BusinessType.AD_REWARD : i6 == 4 ? BusinessType.AD_SPLASH : (i6 == 13 || i6 == 23) ? BusinessType.AD_INTERSTITIAL : i6 == 1 ? BusinessType.AD_FEED : i6 == 10000 ? BusinessType.AD_NATIVE : BusinessType.OTHER;
    }

    public static int cu(int i6) {
        if (i6 == -1) {
            return 100010;
        }
        if (i6 == -2) {
            return 100011;
        }
        return i6;
    }

    private static String a(@NonNull AdMatrixInfo.MatrixTemplate matrixTemplate) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(matrixTemplate.templateId);
        stringBuffer.append("#");
        stringBuffer.append(matrixTemplate.templateVersionCode);
        return stringBuffer.toString();
    }

    public static BusinessType be(AdTemplate adTemplate) {
        return adTemplate == null ? BusinessType.OTHER : ct(e.ef(adTemplate));
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate bf(AdTemplate adTemplate) {
        String str;
        AdMatrixInfo.MatrixTemplate matrixTemplate = null;
        if (adTemplate.mAdScene == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.b.b.cp(adTemplate).adDataV2;
        int ef = e.ef(adTemplate);
        if (ef == 2) {
            str = adDataV2.neoTKInfo.templateId;
        } else if (ef == 3) {
            str = adDataV2.fullScreenInfo.templateId;
        } else if (ef == 4) {
            str = adDataV2.splashPlayCardTKInfo.templateId;
        } else if (ef == 6) {
            str = adDataV2.drawTKCardInfo.templateId;
        } else if (ef != 13) {
            if (ef == 23) {
                int eD = e.eD(adTemplate);
                if (eD == 1) {
                    str = adDataV2.fullScreenInfo.templateId;
                } else if (eD == 2) {
                    str = adDataV2.interstitialCardInfo.templateId;
                }
            }
            str = "";
        } else {
            str = adDataV2.interstitialCardInfo.templateId;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<AdMatrixInfo.MatrixTemplate> it = com.kwad.sdk.core.response.b.b.cq(adTemplate).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdMatrixInfo.MatrixTemplate next = it.next();
            if (bp.isEquals(str, next.templateId)) {
                matrixTemplate = next;
                break;
            }
        }
        if (matrixTemplate == null) {
            matrixTemplate = com.kwad.sdk.core.response.b.b.k(adTemplate, str);
        }
        if (matrixTemplate != null) {
            matrixTemplate.publishType = ((h) ServiceProvider.get(h.class)).ci(a(matrixTemplate));
        }
        return matrixTemplate;
    }
}
