package com.bykv.vk.component.ttvideo.network;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.network.IPCache;
import com.bykv.vk.component.ttvideo.network.NetworkManager;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class DnsHelper {
    private static final String TAG = "DnsHelper";
    private static final int UPDATE_PEROID = 300000;
    private static volatile long mServerIPTime;
    private volatile OnParseCompletionListener mCompletionListener;
    private Context mContext;
    private final ExecutorService mExecutor;
    private Future mFuture;
    private final INetworkClient mNetworkClient;
    public volatile String mServerIP;
    private volatile boolean mIsForceHttp = false;
    private String mHttpDNSServerHost = null;
    private volatile boolean mIsTTNetHttp = false;
    private int mExpiredTime = 600000;

    public interface OnParseCompletionListener {
        void onParseComplete(String str, String str2, LiveError liveError, boolean z5);
    }

    public void cancel() {
        this.mCompletionListener = null;
        Future future = this.mFuture;
        if (future == null || future.isDone()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    private static final class URLHostIndex {
        int authEnd;
        int hostEnd;
        int hostStart;

        URLHostIndex(int i6, int i7, int i8) {
            this.hostStart = i6;
            this.hostEnd = i7;
            this.authEnd = i8;
        }
    }

    private String getURL(String str) {
        return String.format("https://%s/q?host=%s", this.mHttpDNSServerHost, str);
    }

    private static URLHostIndex getURLHostIndex(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf("://") + 3;
        int length = str.length();
        int i6 = indexOf;
        int i7 = -1;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (charAt == '#' || charAt == '/') {
                break;
            }
            if (charAt == ':') {
                i7 = indexOf;
            } else {
                if (charAt == '?') {
                    break;
                }
                if (charAt == '@') {
                    i6 = indexOf + 1;
                }
            }
            indexOf++;
        }
        if (i7 == -1) {
            i7 = indexOf;
        }
        return new URLHostIndex(i6, i7, indexOf);
    }

    public static String getUrlHost(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        URLHostIndex uRLHostIndex = getURLHostIndex(str);
        return str.substring(uRLHostIndex.hostStart, uRLHostIndex.hostEnd);
    }

    public static boolean isIP(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || "".equals(str)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParseComplete(boolean z5, String str, String str2, LiveError liveError, boolean z6) {
        OnParseCompletionListener onParseCompletionListener;
        if (this.mIsForceHttp != z5 || (onParseCompletionListener = this.mCompletionListener) == null) {
            return;
        }
        if (z6 && str2 != null) {
            IPCache.IpInfo ipInfo = new IPCache.IpInfo();
            ipInfo.iptime = System.currentTimeMillis();
            ipInfo.ipaddr = str2;
            ipInfo.needUpdate = false;
            IPCache.getInstance().put(str, ipInfo);
        }
        onParseCompletionListener.onParseComplete(str, str2, liveError, z6);
    }

    public void configure(boolean z5, String str) {
        this.mIsForceHttp = (!z5 || this.mNetworkClient == null || TextUtils.isEmpty(str) || str.equals("null")) ? false : true;
        this.mHttpDNSServerHost = str;
        vl.j(TAG, this.mIsForceHttp + this.mHttpDNSServerHost);
    }

    public DnsHelper(Context context, ExecutorService executorService, INetworkClient iNetworkClient) {
        this.mContext = context;
        this.mExecutor = executorService;
        this.mNetworkClient = iNetworkClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doHttpDns(final String str) {
        NetworkManager.doRequest(this.mNetworkClient, getURL(str), this.mHttpDNSServerHost, new NetworkManager.OnCompletionListener() { // from class: com.bykv.vk.component.ttvideo.network.DnsHelper.2
            @Override // com.bykv.vk.component.ttvideo.network.NetworkManager.OnCompletionListener
            public void onCompletion(JSONObject jSONObject) {
                String str2;
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("host", str);
                    DnsHelper.this.notifyParseComplete(true, str, null, new LiveError(LiveError.EMPTY, "http dns response ip empty", hashMap), true);
                    return;
                }
                try {
                    str2 = optJSONArray.getString(0);
                } catch (Exception unused) {
                    str2 = null;
                }
                DnsHelper.this.notifyParseComplete(true, str, str2, null, true);
            }

            @Override // com.bykv.vk.component.ttvideo.network.NetworkManager.OnCompletionListener
            public void onError(LiveError liveError) {
                DnsHelper.this.notifyParseComplete(true, str, null, liveError, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalDns(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName == null) {
                notifyParseComplete(false, str, null, new LiveError(LiveError.DNS_PARSE_ERROR, "", null), true);
                return;
            }
            String hostAddress = byName.getHostAddress();
            if (byName instanceof Inet6Address) {
                hostAddress = String.format("[%s]", hostAddress);
            }
            notifyParseComplete(false, str, hostAddress, null, true);
        } catch (UnknownHostException e6) {
            HashMap hashMap = new HashMap();
            hashMap.put(MediationConstant.KEY_REASON, "Unknown host name");
            hashMap.put("host", str);
            hashMap.put("exception", e6.toString());
            notifyParseComplete(false, str, null, new LiveError(LiveError.DNS_PARSE_ERROR, "Unknown Host", hashMap), true);
        }
    }

    public static String hostToIPUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            URLHostIndex uRLHostIndex = getURLHostIndex(str);
            boolean startsWith = str.startsWith(b.f50154a);
            String str3 = str.substring(0, uRLHostIndex.hostStart) + str2;
            int i6 = uRLHostIndex.hostEnd;
            if (uRLHostIndex.authEnd != -1) {
                str3 = str3 + str.substring(uRLHostIndex.hostEnd, uRLHostIndex.authEnd);
                i6 = uRLHostIndex.authEnd;
            }
            if (!startsWith) {
                str3 = str3 + "/" + getUrlHost(str);
            }
            return str3 + str.substring(i6);
        }
        return null;
    }

    public String getDNSServerIP() {
        updateDNSServerIP();
        return this.mServerIP;
    }

    public void parseDns(final String str, OnParseCompletionListener onParseCompletionListener) {
        int i6;
        if (!TextUtils.isEmpty(str) && onParseCompletionListener != null) {
            if (this.mExecutor != null) {
                final boolean z5 = this.mIsForceHttp;
                cancel();
                this.mCompletionListener = onParseCompletionListener;
                NetworkInfo networkInfo = NetUtils.getNetworkInfo(this.mContext);
                if (networkInfo != null && networkInfo.isAvailable()) {
                    i6 = networkInfo.getType();
                } else {
                    i6 = -1;
                }
                int curNetType = IPCache.getInstance().getCurNetType();
                if (i6 == -1 || i6 != curNetType) {
                    IPCache.getInstance().clear();
                    IPCache.getInstance().setCurNetType(i6);
                }
                IPCache.IpInfo ipInfo = IPCache.getInstance().get(str);
                if (ipInfo != null && System.currentTimeMillis() - ipInfo.iptime <= this.mExpiredTime && !ipInfo.needUpdate) {
                    notifyParseComplete(this.mIsForceHttp, str, ipInfo.ipaddr, null, false);
                    return;
                } else if (!this.mExecutor.isShutdown()) {
                    this.mFuture = this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.network.DnsHelper.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z5) {
                                DnsHelper.this.doHttpDns(str);
                            } else {
                                DnsHelper.this.doLocalDns(str);
                            }
                        }
                    });
                    return;
                } else {
                    notifyParseComplete(false, str, null, null, false);
                    return;
                }
            }
            throw new IllegalStateException("mExecutor should not be null");
        }
    }

    public void updateDNSServerIP() {
        if (SystemClock.elapsedRealtime() - mServerIPTime >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS && !this.mExecutor.isShutdown()) {
            this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.network.DnsHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InetAddress byName = InetAddress.getByName("whoami.akamai.net");
                        if (byName != null) {
                            DnsHelper.this.mServerIP = byName.getHostAddress();
                            long unused = DnsHelper.mServerIPTime = SystemClock.elapsedRealtime();
                            String str = DnsHelper.this.mServerIP;
                        }
                    } catch (UnknownHostException unused2) {
                    }
                }
            });
        }
    }
}
