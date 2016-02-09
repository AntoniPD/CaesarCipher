import java.util.Scanner;

public class CaesarCipherProject {
	public static String deciphering(String sentence, int displacement) {
		char[] letters = sentence.toCharArray();

		if (sentence == null || sentence.equals("")) {
			System.out.println("The sentence must have value");
			return "";
		}
		String bulAlphabet = "������������������������������";
		String bulCapAlphabet = bulAlphabet.toUpperCase(); //�������� ����� �� ��������

		//������� for �� ��������� ����� ������� ������ �� �������
		for (int i = 0; i < letters.length; i++) {
			//��������� ascii ��������� � ����� �������� ����� �� ����������� ������
			//�� ��� ����� � �������� 65 �� 90
			if (letters[i] <= 90 && letters[i] >= 65) {
				int engDisplacement = displacement;
				// ����������� ��� �� ������ ��-������ ���������� �� 26 �� ��
				// ������ �������� �� ��������� �� 26
				// ������: ��� 28 �� �� ������ 2 , ��� 57 �� �� ������ 5
				if (displacement > 26) {
					engDisplacement = displacement % 26;
				}
				//����������� ���� ������� �� ����������� ��� ���������� 
				//�� ����� ����� ascii ���� �� "�"
				if (letters[i] - engDisplacement < 65) {
					//�� ascii ���� �� ���������� ����� (Z) ����� ��������� �� 
					//���� �� ������� � engDisplacement + 64 
					//������: 'H' - 72(ascii) - 8(displ) < 65 => 90 
					letters[i] = (char) (letters[i] + 90 - (engDisplacement + 64));
				} else {
					//����� ������������ �� ascii ���� �� ������� 
					//� ���������� ������������� �����
					letters[i] -= engDisplacement;
				}
			} else {
				//��������� ascii ��������� � ����� ������� ����� �� ����������� ������
				//�� ��� ����� � �������� 65 �� 90
				if (letters[i] >= 97 && letters[i] <= 122) {
					int engDisplacement = displacement;
					if (displacement > 26) {
						engDisplacement = displacement % 26;
					}
					//����������� ���� ������� �� ����������� ��� ���������� 
					//�� ����� ����� ascii ���� �� "�"
					if (letters[i] - engDisplacement < 97) {
						//�� ascii ���� �� ���������� ����� (z) ����� ��������� �� 
						//���� �� ������� � engDisplacement + 96 
						//������: 'c' - 99(ascii) - 5(displ) < 97 => 122 - 2 -> '������'
						letters[i] = (char) (letters[i] + 122 - (engDisplacement + 96));
					} else {
						letters[i] -= engDisplacement;
					}
				} else {
					for (int j = 0; j < bulAlphabet.length(); j++) {
						if (letters[i] == bulAlphabet.charAt(j)) {
							int bulDisplacement = displacement;
							// ����������� ��� �� ������ ��-������ ���������� �� 30 �� ��
							// ������ �������� �� ��������� �� 30
							// ������: ��� 32 �� �� ������ 2 , ��� 65 �� �� ������ 5
							if (displacement > 30) {
								bulDisplacement = displacement % 30;
							}
							if (j - bulDisplacement < 0) {
								//��� ������� �� ������� ����� ��� ����� �� �������� ������� ������������ � ������� ����� < 0 
								//��� ������� �� ������� ��������� 30(��������) � ��������� ��������� �� ������� �� ������� � ������������
								letters[i] = bulAlphabet.charAt(j - bulDisplacement + bulAlphabet.length());
								//���� ���� ��� ����������� ������� , ���������� �������
								break;
							} else {
								//����������� ������� � ������ ��������� �� ������ �� ������� � ������������
								letters[i] = bulAlphabet.charAt(j - bulDisplacement);
								break;
							}
						} else {
							if (letters[i] == bulCapAlphabet.charAt(j)) {
								int bulDisplacement = displacement;
								// ����������� ��� �� ������ ��-������ ���������� �� 30 �� ��
								// ������ �������� �� ��������� �� 30
								// ������: ��� 32 �� �� ������ 2 , ��� 65 �� �� ������ 5
								if (displacement > 30) {

									bulDisplacement = displacement % 30;
								}

								if (j - bulDisplacement < 0) {
									//����������...
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
		String bulAlphabet = "������������������������������";
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
				// ����������� ��� �� ������ ��-������ ���������� �� 26 �� ��
				// ������ �������� �� ��������� �� 26
				// ������: ��� 28 �� �� ������ 2 , ��� 57 �� �� ������ 5
				if (displacement > 26) {

					engDisplacement = displacement % 26;
				}
				if (letters[i] + engDisplacement > 90) {
					//��� ������ �� ascii ���� �� ������� � ������������ � > 90 
					//����� �� ���� 90 � ��������� 64 � ���������� ����������� �����
					letters[i] = (char) (letters[i] + engDisplacement - 90 + 64);
				} else {
					//��������� ������������ ��� ������� �� �������
					letters[i] += engDisplacement;
								}
			} else {
				if (letters[i] >= 97 && letters[i] <= 122) {

					int engDisplacement = displacement;
					// ����������� ��� �� ������ ��-������ ���������� �� 26 �� ��
					// ������ �������� �� ��������� �� 26
					// ������: ��� 28 �� �� ������ 2 , ��� 57 �� �� ������ 5
					if (displacement > 26) {

						engDisplacement = displacement % 26;
					}
					if (letters[i] + engDisplacement > 122) {
						//��� ������ �� ascii ���� �� ������� � ������������ � > 122 
						//����� �� ���� 122 � ��������� 96 � ���������� ����������� �����
						letters[i] = (char) (letters[i] + engDisplacement - 122 + 96);
						
					} else {
						//��������� ������������ ��� ������� �� �������
						letters[i] += engDisplacement;				
					}

				} else {
					for (int j = 0; j < bulAlphabet.length(); j++) {

						if (letters[i] == bulAlphabet.charAt(j)) {
							int bulDisplacement = displacement;
							// ����������� ��� �� ������ ��-������ ���������� �� 30 �� ��
							// ������ �������� �� ��������� �� 30
							// ������: ��� 32 �� �� ������ 2 , ��� 65 �� �� ������ 5
							if (displacement > 30) {
								bulDisplacement = displacement % 30;
							}	
							//������ �������� �� ������� �� ������ 0 , ��������� �� ��������� � 1
							if (j + bulDisplacement > bulAlphabet.length()-1) {
								//��� �������� �� ������� + ������������ > �������� -1 =>
								//����������� �� ������� �� ������� ��������� �� ����� �� 
								//������� �� �������  � ������������ � ��������� �� ��������
								letters[i] = bulAlphabet.charAt(j + bulDisplacement - bulAlphabet.length() );
								break;
							} else {
								//��������� ��� ������� �� ������� ������������
								letters[i] = bulAlphabet.charAt(j + bulDisplacement );
								break;
							}
						} else {
							if (letters[i] == bulCapAlphabet.charAt(j)) {
								int bulDisplacement = displacement;
								// ����������� ��� �� ������ ��-������ ���������� �� 30 �� ��
								// ������ �������� �� ��������� �� 30
								// ������: ��� 32 �� �� ������ 2 , ��� 65 �� �� ������ 5
								if (displacement > 30) {

									bulDisplacement = displacement % 30;
								}
								
								if (j + bulDisplacement > bulCapAlphabet.length()-1) {
									//��� �������� �� ������� + ������������ > �������� -1 =>
									//����������� �� ������� �� ������� ��������� �� ����� �� 
									//������� �� �������  � ������������ � ��������� �� ��������
									letters[i] = bulCapAlphabet
											.charAt(j + bulDisplacement - bulCapAlphabet.length());
									break;
								} else {
									//����������..
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
		//ciphering(sentence, displacement) ���� � ����������� ��������� ��� �����
		System.out.println("The decyphered text is:");
		System.out.println(deciphering(ciphering(sentence, displacement), displacement));

	}

}
