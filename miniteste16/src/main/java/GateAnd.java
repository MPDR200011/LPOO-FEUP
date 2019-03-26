public class GateAnd extends LogicGate {
    private LogicVariable left;
    private LogicVariable right;

    public GateAnd(LogicVariable internal, LogicVariable x1, LogicVariable x2) throws ColisionException, CycleException {
        super(internal, "AND");
        this.right = x2;
        this.left = x1;
        runCycleCheck(internal);
    }

    @Override
    public void updateInternal() {
        internal.setValue(left.getValue() && right.getValue());
    }

    @Override
    public LogicVariable getOutput() {
        updateInternal();
        return internal;
    }

    @Override
    public LogicVariable[] getInputs() {
        return new LogicVariable[]{left,right};
    }

    @Override
    public String getFormula() {
        return symbol + "(" + left.getFormula() + "," + right.getFormula() + ")";
    }
}
