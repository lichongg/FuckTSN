package cn.jiguang.ba;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import cn.jiguang.android.IDataShare;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static volatile a f1902a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<String> f1903b = new ConcurrentLinkedQueue<>();

        public static a a() {
            if (f1902a == null) {
                synchronized (a.class) {
                    try {
                        if (f1902a == null) {
                            f1902a = new a();
                        }
                    } finally {
                    }
                }
            }
            return f1902a;
        }

        public boolean a(Bundle bundle) {
            if (bundle == null) {
                return false;
            }
            long a6 = f.a(bundle);
            long b6 = f.b(bundle);
            cn.jiguang.bb.f.c("MessageProcessor", "isMessageProcessed Message " + a6 + " from run " + b6);
            if (a6 == -1 || b6 == -1) {
                return false;
            }
            String str = b6 + "_" + a6;
            if (!this.f1903b.contains(str)) {
                synchronized (this) {
                    try {
                        if (this.f1903b.size() >= 1000) {
                            this.f1903b.poll();
                        }
                        this.f1903b.offer(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return false;
            }
            cn.jiguang.bb.f.c("MessageProcessor", "Message " + a6 + " from run " + b6 + " has been processed before");
            return true;
        }

        private a() {
        }
    }

    public static class b {

        /* renamed from: b, reason: collision with root package name */
        private static volatile b f1904b;

        /* renamed from: a, reason: collision with root package name */
        private final ConcurrentHashMap<String, LinkedBlockingQueue<a>> f1905a = new ConcurrentHashMap<>();

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private Context f1906a;

            /* renamed from: b, reason: collision with root package name */
            private String f1907b;

            /* renamed from: c, reason: collision with root package name */
            private String f1908c;

            /* renamed from: d, reason: collision with root package name */
            private Bundle f1909d;

            /* renamed from: e, reason: collision with root package name */
            private String f1910e;

            public String a() {
                return this.f1907b;
            }

            public String b() {
                return this.f1908c;
            }

            public Bundle c() {
                return this.f1909d;
            }

            public a(Context context, String str, String str2, Bundle bundle, String str3) {
                this.f1906a = context;
                this.f1907b = str;
                this.f1908c = str2;
                this.f1909d = bundle;
                this.f1910e = str3;
            }
        }

        private a b(String str) {
            try {
                LinkedBlockingQueue<a> linkedBlockingQueue = this.f1905a.get(str);
                if (linkedBlockingQueue == null) {
                    return null;
                }
                return linkedBlockingQueue.poll();
            } catch (Exception e6) {
                cn.jiguang.bb.f.i("MessageQueueManager", "从队列获取消息失败: " + e6.getMessage());
                return null;
            }
        }

        public synchronized Bundle a(Context context, Uri uri, String str) {
            if (context == null || str == null) {
                cn.jiguang.bb.f.i("MessageQueueManager", "callMessage: context或toProcess为空");
                return null;
            }
            try {
                a b6 = b(str);
                Bundle bundle = null;
                while (b6 != null) {
                    try {
                        cn.jiguang.bb.f.c("MessageQueueManager", "sendByProvider, uri=" + f.a(b6.c()) + "," + uri + ", componentCls=" + b6.a() + ", action=" + b6.b());
                        bundle = context.getContentResolver().call(uri, b6.a(), b6.b(), b6.c());
                        b6 = b(str);
                    } catch (Exception e6) {
                        cn.jiguang.bb.f.i("MessageQueueManager", "发送消息失败: " + e6.getMessage());
                        a(b6, str);
                        throw e6;
                    }
                }
                return bundle;
            } catch (Exception e7) {
                cn.jiguang.bb.f.l("MessageQueueManager", "callMessage发生异常: " + e7.getMessage());
                return null;
            }
        }

        public static b a() {
            if (f1904b == null) {
                synchronized (b.class) {
                    try {
                        if (f1904b == null) {
                            f1904b = new b();
                        }
                    } finally {
                    }
                }
            }
            return f1904b;
        }

        private b() {
        }

        private LinkedBlockingQueue<a> a(String str) {
            LinkedBlockingQueue<a> linkedBlockingQueue;
            LinkedBlockingQueue<a> linkedBlockingQueue2 = this.f1905a.get(str);
            if (linkedBlockingQueue2 != null) {
                return linkedBlockingQueue2;
            }
            synchronized (this.f1905a) {
                try {
                    linkedBlockingQueue = this.f1905a.get(str);
                    if (linkedBlockingQueue == null) {
                        linkedBlockingQueue = new LinkedBlockingQueue<>(1000);
                        this.f1905a.put(str, linkedBlockingQueue);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return linkedBlockingQueue;
        }

        public synchronized void a(IDataShare iDataShare, String str) {
            if (iDataShare == null || str == null) {
                cn.jiguang.bb.f.i("MessageQueueManager", "sendMessage: aidl或toProcess为空");
                return;
            }
            a b6 = b(str);
            while (b6 != null) {
                try {
                    cn.jiguang.bb.f.c("MessageQueueManager", "sendByAidl queue, " + f.a(b6.c()) + "," + b6.a() + "," + b6.b());
                    iDataShare.onAction(b6.a(), b6.b(), b6.c());
                    b6 = b(str);
                } catch (RemoteException e6) {
                    cn.jiguang.bb.f.i("MessageQueueManager", "sendMessage RemoteException: " + e6.getMessage());
                    a(b6, str);
                    throw e6;
                }
            }
        }

        private void a(a aVar, String str) {
            try {
                LinkedBlockingQueue<a> a6 = a(str);
                if (a6 != null) {
                    LinkedBlockingQueue<a> linkedBlockingQueue = new LinkedBlockingQueue<>(1000);
                    do {
                        linkedBlockingQueue.offer(aVar);
                        aVar = a6.poll();
                    } while (aVar != null);
                    this.f1905a.put(str, linkedBlockingQueue);
                }
            } catch (Exception e6) {
                cn.jiguang.bb.f.l("MessageQueueManager", "重新入队失败: " + e6.getMessage());
            }
        }

        public synchronized boolean a(Context context, String str, String str2, Bundle bundle, String str3) {
            try {
                cn.jiguang.bb.f.c("MessageQueueManager", "开始添加消息到队列 - componentCls: " + str + ", action: " + str2 + ", toProcess: " + str3);
                if (!a(bundle, str3)) {
                    return false;
                }
                a aVar = new a(context, str, str2, bundle, str3);
                LinkedBlockingQueue<a> a6 = a(str3);
                boolean offer = a6.offer(aVar);
                if (!offer) {
                    cn.jiguang.bb.f.i("MessageQueueManager", "消息添加到队列失败 - 队列可能已满:" + a6.size());
                }
                return offer;
            } catch (Exception e6) {
                cn.jiguang.bb.f.i("MessageQueueManager", "添加消息到队列失败: " + e6.getMessage());
                return false;
            }
        }

        public boolean a(Bundle bundle, String str) {
            if (bundle == null || str == null) {
                return false;
            }
            if (bundle.containsKey("jpush_JMessenger_message_id")) {
                return true;
            }
            cn.jiguang.bb.f.i("MessageQueueManager", "消息缺少ID，不是要处理的信息，不添加到队列");
            return false;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static volatile c f1911a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicLong f1912b = new AtomicLong(0);

        /* renamed from: c, reason: collision with root package name */
        private long f1913c;

        public synchronized long a() {
            long incrementAndGet;
            incrementAndGet = this.f1912b.incrementAndGet();
            if (incrementAndGet >= 9223372036854774807L) {
                this.f1912b.set(100L);
                incrementAndGet = this.f1912b.incrementAndGet();
            }
            return incrementAndGet;
        }

        private long b(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jiguang.helper.jpush_messenger", 0);
            long j6 = sharedPreferences.getLong("run_id", 0L) + 1;
            long j7 = j6 <= 2147483647L ? j6 : 0L;
            sharedPreferences.edit().putLong("run_id", j7).commit();
            return j7;
        }

        public Bundle a(Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putLong("jpush_JMessenger_message_id", a());
            bundle.putLong("jpush_JMessenger_run_id", this.f1913c);
            return bundle;
        }

        private c(Context context) {
            if (context != null) {
                this.f1913c = b(context);
                return;
            }
            throw new IllegalArgumentException("context cannot be null");
        }

        public static c a(Context context) {
            if (f1911a == null) {
                synchronized (c.class) {
                    try {
                        if (f1911a == null) {
                            f1911a = new c(context);
                        }
                    } finally {
                    }
                }
            }
            return f1911a;
        }
    }

    public static long a(Bundle bundle) {
        if (bundle == null) {
            return -1L;
        }
        return bundle.getLong("jpush_JMessenger_message_id", -1L);
    }

    public static long b(Bundle bundle) {
        if (bundle == null) {
            return -1L;
        }
        return bundle.getLong("jpush_JMessenger_run_id", -1L);
    }
}
