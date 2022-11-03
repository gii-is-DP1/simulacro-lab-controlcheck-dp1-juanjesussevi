package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tipos_de_producto")

public class ProductType {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;
	@Column(name="name",unique = true)
    @NotEmpty
    @Length(min = 3,max=50)
    String name;
}
