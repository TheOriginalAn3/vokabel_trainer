public class Vocab {

    /*
     * Use the same TikTok trick from MyVars to only allow a single object/instance
     * of this class
     */
    private static Vocab instance = null;
    private Vocab() {
            // Exists only to defeat instantiation.
        }

    public static Vocab getInstance() {
        if (instance == null) {
            System.out.println("MyVars Object not existent...");
            instance = new Vocab();
        } else {
            System.out.println("MyVars Object already exists...");
        }
        System.out.println("Returning this instance");
        return instance;
    }
    // This marks the end of the trick i saw on TikTok


    
}
