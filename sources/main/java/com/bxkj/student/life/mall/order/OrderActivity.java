package com.bxkj.student.life.mall.order;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.b;
import com.bxkj.student.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class OrderActivity extends BaseActivity {
    private TabLayout W;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < 8; i6++) {
            OrderFragment orderFragment = new OrderFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i6);
            orderFragment.setArguments(bundle);
            arrayList.add(orderFragment);
        }
        new b(getSupportFragmentManager(), arrayList, 2131298030, this.W);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的订单");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_order;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TabLayout) findViewById(R.id.tb);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
