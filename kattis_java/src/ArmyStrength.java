public class ArmyStrength {

    Kattio io = new Kattio(System.in, System.out);
    private static int strongestGodzilla, strongestMecha;
    private final static String GODZILLA_WINS = "Godzilla";
    private final static String MECHAGODZILLA_WINS = "MechaGodzilla";

    public static void main(String[] args) {
        new ArmyStrength();
    }

    public ArmyStrength() {
        int numberOfTestCases = io.getInt();
        for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
            strongestGodzilla = 0; strongestMecha = 0;
            // Handles input according to specification.
            handleInput();
            if (strongestMecha > strongestGodzilla)
                System.out.println(MECHAGODZILLA_WINS);
            else System.out.println(GODZILLA_WINS);
        }
        io.flush();
    }

    void handleInput() {
        int numGodzillaMonsters = io.getInt();
        int numMechaGodzillaMonsters = io.getInt();
        for (int index = 0; index < numGodzillaMonsters; index++) {
            int monster = io.getInt();
            if (monster > strongestGodzilla)
                strongestGodzilla = monster;
        }
        for (int index = 0; index < numMechaGodzillaMonsters; index++) {
            int monster = io.getInt();
            if (monster > strongestMecha)
                strongestMecha = monster;
        }
    }
}