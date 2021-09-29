DROP DATABASE IF EXISTS control_academico;
CREATE DATABASE  IF NOT EXISTS control_academico;
USE control_academico;

DROP TABLE IF EXISTS alumno;
CREATE TABLE alumno (
  carne VARCHAR(16) NOT NULL,
  apellidos VARCHAR(45),
  nombres VARCHAR(45),
  email VARCHAR(32),
  PRIMARY KEY (carne)
);

INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2020020','Montes Santos', 'Camila', 'mcamila@kinal.edu.gt');
INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2020105','Gonzalez Perez', 'Fernando Miguel', 'fernandogon@gmail.com');
INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2020108','Solis Martinez', 'Juan Diego', 'jsolis@gmail.com');
INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2020015','Fernandez Calvo', 'Ruben', 'rcalvo@kinal.edu.gt');
INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2020109','Rivas Fernandez', 'Bryan', 'brivas@gmail.com');
INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2021030','Coronado Guzman', 'Oscar Luis', 'oluiscor@gmail.com');
INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2019109','Paiz Hernandez', 'Fernanda Eunice', 'fereupaihe@gmail.com');
INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2020201','Maca Gonzalez', 'Angel Fernando', 'anfer@kinal.edu.gt');
INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2021029','Perez Flores', 'Rosario', 'rosperez@gmail.com');
INSERT INTO alumno (carne,apellidos, nombres, email) VALUES ('2018098','Cabrera Hernandez', 'Martin', 'martincabrera@gmail.com');

DROP TABLE IF EXISTS horario;
CREATE TABLE horario (
  horario_id INT NOT NULL AUTO_INCREMENT,
  horario_final TIME NOT NULL,
  horario_inicio TIME NOT NULL,
  PRIMARY KEY (horario_id)
);

INSERT INTO horario (horario_inicio, horario_final) VALUES ('08:00', '09:00');
INSERT INTO horario (horario_inicio, horario_final) VALUES ('03:00', '16:00');
INSERT INTO horario (horario_inicio, horario_final) VALUES ('06:00', '16:00');
INSERT INTO horario (horario_inicio, horario_final) VALUES ('09:00', '20:00');
INSERT INTO horario (horario_inicio, horario_final) VALUES ('05:00', '13:00');
INSERT INTO horario (horario_inicio, horario_final) VALUES ('06:00', '11:00');
INSERT INTO horario (horario_inicio, horario_final) VALUES ('17:00', '20:00');
INSERT INTO horario (horario_inicio, horario_final) VALUES ('20:00', '22:00');
INSERT INTO horario (horario_inicio, horario_final) VALUES ('14:00', '17:00');
INSERT INTO horario (horario_inicio, horario_final) VALUES ('09:00', '11:00');



DROP TABLE IF EXISTS salon;
CREATE TABLE salon (
  salon_id INT NOT NULL AUTO_INCREMENT,
  capacidad INT,
  descripcion VARCHAR(255),
  nombre_salon VARCHAR(255),
  PRIMARY KEY (salon_id)
);

INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('16', 'Laboratorio para realizar trabajos de computo', 'Computo1');
INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('20', 'Laboratorio para realizar trabajos de Biologia', 'Biologia1');
INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('25', 'Salon multiusos', 'Multiusos1');
INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('21', 'Salon para actividades', 'Actividades1');
INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('30', 'Laboratorio para realizar trabajos de Biologia', 'Biologia2');
INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('25', 'Salon de material audiovisual', 'Audiovisuales1');
INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('34', 'Salon de la clase de hogar', 'Hogar1');
INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('21', 'Salon de Artes Plasticas', 'Artes1');
INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('42', 'Salon para reuniones de padres', 'Padres');
INSERT INTO salon (capacidad, descripcion, nombre_salon) values ('25', 'Salon de maestros', 'Maestros');

DROP TABLE IF EXISTS carrera_tecnica;
CREATE TABLE carrera_tecnica (
  codigo_carrera VARCHAR(128) NOT NULL,
  nombre VARCHAR(45),
  PRIMARY KEY (codigo_carrera)
);

INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('IN', 'Informatica');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('ME', 'Mecanica');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('DI', 'Dibujo');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('SE', 'Secretariado');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('TU', 'Turismo');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('MA', 'Magisterio');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('CO', 'Contabilidad');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('DG', 'Diseño Grafico');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('EE', 'Electricidad');
INSERT INTO carrera_tecnica (codigo_carrera, nombre) values ('EA', 'Electronica');

DROP TABLE IF EXISTS instructor;
CREATE TABLE instructor (
  instructor_id INT NOT NULL AUTO_INCREMENT,
  apellidos VARCHAR(45),
  nombres VARCHAR(45),
  direccion VARCHAR(45),
  telefono VARCHAR(45),
  PRIMARY KEY (instructor_id)
);

INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Perez Canto', 'Jorge', '12 av 8-42 villa nueva', '33445566');
INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Noj Xicay', 'José Francisco', 'Calle 7 9-30 zona 16', '31312345');
INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Mayen Montes', 'Juan Alexander', '13-34 San Cristobal, Mixco', '65523642');
INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Martinez Ajuchan', 'Hermes Gabriel', 'Zona 1 29-84', '44889955');
INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Orozco Ramirez', 'Luis Enrique', 'Colonia el paraiso 8-21 zona 18', '12123256');
INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Cifuentes Orellana', 'Jose Roberto', '12-34 san miguel petapa', '88894565');
INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Simon Guzman', 'Milvia', '11-21 Las victorias', '6565423');
INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Blanco Contreras', 'Carlos Marco', '2-31 colonia El Maestro zona 15', '54689321');
INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Felipez Soto', 'Juan Felipe', '1-23 San Jose Pinula', '45693218');
INSERT INTO instructor(apellidos, nombres, direccion, telefono) values('Pinzon Mora', 'Nicolas', '1-25 Santa Elena Barillas', '73261451');

DROP TABLE IF EXISTS curso;
CREATE TABLE curso(
curso_id INT NOT NULL AUTO_INCREMENT,
ciclo INT,
cupo_maximo INT,
cupo_minimo INT,
descripcion VARCHAR(255),
codigo_carrera VARCHAR(128) NOT NULL,
horario_id INT NOT NULL,
instructor_id INT NOT NULL,
salon_id INT NOT NULL,
PRIMARY KEY (curso_id),
FOREIGN KEY(codigo_carrera) REFERENCES carrera_tecnica(codigo_carrera)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
FOREIGN KEY(horario_id) REFERENCES horario(horario_id)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY(instructor_id) REFERENCES instructor(instructor_id)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY(salon_id) REFERENCES salon(salon_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2021', '30', '20', 'Matematica basica 2', 'IN', '1', '1', '3');
INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2020', '40', '30', 'Programacion de sistemas de motores', 'ME', '2', '2', '2');
INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2019', '12', '5', 'Biologia humana', 'SE', '7', '5', '2');
INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2021', '20', '15', 'Hacking etico', 'IN', '8', '2', '3');
INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2020', '10', '5', 'Sistema electrico automotriz', 'ME', '1', '3', '5');
INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2019', '30', '27', 'Programacion de sistemas de motores', 'ME', '3', '2', '8');
INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2021', '18', '12', 'Mantenimiento de equipos', 'IN', '4', '5', '3');
INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2020', '21', '14', 'Diseño de circuitoS', 'EE', '9', '1', '3');
INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2019', '20', '15', 'Capacitación de parte de Honda', 'ME', '8', '6', '7');
INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) values('2019', '30', '27', 'Genetica basica', 'MA', '1', '2', '5');

CREATE TABLE asignacion_alumno(
asignacion_id VARCHAR(45) NOT NULL,
carne VARCHAR(16) NOT NULL,
curso_id INT NOT NULL,
fecha_asignacion DATETIME,
PRIMARY KEY(asignacion_id),
FOREIGN KEY(carne) REFERENCES alumno(carne)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY(curso_id) REFERENCES curso(curso_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a1','2020020', '9', '2020-08-09 15:00:00');
INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a2','2020105', '2', '2021-01-10 20:00:00');
INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a3','2020108', '2', '2020-03-11 07:00:00');
INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a4','2020015', '4', '2021-02-10 05:00:00');
INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a5','2020109', '8', '2020-08-09 13:00:00');
INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a6','2021030', '1', '2020-02-10 11:00:00');
INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a7','2019109', '7', '2020-09-09 07:00:00');
INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a8','2020201', '3', '2021-05-11 21:00:00');
INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a9','2021029', '5', '2021-08-04 08:00:00');
INSERT INTO asignacion_alumno(asignacion_id, carne, curso_id, fecha_asignacion) values('a10','2018098', '10', '2021-01-10 22:00:00');

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
usuario_id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(45) NOT NULL,
usuario VARCHAR(45) NOT NULL,
clave VARCHAR(45) NOT NULL,
PRIMARY KEY(usuario_id)
);

INSERT INTO usuario(nombre, usuario, clave) values("Jorge", "root", "YWRtaW4=");


DROP TABLE IF EXISTS nota;
CREATE TABLE nota(
id_nota INT NOT NULL AUTO_INCREMENT,
nombre_actividad VARCHAR(45),
nota_actividad INT NOT NULL,
fecha_entrega DATE,
asignacion_id VARCHAR(45),
PRIMARY KEY (id_nota),
FOREIGN KEY(asignacion_id) REFERENCES asignacion_alumno(asignacion_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO nota(nombre_actividad, nota_actividad, fecha_entrega, asignacion_id) VALUES ('Historia del arte', 95, '2021-09-26', 'a9');
INSERT INTO nota(nombre_actividad, nota_actividad, fecha_entrega, asignacion_id) VALUES ('Ejemplos de ejercicio', 100, '2021-09-26', 'a10');
INSERT INTO nota(nombre_actividad, nota_actividad, fecha_entrega, asignacion_id) VALUES ('Calculdaora con java', 80, '2021-09-26', 'a7');
INSERT INTO nota(nombre_actividad, nota_actividad, fecha_entrega, asignacion_id) VALUES ('Proyecto html', 100, '2021-09-26', 'a6');
INSERT INTO nota(nombre_actividad, nota_actividad, fecha_entrega, asignacion_id) VALUES ('Historia de la musica', 90, '2021-09-26', 'a5');
INSERT INTO nota(nombre_actividad, nota_actividad, fecha_entrega, asignacion_id) VALUES ('Proyecto final', 100, '2021-09-26', 'a4');
INSERT INTO nota(nombre_actividad, nota_actividad, fecha_entrega, asignacion_id) VALUES ('Web Biografia', 85, '2021-09-26', 'a3');
INSERT INTO nota(nombre_actividad, nota_actividad, fecha_entrega, asignacion_id) VALUES ('Web Biografia', 60, '2021-09-26', 'a1');

SELECT nota.id_nota, nota.nombre_actividad, nota.nota_actividad, nota.fecha_entrega, nota.asignacion_id, alumno.carne, alumno.nombres, alumno.apellidos, curso.descripcion, asignacion_alumno.fecha_asignacion
FROM nota
INNER JOIN asignacion_alumno ON asignacion_alumno.asignacion_id = nota.asignacion_id
INNER JOIN alumno ON alumno.carne = asignacion_alumno.carne
INNER JOIN curso ON curso.curso_id = asignacion_alumno.curso_id;

SELECT * FROM asignacion_alumno;
SELECT * FROM alumno;
SELECT * FROM curso;
SELECT * FROM nota;


UPDATE nota SET nombre_actividad = 'xxxxxxx', nota_actividad = 20, fecha_entrega = '2021-06-20', asignacion_id = 'a5' WHERE id_nota = 3;