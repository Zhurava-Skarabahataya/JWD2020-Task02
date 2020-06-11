package by.epamtc.zhurava.task02;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String text = "На чешуе жестяной рыбы прочел я зовы новых губ. "
				+ "А вы ноктюрн сыграть могли бы на флейте водосточных труб?";
		String text2 = "Not all those who wander are lost.";
		String text3 = "   Eva,    can I  see bees   in a  cave?  ";

		System.out.printf("Исходный текст: %s\n", text);

		System.out.println(divideEvenAndUnevenSymbols(text));

		System.out.println(determineLowerAndUpperCase(text));

		System.out.println(deleteIdenticalSymbols(text));

		System.out.println("Частота символа 'ы' в строке " + frequencyOfSymbol(text, 'ы'));

		System.out.println("Строка наоборот: " + reverseString(text));

		System.out.println(insertSubstring(text, "внезапная подстрока", 10));

		System.out.println(deleteSubstring(text, 4, 11));

		System.out.println(copySubstring(text, 5, 12));

		System.out.printf("Длина строки: %d\n", text.length());

		String word = "уб";
		System.out.println(word + " входит в строку " + countNumberOfSubstringOccurences(text, word) + " раз(а).");

		System.out.println(reverceWords(text));

		System.out.println(replaceSpaces(text));

		System.out.println(replaceLetterInLongestWord(text2));

		System.out.println(findShortesWordLength(text2));

		System.out.println(countWordsInText(text2));

		System.out.println(switchWords(text2, "are", "those"));

		System.out.println(deleteLastWord(text2));

		System.out.println(addSpaces(text2));

		System.out.println("Палиндром? " + isPalindrom(text3));

		System.out.println(replacingSubstring(text, "ноктюрн", "менуэт"));

		System.out.println(findBigSum("1234567890", "987654321987654321"));

		System.out.println(deletWordsWithLength(text2, 3));

		System.out.println(deleteExtraSpaces(text3));

		System.out.println(Arrays.deepToString(extractWords(text)));
	}

	/*
	 * Четные и нечетные символы разделить по разным строкам.
	 */
	private static String divideEvenAndUnevenSymbols(String text) {

		StringBuilder unevenSymbols = new StringBuilder();
		StringBuilder evenSymbols = new StringBuilder();

		for (int index = 0; index < text.length(); index++) {

			if ((index + 1) % 2 == 0) {
				evenSymbols.append(text.charAt(index));
			} else {
				unevenSymbols.append(text.charAt(index));
			}
		}

		return "Разделение символов по строкам:\n" + "Четные символы: " + evenSymbols + "\nНечетные символы: "
				+ unevenSymbols;
	}

	/*
	 * Процентное соотношение строчных и прописных букв
	 */
	private static String determineLowerAndUpperCase(String text) {

		int countLowerCase;
		int countUpperCase;

		countLowerCase = 0;
		countUpperCase = 0;

		for (int index = 0; index < text.length(); index++) {
			char c = text.charAt(index);

			if (Character.isLetter(c)) {

				if (Character.isLowerCase(c)) {
					countLowerCase++;
				} else if (Character.isUpperCase(c)) {
					countUpperCase++;
				}
			}
		}

		int countLettersTotal = countLowerCase + countUpperCase;

		double percentLowerCase = 100.0 * countLowerCase / countLettersTotal;
		double percentUpperCase = 100.0 * countUpperCase / countLettersTotal;

		return String.format("Прописных букв %.2f %%\nСтрочных букв %.2f %%", percentUpperCase, percentLowerCase);
	}

	/*
	 * Удаление одинаковых символов
	 */
	private static String deleteIdenticalSymbols(String text) {
		StringBuilder result = new StringBuilder();

		for (int index = 0; index < text.length(); index++) {
			char ch;

			ch = text.charAt(index);

			if (!isContainsAlready(result, ch)) {
				result.append(ch);
			}
		}
		return result.toString();
	}

	private static boolean isContainsAlready(StringBuilder result, char ch) {
		for (int i = 0; i < result.length(); i++) {

			if (result.charAt(i) == ch) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Частота встречаемости символа в строке
	 */
	private static int frequencyOfSymbol(String text, char ch) {
		int counter;
		counter = 0;

		for (int index = 0; index < text.length(); index++) {
			if (text.charAt(index) == ch) {
				counter++;
			}
		}

		return counter;
	}

	/*
	 * Переворот строки
	 */
	private static String reverseString(String text) {
		StringBuilder result;
		result = new StringBuilder(text);

		result.reverse();

		return result.toString();
	}

	/*
	 * Вставка подстроки
	 */
	private static String insertSubstring(String text, String substring, int index) {
		if (index > text.length()) {
			return "Индекс превышен";
		}

		StringBuilder result;
		result = new StringBuilder(text);

		result.insert(index, substring);

		return result.toString();
	}

	/*
	 * Удаление подстроки
	 */
	private static String deleteSubstring(String text, int indexStart, int indexEnd) {
		StringBuilder result;
		result = new StringBuilder(text);

		result.delete(indexStart, indexEnd + 1);

		return result.toString();
	}

	/*
	 * Копирование части строки
	 */
	private static String copySubstring(String text, int startIndex, int endIndex) {
		StringBuilder result;
		String substring;

		result = new StringBuilder(text);
		substring = text.substring(startIndex, endIndex + 1);

		result.insert(startIndex, substring);

		return result.toString();
	}

	/*
	 * Количество вхождений подстроки в строку
	 */
	private static int countNumberOfSubstringOccurences(String text, String substring) {
		int count;
		count = 0;

		while (text.contains(substring)) {
			text = text.replaceFirst(substring, "");
			count++;
		}

		return count;
	}

	/*
	 * Вывести слова строки в обратном порядке
	 */
	private static String reverceWords(String text) {
		String[] words;
		words = text.split("[ \\.,!\\?]+");

		StringBuilder result;
		result = new StringBuilder();

		for (int index = words.length - 1; index >= 0; index--) {
			result.append(words[index]);
			result.append(" ");
		}

		return result.toString();
	}

	/*
	 * Заменить пробел и группы пробелов символом "*"
	 */
	private static String replaceSpaces(String text) {
		String result;
		result = text.replaceAll("[ ]+", "*");

		return result;
	}

	/*
	 * Заменить в самом длинном слове строки буквы 'a' на 'b'
	 */
	private static String replaceLetterInLongestWord(String text) {
		String longestWord;
		longestWord = findLongestWord(text);

		String longestWordWithoutA;
		longestWordWithoutA = longestWord.replace('a', 'b');

		String result;
		result = text.replace(longestWord, longestWordWithoutA);

		return result;
	}

	private static String findLongestWord(String text) {
		String[] words;
		words = text.split("[ \\.,!\\?]+");

		String longestWord;
		int longestLength;

		longestWord = "";
		longestLength = 0;

		for (String word : words) {
			if (word.length() > longestLength) {
				longestLength = word.length();
				longestWord = word;
			}
		}
		return longestWord;
	}

	/*
	 * Определить длину самого короткого слова в строке
	 */
	private static int findShortesWordLength(String text) {
		String[] words;
		words = text.split("[ \\.,!\\?]+");

		int shortestLength;
		shortestLength = words[0].length();

		for (String word : words) {
			if (word.length() < shortestLength) {
				shortestLength = word.length();
			}
		}
		return shortestLength;
	}

	/*
	 * Подсчет количества слов в строке
	 */

	private static int countWordsInText(String text) {
		String[] words;
		words = text.split("[ \\.,!\\?]+");

		return words.length;
	}

	/*
	 * Поменять слова местами
	 */
	private static String switchWords(String text, String firstWord, String secondWord) {
		int indexFirst;
		int indexSecond;

		indexFirst = text.indexOf(firstWord);
		indexSecond = text.indexOf(secondWord);

		if (indexFirst < indexSecond) {
			text = text.replace(secondWord, firstWord);
			text = text.replaceFirst(firstWord, secondWord);
		}

		else {
			text = text.replace(firstWord, secondWord);
			text = text.replaceFirst(secondWord, firstWord);
		}
		return text;
	}

	/*
	 * Удаление последнего слова в строке
	 */
	private static String deleteLastWord(String text) {
		String lastWord;
		lastWord = findLastWord(text);

		StringBuilder result;
		result = new StringBuilder(text);

		int lastIndex;
		lastIndex = text.lastIndexOf(lastWord);

		result.delete(lastIndex, lastIndex + lastWord.length());

		return result.toString();
	}

	private static String findLastWord(String text) {
		String[] words;
		words = text.split("[ \\.,!\\?]+");

		return words[words.length - 1];
	}

	/*
	 * Добавление пробелов в строку
	 */
	private static String addSpaces(String text) {
		String result;
		result = text.replaceAll(" ", "  ");

		return result;
	}

	/*
	 * Является ли строка палиндром?
	 */
	private static boolean isPalindrom(String text) {
		text = text.toLowerCase();

		int middle;
		middle = text.length() / 2;

		for (int startInd = 0, endInd = text.length() - 1; startInd < middle && endInd > middle; startInd++, endInd--) {
			if (!Character.isLetter(text.charAt(startInd))) {
				endInd++;
				continue;
			}
			if (!Character.isLetter(text.charAt(endInd))) {
				startInd--;
				continue;
			}
			if (text.charAt(startInd) != text.charAt(endInd)) {
				return false;
			}
		}

		return true;
	}

	/*
	 * Замена подстроки в строке
	 */
	private static String replacingSubstring(String text, String substring, String replacement) {
		String result;
		result = text.replaceAll(substring, replacement);

		return result;
	}

	/*
	 * Сложение очень длинных целых чисел
	 */
	private static String findBigSum(String aStr, String bStr) {
		StringBuilder result;
		result = new StringBuilder();

		StringBuilder a;
		a = new StringBuilder(aStr);
		StringBuilder b;
		b = new StringBuilder(bStr);
		a.reverse();
		b.reverse();

		int remainder;
		remainder = 0;
		
		int maxLength;
		maxLength = Math.max(a.length(), b.length());

		for (int i = 0; i < maxLength; i++) {
			int sum;

			if (a.length() > i && b.length() > i) {
				char chA = a.charAt(i);
				char chB = b.charAt(i);
				sum = (int) (chA - '0') + (int) (chB - '0') + remainder;
				result.append(sum % 10);
				remainder = sum / 10;
			} else if (a.length() <= i) {
				char chB = b.charAt(i);
				sum = (int) (chB - '0') + remainder;
				result.append(sum % 10);
			} else {
				char chA = a.charAt(i);
				sum = (int) (chA - '0') + remainder;
				result.append(sum % 10);
			}
		}
		return result.reverse().toString();
	}

	/*
	 * Удаление из строки слов заданной длины
	 */
	private static String deletWordsWithLength(String text, int length) {
		String[] words;
		words = text.split("[ \\.,!\\?]+");

		for (String word : words) {
			if (word.length() == length) {
				text = text.replaceAll(word, "");
			}
		}

		return text;
	}

	/*
	 * Удаление лишних пробелов
	 */
	private static String deleteExtraSpaces(String text3) {
		String result;

		result = text3.trim();
		result = result.replaceAll("[\\s]{2,}+", " ");

		return result;
	}

	/*
	 * Выделение слов из строки
	 */
	private static String[] extractWords(String text) {
		String[] words;
		words = text.split("[ \\.,!\\?]+");

		return words;
	}

}
