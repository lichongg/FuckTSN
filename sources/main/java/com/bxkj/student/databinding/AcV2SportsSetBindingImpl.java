package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.R;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.set.SportsSetActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV2SportsSetBindingImpl extends AcV2SportsSetBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback38;

    @Nullable
    private final View.OnClickListener mCallback39;

    @Nullable
    private final View.OnClickListener mCallback40;

    @Nullable
    private final View.OnClickListener mCallback41;

    @Nullable
    private final View.OnClickListener mCallback42;

    @Nullable
    private final View.OnClickListener mCallback43;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    public AcV2SportsSetBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SportsSetActivity sportsSetActivity = this.mMSportsSetActivity;
        if ((6 & j6) != 0) {
            this.titleLayout.setActivity(sportsSetActivity);
        }
        if ((j6 & 4) != 0) {
            this.titleLayout.setTitle("锻炼设置");
            this.tvDescription.setOnClickListener(this.mCallback38);
            this.tvPermissionSet.setOnClickListener(this.mCallback42);
            this.tvRank.setOnClickListener(this.mCallback40);
            this.tvRecord.setOnClickListener(this.mCallback39);
            this.tvSoundSet.setOnClickListener(this.mCallback43);
            this.tvStatistics.setOnClickListener(this.mCallback41);
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
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
            this.mDirtyFlags = 4L;
        }
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"new_pub_title"}, new int[]{7}, new int[]{R.layout.new_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.bxkj.student.R.id.tv_question, 8);
    }

    private AcV2SportsSetBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (NewPubTitleBinding) bindings[7], (TextView) bindings[1], (TextView) bindings[5], (TextView) bindings[8], (TextView) bindings[3], (TextView) bindings[2], (TextView) bindings[6], (TextView) bindings[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        this.tvDescription.setTag(null);
        this.tvPermissionSet.setTag(null);
        this.tvRank.setTag(null);
        this.tvRecord.setTag(null);
        this.tvSoundSet.setTag(null);
        this.tvStatistics.setTag(null);
        setRootTag(root);
        this.mCallback38 = new a(this, 1);
        this.mCallback39 = new a(this, 2);
        this.mCallback43 = new a(this, 6);
        this.mCallback41 = new a(this, 4);
        this.mCallback42 = new a(this, 5);
        this.mCallback40 = new a(this, 3);
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
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeTitleLayout((NewPubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcV2SportsSetBinding
    public void setMSportsSetActivity(@Nullable SportsSetActivity MSportsSetActivity) {
        this.mMSportsSetActivity = MSportsSetActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (19 != variableId) {
            return false;
        }
        setMSportsSetActivity((SportsSetActivity) variable);
        return true;
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                SportsSetActivity sportsSetActivity = this.mMSportsSetActivity;
                if (sportsSetActivity != null) {
                    sportsSetActivity.M();
                    break;
                }
                break;
            case 2:
                SportsSetActivity sportsSetActivity2 = this.mMSportsSetActivity;
                if (sportsSetActivity2 != null) {
                    sportsSetActivity2.P();
                    break;
                }
                break;
            case 3:
                SportsSetActivity sportsSetActivity3 = this.mMSportsSetActivity;
                if (sportsSetActivity3 != null) {
                    sportsSetActivity3.N();
                    break;
                }
                break;
            case 4:
                SportsSetActivity sportsSetActivity4 = this.mMSportsSetActivity;
                if (sportsSetActivity4 != null) {
                    sportsSetActivity4.R();
                    break;
                }
                break;
            case 5:
                SportsSetActivity sportsSetActivity5 = this.mMSportsSetActivity;
                if (sportsSetActivity5 != null) {
                    sportsSetActivity5.S();
                    break;
                }
                break;
            case 6:
                SportsSetActivity sportsSetActivity6 = this.mMSportsSetActivity;
                if (sportsSetActivity6 != null) {
                    sportsSetActivity6.Q();
                    break;
                }
                break;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }
}
