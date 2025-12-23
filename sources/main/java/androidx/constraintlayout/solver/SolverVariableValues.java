package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    int[] keys = new int[16];
    int[] nextKeys = new int[16];
    int[] variables = new int[16];
    float[] values = new float[16];
    int[] previous = new int[16];
    int[] next = new int[16];
    int mCount = 0;
    int head = -1;

    private void displayHash() {
        for (int i6 = 0; i6 < this.HASH_SIZE; i6++) {
            if (this.keys[i6] != -1) {
                String str = hashCode() + " hash [" + i6 + "] => ";
                int i7 = this.keys[i6];
                boolean z5 = false;
                while (!z5) {
                    str = str + " " + this.variables[i7];
                    int i8 = this.nextKeys[i7];
                    if (i8 != -1) {
                        i7 = i8;
                    } else {
                        z5 = true;
                    }
                }
                System.out.getClass();
            }
        }
    }

    private int findEmptySlot() {
        for (int i6 = 0; i6 < this.SIZE; i6++) {
            if (this.variables[i6] == -1) {
                return i6;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    private void addToHashMap(SolverVariable solverVariable, int i6) {
        int[] iArr;
        int i7 = solverVariable.id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i8 = iArr2[i7];
        if (i8 == -1) {
            iArr2[i7] = i6;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i9 = iArr[i8];
                if (i9 == -1) {
                    break;
                } else {
                    i8 = i9;
                }
            }
            iArr[i8] = i6;
        }
        this.nextKeys[i6] = -1;
    }

    private void addVariable(int i6, SolverVariable solverVariable, float f6) {
        this.variables[i6] = solverVariable.id;
        this.values[i6] = f6;
        this.previous[i6] = -1;
        this.next[i6] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void increaseSize() {
        int i6 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i6);
        this.values = Arrays.copyOf(this.values, i6);
        this.previous = Arrays.copyOf(this.previous, i6);
        this.next = Arrays.copyOf(this.next, i6);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i6);
        for (int i7 = this.SIZE; i7 < i6; i7++) {
            this.variables[i7] = -1;
            this.nextKeys[i7] = -1;
        }
        this.SIZE = i6;
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i6;
        int i7 = solverVariable.id;
        int i8 = i7 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i9 = iArr2[i8];
        if (i9 == -1) {
            return;
        }
        if (this.variables[i9] == i7) {
            int[] iArr3 = this.nextKeys;
            iArr2[i8] = iArr3[i9];
            iArr3[i9] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            i6 = iArr[i9];
            if (i6 == -1 || this.variables[i6] == i7) {
                break;
            } else {
                i9 = i6;
            }
        }
        if (i6 == -1 || this.variables[i6] != i7) {
            return;
        }
        iArr[i9] = iArr[i6];
        iArr[i6] = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f6, boolean z5) {
        float f7 = epsilon;
        if (f6 <= (-f7) || f6 >= f7) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f6);
                return;
            }
            float[] fArr = this.values;
            float f8 = fArr[indexOf] + f6;
            fArr[indexOf] = f8;
            float f9 = epsilon;
            if (f8 <= (-f9) || f8 >= f9) {
                return;
            }
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z5);
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        int i6 = this.mCount;
        for (int i7 = 0; i7 < i6; i7++) {
            SolverVariable variable = getVariable(i7);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i8 = 0; i8 < this.SIZE; i8++) {
            this.variables[i8] = -1;
            this.nextKeys[i8] = -1;
        }
        for (int i9 = 0; i9 < this.HASH_SIZE; i9++) {
            this.keys[i9] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i6 = this.mCount;
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
        int i6 = this.mCount;
        int i7 = this.head;
        for (int i8 = 0; i8 < i6; i8++) {
            float[] fArr = this.values;
            fArr[i7] = fArr[i7] / f6;
            i7 = this.next[i7];
            if (i7 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i6) {
        int i7 = this.mCount;
        if (i7 == 0) {
            return null;
        }
        int i8 = this.head;
        for (int i9 = 0; i9 < i7; i9++) {
            if (i9 == i6 && i8 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i8]];
            }
            i8 = this.next[i8];
            if (i8 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i6) {
        int i7 = this.mCount;
        int i8 = this.head;
        for (int i9 = 0; i9 < i7; i9++) {
            if (i9 == i6) {
                return this.values[i8];
            }
            i8 = this.next[i8];
            if (i8 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount == 0) {
            return -1;
        }
        int i6 = solverVariable.id;
        int i7 = this.keys[i6 % this.HASH_SIZE];
        if (i7 == -1) {
            return -1;
        }
        if (this.variables[i7] == i6) {
            return i7;
        }
        do {
            i7 = this.nextKeys[i7];
            if (i7 == -1) {
                break;
            }
        } while (this.variables[i7] != i6);
        if (i7 != -1 && this.variables[i7] == i6) {
            return i7;
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i6 = this.mCount;
        int i7 = this.head;
        for (int i8 = 0; i8 < i6; i8++) {
            float[] fArr = this.values;
            fArr[i7] = fArr[i7] * (-1.0f);
            i7 = this.next[i7];
            if (i7 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f6) {
        float f7 = epsilon;
        if (f6 > (-f7) && f6 < f7) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f6);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.values[indexOf] = f6;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i6 = this.mCount;
        int i7 = this.head;
        int i8 = -1;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = this.variables[i7];
            int i11 = solverVariable.id;
            if (i10 == i11) {
                this.values[i7] = f6;
                return;
            }
            if (i10 < i11) {
                i8 = i7;
            }
            i7 = this.next[i7];
            if (i7 == -1) {
                break;
            }
        }
        insertVariable(i8, solverVariable, f6);
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i6 = this.mCount;
        for (int i7 = 0; i7 < i6; i7++) {
            SolverVariable variable = getVariable(i7);
            if (variable != null) {
                String str2 = str + variable + " = " + getVariableValue(i7) + " ";
                int indexOf = indexOf(variable);
                String str3 = str2 + "[p: ";
                String str4 = (this.previous[indexOf] != -1 ? str3 + this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]] : str3 + "none") + ", n: ";
                str = (this.next[indexOf] != -1 ? str4 + this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z5) {
        float f6 = get(arrayRow.variable);
        remove(arrayRow.variable, z5);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i6 = 0;
        int i7 = 0;
        while (i6 < currentSize) {
            int i8 = solverVariableValues.variables[i7];
            if (i8 != -1) {
                add(this.mCache.mIndexedVariables[i8], solverVariableValues.values[i7] * f6, z5);
                i6++;
            }
            i7++;
        }
        return f6;
    }

    SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void insertVariable(int i6, SolverVariable solverVariable, float f6) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f6);
        if (i6 != -1) {
            this.previous[findEmptySlot] = i6;
            int[] iArr = this.next;
            iArr[findEmptySlot] = iArr[i6];
            iArr[i6] = findEmptySlot;
        } else {
            this.previous[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[findEmptySlot] = this.head;
                this.head = findEmptySlot;
            } else {
                this.next[findEmptySlot] = -1;
            }
        }
        int i7 = this.next[findEmptySlot];
        if (i7 != -1) {
            this.previous[i7] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        if (indexOf(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z5) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f6 = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] iArr = this.previous;
        int i6 = iArr[indexOf];
        if (i6 != -1) {
            int[] iArr2 = this.next;
            iArr2[i6] = iArr2[indexOf];
        }
        int i7 = this.next[indexOf];
        if (i7 != -1) {
            iArr[i7] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z5) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f6;
    }
}
