public abstract class CommandStrategy {
    private OutputStrategy outputStrategy;
    private VendureConnection vendureConnection;

    abstract void execute(VendureConnection vendureConnection, OutputStrategy outputStrategy);
}
