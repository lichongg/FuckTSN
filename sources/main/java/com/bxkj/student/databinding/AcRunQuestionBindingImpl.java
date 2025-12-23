package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.run.app.exam.QuestionActivity;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcRunQuestionBindingImpl extends AcRunQuestionBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback4;
    private long mDirtyFlags;

    @NonNull
    private final RelativeLayout mboundView0;

    @NonNull
    private final ScrollView mboundView1;

    @NonNull
    private final RadioButton mboundView3;

    @NonNull
    private final RadioButton mboundView4;

    @NonNull
    private final RadioButton mboundView5;

    @NonNull
    private final RadioButton mboundView6;

    public AcRunQuestionBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return this.layoutTitle.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
        }
        this.layoutTitle.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (5 == variableId) {
            setCheckedId((Integer) variable);
            return true;
        }
        if (13 == variableId) {
            setIsShowRightAnswer((Boolean) variable);
            return true;
        }
        if (7 == variableId) {
            setData((Map) variable);
            return true;
        }
        if (3 == variableId) {
            setAnswer((List) variable);
            return true;
        }
        if (1 != variableId) {
            return false;
        }
        setActivity((QuestionActivity) variable);
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"pub_title"}, new int[]{9}, new int[]{R.layout.pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131299171, 10);
        sparseIntArray.put(2131299093, 11);
        sparseIntArray.put(R.id.tv_question, 12);
        sparseIntArray.put(R.id.rg_answer, 13);
    }

    private AcRunQuestionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (PubTitleBinding) bindings[9], (RadioGroup) bindings[13], (Button) bindings[8], (TextView) bindings[2], (TextView) bindings[12], (TextView) bindings[7], (TextView) bindings[11], (TextView) bindings[10]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.layoutTitle);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[1];
        this.mboundView1 = scrollView;
        scrollView.setTag(null);
        RadioButton radioButton = (RadioButton) bindings[3];
        this.mboundView3 = radioButton;
        radioButton.setTag(null);
        RadioButton radioButton2 = (RadioButton) bindings[4];
        this.mboundView4 = radioButton2;
        radioButton2.setTag(null);
        RadioButton radioButton3 = (RadioButton) bindings[5];
        this.mboundView5 = radioButton3;
        radioButton3.setTag(null);
        RadioButton radioButton4 = (RadioButton) bindings[6];
        this.mboundView6 = radioButton4;
        radioButton4.setTag(null);
        this.tbCommit.setTag(null);
        this.tvIndex.setTag(null);
        this.tvRightAnswer.setTag(null);
        setRootTag(root);
        this.mCallback4 = new a(this, 1);
        invalidateAll();
    }

    private boolean onChangeLayoutTitle(PubTitleBinding LayoutTitle, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        QuestionActivity questionActivity = this.mActivity;
        if (questionActivity != null) {
            questionActivity.M();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.databinding.AcRunQuestionBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeLayoutTitle((PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setActivity(@Nullable QuestionActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setAnswer(@Nullable List<Map<String, Object>> Answer) {
        this.mAnswer = Answer;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setCheckedId(@Nullable Integer CheckedId) {
        this.mCheckedId = CheckedId;
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setData(@Nullable Map<String, Object> Data) {
        this.mData = Data;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setIsShowRightAnswer(@Nullable Boolean IsShowRightAnswer) {
        this.mIsShowRightAnswer = IsShowRightAnswer;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.layoutTitle.setLifecycleOwner(lifecycleOwner);
    }
}
