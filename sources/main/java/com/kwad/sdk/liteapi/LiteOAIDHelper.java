package com.kwad.sdk.liteapi;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.kwad.sdk.api.a.b;
import com.kwad.sdk.liteapi.LiteOADIDSDKHelper25;
import com.kwad.sdk.liteapi.oaid.OADIDSDKHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiteOAIDHelper {
    private static final String KEY_OAID = "kasd_oaid_key";
    private static final String TAG = "OAIDHelper";
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

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
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.liteapi.LiteOAIDHelper.getOAIDNormal(android.content.Context):void");
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new b() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                if (TextUtils.isEmpty(LiteOAIDHelper.sOAID)) {
                    LiteOAIDHelper.getOAIDNormal(context);
                    if (OADIDSDKHelper.isSupport()) {
                        OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1.1
                            @Override // com.kwad.sdk.liteapi.oaid.OADIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused = LiteOAIDHelper.sOAID = str;
                            }
                        });
                    } else if (LiteOADIDSDKHelper25.isSupport()) {
                        LiteOADIDSDKHelper25.getOAId(context, new LiteOADIDSDKHelper25.OAIDListener() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1.2
                        });
                    }
                    LiteOAIDHelper.sInitIng.set(false);
                }
            }
        });
    }

    public static String obtainCurrent() {
        return sOAID;
    }

    public static String getAppOAID(Context context) {
        if (LiteSDKDeviceController.useOaidDisable() && !TextUtils.isEmpty(LiteSDKDeviceController.getDevOaid())) {
            return LiteSDKDeviceController.getDevOaid();
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (LiteSDKDeviceController.useOaidDisable()) {
            return sOAID;
        }
        initAsync(context);
        return sOAID;
    }
}
