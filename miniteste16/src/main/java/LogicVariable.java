public class LogicVariable {
    private String name;
    private boolean value;

    private LogicGate calculatedBy;

    public LogicVariable(String name) {
        this.name = name;
        this.value = false;
    }

    public LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getValue() {
        if (calculatedBy != null) {
            calculatedBy.updateInternal();
        }
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public LogicGate getCalculatedBy() {
        return calculatedBy;
    }

    public void setCalculatedBy(LogicGate calculatedBy) throws ColisionException {
        if (this.calculatedBy != null) {
            if (this.calculatedBy != calculatedBy) {
                throw new ColisionException();
            }
        }
        this.calculatedBy = calculatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o instanceof LogicVariable) {
            LogicVariable other = (LogicVariable) o;
            return name.equals(other.name) && value == other.value;
        }
        return false;
    }

    public String getFormula() {
        if (calculatedBy == null) {
            return name;
        } else {
            return calculatedBy.getFormula();
        }
    }
}

