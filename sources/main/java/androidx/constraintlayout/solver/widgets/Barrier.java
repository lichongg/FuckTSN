package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private int mBarrierType = 0;
    private boolean mAllowsGoneWidget = true;
    private int mMargin = 0;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    protected void markWidgets() {
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            ConstraintWidget constraintWidget = this.mWidgets[i6];
            int i7 = this.mBarrierType;
            if (i7 == 0 || i7 == 1) {
                constraintWidget.setInBarrier(0, true);
            } else if (i7 == 2 || i7 == 3) {
                constraintWidget.setInBarrier(1, true);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z5;
        int i6;
        int i7;
        int i8;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i9 = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i9 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i9];
            constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
            i9++;
        }
        int i10 = this.mBarrierType;
        if (i10 < 0 || i10 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i10];
        for (int i11 = 0; i11 < this.mWidgetsCount; i11++) {
            ConstraintWidget constraintWidget = this.mWidgets[i11];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i7 = this.mBarrierType) == 0 || i7 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i8 = this.mBarrierType) == 2 || i8 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z5 = true;
                break;
            }
        }
        z5 = false;
        boolean z6 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
        boolean z7 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
        int i12 = !(!z5 && (((i6 = this.mBarrierType) == 0 && z6) || ((i6 == 2 && z7) || ((i6 == 1 && z6) || (i6 == 3 && z7))))) ? 4 : 5;
        for (int i13 = 0; i13 < this.mWidgetsCount; i13++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i13];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                int i14 = this.mBarrierType;
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i14];
                constraintAnchor3.mSolverVariable = createObjectVariable;
                ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                int i15 = (constraintAnchor4 == null || constraintAnchor4.mOwner != this) ? 0 : constraintAnchor3.mMargin;
                if (i14 == 0 || i14 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin - i15, z5);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i15, z5);
                }
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i15, i12);
            }
        }
        int i16 = this.mBarrierType;
        if (i16 == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            return;
        }
        if (i16 == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        } else if (i16 == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        } else if (i16 == 3) {
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public void setAllowsGoneWidget(boolean z5) {
        this.mAllowsGoneWidget = z5;
    }

    public void setBarrierType(int i6) {
        this.mBarrierType = i6;
    }

    public void setMargin(int i6) {
        this.mMargin = i6;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            ConstraintWidget constraintWidget = this.mWidgets[i6];
            if (i6 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.getDebugName();
        }
        return str + "}";
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }
}
