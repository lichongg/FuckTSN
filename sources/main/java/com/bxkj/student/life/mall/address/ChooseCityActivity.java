package com.bxkj.student.life.mall.address;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ChooseCityActivity extends BaseActivity {
    private String F0;
    private RecyclerView W;
    private CommonAdapter<Map<String, Object>> Y;

    /* renamed from: a0, reason: collision with root package name */
    private String f19250a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f19251b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f19252c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f19253k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f19254p0;
    private List<Map<String, Object>> X = new ArrayList();
    private String Z = "请选择省";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            Resources resources;
            int i6;
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            if (holder.f() % 2 == 0) {
                resources = ChooseCityActivity.this.getResources();
                i6 = 2131099737;
            } else {
                resources = ChooseCityActivity.this.getResources();
                i6 = R.color.city_bg;
            }
            holder.k(2131298068, resources.getColor(i6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            String string = JsonParse.getString((Map) ChooseCityActivity.this.Y.getItem(position), "id");
            String string2 = JsonParse.getString((Map) ChooseCityActivity.this.Y.getItem(position), CommonNetImpl.NAME);
            if (ChooseCityActivity.this.Z.equals("请选择省")) {
                ChooseCityActivity.this.Z = "请选择市";
                ChooseCityActivity.this.f19250a0 = string;
                ChooseCityActivity.this.f19251b0 = string2;
                ChooseCityActivity chooseCityActivity = ChooseCityActivity.this;
                chooseCityActivity.z0(chooseCityActivity.f19250a0);
            } else if (ChooseCityActivity.this.Z.equals("请选择市")) {
                ChooseCityActivity.this.Z = "请选择区";
                ChooseCityActivity.this.f19252c0 = string;
                ChooseCityActivity.this.f19253k0 = string2;
                ChooseCityActivity.this.z0(string);
            } else if (ChooseCityActivity.this.Z.equals("请选择区")) {
                ChooseCityActivity.this.f19254p0 = string;
                ChooseCityActivity.this.F0 = string2;
                Intent intent = new Intent();
                intent.putExtra("provinceId", ChooseCityActivity.this.f19250a0);
                intent.putExtra("provinceName", ChooseCityActivity.this.f19251b0);
                intent.putExtra("cityId", ChooseCityActivity.this.f19252c0);
                intent.putExtra("cityName", ChooseCityActivity.this.f19253k0);
                intent.putExtra("areaId", ChooseCityActivity.this.f19254p0);
                intent.putExtra("areaName", ChooseCityActivity.this.F0);
                ChooseCityActivity.this.setResult(-1, intent);
                ChooseCityActivity.this.finish();
            }
            ChooseCityActivity chooseCityActivity2 = ChooseCityActivity.this;
            chooseCityActivity2.setTitle(chooseCityActivity2.Z);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ChooseCityActivity.this.X = JsonParse.getList(data, "data");
            ChooseCityActivity.this.Y.g(ChooseCityActivity.this.X);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String parentId) {
        Http.with(this.T).setObservable(((g) Http.getApiService(g.class)).t(parentId)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_city_list, this.X);
        this.Y = aVar;
        this.W.setAdapter(aVar);
        z0(null);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle(this.Z);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.pub_recycelrview_no_refresh;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (RecyclerView) findViewById(2131298421);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
