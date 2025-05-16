package com.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Article {
	private String id;
	private String name;
	private boolean isFungible;
	private String value;

	private String[] articleListFull = { "Teclado Inalámbrico", "Ratón Óptico", "Pantalla LED", "Cargador USB-C",
			"Memoria USB 64GB", "Auriculares Bluetooth", "Mochila Antirrobo", "Altavoz Portátil", "Base Refrigerante",
			"Cámara Web HD", "Micrófono de Condensador", "Tablet 10 pulgadas", "Smartwatch Deportivo",
			"Power Bank 10000mAh", "Disco SSD 500GB", "Impresora Multifunción", "Router WiFi 6", "Silla Ergonómica",
			"Mesa de Oficina", "Lámpara LED Escritorio", "Monitor 24 pulgadas", "Portátil i7", "Soporte Monitor",
			"Cinta Antideslizante", "Proyector Mini LED", "Tóner Compatible", "Estación de Carga", "Cable HDMI 2m",
			"Caja Herramientas", "Destornillador Eléctrico", "Detector de Humo", "Cámara Seguridad",
			"Disco Duro Externo", "Repetidor WiFi", "Tarjeta Gráfica", "Memoria RAM 16GB", "Alfombrilla Gaming",
			"Base para Laptop", "Soporte de Tablet", "Cargador Solar Portátil", "Luces LED Decorativas",
			"Termómetro Digital", "Detector CO2", "Timbre Inalámbrico", "Módulo Arduino", "Sensor de Movimiento",
			"Control Remoto Universal", "Cerradura Inteligente", "Kit Herramientas PC", "Antena Digital" };

	public List<Article> getListArticle() {
		List<Article> articleList = new ArrayList<>();
		int articleSize = articleListFull.length;
		Random random = new Random();
		for (int i = 0; i < articleSize; i++) {
			Article article = new Article();
			article.setFungible(random.nextBoolean());
			article.setId("" + i);
			article.setName(articleListFull[i]);
			article.setValue("" + random.nextInt(200));

			articleList.add(article);
		}

		return articleList;
	}

	public String headerString() {
		return "ID, NAME, ISFUNGIBLE, VALUE";
	}

	public String toString() {
		return id + ", " + name + ", " + isFungible + ", " + value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFungible() {
		return isFungible;
	}

	public void setFungible(boolean isFungible) {
		this.isFungible = isFungible;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
