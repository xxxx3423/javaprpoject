public class CommandLineArgs {
    public static void main(String[] args) {
        System.out.println("Argumentu komandnogo raydka:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + (i + 1) + ": " + args[i]);
        }
    }
}
