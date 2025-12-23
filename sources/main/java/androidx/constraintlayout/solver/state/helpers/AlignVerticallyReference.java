package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = this.mState.constraints(it.next());
            constraints.clearVertical();
            Object obj = this.mTopToTop;
            if (obj != null) {
                constraints.topToTop(obj);
            } else {
                Object obj2 = this.mTopToBottom;
                if (obj2 != null) {
                    constraints.topToBottom(obj2);
                } else {
                    constraints.topToTop(State.PARENT);
                }
            }
            Object obj3 = this.mBottomToTop;
            if (obj3 != null) {
                constraints.bottomToTop(obj3);
            } else {
                Object obj4 = this.mBottomToBottom;
                if (obj4 != null) {
                    constraints.bottomToBottom(obj4);
                } else {
                    constraints.bottomToBottom(State.PARENT);
                }
            }
            float f6 = this.mBias;
            if (f6 != 0.5f) {
                constraints.verticalBias(f6);
            }
        }
    }

    public void bias(float f6) {
        this.mBias = f6;
    }

    public void bottomToBottom(Object obj) {
        this.mBottomToBottom = obj;
    }

    public void bottomToTop(Object obj) {
        this.mBottomToTop = obj;
    }

    public void topToBottom(Object obj) {
        this.mTopToBottom = obj;
    }

    public void topToTop(Object obj) {
        this.mTopToTop = obj;
    }
}
