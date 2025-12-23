package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    float[] goalStrengthVector;
    public int id;
    public boolean inGoal;
    HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    public int usageInRowCount;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inRows = null;
        this.mName = str;
        this.mType = type;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i6 = 0;
        while (true) {
            int i7 = this.mClientEquationsCount;
            if (i6 >= i7) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i7 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i8 = this.mClientEquationsCount;
                arrayRowArr2[i8] = arrayRow;
                this.mClientEquationsCount = i8 + 1;
                return;
            }
            if (this.mClientEquations[i6] == arrayRow) {
                return;
            } else {
                i6++;
            }
        }
    }

    void clearStrengths() {
        for (int i6 = 0; i6 < 9; i6++) {
            this.strengthVector[i6] = 0.0f;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        int i6 = this.mClientEquationsCount;
        for (int i7 = 0; i7 < i6; i7++) {
            this.mClientEquations[i7] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        int i6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[type.ordinal()];
        if (i6 == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("U");
            int i7 = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i7;
            sb.append(i7);
            return sb.toString();
        }
        if (i6 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("C");
            int i8 = uniqueConstantId + 1;
            uniqueConstantId = i8;
            sb2.append(i8);
            return sb2.toString();
        }
        if (i6 == 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(ExifInterface.LATITUDE_SOUTH);
            int i9 = uniqueSlackId + 1;
            uniqueSlackId = i9;
            sb3.append(i9);
            return sb3.toString();
        }
        if (i6 == 4) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("e");
            int i10 = uniqueErrorId + 1;
            uniqueErrorId = i10;
            sb4.append(i10);
            return sb4.toString();
        }
        if (i6 != 5) {
            throw new AssertionError(type.name());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i11 = uniqueId + 1;
        uniqueId = i11;
        sb5.append(i11);
        return sb5.toString();
    }

    static void increaseErrorId() {
        uniqueErrorId++;
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i6 = this.mClientEquationsCount;
        int i7 = 0;
        while (i7 < i6) {
            if (this.mClientEquations[i7] == arrayRow) {
                while (i7 < i6 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i8 = i7 + 1;
                    arrayRowArr[i7] = arrayRowArr[i8];
                    i7 = i8;
                }
                this.mClientEquationsCount--;
                return;
            }
            i7++;
        }
    }

    public void setFinalValue(LinearSystem linearSystem, float f6) {
        this.computedValue = f6;
        this.isFinalValue = true;
        int i6 = this.mClientEquationsCount;
        for (int i7 = 0; i7 < i6; i7++) {
            this.mClientEquations[i7].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    String strengthsToString() {
        String str = this + "[";
        boolean z5 = false;
        boolean z6 = true;
        for (int i6 = 0; i6 < this.strengthVector.length; i6++) {
            String str2 = str + this.strengthVector[i6];
            float[] fArr = this.strengthVector;
            float f6 = fArr[i6];
            if (f6 > 0.0f) {
                z5 = false;
            } else if (f6 < 0.0f) {
                z5 = true;
            }
            if (f6 != 0.0f) {
                z6 = false;
            }
            str = i6 < fArr.length - 1 ? str2 + ", " : str2 + "] ";
        }
        if (z5) {
            str = str + " (-)";
        }
        if (!z6) {
            return str;
        }
        return str + " (*)";
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.id;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i6 = this.mClientEquationsCount;
        for (int i7 = 0; i7 < i6; i7++) {
            this.mClientEquations[i7].updateFromRow(arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inRows = null;
        this.mType = type;
    }
}
