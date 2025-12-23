package com.bxkj.student.home.physicaltest.personal.reservation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.tencent.open.SocialConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ReservationDetailActivity extends BaseActivity {
    private String W;
    private LinearLayout X;
    private Button Y;
    private long Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ReservationDetailActivity.this.X.removeAllViews();
            ReservationDetailActivity.this.Z = Long.parseLong(JsonParse.getString(data, "currentTime"));
            ReservationDetailActivity.this.Q().setVisibility(0);
            ReservationDetailActivity.this.m0(data);
        }
    }

    private void k0(String text) {
        TextView textView = new TextView(this.T);
        textView.setMinHeight(u.a(40.0f, this.T));
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(16);
        textView.setText(text);
        this.X.addView(textView);
        View view = new View(this.T);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, u.a(1.0f, this.T)));
        view.setBackgroundColor(getResources().getColor(2131099732));
        this.X.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(Map<String, Object> data) {
        Map map = (Map) data.get("meaSchedule");
        k0("体测名称：" + JsonParse.getString(map, "scheduleName"));
        k0("预约开始时间：" + JsonParse.getString(map, "appointmentBeginTime"));
        k0("预约结束时间：" + JsonParse.getString(map, "appointmentEndTime"));
        k0("体测开始时间：" + JsonParse.getString(map, "meaBeginTime"));
        k0("体测结束时间：" + JsonParse.getString(map, "meaEndTime"));
        String string = JsonParse.getString(map, "classType");
        if (string.equals("0")) {
            k0("班级类型：混合班");
            k0("总人数：" + JsonParse.getString(map, "totalNumber"));
            k0("已预约人数：" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("1")) {
            k0("班级类型：男生班");
            k0("总人数：" + JsonParse.getString(map, "totalNumber"));
            k0("已预约人数：" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("2")) {
            k0("班级类型：女生班");
            k0("总人数：" + JsonParse.getString(map, "totalNumber"));
            k0("已预约人数：" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("3")) {
            k0("班级类型：比例班");
            k0("总人数：" + JsonParse.getString(map, "totalNumber"));
            k0("已预约人数：男:" + JsonParse.getString(map, "maleAppliedNumber") + ";女：" + JsonParse.getString(map, "femaleAppliedNumber"));
        }
        k0("体测说明：" + JsonParse.getString(map, SocialConstants.PARAM_COMMENT));
        List list = (List) data.get("meaScheduleExams");
        String[] strArr = new String[list.size()];
        for (int i6 = 0; i6 < list.size(); i6++) {
            strArr[i6] = JsonParse.getString((Map) list.get(i6), "examName");
        }
        k0("体测项目：" + Arrays.toString(strArr));
        String string2 = JsonParse.getString(map, "appointmentEndTime");
        if ("1".equals(JsonParse.getString(map, "ismeastate"))) {
            this.Y.setText("已预约");
            this.Y.setEnabled(false);
        } else {
            try {
                if (this.Z >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string2).getTime()) {
                    this.Y.setText("预约已结束");
                    this.Y.setEnabled(false);
                } else if (JsonParse.getInt(map, "totalAppliedNumber") >= JsonParse.getInt(map, "totalNumber")) {
                    this.Y.setText("预约人数已满");
                    this.Y.setEnabled(false);
                } else {
                    this.Y.setEnabled(true);
                    this.Y.setText("立即预约");
                }
            } catch (ParseException e6) {
                e6.printStackTrace();
            }
        }
        LinearLayout linearLayout = this.X;
        linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("体测预约详情");
    }

    private void l0() {
        ReservationListActivity reservationListActivity = (ReservationListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ReservationListActivity.class);
        if (reservationListActivity != null) {
            reservationListActivity.t0(this.T, this.W);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_reservation_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.W = getIntent().getStringExtra("id");
        }
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).t(this.W, LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (LinearLayout) findViewById(2131298030);
        this.Y = (Button) findViewById(R.id.bt_reservation);
        Q().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296639) {
            return;
        }
        l0();
    }
}
