package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.umeng.ccg.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AuthActivity extends Activity {
    public static final String ACTION_SHARE_PRIZE = "sharePrize";

    /* renamed from: a, reason: collision with root package name */
    private static int f40690a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, ActionHandler> f40691b = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface ActionHandler {
        void handleAction(Activity activity, Bundle bundle);
    }

    static {
        StubApp.interface11(42555);
    }

    private void a() {
        this.f40691b.put("action_common_channel", new ActionHandler() { // from class: com.tencent.tauth.AuthActivity.1
            @Override // com.tencent.tauth.AuthActivity.ActionHandler
            public void handleAction(Activity activity, Bundle bundle) {
                SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--common channel. ");
                Intent intent = new Intent(activity, (Class<?>) AssistActivity.class);
                intent.putExtras(bundle);
                intent.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_COMMON_CHANNEL);
                intent.setFlags(603979776);
                AuthActivity.this.startActivity(intent);
                AuthActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void a(Uri uri) {
        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri != null && uri.toString() != null) {
            String str = "";
            if (!uri.toString().equals("")) {
                String uri2 = uri.toString();
                Bundle a6 = m.a(uri2.substring(uri2.indexOf("#") + 1));
                if (a6 == null) {
                    SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                    finish();
                    return;
                }
                String string = a6.getString(a.f41544t);
                SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
                if (string == null) {
                    finish();
                    return;
                }
                if (string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("sendToMyComputer") || string.equals("shareToTroopBar")) {
                    if (string.equals("shareToQzone") && k.a((Context) this, "com.tencent.mobileqq") != null && k.c(this, "5.2.0") < 0) {
                        int i6 = f40690a + 1;
                        f40690a = i6;
                        if (i6 == 2) {
                            f40690a = 0;
                            finish();
                            return;
                        }
                    }
                    SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                    Intent intent = new Intent(this, (Class<?>) AssistActivity.class);
                    intent.putExtras(a6);
                    intent.setFlags(603979776);
                    startActivity(intent);
                    finish();
                    return;
                }
                if (string.equals("addToQQFavorites")) {
                    Intent intent2 = getIntent();
                    intent2.putExtras(a6);
                    intent2.putExtra(Constants.KEY_ACTION, "action_share");
                    IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string);
                    if (listnerWithAction != null) {
                        UIListenerManager.getInstance().handleDataToListener(intent2, listnerWithAction);
                    }
                    finish();
                    return;
                }
                if (string.equals(ACTION_SHARE_PRIZE)) {
                    Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                    try {
                        str = m.d(a6.getString("response")).getString("activityid");
                    } catch (Exception e6) {
                        SLog.e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e6);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        launchIntentForPackage.putExtra(ACTION_SHARE_PRIZE, true);
                        Bundle bundle = new Bundle();
                        bundle.putString("activityid", str);
                        launchIntentForPackage.putExtras(bundle);
                    }
                    startActivity(launchIntentForPackage);
                    finish();
                    return;
                }
                if (string.equals("sdkSetAvatar")) {
                    boolean booleanExtra = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent3 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent3.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_AVATAR);
                    intent3.putExtra(Constants.KEY_STAY, booleanExtra);
                    intent3.putExtras(a6);
                    intent3.setFlags(603979776);
                    startActivity(intent3);
                    finish();
                    return;
                }
                if ("sdkSetDynamicAvatar".equals(string)) {
                    boolean booleanExtra2 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent4 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent4.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_DYNAMIC_AVATAR);
                    intent4.putExtra(Constants.KEY_STAY, booleanExtra2);
                    intent4.putExtras(a6);
                    intent4.setFlags(603979776);
                    startActivity(intent4);
                    finish();
                    return;
                }
                if (string.equals("sdkSetEmotion")) {
                    boolean booleanExtra3 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent5 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent5.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_EMOTION);
                    intent5.putExtra(Constants.KEY_STAY, booleanExtra3);
                    intent5.putExtras(a6);
                    intent5.setFlags(603979776);
                    startActivity(intent5);
                    finish();
                    return;
                }
                if (string.equals("bindGroup")) {
                    SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                    boolean booleanExtra4 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent6 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent6.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_BIND_GROUP);
                    intent6.putExtra(Constants.KEY_STAY, booleanExtra4);
                    intent6.putExtras(a6);
                    intent6.setFlags(603979776);
                    startActivity(intent6);
                    finish();
                    return;
                }
                if (string.equals("joinGroup")) {
                    SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                    boolean booleanExtra5 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent7 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent7.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_JOIN_GROUP);
                    intent7.putExtra(Constants.KEY_STAY, booleanExtra5);
                    intent7.putExtras(a6);
                    intent7.setFlags(603979776);
                    startActivity(intent7);
                    finish();
                    return;
                }
                if (!"guildOpen".equals(string)) {
                    ActionHandler actionHandler = this.f40691b.get(string);
                    if (actionHandler != null) {
                        actionHandler.handleAction(this, a6);
                        return;
                    } else {
                        finish();
                        return;
                    }
                }
                Intent intent8 = new Intent(this, (Class<?>) AssistActivity.class);
                intent8.putExtras(a6);
                intent8.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_GUILD);
                intent8.setFlags(603979776);
                startActivity(intent8);
                finish();
                return;
            }
        }
        SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.AuthActivity", "activity finish exception: ", e6);
        }
    }
}
