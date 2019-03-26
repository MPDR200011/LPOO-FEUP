import java.util.Stack;

public abstract class LogicGate {
    protected LogicVariable internal;
    protected String symbol;

    public LogicGate(LogicVariable internal, String symbol) throws ColisionException {
        this.internal = internal;
        this.symbol = symbol;

        internal.setCalculatedBy(this);
    }

    protected void runCycleCheck(LogicVariable internal) throws CycleException {
        for (LogicVariable v: getInputs()) {
            if (v != internal) {
                LogicGate gate = v.getCalculatedBy();
                if (gate != null) {
                    gate.runCycleCheck(internal);
                }
            } else {
                throw new CycleException();
            }
        }
    }

    public abstract void updateInternal();

    public abstract LogicVariable getOutput();

    public abstract LogicVariable[] getInputs();

    public String getSymbol() {
        return symbol;
    }

    public abstract String getFormula();
}
