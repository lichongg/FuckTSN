package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class m6 {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public static b4 a(Context context, String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        switch (lowerCase.hashCode()) {
            case -934795532:
                if (lowerCase.equals(AgConnectInfo.AgConnectKey.REGION)) {
                    return new e6(context);
                }
                break;
            case -905948230:
                if (lowerCase.equals(bi.ac)) {
                    return new w5(context);
                }
                break;
            case -793319857:
                if (lowerCase.equals("appinfo")) {
                    return new u5(context);
                }
                break;
            case 114586:
                if (lowerCase.equals(CommonNetImpl.TAG)) {
                    return new z5(context);
                }
                break;
            case 117588:
                if (lowerCase.equals("web")) {
                    return !TextUtils.isEmpty(str2) ? new b6(context) : new o6(context);
                }
                break;
            case 3327403:
                if (lowerCase.equals("logo")) {
                    return new c6(context);
                }
                break;
            case 3556653:
                if (lowerCase.equals(com.baidu.mobads.sdk.internal.a.f10501b)) {
                    return !TextUtils.isEmpty(str2) ? new xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c(context) : new i6(context);
                }
                break;
            case 3619493:
                lowerCase.equals("view");
                break;
            case 100313435:
                if (lowerCase.equals(SocializeProtocolConstants.IMAGE)) {
                    return !TextUtils.isEmpty(str2) ? new y5(context) : new x5(context);
                }
                break;
            case 109399814:
                if (lowerCase.equals("shake")) {
                    return new f6(context);
                }
                break;
            case 109526449:
                if (lowerCase.equals("slide")) {
                    return new g6(context);
                }
                break;
            case 112202875:
                if (lowerCase.equals("video")) {
                    return new l6(context);
                }
                break;
            case 112386354:
                if (lowerCase.equals("voice")) {
                    return new d6(context);
                }
                break;
            case 1091550823:
                if (lowerCase.equals("countdownclose")) {
                    return new xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.a(context);
                }
                break;
            case 1547952107:
                if (lowerCase.equals("capsuleclose")) {
                    return new xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.b(context);
                }
                break;
        }
        return !TextUtils.isEmpty(str2) ? new a6(context) : new n6(context);
    }
}
