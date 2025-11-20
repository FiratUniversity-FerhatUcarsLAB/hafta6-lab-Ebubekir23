/*
 * Ad Soyad: Ebubekir Yılmaz
 * Öğrenci No: 250541051
 * Tarih: 14.11.2025
 * Açıklama: Öğrenci Not Değerlendirme Sistemi
 * Bu program öğrencinin vize, final ve ödev notlarını alır.
 * Ortalama hesaplar, geçip geçmediğini belirler, harf notunu verir.
 * Ayrıca öğrencinin onur listesinde olup olmadığını ve bütünleme hakkını kontrol eder.
 */

import java.util.Scanner;

public class NotSistemi {

	// ortalama hesaplama
	public static double calculateAverage(int vize, int final_notu, int odev) {

		return vize * 0.3 + final_notu * 0.4 + odev * 0.3;
	}

	// geçme kalma durumu
	public static boolean isPassingGrade(double ort) {
		return ort >= 50;
	}

	// harf belirleme
	public static String getLetterGradeString(double ort) {
		if (ort >= 90)
			return "A";
		else if (ort >= 80)
			return "B";
		else if (ort >= 70)
			return "C";
		else if (ort >= 60)
			return "D";
		else
			return "F";
	}

	// onur listesi
	public static boolean isHonorList(double ort, int vize, int final_notu, int odev) {
		return ort >= 85 && vize >= 70 && final_notu >= 70 && odev >= 70;
	}

	// bütünleme hakkı
	public static boolean hasRetakeRight(double ort) {
		return ort >= 40 && ort < 50;
	}

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);

		System.out.print("----- ÖĞRENCİ NOT SİSTEMİ -----\n");

		System.out.print("Vize: ");
		int vize = inputScanner.nextInt();
		System.out.print("Final: ");
		int final_notu = inputScanner.nextInt();
		System.out.print("Ödev: ");
		int odev = inputScanner.nextInt();

		double ort = calculateAverage(vize, final_notu, odev);
		boolean passed = isPassingGrade(ort);
		String letter = getLetterGradeString(ort);
		boolean honor = isHonorList(ort, vize, final_notu, odev);
		boolean retake = hasRetakeRight(ort);

		System.out.printf("\nOrtalama: %.2f\n", ort);

		if (passed)
			System.out.print("Durum: Geçti\n");
		else
			System.out.print("Durum: Kaldı\n");

		System.out.print("Harf Notu: " + letter + "\n");

		if (honor)
			System.out.print("Onur Listesi: Evet\n");
		else
			System.out.print("Onur Listesi: Hayır\n");

		if (retake)
			System.out.print("Bütünleme Hakkı: Var\n");
		else
			System.out.print("Bütünleme Hakkı: Yok\n");

		inputScanner.close();

	}

}
