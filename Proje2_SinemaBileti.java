/*
 * Ad Soyad: Ebubekir Yılmaz
 * Öğrenci No: 250541051
 * Tarih: 18.11.2025
 * Açıklama: Sinema Bileti Fiyatlandırma
 * Bu program izeyiciden gün, saat, yaş, meslek
 * ve izleyeceği film türü bilgilerini alır.
 * Duruma göre temel fiyatlandırmayı yapıp
 * varsa indirim uygular ve ekstra ücret ekler.
 * tüm hesaplamaların sonunda bilete ait bilgileri ekrana yazdırır.
 */

import java.util.Scanner;

public class SinemaBileti {
	// sabitler
	final static double HAFTAICI_MATINE = 45;
	final static double HAFTAICI_NORMAL = 65;
	final static double HAFTASONU_MATINE = 55;
	final static double HAFTASONU_NORMAL = 85;

	// hafta sonu kontrolü
	public static boolean isWeekend(int gun) {
		return gun == 6 || gun == 7;
	}

	// saat kontrolü
	public static boolean isMatinee(int saat) {
		return saat < 12;
	}

	// temel fiyatlandırma
	public static double calculateBasePrice(int gun, int saat) {
		if (isWeekend(gun)) {
			if (isMatinee(saat)) {
				return HAFTASONU_MATINE;
			} else {
				return HAFTAICI_NORMAL;
			}
		} else {
			if (isMatinee(saat)) {
				return HAFTAICI_MATINE;
			} else {
				return HAFTAICI_NORMAL;
			}
		}
	}

	// indirim oranı
	public static double calculateDiscount(int yas, int meslek, int gun) {
		double indirim = 0;

		// yaşa göre indirim
		if (yas >= 65) {
			indirim = Math.max(indirim, 0.30);
		} else if (yas < 12) {
			indirim = Math.max(indirim, 0.25);
		}

		// meseleğe göre indirim
		switch (meslek) {
		case 1:
			if (isWeekend(gun)) {
				indirim = Math.max(indirim, 0.15);
			} else {
				indirim = Math.max(indirim, 0.20);
			}
			break;
		case 2:
			if (gun == 3) {
				indirim = Math.max(indirim, 0.35);
			}
			break;
		case 3:
		default:
			break;
		}
		return indirim;

	}

	// ekstara ücret
	public static double getFormatExtra(int tur) {
		switch (tur) {
		case 2:
			return 25;
		case 3:
			return 35;
		case 4:
			return 50;
		case 1:
		default:
			return 0;
		}
	}

	// son fiyat hesaplama
	public static double calculateFinalPrice(double temelFiyat, double indirimOrani, double ekstra) {
		double indirimTutari = temelFiyat * indirimOrani;
		double indirimliFiyat = temelFiyat - indirimTutari;
		return indirimliFiyat + ekstra;
	}
	
	
	// ekrana yazdırma
		public static void generateTicketInfo(double temelFiyat, double indirimOrani, double ekstra, double sonFiyat) {
			System.out.print("\n---Bilet Bilgisi---\n");
			System.out.printf("Temel Fiyat: %.2f TL\n", temelFiyat);

			double indirimTutari = temelFiyat * indirimOrani;
			System.out.printf("Uygulanan İndirim Oranı: %.0f%%\n", indirimOrani * 100);
			System.out.printf("İndirim Tutarı: -%.2f TL\n", indirimTutari);

			double indirimliFiyat = temelFiyat - indirimTutari;
			System.out.printf("İndirimli Fiyat: %.2f TL\n", indirimliFiyat);

			System.out.printf("Ekstra Ücret: +%.2f TL\n", ekstra);

			System.out.printf("Son Bilet Fiyatı: %.2f TL\n", sonFiyat);
		}

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("---Sinema Bileti Fiyatlandırma Sistemi---\n");
		
		// girdiler
		System.out.print("Gün (1=Pazartesi, 2=Salı, 3=Çarşamba,"
				+ "4=Perşembe, 5=Cuma, 6=Cumartesi, 7=Pazar): ");
		int gun = inputScanner.nextInt();
		
		System.out.print("Saat (8-23): ");
		int saat = inputScanner.nextInt();
		
		System.out.print("Yaş: ");
		int yas = inputScanner.nextInt();
		
		System.out.print("Meslek (1=Öğrenci, 2=Yaşlı, 3=Diğer): ");
		int meslek = inputScanner.nextInt();
		
		System.out.print("Film Türü (1=2D, 2=3D, 3=IMAX, 4=DX): ");
		int tur = inputScanner.nextInt();
		
		// hesaplamalar
		double temelFiyat = calculateBasePrice(gun, saat);
		double indirimOrani = calculateDiscount(yas, meslek, gun);
		double ekstra = getFormatExtra(tur);
		
		double sonFiyat = calculateFinalPrice(temelFiyat, indirimOrani, ekstra);
		
		// çıktı
		generateTicketInfo(temelFiyat, indirimOrani, ekstra, sonFiyat);
		
		inputScanner.close();
		
		
		

	}

}
