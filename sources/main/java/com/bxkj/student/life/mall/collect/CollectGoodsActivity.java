package com.bxkj.student.life.mall.collect;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CollectGoodsActivity extends BaseActivity {
    private CollectGoodsFragment W;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            CollectGoodsActivity.this.W.Z();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W = new CollectGoodsFragment();
        getSupportFragmentManager().beginTransaction().add(2131298030, this.W).commit();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的收藏");
        c0("清空", new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_home_fragment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
