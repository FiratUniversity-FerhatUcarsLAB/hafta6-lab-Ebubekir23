/*
 * Ad Soyad: Ebubekir Yılmaz
 * Öğrenci No: 250541051
 * Tarih: 20.11.2025
 * Açıklama: Sinema Bileti Fiyatlandırma
 * Bu program müşteriden yemek, içecek, ve tatlı siparişlerini alır.
 * Her kategoride seçilen ürünün fiyatını hesaplar.
 * Ara toplam, KDV ve genel toplamı da hesaplayıp ekrana yazdırır.
 */

import java.util.Scanner;

public class RestoranSiparis {
	// ana yemek fiyatları
	public static double yemekFiyati(int yemek, int adet) {
		double fiyat = 0;

		switch (yemek) {
		case 1:
			fiyat = 85;
			break;
		case 2:
			fiyat = 120;
			break;
		case 3:
			fiyat = 110;
			break;
		case 4:
			fiyat = 65;
			break;
		default:
			System.out.print("Hatalı Yemek Seçimi!\n");

		}

		return fiyat * adet;
	}

	// başlangıç fiyatları
	public static double baslangicFiyati(int baslangic, int adet) {
		double fiyat = 0;

		switch (baslangic) {
		case 1:
			fiyat = 25;
			break;
		case 2:
			fiyat = 45;
			break;
		case 3:
			fiyat = 55;
			break;
		default:
			System.out.print("Hatalı Başlangıç Seçimi!\n");
		}

		return fiyat * adet;
	}

	// içecek fiyatları
	public static double icecekFiyati(int icecek, int adet) {
		double fiyat = 0;

		switch (icecek) {
		case 1:
			fiyat = 15;
			break;
		case 2:
			fiyat = 12;
			break;
		case 3:
			fiyat = 35;
			break;
		case 4:
			fiyat = 25;
			break;
		default:
			System.out.print("Hatalı İçecek Seçimi!\n");
		}

		return fiyat * adet;
	}

	// tatlı fiyatları
	public static double tatliFiyati(int tatli, int adet) {
		double fiyat = 0;

		switch (tatli) {
		case 1:
			fiyat = 65;
			break;
		case 2:
			fiyat = 55;
			break;
		case 3:
			fiyat = 35;
			break;
		default:
			System.out.print("Hatalı Tatlı Seçimi!\n");
		}

		return fiyat * adet;
	}

	// ara toplam
	public static double araToplam(double yemek, double baslangic, double icecek, double tatli) {
		return yemek + baslangic + icecek + tatli;
	}

	// kdv hesaplama
	public static double kdvHesaplama(double araToplam) {
		return araToplam * 0.10;
	}

	// genel toplam
	public static double genelToplam(double araToplam, double kdv) {
		return araToplam + kdv;
	}

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);

		System.out.print("----- Restoran Sipariş Sistemi -----\n\n");

		// yemek
		System.out.print("Yemek Seçenekleri:\n");
		System.out.print("1: Izgara Tavuk - 85 TL\n");
		System.out.print("2: Adana Kebap - 120 TL\n");
		System.out.print("3: Levrek - 110 TL\n");
		System.out.print("4: Mantı - 65 TL\n\n");

		System.out.print("Yemek Seçimi: ");
		int yemekSecim = inputScanner.nextInt();

		System.out.print("Yemek Adeti: ");
		int yemekAdet = inputScanner.nextInt();

		double yemekToplam = yemekFiyati(yemekSecim, yemekAdet);
		System.out.printf("Toplam Yemek Fiyatı: %.2f TL\n\n", yemekToplam);

		// başlangıç
		System.out.print("Başlangıç Seçenekleri:\n");
		System.out.print("1: Çorba - 25 TL\n");
		System.out.print("2: Humus - 45 TL\n");
		System.out.print("3: Sigara Böreği - 55 TL\n\n");

		System.out.print("Başlangıç Seçimi: ");
		int baslangicSecim = inputScanner.nextInt();

		System.out.print("Başlangıç Adeti: ");
		int baslangicAdet = inputScanner.nextInt();

		double baslangicToplam = baslangicFiyati(baslangicSecim, baslangicAdet);
		System.out.printf("Toplam Başlangıç Fiyatı: %.2f TL\n\n", baslangicToplam);

		// içecek
		System.out.print("İçecek Seçenekleri:\n");
		System.out.print("1: Kola - 15 TL\n");
		System.out.print("2: Ayran - 12 TL\n");
		System.out.print("3: Taze Meyve Suyu - 35 TL\n");
		System.out.print("4: Limonata - 25 TL\n\n");

		System.out.print("İçecek Seçimi: ");
		int icecekSecim = inputScanner.nextInt();

		System.out.print("İçecek Adeti: ");
		int icecekAdet = inputScanner.nextInt();

		double icecekToplam = icecekFiyati(icecekSecim, icecekAdet);
		System.out.printf("Toplam İçecek Fiyatı: %.2f TL\n\n", icecekToplam);

		// tatlı
		System.out.print("Tatlı Seçenekleri:\n");
		System.out.print("1: Künefe - 65 TL\n");
		System.out.print("2: Baklava - 55 TL\n");
		System.out.print("3: Sütlaç - 35 TL\n\n");

		System.out.print("Tatlı Seçimi: ");
		int tatliSecim = inputScanner.nextInt();

		System.out.print("Tatlı Adeti: ");
		int tatliAdet = inputScanner.nextInt();

		double tatliToplam = tatliFiyati(tatliSecim, tatliAdet);
		System.out.printf("Toplam Tatlı Fiyatı: %.2f TL\n\n", tatliToplam);

		// hesaplamalar
		double ara = araToplam(yemekToplam, baslangicToplam, icecekToplam, tatliToplam);
		double kdv = kdvHesaplama(ara);
		double genel = genelToplam(ara, kdv);

		// ekrana yazdırma
		System.out.print("----- Hesap Özeti -----\n");
		System.out.printf("Ara Toplam: %.2f TL\n", ara);
		System.out.printf("KDV (%%10): %.2f TL\n", kdv);
		System.out.printf("Genel Toplam: %.2f TL\n", genel);

		inputScanner.close();

	}

}
