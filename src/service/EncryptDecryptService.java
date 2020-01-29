package service;

public interface EncryptDecryptService {
    static String encrypt(final String text, final int n) {
        char[] arr = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int secNum = 1;
        int counter = n;
        for (int j=0; j<n; j++) {
            if (n==0 || text.equals("")) {
                break;
            }
            for (int i=0; i<=arr.length; i++) {
                if (secNum<=arr.length-1) {
                    stringBuilder.append(arr[secNum]);
                    secNum=secNum+2;
                } else {
                    secNum=0;
                }
            }
            if (counter>1) {
                counter--;
                arr = stringBuilder.toString().toCharArray();
                stringBuilder = new StringBuilder();
                secNum=1;
            }
        }
        return n==0 && !text.equals("") && !text.equals(null)
                ? text : text.equals("") ? "" : stringBuilder.toString();
    }

    static String decrypt(final String encryptedText, final int n) {
        char[] arr = encryptedText.toCharArray();
        char[] res = new char[arr.length];
        StringBuilder stringBuilder = new StringBuilder();
        int secNum=1;
        int counter=n;
        for (int j=0; j<n; j++) {
            if (n==0 || encryptedText.equals("")) {
                break;
            }
            for (int i=0; i<=arr.length-1; i++) {
                if (secNum<res.length) {
                    res[secNum] = arr[i];
                    secNum=secNum+2;
                } else {
                    secNum=0;
                    res[secNum] = arr[i];
                    secNum=secNum+2;
                }
            }
            if (counter>1) {
                counter--;
                for (int i=0; i<res.length; i++) {
                    arr[i] = res[i];
                }
                secNum=1;
            }
        }
        for(int i=0; i<res.length; i++) {
            stringBuilder.append(res[i]);
        }
        return n==0 && !encryptedText.equals("") && !encryptedText.equals(null)
                ? encryptedText : encryptedText.equals("") ? "" : stringBuilder.toString();
    }
}
