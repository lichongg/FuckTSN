package com.bykv.vk.component.ttvideo.net;

import com.bykv.vk.component.ttvideo.player.AVThreadPool;
import com.bykv.vk.component.ttvideo.player.CalledByNative;
import com.bykv.vk.component.ttvideo.player.Keep;
import com.bytedance.sdk.component.utils.vl;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class AVResolver {
    public static int HOST_MAX_CACHE_TIME = 600000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "ttmj";
    private static final Hashtable<String, HostInfo> mCacheHosts = new Hashtable<>();
    private String mError;
    private HostInfo mHostInfo;
    private String mHostName;
    private String[] mIPStr;
    private boolean mRet = false;
    private Thread mThread = null;

    static class ParserHost implements Runnable {
        String mHostName;
        AVResolver mResolver;

        @Override // java.lang.Runnable
        public void run() {
            InetAddress inetAddress;
            vl.j(AVResolver.TAG, "start ParserHost task");
            String str = null;
            try {
                inetAddress = InetAddress.getByName(this.mHostName);
            } catch (Throwable th) {
                th = th;
                inetAddress = null;
            }
            try {
                str = inetAddress.getHostAddress();
            } catch (Throwable th2) {
                th = th2;
                vl.j(th);
                this.mResolver.mError = th.getMessage();
                this.mResolver.mRet = true;
                if (inetAddress != null) {
                    return;
                } else {
                    return;
                }
            }
            this.mResolver.mRet = true;
            if (inetAddress != null || str == null) {
                return;
            }
            this.mResolver.mIPStr = new String[1];
            this.mResolver.mIPStr[0] = str;
            HostInfo hostInfo = new HostInfo();
            hostInfo.time = System.currentTimeMillis();
            hostInfo.ip = str;
            AVResolver.putHostInfo(this.mHostName, hostInfo);
            hostInfo.time = System.currentTimeMillis();
        }

        public ParserHost(AVResolver aVResolver, String str) {
            this.mResolver = aVResolver;
            this.mHostName = str;
        }
    }

    static class HostInfo {
        public String ip;
        public long time;

        HostInfo() {
        }
    }

    static synchronized void putHostInfo(String str, HostInfo hostInfo) {
        Object obj;
        synchronized (AVResolver.class) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Hashtable<String, HostInfo> hashtable = mCacheHosts;
                Object obj2 = null;
                if (hashtable.size() > 128) {
                    Iterator<Map.Entry<String, HostInfo>> it = hashtable.entrySet().iterator();
                    HostInfo hostInfo2 = null;
                    while (it.hasNext()) {
                        HostInfo value = it.next().getValue();
                        String key = it.next().getKey();
                        if (value != null) {
                            long j6 = value.time;
                            if (j6 < currentTimeMillis) {
                                hostInfo2 = value;
                                currentTimeMillis = j6;
                            }
                        }
                        obj2 = key;
                    }
                    obj = obj2;
                    obj2 = hostInfo2;
                } else {
                    obj = null;
                }
                if (obj2 != null && obj != null) {
                    mCacheHosts.remove(obj);
                }
                mCacheHosts.put(str, hostInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @CalledByNative
    public void freeAddress() {
        Thread thread = this.mThread;
        if (thread != null) {
            try {
                thread.interrupt();
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    @CalledByNative
    public String getAddress() {
        String[] strArr;
        String str;
        if (this.mRet && (strArr = this.mIPStr) != null && (str = strArr[0]) != null) {
            return str;
        }
        return "parser host name: " + this.mHostName + " error.err msg:" + this.mError;
    }

    @CalledByNative
    public void getAddressInfo(String str) {
        this.mHostName = str;
        if (str == null || str.length() <= 0 || "".equals(str)) {
            this.mRet = true;
            return;
        }
        if (isIP(this.mHostName)) {
            this.mIPStr = new String[]{this.mHostName};
            this.mRet = true;
            return;
        }
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        HostInfo hostInfo = hashtable.get(str);
        this.mHostInfo = hostInfo;
        if (hostInfo != null) {
            if (hostInfo.ip != null) {
                long currentTimeMillis = System.currentTimeMillis();
                HostInfo hostInfo2 = this.mHostInfo;
                if (currentTimeMillis - hostInfo2.time < HOST_MAX_CACHE_TIME) {
                    this.mIPStr = new String[]{hostInfo2.ip};
                    this.mRet = true;
                    return;
                }
            }
            hashtable.remove(str);
            this.mHostInfo = null;
        }
        try {
            AVThreadPool.addTask(new ParserHost(this, this.mHostName));
        } catch (Exception e6) {
            this.mRet = true;
            this.mError = e6.getMessage();
        }
    }

    @CalledByNative
    public int isSuccess() {
        if (!this.mRet) {
            return 0;
        }
        String[] strArr = this.mIPStr;
        return (strArr == null || strArr[0] == null) ? -1 : 1;
    }

    public static final boolean isIP(String str) {
        if (str.length() >= 7 && str.length() <= 15) {
            return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
        }
        if (str.charAt(0) != '[' || str.charAt(str.length() - 1) != ']') {
            return false;
        }
        return true;
    }
}
