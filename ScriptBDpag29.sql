create database bd_hibernate1;
use bd_hibernate1;

create table mascotas(
	id_mascota int primary key not null auto_increment,
    nombre varchar(45) not null,
    raza varchar(45) default null,
    color varchar(45) default null,
    sexo varchar(45) default null
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

CREATE TABLE persona(
id_persona int(11) NOT NULL,
nombre_persona varchar(45) DEFAULT NULL,
profesion_persona varchar(45) DEFAULT NULL,
telefono_persona varchar(45) DEFAULT NULL,
tipo_persona int(2) NOT NULL,
nacimiento_id int(11) NOT NULL,
PRIMARY KEY (id_persona)
);
CREATE TABLE nacimiento(
id_nacimiento int(11) NOT NULL AUTO_INCREMENT ,
ciudad_nacimiento varchar(45) DEFAULT NULL,
departamento_nacimiento varchar(45) DEFAULT NULL,
fecha_nacimiento date DEFAULT NULL,
pais_nacimiento varchar(45) DEFAULT NULL,
PRIMARY KEY (id_nacimiento)
);
CREATE TABLE `bd_hibernate1`. `productos` (
`id_producto` int(11) NOT NULL AUTO_INCREMENT,
`nombre_producto` varchar(45) NOT NULL,
`precio_producto` double DEFAULT NULL,
PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `bd_hibernate1`. `personas_productos` (
`persona_id` int (11) NOT NULL,
`producto_id`int(11) NOT NULL,
KEY `FK_producto` (`producto_id`),
KEY `FK_persona` (`persona_id`),
CONSTRAINT `FK_producto` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id_producto`),
CONSTRAINT `FK_persona` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id_persona`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
 
ALTER TABLE persona
ADD INDEX fk_persona_nacimiento (nacimiento_id ASC);
;
ALTER TABLE persona
ADD CONSTRAINT fk_persona_nacimiento
		FOREIGN KEY (nacimiento_id)
        REFERENCES nacimiento (id_nacimiento)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;
        
ALTER TABLE `bd_hibernate1`.`mascotas`
ADD COLUMN `persona_id` INT(11) NULL AFTER `sexo`;

ALTER TABLE `bd_hibernate1`.`mascotas`
ADD INDEX `fk_mascotas_persona_idx` (`persona_id` ASC);
;
ALTER TABLE `bd_hibernate1`.`mascotas`
ADD CONSTRAINT `fk_mascotas_persona`
  FOREIGN KEY (`persona_id`)
  REFERENCES `bd_hibernate1`.`persona` (`id_persona`)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION;