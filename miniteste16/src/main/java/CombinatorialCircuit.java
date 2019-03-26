import java.util.HashMap;
import java.util.Map;

public class CombinatorialCircuit {
    private Map<String, LogicVariable> variables;

    public CombinatorialCircuit() {
        this.variables = new HashMap<>();
    }


    public boolean addVariable(LogicVariable b) {
        if (variables.containsKey(b.getName())) {
            return false;
        }
        variables.put(b.getName(), b);
        return true;
    }

    public LogicVariable getVariableByName(String x1) {
        return variables.get(x1);
    }
}
