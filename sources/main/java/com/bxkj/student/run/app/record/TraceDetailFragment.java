package com.bxkj.student.run.app.record;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.amap.api.fence.GeoFence;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.bxkj.student.R;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.record.TraceDetailFragment;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.bxkj.student.run.app.utils.p;
import com.bxkj.student.run.app.utils.q;
import com.bxkj.student.run.app.vm.RunVM;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class TraceDetailFragment extends BaseFragment {
    private Polyline C;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f19989j;

    /* renamed from: k, reason: collision with root package name */
    private LinearLayout f19990k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f19991l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f19992m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f19993n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f19994o;

    /* renamed from: p, reason: collision with root package name */
    private TextureMapView f19995p;

    /* renamed from: q, reason: collision with root package name */
    private AMap f19996q;

    /* renamed from: r, reason: collision with root package name */
    private RecordPathView f19997r;

    /* renamed from: s, reason: collision with root package name */
    private RunVM f19998s;

    /* renamed from: t, reason: collision with root package name */
    private String f19999t;

    /* renamed from: u, reason: collision with root package name */
    private String f20000u;

    /* renamed from: v, reason: collision with root package name */
    private List<List<Map<String, Object>>> f20001v;

    /* renamed from: w, reason: collision with root package name */
    private Bundle f20002w;

    /* renamed from: z, reason: collision with root package name */
    private Polyline f20005z;

    /* renamed from: x, reason: collision with root package name */
    private List<LatLng> f20003x = new ArrayList();

    /* renamed from: y, reason: collision with root package name */
    private PolylineOptions f20004y = new PolylineOptions();
    private List<Integer> A = new ArrayList();
    private PolylineOptions B = new PolylineOptions();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements AMap.OnMapScreenShotListener {
        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap, int i6) {
        }

        a() {
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap) {
            TraceDetailFragment traceDetailFragment = TraceDetailFragment.this;
            TraceDetailFragment.this.r0(traceDetailFragment.e0(bitmap, traceDetailFragment.d0(traceDetailFragment.f19990k)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements ShareBoardlistener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f20007a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements UMShareListener {
            a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseFragment) TraceDetailFragment.this).f1096g, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseFragment) TraceDetailFragment.this).f1096g, " 分享成功啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t5) {
                t5.printStackTrace();
                Toast.makeText(((BaseFragment) TraceDetailFragment.this).f1096g, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        b(final Bitmap val$bitmap) {
            this.f20007a = val$bitmap;
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            new ShareAction(TraceDetailFragment.this.getActivity()).setPlatform(share_media).setCallback(new a()).withMedia(new UMImage(((BaseFragment) TraceDetailFragment.this).f1096g, this.f20007a)).share();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends TypeReference<List<List<Map<String, Object>>>> {
        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends TypeReference<List<Map<String, Object>>> {
        d() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends TypeReference<List<Map<String, Object>>> {
        e() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements AMap.OnCameraChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f20013a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f20014b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f20015c;

        f(final List val$finalList, final List val$finalOkPointList) {
            this.f20014b = val$finalList;
            this.f20015c = val$finalOkPointList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(List list, List list2) {
            TraceDetailFragment.this.f19997r.e();
            TraceDetailFragment.this.f19997r.setVisibility(8);
            TraceDetailFragment.this.b0(list, list2);
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChangeFinish(CameraPosition cameraPosition) {
            if (this.f20013a) {
                return;
            }
            this.f20013a = true;
            q qVar = new q();
            for (int i6 = 1; i6 < TraceDetailFragment.this.f20003x.size(); i6++) {
                LatLng latLng = (LatLng) TraceDetailFragment.this.f20003x.get(i6 - 1);
                LatLng latLng2 = (LatLng) TraceDetailFragment.this.f20003x.get(i6);
                Point screenLocation = TraceDetailFragment.this.f19996q.getProjection().toScreenLocation(latLng);
                Point screenLocation2 = TraceDetailFragment.this.f19996q.getProjection().toScreenLocation(latLng2);
                int color = ContextCompat.getColor(((BaseFragment) TraceDetailFragment.this).f1096g, 2131100565);
                qVar.a(screenLocation, screenLocation2, color, color);
            }
            TraceDetailFragment.this.f19997r.setPath(qVar);
            RecordPathView recordPathView = TraceDetailFragment.this.f19997r;
            final List list = this.f20014b;
            final List list2 = this.f20015c;
            recordPathView.setOnAnimEnd(new RecordPathView.d() { // from class: com.bxkj.student.run.app.record.o
                @Override // com.bxkj.student.run.app.utils.RecordPathView.d
                public final void a() {
                    TraceDetailFragment.f.this.b(list, list2);
                }
            });
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e0(Bitmap src, Bitmap watermark) {
        if (src == null) {
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        int width2 = watermark.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(width, watermark.getHeight() + height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRGB(255, 255, 255);
        canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(watermark, width - width2, height, (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setTextSize(u.a(20.0f, this.f1096g));
        Rect rect = new Rect();
        String string = getString(2131951695);
        paint.getTextBounds(string, 0, string.length(), rect);
        canvas.drawText(string, 50.0f, 50.0f, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private void j0(LatLng newLatLng, LatLng lastLatLng, float speed, boolean isPause) {
        if (isPause) {
            Polyline polyline = this.C;
            if (polyline != null) {
                polyline.setOptions(this.B.add(newLatLng).width(u.a(5.0f, this.f1096g)).setDottedLine(true).color(ContextCompat.getColor(this.f1096g, 2131099715)).zIndex(u.a(5.0f, this.f1096g)));
                return;
            }
            this.f20004y = null;
            this.f20005z = null;
            this.A = new ArrayList();
            PolylineOptions polylineOptions = new PolylineOptions();
            this.B = polylineOptions;
            this.C = this.f19996q.addPolyline(polylineOptions.add(lastLatLng, newLatLng).width(u.a(5.0f, this.f1096g)).setDottedLine(true).color(ContextCompat.getColor(this.f1096g, 2131099715)).zIndex(u.a(5.0f, this.f1096g)));
            return;
        }
        this.A.add(Integer.valueOf(com.bxkj.student.run.app.utils.i.r(this.f1096g, speed)));
        Polyline polyline2 = this.f20005z;
        if (polyline2 != null) {
            polyline2.setOptions(this.f20004y.add(newLatLng).width(u.a(5.0f, this.f1096g)).colorValues(this.A).useGradient(true).zIndex(u.a(5.0f, this.f1096g)));
            return;
        }
        this.B = null;
        this.C = null;
        PolylineOptions polylineOptions2 = new PolylineOptions();
        this.f20004y = polylineOptions2;
        this.f20005z = this.f19996q.addPolyline(polylineOptions2.add(lastLatLng, newLatLng).width(u.a(5.0f, this.f1096g)).colorValues(this.A).useGradient(true).zIndex(u.a(5.0f, this.f1096g)));
    }

    public String c0(long size) {
        if (size >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return String.format("%.1f GB", Float.valueOf(size / IjkMediaMeta.AV_CH_STEREO_RIGHT));
        }
        if (size >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            float f6 = size / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            return String.format(f6 > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f6));
        }
        if (size < 1024) {
            return String.format("%d B", Long.valueOf(size));
        }
        float f7 = size / 1024;
        return String.format(f7 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f7));
    }

    public Bitmap d0(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(List<Map<String, Object>> list, List<Map<String, Object>> okPointList) {
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            arrayList.add(new LatLngTimeSpeed(JsonParse.getDouble(map, "latitude"), JsonParse.getDouble(map, "longitude"), JsonParse.getLong(map, "time"), JsonParse.getFloat(map, "speed"), JsonParse.getBoolean(map, "puase"), JsonParse.getInt(map, MyLocationStyle.LOCATION_TYPE)));
        }
        com.orhanobut.logger.j.c("优化后距离countDistance=" + i0(arrayList));
        for (Map<String, Object> map2 : okPointList) {
            this.f19996q.addMarker(new MarkerOptions().position(new LatLng(JsonParse.getDouble(map2, "latitude"), JsonParse.getDouble(map2, "longitude"))).icon(BitmapDescriptorFactory.fromResource(R.mipmap.img_point_must_normal)).zIndex(9.0f).draggable(false));
        }
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_end);
        MarkerOptions markerOptions = new MarkerOptions();
        List<LatLng> list2 = this.f20003x;
        this.f19996q.addMarker(markerOptions.position(list2.get(list2.size() - 1)).icon(fromResource).zIndex(9.0f).draggable(true));
    }

    private void f0(GeoFence fence) {
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.fillColor(this.f1096g.getResources().getColor(R.color.fill));
        circleOptions.strokeColor(this.f1096g.getResources().getColor(R.color.stroke));
        circleOptions.strokeWidth(4.0f);
        circleOptions.radius(fence.getRadius());
        DPoint center = fence.getCenter();
        circleOptions.center(new LatLng(center.getLatitude(), center.getLongitude()));
        this.f19996q.addCircle(circleOptions);
    }

    private void g0(List<LatLng> latLngs) {
        this.f19996q.addPolyline(new PolylineOptions().addAll(latLngs).width(u.a(5.0f, this.f1096g)).setDottedLine(true).color(ContextCompat.getColor(this.f1096g, 2131099715)).zIndex(u.a(5.0f, this.f1096g)));
    }

    private float i0(List<LatLngTimeSpeed> latLngTimeSpeedList) {
        com.orhanobut.logger.j.c("抽稀前pathOptimize=" + latLngTimeSpeedList.size() + "    convertFileSize=" + c0(JSON.toJSONString(latLngTimeSpeedList).length()));
        if (latLngTimeSpeedList.size() > 2) {
            com.bxkj.student.run.app.utils.o oVar = new com.bxkj.student.run.app.utils.o();
            oVar.p(1);
            latLngTimeSpeedList = oVar.k(latLngTimeSpeedList);
        }
        com.orhanobut.logger.j.c("抽稀后pathOptimize=" + latLngTimeSpeedList.size() + "    convertFileSize=" + c0(JSON.toJSONString(latLngTimeSpeedList).length()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float f6 = 0.0f;
        boolean z5 = false;
        LatLng latLng = null;
        for (LatLngTimeSpeed latLngTimeSpeed : latLngTimeSpeedList) {
            LatLng latLng2 = new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude());
            arrayList.add(latLng2);
            boolean isPuase = latLngTimeSpeed.isPuase();
            int r5 = com.bxkj.student.run.app.utils.i.r(this.f1096g, latLngTimeSpeed.getSpeed());
            arrayList2.add(Integer.valueOf(r5));
            if (isPuase != z5) {
                k0(arrayList, z5, arrayList2);
                arrayList2.clear();
                arrayList.clear();
                arrayList.add(latLng2);
                arrayList2.add(Integer.valueOf(r5));
            }
            if (latLng != null && !z5) {
                f6 += AMapUtils.calculateLineDistance(latLng, latLng2);
            }
            latLng = latLng2;
            z5 = isPuase;
        }
        k0(arrayList, z5, arrayList2);
        return f6;
    }

    private void k0(List<LatLng> latLngs, boolean isPause, List<Integer> colorValues) {
        if (isPause) {
            g0(latLngs);
        } else {
            m0(latLngs, colorValues);
        }
    }

    private void l0(List<List<DPoint>> pointList) {
        if (pointList == null || pointList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<DPoint> list : pointList) {
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                PolygonOptions polygonOptions = new PolygonOptions();
                for (DPoint dPoint : list) {
                    arrayList2.add(new LatLng(dPoint.getLatitude(), dPoint.getLongitude()));
                }
                polygonOptions.addAll(arrayList2);
                polygonOptions.fillColor(this.f1096g.getResources().getColor(R.color.fill));
                polygonOptions.strokeColor(this.f1096g.getResources().getColor(R.color.stroke));
                polygonOptions.strokeWidth(4.0f);
                arrayList.add(this.f19996q.addPolygon(polygonOptions));
            }
        }
    }

    private void m0(List<LatLng> latLngs, List<Integer> colorValues) {
        this.f19996q.addPolyline(new PolylineOptions().addAll(latLngs).width(u.a(5.0f, this.f1096g)).colorValues(colorValues).useGradient(true).zIndex(u.a(5.0f, this.f1096g)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 p0(List list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        RunDb runDb = (RunDb) list.get(0);
        long parseLong = Long.parseLong(runDb.getCountTime());
        double parseFloat = Float.parseFloat(runDb.getDistance());
        String a6 = com.bxkj.student.run.app.utils.i.a(parseFloat, parseLong);
        String b6 = com.bxkj.student.run.app.utils.i.b(parseFloat, parseLong);
        this.f19989j.setVisibility(0);
        this.f19991l.setText(a6);
        this.f19993n.setText(b6);
        this.f19992m.setText(com.bxkj.student.run.app.utils.i.g(parseLong));
        this.f19994o.setText(com.bxkj.student.run.app.utils.i.d(parseFloat));
        this.f20000u = runDb.getPassLatLngList();
        this.f19999t = runDb.getLatLngList();
        o0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Bitmap bitmap) {
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new b(bitmap)).open();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        this.f19998s = (RunVM) new ViewModelProvider(this).get(RunVM.class);
        this.f19989j.setVisibility(8);
        if (!getArguments().containsKey("latLngTimeSpeed")) {
            if (getArguments().containsKey("runDataDbId")) {
                this.f19998s.w(getArguments().getString("runDataDbId"), new Function1() { // from class: com.bxkj.student.run.app.record.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 p02;
                        p02 = TraceDetailFragment.this.p0((List) obj);
                        return p02;
                    }
                });
                return;
            }
            return;
        }
        this.f19989j.setVisibility(0);
        this.f19991l.setText(getArguments().getString("speed"));
        this.f19993n.setText(getArguments().getString("peisu"));
        this.f19992m.setText(getArguments().getString("time"));
        this.f19994o.setText(getArguments().getString("distance"));
        this.f20000u = getArguments().getString("okPointList");
        this.f19999t = getArguments().getString("latLngTimeSpeed");
        n0(getArguments().getString("geoFence"));
        o0();
        String string = getArguments().getString("punchCoordinate");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        a0(string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.util.List] */
    public void o0() {
        ArrayList<Map> arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f19999t)) {
            return;
        }
        try {
            arrayList = (List) JSON.parseObject(this.f19999t, new d().getType(), new Feature[0]);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (!TextUtils.isEmpty(this.f20000u)) {
                arrayList2 = (List) JSON.parseObject(this.f20000u, new e().getType(), new Feature[0]);
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (Map map : arrayList) {
            this.f20003x.add(new LatLng(JsonParse.getDouble(map, "latitude"), JsonParse.getDouble(map, "longitude")));
        }
        List<LatLng> list = this.f20003x;
        if (list != null && list.size() > 2) {
            com.orhanobut.logger.j.c("优化前latLngs=" + this.f20003x.size());
            p pVar = new p();
            pVar.p(1);
            List<LatLng> k6 = pVar.k(this.f20003x);
            if (k6 != null && k6.size() > 0) {
                this.f20003x = k6;
            }
            com.orhanobut.logger.j.c("优化后latLngs=" + this.f20003x.size());
        }
        if (this.f20003x.size() == 1) {
            List<LatLng> list2 = this.f20003x;
            list2.add(list2.get(0));
        }
        Marker addMarker = this.f19996q.addMarker(new MarkerOptions().position(this.f20003x.get(0)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_start)).zIndex(9.0f).draggable(true));
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(1000L);
        addMarker.setAnimation(scaleAnimation);
        addMarker.startAnimation();
        this.f19996q.setOnCameraChangeListener(new f(arrayList, arrayList2));
        LatLngBounds.Builder builder = LatLngBounds.builder();
        LatLngBounds build = builder.build();
        Iterator<LatLng> it = this.f20003x.iterator();
        while (it.hasNext()) {
            build = builder.include(it.next()).build();
        }
        this.f19996q.animateCamera(CameraUpdateFactory.newLatLngBounds(build, u.a(50.0f, this.f1096g)), 2000L, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f19995p.onDestroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        this.f19995p.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    protected void q0() {
        this.f19996q.getMapScreenShot(new a());
    }

    private void a0(String punchCoordinate) {
        ArrayMap<String, Object> jsonToMap = JsonParse.jsonToMap(punchCoordinate);
        Map<String, Object> map = JsonParse.getMap(jsonToMap, "first");
        Map<String, Object> map2 = JsonParse.getMap(jsonToMap, "success");
        if (map.containsKey("latitude") && map.containsKey("longitude")) {
            this.f19996q.addMarker(new MarkerOptions().position(new LatLng(JsonParse.getDouble(map, "latitude"), JsonParse.getDouble(map, "longitude"))).icon(BitmapDescriptorFactory.fromResource(R.mipmap.location_dkj)).zIndex(9.0f).title("开始打卡点").draggable(false));
        }
        if (map2.containsKey("latitude") && map2.containsKey("longitude")) {
            this.f19996q.addMarker(new MarkerOptions().position(new LatLng(JsonParse.getDouble(map2, "latitude"), JsonParse.getDouble(map2, "longitude"))).icon(BitmapDescriptorFactory.fromResource(R.mipmap.location_dkj)).zIndex(9.0f).title("结束打卡点").draggable(false));
        }
    }

    private void h0(GeoFence fence) {
        int type = fence.getType();
        if (type != 0 && type != 2) {
            return;
        }
        f0(fence);
    }

    private void n0(String geoFenceJson) {
        if (!TextUtils.isEmpty(geoFenceJson)) {
            this.f20001v = (List) JSON.parseObject(geoFenceJson, new c().getType(), new Feature[0]);
        }
        List<List<Map<String, Object>>> list = this.f20001v;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (List<Map<String, Object>> list2 : this.f20001v) {
                ArrayList arrayList2 = new ArrayList();
                for (Map<String, Object> map : list2) {
                    arrayList2.add(new DPoint(JsonParse.getDouble(map, com.umeng.analytics.pro.d.C), JsonParse.getDouble(map, com.umeng.analytics.pro.d.D)));
                }
                arrayList.add(arrayList2);
            }
            l0(arrayList);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19989j = (LinearLayout) c(2131298068);
        this.f19990k = (LinearLayout) c(2131298015);
        this.f19991l = (TextView) c(R.id.tv_speed);
        this.f19992m = (TextView) c(2131299158);
        this.f19993n = (TextView) c(R.id.tv_peisu);
        this.f19994o = (TextView) c(2131298881);
        this.f19997r = (RecordPathView) c(R.id.rpv);
        TextureMapView textureMapView = (TextureMapView) c(R.id.map);
        this.f19995p = textureMapView;
        this.f19996q = textureMapView.getMap();
        this.f19995p.onCreate(this.f20002w);
        this.f19995p.setForeground(new ColorDrawable(ContextCompat.getColor(this.f1096g, 2131100543)));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_run_trace;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f20002w = savedInstanceState;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f19995p.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f19995p.onResume();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
