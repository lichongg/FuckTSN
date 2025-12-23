package cn.jiguang.g;

import android.os.Bundle;
import androidx.core.view.PointerIconCompat;
import cn.jiguang.bb.f;
import com.amap.api.services.core.AMapException;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.kwad.library.solder.lib.ext.PluginError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f2966a = "DISABLE_DATA";

    /* renamed from: b, reason: collision with root package name */
    public static String f2967b = "ENABLE_DATA";

    /* renamed from: c, reason: collision with root package name */
    private static String f2968c = "JDataUserControl";

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Integer, Object> f2969d;

    /* renamed from: cn.jiguang.g.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f2970a = new c(null);
    }

    private c() {
        this.f2969d = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(2000);
        arrayList.add(3000);
        arrayList.add(1000);
        this.f2969d.put(Integer.valueOf(AVMDLDataLoader.KeyIsIsTestSpeedVersion), arrayList);
        ArrayList arrayList2 = new ArrayList();
        Integer valueOf = Integer.valueOf(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW);
        arrayList2.add(valueOf);
        this.f2969d.put(2400, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(2001);
        arrayList3.add(3001);
        arrayList3.add(1001);
        this.f2969d.put(1100, arrayList3);
        this.f2969d.put(Integer.valueOf(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR), arrayList3);
        this.f2969d.put(1104, arrayList3);
        this.f2969d.put(1112, arrayList3);
        this.f2969d.put(1110, arrayList3);
        this.f2969d.put(Integer.valueOf(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT), arrayList3);
        this.f2969d.put(1013, 3003);
        HashMap<Integer, Object> hashMap = this.f2969d;
        Integer valueOf2 = Integer.valueOf(PluginError.ERROR_UPD_FILE_NOT_FOUND);
        hashMap.put(valueOf2, 3003);
        this.f2969d.put(valueOf, 3004);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(3005);
        Integer valueOf3 = Integer.valueOf(PluginError.ERROR_UPD_REQUEST);
        arrayList4.add(valueOf3);
        this.f2969d.put(Integer.valueOf(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW), arrayList4);
        HashMap<Integer, Object> hashMap2 = this.f2969d;
        Integer valueOf4 = Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_SETISSTIMAP);
        hashMap2.put(valueOf4, arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(1009);
        Integer valueOf5 = Integer.valueOf(PluginError.ERROR_UPD_CAPACITY);
        arrayList5.add(valueOf5);
        arrayList5.add(Integer.valueOf(PluginError.ERROR_INS_INSTALL_PATH));
        this.f2969d.put(1009, arrayList5);
        this.f2969d.put(valueOf3, arrayList5);
        this.f2969d.put(Integer.valueOf(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), 3007);
        this.f2969d.put(1011, 3008);
        HashMap<Integer, Object> hashMap3 = this.f2969d;
        Integer valueOf6 = Integer.valueOf(PluginError.ERROR_UPD_NO_DOWNLOADER);
        hashMap3.put(valueOf6, 3008);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(valueOf2);
        arrayList6.add(3009);
        arrayList6.add(1005);
        HashMap<Integer, Object> hashMap4 = this.f2969d;
        Integer valueOf7 = Integer.valueOf(PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD);
        hashMap4.put(valueOf7, arrayList6);
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(2003);
        arrayList7.add(3010);
        arrayList7.add(1012);
        this.f2969d.put(Integer.valueOf(AVMDLDataLoader.KeyIsIsEncryptVersion), arrayList7);
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(1006);
        arrayList8.add(2010);
        arrayList8.add(3011);
        this.f2969d.put(1608, arrayList8);
        ArrayList arrayList9 = new ArrayList();
        Integer valueOf8 = Integer.valueOf(PluginError.ERROR_UPD_EXTRACT);
        arrayList9.add(valueOf8);
        arrayList9.add(3012);
        arrayList9.add(1007);
        this.f2969d.put(1601, arrayList9);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(1008);
        arrayList10.add(Integer.valueOf(GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE));
        arrayList10.add(3013);
        this.f2969d.put(1501, arrayList10);
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(valueOf7);
        arrayList11.add(3014);
        arrayList11.add(1003);
        this.f2969d.put(valueOf8, arrayList11);
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(valueOf6);
        arrayList12.add(3015);
        arrayList12.add(1004);
        this.f2969d.put(1012, arrayList12);
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(3016);
        arrayList13.add(1010);
        arrayList13.add(valueOf4);
        this.f2969d.put(valueOf5, arrayList13);
        ArrayList arrayList14 = new ArrayList();
        arrayList14.add(3017);
        arrayList14.add(1011);
        arrayList14.add(Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_MAPMODESTATE));
        this.f2969d.put(Integer.valueOf(AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL), arrayList14);
        b.a();
    }

    public static c a() {
        return a.f2970a;
    }

    public synchronized boolean b(int i6) {
        try {
            if (!this.f2969d.containsKey(Integer.valueOf(i6))) {
                return false;
            }
            Object obj = this.f2969d.get(Integer.valueOf(i6));
            if (!b.a(obj)) {
                return false;
            }
            if (!(obj instanceof List)) {
                return b.f2958e.contains(obj);
            }
            new ArrayList(b.f2958e).retainAll((List) obj);
            return !r1.isEmpty();
        } catch (Throwable th) {
            f.c("JDataConfigManager", "isContainDisableDatas throwable=" + th);
            return false;
        }
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public synchronized void a(Bundle bundle) {
        f.c(f2968c, "updateCollectConfig bundle=" + bundle);
        if (bundle != null) {
            try {
            } catch (Throwable th) {
                f.c(f2968c, "updateCollectConfig throwable=" + th);
            }
            if (bundle.size() != 0) {
                b.a((ArrayList) bundle.getSerializable(f2966a), (ArrayList) bundle.getSerializable(f2967b));
                f.c(f2968c, "updateCollectConfig mDisableDatas=" + b.f2958e);
                f.c(f2968c, "updateCollectConfig mEnableDatas=" + b.f2957d);
            }
        }
    }

    public synchronized boolean a(int i6) {
        try {
            if (!this.f2969d.containsKey(Integer.valueOf(i6))) {
                return false;
            }
            Object obj = this.f2969d.get(Integer.valueOf(i6));
            if (!b.a(obj)) {
                return false;
            }
            if (!(obj instanceof List)) {
                return b.f2957d.contains(obj);
            }
            new ArrayList(b.f2957d).retainAll((List) obj);
            return !r1.isEmpty();
        } catch (Throwable unused) {
            return false;
        }
    }
}
