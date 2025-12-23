package xyz.adscope.common.v2.dev.oaid;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;
import xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.DeviceID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.DeviceIdentifier;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.encrypt.impl.Base64Util;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.persistent.sp.CommonSpHelper;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class OAIDHelper {
    private static final String OAID_HELPER_CN = "CN";
    private static final String OAID_HELPER_SM = "SM";
    private static final String SP_KEY_HONOR_OAID = "HONOR_OAID_CIP";
    private static final String SP_KEY_OAID = "OAID_CIP";
    private static final String TAG = "OAIDHelper";
    private volatile boolean hasInvokeInit;
    private String mHonorOAID;
    private String mOAID;
    private boolean personalRecommend;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static OAIDHelper instance = new OAIDHelper();

        private InstanceHolder() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class OAIDChain {
        private OAIDChain() {
        }

        private void getOAIDByCN(final Context context) {
            try {
                new DevicesIDsHelper(new DevicesIDsHelper.AppIdsUpdater() { // from class: xyz.adscope.common.v2.dev.oaid.OAIDHelper.OAIDChain.1
                    @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper.AppIdsUpdater
                    public void OnIdsValid(String str) {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                OAIDHelper.this.saveOAID(context, str, "CN");
                            }
                        } catch (Throwable th) {
                            SDKLog.stack(th);
                        }
                    }
                }).getOAID(context);
            } catch (Throwable th) {
                SDKLog.stack(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void continueGetOAID(Context context) {
            getOAIDByCN(context);
        }
    }

    public synchronized void initOAID(final Context context) {
        if (!this.hasInvokeInit) {
            this.hasInvokeInit = true;
            ScopeThreadPoolManager.getInstance().getOrCreateImplement(context).executeLocalAsyncTask(new Runnable() { // from class: xyz.adscope.common.v2.dev.oaid.OAIDHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    OAIDHelper.this.getHonorOAIDByProp(context);
                    OAIDHelper oAIDHelper = OAIDHelper.this;
                    oAIDHelper.getOAIDBySM(context, new OAIDChain());
                }
            });
        }
    }

    private OAIDHelper() {
        this.personalRecommend = false;
        this.hasInvokeInit = false;
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getHonorOAIDByProp(Context context) {
        if (Build.BRAND.equals("HONOR")) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
                if (TextUtils.isEmpty(string) || Boolean.parseBoolean(string)) {
                    return;
                }
                String string2 = Settings.Global.getString(context.getContentResolver(), "oaid");
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                saveHonorOAID(context, string2);
            } catch (Throwable unused) {
            }
        }
    }

    private void saveHonorOAID(Context context, String str) {
        SDKLog.d(TAG, "保存Honor OAID: " + str);
        this.mHonorOAID = str;
        CommonSpHelper.putString(context, CommonSpHelper.getCommonSPFile(), SP_KEY_HONOR_OAID, Base64Util.encodeToString(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveOAID(Context context, String str, String str2) {
        SDKLog.d(TAG, str2 + "保存 OAID: " + str);
        this.mOAID = str;
        CommonSpHelper.putString(context, CommonSpHelper.getCommonSPFile(), SP_KEY_OAID, Base64Util.encodeToString(str));
    }

    public String getHonorOAID(Context context) {
        if (!this.personalRecommend) {
            return "";
        }
        if (TextUtils.isEmpty(this.mHonorOAID)) {
            this.mHonorOAID = Base64Util.decodeToString(CommonSpHelper.getString(context, CommonSpHelper.getCommonSPFile(), SP_KEY_HONOR_OAID, ""));
        }
        return this.mHonorOAID;
    }

    public String getOAID(Context context) {
        if (!this.personalRecommend) {
            return "";
        }
        if (TextUtils.isEmpty(this.mOAID)) {
            this.mOAID = Base64Util.decodeToString(CommonSpHelper.getString(context, CommonSpHelper.getCommonSPFile(), SP_KEY_OAID, ""));
        }
        return this.mOAID;
    }

    public void setPersonalRecommend(boolean z5) {
        this.personalRecommend = z5;
    }

    public static OAIDHelper getInstance() {
        return InstanceHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOAIDBySM(final Context context, final OAIDChain oAIDChain) {
        try {
            DeviceIdentifier.register((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()));
            if (DeviceID.supportedOAID(context)) {
                DeviceID.getOAID(context, new IGetter() { // from class: xyz.adscope.common.v2.dev.oaid.OAIDHelper.2
                    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
                    public void onOAIDGetError(Exception exc) {
                        OAIDChain oAIDChain2 = oAIDChain;
                        if (oAIDChain2 != null) {
                            oAIDChain2.continueGetOAID(context);
                        }
                    }

                    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
                    public void onOAIDGetComplete(String str) {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                OAIDHelper.this.saveOAID(context, str, OAIDHelper.OAID_HELPER_SM);
                                return;
                            }
                        } catch (Throwable th) {
                            SDKLog.stack(th);
                        }
                        OAIDChain oAIDChain2 = oAIDChain;
                        if (oAIDChain2 != null) {
                            oAIDChain2.continueGetOAID(context);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            SDKLog.stack(th);
        }
    }
}
