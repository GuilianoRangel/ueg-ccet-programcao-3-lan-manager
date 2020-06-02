-- -----------------------------------------------------
-- Table tipo
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS tipo (
  idtipo serial NOT NULL ,
  tipo VARCHAR(50) NOT NULL ,
  PRIMARY KEY (idtipo) );


-- -----------------------------------------------------
-- Table switch
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS switch (
  idswitch serial NOT NULL ,
  nome VARCHAR(100) NOT NULL ,
  localizacao VARCHAR(255) NULL ,
  observacao VARCHAR(8000) NULL ,
  tipo_idtipo INT NOT NULL ,
  PRIMARY KEY (idswitch)  ,
  CONSTRAINT fk_switch_tipo
    FOREIGN KEY (tipo_idtipo )
    REFERENCES tipo (idtipo )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table porta
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS porta (
  idporta serial NOT NULL  ,
  switch_idswitch INT NOT NULL ,
  porta VARCHAR(10) NOT NULL ,
  PRIMARY KEY (idporta) ,
  CONSTRAINT fk_porta_switch1
    FOREIGN KEY (switch_idswitch )
    REFERENCES switch (idswitch )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table vlan
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS vlan (
  vlan varchar(4) NOT NULL ,
  nome VARCHAR(40) NULL ,
  PRIMARY KEY (vlan) );


-- -----------------------------------------------------
-- Table equipamento
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS equipamento (
  idequipamento serial NOT NULL ,
  porta_idporta INT NOT NULL ,
  nome VARCHAR(50) NOT NULL ,
  descricao VARCHAR(500) NULL ,
  observacao VARCHAR(8000) NULL ,
  PRIMARY KEY (idequipamento) ,
  CONSTRAINT fk_equipamento_porta1
    FOREIGN KEY (porta_idporta )
    REFERENCES porta (idporta )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table porta_vlan versão original
-- -----------------------------------------------------
/* CREATE  TABLE IF NOT EXISTS porta_vlan (
  porta_idporta INT NOT NULL ,
  vlan_vlan INT NOT NULL ,
  data_criacao DATE NOT NULL ,
  PRIMARY KEY (porta_idporta, vlan_vlan) ,
  CONSTRAINT fk_porta_has_vlan_porta1
    FOREIGN KEY (porta_idporta )
    REFERENCES porta (idporta )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_porta_has_vlan_vlan1
    FOREIGN KEY (vlan_vlan )
    REFERENCES vlan (vlan )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION); */

	-- Table: porta_vlan

-- DROP TABLE porta_vlan;

CREATE TABLE porta_vlan
(
  idporta_vlan serial NOT NULL,
  porta_idporta integer NOT NULL,
  vlan_vlan varchar(4) NOT NULL,
  --data_criacao date NOT NULL,
  CONSTRAINT porta_vlan_pkey PRIMARY KEY (idporta_vlan),
  CONSTRAINT fk_porta_has_vlan_porta1 FOREIGN KEY (porta_idporta)
      REFERENCES porta (idporta)
      ON UPDATE NO ACTION
	  ON DELETE NO ACTION,
  CONSTRAINT fk_porta_has_vlan_vlan1 FOREIGN KEY (vlan_vlan)
      REFERENCES vlan (vlan)
      ON UPDATE NO ACTION
	  ON DELETE NO ACTION
);

