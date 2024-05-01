public class Prac2 {

    public static String encrypt(String message, int[] key) {
        int numColumns = key.length;
        int numRows = (int) Math.ceil((double) message.length() / numColumns);

        // Pad the message with spaces if needed
        message = String.format("%-" + numRows * numColumns + "s", message);

        char[][] grid = new char[numRows][numColumns];

        // Fill the transposition grid
        int index = 0;
        for (int col : key) {
            for (int row = 0; row < numRows; row++) {
                grid[row][col - 1] = message.charAt(index++);
            }
        }

        // Read the grid column-wise to get the encrypted message
        StringBuilder encryptedMessage = new StringBuilder();
        for (char[] row : grid) {
            for (char ch : row) {
                encryptedMessage.append(ch);
            }
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage, int[] key) {
        int numColumns = key.length;
        int numRows = (int) Math.ceil((double) encryptedMessage.length() / numColumns);

        char[][] grid = new char[numRows][numColumns];

        // Fill the transposition grid with the encrypted message
        int index = 0;
        for (int col : key) {
            for (int row = 0; row < numRows; row++) {
                grid[row][col - 1] = encryptedMessage.charAt(index++);
            }
        }

        // Read the grid row-wise to get the decrypted message
        StringBuilder decryptedMessage = new StringBuilder();
        for (char[] row : grid) {
            for (char ch : row) {
                decryptedMessage.append(ch);
            }
        }

        return decryptedMessage.toString().trim();
    }

    public static void main(String[] args) {
        // Example usage:
        String message = "HELLOWORLD";
        int[] key = {2, 1, 4, 3}; // Example key for column rearrangement

        // Encrypt the message
        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}

