package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    public ArrayRowVariables variables;
    SolverVariable variable = null;
    float constantValue = 0.0f;
    boolean used = false;
    ArrayList<SolverVariable> variablesToUpdate = new ArrayList<>();
    boolean isSimpleDefinition = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f6, boolean z5);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f6);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i6);

        float getVariableValue(int i6);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f6);

        float remove(SolverVariable solverVariable, boolean z5);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z5);
    }

    public ArrayRow() {
    }

    public ArrayRow addError(LinearSystem linearSystem, int i6) {
        this.variables.put(linearSystem.createErrorVariable(i6, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i6, "em"), -1.0f);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f6, float f7, float f8, SolverVariable solverVariable, int i6, SolverVariable solverVariable2, int i7, SolverVariable solverVariable3, int i8, SolverVariable solverVariable4, int i9) {
        if (f7 == 0.0f || f6 == f8) {
            this.constantValue = ((-i6) - i7) + i8 + i9;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        float f9 = (f6 / f7) / (f8 / f7);
        this.constantValue = ((-i6) - i7) + (i8 * f9) + (i9 * f9);
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable4, f9);
        this.variables.put(solverVariable3, -f9);
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f6, float f7, float f8, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.constantValue = 0.0f;
        if (f7 == 0.0f || f6 == f8) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        if (f6 == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            return this;
        }
        if (f8 == 0.0f) {
            this.variables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
            return this;
        }
        float f9 = (f6 / f7) / (f8 / f7);
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable4, f9);
        this.variables.put(solverVariable3, -f9);
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i6) {
        if (i6 < 0) {
            this.constantValue = i6 * (-1);
            this.variables.put(solverVariable, 1.0f);
            return this;
        }
        this.constantValue = i6;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i6) {
        boolean z5 = false;
        if (i6 != 0) {
            if (i6 < 0) {
                i6 *= -1;
                z5 = true;
            }
            this.constantValue = i6;
        }
        if (z5) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, 1.0f);
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i6) {
        boolean z5 = false;
        if (i6 != 0) {
            if (i6 < 0) {
                i6 *= -1;
                z5 = true;
            }
            this.constantValue = i6;
        }
        if (z5) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            return this;
        }
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, -1.0f);
        return this;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return pickPivotInVariables(null, solverVariable);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f6 = 0.0f;
        for (int i6 = 0; i6 < currentSize; i6++) {
            float variableValue = this.variables.getVariableValue(i6);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i6);
                if ((zArr == null || !zArr[variable.id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f6)) {
                    f6 = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    ArrayRow addSingleError(SolverVariable solverVariable, int i6) {
        this.variables.put(solverVariable, i6);
        return this;
    }

    SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        boolean isNew;
        boolean isNew2;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        boolean z5 = false;
        boolean z6 = false;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i6 = 0; i6 < currentSize; i6++) {
            float variableValue = this.variables.getVariableValue(i6);
            SolverVariable variable = this.variables.getVariable(i6);
            if (variable.mType == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (f6 > variableValue) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (!z5 && isNew(variable, linearSystem)) {
                    f6 = variableValue;
                    solverVariable = variable;
                    z5 = true;
                }
                z5 = isNew2;
                f6 = variableValue;
                solverVariable = variable;
            } else if (solverVariable == null && variableValue < 0.0f) {
                if (solverVariable2 == null) {
                    isNew = isNew(variable, linearSystem);
                } else if (f7 > variableValue) {
                    isNew = isNew(variable, linearSystem);
                } else if (!z6 && isNew(variable, linearSystem)) {
                    f7 = variableValue;
                    solverVariable2 = variable;
                    z6 = true;
                }
                z6 = isNew;
                f7 = variableValue;
                solverVariable2 = variable;
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i6, float f6, SolverVariable solverVariable3, SolverVariable solverVariable4, int i7) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f6 == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i6 > 0 || i7 > 0) {
                this.constantValue = (-i6) + i7;
                return this;
            }
        } else {
            if (f6 <= 0.0f) {
                this.variables.put(solverVariable, -1.0f);
                this.variables.put(solverVariable2, 1.0f);
                this.constantValue = i6;
                return this;
            }
            if (f6 >= 1.0f) {
                this.variables.put(solverVariable4, -1.0f);
                this.variables.put(solverVariable3, 1.0f);
                this.constantValue = -i7;
                return this;
            }
            float f7 = 1.0f - f6;
            this.variables.put(solverVariable, f7 * 1.0f);
            this.variables.put(solverVariable2, f7 * (-1.0f));
            this.variables.put(solverVariable3, (-1.0f) * f6);
            this.variables.put(solverVariable4, 1.0f * f6);
            if (i6 > 0 || i7 > 0) {
                this.constantValue = ((-i6) * f7) + (i7 * f6);
                return this;
            }
        }
        return this;
    }

    ArrayRow createRowDefinition(SolverVariable solverVariable, int i6) {
        this.variable = solverVariable;
        float f6 = i6;
        solverVariable.computedValue = f6;
        this.constantValue = f6;
        this.isSimpleDefinition = true;
        return this;
    }

    ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f6) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f6);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f6) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f6);
        this.variables.put(solverVariable4, -f6);
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f6) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f6;
        return this;
    }

    void ensurePositiveConstant() {
        float f6 = this.constantValue;
        if (f6 < 0.0f) {
            this.constantValue = f6 * (-1.0f);
            this.variables.invert();
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }

    boolean hasKeyVariable() {
        SolverVariable solverVariable = this.variable;
        if (solverVariable != null) {
            return solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f;
        }
        return false;
    }

    boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.variable = null;
            this.variables.clear();
            for (int i6 = 0; i6 < arrayRow.variables.getCurrentSize(); i6++) {
                this.variables.add(arrayRow.variables.getVariable(i6), arrayRow.variables.getVariableValue(i6), true);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        return this.variable == null && this.constantValue == 0.0f && this.variables.getCurrentSize() == 0;
    }

    void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.variable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.variable = null;
        }
        float remove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.variable = solverVariable;
        if (remove == 1.0f) {
            return;
        }
        this.constantValue /= remove;
        this.variables.divideByAmount(remove);
    }

    int sizeInBytes() {
        return (this.variable != null ? 4 : 0) + 8 + this.variables.sizeInBytes();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String toReadableString() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.ArrayRow.toReadableString():java.lang.String");
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z5) {
        if (solverVariable.isFinalValue) {
            this.constantValue += solverVariable.computedValue * this.variables.get(solverVariable);
            this.variables.remove(solverVariable, z5);
            if (z5) {
                solverVariable.removeFromRow(this);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(ArrayRow arrayRow, boolean z5) {
        this.constantValue += arrayRow.constantValue * this.variables.use(arrayRow, z5);
        if (z5) {
            arrayRow.variable.removeFromRow(this);
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.mRows.length == 0) {
            return;
        }
        boolean z5 = false;
        while (!z5) {
            int currentSize = this.variables.getCurrentSize();
            for (int i6 = 0; i6 < currentSize; i6++) {
                SolverVariable variable = this.variables.getVariable(i6);
                if (variable.definitionId != -1 || variable.isFinalValue) {
                    this.variablesToUpdate.add(variable);
                }
            }
            if (this.variablesToUpdate.size() > 0) {
                Iterator<SolverVariable> it = this.variablesToUpdate.iterator();
                while (it.hasNext()) {
                    SolverVariable next = it.next();
                    if (next.isFinalValue) {
                        updateFromFinalVariable(linearSystem, next, true);
                    } else {
                        updateFromRow(linearSystem.mRows[next.definitionId], true);
                    }
                }
                this.variablesToUpdate.clear();
            } else {
                z5 = true;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        int i6 = solverVariable.strength;
        float f6 = 1.0f;
        if (i6 != 1) {
            if (i6 == 2) {
                f6 = 1000.0f;
            } else if (i6 == 3) {
                f6 = 1000000.0f;
            } else if (i6 == 4) {
                f6 = 1.0E9f;
            } else if (i6 == 5) {
                f6 = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f6);
    }

    boolean chooseSubject(LinearSystem linearSystem) {
        boolean z5;
        SolverVariable chooseSubjectInVariables = chooseSubjectInVariables(linearSystem);
        if (chooseSubjectInVariables == null) {
            z5 = true;
        } else {
            pivot(chooseSubjectInVariables);
            z5 = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
        }
        return z5;
    }

    public String toString() {
        return toReadableString();
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i6) {
        boolean z5 = false;
        if (i6 != 0) {
            if (i6 < 0) {
                i6 *= -1;
                z5 = true;
            }
            this.constantValue = i6;
        }
        if (!z5) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            return this;
        }
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        return this;
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i6, SolverVariable solverVariable2) {
        this.constantValue = i6;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
