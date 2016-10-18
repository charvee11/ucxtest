
package com.ucx.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ToString
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@Column(nullable = false)
	private String name;

	@Getter
	@Setter
	@Column(nullable = false)
	private double price;

	protected Item() {
	}

	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

}
