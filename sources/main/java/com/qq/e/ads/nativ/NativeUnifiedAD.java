package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* renamed from: h, reason: collision with root package name */
    private AdListenerAdapter f36656h;

    /* renamed from: i, reason: collision with root package name */
    private NativeADUnifiedListener f36657i;

    /* renamed from: j, reason: collision with root package name */
    private List<Integer> f36658j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private List<String> f36659k;

    /* renamed from: l, reason: collision with root package name */
    private volatile int f36660l;

    /* renamed from: m, reason: collision with root package name */
    private volatile int f36661m;

    /* renamed from: n, reason: collision with root package name */
    private String f36662n;

    /* renamed from: o, reason: collision with root package name */
    private LoadAdParams f36663o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class AdListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NativeADUnifiedListener f36664a;

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.f36664a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.f36664a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                }
                this.f36664a.onADLoaded(arrayList);
            }
        }

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f36664a = nativeADUnifiedListener;
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f36657i = nativeADUnifiedListener;
        this.f36656h = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NUADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f36656h);
    }

    public void loadData(int i6) {
        a(i6, true);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f36657i = nativeADUnifiedListener;
        this.f36656h = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void a(int i6, boolean z5) {
        if (a()) {
            if (!b()) {
                if (z5) {
                    this.f36658j.add(Integer.valueOf(i6));
                    return;
                }
                return;
            }
            T t5 = this.f36545a;
            if (t5 != 0) {
                LoadAdParams loadAdParams = this.f36663o;
                NUADI nuadi = (NUADI) t5;
                if (loadAdParams != null) {
                    nuadi.loadData(i6, loadAdParams);
                } else {
                    nuadi.loadData(i6);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i6) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f36657i;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i6));
        }
    }

    public String getAdNetWorkName() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((NUADI) t5).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i6, LoadAdParams loadAdParams) {
        this.f36663o = loadAdParams;
        loadData(i6);
    }

    public void setCategories(List<String> list) {
        this.f36659k = list;
        T t5 = this.f36545a;
        if (t5 == 0 || list == null) {
            return;
        }
        ((NUADI) t5).setCategories(list);
    }

    public void setMaxVideoDuration(int i6) {
        this.f36661m = i6;
        if (this.f36661m > 0 && this.f36660l > this.f36661m) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NUADI) t5).setMaxVideoDuration(this.f36661m);
        }
    }

    public void setMinVideoDuration(int i6) {
        this.f36660l = i6;
        if (this.f36661m > 0 && this.f36660l > this.f36661m) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NUADI) t5).setMinVideoDuration(this.f36660l);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.f36662n = str;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NUADI) t5).setVastClassName(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        super.a((NativeUnifiedAD) nuadi);
        nuadi.setMinVideoDuration(this.f36660l);
        nuadi.setMaxVideoDuration(this.f36661m);
        nuadi.setVastClassName(this.f36662n);
        List<String> list = this.f36659k;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f36658j.iterator();
        while (it.hasNext()) {
            a(it.next().intValue(), false);
        }
    }
}
