package br.com.bernardo.carrosrest.demo.domain;

import br.com.bernardo.carrosrest.demo.enums.CarroColor;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Entity(name="carro")
public class CarroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String tipo;
	private String descricao;
	private String urlFoto;
	private String urlVideo;
	private String latitude;
	private String longitude;
	private ZonedDateTime date;
	private LocalTime hour_translated;
	private String carOwner;
	@OneToOne()
	private AddressEntity addressEntity;

	@Column(name = "cor")
	@Enumerated(EnumType.STRING)
	private CarroColor carroColor;


	public CarroEntity(){
	}

	public CarroEntity(Long id, String nome, String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		setDate();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getUrlVideo() {
		return urlVideo;
	}
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public CarroColor getCarroColor() {	return carroColor; }
	public void setCarroColor(String color) {
		this.carroColor = CarroColor.getCarroColorFromString(color);
	}

	public ZonedDateTime getDate() { return date; }
	public void setDate() {
		this.date = ZonedDateTime.now();
		this.hour_translated = this.date.toLocalTime();
	}

	public LocalTime getHour_translated() { return hour_translated; }
	//TODO: Eu gostaria que não fosse possível setar o hour_translated, porém, tenho dúvidas se o Spring irá barrar se eu deletar o setter.
	//TODO
	public void setHour_translated(LocalTime hour_translated) { this.hour_translated = hour_translated;	}

	public String getCarOwner() { return carOwner; }
	public void setCarOwner(String carOwner) { this.carOwner = carOwner; }
}
