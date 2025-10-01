package factory;

public abstract class Quiz {
    protected int variantId;

    public Quiz(int variantId) {
        this.variantId = variantId;
    }

    public abstract void generate(String studentName);
}
