import java.util.Scanner;

public class CaesarCipherProject {
	public static String deciphering(String sentence, int displacement) {
		char[] letters = sentence.toCharArray();

		if (sentence == null || sentence.equals("")) {
			System.out.println("The sentence must have value");
			return "";
		}
		String bulAlphabet = "абвгдежзийклмнопрстуфхцчшщъьюя";
		String bulCapAlphabet = bulAlphabet.toUpperCase(); //главните букви на кирилица

		//цикълът for ни разглежда всеки въведен символ по отделно
		for (int i = 0; i < letters.length; i++) {
			//използвам ascii таблицата в която главните букви от английската азбука
			//се под кодът в интервал 65 до 90
			if (letters[i] <= 90 && letters[i] >= 65) {
				int engDisplacement = displacement;
				// проверяваме ако се въведе по-голямо отместване от 26 да ни
				// изведе остатъка от делението на 26
				// пример: при 28 ще ни изведе 2 , при 57 ще ни изведе 5
				if (displacement > 26) {
					engDisplacement = displacement % 26;
				}
				//проверяваме дали буквата за дешифриране при отместване 
				//ще отиде преди ascii кода на "А"
				if (letters[i] - engDisplacement < 65) {
					//от ascii кода на последната буква (Z) вадим разликата от 
					//кода на буквата и engDisplacement + 64 
					//пример: 'H' - 72(ascii) - 8(displ) < 65 => 90 
					letters[i] = (char) (letters[i] + 90 - (engDisplacement + 64));
				} else {
					//вадим отместването от ascii кода на буквата 
					//и получаваме дешифрованата буква
					letters[i] -= engDisplacement;
				}
			} else {
				//използвам ascii таблицата в която малките букви от английската азбука
				//се под кодът в интервал 65 до 90
				if (letters[i] >= 97 && letters[i] <= 122) {
					int engDisplacement = displacement;
					if (displacement > 26) {
						engDisplacement = displacement % 26;
					}
					//проверяваме дали буквата за дешифроване при отместване 
					//ще отиде преди ascii кода на "а"
					if (letters[i] - engDisplacement < 97) {
						//от ascii кода на последната буква (z) вадим разликата от 
						//кода на буквата и engDisplacement + 96 
						//пример: 'c' - 99(ascii) - 5(displ) < 97 => 122 - 2 -> 'дабалю'
						letters[i] = (char) (letters[i] + 122 - (engDisplacement + 96));
					} else {
						letters[i] -= engDisplacement;
					}
				} else {
					for (int j = 0; j < bulAlphabet.length(); j++) {
						if (letters[i] == bulAlphabet.charAt(j)) {
							int bulDisplacement = displacement;
							// проверяваме ако се въведе по-голямо отместване от 30 да ни
							// изведе остатъка от делението на 30
							// пример: при 32 ще ни изведе 2 , при 65 ще ни изведе 5
							if (displacement > 30) {
								bulDisplacement = displacement % 30;
							}
							if (j - bulDisplacement < 0) {
								//ако номерът на буквата която сме взели от азбуката извадим отместването и получим число < 0 
								//към номерът на буквата прибавяме 30(азбуката) и изваждаме разликата от номерът на буквата и отместването
								letters[i] = bulAlphabet.charAt(j - bulDisplacement + bulAlphabet.length());
								//след като сме дешифровали буквата , прекъсваме цикълът
								break;
							} else {
								//присвояваме буквата с индекс разликата от номера на буквата и отместването
								letters[i] = bulAlphabet.charAt(j - bulDisplacement);
								break;
							}
						} else {
							if (letters[i] == bulCapAlphabet.charAt(j)) {
								int bulDisplacement = displacement;
								// проверяваме ако се въведе по-голямо отместване от 30 да ни
								// изведе остатъка от делението на 30
								// пример: при 32 ще ни изведе 2 , при 65 ще ни изведе 5
								if (displacement > 30) {

									bulDisplacement = displacement % 30;
								}

								if (j - bulDisplacement < 0) {
									//аналогично...
									letters[i] = bulCapAlphabet
											.charAt(j - bulDisplacement + bulCapAlphabet.length());
									break;
								} else {
									letters[i] = bulCapAlphabet.charAt(j - bulDisplacement);
									break;
								}

							}
						}

					}

				}
			}
		}

		return String.valueOf(letters);

	}

	public static String ciphering(String sentence, int displacement) {
		char[] letters = sentence.toCharArray();
	
		if (sentence == null || sentence.equals("")) {
			System.out.println("The sentence must have value");
			return "";
		}
		String bulAlphabet = "абвгдежзийклмнопрстуфхцчшщъьюя";
		String bulCapAlphabet = bulAlphabet.toUpperCase();

		int flag = 0;
		for (int i = 0; i < letters.length; i++) {

			if (Character.isLetter(letters[i])) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("There are no letters!");
			return sentence;
		}

		for (int i = 0; i < letters.length; i++) {

			if (letters[i] <= 90 && letters[i] >= 65) {
				int engDisplacement = displacement;
				// проверяваме ако се въведе по-голямо отместване от 26 да ни
				// изведе остатъка от делението на 26
				// пример: при 28 ще ни изведе 2 , при 57 ще ни изведе 5
				if (displacement > 26) {

					engDisplacement = displacement % 26;
				}
				if (letters[i] + engDisplacement > 90) {
					//ако сборът от ascii кода на буквата и отместването е > 90 
					//вадим от него 90 и прибавяме 64 и получаваме шифрованата буква
					letters[i] = (char) (letters[i] + engDisplacement - 90 + 64);
				} else {
					//прибавяме отместването към индекса на буквата
					letters[i] += engDisplacement;
								}
			} else {
				if (letters[i] >= 97 && letters[i] <= 122) {

					int engDisplacement = displacement;
					// проверяваме ако се въведе по-голямо отместване от 26 да ни
					// изведе остатъка от делението на 26
					// пример: при 28 ще ни изведе 2 , при 57 ще ни изведе 5
					if (displacement > 26) {

						engDisplacement = displacement % 26;
					}
					if (letters[i] + engDisplacement > 122) {
						//ако сборът от ascii кода на буквата и отместването е > 122 
						//вадим от него 122 и прибавяме 96 и получаваме шифрованата буква
						letters[i] = (char) (letters[i] + engDisplacement - 122 + 96);
						
					} else {
						//прибавяме отместването към индекса на буквата
						letters[i] += engDisplacement;				
					}

				} else {
					for (int j = 0; j < bulAlphabet.length(); j++) {

						if (letters[i] == bulAlphabet.charAt(j)) {
							int bulDisplacement = displacement;
							// проверяваме ако се въведе по-голямо отместване от 30 да ни
							// изведе остатъка от делението на 30
							// пример: при 32 ще ни изведе 2 , при 65 ще ни изведе 5
							if (displacement > 30) {
								bulDisplacement = displacement % 30;
							}	
							//понеже азбуката ни започва от индекс 0 , изваждаме от дължината и 1
							if (j + bulDisplacement > bulAlphabet.length()-1) {
								//ако индексът на буквата + отместването > азбуката -1 =>
								//присвояваме на индекса на буквата разликата от сбора на 
								//индекса на буквата  и отместването с дължината на азбуката
								letters[i] = bulAlphabet.charAt(j + bulDisplacement - bulAlphabet.length() );
								break;
							} else {
								//прибавяме към индекса на буквата отместването
								letters[i] = bulAlphabet.charAt(j + bulDisplacement );
								break;
							}
						} else {
							if (letters[i] == bulCapAlphabet.charAt(j)) {
								int bulDisplacement = displacement;
								// проверяваме ако се въведе по-голямо отместване от 30 да ни
								// изведе остатъка от делението на 30
								// пример: при 32 ще ни изведе 2 , при 65 ще ни изведе 5
								if (displacement > 30) {

									bulDisplacement = displacement % 30;
								}
								
								if (j + bulDisplacement > bulCapAlphabet.length()-1) {
									//ако индексът на буквата + отместването > азбуката -1 =>
									//присвояваме на индекса на буквата разликата от сбора на 
									//индекса на буквата  и отместването с дължината на азбуката
									letters[i] = bulCapAlphabet
											.charAt(j + bulDisplacement - bulCapAlphabet.length());
									break;
								} else {
									//аналогично..
									letters[i] = bulCapAlphabet.charAt(j + bulDisplacement );			
									break;
								}

							}
						}

					}
				}

			}
		}

		return String.valueOf(letters);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Insert a sentence: ");
		String sentence = input.nextLine();
		System.out.println("Insert displacement: ");
		int displacement = input.nextInt();
		if (displacement < 0) {
			System.out.println("It was inserted a negative number =>we take its absolute value: " + Math.abs(displacement));
			displacement = Math.abs(displacement);
		}

		System.out.println("The cyphered text is:");
		System.out.println(ciphering(sentence, displacement));
		//ciphering(sentence, displacement) това е шифрованото съобщение или текст
		System.out.println("The decyphered text is:");
		System.out.println(deciphering(ciphering(sentence, displacement), displacement));

	}

}
