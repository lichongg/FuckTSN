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
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.R;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.base.v2.common.utils.e0;
import com.bxkj.base.v2.common.view.b;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV2SportsRankBindingImpl extends AcV2SportsRankBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    @NonNull
    private final LinearLayout mboundView1;

    public AcV2SportsRankBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return this.titleLayout.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
        }
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"new_pub_title"}, new int[]{6}, new int[]{R.layout.new_pub_title});
        sViewsWithIds = null;
    }

    private AcV2SportsRankBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (NewPubTitleBinding) bindings[6], (TextView) bindings[2], (TextView) bindings[4], (TextView) bindings[3], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        this.tvRunClassRank.setTag(null);
        this.tvRunDepartmentRank.setTag(null);
        this.tvRunMajorRank.setTag(null);
        this.tvRunSchoolRank.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    private boolean onChangeTitleLayout(NewPubTitleBinding TitleLayout, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        String str;
        String str2;
        String str3;
        Object obj;
        Object obj2;
        Object obj3;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, Object> map = this.mDataMap;
        b bVar = this.mMActvity;
        long j7 = j6 & 10;
        String str4 = null;
        Object obj4 = null;
        if (j7 != 0) {
            if (map != null) {
                obj4 = map.get("majorRank");
                obj = map.get("deptRank");
                obj2 = map.get("schoolRank");
                obj3 = map.get("clazzRank");
            } else {
                obj = null;
                obj2 = null;
                obj3 = null;
            }
            boolean z5 = map == null;
            if (j7 != 0) {
                j6 |= z5 ? 32L : 16L;
            }
            String a6 = e0.a(obj4);
            str2 = e0.a(obj);
            str3 = e0.a(obj2);
            String a7 = e0.a(obj3);
            r11 = z5 ? 8 : 0;
            str = a6;
            str4 = a7;
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        long j8 = 12 & j6;
        if ((10 & j6) != 0) {
            this.mboundView1.setVisibility(r11);
            TextViewBindingAdapter.setText(this.tvRunClassRank, str4);
            TextViewBindingAdapter.setText(this.tvRunDepartmentRank, str2);
            TextViewBindingAdapter.setText(this.tvRunMajorRank, str);
            TextViewBindingAdapter.setText(this.tvRunSchoolRank, str3);
        }
        if (j8 != 0) {
            this.titleLayout.setActivity(bVar);
        }
        if ((j6 & 8) != 0) {
            this.titleLayout.setTitle("锻炼排名");
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeTitleLayout((NewPubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcV2SportsRankBinding
    public void setDataMap(@Nullable Map<String, Object> DataMap) {
        this.mDataMap = DataMap;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV2SportsRankBinding
    public void setMActvity(@Nullable b MActvity) {
        this.mMActvity = MActvity;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (8 == variableId) {
            setDataMap((Map) variable);
            return true;
        }
        if (18 != variableId) {
            return false;
        }
        setMActvity((b) variable);
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }
}
