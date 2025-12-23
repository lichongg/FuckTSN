package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class GoalVariableAccessor implements Comparable {
        PriorityGoalRow row;
        SolverVariable variable;

        public void add(SolverVariable solverVariable) {
            for (int i6 = 0; i6 < 9; i6++) {
                float[] fArr = this.variable.goalStrengthVector;
                float f6 = fArr[i6] + solverVariable.goalStrengthVector[i6];
                fArr[i6] = f6;
                if (Math.abs(f6) < 1.0E-4f) {
                    this.variable.goalStrengthVector[i6] = 0.0f;
                }
            }
        }

        public final boolean isNull() {
            for (int i6 = 0; i6 < 9; i6++) {
                if (this.variable.goalStrengthVector[i6] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.row = priorityGoalRow;
        }

        public boolean addToGoal(SolverVariable solverVariable, float f6) {
            boolean z5 = true;
            if (!this.variable.inGoal) {
                for (int i6 = 0; i6 < 9; i6++) {
                    float f7 = solverVariable.goalStrengthVector[i6];
                    if (f7 != 0.0f) {
                        float f8 = f7 * f6;
                        if (Math.abs(f8) < 1.0E-4f) {
                            f8 = 0.0f;
                        }
                        this.variable.goalStrengthVector[i6] = f8;
                    } else {
                        this.variable.goalStrengthVector[i6] = 0.0f;
                    }
                }
                return true;
            }
            for (int i7 = 0; i7 < 9; i7++) {
                float[] fArr = this.variable.goalStrengthVector;
                float f9 = fArr[i7] + (solverVariable.goalStrengthVector[i7] * f6);
                fArr[i7] = f9;
                if (Math.abs(f9) < 1.0E-4f) {
                    this.variable.goalStrengthVector[i7] = 0.0f;
                } else {
                    z5 = false;
                }
            }
            if (z5) {
                PriorityGoalRow.this.removeGoal(this.variable);
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.variable.id - ((SolverVariable) obj).id;
        }

        public void init(SolverVariable solverVariable) {
            this.variable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i6 = 8; i6 >= 0; i6--) {
                float f6 = this.variable.goalStrengthVector[i6];
                if (f6 > 0.0f) {
                    return false;
                }
                if (f6 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i6 = 8;
            while (true) {
                if (i6 < 0) {
                    break;
                }
                float f6 = solverVariable.goalStrengthVector[i6];
                float f7 = this.variable.goalStrengthVector[i6];
                if (f7 == f6) {
                    i6--;
                } else if (f7 < f6) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.variable != null) {
                for (int i6 = 0; i6 < 9; i6++) {
                    str = str + this.variable.goalStrengthVector[i6] + " ";
                }
            }
            return str + "] " + this.variable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeGoal(SolverVariable solverVariable) {
        int i6 = 0;
        while (i6 < this.numGoals) {
            if (this.arrayGoals[i6] == solverVariable) {
                while (true) {
                    int i7 = this.numGoals;
                    if (i6 >= i7 - 1) {
                        this.numGoals = i7 - 1;
                        solverVariable.inGoal = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int i8 = i6 + 1;
                        solverVariableArr[i6] = solverVariableArr[i8];
                        i6 = i8;
                    }
                }
            } else {
                i6++;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i6 = -1;
        for (int i7 = 0; i7 < this.numGoals; i7++) {
            SolverVariable solverVariable = this.arrayGoals[i7];
            if (!zArr[solverVariable.id]) {
                this.accessor.init(solverVariable);
                if (i6 == -1) {
                    if (!this.accessor.isNegative()) {
                    }
                    i6 = i7;
                } else {
                    if (!this.accessor.isSmallerThan(this.arrayGoals[i6])) {
                    }
                    i6 = i7;
                }
            }
        }
        if (i6 == -1) {
            return null;
        }
        return this.arrayGoals[i6];
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int i6;
        int i7 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i7 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i8 = this.numGoals;
        solverVariableArr3[i8] = solverVariable;
        int i9 = i8 + 1;
        this.numGoals = i9;
        if (i9 > 1 && solverVariableArr3[i8].id > solverVariable.id) {
            int i10 = 0;
            while (true) {
                i6 = this.numGoals;
                if (i10 >= i6) {
                    break;
                }
                this.sortArray[i10] = this.arrayGoals[i10];
                i10++;
            }
            Arrays.sort(this.sortArray, 0, i6, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.solver.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.id - solverVariable3.id;
                }
            });
            for (int i11 = 0; i11 < this.numGoals; i11++) {
                this.arrayGoals[i11] = this.sortArray[i11];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.accessor.init(solverVariable);
        this.accessor.reset();
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.constantValue + ") : ";
        for (int i6 = 0; i6 < this.numGoals; i6++) {
            this.accessor.init(this.arrayGoals[i6]);
            str = str + this.accessor + " ";
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(ArrayRow arrayRow, boolean z5) {
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i6 = 0; i6 < currentSize; i6++) {
            SolverVariable variable = arrayRowVariables.getVariable(i6);
            float variableValue = arrayRowVariables.getVariableValue(i6);
            this.accessor.init(variable);
            if (this.accessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.constantValue += arrayRow.constantValue * variableValue;
        }
        removeGoal(solverVariable);
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.TABLE_SIZE = 128;
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }
}
