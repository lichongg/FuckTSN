package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState = -1;
    int mCurrentStateId = -1;
    int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public int findMatch(float f6, float f7) {
            for (int i6 = 0; i6 < this.mVariants.size(); i6++) {
                if (this.mVariants.get(i6).match(f6, f7)) {
                    return i6;
                }
            }
            return -1;
        }

        void add(Variant variant) {
            this.mVariants.add(variant);
        }

        public State(Context context, XmlPullParser xmlPullParser) {
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == R.styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (ResIdentify.RES_TYPE_LAYOUT.equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Variant {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        boolean match(float f6, float f7) {
            if (!Float.isNaN(this.mMinWidth) && f6 < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f7 < this.mMinHeight) {
                return false;
            }
            if (Float.isNaN(this.mMaxWidth) || f6 <= this.mMaxWidth) {
                return Float.isNaN(this.mMaxHeight) || f7 <= this.mMaxHeight;
            }
            return false;
        }

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (ResIdentify.RES_TYPE_LAYOUT.equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public int stateGetConstraintID(int i6, int i7, int i8) {
        return updateConstraints(-1, i6, i7, i8);
    }

    public int updateConstraints(int i6, int i7, float f6, float f7) {
        int findMatch;
        if (i6 == i7) {
            State valueAt = i7 == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(this.mCurrentStateId);
            if (valueAt == null) {
                return -1;
            }
            return ((this.mCurrentConstraintNumber == -1 || !valueAt.mVariants.get(i6).match(f6, f7)) && i6 != (findMatch = valueAt.findMatch(f6, f7))) ? findMatch == -1 ? valueAt.mConstraintID : valueAt.mVariants.get(findMatch).mConstraintID : i6;
        }
        State state = this.mStateList.get(i7);
        if (state == null) {
            return -1;
        }
        int findMatch2 = state.findMatch(f6, f7);
        return findMatch2 == -1 ? state.mConstraintID : state.mVariants.get(findMatch2).mConstraintID;
    }

    public int convertToConstraintSet(int i6, int i7, float f6, float f7) {
        State state = this.mStateList.get(i7);
        if (state == null) {
            return i7;
        }
        if (f6 != -1.0f && f7 != -1.0f) {
            Iterator<Variant> it = state.mVariants.iterator();
            Variant variant = null;
            while (it.hasNext()) {
                Variant next = it.next();
                if (next.match(f6, f7)) {
                    if (i6 != next.mConstraintID) {
                        variant = next;
                    }
                }
            }
            return variant != null ? variant.mConstraintID : state.mConstraintID;
        }
        if (state.mConstraintID != i6) {
            Iterator<Variant> it2 = state.mVariants.iterator();
            while (it2.hasNext()) {
                if (i6 == it2.next().mConstraintID) {
                }
            }
            return state.mConstraintID;
        }
        return i6;
    }

    public boolean needsToChange(int i6, float f6, float f7) {
        int i7 = this.mCurrentStateId;
        if (i7 != i6) {
            return true;
        }
        State valueAt = i6 == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i7);
        int i8 = this.mCurrentConstraintNumber;
        return (i8 == -1 || !valueAt.mVariants.get(i8).match(f6, f7)) && this.mCurrentConstraintNumber != valueAt.findMatch(f6, f7);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void load(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = obtainStyledAttributes.getIndex(i6);
            if (index == R.styleable.StateSet_defaultState) {
                this.mDefaultState = obtainStyledAttributes.getResourceId(index, this.mDefaultState);
            }
        }
        try {
            int eventType = xmlPullParser.getEventType();
            State state = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        if (eventType != 3) {
                            continue;
                        } else if ("StateSet".equals(xmlPullParser.getName())) {
                            return;
                        }
                    } else {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case 80204913:
                                if (name.equals("State")) {
                                    state = new State(context, xmlPullParser);
                                    this.mStateList.put(state.mId, state);
                                    break;
                                } else {
                                    break;
                                }
                            case 1301459538:
                                name.equals("LayoutDescription");
                                break;
                            case 1382829617:
                                name.equals("StateSet");
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    Variant variant = new Variant(context, xmlPullParser);
                                    if (state != null) {
                                        state.add(variant);
                                        break;
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        } catch (XmlPullParserException e7) {
            e7.printStackTrace();
        }
    }
}
