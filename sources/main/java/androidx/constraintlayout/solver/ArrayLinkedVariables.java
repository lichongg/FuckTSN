package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    int currentSize = 0;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private int mHead = -1;
    private int mLast = -1;
    private boolean mDidFillOnce = false;

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f6) {
        if (f6 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i6 = this.mHead;
        if (i6 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f6;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (this.mDidFillOnce) {
                return;
            }
            int i7 = this.mLast + 1;
            this.mLast = i7;
            int[] iArr = this.mArrayIndices;
            if (i7 >= iArr.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr.length - 1;
                return;
            }
            return;
        }
        int i8 = -1;
        for (int i9 = 0; i6 != -1 && i9 < this.currentSize; i9++) {
            int i10 = this.mArrayIndices[i6];
            int i11 = solverVariable.id;
            if (i10 == i11) {
                this.mArrayValues[i6] = f6;
                return;
            }
            if (i10 < i11) {
                i8 = i6;
            }
            i6 = this.mArrayNextIndices[i6];
        }
        int i12 = this.mLast;
        int i13 = i12 + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[i12] != -1) {
                i12 = iArr2.length;
            }
        } else {
            i12 = i13;
        }
        int[] iArr3 = this.mArrayIndices;
        if (i12 >= iArr3.length && this.currentSize < iArr3.length) {
            int i14 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i14 >= iArr4.length) {
                    break;
                }
                if (iArr4[i14] == -1) {
                    i12 = i14;
                    break;
                }
                i14++;
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (i12 >= iArr5.length) {
            i12 = iArr5.length;
            int i15 = this.ROW_SIZE * 2;
            this.ROW_SIZE = i15;
            this.mDidFillOnce = false;
            this.mLast = i12 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i15);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[i12] = solverVariable.id;
        this.mArrayValues[i12] = f6;
        if (i8 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[i12] = iArr6[i8];
            iArr6[i8] = i12;
        } else {
            this.mArrayNextIndices[i12] = this.mHead;
            this.mHead = i12;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i16 = this.currentSize + 1;
        this.currentSize = i16;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i16 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f6, boolean z5) {
        float f7 = epsilon;
        if (f6 <= (-f7) || f6 >= f7) {
            int i6 = this.mHead;
            if (i6 == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f6;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.currentSize++;
                if (this.mDidFillOnce) {
                    return;
                }
                int i7 = this.mLast + 1;
                this.mLast = i7;
                int[] iArr = this.mArrayIndices;
                if (i7 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            int i8 = -1;
            for (int i9 = 0; i6 != -1 && i9 < this.currentSize; i9++) {
                int i10 = this.mArrayIndices[i6];
                int i11 = solverVariable.id;
                if (i10 == i11) {
                    float[] fArr = this.mArrayValues;
                    float f8 = fArr[i6] + f6;
                    float f9 = epsilon;
                    if (f8 > (-f9) && f8 < f9) {
                        f8 = 0.0f;
                    }
                    fArr[i6] = f8;
                    if (f8 == 0.0f) {
                        if (i6 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i6];
                        } else {
                            int[] iArr2 = this.mArrayNextIndices;
                            iArr2[i8] = iArr2[i6];
                        }
                        if (z5) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i6;
                        }
                        solverVariable.usageInRowCount--;
                        this.currentSize--;
                        return;
                    }
                    return;
                }
                if (i10 < i11) {
                    i8 = i6;
                }
                i6 = this.mArrayNextIndices[i6];
            }
            int i12 = this.mLast;
            int i13 = i12 + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[i12] != -1) {
                    i12 = iArr3.length;
                }
            } else {
                i12 = i13;
            }
            int[] iArr4 = this.mArrayIndices;
            if (i12 >= iArr4.length && this.currentSize < iArr4.length) {
                int i14 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i14 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i14] == -1) {
                        i12 = i14;
                        break;
                    }
                    i14++;
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (i12 >= iArr6.length) {
                i12 = iArr6.length;
                int i15 = this.ROW_SIZE * 2;
                this.ROW_SIZE = i15;
                this.mDidFillOnce = false;
                this.mLast = i12 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i15);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i12] = solverVariable.id;
            this.mArrayValues[i12] = f6;
            if (i8 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[i12] = iArr7[i8];
                iArr7[i8] = i12;
            } else {
                this.mArrayNextIndices[i12] = this.mHead;
                this.mHead = i12;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i16 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i16 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i6 = this.mHead;
        for (int i7 = 0; i6 != -1 && i7 < this.currentSize; i7++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i6]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i6 = this.mArrayNextIndices[i6];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i6 = this.mHead;
        if (i6 == -1) {
            return false;
        }
        for (int i7 = 0; i6 != -1 && i7 < this.currentSize; i7++) {
            if (this.mArrayIndices[i6] == solverVariable.id) {
                return true;
            }
            i6 = this.mArrayNextIndices[i6];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i6 = this.currentSize;
        System.out.getClass();
        for (int i7 = 0; i7 < i6; i7++) {
            SolverVariable variable = getVariable(i7);
            if (variable != null) {
                PrintStream printStream = System.out;
                variable.toString();
                getVariableValue(i7);
                printStream.getClass();
            }
        }
        System.out.getClass();
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f6) {
        int i6 = this.mHead;
        for (int i7 = 0; i6 != -1 && i7 < this.currentSize; i7++) {
            float[] fArr = this.mArrayValues;
            fArr[i6] = fArr[i6] / f6;
            i6 = this.mArrayNextIndices[i6];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i6 = this.mHead;
        for (int i7 = 0; i6 != -1 && i7 < this.currentSize; i7++) {
            if (this.mArrayIndices[i6] == solverVariable.id) {
                return this.mArrayValues[i6];
            }
            i6 = this.mArrayNextIndices[i6];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i6) {
        return this.mArrayIndices[i6];
    }

    public final int getNextIndice(int i6) {
        return this.mArrayNextIndices[i6];
    }

    SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.candidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i6 = this.mHead;
        SolverVariable solverVariable2 = null;
        for (int i7 = 0; i6 != -1 && i7 < this.currentSize; i7++) {
            if (this.mArrayValues[i6] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i6]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i6 = this.mArrayNextIndices[i6];
        }
        return solverVariable2;
    }

    public final float getValue(int i6) {
        return this.mArrayValues[i6];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i6) {
        int i7 = this.mHead;
        for (int i8 = 0; i7 != -1 && i8 < this.currentSize; i8++) {
            if (i8 == i6) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i7]];
            }
            i7 = this.mArrayNextIndices[i7];
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i6) {
        int i7 = this.mHead;
        for (int i8 = 0; i7 != -1 && i8 < this.currentSize; i8++) {
            if (i8 == i6) {
                return this.mArrayValues[i7];
            }
            i7 = this.mArrayNextIndices[i7];
        }
        return 0.0f;
    }

    boolean hasAtLeastOnePositiveVariable() {
        int i6 = this.mHead;
        for (int i7 = 0; i6 != -1 && i7 < this.currentSize; i7++) {
            if (this.mArrayValues[i6] > 0.0f) {
                return true;
            }
            i6 = this.mArrayNextIndices[i6];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i6 = this.mHead;
        if (i6 == -1) {
            return -1;
        }
        for (int i7 = 0; i6 != -1 && i7 < this.currentSize; i7++) {
            if (this.mArrayIndices[i6] == solverVariable.id) {
                return i6;
            }
            i6 = this.mArrayNextIndices[i6];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i6 = this.mHead;
        for (int i7 = 0; i6 != -1 && i7 < this.currentSize; i7++) {
            float[] fArr = this.mArrayValues;
            fArr[i6] = fArr[i6] * (-1.0f);
            i6 = this.mArrayNextIndices[i6];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z5) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        int i6 = this.mHead;
        if (i6 == -1) {
            return 0.0f;
        }
        int i7 = 0;
        int i8 = -1;
        while (i6 != -1 && i7 < this.currentSize) {
            if (this.mArrayIndices[i6] == solverVariable.id) {
                if (i6 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i6];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i8] = iArr[i6];
                }
                if (z5) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[i6] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i6;
                }
                return this.mArrayValues[i6];
            }
            i7++;
            i8 = i6;
            i6 = this.mArrayNextIndices[i6];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int i6 = this.mHead;
        String str = "";
        for (int i7 = 0; i6 != -1 && i7 < this.currentSize; i7++) {
            str = ((str + " -> ") + this.mArrayValues[i6] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[i6]];
            i6 = this.mArrayNextIndices[i6];
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z5) {
        float f6 = get(arrayRow.variable);
        remove(arrayRow.variable, z5);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i6 = 0; i6 < currentSize; i6++) {
            SolverVariable variable = arrayRowVariables.getVariable(i6);
            add(variable, arrayRowVariables.get(variable) * f6, z5);
        }
        return f6;
    }

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }
}
