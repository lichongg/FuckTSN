package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.maps.TextureMapView;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.common.utils.h;
import com.bxkj.student.R;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.bxkj.student.run.app.utils.i;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.umeng.analytics.AnalyticsConfig;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FmV3SportsTraceBindingImpl extends FmV3SportsTraceBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    public FmV3SportsTraceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
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
            this.mDirtyFlags = 2L;
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
        sparseIntArray.put(R.id.map, 8);
        sparseIntArray.put(R.id.rpv, 9);
        sparseIntArray.put(2131298015, 10);
        sparseIntArray.put(R.id.card_bottom, 11);
        sparseIntArray.put(2131297148, 12);
        sparseIntArray.put(R.id.tv_distance_hint, 13);
        sparseIntArray.put(R.id.view_divider, 14);
    }

    private FmV3SportsTraceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialCardView) bindings[11], (ShapeableImageView) bindings[12], (LinearLayout) bindings[10], (TextureMapView) bindings[8], (RecordPathView) bindings[9], (TextView) bindings[2], (TextView) bindings[4], (TextView) bindings[13], (TextView) bindings[1], (TextView) bindings[5], (TextView) bindings[3], (TextView) bindings[6], (TextView) bindings[7], (View) bindings[14]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvAccount.setTag(null);
        this.tvDistance.setTag(null);
        this.tvName.setTag(null);
        this.tvPace.setTag(null);
        this.tvStartTime.setTag(null);
        this.tvStep.setTag(null);
        this.tvTime.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        long j7;
        long j8;
        Object obj;
        String str;
        Object obj2;
        String str2;
        String str3;
        Object obj3;
        Object obj4;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mDataMap;
        long j9 = j6 & 3;
        Object obj5 = null;
        if (j9 != 0) {
            long j10 = JsonParse.getLong(map, AnalyticsConfig.RTD_START_TIME);
            boolean z5 = map == null;
            long j11 = JsonParse.getLong(map, "sportTime", 0L);
            j7 = 0;
            double f6 = c0.f16887a.f(map, "sportRange");
            if (j9 != 0) {
                j6 |= z5 ? 8L : 4L;
            }
            if (map != null) {
                Object obj6 = map.get("userName");
                obj3 = map.get("speed");
                j8 = 3;
                obj2 = map.get("stepCount");
                obj5 = map.get("nickName");
                obj4 = obj6;
            } else {
                j8 = 3;
                obj4 = null;
                obj2 = null;
                obj3 = null;
            }
            str2 = i.h(j10, "");
            r10 = z5 ? 8 : 0;
            str3 = i.g(j11);
            str = h.f16899a.a(f6);
            Object obj7 = obj5;
            obj5 = obj4;
            obj = obj7;
        } else {
            j7 = 0;
            j8 = 3;
            obj = null;
            str = null;
            obj2 = null;
            str2 = null;
            str3 = null;
            obj3 = null;
        }
        if ((j6 & j8) != j7) {
            this.mboundView0.setVisibility(r10);
            TextViewBindingAdapter.setText(this.tvAccount, (CharSequence) obj5);
            TextViewBindingAdapter.setText(this.tvDistance, str);
            TextViewBindingAdapter.setText(this.tvName, (CharSequence) obj);
            TextViewBindingAdapter.setText(this.tvPace, (CharSequence) obj3);
            TextViewBindingAdapter.setText(this.tvStartTime, str2);
            TextViewBindingAdapter.setText(this.tvStep, (CharSequence) obj2);
            TextViewBindingAdapter.setText(this.tvTime, str3);
        }
    }

    @Override // com.bxkj.student.databinding.FmV3SportsTraceBinding
    public void setDataMap(@Nullable Map<String, Object> DataMap) {
        this.mDataMap = DataMap;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (8 != variableId) {
            return false;
        }
        setDataMap((Map) variable);
        return true;
    }
}
