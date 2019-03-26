public class GateNot extends LogicGate {
    private LogicVariable input;

    public GateNot(LogicVariable internal, LogicVariable x1) throws ColisionException, CycleException {
        super(internal, "NOT");
        this.input = x1;
        runCycleCheck(internal);
    }

    @Override
    public void updateInternal() {
        internal.setValue(!input.getValue());
    }

    @Override
    public LogicVariable getOutput() {
        updateInternal();
        return internal;
    }

    @Override
    public LogicVariable[] getInputs() {
        return new LogicVariable[]{input};
    }

    @Override
    public String getFormula() {
        return symbol + "(" + input.getFormula() + ")";
    }
}
