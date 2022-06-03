package de.freshminds.backend;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import de.freshminds.entities.Article;
import de.freshminds.entities.Category;
import de.freshminds.entities.Stock;
import de.freshminds.main.Core;

public class DatabaseMethods {
	
	public static void fillArticlesTable() {
	
		List<Article> articles = new ArrayList<Article>();
		
		articles.add(new Article(1001, "Roggenmischbrot", 1.80, "GER", 1));
		articles.add(new Article(1002, "Bauernbrot", 1.67, "GER", 1));
		articles.add(new Article(1003, "Glutenfreies Landbrot", 1.77, "GER", 1));
		articles.add(new Article(1004, "Dinkelbrot", 1.63, "GER", 1));
		articles.add(new Article(1005, "Weizenmischbrot", 1.99, "POL", 1));
		articles.add(new Article(1006, "Vollkornbrot", 2.10, "GER", 1));
		articles.add(new Article(1007, "Rosinenbrot", 1.41, "POL", 1));
		articles.add(new Article(1008, "Kasten-Wei�brot", 2.07, "GER", 1));
		articles.add(new Article(1009, "Wei�brot", 2.15, "GER", 1));
		articles.add(new Article(1010, "Toastbrot", 1.92, "GER", 1));
		articles.add(new Article(2001, "Br�tchen", 0.15, "GER", 2));
		articles.add(new Article(2002, "Doppelbr�tchen", 0.21, "GER", 2));
		articles.add(new Article(2003, "Vollkornbr�tchen", 0.22, "GER", 2));	
		articles.add(new Article(2004, "Rosinenbr�tchen", 0.26, "POL", 2));
		articles.add(new Article(2005, "Schusterjunge", 0.19, "GER", 2));
		articles.add(new Article(2006, "Laugenbr�tchen", 0.31, "GER", 2));
		articles.add(new Article(2007, "Milchbr�tchen", 0.21, "POL", 2));
		articles.add(new Article(2008, "Weltmeisterbr�tchen", 0.29, "GER", 2));
		articles.add(new Article(2009, "Laugenecke", 0.34, "GER", 2));
		articles.add(new Article(3001, "Apfelkuchen", 2.21, "GER", 3));
		articles.add(new Article(3002, "K�sekuchen", 2.01, "GER", 3));
		articles.add(new Article(3003, "Karottenkuchen", 1.81, "GER", 3));
		articles.add(new Article(3004, "Pflaumenkuchen", 1.99, "GER", 3));
		articles.add(new Article(3005, "Zuckerkuchen", 1.21, "GER", 3));
		articles.add(new Article(4001, "Kirschplunder", 1.76, "GER", 4));
		articles.add(new Article(4002, "Puddingschnecke", 1.65, "GER", 4));
		articles.add(new Article(4003, "Buttercroissant", 0.25, "GER", 4));
		articles.add(new Article(4004, "Schokocroissant", 0.34, "GER", 4));
		articles.add(new Article(4005, "Franzbr�tchen", 1.21, "GER", 4));
		articles.add(new Article(4006, "Quarktasche", 1.34, "GER", 4));
		articles.add(new Article(4007, "Nussh�rnchen", 1.24, "GER", 4));
		articles.add(new Article(4008, "Vanilleplunder", 1.46, "GER", 4));
		articles.add(new Article(5001, "Rinderhack", 3.35, "GER", 5));
		articles.add(new Article(5002, "Rindergulasch", 5.30, "GER", 5));
		articles.add(new Article(5003, "Rinderh�ftsteaks", 6.40, "GER", 5));
		articles.add(new Article(5004, "Entrecote", 15.90, "FRA", 5));
		articles.add(new Article(5005, "Rinderwurst", 4.50, "GER", 5));
		articles.add(new Article(5006, "Roastbeef", 14.20, "GER", 5));
		articles.add(new Article(5007, "Rindersalami", 3.50, "GER", 5));
		articles.add(new Article(5008, "Ungarische Salami", 5.10, "HUN", 5));
		articles.add(new Article(6001, "H�hnchenbrust geschnitten", 2.31, "GER", 6));
		articles.add(new Article(6002, "H�hnchenbrustfilet", 4.50, "GER", 6));
		articles.add(new Article(6003, "H�hnchenfl�gel", 2.39, "GER", 6));
		articles.add(new Article(6004, "H�hnchen Unterschenkel", 3.40, "GER", 6));
		articles.add(new Article(6005, "H�hnchenkeule", 6.45, "GER", 6));
		articles.add(new Article(7001, "Bratwurst", 2.99, "GER", 7));
		articles.add(new Article(7002, "Parmaschinken", 4.05, "ITA", 7));
		articles.add(new Article(7003, "Minutensteaks", 3.30, "GER", 7));
		articles.add(new Article(7004, "Wienerw�rstchen", 2.50, "GER", 7));
		articles.add(new Article(7005, "Bauernschinken", 3.60, "GER", 7));
		articles.add(new Article(7006, "Schnitzel", 5.00, "GER", 7));
		articles.add(new Article(7007, "Nackensteaks", 4.40, "GER", 7));
		articles.add(new Article(7008, "Bauchspeck", 3.80, "GER", 7));
		articles.add(new Article(7009, "Schweinegeschnetzeltes", 4.60, "GER", 7));
		articles.add(new Article(7010, "Schweinehack", 3.60, "GER", 7));
		articles.add(new Article(8001, "Putenbrust roh", 4.90, "GER", 8));
		articles.add(new Article(8002, "Putengeschnetzeltes", 4.40, "GER", 8));
		articles.add(new Article(8003, "Putenschnitzel", 4.99, "GER", 8));
		articles.add(new Article(8004, "Putenbrust geschnitten", 3.10, "GER", 8));
		articles.add(new Article(9001, "Lachs roh", 6.50, "NOR", 9));
		articles.add(new Article(9002, "Seelachs", 5.00, "USA", 9));
		articles.add(new Article(9003, "Forelle", 5.50, "GER", 9));
		articles.add(new Article(9004, "Graved Lachs", 4.50, "NOR", 9));
		articles.add(new Article(9005, "Zander", 6.40, "GER", 9));
		articles.add(new Article(9006, "gebratener Hering", 3.50, "SWE", 9));
		articles.add(new Article(9007, "Bismarckheringe", 3.44, "SWE", 9));
		articles.add(new Article(9008, "Sprotten", 3.00, "SWE", 9));
		articles.add(new Article(10001, "fettarme H-Milch", 1.20, "GER", 10));
		articles.add(new Article(10002, "Bio H-Milch", 1.60, "GER", 10));
		articles.add(new Article(10003, "Frische Weidemilch", 2.10, "GER", 10));
		articles.add(new Article(10004, "Laktosefreie H-Milch", 1.50, "GER", 10));
		articles.add(new Article(11001, "Butter", 1.50, "GER", 11));
		articles.add(new Article(11002, "Bio Weidebutter", 2.30, "GER", 11));
		articles.add(new Article(11003, "Irische Weidebutter", 2.10, "IRL", 11));
		articles.add(new Article(11004, "Kr�uterbutter", 2.00, "GER", 11));
		articles.add(new Article(11005, "Gesalzene Butter", 1.80, "GER", 11));
		articles.add(new Article(12001, "Margarine", 1.40, "GER", 12));
		articles.add(new Article(12002, "Bio Margarine", 1.70, "GER", 12));
		articles.add(new Article(13001, "Edamer K�se", 2.00, "CHE", 13));
		articles.add(new Article(13002, "Gouda K�se", 2.10, "NED", 13));
		articles.add(new Article(13003, "Heumilchk�se", 2.20, "GER", 13));
		articles.add(new Article(13004, "Mozzarella", 1.99, "ITA", 13));
		articles.add(new Article(13005, "Grana Padano Parmesan K�se", 3.50, "ITA", 13));
		articles.add(new Article(13006, "Fetak�se", 1.99, "GRE", 13));
		articles.add(new Article(13007, "Schafsk�se", 1.99, "GER", 13));
		articles.add(new Article(13008, "Mozzarella Streuk�se", 1.80, "ITA", 13));
		articles.add(new Article(13009, "Edamer Streuk�se", 1.70, "CHE", 13));
		articles.add(new Article(13010, "Tilsiter", 2.30, "NED", 13));
		articles.add(new Article(13011, "Frischk�se Natur", 2.50, "GER", 13));
		articles.add(new Article(13012, "Frischk�se Kr�uter", 2.60, "GER", 13));
		articles.add(new Article(13013, "Ofenk�se", 3.90, "GER", 13));
		articles.add(new Article(14001, "Naturjoghurt", 1.40, "GER", 14));
		articles.add(new Article(14002, "Bio Naturjoghurt", 1.80, "GER", 14));
		articles.add(new Article(14003, "Erdbeerjoghurt", 1.50, "GER", 14));
		articles.add(new Article(14004, "Heidelbeerjoghurt", 1.55, "GER", 14));
		articles.add(new Article(14005, "Kefir", 2.10, "TUR", 14));
		articles.add(new Article(15001, "Gala �pfel 1kg", 1.99, "GER", 15));
		articles.add(new Article(15002, "Boskop �pfel 1kg", 2.50, "NLD", 15));
		articles.add(new Article(15003, "Chiquita Bananen 1kg", 2.39, "PAN", 15));
		articles.add(new Article(15004, "Mangos 1kg", 2.49, "BRA", 15));
		articles.add(new Article(15005, "Orangen 1kg", 1.99, "SPA", 15));
		articles.add(new Article(15006, "Kirschen 1kg", 2.19, "GER", 15));
		articles.add(new Article(15007, "Birnen 1kg", 1.99, "GER", 15));
		articles.add(new Article(15008, "Heidelbeeren 1kg", 4.99, "GER", 15));
		articles.add(new Article(15009, "Erdbeeren", 3.99, "GER", 15));
		articles.add(new Article(15010, "Aprikosen 1kg", 2.89, "GER", 15));
		articles.add(new Article(16001, "Lauchzwiebeln 1kg", 1.99, "GER", 16));
		articles.add(new Article(16002, "Champignons 1kg", 1.49, "NLD", 16));
		articles.add(new Article(16003, "Brokkoli 1kg", 0.89, "PAN", 16));
		articles.add(new Article(16004, "Cherrytomaten 1kg", 1.19, "GER", 16));
		articles.add(new Article(16005, "Fleischtomaten 1kg", 2.39, "GER", 16));
		articles.add(new Article(16006, "Rote Paprika 1kg", 0.89, "GER", 16));
		articles.add(new Article(16007, "Paprikamix 1kg", 1.09, "GER", 16));
		articles.add(new Article(16008, "Bio Karotten 1kg", 4.99, "GER", 16));
		articles.add(new Article(16009, "Eisbergsalat", 0.99, "GER", 16));
		articles.add(new Article(16010, "Gurken 1kg", 1.99, "GER", 16));
		articles.add(new Article(17001, "Pfeffer", 0.59, "CHI", 17));
		articles.add(new Article(17002, "Salz", 0.89, "GER", 17));
		articles.add(new Article(17003, "Curry", 1.09, "IND", 17));
		articles.add(new Article(17004, "K�mmel", 0.99, "GER", 17));
		articles.add(new Article(17005, "Kreuzk�mmel", 1.09, "GER", 17));
		articles.add(new Article(17006, "Kr�uter der Provence", 0.89, "FRA", 17));
		articles.add(new Article(17007, "Zitronengras", 1.39, "CHI", 17));
		articles.add(new Article(17008, "Kardamon", 0.89, "IND", 17));
		articles.add(new Article(17009, "Koriander", 0.99, "GER", 17));
		articles.add(new Article(17010, "Rosmarin", 0.89, "GER", 17));
		articles.add(new Article(18001, "Granini Banane lL", 1.69, "GER", 18));
		articles.add(new Article(18002, "Granini Birne 1L", 1.69, "GER", 18));
		articles.add(new Article(18003, "Granini Mango 1L", 1.69, "GER", 18));
		articles.add(new Article(18004, "Granini Orange 1L", 1.69, "GER", 18));
		articles.add(new Article(18005, "Punica Multivitamin 1L", 1.19, "GER", 18));
		articles.add(new Article(18006, "Punica Pink Banana 1L", 1.29, "GER", 18));
		articles.add(new Article(18007, "Punica Crazy Cherry 1L", 1.49, "GER", 18));
		articles.add(new Article(18008, "Albi Johannisbeere 1L", 1.69, "GER", 18));
		articles.add(new Article(18009, "Albi Granatapfel 1L", 1.78, "GER", 18));
		articles.add(new Article(18010, "Albi Holunderbeere", 1.59, "GER", 18));
		articles.add(new Article(19001, "Coca Cola lL", 1.69, "GER", 19));
		articles.add(new Article(19002, "Coca Cola Zero 1L", 1.69, "GER", 19));
		articles.add(new Article(19003, "Coca Cola Light 1L", 1.69, "GER", 19));
		articles.add(new Article(19004, "Fanta 1L", 1.69, "GER", 19));
		articles.add(new Article(19005, "Sprite 1L", 1.19, "GER", 19));
		articles.add(new Article(19006, "Pepsi 1L", 1.29, "GER", 19));
		articles.add(new Article(19007, "Mirinda 1L", 1.49, "USA", 19));
		articles.add(new Article(19008, "Mountain Dew 0.33L", 0.89, "USA", 19));
		articles.add(new Article(19009, "Afri-Cola 1L", 1.78, "GER", 19));
		articles.add(new Article(19010, "7Up", 1.59, "USA", 19));
		articles.add(new Article(20001, "Gut und G�nsig Still lL", 0.19, "GER", 20));
		articles.add(new Article(20002, "Gut und G�nsig Medium 1L", 0.25, "GER", 20));
		articles.add(new Article(20003, "Gut und G�nsig Sprudel 1L", 0.29, "GER", 20));
		articles.add(new Article(20004, "Volvic Still 1L", 0.45, "GER", 20));
		articles.add(new Article(20005, "Volvic Medium 1L", 0.49, "GER", 20));
		articles.add(new Article(20006, "Volvic Sprudel 1L", 0.52, "GER", 20));
		articles.add(new Article(20007, "Aquarius 1L", 1.49, "USA", 20));
		articles.add(new Article(20008, "Vittel 1L", 0.39, "GER", 20));
		articles.add(new Article(20009, "Fiji 0,33L", 1.39, "GER", 20));
		articles.add(new Article(20010, "Gerolsteiner 1L", 0.39, "GER", 20));
		articles.add(new Article(21001, "Beck`s 0,33L", 0.25, "GER", 21));
		articles.add(new Article(21002, "Astra 0,33L", 0.25, "GER", 21));
		articles.add(new Article(21003, "Sternburger 0,33L", 0.29, "GER", 21));
		articles.add(new Article(21004, "Jever Pilsener 0,33L", 0.25, "GER", 21));
		articles.add(new Article(21005, "Berliner Pilsener 0,33L", 0.21, "GER", 21));
		articles.add(new Article(21006, "Berliner Kindl 0,33L", 0.29, "GER", 21));
		articles.add(new Article(21007, "Vodka Belaja Berjoska 1L", 39.49, "RUS", 21));
		articles.add(new Article(21008, "Captain Morgan 1L", 8.99, "GER", 21));
		articles.add(new Article(21009, "Vodka Gorbatschow 1L", 6.99, "GER", 21));
		articles.add(new Article(21010, "Vodka Pushkin 1L", 5.99, "GER", 21));
		articles.add(new Article(22001, "True Fruits Pink 0,5L", 2.99, "GER", 22));
		articles.add(new Article(22002, "True Fruits Orange 0,5L", 2.99, "GER", 22));
		articles.add(new Article(22003, "True Fruits Yellow 0,5L", 2.99, "GER", 22));
		articles.add(new Article(22004, "True Fruits creamie 0,5L", 2.99, "GER", 22));
		articles.add(new Article(22005, "Innocent Mango 0,5L", 3.29, "GER", 22));
		articles.add(new Article(22006, "Innocent Maracuja 0,5L", 3.29, "GER", 22));
		articles.add(new Article(22007, "Innocent Tropical 0,5L", 3.29, "GER", 22));
		articles.add(new Article(22008, "Innocent Erdbeere 0,5L", 3.29, "GER", 22));
		articles.add(new Article(22009, "Innocent Banane 0,5L", 3.29, "GER", 22));
		articles.add(new Article(22010, "Innocent Kirsche 0,5L", 3.29, "GER", 22));
		articles.add(new Article(23001, "Wagner Steinofenpizza", 2.99, "GER", 23));
		articles.add(new Article(23002, "Wagner Pizza Funghi", 2.99, "GER", 23));
		articles.add(new Article(23003, "Wagner Pizza Margharita", 2.99, "GER", 23));
		articles.add(new Article(23004, "Wagner Piccolinis", 2.99, "GER", 23));
		articles.add(new Article(23005, "Wagner Big City Pizza", 3.29, "GER", 23));
		articles.add(new Article(23006, "Gut und G�nstig Chicken Wings", 1.49, "GER", 23));
		articles.add(new Article(23007, "Frosta Reispfanne", 2.99, "GER", 23));
		articles.add(new Article(23008, "Gyros", 2.19, "GER", 23));
		articles.add(new Article(23009, "Iglo Schlemmerfilet Sylter Art", 1.89, "GER", 23));
		articles.add(new Article(23010, "Iglo Backfischst�bchen", 1.49, "GER", 23));
		articles.add(new Article(24001, "Kellog`s Smacks", 2.99, "GER", 24));
		articles.add(new Article(24002, "Kellog`s Frosties", 2.99, "GER", 24));
		articles.add(new Article(24003, "Kellog`s Crunchy Nut", 2.99, "GER", 24));
		articles.add(new Article(24004, "Kellog`s Choco Krispies", 2.99, "GER", 24));
		articles.add(new Article(24005, "Cheerios", 1.49, "USA", 24));
		articles.add(new Article(24006, "Nesquik Knusperfr�hst�ck", 1.49, "GER", 24));
		articles.add(new Article(24007, "Nesquik Duo", 2.99, "GER", 24));
		articles.add(new Article(24008, "Nestle Cookie Crips", 2.19, "GER", 24));
		articles.add(new Article(24009, "Fruit Loops", 1.89, "USA", 24));
		articles.add(new Article(24010, "K�lln Schokom�sli", 3.49, "GER", 24));
		articles.add(new Article(25001, "Dr. Oetker Browniemischung", 4.99, "GER", 25));
		articles.add(new Article(25002, "Dr. Oetker Cupcakemischung", 3.99, "GER", 25));
		articles.add(new Article(25003, "Dr. Oetker Zupfkuchenmischung", 3.99, "GER", 25));
		articles.add(new Article(25004, "Vanilleextrakt", 1.99, "GER", 25));
		articles.add(new Article(25005, "Tortenkerzen", 1.49, "GER", 25));
		articles.add(new Article(25006, "Dr. Oetker Muffinsmischung", 2.49, "GER", 25));
		articles.add(new Article(25007, "Dr. Oetker K�sekuchenmischung", 3.99, "GER", 25));
		articles.add(new Article(25008, "Pl�tzchenformen", 1.19, "GER", 25));
		articles.add(new Article(25009, "Dr. Oetker Maulwurfkuchen", 3.89, "GER", 25));
		articles.add(new Article(25010, "Dr. Oetker Wolke", 3.49, "GER", 25));
		
		Session freshMindsSession = Core.articlesSessionFactory.openSession();
		freshMindsSession.beginTransaction();
		
		for(Article article : articles)  {
			freshMindsSession.saveOrUpdate(article);
		}
		freshMindsSession.getTransaction().commit();
		freshMindsSession.close();
	}
	
	public static void fillStockTable() {
		
		List<Stock> stock = new ArrayList<Stock>();
		
		stock.add(new Stock(1001, 500));
		stock.add(new Stock(1002, 500));
		stock.add(new Stock(1003, 500));
		stock.add(new Stock(1004, 500));
		stock.add(new Stock(1005, 500));
		stock.add(new Stock(1006, 500));
		stock.add(new Stock(1007, 500));
		stock.add(new Stock(1008, 500));
		stock.add(new Stock(1009, 500));
		stock.add(new Stock(1010, 500));
		stock.add(new Stock(2001, 500));
		stock.add(new Stock(2002, 500));
		stock.add(new Stock(2003, 500));
		
		stock.add(new Stock(2004, 500));
		stock.add(new Stock(2005, 500));
		stock.add(new Stock(2006, 500));
		stock.add(new Stock(2007, 500));
		stock.add(new Stock(2008, 500));
		stock.add(new Stock(2009, 500));
		stock.add(new Stock(3001, 500));
		stock.add(new Stock(3002, 500));
		stock.add(new Stock(3003, 500));
		stock.add(new Stock(3004, 500));
		stock.add(new Stock(3005, 500));
		stock.add(new Stock(4001, 500));
		stock.add(new Stock(4002, 500));
		stock.add(new Stock(4003, 500));
		stock.add(new Stock(4004, 500));
		stock.add(new Stock(4005, 500));
		stock.add(new Stock(4006, 500));
		stock.add(new Stock(4007, 500));
		stock.add(new Stock(4008, 500));
		stock.add(new Stock(5001, 500));
		stock.add(new Stock(5002, 500));
		stock.add(new Stock(5003, 500));
		stock.add(new Stock(5004, 500));
		stock.add(new Stock(5005, 500));
		stock.add(new Stock(5006, 500));
		stock.add(new Stock(5007, 500));
		stock.add(new Stock(5008, 500));
		stock.add(new Stock(6001, 500));
		stock.add(new Stock(6002, 500));
		stock.add(new Stock(6003, 500));
		stock.add(new Stock(6004, 500));
		stock.add(new Stock(6005, 500));
		stock.add(new Stock(7001, 500));
		stock.add(new Stock(7002, 500));
		stock.add(new Stock(7003, 500));
		stock.add(new Stock(7004, 500));
		stock.add(new Stock(7005, 500));
		stock.add(new Stock(7006, 500));
		stock.add(new Stock(7007, 500));
		stock.add(new Stock(7008, 500));
		stock.add(new Stock(7009, 500));
		stock.add(new Stock(7010, 500));
		stock.add(new Stock(8001, 500));
		stock.add(new Stock(8002, 500));
		stock.add(new Stock(8003, 500));
		stock.add(new Stock(8004, 500));
		stock.add(new Stock(9001, 500));
		stock.add(new Stock(9002, 500));
		stock.add(new Stock(9003, 500));
		stock.add(new Stock(9004, 500));
		stock.add(new Stock(9005, 500));
		stock.add(new Stock(9006, 500));
		stock.add(new Stock(9007, 500));
		stock.add(new Stock(9008, 500));
		stock.add(new Stock(10001, 500));
		stock.add(new Stock(10002, 500));
		stock.add(new Stock(10003, 500));
		stock.add(new Stock(10004, 500));
		stock.add(new Stock(11001, 500));
		stock.add(new Stock(11002, 500));
		stock.add(new Stock(11003, 500));
		stock.add(new Stock(11004, 500));
		stock.add(new Stock(11005, 500));
		stock.add(new Stock(12001, 500));
		stock.add(new Stock(12002, 500));
		stock.add(new Stock(13001, 500));
		stock.add(new Stock(13002, 500));
		stock.add(new Stock(13003, 500));
		stock.add(new Stock(13004, 500));
		stock.add(new Stock(13005, 500));
		stock.add(new Stock(13006, 500));
		stock.add(new Stock(13007, 500));
		stock.add(new Stock(13008, 500));
		stock.add(new Stock(13009, 500));
		stock.add(new Stock(13010, 500));
		stock.add(new Stock(13011, 500));
		stock.add(new Stock(13012, 500));
		stock.add(new Stock(13013, 500));
		stock.add(new Stock(14001, 500));
		stock.add(new Stock(14002, 500));
		stock.add(new Stock(14003, 500));
		stock.add(new Stock(14004, 500));
		stock.add(new Stock(14005, 500));
		stock.add(new Stock(15001, 500));
		stock.add(new Stock(15002, 500));
		stock.add(new Stock(15003, 500));
		stock.add(new Stock(15004, 500));
		stock.add(new Stock(15005, 500));
		stock.add(new Stock(15006, 500));
		stock.add(new Stock(15007, 500));
		stock.add(new Stock(15008, 500));
		stock.add(new Stock(15009, 500));
		stock.add(new Stock(15010, 500));
		stock.add(new Stock(16001, 500));
		stock.add(new Stock(16002, 500));
		stock.add(new Stock(16003, 500));
		stock.add(new Stock(16004, 500));
		stock.add(new Stock(16005, 500));
		stock.add(new Stock(16006, 500));
		stock.add(new Stock(16007, 500));
		stock.add(new Stock(16008, 500));
		stock.add(new Stock(16009, 500));
		stock.add(new Stock(16010, 500));
		stock.add(new Stock(17001, 500));
		stock.add(new Stock(17002, 500));
		stock.add(new Stock(17003, 500));
		stock.add(new Stock(17004, 500));
		stock.add(new Stock(17005, 500));
		stock.add(new Stock(17006, 500));
		stock.add(new Stock(17007, 500));
		stock.add(new Stock(17008, 500));
		stock.add(new Stock(17009, 500));
		stock.add(new Stock(17010, 500));
		stock.add(new Stock(18001, 500));
		stock.add(new Stock(18002, 500));
		stock.add(new Stock(18003, 500));
		stock.add(new Stock(18004, 500));
		stock.add(new Stock(18005, 500));
		stock.add(new Stock(18006, 500));
		stock.add(new Stock(18007, 500));
		stock.add(new Stock(18008, 500));
		stock.add(new Stock(18009, 500));
		stock.add(new Stock(18010, 500));
		stock.add(new Stock(19001, 500));
		stock.add(new Stock(19002, 500));
		stock.add(new Stock(19003, 500));
		stock.add(new Stock(19004, 500));
		stock.add(new Stock(19005, 500));
		stock.add(new Stock(19006, 500));
		stock.add(new Stock(19007, 500));
		stock.add(new Stock(19008, 500));
		stock.add(new Stock(19009, 500));
		stock.add(new Stock(19010, 500));
		stock.add(new Stock(20001, 500));
		stock.add(new Stock(20002, 500));
		stock.add(new Stock(20003, 500));
		stock.add(new Stock(20004, 500));
		stock.add(new Stock(20005, 500));
		stock.add(new Stock(20006, 500));
		stock.add(new Stock(20007, 500));
		stock.add(new Stock(20008, 500));
		stock.add(new Stock(20009, 500));
		stock.add(new Stock(20010, 500));
		stock.add(new Stock(21001, 500));
		stock.add(new Stock(21002, 500));
		stock.add(new Stock(21003, 500));
		stock.add(new Stock(21004, 500));
		stock.add(new Stock(21005, 500));
		stock.add(new Stock(21006, 500));
		stock.add(new Stock(21007, 500));
		stock.add(new Stock(21008, 500));
		stock.add(new Stock(21009, 500));
		stock.add(new Stock(21010, 500));
		stock.add(new Stock(22001, 500));
		stock.add(new Stock(22002, 500));
		stock.add(new Stock(22003, 500));
		stock.add(new Stock(22004, 500));
		stock.add(new Stock(22005, 500));
		stock.add(new Stock(22006, 500));
		stock.add(new Stock(22007, 500));
		stock.add(new Stock(22008, 500));
		stock.add(new Stock(22009, 500));
		stock.add(new Stock(22010, 500));
		stock.add(new Stock(23001, 500));
		stock.add(new Stock(23002, 500));
		stock.add(new Stock(23003, 500));
		stock.add(new Stock(23004, 500));
		stock.add(new Stock(23005, 500));
		stock.add(new Stock(23006, 500));
		stock.add(new Stock(23007, 500));
		stock.add(new Stock(23008, 500));
		stock.add(new Stock(23009, 500));
		stock.add(new Stock(23010, 500));
		stock.add(new Stock(24001, 500));
		stock.add(new Stock(24002, 500));
		stock.add(new Stock(24003, 500));
		stock.add(new Stock(24004, 500));
		stock.add(new Stock(24005, 500));
		stock.add(new Stock(24006, 500));
		stock.add(new Stock(24007, 500));
		stock.add(new Stock(24008, 500));
		stock.add(new Stock(24009, 500));
		stock.add(new Stock(24010, 500));
		stock.add(new Stock(25001, 500));
		stock.add(new Stock(25002, 500));
		stock.add(new Stock(25003, 500));
		stock.add(new Stock(25004, 500));
		stock.add(new Stock(25005, 500));
		stock.add(new Stock(25006, 500));
		stock.add(new Stock(25007, 500));
		stock.add(new Stock(25008, 500));
		stock.add(new Stock(25009, 500));
		stock.add(new Stock(25010, 500));
		
		Session freshMindsSession = Core.articlesSessionFactory.openSession();
		freshMindsSession.beginTransaction();
		
		for(Stock articleStock : stock)  {
			freshMindsSession.saveOrUpdate(articleStock);
		}
		freshMindsSession.getTransaction().commit();
		freshMindsSession.close();
	}
	
	public static void fillCategoriesTable() {
		
		List<Category> categories = new ArrayList<Category>();
		
		categories.add(new Category(1, "Brot"));
		categories.add(new Category(2, "Br�tchen"));		
		categories.add(new Category(3, "Kuchen"));
		categories.add(new Category(4, "S��geb�cke"));
		categories.add(new Category(5, "Rindfleisch"));
		categories.add(new Category(6, "H�hnerfleisch"));
		categories.add(new Category(7, "Schweinefleisch"));
		categories.add(new Category(8, "Putenfleisch"));
		categories.add(new Category(9, "Fisch"));
		categories.add(new Category(10, "Milch"));
		categories.add(new Category(11, "Butter"));
		categories.add(new Category(12, "Margarine"));
		categories.add(new Category(13, "K�se"));
		categories.add(new Category(14, "Jogurt"));
		categories.add(new Category(15, "Obst"));
		categories.add(new Category(16, "Gem�se"));
		categories.add(new Category(17, "Gew�rze"));
		categories.add(new Category(18, "S�fte"));
		categories.add(new Category(19, "Softdrinks"));
		categories.add(new Category(20, "Wasser"));
		categories.add(new Category(21, "Alkoholische Getr�nke"));
		categories.add(new Category(22, "Smoothies"));
		categories.add(new Category(23, "Tiefk�hlgerichte"));
		categories.add(new Category(24, "Cornflakes"));
		categories.add(new Category(25, "Backwaren"));
		categories.add(new Category(26, "Haushalt"));
		categories.add(new Category(27, "Zeitschriften"));
		categories.add(new Category(28, "Snacks"));
		categories.add(new Category(29, "Saucen"));
		categories.add(new Category(30, "Teigwaren"));
		
		Session freshMindsSession = Core.articlesSessionFactory.openSession();
		freshMindsSession.beginTransaction();
		
		for(Category category : categories)  {
			freshMindsSession.saveOrUpdate(category);
		}
		freshMindsSession.getTransaction().commit();
		freshMindsSession.close();
	}

}
