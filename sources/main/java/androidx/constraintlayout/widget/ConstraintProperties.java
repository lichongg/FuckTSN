package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.beizi.fusion.widget.ScrollClickView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    ConstraintLayout.LayoutParams mParams;
    View mView;

    public ConstraintProperties addToHorizontalChain(int i6, int i7) {
        connect(1, i6, i6 == 0 ? 1 : 2, 0);
        connect(2, i7, i7 == 0 ? 2 : 1, 0);
        if (i6 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6)).connect(2, this.mView.getId(), 1, 0);
        }
        if (i7 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i7)).connect(1, this.mView.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i6, int i7) {
        connect(6, i6, i6 == 0 ? 6 : 7, 0);
        connect(7, i7, i7 == 0 ? 7 : 6, 0);
        if (i6 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6)).connect(7, this.mView.getId(), 6, 0);
        }
        if (i7 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i7)).connect(6, this.mView.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i6, int i7) {
        connect(3, i6, i6 == 0 ? 3 : 4, 0);
        connect(4, i7, i7 == 0 ? 4 : 3, 0);
        if (i6 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6)).connect(4, this.mView.getId(), 3, 0);
        }
        if (i7 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i7)).connect(3, this.mView.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties centerHorizontally(int i6, int i7, int i8, int i9, int i10, int i11, float f6) {
        connect(1, i6, i7, i8);
        connect(2, i9, i10, i11);
        this.mParams.horizontalBias = f6;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i6, int i7, int i8, int i9, int i10, int i11, float f6) {
        connect(6, i6, i7, i8);
        connect(7, i9, i10, i11);
        this.mParams.horizontalBias = f6;
        return this;
    }

    public ConstraintProperties centerVertically(int i6, int i7, int i8, int i9, int i10, int i11, float f6) {
        connect(3, i6, i7, i8);
        connect(4, i9, i10, i11);
        this.mParams.verticalBias = f6;
        return this;
    }

    public ConstraintProperties connect(int i6, int i7, int i8, int i9) {
        switch (i6) {
            case 1:
                if (i8 == 1) {
                    ConstraintLayout.LayoutParams layoutParams = this.mParams;
                    layoutParams.leftToLeft = i7;
                    layoutParams.leftToRight = -1;
                } else {
                    if (i8 != 2) {
                        throw new IllegalArgumentException("Left to " + sideToString(i8) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    layoutParams2.leftToRight = i7;
                    layoutParams2.leftToLeft = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i9;
                return this;
            case 2:
                if (i8 == 1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    layoutParams3.rightToLeft = i7;
                    layoutParams3.rightToRight = -1;
                } else {
                    if (i8 != 2) {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                    layoutParams4.rightToRight = i7;
                    layoutParams4.rightToLeft = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i9;
                return this;
            case 3:
                if (i8 == 3) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                    layoutParams5.topToTop = i7;
                    layoutParams5.topToBottom = -1;
                    layoutParams5.baselineToBaseline = -1;
                } else {
                    if (i8 != 4) {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                    layoutParams6.topToBottom = i7;
                    layoutParams6.topToTop = -1;
                    layoutParams6.baselineToBaseline = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i9;
                return this;
            case 4:
                if (i8 == 4) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                    layoutParams7.bottomToBottom = i7;
                    layoutParams7.bottomToTop = -1;
                    layoutParams7.baselineToBaseline = -1;
                } else {
                    if (i8 != 3) {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                    layoutParams8.bottomToTop = i7;
                    layoutParams8.bottomToBottom = -1;
                    layoutParams8.baselineToBaseline = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i9;
                return this;
            case 5:
                if (i8 != 5) {
                    throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                }
                ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                layoutParams9.baselineToBaseline = i7;
                layoutParams9.bottomToBottom = -1;
                layoutParams9.bottomToTop = -1;
                layoutParams9.topToTop = -1;
                layoutParams9.topToBottom = -1;
                return this;
            case 6:
                if (i8 == 6) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                    layoutParams10.startToStart = i7;
                    layoutParams10.startToEnd = -1;
                } else {
                    if (i8 != 7) {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                    layoutParams11.startToEnd = i7;
                    layoutParams11.startToStart = -1;
                }
                this.mParams.setMarginStart(i9);
                return this;
            case 7:
                if (i8 == 7) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                    layoutParams12.endToEnd = i7;
                    layoutParams12.endToStart = -1;
                } else {
                    if (i8 != 6) {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                    layoutParams13.endToStart = i7;
                    layoutParams13.endToEnd = -1;
                }
                this.mParams.setMarginEnd(i9);
                return this;
            default:
                throw new IllegalArgumentException(sideToString(i6) + " to " + sideToString(i8) + " unknown");
        }
    }

    public ConstraintProperties removeConstraints(int i6) {
        switch (i6) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.mParams;
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
                layoutParams.goneLeftMargin = -1;
                return this;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                layoutParams2.rightToRight = -1;
                layoutParams2.rightToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = -1;
                layoutParams2.goneRightMargin = -1;
                return this;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                layoutParams3.topToBottom = -1;
                layoutParams3.topToTop = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = -1;
                layoutParams3.goneTopMargin = -1;
                return this;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                layoutParams4.bottomToTop = -1;
                layoutParams4.bottomToBottom = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = -1;
                layoutParams4.goneBottomMargin = -1;
                return this;
            case 5:
                this.mParams.baselineToBaseline = -1;
                return this;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                layoutParams5.startToEnd = -1;
                layoutParams5.startToStart = -1;
                layoutParams5.setMarginStart(-1);
                this.mParams.goneStartMargin = -1;
                return this;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                layoutParams6.endToStart = -1;
                layoutParams6.endToEnd = -1;
                layoutParams6.setMarginEnd(-1);
                this.mParams.goneEndMargin = -1;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties alpha(float f6) {
        this.mView.setAlpha(f6);
        return this;
    }

    public ConstraintProperties center(int i6, int i7, int i8, int i9, int i10, int i11, float f6) {
        if (i8 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (f6 <= 0.0f || f6 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i7 == 1 || i7 == 2) {
            connect(1, i6, i7, i8);
            connect(2, i9, i10, i11);
            this.mParams.horizontalBias = f6;
            return this;
        }
        if (i7 == 6 || i7 == 7) {
            connect(6, i6, i7, i8);
            connect(7, i9, i10, i11);
            this.mParams.horizontalBias = f6;
            return this;
        }
        connect(3, i6, i7, i8);
        connect(4, i9, i10, i11);
        this.mParams.verticalBias = f6;
        return this;
    }

    public ConstraintProperties constrainDefaultHeight(int i6) {
        this.mParams.matchConstraintDefaultHeight = i6;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i6) {
        this.mParams.matchConstraintDefaultWidth = i6;
        return this;
    }

    public ConstraintProperties constrainHeight(int i6) {
        ((ViewGroup.MarginLayoutParams) this.mParams).height = i6;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i6) {
        this.mParams.matchConstraintMaxHeight = i6;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i6) {
        this.mParams.matchConstraintMaxWidth = i6;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i6) {
        this.mParams.matchConstraintMinHeight = i6;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i6) {
        this.mParams.matchConstraintMinWidth = i6;
        return this;
    }

    public ConstraintProperties constrainWidth(int i6) {
        ((ViewGroup.MarginLayoutParams) this.mParams).width = i6;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.mParams.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f6) {
        this.mView.setElevation(f6);
        return this;
    }

    public ConstraintProperties horizontalBias(float f6) {
        this.mParams.horizontalBias = f6;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i6) {
        this.mParams.horizontalChainStyle = i6;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f6) {
        this.mParams.horizontalWeight = f6;
        return this;
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i6 = layoutParams.leftToRight;
        int i7 = layoutParams.rightToLeft;
        if (i6 != -1 || i7 != -1) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i7));
            ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
            if (i6 != -1 && i7 != -1) {
                constraintProperties.connect(2, i7, 1, 0);
                constraintProperties2.connect(1, i6, 2, 0);
            } else if (i6 != -1 || i7 != -1) {
                int i8 = layoutParams2.rightToRight;
                if (i8 != -1) {
                    constraintProperties.connect(2, i8, 2, 0);
                } else {
                    int i9 = layoutParams2.leftToLeft;
                    if (i9 != -1) {
                        constraintProperties2.connect(1, i9, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
            return this;
        }
        int i10 = layoutParams.startToEnd;
        int i11 = layoutParams.endToStart;
        if (i10 != -1 || i11 != -1) {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i10));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i11));
            ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
            if (i10 != -1 && i11 != -1) {
                constraintProperties3.connect(7, i11, 6, 0);
                constraintProperties4.connect(6, i6, 7, 0);
            } else if (i6 != -1 || i11 != -1) {
                int i12 = layoutParams3.rightToRight;
                if (i12 != -1) {
                    constraintProperties3.connect(7, i12, 7, 0);
                } else {
                    int i13 = layoutParams3.leftToLeft;
                    if (i13 != -1) {
                        constraintProperties4.connect(6, i13, 6, 0);
                    }
                }
            }
        }
        removeConstraints(6);
        removeConstraints(7);
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i6 = layoutParams.topToBottom;
        int i7 = layoutParams.bottomToTop;
        if (i6 != -1 || i7 != -1) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i7));
            ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
            if (i6 != -1 && i7 != -1) {
                constraintProperties.connect(4, i7, 3, 0);
                constraintProperties2.connect(3, i6, 4, 0);
            } else if (i6 != -1 || i7 != -1) {
                int i8 = layoutParams2.bottomToBottom;
                if (i8 != -1) {
                    constraintProperties.connect(4, i8, 4, 0);
                } else {
                    int i9 = layoutParams2.topToTop;
                    if (i9 != -1) {
                        constraintProperties2.connect(3, i9, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f6) {
        this.mView.setRotation(f6);
        return this;
    }

    public ConstraintProperties rotationX(float f6) {
        this.mView.setRotationX(f6);
        return this;
    }

    public ConstraintProperties rotationY(float f6) {
        this.mView.setRotationY(f6);
        return this;
    }

    public ConstraintProperties scaleX(float f6) {
        this.mView.setScaleY(f6);
        return this;
    }

    public ConstraintProperties transformPivot(float f6, float f7) {
        this.mView.setPivotX(f6);
        this.mView.setPivotY(f7);
        return this;
    }

    public ConstraintProperties transformPivotX(float f6) {
        this.mView.setPivotX(f6);
        return this;
    }

    public ConstraintProperties transformPivotY(float f6) {
        this.mView.setPivotY(f6);
        return this;
    }

    public ConstraintProperties translation(float f6, float f7) {
        this.mView.setTranslationX(f6);
        this.mView.setTranslationY(f7);
        return this;
    }

    public ConstraintProperties translationX(float f6) {
        this.mView.setTranslationX(f6);
        return this;
    }

    public ConstraintProperties translationY(float f6) {
        this.mView.setTranslationY(f6);
        return this;
    }

    public ConstraintProperties translationZ(float f6) {
        this.mView.setTranslationZ(f6);
        return this;
    }

    public ConstraintProperties verticalBias(float f6) {
        this.mParams.verticalBias = f6;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i6) {
        this.mParams.verticalChainStyle = i6;
        return this;
    }

    public ConstraintProperties verticalWeight(float f6) {
        this.mParams.verticalWeight = f6;
        return this;
    }

    public ConstraintProperties visibility(int i6) {
        this.mView.setVisibility(i6);
        return this;
    }

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mParams = (ConstraintLayout.LayoutParams) layoutParams;
            this.mView = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int i6) {
        switch (i6) {
            case 1:
                return ScrollClickView.DIR_LEFT;
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public ConstraintProperties goneMargin(int i6, int i7) {
        switch (i6) {
            case 1:
                this.mParams.goneLeftMargin = i7;
                return this;
            case 2:
                this.mParams.goneRightMargin = i7;
                return this;
            case 3:
                this.mParams.goneTopMargin = i7;
                return this;
            case 4:
                this.mParams.goneBottomMargin = i7;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.goneStartMargin = i7;
                return this;
            case 7:
                this.mParams.goneEndMargin = i7;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties margin(int i6, int i7) {
        switch (i6) {
            case 1:
                ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i7;
                return this;
            case 2:
                ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i7;
                return this;
            case 3:
                ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i7;
                return this;
            case 4:
                ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i7;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.setMarginStart(i7);
                return this;
            case 7:
                this.mParams.setMarginEnd(i7);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties centerHorizontally(int i6) {
        if (i6 == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
            return this;
        }
        center(i6, 2, 0, i6, 1, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i6) {
        if (i6 == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
            return this;
        }
        center(i6, 7, 0, i6, 6, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerVertically(int i6) {
        if (i6 == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
            return this;
        }
        center(i6, 4, 0, i6, 3, 0, 0.5f);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties scaleY(float f6) {
        return this;
    }
}
