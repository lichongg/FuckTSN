package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.snail.antifake.deviceid.e;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = true;
    private static int POOL_SIZE = 1000;
    static final boolean SIMPLIFY_SYNONYMS = false;
    private static final boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    ArrayRow[] mRows;
    private Row mTempGoal;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int TABLE_SIZE = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
    private int mPoolVariablesCount = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z5);

        void updateFromRow(ArrayRow arrayRow, boolean z5);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private void addSingleError(ArrayRow arrayRow, int i6) {
        addSingleError(arrayRow, i6, 0);
    }

    private void computeValues() {
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            ArrayRow arrayRow = this.mRows[i6];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    private String getDisplayStrength(int i6) {
        return i6 == 1 ? "LOW" : i6 == 2 ? "MEDIUM" : i6 == 3 ? "HIGH" : i6 == 4 ? "HIGHEST" : i6 == 5 ? "EQUALITY" : i6 == 8 ? "FIXED" : i6 == 6 ? "BARRIER" : "NONE";
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i6, int i7) {
        if (i7 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i6);
            return null;
        }
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i6);
        if (i7 != 8) {
            createRow.addError(this, i7);
        }
        addConstraint(createRow);
        return createRow;
    }

    final void cleanupRows() {
        int i6;
        int i7 = 0;
        while (i7 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i7];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (arrayRow.isSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.variable;
                solverVariable.computedValue = arrayRow.constantValue;
                solverVariable.removeFromRow(arrayRow);
                int i8 = i7;
                while (true) {
                    i6 = this.mNumRows;
                    if (i8 >= i6 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i9 = i8 + 1;
                    arrayRowArr[i8] = arrayRowArr[i9];
                    i8 = i9;
                }
                this.mRows[i6 - 1] = null;
                this.mNumRows = i6 - 1;
                i7--;
            }
            i7++;
        }
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i6 = solverVariable.id;
            if (i6 != -1 && i6 <= this.mVariablesID && this.mCache.mIndexedVariables[i6] != null) {
                return solverVariable;
            }
            if (i6 != -1) {
                solverVariable.reset();
            }
            int i7 = this.mVariablesID + 1;
            this.mVariablesID = i7;
            this.mNumColumns++;
            solverVariable.id = i7;
            solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
            this.mCache.mIndexedVariables[i7] = solverVariable;
        }
        return solverVariable;
    }

    void displaySystemInformations() {
        int i6 = 0;
        for (int i7 = 0; i7 < this.TABLE_SIZE; i7++) {
            ArrayRow arrayRow = this.mRows[i7];
            if (arrayRow != null) {
                i6 += arrayRow.sizeInBytes();
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.mNumRows; i9++) {
            ArrayRow arrayRow2 = this.mRows[i9];
            if (arrayRow2 != null) {
                i8 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        int i10 = this.TABLE_SIZE;
        getDisplaySize(i10 * i10);
        getDisplaySize(i6);
        getDisplaySize(i8);
        getDisplaySize(0);
        printStream.getClass();
    }

    public int getMemoryUsed() {
        int i6 = 0;
        for (int i7 = 0; i7 < this.mNumRows; i7++) {
            ArrayRow arrayRow = this.mRows[i7];
            if (arrayRow != null) {
                i6 += arrayRow.sizeInBytes();
            }
        }
        return i6;
    }

    public void reset() {
        Cache cache;
        int i6 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i6 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i6];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i6++;
        }
        cache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.mVariables;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i7 = 0; i7 < this.mNumRows; i7++) {
            this.mRows[i7].used = false;
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.mCache.solverVariablePool.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        int i6 = this.mPoolVariablesCount;
        int i7 = POOL_SIZE;
        if (i6 >= i7) {
            int i8 = i7 * 2;
            POOL_SIZE = i8;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i8);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i9 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i9 + 1;
        solverVariableArr[i9] = acquire;
        return acquire;
    }

    private final void addRow(ArrayRow arrayRow) {
        if (OPTIMIZED_ENGINE) {
            ArrayRow arrayRow2 = this.mRows[this.mNumRows];
            if (arrayRow2 != null) {
                this.mCache.optimizedArrayRowPool.release(arrayRow2);
            }
        } else {
            ArrayRow arrayRow3 = this.mRows[this.mNumRows];
            if (arrayRow3 != null) {
                this.mCache.arrayRowPool.release(arrayRow3);
            }
        }
        ArrayRow[] arrayRowArr = this.mRows;
        int i6 = this.mNumRows;
        arrayRowArr[i6] = arrayRow;
        SolverVariable solverVariable = arrayRow.variable;
        solverVariable.definitionId = i6;
        this.mNumRows = i6 + 1;
        solverVariable.updateReferencesWithNewDefinition(arrayRow);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
        acquireSolverVariable.setName(str);
        int i6 = this.mVariablesID + 1;
        this.mVariablesID = i6;
        this.mNumColumns++;
        acquireSolverVariable.id = i6;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displaySolverVariables() {
        System.out.getClass();
    }

    private int enforceBFS(Row row) throws Exception {
        long j6;
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            ArrayRow arrayRow = this.mRows[i6];
            if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED) {
                float f6 = 0.0f;
                if (arrayRow.constantValue < 0.0f) {
                    boolean z5 = false;
                    int i7 = 0;
                    while (!z5) {
                        Metrics metrics = sMetrics;
                        long j7 = 1;
                        if (metrics != null) {
                            metrics.bfs++;
                        }
                        i7++;
                        float f7 = Float.MAX_VALUE;
                        int i8 = 0;
                        int i9 = -1;
                        int i10 = -1;
                        int i11 = 0;
                        while (true) {
                            int i12 = 1;
                            if (i8 >= this.mNumRows) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.mRows[i8];
                            if (arrayRow2.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow2.isSimpleDefinition && arrayRow2.constantValue < f6) {
                                while (i12 < this.mNumColumns) {
                                    SolverVariable solverVariable = this.mCache.mIndexedVariables[i12];
                                    float f8 = arrayRow2.variables.get(solverVariable);
                                    if (f8 <= f6) {
                                        j6 = j7;
                                    } else {
                                        j6 = j7;
                                        for (int i13 = 0; i13 < 9; i13++) {
                                            float f9 = solverVariable.strengthVector[i13] / f8;
                                            if ((f9 < f7 && i13 == i11) || i13 > i11) {
                                                i11 = i13;
                                                f7 = f9;
                                                i9 = i8;
                                                i10 = i12;
                                            }
                                        }
                                    }
                                    i12++;
                                    j7 = j6;
                                    f6 = 0.0f;
                                }
                            }
                            i8++;
                            j7 = j7;
                            f6 = 0.0f;
                        }
                        long j8 = j7;
                        if (i9 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i9];
                            arrayRow3.variable.definitionId = -1;
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots += j8;
                            }
                            arrayRow3.pivot(this.mCache.mIndexedVariables[i10]);
                            SolverVariable solverVariable2 = arrayRow3.variable;
                            solverVariable2.definitionId = i9;
                            solverVariable2.updateReferencesWithNewDefinition(arrayRow3);
                        } else {
                            z5 = true;
                        }
                        if (i7 > this.mNumColumns / 2) {
                            z5 = true;
                        }
                        f6 = 0.0f;
                    }
                    return i7;
                }
            }
        }
        return 0;
    }

    private String getDisplaySize(int i6) {
        int i7 = i6 * 4;
        int i8 = i7 / 1024;
        int i9 = i8 / 1024;
        if (i9 > 0) {
            return "" + i9 + " Mb";
        }
        if (i8 > 0) {
            return "" + i8 + " Kb";
        }
        return "" + i7 + " bytes";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i6 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i6;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i6);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i7 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i7];
        this.mMaxColumns = i7;
        this.mMaxRows = i7;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i7);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int optimize(Row row, boolean z5) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i6 = 0; i6 < this.mNumColumns; i6++) {
            this.mAlreadyTestedCandidates[i6] = false;
        }
        boolean z6 = false;
        int i7 = 0;
        while (!z6) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i7++;
            if (i7 < this.mNumColumns * 2) {
                if (row.getKey() != null) {
                    this.mAlreadyTestedCandidates[row.getKey().id] = true;
                }
                SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
                if (pivotCandidate != null) {
                    boolean[] zArr = this.mAlreadyTestedCandidates;
                    int i8 = pivotCandidate.id;
                    if (!zArr[i8]) {
                        zArr[i8] = true;
                    }
                }
                if (pivotCandidate != null) {
                    float f6 = Float.MAX_VALUE;
                    int i9 = -1;
                    for (int i10 = 0; i10 < this.mNumRows; i10++) {
                        ArrayRow arrayRow = this.mRows[i10];
                        if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                            float f7 = arrayRow.variables.get(pivotCandidate);
                            if (f7 < 0.0f) {
                                float f8 = (-arrayRow.constantValue) / f7;
                                if (f8 < f6) {
                                    i9 = i10;
                                    f6 = f8;
                                }
                            }
                        }
                    }
                    if (i9 > -1) {
                        ArrayRow arrayRow2 = this.mRows[i9];
                        arrayRow2.variable.definitionId = -1;
                        Metrics metrics3 = sMetrics;
                        if (metrics3 != null) {
                            metrics3.pivots++;
                        }
                        arrayRow2.pivot(pivotCandidate);
                        SolverVariable solverVariable = arrayRow2.variable;
                        solverVariable.definitionId = i9;
                        solverVariable.updateReferencesWithNewDefinition(arrayRow2);
                    }
                } else {
                    z6 = true;
                }
            }
            return i7;
        }
        return i7;
    }

    private void releaseRows() {
        int i6 = 0;
        if (OPTIMIZED_ENGINE) {
            while (true) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (i6 >= arrayRowArr.length) {
                    return;
                }
                ArrayRow arrayRow = arrayRowArr[i6];
                if (arrayRow != null) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i6] = null;
                i6++;
            }
        } else {
            while (true) {
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (i6 >= arrayRowArr2.length) {
                    return;
                }
                ArrayRow arrayRow2 = arrayRowArr2[i6];
                if (arrayRow2 != null) {
                    this.mCache.arrayRowPool.release(arrayRow2);
                }
                this.mRows[i6] = null;
                i6++;
            }
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f6, int i6) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d6 = f6;
        double d7 = i6;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d6) * d7));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(d6) * d7));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i6, float f6, SolverVariable solverVariable3, SolverVariable solverVariable4, int i7, int i8) {
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i6, f6, solverVariable3, solverVariable4, i7);
        if (i8 != 8) {
            createRow.addError(this, i8);
        }
        addConstraint(createRow);
    }

    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable pickPivot;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.isSimpleDefinition) {
                metrics.simpleconstraints++;
            }
        }
        boolean z5 = true;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z6 = false;
        if (!arrayRow.isSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable createExtraVariable = createExtraVariable();
                arrayRow.variable = createExtraVariable;
                addRow(arrayRow);
                this.mTempGoal.initFromRow(arrayRow);
                optimize(this.mTempGoal, true);
                if (createExtraVariable.definitionId == -1) {
                    if (arrayRow.variable == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                        Metrics metrics2 = sMetrics;
                        if (metrics2 != null) {
                            metrics2.pivots++;
                        }
                        arrayRow.pivot(pickPivot);
                    }
                    if (!arrayRow.isSimpleDefinition) {
                        arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                    }
                    this.mNumRows--;
                }
            } else {
                z5 = false;
            }
            if (!arrayRow.hasKeyVariable()) {
                return;
            } else {
                z6 = z5;
            }
        }
        if (z6) {
            return;
        }
        addRow(arrayRow);
    }

    void addSingleError(ArrayRow arrayRow, int i6, int i7) {
        arrayRow.addSingleError(createErrorVariable(i7, null), i6);
    }

    public SolverVariable createErrorVariable(int i6, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i7 = this.mVariablesID + 1;
        this.mVariablesID = i7;
        this.mNumColumns++;
        acquireSolverVariable.id = i7;
        acquireSolverVariable.strength = i6;
        this.mCache.mIndexedVariables[i7] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i6 = this.mVariablesID + 1;
        this.mVariablesID = i6;
        this.mNumColumns++;
        acquireSolverVariable.id = i6;
        this.mCache.mIndexedVariables[i6] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow acquire;
        if (OPTIMIZED_ENGINE) {
            acquire = this.mCache.optimizedArrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        } else {
            acquire = this.mCache.arrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i6 = this.mVariablesID + 1;
        this.mVariablesID = i6;
        this.mNumColumns++;
        acquireSolverVariable.id = i6;
        this.mCache.mIndexedVariables[i6] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    Row getGoal() {
        return this.mGoal;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    ArrayRow getRow(int i6) {
        return this.mRows[i6];
    }

    float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        if (metrics != null) {
            metrics.graphOptimizer++;
        }
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            if (!this.mRows[i6].isSimpleDefinition) {
                minimizeGoal(this.mGoal);
                return;
            }
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.fullySolved++;
        }
        computeValues();
    }

    void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i6;
        if (!arrayRow.isSimpleDefinition || (solverVariable = arrayRow.variable) == null) {
            return;
        }
        int i7 = solverVariable.definitionId;
        if (i7 != -1) {
            while (true) {
                i6 = this.mNumRows;
                if (i7 >= i6 - 1) {
                    break;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                int i8 = i7 + 1;
                arrayRowArr[i7] = arrayRowArr[i8];
                i7 = i8;
            }
            this.mNumRows = i6 - 1;
        }
        arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f6) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f6);
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            str = (str + this.mRows[i6]) + e.f37542d;
        }
        Objects.toString(this.mGoal);
        System.out.getClass();
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i6, boolean z5) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i6);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i6, int i7) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i6);
        if (i7 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i7);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i6, boolean z5) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i6);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i6, int i7) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i6);
        if (i7 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i7);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f6, int i6) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f6);
        if (i6 != 8) {
            createRow.addError(this, i6);
        }
        addConstraint(createRow);
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i6 = 0; i6 < this.mVariablesID; i6++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i6];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i6 + "] => " + solverVariable + " = " + solverVariable.computedValue + e.f37542d;
            }
        }
        String str2 = str + "\n\n #  ";
        for (int i7 = 0; i7 < this.mNumRows; i7++) {
            str2 = (str2 + this.mRows[i7].toReadableString()) + "\n #  ";
        }
        if (this.mGoal != null) {
            Objects.toString(this.mGoal);
        }
        System.out.getClass();
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            if (this.mRows[i6].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.mRows[i6].toReadableString()) + e.f37542d;
            }
        }
        Objects.toString(this.mGoal);
        System.out.getClass();
    }

    public void addEquality(SolverVariable solverVariable, int i6) {
        int i7 = solverVariable.definitionId;
        if (i7 == -1) {
            solverVariable.setFinalValue(this, i6);
            return;
        }
        if (i7 != -1) {
            ArrayRow arrayRow = this.mRows[i7];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = i6;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = i6;
                return;
            } else {
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i6);
                addConstraint(createRow);
                return;
            }
        }
        ArrayRow createRow2 = createRow();
        createRow2.createRowDefinition(solverVariable, i6);
        addConstraint(createRow2);
    }
}
