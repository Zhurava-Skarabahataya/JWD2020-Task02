package by.epamtc.zhurava.task02;

public class Main {

	public static void main(String[] args) {
		String text = "На чешуе жестяной рыбы прочел я зовы новых губ.     "
				+ "А вы ноктюрн сыграть могли бы на флейте водосточных труб?";
		System.out.printf("Исходный текст: %s\n", text);

		
		divideEvenAndUnevenSymbols(text);

		determineLowerAndUpperCase(text);

		deleteIdenticalSymbols(text);

		frequencyOfSymbol(text);

		reverseString(text);

		String substring;
		int substringIndex;

		substring = "внезапная подстрока";
		substringIndex = 5;

		System.out.println(insertSubstring(text, substring, substringIndex));

		int indexStartSubstring;
		int indexEndSubstring;

		indexStartSubstring = 4;
		indexEndSubstring = 11;

		System.out.println(deleteSubstring(text, indexStartSubstring, indexEndSubstring));

		String copiedSubstring = copySubstring(text, 5, 12);
		System.out.println(copiedSubstring);

		int stringLength = text.length();
		System.out.printf("Длина строки: %d\n", stringLength);

		String word = "уб";
		int numberOfOccurences = countNumberOfSubstringOccurences(text, word);
		System.out.println(numberOfOccurences);

		String revercedWords = reverceWords(text);
		System.out.println(revercedWords);
		
		String replacedSpaces = replaceSpaces(text);
		System.out.println(replacedSpaces);
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
	 * Вывести слова строки в обратном порядке
	 */
	private static String reverceWords(String text) {
		String[] words;
		words = text.split("[ \\.,!\\?]+");
		
		StringBuilder result;
		result = new StringBuilder();
		
		for (int index = words.length - 1; index >=0; index--) {
			result.append(words[index]);
			result.append(" ");
		}
		
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

	/**
	 * Копирование части строки
	 * 
	 * @param text
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private static String copySubstring(String text, int startIndex, int endIndex) {
		StringBuilder result;
		String substring;

		result = new StringBuilder();
		substring = text.substring(startIndex, endIndex + 1);

		result.append(text, 0, startIndex);
		result.append(substring);
		result.append(text, startIndex, text.length());

		return result.toString();
	}

	/**
	 * Удаление подстроки
	 * 
	 * @param text
	 * @param indexStartSubstring
	 * @param substringLength
	 */
	private static String deleteSubstring(String text, int indexStart, int indexEnd) {
		StringBuilder result;
		result = new StringBuilder(text);

		result.delete(indexStart, indexEnd + 1);

		return result.toString();
	}

	/**
	 * Вставка подстроки
	 * 
	 * @param text
	 * @param substring
	 */
	private static String insertSubstring(String text, String substring, int index) {
		if (index > text.length()) {
			return "Индекс превышен";
		}

		StringBuilder result;
		result = new StringBuilder();

		result.append(text, 0, index);
		result.append(substring);
		result.append(text, index, text.length());

		return result.toString();
	}

	/**
	 * Переворот строки
	 * 
	 * @param text
	 */
	private static void reverseString(String text) {
		StringBuilder result;
		result = new StringBuilder(text);

		result.reverse();

		System.out.println(result);
	}

	/**
	 * Частота встречаемости символа в строке
	 * 
	 * @param text
	 */
	private static void frequencyOfSymbol(String text) {

	}

	/**
	 * Удаление одинаковых символов
	 * 
	 * @param text
	 */
	private static void deleteIdenticalSymbols(String text) {

	}

	/**
	 * Процентное соотношение строчных и прописных букв
	 * 
	 * @param text
	 */
	private static void determineLowerAndUpperCase(String text) {

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

		System.out.printf("Прописных букв %.2f %%\n", percentUpperCase);
		System.out.printf("Строчных букв %.2f %%\n", percentLowerCase);

	}

	/**
	 * Четные и нечетные символы разделить по разным строкам.
	 * 
	 * @param text
	 */
	private static void divideEvenAndUnevenSymbols(String text) {

		StringBuilder unevenSymbols = new StringBuilder();
		StringBuilder evenSymbols = new StringBuilder();

		for (int index = 0; index < text.length(); index++) {

			if ((index + 1) % 2 == 0) {
				evenSymbols.append(text.charAt(index));
			} else {
				unevenSymbols.append(text.charAt(index));
			}
		}

		System.out.println("Разделение символов по строкам:");
		System.out.println("Четные символы:" + evenSymbols);
		System.out.println("Нечетные символы:" + unevenSymbols);

	}

}
