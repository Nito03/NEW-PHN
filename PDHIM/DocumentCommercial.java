public abstract class DocumentCommercial {
    protected long numero;
    protected Client client;
    protected Detail detail;

    public abstract double getTotal();
    public abstract double getTVA();
}

