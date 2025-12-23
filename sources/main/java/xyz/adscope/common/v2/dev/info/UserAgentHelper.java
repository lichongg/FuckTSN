package xyz.adscope.common.v2.dev.info;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.concurrent.TimeUnit;
import xyz.adscope.common.v2.encrypt.impl.Base64Util;
import xyz.adscope.common.v2.handle.WeakReferenceHandler;
import xyz.adscope.common.v2.persistent.sp.CommonSpHelper;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.date.DateUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UserAgentHelper {
    private static final int GET_USER_AGENT_MSG = 1;
    private static final String SP_KEY_USER_AGENT = "UA_CIP";
    private static final String SP_KEY_USER_AGENT_LAST = "UA_LAST";
    private String mCustomUA;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.dev.info.UserAgentHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static UserAgentHelper instance = new UserAgentHelper(null);

        private InstanceHolder() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class UAHandler extends WeakReferenceHandler {
        private WebView getSafeWebView(Context context) {
            WebView webView = new WebView(context);
            WebView.setWebContentsDebuggingEnabled(false);
            webView.getSettings().setSavePassword(false);
            return webView;
        }

        @Override // xyz.adscope.common.v2.handle.WeakReferenceHandler
        public void scopeHandleMessage(Message message) {
            Context context;
            if (message == null || message.what != 1 || (context = getContext()) == null || DateUtil.timestampIsInDay(CommonSpHelper.getLong(context, CommonSpHelper.getBasicSPFile("v2"), UserAgentHelper.SP_KEY_USER_AGENT_LAST, 0L), 2)) {
                return;
            }
            String userAgentString = getSafeWebView(context).getSettings().getUserAgentString();
            if (TextUtils.isEmpty(userAgentString)) {
                return;
            }
            CommonSpHelper.putString(context, CommonSpHelper.getBasicSPFile("v2"), UserAgentHelper.SP_KEY_USER_AGENT, Base64Util.encodeToString(userAgentString));
            CommonSpHelper.putLong(context, CommonSpHelper.getBasicSPFile("v2"), UserAgentHelper.SP_KEY_USER_AGENT_LAST, System.currentTimeMillis());
        }

        public UAHandler(Context context) {
            super(context);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class UserAgentTask implements Runnable {
        private final WeakReferenceHandler mHandler;

        /* synthetic */ UserAgentTask(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        private UserAgentTask(Context context) {
            this.mHandler = new UAHandler(context);
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mHandler.sendMessage(obtain);
        }
    }

    /* synthetic */ UserAgentHelper(AnonymousClass1 anonymousClass1) {
        this();
    }

    private UserAgentHelper() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public String getUserAgent(Context context) {
        if (!TextUtils.isEmpty(this.mCustomUA)) {
            return this.mCustomUA;
        }
        String string = CommonSpHelper.getString(context, CommonSpHelper.getBasicSPFile("v2"), SP_KEY_USER_AGENT, "");
        return !TextUtils.isEmpty(string) ? Base64Util.decodeToString(string) : "";
    }

    public void setCustomUserAgent(String str) {
        this.mCustomUA = str;
    }

    public static UserAgentHelper getInstance() {
        return InstanceHolder.instance;
    }

    public void asyncInitUserAgent(Context context) {
        IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(context);
        if (orCreateImplement != null) {
            orCreateImplement.scheduleAsyncTask(new UserAgentTask(context, null), 5L, TimeUnit.SECONDS);
        }
    }
}
