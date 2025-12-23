package com.kwad.sdk.core.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.oaid.NewOAIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.s;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    public static String Ie() {
        if (sHasReadSp.getAndSet(true)) {
            return sOAID;
        }
        String h6 = ag.h("ksadsdk_pref", "kasd_oaid_key", "");
        sOAID = h6;
        return h6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d2, code lost:
    
        if (r0.equals("ZTE") != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e6, code lost:
    
        if (r0.equals("ONEPLUS") != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0103, code lost:
    
        if (r0.equals("XIAOMI") != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012b, code lost:
    
        if (r0.equals("LENOVO") != false) goto L60;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void getOAIDNormal(android.content.Context r3) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.e.a.getOAIDNormal(android.content.Context):void");
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.core.e.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                String unused = a.sOAID = a.Ie();
                if (TextUtils.isEmpty(a.sOAID)) {
                    a.getOAIDNormal(context);
                    if (NewOAIDSDKHelper.isSupport()) {
                        NewOAIDSDKHelper.a(context, new NewOAIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                            @Override // com.kwad.sdk.oaid.NewOAIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eu(str);
                                a.Ig();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eu(str);
                                a.Ig();
                            }
                        });
                    }
                    a.sInitIng.set(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eu(String str) {
        if (!TextUtils.isEmpty(str)) {
            ag.g("ksadsdk_pref", "kasd_oaid_key", str);
        }
    }

    public static String getAppOAID(Context context) {
        if (bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid())) {
            return bc.getDevOaid();
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (!bc.useOaidDisable() && s.PU()) {
            initAsync(context);
            return sOAID;
        }
        String Ie = Ie();
        sOAID = Ie;
        return Ie;
    }

    static /* synthetic */ void Ig() {
    }
}
