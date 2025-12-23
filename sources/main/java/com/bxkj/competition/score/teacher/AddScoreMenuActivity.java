package com.bxkj.competition.score.teacher;

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
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AddScoreMenuActivity extends BaseActivity {
    private List<Map<String, Object>> W;
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.competition.score.teacher.AddScoreMenuActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0196a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f17339a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f17340b;

            ViewOnClickListenerC0196a(final String val$type, final int val$name) {
                this.f17339a = val$type;
                this.f17340b = val$name;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                AddScoreMenuActivity addScoreMenuActivity = AddScoreMenuActivity.this;
                addScoreMenuActivity.startActivity(addScoreMenuActivity.getIntent().setClass(((CommonAdapter) a.this).f1138e, TrackScoreListActivity.class).putExtra("menu", this.f17339a).putExtra("type", this.f17340b));
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, CommonNetImpl.NAME);
            int i6 = JsonParse.getInt(stringObjectMap, "type");
            int i7 = R.id.bt_name;
            holder.J(i7, string);
            holder.w(i7, new ViewOnClickListenerC0196a(string, i6));
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
        arrayMap.put("type", 1);
        arrayMap.put(CommonNetImpl.NAME, ScoreMenu.START);
        this.W.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("type", 1);
        arrayMap2.put(CommonNetImpl.NAME, ScoreMenu.CHECK);
        this.W.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("type", 0);
        arrayMap3.put(CommonNetImpl.NAME, ScoreMenu.RANK);
        this.W.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("type", 0);
        arrayMap4.put(CommonNetImpl.NAME, ScoreMenu.TIME);
        this.W.add(arrayMap4);
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
        setTitle("选择要录入的内容");
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
