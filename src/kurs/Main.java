package kurs;

//Сегодня поработаем с массивами. Давайте напишем функцию, которая на вход получает массив слов. Например:
//["apple banana", "orange", "banana", "kiwi strawberry blueberry"]
//Видно, что в этом массиве в некоторых слотах затесалось сразу несколько слов. На выходе функция
//должна вернуть такой массив, где одно слово будет в каждом элементе:
//["apple", "banana", "orange", "banana", "kiwi", "strawberry", "blueberry"]
//Словом считается любой набор символов, обособленный пробелами или началом/концом строки.

public class Main {

    public static void main(String[] args) {
	    String[] inWords = {"apple banana", "orange", "banana", "kiwi strawberry blueberry"};
        System.out.println("БЫЛО: ");
	    outWords(inWords, 0);
	    String[] outWords = splitWords(inWords);
        System.out.println("СТАЛО: ");
        outWords(outWords, 0);
    }

    private static String[] splitWords(String[] words) {
        //можно получить слова по одному элементу, потом сложить
        //получается массив массивов сначала, потом легко его конвертируем в один
        //вторую размерность не задаем, она будет динамической
        String[][] tempArray = new String[words.length][];

        int totalSize = 0;
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = words[i].split(" ");
            totalSize += tempArray[i].length;
        }

        String[] outArray = new String[totalSize];
        int outIndex = 0;
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                outArray[outIndex] = tempArray[i][j];
                outIndex++;
            }
        }
        return outArray;
    }

    private static void outWords(String[] words, int wordsInRow) {
        boolean wasCRLF = false;
        int length = words.length;
        for (int i = 0; i < length; i++) {
            System.out.printf("\"%s\"%s ", words[i], i < length - 1 ? "," : "");
            if (wordsInRow != 0 && i > 0 && i % wordsInRow == 0) {
                System.out.println();
                wasCRLF = true;
            } else
                wasCRLF = false;
        }
        if (wasCRLF) return;
        System.out.println();
    }
}
