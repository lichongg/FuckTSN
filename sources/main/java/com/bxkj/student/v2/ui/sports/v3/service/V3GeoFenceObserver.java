package com.bxkj.student.v2.ui.sports.v3.service;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceClient;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonOptions;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.R;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.utils.d0;
import com.bxkj.student.v2.ui.sports.v3.V3ThreeTwoOneActivity;
import com.bxkj.student.v2.ui.sports.v3.service.l;
import com.bxkj.student.v2.vm.sports.SportsVM;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3GeoFenceObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3GeoFenceObserver.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3GeoFenceObserver\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,198:1\n1878#2,2:199\n1563#2:201\n1634#2,3:202\n1563#2:205\n1634#2,3:206\n1880#2:209\n*S KotlinDebug\n*F\n+ 1 V3GeoFenceObserver.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3GeoFenceObserver\n*L\n70#1:199,2\n71#1:201\n71#1:202,3\n80#1:205\n80#1:206,3\n70#1:209\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3GeoFenceObserver implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final FragmentActivity f21907a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private SportsVM f21908b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final AMap f21909c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private GeoFenceClient f21910d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Map<String, Boolean> f21911e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Intent f21912f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final String f21913g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final BroadcastReceiver f21914h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f21915i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private iOSOneButtonDialog f21916j;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(List list, int i6, String str) {
        if (i6 == 0) {
            com.orhanobut.logger.j.d("添加跑步范围围栏成功!!", new Object[0]);
        } else {
            com.orhanobut.logger.j.d("添加跑步范围围栏失败!!", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(boolean z5) {
        iOSOneButtonDialog iosonebuttondialog = null;
        if (z5 && this.f21915i) {
            com.orhanobut.logger.j.d("ActionStatus=在地理围栏里面", new Object[0]);
            com.bxkj.student.v2.common.data.i.f20657a.b0(false);
            d0.e().l(this.f21907a, f0.U(Integer.valueOf(R.raw.geofence_in)));
            iOSOneButtonDialog iosonebuttondialog2 = this.f21916j;
            if (iosonebuttondialog2 != null) {
                if (iosonebuttondialog2.isShowing()) {
                    iosonebuttondialog2.dismiss();
                } else {
                    Activity q5 = cn.bluemobi.dylan.base.utils.a.n().q();
                    if (q5 != null) {
                        if (q5 instanceof V3ThreeTwoOneActivity) {
                            Activity r5 = cn.bluemobi.dylan.base.utils.a.n().r();
                            if (r5 != null) {
                                iosonebuttondialog = ContextExtKt.m(r5, "您已进入跑步规定区域，跑步已恢复，请继续进行跑步！");
                            }
                        } else {
                            iosonebuttondialog = ContextExtKt.m(q5, "您已进入跑步规定区域，跑步已恢复，请继续进行跑步！");
                        }
                        this.f21916j = iosonebuttondialog;
                    }
                    l.a.h(l.f22009a, this.f21907a, "您已进入跑步规定区域，跑步已恢复，请继续进行跑步！", false, 4, null);
                }
            }
        } else if (!z5 && !this.f21915i) {
            com.orhanobut.logger.j.d("ActionStatus=在地理围栏外面", new Object[0]);
            com.bxkj.student.v2.common.data.i.f20657a.b0(true);
            d0.e().l(this.f21907a, f0.U(Integer.valueOf(R.raw.geofence_out)));
            Object systemService = this.f21907a.getSystemService("vibrator");
            g0.n(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(2000L);
            iOSOneButtonDialog iosonebuttondialog3 = this.f21916j;
            if (iosonebuttondialog3 != null) {
                iosonebuttondialog3.dismiss();
            }
            Activity q6 = cn.bluemobi.dylan.base.utils.a.n().q();
            if (q6 != null) {
                if (q6 instanceof V3ThreeTwoOneActivity) {
                    Activity r6 = cn.bluemobi.dylan.base.utils.a.n().r();
                    if (r6 != null) {
                        iosonebuttondialog = ContextExtKt.m(r6, "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！");
                    }
                } else {
                    iosonebuttondialog = ContextExtKt.m(q6, "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！");
                }
                this.f21916j = iosonebuttondialog;
            }
            l.a.h(l.f22009a, this.f21907a, "您已偏离跑步规定区域，跑步已暂停，请在规定区域内进行跑步！", false, 4, null);
        }
        this.f21915i = !z5;
    }

    public V3GeoFenceObserver(@NotNull FragmentActivity mActivity, @NotNull SportsVM mViewModel, @NotNull AMap aMap) {
        g0.p(mActivity, "mActivity");
        g0.p(mViewModel, "mViewModel");
        g0.p(aMap, "aMap");
        this.f21907a = mActivity;
        this.f21908b = mViewModel;
        this.f21909c = aMap;
        this.f21911e = new LinkedHashMap();
        this.f21913g = RunningActivity.f19690z1;
        this.f21914h = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.service.V3GeoFenceObserver$mGeoFenceBoundsReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Map map;
                Map map2;
                Map map3;
                g0.p(context, "context");
                g0.p(intent, "intent");
                if (g0.g(intent.getAction(), V3GeoFenceObserver.this.g())) {
                    Bundle extras = intent.getExtras();
                    Integer valueOf = extras != null ? Integer.valueOf(extras.getInt("event")) : null;
                    String string = extras != null ? extras.getString(GeoFence.BUNDLE_KEY_CUSTOMID) : null;
                    if (string != null) {
                        V3GeoFenceObserver v3GeoFenceObserver = V3GeoFenceObserver.this;
                        map = v3GeoFenceObserver.f21911e;
                        boolean z5 = false;
                        map.put(string, Boolean.valueOf(valueOf != null && valueOf.intValue() == 1));
                        map2 = v3GeoFenceObserver.f21911e;
                        for (String str : map2.keySet()) {
                            map3 = v3GeoFenceObserver.f21911e;
                            if (g0.g(map3.get(str), Boolean.TRUE)) {
                                z5 = true;
                            }
                        }
                        v3GeoFenceObserver.k(z5);
                    }
                }
            }
        };
    }

    private final void d(List<? extends List<? extends Map<String, ? extends Object>>> list) {
        int i6 = 0;
        for (Object obj : list) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                f0.b0();
            }
            List list2 = (List) obj;
            GeoFenceClient geoFenceClient = this.f21910d;
            if (geoFenceClient != null) {
                List list3 = list2;
                ArrayList arrayList = new ArrayList(f0.d0(list3, 10));
                for (Iterator it = list3.iterator(); it.hasNext(); it = it) {
                    Map<String, ? extends Object> map = (Map) it.next();
                    c0 c0Var = c0.f16887a;
                    arrayList.add(new DPoint(Double.parseDouble(c0Var.t(map, com.umeng.analytics.pro.d.C)), Double.parseDouble(c0Var.t(map, com.umeng.analytics.pro.d.D))));
                }
                geoFenceClient.addGeoFence(arrayList, "runGeoFenceId" + i6);
            }
            this.f21911e.put("runGeoFenceId" + i6, Boolean.TRUE);
            List<Map<String, ? extends Object>> list4 = list2;
            ArrayList arrayList2 = new ArrayList(f0.d0(list4, 10));
            for (Map<String, ? extends Object> map2 : list4) {
                c0 c0Var2 = c0.f16887a;
                arrayList2.add(new LatLng(Double.parseDouble(c0Var2.t(map2, com.umeng.analytics.pro.d.C)), Double.parseDouble(c0Var2.t(map2, com.umeng.analytics.pro.d.D))));
            }
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.addAll(arrayList2);
            polygonOptions.fillColor(ContextCompat.getColor(this.f21907a, R.color.fill));
            polygonOptions.strokeColor(ContextCompat.getColor(this.f21907a, R.color.stroke));
            polygonOptions.strokeWidth(4.0f);
            this.f21909c.addPolygon(polygonOptions);
            i6 = i7;
        }
        GeoFenceListener geoFenceListener = new GeoFenceListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.a
            @Override // com.amap.api.fence.GeoFenceListener
            public final void onGeoFenceCreateFinished(List list5, int i8, String str) {
                V3GeoFenceObserver.e(list5, i8, str);
            }
        };
        GeoFenceClient geoFenceClient2 = this.f21910d;
        if (geoFenceClient2 != null) {
            geoFenceClient2.setGeoFenceListener(geoFenceListener);
        }
        GeoFenceClient geoFenceClient3 = this.f21910d;
        if (geoFenceClient3 != null) {
            geoFenceClient3.createPendingIntent(this.f21913g);
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(this.f21913g);
        this.f21912f = this.f21907a.registerReceiver(this.f21914h, intentFilter);
    }

    @NotNull
    public final AMap f() {
        return this.f21909c;
    }

    @NotNull
    public final String g() {
        return this.f21913g;
    }

    @NotNull
    public final FragmentActivity h() {
        return this.f21907a;
    }

    @NotNull
    public final SportsVM i() {
        return this.f21908b;
    }

    public final void j(@NotNull SportsVM sportsVM) {
        g0.p(sportsVM, "<set-?>");
        this.f21908b = sportsVM;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        GeoFenceClient geoFenceClient = new GeoFenceClient(this.f21907a);
        geoFenceClient.setActivateAction(3);
        this.f21910d = geoFenceClient;
        com.orhanobut.logger.j.d("V3GeoFenceObserver->mViewModel.sportsSetMap=" + this.f21908b.M(), new Object[0]);
        if (this.f21908b.M().containsKey("geofence")) {
            c0 c0Var = c0.f16887a;
            d(c0Var.y(c0Var.t(this.f21908b.M(), "geofence")));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        GeoFenceClient geoFenceClient = this.f21910d;
        if (geoFenceClient != null) {
            g0.m(geoFenceClient);
            geoFenceClient.removeGeoFence();
        }
        if (this.f21912f != null) {
            this.f21907a.unregisterReceiver(this.f21914h);
        }
    }
}
