package com.bxkj.equipment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.i;
import com.bxkj.equipment.view.NumberButton;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyEquipmentActivity extends BaseActivity {
    private String F0;
    private int G0 = 0;
    private TextView W;
    private TextView X;
    private NumberButton Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f17475a0;

    /* renamed from: b0, reason: collision with root package name */
    private EditText f17476b0;

    /* renamed from: c0, reason: collision with root package name */
    private Button f17477c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f17478k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f17479p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements NumberButton.a {
        a() {
        }

        @Override // com.bxkj.equipment.view.NumberButton.a
        public void onWarningForInventory(int inventory) {
            new iOSOneButtonDialog(((BaseActivity) ApplyEquipmentActivity.this).T).setMessage("库存不足").show();
        }

        @Override // com.bxkj.equipment.view.NumberButton.a
        public void onNumberChanged(int number) {
        }

        @Override // com.bxkj.equipment.view.NumberButton.a
        public void onWarningForBuyMax(int max) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyEquipmentActivity.this.finish();
            ApplyEquipmentActivity.this.g0("申请成功");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyEquipmentActivity.this.finish();
            ApplyEquipmentActivity.this.g0("申请成功");
        }
    }

    public static /* synthetic */ void j0(ApplyEquipmentActivity applyEquipmentActivity, String str, String str2, Map map) {
        applyEquipmentActivity.f17478k0 = str;
        applyEquipmentActivity.W.setText("");
        applyEquipmentActivity.f17479p0 = "";
        applyEquipmentActivity.Y.e(1);
    }

    public static /* synthetic */ void k0(ApplyEquipmentActivity applyEquipmentActivity, String str, String str2, Map map) {
        applyEquipmentActivity.f17479p0 = str;
        int i6 = JsonParse.getInt(map, "amount");
        if (applyEquipmentActivity.Y.getNumber() > i6) {
            applyEquipmentActivity.Y.e(i6);
        }
        applyEquipmentActivity.Y.f(i6);
    }

    public static /* synthetic */ void m0(final ApplyEquipmentActivity applyEquipmentActivity, View view) {
        if (TextUtils.isEmpty(applyEquipmentActivity.f17478k0)) {
            new iOSOneButtonDialog(applyEquipmentActivity.T).setMessage("请先选择校区").show();
        } else {
            new com.bxkj.base.util.i(applyEquipmentActivity.T).i(applyEquipmentActivity.W, "请选择器材", ((i) Http.getApiService(i.class)).e(applyEquipmentActivity.f17478k0), new i.c() { // from class: com.bxkj.equipment.f
                @Override // com.bxkj.base.util.i.c
                public final void a(String str, String str2, Map map) {
                    ApplyEquipmentActivity.k0(ApplyEquipmentActivity.this, str, str2, map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        if (TextUtils.isEmpty(this.f17478k0)) {
            new iOSOneButtonDialog(this.T).setMessage("请选择校区").show();
            return;
        }
        if (TextUtils.isEmpty(this.f17479p0)) {
            new iOSOneButtonDialog(this.T).setMessage("请选择器材").show();
            return;
        }
        String trim = this.Z.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.T).setMessage(this.Z.getHint()).show();
            return;
        }
        String trim2 = this.f17475a0.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            new iOSOneButtonDialog(this.T).setMessage(this.f17475a0.getHint()).show();
            return;
        }
        String trim3 = this.f17476b0.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            new iOSOneButtonDialog(this.T).setMessage(this.f17476b0.getHint()).show();
        } else if (LoginUser.getLoginUser().getUserType() == 1) {
            Http.with(this.T).setObservable(((i) Http.getApiService(i.class)).d(LoginUser.getLoginUser().getUserId(), this.f17478k0, this.f17479p0, trim3, Integer.valueOf(this.Y.getNumber()), trim, trim2, "0", null)).setDataListener(new b());
        } else {
            Http.with(this.T).setObservable(((i) Http.getApiService(i.class)).f(this.F0, this.G0, this.f17479p0, trim3, Integer.valueOf(this.Y.getNumber()), trim, trim2, "0", null)).setDataListener(new c());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                new com.bxkj.base.util.i(r0.T).i(r0.X, "请选择校区", ((i) Http.getApiService(i.class)).b(), new i.c() { // from class: com.bxkj.equipment.g
                    @Override // com.bxkj.base.util.i.c
                    public final void a(String str, String str2, Map map) {
                        ApplyEquipmentActivity.j0(ApplyEquipmentActivity.this, str, str2, map);
                    }
                });
            }
        });
        this.W.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.m0(ApplyEquipmentActivity.this, view);
            }
        });
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                new com.bxkj.base.util.i(r0.T).g(ApplyEquipmentActivity.this.Z, null);
            }
        });
        this.f17475a0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                new com.bxkj.base.util.i(r0.T).g(ApplyEquipmentActivity.this.f17475a0, null);
            }
        });
        this.Y.g(new a());
        this.f17477c0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyEquipmentActivity.this.p0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_apply_equipment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("借用器材");
        e0(getResources().getColor(R.color.colorWhite));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (TextView) findViewById(R.id.tv_campus);
        this.W = (TextView) findViewById(R.id.tv_name);
        this.Y = (NumberButton) findViewById(R.id.number_button);
        this.Z = (TextView) findViewById(R.id.tv_receive_date);
        this.f17475a0 = (TextView) findViewById(R.id.tv_return_date);
        this.f17476b0 = (EditText) findViewById(R.id.et_reason);
        this.f17477c0 = (Button) findViewById(R.id.bt_commit);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("teacherCurriculumId")) {
            this.F0 = getIntent().getStringExtra("teacherCurriculumId");
        }
        if (getIntent().hasExtra("week")) {
            this.G0 = getIntent().getIntExtra("week", 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
