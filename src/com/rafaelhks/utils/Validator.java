package com.rafaelhks.utils;

public class Validator {
	private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	private String teste;

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int i=str.length()-1, digito; i >= 0; i--) {
			digito = Integer.parseInt(str.substring(i,i+1));
			soma += digito*peso[peso.length-str.length()+i];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	public static boolean isValidCPF(String cpf) {
		cpf = cpf.replaceAll("[./-]", "");
		System.out.println(cpf);
		if ((cpf==null) || (cpf.length()!=11)) return false; //Se tamanho estiver errado

		Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF); //Valida primeiro digito
		Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF); //Valida segundo digito
		return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString()); 
	}

	public static boolean isValidCNPJ(String cnpj) {
		cnpj = cnpj.replaceAll("[./-]", "");
		System.out.println(cnpj);
		if ((cnpj==null)||(cnpj.length()!=14)) return false; //Se tamanho estiver errado

		Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ); //Valida primeiro digito
		Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ); //Valida segundo digito
		return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
	}
	
	public static boolean isValidPhone(String phone) {
		return (phone.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}") ||
			    phone.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}"));
	}
	
	public static boolean isValidEmail(String email) {
		return email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
	}
	
	public String getTeste() {
		return teste;
	}
	
	public void setTeste(String teste) {
		this.teste = teste;
	}
}
