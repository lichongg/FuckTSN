package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    ConstraintSet mDefaultConstraintSet;
    int mCurrentStateId = -1;
    int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
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
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Variant {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (ResIdentify.RES_TYPE_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
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

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i6 = 0; i6 < attributeCount; i6++) {
            if ("id".equals(xmlPullParser.getAttributeName(i6))) {
                String attributeValue = xmlPullParser.getAttributeValue(i6);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1 && attributeValue.length() > 1) {
                    identifier = Integer.parseInt(attributeValue.substring(1));
                }
                constraintSet.load(context, xmlPullParser);
                this.mConstraintSetMap.put(identifier, constraintSet);
                return;
            }
        }
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

    public void updateConstraints(int i6, float f6, float f7) {
        int findMatch;
        int i7 = this.mCurrentStateId;
        if (i7 != i6) {
            this.mCurrentStateId = i6;
            State state = this.mStateList.get(i6);
            int findMatch2 = state.findMatch(f6, f7);
            ConstraintSet constraintSet = findMatch2 == -1 ? state.mConstraintSet : state.mVariants.get(findMatch2).mConstraintSet;
            int i8 = findMatch2 == -1 ? state.mConstraintID : state.mVariants.get(findMatch2).mConstraintID;
            if (constraintSet == null) {
                return;
            }
            this.mCurrentConstraintNumber = findMatch2;
            ConstraintsChangedListener constraintsChangedListener = this.mConstraintsChangedListener;
            if (constraintsChangedListener != null) {
                constraintsChangedListener.preLayoutChange(i6, i8);
            }
            constraintSet.applyTo(this.mConstraintLayout);
            ConstraintsChangedListener constraintsChangedListener2 = this.mConstraintsChangedListener;
            if (constraintsChangedListener2 != null) {
                constraintsChangedListener2.postLayoutChange(i6, i8);
                return;
            }
            return;
        }
        State valueAt = i6 == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i7);
        int i9 = this.mCurrentConstraintNumber;
        if ((i9 == -1 || !valueAt.mVariants.get(i9).match(f6, f7)) && this.mCurrentConstraintNumber != (findMatch = valueAt.findMatch(f6, f7))) {
            ConstraintSet constraintSet2 = findMatch == -1 ? this.mDefaultConstraintSet : valueAt.mVariants.get(findMatch).mConstraintSet;
            int i10 = findMatch == -1 ? valueAt.mConstraintID : valueAt.mVariants.get(findMatch).mConstraintID;
            if (constraintSet2 == null) {
                return;
            }
            this.mCurrentConstraintNumber = findMatch;
            ConstraintsChangedListener constraintsChangedListener3 = this.mConstraintsChangedListener;
            if (constraintsChangedListener3 != null) {
                constraintsChangedListener3.preLayoutChange(-1, i10);
            }
            constraintSet2.applyTo(this.mConstraintLayout);
            ConstraintsChangedListener constraintsChangedListener4 = this.mConstraintsChangedListener;
            if (constraintsChangedListener4 != null) {
                constraintsChangedListener4.postLayoutChange(-1, i10);
            }
        }
    }

    ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i6) {
        this.mConstraintLayout = constraintLayout;
        load(context, i6);
    }

    private void load(Context context, int i6) {
        String str;
        XmlResourceParser xml = context.getResources().getXml(i6);
        try {
            State state = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    parseConstraintSet(context, xml);
                                    break;
                                } else {
                                    break;
                                }
                            case 80204913:
                                if (name.equals("State")) {
                                    state = new State(context, xml);
                                    this.mStateList.put(state.mId, state);
                                    break;
                                } else {
                                    break;
                                }
                            case 1382829617:
                                str = "StateSet";
                                name.equals(str);
                                break;
                            case 1657696882:
                                str = "layoutDescription";
                                name.equals(str);
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    Variant variant = new Variant(context, xml);
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
                    xml.getName();
                }
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        } catch (XmlPullParserException e7) {
            e7.printStackTrace();
        }
    }
}
