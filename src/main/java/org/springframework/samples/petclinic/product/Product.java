package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="productos")
public class Product extends NamedEntity{
	 @NotNull
	    @Min(value = 0)
	    double price;
	    @ManyToOne
	    @JoinColumn(name="tipo_de_producto")
	    ProductType productType;
    
}
