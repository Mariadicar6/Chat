
CREATE DATABASE Chat
-----------------------------------------------------------------


USE Chat
-----------------------------------------------------------------


CREATE TABLE Usuario(
Codigo_U			INT IDENTITY(1,1)	NOT NULL,
Nombre_U			VARCHAR(100)		NOT NULL,
Contraseña_U		VARCHAR(200)		NOT NULL,
Ip_U						VARCHAR(17)			NOT NULL,
Imagen_U			VARBINARY(MAX)	NULL,
Nick_U					VARCHAR(100)		NOT NULL,
MsjPersonal_U		VARCHAR(200)		NULL
)
ALTER TABLE Usuario
	ADD CONSTRAINT PK_Usuario
	PRIMARY KEY(Codigo_U)
-----------------------------------------------------------------


CREATE TABLE Contacto(
Codigo			INT IDENTITY(1,1)	NOT NULL,
Nombre			VARCHAR(100)		NOT NULL,
Ip						VARCHAR(17)			NOT NULL,
Imagen			VARBINARY(MAX)	NULL,
C_Id					INT							NOT NULL, 
Nick					VARCHAR(100)		NOT NULL,
MsjPersonal		VARCHAR(200)		NULL
)
ALTER TABLE Contacto
	ADD CONSTRAINT PK_Contacto
	PRIMARY KEY(Codigo)
ALTER TABLE Contacto
	ADD CONSTRAINT FK_Usuario
	FOREIGN KEY(C_Id)
	REFERENCES Usuario(Codigo_U)
-----------------------------------------------------------------


INSERT INTO dbo.Usuario
VALUES ('Patricia','1234' ,'127.0.0.1', NULL,'Paty','');
INSERT INTO dbo.Usuario
VALUES ('Rosario','abcd' ,'127.0.0.1', NULL,'Rosita06','');
INSERT INTO dbo.Usuario
VALUES ('Julia','asdf' ,'127.0.0.1', NULL,'JuliaRC','');
-----------------------------------------------------------------


INSERT INTO dbo.Contacto
VALUES ('Patricia','127.0.0.1', NULL,1,'Paty','');
INSERT INTO dbo.Contacto
VALUES ('Rosario','127.0.0.1', NULL,1,'Rosita06','');
INSERT INTO dbo.Contacto
VALUES ('Julia','127.0.0.1', NULL,1,'JuliaRC','');
-----------------------------------------------------------------


-- Actualizar imagen en la BD
UPDATE Usuario 
	SET Imagen_U = (	SELECT BulkColumn 
									FROM OPENROWSET(BULK 'Ruta de imagen', 
									SINGLE_BLOB) Imagen)
	WHERE Codigo_U = 2
-----------------------------------------------------------------


/* P. A. para saber si el usuario tiene imagen o no
	Parametro de entrada: Código
*/
CREATE PROCEDURE usp_fotoExiste
@Codigo INT
AS
	DECLARE @Rpta INT
	
	IF (SELECT Imagen_U FROM Usuario 
					WHERE Codigo_U = @Codigo) IS NOT NULL
		BEGIN
			SET @Rpta = 1
			SELECT @Rpta
		END
	
	ELSE
		BEGIN
			SET @Rpta = 0
			SELECT @Rpta
		END
GO
-----------------------------------------------------------------
EXECUTE usp_fotoExiste 1		-- Debe salir 1 como Rpta
-----------------------------------------------------------------


/* Procedimiento almacenado que busca si existe usuario y agrega contacto
	Parámetro de entrada: Nombre
	Parámetros de salida: Nombre, Imagen, Ip, Nick y Msj Personal
*/	
CREATE PROCEDURE usp_BuscarUsuario
@Nombre_U		VARCHAR(100),
@Nombre			VARCHAR(100)		OUTPUT,
@Imagen			VARBINARY(MAX)	OUTPUT,
--@C_Id					INT							OUTPUT,
@Ip						VARCHAR(17)			OUTPUT,
@Nick					VARCHAR(100)		OUTPUT,
@MsjPersonal		VARCHAR(200)		OUTPUT	
AS

	DECLARE @Rpta		INT
	DECLARE @C_Id		INT
	IF EXISTS(SELECT 1 FROM Usuario WHERE Nombre_U = @Nombre_U)
		BEGIN
			SET @Rpta = 1
			SELECT @Rpta AS 'Respuesta'
			
			-- Asignamos valores
			SELECT	@Nombre = Nombre_U,
							@Ip = Ip_U,
							@Imagen = Imagen_U,
							@C_Id = Codigo_U,
							@Nick = Nick_U,
							@MsjPersonal = MsjPersonal_U
			FROM Usuario 
			WHERE Nombre_U = @Nombre_U 
			
			-- Insertamos datos
			INSERT INTO Contacto(Nombre, Ip, Imagen, C_Id, Nick, MsjPersonal)
			VALUES(@Nombre, @Ip, @Imagen, @C_Id, @Nick, @MsjPersonal)
		END
		
	ELSE
		BEGIN
			SET @Rpta = 0 
			SELECT @Rpta AS 'Respuesta'
		END
		
GO
-----------------------------------------------------------------
-- Debe salir Resultado = 1, mostrar datos de contacto y agregar en la BD
DECLARE @Nombre			VARCHAR(100)	
DECLARE @Imagen			VARBINARY(MAX) 
DECLARE @Ip						VARCHAR(17)		
DECLARE @Nick					VARCHAR(100)	
DECLARE @MsjPersonal		VARCHAR(200)	
EXECUTE usp_BuscarUsuario 'Julia',	@Nombre		OUTPUT, 
																@Imagen		OUTPUT, 
																@Ip					OUTPUT, 
																@Nick				OUTPUT, 
																@MsjPersonal	OUTPUT
SELECT	@Nombre AS 'Nombre',  
				CONVERT(VARCHAR(100), @Imagen) AS 'Imagen',
				@Ip AS 'IP',
				@Nick AS 'Nick',
				@MsjPersonal AS 'Msj Personal'	
-----------------------------------------------------------------


-- Comprobar que se agregó contacto
SELECT Codigo, Nombre, Ip, Imagen, C_Id, Nick, MsjPersonal
FROM Contacto C JOIN Usuario U
ON C.C_Id = U.Codigo_U
WHERE Nombre_U = 'Julia'