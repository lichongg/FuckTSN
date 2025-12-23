package com.bxkj.student.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.common.utils.g;
import com.bxkj.base.v2.common.utils.h;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.utils.u;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment;
import com.umeng.analytics.AnalyticsConfig;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V3ItemForInvalidRecordListBindingImpl extends V3ItemForInvalidRecordListBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback69;

    @Nullable
    private final View.OnClickListener mCallback70;
    private long mDirtyFlags;

    @NonNull
    private final LinearLayout mboundView0;

    @NonNull
    private final LinearLayout mboundView2;

    @NonNull
    private final LinearLayout mboundView4;

    @NonNull
    private final LinearLayout mboundView7;

    public V3ItemForInvalidRecordListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3RecordInValidFragment v3RecordInValidFragment = this.mMActivity;
            Map<String, ? extends Object> map = this.mMap;
            if (v3RecordInValidFragment != null) {
                v3RecordInValidFragment.V(map);
                return;
            }
            return;
        }
        if (sourceId != 2) {
            return;
        }
        V3RecordInValidFragment v3RecordInValidFragment2 = this.mMActivity;
        Map<String, ? extends Object> map2 = this.mMap;
        if (v3RecordInValidFragment2 != null) {
            v3RecordInValidFragment2.R(map2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.mDirtyFlags != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296684, 12);
        sparseIntArray.put(2131298991, 13);
        sparseIntArray.put(R.id.bt_appeal, 14);
        sparseIntArray.put(R.id.ll_question, 15);
        sparseIntArray.put(R.id.iv_question, 16);
        sparseIntArray.put(2131297100, 17);
    }

    private V3ItemForInvalidRecordListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[14], (Button) bindings[10], (CardView) bindings[12], (ImageView) bindings[17], (ImageView) bindings[16], (LinearLayout) bindings[15], (TextView) bindings[1], (TextView) bindings[5], (TextView) bindings[13], (TextView) bindings[3], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[6], (TextView) bindings[11]);
        this.mDirtyFlags = -1L;
        this.btFace.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[2];
        this.mboundView2 = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[4];
        this.mboundView4 = linearLayout3;
        linearLayout3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) bindings[7];
        this.mboundView7 = linearLayout4;
        linearLayout4.setTag(null);
        this.status.setTag(null);
        this.tvDistance.setTag(null);
        this.tvStartTime.setTag(null);
        this.tvStatus.setTag(null);
        this.tvStepCount.setTag(null);
        this.tvTimeCount.setTag(null);
        this.tvUploadType.setTag(null);
        setRootTag(root);
        this.mCallback70 = new a(this, 2);
        this.mCallback69 = new a(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        long j7;
        long j8;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mMap;
        long j9 = j6 & 5;
        Drawable drawable = null;
        Object obj5 = null;
        if (j9 != 0) {
            if (map != null) {
                obj5 = map.get("stepNumbers");
                obj2 = map.get(AnalyticsConfig.RTD_START_TIME);
                obj3 = map.get("sportTypeName");
                obj4 = map.get(NotificationCompat.CATEGORY_STATUS);
                obj = map.get("remark");
            } else {
                obj2 = null;
                obj3 = null;
                obj4 = null;
                obj = null;
            }
            long j10 = JsonParse.getLong(map, "sportTime");
            j7 = 0;
            c0 c0Var = c0.f16887a;
            int k6 = c0Var.k(map, "sportType");
            j8 = 5;
            double f6 = c0Var.f(map, "sportRange");
            int i6 = JsonParse.getInt(map, "uploadType");
            String valueOf = String.valueOf(obj5);
            String a6 = g.a(obj2);
            String str7 = obj3 + " ";
            String g6 = i.g(j10);
            boolean z5 = k6 == 5;
            String a7 = h.f16899a.a(f6);
            String a8 = u.a(i6);
            if (j9 != 0) {
                j6 |= z5 ? 16L : 8L;
            }
            boolean equals = obj4 != null ? obj4.equals("1") : false;
            if ((j6 & 5) != 0) {
                j6 |= equals ? 320L : 160L;
            }
            int t5 = i.t(valueOf);
            str6 = str7 + a6;
            r10 = z5 ? 8 : 0;
            str3 = a7 + "KM";
            String str8 = "上传方式:" + a8;
            Drawable drawable2 = AppCompatResources.getDrawable(this.status.getContext(), equals ? R.drawable.round_blue : R.drawable.red_round);
            str5 = equals ? "√" : "×";
            str2 = String.valueOf(t5);
            str4 = str8;
            str = g6;
            drawable = drawable2;
        } else {
            j7 = 0;
            j8 = 5;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            obj = null;
        }
        if ((4 & j6) != j7) {
            this.btFace.setOnClickListener(this.mCallback70);
            this.mboundView2.setOnClickListener(this.mCallback69);
        }
        if ((j6 & j8) != j7) {
            this.mboundView4.setVisibility(r10);
            this.mboundView7.setVisibility(r10);
            ViewBindingAdapter.setBackground(this.status, drawable);
            TextViewBindingAdapter.setText(this.status, str5);
            TextViewBindingAdapter.setText(this.tvDistance, str3);
            TextViewBindingAdapter.setText(this.tvStartTime, str6);
            TextViewBindingAdapter.setText(this.tvStatus, (CharSequence) obj);
            TextViewBindingAdapter.setText(this.tvStepCount, str2);
            TextViewBindingAdapter.setText(this.tvTimeCount, str);
            this.tvUploadType.setText(str4);
        }
    }

    @Override // com.bxkj.student.databinding.V3ItemForInvalidRecordListBinding
    public void setMActivity(@Nullable V3RecordInValidFragment MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3ItemForInvalidRecordListBinding
    public void setMap(@Nullable Map<String, Object> Map) {
        this.mMap = Map;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (20 == variableId) {
            setMap((Map) variable);
            return true;
        }
        if (17 != variableId) {
            return false;
        }
        setMActivity((V3RecordInValidFragment) variable);
        return true;
    }
}
