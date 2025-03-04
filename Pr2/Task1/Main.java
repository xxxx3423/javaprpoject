import java.io.Serializable;

class ComputationData implements Serializable {
    private static final long serialVersionUID = 1L; 
    private double param1;
    private double param2;
    private double result;

    public ComputationData(double param1, double param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public void compute() {
        this.result = param1 + param2;
    }

    public double getResult() {
        return result;
    }
}
class ComputationProcessor {
    private ComputationData data;

    public ComputationProcessor(double param1, double param2) {
        this.data = new ComputationData(param1, param2);
    }

    public void performComputation() {
        data.compute();
    }

    public double getComputationResult() {
        return data.getResult();
    }
}

public class Main {
    public static void main(String[] args) {
        ComputationProcessor processor = new ComputationProcessor(10.5, 20.3);
        processor.performComputation();
        System.out.println("Result: " + processor.getComputationResult());
    }
}
