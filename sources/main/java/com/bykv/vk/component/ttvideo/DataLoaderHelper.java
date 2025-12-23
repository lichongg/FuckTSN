package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.bytedance.sdk.component.utils.vl;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\Downloads\app\classes3.dex */
public class DataLoaderHelper implements AVMDLDataLoaderListener, AVMDLStartCompleteListener {
    public static final int DATALOADER_KEY_ENABLE_ALOG = 512;
    public static final int DATALOADER_KEY_INT_MAXCACHESIZE = 1;
    public static final int DATALOADER_KEY_INT_OPENTIMEOUT = 3;
    public static final int DATALOADER_KEY_INT_PARALLEL_NUM = 11;
    public static final int DATALOADER_KEY_INT_RWTIMEOUT = 2;
    public static final int DATALOADER_KEY_INT_TRYCOUNT = 4;
    public static final int DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE = 1005;
    public static final int DATALOADER_KEY_STRING_CACHEDIR = 0;
    public static final int IsClose = 1;
    public static final int IsPlayTask = 1;
    public static final int IsPreloadTask = 2;
    public static final int IsStart = 0;
    public static final int IsUnknown = 0;
    public static final String MDL_PREFIX = "mdl://";

    /* renamed from: p, reason: collision with root package name */
    private static final DataLoaderHelper f22786p = new DataLoaderHelper();

    /* renamed from: q, reason: collision with root package name */
    private static int f22787q = 0;

    /* renamed from: r, reason: collision with root package name */
    private static int f22788r = 0;

    /* renamed from: s, reason: collision with root package name */
    private static int f22789s = 0;

    /* renamed from: b, reason: collision with root package name */
    private final d f22791b;

    /* renamed from: c, reason: collision with root package name */
    private final d f22792c;

    /* renamed from: d, reason: collision with root package name */
    private final d f22793d;

    /* renamed from: e, reason: collision with root package name */
    private final d f22794e;

    /* renamed from: i, reason: collision with root package name */
    private AVMDLDataLoader f22798i;

    /* renamed from: k, reason: collision with root package name */
    private VideoEventEngineUploader f22800k;

    /* renamed from: m, reason: collision with root package name */
    private boolean f22802m;

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f22795f = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap<String, ArrayList<TTVideoEngine>> f22796g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final ReentrantLock f22797h = new ReentrantLock();

    /* renamed from: l, reason: collision with root package name */
    private boolean f22801l = true;

    /* renamed from: n, reason: collision with root package name */
    private int f22803n = 0;

    /* renamed from: o, reason: collision with root package name */
    private final ReentrantLock f22804o = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    private volatile int f22790a = 1;

    /* renamed from: j, reason: collision with root package name */
    private AVMDLDataLoaderConfigure f22799j = AVMDLDataLoaderConfigure.getDefaultonfigure();

    public static class DataLoaderTaskProgressInfo {
        public String mKey = null;
        public String mVideoId = null;
        public String mLocalFilePath = null;
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public int mTaskType = 0;
    }

    static /* synthetic */ class a {
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public String f22805a = null;

        /* renamed from: b, reason: collision with root package name */
        public long f22806b = 0;

        /* renamed from: c, reason: collision with root package name */
        public PreloaderURLItem f22807c = null;

        /* renamed from: d, reason: collision with root package name */
        public boolean f22808d = false;

        /* renamed from: e, reason: collision with root package name */
        public List<a> f22809e = new CopyOnWriteArrayList();

        public a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a b6 = b(str);
            if (b6 != null) {
                return b6;
            }
            a aVar = new a(this);
            aVar.f22810a = str;
            this.f22809e.add(aVar);
            return aVar;
        }

        public class a {

            /* renamed from: a, reason: collision with root package name */
            public String f22810a = null;

            /* renamed from: b, reason: collision with root package name */
            public String f22811b = null;

            /* renamed from: c, reason: collision with root package name */
            public String[] f22812c = null;

            /* renamed from: d, reason: collision with root package name */
            public String f22813d = null;

            /* renamed from: e, reason: collision with root package name */
            public long f22814e = 0;

            /* renamed from: f, reason: collision with root package name */
            public long f22815f = 0;

            /* renamed from: g, reason: collision with root package name */
            public long f22816g = 0;

            /* renamed from: h, reason: collision with root package name */
            public long f22817h = 0;

            /* renamed from: i, reason: collision with root package name */
            public long f22818i = 0;

            public a(b bVar) {
            }
        }

        public IPreLoaderItemCallBackListener a() {
            PreloaderURLItem preloaderURLItem = this.f22807c;
            if (preloaderURLItem == null || preloaderURLItem.getCallBackListener() == null) {
                return null;
            }
            return this.f22807c.getCallBackListener();
        }

        public a b(String str) {
            if (this.f22809e.size() <= 0) {
                return null;
            }
            for (int i6 = 0; i6 < this.f22809e.size(); i6++) {
                a aVar = this.f22809e.get(i6);
                if (aVar.f22810a.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }

        public b(DataLoaderHelper dataLoaderHelper) {
        }

        public void a(int i6) {
            if (a() != null) {
                DataLoaderHelper.c();
                int unused = DataLoaderHelper.f22789s;
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i6);
                a().preloadItemInfo(preLoaderItemCallBackInfo);
            }
        }

        public void a(String str, long j6) {
            if (this.f22809e.size() == 0) {
                a aVar = new a(this);
                aVar.f22810a = str;
                aVar.f22816g = j6;
                this.f22809e.add(aVar);
            } else {
                TTVideoEngineLog.e("DataLoaderHelper", "[preload] DataLoaderTaskItem setup fail");
            }
            this.f22806b = j6;
        }
    }

    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f22819a;

        /* renamed from: b, reason: collision with root package name */
        public int f22820b = 0;

        /* renamed from: c, reason: collision with root package name */
        public List<a> f22821c = null;

        public class a {

            /* renamed from: e, reason: collision with root package name */
            public String f22826e;

            /* renamed from: a, reason: collision with root package name */
            public String f22822a = null;

            /* renamed from: b, reason: collision with root package name */
            public long f22823b = 0;

            /* renamed from: c, reason: collision with root package name */
            public long f22824c = 0;

            /* renamed from: d, reason: collision with root package name */
            public List<C0302a> f22825d = null;

            /* renamed from: f, reason: collision with root package name */
            public Error f22827f = null;

            void a(long j6) {
                if (this.f22825d == null) {
                    this.f22825d = new ArrayList();
                }
                if (this.f22825d.size() == 0) {
                    this.f22825d.add(new C0302a(this));
                }
                this.f22825d.get(0).f22828a = 0L;
                this.f22825d.get(0).f22829b = j6;
            }

            /* renamed from: com.bykv.vk.component.ttvideo.DataLoaderHelper$c$a$a, reason: collision with other inner class name */
            public class C0302a {

                /* renamed from: a, reason: collision with root package name */
                public long f22828a = 0;

                /* renamed from: b, reason: collision with root package name */
                public long f22829b = 0;

                public C0302a(a aVar) {
                }
            }

            public boolean a() {
                long j6 = this.f22824c;
                long min = j6 > 0 ? Math.min(j6, this.f22823b) : this.f22823b;
                List<C0302a> list = this.f22825d;
                C0302a c0302a = list != null ? list.get(list.size() - 1) : null;
                return this.f22827f != null || (c0302a != null && this.f22823b > 0 && c0302a.f22828a + c0302a.f22829b >= min);
            }

            public long b() {
                List<C0302a> list = this.f22825d;
                if (list == null || list.size() <= 0) {
                    return 0L;
                }
                return this.f22825d.get(r0.size() - 1).f22829b;
            }

            public a(c cVar) {
            }
        }

        public long a() {
            long j6 = 0;
            if (this.f22821c != null) {
                for (int i6 = 0; i6 < this.f22821c.size(); i6++) {
                    j6 += this.f22821c.get(i6).b();
                }
            }
            return j6;
        }

        private a a(String str) {
            List<a> list;
            if (TextUtils.isEmpty(str) || (list = this.f22821c) == null) {
                return null;
            }
            for (a aVar : list) {
                if (aVar.f22822a.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }

        public boolean b() {
            boolean z5;
            int i6;
            if (this.f22821c != null) {
                z5 = true;
                i6 = 0;
                for (int i7 = 0; i7 < this.f22821c.size(); i7++) {
                    a aVar = this.f22821c.get(i7);
                    if (aVar == null || aVar.a()) {
                        i6++;
                    } else {
                        z5 = false;
                    }
                }
            } else {
                z5 = true;
                i6 = 0;
            }
            return z5 || (i6 >= 2 && this.f22820b == 1);
        }

        public boolean c() {
            if (this.f22820b != 2) {
                return false;
            }
            if (this.f22821c == null) {
                return true;
            }
            for (int i6 = 0; i6 < this.f22821c.size(); i6++) {
                a aVar = this.f22821c.get(i6);
                if (aVar != null && !aVar.a()) {
                    return false;
                }
            }
            return true;
        }

        public c(DataLoaderHelper dataLoaderHelper) {
        }

        public void a(b bVar) {
            boolean z5;
            if (this.f22821c == null) {
                this.f22821c = new ArrayList();
            }
            for (b.a aVar : bVar.f22809e) {
                a a6 = a(aVar.f22810a);
                if (a6 == null) {
                    a6 = new a(this);
                    z5 = false;
                } else {
                    z5 = true;
                }
                a6.f22822a = aVar.f22810a;
                a6.f22823b = aVar.f22817h;
                a6.a(aVar.f22818i);
                a6.f22824c = aVar.f22816g;
                a6.f22826e = aVar.f22813d;
                if (!z5) {
                    this.f22821c.add(a6);
                }
            }
        }

        public void a(String str, Error error) {
            a a6 = a(str);
            if (a6 != null) {
                a6.f22827f = error;
            }
        }
    }

    private class d {

        /* renamed from: a, reason: collision with root package name */
        private final ReentrantLock f22830a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<b> f22831b;

        /* renamed from: c, reason: collision with root package name */
        private long f22832c;

        private d(DataLoaderHelper dataLoaderHelper) {
            this.f22830a = new ReentrantLock();
            this.f22831b = new ArrayList<>();
            this.f22832c = 0L;
        }

        public b a() {
            this.f22830a.lock();
            if (this.f22831b.size() == 0) {
                this.f22830a.unlock();
                return null;
            }
            b bVar = this.f22831b.get(r0.size() - 1);
            this.f22830a.unlock();
            return bVar;
        }

        public long b() {
            this.f22830a.lock();
            long size = this.f22831b.size();
            this.f22830a.unlock();
            return size;
        }

        public b c() {
            this.f22830a.lock();
            if (this.f22831b.size() == 0) {
                this.f22830a.unlock();
                return null;
            }
            b bVar = this.f22831b.get(r0.size() - 1);
            this.f22831b.remove(bVar);
            this.f22830a.unlock();
            return bVar;
        }

        public b d(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f22830a.lock();
            int i6 = 0;
            while (true) {
                if (i6 >= this.f22831b.size()) {
                    break;
                }
                b bVar2 = this.f22831b.get(i6);
                if (!TextUtils.isEmpty(bVar2.f22805a) && bVar2.f22805a.equals(str)) {
                    bVar = bVar2;
                    break;
                }
                i6++;
            }
            if (bVar != null) {
                this.f22831b.remove(bVar);
            }
            this.f22830a.unlock();
            return bVar;
        }

        /* synthetic */ d(DataLoaderHelper dataLoaderHelper, a aVar) {
            this(dataLoaderHelper);
        }

        private Boolean e() {
            if (this.f22832c >= 1) {
                return Boolean.valueOf(((long) this.f22831b.size()) >= this.f22832c);
            }
            return Boolean.FALSE;
        }

        public void a(long j6) {
            this.f22832c = j6;
        }

        public b b(b bVar) {
            b bVar2;
            if (TextUtils.isEmpty(bVar.f22805a)) {
                bVar2 = null;
            } else {
                bVar2 = d(bVar.f22805a);
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            Iterator<b.a> it = bVar.f22809e.iterator();
            while (it.hasNext() && (bVar2 = c(it.next().f22810a)) == null) {
            }
            return bVar2;
        }

        public b c(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f22830a.lock();
            int i6 = 0;
            while (true) {
                if (i6 >= this.f22831b.size()) {
                    break;
                }
                b bVar2 = this.f22831b.get(i6);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
                i6++;
            }
            if (bVar != null) {
                this.f22831b.remove(bVar);
            }
            this.f22830a.unlock();
            return bVar;
        }

        public ArrayList<b> d() {
            try {
                this.f22830a.lock();
                return new ArrayList<>(this.f22831b);
            } finally {
                this.f22830a.unlock();
            }
        }

        boolean a(b bVar) {
            Boolean bool;
            if (bVar == null || bVar.f22809e.size() == 0) {
                return false;
            }
            this.f22830a.lock();
            if (e().booleanValue()) {
                bool = Boolean.FALSE;
            } else {
                this.f22831b.add(bVar);
                bool = Boolean.TRUE;
            }
            this.f22830a.unlock();
            return bool.booleanValue();
        }

        public b b(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f22830a.lock();
            int i6 = 0;
            while (true) {
                if (i6 >= this.f22831b.size()) {
                    break;
                }
                b bVar2 = this.f22831b.get(i6);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
                i6++;
            }
            this.f22830a.unlock();
            return bVar;
        }

        public boolean a(String str) {
            int i6 = 0;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean bool = Boolean.FALSE;
            this.f22830a.lock();
            while (true) {
                if (i6 >= this.f22831b.size()) {
                    break;
                }
                if (this.f22831b.get(i6).b(str) != null) {
                    bool = Boolean.TRUE;
                    break;
                }
                i6++;
            }
            this.f22830a.unlock();
            return bool.booleanValue();
        }
    }

    private String a(String str, String str2, long j6, long j7, String[] strArr, String str3) {
        String str4;
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        if (j7 <= 0) {
            j7 = 0;
        }
        for (String str5 : strArr2) {
            if (!c(str5)) {
                return null;
            }
        }
        String[] a6 = a(strArr2);
        String encodeUrl = encodeUrl(str);
        if (TextUtils.isEmpty(encodeUrl)) {
            return null;
        }
        TTVideoEngineLog.i("DataLoaderHelper", "preloadProxyQuery: key = " + str + ", rawKey = " + str2);
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        String encodeUrl2 = encodeUrl(str);
        if (TextUtils.isEmpty(encodeUrl2)) {
            encodeUrl2 = "videoId";
        }
        StringBuffer stringBuffer = new StringBuffer("?rk=");
        stringBuffer.append(encodeUrl2);
        stringBuffer.append("&k=");
        stringBuffer.append(encodeUrl);
        if (j7 > 0) {
            stringBuffer.append("&s=");
            stringBuffer.append(j6 + j7);
        }
        if (!TextUtils.isEmpty(str3)) {
            try {
                str4 = URLEncoder.encode(str3, "UTF-8");
            } catch (UnsupportedEncodingException e6) {
                vl.j(e6);
                str4 = null;
            }
            if (!TextUtils.isEmpty(str4)) {
                stringBuffer.append("&p=");
                stringBuffer.append(str4);
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i6 = 0; i6 < a6.length; i6++) {
            String encodeUrlByQuery = encodeUrlByQuery(a6[i6]);
            StringBuffer stringBuffer3 = new StringBuffer();
            if (!TextUtils.isEmpty(encodeUrlByQuery)) {
                stringBuffer3.append("&u");
                stringBuffer3.append(i6);
                stringBuffer3.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer3.append(encodeUrlByQuery);
            }
            if (stringBuffer.length() + stringBuffer2.length() + stringBuffer3.length() + 32 > 3096) {
                break;
            }
            stringBuffer2.append(stringBuffer3);
        }
        if (stringBuffer2.length() <= 0) {
            return null;
        }
        stringBuffer.append(stringBuffer2);
        return stringBuffer.toString();
    }

    static /* synthetic */ int c() {
        int i6 = f22789s;
        f22789s = i6 + 1;
        return i6;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String str) {
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int i6, long j6, String str) {
        return null;
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader videoEventEngineUploader) {
        this.f22800k = videoEventEngineUploader;
    }

    public class DataLoaderCacheInfo {
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public String mLocalFilePath = null;

        public DataLoaderCacheInfo(DataLoaderHelper dataLoaderHelper) {
        }
    }

    private ArrayList<TTVideoEngine> a(String str) {
        ArrayList<TTVideoEngine> arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            this.f22797h.lock();
            ArrayList<TTVideoEngine> arrayList2 = this.f22796g.get(str);
            if (arrayList2 != null) {
                arrayList = new ArrayList<>(arrayList2);
                TTVideoEngineLog.i("DataLoaderHelper", "get engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
            }
            return arrayList;
        } finally {
            this.f22797h.unlock();
        }
    }

    private DataLoaderCacheInfo b(String str) {
        DataLoaderCacheInfo dataLoaderCacheInfo = null;
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length >= 4) {
            dataLoaderCacheInfo = new DataLoaderCacheInfo(this);
            dataLoaderCacheInfo.mLocalFilePath = split[3];
            if (!TextUtils.isEmpty(split[0])) {
                dataLoaderCacheInfo.mCacheSizeFromZero = Long.parseLong(split[0]);
            }
            if (!TextUtils.isEmpty(split[1])) {
                dataLoaderCacheInfo.mMediaSize = Long.parseLong(split[1]);
            }
        }
        return dataLoaderCacheInfo;
    }

    private void c(b bVar) {
        if (bVar == null || bVar.f22808d) {
            return;
        }
        bVar.f22808d = true;
        if (bVar.a() != null) {
            f22789s++;
            bVar.a().preloadItemInfo(new PreLoaderItemCallBackInfo(5));
        }
    }

    private boolean d() {
        if (this.f22798i != null) {
            return true;
        }
        if (AVMDLDataLoader.init(false, false) != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "library has not been loaded");
            return false;
        }
        try {
            AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
            this.f22798i = aVMDLDataLoader;
            aVMDLDataLoader.setConfigure(this.f22799j);
            this.f22798i.setListener(this);
            this.f22798i.setStartCompleteListener(this);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static DataLoaderHelper getDataLoader() {
        return f22786p;
    }

    public String _proxyUrl(String str, String str2, long j6, String[] strArr, String str3) {
        if (this.f22790a != 0 || TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (String str4 : strArr2) {
            if (!c(str4)) {
                return str4;
            }
        }
        if (this.f22798i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "start mdl first");
            return null;
        }
        this.f22804o.lock();
        try {
            String localAddr = this.f22798i.getLocalAddr();
            if (TextUtils.isEmpty(localAddr)) {
                TTVideoEngineLog.e("DataLoaderHelper", "local host error");
                this.f22804o.unlock();
                return null;
            }
            String a6 = a(str, str2, 0L, j6, strArr2, str3);
            if (TextUtils.isEmpty(a6)) {
                this.f22804o.unlock();
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i6 = this.f22803n;
            this.f22803n = i6 + 1;
            StringBuffer stringBuffer2 = new StringBuffer();
            TTVideoEngineLog.i("DataLoaderHelper", "proxy url, mInvalidMdlProcotol: " + this.f22801l);
            if (this.f22801l || !this.f22802m) {
                stringBuffer.append(JPushConstants.HTTP_PRE);
                stringBuffer.append(localAddr);
                stringBuffer.append("/");
                stringBuffer.append(i6);
            } else {
                stringBuffer.append("mdl://id");
                stringBuffer.append(i6);
                stringBuffer.append("/");
            }
            stringBuffer.append(a6);
            stringBuffer2.append(a6);
            String auth = this.f22798i.getAuth(a6);
            if (!TextUtils.isEmpty(auth)) {
                stringBuffer.append("&ah=");
                stringBuffer.append(auth);
                stringBuffer.append("&ah=");
                stringBuffer.append(auth);
            }
            String stringBuffer3 = stringBuffer.toString();
            TTVideoEngineLog.i("DataLoaderHelper", "_proxyUrl: ".concat(String.valueOf(stringBuffer3)));
            this.f22804o.unlock();
            b d6 = this.f22794e.d(str2);
            if (d6 == null) {
                d6 = new b(this);
            }
            b.a a7 = d6.a(str);
            if (a7 != null) {
                a7.f22810a = str;
                d6.f22805a = str2;
                a7.f22811b = stringBuffer3;
                a7.f22812c = strArr2;
                a7.f22813d = str3;
                this.f22794e.a(d6);
            }
            return stringBuffer3;
        } catch (Throwable th) {
            this.f22804o.unlock();
            throw th;
        }
    }

    public void _removePlayTask(String str) {
        this.f22794e.c(str);
    }

    public void addTask(PreloaderURLItem preloaderURLItem) {
        DataLoaderHelper dataLoaderHelper;
        f22787q++;
        if (preloaderURLItem == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] url item invalid");
            return;
        }
        this.f22804o.lock();
        try {
            dataLoaderHelper = this;
        } catch (Throwable th) {
            th = th;
            dataLoaderHelper = this;
        }
        try {
            dataLoaderHelper.a(preloaderURLItem.getKey(), preloaderURLItem.getVideoId(), preloaderURLItem.getPreloadSize(), preloaderURLItem);
            dataLoaderHelper.f22804o.unlock();
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            dataLoaderHelper.f22804o.unlock();
            throw th3;
        }
    }

    public void cancelAllTasks() {
        if (this.f22798i == null || this.f22790a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.f22804o.lock();
        try {
            cancelAllTasksInternal();
            this.f22804o.unlock();
        } catch (Throwable unused) {
            this.f22804o.unlock();
        }
    }

    public void cancelAllTasksInternal() {
        a(this.f22792c);
        a(this.f22791b);
        if (a(this.f22793d)) {
            this.f22798i.cancelAll();
        }
    }

    public void clearAllCaches() {
        if (this.f22790a != 0) {
            return;
        }
        this.f22804o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.f22798i;
            if (aVMDLDataLoader == null) {
                TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            } else {
                aVMDLDataLoader.clearAllCaches();
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void close() {
        this.f22804o.lock();
        try {
            if (this.f22790a == 1) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader not started, not need close");
            } else {
                this.f22798i.close();
                cancelAllTasksInternal();
                this.f22790a = 1;
            }
        } finally {
            this.f22804o.unlock();
        }
    }

    public DataLoaderCacheInfo getCacheInfoByFilePath(String str, String str2) {
        this.f22804o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.f22798i;
            if (aVMDLDataLoader != null) {
                DataLoaderCacheInfo b6 = b(aVMDLDataLoader.getStringCacheInfo(str, str2));
                this.f22804o.unlock();
                return b6;
            }
        } catch (Throwable unused) {
        }
        this.f22804o.unlock();
        return null;
    }

    public long getCacheSize(String str) {
        long j6 = 0;
        if (this.f22790a != 0) {
            return 0L;
        }
        this.f22804o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.f22798i;
            if (aVMDLDataLoader != null) {
                long cacheSize = aVMDLDataLoader.getCacheSize(str);
                if (cacheSize > 0) {
                    j6 = cacheSize;
                }
            }
        } finally {
            try {
                return j6;
            } finally {
            }
        }
        return j6;
    }

    public long getCacheSizeByFilePath(String str, String str2) {
        this.f22804o.lock();
        long j6 = 0;
        try {
            DataLoaderCacheInfo cacheInfoByFilePath = getCacheInfoByFilePath(str, str2);
            if (cacheInfoByFilePath != null) {
                j6 = cacheInfoByFilePath.mCacheSizeFromZero;
            }
        } catch (Throwable unused) {
        }
        this.f22804o.unlock();
        return j6;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int i6, long j6) {
        return 0L;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        String str;
        b b6;
        if (aVMDLDataLoaderNotifyInfo == null) {
            return;
        }
        int i6 = aVMDLDataLoaderNotifyInfo.what;
        if (i6 != 0 && i6 != 15) {
            if (i6 != 20) {
                if (i6 == 3 || i6 == 4) {
                    if (i6 == 4) {
                        f22788r++;
                    }
                    if (aVMDLDataLoaderNotifyInfo.logInfo != null) {
                        long j6 = aVMDLDataLoaderNotifyInfo.parameter;
                        if (j6 != 3) {
                            a(aVMDLDataLoaderNotifyInfo, j6 == 2, i6 == 4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i6 == 7) {
                    f22788r++;
                    if (TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
                        return;
                    }
                    String[] split = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                    if (split.length < 4) {
                        return;
                    }
                    String str2 = split[2];
                    b b7 = this.f22793d.b(str2);
                    this.f22793d.c(str2);
                    c(b7);
                    return;
                }
                if (i6 != 8) {
                    if (i6 != 10 && i6 != 11) {
                        return;
                    }
                }
            }
            if (i6 == 8) {
                f22788r++;
            }
            String str3 = aVMDLDataLoaderNotifyInfo.logInfo;
            if ((str3 == null || aVMDLDataLoaderNotifyInfo.parameter != 3) && str3 != null) {
                TTVideoEngineLog.i("DataLoaderHelper", " task fail log = " + aVMDLDataLoaderNotifyInfo.logInfo + ", code = " + aVMDLDataLoaderNotifyInfo.code + ", task type = " + aVMDLDataLoaderNotifyInfo.parameter);
                String[] split2 = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                if (split2.length > 0 && (b6 = this.f22793d.b((str = split2[0]))) != null) {
                    d dVar = this.f22793d;
                    Error error = new Error(Error.DataLoaderPreload, (int) aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.logInfo);
                    String str4 = TextUtils.isEmpty(b6.f22805a) ? str : b6.f22805a;
                    c loadProgressByRawKey = getLoadProgressByRawKey(str4);
                    if (loadProgressByRawKey == null) {
                        loadProgressByRawKey = new c(this);
                    }
                    loadProgressByRawKey.f22819a = b6.f22805a;
                    loadProgressByRawKey.f22820b = (int) aVMDLDataLoaderNotifyInfo.parameter;
                    loadProgressByRawKey.a(b6);
                    loadProgressByRawKey.a(str, error);
                    putByRawKey(str4, loadProgressByRawKey);
                    if (!loadProgressByRawKey.b() && !loadProgressByRawKey.c()) {
                        loadProgressByRawKey.b();
                        loadProgressByRawKey.c();
                        return;
                    }
                    dVar.c(str);
                    TTVideoEngineLog.i("DataLoaderHelper", "pop all task item. videoId = " + b6.f22805a + " key = " + str);
                    removeLoadProgressByRawKey(str4);
                    if (b6.a() == null || aVMDLDataLoaderNotifyInfo.parameter != 2) {
                        return;
                    }
                    PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                    preLoaderItemCallBackInfo.preloadError = error;
                    preLoaderItemCallBackInfo.loadProgress = loadProgressByRawKey;
                    preLoaderItemCallBackInfo.preloadDataInfo = null;
                    f22789s++;
                    b6.a().preloadItemInfo(preLoaderItemCallBackInfo);
                    return;
                }
                return;
            }
            return;
        }
        VideoEventEngineUploader videoEventEngineUploader = this.f22800k;
        if (videoEventEngineUploader != null) {
            videoEventEngineUploader.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
        }
    }

    public void setContext(Context context) {
        this.f22804o.lock();
        this.f22804o.unlock();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x006e -> B:16:0x0071). Please report as a decompilation issue!!! */
    public void setIntValue(int i6, int i7) {
        this.f22804o.lock();
        try {
            try {
            } catch (Exception e6) {
                vl.j(e6);
            }
            if (i6 == 11) {
                this.f22799j.mPreloadParallelNum = i7;
                AVMDLDataLoader aVMDLDataLoader = this.f22798i;
                if (aVMDLDataLoader != null) {
                    aVMDLDataLoader.setIntValue(102, i7);
                }
            } else if (i6 != 512) {
                boolean z5 = true;
                if (i6 == 1005) {
                    if (i7 != 1) {
                        z5 = false;
                    }
                    this.f22802m = z5;
                    TTVideoEngineLog.i("DataLoaderHelper", "config DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE: " + this.f22802m);
                } else if (i6 == 1) {
                    this.f22799j.mMaxCacheSize = i7;
                } else if (i6 == 2) {
                    this.f22799j.mRWTimeOut = i7;
                } else {
                    if (i6 != 3) {
                        if (i6 == 4) {
                            this.f22799j.mTryCount = i7;
                        }
                        this.f22804o.unlock();
                    }
                    this.f22799j.mOpenTimeOut = i7;
                }
            } else {
                this.f22799j.mAlogEnable = i7;
                AVMDLDataLoader aVMDLDataLoader2 = this.f22798i;
                if (aVMDLDataLoader2 != null) {
                    aVMDLDataLoader2.setIntValue(AVMDLDataLoader.KeyIsAlogEnable, i7);
                }
            }
            this.f22804o.unlock();
        } catch (Throwable th) {
            this.f22804o.unlock();
            throw th;
        }
    }

    public void setStringValue(int i6, String str) {
        this.f22804o.lock();
        if (i6 == 0) {
            try {
                this.f22799j.mCacheDir = str;
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f22804o.unlock();
                throw th;
            }
        }
        this.f22804o.unlock();
    }

    public void start() {
        this.f22804o.lock();
        try {
            if (this.f22790a == 0) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader has started not need start");
            } else {
                if (!d()) {
                    throw new Exception("init data loader fail");
                }
                this.f22792c.a(4L);
                if (this.f22799j == null) {
                    this.f22799j = AVMDLDataLoaderConfigure.getDefaultonfigure();
                }
                if (this.f22800k != null) {
                    this.f22799j.mEnableReportTaskLog = 1;
                }
                this.f22798i.setConfigure(this.f22799j);
                if (this.f22798i.start() < 0) {
                    throw new Exception("start data loader fail");
                }
                if (this.f22798i.getLongValue(AVMDLDataLoader.KeyIsGetMdlProtocolHandle) == -1) {
                    this.f22801l = true;
                }
                this.f22790a = 0;
            }
        } finally {
            this.f22804o.unlock();
        }
    }

    private DataLoaderHelper() {
        a aVar = null;
        this.f22791b = new d(this, aVar);
        this.f22792c = new d(this, aVar);
        this.f22793d = new d(this, aVar);
        this.f22794e = new d(this, aVar);
    }

    private void a() {
        if (this.f22798i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        b a6 = this.f22791b.a();
        if (a6 != null && this.f22792c.a(a6)) {
            this.f22791b.c();
            if (a6.f22807c != null) {
                b(a6);
            }
        }
    }

    private void b(b bVar) {
        if (bVar == null) {
            a();
            return;
        }
        if (this.f22798i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        this.f22792c.b(bVar);
        long j6 = bVar.f22806b;
        PreloaderURLItem preloaderURLItem = bVar.f22807c;
        if (preloaderURLItem != null && preloaderURLItem.getUrls() != null && bVar.f22807c.getUrls().length > 0) {
            b.a aVar = bVar.f22809e.get(0);
            aVar.f22812c = bVar.f22807c.getUrls();
            aVar.f22816g = bVar.f22806b;
            aVar.f22813d = bVar.f22807c.getFilePath();
            a(bVar, aVar);
        }
        if (bVar.a() != null) {
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(6);
            preLoaderItemCallBackInfo.preloadType = 0;
            preLoaderItemCallBackInfo.videoPreloadSize = j6;
            preLoaderItemCallBackInfo.audioPreloadSize = 0L;
            bVar.a().preloadItemInfo(preLoaderItemCallBackInfo);
            TTVideoEngineLog.i("DataLoaderHelper", "[preload] notify info. type = 0");
        }
        a();
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith(MDL_PREFIX) || lowerCase.startsWith("file://") || lowerCase.startsWith("/") || lowerCase.endsWith(".mpd") || lowerCase.contains(".mpd?")) ? false : true;
    }

    public static String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String encodeUrlByQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String queryComponentEncode = AVMDLDataLoader.queryComponentEncode(str);
            if (TextUtils.isEmpty(queryComponentEncode)) {
                return URLEncoder.encode(str, "UTF-8");
            }
            return queryComponentEncode;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public void _addEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f22797h.lock();
            ArrayList<TTVideoEngine> arrayList = this.f22796g.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f22796g.put(str, arrayList);
            }
            if (!arrayList.contains(tTVideoEngine)) {
                arrayList.add(tTVideoEngine);
                TTVideoEngineLog.i("DataLoaderHelper", "add engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
            }
            this.f22797h.unlock();
        } catch (Throwable th) {
            this.f22797h.unlock();
            throw th;
        }
    }

    public void _removeEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f22797h.lock();
            ArrayList<TTVideoEngine> arrayList = this.f22796g.get(str);
            if (arrayList != null) {
                arrayList.remove(tTVideoEngine);
                TTVideoEngineLog.i("DataLoaderHelper", "remove engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
                if (arrayList.size() == 0) {
                    this.f22796g.remove(str);
                }
            }
        } finally {
            this.f22797h.unlock();
        }
    }

    public void cancelTask(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f22798i != null && this.f22790a == 0) {
            this.f22804o.lock();
            try {
                b c6 = this.f22791b.c(str);
                if (c6 == null && (c6 = this.f22792c.c(str)) == null) {
                    c6 = this.f22793d.c(str);
                    if (c6 != null) {
                        this.f22798i.cancel(str);
                    }
                    TTVideoEngineLog.i("DataLoaderHelper", "[preload] cancel preload task. key = ".concat(String.valueOf(str)));
                    this.f22804o.unlock();
                    return;
                }
                c(c6);
                TTVideoEngineLog.i("DataLoaderHelper", "[preload] cancel preload task. key = ".concat(String.valueOf(str)));
                this.f22804o.unlock();
                return;
            } catch (Throwable unused) {
                this.f22804o.unlock();
                return;
            }
        }
        TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
    }

    public c getLoadProgressByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] get, param is invalid key is null");
            return null;
        }
        return this.f22795f.get(str);
    }

    public void notifyPreloadError(PreloaderURLItem preloaderURLItem, int i6) {
        IPreLoaderItemCallBackListener callBackListener = preloaderURLItem.getCallBackListener();
        if (callBackListener != null) {
            f22789s++;
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
            preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i6);
            callBackListener.preloadItemInfo(preLoaderItemCallBackInfo);
        }
    }

    public void putByRawKey(String str, c cVar) {
        if (!TextUtils.isEmpty(str) && cVar != null) {
            this.f22795f.put(str, cVar);
        } else {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] param is invalid");
        }
    }

    public void removeCacheFile(String str, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f22804o.lock();
        try {
            if (this.f22798i == null) {
                TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            } else {
                TTVideoEngineLog.i("DataLoaderHelper", "remove mdl file. key ".concat(String.valueOf(str)));
                if (z5) {
                    this.f22798i.forceRemoveFileCache(str);
                } else {
                    this.f22798i.removeFileCache(str);
                }
            }
        } catch (Throwable unused) {
        }
        this.f22804o.unlock();
    }

    public void removeLoadProgressByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] remove, param is invalid key is null");
        } else {
            this.f22795f.remove(str);
        }
    }

    public void setCacheInfoLists(String[] strArr, long[] jArr) {
        Arrays.toString(strArr);
        Arrays.toString(jArr);
        this.f22804o.lock();
        try {
            this.f22799j.setCacheInfoList(strArr, jArr);
        } finally {
            this.f22804o.unlock();
        }
    }

    private void a(b bVar) {
        ArrayList<b> d6 = this.f22794e.d();
        for (int i6 = 0; i6 < d6.size(); i6++) {
            b bVar2 = d6.get(i6);
            if (!TextUtils.isEmpty(bVar2.f22805a) && !TextUtils.isEmpty(bVar.f22805a) && bVar2.f22805a.equals(bVar.f22805a)) {
                return;
            }
        }
        ArrayList<TTVideoEngine> a6 = a(bVar.f22805a);
        if (a6 == null || a6.size() == 0) {
            return;
        }
        for (int i7 = 0; i7 < a6.size(); i7++) {
            a6.get(i7).a();
        }
    }

    private void a(b bVar, b.a aVar) {
        if (bVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. item is null");
            return;
        }
        if (aVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. track is null");
            notifyPreloadError(bVar.f22807c, -100004);
            return;
        }
        TTVideoEngineLog.i("DataLoaderHelper", "[preload] start mdl preload task.  key = " + aVar.f22810a);
        String str = aVar.f22810a;
        String[] strArr = aVar.f22812c;
        if (strArr != null) {
            String a6 = a(str, bVar.f22805a, aVar.f22815f, 0L, strArr, aVar.f22813d);
            aVar.f22811b = a6;
            if (!TextUtils.isEmpty(a6)) {
                this.f22793d.a(bVar);
                if (aVar.f22815f > 0) {
                    long j6 = aVar.f22814e;
                    if (j6 > 0) {
                        this.f22798i.preloadResource(aVar.f22811b, (int) j6);
                    }
                    this.f22798i.preloadResource(aVar.f22811b, (int) aVar.f22815f, (int) aVar.f22816g);
                } else {
                    this.f22798i.preloadResource(aVar.f22811b, (int) aVar.f22816g);
                }
                TTVideoEngineLog.i("DataLoaderHelper", String.format("[preload] exect preload task ,key is %s; videoId = %s", aVar.f22810a, bVar.f22805a));
                return;
            }
        }
        bVar.a(-100001);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0090 A[Catch: Exception -> 0x011c, TryCatch #0 {Exception -> 0x011c, blocks: (B:9:0x001d, B:13:0x003c, B:14:0x0048, B:15:0x004c, B:19:0x0050, B:22:0x005a, B:24:0x0062, B:25:0x006f, B:26:0x008a, B:28:0x0090, B:29:0x0096, B:32:0x00a2, B:34:0x00a8, B:35:0x00ad, B:38:0x00b6, B:43:0x00c8, B:44:0x00cb, B:46:0x00d0, B:47:0x00d3, B:50:0x00db, B:54:0x00a0, B:55:0x0072, B:57:0x007a, B:58:0x0087), top: B:8:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8 A[Catch: Exception -> 0x011c, TryCatch #0 {Exception -> 0x011c, blocks: (B:9:0x001d, B:13:0x003c, B:14:0x0048, B:15:0x004c, B:19:0x0050, B:22:0x005a, B:24:0x0062, B:25:0x006f, B:26:0x008a, B:28:0x0090, B:29:0x0096, B:32:0x00a2, B:34:0x00a8, B:35:0x00ad, B:38:0x00b6, B:43:0x00c8, B:44:0x00cb, B:46:0x00d0, B:47:0x00d3, B:50:0x00db, B:54:0x00a0, B:55:0x0072, B:57:0x007a, B:58:0x0087), top: B:8:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8 A[Catch: Exception -> 0x011c, TryCatch #0 {Exception -> 0x011c, blocks: (B:9:0x001d, B:13:0x003c, B:14:0x0048, B:15:0x004c, B:19:0x0050, B:22:0x005a, B:24:0x0062, B:25:0x006f, B:26:0x008a, B:28:0x0090, B:29:0x0096, B:32:0x00a2, B:34:0x00a8, B:35:0x00ad, B:38:0x00b6, B:43:0x00c8, B:44:0x00cb, B:46:0x00d0, B:47:0x00d3, B:50:0x00db, B:54:0x00a0, B:55:0x0072, B:57:0x007a, B:58:0x0087), top: B:8:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0 A[Catch: Exception -> 0x011c, TryCatch #0 {Exception -> 0x011c, blocks: (B:9:0x001d, B:13:0x003c, B:14:0x0048, B:15:0x004c, B:19:0x0050, B:22:0x005a, B:24:0x0062, B:25:0x006f, B:26:0x008a, B:28:0x0090, B:29:0x0096, B:32:0x00a2, B:34:0x00a8, B:35:0x00ad, B:38:0x00b6, B:43:0x00c8, B:44:0x00cb, B:46:0x00d0, B:47:0x00d3, B:50:0x00db, B:54:0x00a0, B:55:0x0072, B:57:0x007a, B:58:0x0087), top: B:8:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0 A[Catch: Exception -> 0x011c, TryCatch #0 {Exception -> 0x011c, blocks: (B:9:0x001d, B:13:0x003c, B:14:0x0048, B:15:0x004c, B:19:0x0050, B:22:0x005a, B:24:0x0062, B:25:0x006f, B:26:0x008a, B:28:0x0090, B:29:0x0096, B:32:0x00a2, B:34:0x00a8, B:35:0x00ad, B:38:0x00b6, B:43:0x00c8, B:44:0x00cb, B:46:0x00d0, B:47:0x00d3, B:50:0x00db, B:54:0x00a0, B:55:0x0072, B:57:0x007a, B:58:0x0087), top: B:8:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.DataLoaderHelper.a(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo, boolean, boolean):void");
    }

    private void a(String str, String str2, long j6, PreloaderURLItem preloaderURLItem) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] key invalid.");
            notifyPreloadError(preloaderURLItem, -100001);
            return;
        }
        if (this.f22798i == null || this.f22790a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            notifyPreloadError(preloaderURLItem, -100002);
        } else {
            if (this.f22792c.a(str) || this.f22791b.a(str)) {
                notifyPreloadError(preloaderURLItem, -100003);
                return;
            }
            b bVar = new b(this);
            bVar.a(str, j6);
            bVar.f22805a = str2;
            bVar.f22807c = preloaderURLItem;
            this.f22791b.a(bVar);
            a();
        }
    }

    private boolean a(d dVar) {
        boolean z5 = false;
        if (dVar.b() > 0) {
            while (true) {
                b c6 = dVar.c();
                if (c6 == null) {
                    break;
                }
                c(c6);
                z5 = true;
            }
        }
        return z5;
    }

    private String[] a(String[] strArr) {
        if (strArr == null || strArr.length <= 1) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr[0]);
        for (int i6 = 1; i6 < strArr.length; i6++) {
            String str = strArr[i6];
            Boolean bool = Boolean.TRUE;
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                if (((String) arrayList.get(size)).equals(str)) {
                    bool = Boolean.FALSE;
                    break;
                }
                size--;
            }
            if (bool.booleanValue()) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        return strArr2;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener
    public void onStartComplete() {
    }
}
