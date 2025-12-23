package com.bxkj.student.home.physicaltest.rank;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.o;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class PhysicalTestRankActivity extends BaseActivity {

    @Nullable
    private EmptyRecyclerView W;

    @Nullable
    private CommonAdapter<Map<String, Object>> Y;

    @Nullable
    private RadioGroup Z;

    @NotNull
    private List<Map<String, Object>> X = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private int f18047a0 = 5;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, ? extends Object> map) {
            PhysicalTestRankActivity physicalTestRankActivity = PhysicalTestRankActivity.this;
            List<Map<String, Object>> list = JsonParse.getList(map, "meaScoreList");
            g0.o(list, "getList(...)");
            physicalTestRankActivity.X = list;
            CommonAdapter commonAdapter = PhysicalTestRankActivity.this.Y;
            if (commonAdapter != null) {
                commonAdapter.g(PhysicalTestRankActivity.this.X);
            }
            PhysicalTestRankActivity.this.n0(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(PhysicalTestRankActivity physicalTestRankActivity, RadioGroup radioGroup, int i6) {
        View childAt;
        View childAt2;
        View childAt3;
        View childAt4;
        View childAt5;
        RadioGroup radioGroup2 = physicalTestRankActivity.Z;
        if (radioGroup2 == null || (childAt5 = radioGroup2.getChildAt(0)) == null || i6 != childAt5.getId()) {
            RadioGroup radioGroup3 = physicalTestRankActivity.Z;
            if (radioGroup3 == null || (childAt4 = radioGroup3.getChildAt(1)) == null || i6 != childAt4.getId()) {
                RadioGroup radioGroup4 = physicalTestRankActivity.Z;
                if (radioGroup4 == null || (childAt3 = radioGroup4.getChildAt(2)) == null || i6 != childAt3.getId()) {
                    RadioGroup radioGroup5 = physicalTestRankActivity.Z;
                    if (radioGroup5 == null || (childAt2 = radioGroup5.getChildAt(3)) == null || i6 != childAt2.getId()) {
                        RadioGroup radioGroup6 = physicalTestRankActivity.Z;
                        if (radioGroup6 != null && (childAt = radioGroup6.getChildAt(4)) != null && i6 == childAt.getId()) {
                            physicalTestRankActivity.f18047a0 = 1;
                        }
                    } else {
                        physicalTestRankActivity.f18047a0 = 2;
                    }
                } else {
                    physicalTestRankActivity.f18047a0 = 3;
                }
            } else {
                physicalTestRankActivity.f18047a0 = 4;
            }
        } else {
            physicalTestRankActivity.f18047a0 = 5;
        }
        physicalTestRankActivity.S();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).Y0(this.f18047a0, LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("体测排名");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(Map<String, ? extends Object> map) {
        TextView textView = (TextView) findViewById(R.id.my_rank).findViewById(2131298991);
        ImageView imageView = (ImageView) findViewById(R.id.my_rank).findViewById(R.id.iv_no);
        int i6 = JsonParse.getInt(map, "myRank");
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (textView != null) {
                        textView.setText(JsonParse.getString(map, "myRank"));
                    }
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.transport);
                    }
                } else {
                    if (textView != null) {
                        textView.setText("");
                    }
                    if (imageView != null) {
                        imageView.setImageResource(R.mipmap.rank3);
                    }
                }
            } else {
                if (textView != null) {
                    textView.setText("");
                }
                if (imageView != null) {
                    imageView.setImageResource(R.mipmap.rank2);
                }
            }
        } else {
            if (textView != null) {
                textView.setText("");
            }
            if (imageView != null) {
                imageView.setImageResource(R.mipmap.rank1);
            }
        }
        String string = JsonParse.getString(map, CommonNetImpl.NAME);
        if (string.length() > 1) {
            g0.m(string);
            String substring = string.substring(0, 1);
            g0.o(substring, "substring(...)");
            string = substring + "同学";
        }
        TextView textView2 = (TextView) findViewById(2131298986);
        if (textView2 != null) {
            textView2.setText(string);
        }
        TextView textView3 = (TextView) findViewById(2131299093);
        if (textView3 != null) {
            textView3.setText(JsonParse.getString(map, "myScore"));
        }
        o.f(this.T, c0.f16887a.t(map, "myAvatar"), (ImageView) findViewById(2131297148), 2131689689, 2131689689);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_physical_test_rank;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(@Nullable Bundle bundle) {
        Integer num;
        View childAt;
        View findViewById = findViewById(2131298421);
        g0.n(findViewById, "null cannot be cast to non-null type cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView");
        this.W = (EmptyRecyclerView) findViewById;
        RadioGroup radioGroup = (RadioGroup) findViewById(2131298361);
        this.Z = radioGroup;
        if (radioGroup != null) {
            if (radioGroup != null && (childAt = radioGroup.getChildAt(0)) != null) {
                num = Integer.valueOf(childAt.getId());
            } else {
                num = null;
            }
            g0.m(num);
            radioGroup.check(num.intValue());
        }
        RadioGroup radioGroup2 = this.Z;
        if (radioGroup2 != null) {
            radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.home.physicaltest.rank.a
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup3, int i6) {
                    PhysicalTestRankActivity.m0(PhysicalTestRankActivity.this, radioGroup3, i6);
                }
            });
        }
        final Context context = this.T;
        final List<Map<String, Object>> list = this.X;
        CommonAdapter<Map<String, Object>> commonAdapter = new CommonAdapter<Map<String, Object>>(context, list) { // from class: com.bxkj.student.home.physicaltest.rank.PhysicalTestRankActivity$initViews$2
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public void c(ViewHolder viewHolder, Map<String, Object> map) {
                int e6 = e(viewHolder) + 1;
                if (e6 != 1) {
                    if (e6 != 2) {
                        if (e6 != 3) {
                            if (viewHolder != null) {
                                viewHolder.J(2131298991, String.valueOf(e6));
                            }
                            if (viewHolder != null) {
                                viewHolder.r(R.id.iv_no, R.drawable.transport);
                            }
                        } else {
                            if (viewHolder != null) {
                                viewHolder.J(2131298991, "");
                            }
                            if (viewHolder != null) {
                                viewHolder.r(R.id.iv_no, R.mipmap.rank3);
                            }
                        }
                    } else {
                        if (viewHolder != null) {
                            viewHolder.J(2131298991, "");
                        }
                        if (viewHolder != null) {
                            viewHolder.r(R.id.iv_no, R.mipmap.rank2);
                        }
                    }
                } else {
                    if (viewHolder != null) {
                        viewHolder.J(2131298991, "");
                    }
                    if (viewHolder != null) {
                        viewHolder.r(R.id.iv_no, R.mipmap.rank1);
                    }
                }
                String string = JsonParse.getString(map, CommonNetImpl.NAME);
                if (string.length() > 1) {
                    g0.m(string);
                    String substring = string.substring(0, 1);
                    g0.o(substring, "substring(...)");
                    string = substring + "同学";
                }
                if (viewHolder != null) {
                    viewHolder.J(2131298986, string);
                }
                if (viewHolder != null) {
                    viewHolder.J(2131299093, JsonParse.getString(map, "score"));
                }
                if (viewHolder != null) {
                    viewHolder.G(2131297148, JsonParse.getString(map, "avatar"), 2131689689, 2131689689);
                }
            }
        };
        this.Y = commonAdapter;
        EmptyRecyclerView emptyRecyclerView = this.W;
        if (emptyRecyclerView != null) {
            emptyRecyclerView.setAdapter(commonAdapter);
        }
        EmptyRecyclerView emptyRecyclerView2 = this.W;
        if (emptyRecyclerView2 != null) {
            emptyRecyclerView2.setEmptyView(findViewById(2131298892));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
