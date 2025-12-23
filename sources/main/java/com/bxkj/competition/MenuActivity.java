package com.bxkj.competition;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.competition.score.CompetitionProjectListActivity;
import com.bxkj.competition.signup.CompetitionDetailActivity;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MenuActivity extends BaseActivity {
    private List<Map<String, Object>> W;
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.competition.MenuActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0195a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewHolder f17251a;

            ViewOnClickListenerC0195a(final ViewHolder val$holder) {
                this.f17251a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                MenuActivity.this.i0(this.f17251a.g(R.id.bt_name));
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            int i6 = R.id.bt_name;
            holder.J(i6, u.O(stringObjectMap, CommonNetImpl.NAME));
            holder.w(i6, new ViewOnClickListenerC0195a(holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(String text) {
        if (text.equals("竞赛报名")) {
            startActivity(getIntent().setClass(this.T, CompetitionDetailActivity.class));
        } else if (text.equals("录入成绩")) {
            startActivity(getIntent().setClass(this.T, CompetitionProjectListActivity.class));
        } else if (text.equals("签到")) {
            startActivity(getIntent().setClassName("com.bxkj.teacher", "com.bxkj.teacher.completion.signin.ProjectActivity"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.pub_recycleview;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "竞赛报名");
        this.W.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(CommonNetImpl.NAME, "录入成绩");
        this.W.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put(CommonNetImpl.NAME, "签到");
        this.W.add(arrayMap3);
        this.X.setLayoutManager(new GridLayoutManager(this.T, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_menu_list, this.W);
        this.Y = aVar;
        this.X.setAdapter(aVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("竞赛");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (RecyclerView) findViewById(R.id.rv);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
