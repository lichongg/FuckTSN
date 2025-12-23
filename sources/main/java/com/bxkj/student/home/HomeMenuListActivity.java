package com.bxkj.student.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.common.db.HomeMenuDB;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.main.HomeFragment;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class HomeMenuListActivity extends BaseActivity {
    private ItemTouchHelper F0;
    private RecyclerView X;
    private RecyclerView Y;
    private Button Z;

    /* renamed from: b0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17856b0;

    /* renamed from: k0, reason: collision with root package name */
    private List<Map<String, Object>> f17858k0;

    /* renamed from: p0, reason: collision with root package name */
    private HomeFragment f17859p0;
    private final String W = "groupType";

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f17855a0 = new ArrayList();

    /* renamed from: c0, reason: collision with root package name */
    private boolean f17857c0 = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends ItemTouchHelper.Callback {
        a() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            viewHolder.itemView.setBackgroundColor(-1);
            super.clearView(recyclerView, viewHolder);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            if (!HomeMenuListActivity.this.f17857c0) {
                return false;
            }
            ((Vibrator) ((BaseActivity) HomeMenuListActivity.this).T.getSystemService("vibrator")).vibrate(500L);
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            if (actionState != 0) {
                viewHolder.itemView.setBackgroundColor(-3355444);
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            int i6;
            if (viewHolder.getItemViewType() != 1 && viewHolder.getItemViewType() == viewHolder.getItemViewType() && HomeMenuListActivity.this.f17857c0 && viewHolder.getAdapterPosition() < HomeMenuListActivity.this.f17858k0.size() && !JsonParse.getString((Map) HomeMenuListActivity.this.f17858k0.get(viewHolder.getAdapterPosition()), CommonNetImpl.NAME).isEmpty()) {
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    i6 = 15;
                } else {
                    i6 = 3;
                }
            } else {
                i6 = 0;
            }
            return ItemTouchHelper.Callback.makeMovementFlags(i6, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            if (JsonParse.getString((Map) HomeMenuListActivity.this.f17858k0.get(adapterPosition), CommonNetImpl.NAME).isEmpty() || JsonParse.getString((Map) HomeMenuListActivity.this.f17858k0.get(adapterPosition2), CommonNetImpl.NAME).isEmpty()) {
                return false;
            }
            if (adapterPosition < adapterPosition2) {
                int i6 = adapterPosition;
                while (i6 < adapterPosition2) {
                    int i7 = i6 + 1;
                    Collections.swap(HomeMenuListActivity.this.f17858k0, i6, i7);
                    i6 = i7;
                }
            } else {
                for (int i8 = adapterPosition; i8 > adapterPosition2; i8--) {
                    Collections.swap(HomeMenuListActivity.this.f17858k0, i8, i8 - 1);
                }
            }
            HomeMenuListActivity.this.f17856b0.notifyItemMoved(adapterPosition, adapterPosition2);
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.r(2131297155, HomeMenuListActivity.this.v0(JsonParse.getString(stringObjectMap, "icon")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends UniversalItemDecoration {
        c() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            aVar.f17788a = u.a(7.0f, ((BaseActivity) HomeMenuListActivity.this).T);
            aVar.f17787f = -1;
            return aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int itemType) {
            return itemType == 1 ? R.layout.item_for_home_class_list : R.layout.item_for_home_menu;
        }

        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(int position, Map<String, Object> stringObjectMap) {
            return JsonParse.getInt(stringObjectMap, "type");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends MultiItemCommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends GridLayoutManager.SpanSizeLookup {
            a() {
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return e.this.getItemViewType(position) != 1 ? 1 : 4;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f17866a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewHolder f17867b;

            b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f17866a = val$stringObjectMap;
                this.f17867b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                e.this.r(this.f17866a, this.f17867b);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class c implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f17869a;

            c(final int val$index) {
                this.f17869a = val$index;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                e.this.s(this.f17869a);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class d implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f17871a;

            d(final Map val$stringObjectMap) {
                this.f17871a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                e.this.p(this.f17871a);
            }
        }

        e(Context context, List datas, cn.bluemobi.dylan.base.adapter.common.recyclerview.a multiItemTypeSupport) {
            super(context, datas, multiItemTypeSupport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(Map<String, Object> stringObjectMap) {
            int size = HomeMenuListActivity.this.f17858k0.size();
            HashMap hashMap = new HashMap(stringObjectMap);
            hashMap.put("groupType", -1);
            if (size == 12 && JsonParse.getString((Map) HomeMenuListActivity.this.f17858k0.get(HomeMenuListActivity.this.f17858k0.size() - 1), CommonNetImpl.NAME).isEmpty()) {
                int i6 = size - 1;
                HomeMenuListActivity.this.f17858k0.set(i6, hashMap);
                HomeMenuListActivity.this.f17855a0.set(i6, hashMap);
                notifyItemRangeChanged(i6, HomeMenuListActivity.this.f17855a0.size());
                return;
            }
            if (size >= 12) {
                HomeMenuListActivity.this.g0("首页最多添加11个应用");
                return;
            }
            int i7 = size - 1;
            HomeMenuListActivity.this.f17858k0.add(i7, hashMap);
            HomeMenuListActivity.this.f17855a0.add(i7, hashMap);
            int i8 = size - 2;
            notifyItemInserted(i8);
            notifyItemRangeChanged(i8, HomeMenuListActivity.this.f17855a0.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(Map<String, Object> stringObjectMap, ViewHolder holder) {
            HomeMenuListActivity.this.f17855a0.remove(stringObjectMap);
            HomeMenuListActivity.this.f17858k0.remove(stringObjectMap);
            if (!JsonParse.getString((Map) HomeMenuListActivity.this.f17858k0.get(HomeMenuListActivity.this.f17858k0.size() - 1), CommonNetImpl.NAME).isEmpty()) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put(CommonNetImpl.NAME, "");
                arrayMap.put("type", 2);
                HomeMenuListActivity.this.f17858k0.add(arrayMap);
                HomeMenuListActivity.this.f17855a0.add(HomeMenuListActivity.this.f17858k0.size() - 1, arrayMap);
            }
            notifyItemRemoved(holder.f());
            notifyItemRangeChanged(holder.f(), HomeMenuListActivity.this.f17855a0.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(int index) {
            HomeMenuListActivity.this.f17855a0.remove(index);
            HomeMenuListActivity.this.f17858k0.remove(index);
            if (!JsonParse.getString((Map) HomeMenuListActivity.this.f17858k0.get(HomeMenuListActivity.this.f17858k0.size() - 1), CommonNetImpl.NAME).isEmpty()) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put(CommonNetImpl.NAME, "");
                arrayMap.put("type", 2);
                HomeMenuListActivity.this.f17858k0.add(arrayMap);
                HomeMenuListActivity.this.f17855a0.add(HomeMenuListActivity.this.f17858k0.size() - 1, arrayMap);
            }
            notifyItemRemoved(index);
            notifyItemRangeChanged(index, HomeMenuListActivity.this.f17855a0.size());
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, CommonNetImpl.NAME);
            if (string.equals("首页应用")) {
                SpannableString spannableString = new SpannableString(string + "(按住拖动调整顺序)");
                spannableString.setSpan(new ForegroundColorSpan(HomeMenuListActivity.this.getResources().getColor(2131099821)), 4, spannableString.length(), 34);
                ((TextView) holder.h(2131298986)).setText(spannableString);
            } else {
                holder.J(2131298986, string);
            }
            if (getItemViewType(holder.f()) == 2) {
                if (TextUtils.isEmpty(string)) {
                    holder.N(2131298986, false);
                    holder.N(2131297155, false);
                    holder.N(R.id.iv_op, false);
                    GridLayoutManager.LayoutParams layoutParams = new GridLayoutManager.LayoutParams(-1, u.a(50.0f, this.f1138e));
                    int a6 = u.a(10.0f, this.f1138e);
                    int a7 = u.a(15.0f, this.f1138e);
                    layoutParams.setMargins(a7, a6, a7, a6);
                    holder.itemView.setLayoutParams(layoutParams);
                    holder.itemView.setBackgroundResource(R.drawable.xk);
                } else {
                    holder.N(2131298986, true);
                    holder.N(2131297155, true);
                    holder.N(R.id.iv_op, true);
                    holder.itemView.setLayoutParams(new GridLayoutManager.LayoutParams(-1, u.a(70.0f, this.f1138e)));
                    holder.itemView.setBackgroundColor(0);
                }
                if (JsonParse.getString(stringObjectMap, "icon").isEmpty()) {
                    holder.N(2131297155, false);
                } else {
                    holder.N(2131297155, true);
                    holder.r(2131297155, HomeMenuListActivity.this.v0(JsonParse.getString(stringObjectMap, "icon")));
                }
                holder.N(R.id.iv_op, HomeMenuListActivity.this.f17857c0 && !TextUtils.isEmpty(string));
                if (JsonParse.getInt(stringObjectMap, "groupType") == -1) {
                    holder.r(R.id.iv_op, R.mipmap.jian);
                    holder.w(R.id.iv_op, new b(stringObjectMap, holder));
                    return;
                }
                int z02 = HomeMenuListActivity.this.z0(string, JsonParse.getString(stringObjectMap, "icon"));
                if (z02 != -1) {
                    holder.r(R.id.iv_op, R.mipmap.jian);
                    holder.w(R.id.iv_op, new c(z02));
                } else {
                    holder.r(R.id.iv_op, R.mipmap.jia);
                    holder.w(R.id.iv_op, new d(stringObjectMap));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                ((GridLayoutManager) layoutManager).setSpanSizeLookup(new a());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends UniversalItemDecoration {
        f() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            if (position <= 0 || position >= HomeMenuListActivity.this.f17856b0.getItemCount() || JsonParse.getInt((Map) HomeMenuListActivity.this.f17856b0.getItem(position), "type") != 1) {
                return null;
            }
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            aVar.f17790c = u.a(2.0f, ((BaseActivity) HomeMenuListActivity.this).T);
            aVar.f17787f = HomeMenuListActivity.this.getResources().getColor(R.color.defaultBackgroundColor);
            return aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        g() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            if (HomeMenuListActivity.this.f17857c0 || JsonParse.getInt((Map) HomeMenuListActivity.this.f17856b0.getItem(position), "type") != 2) {
                return;
            }
            new com.bxkj.student.home.d(((BaseActivity) HomeMenuListActivity.this).U, JsonParse.getString((Map) HomeMenuListActivity.this.f17856b0.getItem(position), "icon"), JsonParse.getString((Map) HomeMenuListActivity.this.f17856b0.getItem(position), CommonNetImpl.NAME)).f();
        }
    }

    private List<Map<String, Object>> x0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "教学");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(CommonNetImpl.NAME, "查看" + LoginUser.getLoginUser().getViewAfterLabelName());
        arrayMap2.put("icon", "icon_1_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put(CommonNetImpl.NAME, "在线选" + LoginUser.getLoginUser().getXuanAfterLabelName());
        arrayMap3.put("icon", "icon_1_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put(CommonNetImpl.NAME, "查看点名");
        arrayMap4.put("icon", "icon_1_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put(CommonNetImpl.NAME, "上课签到");
        arrayMap5.put("icon", "icon_1_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put(CommonNetImpl.NAME, "上课请假");
        arrayMap6.put("icon", "icon_1_5");
        arrayMap6.put("type", 2);
        arrayList.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put(CommonNetImpl.NAME, "评价教师");
        arrayMap7.put("icon", "icon_1_6");
        arrayMap7.put("type", 2);
        arrayList.add(arrayMap7);
        ArrayMap arrayMap8 = new ArrayMap();
        arrayMap8.put(CommonNetImpl.NAME, "理论考试");
        arrayMap8.put("icon", "icon_1_7");
        arrayMap8.put("type", 2);
        arrayList.add(arrayMap8);
        ArrayMap arrayMap9 = new ArrayMap();
        arrayMap9.put(CommonNetImpl.NAME, "师生互动");
        arrayMap9.put("icon", "icon_1_8");
        arrayMap9.put("type", 2);
        arrayList.add(arrayMap9);
        ArrayMap arrayMap10 = new ArrayMap();
        arrayMap10.put(CommonNetImpl.NAME, "申请状态");
        arrayMap10.put("icon", "icon_1_9");
        arrayMap10.put("type", 2);
        arrayList.add(arrayMap10);
        ArrayMap arrayMap11 = new ArrayMap();
        arrayMap11.put(CommonNetImpl.NAME, "期末成绩");
        arrayMap11.put("icon", "icon_1_10");
        arrayMap11.put("type", 2);
        arrayList.add(arrayMap11);
        ArrayMap arrayMap12 = new ArrayMap();
        arrayMap12.put(CommonNetImpl.NAME, "申请班长");
        arrayMap12.put("icon", "icon_1_11");
        arrayMap12.put("type", 2);
        arrayList.add(arrayMap12);
        ArrayMap arrayMap13 = new ArrayMap();
        arrayMap13.put(CommonNetImpl.NAME, "班级管理");
        arrayMap13.put("icon", "icon_1_12");
        arrayMap13.put("type", 2);
        arrayList.add(arrayMap13);
        ArrayMap arrayMap14 = new ArrayMap();
        arrayMap14.put(CommonNetImpl.NAME, "公共班级");
        arrayMap14.put("icon", "icon_1_13");
        arrayMap14.put("type", 2);
        arrayList.add(arrayMap14);
        ArrayMap arrayMap15 = new ArrayMap();
        arrayMap15.put(CommonNetImpl.NAME, "预约活动");
        arrayMap15.put("icon", "icon_1_14");
        arrayMap15.put("type", 2);
        arrayList.add(arrayMap15);
        ArrayMap arrayMap16 = new ArrayMap();
        arrayMap16.put(CommonNetImpl.NAME, "我的活动");
        arrayMap16.put("icon", "icon_1_15");
        arrayMap16.put("type", 2);
        arrayList.add(arrayMap16);
        ArrayMap arrayMap17 = new ArrayMap();
        arrayMap17.put(CommonNetImpl.NAME, "在线学习");
        arrayMap17.put("icon", "icon_1_16");
        arrayMap17.put("type", 2);
        arrayList.add(arrayMap17);
        ArrayMap arrayMap18 = new ArrayMap();
        arrayMap18.put(CommonNetImpl.NAME, "预约考试");
        arrayMap18.put("icon", "icon_1_17");
        arrayMap18.put("type", 2);
        arrayList.add(arrayMap18);
        if (LoginUser.getLoginUser().getSchoolId().equals("92") || LoginUser.getLoginUser().getSchoolId().equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE) || LoginUser.getLoginUser().getSchoolId().equals("95") || LoginUser.getLoginUser().getSchoolId().equals("97") || LoginUser.getLoginUser().getSchoolId().equals("130")) {
            ArrayMap arrayMap19 = new ArrayMap();
            arrayMap19.put(CommonNetImpl.NAME, "体育专业题库");
            arrayMap19.put("icon", "icon_1_18");
            arrayMap19.put("type", 2);
            arrayMap19.put("groupType", -1);
            arrayList.add(arrayMap19);
        }
        ArrayMap arrayMap20 = new ArrayMap();
        arrayMap20.put(CommonNetImpl.NAME, "课后作业");
        arrayMap20.put("icon", "ic_home_word");
        arrayMap20.put("type", 2);
        arrayList.add(arrayMap20);
        if (!LoginUser.getLoginUser().getSchoolId().equals("92") && !LoginUser.getLoginUser().getSchoolId().equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE) && !LoginUser.getLoginUser().getSchoolId().equals("97") && !LoginUser.getLoginUser().getSchoolId().equals("130")) {
            return arrayList;
        }
        ArrayMap arrayMap21 = new ArrayMap();
        arrayMap21.put(CommonNetImpl.NAME, "体育知识竞赛");
        arrayMap21.put("icon", "icon_1_18");
        arrayMap21.put("type", 2);
        arrayMap21.put("groupType", -1);
        arrayList.add(arrayMap21);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z0(String name, String icon) {
        for (int i6 = 0; i6 < this.f17858k0.size(); i6++) {
            if (this.f17858k0.get(i6).containsValue(name) && this.f17858k0.get(i6).containsValue(icon)) {
                return i6;
            }
        }
        return -1;
    }

    private int A0(String name) {
        for (int size = this.f17855a0.size() - 1; size >= 0; size--) {
            if (this.f17855a0.get(size).containsValue(name)) {
                return size;
            }
        }
        return -1;
    }

    private void B0() {
        d dVar = new d();
        this.X.setLayoutManager(new GridLayoutManager(this.T, 4, 1, false));
        e eVar = new e(this.T, this.f17855a0, dVar);
        this.f17856b0 = eVar;
        this.X.setAdapter(eVar);
        this.X.addItemDecoration(new f());
    }

    private void C0() {
        this.f17855a0.addAll(x0());
        this.f17855a0.addAll(t0());
        this.f17855a0.addAll(s0());
        this.f17855a0.addAll(w0());
        this.f17855a0.addAll(u0());
        this.f17855a0.addAll(y0());
    }

    private void D0() {
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.Y.setLayoutAnimation(layoutAnimationController);
        this.Y.setLayoutManager(new LinearLayoutManager(this.T, 0, false));
        this.Y.setAdapter(new b(this.T, R.layout.item_for_my_menu, com.bxkj.student.home.a.b().c()));
        this.Y.addItemDecoration(new c());
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeMenuListActivity.this.E0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(View view) {
        if (this.f17857c0) {
            this.Z.setText("编辑");
            this.f17857c0 = false;
            this.f17855a0.removeAll(this.f17858k0);
            this.f17856b0.notifyDataSetChanged();
            this.X.scrollToPosition(0);
            F0();
            return;
        }
        this.Z.setText("完成");
        this.f17857c0 = true;
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "首页应用");
        arrayMap.put("type", 1);
        this.f17858k0.add(0, arrayMap);
        if (this.f17858k0.size() < 12) {
            ArrayMap arrayMap2 = new ArrayMap();
            arrayMap2.put(CommonNetImpl.NAME, "");
            arrayMap2.put("type", 2);
            this.f17858k0.add(arrayMap2);
        }
        this.f17855a0.addAll(0, this.f17858k0);
        this.f17856b0.notifyDataSetChanged();
        this.X.scrollToPosition(0);
    }

    private void F0() {
        try {
            cn.bluemobi.dylan.sqlitelibrary.c.h().c(HomeMenuDB.class);
            ArrayList arrayList = new ArrayList();
            this.f17858k0.remove(0);
            if (JsonParse.getString(this.f17858k0.get(r2.size() - 1), CommonNetImpl.NAME).isEmpty()) {
                this.f17858k0.remove(r2.size() - 1);
            }
            for (Map<String, Object> map : this.f17858k0) {
                HomeMenuDB homeMenuDB = new HomeMenuDB();
                homeMenuDB.setMenuName(JsonParse.getString(map, CommonNetImpl.NAME));
                homeMenuDB.setIconResName(JsonParse.getString(map, "icon"));
                arrayList.add(homeMenuDB);
            }
            cn.bluemobi.dylan.sqlitelibrary.c.h().insert((List) arrayList);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        HomeFragment homeFragment = this.f17859p0;
        if (homeFragment != null) {
            homeFragment.Z();
        }
    }

    private void r0() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new a());
        this.F0 = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.X);
    }

    private List<Map<String, Object>> s0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "竞赛");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(CommonNetImpl.NAME, "竞赛报名");
        arrayMap2.put("icon", "icon_3_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put(CommonNetImpl.NAME, "竞赛记录");
        arrayMap3.put("icon", "icon_3_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put(CommonNetImpl.NAME, "电子参赛证");
        arrayMap4.put("icon", "icon_3_4");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put(CommonNetImpl.NAME, "赛事中心");
        arrayMap5.put("icon", "icon_3_3");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        return arrayList;
    }

    private List<Map<String, Object>> t0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "体测");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(CommonNetImpl.NAME, "预约体测");
        arrayMap2.put("icon", "icon_2_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put(CommonNetImpl.NAME, "体测预约记录");
        arrayMap3.put("icon", "icon_2_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put(CommonNetImpl.NAME, "体测成绩");
        arrayMap4.put("icon", "icon_2_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put(CommonNetImpl.NAME, "申请免测");
        arrayMap5.put("icon", "icon_2_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put(CommonNetImpl.NAME, "班长预约");
        arrayMap6.put("icon", "icon_2_5");
        arrayMap6.put("type", 2);
        arrayList.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put(CommonNetImpl.NAME, "班长记录");
        arrayMap7.put("icon", "icon_2_6");
        arrayMap7.put("type", 2);
        arrayList.add(arrayMap7);
        ArrayMap arrayMap8 = new ArrayMap();
        arrayMap8.put(CommonNetImpl.NAME, "体测计算器");
        arrayMap8.put("icon", "icon_2_7");
        arrayMap8.put("type", 2);
        arrayList.add(arrayMap8);
        ArrayMap arrayMap9 = new ArrayMap();
        arrayMap9.put(CommonNetImpl.NAME, "自助视力");
        arrayMap9.put("icon", "icon_2_8");
        arrayMap9.put("type", 2);
        arrayList.add(arrayMap9);
        ArrayMap arrayMap10 = new ArrayMap();
        arrayMap10.put(CommonNetImpl.NAME, "体测准考证");
        arrayMap10.put("icon", "icon_2_7");
        arrayMap10.put("type", 2);
        arrayList.add(arrayMap10);
        ArrayMap arrayMap11 = new ArrayMap();
        arrayMap11.put(CommonNetImpl.NAME, "体测排名");
        arrayMap11.put("icon", "icon_2_3");
        arrayMap11.put("type", 2);
        arrayList.add(arrayMap11);
        return arrayList;
    }

    private List<Map<String, Object>> u0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "场馆");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(CommonNetImpl.NAME, "预约场馆");
        arrayMap2.put("icon", "icon_5_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        if (!LoginUser.getLoginUser().getSchoolId().equals("342")) {
            ArrayMap arrayMap3 = new ArrayMap();
            arrayMap3.put(CommonNetImpl.NAME, "场馆预约记录");
            arrayMap3.put("icon", "icon_5_2");
            arrayMap3.put("type", 2);
            arrayList.add(arrayMap3);
            ArrayMap arrayMap4 = new ArrayMap();
            arrayMap4.put(CommonNetImpl.NAME, "申请场馆");
            arrayMap4.put("icon", "icon_5_3");
            arrayMap4.put("type", 2);
            arrayList.add(arrayMap4);
            ArrayMap arrayMap5 = new ArrayMap();
            arrayMap5.put(CommonNetImpl.NAME, "申请记录");
            arrayMap5.put("icon", "icon_5_4");
            arrayMap5.put("type", 2);
            arrayList.add(arrayMap5);
        }
        return arrayList;
    }

    private List<Map<String, Object>> w0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "阳光体育");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(CommonNetImpl.NAME, "App跑步");
        arrayMap2.put("icon", "icon_4_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put(CommonNetImpl.NAME, "约跑");
        arrayMap3.put("icon", "icon_4_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put(CommonNetImpl.NAME, "锻炼考勤");
        arrayMap4.put("icon", "icon_4_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put(CommonNetImpl.NAME, "场馆打卡");
        arrayMap5.put("icon", "icon_4_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put(CommonNetImpl.NAME, "申请免跑");
        arrayMap6.put("icon", "icon_4_5");
        arrayMap6.put("type", 2);
        arrayList.add(arrayMap6);
        if (LoginUser.getLoginUser().getIsOpenKeep() == 1) {
            ArrayMap arrayMap7 = new ArrayMap();
            arrayMap7.put(CommonNetImpl.NAME, "绑定Keep账号");
            arrayMap7.put("icon", "keep");
            arrayMap7.put("type", 2);
            arrayList.add(arrayMap7);
            ArrayMap arrayMap8 = new ArrayMap();
            arrayMap8.put(CommonNetImpl.NAME, "同步Keep数据");
            arrayMap8.put("icon", "keep");
            arrayMap8.put("type", 2);
            arrayList.add(arrayMap8);
        }
        return arrayList;
    }

    private List<Map<String, Object>> y0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "器材");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(CommonNetImpl.NAME, "借用器材");
        arrayMap2.put("icon", "icon_6_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put(CommonNetImpl.NAME, "借用记录");
        arrayMap3.put("icon", "icon_6_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        return arrayList;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f17856b0.k(new g());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("全部应用");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_home_menu_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.f17859p0 = (HomeFragment) cn.bluemobi.dylan.base.utils.a.n().o(HomeFragment.class);
        this.f17858k0 = com.bxkj.student.home.a.b().c();
        C0();
        B0();
        D0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.Z = (Button) findViewById(R.id.bt_edit);
        this.Y = (RecyclerView) findViewById(R.id.rv_my);
        this.X = (RecyclerView) findViewById(2131298421);
        r0();
    }

    public int v0(String imageName) {
        int identifier = getResources().getIdentifier(imageName, ResIdentify.RES_TYPE_MIPMAP, getPackageName());
        if (imageName.equals("ic_home_word")) {
            return getResources().getIdentifier(imageName, ResIdentify.RES_TYPE_DRAWABLE, getPackageName());
        }
        return identifier;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
