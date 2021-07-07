package com.java.virtusVer010.model;
import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity(name="Item")
@Data
@Table(name = "itens")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "id_itens_seq", sequenceName = "id_itens_seq")
public class Item {

	@Id
	@Column(name = "id_item")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_itens_seq")
	private Long idItem;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "descricao", nullable = false, length = 4000)
	private String descricao;
	
	@Column(name = "referencia", nullable = false, length = 500)
	private String referencia;
	
	@Column(name = "id_autor")
	private Long idAutor;
	
	@Column(name = "criado_em")
	@Temporal(TemporalType.TIMESTAMP)
	private Date criadoEm;
	
	@Column(name = "id_Status")
	private Long idStatus;
	
}
