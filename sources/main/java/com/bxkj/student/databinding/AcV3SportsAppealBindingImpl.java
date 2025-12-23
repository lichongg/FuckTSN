package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import cn.bluemobi.dylan.base.view.MyGridView;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV3SportsAppealBindingImpl extends AcV3SportsAppealBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final LinearLayout mboundView0;

    public AcV3SportsAppealBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        b bVar = this.mBackEvent;
        if ((6 & j6) != 0) {
            this.titleLayout.setActivity(bVar);
        }
        if ((j6 & 4) != 0) {
            this.titleLayout.setTitle("跑步申诉");
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

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (4 != variableId) {
            return false;
        }
        setBackEvent((b) variable);
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v3_pub_title"}, new int[]{1}, new int[]{R.layout.v3_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131296947, 2);
        sparseIntArray.put(2131297030, 3);
        sparseIntArray.put(2131296599, 4);
    }

    private AcV3SportsAppealBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[4], (EditText) bindings[2], (MyGridView) bindings[3], (V3PubTitleBinding) bindings[1]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        setRootTag(root);
        invalidateAll();
    }

    private boolean onChangeTitleLayout(V3PubTitleBinding TitleLayout, int fieldId) {
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
        return onChangeTitleLayout((V3PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcV3SportsAppealBinding
    public void setBackEvent(@Nullable b BackEvent) {
        this.mBackEvent = BackEvent;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }
}
