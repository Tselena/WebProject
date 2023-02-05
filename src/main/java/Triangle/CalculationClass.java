package Triangle;

public class CalculationClass {
    int a, b, c;

    public int calculateGeroneFormula(int a, int b, int c) throws MyExcemption {
        if (testValue(a, b, c)) throw new MyExcemption("This is not a triangle");
        int p = (a + b + c) / 2;
        int result = (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;

    }

    private boolean testValue (int a, int b, int c){
        return a<=0 || b<=0 || c<=0;
    }
}
