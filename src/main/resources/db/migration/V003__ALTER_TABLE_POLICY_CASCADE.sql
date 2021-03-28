ALTER TABLE `policies`.`apolices` 
DROP FOREIGN KEY `cliente_id`;
ALTER TABLE `policies`.`apolices` 
ADD CONSTRAINT `cliente_id`
  FOREIGN KEY (`cliente_id`)
  REFERENCES `policies`.`clientes` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;