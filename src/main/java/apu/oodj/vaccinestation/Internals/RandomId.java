package apu.oodj.vaccinestation.Internals;

public class RandomId {
    public static String generate() {
        // Get current unix timestamp
        // round number to 0 decimals
        long timestamp =  System.currentTimeMillis() / 1000;
        // Use snowflake format
        return "Id-" + timestamp;
    }

    public static String generate(String prefix) {
        // Get current unix timestamp
        // round number to 0 decimals
        long timestamp =  System.currentTimeMillis() / 1000;
        // Use snowflake format
        return prefix + "-" + timestamp;
    }

    // Debugging purposes
    public static void main(String[] args) {
        System.out.println(generate());
    }
}
