public class Main {

    public static void main(String[] args) {
        int counter = 0;
        for (Secret x : Secret.values()) {
            if (x.name().toString().startsWith("STAR")) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}


/*
   enum Secret {
    STAR, CRASH, START,
}
*/
