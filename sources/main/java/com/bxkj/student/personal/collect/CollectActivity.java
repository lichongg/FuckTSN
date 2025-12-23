package com.bxkj.student.personal.collect;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.b;
import com.bxkj.student.R;
import com.bxkj.student.life.InfoFragment;
import com.bxkj.student.life.mall.collect.CollectGoodsFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CollectActivity extends BaseActivity {
    private ImageView W;
    private TabLayout X;
    private CollectGoodsFragment Y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            if (CollectActivity.this.X.getSelectedTabPosition() != 2 || CollectActivity.this.Y == null) {
                return;
            }
            CollectActivity.this.Y.Z();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InfoFragment());
        arrayList.add(new InfoFragment());
        CollectGoodsFragment collectGoodsFragment = new CollectGoodsFragment();
        this.Y = collectGoodsFragment;
        arrayList.add(collectGoodsFragment);
        new b(getSupportFragmentManager(), arrayList, 2131298030, this.X);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的收藏");
        c0("清空", new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_collect;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (ImageView) findViewById(R.id.iv);
        this.X = (TabLayout) findViewById(R.id.tb);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
