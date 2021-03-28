CREATE TABLE `apolices` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cliente_id` BIGINT(20) NOT NULL,
  `numero_apolice` VARCHAR(100) NOT NULL,
  `inicio_vigencia` VARCHAR(45) NOT NULL,
  `fim_vigencia` VARCHAR(45) NOT NULL,
  `placa_veiculo` VARCHAR(15) NOT NULL,
  `valor_apolice` DECIMAL NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `cliente_id_idx` (`cliente_id` ASC) VISIBLE,
  UNIQUE INDEX `numero_apolice_UNIQUE` (`numero_apolice` ASC) VISIBLE,
  CONSTRAINT `cliente_id`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)