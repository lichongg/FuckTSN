package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ChainReference extends HelperReference {
    protected float mBias;
    protected State.Chain mStyle;

    public void bias(float f6) {
        this.mBias = f6;
    }

    public float getBias() {
        return this.mBias;
    }

    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    public void style(State.Chain chain) {
        this.mStyle = chain;
    }

    public ChainReference(State state, State.Helper helper) {
        super(state, helper);
        this.mBias = 0.5f;
        this.mStyle = State.Chain.SPREAD;
    }
}
