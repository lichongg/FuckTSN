package com.bxkj.student.home.teaching.learning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LearningCategoryActivity extends BaseActivity {
    private ArrayList<Map<String, Object>> W;
    private SmartRefreshLayout X;
    private EmptyRecyclerView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18432a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.learning.LearningCategoryActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0223a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewHolder f18434a;

            ViewOnClickListenerC0223a(final ViewHolder val$holder) {
                this.f18434a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                Intent intent = new Intent();
                intent.putExtra("index", a.this.e(this.f18434a));
                LearningCategoryActivity.this.setResult(-1, intent);
                LearningCategoryActivity.this.finish();
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "typeName"));
            holder.w(2131296688, new ViewOnClickListenerC0223a(holder));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("全部频道");
        Z(false);
        a0(2131689673, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.n
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                LearningCategoryActivity.this.i0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0() {
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493640;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("list")) {
            this.W = (ArrayList) getIntent().getSerializableExtra("list");
        }
        this.Y.setLayoutManager(new GridLayoutManager(this.T, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.Y.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_school_list, this.W);
        this.f18432a0 = aVar;
        this.Y.setAdapter(aVar);
        this.Y.setEmptyView(this.Z);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (SmartRefreshLayout) findViewById(2131298352);
        this.Y = (EmptyRecyclerView) findViewById(2131298351);
        this.Z = (TextView) findViewById(2131298892);
        this.X.h0(false);
        this.X.v(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
