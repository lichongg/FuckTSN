package com.bxkj.student.life.mall;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.auth.a;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.life.mall.address.MyAddressListActivity;
import com.bxkj.student.life.mall.collect.CollectGoodsActivity;
import com.bxkj.student.life.mall.order.OrderActivity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MallHomeActivity extends BaseActivity {
    private Toolbar W;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            MallHomeActivity mallHomeActivity = MallHomeActivity.this;
            mallHomeActivity.W = (Toolbar) mallHomeActivity.findViewById(2131298702);
            MallHomeActivity mallHomeActivity2 = MallHomeActivity.this;
            mallHomeActivity2.q0(mallHomeActivity2.W);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends UniversalItemDecoration {
        b() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            int a6 = u.a(1.0f, ((BaseActivity) MallHomeActivity.this).T);
            if (position != 2) {
                aVar.f17791d = a6;
                aVar.f17787f = -1;
            }
            return aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends CommonAdapter<String> {
        c(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder viewHolder, String string) {
            if (viewHolder.f() == 0) {
                viewHolder.r(2131297182, R.mipmap.my_order);
            } else if (viewHolder.f() == 1) {
                viewHolder.r(2131297182, R.mipmap.star_white);
            } else {
                viewHolder.r(2131297182, R.mipmap.my_address);
            }
            viewHolder.J(2131298986, string);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PopupWindow f19229a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements a.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f19231a;

            a(final int val$position) {
                this.f19231a = val$position;
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                d.this.f19229a.dismiss();
                int i6 = this.f19231a;
                if (i6 == 0) {
                    MallHomeActivity.this.startActivity(new Intent(((BaseActivity) MallHomeActivity.this).T, (Class<?>) OrderActivity.class));
                } else if (i6 == 1) {
                    MallHomeActivity.this.startActivity(new Intent(((BaseActivity) MallHomeActivity.this).T, (Class<?>) CollectGoodsActivity.class));
                } else {
                    if (i6 != 2) {
                        return;
                    }
                    MallHomeActivity.this.startActivity(new Intent(((BaseActivity) MallHomeActivity.this).T, (Class<?>) MyAddressListActivity.class));
                }
            }
        }

        d(final PopupWindow val$window) {
            this.f19229a = val$window;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, final int position) {
            new com.bxkj.base.auth.a(((BaseActivity) MallHomeActivity.this).T).i(new a(position)).b(MallHomeActivity.this.getSupportFragmentManager(), 0);
        }
    }

    private int[] p0(final View anchorView, final View contentView) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        anchorView.getLocationOnScreen(iArr2);
        int height = anchorView.getHeight();
        int i6 = u.K(this.T)[1];
        int i7 = u.K(this.T)[0];
        contentView.measure(0, 0);
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = contentView.getMeasuredWidth();
        int i8 = iArr2[1];
        if ((i6 - i8) - height < measuredHeight) {
            iArr[0] = i7 - measuredWidth;
            iArr[1] = i8 - measuredHeight;
            return iArr;
        }
        iArr[0] = i7 - measuredWidth;
        iArr[1] = i8 + height;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PopupWindow q0(View paramView) {
        View inflate = LayoutInflater.from(this.T).inflate(2131493630, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131298098);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.T));
        recyclerView.addItemDecoration(new b());
        ArrayList arrayList = new ArrayList();
        arrayList.add("我的订单");
        arrayList.add("我的收藏");
        arrayList.add("收货地址");
        c cVar = new c(this.T, R.layout.item_for_classify_name, arrayList);
        recyclerView.setAdapter(cVar);
        PopupWindow popupWindow = new PopupWindow(inflate, u.a(120.0f, this.T), -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(paramView, 53, 0, p0(paramView, this.W)[1]);
        cVar.k(new d(popupWindow));
        return popupWindow;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("商城");
        a0(2131689955, new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_mall_home;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
