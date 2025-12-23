package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Dimension {
    private final int WRAP_CONTENT;
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    float mRatio;
    int mValue;
    public static final Object FIXED_DIMENSION = new Object();
    public static final Object WRAP_DIMENSION = new Object();
    public static final Object SPREAD_DIMENSION = new Object();
    public static final Object PARENT_DIMENSION = new Object();
    public static final Object PERCENT_DIMENSION = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    public static Dimension Fixed(int i6) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i6);
        return dimension;
    }

    public static Dimension Suggested(int i6) {
        Dimension dimension = new Dimension();
        dimension.suggested(i6);
        return dimension;
    }

    public Dimension fixed(Object obj) {
        this.mInitialValue = obj;
        if (obj instanceof Integer) {
            this.mValue = ((Integer) obj).intValue();
            this.mInitialValue = null;
        }
        return this;
    }

    public Dimension max(int i6) {
        if (this.mMax >= 0) {
            this.mMax = i6;
        }
        return this;
    }

    public Dimension min(int i6) {
        if (i6 >= 0) {
            this.mMin = i6;
        }
        return this;
    }

    void setValue(int i6) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = i6;
    }

    public Dimension suggested(int i6) {
        this.mIsSuggested = true;
        return this;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object obj, float f6) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f6);
        return dimension;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    float getRatio() {
        return this.mRatio;
    }

    int getValue() {
        return this.mValue;
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.mMin = -2;
        }
        return this;
    }

    public Dimension percent(Object obj, float f6) {
        this.mPercent = f6;
        return this;
    }

    void setRatio(float f6) {
        this.mRatio = f6;
    }

    public Dimension suggested(Object obj) {
        this.mInitialValue = obj;
        this.mIsSuggested = true;
        return this;
    }

    public static Dimension Fixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public static Dimension Suggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i6) {
        int i7 = 2;
        if (i6 == 0) {
            if (this.mIsSuggested) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.mInitialValue;
                if (obj == WRAP_DIMENSION) {
                    i7 = 1;
                } else if (obj != PERCENT_DIMENSION) {
                    i7 = 0;
                }
                constraintWidget.setHorizontalMatchStyle(i7, this.mMin, this.mMax, this.mPercent);
                return;
            }
            int i8 = this.mMin;
            if (i8 > 0) {
                constraintWidget.setMinWidth(i8);
            }
            int i9 = this.mMax;
            if (i9 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i9);
            }
            Object obj2 = this.mInitialValue;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                return;
            }
            if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                return;
            } else {
                if (obj2 == null) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.setWidth(this.mValue);
                    return;
                }
                return;
            }
        }
        if (this.mIsSuggested) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.mInitialValue;
            if (obj3 == WRAP_DIMENSION) {
                i7 = 1;
            } else if (obj3 != PERCENT_DIMENSION) {
                i7 = 0;
            }
            constraintWidget.setVerticalMatchStyle(i7, this.mMin, this.mMax, this.mPercent);
            return;
        }
        int i10 = this.mMin;
        if (i10 > 0) {
            constraintWidget.setMinHeight(i10);
        }
        int i11 = this.mMax;
        if (i11 < Integer.MAX_VALUE) {
            constraintWidget.setMaxHeight(i11);
        }
        Object obj4 = this.mInitialValue;
        if (obj4 == WRAP_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            return;
        }
        if (obj4 == PARENT_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        } else if (obj4 == null) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setHeight(this.mValue);
        }
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.mIsSuggested) {
            this.mInitialValue = obj2;
            this.mMax = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension fixed(int i6) {
        this.mInitialValue = null;
        this.mValue = i6;
        return this;
    }

    private Dimension(Object obj) {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mIsSuggested = false;
        this.mInitialValue = obj;
    }

    public Dimension ratio(float f6) {
        return this;
    }
}
