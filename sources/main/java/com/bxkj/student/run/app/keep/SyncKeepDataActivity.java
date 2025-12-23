package com.bxkj.student.run.app.keep;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.model.MyLocationStyle;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.j;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.utils.i;
import com.umeng.analytics.AnalyticsConfig;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SyncKeepDataActivity extends BaseActivity {
    private TextView W;
    private TextView X;
    private int Y;
    private List<? extends Map<String, ? extends Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    private final DateFormat f19833a0 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            List<Map<String, Object>> list = JsonParse.getList(map, "data");
            if (list != null && list.size() > 0) {
                SyncKeepDataActivity.this.Y = 0;
                SyncKeepDataActivity.this.Z = list;
                SyncKeepDataActivity.this.y0();
                return;
            }
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) SyncKeepDataActivity.this).T);
            TextView textView = SyncKeepDataActivity.this.W;
            if (textView == null) {
                g0.S("tv_date");
                textView = null;
            }
            iosonebuttondialog.setMessage(((Object) textView.getText()) + "当天没有跑步数据").show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            SyncKeepDataActivity.this.Y++;
            SyncKeepDataActivity.this.y0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(SyncKeepDataActivity syncKeepDataActivity) {
        syncKeepDataActivity.T.startActivity(new Intent(syncKeepDataActivity.T, (Class<?>) KeepAuthH5Activity.class));
    }

    private final List<Integer> t0(List<? extends Map<String, Object>> list) {
        int i6;
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        int i8 = 1;
        for (Map<String, Object> map : list) {
            double d6 = JsonParse.getDouble(map, "currentTotalDuration");
            int i9 = JsonParse.getInt(map, "currentTotalSteps");
            if (d6 > i8 * 60) {
                int i10 = i9 - i7;
                i7 += i10;
                i8++;
                arrayList.add(Integer.valueOf(i10));
            }
            System.out.getClass();
        }
        if (!list.isEmpty() && (i6 = JsonParse.getInt(list.get(list.size() - 1), "currentTotalSteps") - i7) > 0) {
            arrayList.add(Integer.valueOf(i6));
        }
        return arrayList;
    }

    private final List<LatLngTimeSpeed> u0(List<? extends Map<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            LatLngTimeSpeed latLngTimeSpeed = new LatLngTimeSpeed();
            latLngTimeSpeed.setLatitude(JsonParse.getDouble(map, "latitude"));
            latLngTimeSpeed.setLongitude(JsonParse.getDouble(map, "longitude"));
            latLngTimeSpeed.setLocationType(JsonParse.getInt(map, MyLocationStyle.LOCATION_TYPE));
            latLngTimeSpeed.setSpeed(JsonParse.getFloat(map, "speed"));
            latLngTimeSpeed.setTime((long) (JsonParse.getDouble(map, "currentTotalDuration") * 1000));
            latLngTimeSpeed.setPuase(false);
            arrayList.add(latLngTimeSpeed);
        }
        return arrayList;
    }

    private final void v0() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(new Date());
        new DatePickerDialog(this.T, new DatePickerDialog.OnDateSetListener() { // from class: com.bxkj.student.run.app.keep.b
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i6, int i7, int i8) {
                SyncKeepDataActivity.w0(SyncKeepDataActivity.this, datePicker, i6, i7, i8);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(SyncKeepDataActivity syncKeepDataActivity, DatePicker datePicker, int i6, int i7, int i8) {
        String str = i6 + "-" + (i7 + 1) + "-" + i8;
        try {
            DateFormat dateFormat = syncKeepDataActivity.f19833a0;
            String format = dateFormat.format(dateFormat.parse(str));
            g0.o(format, "format(...)");
            str = format;
        } catch (ParseException e6) {
            e6.printStackTrace();
        }
        TextView textView = syncKeepDataActivity.W;
        if (textView == null) {
            g0.S("tv_date");
            textView = null;
        }
        textView.setText(str);
    }

    private final void x0() {
        HttpRequest with = Http.with(this.T);
        com.bxkj.student.run.app.a aVar = (com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class);
        String keepToken = LoginUser.getLoginUser().getKeepToken();
        TextView textView = this.W;
        if (textView == null) {
            g0.S("tv_date");
            textView = null;
        }
        with.setObservable(aVar.q(keepToken, u.x2(textView.getText().toString(), "-", "", false, 4, null))).setHttpJsonKey(new j()).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        TextView textView = this.W;
        TextView textView2 = null;
        if (textView == null) {
            g0.S("tv_date");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.keep.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncKeepDataActivity.q0(SyncKeepDataActivity.this, view);
            }
        });
        TextView textView3 = this.X;
        if (textView3 == null) {
            g0.S("bt_sync");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.keep.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncKeepDataActivity.r0(SyncKeepDataActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        TextView textView = this.W;
        if (textView == null) {
            g0.S("tv_date");
            textView = null;
        }
        textView.setText(this.f19833a0.format(new Date()));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("同步keep跑步记录");
        e0(ContextCompat.getColor(this.T, 2131099737));
    }

    public final void y0() {
        int i6 = this.Y;
        List<? extends Map<String, ? extends Object>> list = this.Z;
        List<? extends Map<String, ? extends Object>> list2 = null;
        if (list == null) {
            g0.S("dataList");
            list = null;
        }
        if (i6 >= list.size()) {
            new iOSOneButtonDialog(this.T).setMessage("同步Keep数据成功").show();
            return;
        }
        List<? extends Map<String, ? extends Object>> list3 = this.Z;
        if (list3 == null) {
            g0.S("dataList");
        } else {
            list2 = list3;
        }
        Map<String, ? extends Object> map = list2.get(this.Y);
        double d6 = JsonParse.getDouble(map, "doubtfulScore");
        if (d6 != 0.0d && d6 != 0.5d) {
            this.Y++;
            y0();
            return;
        }
        long j6 = (long) JsonParse.getDouble(map, "duration");
        String g6 = i.g(j6);
        double d7 = JsonParse.getDouble(map, "distance");
        String c6 = i.c(d7);
        String a6 = i.a(d7, j6);
        String b6 = i.b(d7, j6);
        List<Map<String, Object>> list4 = JsonParse.getList(map, "geoPoints");
        g0.m(list4);
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).l(LoginUser.getLoginUser().getUserId(), 2, JsonParse.getLong(map, AnalyticsConfig.RTD_START_TIME), JsonParse.getLong(map, "endTime"), JSON.toJSONString(u0(list4)), UUID.randomUUID().toString(), g6, c6, a6, b6, null, null, null, null, null, null, JSON.toJSONString(t0(list4)), null, null, 4, JsonParse.getString(map, "id"))).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(SyncKeepDataActivity syncKeepDataActivity, View view) {
        syncKeepDataActivity.v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(final SyncKeepDataActivity syncKeepDataActivity, View view) {
        if (TextUtils.isEmpty(LoginUser.getLoginUser().getKeepToken())) {
            new iOSTwoButtonDialog(syncKeepDataActivity.T).setMessage("系统检测到您还未绑定Keep账号,请先绑定Keep账号").setLeftButtonText("暂不绑定").setRightButtonText("去绑定").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.keep.e
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    SyncKeepDataActivity.s0(SyncKeepDataActivity.this);
                }
            }).show();
        } else {
            syncKeepDataActivity.x0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_sync_keep_data;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(@Nullable Bundle bundle) {
        View findViewById = findViewById(2131298860);
        g0.o(findViewById, "findViewById(...)");
        this.W = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.bt_sync);
        g0.o(findViewById2, "findViewById(...)");
        this.X = (TextView) findViewById2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
